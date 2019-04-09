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
    private static Object gCP = new Object();
    private static volatile CDNProblemUploader gCQ;
    private m bXe;
    private int gCK;
    private int gCL;
    private int gCM;
    private int mErrorNum;
    private Handler mHandler;
    private final int gCx = 5;
    private final int gCy = 0;
    private final int gCz = 1;
    private final int gCA = 2;
    private final int gCB = 3;
    private final byte gCC = 0;
    private final byte gCD = 1;
    private int gCE = 0;
    private final int gCF = 5;
    private boolean gCG = false;
    private long EE = 0;
    private final long gCH = 86400000;
    private final float gCI = 100.0f;
    private float gCJ = 0.0f;
    private BdAsyncTaskParallel gCN = null;
    private final CdnErrorJsonData gCO = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gCE + 1;
        cDNProblemUploader.gCE = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gCQ == null) {
            synchronized (CDNProblemUploader.class) {
                if (gCQ == null) {
                    gCQ = new CDNProblemUploader();
                }
            }
        }
        return gCQ;
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
        return this.bXe;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (gCP) {
            this.bXe = mVar;
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
        synchronized (gCP) {
            if (getmCdnLogData() == null) {
                this.gCJ += 25.0f;
            } else {
                this.gCJ += getmCdnLogData().getErrRank();
            }
            this.gCL++;
            this.mErrorNum++;
            this.gCO.add(i);
            int i3 = this.gCL;
            int i4 = this.mErrorNum;
            int i5 = this.gCK;
            int i6 = this.gCK != 0 ? this.gCM / this.gCK : 0;
            String cdnErrorJsonData = this.gCO.toString();
            if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gCE = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gCL < 5) {
                    i2 = 0;
                } else if (this.gCJ < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gCK < getmCdnLogData().getSlowNumber()) {
                    if (this.gCJ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gCJ < 100.0f || this.gCK < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (gCP) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gCJ += 10.0f;
                } else {
                    this.gCJ += getmCdnLogData().getSlowRank();
                }
                this.gCK++;
                this.gCM = (int) (this.gCM + j);
                this.gCL++;
                int i4 = this.gCL;
                int i5 = this.mErrorNum;
                int i6 = this.gCK;
                if (this.gCK != 0) {
                    i = this.gCM / this.gCK;
                }
                String cdnErrorJsonData = this.gCO.toString();
                if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gCE = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gCL >= 5) {
                        if (this.gCJ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gCK >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gCJ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gCJ >= 100.0f && this.gCK >= getmCdnLogData().getSlowNumber()) {
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
                this.gCJ -= 25.0f;
            } else {
                this.gCJ -= getmCdnLogData().getSuccRank();
            }
            if (this.gCJ < 0.0f) {
                this.gCJ = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gCG) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gCN == null) {
            this.gCN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gCN);
        cDNUpLoadTask.execute(new Object[0]);
        this.gCG = true;
        a jC = s.jC();
        jC.append(SocialConstants.PARAM_ACT, "fallback");
        jC.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gCL = 0;
        this.gCK = 0;
        this.mErrorNum = 0;
        this.gCM = 0;
        this.gCJ = 0.0f;
        this.gCO.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bHv;
        private final int gCK;
        private final int gCL;
        private final String gCS;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gCK = i4;
            this.bHv = str;
            this.gCS = str2;
            this.mType = i;
            this.gCL = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.gCL));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x("error", this.bHv);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.gCK));
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCS);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.gCK + "");
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCS);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x("error", this.bHv);
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
                    CDNProblemUploader.this.bXe.setmSwitch(false);
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
                        CDNProblemUploader.this.bXe.setmSwitch(false);
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
                CDNProblemUploader.this.gCG = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gCT;

        private CdnErrorJsonData() {
            this.gCT = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gCT.length() != 0) {
                this.gCT.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gCT.append(i);
        }

        public void clear() {
            this.gCT.setLength(0);
        }

        public String toString() {
            return this.gCT.toString();
        }
    }
}
