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
    private static Object dpE = new Object();
    private static volatile CDNProblemUploader dpF;
    private l aoQ;
    private int dpA;
    private int dpB;
    private int dpz;
    private int mErrorNum;
    private Handler mHandler;
    private final int dpm = 5;
    private final int dpn = 0;
    private final int dpo = 1;
    private final int dpp = 2;
    private final int dpq = 3;
    private final byte dpr = 0;
    private final byte dps = 1;
    private int dpt = 0;
    private final int dpu = 5;
    private boolean dpv = false;
    private long xI = 0;
    private final long dpw = 86400000;
    private final float dpx = 100.0f;
    private float dpy = 0.0f;
    private BdAsyncTaskParallel dpC = null;
    private final CdnErrorJsonData dpD = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m16getInstance() {
        if (dpF == null) {
            synchronized (CDNProblemUploader.class) {
                if (dpF == null) {
                    dpF = new CDNProblemUploader();
                }
            }
        }
        return dpF;
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
        return this.aoQ;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dpE) {
            this.aoQ = lVar;
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
        synchronized (dpE) {
            if (getmCdnLogData() == null) {
                this.dpy += 25.0f;
            } else {
                this.dpy += getmCdnLogData().getErrRank();
            }
            this.dpA++;
            this.mErrorNum++;
            this.dpD.add(i);
            int i3 = this.dpA;
            int i4 = this.mErrorNum;
            int i5 = this.dpz;
            int i6 = this.dpz != 0 ? this.dpB / this.dpz : 0;
            String cdnErrorJsonData = this.dpD.toString();
            if (getmCdnLogData() != null && this.xI > 0 && System.currentTimeMillis() - this.xI > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dpt = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dpA < 5) {
                    i2 = 0;
                } else if (this.dpy < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dpz < getmCdnLogData().getSlowNumber()) {
                    if (this.dpy >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dpy < 100.0f || this.dpz < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dpE) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dpy += 10.0f;
                } else {
                    this.dpy += getmCdnLogData().getSlowRank();
                }
                this.dpz++;
                this.dpB = (int) (this.dpB + j);
                this.dpA++;
                int i4 = this.dpA;
                int i5 = this.mErrorNum;
                int i6 = this.dpz;
                if (this.dpz != 0) {
                    i = this.dpB / this.dpz;
                }
                String cdnErrorJsonData = this.dpD.toString();
                if (getmCdnLogData() != null && this.xI > 0 && System.currentTimeMillis() - this.xI > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dpt = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dpA >= 5) {
                        if (this.dpy >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dpz >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dpy >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dpy >= 100.0f && this.dpz >= getmCdnLogData().getSlowNumber()) {
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
                this.dpy -= 25.0f;
            } else {
                this.dpy -= getmCdnLogData().getSuccRank();
            }
            if (this.dpy < 0.0f) {
                this.dpy = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dpv) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dpC == null) {
            this.dpC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dpC);
        cDNUpLoadTask.execute(new Object[0]);
        this.dpv = true;
        c fH = u.fH();
        fH.p("act", "fallback");
        fH.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dpA = 0;
        this.dpz = 0;
        this.mErrorNum = 0;
        this.dpB = 0;
        this.dpy = 0.0f;
        this.dpD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String acI;
        private final int dpA;
        private final String dpH;
        private final int dpz;
        private final int mErrorNum;
        private final z mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dpz = i4;
            this.acI = str;
            this.dpH = str2;
            this.mType = i;
            this.dpA = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dpA));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.acI);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dpz));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dpH);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dpz)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dpH);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.acI);
            }
            String uB = this.mNetWork.uB();
            if (!this.mNetWork.vc() || TextUtils.isEmpty(uB)) {
                return null;
            }
            try {
                return new JSONObject(uB);
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
                    c fH = u.fH();
                    fH.p("act", "fallback");
                    fH.p("result", "1");
                    fH.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fH);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dpt + 1;
                cDNProblemUploader.dpt = i;
                if (i >= 5) {
                    CDNProblemUploader.this.aoQ.setmSwitch(false);
                    CDNProblemUploader.this.xI = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    c fH2 = u.fH();
                    fH2.p("act", "fallback");
                    fH2.p("result", "2");
                    fH2.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fH2);
                } else {
                    c fH3 = u.fH();
                    fH3.p("act", "fallback");
                    fH3.p("result", "0");
                    fH3.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fH3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.aoQ.setmSwitch(false);
                    CDNProblemUploader.this.xI = System.currentTimeMillis();
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
                CDNProblemUploader.this.dpv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dpI;

        private CdnErrorJsonData() {
            this.dpI = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dpI.length() != 0) {
                this.dpI.append(",");
            }
            this.dpI.append(i);
        }

        public void clear() {
            this.dpI.setLength(0);
        }

        public String toString() {
            return this.dpI.toString();
        }
    }
}
