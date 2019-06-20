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
    private static Object gUl = new Object();
    private static volatile CDNProblemUploader gUm;
    private m cfa;
    private int gUg;
    private int gUh;
    private int gUi;
    private int mErrorNum;
    private Handler mHandler;
    private final int gTT = 5;
    private final int gTU = 0;
    private final int gTV = 1;
    private final int gTW = 2;
    private final int gTX = 3;
    private final byte gTY = 0;
    private final byte gTZ = 1;
    private int gUa = 0;
    private final int gUb = 5;
    private boolean gUc = false;
    private long Cm = 0;
    private final long gUd = 86400000;
    private final float gUe = 100.0f;
    private float gUf = 0.0f;
    private BdAsyncTaskParallel gUj = null;
    private final CdnErrorJsonData gUk = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gUa + 1;
        cDNProblemUploader.gUa = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gUm == null) {
            synchronized (CDNProblemUploader.class) {
                if (gUm == null) {
                    gUm = new CDNProblemUploader();
                }
            }
        }
        return gUm;
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
        return this.cfa;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (gUl) {
            this.cfa = mVar;
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
        synchronized (gUl) {
            if (getmCdnLogData() == null) {
                this.gUf += 25.0f;
            } else {
                this.gUf += getmCdnLogData().getErrRank();
            }
            this.gUh++;
            this.mErrorNum++;
            this.gUk.add(i);
            int i3 = this.gUh;
            int i4 = this.mErrorNum;
            int i5 = this.gUg;
            int i6 = this.gUg != 0 ? this.gUi / this.gUg : 0;
            String cdnErrorJsonData = this.gUk.toString();
            if (getmCdnLogData() != null && this.Cm > 0 && System.currentTimeMillis() - this.Cm > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gUa = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gUh < 5) {
                    i2 = 0;
                } else if (this.gUf < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gUg < getmCdnLogData().getSlowNumber()) {
                    if (this.gUf >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gUf < 100.0f || this.gUg < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (gUl) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gUf += 10.0f;
                } else {
                    this.gUf += getmCdnLogData().getSlowRank();
                }
                this.gUg++;
                this.gUi = (int) (this.gUi + j);
                this.gUh++;
                int i4 = this.gUh;
                int i5 = this.mErrorNum;
                int i6 = this.gUg;
                if (this.gUg != 0) {
                    i = this.gUi / this.gUg;
                }
                String cdnErrorJsonData = this.gUk.toString();
                if (getmCdnLogData() != null && this.Cm > 0 && System.currentTimeMillis() - this.Cm > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gUa = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gUh >= 5) {
                        if (this.gUf >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gUg >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gUf >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gUf >= 100.0f && this.gUg >= getmCdnLogData().getSlowNumber()) {
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
                this.gUf -= 25.0f;
            } else {
                this.gUf -= getmCdnLogData().getSuccRank();
            }
            if (this.gUf < 0.0f) {
                this.gUf = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gUc) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gUj == null) {
            this.gUj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gUj);
        cDNUpLoadTask.execute(new Object[0]);
        this.gUc = true;
        a iw = s.iw();
        iw.append(SocialConstants.PARAM_ACT, "fallback");
        iw.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gUh = 0;
        this.gUg = 0;
        this.mErrorNum = 0;
        this.gUi = 0;
        this.gUf = 0.0f;
        this.gUk.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bOV;
        private final int gUg;
        private final int gUh;
        private final String gUo;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gUg = i4;
            this.bOV = str;
            this.gUo = str2;
            this.mType = i;
            this.gUh = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.gUh));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.bOV);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.gUg));
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUo);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.gUg + "");
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUo);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.bOV);
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
                    CDNProblemUploader.this.cfa.setmSwitch(false);
                    CDNProblemUploader.this.Cm = System.currentTimeMillis();
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
                        CDNProblemUploader.this.cfa.setmSwitch(false);
                        CDNProblemUploader.this.Cm = System.currentTimeMillis();
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
                CDNProblemUploader.this.gUc = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gUp;

        private CdnErrorJsonData() {
            this.gUp = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gUp.length() != 0) {
                this.gUp.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gUp.append(i);
        }

        public void clear() {
            this.gUp.setLength(0);
        }

        public String toString() {
            return this.gUp.toString();
        }
    }
}
