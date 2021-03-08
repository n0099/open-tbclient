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
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.u;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CDNProblemUploader extends s {
    private static volatile CDNProblemUploader kZP;
    private static Object lockObject = new Object();
    private r fsv;
    private int kZJ;
    private int kZK;
    private int kZL;
    private int kZM;
    private Handler mHandler;
    private final int kZw = 5;
    private final int kZx = 0;
    private final int kZy = 1;
    private final int kZz = 2;
    private final int kZA = 3;
    private final byte kZB = 0;
    private final byte kZC = 1;
    private int kZD = 0;
    private final int kZE = 5;
    private boolean kZF = false;
    private long QG = 0;
    private final long kZG = 86400000;
    private final float kZH = 100.0f;
    private float kZI = 0.0f;
    private BdAsyncTaskParallel kZN = null;
    private final CdnErrorJsonData kZO = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kZD + 1;
        cDNProblemUploader.kZD = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kZP == null) {
            synchronized (CDNProblemUploader.class) {
                if (kZP == null) {
                    kZP = new CDNProblemUploader();
                }
            }
        }
        return kZP;
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

    @Override // com.baidu.tbadk.core.util.s
    public r getmCdnLogData() {
        return this.fsv;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setmCdnLogData(r rVar) {
        synchronized (lockObject) {
            this.fsv = rVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.kZI += 25.0f;
            } else {
                this.kZI += getmCdnLogData().getErrRank();
            }
            this.kZL++;
            this.kZK++;
            this.kZO.add(i);
            int i3 = this.kZL;
            int i4 = this.kZK;
            int i5 = this.kZJ;
            int i6 = this.kZJ != 0 ? this.kZM / this.kZJ : 0;
            String cdnErrorJsonData = this.kZO.toString();
            if (getmCdnLogData() != null && this.QG > 0 && System.currentTimeMillis() - this.QG > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kZD = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kZL < 5) {
                    i2 = 0;
                } else if (this.kZI < 100.0f || this.kZK < getmCdnLogData().getErrNumber() || this.kZJ < getmCdnLogData().getSlowNumber()) {
                    if (this.kZI >= 100.0f && this.kZK >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kZI < 100.0f || this.kZJ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kZI += 10.0f;
                } else {
                    this.kZI += getmCdnLogData().getSlowRank();
                }
                this.kZJ++;
                this.kZM = (int) (this.kZM + j);
                this.kZL++;
                int i4 = this.kZL;
                int i5 = this.kZK;
                int i6 = this.kZJ;
                if (this.kZJ != 0) {
                    i = this.kZM / this.kZJ;
                }
                String cdnErrorJsonData = this.kZO.toString();
                if (getmCdnLogData() != null && this.QG > 0 && System.currentTimeMillis() - this.QG > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kZD = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kZL >= 5) {
                        if (this.kZI >= 100.0f && this.kZK >= getmCdnLogData().getErrNumber() && this.kZJ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kZI >= 100.0f && this.kZK >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kZI >= 100.0f && this.kZJ >= getmCdnLogData().getSlowNumber()) {
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
                this.kZI -= 25.0f;
            } else {
                this.kZI -= getmCdnLogData().getSuccRank();
            }
            if (this.kZI < 0.0f) {
                this.kZI = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kZF) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kZN == null) {
            this.kZN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kZN);
        cDNUpLoadTask.execute(new Object[0]);
        this.kZF = true;
        a pg = u.pg();
        pg.append("act", "fallback");
        pg.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", pg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kZL = 0;
        this.kZJ = 0;
        this.kZK = 0;
        this.kZM = 0;
        this.kZI = 0.0f;
        this.kZO.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bLn;
        private final aa cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kZJ;
        private final int kZK;
        private final int kZL;
        private final String kZR;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kZK = i3;
            this.kZJ = i4;
            this.bLn = str;
            this.kZR = str2;
            this.mType = i;
            this.kZL = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cnM.addPostData("number", String.valueOf(this.kZL));
            if (this.mType == 1) {
                this.cnM.addPostData("ab_num_error", String.valueOf(this.kZK));
                this.cnM.addPostData(BdStatsConstant.StatsType.ERROR, this.bLn);
                this.cnM.addPostData("ab_num_slow", String.valueOf(this.kZJ));
                this.cnM.addPostData("time", this.kZR);
            } else if (this.mType == 3) {
                this.cnM.addPostData("ab_num_slow", this.kZJ + "");
                this.cnM.addPostData("time", this.kZR);
            } else if (this.mType == 2) {
                this.cnM.addPostData("ab_num_error", this.kZK + "");
                this.cnM.addPostData(BdStatsConstant.StatsType.ERROR, this.bLn);
            }
            String postNetData = this.cnM.postNetData();
            if (!this.cnM.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: ex */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a pg = u.pg();
                    pg.append("act", "fallback");
                    pg.append("result", "1");
                    pg.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", pg);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.fsv.setmSwitch(false);
                    CDNProblemUploader.this.QG = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                        a pg2 = u.pg();
                        pg2.append("act", "fallback");
                        pg2.append("result", "2");
                        pg2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pg2);
                    } else {
                        a pg3 = u.pg();
                        pg3.append("act", "fallback");
                        pg3.append("result", "0");
                        pg3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pg3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.fsv.setmSwitch(false);
                        CDNProblemUploader.this.QG = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    r rVar = new r();
                    rVar.parseJson(optString);
                    if (rVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && rVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && rVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && rVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(rVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.kZF = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class CdnErrorJsonData {
        StringBuffer kZS;

        private CdnErrorJsonData() {
            this.kZS = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kZS.length() != 0) {
                this.kZS.append(",");
            }
            this.kZS.append(i);
        }

        public void clear() {
            this.kZS.setLength(0);
        }

        public String toString() {
            return this.kZS.toString();
        }
    }
}
