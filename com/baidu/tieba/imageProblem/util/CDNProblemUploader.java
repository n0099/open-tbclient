package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.w;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends t {
    private static Object dxN = new Object();
    private static volatile CDNProblemUploader dxO;
    private m apV;
    private int dxI;
    private int dxJ;
    private int dxK;
    private int mErrorNum;
    private Handler mHandler;
    private final int dxv = 5;
    private final int dxw = 0;
    private final int dxx = 1;
    private final int dxy = 2;
    private final int dxz = 3;
    private final byte dxA = 0;
    private final byte dxB = 1;
    private int dxC = 0;
    private final int dxD = 5;
    private boolean dxE = false;
    private long xn = 0;
    private final long dxF = 86400000;
    private final float dxG = 100.0f;
    private float dxH = 0.0f;
    private BdAsyncTaskParallel dxL = null;
    private final CdnErrorJsonData dxM = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m14getInstance() {
        if (dxO == null) {
            synchronized (CDNProblemUploader.class) {
                if (dxO == null) {
                    dxO = new CDNProblemUploader();
                }
            }
        }
        return dxO;
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

    @Override // com.baidu.tbadk.core.util.t
    public m getmCdnLogData() {
        return this.apV;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setmCdnLogData(m mVar) {
        synchronized (dxN) {
            this.apV = mVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (dxN) {
            if (getmCdnLogData() == null) {
                this.dxH += 25.0f;
            } else {
                this.dxH += getmCdnLogData().getErrRank();
            }
            this.dxJ++;
            this.mErrorNum++;
            this.dxM.add(i);
            int i3 = this.dxJ;
            int i4 = this.mErrorNum;
            int i5 = this.dxI;
            int i6 = this.dxI != 0 ? this.dxK / this.dxI : 0;
            String cdnErrorJsonData = this.dxM.toString();
            if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dxC = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dxJ < 5) {
                    i2 = 0;
                } else if (this.dxH < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dxI < getmCdnLogData().getSlowNumber()) {
                    if (this.dxH >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dxH < 100.0f || this.dxI < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dxN) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dxH += 10.0f;
                } else {
                    this.dxH += getmCdnLogData().getSlowRank();
                }
                this.dxI++;
                this.dxK = (int) (this.dxK + j);
                this.dxJ++;
                int i4 = this.dxJ;
                int i5 = this.mErrorNum;
                int i6 = this.dxI;
                if (this.dxI != 0) {
                    i = this.dxK / this.dxI;
                }
                String cdnErrorJsonData = this.dxM.toString();
                if (getmCdnLogData() != null && this.xn > 0 && System.currentTimeMillis() - this.xn > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dxC = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dxJ >= 5) {
                        if (this.dxH >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dxI >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dxH >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dxH >= 100.0f && this.dxI >= getmCdnLogData().getSlowNumber()) {
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
                this.dxH -= 25.0f;
            } else {
                this.dxH -= getmCdnLogData().getSuccRank();
            }
            if (this.dxH < 0.0f) {
                this.dxH = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dxE) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dxL == null) {
            this.dxL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dxL);
        cDNUpLoadTask.execute(new Object[0]);
        this.dxE = true;
        c fM = w.fM();
        fM.p("act", "fallback");
        fM.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dxJ = 0;
        this.dxI = 0;
        this.mErrorNum = 0;
        this.dxK = 0;
        this.dxH = 0.0f;
        this.dxM.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String adc;
        private final int dxI;
        private final int dxJ;
        private final String dxQ;
        private final int mErrorNum;
        private final ab mNetWork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dxI = i4;
            this.adc = str;
            this.dxQ = str2;
            this.mType = i;
            this.dxJ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dxJ));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.adc);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dxI));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dxQ);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dxI)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dxQ);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.adc);
            }
            String uy = this.mNetWork.uy();
            if (!this.mNetWork.uY() || TextUtils.isEmpty(uy)) {
                return null;
            }
            try {
                return new JSONObject(uy);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    c fM = w.fM();
                    fM.p("act", "fallback");
                    fM.p("result", "1");
                    fM.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dxC + 1;
                cDNProblemUploader.dxC = i;
                if (i >= 5) {
                    CDNProblemUploader.this.apV.setmSwitch(false);
                    CDNProblemUploader.this.xn = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    c fM2 = w.fM();
                    fM2.p("act", "fallback");
                    fM2.p("result", "2");
                    fM2.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM2);
                } else {
                    c fM3 = w.fM();
                    fM3.p("act", "fallback");
                    fM3.p("result", "0");
                    fM3.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.apV.setmSwitch(false);
                    CDNProblemUploader.this.xn = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                m mVar = new m();
                mVar.parseJson(optString);
                if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(mVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dxE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dxR;

        private CdnErrorJsonData() {
            this.dxR = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dxR.length() != 0) {
                this.dxR.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dxR.append(i);
        }

        public void clear() {
            this.dxR.setLength(0);
        }

        public String toString() {
            return this.dxR.toString();
        }
    }
}
