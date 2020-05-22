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
    private static volatile CDNProblemUploader iUN;
    private static Object lockObject = new Object();
    private m ebe;
    private int iUH;
    private int iUI;
    private int iUJ;
    private int iUK;
    private Handler mHandler;
    private final int iUu = 5;
    private final int iUv = 0;
    private final int iUw = 1;
    private final int iUx = 2;
    private final int iUy = 3;
    private final byte iUz = 0;
    private final byte iUA = 1;
    private int iUB = 0;
    private final int iUC = 5;
    private boolean iUD = false;
    private long Mu = 0;
    private final long iUE = 86400000;
    private final float iUF = 100.0f;
    private float iUG = 0.0f;
    private BdAsyncTaskParallel iUL = null;
    private final CdnErrorJsonData iUM = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.iUB + 1;
        cDNProblemUploader.iUB = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (iUN == null) {
            synchronized (CDNProblemUploader.class) {
                if (iUN == null) {
                    iUN = new CDNProblemUploader();
                }
            }
        }
        return iUN;
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
                this.iUG += 25.0f;
            } else {
                this.iUG += getmCdnLogData().getErrRank();
            }
            this.iUJ++;
            this.iUI++;
            this.iUM.add(i);
            int i3 = this.iUJ;
            int i4 = this.iUI;
            int i5 = this.iUH;
            int i6 = this.iUH != 0 ? this.iUK / this.iUH : 0;
            String cdnErrorJsonData = this.iUM.toString();
            if (getmCdnLogData() != null && this.Mu > 0 && System.currentTimeMillis() - this.Mu > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.iUB = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.iUJ < 5) {
                    i2 = 0;
                } else if (this.iUG < 100.0f || this.iUI < getmCdnLogData().getErrNumber() || this.iUH < getmCdnLogData().getSlowNumber()) {
                    if (this.iUG >= 100.0f && this.iUI >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.iUG < 100.0f || this.iUH < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.iUG += 10.0f;
                } else {
                    this.iUG += getmCdnLogData().getSlowRank();
                }
                this.iUH++;
                this.iUK = (int) (this.iUK + j);
                this.iUJ++;
                int i4 = this.iUJ;
                int i5 = this.iUI;
                int i6 = this.iUH;
                if (this.iUH != 0) {
                    i = this.iUK / this.iUH;
                }
                String cdnErrorJsonData = this.iUM.toString();
                if (getmCdnLogData() != null && this.Mu > 0 && System.currentTimeMillis() - this.Mu > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.iUB = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.iUJ >= 5) {
                        if (this.iUG >= 100.0f && this.iUI >= getmCdnLogData().getErrNumber() && this.iUH >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.iUG >= 100.0f && this.iUI >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.iUG >= 100.0f && this.iUH >= getmCdnLogData().getSlowNumber()) {
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
                this.iUG -= 25.0f;
            } else {
                this.iUG -= getmCdnLogData().getSuccRank();
            }
            if (this.iUG < 0.0f) {
                this.iUG = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.iUD) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.iUL == null) {
            this.iUL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.iUL);
        cDNUpLoadTask.execute(new Object[0]);
        this.iUD = true;
        a kY = s.kY();
        kY.append("act", "fallback");
        kY.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", kY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iUJ = 0;
        this.iUH = 0;
        this.iUI = 0;
        this.iUK = 0;
        this.iUG = 0.0f;
        this.iUM.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bcp;
        private final x bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int iUH;
        private final int iUI;
        private final int iUJ;
        private final String iUP;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.iUI = i3;
            this.iUH = i4;
            this.bcp = str;
            this.iUP = str2;
            this.mType = i;
            this.iUJ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bth.addPostData("number", String.valueOf(this.iUJ));
            if (this.mType == 1) {
                this.bth.addPostData("ab_num_error", String.valueOf(this.iUI));
                this.bth.addPostData(BdStatsConstant.StatsType.ERROR, this.bcp);
                this.bth.addPostData("ab_num_slow", String.valueOf(this.iUH));
                this.bth.addPostData("time", this.iUP);
            } else if (this.mType == 3) {
                this.bth.addPostData("ab_num_slow", this.iUH + "");
                this.bth.addPostData("time", this.iUP);
            } else if (this.mType == 2) {
                this.bth.addPostData("ab_num_error", this.iUI + "");
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
                CDNProblemUploader.this.iUD = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer iUQ;

        private CdnErrorJsonData() {
            this.iUQ = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.iUQ.length() != 0) {
                this.iUQ.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.iUQ.append(i);
        }

        public void clear() {
            this.iUQ.setLength(0);
        }

        public String toString() {
            return this.iUQ.toString();
        }
    }
}
