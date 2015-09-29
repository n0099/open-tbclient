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
import com.baidu.tbadk.core.data.e;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends p {
    private static Object bQY = new Object();
    private static volatile CDNProblemUploader bQZ;
    private e agf;
    private int bQS;
    private int bQT;
    private int bQU;
    private int bQV;
    private Handler mHandler;
    private final int bQF = 5;
    private final int bQG = 0;
    private final int bQH = 1;
    private final int bQI = 2;
    private final int bQJ = 3;
    private final byte bQK = 0;
    private final byte bQL = 1;
    private int bQM = 0;
    private final int bQN = 5;
    private boolean bQO = false;
    private long wN = 0;
    private final long bQP = 86400000;
    private final float bQQ = 100.0f;
    private float bQR = 0.0f;
    private BdAsyncTaskParallel bQW = null;
    private final CdnErrorJsonData bQX = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bQZ == null) {
            synchronized (CDNProblemUploader.class) {
                if (bQZ == null) {
                    bQZ = new CDNProblemUploader();
                }
            }
        }
        return bQZ;
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
    public e getmCdnLogData() {
        return this.agf;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(e eVar) {
        synchronized (bQY) {
            this.agf = eVar;
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
        synchronized (bQY) {
            if (getmCdnLogData() == null) {
                this.bQR += 25.0f;
            } else {
                this.bQR += getmCdnLogData().getErrRank();
            }
            this.bQU++;
            this.bQT++;
            this.bQX.add(i);
            int i3 = this.bQU;
            int i4 = this.bQT;
            int i5 = this.bQS;
            int i6 = this.bQS != 0 ? this.bQV / this.bQS : 0;
            String cdnErrorJsonData = this.bQX.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bQM = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bQU < 5) {
                    i2 = 0;
                } else if (this.bQR < 100.0f || this.bQT < getmCdnLogData().getErrNumber() || this.bQS < getmCdnLogData().getSlowNumber()) {
                    if (this.bQR >= 100.0f && this.bQT >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bQR < 100.0f || this.bQS < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bQY) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bQR += 10.0f;
                } else {
                    this.bQR += getmCdnLogData().getSlowRank();
                }
                this.bQS++;
                this.bQV = (int) (this.bQV + j);
                this.bQU++;
                int i4 = this.bQU;
                int i5 = this.bQT;
                int i6 = this.bQS;
                if (this.bQS != 0) {
                    i = this.bQV / this.bQS;
                }
                String cdnErrorJsonData = this.bQX.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bQM = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bQU >= 5) {
                        if (this.bQR >= 100.0f && this.bQT >= getmCdnLogData().getErrNumber() && this.bQS >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bQR >= 100.0f && this.bQT >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bQR >= 100.0f && this.bQS >= getmCdnLogData().getSlowNumber()) {
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
                this.bQR -= 25.0f;
            } else {
                this.bQR -= getmCdnLogData().getSuccRank();
            }
            if (this.bQR < 0.0f) {
                this.bQR = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.bQO) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bQW == null) {
            this.bQW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bQW);
        cDNUpLoadTask.execute(new Object[0]);
        this.bQO = true;
        d hb = r.hb();
        hb.q("act", "fallback");
        hb.q("type", IntentConfig.START);
        a.hi().b("img", hb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bQU = 0;
        this.bQS = 0;
        this.bQT = 0;
        this.bQV = 0;
        this.bQR = 0.0f;
        this.bQX.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final w Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String XT;
        private final int bQS;
        private final int bQT;
        private final int bQU;
        private final String bRb;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bQT = i3;
            this.bQS = i4;
            this.XT = str;
            this.bRb = str2;
            this.mType = i;
            this.bQU = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Th.o("number", String.valueOf(this.bQU));
            if (this.mType == 1) {
                this.Th.o("ab_num_error", String.valueOf(this.bQT));
                this.Th.o("error", this.XT);
                this.Th.o("ab_num_slow", String.valueOf(this.bQS));
                this.Th.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRb);
            } else if (this.mType == 3) {
                this.Th.o("ab_num_slow", new StringBuilder(String.valueOf(this.bQS)).toString());
                this.Th.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRb);
            } else if (this.mType == 2) {
                this.Th.o("ab_num_error", new StringBuilder(String.valueOf(this.bQT)).toString());
                this.Th.o("error", this.XT);
            }
            String tG = this.Th.tG();
            if (!this.Th.uk() || TextUtils.isEmpty(tG)) {
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
                int i = cDNProblemUploader.bQM + 1;
                cDNProblemUploader.bQM = i;
                if (i >= 5) {
                    CDNProblemUploader.this.agf.setmSwitch(false);
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
                    CDNProblemUploader.this.agf.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                e eVar = new e();
                eVar.parseJson(optString);
                if (eVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && eVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && eVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && eVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(eVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.bQO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bRc;

        private CdnErrorJsonData() {
            this.bRc = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bRc.length() != 0) {
                this.bRc.append(",");
            }
            this.bRc.append(i);
        }

        public void clear() {
            this.bRc.setLength(0);
        }

        public String toString() {
            return this.bRc.toString();
        }
    }
}
