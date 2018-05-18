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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object esX = new Object();
    private static volatile CDNProblemUploader esY;
    private l ath;
    private int esS;
    private int esT;
    private int esU;
    private int mErrorNum;
    private Handler mHandler;
    private final int esF = 5;
    private final int esG = 0;
    private final int esH = 1;
    private final int esI = 2;
    private final int esJ = 3;
    private final byte esK = 0;
    private final byte esL = 1;
    private int esM = 0;
    private final int esN = 5;
    private boolean esO = false;
    private long vu = 0;
    private final long esP = 86400000;
    private final float esQ = 100.0f;
    private float esR = 0.0f;
    private BdAsyncTaskParallel esV = null;
    private final CdnErrorJsonData esW = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.esM + 1;
        cDNProblemUploader.esM = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (esY == null) {
            synchronized (CDNProblemUploader.class) {
                if (esY == null) {
                    esY = new CDNProblemUploader();
                }
            }
        }
        return esY;
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
    public l getmCdnLogData() {
        return this.ath;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (esX) {
            this.ath = lVar;
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
        synchronized (esX) {
            if (getmCdnLogData() == null) {
                this.esR += 25.0f;
            } else {
                this.esR += getmCdnLogData().getErrRank();
            }
            this.esT++;
            this.mErrorNum++;
            this.esW.add(i);
            int i3 = this.esT;
            int i4 = this.mErrorNum;
            int i5 = this.esS;
            int i6 = this.esS != 0 ? this.esU / this.esS : 0;
            String cdnErrorJsonData = this.esW.toString();
            if (getmCdnLogData() != null && this.vu > 0 && System.currentTimeMillis() - this.vu > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.esM = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.esT < 5) {
                    i2 = 0;
                } else if (this.esR < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.esS < getmCdnLogData().getSlowNumber()) {
                    if (this.esR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.esR < 100.0f || this.esS < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (esX) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.esR += 10.0f;
                } else {
                    this.esR += getmCdnLogData().getSlowRank();
                }
                this.esS++;
                this.esU = (int) (this.esU + j);
                this.esT++;
                int i4 = this.esT;
                int i5 = this.mErrorNum;
                int i6 = this.esS;
                if (this.esS != 0) {
                    i = this.esU / this.esS;
                }
                String cdnErrorJsonData = this.esW.toString();
                if (getmCdnLogData() != null && this.vu > 0 && System.currentTimeMillis() - this.vu > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.esM = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.esT >= 5) {
                        if (this.esR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.esS >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.esR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.esR >= 100.0f && this.esS >= getmCdnLogData().getSlowNumber()) {
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
                this.esR -= 25.0f;
            } else {
                this.esR -= getmCdnLogData().getSuccRank();
            }
            if (this.esR < 0.0f) {
                this.esR = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.esO) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.esV == null) {
            this.esV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.esV);
        cDNUpLoadTask.execute(new Object[0]);
        this.esO = true;
        a fq = s.fq();
        fq.append(SocialConstants.PARAM_ACT, "fallback");
        fq.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.esT = 0;
        this.esS = 0;
        this.mErrorNum = 0;
        this.esU = 0;
        this.esR = 0.0f;
        this.esW.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String afi;
        private final int esS;
        private final int esT;
        private final String eta;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.esS = i4;
            this.afi = str;
            this.eta = str2;
            this.mType = i;
            this.esT = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.esT));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.afi);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.esS));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eta);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.esS + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eta);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.afi);
            }
            String uK = this.mNetWork.uK();
            if (!this.mNetWork.vl() || TextUtils.isEmpty(uK)) {
                return null;
            }
            try {
                return new JSONObject(uK);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fq = s.fq();
                    fq.append(SocialConstants.PARAM_ACT, "fallback");
                    fq.append("result", "1");
                    fq.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fq);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ath.setmSwitch(false);
                    CDNProblemUploader.this.vu = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.HTTP_RET).optInt("err_no", -1) != 0) {
                        a fq2 = s.fq();
                        fq2.append(SocialConstants.PARAM_ACT, "fallback");
                        fq2.append("result", "2");
                        fq2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fq2);
                    } else {
                        a fq3 = s.fq();
                        fq3.append(SocialConstants.PARAM_ACT, "fallback");
                        fq3.append("result", "0");
                        fq3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fq3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ath.setmSwitch(false);
                        CDNProblemUploader.this.vu = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    l lVar = new l();
                    lVar.parseJson(optString);
                    if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(lVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.esO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer etb;

        private CdnErrorJsonData() {
            this.etb = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.etb.length() != 0) {
                this.etb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.etb.append(i);
        }

        public void clear() {
            this.etb.setLength(0);
        }

        public String toString() {
            return this.etb.toString();
        }
    }
}
