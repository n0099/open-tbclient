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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kOv;
    private static Object lockObject = new Object();
    private q fjE;
    private int kOp;
    private int kOq;
    private int kOr;
    private int kOs;
    private Handler mHandler;
    private final int kOc = 5;
    private final int kOd = 0;
    private final int kOe = 1;
    private final int kOf = 2;
    private final int kOg = 3;
    private final byte kOh = 0;
    private final byte kOi = 1;
    private int kOj = 0;
    private final int kOk = 5;
    private boolean kOl = false;
    private long Ph = 0;
    private final long kOm = 86400000;
    private final float kOn = 100.0f;
    private float kOo = 0.0f;
    private BdAsyncTaskParallel kOt = null;
    private final CdnErrorJsonData kOu = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kOj + 1;
        cDNProblemUploader.kOj = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kOv == null) {
            synchronized (CDNProblemUploader.class) {
                if (kOv == null) {
                    kOv = new CDNProblemUploader();
                }
            }
        }
        return kOv;
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
        return this.fjE;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(q qVar) {
        synchronized (lockObject) {
            this.fjE = qVar;
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
                this.kOo += 25.0f;
            } else {
                this.kOo += getmCdnLogData().getErrRank();
            }
            this.kOr++;
            this.kOq++;
            this.kOu.add(i);
            int i3 = this.kOr;
            int i4 = this.kOq;
            int i5 = this.kOp;
            int i6 = this.kOp != 0 ? this.kOs / this.kOp : 0;
            String cdnErrorJsonData = this.kOu.toString();
            if (getmCdnLogData() != null && this.Ph > 0 && System.currentTimeMillis() - this.Ph > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kOj = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kOr < 5) {
                    i2 = 0;
                } else if (this.kOo < 100.0f || this.kOq < getmCdnLogData().getErrNumber() || this.kOp < getmCdnLogData().getSlowNumber()) {
                    if (this.kOo >= 100.0f && this.kOq >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kOo < 100.0f || this.kOp < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kOo += 10.0f;
                } else {
                    this.kOo += getmCdnLogData().getSlowRank();
                }
                this.kOp++;
                this.kOs = (int) (this.kOs + j);
                this.kOr++;
                int i4 = this.kOr;
                int i5 = this.kOq;
                int i6 = this.kOp;
                if (this.kOp != 0) {
                    i = this.kOs / this.kOp;
                }
                String cdnErrorJsonData = this.kOu.toString();
                if (getmCdnLogData() != null && this.Ph > 0 && System.currentTimeMillis() - this.Ph > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kOj = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kOr >= 5) {
                        if (this.kOo >= 100.0f && this.kOq >= getmCdnLogData().getErrNumber() && this.kOp >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kOo >= 100.0f && this.kOq >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kOo >= 100.0f && this.kOp >= getmCdnLogData().getSlowNumber()) {
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
                this.kOo -= 25.0f;
            } else {
                this.kOo -= getmCdnLogData().getSuccRank();
            }
            if (this.kOo < 0.0f) {
                this.kOo = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kOl) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kOt == null) {
            this.kOt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kOt);
        cDNUpLoadTask.execute(new Object[0]);
        this.kOl = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kOr = 0;
        this.kOp = 0;
        this.kOq = 0;
        this.kOs = 0;
        this.kOo = 0.0f;
        this.kOu.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bGa;
        private final aa cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kOp;
        private final int kOq;
        private final int kOr;
        private final String kOx;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kOq = i3;
            this.kOp = i4;
            this.bGa = str;
            this.kOx = str2;
            this.mType = i;
            this.kOr = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cfI.addPostData("number", String.valueOf(this.kOr));
            if (this.mType == 1) {
                this.cfI.addPostData("ab_num_error", String.valueOf(this.kOq));
                this.cfI.addPostData(BdStatsConstant.StatsType.ERROR, this.bGa);
                this.cfI.addPostData("ab_num_slow", String.valueOf(this.kOp));
                this.cfI.addPostData("time", this.kOx);
            } else if (this.mType == 3) {
                this.cfI.addPostData("ab_num_slow", this.kOp + "");
                this.cfI.addPostData("time", this.kOx);
            } else if (this.mType == 2) {
                this.cfI.addPostData("ab_num_error", this.kOq + "");
                this.cfI.addPostData(BdStatsConstant.StatsType.ERROR, this.bGa);
            }
            String postNetData = this.cfI.postNetData();
            if (!this.cfI.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: eg */
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
                    CDNProblemUploader.this.fjE.setmSwitch(false);
                    CDNProblemUploader.this.Ph = System.currentTimeMillis();
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
                        CDNProblemUploader.this.fjE.setmSwitch(false);
                        CDNProblemUploader.this.Ph = System.currentTimeMillis();
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
                CDNProblemUploader.this.kOl = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kOy;

        private CdnErrorJsonData() {
            this.kOy = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kOy.length() != 0) {
                this.kOy.append(",");
            }
            this.kOy.append(i);
        }

        public void clear() {
            this.kOy.setLength(0);
        }

        public String toString() {
            return this.kOy.toString();
        }
    }
}
