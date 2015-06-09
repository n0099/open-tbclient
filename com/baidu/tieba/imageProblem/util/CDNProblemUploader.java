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
import com.baidu.tbadk.core.frameworkData.c;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object bza = new Object();
    private static volatile CDNProblemUploader bzb;
    private h abT;
    private int byU;
    private int byV;
    private int byW;
    private int byX;
    private Handler mHandler;
    private final int byI = 5;
    private final int byJ = 0;
    private final int byK = 1;
    private final int byL = 2;
    private final int byM = 3;
    private final byte byN = 0;
    private final byte byO = 1;
    private int byP = 0;
    private final int byQ = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long byR = 86400000;
    private final float byS = 100.0f;
    private float byT = 0.0f;
    private BdAsyncTaskParallel byY = null;
    private final CdnErrorJsonData byZ = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (bzb == null) {
            synchronized (CDNProblemUploader.class) {
                if (bzb == null) {
                    bzb = new CDNProblemUploader();
                }
            }
        }
        return bzb;
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
        return this.abT;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(h hVar) {
        synchronized (bza) {
            this.abT = hVar;
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
        synchronized (bza) {
            if (getmCdnLogData() == null) {
                this.byT += 25.0f;
            } else {
                this.byT += getmCdnLogData().getErrRank();
            }
            this.byW++;
            this.byV++;
            this.byZ.add(i);
            int i3 = this.byW;
            int i4 = this.byV;
            int i5 = this.byU;
            int i6 = this.byU != 0 ? this.byX / this.byU : 0;
            String cdnErrorJsonData = this.byZ.toString();
            if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.byP = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.byW < 5) {
                    i2 = 0;
                } else if (this.byT < 100.0f || this.byV < getmCdnLogData().getErrNumber() || this.byU < getmCdnLogData().getSlowNumber()) {
                    if (this.byT >= 100.0f && this.byV >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.byT < 100.0f || this.byU < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (bza) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.byT += 10.0f;
                } else {
                    this.byT += getmCdnLogData().getSlowRank();
                }
                this.byU++;
                this.byX = (int) (this.byX + j);
                this.byW++;
                int i4 = this.byW;
                int i5 = this.byV;
                int i6 = this.byU;
                if (this.byU != 0) {
                    i = this.byX / this.byU;
                }
                String cdnErrorJsonData = this.byZ.toString();
                if (getmCdnLogData() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.byP = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.byW >= 5) {
                        if (this.byT >= 100.0f && this.byV >= getmCdnLogData().getErrNumber() && this.byU >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.byT >= 100.0f && this.byV >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.byT >= 100.0f && this.byU >= getmCdnLogData().getSlowNumber()) {
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
                this.byT -= 25.0f;
            } else {
                this.byT -= getmCdnLogData().getSuccRank();
            }
            if (this.byT < 0.0f) {
                this.byT = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.byY == null) {
            this.byY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.byY);
        cDNUpLoadTask.execute(new Object[0]);
        this.mIsUploading = true;
        q hm = t.hm();
        hm.r("act", "fallback");
        hm.r("type", c.START);
        f.hz().a("img", hm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.byW = 0;
        this.byU = 0;
        this.byV = 0;
        this.byX = 0;
        this.byT = 0.0f;
        this.byZ.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final aa OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String SY;
        private final int byU;
        private final int byV;
        private final int byW;
        private final String bzd;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.byV = i3;
            this.byU = i4;
            this.SY = str;
            this.bzd = str2;
            this.mType = i;
            this.byW = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.OE.o("number", String.valueOf(this.byW));
            if (this.mType == 1) {
                this.OE.o("ab_num_error", String.valueOf(this.byV));
                this.OE.o("error", this.SY);
                this.OE.o("ab_num_slow", String.valueOf(this.byU));
                this.OE.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bzd);
            } else if (this.mType == 3) {
                this.OE.o("ab_num_slow", new StringBuilder(String.valueOf(this.byU)).toString());
                this.OE.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.bzd);
            } else if (this.mType == 2) {
                this.OE.o("ab_num_error", new StringBuilder(String.valueOf(this.byV)).toString());
                this.OE.o("error", this.SY);
            }
            String sw = this.OE.sw();
            if (!this.OE.ta() || TextUtils.isEmpty(sw)) {
                return null;
            }
            try {
                return new JSONObject(sw);
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
                    q hm = t.hm();
                    hm.r("act", "fallback");
                    hm.r("result", "1");
                    hm.r("type", "end");
                    f.hz().a("img", hm);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.byP + 1;
                cDNProblemUploader.byP = i;
                if (i >= 5) {
                    CDNProblemUploader.this.abT.setmSwitch(false);
                    CDNProblemUploader.this.mLastUploadTime = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    q hm2 = t.hm();
                    hm2.r("act", "fallback");
                    hm2.r("result", "2");
                    hm2.r("type", "end");
                    f.hz().a("img", hm2);
                } else {
                    q hm3 = t.hm();
                    hm3.r("act", "fallback");
                    hm3.r("result", GameInfoData.NOT_FROM_DETAIL);
                    hm3.r("type", "end");
                    f.hz().a("img", hm3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.abT.setmSwitch(false);
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
        StringBuffer bze;

        private CdnErrorJsonData() {
            this.bze = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.bze.length() != 0) {
                this.bze.append(",");
            }
            this.bze.append(i);
        }

        public void clear() {
            this.bze.setLength(0);
        }

        public String toString() {
            return this.bze.toString();
        }
    }
}
