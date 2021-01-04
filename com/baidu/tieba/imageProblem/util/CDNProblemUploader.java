package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.z;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CDNProblemUploader extends r {
    private static volatile CDNProblemUploader kUc;
    private static Object lockObject = new Object();
    private q ftn;
    private int kTW;
    private int kTX;
    private int kTY;
    private int kTZ;
    private Handler mHandler;
    private final int kTJ = 5;
    private final int kTK = 0;
    private final int kTL = 1;
    private final int kTM = 2;
    private final int kTN = 3;
    private final byte kTO = 0;
    private final byte kTP = 1;
    private int kTQ = 0;
    private final int kTR = 5;
    private boolean kTS = false;
    private long Pk = 0;
    private final long kTT = 86400000;
    private final float kTU = 100.0f;
    private float kTV = 0.0f;
    private BdAsyncTaskParallel kUa = null;
    private final CdnErrorJsonData kUb = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.kTQ + 1;
        cDNProblemUploader.kTQ = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (kUc == null) {
            synchronized (CDNProblemUploader.class) {
                if (kUc == null) {
                    kUc = new CDNProblemUploader();
                }
            }
        }
        return kUc;
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
    public q getmCdnLogData() {
        return this.ftn;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setmCdnLogData(q qVar) {
        synchronized (lockObject) {
            this.ftn = qVar;
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
        synchronized (lockObject) {
            if (getmCdnLogData() == null) {
                this.kTV += 25.0f;
            } else {
                this.kTV += getmCdnLogData().getErrRank();
            }
            this.kTY++;
            this.kTX++;
            this.kUb.add(i);
            int i3 = this.kTY;
            int i4 = this.kTX;
            int i5 = this.kTW;
            int i6 = this.kTW != 0 ? this.kTZ / this.kTW : 0;
            String cdnErrorJsonData = this.kUb.toString();
            if (getmCdnLogData() != null && this.Pk > 0 && System.currentTimeMillis() - this.Pk > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.kTQ = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.kTY < 5) {
                    i2 = 0;
                } else if (this.kTV < 100.0f || this.kTX < getmCdnLogData().getErrNumber() || this.kTW < getmCdnLogData().getSlowNumber()) {
                    if (this.kTV >= 100.0f && this.kTX >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.kTV < 100.0f || this.kTW < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (lockObject) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.kTV += 10.0f;
                } else {
                    this.kTV += getmCdnLogData().getSlowRank();
                }
                this.kTW++;
                this.kTZ = (int) (this.kTZ + j);
                this.kTY++;
                int i4 = this.kTY;
                int i5 = this.kTX;
                int i6 = this.kTW;
                if (this.kTW != 0) {
                    i = this.kTZ / this.kTW;
                }
                String cdnErrorJsonData = this.kUb.toString();
                if (getmCdnLogData() != null && this.Pk > 0 && System.currentTimeMillis() - this.Pk > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.kTQ = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.kTY >= 5) {
                        if (this.kTV >= 100.0f && this.kTX >= getmCdnLogData().getErrNumber() && this.kTW >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.kTV >= 100.0f && this.kTX >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.kTV >= 100.0f && this.kTW >= getmCdnLogData().getSlowNumber()) {
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
                this.kTV -= 25.0f;
            } else {
                this.kTV -= getmCdnLogData().getSuccRank();
            }
            if (this.kTV < 0.0f) {
                this.kTV = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.kTS) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.kUa == null) {
            this.kUa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.kUa);
        cDNUpLoadTask.execute(new Object[0]);
        this.kTS = true;
        a pi = t.pi();
        pi.append("act", "fallback");
        pi.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kTY = 0;
        this.kTW = 0;
        this.kTX = 0;
        this.kTZ = 0;
        this.kTV = 0.0f;
        this.kUb.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String bKP;
        private final z cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int kTW;
        private final int kTX;
        private final int kTY;
        private final String kUe;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.kTX = i3;
            this.kTW = i4;
            this.bKP = str;
            this.kUe = str2;
            this.mType = i;
            this.kTY = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cmJ.addPostData("number", String.valueOf(this.kTY));
            if (this.mType == 1) {
                this.cmJ.addPostData("ab_num_error", String.valueOf(this.kTX));
                this.cmJ.addPostData(BdStatsConstant.StatsType.ERROR, this.bKP);
                this.cmJ.addPostData("ab_num_slow", String.valueOf(this.kTW));
                this.cmJ.addPostData("time", this.kUe);
            } else if (this.mType == 3) {
                this.cmJ.addPostData("ab_num_slow", this.kTW + "");
                this.cmJ.addPostData("time", this.kUe);
            } else if (this.mType == 2) {
                this.cmJ.addPostData("ab_num_error", this.kTX + "");
                this.cmJ.addPostData(BdStatsConstant.StatsType.ERROR, this.bKP);
            }
            String postNetData = this.cmJ.postNetData();
            if (!this.cmJ.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eu */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a pi = t.pi();
                    pi.append("act", "fallback");
                    pi.append("result", "1");
                    pi.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", pi);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.ftn.setmSwitch(false);
                    CDNProblemUploader.this.Pk = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                        a pi2 = t.pi();
                        pi2.append("act", "fallback");
                        pi2.append("result", "2");
                        pi2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pi2);
                    } else {
                        a pi3 = t.pi();
                        pi3.append("act", "fallback");
                        pi3.append("result", "0");
                        pi3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", pi3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.ftn.setmSwitch(false);
                        CDNProblemUploader.this.Pk = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    q qVar = new q();
                    qVar.parseJson(optString);
                    if (qVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && qVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && qVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && qVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(qVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.kTS = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class CdnErrorJsonData {
        StringBuffer kUf;

        private CdnErrorJsonData() {
            this.kUf = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.kUf.length() != 0) {
                this.kUf.append(",");
            }
            this.kUf.append(i);
        }

        public void clear() {
            this.kUf.setLength(0);
        }

        public String toString() {
            return this.kUf.toString();
        }
    }
}
