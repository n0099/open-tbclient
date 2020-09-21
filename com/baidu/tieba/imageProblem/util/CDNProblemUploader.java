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
    private static volatile CDNProblemUploader jTw;
    private static Object lockObject = new Object();
    private p eCE;
    private int jTq;
    private int jTr;
    private int jTs;
    private int jTt;
    private Handler mHandler;
    private final int jTd = 5;
    private final int jTe = 0;
    private final int jTf = 1;
    private final int jTg = 2;
    private final int jTh = 3;
    private final byte jTi = 0;
    private final byte jTj = 1;
    private int jTk = 0;
    private final int jTl = 5;
    private boolean jTm = false;
    private long NV = 0;
    private final long jTn = 86400000;
    private final float jTo = 100.0f;
    private float jTp = 0.0f;
    private BdAsyncTaskParallel jTu = null;
    private final CdnErrorJsonData jTv = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.jTk + 1;
        cDNProblemUploader.jTk = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (jTw == null) {
            synchronized (CDNProblemUploader.class) {
                if (jTw == null) {
                    jTw = new CDNProblemUploader();
                }
            }
        }
        return jTw;
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
        return this.eCE;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eCE = pVar;
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
                this.jTp += 25.0f;
            } else {
                this.jTp += getmCdnLogData().getErrRank();
            }
            this.jTs++;
            this.jTr++;
            this.jTv.add(i);
            int i3 = this.jTs;
            int i4 = this.jTr;
            int i5 = this.jTq;
            int i6 = this.jTq != 0 ? this.jTt / this.jTq : 0;
            String cdnErrorJsonData = this.jTv.toString();
            if (getmCdnLogData() != null && this.NV > 0 && System.currentTimeMillis() - this.NV > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.jTk = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.jTs < 5) {
                    i2 = 0;
                } else if (this.jTp < 100.0f || this.jTr < getmCdnLogData().getErrNumber() || this.jTq < getmCdnLogData().getSlowNumber()) {
                    if (this.jTp >= 100.0f && this.jTr >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.jTp < 100.0f || this.jTq < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.jTp += 10.0f;
                } else {
                    this.jTp += getmCdnLogData().getSlowRank();
                }
                this.jTq++;
                this.jTt = (int) (this.jTt + j);
                this.jTs++;
                int i4 = this.jTs;
                int i5 = this.jTr;
                int i6 = this.jTq;
                if (this.jTq != 0) {
                    i = this.jTt / this.jTq;
                }
                String cdnErrorJsonData = this.jTv.toString();
                if (getmCdnLogData() != null && this.NV > 0 && System.currentTimeMillis() - this.NV > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.jTk = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.jTs >= 5) {
                        if (this.jTp >= 100.0f && this.jTr >= getmCdnLogData().getErrNumber() && this.jTq >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.jTp >= 100.0f && this.jTr >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.jTp >= 100.0f && this.jTq >= getmCdnLogData().getSlowNumber()) {
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
                this.jTp -= 25.0f;
            } else {
                this.jTp -= getmCdnLogData().getSuccRank();
            }
            if (this.jTp < 0.0f) {
                this.jTp = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.jTm) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.jTu == null) {
            this.jTu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.jTu);
        cDNUpLoadTask.execute(new Object[0]);
        this.jTm = true;
        a mS = u.mS();
        mS.append("act", "fallback");
        mS.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jTs = 0;
        this.jTq = 0;
        this.jTr = 0;
        this.jTt = 0;
        this.jTp = 0.0f;
        this.jTv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String bqy;
        private final int jTq;
        private final int jTr;
        private final int jTs;
        private final String jTy;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.jTr = i3;
            this.jTq = i4;
            this.bqy = str;
            this.jTy = str2;
            this.mType = i;
            this.jTs = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bGb.addPostData("number", String.valueOf(this.jTs));
            if (this.mType == 1) {
                this.bGb.addPostData("ab_num_error", String.valueOf(this.jTr));
                this.bGb.addPostData(BdStatsConstant.StatsType.ERROR, this.bqy);
                this.bGb.addPostData("ab_num_slow", String.valueOf(this.jTq));
                this.bGb.addPostData("time", this.jTy);
            } else if (this.mType == 3) {
                this.bGb.addPostData("ab_num_slow", this.jTq + "");
                this.bGb.addPostData("time", this.jTy);
            } else if (this.mType == 2) {
                this.bGb.addPostData("ab_num_error", this.jTr + "");
                this.bGb.addPostData(BdStatsConstant.StatsType.ERROR, this.bqy);
            }
            String postNetData = this.bGb.postNetData();
            if (!this.bGb.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: dU */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a mS = u.mS();
                    mS.append("act", "fallback");
                    mS.append("result", "1");
                    mS.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", mS);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.eCE.setmSwitch(false);
                    CDNProblemUploader.this.NV = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a mS2 = u.mS();
                        mS2.append("act", "fallback");
                        mS2.append("result", "2");
                        mS2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mS2);
                    } else {
                        a mS3 = u.mS();
                        mS3.append("act", "fallback");
                        mS3.append("result", "0");
                        mS3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mS3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.eCE.setmSwitch(false);
                        CDNProblemUploader.this.NV = System.currentTimeMillis();
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
                CDNProblemUploader.this.jTm = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer jTz;

        private CdnErrorJsonData() {
            this.jTz = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.jTz.length() != 0) {
                this.jTz.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.jTz.append(i);
        }

        public void clear() {
            this.jTz.setLength(0);
        }

        public String toString() {
            return this.jTz.toString();
        }
    }
}
