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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.w;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends o {
    private static Object dHG = new Object();
    private static volatile CDNProblemUploader dHH;
    private l ase;
    private int dHB;
    private int dHC;
    private int dHD;
    private int mErrorNum;
    private Handler mHandler;
    private final int dHo = 5;
    private final int dHp = 0;
    private final int dHq = 1;
    private final int dHr = 2;
    private final int dHs = 3;
    private final byte dHt = 0;
    private final byte dHu = 1;
    private int dHv = 0;
    private final int dHw = 5;
    private boolean dHx = false;
    private long yO = 0;
    private final long dHy = 86400000;
    private final float dHz = 100.0f;
    private float dHA = 0.0f;
    private BdAsyncTaskParallel dHE = null;
    private final CdnErrorJsonData dHF = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dHv + 1;
        cDNProblemUploader.dHv = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dHH == null) {
            synchronized (CDNProblemUploader.class) {
                if (dHH == null) {
                    dHH = new CDNProblemUploader();
                }
            }
        }
        return dHH;
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

    @Override // com.baidu.tbadk.core.util.o
    public l getmCdnLogData() {
        return this.ase;
    }

    @Override // com.baidu.tbadk.core.util.o
    public void setmCdnLogData(l lVar) {
        synchronized (dHG) {
            this.ase = lVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.o
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.o
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (dHG) {
            if (getmCdnLogData() == null) {
                this.dHA += 25.0f;
            } else {
                this.dHA += getmCdnLogData().getErrRank();
            }
            this.dHC++;
            this.mErrorNum++;
            this.dHF.add(i);
            int i3 = this.dHC;
            int i4 = this.mErrorNum;
            int i5 = this.dHB;
            int i6 = this.dHB != 0 ? this.dHD / this.dHB : 0;
            String cdnErrorJsonData = this.dHF.toString();
            if (getmCdnLogData() != null && this.yO > 0 && System.currentTimeMillis() - this.yO > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dHv = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dHC < 5) {
                    i2 = 0;
                } else if (this.dHA < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dHB < getmCdnLogData().getSlowNumber()) {
                    if (this.dHA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dHA < 100.0f || this.dHB < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dHG) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dHA += 10.0f;
                } else {
                    this.dHA += getmCdnLogData().getSlowRank();
                }
                this.dHB++;
                this.dHD = (int) (this.dHD + j);
                this.dHC++;
                int i4 = this.dHC;
                int i5 = this.mErrorNum;
                int i6 = this.dHB;
                if (this.dHB != 0) {
                    i = this.dHD / this.dHB;
                }
                String cdnErrorJsonData = this.dHF.toString();
                if (getmCdnLogData() != null && this.yO > 0 && System.currentTimeMillis() - this.yO > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dHv = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dHC >= 5) {
                        if (this.dHA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dHB >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dHA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dHA >= 100.0f && this.dHB >= getmCdnLogData().getSlowNumber()) {
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
                this.dHA -= 25.0f;
            } else {
                this.dHA -= getmCdnLogData().getSuccRank();
            }
            if (this.dHA < 0.0f) {
                this.dHA = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dHx) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dHE == null) {
            this.dHE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dHE);
        cDNUpLoadTask.execute(new Object[0]);
        this.dHx = true;
        a fV = r.fV();
        fV.p("act", "fallback");
        fV.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dHC = 0;
        this.dHB = 0;
        this.mErrorNum = 0;
        this.dHD = 0;
        this.dHA = 0.0f;
        this.dHF.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aeU;
        private final int dHB;
        private final int dHC;
        private final String dHJ;
        private final int mErrorNum;
        private final w mNetWork = new w(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dHB = i4;
            this.aeU = str;
            this.dHJ = str2;
            this.mType = i;
            this.dHC = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dHC));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aeU);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dHB));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dHJ);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dHB + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dHJ);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aeU);
            }
            String uO = this.mNetWork.uO();
            if (!this.mNetWork.vo() || TextUtils.isEmpty(uO)) {
                return null;
            }
            try {
                return new JSONObject(uO);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fV = r.fV();
                    fV.p("act", "fallback");
                    fV.p("result", "1");
                    fV.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fV);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ase.setmSwitch(false);
                    CDNProblemUploader.this.yO = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fV2 = r.fV();
                        fV2.p("act", "fallback");
                        fV2.p("result", "2");
                        fV2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fV2);
                    } else {
                        a fV3 = r.fV();
                        fV3.p("act", "fallback");
                        fV3.p("result", "0");
                        fV3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fV3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ase.setmSwitch(false);
                        CDNProblemUploader.this.yO = System.currentTimeMillis();
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
                CDNProblemUploader.this.dHx = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dHK;

        private CdnErrorJsonData() {
            this.dHK = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dHK.length() != 0) {
                this.dHK.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dHK.append(i);
        }

        public void clear() {
            this.dHK.setLength(0);
        }

        public String toString() {
            return this.dHK.toString();
        }
    }
}
