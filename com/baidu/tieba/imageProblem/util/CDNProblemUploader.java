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
    private static volatile CDNProblemUploader kAO;
    private static Object lockObject = new Object();
    private p fcX;
    private int kAI;
    private int kAJ;
    private int kAK;
    private int kAL;
    private Handler mHandler;
    private final int kAv = 5;
    private final int kAw = 0;
    private final int kAx = 1;
    private final int kAy = 2;
    private final int kAz = 3;
    private final byte kAA = 0;
    private final byte kAB = 1;
    private int kAC = 0;
    private final int kAD = 5;
    private boolean kAE = false;
    private long Om = 0;
    private final long kAF = 86400000;
    private final float kAG = 100.0f;
    private float kAH = 0.0f;
    private BdAsyncTaskParallel kAM = null;
    private final CdnErrorJsonData kAN = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kAC + 1;
        cDNProblemUploader.kAC = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kAO == null) {
            synchronized (CDNProblemUploader.class) {
                if (kAO == null) {
                    kAO = new CDNProblemUploader();
                }
            }
        }
        return kAO;
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
        return this.fcX;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.fcX = pVar;
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
                this.kAH += 25.0f;
            } else {
                this.kAH += getmCdnLogData().getErrRank();
            }
            this.kAK++;
            this.kAJ++;
            this.kAN.add(i);
            int i3 = this.kAK;
            int i4 = this.kAJ;
            int i5 = this.kAI;
            int i6 = this.kAI != 0 ? this.kAL / this.kAI : 0;
            String cdnErrorJsonData = this.kAN.toString();
            if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kAC = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kAK < 5) {
                    i2 = 0;
                } else if (this.kAH < 100.0f || this.kAJ < getmCdnLogData().getErrNumber() || this.kAI < getmCdnLogData().getSlowNumber()) {
                    if (this.kAH >= 100.0f && this.kAJ >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kAH < 100.0f || this.kAI < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kAH += 10.0f;
                } else {
                    this.kAH += getmCdnLogData().getSlowRank();
                }
                this.kAI++;
                this.kAL = (int) (this.kAL + j);
                this.kAK++;
                int i4 = this.kAK;
                int i5 = this.kAJ;
                int i6 = this.kAI;
                if (this.kAI != 0) {
                    i = this.kAL / this.kAI;
                }
                String cdnErrorJsonData = this.kAN.toString();
                if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kAC = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kAK >= 5) {
                        if (this.kAH >= 100.0f && this.kAJ >= getmCdnLogData().getErrNumber() && this.kAI >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kAH >= 100.0f && this.kAJ >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kAH >= 100.0f && this.kAI >= getmCdnLogData().getSlowNumber()) {
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
                this.kAH -= 25.0f;
            } else {
                this.kAH -= getmCdnLogData().getSuccRank();
            }
            if (this.kAH < 0.0f) {
                this.kAH = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kAE) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kAM == null) {
            this.kAM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kAM);
        cDNUpLoadTask.execute(new Object[0]);
        this.kAE = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kAK = 0;
        this.kAI = 0;
        this.kAJ = 0;
        this.kAL = 0;
        this.kAH = 0.0f;
        this.kAN.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bCD;
        private final aa caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kAI;
        private final int kAJ;
        private final int kAK;
        private final String kAQ;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kAJ = i3;
            this.kAI = i4;
            this.bCD = str;
            this.kAQ = str2;
            this.mType = i;
            this.kAK = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.caS.addPostData("number", String.valueOf(this.kAK));
            if (this.mType == 1) {
                this.caS.addPostData("ab_num_error", String.valueOf(this.kAJ));
                this.caS.addPostData(BdStatsConstant.StatsType.ERROR, this.bCD);
                this.caS.addPostData("ab_num_slow", String.valueOf(this.kAI));
                this.caS.addPostData("time", this.kAQ);
            } else if (this.mType == 3) {
                this.caS.addPostData("ab_num_slow", this.kAI + "");
                this.caS.addPostData("time", this.kAQ);
            } else if (this.mType == 2) {
                this.caS.addPostData("ab_num_error", this.kAJ + "");
                this.caS.addPostData(BdStatsConstant.StatsType.ERROR, this.bCD);
            }
            String postNetData = this.caS.postNetData();
            if (!this.caS.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: ek */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a mT = u.mT();
                    mT.append("act", "fallback");
                    mT.append("result", "1");
                    mT.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", mT);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.fcX.setmSwitch(false);
                    CDNProblemUploader.this.Om = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a mT2 = u.mT();
                        mT2.append("act", "fallback");
                        mT2.append("result", "2");
                        mT2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT2);
                    } else {
                        a mT3 = u.mT();
                        mT3.append("act", "fallback");
                        mT3.append("result", "0");
                        mT3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.fcX.setmSwitch(false);
                        CDNProblemUploader.this.Om = System.currentTimeMillis();
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
                CDNProblemUploader.this.kAE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kAR;

        private CdnErrorJsonData() {
            this.kAR = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kAR.length() != 0) {
                this.kAR.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.kAR.append(i);
        }

        public void clear() {
            this.kAR.setLength(0);
        }

        public String toString() {
            return this.kAR.toString();
        }
    }
}
