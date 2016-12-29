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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends r {
    private static Object dgb = new Object();
    private static volatile CDNProblemUploader dgc;
    private l akg;
    private int dfW;
    private int dfX;
    private int dfY;
    private int mErrorNum;
    private Handler mHandler;
    private final int dfJ = 5;
    private final int dfK = 0;
    private final int dfL = 1;
    private final int dfM = 2;
    private final int dfN = 3;
    private final byte dfO = 0;
    private final byte dfP = 1;
    private int dfQ = 0;
    private final int dfR = 5;
    private boolean dfS = false;
    private long qt = 0;
    private final long dfT = 86400000;
    private final float dfU = 100.0f;
    private float dfV = 0.0f;
    private BdAsyncTaskParallel dfZ = null;
    private final CdnErrorJsonData dga = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m21getInstance() {
        if (dgc == null) {
            synchronized (CDNProblemUploader.class) {
                if (dgc == null) {
                    dgc = new CDNProblemUploader();
                }
            }
        }
        return dgc;
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
    public l getmCdnLogData() {
        return this.akg;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dgb) {
            this.akg = lVar;
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
        synchronized (dgb) {
            if (getmCdnLogData() == null) {
                this.dfV += 25.0f;
            } else {
                this.dfV += getmCdnLogData().getErrRank();
            }
            this.dfX++;
            this.mErrorNum++;
            this.dga.add(i);
            int i3 = this.dfX;
            int i4 = this.mErrorNum;
            int i5 = this.dfW;
            int i6 = this.dfW != 0 ? this.dfY / this.dfW : 0;
            String cdnErrorJsonData = this.dga.toString();
            if (getmCdnLogData() != null && this.qt > 0 && System.currentTimeMillis() - this.qt > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dfQ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dfX < 5) {
                    i2 = 0;
                } else if (this.dfV < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dfW < getmCdnLogData().getSlowNumber()) {
                    if (this.dfV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dfV < 100.0f || this.dfW < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dgb) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dfV += 10.0f;
                } else {
                    this.dfV += getmCdnLogData().getSlowRank();
                }
                this.dfW++;
                this.dfY = (int) (this.dfY + j);
                this.dfX++;
                int i4 = this.dfX;
                int i5 = this.mErrorNum;
                int i6 = this.dfW;
                if (this.dfW != 0) {
                    i = this.dfY / this.dfW;
                }
                String cdnErrorJsonData = this.dga.toString();
                if (getmCdnLogData() != null && this.qt > 0 && System.currentTimeMillis() - this.qt > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dfQ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dfX >= 5) {
                        if (this.dfV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dfW >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dfV >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dfV >= 100.0f && this.dfW >= getmCdnLogData().getSlowNumber()) {
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
                this.dfV -= 25.0f;
            } else {
                this.dfV -= getmCdnLogData().getSuccRank();
            }
            if (this.dfV < 0.0f) {
                this.dfV = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dfS) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dfZ == null) {
            this.dfZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dfZ);
        cDNUpLoadTask.execute(new Object[0]);
        this.dfS = true;
        d eB = u.eB();
        eB.q("act", "fallback");
        eB.q("type", IntentConfig.START);
        a.eI().b("img", eB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dfX = 0;
        this.dfW = 0;
        this.mErrorNum = 0;
        this.dfY = 0;
        this.dfV = 0.0f;
        this.dga.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final z NX = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Yg;
        private final int dfW;
        private final int dfX;
        private final String dge;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dfW = i4;
            this.Yg = str;
            this.dge = str2;
            this.mType = i;
            this.dfX = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.NX.n("number", String.valueOf(this.dfX));
            if (this.mType == 1) {
                this.NX.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.NX.n("error", this.Yg);
                this.NX.n("ab_num_slow", String.valueOf(this.dfW));
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dge);
            } else if (this.mType == 3) {
                this.NX.n("ab_num_slow", new StringBuilder(String.valueOf(this.dfW)).toString());
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dge);
            } else if (this.mType == 2) {
                this.NX.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.NX.n("error", this.Yg);
            }
            String uk = this.NX.uk();
            if (!this.NX.uL() || TextUtils.isEmpty(uk)) {
                return null;
            }
            try {
                return new JSONObject(uk);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d eB = u.eB();
                    eB.q("act", "fallback");
                    eB.q("result", "1");
                    eB.q("type", "end");
                    a.eI().b("img", eB);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dfQ + 1;
                cDNProblemUploader.dfQ = i;
                if (i >= 5) {
                    CDNProblemUploader.this.akg.setmSwitch(false);
                    CDNProblemUploader.this.qt = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d eB2 = u.eB();
                    eB2.q("act", "fallback");
                    eB2.q("result", "2");
                    eB2.q("type", "end");
                    a.eI().b("img", eB2);
                } else {
                    d eB3 = u.eB();
                    eB3.q("act", "fallback");
                    eB3.q("result", "0");
                    eB3.q("type", "end");
                    a.eI().b("img", eB3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.akg.setmSwitch(false);
                    CDNProblemUploader.this.qt = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                l lVar = new l();
                lVar.parseJson(optString);
                if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(lVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dfS = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dgf;

        private CdnErrorJsonData() {
            this.dgf = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dgf.length() != 0) {
                this.dgf.append(",");
            }
            this.dgf.append(i);
        }

        public void clear() {
            this.dgf.setLength(0);
        }

        public String toString() {
            return this.dgf.toString();
        }
    }
}
