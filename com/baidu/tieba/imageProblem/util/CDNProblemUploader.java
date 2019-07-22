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
    private static Object haw = new Object();
    private static volatile CDNProblemUploader hax;
    private m cgf;
    private int haq;
    private int har;
    private int has;
    private int hat;
    private Handler mHandler;
    private final int had = 5;
    private final int hae = 0;
    private final int haf = 1;
    private final int hag = 2;
    private final int hah = 3;
    private final byte hai = 0;
    private final byte haj = 1;
    private int hak = 0;
    private final int hal = 5;
    private boolean ham = false;
    private long Cs = 0;
    private final long han = 86400000;
    private final float hao = 100.0f;
    private float hap = 0.0f;
    private BdAsyncTaskParallel hau = null;
    private final CdnErrorJsonData hav = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hak + 1;
        cDNProblemUploader.hak = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hax == null) {
            synchronized (CDNProblemUploader.class) {
                if (hax == null) {
                    hax = new CDNProblemUploader();
                }
            }
        }
        return hax;
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
        return this.cgf;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (haw) {
            this.cgf = mVar;
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
        synchronized (haw) {
            if (getmCdnLogData() == null) {
                this.hap += 25.0f;
            } else {
                this.hap += getmCdnLogData().getErrRank();
            }
            this.has++;
            this.har++;
            this.hav.add(i);
            int i3 = this.has;
            int i4 = this.har;
            int i5 = this.haq;
            int i6 = this.haq != 0 ? this.hat / this.haq : 0;
            String cdnErrorJsonData = this.hav.toString();
            if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hak = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.has < 5) {
                    i2 = 0;
                } else if (this.hap < 100.0f || this.har < getmCdnLogData().getErrNumber() || this.haq < getmCdnLogData().getSlowNumber()) {
                    if (this.hap >= 100.0f && this.har >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hap < 100.0f || this.haq < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (haw) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hap += 10.0f;
                } else {
                    this.hap += getmCdnLogData().getSlowRank();
                }
                this.haq++;
                this.hat = (int) (this.hat + j);
                this.has++;
                int i4 = this.has;
                int i5 = this.har;
                int i6 = this.haq;
                if (this.haq != 0) {
                    i = this.hat / this.haq;
                }
                String cdnErrorJsonData = this.hav.toString();
                if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hak = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.has >= 5) {
                        if (this.hap >= 100.0f && this.har >= getmCdnLogData().getErrNumber() && this.haq >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hap >= 100.0f && this.har >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hap >= 100.0f && this.haq >= getmCdnLogData().getSlowNumber()) {
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
                this.hap -= 25.0f;
            } else {
                this.hap -= getmCdnLogData().getSuccRank();
            }
            if (this.hap < 0.0f) {
                this.hap = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.ham) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hau == null) {
            this.hau = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hau);
        cDNUpLoadTask.execute(new Object[0]);
        this.ham = true;
        a iF = s.iF();
        iF.append(SocialConstants.PARAM_ACT, "fallback");
        iF.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.has = 0;
        this.haq = 0;
        this.har = 0;
        this.hat = 0;
        this.hap = 0.0f;
        this.hav.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bPV;
        private final int haq;
        private final int har;
        private final int has;
        private final String haz;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.har = i3;
            this.haq = i4;
            this.bPV = str;
            this.haz = str2;
            this.mType = i;
            this.has = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.has));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.har));
                this.mNetWork.o("error", this.bPV);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.haq));
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.haz);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.haq + "");
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.haz);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.har + "");
                this.mNetWork.o("error", this.bPV);
            }
            String aig = this.mNetWork.aig();
            if (!this.mNetWork.aiH() || TextUtils.isEmpty(aig)) {
                return null;
            }
            try {
                return new JSONObject(aig);
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
                    CDNProblemUploader.this.cgf.setmSwitch(false);
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
                        CDNProblemUploader.this.cgf.setmSwitch(false);
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
                CDNProblemUploader.this.ham = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer haA;

        private CdnErrorJsonData() {
            this.haA = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.haA.length() != 0) {
                this.haA.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.haA.append(i);
        }

        public void clear() {
            this.haA.setLength(0);
        }

        public String toString() {
            return this.haA.toString();
        }
    }
}
