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
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object cqw = new Object();
    private static volatile CDNProblemUploader cqx;
    private h ajL;
    private int cqr;
    private int cqs;
    private int cqt;
    private int mErrorNum;
    private Handler mHandler;
    private final int cqe = 5;
    private final int cqf = 0;
    private final int cqg = 1;
    private final int cqh = 2;
    private final int cqi = 3;
    private final byte cqj = 0;
    private final byte cqk = 1;
    private int cql = 0;
    private final int cqm = 5;
    private boolean cqn = false;
    private long xe = 0;
    private final long cqo = 86400000;
    private final float cqp = 100.0f;
    private float cqq = 0.0f;
    private BdAsyncTaskParallel cqu = null;
    private final CdnErrorJsonData cqv = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (cqx == null) {
            synchronized (CDNProblemUploader.class) {
                if (cqx == null) {
                    cqx = new CDNProblemUploader();
                }
            }
        }
        return cqx;
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
    public h getmCdnLogData() {
        return this.ajL;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(h hVar) {
        synchronized (cqw) {
            this.ajL = hVar;
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
        synchronized (cqw) {
            if (getmCdnLogData() == null) {
                this.cqq += 25.0f;
            } else {
                this.cqq += getmCdnLogData().getErrRank();
            }
            this.cqs++;
            this.mErrorNum++;
            this.cqv.add(i);
            int i3 = this.cqs;
            int i4 = this.mErrorNum;
            int i5 = this.cqr;
            int i6 = this.cqr != 0 ? this.cqt / this.cqr : 0;
            String cdnErrorJsonData = this.cqv.toString();
            if (getmCdnLogData() != null && this.xe > 0 && System.currentTimeMillis() - this.xe > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.cql = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.cqs < 5) {
                    i2 = 0;
                } else if (this.cqq < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.cqr < getmCdnLogData().getSlowNumber()) {
                    if (this.cqq >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.cqq < 100.0f || this.cqr < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (cqw) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.cqq += 10.0f;
                } else {
                    this.cqq += getmCdnLogData().getSlowRank();
                }
                this.cqr++;
                this.cqt = (int) (this.cqt + j);
                this.cqs++;
                int i4 = this.cqs;
                int i5 = this.mErrorNum;
                int i6 = this.cqr;
                if (this.cqr != 0) {
                    i = this.cqt / this.cqr;
                }
                String cdnErrorJsonData = this.cqv.toString();
                if (getmCdnLogData() != null && this.xe > 0 && System.currentTimeMillis() - this.xe > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.cql = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.cqs >= 5) {
                        if (this.cqq >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.cqr >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.cqq >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.cqq >= 100.0f && this.cqr >= getmCdnLogData().getSlowNumber()) {
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
                this.cqq -= 25.0f;
            } else {
                this.cqq -= getmCdnLogData().getSuccRank();
            }
            if (this.cqq < 0.0f) {
                this.cqq = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.cqn) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.cqu == null) {
            this.cqu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.cqu);
        cDNUpLoadTask.execute(new Object[0]);
        this.cqn = true;
        d hm = u.hm();
        hm.r("act", "fallback");
        hm.r("type", IntentConfig.START);
        a.ht().b("img", hm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.cqs = 0;
        this.cqr = 0;
        this.mErrorNum = 0;
        this.cqt = 0;
        this.cqq = 0.0f;
        this.cqv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String ZL;
        private final int cqr;
        private final int cqs;
        private final String cqz;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.cqr = i4;
            this.ZL = str;
            this.cqz = str2;
            this.mType = i;
            this.cqs = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ty.p("number", String.valueOf(this.cqs));
            if (this.mType == 1) {
                this.Ty.p("ab_num_error", String.valueOf(this.mErrorNum));
                this.Ty.p("error", this.ZL);
                this.Ty.p("ab_num_slow", String.valueOf(this.cqr));
                this.Ty.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cqz);
            } else if (this.mType == 3) {
                this.Ty.p("ab_num_slow", new StringBuilder(String.valueOf(this.cqr)).toString());
                this.Ty.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cqz);
            } else if (this.mType == 2) {
                this.Ty.p("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.Ty.p("error", this.ZL);
            }
            String uZ = this.Ty.uZ();
            if (!this.Ty.vE() || TextUtils.isEmpty(uZ)) {
                return null;
            }
            try {
                return new JSONObject(uZ);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d hm = u.hm();
                    hm.r("act", "fallback");
                    hm.r("result", "1");
                    hm.r("type", "end");
                    a.ht().b("img", hm);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.cql + 1;
                cDNProblemUploader.cql = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ajL.setmSwitch(false);
                    CDNProblemUploader.this.xe = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d hm2 = u.hm();
                    hm2.r("act", "fallback");
                    hm2.r("result", "2");
                    hm2.r("type", "end");
                    a.ht().b("img", hm2);
                } else {
                    d hm3 = u.hm();
                    hm3.r("act", "fallback");
                    hm3.r("result", "0");
                    hm3.r("type", "end");
                    a.ht().b("img", hm3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ajL.setmSwitch(false);
                    CDNProblemUploader.this.xe = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                h hVar = new h();
                hVar.parseJson(optString);
                if (hVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && hVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && hVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && hVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(hVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.cqn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer cqA;

        private CdnErrorJsonData() {
            this.cqA = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.cqA.length() != 0) {
                this.cqA.append(",");
            }
            this.cqA.append(i);
        }

        public void clear() {
            this.cqA.setLength(0);
        }

        public String toString() {
            return this.cqA.toString();
        }
    }
}
