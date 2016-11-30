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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object dDd = new Object();
    private static volatile CDNProblemUploader dDe;
    private l akE;
    private int dCY;
    private int dCZ;
    private int dDa;
    private int mErrorNum;
    private Handler mHandler;
    private final int dCL = 5;
    private final int dCM = 0;
    private final int dCN = 1;
    private final int dCO = 2;
    private final int dCP = 3;
    private final byte dCQ = 0;
    private final byte dCR = 1;
    private int dCS = 0;
    private final int dCT = 5;
    private boolean dCU = false;
    private long qt = 0;
    private final long dCV = 86400000;
    private final float dCW = 100.0f;
    private float dCX = 0.0f;
    private BdAsyncTaskParallel dDb = null;
    private final CdnErrorJsonData dDc = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m16getInstance() {
        if (dDe == null) {
            synchronized (CDNProblemUploader.class) {
                if (dDe == null) {
                    dDe = new CDNProblemUploader();
                }
            }
        }
        return dDe;
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
        return this.akE;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dDd) {
            this.akE = lVar;
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
        synchronized (dDd) {
            if (getmCdnLogData() == null) {
                this.dCX += 25.0f;
            } else {
                this.dCX += getmCdnLogData().getErrRank();
            }
            this.dCZ++;
            this.mErrorNum++;
            this.dDc.add(i);
            int i3 = this.dCZ;
            int i4 = this.mErrorNum;
            int i5 = this.dCY;
            int i6 = this.dCY != 0 ? this.dDa / this.dCY : 0;
            String cdnErrorJsonData = this.dDc.toString();
            if (getmCdnLogData() != null && this.qt > 0 && System.currentTimeMillis() - this.qt > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dCS = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dCZ < 5) {
                    i2 = 0;
                } else if (this.dCX < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dCY < getmCdnLogData().getSlowNumber()) {
                    if (this.dCX >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dCX < 100.0f || this.dCY < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dDd) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dCX += 10.0f;
                } else {
                    this.dCX += getmCdnLogData().getSlowRank();
                }
                this.dCY++;
                this.dDa = (int) (this.dDa + j);
                this.dCZ++;
                int i4 = this.dCZ;
                int i5 = this.mErrorNum;
                int i6 = this.dCY;
                if (this.dCY != 0) {
                    i = this.dDa / this.dCY;
                }
                String cdnErrorJsonData = this.dDc.toString();
                if (getmCdnLogData() != null && this.qt > 0 && System.currentTimeMillis() - this.qt > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dCS = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dCZ >= 5) {
                        if (this.dCX >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dCY >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dCX >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dCX >= 100.0f && this.dCY >= getmCdnLogData().getSlowNumber()) {
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
                this.dCX -= 25.0f;
            } else {
                this.dCX -= getmCdnLogData().getSuccRank();
            }
            if (this.dCX < 0.0f) {
                this.dCX = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dCU) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dDb == null) {
            this.dDb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dDb);
        cDNUpLoadTask.execute(new Object[0]);
        this.dCU = true;
        d eB = u.eB();
        eB.q("act", "fallback");
        eB.q("type", IntentConfig.START);
        a.eI().b("img", eB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dCZ = 0;
        this.dCY = 0;
        this.mErrorNum = 0;
        this.dDa = 0;
        this.dCX = 0.0f;
        this.dDc.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final z Ob = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String YM;
        private final int dCY;
        private final int dCZ;
        private final String dDg;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dCY = i4;
            this.YM = str;
            this.dDg = str2;
            this.mType = i;
            this.dCZ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ob.n("number", String.valueOf(this.dCZ));
            if (this.mType == 1) {
                this.Ob.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.Ob.n("error", this.YM);
                this.Ob.n("ab_num_slow", String.valueOf(this.dCY));
                this.Ob.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dDg);
            } else if (this.mType == 3) {
                this.Ob.n("ab_num_slow", new StringBuilder(String.valueOf(this.dCY)).toString());
                this.Ob.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dDg);
            } else if (this.mType == 2) {
                this.Ob.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.Ob.n("error", this.YM);
            }
            String uy = this.Ob.uy();
            if (!this.Ob.uZ() || TextUtils.isEmpty(uy)) {
                return null;
            }
            try {
                return new JSONObject(uy);
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
                    d eB = u.eB();
                    eB.q("act", "fallback");
                    eB.q("result", "1");
                    eB.q("type", "end");
                    a.eI().b("img", eB);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dCS + 1;
                cDNProblemUploader.dCS = i;
                if (i >= 5) {
                    CDNProblemUploader.this.akE.setmSwitch(false);
                    CDNProblemUploader.this.qt = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d eB2 = u.eB();
                    eB2.q("act", "fallback");
                    eB2.q("result", "2");
                    eB2.q("type", "end");
                    a.eI().b("img", eB2);
                } else {
                    d eB3 = u.eB();
                    eB3.q("act", "fallback");
                    eB3.q("result", "0");
                    eB3.q("type", "end");
                    a.eI().b("img", eB3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.akE.setmSwitch(false);
                    CDNProblemUploader.this.qt = System.currentTimeMillis();
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
                CDNProblemUploader.this.dCU = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dDh;

        private CdnErrorJsonData() {
            this.dDh = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dDh.length() != 0) {
                this.dDh.append(",");
            }
            this.dDh.append(i);
        }

        public void clear() {
            this.dDh.setLength(0);
        }

        public String toString() {
            return this.dDh.toString();
        }
    }
}
