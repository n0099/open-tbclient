package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object dRb = new Object();
    private static volatile CDNProblemUploader dRc;
    private l arI;
    private int dQW;
    private int dQX;
    private int dQY;
    private int mErrorNum;
    private Handler mHandler;
    private final int dQJ = 5;
    private final int dQK = 0;
    private final int dQL = 1;
    private final int dQM = 2;
    private final int dQN = 3;
    private final byte dQO = 0;
    private final byte dQP = 1;
    private int dQQ = 0;
    private final int dQR = 5;
    private boolean dQS = false;
    private long wK = 0;
    private final long dQT = 86400000;
    private final float dQU = 100.0f;
    private float dQV = 0.0f;
    private BdAsyncTaskParallel dQZ = null;
    private final CdnErrorJsonData dRa = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dQQ + 1;
        cDNProblemUploader.dQQ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dRc == null) {
            synchronized (CDNProblemUploader.class) {
                if (dRc == null) {
                    dRc = new CDNProblemUploader();
                }
            }
        }
        return dRc;
    }

    private CDNProblemUploader() {
        this.mHandler = null;
        this.mHandler = new Handler() { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        CDNProblemUploader.this._insertNormalData(message.arg1, (String) message.obj);
                        return;
                    case 1:
                        CDNProblemUploader.this._insertErrorData(message.arg1, (String) message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.tbadk.core.util.p
    public l getmCdnLogData() {
        return this.arI;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (dRb) {
            this.arI = lVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.p
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (dRb) {
            if (getmCdnLogData() == null) {
                this.dQV += 25.0f;
            } else {
                this.dQV += getmCdnLogData().getErrRank();
            }
            this.dQX++;
            this.mErrorNum++;
            this.dRa.add(i);
            int i3 = this.dQX;
            int i4 = this.mErrorNum;
            int i5 = this.dQW;
            int i6 = this.dQW != 0 ? this.dQY / this.dQW : 0;
            String cdnErrorJsonData = this.dRa.toString();
            if (getmCdnLogData() != null && this.wK > 0 && System.currentTimeMillis() - this.wK > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dQQ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dQX < 5) {
                    i2 = 0;
                } else if (this.dQV < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dQW < getmCdnLogData().getSlowNumber()) {
                    if (this.dQV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dQV < 100.0f || this.dQW < getmCdnLogData().getSlowNumber()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, cdnErrorJsonData, i5, i6);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = 5000;
        if (getmCdnLogData() != null) {
            i3 = getmCdnLogData().getTime();
        }
        synchronized (dRb) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dQV += 10.0f;
                } else {
                    this.dQV += getmCdnLogData().getSlowRank();
                }
                this.dQW++;
                this.dQY = (int) (this.dQY + j);
                this.dQX++;
                int i4 = this.dQX;
                int i5 = this.mErrorNum;
                int i6 = this.dQW;
                if (this.dQW != 0) {
                    i = this.dQY / this.dQW;
                }
                String cdnErrorJsonData = this.dRa.toString();
                if (getmCdnLogData() != null && this.wK > 0 && System.currentTimeMillis() - this.wK > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dQQ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dQX >= 5) {
                        if (this.dQV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dQW >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dQV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dQV >= 100.0f && this.dQW >= getmCdnLogData().getSlowNumber()) {
                            i2 = 3;
                        } else {
                            i2 = 0;
                        }
                    }
                    a(i2, i4, i5, cdnErrorJsonData, i6, i);
                    return;
                }
                return;
            }
            if (getmCdnLogData() == null) {
                this.dQV -= 25.0f;
            } else {
                this.dQV -= getmCdnLogData().getSuccRank();
            }
            if (this.dQV < 0.0f) {
                this.dQV = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dQS) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dQZ == null) {
            this.dQZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dQZ);
        cDNUpLoadTask.execute(new Object[0]);
        this.dQS = true;
        a fL = s.fL();
        fL.p("act", "fallback");
        fL.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dQX = 0;
        this.dQW = 0;
        this.mErrorNum = 0;
        this.dQY = 0;
        this.dQV = 0.0f;
        this.dRa.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aee;
        private final int dQW;
        private final int dQX;
        private final String dRe;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dQW = i4;
            this.aee = str;
            this.dRe = str2;
            this.mType = i;
            this.dQX = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dQX));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aee);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dQW));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dRe);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dQW + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dRe);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aee);
            }
            String uM = this.mNetWork.uM();
            if (!this.mNetWork.vm() || TextUtils.isEmpty(uM)) {
                return null;
            }
            try {
                return new JSONObject(uM);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fL = s.fL();
                    fL.p("act", "fallback");
                    fL.p("result", "1");
                    fL.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fL);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.arI.setmSwitch(false);
                    CDNProblemUploader.this.wK = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fL2 = s.fL();
                        fL2.p("act", "fallback");
                        fL2.p("result", "2");
                        fL2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fL2);
                    } else {
                        a fL3 = s.fL();
                        fL3.p("act", "fallback");
                        fL3.p("result", "0");
                        fL3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fL3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.arI.setmSwitch(false);
                        CDNProblemUploader.this.wK = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    l lVar = new l();
                    lVar.parseJson(optString);
                    if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(lVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dQS = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dRf;

        private CdnErrorJsonData() {
            this.dRf = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dRf.length() != 0) {
                this.dRf.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dRf.append(i);
        }

        public void clear() {
            this.dRf.setLength(0);
        }

        public String toString() {
            return this.dRf.toString();
        }
    }
}
