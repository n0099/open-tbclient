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
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNProblemUploader extends p {
    private static Object hUd = new Object();
    private static volatile CDNProblemUploader hUe;
    private n dmn;
    private int hTX;
    private int hTY;
    private int hTZ;
    private int hUa;
    private Handler mHandler;
    private final int hTK = 5;
    private final int hTL = 0;
    private final int hTM = 1;
    private final int hTN = 2;
    private final int hTO = 3;
    private final byte hTP = 0;
    private final byte hTQ = 1;
    private int hTR = 0;
    private final int hTS = 5;
    private boolean hTT = false;
    private long tl = 0;
    private final long hTU = 86400000;
    private final float hTV = 100.0f;
    private float hTW = 0.0f;
    private BdAsyncTaskParallel hUb = null;
    private final CdnErrorJsonData hUc = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hTR + 1;
        cDNProblemUploader.hTR = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hUe == null) {
            synchronized (CDNProblemUploader.class) {
                if (hUe == null) {
                    hUe = new CDNProblemUploader();
                }
            }
        }
        return hUe;
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
    public n getmCdnLogData() {
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hUd) {
            this.dmn = nVar;
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
        synchronized (hUd) {
            if (getmCdnLogData() == null) {
                this.hTW += 25.0f;
            } else {
                this.hTW += getmCdnLogData().getErrRank();
            }
            this.hTZ++;
            this.hTY++;
            this.hUc.add(i);
            int i3 = this.hTZ;
            int i4 = this.hTY;
            int i5 = this.hTX;
            int i6 = this.hTX != 0 ? this.hUa / this.hTX : 0;
            String cdnErrorJsonData = this.hUc.toString();
            if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hTR = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hTZ < 5) {
                    i2 = 0;
                } else if (this.hTW < 100.0f || this.hTY < getmCdnLogData().getErrNumber() || this.hTX < getmCdnLogData().getSlowNumber()) {
                    if (this.hTW >= 100.0f && this.hTY >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hTW < 100.0f || this.hTX < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hUd) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hTW += 10.0f;
                } else {
                    this.hTW += getmCdnLogData().getSlowRank();
                }
                this.hTX++;
                this.hUa = (int) (this.hUa + j);
                this.hTZ++;
                int i4 = this.hTZ;
                int i5 = this.hTY;
                int i6 = this.hTX;
                if (this.hTX != 0) {
                    i = this.hUa / this.hTX;
                }
                String cdnErrorJsonData = this.hUc.toString();
                if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hTR = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hTZ >= 5) {
                        if (this.hTW >= 100.0f && this.hTY >= getmCdnLogData().getErrNumber() && this.hTX >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hTW >= 100.0f && this.hTY >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hTW >= 100.0f && this.hTX >= getmCdnLogData().getSlowNumber()) {
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
                this.hTW -= 25.0f;
            } else {
                this.hTW -= getmCdnLogData().getSuccRank();
            }
            if (this.hTW < 0.0f) {
                this.hTW = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hTT) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hUb == null) {
            this.hUb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hUb);
        cDNUpLoadTask.execute(new Object[0]);
        this.hTT = true;
        a gs = s.gs();
        gs.append("act", "fallback");
        gs.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hTZ = 0;
        this.hTX = 0;
        this.hTY = 0;
        this.hUa = 0;
        this.hTW = 0.0f;
        this.hUc.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aAZ;
        private final x cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hTX;
        private final int hTY;
        private final int hTZ;
        private final String hUg;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hTY = i3;
            this.hTX = i4;
            this.aAZ = str;
            this.hUg = str2;
            this.mType = i;
            this.hTZ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cLD.addPostData("number", String.valueOf(this.hTZ));
            if (this.mType == 1) {
                this.cLD.addPostData("ab_num_error", String.valueOf(this.hTY));
                this.cLD.addPostData(BdStatsConstant.StatsType.ERROR, this.aAZ);
                this.cLD.addPostData("ab_num_slow", String.valueOf(this.hTX));
                this.cLD.addPostData("time", this.hUg);
            } else if (this.mType == 3) {
                this.cLD.addPostData("ab_num_slow", this.hTX + "");
                this.cLD.addPostData("time", this.hUg);
            } else if (this.mType == 2) {
                this.cLD.addPostData("ab_num_error", this.hTY + "");
                this.cLD.addPostData(BdStatsConstant.StatsType.ERROR, this.aAZ);
            }
            String postNetData = this.cLD.postNetData();
            if (!this.cLD.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: cS */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a gs = s.gs();
                    gs.append("act", "fallback");
                    gs.append("result", "1");
                    gs.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", gs);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.dmn.setmSwitch(false);
                    CDNProblemUploader.this.tl = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a gs2 = s.gs();
                        gs2.append("act", "fallback");
                        gs2.append("result", "2");
                        gs2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gs2);
                    } else {
                        a gs3 = s.gs();
                        gs3.append("act", "fallback");
                        gs3.append("result", "0");
                        gs3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", gs3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.dmn.setmSwitch(false);
                        CDNProblemUploader.this.tl = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    n nVar = new n();
                    nVar.parseJson(optString);
                    if (nVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && nVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && nVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && nVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(nVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.hTT = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer hUh;

        private CdnErrorJsonData() {
            this.hUh = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hUh.length() != 0) {
                this.hUh.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hUh.append(i);
        }

        public void clear() {
            this.hUh.setLength(0);
        }

        public String toString() {
            return this.hUh.toString();
        }
    }
}
