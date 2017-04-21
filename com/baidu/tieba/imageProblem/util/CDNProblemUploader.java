package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object dqu = new Object();
    private static volatile CDNProblemUploader dqv;
    private l apf;
    private int dqp;
    private int dqq;
    private int dqr;
    private int mErrorNum;
    private Handler mHandler;
    private final int dqc = 5;
    private final int dqd = 0;
    private final int dqe = 1;
    private final int dqf = 2;
    private final int dqg = 3;
    private final byte dqh = 0;
    private final byte dqi = 1;
    private int dqj = 0;
    private final int dqk = 5;
    private boolean dql = false;
    private long xm = 0;
    private final long dqm = 86400000;
    private final float dqn = 100.0f;
    private float dqo = 0.0f;
    private BdAsyncTaskParallel dqs = null;
    private final CdnErrorJsonData dqt = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m23getInstance() {
        if (dqv == null) {
            synchronized (CDNProblemUploader.class) {
                if (dqv == null) {
                    dqv = new CDNProblemUploader();
                }
            }
        }
        return dqv;
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
    public l getmCdnLogData() {
        return this.apf;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dqu) {
            this.apf = lVar;
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
        synchronized (dqu) {
            if (getmCdnLogData() == null) {
                this.dqo += 25.0f;
            } else {
                this.dqo += getmCdnLogData().getErrRank();
            }
            this.dqq++;
            this.mErrorNum++;
            this.dqt.add(i);
            int i3 = this.dqq;
            int i4 = this.mErrorNum;
            int i5 = this.dqp;
            int i6 = this.dqp != 0 ? this.dqr / this.dqp : 0;
            String cdnErrorJsonData = this.dqt.toString();
            if (getmCdnLogData() != null && this.xm > 0 && System.currentTimeMillis() - this.xm > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dqj = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dqq < 5) {
                    i2 = 0;
                } else if (this.dqo < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dqp < getmCdnLogData().getSlowNumber()) {
                    if (this.dqo >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dqo < 100.0f || this.dqp < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dqu) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dqo += 10.0f;
                } else {
                    this.dqo += getmCdnLogData().getSlowRank();
                }
                this.dqp++;
                this.dqr = (int) (this.dqr + j);
                this.dqq++;
                int i4 = this.dqq;
                int i5 = this.mErrorNum;
                int i6 = this.dqp;
                if (this.dqp != 0) {
                    i = this.dqr / this.dqp;
                }
                String cdnErrorJsonData = this.dqt.toString();
                if (getmCdnLogData() != null && this.xm > 0 && System.currentTimeMillis() - this.xm > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dqj = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dqq >= 5) {
                        if (this.dqo >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dqp >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dqo >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dqo >= 100.0f && this.dqp >= getmCdnLogData().getSlowNumber()) {
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
                this.dqo -= 25.0f;
            } else {
                this.dqo -= getmCdnLogData().getSuccRank();
            }
            if (this.dqo < 0.0f) {
                this.dqo = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dql) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dqs == null) {
            this.dqs = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dqs);
        cDNUpLoadTask.execute(new Object[0]);
        this.dql = true;
        c fN = u.fN();
        fN.p("act", "fallback");
        fN.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dqq = 0;
        this.dqp = 0;
        this.mErrorNum = 0;
        this.dqr = 0;
        this.dqo = 0.0f;
        this.dqt.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String acY;
        private final int dqp;
        private final int dqq;
        private final String dqx;
        private final int mErrorNum;
        private final z mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dqp = i4;
            this.acY = str;
            this.dqx = str2;
            this.mType = i;
            this.dqq = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dqq));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.acY);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dqp));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dqx);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dqp)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dqx);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.acY);
            }
            String uY = this.mNetWork.uY();
            if (!this.mNetWork.vz() || TextUtils.isEmpty(uY)) {
                return null;
            }
            try {
                return new JSONObject(uY);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    c fN = u.fN();
                    fN.p("act", "fallback");
                    fN.p("result", "1");
                    fN.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fN);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dqj + 1;
                cDNProblemUploader.dqj = i;
                if (i >= 5) {
                    CDNProblemUploader.this.apf.setmSwitch(false);
                    CDNProblemUploader.this.xm = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    c fN2 = u.fN();
                    fN2.p("act", "fallback");
                    fN2.p("result", "2");
                    fN2.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fN2);
                } else {
                    c fN3 = u.fN();
                    fN3.p("act", "fallback");
                    fN3.p("result", "0");
                    fN3.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fN3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.apf.setmSwitch(false);
                    CDNProblemUploader.this.xm = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                l lVar = new l();
                lVar.parseJson(optString);
                if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(lVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dql = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dqy;

        private CdnErrorJsonData() {
            this.dqy = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dqy.length() != 0) {
                this.dqy.append(",");
            }
            this.dqy.append(i);
        }

        public void clear() {
            this.dqy.setLength(0);
        }

        public String toString() {
            return this.dqy.toString();
        }
    }
}
