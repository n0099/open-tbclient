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
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends q {
    private static Object dnk = new Object();
    private static volatile CDNProblemUploader dnl;
    private m ajt;
    private int dnf;
    private int dng;
    private int dnh;
    private int mErrorNum;
    private Handler mHandler;
    private final int dmS = 5;
    private final int dmT = 0;
    private final int dmU = 1;
    private final int dmV = 2;
    private final int dmW = 3;
    private final byte dmX = 0;
    private final byte dmY = 1;
    private int dmZ = 0;
    private final int dna = 5;
    private boolean dnb = false;
    private long qm = 0;
    private final long dnc = 86400000;
    private final float dnd = 100.0f;
    private float dne = 0.0f;
    private BdAsyncTaskParallel dni = null;
    private final CdnErrorJsonData dnj = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m16getInstance() {
        if (dnl == null) {
            synchronized (CDNProblemUploader.class) {
                if (dnl == null) {
                    dnl = new CDNProblemUploader();
                }
            }
        }
        return dnl;
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

    @Override // com.baidu.tbadk.core.util.q
    public m getmCdnLogData() {
        return this.ajt;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(m mVar) {
        synchronized (dnk) {
            this.ajt = mVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (dnk) {
            if (getmCdnLogData() == null) {
                this.dne += 25.0f;
            } else {
                this.dne += getmCdnLogData().getErrRank();
            }
            this.dng++;
            this.mErrorNum++;
            this.dnj.add(i);
            int i3 = this.dng;
            int i4 = this.mErrorNum;
            int i5 = this.dnf;
            int i6 = this.dnf != 0 ? this.dnh / this.dnf : 0;
            String cdnErrorJsonData = this.dnj.toString();
            if (getmCdnLogData() != null && this.qm > 0 && System.currentTimeMillis() - this.qm > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dmZ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dng < 5) {
                    i2 = 0;
                } else if (this.dne < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dnf < getmCdnLogData().getSlowNumber()) {
                    if (this.dne >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dne < 100.0f || this.dnf < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dnk) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dne += 10.0f;
                } else {
                    this.dne += getmCdnLogData().getSlowRank();
                }
                this.dnf++;
                this.dnh = (int) (this.dnh + j);
                this.dng++;
                int i4 = this.dng;
                int i5 = this.mErrorNum;
                int i6 = this.dnf;
                if (this.dnf != 0) {
                    i = this.dnh / this.dnf;
                }
                String cdnErrorJsonData = this.dnj.toString();
                if (getmCdnLogData() != null && this.qm > 0 && System.currentTimeMillis() - this.qm > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dmZ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dng >= 5) {
                        if (this.dne >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dnf >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dne >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dne >= 100.0f && this.dnf >= getmCdnLogData().getSlowNumber()) {
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
                this.dne -= 25.0f;
            } else {
                this.dne -= getmCdnLogData().getSuccRank();
            }
            if (this.dne < 0.0f) {
                this.dne = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dnb) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.dni == null) {
            this.dni = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.dni);
        cDNUpLoadTask.execute(new Object[0]);
        this.dnb = true;
        d ez = t.ez();
        ez.q("act", "fallback");
        ez.q("type", IntentConfig.START);
        a.eG().b("img", ez);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dng = 0;
        this.dnf = 0;
        this.mErrorNum = 0;
        this.dnh = 0;
        this.dne = 0.0f;
        this.dnj.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String Xu;
        private final int dnf;
        private final int dng;
        private final String dnn;
        private final int mErrorNum;
        private final y mNetWork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dnf = i4;
            this.Xu = str;
            this.dnn = str2;
            this.mType = i;
            this.dng = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dng));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.Xu);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dnf));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dnn);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dnf)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dnn);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.Xu);
            }
            String ud = this.mNetWork.ud();
            if (!this.mNetWork.uF() || TextUtils.isEmpty(ud)) {
                return null;
            }
            try {
                return new JSONObject(ud);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d ez = t.ez();
                    ez.q("act", "fallback");
                    ez.q("result", "1");
                    ez.q("type", "end");
                    a.eG().b("img", ez);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dmZ + 1;
                cDNProblemUploader.dmZ = i;
                if (i >= 5) {
                    CDNProblemUploader.this.ajt.setmSwitch(false);
                    CDNProblemUploader.this.qm = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d ez2 = t.ez();
                    ez2.q("act", "fallback");
                    ez2.q("result", "2");
                    ez2.q("type", "end");
                    a.eG().b("img", ez2);
                } else {
                    d ez3 = t.ez();
                    ez3.q("act", "fallback");
                    ez3.q("result", "0");
                    ez3.q("type", "end");
                    a.eG().b("img", ez3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.ajt.setmSwitch(false);
                    CDNProblemUploader.this.qm = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                m mVar = new m();
                mVar.parseJson(optString);
                if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(mVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.dnb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer dno;

        private CdnErrorJsonData() {
            this.dno = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.dno.length() != 0) {
                this.dno.append(",");
            }
            this.dno.append(i);
        }

        public void clear() {
            this.dno.setLength(0);
        }

        public String toString() {
            return this.dno.toString();
        }
    }
}
