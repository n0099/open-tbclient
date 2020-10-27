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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kuT;
    private static Object lockObject = new Object();
    private p eXh;
    private int kuN;
    private int kuO;
    private int kuP;
    private int kuQ;
    private Handler mHandler;
    private final int kuA = 5;
    private final int kuB = 0;
    private final int kuC = 1;
    private final int kuD = 2;
    private final int kuE = 3;
    private final byte kuF = 0;
    private final byte kuG = 1;
    private int kuH = 0;
    private final int kuI = 5;
    private boolean kuJ = false;
    private long Om = 0;
    private final long kuK = 86400000;
    private final float kuL = 100.0f;
    private float kuM = 0.0f;
    private BdAsyncTaskParallel kuR = null;
    private final CdnErrorJsonData kuS = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kuH + 1;
        cDNProblemUploader.kuH = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kuT == null) {
            synchronized (CDNProblemUploader.class) {
                if (kuT == null) {
                    kuT = new CDNProblemUploader();
                }
            }
        }
        return kuT;
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

    @Override // com.baidu.tbadk.core.util.r
    public p getmCdnLogData() {
        return this.eXh;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eXh = pVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.kuM += 25.0f;
            } else {
                this.kuM += getmCdnLogData().getErrRank();
            }
            this.kuP++;
            this.kuO++;
            this.kuS.add(i);
            int i3 = this.kuP;
            int i4 = this.kuO;
            int i5 = this.kuN;
            int i6 = this.kuN != 0 ? this.kuQ / this.kuN : 0;
            String cdnErrorJsonData = this.kuS.toString();
            if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kuH = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kuP < 5) {
                    i2 = 0;
                } else if (this.kuM < 100.0f || this.kuO < getmCdnLogData().getErrNumber() || this.kuN < getmCdnLogData().getSlowNumber()) {
                    if (this.kuM >= 100.0f && this.kuO >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kuM < 100.0f || this.kuN < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (lockObject) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.kuM += 10.0f;
                } else {
                    this.kuM += getmCdnLogData().getSlowRank();
                }
                this.kuN++;
                this.kuQ = (int) (this.kuQ + j);
                this.kuP++;
                int i4 = this.kuP;
                int i5 = this.kuO;
                int i6 = this.kuN;
                if (this.kuN != 0) {
                    i = this.kuQ / this.kuN;
                }
                String cdnErrorJsonData = this.kuS.toString();
                if (getmCdnLogData() != null && this.Om > 0 && System.currentTimeMillis() - this.Om > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kuH = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kuP >= 5) {
                        if (this.kuM >= 100.0f && this.kuO >= getmCdnLogData().getErrNumber() && this.kuN >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kuM >= 100.0f && this.kuO >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kuM >= 100.0f && this.kuN >= getmCdnLogData().getSlowNumber()) {
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
                this.kuM -= 25.0f;
            } else {
                this.kuM -= getmCdnLogData().getSuccRank();
            }
            if (this.kuM < 0.0f) {
                this.kuM = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kuJ) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kuR == null) {
            this.kuR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kuR);
        cDNUpLoadTask.execute(new Object[0]);
        this.kuJ = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kuP = 0;
        this.kuN = 0;
        this.kuO = 0;
        this.kuQ = 0;
        this.kuM = 0.0f;
        this.kuS.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String bws;
        private final int kuN;
        private final int kuO;
        private final int kuP;
        private final String kuV;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kuO = i3;
            this.kuN = i4;
            this.bws = str;
            this.kuV = str2;
            this.mType = i;
            this.kuP = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bVi.addPostData("number", String.valueOf(this.kuP));
            if (this.mType == 1) {
                this.bVi.addPostData("ab_num_error", String.valueOf(this.kuO));
                this.bVi.addPostData(BdStatsConstant.StatsType.ERROR, this.bws);
                this.bVi.addPostData("ab_num_slow", String.valueOf(this.kuN));
                this.bVi.addPostData("time", this.kuV);
            } else if (this.mType == 3) {
                this.bVi.addPostData("ab_num_slow", this.kuN + "");
                this.bVi.addPostData("time", this.kuV);
            } else if (this.mType == 2) {
                this.bVi.addPostData("ab_num_error", this.kuO + "");
                this.bVi.addPostData(BdStatsConstant.StatsType.ERROR, this.bws);
            }
            String postNetData = this.bVi.postNetData();
            if (!this.bVi.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ee */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a mT = u.mT();
                    mT.append("act", "fallback");
                    mT.append("result", "1");
                    mT.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", mT);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.eXh.setmSwitch(false);
                    CDNProblemUploader.this.Om = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a mT2 = u.mT();
                        mT2.append("act", "fallback");
                        mT2.append("result", "2");
                        mT2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT2);
                    } else {
                        a mT3 = u.mT();
                        mT3.append("act", "fallback");
                        mT3.append("result", "0");
                        mT3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.eXh.setmSwitch(false);
                        CDNProblemUploader.this.Om = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    p pVar = new p();
                    pVar.parseJson(optString);
                    if (pVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && pVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && pVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && pVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(pVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.kuJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kuW;

        private CdnErrorJsonData() {
            this.kuW = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kuW.length() != 0) {
                this.kuW.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.kuW.append(i);
        }

        public void clear() {
            this.kuW.setLength(0);
        }

        public String toString() {
            return this.kuW.toString();
        }
    }
}
