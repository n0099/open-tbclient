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
/* loaded from: classes6.dex */
public class CDNProblemUploader extends p {
    private static Object hVR = new Object();
    private static volatile CDNProblemUploader hVS;
    private n dmO;
    private int hVL;
    private int hVM;
    private int hVN;
    private int hVO;
    private Handler mHandler;
    private final int hVy = 5;
    private final int hVz = 0;
    private final int hVA = 1;
    private final int hVB = 2;
    private final int hVC = 3;
    private final byte hVD = 0;
    private final byte hVE = 1;
    private int hVF = 0;
    private final int hVG = 5;
    private boolean hVH = false;
    private long tl = 0;
    private final long hVI = 86400000;
    private final float hVJ = 100.0f;
    private float hVK = 0.0f;
    private BdAsyncTaskParallel hVP = null;
    private final CdnErrorJsonData hVQ = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hVF + 1;
        cDNProblemUploader.hVF = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hVS == null) {
            synchronized (CDNProblemUploader.class) {
                if (hVS == null) {
                    hVS = new CDNProblemUploader();
                }
            }
        }
        return hVS;
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
        return this.dmO;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hVR) {
            this.dmO = nVar;
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
        synchronized (hVR) {
            if (getmCdnLogData() == null) {
                this.hVK += 25.0f;
            } else {
                this.hVK += getmCdnLogData().getErrRank();
            }
            this.hVN++;
            this.hVM++;
            this.hVQ.add(i);
            int i3 = this.hVN;
            int i4 = this.hVM;
            int i5 = this.hVL;
            int i6 = this.hVL != 0 ? this.hVO / this.hVL : 0;
            String cdnErrorJsonData = this.hVQ.toString();
            if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hVF = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hVN < 5) {
                    i2 = 0;
                } else if (this.hVK < 100.0f || this.hVM < getmCdnLogData().getErrNumber() || this.hVL < getmCdnLogData().getSlowNumber()) {
                    if (this.hVK >= 100.0f && this.hVM >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hVK < 100.0f || this.hVL < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hVR) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hVK += 10.0f;
                } else {
                    this.hVK += getmCdnLogData().getSlowRank();
                }
                this.hVL++;
                this.hVO = (int) (this.hVO + j);
                this.hVN++;
                int i4 = this.hVN;
                int i5 = this.hVM;
                int i6 = this.hVL;
                if (this.hVL != 0) {
                    i = this.hVO / this.hVL;
                }
                String cdnErrorJsonData = this.hVQ.toString();
                if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hVF = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hVN >= 5) {
                        if (this.hVK >= 100.0f && this.hVM >= getmCdnLogData().getErrNumber() && this.hVL >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hVK >= 100.0f && this.hVM >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hVK >= 100.0f && this.hVL >= getmCdnLogData().getSlowNumber()) {
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
                this.hVK -= 25.0f;
            } else {
                this.hVK -= getmCdnLogData().getSuccRank();
            }
            if (this.hVK < 0.0f) {
                this.hVK = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hVH) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hVP == null) {
            this.hVP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hVP);
        cDNUpLoadTask.execute(new Object[0]);
        this.hVH = true;
        a gs = s.gs();
        gs.append("act", "fallback");
        gs.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hVN = 0;
        this.hVL = 0;
        this.hVM = 0;
        this.hVO = 0;
        this.hVK = 0.0f;
        this.hVQ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aBp;
        private final x cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hVL;
        private final int hVM;
        private final int hVN;
        private final String hVU;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hVM = i3;
            this.hVL = i4;
            this.aBp = str;
            this.hVU = str2;
            this.mType = i;
            this.hVN = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cLQ.addPostData("number", String.valueOf(this.hVN));
            if (this.mType == 1) {
                this.cLQ.addPostData("ab_num_error", String.valueOf(this.hVM));
                this.cLQ.addPostData(BdStatsConstant.StatsType.ERROR, this.aBp);
                this.cLQ.addPostData("ab_num_slow", String.valueOf(this.hVL));
                this.cLQ.addPostData("time", this.hVU);
            } else if (this.mType == 3) {
                this.cLQ.addPostData("ab_num_slow", this.hVL + "");
                this.cLQ.addPostData("time", this.hVU);
            } else if (this.mType == 2) {
                this.cLQ.addPostData("ab_num_error", this.hVM + "");
                this.cLQ.addPostData(BdStatsConstant.StatsType.ERROR, this.aBp);
            }
            String postNetData = this.cLQ.postNetData();
            if (!this.cLQ.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.dmO.setmSwitch(false);
                    CDNProblemUploader.this.tl = System.currentTimeMillis();
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
                        CDNProblemUploader.this.dmO.setmSwitch(false);
                        CDNProblemUploader.this.tl = System.currentTimeMillis();
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
                CDNProblemUploader.this.hVH = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer hVV;

        private CdnErrorJsonData() {
            this.hVV = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hVV.length() != 0) {
                this.hVV.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hVV.append(i);
        }

        public void clear() {
            this.hVV.setLength(0);
        }

        public String toString() {
            return this.hVV.toString();
        }
    }
}
