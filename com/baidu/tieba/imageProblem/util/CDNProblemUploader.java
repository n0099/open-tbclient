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
    private static Object dkr = new Object();
    private static volatile CDNProblemUploader dks;
    private k ahf;
    private int dkm;
    private int dkn;
    private int dko;
    private int mErrorNum;
    private Handler mHandler;
    private final int djZ = 5;
    private final int dka = 0;
    private final int dkb = 1;
    private final int dkc = 2;
    private final int dkd = 3;
    private final byte dke = 0;
    private final byte dkf = 1;
    private int dkg = 0;
    private final int dkh = 5;
    private boolean dki = false;
    private long nX = 0;
    private final long dkj = 86400000;
    private final float dkk = 100.0f;
    private float dkl = 0.0f;
    private BdAsyncTaskParallel dkp = null;
    private final CdnErrorJsonData dkq = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m18getInstance() {
        if (dks == null) {
            synchronized (CDNProblemUploader.class) {
                if (dks == null) {
                    dks = new CDNProblemUploader();
                }
            }
        }
        return dks;
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
        return this.ahf;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(k kVar) {
        synchronized (dkr) {
            this.ahf = kVar;
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
        synchronized (dkr) {
            if (getmCdnLogData() == null) {
                this.dkl += 25.0f;
            } else {
                this.dkl += getmCdnLogData().getErrRank();
            }
            this.dkn++;
            this.mErrorNum++;
            this.dkq.add(i);
            int i3 = this.dkn;
            int i4 = this.mErrorNum;
            int i5 = this.dkm;
            int i6 = this.dkm != 0 ? this.dko / this.dkm : 0;
            String cdnErrorJsonData = this.dkq.toString();
            if (getmCdnLogData() != null && this.nX > 0 && System.currentTimeMillis() - this.nX > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dkg = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dkn < 5) {
                    i2 = 0;
                } else if (this.dkl < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dkm < getmCdnLogData().getSlowNumber()) {
                    if (this.dkl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dkl < 100.0f || this.dkm < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dkr) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dkl += 10.0f;
                } else {
                    this.dkl += getmCdnLogData().getSlowRank();
                }
                this.dkm++;
                this.dko = (int) (this.dko + j);
                this.dkn++;
                int i4 = this.dkn;
                int i5 = this.mErrorNum;
                int i6 = this.dkm;
                if (this.dkm != 0) {
                    i = this.dko / this.dkm;
                }
                String cdnErrorJsonData = this.dkq.toString();
                if (getmCdnLogData() != null && this.nX > 0 && System.currentTimeMillis() - this.nX > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dkg = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dkn >= 5) {
                        if (this.dkl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dkm >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dkl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dkl >= 100.0f && this.dkm >= getmCdnLogData().getSlowNumber()) {
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
                this.dkl -= 25.0f;
            } else {
                this.dkl -= getmCdnLogData().getSuccRank();
            }
            if (this.dkl < 0.0f) {
                this.dkl = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dki) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dkp == null) {
            this.dkp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dkp);
        cDNUpLoadTask.execute(new Object[0]);
        this.dki = true;
        d dG = v.dG();
        dG.q("act", "fallback");
        dG.q("type", IntentConfig.START);
        a.dN().b("img", dG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dkn = 0;
        this.dkm = 0;
        this.mErrorNum = 0;
        this.dko = 0;
        this.dkl = 0.0f;
        this.dkq.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab LI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Vo;
        private final int dkm;
        private final int dkn;
        private final String dku;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dkm = i4;
            this.Vo = str;
            this.dku = str2;
            this.mType = i;
            this.dkn = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.LI.n("number", String.valueOf(this.dkn));
            if (this.mType == 1) {
                this.LI.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.LI.n("error", this.Vo);
                this.LI.n("ab_num_slow", String.valueOf(this.dkm));
                this.LI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dku);
            } else if (this.mType == 3) {
                this.LI.n("ab_num_slow", new StringBuilder(String.valueOf(this.dkm)).toString());
                this.LI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dku);
            } else if (this.mType == 2) {
                this.LI.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.LI.n("error", this.Vo);
            }
            String sZ = this.LI.sZ();
            if (!this.LI.tA() || TextUtils.isEmpty(sZ)) {
                return null;
            }
            try {
                return new JSONObject(sZ);
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
                    d dG = v.dG();
                    dG.q("act", "fallback");
                    dG.q("result", "1");
                    dG.q("type", "end");
                    a.dN().b("img", dG);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dkg + 1;
                cDNProblemUploader.dkg = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ahf.setmSwitch(false);
                    CDNProblemUploader.this.nX = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d dG2 = v.dG();
                    dG2.q("act", "fallback");
                    dG2.q("result", "2");
                    dG2.q("type", "end");
                    a.dN().b("img", dG2);
                } else {
                    d dG3 = v.dG();
                    dG3.q("act", "fallback");
                    dG3.q("result", "0");
                    dG3.q("type", "end");
                    a.dN().b("img", dG3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ahf.setmSwitch(false);
                    CDNProblemUploader.this.nX = System.currentTimeMillis();
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
                CDNProblemUploader.this.dki = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dkv;

        private CdnErrorJsonData() {
            this.dkv = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dkv.length() != 0) {
                this.dkv.append(",");
            }
            this.dkv.append(i);
        }

        public void clear() {
            this.dkv.setLength(0);
        }

        public String toString() {
            return this.dkv.toString();
        }
    }
}
