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
    private static Object erS = new Object();
    private static volatile CDNProblemUploader erT;
    private l atg;
    private int erN;
    private int erO;
    private int erP;
    private int mErrorNum;
    private Handler mHandler;
    private final int erA = 5;
    private final int erB = 0;
    private final int erC = 1;
    private final int erD = 2;
    private final int erE = 3;
    private final byte erF = 0;
    private final byte erG = 1;
    private int erH = 0;
    private final int erI = 5;
    private boolean erJ = false;
    private long vv = 0;
    private final long erK = 86400000;
    private final float erL = 100.0f;
    private float erM = 0.0f;
    private BdAsyncTaskParallel erQ = null;
    private final CdnErrorJsonData erR = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.erH + 1;
        cDNProblemUploader.erH = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (erT == null) {
            synchronized (CDNProblemUploader.class) {
                if (erT == null) {
                    erT = new CDNProblemUploader();
                }
            }
        }
        return erT;
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
        return this.atg;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (erS) {
            this.atg = lVar;
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
        synchronized (erS) {
            if (getmCdnLogData() == null) {
                this.erM += 25.0f;
            } else {
                this.erM += getmCdnLogData().getErrRank();
            }
            this.erO++;
            this.mErrorNum++;
            this.erR.add(i);
            int i3 = this.erO;
            int i4 = this.mErrorNum;
            int i5 = this.erN;
            int i6 = this.erN != 0 ? this.erP / this.erN : 0;
            String cdnErrorJsonData = this.erR.toString();
            if (getmCdnLogData() != null && this.vv > 0 && System.currentTimeMillis() - this.vv > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.erH = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.erO < 5) {
                    i2 = 0;
                } else if (this.erM < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.erN < getmCdnLogData().getSlowNumber()) {
                    if (this.erM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.erM < 100.0f || this.erN < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (erS) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.erM += 10.0f;
                } else {
                    this.erM += getmCdnLogData().getSlowRank();
                }
                this.erN++;
                this.erP = (int) (this.erP + j);
                this.erO++;
                int i4 = this.erO;
                int i5 = this.mErrorNum;
                int i6 = this.erN;
                if (this.erN != 0) {
                    i = this.erP / this.erN;
                }
                String cdnErrorJsonData = this.erR.toString();
                if (getmCdnLogData() != null && this.vv > 0 && System.currentTimeMillis() - this.vv > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.erH = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.erO >= 5) {
                        if (this.erM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.erN >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.erM >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.erM >= 100.0f && this.erN >= getmCdnLogData().getSlowNumber()) {
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
                this.erM -= 25.0f;
            } else {
                this.erM -= getmCdnLogData().getSuccRank();
            }
            if (this.erM < 0.0f) {
                this.erM = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.erJ) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.erQ == null) {
            this.erQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.erQ);
        cDNUpLoadTask.execute(new Object[0]);
        this.erJ = true;
        a fq = s.fq();
        fq.append(SocialConstants.PARAM_ACT, "fallback");
        fq.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.erO = 0;
        this.erN = 0;
        this.mErrorNum = 0;
        this.erP = 0;
        this.erM = 0.0f;
        this.erR.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String afi;
        private final int erN;
        private final int erO;
        private final String erV;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.erN = i4;
            this.afi = str;
            this.erV = str2;
            this.mType = i;
            this.erO = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.erO));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.afi);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.erN));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.erV);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.erN + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.erV);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.afi);
            }
            String uL = this.mNetWork.uL();
            if (!this.mNetWork.vm() || TextUtils.isEmpty(uL)) {
                return null;
            }
            try {
                return new JSONObject(uL);
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
                    CDNProblemUploader.this.atg.setmSwitch(false);
                    CDNProblemUploader.this.vv = System.currentTimeMillis();
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
                        CDNProblemUploader.this.atg.setmSwitch(false);
                        CDNProblemUploader.this.vv = System.currentTimeMillis();
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
                CDNProblemUploader.this.erJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer erW;

        private CdnErrorJsonData() {
            this.erW = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.erW.length() != 0) {
                this.erW.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.erW.append(i);
        }

        public void clear() {
            this.erW.setLength(0);
        }

        public String toString() {
            return this.erW.toString();
        }
    }
}
