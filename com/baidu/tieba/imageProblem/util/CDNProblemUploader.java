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
    private static Object iFI = new Object();
    private static volatile CDNProblemUploader iFJ;
    private n dMJ;
    private int iFC;
    private int iFD;
    private int iFE;
    private int iFF;
    private Handler mHandler;
    private final int iFp = 5;
    private final int iFq = 0;
    private final int iFr = 1;
    private final int iFs = 2;
    private final int iFt = 3;
    private final byte iFu = 0;
    private final byte iFv = 1;
    private int iFw = 0;
    private final int iFx = 5;
    private boolean iFy = false;
    private long Mh = 0;
    private final long iFz = 86400000;
    private final float iFA = 100.0f;
    private float iFB = 0.0f;
    private BdAsyncTaskParallel iFG = null;
    private final CdnErrorJsonData iFH = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.iFw + 1;
        cDNProblemUploader.iFw = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (iFJ == null) {
            synchronized (CDNProblemUploader.class) {
                if (iFJ == null) {
                    iFJ = new CDNProblemUploader();
                }
            }
        }
        return iFJ;
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
        return this.dMJ;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (iFI) {
            this.dMJ = nVar;
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
        synchronized (iFI) {
            if (getmCdnLogData() == null) {
                this.iFB += 25.0f;
            } else {
                this.iFB += getmCdnLogData().getErrRank();
            }
            this.iFE++;
            this.iFD++;
            this.iFH.add(i);
            int i3 = this.iFE;
            int i4 = this.iFD;
            int i5 = this.iFC;
            int i6 = this.iFC != 0 ? this.iFF / this.iFC : 0;
            String cdnErrorJsonData = this.iFH.toString();
            if (getmCdnLogData() != null && this.Mh > 0 && System.currentTimeMillis() - this.Mh > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.iFw = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.iFE < 5) {
                    i2 = 0;
                } else if (this.iFB < 100.0f || this.iFD < getmCdnLogData().getErrNumber() || this.iFC < getmCdnLogData().getSlowNumber()) {
                    if (this.iFB >= 100.0f && this.iFD >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.iFB < 100.0f || this.iFC < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (iFI) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.iFB += 10.0f;
                } else {
                    this.iFB += getmCdnLogData().getSlowRank();
                }
                this.iFC++;
                this.iFF = (int) (this.iFF + j);
                this.iFE++;
                int i4 = this.iFE;
                int i5 = this.iFD;
                int i6 = this.iFC;
                if (this.iFC != 0) {
                    i = this.iFF / this.iFC;
                }
                String cdnErrorJsonData = this.iFH.toString();
                if (getmCdnLogData() != null && this.Mh > 0 && System.currentTimeMillis() - this.Mh > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.iFw = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.iFE >= 5) {
                        if (this.iFB >= 100.0f && this.iFD >= getmCdnLogData().getErrNumber() && this.iFC >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.iFB >= 100.0f && this.iFD >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.iFB >= 100.0f && this.iFC >= getmCdnLogData().getSlowNumber()) {
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
                this.iFB -= 25.0f;
            } else {
                this.iFB -= getmCdnLogData().getSuccRank();
            }
            if (this.iFB < 0.0f) {
                this.iFB = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.iFy) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.iFG == null) {
            this.iFG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.iFG);
        cDNUpLoadTask.execute(new Object[0]);
        this.iFy = true;
        a kW = s.kW();
        kW.append("act", "fallback");
        kW.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", kW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iFE = 0;
        this.iFC = 0;
        this.iFD = 0;
        this.iFF = 0;
        this.iFB = 0.0f;
        this.iFH.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aUW;
        private final x blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int iFC;
        private final int iFD;
        private final int iFE;
        private final String iFL;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.iFD = i3;
            this.iFC = i4;
            this.aUW = str;
            this.iFL = str2;
            this.mType = i;
            this.iFE = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.blF.addPostData("number", String.valueOf(this.iFE));
            if (this.mType == 1) {
                this.blF.addPostData("ab_num_error", String.valueOf(this.iFD));
                this.blF.addPostData(BdStatsConstant.StatsType.ERROR, this.aUW);
                this.blF.addPostData("ab_num_slow", String.valueOf(this.iFC));
                this.blF.addPostData("time", this.iFL);
            } else if (this.mType == 3) {
                this.blF.addPostData("ab_num_slow", this.iFC + "");
                this.blF.addPostData("time", this.iFL);
            } else if (this.mType == 2) {
                this.blF.addPostData("ab_num_error", this.iFD + "");
                this.blF.addPostData(BdStatsConstant.StatsType.ERROR, this.aUW);
            }
            String postNetData = this.blF.postNetData();
            if (!this.blF.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: dd */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a kW = s.kW();
                    kW.append("act", "fallback");
                    kW.append("result", "1");
                    kW.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", kW);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.dMJ.setmSwitch(false);
                    CDNProblemUploader.this.Mh = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a kW2 = s.kW();
                        kW2.append("act", "fallback");
                        kW2.append("result", "2");
                        kW2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", kW2);
                    } else {
                        a kW3 = s.kW();
                        kW3.append("act", "fallback");
                        kW3.append("result", "0");
                        kW3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", kW3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.dMJ.setmSwitch(false);
                        CDNProblemUploader.this.Mh = System.currentTimeMillis();
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
                CDNProblemUploader.this.iFy = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer iFM;

        private CdnErrorJsonData() {
            this.iFM = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.iFM.length() != 0) {
                this.iFM.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.iFM.append(i);
        }

        public void clear() {
            this.iFM.setLength(0);
        }

        public String toString() {
            return this.iFM.toString();
        }
    }
}
