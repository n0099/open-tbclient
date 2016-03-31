package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object cAW = new Object();
    private static volatile CDNProblemUploader cAX;
    private j akb;
    private int cAR;
    private int cAS;
    private int cAT;
    private int mErrorNum;
    private Handler mHandler;
    private final int cAE = 5;
    private final int cAF = 0;
    private final int cAG = 1;
    private final int cAH = 2;
    private final int cAI = 3;
    private final byte cAJ = 0;
    private final byte cAK = 1;
    private int cAL = 0;
    private final int cAM = 5;
    private boolean cAN = false;
    private long xv = 0;
    private final long cAO = 86400000;
    private final float cAP = 100.0f;
    private float cAQ = 0.0f;
    private BdAsyncTaskParallel cAU = null;
    private final CdnErrorJsonData cAV = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (cAX == null) {
            synchronized (CDNProblemUploader.class) {
                if (cAX == null) {
                    cAX = new CDNProblemUploader();
                }
            }
        }
        return cAX;
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
    public j getmCdnLogData() {
        return this.akb;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(j jVar) {
        synchronized (cAW) {
            this.akb = jVar;
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
        synchronized (cAW) {
            if (getmCdnLogData() == null) {
                this.cAQ += 25.0f;
            } else {
                this.cAQ += getmCdnLogData().getErrRank();
            }
            this.cAS++;
            this.mErrorNum++;
            this.cAV.add(i);
            int i3 = this.cAS;
            int i4 = this.mErrorNum;
            int i5 = this.cAR;
            int i6 = this.cAR != 0 ? this.cAT / this.cAR : 0;
            String cdnErrorJsonData = this.cAV.toString();
            if (getmCdnLogData() != null && this.xv > 0 && System.currentTimeMillis() - this.xv > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.cAL = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.cAS < 5) {
                    i2 = 0;
                } else if (this.cAQ < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.cAR < getmCdnLogData().getSlowNumber()) {
                    if (this.cAQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.cAQ < 100.0f || this.cAR < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (cAW) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.cAQ += 10.0f;
                } else {
                    this.cAQ += getmCdnLogData().getSlowRank();
                }
                this.cAR++;
                this.cAT = (int) (this.cAT + j);
                this.cAS++;
                int i4 = this.cAS;
                int i5 = this.mErrorNum;
                int i6 = this.cAR;
                if (this.cAR != 0) {
                    i = this.cAT / this.cAR;
                }
                String cdnErrorJsonData = this.cAV.toString();
                if (getmCdnLogData() != null && this.xv > 0 && System.currentTimeMillis() - this.xv > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.cAL = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.cAS >= 5) {
                        if (this.cAQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.cAR >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.cAQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.cAQ >= 100.0f && this.cAR >= getmCdnLogData().getSlowNumber()) {
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
                this.cAQ -= 25.0f;
            } else {
                this.cAQ -= getmCdnLogData().getSuccRank();
            }
            if (this.cAQ < 0.0f) {
                this.cAQ = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.cAN) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.cAU == null) {
            this.cAU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.cAU);
        cDNUpLoadTask.execute(new Object[0]);
        this.cAN = true;
        d hs = v.hs();
        hs.r("act", "fallback");
        hs.r("type", IntentConfig.START);
        a.hz().b("img", hs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.cAS = 0;
        this.cAR = 0;
        this.mErrorNum = 0;
        this.cAT = 0;
        this.cAQ = 0.0f;
        this.cAV.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String YX;
        private final int cAR;
        private final int cAS;
        private final String cAZ;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.cAR = i4;
            this.YX = str;
            this.cAZ = str2;
            this.mType = i;
            this.cAS = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.QV.p("number", String.valueOf(this.cAS));
            if (this.mType == 1) {
                this.QV.p("ab_num_error", String.valueOf(this.mErrorNum));
                this.QV.p("error", this.YX);
                this.QV.p("ab_num_slow", String.valueOf(this.cAR));
                this.QV.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cAZ);
            } else if (this.mType == 3) {
                this.QV.p("ab_num_slow", new StringBuilder(String.valueOf(this.cAR)).toString());
                this.QV.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cAZ);
            } else if (this.mType == 2) {
                this.QV.p("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.QV.p("error", this.YX);
            }
            String vw = this.QV.vw();
            if (!this.QV.vX() || TextUtils.isEmpty(vw)) {
                return null;
            }
            try {
                return new JSONObject(vw);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d hs = v.hs();
                    hs.r("act", "fallback");
                    hs.r("result", "1");
                    hs.r("type", "end");
                    a.hz().b("img", hs);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.cAL + 1;
                cDNProblemUploader.cAL = i;
                if (i >= 5) {
                    CDNProblemUploader.this.akb.setmSwitch(false);
                    CDNProblemUploader.this.xv = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d hs2 = v.hs();
                    hs2.r("act", "fallback");
                    hs2.r("result", "2");
                    hs2.r("type", "end");
                    a.hz().b("img", hs2);
                } else {
                    d hs3 = v.hs();
                    hs3.r("act", "fallback");
                    hs3.r("result", "0");
                    hs3.r("type", "end");
                    a.hz().b("img", hs3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.akb.setmSwitch(false);
                    CDNProblemUploader.this.xv = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                j jVar = new j();
                jVar.parseJson(optString);
                if (jVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && jVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && jVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && jVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(jVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.cAN = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer cBa;

        private CdnErrorJsonData() {
            this.cBa = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.cBa.length() != 0) {
                this.cBa.append(",");
            }
            this.cBa.append(i);
        }

        public void clear() {
            this.cBa.setLength(0);
        }

        public String toString() {
            return this.cBa.toString();
        }
    }
}
