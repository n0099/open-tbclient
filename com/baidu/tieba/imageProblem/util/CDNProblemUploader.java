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
/* loaded from: classes8.dex */
public class CDNProblemUploader extends s {
    private static volatile CDNProblemUploader kXz;
    private static Object lockObject = new Object();
    private r fqU;
    private int kXt;
    private int kXu;
    private int kXv;
    private int kXw;
    private Handler mHandler;
    private final int kXg = 5;
    private final int kXh = 0;
    private final int kXi = 1;
    private final int kXj = 2;
    private final int kXk = 3;
    private final byte kXl = 0;
    private final byte kXm = 1;
    private int kXn = 0;
    private final int kXo = 5;
    private boolean kXp = false;
    private long Pg = 0;
    private final long kXq = 86400000;
    private final float kXr = 100.0f;
    private float kXs = 0.0f;
    private BdAsyncTaskParallel kXx = null;
    private final CdnErrorJsonData kXy = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kXn + 1;
        cDNProblemUploader.kXn = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kXz == null) {
            synchronized (CDNProblemUploader.class) {
                if (kXz == null) {
                    kXz = new CDNProblemUploader();
                }
            }
        }
        return kXz;
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
        return this.fqU;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setmCdnLogData(r rVar) {
        synchronized (lockObject) {
            this.fqU = rVar;
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
                this.kXs += 25.0f;
            } else {
                this.kXs += getmCdnLogData().getErrRank();
            }
            this.kXv++;
            this.kXu++;
            this.kXy.add(i);
            int i3 = this.kXv;
            int i4 = this.kXu;
            int i5 = this.kXt;
            int i6 = this.kXt != 0 ? this.kXw / this.kXt : 0;
            String cdnErrorJsonData = this.kXy.toString();
            if (getmCdnLogData() != null && this.Pg > 0 && System.currentTimeMillis() - this.Pg > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kXn = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kXv < 5) {
                    i2 = 0;
                } else if (this.kXs < 100.0f || this.kXu < getmCdnLogData().getErrNumber() || this.kXt < getmCdnLogData().getSlowNumber()) {
                    if (this.kXs >= 100.0f && this.kXu >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kXs < 100.0f || this.kXt < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.kXs += 10.0f;
                } else {
                    this.kXs += getmCdnLogData().getSlowRank();
                }
                this.kXt++;
                this.kXw = (int) (this.kXw + j);
                this.kXv++;
                int i4 = this.kXv;
                int i5 = this.kXu;
                int i6 = this.kXt;
                if (this.kXt != 0) {
                    i = this.kXw / this.kXt;
                }
                String cdnErrorJsonData = this.kXy.toString();
                if (getmCdnLogData() != null && this.Pg > 0 && System.currentTimeMillis() - this.Pg > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kXn = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kXv >= 5) {
                        if (this.kXs >= 100.0f && this.kXu >= getmCdnLogData().getErrNumber() && this.kXt >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kXs >= 100.0f && this.kXu >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kXs >= 100.0f && this.kXt >= getmCdnLogData().getSlowNumber()) {
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
                this.kXs -= 25.0f;
            } else {
                this.kXs -= getmCdnLogData().getSuccRank();
            }
            if (this.kXs < 0.0f) {
                this.kXs = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kXp) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kXx == null) {
            this.kXx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kXx);
        cDNUpLoadTask.execute(new Object[0]);
        this.kXp = true;
        a pg = u.pg();
        pg.append("act", "fallback");
        pg.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", pg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kXv = 0;
        this.kXt = 0;
        this.kXu = 0;
        this.kXw = 0;
        this.kXs = 0.0f;
        this.kXy.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bJN;
        private final aa cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String kXB;
        private final int kXt;
        private final int kXu;
        private final int kXv;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kXu = i3;
            this.kXt = i4;
            this.bJN = str;
            this.kXB = str2;
            this.mType = i;
            this.kXv = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cml.addPostData("number", String.valueOf(this.kXv));
            if (this.mType == 1) {
                this.cml.addPostData("ab_num_error", String.valueOf(this.kXu));
                this.cml.addPostData(BdStatsConstant.StatsType.ERROR, this.bJN);
                this.cml.addPostData("ab_num_slow", String.valueOf(this.kXt));
                this.cml.addPostData("time", this.kXB);
            } else if (this.mType == 3) {
                this.cml.addPostData("ab_num_slow", this.kXt + "");
                this.cml.addPostData("time", this.kXB);
            } else if (this.mType == 2) {
                this.cml.addPostData("ab_num_error", this.kXu + "");
                this.cml.addPostData(BdStatsConstant.StatsType.ERROR, this.bJN);
            }
            String postNetData = this.cml.postNetData();
            if (!this.cml.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: ev */
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
                    CDNProblemUploader.this.fqU.setmSwitch(false);
                    CDNProblemUploader.this.Pg = System.currentTimeMillis();
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
                        CDNProblemUploader.this.fqU.setmSwitch(false);
                        CDNProblemUploader.this.Pg = System.currentTimeMillis();
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
                CDNProblemUploader.this.kXp = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class CdnErrorJsonData {
        StringBuffer kXC;

        private CdnErrorJsonData() {
            this.kXC = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kXC.length() != 0) {
                this.kXC.append(",");
            }
            this.kXC.append(i);
        }

        public void clear() {
            this.kXC.setLength(0);
        }

        public String toString() {
            return this.kXC.toString();
        }
    }
}
