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
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends q {
    private static Object eLT = new Object();
    private static volatile CDNProblemUploader eLU;
    private k aBZ;
    private int eLO;
    private int eLP;
    private int eLQ;
    private int mErrorNum;
    private Handler mHandler;
    private final int eLB = 5;
    private final int eLC = 0;
    private final int eLD = 1;
    private final int eLE = 2;
    private final int eLF = 3;
    private final byte eLG = 0;
    private final byte eLH = 1;
    private int eLI = 0;
    private final int eLJ = 5;
    private boolean eLK = false;
    private long By = 0;
    private final long eLL = 86400000;
    private final float eLM = 100.0f;
    private float eLN = 0.0f;
    private BdAsyncTaskParallel eLR = null;
    private final CdnErrorJsonData eLS = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eLI + 1;
        cDNProblemUploader.eLI = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eLU == null) {
            synchronized (CDNProblemUploader.class) {
                if (eLU == null) {
                    eLU = new CDNProblemUploader();
                }
            }
        }
        return eLU;
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

    @Override // com.baidu.tbadk.core.util.q
    public k getmCdnLogData() {
        return this.aBZ;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(k kVar) {
        synchronized (eLT) {
            this.aBZ = kVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (eLT) {
            if (getmCdnLogData() == null) {
                this.eLN += 25.0f;
            } else {
                this.eLN += getmCdnLogData().getErrRank();
            }
            this.eLP++;
            this.mErrorNum++;
            this.eLS.add(i);
            int i3 = this.eLP;
            int i4 = this.mErrorNum;
            int i5 = this.eLO;
            int i6 = this.eLO != 0 ? this.eLQ / this.eLO : 0;
            String cdnErrorJsonData = this.eLS.toString();
            if (getmCdnLogData() != null && this.By > 0 && System.currentTimeMillis() - this.By > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eLI = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eLP < 5) {
                    i2 = 0;
                } else if (this.eLN < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eLO < getmCdnLogData().getSlowNumber()) {
                    if (this.eLN >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eLN < 100.0f || this.eLO < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eLT) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eLN += 10.0f;
                } else {
                    this.eLN += getmCdnLogData().getSlowRank();
                }
                this.eLO++;
                this.eLQ = (int) (this.eLQ + j);
                this.eLP++;
                int i4 = this.eLP;
                int i5 = this.mErrorNum;
                int i6 = this.eLO;
                if (this.eLO != 0) {
                    i = this.eLQ / this.eLO;
                }
                String cdnErrorJsonData = this.eLS.toString();
                if (getmCdnLogData() != null && this.By > 0 && System.currentTimeMillis() - this.By > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eLI = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eLP >= 5) {
                        if (this.eLN >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eLO >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eLN >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eLN >= 100.0f && this.eLO >= getmCdnLogData().getSlowNumber()) {
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
                this.eLN -= 25.0f;
            } else {
                this.eLN -= getmCdnLogData().getSuccRank();
            }
            if (this.eLN < 0.0f) {
                this.eLN = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eLK) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eLR == null) {
            this.eLR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eLR);
        cDNUpLoadTask.execute(new Object[0]);
        this.eLK = true;
        a ii = t.ii();
        ii.append(SocialConstants.PARAM_ACT, "fallback");
        ii.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eLP = 0;
        this.eLO = 0;
        this.mErrorNum = 0;
        this.eLQ = 0;
        this.eLN = 0.0f;
        this.eLS.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String anm;
        private final int eLO;
        private final int eLP;
        private final String eLW;
        private final int mErrorNum;
        private final y mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eLO = i4;
            this.anm = str;
            this.eLW = str2;
            this.mType = i;
            this.eLP = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.eLP));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.anm);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.eLO));
                this.mNetWork.o("time", this.eLW);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.eLO + "");
                this.mNetWork.o("time", this.eLW);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.anm);
            }
            String yo = this.mNetWork.yo();
            if (!this.mNetWork.yP() || TextUtils.isEmpty(yo)) {
                return null;
            }
            try {
                return new JSONObject(yo);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a ii = t.ii();
                    ii.append(SocialConstants.PARAM_ACT, "fallback");
                    ii.append("result", "1");
                    ii.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aBZ.setmSwitch(false);
                    CDNProblemUploader.this.By = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a ii2 = t.ii();
                        ii2.append(SocialConstants.PARAM_ACT, "fallback");
                        ii2.append("result", "2");
                        ii2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii2);
                    } else {
                        a ii3 = t.ii();
                        ii3.append(SocialConstants.PARAM_ACT, "fallback");
                        ii3.append("result", "0");
                        ii3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aBZ.setmSwitch(false);
                        CDNProblemUploader.this.By = System.currentTimeMillis();
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
                CDNProblemUploader.this.eLK = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eLX;

        private CdnErrorJsonData() {
            this.eLX = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eLX.length() != 0) {
                this.eLX.append(",");
            }
            this.eLX.append(i);
        }

        public void clear() {
            this.eLX.setLength(0);
        }

        public String toString() {
            return this.eLX.toString();
        }
    }
}
