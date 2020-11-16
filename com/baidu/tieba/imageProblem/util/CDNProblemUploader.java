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
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kBd;
    private static Object lockObject = new Object();
    private q fce;
    private int kAX;
    private int kAY;
    private int kAZ;
    private int kBa;
    private Handler mHandler;
    private final int kAK = 5;
    private final int kAL = 0;
    private final int kAM = 1;
    private final int kAN = 2;
    private final int kAO = 3;
    private final byte kAP = 0;
    private final byte kAQ = 1;
    private int kAR = 0;
    private final int kAS = 5;
    private boolean kAT = false;
    private long Om = 0;
    private final long kAU = 86400000;
    private final float kAV = 100.0f;
    private float kAW = 0.0f;
    private BdAsyncTaskParallel kBb = null;
    private final CdnErrorJsonData kBc = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kAR + 1;
        cDNProblemUploader.kAR = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kBd == null) {
            synchronized (CDNProblemUploader.class) {
                if (kBd == null) {
                    kBd = new CDNProblemUploader();
                }
            }
        }
        return kBd;
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
    public q getmCdnLogData() {
        return this.fce;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(q qVar) {
        synchronized (lockObject) {
            this.fce = qVar;
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
                this.kAW += 25.0f;
            } else {
                this.kAW += getmCdnLogData().getErrRank();
            }
            this.kAZ++;
            this.kAY++;
            this.kBc.add(i);
            int i3 = this.kAZ;
            int i4 = this.kAY;
            int i5 = this.kAX;
            int i6 = this.kAX != 0 ? this.kBa / this.kAX : 0;
            String cdnErrorJsonData = this.kBc.toString();
            if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kAR = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kAZ < 5) {
                    i2 = 0;
                } else if (this.kAW < 100.0f || this.kAY < getmCdnLogData().getErrNumber() || this.kAX < getmCdnLogData().getSlowNumber()) {
                    if (this.kAW >= 100.0f && this.kAY >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kAW < 100.0f || this.kAX < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kAW += 10.0f;
                } else {
                    this.kAW += getmCdnLogData().getSlowRank();
                }
                this.kAX++;
                this.kBa = (int) (this.kBa + j);
                this.kAZ++;
                int i4 = this.kAZ;
                int i5 = this.kAY;
                int i6 = this.kAX;
                if (this.kAX != 0) {
                    i = this.kBa / this.kAX;
                }
                String cdnErrorJsonData = this.kBc.toString();
                if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kAR = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kAZ >= 5) {
                        if (this.kAW >= 100.0f && this.kAY >= getmCdnLogData().getErrNumber() && this.kAX >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kAW >= 100.0f && this.kAY >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kAW >= 100.0f && this.kAX >= getmCdnLogData().getSlowNumber()) {
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
                this.kAW -= 25.0f;
            } else {
                this.kAW -= getmCdnLogData().getSuccRank();
            }
            if (this.kAW < 0.0f) {
                this.kAW = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kAT) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kBb == null) {
            this.kBb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kBb);
        cDNUpLoadTask.execute(new Object[0]);
        this.kAT = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kAZ = 0;
        this.kAX = 0;
        this.kAY = 0;
        this.kBa = 0;
        this.kAW = 0.0f;
        this.kBc.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bAS;
        private final aa bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kAX;
        private final int kAY;
        private final int kAZ;
        private final String kBf;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kAY = i3;
            this.kAX = i4;
            this.bAS = str;
            this.kBf = str2;
            this.mType = i;
            this.kAZ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bZh.addPostData("number", String.valueOf(this.kAZ));
            if (this.mType == 1) {
                this.bZh.addPostData("ab_num_error", String.valueOf(this.kAY));
                this.bZh.addPostData(BdStatsConstant.StatsType.ERROR, this.bAS);
                this.bZh.addPostData("ab_num_slow", String.valueOf(this.kAX));
                this.bZh.addPostData("time", this.kBf);
            } else if (this.mType == 3) {
                this.bZh.addPostData("ab_num_slow", this.kAX + "");
                this.bZh.addPostData("time", this.kBf);
            } else if (this.mType == 2) {
                this.bZh.addPostData("ab_num_error", this.kAY + "");
                this.bZh.addPostData(BdStatsConstant.StatsType.ERROR, this.bAS);
            }
            String postNetData = this.bZh.postNetData();
            if (!this.bZh.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: ee */
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
                    CDNProblemUploader.this.fce.setmSwitch(false);
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
                        CDNProblemUploader.this.fce.setmSwitch(false);
                        CDNProblemUploader.this.Om = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    q qVar = new q();
                    qVar.parseJson(optString);
                    if (qVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && qVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && qVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && qVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(qVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.kAT = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kBg;

        private CdnErrorJsonData() {
            this.kBg = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kBg.length() != 0) {
                this.kBg.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.kBg.append(i);
        }

        public void clear() {
            this.kBg.setLength(0);
        }

        public String toString() {
            return this.kBg.toString();
        }
    }
}
