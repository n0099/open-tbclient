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
    private static volatile CDNProblemUploader jKO;
    private static Object lockObject = new Object();
    private p eAv;
    private int jKI;
    private int jKJ;
    private int jKK;
    private int jKL;
    private Handler mHandler;
    private final int jKv = 5;
    private final int jKw = 0;
    private final int jKx = 1;
    private final int jKy = 2;
    private final int jKz = 3;
    private final byte jKA = 0;
    private final byte jKB = 1;
    private int jKC = 0;
    private final int jKD = 5;
    private boolean jKE = false;
    private long NA = 0;
    private final long jKF = 86400000;
    private final float jKG = 100.0f;
    private float jKH = 0.0f;
    private BdAsyncTaskParallel jKM = null;
    private final CdnErrorJsonData jKN = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.jKC + 1;
        cDNProblemUploader.jKC = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (jKO == null) {
            synchronized (CDNProblemUploader.class) {
                if (jKO == null) {
                    jKO = new CDNProblemUploader();
                }
            }
        }
        return jKO;
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
        return this.eAv;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eAv = pVar;
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
                this.jKH += 25.0f;
            } else {
                this.jKH += getmCdnLogData().getErrRank();
            }
            this.jKK++;
            this.jKJ++;
            this.jKN.add(i);
            int i3 = this.jKK;
            int i4 = this.jKJ;
            int i5 = this.jKI;
            int i6 = this.jKI != 0 ? this.jKL / this.jKI : 0;
            String cdnErrorJsonData = this.jKN.toString();
            if (getmCdnLogData() != null && this.NA > 0 && System.currentTimeMillis() - this.NA > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.jKC = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.jKK < 5) {
                    i2 = 0;
                } else if (this.jKH < 100.0f || this.jKJ < getmCdnLogData().getErrNumber() || this.jKI < getmCdnLogData().getSlowNumber()) {
                    if (this.jKH >= 100.0f && this.jKJ >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.jKH < 100.0f || this.jKI < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.jKH += 10.0f;
                } else {
                    this.jKH += getmCdnLogData().getSlowRank();
                }
                this.jKI++;
                this.jKL = (int) (this.jKL + j);
                this.jKK++;
                int i4 = this.jKK;
                int i5 = this.jKJ;
                int i6 = this.jKI;
                if (this.jKI != 0) {
                    i = this.jKL / this.jKI;
                }
                String cdnErrorJsonData = this.jKN.toString();
                if (getmCdnLogData() != null && this.NA > 0 && System.currentTimeMillis() - this.NA > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.jKC = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.jKK >= 5) {
                        if (this.jKH >= 100.0f && this.jKJ >= getmCdnLogData().getErrNumber() && this.jKI >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.jKH >= 100.0f && this.jKJ >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.jKH >= 100.0f && this.jKI >= getmCdnLogData().getSlowNumber()) {
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
                this.jKH -= 25.0f;
            } else {
                this.jKH -= getmCdnLogData().getSuccRank();
            }
            if (this.jKH < 0.0f) {
                this.jKH = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.jKE) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.jKM == null) {
            this.jKM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.jKM);
        cDNUpLoadTask.execute(new Object[0]);
        this.jKE = true;
        a mN = u.mN();
        mN.append("act", "fallback");
        mN.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jKK = 0;
        this.jKI = 0;
        this.jKJ = 0;
        this.jKL = 0;
        this.jKH = 0.0f;
        this.jKN.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String bnA;
        private final int jKI;
        private final int jKJ;
        private final int jKK;
        private final String jKQ;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.jKJ = i3;
            this.jKI = i4;
            this.bnA = str;
            this.jKQ = str2;
            this.mType = i;
            this.jKK = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bDY.addPostData("number", String.valueOf(this.jKK));
            if (this.mType == 1) {
                this.bDY.addPostData("ab_num_error", String.valueOf(this.jKJ));
                this.bDY.addPostData(BdStatsConstant.StatsType.ERROR, this.bnA);
                this.bDY.addPostData("ab_num_slow", String.valueOf(this.jKI));
                this.bDY.addPostData("time", this.jKQ);
            } else if (this.mType == 3) {
                this.bDY.addPostData("ab_num_slow", this.jKI + "");
                this.bDY.addPostData("time", this.jKQ);
            } else if (this.mType == 2) {
                this.bDY.addPostData("ab_num_error", this.jKJ + "");
                this.bDY.addPostData(BdStatsConstant.StatsType.ERROR, this.bnA);
            }
            String postNetData = this.bDY.postNetData();
            if (!this.bDY.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.eAv.setmSwitch(false);
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
                        CDNProblemUploader.this.eAv.setmSwitch(false);
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
                CDNProblemUploader.this.jKE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer jKR;

        private CdnErrorJsonData() {
            this.jKR = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.jKR.length() != 0) {
                this.jKR.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.jKR.append(i);
        }

        public void clear() {
            this.jKR.setLength(0);
        }

        public String toString() {
            return this.jKR.toString();
        }
    }
}
