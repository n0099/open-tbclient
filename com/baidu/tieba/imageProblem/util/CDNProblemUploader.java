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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader jKU;
    private static Object lockObject = new Object();
    private p eAz;
    private int jKO;
    private int jKP;
    private int jKQ;
    private int jKR;
    private Handler mHandler;
    private final int jKB = 5;
    private final int jKC = 0;
    private final int jKD = 1;
    private final int jKE = 2;
    private final int jKF = 3;
    private final byte jKG = 0;
    private final byte jKH = 1;
    private int jKI = 0;
    private final int jKJ = 5;
    private boolean jKK = false;
    private long NA = 0;
    private final long jKL = 86400000;
    private final float jKM = 100.0f;
    private float jKN = 0.0f;
    private BdAsyncTaskParallel jKS = null;
    private final CdnErrorJsonData jKT = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.jKI + 1;
        cDNProblemUploader.jKI = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (jKU == null) {
            synchronized (CDNProblemUploader.class) {
                if (jKU == null) {
                    jKU = new CDNProblemUploader();
                }
            }
        }
        return jKU;
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

    @Override // com.baidu.tbadk.core.util.r
    public p getmCdnLogData() {
        return this.eAz;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eAz = pVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.jKN += 25.0f;
            } else {
                this.jKN += getmCdnLogData().getErrRank();
            }
            this.jKQ++;
            this.jKP++;
            this.jKT.add(i);
            int i3 = this.jKQ;
            int i4 = this.jKP;
            int i5 = this.jKO;
            int i6 = this.jKO != 0 ? this.jKR / this.jKO : 0;
            String cdnErrorJsonData = this.jKT.toString();
            if (getmCdnLogData() != null && this.NA > 0 && System.currentTimeMillis() - this.NA > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.jKI = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.jKQ < 5) {
                    i2 = 0;
                } else if (this.jKN < 100.0f || this.jKP < getmCdnLogData().getErrNumber() || this.jKO < getmCdnLogData().getSlowNumber()) {
                    if (this.jKN >= 100.0f && this.jKP >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.jKN < 100.0f || this.jKO < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (lockObject) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.jKN += 10.0f;
                } else {
                    this.jKN += getmCdnLogData().getSlowRank();
                }
                this.jKO++;
                this.jKR = (int) (this.jKR + j);
                this.jKQ++;
                int i4 = this.jKQ;
                int i5 = this.jKP;
                int i6 = this.jKO;
                if (this.jKO != 0) {
                    i = this.jKR / this.jKO;
                }
                String cdnErrorJsonData = this.jKT.toString();
                if (getmCdnLogData() != null && this.NA > 0 && System.currentTimeMillis() - this.NA > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.jKI = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.jKQ >= 5) {
                        if (this.jKN >= 100.0f && this.jKP >= getmCdnLogData().getErrNumber() && this.jKO >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.jKN >= 100.0f && this.jKP >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.jKN >= 100.0f && this.jKO >= getmCdnLogData().getSlowNumber()) {
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
                this.jKN -= 25.0f;
            } else {
                this.jKN -= getmCdnLogData().getSuccRank();
            }
            if (this.jKN < 0.0f) {
                this.jKN = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.jKK) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.jKS == null) {
            this.jKS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.jKS);
        cDNUpLoadTask.execute(new Object[0]);
        this.jKK = true;
        a mN = u.mN();
        mN.append("act", "fallback");
        mN.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jKQ = 0;
        this.jKO = 0;
        this.jKP = 0;
        this.jKR = 0;
        this.jKN = 0.0f;
        this.jKT.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String bnD;
        private final int jKO;
        private final int jKP;
        private final int jKQ;
        private final String jKW;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.jKP = i3;
            this.jKO = i4;
            this.bnD = str;
            this.jKW = str2;
            this.mType = i;
            this.jKQ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bEb.addPostData("number", String.valueOf(this.jKQ));
            if (this.mType == 1) {
                this.bEb.addPostData("ab_num_error", String.valueOf(this.jKP));
                this.bEb.addPostData(BdStatsConstant.StatsType.ERROR, this.bnD);
                this.bEb.addPostData("ab_num_slow", String.valueOf(this.jKO));
                this.bEb.addPostData("time", this.jKW);
            } else if (this.mType == 3) {
                this.bEb.addPostData("ab_num_slow", this.jKO + "");
                this.bEb.addPostData("time", this.jKW);
            } else if (this.mType == 2) {
                this.bEb.addPostData("ab_num_error", this.jKP + "");
                this.bEb.addPostData(BdStatsConstant.StatsType.ERROR, this.bnD);
            }
            String postNetData = this.bEb.postNetData();
            if (!this.bEb.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: dM */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a mN = u.mN();
                    mN.append("act", "fallback");
                    mN.append("result", "1");
                    mN.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", mN);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.eAz.setmSwitch(false);
                    CDNProblemUploader.this.NA = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a mN2 = u.mN();
                        mN2.append("act", "fallback");
                        mN2.append("result", "2");
                        mN2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mN2);
                    } else {
                        a mN3 = u.mN();
                        mN3.append("act", "fallback");
                        mN3.append("result", "0");
                        mN3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mN3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.eAz.setmSwitch(false);
                        CDNProblemUploader.this.NA = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    p pVar = new p();
                    pVar.parseJson(optString);
                    if (pVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && pVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && pVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && pVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(pVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.jKK = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer jKX;

        private CdnErrorJsonData() {
            this.jKX = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.jKX.length() != 0) {
                this.jKX.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.jKX.append(i);
        }

        public void clear() {
            this.jKX.setLength(0);
        }

        public String toString() {
            return this.jKX.toString();
        }
    }
}
