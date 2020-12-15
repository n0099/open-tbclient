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
    private static volatile CDNProblemUploader kOx;
    private static Object lockObject = new Object();
    private q fjE;
    private int kOr;
    private int kOs;
    private int kOt;
    private int kOu;
    private Handler mHandler;
    private final int kOe = 5;
    private final int kOf = 0;
    private final int kOg = 1;
    private final int kOh = 2;
    private final int kOi = 3;
    private final byte kOj = 0;
    private final byte kOk = 1;
    private int kOl = 0;
    private final int kOm = 5;
    private boolean kOn = false;
    private long Ph = 0;
    private final long kOo = 86400000;
    private final float kOp = 100.0f;
    private float kOq = 0.0f;
    private BdAsyncTaskParallel kOv = null;
    private final CdnErrorJsonData kOw = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kOl + 1;
        cDNProblemUploader.kOl = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kOx == null) {
            synchronized (CDNProblemUploader.class) {
                if (kOx == null) {
                    kOx = new CDNProblemUploader();
                }
            }
        }
        return kOx;
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
                this.kOq += 25.0f;
            } else {
                this.kOq += getmCdnLogData().getErrRank();
            }
            this.kOt++;
            this.kOs++;
            this.kOw.add(i);
            int i3 = this.kOt;
            int i4 = this.kOs;
            int i5 = this.kOr;
            int i6 = this.kOr != 0 ? this.kOu / this.kOr : 0;
            String cdnErrorJsonData = this.kOw.toString();
            if (getmCdnLogData() != null && this.Ph > 0 && System.currentTimeMillis() - this.Ph > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kOl = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kOt < 5) {
                    i2 = 0;
                } else if (this.kOq < 100.0f || this.kOs < getmCdnLogData().getErrNumber() || this.kOr < getmCdnLogData().getSlowNumber()) {
                    if (this.kOq >= 100.0f && this.kOs >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kOq < 100.0f || this.kOr < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kOq += 10.0f;
                } else {
                    this.kOq += getmCdnLogData().getSlowRank();
                }
                this.kOr++;
                this.kOu = (int) (this.kOu + j);
                this.kOt++;
                int i4 = this.kOt;
                int i5 = this.kOs;
                int i6 = this.kOr;
                if (this.kOr != 0) {
                    i = this.kOu / this.kOr;
                }
                String cdnErrorJsonData = this.kOw.toString();
                if (getmCdnLogData() != null && this.Ph > 0 && System.currentTimeMillis() - this.Ph > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kOl = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kOt >= 5) {
                        if (this.kOq >= 100.0f && this.kOs >= getmCdnLogData().getErrNumber() && this.kOr >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kOq >= 100.0f && this.kOs >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kOq >= 100.0f && this.kOr >= getmCdnLogData().getSlowNumber()) {
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
                this.kOq -= 25.0f;
            } else {
                this.kOq -= getmCdnLogData().getSuccRank();
            }
            if (this.kOq < 0.0f) {
                this.kOq = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kOn) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kOv == null) {
            this.kOv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kOv);
        cDNUpLoadTask.execute(new Object[0]);
        this.kOn = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kOt = 0;
        this.kOr = 0;
        this.kOs = 0;
        this.kOu = 0;
        this.kOq = 0.0f;
        this.kOw.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bGa;
        private final aa cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kOr;
        private final int kOs;
        private final int kOt;
        private final String kOz;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kOs = i3;
            this.kOr = i4;
            this.bGa = str;
            this.kOz = str2;
            this.mType = i;
            this.kOt = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cfI.addPostData("number", String.valueOf(this.kOt));
            if (this.mType == 1) {
                this.cfI.addPostData("ab_num_error", String.valueOf(this.kOs));
                this.cfI.addPostData(BdStatsConstant.StatsType.ERROR, this.bGa);
                this.cfI.addPostData("ab_num_slow", String.valueOf(this.kOr));
                this.cfI.addPostData("time", this.kOz);
            } else if (this.mType == 3) {
                this.cfI.addPostData("ab_num_slow", this.kOr + "");
                this.cfI.addPostData("time", this.kOz);
            } else if (this.mType == 2) {
                this.cfI.addPostData("ab_num_error", this.kOs + "");
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
                CDNProblemUploader.this.kOn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kOA;

        private CdnErrorJsonData() {
            this.kOA = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kOA.length() != 0) {
                this.kOA.append(",");
            }
            this.kOA.append(i);
        }

        public void clear() {
            this.kOA.setLength(0);
        }

        public String toString() {
            return this.kOA.toString();
        }
    }
}
