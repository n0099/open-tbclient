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
    private static Object dMU = new Object();
    private static volatile CDNProblemUploader dMV;
    private l aqE;
    private int dMP;
    private int dMQ;
    private int dMR;
    private int mErrorNum;
    private Handler mHandler;
    private final int dMC = 5;
    private final int dMD = 0;
    private final int dME = 1;
    private final int dMF = 2;
    private final int dMG = 3;
    private final byte dMH = 0;
    private final byte dMI = 1;
    private int dMJ = 0;
    private final int dMK = 5;
    private boolean dML = false;
    private long wN = 0;
    private final long dMM = 86400000;
    private final float dMN = 100.0f;
    private float dMO = 0.0f;
    private BdAsyncTaskParallel dMS = null;
    private final CdnErrorJsonData dMT = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dMJ + 1;
        cDNProblemUploader.dMJ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dMV == null) {
            synchronized (CDNProblemUploader.class) {
                if (dMV == null) {
                    dMV = new CDNProblemUploader();
                }
            }
        }
        return dMV;
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
        return this.aqE;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (dMU) {
            this.aqE = lVar;
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
        synchronized (dMU) {
            if (getmCdnLogData() == null) {
                this.dMO += 25.0f;
            } else {
                this.dMO += getmCdnLogData().getErrRank();
            }
            this.dMQ++;
            this.mErrorNum++;
            this.dMT.add(i);
            int i3 = this.dMQ;
            int i4 = this.mErrorNum;
            int i5 = this.dMP;
            int i6 = this.dMP != 0 ? this.dMR / this.dMP : 0;
            String cdnErrorJsonData = this.dMT.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dMJ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dMQ < 5) {
                    i2 = 0;
                } else if (this.dMO < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dMP < getmCdnLogData().getSlowNumber()) {
                    if (this.dMO >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dMO < 100.0f || this.dMP < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dMU) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dMO += 10.0f;
                } else {
                    this.dMO += getmCdnLogData().getSlowRank();
                }
                this.dMP++;
                this.dMR = (int) (this.dMR + j);
                this.dMQ++;
                int i4 = this.dMQ;
                int i5 = this.mErrorNum;
                int i6 = this.dMP;
                if (this.dMP != 0) {
                    i = this.dMR / this.dMP;
                }
                String cdnErrorJsonData = this.dMT.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dMJ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dMQ >= 5) {
                        if (this.dMO >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dMP >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dMO >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dMO >= 100.0f && this.dMP >= getmCdnLogData().getSlowNumber()) {
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
                this.dMO -= 25.0f;
            } else {
                this.dMO -= getmCdnLogData().getSuccRank();
            }
            if (this.dMO < 0.0f) {
                this.dMO = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dML) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dMS == null) {
            this.dMS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dMS);
        cDNUpLoadTask.execute(new Object[0]);
        this.dML = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dMQ = 0;
        this.dMP = 0;
        this.mErrorNum = 0;
        this.dMR = 0;
        this.dMO = 0.0f;
        this.dMT.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String adp;
        private final int dMP;
        private final int dMQ;
        private final String dMX;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dMP = i4;
            this.adp = str;
            this.dMX = str2;
            this.mType = i;
            this.dMQ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dMQ));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.adp);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dMP));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dMX);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dMP + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dMX);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.adp);
            }
            String ui = this.mNetWork.ui();
            if (!this.mNetWork.uJ() || TextUtils.isEmpty(ui)) {
                return null;
            }
            try {
                return new JSONObject(ui);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fK = s.fK();
                    fK.p("act", "fallback");
                    fK.p("result", "1");
                    fK.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fK);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aqE.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fK2 = s.fK();
                        fK2.p("act", "fallback");
                        fK2.p("result", "2");
                        fK2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK2);
                    } else {
                        a fK3 = s.fK();
                        fK3.p("act", "fallback");
                        fK3.p("result", "0");
                        fK3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aqE.setmSwitch(false);
                        CDNProblemUploader.this.wN = System.currentTimeMillis();
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
                CDNProblemUploader.this.dML = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dMY;

        private CdnErrorJsonData() {
            this.dMY = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dMY.length() != 0) {
                this.dMY.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dMY.append(i);
        }

        public void clear() {
            this.dMY.setLength(0);
        }

        public String toString() {
            return this.dMY.toString();
        }
    }
}
