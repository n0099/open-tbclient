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
    private static Object bNw = new Object();
    private static volatile CDNProblemUploader bNx;
    private f ahj;
    private int bNq;
    private int bNr;
    private int bNs;
    private int bNt;
    private Handler mHandler;
    private final int bNd = 5;
    private final int bNe = 0;
    private final int bNf = 1;
    private final int bNg = 2;
    private final int bNh = 3;
    private final byte bNi = 0;
    private final byte bNj = 1;
    private int bNk = 0;
    private final int bNl = 5;
    private boolean bNm = false;
    private long wM = 0;
    private final long bNn = 86400000;
    private final float bNo = 100.0f;
    private float bNp = 0.0f;
    private BdAsyncTaskParallel bNu = null;
    private final CdnErrorJsonData bNv = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bNx == null) {
            synchronized (CDNProblemUploader.class) {
                if (bNx == null) {
                    bNx = new CDNProblemUploader();
                }
            }
        }
        return bNx;
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
        return this.ahj;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(f fVar) {
        synchronized (bNw) {
            this.ahj = fVar;
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
        synchronized (bNw) {
            if (getmCdnLogData() == null) {
                this.bNp += 25.0f;
            } else {
                this.bNp += getmCdnLogData().getErrRank();
            }
            this.bNs++;
            this.bNr++;
            this.bNv.add(i);
            int i3 = this.bNs;
            int i4 = this.bNr;
            int i5 = this.bNq;
            int i6 = this.bNq != 0 ? this.bNt / this.bNq : 0;
            String cdnErrorJsonData = this.bNv.toString();
            if (getmCdnLogData() != null && this.wM > 0 && System.currentTimeMillis() - this.wM > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bNk = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bNs < 5) {
                    i2 = 0;
                } else if (this.bNp < 100.0f || this.bNr < getmCdnLogData().getErrNumber() || this.bNq < getmCdnLogData().getSlowNumber()) {
                    if (this.bNp >= 100.0f && this.bNr >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bNp < 100.0f || this.bNq < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bNw) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bNp += 10.0f;
                } else {
                    this.bNp += getmCdnLogData().getSlowRank();
                }
                this.bNq++;
                this.bNt = (int) (this.bNt + j);
                this.bNs++;
                int i4 = this.bNs;
                int i5 = this.bNr;
                int i6 = this.bNq;
                if (this.bNq != 0) {
                    i = this.bNt / this.bNq;
                }
                String cdnErrorJsonData = this.bNv.toString();
                if (getmCdnLogData() != null && this.wM > 0 && System.currentTimeMillis() - this.wM > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bNk = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bNs >= 5) {
                        if (this.bNp >= 100.0f && this.bNr >= getmCdnLogData().getErrNumber() && this.bNq >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bNp >= 100.0f && this.bNr >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bNp >= 100.0f && this.bNq >= getmCdnLogData().getSlowNumber()) {
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
                this.bNp -= 25.0f;
            } else {
                this.bNp -= getmCdnLogData().getSuccRank();
            }
            if (this.bNp < 0.0f) {
                this.bNp = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.bNm) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bNu == null) {
            this.bNu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bNu);
        cDNUpLoadTask.execute(new Object[0]);
        this.bNm = true;
        d ha = r.ha();
        ha.q("act", "fallback");
        ha.q("type", IntentConfig.START);
        a.hh().b("img", ha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bNs = 0;
        this.bNq = 0;
        this.bNr = 0;
        this.bNt = 0;
        this.bNp = 0.0f;
        this.bNv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final v Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Yc;
        private final int bNq;
        private final int bNr;
        private final int bNs;
        private final String bNz;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bNr = i3;
            this.bNq = i4;
            this.Yc = str;
            this.bNz = str2;
            this.mType = i;
            this.bNs = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Tv.o("number", String.valueOf(this.bNs));
            if (this.mType == 1) {
                this.Tv.o("ab_num_error", String.valueOf(this.bNr));
                this.Tv.o("error", this.Yc);
                this.Tv.o("ab_num_slow", String.valueOf(this.bNq));
                this.Tv.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bNz);
            } else if (this.mType == 3) {
                this.Tv.o("ab_num_slow", new StringBuilder(String.valueOf(this.bNq)).toString());
                this.Tv.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bNz);
            } else if (this.mType == 2) {
                this.Tv.o("ab_num_error", new StringBuilder(String.valueOf(this.bNr)).toString());
                this.Tv.o("error", this.Yc);
            }
            String tI = this.Tv.tI();
            if (!this.Tv.um() || TextUtils.isEmpty(tI)) {
                return null;
            }
            try {
                return new JSONObject(tI);
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
                    d ha = r.ha();
                    ha.q("act", "fallback");
                    ha.q("result", "1");
                    ha.q("type", "end");
                    a.hh().b("img", ha);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.bNk + 1;
                cDNProblemUploader.bNk = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ahj.setmSwitch(false);
                    CDNProblemUploader.this.wM = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d ha2 = r.ha();
                    ha2.q("act", "fallback");
                    ha2.q("result", "2");
                    ha2.q("type", "end");
                    a.hh().b("img", ha2);
                } else {
                    d ha3 = r.ha();
                    ha3.q("act", "fallback");
                    ha3.q("result", "0");
                    ha3.q("type", "end");
                    a.hh().b("img", ha3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ahj.setmSwitch(false);
                    CDNProblemUploader.this.wM = System.currentTimeMillis();
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
                CDNProblemUploader.this.bNm = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bNA;

        private CdnErrorJsonData() {
            this.bNA = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bNA.length() != 0) {
                this.bNA.append(",");
            }
            this.bNA.append(i);
        }

        public void clear() {
            this.bNA.setLength(0);
        }

        public String toString() {
            return this.bNA.toString();
        }
    }
}
