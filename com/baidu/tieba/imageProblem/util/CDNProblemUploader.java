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
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader dxA;
    private static Object dxz = new Object();
    private k ajM;
    private int dxu;
    private int dxv;
    private int dxw;
    private int mErrorNum;
    private Handler mHandler;
    private final int dxh = 5;
    private final int dxi = 0;
    private final int dxj = 1;
    private final int dxk = 2;
    private final int dxl = 3;
    private final byte dxm = 0;
    private final byte dxn = 1;
    private int dxo = 0;
    private final int dxp = 5;
    private boolean dxq = false;
    private long qs = 0;
    private final long dxr = 86400000;
    private final float dxs = 100.0f;
    private float dxt = 0.0f;
    private BdAsyncTaskParallel dxx = null;
    private final CdnErrorJsonData dxy = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m16getInstance() {
        if (dxA == null) {
            synchronized (CDNProblemUploader.class) {
                if (dxA == null) {
                    dxA = new CDNProblemUploader();
                }
            }
        }
        return dxA;
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
    public k getmCdnLogData() {
        return this.ajM;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(k kVar) {
        synchronized (dxz) {
            this.ajM = kVar;
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
        synchronized (dxz) {
            if (getmCdnLogData() == null) {
                this.dxt += 25.0f;
            } else {
                this.dxt += getmCdnLogData().getErrRank();
            }
            this.dxv++;
            this.mErrorNum++;
            this.dxy.add(i);
            int i3 = this.dxv;
            int i4 = this.mErrorNum;
            int i5 = this.dxu;
            int i6 = this.dxu != 0 ? this.dxw / this.dxu : 0;
            String cdnErrorJsonData = this.dxy.toString();
            if (getmCdnLogData() != null && this.qs > 0 && System.currentTimeMillis() - this.qs > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dxo = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dxv < 5) {
                    i2 = 0;
                } else if (this.dxt < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dxu < getmCdnLogData().getSlowNumber()) {
                    if (this.dxt >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dxt < 100.0f || this.dxu < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dxz) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dxt += 10.0f;
                } else {
                    this.dxt += getmCdnLogData().getSlowRank();
                }
                this.dxu++;
                this.dxw = (int) (this.dxw + j);
                this.dxv++;
                int i4 = this.dxv;
                int i5 = this.mErrorNum;
                int i6 = this.dxu;
                if (this.dxu != 0) {
                    i = this.dxw / this.dxu;
                }
                String cdnErrorJsonData = this.dxy.toString();
                if (getmCdnLogData() != null && this.qs > 0 && System.currentTimeMillis() - this.qs > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dxo = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dxv >= 5) {
                        if (this.dxt >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dxu >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dxt >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dxt >= 100.0f && this.dxu >= getmCdnLogData().getSlowNumber()) {
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
                this.dxt -= 25.0f;
            } else {
                this.dxt -= getmCdnLogData().getSuccRank();
            }
            if (this.dxt < 0.0f) {
                this.dxt = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dxq) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dxx == null) {
            this.dxx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dxx);
        cDNUpLoadTask.execute(new Object[0]);
        this.dxq = true;
        d eB = v.eB();
        eB.q("act", "fallback");
        eB.q("type", IntentConfig.START);
        a.eI().b("img", eB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dxv = 0;
        this.dxu = 0;
        this.mErrorNum = 0;
        this.dxw = 0;
        this.dxt = 0.0f;
        this.dxy.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab NY = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Yo;
        private final String dxC;
        private final int dxu;
        private final int dxv;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dxu = i4;
            this.Yo = str;
            this.dxC = str2;
            this.mType = i;
            this.dxv = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.NY.n("number", String.valueOf(this.dxv));
            if (this.mType == 1) {
                this.NY.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.NY.n("error", this.Yo);
                this.NY.n("ab_num_slow", String.valueOf(this.dxu));
                this.NY.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dxC);
            } else if (this.mType == 3) {
                this.NY.n("ab_num_slow", new StringBuilder(String.valueOf(this.dxu)).toString());
                this.NY.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dxC);
            } else if (this.mType == 2) {
                this.NY.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.NY.n("error", this.Yo);
            }
            String uu = this.NY.uu();
            if (!this.NY.uV() || TextUtils.isEmpty(uu)) {
                return null;
            }
            try {
                return new JSONObject(uu);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d eB = v.eB();
                    eB.q("act", "fallback");
                    eB.q("result", "1");
                    eB.q("type", "end");
                    a.eI().b("img", eB);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dxo + 1;
                cDNProblemUploader.dxo = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ajM.setmSwitch(false);
                    CDNProblemUploader.this.qs = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d eB2 = v.eB();
                    eB2.q("act", "fallback");
                    eB2.q("result", "2");
                    eB2.q("type", "end");
                    a.eI().b("img", eB2);
                } else {
                    d eB3 = v.eB();
                    eB3.q("act", "fallback");
                    eB3.q("result", "0");
                    eB3.q("type", "end");
                    a.eI().b("img", eB3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ajM.setmSwitch(false);
                    CDNProblemUploader.this.qs = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                k kVar = new k();
                kVar.parseJson(optString);
                if (kVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && kVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && kVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && kVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(kVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dxq = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dxD;

        private CdnErrorJsonData() {
            this.dxD = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dxD.length() != 0) {
                this.dxD.append(",");
            }
            this.dxD.append(i);
        }

        public void clear() {
            this.dxD.setLength(0);
        }

        public String toString() {
            return this.dxD.toString();
        }
    }
}
