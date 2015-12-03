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
import com.baidu.tbadk.core.data.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends s {
    private static Object chQ = new Object();
    private static volatile CDNProblemUploader chR;
    private f ahV;
    private int chL;
    private int chM;
    private int chN;
    private int mErrorNum;
    private Handler mHandler;
    private final int chy = 5;
    private final int chz = 0;
    private final int chA = 1;
    private final int chB = 2;
    private final int chC = 3;
    private final byte chD = 0;
    private final byte chE = 1;
    private int chF = 0;
    private final int chG = 5;
    private boolean chH = false;
    private long wT = 0;
    private final long chI = 86400000;
    private final float chJ = 100.0f;
    private float chK = 0.0f;
    private BdAsyncTaskParallel chO = null;
    private final CdnErrorJsonData chP = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (chR == null) {
            synchronized (CDNProblemUploader.class) {
                if (chR == null) {
                    chR = new CDNProblemUploader();
                }
            }
        }
        return chR;
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

    @Override // com.baidu.tbadk.core.util.s
    public f getmCdnLogData() {
        return this.ahV;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setmCdnLogData(f fVar) {
        synchronized (chQ) {
            this.ahV = fVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (chQ) {
            if (getmCdnLogData() == null) {
                this.chK += 25.0f;
            } else {
                this.chK += getmCdnLogData().getErrRank();
            }
            this.chM++;
            this.mErrorNum++;
            this.chP.add(i);
            int i3 = this.chM;
            int i4 = this.mErrorNum;
            int i5 = this.chL;
            int i6 = this.chL != 0 ? this.chN / this.chL : 0;
            String cdnErrorJsonData = this.chP.toString();
            if (getmCdnLogData() != null && this.wT > 0 && System.currentTimeMillis() - this.wT > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.chF = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.chM < 5) {
                    i2 = 0;
                } else if (this.chK < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.chL < getmCdnLogData().getSlowNumber()) {
                    if (this.chK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.chK < 100.0f || this.chL < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (chQ) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.chK += 10.0f;
                } else {
                    this.chK += getmCdnLogData().getSlowRank();
                }
                this.chL++;
                this.chN = (int) (this.chN + j);
                this.chM++;
                int i4 = this.chM;
                int i5 = this.mErrorNum;
                int i6 = this.chL;
                if (this.chL != 0) {
                    i = this.chN / this.chL;
                }
                String cdnErrorJsonData = this.chP.toString();
                if (getmCdnLogData() != null && this.wT > 0 && System.currentTimeMillis() - this.wT > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.chF = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.chM >= 5) {
                        if (this.chK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.chL >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.chK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.chK >= 100.0f && this.chL >= getmCdnLogData().getSlowNumber()) {
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
                this.chK -= 25.0f;
            } else {
                this.chK -= getmCdnLogData().getSuccRank();
            }
            if (this.chK < 0.0f) {
                this.chK = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.chH) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.chO == null) {
            this.chO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.chO);
        cDNUpLoadTask.execute(new Object[0]);
        this.chH = true;
        d he = v.he();
        he.q("act", "fallback");
        he.q("type", IntentConfig.START);
        a.hl().b("img", he);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.chM = 0;
        this.chL = 0;
        this.mErrorNum = 0;
        this.chN = 0;
        this.chK = 0.0f;
        this.chP.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String YL;
        private final int chL;
        private final int chM;
        private final String chT;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.chL = i4;
            this.YL = str;
            this.chT = str2;
            this.mType = i;
            this.chM = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ty.o("number", String.valueOf(this.chM));
            if (this.mType == 1) {
                this.Ty.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.Ty.o("error", this.YL);
                this.Ty.o("ab_num_slow", String.valueOf(this.chL));
                this.Ty.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.chT);
            } else if (this.mType == 3) {
                this.Ty.o("ab_num_slow", new StringBuilder(String.valueOf(this.chL)).toString());
                this.Ty.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.chT);
            } else if (this.mType == 2) {
                this.Ty.o("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.Ty.o("error", this.YL);
            }
            String ul = this.Ty.ul();
            if (!this.Ty.uP() || TextUtils.isEmpty(ul)) {
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
        /* renamed from: n */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d he = v.he();
                    he.q("act", "fallback");
                    he.q("result", "1");
                    he.q("type", "end");
                    a.hl().b("img", he);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.chF + 1;
                cDNProblemUploader.chF = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ahV.setmSwitch(false);
                    CDNProblemUploader.this.wT = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d he2 = v.he();
                    he2.q("act", "fallback");
                    he2.q("result", "2");
                    he2.q("type", "end");
                    a.hl().b("img", he2);
                } else {
                    d he3 = v.he();
                    he3.q("act", "fallback");
                    he3.q("result", "0");
                    he3.q("type", "end");
                    a.hl().b("img", he3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ahV.setmSwitch(false);
                    CDNProblemUploader.this.wT = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                f fVar = new f();
                fVar.parseJson(optString);
                if (fVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && fVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && fVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && fVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(fVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.chH = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer chU;

        private CdnErrorJsonData() {
            this.chU = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.chU.length() != 0) {
                this.chU.append(",");
            }
            this.chU.append(i);
        }

        public void clear() {
            this.chU.setLength(0);
        }

        public String toString() {
            return this.chU.toString();
        }
    }
}
