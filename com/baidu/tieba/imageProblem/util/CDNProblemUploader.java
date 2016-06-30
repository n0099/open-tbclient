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
    private static Object dht = new Object();
    private static volatile CDNProblemUploader dhu;
    private j agr;
    private int dho;
    private int dhp;
    private int dhq;
    private int mErrorNum;
    private Handler mHandler;
    private final int dhb = 5;
    private final int dhc = 0;
    private final int dhd = 1;
    private final int dhe = 2;
    private final int dhf = 3;
    private final byte dhg = 0;
    private final byte dhh = 1;
    private int dhi = 0;
    private final int dhj = 5;
    private boolean dhk = false;
    private long nv = 0;
    private final long dhl = 86400000;
    private final float dhm = 100.0f;
    private float dhn = 0.0f;
    private BdAsyncTaskParallel dhr = null;
    private final CdnErrorJsonData dhs = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m14getInstance() {
        if (dhu == null) {
            synchronized (CDNProblemUploader.class) {
                if (dhu == null) {
                    dhu = new CDNProblemUploader();
                }
            }
        }
        return dhu;
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
        return this.agr;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(j jVar) {
        synchronized (dht) {
            this.agr = jVar;
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
        synchronized (dht) {
            if (getmCdnLogData() == null) {
                this.dhn += 25.0f;
            } else {
                this.dhn += getmCdnLogData().getErrRank();
            }
            this.dhp++;
            this.mErrorNum++;
            this.dhs.add(i);
            int i3 = this.dhp;
            int i4 = this.mErrorNum;
            int i5 = this.dho;
            int i6 = this.dho != 0 ? this.dhq / this.dho : 0;
            String cdnErrorJsonData = this.dhs.toString();
            if (getmCdnLogData() != null && this.nv > 0 && System.currentTimeMillis() - this.nv > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dhi = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dhp < 5) {
                    i2 = 0;
                } else if (this.dhn < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dho < getmCdnLogData().getSlowNumber()) {
                    if (this.dhn >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dhn < 100.0f || this.dho < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dht) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dhn += 10.0f;
                } else {
                    this.dhn += getmCdnLogData().getSlowRank();
                }
                this.dho++;
                this.dhq = (int) (this.dhq + j);
                this.dhp++;
                int i4 = this.dhp;
                int i5 = this.mErrorNum;
                int i6 = this.dho;
                if (this.dho != 0) {
                    i = this.dhq / this.dho;
                }
                String cdnErrorJsonData = this.dhs.toString();
                if (getmCdnLogData() != null && this.nv > 0 && System.currentTimeMillis() - this.nv > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dhi = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dhp >= 5) {
                        if (this.dhn >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dho >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dhn >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dhn >= 100.0f && this.dho >= getmCdnLogData().getSlowNumber()) {
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
                this.dhn -= 25.0f;
            } else {
                this.dhn -= getmCdnLogData().getSuccRank();
            }
            if (this.dhn < 0.0f) {
                this.dhn = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dhk) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dhr == null) {
            this.dhr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dhr);
        cDNUpLoadTask.execute(new Object[0]);
        this.dhk = true;
        d dH = v.dH();
        dH.q("act", "fallback");
        dH.q("type", IntentConfig.START);
        a.dO().b("img", dH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dhp = 0;
        this.dho = 0;
        this.mErrorNum = 0;
        this.dhq = 0;
        this.dhn = 0.0f;
        this.dhs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab LK = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String UE;
        private final int dho;
        private final int dhp;
        private final String dhw;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dho = i4;
            this.UE = str;
            this.dhw = str2;
            this.mType = i;
            this.dhp = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.LK.n("number", String.valueOf(this.dhp));
            if (this.mType == 1) {
                this.LK.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.LK.n("error", this.UE);
                this.LK.n("ab_num_slow", String.valueOf(this.dho));
                this.LK.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dhw);
            } else if (this.mType == 3) {
                this.LK.n("ab_num_slow", new StringBuilder(String.valueOf(this.dho)).toString());
                this.LK.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dhw);
            } else if (this.mType == 2) {
                this.LK.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.LK.n("error", this.UE);
            }
            String ta = this.LK.ta();
            if (!this.LK.tB() || TextUtils.isEmpty(ta)) {
                return null;
            }
            try {
                return new JSONObject(ta);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d dH = v.dH();
                    dH.q("act", "fallback");
                    dH.q("result", "1");
                    dH.q("type", "end");
                    a.dO().b("img", dH);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dhi + 1;
                cDNProblemUploader.dhi = i;
                if (i >= 5) {
                    CDNProblemUploader.this.agr.setmSwitch(false);
                    CDNProblemUploader.this.nv = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d dH2 = v.dH();
                    dH2.q("act", "fallback");
                    dH2.q("result", "2");
                    dH2.q("type", "end");
                    a.dO().b("img", dH2);
                } else {
                    d dH3 = v.dH();
                    dH3.q("act", "fallback");
                    dH3.q("result", "0");
                    dH3.q("type", "end");
                    a.dO().b("img", dH3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.agr.setmSwitch(false);
                    CDNProblemUploader.this.nv = System.currentTimeMillis();
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
                CDNProblemUploader.this.dhk = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dhx;

        private CdnErrorJsonData() {
            this.dhx = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dhx.length() != 0) {
                this.dhx.append(",");
            }
            this.dhx.append(i);
        }

        public void clear() {
            this.dhx.setLength(0);
        }

        public String toString() {
            return this.dhx.toString();
        }
    }
}
