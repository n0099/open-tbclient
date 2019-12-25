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
/* loaded from: classes4.dex */
public class CDNProblemUploader extends p {
    private static Object hOC = new Object();
    private static volatile CDNProblemUploader hOD;
    private n dhU;
    private int hOw;
    private int hOx;
    private int hOy;
    private int hOz;
    private Handler mHandler;
    private final int hOj = 5;
    private final int hOk = 0;
    private final int hOl = 1;
    private final int hOm = 2;
    private final int hOn = 3;
    private final byte hOo = 0;
    private final byte hOp = 1;
    private int hOq = 0;
    private final int hOr = 5;
    private boolean hOs = false;
    private long sX = 0;
    private final long hOt = 86400000;
    private final float hOu = 100.0f;
    private float hOv = 0.0f;
    private BdAsyncTaskParallel hOA = null;
    private final CdnErrorJsonData hOB = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hOq + 1;
        cDNProblemUploader.hOq = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hOD == null) {
            synchronized (CDNProblemUploader.class) {
                if (hOD == null) {
                    hOD = new CDNProblemUploader();
                }
            }
        }
        return hOD;
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
        return this.dhU;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hOC) {
            this.dhU = nVar;
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
        synchronized (hOC) {
            if (getmCdnLogData() == null) {
                this.hOv += 25.0f;
            } else {
                this.hOv += getmCdnLogData().getErrRank();
            }
            this.hOy++;
            this.hOx++;
            this.hOB.add(i);
            int i3 = this.hOy;
            int i4 = this.hOx;
            int i5 = this.hOw;
            int i6 = this.hOw != 0 ? this.hOz / this.hOw : 0;
            String cdnErrorJsonData = this.hOB.toString();
            if (getmCdnLogData() != null && this.sX > 0 && System.currentTimeMillis() - this.sX > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hOq = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hOy < 5) {
                    i2 = 0;
                } else if (this.hOv < 100.0f || this.hOx < getmCdnLogData().getErrNumber() || this.hOw < getmCdnLogData().getSlowNumber()) {
                    if (this.hOv >= 100.0f && this.hOx >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hOv < 100.0f || this.hOw < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hOC) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hOv += 10.0f;
                } else {
                    this.hOv += getmCdnLogData().getSlowRank();
                }
                this.hOw++;
                this.hOz = (int) (this.hOz + j);
                this.hOy++;
                int i4 = this.hOy;
                int i5 = this.hOx;
                int i6 = this.hOw;
                if (this.hOw != 0) {
                    i = this.hOz / this.hOw;
                }
                String cdnErrorJsonData = this.hOB.toString();
                if (getmCdnLogData() != null && this.sX > 0 && System.currentTimeMillis() - this.sX > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hOq = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hOy >= 5) {
                        if (this.hOv >= 100.0f && this.hOx >= getmCdnLogData().getErrNumber() && this.hOw >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hOv >= 100.0f && this.hOx >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hOv >= 100.0f && this.hOw >= getmCdnLogData().getSlowNumber()) {
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
                this.hOv -= 25.0f;
            } else {
                this.hOv -= getmCdnLogData().getSuccRank();
            }
            if (this.hOv < 0.0f) {
                this.hOv = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hOs) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hOA == null) {
            this.hOA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hOA);
        cDNUpLoadTask.execute(new Object[0]);
        this.hOs = true;
        a gt = s.gt();
        gt.append("act", "fallback");
        gt.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hOy = 0;
        this.hOw = 0;
        this.hOx = 0;
        this.hOz = 0;
        this.hOv = 0.0f;
        this.hOB.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String avX;
        private final x cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String hOF;
        private final int hOw;
        private final int hOx;
        private final int hOy;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hOx = i3;
            this.hOw = i4;
            this.avX = str;
            this.hOF = str2;
            this.mType = i;
            this.hOy = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cHo.addPostData("number", String.valueOf(this.hOy));
            if (this.mType == 1) {
                this.cHo.addPostData("ab_num_error", String.valueOf(this.hOx));
                this.cHo.addPostData(BdStatsConstant.StatsType.ERROR, this.avX);
                this.cHo.addPostData("ab_num_slow", String.valueOf(this.hOw));
                this.cHo.addPostData("time", this.hOF);
            } else if (this.mType == 3) {
                this.cHo.addPostData("ab_num_slow", this.hOw + "");
                this.cHo.addPostData("time", this.hOF);
            } else if (this.mType == 2) {
                this.cHo.addPostData("ab_num_error", this.hOx + "");
                this.cHo.addPostData(BdStatsConstant.StatsType.ERROR, this.avX);
            }
            String postNetData = this.cHo.postNetData();
            if (!this.cHo.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    a gt = s.gt();
                    gt.append("act", "fallback");
                    gt.append("result", "1");
                    gt.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", gt);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.dhU.setmSwitch(false);
                    CDNProblemUploader.this.sX = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a gt2 = s.gt();
                        gt2.append("act", "fallback");
                        gt2.append("result", "2");
                        gt2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gt2);
                    } else {
                        a gt3 = s.gt();
                        gt3.append("act", "fallback");
                        gt3.append("result", "0");
                        gt3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gt3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.dhU.setmSwitch(false);
                        CDNProblemUploader.this.sX = System.currentTimeMillis();
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
                CDNProblemUploader.this.hOs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {
        StringBuffer hOG;

        private CdnErrorJsonData() {
            this.hOG = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hOG.length() != 0) {
                this.hOG.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hOG.append(i);
        }

        public void clear() {
            this.hOG.setLength(0);
        }

        public String toString() {
            return this.hOG.toString();
        }
    }
}
