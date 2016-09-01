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
    private static Object dvZ = new Object();
    private static volatile CDNProblemUploader dwa;
    private k akg;
    private int dvU;
    private int dvV;
    private int dvW;
    private int mErrorNum;
    private Handler mHandler;
    private final int dvH = 5;
    private final int dvI = 0;
    private final int dvJ = 1;
    private final int dvK = 2;
    private final int dvL = 3;
    private final byte dvM = 0;
    private final byte dvN = 1;
    private int dvO = 0;
    private final int dvP = 5;
    private boolean dvQ = false;
    private long qs = 0;
    private final long dvR = 86400000;
    private final float dvS = 100.0f;
    private float dvT = 0.0f;
    private BdAsyncTaskParallel dvX = null;
    private final CdnErrorJsonData dvY = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m16getInstance() {
        if (dwa == null) {
            synchronized (CDNProblemUploader.class) {
                if (dwa == null) {
                    dwa = new CDNProblemUploader();
                }
            }
        }
        return dwa;
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
        return this.akg;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(k kVar) {
        synchronized (dvZ) {
            this.akg = kVar;
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
        synchronized (dvZ) {
            if (getmCdnLogData() == null) {
                this.dvT += 25.0f;
            } else {
                this.dvT += getmCdnLogData().getErrRank();
            }
            this.dvV++;
            this.mErrorNum++;
            this.dvY.add(i);
            int i3 = this.dvV;
            int i4 = this.mErrorNum;
            int i5 = this.dvU;
            int i6 = this.dvU != 0 ? this.dvW / this.dvU : 0;
            String cdnErrorJsonData = this.dvY.toString();
            if (getmCdnLogData() != null && this.qs > 0 && System.currentTimeMillis() - this.qs > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dvO = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dvV < 5) {
                    i2 = 0;
                } else if (this.dvT < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dvU < getmCdnLogData().getSlowNumber()) {
                    if (this.dvT >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dvT < 100.0f || this.dvU < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dvZ) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dvT += 10.0f;
                } else {
                    this.dvT += getmCdnLogData().getSlowRank();
                }
                this.dvU++;
                this.dvW = (int) (this.dvW + j);
                this.dvV++;
                int i4 = this.dvV;
                int i5 = this.mErrorNum;
                int i6 = this.dvU;
                if (this.dvU != 0) {
                    i = this.dvW / this.dvU;
                }
                String cdnErrorJsonData = this.dvY.toString();
                if (getmCdnLogData() != null && this.qs > 0 && System.currentTimeMillis() - this.qs > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dvO = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dvV >= 5) {
                        if (this.dvT >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dvU >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dvT >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dvT >= 100.0f && this.dvU >= getmCdnLogData().getSlowNumber()) {
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
                this.dvT -= 25.0f;
            } else {
                this.dvT -= getmCdnLogData().getSuccRank();
            }
            if (this.dvT < 0.0f) {
                this.dvT = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dvQ) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dvX == null) {
            this.dvX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dvX);
        cDNUpLoadTask.execute(new Object[0]);
        this.dvQ = true;
        d eB = v.eB();
        eB.q("act", "fallback");
        eB.q("type", IntentConfig.START);
        a.eI().b("img", eB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dvV = 0;
        this.dvU = 0;
        this.mErrorNum = 0;
        this.dvW = 0;
        this.dvT = 0.0f;
        this.dvY.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab NX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Yb;
        private final int dvU;
        private final int dvV;
        private final String dwc;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dvU = i4;
            this.Yb = str;
            this.dwc = str2;
            this.mType = i;
            this.dvV = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.NX.n("number", String.valueOf(this.dvV));
            if (this.mType == 1) {
                this.NX.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.NX.n("error", this.Yb);
                this.NX.n("ab_num_slow", String.valueOf(this.dvU));
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dwc);
            } else if (this.mType == 3) {
                this.NX.n("ab_num_slow", new StringBuilder(String.valueOf(this.dvU)).toString());
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dwc);
            } else if (this.mType == 2) {
                this.NX.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.NX.n("error", this.Yb);
            }
            String ue = this.NX.ue();
            if (!this.NX.uG() || TextUtils.isEmpty(ue)) {
                return null;
            }
            try {
                return new JSONObject(ue);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
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
                int i = cDNProblemUploader.dvO + 1;
                cDNProblemUploader.dvO = i;
                if (i >= 5) {
                    CDNProblemUploader.this.akg.setmSwitch(false);
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
                    CDNProblemUploader.this.akg.setmSwitch(false);
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
                CDNProblemUploader.this.dvQ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dwd;

        private CdnErrorJsonData() {
            this.dwd = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dwd.length() != 0) {
                this.dwd.append(",");
            }
            this.dwd.append(i);
        }

        public void clear() {
            this.dwd.setLength(0);
        }

        public String toString() {
            return this.dwd.toString();
        }
    }
}
