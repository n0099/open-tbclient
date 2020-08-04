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
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.z;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader jvt;
    private static Object lockObject = new Object();
    private p eqb;
    private int jvn;
    private int jvo;
    private int jvp;
    private int jvq;
    private Handler mHandler;
    private final int jva = 5;
    private final int jvb = 0;
    private final int jvc = 1;
    private final int jvd = 2;
    private final int jve = 3;
    private final byte jvf = 0;
    private final byte jvg = 1;
    private int jvh = 0;
    private final int jvi = 5;
    private boolean jvj = false;
    private long MX = 0;
    private final long jvk = 86400000;
    private final float jvl = 100.0f;
    private float jvm = 0.0f;
    private BdAsyncTaskParallel jvr = null;
    private final CdnErrorJsonData jvs = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.jvh + 1;
        cDNProblemUploader.jvh = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (jvt == null) {
            synchronized (CDNProblemUploader.class) {
                if (jvt == null) {
                    jvt = new CDNProblemUploader();
                }
            }
        }
        return jvt;
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
        return this.eqb;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eqb = pVar;
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
                this.jvm += 25.0f;
            } else {
                this.jvm += getmCdnLogData().getErrRank();
            }
            this.jvp++;
            this.jvo++;
            this.jvs.add(i);
            int i3 = this.jvp;
            int i4 = this.jvo;
            int i5 = this.jvn;
            int i6 = this.jvn != 0 ? this.jvq / this.jvn : 0;
            String cdnErrorJsonData = this.jvs.toString();
            if (getmCdnLogData() != null && this.MX > 0 && System.currentTimeMillis() - this.MX > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.jvh = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.jvp < 5) {
                    i2 = 0;
                } else if (this.jvm < 100.0f || this.jvo < getmCdnLogData().getErrNumber() || this.jvn < getmCdnLogData().getSlowNumber()) {
                    if (this.jvm >= 100.0f && this.jvo >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.jvm < 100.0f || this.jvn < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
                    this.jvm += 10.0f;
                } else {
                    this.jvm += getmCdnLogData().getSlowRank();
                }
                this.jvn++;
                this.jvq = (int) (this.jvq + j);
                this.jvp++;
                int i4 = this.jvp;
                int i5 = this.jvo;
                int i6 = this.jvn;
                if (this.jvn != 0) {
                    i = this.jvq / this.jvn;
                }
                String cdnErrorJsonData = this.jvs.toString();
                if (getmCdnLogData() != null && this.MX > 0 && System.currentTimeMillis() - this.MX > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.jvh = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.jvp >= 5) {
                        if (this.jvm >= 100.0f && this.jvo >= getmCdnLogData().getErrNumber() && this.jvn >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.jvm >= 100.0f && this.jvo >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.jvm >= 100.0f && this.jvn >= getmCdnLogData().getSlowNumber()) {
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
                this.jvm -= 25.0f;
            } else {
                this.jvm -= getmCdnLogData().getSuccRank();
            }
            if (this.jvm < 0.0f) {
                this.jvm = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.jvj) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.jvr == null) {
            this.jvr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.jvr);
        cDNUpLoadTask.execute(new Object[0]);
        this.jvj = true;
        a lo = u.lo();
        lo.append("act", "fallback");
        lo.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jvp = 0;
        this.jvn = 0;
        this.jvo = 0;
        this.jvq = 0;
        this.jvm = 0.0f;
        this.jvs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bhS;
        private final z byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int jvn;
        private final int jvo;
        private final int jvp;
        private final String jvv;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.jvo = i3;
            this.jvn = i4;
            this.bhS = str;
            this.jvv = str2;
            this.mType = i;
            this.jvp = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.byq.addPostData("number", String.valueOf(this.jvp));
            if (this.mType == 1) {
                this.byq.addPostData("ab_num_error", String.valueOf(this.jvo));
                this.byq.addPostData(BdStatsConstant.StatsType.ERROR, this.bhS);
                this.byq.addPostData("ab_num_slow", String.valueOf(this.jvn));
                this.byq.addPostData("time", this.jvv);
            } else if (this.mType == 3) {
                this.byq.addPostData("ab_num_slow", this.jvn + "");
                this.byq.addPostData("time", this.jvv);
            } else if (this.mType == 2) {
                this.byq.addPostData("ab_num_error", this.jvo + "");
                this.byq.addPostData(BdStatsConstant.StatsType.ERROR, this.bhS);
            }
            String postNetData = this.byq.postNetData();
            if (!this.byq.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: dB */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a lo = u.lo();
                    lo.append("act", "fallback");
                    lo.append("result", "1");
                    lo.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", lo);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.eqb.setmSwitch(false);
                    CDNProblemUploader.this.MX = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a lo2 = u.lo();
                        lo2.append("act", "fallback");
                        lo2.append("result", "2");
                        lo2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", lo2);
                    } else {
                        a lo3 = u.lo();
                        lo3.append("act", "fallback");
                        lo3.append("result", "0");
                        lo3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", lo3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.eqb.setmSwitch(false);
                        CDNProblemUploader.this.MX = System.currentTimeMillis();
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
                CDNProblemUploader.this.jvj = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer jvw;

        private CdnErrorJsonData() {
            this.jvw = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.jvw.length() != 0) {
                this.jvw.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.jvw.append(i);
        }

        public void clear() {
            this.jvw.setLength(0);
        }

        public String toString() {
            return this.jvw.toString();
        }
    }
}
