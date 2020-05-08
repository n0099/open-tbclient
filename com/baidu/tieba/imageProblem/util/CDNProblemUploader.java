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
    private static Object iFO = new Object();
    private static volatile CDNProblemUploader iFP;
    private n dMN;
    private int iFI;
    private int iFJ;
    private int iFK;
    private int iFL;
    private Handler mHandler;
    private final int iFv = 5;
    private final int iFw = 0;
    private final int iFx = 1;
    private final int iFy = 2;
    private final int iFz = 3;
    private final byte iFA = 0;
    private final byte iFB = 1;
    private int iFC = 0;
    private final int iFD = 5;
    private boolean iFE = false;
    private long Ml = 0;
    private final long iFF = 86400000;
    private final float iFG = 100.0f;
    private float iFH = 0.0f;
    private BdAsyncTaskParallel iFM = null;
    private final CdnErrorJsonData iFN = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.iFC + 1;
        cDNProblemUploader.iFC = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (iFP == null) {
            synchronized (CDNProblemUploader.class) {
                if (iFP == null) {
                    iFP = new CDNProblemUploader();
                }
            }
        }
        return iFP;
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
        return this.dMN;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (iFO) {
            this.dMN = nVar;
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
        synchronized (iFO) {
            if (getmCdnLogData() == null) {
                this.iFH += 25.0f;
            } else {
                this.iFH += getmCdnLogData().getErrRank();
            }
            this.iFK++;
            this.iFJ++;
            this.iFN.add(i);
            int i3 = this.iFK;
            int i4 = this.iFJ;
            int i5 = this.iFI;
            int i6 = this.iFI != 0 ? this.iFL / this.iFI : 0;
            String cdnErrorJsonData = this.iFN.toString();
            if (getmCdnLogData() != null && this.Ml > 0 && System.currentTimeMillis() - this.Ml > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.iFC = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.iFK < 5) {
                    i2 = 0;
                } else if (this.iFH < 100.0f || this.iFJ < getmCdnLogData().getErrNumber() || this.iFI < getmCdnLogData().getSlowNumber()) {
                    if (this.iFH >= 100.0f && this.iFJ >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.iFH < 100.0f || this.iFI < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (iFO) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.iFH += 10.0f;
                } else {
                    this.iFH += getmCdnLogData().getSlowRank();
                }
                this.iFI++;
                this.iFL = (int) (this.iFL + j);
                this.iFK++;
                int i4 = this.iFK;
                int i5 = this.iFJ;
                int i6 = this.iFI;
                if (this.iFI != 0) {
                    i = this.iFL / this.iFI;
                }
                String cdnErrorJsonData = this.iFN.toString();
                if (getmCdnLogData() != null && this.Ml > 0 && System.currentTimeMillis() - this.Ml > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.iFC = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.iFK >= 5) {
                        if (this.iFH >= 100.0f && this.iFJ >= getmCdnLogData().getErrNumber() && this.iFI >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.iFH >= 100.0f && this.iFJ >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.iFH >= 100.0f && this.iFI >= getmCdnLogData().getSlowNumber()) {
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
                this.iFH -= 25.0f;
            } else {
                this.iFH -= getmCdnLogData().getSuccRank();
            }
            if (this.iFH < 0.0f) {
                this.iFH = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.iFE) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.iFM == null) {
            this.iFM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.iFM);
        cDNUpLoadTask.execute(new Object[0]);
        this.iFE = true;
        a kW = s.kW();
        kW.append("act", "fallback");
        kW.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", kW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iFK = 0;
        this.iFI = 0;
        this.iFJ = 0;
        this.iFL = 0;
        this.iFH = 0.0f;
        this.iFN.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aVb;
        private final x blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int iFI;
        private final int iFJ;
        private final int iFK;
        private final String iFR;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.iFJ = i3;
            this.iFI = i4;
            this.aVb = str;
            this.iFR = str2;
            this.mType = i;
            this.iFK = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.blK.addPostData("number", String.valueOf(this.iFK));
            if (this.mType == 1) {
                this.blK.addPostData("ab_num_error", String.valueOf(this.iFJ));
                this.blK.addPostData(BdStatsConstant.StatsType.ERROR, this.aVb);
                this.blK.addPostData("ab_num_slow", String.valueOf(this.iFI));
                this.blK.addPostData("time", this.iFR);
            } else if (this.mType == 3) {
                this.blK.addPostData("ab_num_slow", this.iFI + "");
                this.blK.addPostData("time", this.iFR);
            } else if (this.mType == 2) {
                this.blK.addPostData("ab_num_error", this.iFJ + "");
                this.blK.addPostData(BdStatsConstant.StatsType.ERROR, this.aVb);
            }
            String postNetData = this.blK.postNetData();
            if (!this.blK.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.dMN.setmSwitch(false);
                    CDNProblemUploader.this.Ml = System.currentTimeMillis();
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
                        CDNProblemUploader.this.dMN.setmSwitch(false);
                        CDNProblemUploader.this.Ml = System.currentTimeMillis();
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
                CDNProblemUploader.this.iFE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer iFS;

        private CdnErrorJsonData() {
            this.iFS = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.iFS.length() != 0) {
                this.iFS.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.iFS.append(i);
        }

        public void clear() {
            this.iFS.setLength(0);
        }

        public String toString() {
            return this.iFS.toString();
        }
    }
}
