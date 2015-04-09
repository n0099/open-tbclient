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
    private static Object bwr = new Object();
    private static volatile CDNProblemUploader bws;
    private h aaP;
    private int bwl;
    private int bwm;
    private int bwn;
    private int bwo;
    private Handler mHandler;
    private final int bvZ = 5;
    private final int bwa = 0;
    private final int bwb = 1;
    private final int bwc = 2;
    private final int bwd = 3;
    private final byte bwe = 0;
    private final byte bwf = 1;
    private int bwg = 0;
    private final int bwh = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long bwi = 86400000;
    private final float bwj = 100.0f;
    private float bwk = 0.0f;
    private BdAsyncTaskParallel bwp = null;
    private final CdnErrorJsonData bwq = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bws == null) {
            synchronized (CDNProblemUploader.class) {
                if (bws == null) {
                    bws = new CDNProblemUploader();
                }
            }
        }
        return bws;
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
        return this.aaP;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(h hVar) {
        synchronized (bwr) {
            this.aaP = hVar;
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
        synchronized (bwr) {
            if (getmCdnLogData() == null) {
                this.bwk += 25.0f;
            } else {
                this.bwk += getmCdnLogData().getErrRank();
            }
            this.bwn++;
            this.bwm++;
            this.bwq.add(i);
            int i3 = this.bwn;
            int i4 = this.bwm;
            int i5 = this.bwl;
            int i6 = this.bwl != 0 ? this.bwo / this.bwl : 0;
            String cdnErrorJsonData = this.bwq.toString();
            if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.bwg = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.bwn < 5) {
                    i2 = 0;
                } else if (this.bwk < 100.0f || this.bwm < getmCdnLogData().getErrNumber() || this.bwl < getmCdnLogData().getSlowNumber()) {
                    if (this.bwk >= 100.0f && this.bwm >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.bwk < 100.0f || this.bwl < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bwr) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.bwk += 10.0f;
                } else {
                    this.bwk += getmCdnLogData().getSlowRank();
                }
                this.bwl++;
                this.bwo = (int) (this.bwo + j);
                this.bwn++;
                int i4 = this.bwn;
                int i5 = this.bwm;
                int i6 = this.bwl;
                if (this.bwl != 0) {
                    i = this.bwo / this.bwl;
                }
                String cdnErrorJsonData = this.bwq.toString();
                if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.bwg = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.bwn >= 5) {
                        if (this.bwk >= 100.0f && this.bwm >= getmCdnLogData().getErrNumber() && this.bwl >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.bwk >= 100.0f && this.bwm >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.bwk >= 100.0f && this.bwl >= getmCdnLogData().getSlowNumber()) {
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
                this.bwk -= 25.0f;
            } else {
                this.bwk -= getmCdnLogData().getSuccRank();
            }
            if (this.bwk < 0.0f) {
                this.bwk = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.bwp == null) {
            this.bwp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.bwp);
        cDNUpLoadTask.execute(new Object[0]);
        this.mIsUploading = true;
        q hC = t.hC();
        hC.r("act", "fallback");
        hC.r("type", a.START);
        f.hP().a("img", hC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.bwn = 0;
        this.bwl = 0;
        this.bwm = 0;
        this.bwo = 0;
        this.bwk = 0.0f;
        this.bwq.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String So;
        private final int bwl;
        private final int bwm;
        private final int bwn;
        private final String bwu;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.bwm = i3;
            this.bwl = i4;
            this.So = str;
            this.bwu = str2;
            this.mType = i;
            this.bwn = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ok.o("number", String.valueOf(this.bwn));
            if (this.mType == 1) {
                this.Ok.o("ab_num_error", String.valueOf(this.bwm));
                this.Ok.o("error", this.So);
                this.Ok.o("ab_num_slow", String.valueOf(this.bwl));
                this.Ok.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bwu);
            } else if (this.mType == 3) {
                this.Ok.o("ab_num_slow", new StringBuilder(String.valueOf(this.bwl)).toString());
                this.Ok.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bwu);
            } else if (this.mType == 2) {
                this.Ok.o("ab_num_error", new StringBuilder(String.valueOf(this.bwm)).toString());
                this.Ok.o("error", this.So);
            }
            String rO = this.Ok.rO();
            if (!this.Ok.ss() || TextUtils.isEmpty(rO)) {
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
                int i = cDNProblemUploader.bwg + 1;
                cDNProblemUploader.bwg = i;
                if (i >= 5) {
                    CDNProblemUploader.this.aaP.setmSwitch(false);
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
                    CDNProblemUploader.this.aaP.setmSwitch(false);
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
        StringBuffer bwv;

        private CdnErrorJsonData() {
            this.bwv = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bwv.length() != 0) {
                this.bwv.append(",");
            }
            this.bwv.append(i);
        }

        public void clear() {
            this.bwv.setLength(0);
        }

        public String toString() {
            return this.bwv.toString();
        }
    }
}
