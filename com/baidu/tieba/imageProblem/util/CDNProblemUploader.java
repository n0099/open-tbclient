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
    private static Object dNi = new Object();
    private static volatile CDNProblemUploader dNj;
    private l aqQ;
    private int dNd;
    private int dNe;
    private int dNf;
    private int mErrorNum;
    private Handler mHandler;
    private final int dMQ = 5;
    private final int dMR = 0;
    private final int dMS = 1;
    private final int dMT = 2;
    private final int dMU = 3;
    private final byte dMV = 0;
    private final byte dMW = 1;
    private int dMX = 0;
    private final int dMY = 5;
    private boolean dMZ = false;
    private long wM = 0;
    private final long dNa = 86400000;
    private final float dNb = 100.0f;
    private float dNc = 0.0f;
    private BdAsyncTaskParallel dNg = null;
    private final CdnErrorJsonData dNh = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dMX + 1;
        cDNProblemUploader.dMX = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dNj == null) {
            synchronized (CDNProblemUploader.class) {
                if (dNj == null) {
                    dNj = new CDNProblemUploader();
                }
            }
        }
        return dNj;
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
        return this.aqQ;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(l lVar) {
        synchronized (dNi) {
            this.aqQ = lVar;
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
        synchronized (dNi) {
            if (getmCdnLogData() == null) {
                this.dNc += 25.0f;
            } else {
                this.dNc += getmCdnLogData().getErrRank();
            }
            this.dNe++;
            this.mErrorNum++;
            this.dNh.add(i);
            int i3 = this.dNe;
            int i4 = this.mErrorNum;
            int i5 = this.dNd;
            int i6 = this.dNd != 0 ? this.dNf / this.dNd : 0;
            String cdnErrorJsonData = this.dNh.toString();
            if (getmCdnLogData() != null && this.wM > 0 && System.currentTimeMillis() - this.wM > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dMX = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dNe < 5) {
                    i2 = 0;
                } else if (this.dNc < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dNd < getmCdnLogData().getSlowNumber()) {
                    if (this.dNc >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dNc < 100.0f || this.dNd < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dNi) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dNc += 10.0f;
                } else {
                    this.dNc += getmCdnLogData().getSlowRank();
                }
                this.dNd++;
                this.dNf = (int) (this.dNf + j);
                this.dNe++;
                int i4 = this.dNe;
                int i5 = this.mErrorNum;
                int i6 = this.dNd;
                if (this.dNd != 0) {
                    i = this.dNf / this.dNd;
                }
                String cdnErrorJsonData = this.dNh.toString();
                if (getmCdnLogData() != null && this.wM > 0 && System.currentTimeMillis() - this.wM > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dMX = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dNe >= 5) {
                        if (this.dNc >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dNd >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dNc >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dNc >= 100.0f && this.dNd >= getmCdnLogData().getSlowNumber()) {
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
                this.dNc -= 25.0f;
            } else {
                this.dNc -= getmCdnLogData().getSuccRank();
            }
            if (this.dNc < 0.0f) {
                this.dNc = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dMZ) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dNg == null) {
            this.dNg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dNg);
        cDNUpLoadTask.execute(new Object[0]);
        this.dMZ = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dNe = 0;
        this.dNd = 0;
        this.mErrorNum = 0;
        this.dNf = 0;
        this.dNc = 0.0f;
        this.dNh.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String adB;
        private final int dNd;
        private final int dNe;
        private final String dNl;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dNd = i4;
            this.adB = str;
            this.dNl = str2;
            this.mType = i;
            this.dNe = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dNe));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.adB);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dNd));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dNl);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dNd + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dNl);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.adB);
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
        /* renamed from: x */
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
                    CDNProblemUploader.this.aqQ.setmSwitch(false);
                    CDNProblemUploader.this.wM = System.currentTimeMillis();
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
                        CDNProblemUploader.this.aqQ.setmSwitch(false);
                        CDNProblemUploader.this.wM = System.currentTimeMillis();
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
                CDNProblemUploader.this.dMZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dNm;

        private CdnErrorJsonData() {
            this.dNm = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dNm.length() != 0) {
                this.dNm.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dNm.append(i);
        }

        public void clear() {
            this.dNm.setLength(0);
        }

        public String toString() {
            return this.dNm.toString();
        }
    }
}
