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
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNProblemUploader extends q {
    private static volatile CDNProblemUploader jmN;
    private static Object lockObject = new Object();
    private p ejO;
    private int jmH;
    private int jmI;
    private int jmJ;
    private int jmK;
    private Handler mHandler;
    private final int jmu = 5;
    private final int jmv = 0;
    private final int jmw = 1;
    private final int jmx = 2;
    private final int jmy = 3;
    private final byte jmz = 0;
    private final byte jmA = 1;
    private int jmB = 0;
    private final int jmC = 5;
    private boolean jmD = false;
    private long MY = 0;
    private final long jmE = 86400000;
    private final float jmF = 100.0f;
    private float jmG = 0.0f;
    private BdAsyncTaskParallel jmL = null;
    private final CdnErrorJsonData jmM = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.jmB + 1;
        cDNProblemUploader.jmB = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (jmN == null) {
            synchronized (CDNProblemUploader.class) {
                if (jmN == null) {
                    jmN = new CDNProblemUploader();
                }
            }
        }
        return jmN;
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
    public p getmCdnLogData() {
        return this.ejO;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.ejO = pVar;
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
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.jmG += 25.0f;
            } else {
                this.jmG += getmCdnLogData().getErrRank();
            }
            this.jmJ++;
            this.jmI++;
            this.jmM.add(i);
            int i3 = this.jmJ;
            int i4 = this.jmI;
            int i5 = this.jmH;
            int i6 = this.jmH != 0 ? this.jmK / this.jmH : 0;
            String cdnErrorJsonData = this.jmM.toString();
            if (getmCdnLogData() != null && this.MY > 0 && System.currentTimeMillis() - this.MY > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.jmB = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.jmJ < 5) {
                    i2 = 0;
                } else if (this.jmG < 100.0f || this.jmI < getmCdnLogData().getErrNumber() || this.jmH < getmCdnLogData().getSlowNumber()) {
                    if (this.jmG >= 100.0f && this.jmI >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.jmG < 100.0f || this.jmH < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.jmG += 10.0f;
                } else {
                    this.jmG += getmCdnLogData().getSlowRank();
                }
                this.jmH++;
                this.jmK = (int) (this.jmK + j);
                this.jmJ++;
                int i4 = this.jmJ;
                int i5 = this.jmI;
                int i6 = this.jmH;
                if (this.jmH != 0) {
                    i = this.jmK / this.jmH;
                }
                String cdnErrorJsonData = this.jmM.toString();
                if (getmCdnLogData() != null && this.MY > 0 && System.currentTimeMillis() - this.MY > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.jmB = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.jmJ >= 5) {
                        if (this.jmG >= 100.0f && this.jmI >= getmCdnLogData().getErrNumber() && this.jmH >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.jmG >= 100.0f && this.jmI >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.jmG >= 100.0f && this.jmH >= getmCdnLogData().getSlowNumber()) {
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
                this.jmG -= 25.0f;
            } else {
                this.jmG -= getmCdnLogData().getSuccRank();
            }
            if (this.jmG < 0.0f) {
                this.jmG = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.jmD) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.jmL == null) {
            this.jmL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.jmL);
        cDNUpLoadTask.execute(new Object[0]);
        this.jmD = true;
        a lo = t.lo();
        lo.append("act", "fallback");
        lo.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jmJ = 0;
        this.jmH = 0;
        this.jmI = 0;
        this.jmK = 0;
        this.jmG = 0.0f;
        this.jmM.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bhz;
        private final y byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int jmH;
        private final int jmI;
        private final int jmJ;
        private final String jmP;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.jmI = i3;
            this.jmH = i4;
            this.bhz = str;
            this.jmP = str2;
            this.mType = i;
            this.jmJ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.byb.addPostData("number", String.valueOf(this.jmJ));
            if (this.mType == 1) {
                this.byb.addPostData("ab_num_error", String.valueOf(this.jmI));
                this.byb.addPostData(BdStatsConstant.StatsType.ERROR, this.bhz);
                this.byb.addPostData("ab_num_slow", String.valueOf(this.jmH));
                this.byb.addPostData("time", this.jmP);
            } else if (this.mType == 3) {
                this.byb.addPostData("ab_num_slow", this.jmH + "");
                this.byb.addPostData("time", this.jmP);
            } else if (this.mType == 2) {
                this.byb.addPostData("ab_num_error", this.jmI + "");
                this.byb.addPostData(BdStatsConstant.StatsType.ERROR, this.bhz);
            }
            String postNetData = this.byb.postNetData();
            if (!this.byb.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: du */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a lo = t.lo();
                    lo.append("act", "fallback");
                    lo.append("result", "1");
                    lo.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", lo);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ejO.setmSwitch(false);
                    CDNProblemUploader.this.MY = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a lo2 = t.lo();
                        lo2.append("act", "fallback");
                        lo2.append("result", "2");
                        lo2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", lo2);
                    } else {
                        a lo3 = t.lo();
                        lo3.append("act", "fallback");
                        lo3.append("result", "0");
                        lo3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", lo3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ejO.setmSwitch(false);
                        CDNProblemUploader.this.MY = System.currentTimeMillis();
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
                CDNProblemUploader.this.jmD = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer jmQ;

        private CdnErrorJsonData() {
            this.jmQ = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.jmQ.length() != 0) {
                this.jmQ.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.jmQ.append(i);
        }

        public void clear() {
            this.jmQ.setLength(0);
        }

        public String toString() {
            return this.jmQ.toString();
        }
    }
}
