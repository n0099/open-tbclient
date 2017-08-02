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
    private static Object dGp = new Object();
    private static volatile CDNProblemUploader dGq;
    private l aqM;
    private int dGk;
    private int dGl;
    private int dGm;
    private int mErrorNum;
    private Handler mHandler;
    private final int dFX = 5;
    private final int dFY = 0;
    private final int dFZ = 1;
    private final int dGa = 2;
    private final int dGb = 3;
    private final byte dGc = 0;
    private final byte dGd = 1;
    private int dGe = 0;
    private final int dGf = 5;
    private boolean dGg = false;
    private long xo = 0;
    private final long dGh = 86400000;
    private final float dGi = 100.0f;
    private float dGj = 0.0f;
    private BdAsyncTaskParallel dGn = null;
    private final CdnErrorJsonData dGo = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.dGe + 1;
        cDNProblemUploader.dGe = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (dGq == null) {
            synchronized (CDNProblemUploader.class) {
                if (dGq == null) {
                    dGq = new CDNProblemUploader();
                }
            }
        }
        return dGq;
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
        return this.aqM;
    }

    @Override // com.baidu.tbadk.core.util.o
    public void setmCdnLogData(l lVar) {
        synchronized (dGp) {
            this.aqM = lVar;
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
        synchronized (dGp) {
            if (getmCdnLogData() == null) {
                this.dGj += 25.0f;
            } else {
                this.dGj += getmCdnLogData().getErrRank();
            }
            this.dGl++;
            this.mErrorNum++;
            this.dGo.add(i);
            int i3 = this.dGl;
            int i4 = this.mErrorNum;
            int i5 = this.dGk;
            int i6 = this.dGk != 0 ? this.dGm / this.dGk : 0;
            String cdnErrorJsonData = this.dGo.toString();
            if (getmCdnLogData() != null && this.xo > 0 && System.currentTimeMillis() - this.xo > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dGe = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dGl < 5) {
                    i2 = 0;
                } else if (this.dGj < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dGk < getmCdnLogData().getSlowNumber()) {
                    if (this.dGj >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dGj < 100.0f || this.dGk < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dGp) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dGj += 10.0f;
                } else {
                    this.dGj += getmCdnLogData().getSlowRank();
                }
                this.dGk++;
                this.dGm = (int) (this.dGm + j);
                this.dGl++;
                int i4 = this.dGl;
                int i5 = this.mErrorNum;
                int i6 = this.dGk;
                if (this.dGk != 0) {
                    i = this.dGm / this.dGk;
                }
                String cdnErrorJsonData = this.dGo.toString();
                if (getmCdnLogData() != null && this.xo > 0 && System.currentTimeMillis() - this.xo > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dGe = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dGl >= 5) {
                        if (this.dGj >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dGk >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dGj >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dGj >= 100.0f && this.dGk >= getmCdnLogData().getSlowNumber()) {
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
                this.dGj -= 25.0f;
            } else {
                this.dGj -= getmCdnLogData().getSuccRank();
            }
            if (this.dGj < 0.0f) {
                this.dGj = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dGg) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dGn == null) {
            this.dGn = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dGn);
        cDNUpLoadTask.execute(new Object[0]);
        this.dGg = true;
        a fK = r.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dGl = 0;
        this.dGk = 0;
        this.mErrorNum = 0;
        this.dGm = 0;
        this.dGj = 0.0f;
        this.dGo.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String adz;
        private final int dGk;
        private final int dGl;
        private final String dGs;
        private final int mErrorNum;
        private final w mNetWork = new w(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dGk = i4;
            this.adz = str;
            this.dGs = str2;
            this.mType = i;
            this.dGl = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dGl));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.adz);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dGk));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dGs);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.dGk + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dGs);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.adz);
            }
            String uE = this.mNetWork.uE();
            if (!this.mNetWork.ve() || TextUtils.isEmpty(uE)) {
                return null;
            }
            try {
                return new JSONObject(uE);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fK = r.fK();
                    fK.p("act", "fallback");
                    fK.p("result", "1");
                    fK.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fK);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aqM.setmSwitch(false);
                    CDNProblemUploader.this.xo = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fK2 = r.fK();
                        fK2.p("act", "fallback");
                        fK2.p("result", "2");
                        fK2.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK2);
                    } else {
                        a fK3 = r.fK();
                        fK3.p("act", "fallback");
                        fK3.p("result", "0");
                        fK3.p("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fK3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aqM.setmSwitch(false);
                        CDNProblemUploader.this.xo = System.currentTimeMillis();
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
                CDNProblemUploader.this.dGg = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer dGt;

        private CdnErrorJsonData() {
            this.dGt = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.dGt.length() != 0) {
                this.dGt.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.dGt.append(i);
        }

        public void clear() {
            this.dGt.setLength(0);
        }

        public String toString() {
            return this.dGt.toString();
        }
    }
}
