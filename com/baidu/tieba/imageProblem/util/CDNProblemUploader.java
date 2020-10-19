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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kiw;
    private static Object lockObject = new Object();
    private p eOL;
    private int kiq;
    private int kir;
    private int kis;
    private int kit;
    private Handler mHandler;
    private final int kic = 5;
    private final int kie = 0;
    private final int kif = 1;
    private final int kig = 2;
    private final int kih = 3;
    private final byte kii = 0;
    private final byte kij = 1;
    private int kik = 0;
    private final int kil = 5;
    private boolean kim = false;
    private long Ol = 0;
    private final long kin = 86400000;
    private final float kio = 100.0f;
    private float kip = 0.0f;
    private BdAsyncTaskParallel kiu = null;
    private final CdnErrorJsonData kiv = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kik + 1;
        cDNProblemUploader.kik = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kiw == null) {
            synchronized (CDNProblemUploader.class) {
                if (kiw == null) {
                    kiw = new CDNProblemUploader();
                }
            }
        }
        return kiw;
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

    @Override // com.baidu.tbadk.core.util.r
    public p getmCdnLogData() {
        return this.eOL;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(p pVar) {
        synchronized (lockObject) {
            this.eOL = pVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.kip += 25.0f;
            } else {
                this.kip += getmCdnLogData().getErrRank();
            }
            this.kis++;
            this.kir++;
            this.kiv.add(i);
            int i3 = this.kis;
            int i4 = this.kir;
            int i5 = this.kiq;
            int i6 = this.kiq != 0 ? this.kit / this.kiq : 0;
            String cdnErrorJsonData = this.kiv.toString();
            if (getmCdnLogData() != null && this.Ol > 0 && System.currentTimeMillis() - this.Ol > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kik = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kis < 5) {
                    i2 = 0;
                } else if (this.kip < 100.0f || this.kir < getmCdnLogData().getErrNumber() || this.kiq < getmCdnLogData().getSlowNumber()) {
                    if (this.kip >= 100.0f && this.kir >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kip < 100.0f || this.kiq < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (lockObject) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.kip += 10.0f;
                } else {
                    this.kip += getmCdnLogData().getSlowRank();
                }
                this.kiq++;
                this.kit = (int) (this.kit + j);
                this.kis++;
                int i4 = this.kis;
                int i5 = this.kir;
                int i6 = this.kiq;
                if (this.kiq != 0) {
                    i = this.kit / this.kiq;
                }
                String cdnErrorJsonData = this.kiv.toString();
                if (getmCdnLogData() != null && this.Ol > 0 && System.currentTimeMillis() - this.Ol > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kik = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kis >= 5) {
                        if (this.kip >= 100.0f && this.kir >= getmCdnLogData().getErrNumber() && this.kiq >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kip >= 100.0f && this.kir >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kip >= 100.0f && this.kiq >= getmCdnLogData().getSlowNumber()) {
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
                this.kip -= 25.0f;
            } else {
                this.kip -= getmCdnLogData().getSuccRank();
            }
            if (this.kip < 0.0f) {
                this.kip = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kim) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kiu == null) {
            this.kiu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kiu);
        cDNUpLoadTask.execute(new Object[0]);
        this.kim = true;
        a mT = u.mT();
        mT.append("act", "fallback");
        mT.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kis = 0;
        this.kiq = 0;
        this.kir = 0;
        this.kit = 0;
        this.kip = 0.0f;
        this.kiv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final String bum;
        private final int kiq;
        private final int kir;
        private final int kis;
        private final String kiy;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kir = i3;
            this.kiq = i4;
            this.bum = str;
            this.kiy = str2;
            this.mType = i;
            this.kis = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bML.addPostData("number", String.valueOf(this.kis));
            if (this.mType == 1) {
                this.bML.addPostData("ab_num_error", String.valueOf(this.kir));
                this.bML.addPostData(BdStatsConstant.StatsType.ERROR, this.bum);
                this.bML.addPostData("ab_num_slow", String.valueOf(this.kiq));
                this.bML.addPostData("time", this.kiy);
            } else if (this.mType == 3) {
                this.bML.addPostData("ab_num_slow", this.kiq + "");
                this.bML.addPostData("time", this.kiy);
            } else if (this.mType == 2) {
                this.bML.addPostData("ab_num_error", this.kir + "");
                this.bML.addPostData(BdStatsConstant.StatsType.ERROR, this.bum);
            }
            String postNetData = this.bML.postNetData();
            if (!this.bML.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: dY */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a mT = u.mT();
                    mT.append("act", "fallback");
                    mT.append("result", "1");
                    mT.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", mT);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.eOL.setmSwitch(false);
                    CDNProblemUploader.this.Ol = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a mT2 = u.mT();
                        mT2.append("act", "fallback");
                        mT2.append("result", "2");
                        mT2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT2);
                    } else {
                        a mT3 = u.mT();
                        mT3.append("act", "fallback");
                        mT3.append("result", "0");
                        mT3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", mT3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.eOL.setmSwitch(false);
                        CDNProblemUploader.this.Ol = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    p pVar = new p();
                    pVar.parseJson(optString);
                    if (pVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && pVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && pVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && pVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(pVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.kim = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class CdnErrorJsonData {
        StringBuffer kiz;

        private CdnErrorJsonData() {
            this.kiz = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kiz.length() != 0) {
                this.kiz.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.kiz.append(i);
        }

        public void clear() {
            this.kiz.setLength(0);
        }

        public String toString() {
            return this.kiz.toString();
        }
    }
}
