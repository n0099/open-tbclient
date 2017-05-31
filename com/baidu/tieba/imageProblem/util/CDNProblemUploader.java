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
/* loaded from: classes2.dex */
public class CDNProblemUploader extends r {
    private static Object dpS = new Object();
    private static volatile CDNProblemUploader dpT;
    private l aoU;
    private int dpN;
    private int dpO;
    private int dpP;
    private int mErrorNum;
    private Handler mHandler;
    private final int dpA = 5;
    private final int dpB = 0;
    private final int dpC = 1;
    private final int dpD = 2;
    private final int dpE = 3;
    private final byte dpF = 0;
    private final byte dpG = 1;
    private int dpH = 0;
    private final int dpI = 5;
    private boolean dpJ = false;
    private long xn = 0;
    private final long dpK = 86400000;
    private final float dpL = 100.0f;
    private float dpM = 0.0f;
    private BdAsyncTaskParallel dpQ = null;
    private final CdnErrorJsonData dpR = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m17getInstance() {
        if (dpT == null) {
            synchronized (CDNProblemUploader.class) {
                if (dpT == null) {
                    dpT = new CDNProblemUploader();
                }
            }
        }
        return dpT;
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
        return this.aoU;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dpS) {
            this.aoU = lVar;
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
        synchronized (dpS) {
            if (getmCdnLogData() == null) {
                this.dpM += 25.0f;
            } else {
                this.dpM += getmCdnLogData().getErrRank();
            }
            this.dpO++;
            this.mErrorNum++;
            this.dpR.add(i);
            int i3 = this.dpO;
            int i4 = this.mErrorNum;
            int i5 = this.dpN;
            int i6 = this.dpN != 0 ? this.dpP / this.dpN : 0;
            String cdnErrorJsonData = this.dpR.toString();
            if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dpH = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dpO < 5) {
                    i2 = 0;
                } else if (this.dpM < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dpN < getmCdnLogData().getSlowNumber()) {
                    if (this.dpM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dpM < 100.0f || this.dpN < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dpS) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dpM += 10.0f;
                } else {
                    this.dpM += getmCdnLogData().getSlowRank();
                }
                this.dpN++;
                this.dpP = (int) (this.dpP + j);
                this.dpO++;
                int i4 = this.dpO;
                int i5 = this.mErrorNum;
                int i6 = this.dpN;
                if (this.dpN != 0) {
                    i = this.dpP / this.dpN;
                }
                String cdnErrorJsonData = this.dpR.toString();
                if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dpH = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dpO >= 5) {
                        if (this.dpM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dpN >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dpM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dpM >= 100.0f && this.dpN >= getmCdnLogData().getSlowNumber()) {
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
                this.dpM -= 25.0f;
            } else {
                this.dpM -= getmCdnLogData().getSuccRank();
            }
            if (this.dpM < 0.0f) {
                this.dpM = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dpJ) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dpQ == null) {
            this.dpQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dpQ);
        cDNUpLoadTask.execute(new Object[0]);
        this.dpJ = true;
        c fN = u.fN();
        fN.p("act", "fallback");
        fN.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dpO = 0;
        this.dpN = 0;
        this.mErrorNum = 0;
        this.dpP = 0;
        this.dpM = 0.0f;
        this.dpR.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String act;
        private final int dpN;
        private final int dpO;
        private final String dpV;
        private final int mErrorNum;
        private final z mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dpN = i4;
            this.act = str;
            this.dpV = str2;
            this.mType = i;
            this.dpO = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dpO));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.act);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dpN));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dpV);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dpN)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dpV);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.act);
            }
            String ug = this.mNetWork.ug();
            if (!this.mNetWork.uI() || TextUtils.isEmpty(ug)) {
                return null;
            }
            try {
                return new JSONObject(ug);
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
                int i = cDNProblemUploader.dpH + 1;
                cDNProblemUploader.dpH = i;
                if (i >= 5) {
                    CDNProblemUploader.this.aoU.setmSwitch(false);
                    CDNProblemUploader.this.xn = System.currentTimeMillis();
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
                    CDNProblemUploader.this.aoU.setmSwitch(false);
                    CDNProblemUploader.this.xn = System.currentTimeMillis();
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
                CDNProblemUploader.this.dpJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dpW;

        private CdnErrorJsonData() {
            this.dpW = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dpW.length() != 0) {
                this.dpW.append(",");
            }
            this.dpW.append(i);
        }

        public void clear() {
            this.dpW.setLength(0);
        }

        public String toString() {
            return this.dpW.toString();
        }
    }
}
