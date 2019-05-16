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
    private static Object gUg = new Object();
    private static volatile CDNProblemUploader gUh;
    private m ceZ;
    private int gUb;
    private int gUc;
    private int gUd;
    private int mErrorNum;
    private Handler mHandler;
    private final int gTO = 5;
    private final int gTP = 0;
    private final int gTQ = 1;
    private final int gTR = 2;
    private final int gTS = 3;
    private final byte gTT = 0;
    private final byte gTU = 1;
    private int gTV = 0;
    private final int gTW = 5;
    private boolean gTX = false;
    private long Cn = 0;
    private final long gTY = 86400000;
    private final float gTZ = 100.0f;
    private float gUa = 0.0f;
    private BdAsyncTaskParallel gUe = null;
    private final CdnErrorJsonData gUf = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.gTV + 1;
        cDNProblemUploader.gTV = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (gUh == null) {
            synchronized (CDNProblemUploader.class) {
                if (gUh == null) {
                    gUh = new CDNProblemUploader();
                }
            }
        }
        return gUh;
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
        synchronized (gUg) {
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
        synchronized (gUg) {
            if (getmCdnLogData() == null) {
                this.gUa += 25.0f;
            } else {
                this.gUa += getmCdnLogData().getErrRank();
            }
            this.gUc++;
            this.mErrorNum++;
            this.gUf.add(i);
            int i3 = this.gUc;
            int i4 = this.mErrorNum;
            int i5 = this.gUb;
            int i6 = this.gUb != 0 ? this.gUd / this.gUb : 0;
            String cdnErrorJsonData = this.gUf.toString();
            if (getmCdnLogData() != null && this.Cn > 0 && System.currentTimeMillis() - this.Cn > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.gTV = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.gUc < 5) {
                    i2 = 0;
                } else if (this.gUa < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.gUb < getmCdnLogData().getSlowNumber()) {
                    if (this.gUa >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.gUa < 100.0f || this.gUb < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (gUg) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.gUa += 10.0f;
                } else {
                    this.gUa += getmCdnLogData().getSlowRank();
                }
                this.gUb++;
                this.gUd = (int) (this.gUd + j);
                this.gUc++;
                int i4 = this.gUc;
                int i5 = this.mErrorNum;
                int i6 = this.gUb;
                if (this.gUb != 0) {
                    i = this.gUd / this.gUb;
                }
                String cdnErrorJsonData = this.gUf.toString();
                if (getmCdnLogData() != null && this.Cn > 0 && System.currentTimeMillis() - this.Cn > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.gTV = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.gUc >= 5) {
                        if (this.gUa >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.gUb >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.gUa >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.gUa >= 100.0f && this.gUb >= getmCdnLogData().getSlowNumber()) {
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
                this.gUa -= 25.0f;
            } else {
                this.gUa -= getmCdnLogData().getSuccRank();
            }
            if (this.gUa < 0.0f) {
                this.gUa = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.gTX) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.gUe == null) {
            this.gUe = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.gUe);
        cDNUpLoadTask.execute(new Object[0]);
        this.gTX = true;
        a iw = s.iw();
        iw.append(SocialConstants.PARAM_ACT, "fallback");
        iw.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gUc = 0;
        this.gUb = 0;
        this.mErrorNum = 0;
        this.gUd = 0;
        this.gUa = 0.0f;
        this.gUf.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bOU;
        private final int gUb;
        private final int gUc;
        private final String gUj;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.gUb = i4;
            this.bOU = str;
            this.gUj = str2;
            this.mType = i;
            this.gUc = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.gUc));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.bOU);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.gUb));
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUj);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.gUb + "");
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gUj);
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
                CDNProblemUploader.this.gTX = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer gUk;

        private CdnErrorJsonData() {
            this.gUk = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.gUk.length() != 0) {
                this.gUk.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.gUk.append(i);
        }

        public void clear() {
            this.gUk.setLength(0);
        }

        public String toString() {
            return this.gUk.toString();
        }
    }
}
