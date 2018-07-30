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
    private static Object eLY = new Object();
    private static volatile CDNProblemUploader eLZ;
    private k aCc;
    private int eLT;
    private int eLU;
    private int eLV;
    private int mErrorNum;
    private Handler mHandler;
    private final int eLG = 5;
    private final int eLH = 0;
    private final int eLI = 1;
    private final int eLJ = 2;
    private final int eLK = 3;
    private final byte eLL = 0;
    private final byte eLM = 1;
    private int eLN = 0;
    private final int eLO = 5;
    private boolean eLP = false;
    private long Bx = 0;
    private final long eLQ = 86400000;
    private final float eLR = 100.0f;
    private float eLS = 0.0f;
    private BdAsyncTaskParallel eLW = null;
    private final CdnErrorJsonData eLX = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eLN + 1;
        cDNProblemUploader.eLN = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eLZ == null) {
            synchronized (CDNProblemUploader.class) {
                if (eLZ == null) {
                    eLZ = new CDNProblemUploader();
                }
            }
        }
        return eLZ;
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
        return this.aCc;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(k kVar) {
        synchronized (eLY) {
            this.aCc = kVar;
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
        synchronized (eLY) {
            if (getmCdnLogData() == null) {
                this.eLS += 25.0f;
            } else {
                this.eLS += getmCdnLogData().getErrRank();
            }
            this.eLU++;
            this.mErrorNum++;
            this.eLX.add(i);
            int i3 = this.eLU;
            int i4 = this.mErrorNum;
            int i5 = this.eLT;
            int i6 = this.eLT != 0 ? this.eLV / this.eLT : 0;
            String cdnErrorJsonData = this.eLX.toString();
            if (getmCdnLogData() != null && this.Bx > 0 && System.currentTimeMillis() - this.Bx > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eLN = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eLU < 5) {
                    i2 = 0;
                } else if (this.eLS < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eLT < getmCdnLogData().getSlowNumber()) {
                    if (this.eLS >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eLS < 100.0f || this.eLT < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eLY) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eLS += 10.0f;
                } else {
                    this.eLS += getmCdnLogData().getSlowRank();
                }
                this.eLT++;
                this.eLV = (int) (this.eLV + j);
                this.eLU++;
                int i4 = this.eLU;
                int i5 = this.mErrorNum;
                int i6 = this.eLT;
                if (this.eLT != 0) {
                    i = this.eLV / this.eLT;
                }
                String cdnErrorJsonData = this.eLX.toString();
                if (getmCdnLogData() != null && this.Bx > 0 && System.currentTimeMillis() - this.Bx > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eLN = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eLU >= 5) {
                        if (this.eLS >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eLT >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eLS >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eLS >= 100.0f && this.eLT >= getmCdnLogData().getSlowNumber()) {
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
                this.eLS -= 25.0f;
            } else {
                this.eLS -= getmCdnLogData().getSuccRank();
            }
            if (this.eLS < 0.0f) {
                this.eLS = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eLP) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eLW == null) {
            this.eLW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eLW);
        cDNUpLoadTask.execute(new Object[0]);
        this.eLP = true;
        a ii = t.ii();
        ii.append(SocialConstants.PARAM_ACT, "fallback");
        ii.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eLU = 0;
        this.eLT = 0;
        this.mErrorNum = 0;
        this.eLV = 0;
        this.eLS = 0.0f;
        this.eLX.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String anl;
        private final int eLT;
        private final int eLU;
        private final String eMb;
        private final int mErrorNum;
        private final y mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eLT = i4;
            this.anl = str;
            this.eMb = str2;
            this.mType = i;
            this.eLU = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.eLU));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.anl);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.eLT));
                this.mNetWork.o("time", this.eMb);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.eLT + "");
                this.mNetWork.o("time", this.eMb);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.anl);
            }
            String yq = this.mNetWork.yq();
            if (!this.mNetWork.yR() || TextUtils.isEmpty(yq)) {
                return null;
            }
            try {
                return new JSONObject(yq);
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
                    CDNProblemUploader.this.aCc.setmSwitch(false);
                    CDNProblemUploader.this.Bx = System.currentTimeMillis();
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
                        CDNProblemUploader.this.aCc.setmSwitch(false);
                        CDNProblemUploader.this.Bx = System.currentTimeMillis();
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
                CDNProblemUploader.this.eLP = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eMc;

        private CdnErrorJsonData() {
            this.eMc = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eMc.length() != 0) {
                this.eMc.append(",");
            }
            this.eMc.append(i);
        }

        public void clear() {
            this.eMc.setLength(0);
        }

        public String toString() {
            return this.eMc.toString();
        }
    }
}
