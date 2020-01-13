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
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CDNProblemUploader extends p {
    private static Object hSf = new Object();
    private static volatile CDNProblemUploader hSg;
    private n dih;
    private int hRZ;
    private int hSa;
    private int hSb;
    private int hSc;
    private Handler mHandler;
    private final int hRM = 5;
    private final int hRN = 0;
    private final int hRO = 1;
    private final int hRP = 2;
    private final int hRQ = 3;
    private final byte hRR = 0;
    private final byte hRS = 1;
    private int hRT = 0;
    private final int hRU = 5;
    private boolean hRV = false;
    private long sY = 0;
    private final long hRW = 86400000;
    private final float hRX = 100.0f;
    private float hRY = 0.0f;
    private BdAsyncTaskParallel hSd = null;
    private final CdnErrorJsonData hSe = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hRT + 1;
        cDNProblemUploader.hRT = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hSg == null) {
            synchronized (CDNProblemUploader.class) {
                if (hSg == null) {
                    hSg = new CDNProblemUploader();
                }
            }
        }
        return hSg;
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
    public n getmCdnLogData() {
        return this.dih;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hSf) {
            this.dih = nVar;
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
        synchronized (hSf) {
            if (getmCdnLogData() == null) {
                this.hRY += 25.0f;
            } else {
                this.hRY += getmCdnLogData().getErrRank();
            }
            this.hSb++;
            this.hSa++;
            this.hSe.add(i);
            int i3 = this.hSb;
            int i4 = this.hSa;
            int i5 = this.hRZ;
            int i6 = this.hRZ != 0 ? this.hSc / this.hRZ : 0;
            String cdnErrorJsonData = this.hSe.toString();
            if (getmCdnLogData() != null && this.sY > 0 && System.currentTimeMillis() - this.sY > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hRT = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hSb < 5) {
                    i2 = 0;
                } else if (this.hRY < 100.0f || this.hSa < getmCdnLogData().getErrNumber() || this.hRZ < getmCdnLogData().getSlowNumber()) {
                    if (this.hRY >= 100.0f && this.hSa >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hRY < 100.0f || this.hRZ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hSf) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hRY += 10.0f;
                } else {
                    this.hRY += getmCdnLogData().getSlowRank();
                }
                this.hRZ++;
                this.hSc = (int) (this.hSc + j);
                this.hSb++;
                int i4 = this.hSb;
                int i5 = this.hSa;
                int i6 = this.hRZ;
                if (this.hRZ != 0) {
                    i = this.hSc / this.hRZ;
                }
                String cdnErrorJsonData = this.hSe.toString();
                if (getmCdnLogData() != null && this.sY > 0 && System.currentTimeMillis() - this.sY > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hRT = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hSb >= 5) {
                        if (this.hRY >= 100.0f && this.hSa >= getmCdnLogData().getErrNumber() && this.hRZ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hRY >= 100.0f && this.hSa >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hRY >= 100.0f && this.hRZ >= getmCdnLogData().getSlowNumber()) {
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
                this.hRY -= 25.0f;
            } else {
                this.hRY -= getmCdnLogData().getSuccRank();
            }
            if (this.hRY < 0.0f) {
                this.hRY = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hRV) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hSd == null) {
            this.hSd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hSd);
        cDNUpLoadTask.execute(new Object[0]);
        this.hRV = true;
        a gs = s.gs();
        gs.append("act", "fallback");
        gs.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hSb = 0;
        this.hRZ = 0;
        this.hSa = 0;
        this.hSc = 0;
        this.hRY = 0.0f;
        this.hSe.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String awJ;
        private final x cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hRZ;
        private final int hSa;
        private final int hSb;
        private final String hSi;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hSa = i3;
            this.hRZ = i4;
            this.awJ = str;
            this.hSi = str2;
            this.mType = i;
            this.hSb = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cHA.addPostData("number", String.valueOf(this.hSb));
            if (this.mType == 1) {
                this.cHA.addPostData("ab_num_error", String.valueOf(this.hSa));
                this.cHA.addPostData(BdStatsConstant.StatsType.ERROR, this.awJ);
                this.cHA.addPostData("ab_num_slow", String.valueOf(this.hRZ));
                this.cHA.addPostData("time", this.hSi);
            } else if (this.mType == 3) {
                this.cHA.addPostData("ab_num_slow", this.hRZ + "");
                this.cHA.addPostData("time", this.hSi);
            } else if (this.mType == 2) {
                this.cHA.addPostData("ab_num_error", this.hSa + "");
                this.cHA.addPostData(BdStatsConstant.StatsType.ERROR, this.awJ);
            }
            String postNetData = this.cHA.postNetData();
            if (!this.cHA.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: cS */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a gs = s.gs();
                    gs.append("act", "fallback");
                    gs.append("result", "1");
                    gs.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", gs);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.dih.setmSwitch(false);
                    CDNProblemUploader.this.sY = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a gs2 = s.gs();
                        gs2.append("act", "fallback");
                        gs2.append("result", "2");
                        gs2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gs2);
                    } else {
                        a gs3 = s.gs();
                        gs3.append("act", "fallback");
                        gs3.append("result", "0");
                        gs3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gs3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.dih.setmSwitch(false);
                        CDNProblemUploader.this.sY = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    n nVar = new n();
                    nVar.parseJson(optString);
                    if (nVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && nVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && nVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && nVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(nVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.hRV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class CdnErrorJsonData {
        StringBuffer hSj;

        private CdnErrorJsonData() {
            this.hSj = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hSj.length() != 0) {
                this.hSj.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hSj.append(i);
        }

        public void clear() {
            this.hSj.setLength(0);
        }

        public String toString() {
            return this.hSj.toString();
        }
    }
}
