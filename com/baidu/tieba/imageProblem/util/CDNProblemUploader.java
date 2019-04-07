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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object gCO = new Object();
    private static volatile CDNProblemUploader gCP;
    private m bXd;
    private int gCJ;
    private int gCK;
    private int gCL;
    private int mErrorNum;
    private Handler mHandler;
    private final int gCw = 5;
    private final int gCx = 0;
    private final int gCy = 1;
    private final int gCz = 2;
    private final int gCA = 3;
    private final byte gCB = 0;
    private final byte gCC = 1;
    private int gCD = 0;
    private final int gCE = 5;
    private boolean gCF = false;
    private long EE = 0;
    private final long gCG = 86400000;
    private final float gCH = 100.0f;
    private float gCI = 0.0f;
    private BdAsyncTaskParallel gCM = null;
    private final CdnErrorJsonData gCN = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gCD + 1;
        cDNProblemUploader.gCD = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gCP == null) {
            synchronized (CDNProblemUploader.class) {
                if (gCP == null) {
                    gCP = new CDNProblemUploader();
                }
            }
        }
        return gCP;
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
    public m getmCdnLogData() {
        return this.bXd;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (gCO) {
            this.bXd = mVar;
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
        synchronized (gCO) {
            if (getmCdnLogData() == null) {
                this.gCI += 25.0f;
            } else {
                this.gCI += getmCdnLogData().getErrRank();
            }
            this.gCK++;
            this.mErrorNum++;
            this.gCN.add(i);
            int i3 = this.gCK;
            int i4 = this.mErrorNum;
            int i5 = this.gCJ;
            int i6 = this.gCJ != 0 ? this.gCL / this.gCJ : 0;
            String cdnErrorJsonData = this.gCN.toString();
            if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gCD = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gCK < 5) {
                    i2 = 0;
                } else if (this.gCI < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gCJ < getmCdnLogData().getSlowNumber()) {
                    if (this.gCI >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gCI < 100.0f || this.gCJ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, cdnErrorJsonData, i5, i6);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = UIMsg.m_AppUI.MSG_APP_GPS;
        if (getmCdnLogData() != null) {
            i3 = getmCdnLogData().getTime();
        }
        synchronized (gCO) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gCI += 10.0f;
                } else {
                    this.gCI += getmCdnLogData().getSlowRank();
                }
                this.gCJ++;
                this.gCL = (int) (this.gCL + j);
                this.gCK++;
                int i4 = this.gCK;
                int i5 = this.mErrorNum;
                int i6 = this.gCJ;
                if (this.gCJ != 0) {
                    i = this.gCL / this.gCJ;
                }
                String cdnErrorJsonData = this.gCN.toString();
                if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gCD = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gCK >= 5) {
                        if (this.gCI >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gCJ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gCI >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gCI >= 100.0f && this.gCJ >= getmCdnLogData().getSlowNumber()) {
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
                this.gCI -= 25.0f;
            } else {
                this.gCI -= getmCdnLogData().getSuccRank();
            }
            if (this.gCI < 0.0f) {
                this.gCI = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gCF) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gCM == null) {
            this.gCM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gCM);
        cDNUpLoadTask.execute(new Object[0]);
        this.gCF = true;
        a jC = s.jC();
        jC.append(SocialConstants.PARAM_ACT, "fallback");
        jC.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gCK = 0;
        this.gCJ = 0;
        this.mErrorNum = 0;
        this.gCL = 0;
        this.gCI = 0.0f;
        this.gCN.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bHu;
        private final int gCJ;
        private final int gCK;
        private final String gCR;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gCJ = i4;
            this.bHu = str;
            this.gCR = str2;
            this.mType = i;
            this.gCK = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.gCK));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x("error", this.bHu);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.gCJ));
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCR);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.gCJ + "");
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCR);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x("error", this.bHu);
            }
            String acg = this.mNetWork.acg();
            if (!this.mNetWork.acH() || TextUtils.isEmpty(acg)) {
                return null;
            }
            try {
                return new JSONObject(acg);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: bq */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a jC = s.jC();
                    jC.append(SocialConstants.PARAM_ACT, "fallback");
                    jC.append("result", "1");
                    jC.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.bXd.setmSwitch(false);
                    CDNProblemUploader.this.EE = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a jC2 = s.jC();
                        jC2.append(SocialConstants.PARAM_ACT, "fallback");
                        jC2.append("result", "2");
                        jC2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC2);
                    } else {
                        a jC3 = s.jC();
                        jC3.append(SocialConstants.PARAM_ACT, "fallback");
                        jC3.append("result", "0");
                        jC3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.bXd.setmSwitch(false);
                        CDNProblemUploader.this.EE = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    m mVar = new m();
                    mVar.parseJson(optString);
                    if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(mVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.gCF = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gCS;

        private CdnErrorJsonData() {
            this.gCS = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gCS.length() != 0) {
                this.gCS.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gCS.append(i);
        }

        public void clear() {
            this.gCS.setLength(0);
        }

        public String toString() {
            return this.gCS.toString();
        }
    }
}
