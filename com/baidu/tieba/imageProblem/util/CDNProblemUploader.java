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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object hdi = new Object();
    private static volatile CDNProblemUploader hdj;
    private m chf;
    private int hdc;
    private int hdd;
    private int hde;
    private int hdf;
    private Handler mHandler;
    private final int hcP = 5;
    private final int hcQ = 0;
    private final int hcR = 1;
    private final int hcS = 2;
    private final int hcT = 3;
    private final byte hcU = 0;
    private final byte hcV = 1;
    private int hcW = 0;
    private final int hcX = 5;
    private boolean hcY = false;
    private long Cs = 0;
    private final long hcZ = 86400000;
    private final float hda = 100.0f;
    private float hdb = 0.0f;
    private BdAsyncTaskParallel hdg = null;
    private final CdnErrorJsonData hdh = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hcW + 1;
        cDNProblemUploader.hcW = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hdj == null) {
            synchronized (CDNProblemUploader.class) {
                if (hdj == null) {
                    hdj = new CDNProblemUploader();
                }
            }
        }
        return hdj;
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
        return this.chf;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (hdi) {
            this.chf = mVar;
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
        synchronized (hdi) {
            if (getmCdnLogData() == null) {
                this.hdb += 25.0f;
            } else {
                this.hdb += getmCdnLogData().getErrRank();
            }
            this.hde++;
            this.hdd++;
            this.hdh.add(i);
            int i3 = this.hde;
            int i4 = this.hdd;
            int i5 = this.hdc;
            int i6 = this.hdc != 0 ? this.hdf / this.hdc : 0;
            String cdnErrorJsonData = this.hdh.toString();
            if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hcW = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hde < 5) {
                    i2 = 0;
                } else if (this.hdb < 100.0f || this.hdd < getmCdnLogData().getErrNumber() || this.hdc < getmCdnLogData().getSlowNumber()) {
                    if (this.hdb >= 100.0f && this.hdd >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hdb < 100.0f || this.hdc < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hdi) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hdb += 10.0f;
                } else {
                    this.hdb += getmCdnLogData().getSlowRank();
                }
                this.hdc++;
                this.hdf = (int) (this.hdf + j);
                this.hde++;
                int i4 = this.hde;
                int i5 = this.hdd;
                int i6 = this.hdc;
                if (this.hdc != 0) {
                    i = this.hdf / this.hdc;
                }
                String cdnErrorJsonData = this.hdh.toString();
                if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hcW = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hde >= 5) {
                        if (this.hdb >= 100.0f && this.hdd >= getmCdnLogData().getErrNumber() && this.hdc >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hdb >= 100.0f && this.hdd >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hdb >= 100.0f && this.hdc >= getmCdnLogData().getSlowNumber()) {
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
                this.hdb -= 25.0f;
            } else {
                this.hdb -= getmCdnLogData().getSuccRank();
            }
            if (this.hdb < 0.0f) {
                this.hdb = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hcY) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hdg == null) {
            this.hdg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hdg);
        cDNUpLoadTask.execute(new Object[0]);
        this.hcY = true;
        a iF = s.iF();
        iF.append(SocialConstants.PARAM_ACT, "fallback");
        iF.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hde = 0;
        this.hdc = 0;
        this.hdd = 0;
        this.hdf = 0;
        this.hdb = 0.0f;
        this.hdh.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bQC;
        private final int hdc;
        private final int hdd;
        private final int hde;
        private final String hdl;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hdd = i3;
            this.hdc = i4;
            this.bQC = str;
            this.hdl = str2;
            this.mType = i;
            this.hde = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.hde));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.hdd));
                this.mNetWork.o("error", this.bQC);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.hdc));
                this.mNetWork.o("time", this.hdl);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.hdc + "");
                this.mNetWork.o("time", this.hdl);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.hdd + "");
                this.mNetWork.o("error", this.bQC);
            }
            String aim = this.mNetWork.aim();
            if (!this.mNetWork.aiN() || TextUtils.isEmpty(aim)) {
                return null;
            }
            try {
                return new JSONObject(aim);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: bC */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a iF = s.iF();
                    iF.append(SocialConstants.PARAM_ACT, "fallback");
                    iF.append("result", "1");
                    iF.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.chf.setmSwitch(false);
                    CDNProblemUploader.this.Cs = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a iF2 = s.iF();
                        iF2.append(SocialConstants.PARAM_ACT, "fallback");
                        iF2.append("result", "2");
                        iF2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF2);
                    } else {
                        a iF3 = s.iF();
                        iF3.append(SocialConstants.PARAM_ACT, "fallback");
                        iF3.append("result", "0");
                        iF3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.chf.setmSwitch(false);
                        CDNProblemUploader.this.Cs = System.currentTimeMillis();
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
                CDNProblemUploader.this.hcY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer hdm;

        private CdnErrorJsonData() {
            this.hdm = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hdm.length() != 0) {
                this.hdm.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hdm.append(i);
        }

        public void clear() {
            this.hdm.setLength(0);
        }

        public String toString() {
            return this.hdm.toString();
        }
    }
}
