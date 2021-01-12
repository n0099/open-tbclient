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
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.z;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kPx;
    private static Object lockObject = new Object();
    private q foC;
    private int kPr;
    private int kPs;
    private int kPt;
    private int kPu;
    private Handler mHandler;
    private final int kPe = 5;
    private final int kPf = 0;
    private final int kPg = 1;
    private final int kPh = 2;
    private final int kPi = 3;
    private final byte kPj = 0;
    private final byte kPk = 1;
    private int kPl = 0;
    private final int kPm = 5;
    private boolean kPn = false;
    private long Pi = 0;
    private final long kPo = 86400000;
    private final float kPp = 100.0f;
    private float kPq = 0.0f;
    private BdAsyncTaskParallel kPv = null;
    private final CdnErrorJsonData kPw = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kPl + 1;
        cDNProblemUploader.kPl = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kPx == null) {
            synchronized (CDNProblemUploader.class) {
                if (kPx == null) {
                    kPx = new CDNProblemUploader();
                }
            }
        }
        return kPx;
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
        return this.foC;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(q qVar) {
        synchronized (lockObject) {
            this.foC = qVar;
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
                this.kPq += 25.0f;
            } else {
                this.kPq += getmCdnLogData().getErrRank();
            }
            this.kPt++;
            this.kPs++;
            this.kPw.add(i);
            int i3 = this.kPt;
            int i4 = this.kPs;
            int i5 = this.kPr;
            int i6 = this.kPr != 0 ? this.kPu / this.kPr : 0;
            String cdnErrorJsonData = this.kPw.toString();
            if (getmCdnLogData() != null && this.Pi > 0 && System.currentTimeMillis() - this.Pi > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kPl = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kPt < 5) {
                    i2 = 0;
                } else if (this.kPq < 100.0f || this.kPs < getmCdnLogData().getErrNumber() || this.kPr < getmCdnLogData().getSlowNumber()) {
                    if (this.kPq >= 100.0f && this.kPs >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kPq < 100.0f || this.kPr < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kPq += 10.0f;
                } else {
                    this.kPq += getmCdnLogData().getSlowRank();
                }
                this.kPr++;
                this.kPu = (int) (this.kPu + j);
                this.kPt++;
                int i4 = this.kPt;
                int i5 = this.kPs;
                int i6 = this.kPr;
                if (this.kPr != 0) {
                    i = this.kPu / this.kPr;
                }
                String cdnErrorJsonData = this.kPw.toString();
                if (getmCdnLogData() != null && this.Pi > 0 && System.currentTimeMillis() - this.Pi > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kPl = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kPt >= 5) {
                        if (this.kPq >= 100.0f && this.kPs >= getmCdnLogData().getErrNumber() && this.kPr >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kPq >= 100.0f && this.kPs >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kPq >= 100.0f && this.kPr >= getmCdnLogData().getSlowNumber()) {
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
                this.kPq -= 25.0f;
            } else {
                this.kPq -= getmCdnLogData().getSuccRank();
            }
            if (this.kPq < 0.0f) {
                this.kPq = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kPn) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kPv == null) {
            this.kPv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kPv);
        cDNUpLoadTask.execute(new Object[0]);
        this.kPn = true;
        a pi = t.pi();
        pi.append("act", "fallback");
        pi.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kPt = 0;
        this.kPr = 0;
        this.kPs = 0;
        this.kPu = 0;
        this.kPq = 0.0f;
        this.kPw.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bGd;
        private final z chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kPr;
        private final int kPs;
        private final int kPt;
        private final String kPz;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kPs = i3;
            this.kPr = i4;
            this.bGd = str;
            this.kPz = str2;
            this.mType = i;
            this.kPt = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.chV.addPostData("number", String.valueOf(this.kPt));
            if (this.mType == 1) {
                this.chV.addPostData("ab_num_error", String.valueOf(this.kPs));
                this.chV.addPostData(BdStatsConstant.StatsType.ERROR, this.bGd);
                this.chV.addPostData("ab_num_slow", String.valueOf(this.kPr));
                this.chV.addPostData("time", this.kPz);
            } else if (this.mType == 3) {
                this.chV.addPostData("ab_num_slow", this.kPr + "");
                this.chV.addPostData("time", this.kPz);
            } else if (this.mType == 2) {
                this.chV.addPostData("ab_num_error", this.kPs + "");
                this.chV.addPostData(BdStatsConstant.StatsType.ERROR, this.bGd);
            }
            String postNetData = this.chV.postNetData();
            if (!this.chV.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: eu */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a pi = t.pi();
                    pi.append("act", "fallback");
                    pi.append("result", "1");
                    pi.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", pi);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.foC.setmSwitch(false);
                    CDNProblemUploader.this.Pi = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                        a pi2 = t.pi();
                        pi2.append("act", "fallback");
                        pi2.append("result", "2");
                        pi2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pi2);
                    } else {
                        a pi3 = t.pi();
                        pi3.append("act", "fallback");
                        pi3.append("result", "0");
                        pi3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pi3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.foC.setmSwitch(false);
                        CDNProblemUploader.this.Pi = System.currentTimeMillis();
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
                CDNProblemUploader.this.kPn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class CdnErrorJsonData {
        StringBuffer kPA;

        private CdnErrorJsonData() {
            this.kPA = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kPA.length() != 0) {
                this.kPA.append(",");
            }
            this.kPA.append(i);
        }

        public void clear() {
            this.kPA.setLength(0);
        }

        public String toString() {
            return this.kPA.toString();
        }
    }
}
