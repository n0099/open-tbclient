package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends p {
    private static Object bMP = new Object();
    private static volatile CDNProblemUploader bMQ;
    private f agZ;
    private int bMJ;
    private int bMK;
    private int bML;
    private int bMM;
    private Handler mHandler;
    private final int bMw = 5;
    private final int bMx = 0;
    private final int bMy = 1;
    private final int bMz = 2;
    private final int bMA = 3;
    private final byte bMB = 0;
    private final byte bMC = 1;
    private int bMD = 0;
    private final int bME = 5;
    private boolean bMF = false;
    private long wO = 0;
    private final long bMG = 86400000;
    private final float bMH = 100.0f;
    private float bMI = 0.0f;
    private BdAsyncTaskParallel bMN = null;
    private final CdnErrorJsonData bMO = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bMQ == null) {
            synchronized (CDNProblemUploader.class) {
                if (bMQ == null) {
                    bMQ = new CDNProblemUploader();
                }
            }
        }
        return bMQ;
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
    public f getmCdnLogData() {
        return this.agZ;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(f fVar) {
        synchronized (bMP) {
            this.agZ = fVar;
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
        synchronized (bMP) {
            if (getmCdnLogData() == null) {
                this.bMI += 25.0f;
            } else {
                this.bMI += getmCdnLogData().getErrRank();
            }
            this.bML++;
            this.bMK++;
            this.bMO.add(i);
            int i3 = this.bML;
            int i4 = this.bMK;
            int i5 = this.bMJ;
            int i6 = this.bMJ != 0 ? this.bMM / this.bMJ : 0;
            String cdnErrorJsonData = this.bMO.toString();
            if (getmCdnLogData() != null && this.wO > 0 && System.currentTimeMillis() - this.wO > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bMD = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bML < 5) {
                    i2 = 0;
                } else if (this.bMI < 100.0f || this.bMK < getmCdnLogData().getErrNumber() || this.bMJ < getmCdnLogData().getSlowNumber()) {
                    if (this.bMI >= 100.0f && this.bMK >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bMI < 100.0f || this.bMJ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bMP) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bMI += 10.0f;
                } else {
                    this.bMI += getmCdnLogData().getSlowRank();
                }
                this.bMJ++;
                this.bMM = (int) (this.bMM + j);
                this.bML++;
                int i4 = this.bML;
                int i5 = this.bMK;
                int i6 = this.bMJ;
                if (this.bMJ != 0) {
                    i = this.bMM / this.bMJ;
                }
                String cdnErrorJsonData = this.bMO.toString();
                if (getmCdnLogData() != null && this.wO > 0 && System.currentTimeMillis() - this.wO > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bMD = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bML >= 5) {
                        if (this.bMI >= 100.0f && this.bMK >= getmCdnLogData().getErrNumber() && this.bMJ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bMI >= 100.0f && this.bMK >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bMI >= 100.0f && this.bMJ >= getmCdnLogData().getSlowNumber()) {
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
                this.bMI -= 25.0f;
            } else {
                this.bMI -= getmCdnLogData().getSuccRank();
            }
            if (this.bMI < 0.0f) {
                this.bMI = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.bMF) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bMN == null) {
            this.bMN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bMN);
        cDNUpLoadTask.execute(new Object[0]);
        this.bMF = true;
        d hd = r.hd();
        hd.q("act", "fallback");
        hd.q("type", IntentConfig.START);
        a.hk().b("img", hd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bML = 0;
        this.bMJ = 0;
        this.bMK = 0;
        this.bMM = 0;
        this.bMI = 0.0f;
        this.bMO.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final v Tu = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String XT;
        private final int bMJ;
        private final int bMK;
        private final int bML;
        private final String bMS;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bMK = i3;
            this.bMJ = i4;
            this.XT = str;
            this.bMS = str2;
            this.mType = i;
            this.bML = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Tu.o("number", String.valueOf(this.bML));
            if (this.mType == 1) {
                this.Tu.o("ab_num_error", String.valueOf(this.bMK));
                this.Tu.o("error", this.XT);
                this.Tu.o("ab_num_slow", String.valueOf(this.bMJ));
                this.Tu.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bMS);
            } else if (this.mType == 3) {
                this.Tu.o("ab_num_slow", new StringBuilder(String.valueOf(this.bMJ)).toString());
                this.Tu.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bMS);
            } else if (this.mType == 2) {
                this.Tu.o("ab_num_error", new StringBuilder(String.valueOf(this.bMK)).toString());
                this.Tu.o("error", this.XT);
            }
            String tD = this.Tu.tD();
            if (!this.Tu.uh() || TextUtils.isEmpty(tD)) {
                return null;
            }
            try {
                return new JSONObject(tD);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d hd = r.hd();
                    hd.q("act", "fallback");
                    hd.q("result", "1");
                    hd.q("type", "end");
                    a.hk().b("img", hd);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.bMD + 1;
                cDNProblemUploader.bMD = i;
                if (i >= 5) {
                    CDNProblemUploader.this.agZ.setmSwitch(false);
                    CDNProblemUploader.this.wO = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d hd2 = r.hd();
                    hd2.q("act", "fallback");
                    hd2.q("result", "2");
                    hd2.q("type", "end");
                    a.hk().b("img", hd2);
                } else {
                    d hd3 = r.hd();
                    hd3.q("act", "fallback");
                    hd3.q("result", "0");
                    hd3.q("type", "end");
                    a.hk().b("img", hd3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.agZ.setmSwitch(false);
                    CDNProblemUploader.this.wO = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                f fVar = new f();
                fVar.parseJson(optString);
                if (fVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && fVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && fVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && fVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(fVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.bMF = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bMT;

        private CdnErrorJsonData() {
            this.bMT = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bMT.length() != 0) {
                this.bMT.append(",");
            }
            this.bMT.append(i);
        }

        public void clear() {
            this.bMT.setLength(0);
        }

        public String toString() {
            return this.bMT.toString();
        }
    }
}
