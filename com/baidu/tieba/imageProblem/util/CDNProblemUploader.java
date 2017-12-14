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
    private static Object edG = new Object();
    private static volatile CDNProblemUploader edH;
    private k ary;
    private int edB;
    private int edC;
    private int edD;
    private int mErrorNum;
    private Handler mHandler;
    private final int edo = 5;
    private final int edp = 0;
    private final int edq = 1;
    private final int edr = 2;
    private final int eds = 3;
    private final byte edt = 0;
    private final byte edu = 1;
    private int edv = 0;
    private final int edw = 5;
    private boolean edx = false;
    private long wK = 0;
    private final long edy = 86400000;
    private final float edz = 100.0f;
    private float edA = 0.0f;
    private BdAsyncTaskParallel edE = null;
    private final CdnErrorJsonData edF = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.edv + 1;
        cDNProblemUploader.edv = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (edH == null) {
            synchronized (CDNProblemUploader.class) {
                if (edH == null) {
                    edH = new CDNProblemUploader();
                }
            }
        }
        return edH;
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
        return this.ary;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (edG) {
            this.ary = kVar;
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
        synchronized (edG) {
            if (getmCdnLogData() == null) {
                this.edA += 25.0f;
            } else {
                this.edA += getmCdnLogData().getErrRank();
            }
            this.edC++;
            this.mErrorNum++;
            this.edF.add(i);
            int i3 = this.edC;
            int i4 = this.mErrorNum;
            int i5 = this.edB;
            int i6 = this.edB != 0 ? this.edD / this.edB : 0;
            String cdnErrorJsonData = this.edF.toString();
            if (getmCdnLogData() != null && this.wK > 0 && System.currentTimeMillis() - this.wK > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.edv = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.edC < 5) {
                    i2 = 0;
                } else if (this.edA < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.edB < getmCdnLogData().getSlowNumber()) {
                    if (this.edA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.edA < 100.0f || this.edB < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (edG) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.edA += 10.0f;
                } else {
                    this.edA += getmCdnLogData().getSlowRank();
                }
                this.edB++;
                this.edD = (int) (this.edD + j);
                this.edC++;
                int i4 = this.edC;
                int i5 = this.mErrorNum;
                int i6 = this.edB;
                if (this.edB != 0) {
                    i = this.edD / this.edB;
                }
                String cdnErrorJsonData = this.edF.toString();
                if (getmCdnLogData() != null && this.wK > 0 && System.currentTimeMillis() - this.wK > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.edv = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.edC >= 5) {
                        if (this.edA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.edB >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.edA >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.edA >= 100.0f && this.edB >= getmCdnLogData().getSlowNumber()) {
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
                this.edA -= 25.0f;
            } else {
                this.edA -= getmCdnLogData().getSuccRank();
            }
            if (this.edA < 0.0f) {
                this.edA = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.edx) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.edE == null) {
            this.edE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.edE);
        cDNUpLoadTask.execute(new Object[0]);
        this.edx = true;
        a fK = s.fK();
        fK.p("act", "fallback");
        fK.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.edC = 0;
        this.edB = 0;
        this.mErrorNum = 0;
        this.edD = 0;
        this.edA = 0.0f;
        this.edF.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aec;
        private final int edB;
        private final int edC;
        private final String edJ;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.edB = i4;
            this.aec = str;
            this.edJ = str2;
            this.mType = i;
            this.edC = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.edC));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.aec);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.edB));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.edJ);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", this.edB + "");
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.edJ);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", this.mErrorNum + "");
                this.mNetWork.n("error", this.aec);
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
        /* renamed from: y */
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
                    CDNProblemUploader.this.ary.setmSwitch(false);
                    CDNProblemUploader.this.wK = System.currentTimeMillis();
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
                        CDNProblemUploader.this.ary.setmSwitch(false);
                        CDNProblemUploader.this.wK = System.currentTimeMillis();
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
                CDNProblemUploader.this.edx = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer edK;

        private CdnErrorJsonData() {
            this.edK = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.edK.length() != 0) {
                this.edK.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.edK.append(i);
        }

        public void clear() {
            this.edK.setLength(0);
        }

        public String toString() {
            return this.edK.toString();
        }
    }
}
