package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
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
    private static Object dod = new Object();
    private static volatile CDNProblemUploader doe;
    private l apf;
    private int dnX;
    private int dnY;
    private int dnZ;
    private int mErrorNum;
    private Handler mHandler;
    private final int dnK = 5;
    private final int dnL = 0;
    private final int dnM = 1;
    private final int dnN = 2;
    private final int dnO = 3;
    private final byte dnP = 0;
    private final byte dnQ = 1;
    private int dnR = 0;
    private final int dnS = 5;
    private boolean dnT = false;
    private long xj = 0;
    private final long dnU = 86400000;
    private final float dnV = 100.0f;
    private float dnW = 0.0f;
    private BdAsyncTaskParallel doa = null;
    private final CdnErrorJsonData dob = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m22getInstance() {
        if (doe == null) {
            synchronized (CDNProblemUploader.class) {
                if (doe == null) {
                    doe = new CDNProblemUploader();
                }
            }
        }
        return doe;
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
        return this.apf;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(l lVar) {
        synchronized (dod) {
            this.apf = lVar;
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
        synchronized (dod) {
            if (getmCdnLogData() == null) {
                this.dnW += 25.0f;
            } else {
                this.dnW += getmCdnLogData().getErrRank();
            }
            this.dnY++;
            this.mErrorNum++;
            this.dob.add(i);
            int i3 = this.dnY;
            int i4 = this.mErrorNum;
            int i5 = this.dnX;
            int i6 = this.dnX != 0 ? this.dnZ / this.dnX : 0;
            String cdnErrorJsonData = this.dob.toString();
            if (getmCdnLogData() != null && this.xj > 0 && System.currentTimeMillis() - this.xj > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.dnR = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.dnY < 5) {
                    i2 = 0;
                } else if (this.dnW < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.dnX < getmCdnLogData().getSlowNumber()) {
                    if (this.dnW >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.dnW < 100.0f || this.dnX < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (dod) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.dnW += 10.0f;
                } else {
                    this.dnW += getmCdnLogData().getSlowRank();
                }
                this.dnX++;
                this.dnZ = (int) (this.dnZ + j);
                this.dnY++;
                int i4 = this.dnY;
                int i5 = this.mErrorNum;
                int i6 = this.dnX;
                if (this.dnX != 0) {
                    i = this.dnZ / this.dnX;
                }
                String cdnErrorJsonData = this.dob.toString();
                if (getmCdnLogData() != null && this.xj > 0 && System.currentTimeMillis() - this.xj > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.dnR = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.dnY >= 5) {
                        if (this.dnW >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.dnX >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.dnW >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.dnW >= 100.0f && this.dnX >= getmCdnLogData().getSlowNumber()) {
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
                this.dnW -= 25.0f;
            } else {
                this.dnW -= getmCdnLogData().getSuccRank();
            }
            if (this.dnW < 0.0f) {
                this.dnW = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.dnT) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.doa == null) {
            this.doa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.doa);
        cDNUpLoadTask.execute(new Object[0]);
        this.dnT = true;
        c fM = u.fM();
        fM.p("act", "fallback");
        fM.p("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", fM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dnY = 0;
        this.dnX = 0;
        this.mErrorNum = 0;
        this.dnZ = 0;
        this.dnW = 0.0f;
        this.dob.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String acX;
        private final int dnX;
        private final int dnY;
        private final String dog;
        private final int mErrorNum;
        private final z mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.dnX = i4;
            this.acX = str;
            this.dog = str2;
            this.mType = i;
            this.dnY = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.n("number", String.valueOf(this.dnY));
            if (this.mType == 1) {
                this.mNetWork.n("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.n("error", this.acX);
                this.mNetWork.n("ab_num_slow", String.valueOf(this.dnX));
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dog);
            } else if (this.mType == 3) {
                this.mNetWork.n("ab_num_slow", new StringBuilder(String.valueOf(this.dnX)).toString());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dog);
            } else if (this.mType == 2) {
                this.mNetWork.n("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.mNetWork.n("error", this.acX);
            }
            String uY = this.mNetWork.uY();
            if (!this.mNetWork.vz() || TextUtils.isEmpty(uY)) {
                return null;
            }
            try {
                return new JSONObject(uY);
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
                    c fM = u.fM();
                    fM.p("act", "fallback");
                    fM.p("result", "1");
                    fM.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.dnR + 1;
                cDNProblemUploader.dnR = i;
                if (i >= 5) {
                    CDNProblemUploader.this.apf.setmSwitch(false);
                    CDNProblemUploader.this.xj = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    c fM2 = u.fM();
                    fM2.p("act", "fallback");
                    fM2.p("result", "2");
                    fM2.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM2);
                } else {
                    c fM3 = u.fM();
                    fM3.p("act", "fallback");
                    fM3.p("result", "0");
                    fM3.p("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fM3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.apf.setmSwitch(false);
                    CDNProblemUploader.this.xj = System.currentTimeMillis();
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
                CDNProblemUploader.this.dnT = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer doh;

        private CdnErrorJsonData() {
            this.doh = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.doh.length() != 0) {
                this.doh.append(",");
            }
            this.doh.append(i);
        }

        public void clear() {
            this.doh.setLength(0);
        }

        public String toString() {
            return this.doh.toString();
        }
    }
}
