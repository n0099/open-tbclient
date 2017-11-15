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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object dUL = new Object();
    private static volatile CDNProblemUploader dUM;
    private l arb;
    private int dUG;
    private int dUH;
    private int dUI;
    private int mErrorNum;
    private Handler mHandler;
    private final int dUt = 5;
    private final int dUu = 0;
    private final int dUv = 1;
    private final int dUw = 2;
    private final int dUx = 3;
    private final byte dUy = 0;
    private final byte dUz = 1;
    private int dUA = 0;
    private final int dUB = 5;
    private boolean dUC = false;
    private long wN = 0;
    private final long dUD = 86400000;
    private final float dUE = 100.0f;
    private float dUF = 0.0f;
    private BdAsyncTaskParallel dUJ = null;
    private final CdnErrorJsonData dUK = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dUA + 1;
        cDNProblemUploader.dUA = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dUM == null) {
            synchronized (CDNProblemUploader.class) {
                if (dUM == null) {
                    dUM = new CDNProblemUploader();
                }
            }
        }
        return dUM;
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
    public l getmCdnLogData() {
        return this.arb;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (dUL) {
            this.arb = lVar;
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
        synchronized (dUL) {
            if (getmCdnLogData() == null) {
                this.dUF += 25.0f;
            } else {
                this.dUF += getmCdnLogData().getErrRank();
            }
            this.dUH++;
            this.mErrorNum++;
            this.dUK.add(i);
            int i3 = this.dUH;
            int i4 = this.mErrorNum;
            int i5 = this.dUG;
            int i6 = this.dUG != 0 ? this.dUI / this.dUG : 0;
            String cdnErrorJsonData = this.dUK.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dUA = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dUH < 5) {
                    i2 = 0;
                } else if (this.dUF < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dUG < getmCdnLogData().getSlowNumber()) {
                    if (this.dUF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dUF < 100.0f || this.dUG < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dUL) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dUF += 10.0f;
                } else {
                    this.dUF += getmCdnLogData().getSlowRank();
                }
                this.dUG++;
                this.dUI = (int) (this.dUI + j);
                this.dUH++;
                int i4 = this.dUH;
                int i5 = this.mErrorNum;
                int i6 = this.dUG;
                if (this.dUG != 0) {
                    i = this.dUI / this.dUG;
                }
                String cdnErrorJsonData = this.dUK.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dUA = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dUH >= 5) {
                        if (this.dUF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dUG >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dUF >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dUF >= 100.0f && this.dUG >= getmCdnLogData().getSlowNumber()) {
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
                this.dUF -= 25.0f;
            } else {
                this.dUF -= getmCdnLogData().getSuccRank();
            }
            if (this.dUF < 0.0f) {
                this.dUF = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dUC) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dUJ == null) {
            this.dUJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dUJ);
        cDNUpLoadTask.execute(new Object[0]);
        this.dUC = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dUH = 0;
        this.dUG = 0;
        this.mErrorNum = 0;
        this.dUI = 0;
        this.dUF = 0.0f;
        this.dUK.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String adN;
        private final int dUG;
        private final int dUH;
        private final String dUO;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dUG = i4;
            this.adN = str;
            this.dUO = str2;
            this.mType = i;
            this.dUH = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dUH));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.adN);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dUG));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dUO);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dUG + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dUO);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.adN);
            }
            String up = this.mNetWork.up();
            if (!this.mNetWork.uQ() || TextUtils.isEmpty(up)) {
                return null;
            }
            try {
                return new JSONObject(up);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
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
                    CDNProblemUploader.this.arb.setmSwitch(false);
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
                        CDNProblemUploader.this.arb.setmSwitch(false);
                        CDNProblemUploader.this.wN = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    l lVar = new l();
                    lVar.parseJson(optString);
                    if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(lVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dUC = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dUP;

        private CdnErrorJsonData() {
            this.dUP = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dUP.length() != 0) {
                this.dUP.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dUP.append(i);
        }

        public void clear() {
            this.dUP.setLength(0);
        }

        public String toString() {
            return this.dUP.toString();
        }
    }
}
