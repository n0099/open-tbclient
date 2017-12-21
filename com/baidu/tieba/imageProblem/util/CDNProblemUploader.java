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
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object edK = new Object();
    private static volatile CDNProblemUploader edL;
    private k arB;
    private int edF;
    private int edG;
    private int edH;
    private int mErrorNum;
    private Handler mHandler;
    private final int eds = 5;
    private final int edt = 0;
    private final int edu = 1;
    private final int edv = 2;
    private final int edw = 3;
    private final byte edx = 0;
    private final byte edy = 1;
    private int edz = 0;
    private final int edA = 5;
    private boolean edB = false;
    private long wL = 0;
    private final long edC = 86400000;
    private final float edD = 100.0f;
    private float edE = 0.0f;
    private BdAsyncTaskParallel edI = null;
    private final CdnErrorJsonData edJ = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.edz + 1;
        cDNProblemUploader.edz = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (edL == null) {
            synchronized (CDNProblemUploader.class) {
                if (edL == null) {
                    edL = new CDNProblemUploader();
                }
            }
        }
        return edL;
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
    public k getmCdnLogData() {
        return this.arB;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (edK) {
            this.arB = kVar;
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
        synchronized (edK) {
            if (getmCdnLogData() == null) {
                this.edE += 25.0f;
            } else {
                this.edE += getmCdnLogData().getErrRank();
            }
            this.edG++;
            this.mErrorNum++;
            this.edJ.add(i);
            int i3 = this.edG;
            int i4 = this.mErrorNum;
            int i5 = this.edF;
            int i6 = this.edF != 0 ? this.edH / this.edF : 0;
            String cdnErrorJsonData = this.edJ.toString();
            if (getmCdnLogData() != null && this.wL > 0 && System.currentTimeMillis() - this.wL > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.edz = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.edG < 5) {
                    i2 = 0;
                } else if (this.edE < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.edF < getmCdnLogData().getSlowNumber()) {
                    if (this.edE >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.edE < 100.0f || this.edF < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (edK) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.edE += 10.0f;
                } else {
                    this.edE += getmCdnLogData().getSlowRank();
                }
                this.edF++;
                this.edH = (int) (this.edH + j);
                this.edG++;
                int i4 = this.edG;
                int i5 = this.mErrorNum;
                int i6 = this.edF;
                if (this.edF != 0) {
                    i = this.edH / this.edF;
                }
                String cdnErrorJsonData = this.edJ.toString();
                if (getmCdnLogData() != null && this.wL > 0 && System.currentTimeMillis() - this.wL > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.edz = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.edG >= 5) {
                        if (this.edE >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.edF >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.edE >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.edE >= 100.0f && this.edF >= getmCdnLogData().getSlowNumber()) {
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
                this.edE -= 25.0f;
            } else {
                this.edE -= getmCdnLogData().getSuccRank();
            }
            if (this.edE < 0.0f) {
                this.edE = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.edB) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.edI == null) {
            this.edI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.edI);
        cDNUpLoadTask.execute(new Object[0]);
        this.edB = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.edG = 0;
        this.edF = 0;
        this.mErrorNum = 0;
        this.edH = 0;
        this.edE = 0.0f;
        this.edJ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aef;
        private final int edF;
        private final int edG;
        private final String edN;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.edF = i4;
            this.aef = str;
            this.edN = str2;
            this.mType = i;
            this.edG = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.edG));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aef);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.edF));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.edN);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.edF + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.edN);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aef);
            }
            String up = this.mNetWork.up();
            if (!this.mNetWork.uQ() || TextUtils.isEmpty(up)) {
                return null;
            }
            try {
                return new JSONObject(up);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
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
                    CDNProblemUploader.this.arB.setmSwitch(false);
                    CDNProblemUploader.this.wL = System.currentTimeMillis();
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
                        CDNProblemUploader.this.arB.setmSwitch(false);
                        CDNProblemUploader.this.wL = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    k kVar = new k();
                    kVar.parseJson(optString);
                    if (kVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && kVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && kVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && kVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(kVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.edB = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer edO;

        private CdnErrorJsonData() {
            this.edO = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.edO.length() != 0) {
                this.edO.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.edO.append(i);
        }

        public void clear() {
            this.edO.setLength(0);
        }

        public String toString() {
            return this.edO.toString();
        }
    }
}
