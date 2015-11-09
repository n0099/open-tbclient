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
    private static Object bRE = new Object();
    private static volatile CDNProblemUploader bRF;
    private f agm;
    private int bRA;
    private int bRB;
    private int bRy;
    private int bRz;
    private Handler mHandler;
    private final int bRl = 5;
    private final int bRm = 0;
    private final int bRn = 1;
    private final int bRo = 2;
    private final int bRp = 3;
    private final byte bRq = 0;
    private final byte bRr = 1;
    private int bRs = 0;
    private final int bRt = 5;
    private boolean bRu = false;
    private long wN = 0;
    private final long bRv = 86400000;
    private final float bRw = 100.0f;
    private float bRx = 0.0f;
    private BdAsyncTaskParallel bRC = null;
    private final CdnErrorJsonData bRD = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bRF == null) {
            synchronized (CDNProblemUploader.class) {
                if (bRF == null) {
                    bRF = new CDNProblemUploader();
                }
            }
        }
        return bRF;
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
        return this.agm;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(f fVar) {
        synchronized (bRE) {
            this.agm = fVar;
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
        synchronized (bRE) {
            if (getmCdnLogData() == null) {
                this.bRx += 25.0f;
            } else {
                this.bRx += getmCdnLogData().getErrRank();
            }
            this.bRA++;
            this.bRz++;
            this.bRD.add(i);
            int i3 = this.bRA;
            int i4 = this.bRz;
            int i5 = this.bRy;
            int i6 = this.bRy != 0 ? this.bRB / this.bRy : 0;
            String cdnErrorJsonData = this.bRD.toString();
            if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bRs = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bRA < 5) {
                    i2 = 0;
                } else if (this.bRx < 100.0f || this.bRz < getmCdnLogData().getErrNumber() || this.bRy < getmCdnLogData().getSlowNumber()) {
                    if (this.bRx >= 100.0f && this.bRz >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bRx < 100.0f || this.bRy < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bRE) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bRx += 10.0f;
                } else {
                    this.bRx += getmCdnLogData().getSlowRank();
                }
                this.bRy++;
                this.bRB = (int) (this.bRB + j);
                this.bRA++;
                int i4 = this.bRA;
                int i5 = this.bRz;
                int i6 = this.bRy;
                if (this.bRy != 0) {
                    i = this.bRB / this.bRy;
                }
                String cdnErrorJsonData = this.bRD.toString();
                if (getmCdnLogData() != null && this.wN > 0 && System.currentTimeMillis() - this.wN > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bRs = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bRA >= 5) {
                        if (this.bRx >= 100.0f && this.bRz >= getmCdnLogData().getErrNumber() && this.bRy >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bRx >= 100.0f && this.bRz >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bRx >= 100.0f && this.bRy >= getmCdnLogData().getSlowNumber()) {
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
                this.bRx -= 25.0f;
            } else {
                this.bRx -= getmCdnLogData().getSuccRank();
            }
            if (this.bRx < 0.0f) {
                this.bRx = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.bRu) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bRC == null) {
            this.bRC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bRC);
        cDNUpLoadTask.execute(new Object[0]);
        this.bRu = true;
        d hc = r.hc();
        hc.q("act", "fallback");
        hc.q("type", IntentConfig.START);
        a.hj().b("img", hc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bRA = 0;
        this.bRy = 0;
        this.bRz = 0;
        this.bRB = 0;
        this.bRx = 0.0f;
        this.bRD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final w Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String XZ;
        private final int bRA;
        private final String bRH;
        private final int bRy;
        private final int bRz;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bRz = i3;
            this.bRy = i4;
            this.XZ = str;
            this.bRH = str2;
            this.mType = i;
            this.bRA = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Tj.o("number", String.valueOf(this.bRA));
            if (this.mType == 1) {
                this.Tj.o("ab_num_error", String.valueOf(this.bRz));
                this.Tj.o("error", this.XZ);
                this.Tj.o("ab_num_slow", String.valueOf(this.bRy));
                this.Tj.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRH);
            } else if (this.mType == 3) {
                this.Tj.o("ab_num_slow", new StringBuilder(String.valueOf(this.bRy)).toString());
                this.Tj.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bRH);
            } else if (this.mType == 2) {
                this.Tj.o("ab_num_error", new StringBuilder(String.valueOf(this.bRz)).toString());
                this.Tj.o("error", this.XZ);
            }
            String tG = this.Tj.tG();
            if (!this.Tj.uk() || TextUtils.isEmpty(tG)) {
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
                    d hc = r.hc();
                    hc.q("act", "fallback");
                    hc.q("result", "1");
                    hc.q("type", "end");
                    a.hj().b("img", hc);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.bRs + 1;
                cDNProblemUploader.bRs = i;
                if (i >= 5) {
                    CDNProblemUploader.this.agm.setmSwitch(false);
                    CDNProblemUploader.this.wN = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d hc2 = r.hc();
                    hc2.q("act", "fallback");
                    hc2.q("result", "2");
                    hc2.q("type", "end");
                    a.hj().b("img", hc2);
                } else {
                    d hc3 = r.hc();
                    hc3.q("act", "fallback");
                    hc3.q("result", "0");
                    hc3.q("type", "end");
                    a.hj().b("img", hc3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.agm.setmSwitch(false);
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
                CDNProblemUploader.this.bRu = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bRI;

        private CdnErrorJsonData() {
            this.bRI = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bRI.length() != 0) {
                this.bRI.append(",");
            }
            this.bRI.append(i);
        }

        public void clear() {
            this.bRI.setLength(0);
        }

        public String toString() {
            return this.bRI.toString();
        }
    }
}
