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
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object eWW = new Object();
    private static volatile CDNProblemUploader eWX;
    private k bhw;
    private int eWR;
    private int eWS;
    private int eWT;
    private int mErrorNum;
    private Handler mHandler;
    private final int eWE = 5;
    private final int eWF = 0;
    private final int eWG = 1;
    private final int eWH = 2;
    private final int eWI = 3;
    private final byte eWJ = 0;
    private final byte eWK = 1;
    private int eWL = 0;
    private final int eWM = 5;
    private boolean eWN = false;
    private long akR = 0;
    private final long eWO = 86400000;
    private final float eWP = 100.0f;
    private float eWQ = 0.0f;
    private BdAsyncTaskParallel eWU = null;
    private final CdnErrorJsonData eWV = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eWL + 1;
        cDNProblemUploader.eWL = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eWX == null) {
            synchronized (CDNProblemUploader.class) {
                if (eWX == null) {
                    eWX = new CDNProblemUploader();
                }
            }
        }
        return eWX;
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
        return this.bhw;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (eWW) {
            this.bhw = kVar;
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
        synchronized (eWW) {
            if (getmCdnLogData() == null) {
                this.eWQ += 25.0f;
            } else {
                this.eWQ += getmCdnLogData().getErrRank();
            }
            this.eWS++;
            this.mErrorNum++;
            this.eWV.add(i);
            int i3 = this.eWS;
            int i4 = this.mErrorNum;
            int i5 = this.eWR;
            int i6 = this.eWR != 0 ? this.eWT / this.eWR : 0;
            String cdnErrorJsonData = this.eWV.toString();
            if (getmCdnLogData() != null && this.akR > 0 && System.currentTimeMillis() - this.akR > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eWL = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eWS < 5) {
                    i2 = 0;
                } else if (this.eWQ < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eWR < getmCdnLogData().getSlowNumber()) {
                    if (this.eWQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eWQ < 100.0f || this.eWR < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eWW) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eWQ += 10.0f;
                } else {
                    this.eWQ += getmCdnLogData().getSlowRank();
                }
                this.eWR++;
                this.eWT = (int) (this.eWT + j);
                this.eWS++;
                int i4 = this.eWS;
                int i5 = this.mErrorNum;
                int i6 = this.eWR;
                if (this.eWR != 0) {
                    i = this.eWT / this.eWR;
                }
                String cdnErrorJsonData = this.eWV.toString();
                if (getmCdnLogData() != null && this.akR > 0 && System.currentTimeMillis() - this.akR > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eWL = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eWS >= 5) {
                        if (this.eWQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eWR >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eWQ >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eWQ >= 100.0f && this.eWR >= getmCdnLogData().getSlowNumber()) {
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
                this.eWQ -= 25.0f;
            } else {
                this.eWQ -= getmCdnLogData().getSuccRank();
            }
            if (this.eWQ < 0.0f) {
                this.eWQ = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eWN) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eWU == null) {
            this.eWU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eWU);
        cDNUpLoadTask.execute(new Object[0]);
        this.eWN = true;
        a nn = s.nn();
        nn.append(SocialConstants.PARAM_ACT, "fallback");
        nn.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eWS = 0;
        this.eWR = 0;
        this.mErrorNum = 0;
        this.eWT = 0;
        this.eWQ = 0.0f;
        this.eWV.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aTM;
        private final int eWR;
        private final int eWS;
        private final String eWZ;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eWR = i4;
            this.aTM = str;
            this.eWZ = str2;
            this.mType = i;
            this.eWS = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.eWS));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aTM);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.eWR));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eWZ);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.eWR + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eWZ);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aTM);
            }
            String Ca = this.mNetWork.Ca();
            if (!this.mNetWork.CB() || TextUtils.isEmpty(Ca)) {
                return null;
            }
            try {
                return new JSONObject(Ca);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a nn = s.nn();
                    nn.append(SocialConstants.PARAM_ACT, "fallback");
                    nn.append("result", "1");
                    nn.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", nn);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.bhw.setmSwitch(false);
                    CDNProblemUploader.this.akR = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.HTTP_RET).optInt("err_no", -1) != 0) {
                        a nn2 = s.nn();
                        nn2.append(SocialConstants.PARAM_ACT, "fallback");
                        nn2.append("result", "2");
                        nn2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn2);
                    } else {
                        a nn3 = s.nn();
                        nn3.append(SocialConstants.PARAM_ACT, "fallback");
                        nn3.append("result", "0");
                        nn3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.bhw.setmSwitch(false);
                        CDNProblemUploader.this.akR = System.currentTimeMillis();
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
                CDNProblemUploader.this.eWN = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eXa;

        private CdnErrorJsonData() {
            this.eXa = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eXa.length() != 0) {
                this.eXa.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.eXa.append(i);
        }

        public void clear() {
            this.eXa.setLength(0);
        }

        public String toString() {
            return this.eXa.toString();
        }
    }
}
