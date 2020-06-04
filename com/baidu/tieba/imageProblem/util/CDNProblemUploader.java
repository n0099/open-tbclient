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
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNProblemUploader extends p {
    private static volatile CDNProblemUploader iVA;
    private static Object lockObject = new Object();
    private m ebe;
    private int iVu;
    private int iVv;
    private int iVw;
    private int iVx;
    private Handler mHandler;
    private final int iVh = 5;
    private final int iVi = 0;
    private final int iVj = 1;
    private final int iVk = 2;
    private final int iVl = 3;
    private final byte iVm = 0;
    private final byte iVn = 1;
    private int iVo = 0;
    private final int iVp = 5;
    private boolean iVq = false;
    private long Mu = 0;
    private final long iVr = 86400000;
    private final float iVs = 100.0f;
    private float iVt = 0.0f;
    private BdAsyncTaskParallel iVy = null;
    private final CdnErrorJsonData iVz = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.iVo + 1;
        cDNProblemUploader.iVo = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (iVA == null) {
            synchronized (CDNProblemUploader.class) {
                if (iVA == null) {
                    iVA = new CDNProblemUploader();
                }
            }
        }
        return iVA;
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
    public m getmCdnLogData() {
        return this.ebe;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (lockObject) {
            this.ebe = mVar;
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
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.iVt += 25.0f;
            } else {
                this.iVt += getmCdnLogData().getErrRank();
            }
            this.iVw++;
            this.iVv++;
            this.iVz.add(i);
            int i3 = this.iVw;
            int i4 = this.iVv;
            int i5 = this.iVu;
            int i6 = this.iVu != 0 ? this.iVx / this.iVu : 0;
            String cdnErrorJsonData = this.iVz.toString();
            if (getmCdnLogData() != null && this.Mu > 0 && System.currentTimeMillis() - this.Mu > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.iVo = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.iVw < 5) {
                    i2 = 0;
                } else if (this.iVt < 100.0f || this.iVv < getmCdnLogData().getErrNumber() || this.iVu < getmCdnLogData().getSlowNumber()) {
                    if (this.iVt >= 100.0f && this.iVv >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.iVt < 100.0f || this.iVu < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.iVt += 10.0f;
                } else {
                    this.iVt += getmCdnLogData().getSlowRank();
                }
                this.iVu++;
                this.iVx = (int) (this.iVx + j);
                this.iVw++;
                int i4 = this.iVw;
                int i5 = this.iVv;
                int i6 = this.iVu;
                if (this.iVu != 0) {
                    i = this.iVx / this.iVu;
                }
                String cdnErrorJsonData = this.iVz.toString();
                if (getmCdnLogData() != null && this.Mu > 0 && System.currentTimeMillis() - this.Mu > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.iVo = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.iVw >= 5) {
                        if (this.iVt >= 100.0f && this.iVv >= getmCdnLogData().getErrNumber() && this.iVu >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.iVt >= 100.0f && this.iVv >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.iVt >= 100.0f && this.iVu >= getmCdnLogData().getSlowNumber()) {
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
                this.iVt -= 25.0f;
            } else {
                this.iVt -= getmCdnLogData().getSuccRank();
            }
            if (this.iVt < 0.0f) {
                this.iVt = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.iVq) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.iVy == null) {
            this.iVy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.iVy);
        cDNUpLoadTask.execute(new Object[0]);
        this.iVq = true;
        a kY = s.kY();
        kY.append("act", "fallback");
        kY.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", kY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iVw = 0;
        this.iVu = 0;
        this.iVv = 0;
        this.iVx = 0;
        this.iVt = 0.0f;
        this.iVz.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bcp;
        private final x bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String iVC;
        private final int iVu;
        private final int iVv;
        private final int iVw;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.iVv = i3;
            this.iVu = i4;
            this.bcp = str;
            this.iVC = str2;
            this.mType = i;
            this.iVw = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bth.addPostData("number", String.valueOf(this.iVw));
            if (this.mType == 1) {
                this.bth.addPostData("ab_num_error", String.valueOf(this.iVv));
                this.bth.addPostData(BdStatsConstant.StatsType.ERROR, this.bcp);
                this.bth.addPostData("ab_num_slow", String.valueOf(this.iVu));
                this.bth.addPostData("time", this.iVC);
            } else if (this.mType == 3) {
                this.bth.addPostData("ab_num_slow", this.iVu + "");
                this.bth.addPostData("time", this.iVC);
            } else if (this.mType == 2) {
                this.bth.addPostData("ab_num_error", this.iVv + "");
                this.bth.addPostData(BdStatsConstant.StatsType.ERROR, this.bcp);
            }
            String postNetData = this.bth.postNetData();
            if (!this.bth.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: dk */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a kY = s.kY();
                    kY.append("act", "fallback");
                    kY.append("result", "1");
                    kY.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", kY);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ebe.setmSwitch(false);
                    CDNProblemUploader.this.Mu = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a kY2 = s.kY();
                        kY2.append("act", "fallback");
                        kY2.append("result", "2");
                        kY2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", kY2);
                    } else {
                        a kY3 = s.kY();
                        kY3.append("act", "fallback");
                        kY3.append("result", "0");
                        kY3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", kY3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ebe.setmSwitch(false);
                        CDNProblemUploader.this.Mu = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    m mVar = new m();
                    mVar.parseJson(optString);
                    if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(mVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.iVq = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer iVD;

        private CdnErrorJsonData() {
            this.iVD = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.iVD.length() != 0) {
                this.iVD.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.iVD.append(i);
        }

        public void clear() {
            this.iVD.setLength(0);
        }

        public String toString() {
            return this.iVD.toString();
        }
    }
}
