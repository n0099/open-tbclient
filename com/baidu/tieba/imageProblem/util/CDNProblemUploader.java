package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object bwb = new Object();
    private static volatile CDNProblemUploader bwc;
    private h aaN;
    private int bvV;
    private int bvW;
    private int bvX;
    private int bvY;
    private Handler mHandler;
    private final int bvJ = 5;
    private final int bvK = 0;
    private final int bvL = 1;
    private final int bvM = 2;
    private final int bvN = 3;
    private final byte bvO = 0;
    private final byte bvP = 1;
    private int bvQ = 0;
    private final int bvR = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long bvS = 86400000;
    private final float bvT = 100.0f;
    private float bvU = 0.0f;
    private BdAsyncTaskParallel bvZ = null;
    private final CdnErrorJsonData bwa = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bwc == null) {
            synchronized (CDNProblemUploader.class) {
                if (bwc == null) {
                    bwc = new CDNProblemUploader();
                }
            }
        }
        return bwc;
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
    public h getmCdnLogData() {
        return this.aaN;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(h hVar) {
        synchronized (bwb) {
            this.aaN = hVar;
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
        synchronized (bwb) {
            if (getmCdnLogData() == null) {
                this.bvU += 25.0f;
            } else {
                this.bvU += getmCdnLogData().getErrRank();
            }
            this.bvX++;
            this.bvW++;
            this.bwa.add(i);
            int i3 = this.bvX;
            int i4 = this.bvW;
            int i5 = this.bvV;
            int i6 = this.bvV != 0 ? this.bvY / this.bvV : 0;
            String cdnErrorJsonData = this.bwa.toString();
            if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bvQ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bvX < 5) {
                    i2 = 0;
                } else if (this.bvU < 100.0f || this.bvW < getmCdnLogData().getErrNumber() || this.bvV < getmCdnLogData().getSlowNumber()) {
                    if (this.bvU >= 100.0f && this.bvW >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bvU < 100.0f || this.bvV < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bwb) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bvU += 10.0f;
                } else {
                    this.bvU += getmCdnLogData().getSlowRank();
                }
                this.bvV++;
                this.bvY = (int) (this.bvY + j);
                this.bvX++;
                int i4 = this.bvX;
                int i5 = this.bvW;
                int i6 = this.bvV;
                if (this.bvV != 0) {
                    i = this.bvY / this.bvV;
                }
                String cdnErrorJsonData = this.bwa.toString();
                if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bvQ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bvX >= 5) {
                        if (this.bvU >= 100.0f && this.bvW >= getmCdnLogData().getErrNumber() && this.bvV >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bvU >= 100.0f && this.bvW >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bvU >= 100.0f && this.bvV >= getmCdnLogData().getSlowNumber()) {
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
                this.bvU -= 25.0f;
            } else {
                this.bvU -= getmCdnLogData().getSuccRank();
            }
            if (this.bvU < 0.0f) {
                this.bvU = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bvZ == null) {
            this.bvZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bvZ);
        cDNUpLoadTask.execute(new Object[0]);
        this.mIsUploading = true;
        q hC = t.hC();
        hC.r("act", "fallback");
        hC.r("type", a.START);
        f.hP().a("img", hC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bvX = 0;
        this.bvV = 0;
        this.bvW = 0;
        this.bvY = 0;
        this.bvU = 0.0f;
        this.bwa.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Sm;
        private final int bvV;
        private final int bvW;
        private final int bvX;
        private final String bwe;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bvW = i3;
            this.bvV = i4;
            this.Sm = str;
            this.bwe = str2;
            this.mType = i;
            this.bvX = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Oi.o("number", String.valueOf(this.bvX));
            if (this.mType == 1) {
                this.Oi.o("ab_num_error", String.valueOf(this.bvW));
                this.Oi.o("error", this.Sm);
                this.Oi.o("ab_num_slow", String.valueOf(this.bvV));
                this.Oi.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bwe);
            } else if (this.mType == 3) {
                this.Oi.o("ab_num_slow", new StringBuilder(String.valueOf(this.bvV)).toString());
                this.Oi.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bwe);
            } else if (this.mType == 2) {
                this.Oi.o("ab_num_error", new StringBuilder(String.valueOf(this.bvW)).toString());
                this.Oi.o("error", this.Sm);
            }
            String rO = this.Oi.rO();
            if (!this.Oi.ss() || TextUtils.isEmpty(rO)) {
                return null;
            }
            try {
                return new JSONObject(rO);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    q hC = t.hC();
                    hC.r("act", "fallback");
                    hC.r("result", "1");
                    hC.r("type", "end");
                    f.hP().a("img", hC);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.bvQ + 1;
                cDNProblemUploader.bvQ = i;
                if (i >= 5) {
                    CDNProblemUploader.this.aaN.setmSwitch(false);
                    CDNProblemUploader.this.mLastUploadTime = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    q hC2 = t.hC();
                    hC2.r("act", "fallback");
                    hC2.r("result", "2");
                    hC2.r("type", "end");
                    f.hP().a("img", hC2);
                } else {
                    q hC3 = t.hC();
                    hC3.r("act", "fallback");
                    hC3.r("result", GameInfoData.NOT_FROM_DETAIL);
                    hC3.r("type", "end");
                    f.hP().a("img", hC3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.aaN.setmSwitch(false);
                    CDNProblemUploader.this.mLastUploadTime = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                h hVar = new h();
                hVar.parseJson(optString);
                if (hVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && hVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && hVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && hVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(hVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.mIsUploading = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer bwf;

        private CdnErrorJsonData() {
            this.bwf = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bwf.length() != 0) {
                this.bwf.append(",");
            }
            this.bwf.append(i);
        }

        public void clear() {
            this.bwf.setLength(0);
        }

        public String toString() {
            return this.bwf.toString();
        }
    }
}
