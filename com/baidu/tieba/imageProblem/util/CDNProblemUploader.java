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
    private static Object dky = new Object();
    private static volatile CDNProblemUploader dkz;
    private l apk;
    private int dkt;
    private int dku;
    private int dkv;
    private int mErrorNum;
    private Handler mHandler;
    private final int dkg = 5;
    private final int dkh = 0;
    private final int dki = 1;
    private final int dkj = 2;
    private final int dkk = 3;
    private final byte dkl = 0;
    private final byte dkm = 1;
    private int dkn = 0;
    private final int dko = 5;
    private boolean dkp = false;
    private long xn = 0;
    private final long dkq = 86400000;
    private final float dkr = 100.0f;
    private float dks = 0.0f;
    private BdAsyncTaskParallel dkw = null;
    private final CdnErrorJsonData dkx = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m14getInstance() {
        if (dkz == null) {
            synchronized (CDNProblemUploader.class) {
                if (dkz == null) {
                    dkz = new CDNProblemUploader();
                }
            }
        }
        return dkz;
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
        return this.apk;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dky) {
            this.apk = lVar;
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
        synchronized (dky) {
            if (getmCdnLogData() == null) {
                this.dks += 25.0f;
            } else {
                this.dks += getmCdnLogData().getErrRank();
            }
            this.dku++;
            this.mErrorNum++;
            this.dkx.add(i);
            int i3 = this.dku;
            int i4 = this.mErrorNum;
            int i5 = this.dkt;
            int i6 = this.dkt != 0 ? this.dkv / this.dkt : 0;
            String cdnErrorJsonData = this.dkx.toString();
            if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dkn = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dku < 5) {
                    i2 = 0;
                } else if (this.dks < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dkt < getmCdnLogData().getSlowNumber()) {
                    if (this.dks >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dks < 100.0f || this.dkt < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dky) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dks += 10.0f;
                } else {
                    this.dks += getmCdnLogData().getSlowRank();
                }
                this.dkt++;
                this.dkv = (int) (this.dkv + j);
                this.dku++;
                int i4 = this.dku;
                int i5 = this.mErrorNum;
                int i6 = this.dkt;
                if (this.dkt != 0) {
                    i = this.dkv / this.dkt;
                }
                String cdnErrorJsonData = this.dkx.toString();
                if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dkn = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dku >= 5) {
                        if (this.dks >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dkt >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dks >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dks >= 100.0f && this.dkt >= getmCdnLogData().getSlowNumber()) {
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
                this.dks -= 25.0f;
            } else {
                this.dks -= getmCdnLogData().getSuccRank();
            }
            if (this.dks < 0.0f) {
                this.dks = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dkp) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dkw == null) {
            this.dkw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dkw);
        cDNUpLoadTask.execute(new Object[0]);
        this.dkp = true;
        c fN = u.fN();
        fN.p("act", "fallback");
        fN.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dku = 0;
        this.dkt = 0;
        this.mErrorNum = 0;
        this.dkv = 0;
        this.dks = 0.0f;
        this.dkx.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String acu;
        private final String dkB;
        private final int dkt;
        private final int dku;
        private final int mErrorNum;
        private final z mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dkt = i4;
            this.acu = str;
            this.dkB = str2;
            this.mType = i;
            this.dku = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dku));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.acu);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dkt));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dkB);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dkt)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dkB);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.acu);
            }
            String ul = this.mNetWork.ul();
            if (!this.mNetWork.uM() || TextUtils.isEmpty(ul)) {
                return null;
            }
            try {
                return new JSONObject(ul);
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
                int i = cDNProblemUploader.dkn + 1;
                cDNProblemUploader.dkn = i;
                if (i >= 5) {
                    CDNProblemUploader.this.apk.setmSwitch(false);
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
                    CDNProblemUploader.this.apk.setmSwitch(false);
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
                CDNProblemUploader.this.dkp = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dkC;

        private CdnErrorJsonData() {
            this.dkC = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dkC.length() != 0) {
                this.dkC.append(",");
            }
            this.dkC.append(i);
        }

        public void clear() {
            this.dkC.setLength(0);
        }

        public String toString() {
            return this.dkC.toString();
        }
    }
}
