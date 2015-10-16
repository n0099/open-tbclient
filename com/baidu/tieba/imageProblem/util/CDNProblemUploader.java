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
import com.baidu.tbadk.core.util.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends p {
    private static Object bRj = new Object();
    private static volatile CDNProblemUploader bRk;
    private f agg;
    private int bRd;
    private int bRe;
    private int bRf;
    private int bRg;
    private Handler mHandler;
    private final int bQQ = 5;
    private final int bQR = 0;
    private final int bQS = 1;
    private final int bQT = 2;
    private final int bQU = 3;
    private final byte bQV = 0;
    private final byte bQW = 1;
    private int bQX = 0;
    private final int bQY = 5;
    private boolean bQZ = false;
    private long wN = 0;
    private final long bRa = 86400000;
    private final float bRb = 100.0f;
    private float bRc = 0.0f;
    private BdAsyncTaskParallel bRh = null;
    private final CdnErrorJsonData bRi = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bRk == null) {
            synchronized (CDNProblemUploader.class) {
                if (bRk == null) {
                    bRk = new CDNProblemUploader();
                }
            }
        }
        return bRk;
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
        return this.agg;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(f fVar) {
        synchronized (bRj) {
            this.agg = fVar;
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
        synchronized (bRj) {
            if (getmCdnLogData() == null) {
                this.bRc += 25.0f;
            } else {
                this.bRc += getmCdnLogData().getErrRank();
            }
            this.bRf++;
            this.bRe++;
            this.bRi.add(i);
            int i3 = this.bRf;
            int i4 = this.bRe;
            int i5 = this.bRd;
            int i6 = this.bRd != 0 ? this.bRg / this.bRd : 0;
            String cdnErrorJsonData = this.bRi.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bQX = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bRf < 5) {
                    i2 = 0;
                } else if (this.bRc < 100.0f || this.bRe < getmCdnLogData().getErrNumber() || this.bRd < getmCdnLogData().getSlowNumber()) {
                    if (this.bRc >= 100.0f && this.bRe >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bRc < 100.0f || this.bRd < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bRj) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bRc += 10.0f;
                } else {
                    this.bRc += getmCdnLogData().getSlowRank();
                }
                this.bRd++;
                this.bRg = (int) (this.bRg + j);
                this.bRf++;
                int i4 = this.bRf;
                int i5 = this.bRe;
                int i6 = this.bRd;
                if (this.bRd != 0) {
                    i = this.bRg / this.bRd;
                }
                String cdnErrorJsonData = this.bRi.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bQX = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bRf >= 5) {
                        if (this.bRc >= 100.0f && this.bRe >= getmCdnLogData().getErrNumber() && this.bRd >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bRc >= 100.0f && this.bRe >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bRc >= 100.0f && this.bRd >= getmCdnLogData().getSlowNumber()) {
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
                this.bRc -= 25.0f;
            } else {
                this.bRc -= getmCdnLogData().getSuccRank();
            }
            if (this.bRc < 0.0f) {
                this.bRc = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.bQZ) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bRh == null) {
            this.bRh = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bRh);
        cDNUpLoadTask.execute(new Object[0]);
        this.bQZ = true;
        d hb = r.hb();
        hb.q("act", "fallback");
        hb.q("type", IntentConfig.START);
        a.hi().b("img", hb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bRf = 0;
        this.bRd = 0;
        this.bRe = 0;
        this.bRg = 0;
        this.bRc = 0.0f;
        this.bRi.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final w Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String XV;
        private final int bRd;
        private final int bRe;
        private final int bRf;
        private final String bRm;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bRe = i3;
            this.bRd = i4;
            this.XV = str;
            this.bRm = str2;
            this.mType = i;
            this.bRf = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ti.o("number", String.valueOf(this.bRf));
            if (this.mType == 1) {
                this.Ti.o("ab_num_error", String.valueOf(this.bRe));
                this.Ti.o("error", this.XV);
                this.Ti.o("ab_num_slow", String.valueOf(this.bRd));
                this.Ti.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRm);
            } else if (this.mType == 3) {
                this.Ti.o("ab_num_slow", new StringBuilder(String.valueOf(this.bRd)).toString());
                this.Ti.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRm);
            } else if (this.mType == 2) {
                this.Ti.o("ab_num_error", new StringBuilder(String.valueOf(this.bRe)).toString());
                this.Ti.o("error", this.XV);
            }
            String tG = this.Ti.tG();
            if (!this.Ti.uk() || TextUtils.isEmpty(tG)) {
                return null;
            }
            try {
                return new JSONObject(tG);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d hb = r.hb();
                    hb.q("act", "fallback");
                    hb.q("result", "1");
                    hb.q("type", "end");
                    a.hi().b("img", hb);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.bQX + 1;
                cDNProblemUploader.bQX = i;
                if (i >= 5) {
                    CDNProblemUploader.this.agg.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d hb2 = r.hb();
                    hb2.q("act", "fallback");
                    hb2.q("result", "2");
                    hb2.q("type", "end");
                    a.hi().b("img", hb2);
                } else {
                    d hb3 = r.hb();
                    hb3.q("act", "fallback");
                    hb3.q("result", "0");
                    hb3.q("type", "end");
                    a.hi().b("img", hb3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.agg.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
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
                CDNProblemUploader.this.bQZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bRn;

        private CdnErrorJsonData() {
            this.bRn = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bRn.length() != 0) {
                this.bRn.append(",");
            }
            this.bRn.append(i);
        }

        public void clear() {
            this.bRn.setLength(0);
        }

        public String toString() {
            return this.bRn.toString();
        }
    }
}
