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
    private static Object hbo = new Object();
    private static volatile CDNProblemUploader hbp;
    private m cgm;
    private int hbi;
    private int hbj;
    private int hbk;
    private int hbl;
    private Handler mHandler;
    private final int haV = 5;
    private final int haW = 0;
    private final int haX = 1;
    private final int haY = 2;
    private final int haZ = 3;
    private final byte hba = 0;
    private final byte hbb = 1;
    private int hbc = 0;
    private final int hbd = 5;
    private boolean hbe = false;
    private long Cs = 0;
    private final long hbf = 86400000;
    private final float hbg = 100.0f;
    private float hbh = 0.0f;
    private BdAsyncTaskParallel hbm = null;
    private final CdnErrorJsonData hbn = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hbc + 1;
        cDNProblemUploader.hbc = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hbp == null) {
            synchronized (CDNProblemUploader.class) {
                if (hbp == null) {
                    hbp = new CDNProblemUploader();
                }
            }
        }
        return hbp;
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
        return this.cgm;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (hbo) {
            this.cgm = mVar;
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
        synchronized (hbo) {
            if (getmCdnLogData() == null) {
                this.hbh += 25.0f;
            } else {
                this.hbh += getmCdnLogData().getErrRank();
            }
            this.hbk++;
            this.hbj++;
            this.hbn.add(i);
            int i3 = this.hbk;
            int i4 = this.hbj;
            int i5 = this.hbi;
            int i6 = this.hbi != 0 ? this.hbl / this.hbi : 0;
            String cdnErrorJsonData = this.hbn.toString();
            if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hbc = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hbk < 5) {
                    i2 = 0;
                } else if (this.hbh < 100.0f || this.hbj < getmCdnLogData().getErrNumber() || this.hbi < getmCdnLogData().getSlowNumber()) {
                    if (this.hbh >= 100.0f && this.hbj >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hbh < 100.0f || this.hbi < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hbo) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hbh += 10.0f;
                } else {
                    this.hbh += getmCdnLogData().getSlowRank();
                }
                this.hbi++;
                this.hbl = (int) (this.hbl + j);
                this.hbk++;
                int i4 = this.hbk;
                int i5 = this.hbj;
                int i6 = this.hbi;
                if (this.hbi != 0) {
                    i = this.hbl / this.hbi;
                }
                String cdnErrorJsonData = this.hbn.toString();
                if (getmCdnLogData() != null && this.Cs > 0 && System.currentTimeMillis() - this.Cs > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hbc = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hbk >= 5) {
                        if (this.hbh >= 100.0f && this.hbj >= getmCdnLogData().getErrNumber() && this.hbi >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hbh >= 100.0f && this.hbj >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hbh >= 100.0f && this.hbi >= getmCdnLogData().getSlowNumber()) {
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
                this.hbh -= 25.0f;
            } else {
                this.hbh -= getmCdnLogData().getSuccRank();
            }
            if (this.hbh < 0.0f) {
                this.hbh = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hbe) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hbm == null) {
            this.hbm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hbm);
        cDNUpLoadTask.execute(new Object[0]);
        this.hbe = true;
        a iF = s.iF();
        iF.append(SocialConstants.PARAM_ACT, "fallback");
        iF.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hbk = 0;
        this.hbi = 0;
        this.hbj = 0;
        this.hbl = 0;
        this.hbh = 0.0f;
        this.hbn.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bQb;
        private final int hbi;
        private final int hbj;
        private final int hbk;
        private final String hbr;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hbj = i3;
            this.hbi = i4;
            this.bQb = str;
            this.hbr = str2;
            this.mType = i;
            this.hbk = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.hbk));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.hbj));
                this.mNetWork.o("error", this.bQb);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.hbi));
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.hbr);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.hbi + "");
                this.mNetWork.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.hbr);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.hbj + "");
                this.mNetWork.o("error", this.bQb);
            }
            String aii = this.mNetWork.aii();
            if (!this.mNetWork.aiJ() || TextUtils.isEmpty(aii)) {
                return null;
            }
            try {
                return new JSONObject(aii);
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
                    CDNProblemUploader.this.cgm.setmSwitch(false);
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
                        CDNProblemUploader.this.cgm.setmSwitch(false);
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
                CDNProblemUploader.this.hbe = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer hbs;

        private CdnErrorJsonData() {
            this.hbs = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hbs.length() != 0) {
                this.hbs.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hbs.append(i);
        }

        public void clear() {
            this.hbs.setLength(0);
        }

        public String toString() {
            return this.hbs.toString();
        }
    }
}
