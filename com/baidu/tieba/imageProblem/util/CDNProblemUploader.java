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
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object ecB = new Object();
    private static volatile CDNProblemUploader ecC;
    private k art;
    private int ecw;
    private int ecx;
    private int ecy;
    private int mErrorNum;
    private Handler mHandler;
    private final int ecj = 5;
    private final int eck = 0;
    private final int ecl = 1;
    private final int ecm = 2;
    private final int ecn = 3;
    private final byte eco = 0;
    private final byte ecp = 1;
    private int ecq = 0;
    private final int ecr = 5;
    private boolean ecs = false;
    private long wN = 0;
    private final long ect = 86400000;
    private final float ecu = 100.0f;
    private float ecv = 0.0f;
    private BdAsyncTaskParallel ecz = null;
    private final CdnErrorJsonData ecA = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.ecq + 1;
        cDNProblemUploader.ecq = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (ecC == null) {
            synchronized (CDNProblemUploader.class) {
                if (ecC == null) {
                    ecC = new CDNProblemUploader();
                }
            }
        }
        return ecC;
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
        return this.art;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (ecB) {
            this.art = kVar;
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
        synchronized (ecB) {
            if (getmCdnLogData() == null) {
                this.ecv += 25.0f;
            } else {
                this.ecv += getmCdnLogData().getErrRank();
            }
            this.ecx++;
            this.mErrorNum++;
            this.ecA.add(i);
            int i3 = this.ecx;
            int i4 = this.mErrorNum;
            int i5 = this.ecw;
            int i6 = this.ecw != 0 ? this.ecy / this.ecw : 0;
            String cdnErrorJsonData = this.ecA.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.ecq = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.ecx < 5) {
                    i2 = 0;
                } else if (this.ecv < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.ecw < getmCdnLogData().getSlowNumber()) {
                    if (this.ecv >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.ecv < 100.0f || this.ecw < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (ecB) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.ecv += 10.0f;
                } else {
                    this.ecv += getmCdnLogData().getSlowRank();
                }
                this.ecw++;
                this.ecy = (int) (this.ecy + j);
                this.ecx++;
                int i4 = this.ecx;
                int i5 = this.mErrorNum;
                int i6 = this.ecw;
                if (this.ecw != 0) {
                    i = this.ecy / this.ecw;
                }
                String cdnErrorJsonData = this.ecA.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.ecq = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.ecx >= 5) {
                        if (this.ecv >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.ecw >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.ecv >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.ecv >= 100.0f && this.ecw >= getmCdnLogData().getSlowNumber()) {
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
                this.ecv -= 25.0f;
            } else {
                this.ecv -= getmCdnLogData().getSuccRank();
            }
            if (this.ecv < 0.0f) {
                this.ecv = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.ecs) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.ecz == null) {
            this.ecz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.ecz);
        cDNUpLoadTask.execute(new Object[0]);
        this.ecs = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.ecx = 0;
        this.ecw = 0;
        this.mErrorNum = 0;
        this.ecy = 0;
        this.ecv = 0.0f;
        this.ecA.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aei;
        private final String ecE;
        private final int ecw;
        private final int ecx;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.ecw = i4;
            this.aei = str;
            this.ecE = str2;
            this.mType = i;
            this.ecx = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.ecx));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aei);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.ecw));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.ecE);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.ecw + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.ecE);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aei);
            }
            String us = this.mNetWork.us();
            if (!this.mNetWork.uT() || TextUtils.isEmpty(us)) {
                return null;
            }
            try {
                return new JSONObject(us);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fK = s.fK();
                    fK.p("act", "fallback");
                    fK.p("result", "1");
                    fK.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fK);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.art.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fK2 = s.fK();
                        fK2.p("act", "fallback");
                        fK2.p("result", "2");
                        fK2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK2);
                    } else {
                        a fK3 = s.fK();
                        fK3.p("act", "fallback");
                        fK3.p("result", "0");
                        fK3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.art.setmSwitch(false);
                        CDNProblemUploader.this.wN = System.currentTimeMillis();
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
                CDNProblemUploader.this.ecs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer ecF;

        private CdnErrorJsonData() {
            this.ecF = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.ecF.length() != 0) {
                this.ecF.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.ecF.append(i);
        }

        public void clear() {
            this.ecF.setLength(0);
        }

        public String toString() {
            return this.ecF.toString();
        }
    }
}
