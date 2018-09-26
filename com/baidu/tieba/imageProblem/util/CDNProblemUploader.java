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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.TbConfig;
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
    private static Object eTo = new Object();
    private static volatile CDNProblemUploader eTp;
    private k aFf;
    private int eTj;
    private int eTk;
    private int eTl;
    private int mErrorNum;
    private Handler mHandler;
    private final int eSW = 5;
    private final int eSX = 0;
    private final int eSY = 1;
    private final int eSZ = 2;
    private final int eTa = 3;
    private final byte eTb = 0;
    private final byte eTc = 1;
    private int eTd = 0;
    private final int eTe = 5;
    private boolean eTf = false;
    private long DT = 0;
    private final long eTg = 86400000;
    private final float eTh = 100.0f;
    private float eTi = 0.0f;
    private BdAsyncTaskParallel eTm = null;
    private final CdnErrorJsonData eTn = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eTd + 1;
        cDNProblemUploader.eTd = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eTp == null) {
            synchronized (CDNProblemUploader.class) {
                if (eTp == null) {
                    eTp = new CDNProblemUploader();
                }
            }
        }
        return eTp;
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
        return this.aFf;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (eTo) {
            this.aFf = kVar;
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
        synchronized (eTo) {
            if (getmCdnLogData() == null) {
                this.eTi += 25.0f;
            } else {
                this.eTi += getmCdnLogData().getErrRank();
            }
            this.eTk++;
            this.mErrorNum++;
            this.eTn.add(i);
            int i3 = this.eTk;
            int i4 = this.mErrorNum;
            int i5 = this.eTj;
            int i6 = this.eTj != 0 ? this.eTl / this.eTj : 0;
            String cdnErrorJsonData = this.eTn.toString();
            if (getmCdnLogData() != null && this.DT > 0 && System.currentTimeMillis() - this.DT > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eTd = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eTk < 5) {
                    i2 = 0;
                } else if (this.eTi < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eTj < getmCdnLogData().getSlowNumber()) {
                    if (this.eTi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eTi < 100.0f || this.eTj < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eTo) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eTi += 10.0f;
                } else {
                    this.eTi += getmCdnLogData().getSlowRank();
                }
                this.eTj++;
                this.eTl = (int) (this.eTl + j);
                this.eTk++;
                int i4 = this.eTk;
                int i5 = this.mErrorNum;
                int i6 = this.eTj;
                if (this.eTj != 0) {
                    i = this.eTl / this.eTj;
                }
                String cdnErrorJsonData = this.eTn.toString();
                if (getmCdnLogData() != null && this.DT > 0 && System.currentTimeMillis() - this.DT > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eTd = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eTk >= 5) {
                        if (this.eTi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eTj >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eTi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eTi >= 100.0f && this.eTj >= getmCdnLogData().getSlowNumber()) {
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
                this.eTi -= 25.0f;
            } else {
                this.eTi -= getmCdnLogData().getSuccRank();
            }
            if (this.eTi < 0.0f) {
                this.eTi = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eTf) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eTm == null) {
            this.eTm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eTm);
        cDNUpLoadTask.execute(new Object[0]);
        this.eTf = true;
        a jo = s.jo();
        jo.append(SocialConstants.PARAM_ACT, "fallback");
        jo.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eTk = 0;
        this.eTj = 0;
        this.mErrorNum = 0;
        this.eTl = 0;
        this.eTi = 0.0f;
        this.eTn.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String apS;
        private final int eTj;
        private final int eTk;
        private final String eTr;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eTj = i4;
            this.apS = str;
            this.eTr = str2;
            this.mType = i;
            this.eTk = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.u("number", String.valueOf(this.eTk));
            if (this.mType == 1) {
                this.mNetWork.u("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.u("error", this.apS);
                this.mNetWork.u("ab_num_slow", String.valueOf(this.eTj));
                this.mNetWork.u("time", this.eTr);
            } else if (this.mType == 3) {
                this.mNetWork.u("ab_num_slow", this.eTj + "");
                this.mNetWork.u("time", this.eTr);
            } else if (this.mType == 2) {
                this.mNetWork.u("ab_num_error", this.mErrorNum + "");
                this.mNetWork.u("error", this.apS);
            }
            String zt = this.mNetWork.zt();
            if (!this.mNetWork.zU() || TextUtils.isEmpty(zt)) {
                return null;
            }
            try {
                return new JSONObject(zt);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: V */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a jo = s.jo();
                    jo.append(SocialConstants.PARAM_ACT, "fallback");
                    jo.append("result", "1");
                    jo.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aFf.setmSwitch(false);
                    CDNProblemUploader.this.DT = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a jo2 = s.jo();
                        jo2.append(SocialConstants.PARAM_ACT, "fallback");
                        jo2.append("result", "2");
                        jo2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo2);
                    } else {
                        a jo3 = s.jo();
                        jo3.append(SocialConstants.PARAM_ACT, "fallback");
                        jo3.append("result", "0");
                        jo3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aFf.setmSwitch(false);
                        CDNProblemUploader.this.DT = System.currentTimeMillis();
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
                CDNProblemUploader.this.eTf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eTs;

        private CdnErrorJsonData() {
            this.eTs = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eTs.length() != 0) {
                this.eTs.append(",");
            }
            this.eTs.append(i);
        }

        public void clear() {
            this.eTs.setLength(0);
        }

        public String toString() {
            return this.eTs.toString();
        }
    }
}
