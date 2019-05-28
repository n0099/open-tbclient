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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
    private static Object gUj = new Object();
    private static volatile CDNProblemUploader gUk;
    private m ceZ;
    private int gUe;
    private int gUf;
    private int gUg;
    private int mErrorNum;
    private Handler mHandler;
    private final int gTR = 5;
    private final int gTS = 0;
    private final int gTT = 1;
    private final int gTU = 2;
    private final int gTV = 3;
    private final byte gTW = 0;
    private final byte gTX = 1;
    private int gTY = 0;
    private final int gTZ = 5;
    private boolean gUa = false;
    private long Cn = 0;
    private final long gUb = 86400000;
    private final float gUc = 100.0f;
    private float gUd = 0.0f;
    private BdAsyncTaskParallel gUh = null;
    private final CdnErrorJsonData gUi = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gTY + 1;
        cDNProblemUploader.gTY = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gUk == null) {
            synchronized (CDNProblemUploader.class) {
                if (gUk == null) {
                    gUk = new CDNProblemUploader();
                }
            }
        }
        return gUk;
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
        return this.ceZ;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (gUj) {
            this.ceZ = mVar;
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
        synchronized (gUj) {
            if (getmCdnLogData() == null) {
                this.gUd += 25.0f;
            } else {
                this.gUd += getmCdnLogData().getErrRank();
            }
            this.gUf++;
            this.mErrorNum++;
            this.gUi.add(i);
            int i3 = this.gUf;
            int i4 = this.mErrorNum;
            int i5 = this.gUe;
            int i6 = this.gUe != 0 ? this.gUg / this.gUe : 0;
            String cdnErrorJsonData = this.gUi.toString();
            if (getmCdnLogData() != null && this.Cn > 0 && System.currentTimeMillis() - this.Cn > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gTY = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gUf < 5) {
                    i2 = 0;
                } else if (this.gUd < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gUe < getmCdnLogData().getSlowNumber()) {
                    if (this.gUd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gUd < 100.0f || this.gUe < getmCdnLogData().getSlowNumber()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, cdnErrorJsonData, i5, i6);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = UIMsg.m_AppUI.MSG_APP_GPS;
        if (getmCdnLogData() != null) {
            i3 = getmCdnLogData().getTime();
        }
        synchronized (gUj) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gUd += 10.0f;
                } else {
                    this.gUd += getmCdnLogData().getSlowRank();
                }
                this.gUe++;
                this.gUg = (int) (this.gUg + j);
                this.gUf++;
                int i4 = this.gUf;
                int i5 = this.mErrorNum;
                int i6 = this.gUe;
                if (this.gUe != 0) {
                    i = this.gUg / this.gUe;
                }
                String cdnErrorJsonData = this.gUi.toString();
                if (getmCdnLogData() != null && this.Cn > 0 && System.currentTimeMillis() - this.Cn > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gTY = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gUf >= 5) {
                        if (this.gUd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gUe >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gUd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gUd >= 100.0f && this.gUe >= getmCdnLogData().getSlowNumber()) {
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
                this.gUd -= 25.0f;
            } else {
                this.gUd -= getmCdnLogData().getSuccRank();
            }
            if (this.gUd < 0.0f) {
                this.gUd = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gUa) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gUh == null) {
            this.gUh = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gUh);
        cDNUpLoadTask.execute(new Object[0]);
        this.gUa = true;
        a iw = s.iw();
        iw.append(SocialConstants.PARAM_ACT, "fallback");
        iw.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gUf = 0;
        this.gUe = 0;
        this.mErrorNum = 0;
        this.gUg = 0;
        this.gUd = 0.0f;
        this.gUi.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bOU;
        private final int gUe;
        private final int gUf;
        private final String gUm;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gUe = i4;
            this.bOU = str;
            this.gUm = str2;
            this.mType = i;
            this.gUf = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.gUf));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.bOU);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.gUe));
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUm);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.gUe + "");
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUm);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.bOU);
            }
            String ahe = this.mNetWork.ahe();
            if (!this.mNetWork.ahF() || TextUtils.isEmpty(ahe)) {
                return null;
            }
            try {
                return new JSONObject(ahe);
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
                    a iw = s.iw();
                    iw.append(SocialConstants.PARAM_ACT, "fallback");
                    iw.append("result", "1");
                    iw.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ceZ.setmSwitch(false);
                    CDNProblemUploader.this.Cn = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a iw2 = s.iw();
                        iw2.append(SocialConstants.PARAM_ACT, "fallback");
                        iw2.append("result", "2");
                        iw2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw2);
                    } else {
                        a iw3 = s.iw();
                        iw3.append(SocialConstants.PARAM_ACT, "fallback");
                        iw3.append("result", "0");
                        iw3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ceZ.setmSwitch(false);
                        CDNProblemUploader.this.Cn = System.currentTimeMillis();
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
                CDNProblemUploader.this.gUa = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gUn;

        private CdnErrorJsonData() {
            this.gUn = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gUn.length() != 0) {
                this.gUn.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gUn.append(i);
        }

        public void clear() {
            this.gUn.setLength(0);
        }

        public String toString() {
            return this.gUn.toString();
        }
    }
}
