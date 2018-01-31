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
    private static Object eRL = new Object();
    private static volatile CDNProblemUploader eRM;
    private k bfP;
    private int eRG;
    private int eRH;
    private int eRI;
    private int mErrorNum;
    private Handler mHandler;
    private final int eRt = 5;
    private final int eRu = 0;
    private final int eRv = 1;
    private final int eRw = 2;
    private final int eRx = 3;
    private final byte eRy = 0;
    private final byte eRz = 1;
    private int eRA = 0;
    private final int eRB = 5;
    private boolean eRC = false;
    private long akY = 0;
    private final long eRD = 86400000;
    private final float eRE = 100.0f;
    private float eRF = 0.0f;
    private BdAsyncTaskParallel eRJ = null;
    private final CdnErrorJsonData eRK = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eRA + 1;
        cDNProblemUploader.eRA = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eRM == null) {
            synchronized (CDNProblemUploader.class) {
                if (eRM == null) {
                    eRM = new CDNProblemUploader();
                }
            }
        }
        return eRM;
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
        return this.bfP;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (eRL) {
            this.bfP = kVar;
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
        synchronized (eRL) {
            if (getmCdnLogData() == null) {
                this.eRF += 25.0f;
            } else {
                this.eRF += getmCdnLogData().getErrRank();
            }
            this.eRH++;
            this.mErrorNum++;
            this.eRK.add(i);
            int i3 = this.eRH;
            int i4 = this.mErrorNum;
            int i5 = this.eRG;
            int i6 = this.eRG != 0 ? this.eRI / this.eRG : 0;
            String cdnErrorJsonData = this.eRK.toString();
            if (getmCdnLogData() != null && this.akY > 0 && System.currentTimeMillis() - this.akY > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eRA = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eRH < 5) {
                    i2 = 0;
                } else if (this.eRF < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eRG < getmCdnLogData().getSlowNumber()) {
                    if (this.eRF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eRF < 100.0f || this.eRG < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eRL) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eRF += 10.0f;
                } else {
                    this.eRF += getmCdnLogData().getSlowRank();
                }
                this.eRG++;
                this.eRI = (int) (this.eRI + j);
                this.eRH++;
                int i4 = this.eRH;
                int i5 = this.mErrorNum;
                int i6 = this.eRG;
                if (this.eRG != 0) {
                    i = this.eRI / this.eRG;
                }
                String cdnErrorJsonData = this.eRK.toString();
                if (getmCdnLogData() != null && this.akY > 0 && System.currentTimeMillis() - this.akY > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eRA = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eRH >= 5) {
                        if (this.eRF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eRG >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eRF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eRF >= 100.0f && this.eRG >= getmCdnLogData().getSlowNumber()) {
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
                this.eRF -= 25.0f;
            } else {
                this.eRF -= getmCdnLogData().getSuccRank();
            }
            if (this.eRF < 0.0f) {
                this.eRF = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eRC) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eRJ == null) {
            this.eRJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eRJ);
        cDNUpLoadTask.execute(new Object[0]);
        this.eRC = true;
        a nn = s.nn();
        nn.append("act", "fallback");
        nn.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eRH = 0;
        this.eRG = 0;
        this.mErrorNum = 0;
        this.eRI = 0;
        this.eRF = 0.0f;
        this.eRK.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aSt;
        private final int eRG;
        private final int eRH;
        private final String eRO;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eRG = i4;
            this.aSt = str;
            this.eRO = str2;
            this.mType = i;
            this.eRH = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.eRH));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aSt);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.eRG));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eRO);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.eRG + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eRO);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aSt);
            }
            String BI = this.mNetWork.BI();
            if (!this.mNetWork.Cj() || TextUtils.isEmpty(BI)) {
                return null;
            }
            try {
                return new JSONObject(BI);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a nn = s.nn();
                    nn.append("act", "fallback");
                    nn.append("result", "1");
                    nn.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", nn);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.bfP.setmSwitch(false);
                    CDNProblemUploader.this.akY = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a nn2 = s.nn();
                        nn2.append("act", "fallback");
                        nn2.append("result", "2");
                        nn2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn2);
                    } else {
                        a nn3 = s.nn();
                        nn3.append("act", "fallback");
                        nn3.append("result", "0");
                        nn3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.bfP.setmSwitch(false);
                        CDNProblemUploader.this.akY = System.currentTimeMillis();
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
                CDNProblemUploader.this.eRC = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eRP;

        private CdnErrorJsonData() {
            this.eRP = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eRP.length() != 0) {
                this.eRP.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.eRP.append(i);
        }

        public void clear() {
            this.eRP.setLength(0);
        }

        public String toString() {
            return this.eRP.toString();
        }
    }
}
