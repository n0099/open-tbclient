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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.w;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends o {
    private static Object dJC = new Object();
    private static volatile CDNProblemUploader dJD;
    private l asf;
    private int dJx;
    private int dJy;
    private int dJz;
    private int mErrorNum;
    private Handler mHandler;
    private final int dJk = 5;
    private final int dJl = 0;
    private final int dJm = 1;
    private final int dJn = 2;
    private final int dJo = 3;
    private final byte dJp = 0;
    private final byte dJq = 1;
    private int dJr = 0;
    private final int dJs = 5;
    private boolean dJt = false;
    private long yQ = 0;
    private final long dJu = 86400000;
    private final float dJv = 100.0f;
    private float dJw = 0.0f;
    private BdAsyncTaskParallel dJA = null;
    private final CdnErrorJsonData dJB = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dJr + 1;
        cDNProblemUploader.dJr = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dJD == null) {
            synchronized (CDNProblemUploader.class) {
                if (dJD == null) {
                    dJD = new CDNProblemUploader();
                }
            }
        }
        return dJD;
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

    @Override // com.baidu.tbadk.core.util.o
    public l getmCdnLogData() {
        return this.asf;
    }

    @Override // com.baidu.tbadk.core.util.o
    public void setmCdnLogData(l lVar) {
        synchronized (dJC) {
            this.asf = lVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.o
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.o
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (dJC) {
            if (getmCdnLogData() == null) {
                this.dJw += 25.0f;
            } else {
                this.dJw += getmCdnLogData().getErrRank();
            }
            this.dJy++;
            this.mErrorNum++;
            this.dJB.add(i);
            int i3 = this.dJy;
            int i4 = this.mErrorNum;
            int i5 = this.dJx;
            int i6 = this.dJx != 0 ? this.dJz / this.dJx : 0;
            String cdnErrorJsonData = this.dJB.toString();
            if (getmCdnLogData() != null && this.yQ > 0 && System.currentTimeMillis() - this.yQ > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dJr = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dJy < 5) {
                    i2 = 0;
                } else if (this.dJw < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dJx < getmCdnLogData().getSlowNumber()) {
                    if (this.dJw >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dJw < 100.0f || this.dJx < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dJC) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dJw += 10.0f;
                } else {
                    this.dJw += getmCdnLogData().getSlowRank();
                }
                this.dJx++;
                this.dJz = (int) (this.dJz + j);
                this.dJy++;
                int i4 = this.dJy;
                int i5 = this.mErrorNum;
                int i6 = this.dJx;
                if (this.dJx != 0) {
                    i = this.dJz / this.dJx;
                }
                String cdnErrorJsonData = this.dJB.toString();
                if (getmCdnLogData() != null && this.yQ > 0 && System.currentTimeMillis() - this.yQ > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dJr = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dJy >= 5) {
                        if (this.dJw >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dJx >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dJw >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dJw >= 100.0f && this.dJx >= getmCdnLogData().getSlowNumber()) {
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
                this.dJw -= 25.0f;
            } else {
                this.dJw -= getmCdnLogData().getSuccRank();
            }
            if (this.dJw < 0.0f) {
                this.dJw = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dJt) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dJA == null) {
            this.dJA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dJA);
        cDNUpLoadTask.execute(new Object[0]);
        this.dJt = true;
        a fV = r.fV();
        fV.p("act", "fallback");
        fV.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dJy = 0;
        this.dJx = 0;
        this.mErrorNum = 0;
        this.dJz = 0;
        this.dJw = 0.0f;
        this.dJB.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aeW;
        private final String dJF;
        private final int dJx;
        private final int dJy;
        private final int mErrorNum;
        private final w mNetWork = new w(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dJx = i4;
            this.aeW = str;
            this.dJF = str2;
            this.mType = i;
            this.dJy = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dJy));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aeW);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dJx));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dJF);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dJx + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dJF);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aeW);
            }
            String uP = this.mNetWork.uP();
            if (!this.mNetWork.vp() || TextUtils.isEmpty(uP)) {
                return null;
            }
            try {
                return new JSONObject(uP);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fV = r.fV();
                    fV.p("act", "fallback");
                    fV.p("result", "1");
                    fV.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fV);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.asf.setmSwitch(false);
                    CDNProblemUploader.this.yQ = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fV2 = r.fV();
                        fV2.p("act", "fallback");
                        fV2.p("result", "2");
                        fV2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fV2);
                    } else {
                        a fV3 = r.fV();
                        fV3.p("act", "fallback");
                        fV3.p("result", "0");
                        fV3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fV3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.asf.setmSwitch(false);
                        CDNProblemUploader.this.yQ = System.currentTimeMillis();
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
                CDNProblemUploader.this.dJt = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dJG;

        private CdnErrorJsonData() {
            this.dJG = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dJG.length() != 0) {
                this.dJG.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dJG.append(i);
        }

        public void clear() {
            this.dJG.setLength(0);
        }

        public String toString() {
            return this.dJG.toString();
        }
    }
}
