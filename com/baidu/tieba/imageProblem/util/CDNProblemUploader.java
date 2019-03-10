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
    private static Object gDb = new Object();
    private static volatile CDNProblemUploader gDc;
    private m bXa;
    private int gCW;
    private int gCX;
    private int gCY;
    private int mErrorNum;
    private Handler mHandler;
    private final int gCJ = 5;
    private final int gCK = 0;
    private final int gCL = 1;
    private final int gCM = 2;
    private final int gCN = 3;
    private final byte gCO = 0;
    private final byte gCP = 1;
    private int gCQ = 0;
    private final int gCR = 5;
    private boolean gCS = false;
    private long EE = 0;
    private final long gCT = 86400000;
    private final float gCU = 100.0f;
    private float gCV = 0.0f;
    private BdAsyncTaskParallel gCZ = null;
    private final CdnErrorJsonData gDa = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gCQ + 1;
        cDNProblemUploader.gCQ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gDc == null) {
            synchronized (CDNProblemUploader.class) {
                if (gDc == null) {
                    gDc = new CDNProblemUploader();
                }
            }
        }
        return gDc;
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
        return this.bXa;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (gDb) {
            this.bXa = mVar;
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
        synchronized (gDb) {
            if (getmCdnLogData() == null) {
                this.gCV += 25.0f;
            } else {
                this.gCV += getmCdnLogData().getErrRank();
            }
            this.gCX++;
            this.mErrorNum++;
            this.gDa.add(i);
            int i3 = this.gCX;
            int i4 = this.mErrorNum;
            int i5 = this.gCW;
            int i6 = this.gCW != 0 ? this.gCY / this.gCW : 0;
            String cdnErrorJsonData = this.gDa.toString();
            if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gCQ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gCX < 5) {
                    i2 = 0;
                } else if (this.gCV < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gCW < getmCdnLogData().getSlowNumber()) {
                    if (this.gCV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gCV < 100.0f || this.gCW < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (gDb) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gCV += 10.0f;
                } else {
                    this.gCV += getmCdnLogData().getSlowRank();
                }
                this.gCW++;
                this.gCY = (int) (this.gCY + j);
                this.gCX++;
                int i4 = this.gCX;
                int i5 = this.mErrorNum;
                int i6 = this.gCW;
                if (this.gCW != 0) {
                    i = this.gCY / this.gCW;
                }
                String cdnErrorJsonData = this.gDa.toString();
                if (getmCdnLogData() != null && this.EE > 0 && System.currentTimeMillis() - this.EE > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gCQ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gCX >= 5) {
                        if (this.gCV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gCW >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gCV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gCV >= 100.0f && this.gCW >= getmCdnLogData().getSlowNumber()) {
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
                this.gCV -= 25.0f;
            } else {
                this.gCV -= getmCdnLogData().getSuccRank();
            }
            if (this.gCV < 0.0f) {
                this.gCV = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gCS) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gCZ == null) {
            this.gCZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gCZ);
        cDNUpLoadTask.execute(new Object[0]);
        this.gCS = true;
        a jC = s.jC();
        jC.append(SocialConstants.PARAM_ACT, "fallback");
        jC.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gCX = 0;
        this.gCW = 0;
        this.mErrorNum = 0;
        this.gCY = 0;
        this.gCV = 0.0f;
        this.gDa.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bHr;
        private final int gCW;
        private final int gCX;
        private final String gDe;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gCW = i4;
            this.bHr = str;
            this.gDe = str2;
            this.mType = i;
            this.gCX = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.gCX));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x("error", this.bHr);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.gCW));
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gDe);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.gCW + "");
                this.mNetWork.x(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gDe);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x("error", this.bHr);
            }
            String acj = this.mNetWork.acj();
            if (!this.mNetWork.acK() || TextUtils.isEmpty(acj)) {
                return null;
            }
            try {
                return new JSONObject(acj);
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
                    CDNProblemUploader.this.bXa.setmSwitch(false);
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
                        CDNProblemUploader.this.bXa.setmSwitch(false);
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
                CDNProblemUploader.this.gCS = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gDf;

        private CdnErrorJsonData() {
            this.gDf = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gDf.length() != 0) {
                this.gDf.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gDf.append(i);
        }

        public void clear() {
            this.gDf.setLength(0);
        }

        public String toString() {
            return this.gDf.toString();
        }
    }
}
