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
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object eXk = new Object();
    private static volatile CDNProblemUploader eXl;
    private k bhz;
    private int eXf;
    private int eXg;
    private int eXh;
    private int mErrorNum;
    private Handler mHandler;
    private final int eWS = 5;
    private final int eWT = 0;
    private final int eWU = 1;
    private final int eWV = 2;
    private final int eWW = 3;
    private final byte eWX = 0;
    private final byte eWY = 1;
    private int eWZ = 0;
    private final int eXa = 5;
    private boolean eXb = false;
    private long akR = 0;
    private final long eXc = 86400000;
    private final float eXd = 100.0f;
    private float eXe = 0.0f;
    private BdAsyncTaskParallel eXi = null;
    private final CdnErrorJsonData eXj = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eWZ + 1;
        cDNProblemUploader.eWZ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eXl == null) {
            synchronized (CDNProblemUploader.class) {
                if (eXl == null) {
                    eXl = new CDNProblemUploader();
                }
            }
        }
        return eXl;
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
    public k getmCdnLogData() {
        return this.bhz;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (eXk) {
            this.bhz = kVar;
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
        synchronized (eXk) {
            if (getmCdnLogData() == null) {
                this.eXe += 25.0f;
            } else {
                this.eXe += getmCdnLogData().getErrRank();
            }
            this.eXg++;
            this.mErrorNum++;
            this.eXj.add(i);
            int i3 = this.eXg;
            int i4 = this.mErrorNum;
            int i5 = this.eXf;
            int i6 = this.eXf != 0 ? this.eXh / this.eXf : 0;
            String cdnErrorJsonData = this.eXj.toString();
            if (getmCdnLogData() != null && this.akR > 0 && System.currentTimeMillis() - this.akR > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eWZ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eXg < 5) {
                    i2 = 0;
                } else if (this.eXe < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eXf < getmCdnLogData().getSlowNumber()) {
                    if (this.eXe >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eXe < 100.0f || this.eXf < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eXk) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eXe += 10.0f;
                } else {
                    this.eXe += getmCdnLogData().getSlowRank();
                }
                this.eXf++;
                this.eXh = (int) (this.eXh + j);
                this.eXg++;
                int i4 = this.eXg;
                int i5 = this.mErrorNum;
                int i6 = this.eXf;
                if (this.eXf != 0) {
                    i = this.eXh / this.eXf;
                }
                String cdnErrorJsonData = this.eXj.toString();
                if (getmCdnLogData() != null && this.akR > 0 && System.currentTimeMillis() - this.akR > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eWZ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eXg >= 5) {
                        if (this.eXe >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eXf >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eXe >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eXe >= 100.0f && this.eXf >= getmCdnLogData().getSlowNumber()) {
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
                this.eXe -= 25.0f;
            } else {
                this.eXe -= getmCdnLogData().getSuccRank();
            }
            if (this.eXe < 0.0f) {
                this.eXe = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eXb) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eXi == null) {
            this.eXi = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eXi);
        cDNUpLoadTask.execute(new Object[0]);
        this.eXb = true;
        a nn = s.nn();
        nn.append(SocialConstants.PARAM_ACT, "fallback");
        nn.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eXg = 0;
        this.eXf = 0;
        this.mErrorNum = 0;
        this.eXh = 0;
        this.eXe = 0.0f;
        this.eXj.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aTO;
        private final int eXf;
        private final int eXg;
        private final String eXn;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eXf = i4;
            this.aTO = str;
            this.eXn = str2;
            this.mType = i;
            this.eXg = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.eXg));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aTO);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.eXf));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eXn);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.eXf + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eXn);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aTO);
            }
            String Cb = this.mNetWork.Cb();
            if (!this.mNetWork.CC() || TextUtils.isEmpty(Cb)) {
                return null;
            }
            try {
                return new JSONObject(Cb);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a nn = s.nn();
                    nn.append(SocialConstants.PARAM_ACT, "fallback");
                    nn.append("result", "1");
                    nn.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", nn);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.bhz.setmSwitch(false);
                    CDNProblemUploader.this.akR = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.HTTP_RET).optInt("err_no", -1) != 0) {
                        a nn2 = s.nn();
                        nn2.append(SocialConstants.PARAM_ACT, "fallback");
                        nn2.append("result", "2");
                        nn2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn2);
                    } else {
                        a nn3 = s.nn();
                        nn3.append(SocialConstants.PARAM_ACT, "fallback");
                        nn3.append("result", "0");
                        nn3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", nn3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.bhz.setmSwitch(false);
                        CDNProblemUploader.this.akR = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    k kVar = new k();
                    kVar.parseJson(optString);
                    if (kVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && kVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && kVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && kVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(kVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.eXb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eXo;

        private CdnErrorJsonData() {
            this.eXo = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eXo.length() != 0) {
                this.eXo.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.eXo.append(i);
        }

        public void clear() {
            this.eXo.setLength(0);
        }

        public String toString() {
            return this.eXo.toString();
        }
    }
}
