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
    private static Object cBW = new Object();
    private static volatile CDNProblemUploader cBX;
    private j afN;
    private int cBR;
    private int cBS;
    private int cBT;
    private int mErrorNum;
    private Handler mHandler;
    private final int cBE = 5;
    private final int cBF = 0;
    private final int cBG = 1;
    private final int cBH = 2;
    private final int cBI = 3;
    private final byte cBJ = 0;
    private final byte cBK = 1;
    private int cBL = 0;
    private final int cBM = 5;
    private boolean cBN = false;
    private long nv = 0;
    private final long cBO = 86400000;
    private final float cBP = 100.0f;
    private float cBQ = 0.0f;
    private BdAsyncTaskParallel cBU = null;
    private final CdnErrorJsonData cBV = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m20getInstance() {
        if (cBX == null) {
            synchronized (CDNProblemUploader.class) {
                if (cBX == null) {
                    cBX = new CDNProblemUploader();
                }
            }
        }
        return cBX;
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
        return this.afN;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(j jVar) {
        synchronized (cBW) {
            this.afN = jVar;
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
        synchronized (cBW) {
            if (getmCdnLogData() == null) {
                this.cBQ += 25.0f;
            } else {
                this.cBQ += getmCdnLogData().getErrRank();
            }
            this.cBS++;
            this.mErrorNum++;
            this.cBV.add(i);
            int i3 = this.cBS;
            int i4 = this.mErrorNum;
            int i5 = this.cBR;
            int i6 = this.cBR != 0 ? this.cBT / this.cBR : 0;
            String cdnErrorJsonData = this.cBV.toString();
            if (getmCdnLogData() != null && this.nv > 0 && System.currentTimeMillis() - this.nv > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.cBL = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.cBS < 5) {
                    i2 = 0;
                } else if (this.cBQ < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.cBR < getmCdnLogData().getSlowNumber()) {
                    if (this.cBQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.cBQ < 100.0f || this.cBR < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (cBW) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.cBQ += 10.0f;
                } else {
                    this.cBQ += getmCdnLogData().getSlowRank();
                }
                this.cBR++;
                this.cBT = (int) (this.cBT + j);
                this.cBS++;
                int i4 = this.cBS;
                int i5 = this.mErrorNum;
                int i6 = this.cBR;
                if (this.cBR != 0) {
                    i = this.cBT / this.cBR;
                }
                String cdnErrorJsonData = this.cBV.toString();
                if (getmCdnLogData() != null && this.nv > 0 && System.currentTimeMillis() - this.nv > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.cBL = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.cBS >= 5) {
                        if (this.cBQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.cBR >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.cBQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.cBQ >= 100.0f && this.cBR >= getmCdnLogData().getSlowNumber()) {
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
                this.cBQ -= 25.0f;
            } else {
                this.cBQ -= getmCdnLogData().getSuccRank();
            }
            if (this.cBQ < 0.0f) {
                this.cBQ = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.cBN) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.cBU == null) {
            this.cBU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.cBU);
        cDNUpLoadTask.execute(new Object[0]);
        this.cBN = true;
        d dG = v.dG();
        dG.q("act", "fallback");
        dG.q("type", IntentConfig.START);
        a.dN().b("img", dG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.cBS = 0;
        this.cBR = 0;
        this.mErrorNum = 0;
        this.cBT = 0;
        this.cBQ = 0.0f;
        this.cBV.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab LL = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Un;
        private final int cBR;
        private final int cBS;
        private final String cBZ;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.cBR = i4;
            this.Un = str;
            this.cBZ = str2;
            this.mType = i;
            this.cBS = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.LL.n("number", String.valueOf(this.cBS));
            if (this.mType == 1) {
                this.LL.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.LL.n("error", this.Un);
                this.LL.n("ab_num_slow", String.valueOf(this.cBR));
                this.LL.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cBZ);
            } else if (this.mType == 3) {
                this.LL.n("ab_num_slow", new StringBuilder(String.valueOf(this.cBR)).toString());
                this.LL.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.cBZ);
            } else if (this.mType == 2) {
                this.LL.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.LL.n("error", this.Un);
            }
            String tc = this.LL.tc();
            if (!this.LL.tD() || TextUtils.isEmpty(tc)) {
                return null;
            }
            try {
                return new JSONObject(tc);
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
                    d dG = v.dG();
                    dG.q("act", "fallback");
                    dG.q("result", "1");
                    dG.q("type", "end");
                    a.dN().b("img", dG);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.cBL + 1;
                cDNProblemUploader.cBL = i;
                if (i >= 5) {
                    CDNProblemUploader.this.afN.setmSwitch(false);
                    CDNProblemUploader.this.nv = System.currentTimeMillis();
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
                    CDNProblemUploader.this.afN.setmSwitch(false);
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
                CDNProblemUploader.this.cBN = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer cCa;

        private CdnErrorJsonData() {
            this.cCa = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.cCa.length() != 0) {
                this.cCa.append(",");
            }
            this.cCa.append(i);
        }

        public void clear() {
            this.cCa.setLength(0);
        }

        public String toString() {
            return this.cCa.toString();
        }
    }
}
