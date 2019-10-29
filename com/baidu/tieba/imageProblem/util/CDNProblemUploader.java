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
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object hbl = new Object();
    private static volatile CDNProblemUploader hbm;
    private m cvc;
    private int hbf;
    private int hbg;
    private int hbh;
    private int hbi;
    private Handler mHandler;
    private final int haS = 5;
    private final int haT = 0;
    private final int haU = 1;
    private final int haV = 2;
    private final int haW = 3;
    private final byte haX = 0;
    private final byte haY = 1;
    private int haZ = 0;
    private final int hba = 5;
    private boolean hbb = false;
    private long qL = 0;
    private final long hbc = 86400000;
    private final float hbd = 100.0f;
    private float hbe = 0.0f;
    private BdAsyncTaskParallel hbj = null;
    private final CdnErrorJsonData hbk = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.haZ + 1;
        cDNProblemUploader.haZ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hbm == null) {
            synchronized (CDNProblemUploader.class) {
                if (hbm == null) {
                    hbm = new CDNProblemUploader();
                }
            }
        }
        return hbm;
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
    public m getmCdnLogData() {
        return this.cvc;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (hbl) {
            this.cvc = mVar;
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
        synchronized (hbl) {
            if (getmCdnLogData() == null) {
                this.hbe += 25.0f;
            } else {
                this.hbe += getmCdnLogData().getErrRank();
            }
            this.hbh++;
            this.hbg++;
            this.hbk.add(i);
            int i3 = this.hbh;
            int i4 = this.hbg;
            int i5 = this.hbf;
            int i6 = this.hbf != 0 ? this.hbi / this.hbf : 0;
            String cdnErrorJsonData = this.hbk.toString();
            if (getmCdnLogData() != null && this.qL > 0 && System.currentTimeMillis() - this.qL > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.haZ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hbh < 5) {
                    i2 = 0;
                } else if (this.hbe < 100.0f || this.hbg < getmCdnLogData().getErrNumber() || this.hbf < getmCdnLogData().getSlowNumber()) {
                    if (this.hbe >= 100.0f && this.hbg >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hbe < 100.0f || this.hbf < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hbl) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hbe += 10.0f;
                } else {
                    this.hbe += getmCdnLogData().getSlowRank();
                }
                this.hbf++;
                this.hbi = (int) (this.hbi + j);
                this.hbh++;
                int i4 = this.hbh;
                int i5 = this.hbg;
                int i6 = this.hbf;
                if (this.hbf != 0) {
                    i = this.hbi / this.hbf;
                }
                String cdnErrorJsonData = this.hbk.toString();
                if (getmCdnLogData() != null && this.qL > 0 && System.currentTimeMillis() - this.qL > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.haZ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hbh >= 5) {
                        if (this.hbe >= 100.0f && this.hbg >= getmCdnLogData().getErrNumber() && this.hbf >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hbe >= 100.0f && this.hbg >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hbe >= 100.0f && this.hbf >= getmCdnLogData().getSlowNumber()) {
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
                this.hbe -= 25.0f;
            } else {
                this.hbe -= getmCdnLogData().getSuccRank();
            }
            if (this.hbe < 0.0f) {
                this.hbe = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hbb) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hbj == null) {
            this.hbj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hbj);
        cDNUpLoadTask.execute(new Object[0]);
        this.hbb = true;
        a fU = s.fU();
        fU.append("act", "fallback");
        fU.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hbh = 0;
        this.hbf = 0;
        this.hbg = 0;
        this.hbi = 0;
        this.hbe = 0.0f;
        this.hbk.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aos;
        private final x bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hbf;
        private final int hbg;
        private final int hbh;
        private final String hbo;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hbg = i3;
            this.hbf = i4;
            this.aos = str;
            this.hbo = str2;
            this.mType = i;
            this.hbh = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bVP.addPostData("number", String.valueOf(this.hbh));
            if (this.mType == 1) {
                this.bVP.addPostData("ab_num_error", String.valueOf(this.hbg));
                this.bVP.addPostData(BdStatsConstant.StatsType.ERROR, this.aos);
                this.bVP.addPostData("ab_num_slow", String.valueOf(this.hbf));
                this.bVP.addPostData("time", this.hbo);
            } else if (this.mType == 3) {
                this.bVP.addPostData("ab_num_slow", this.hbf + "");
                this.bVP.addPostData("time", this.hbo);
            } else if (this.mType == 2) {
                this.bVP.addPostData("ab_num_error", this.hbg + "");
                this.bVP.addPostData(BdStatsConstant.StatsType.ERROR, this.aos);
            }
            String postNetData = this.bVP.postNetData();
            if (!this.bVP.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: cb */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fU = s.fU();
                    fU.append("act", "fallback");
                    fU.append("result", "1");
                    fU.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fU);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.cvc.setmSwitch(false);
                    CDNProblemUploader.this.qL = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fU2 = s.fU();
                        fU2.append("act", "fallback");
                        fU2.append("result", "2");
                        fU2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fU2);
                    } else {
                        a fU3 = s.fU();
                        fU3.append("act", "fallback");
                        fU3.append("result", "0");
                        fU3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fU3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.cvc.setmSwitch(false);
                        CDNProblemUploader.this.qL = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    m mVar = new m();
                    mVar.parseJson(optString);
                    if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(mVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.hbb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer hbp;

        private CdnErrorJsonData() {
            this.hbp = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hbp.length() != 0) {
                this.hbp.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hbp.append(i);
        }

        public void clear() {
            this.hbp.setLength(0);
        }

        public String toString() {
            return this.hbp.toString();
        }
    }
}
