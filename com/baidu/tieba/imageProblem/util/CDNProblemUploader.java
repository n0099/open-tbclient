package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object ePQ = new Object();
    private static volatile CDNProblemUploader ePR;
    private k bfB;
    private int ePL;
    private int ePM;
    private int ePN;
    private int mErrorNum;
    private Handler mHandler;
    private final int ePy = 5;
    private final int ePz = 0;
    private final int ePA = 1;
    private final int ePB = 2;
    private final int ePC = 3;
    private final byte ePD = 0;
    private final byte ePE = 1;
    private int ePF = 0;
    private final int ePG = 5;
    private boolean ePH = false;
    private long akV = 0;
    private final long ePI = 86400000;
    private final float ePJ = 100.0f;
    private float ePK = 0.0f;
    private BdAsyncTaskParallel ePO = null;
    private final CdnErrorJsonData ePP = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.ePF + 1;
        cDNProblemUploader.ePF = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (ePR == null) {
            synchronized (CDNProblemUploader.class) {
                if (ePR == null) {
                    ePR = new CDNProblemUploader();
                }
            }
        }
        return ePR;
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

    @Override // com.baidu.tbadk.core.util.p
    public k getmCdnLogData() {
        return this.bfB;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (ePQ) {
            this.bfB = kVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.p
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (ePQ) {
            if (getmCdnLogData() == null) {
                this.ePK += 25.0f;
            } else {
                this.ePK += getmCdnLogData().getErrRank();
            }
            this.ePM++;
            this.mErrorNum++;
            this.ePP.add(i);
            int i3 = this.ePM;
            int i4 = this.mErrorNum;
            int i5 = this.ePL;
            int i6 = this.ePL != 0 ? this.ePN / this.ePL : 0;
            String cdnErrorJsonData = this.ePP.toString();
            if (getmCdnLogData() != null && this.akV > 0 && System.currentTimeMillis() - this.akV > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.ePF = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.ePM < 5) {
                    i2 = 0;
                } else if (this.ePK < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.ePL < getmCdnLogData().getSlowNumber()) {
                    if (this.ePK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.ePK < 100.0f || this.ePL < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (ePQ) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.ePK += 10.0f;
                } else {
                    this.ePK += getmCdnLogData().getSlowRank();
                }
                this.ePL++;
                this.ePN = (int) (this.ePN + j);
                this.ePM++;
                int i4 = this.ePM;
                int i5 = this.mErrorNum;
                int i6 = this.ePL;
                if (this.ePL != 0) {
                    i = this.ePN / this.ePL;
                }
                String cdnErrorJsonData = this.ePP.toString();
                if (getmCdnLogData() != null && this.akV > 0 && System.currentTimeMillis() - this.akV > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.ePF = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.ePM >= 5) {
                        if (this.ePK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.ePL >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.ePK >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.ePK >= 100.0f && this.ePL >= getmCdnLogData().getSlowNumber()) {
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
                this.ePK -= 25.0f;
            } else {
                this.ePK -= getmCdnLogData().getSuccRank();
            }
            if (this.ePK < 0.0f) {
                this.ePK = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.ePH) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.ePO == null) {
            this.ePO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.ePO);
        cDNUpLoadTask.execute(new Object[0]);
        this.ePH = true;
        a nm = s.nm();
        nm.append("act", "fallback");
        nm.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", nm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.ePM = 0;
        this.ePL = 0;
        this.mErrorNum = 0;
        this.ePN = 0;
        this.ePK = 0.0f;
        this.ePP.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aSr;
        private final int ePL;
        private final int ePM;
        private final String ePT;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.ePL = i4;
            this.aSr = str;
            this.ePT = str2;
            this.mType = i;
            this.ePM = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.ePM));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aSr);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.ePL));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.ePT);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.ePL + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.ePT);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aSr);
            }
            String BP = this.mNetWork.BP();
            if (!this.mNetWork.Cq() || TextUtils.isEmpty(BP)) {
                return null;
            }
            try {
                return new JSONObject(BP);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a nm = s.nm();
                    nm.append("act", "fallback");
                    nm.append("result", "1");
                    nm.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", nm);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.bfB.setmSwitch(false);
                    CDNProblemUploader.this.akV = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a nm2 = s.nm();
                        nm2.append("act", "fallback");
                        nm2.append("result", "2");
                        nm2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nm2);
                    } else {
                        a nm3 = s.nm();
                        nm3.append("act", "fallback");
                        nm3.append("result", "0");
                        nm3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nm3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.bfB.setmSwitch(false);
                        CDNProblemUploader.this.akV = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    k kVar = new k();
                    kVar.parseJson(optString);
                    if (kVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && kVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && kVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && kVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(kVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.ePH = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer ePU;

        private CdnErrorJsonData() {
            this.ePU = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.ePU.length() != 0) {
                this.ePU.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.ePU.append(i);
        }

        public void clear() {
            this.ePU.setLength(0);
        }

        public String toString() {
            return this.ePU.toString();
        }
    }
}
