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
    private static Object hUf = new Object();
    private static volatile CDNProblemUploader hUg;
    private n dmo;
    private int hTZ;
    private int hUa;
    private int hUb;
    private int hUc;
    private Handler mHandler;
    private final int hTM = 5;
    private final int hTN = 0;
    private final int hTO = 1;
    private final int hTP = 2;
    private final int hTQ = 3;
    private final byte hTR = 0;
    private final byte hTS = 1;
    private int hTT = 0;
    private final int hTU = 5;
    private boolean hTV = false;
    private long tl = 0;
    private final long hTW = 86400000;
    private final float hTX = 100.0f;
    private float hTY = 0.0f;
    private BdAsyncTaskParallel hUd = null;
    private final CdnErrorJsonData hUe = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hTT + 1;
        cDNProblemUploader.hTT = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hUg == null) {
            synchronized (CDNProblemUploader.class) {
                if (hUg == null) {
                    hUg = new CDNProblemUploader();
                }
            }
        }
        return hUg;
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
        return this.dmo;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hUf) {
            this.dmo = nVar;
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
        synchronized (hUf) {
            if (getmCdnLogData() == null) {
                this.hTY += 25.0f;
            } else {
                this.hTY += getmCdnLogData().getErrRank();
            }
            this.hUb++;
            this.hUa++;
            this.hUe.add(i);
            int i3 = this.hUb;
            int i4 = this.hUa;
            int i5 = this.hTZ;
            int i6 = this.hTZ != 0 ? this.hUc / this.hTZ : 0;
            String cdnErrorJsonData = this.hUe.toString();
            if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hTT = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hUb < 5) {
                    i2 = 0;
                } else if (this.hTY < 100.0f || this.hUa < getmCdnLogData().getErrNumber() || this.hTZ < getmCdnLogData().getSlowNumber()) {
                    if (this.hTY >= 100.0f && this.hUa >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hTY < 100.0f || this.hTZ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hUf) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hTY += 10.0f;
                } else {
                    this.hTY += getmCdnLogData().getSlowRank();
                }
                this.hTZ++;
                this.hUc = (int) (this.hUc + j);
                this.hUb++;
                int i4 = this.hUb;
                int i5 = this.hUa;
                int i6 = this.hTZ;
                if (this.hTZ != 0) {
                    i = this.hUc / this.hTZ;
                }
                String cdnErrorJsonData = this.hUe.toString();
                if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hTT = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hUb >= 5) {
                        if (this.hTY >= 100.0f && this.hUa >= getmCdnLogData().getErrNumber() && this.hTZ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hTY >= 100.0f && this.hUa >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hTY >= 100.0f && this.hTZ >= getmCdnLogData().getSlowNumber()) {
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
                this.hTY -= 25.0f;
            } else {
                this.hTY -= getmCdnLogData().getSuccRank();
            }
            if (this.hTY < 0.0f) {
                this.hTY = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hTV) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hUd == null) {
            this.hUd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hUd);
        cDNUpLoadTask.execute(new Object[0]);
        this.hTV = true;
        a gs = s.gs();
        gs.append("act", "fallback");
        gs.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hUb = 0;
        this.hTZ = 0;
        this.hUa = 0;
        this.hUc = 0;
        this.hTY = 0.0f;
        this.hUe.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aBa;
        private final x cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hTZ;
        private final int hUa;
        private final int hUb;
        private final String hUi;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hUa = i3;
            this.hTZ = i4;
            this.aBa = str;
            this.hUi = str2;
            this.mType = i;
            this.hUb = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cLE.addPostData("number", String.valueOf(this.hUb));
            if (this.mType == 1) {
                this.cLE.addPostData("ab_num_error", String.valueOf(this.hUa));
                this.cLE.addPostData(BdStatsConstant.StatsType.ERROR, this.aBa);
                this.cLE.addPostData("ab_num_slow", String.valueOf(this.hTZ));
                this.cLE.addPostData("time", this.hUi);
            } else if (this.mType == 3) {
                this.cLE.addPostData("ab_num_slow", this.hTZ + "");
                this.cLE.addPostData("time", this.hUi);
            } else if (this.mType == 2) {
                this.cLE.addPostData("ab_num_error", this.hUa + "");
                this.cLE.addPostData(BdStatsConstant.StatsType.ERROR, this.aBa);
            }
            String postNetData = this.cLE.postNetData();
            if (!this.cLE.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.dmo.setmSwitch(false);
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
                        CDNProblemUploader.this.dmo.setmSwitch(false);
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
                CDNProblemUploader.this.hTV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer hUj;

        private CdnErrorJsonData() {
            this.hUj = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hUj.length() != 0) {
                this.hUj.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hUj.append(i);
        }

        public void clear() {
            this.hUj.setLength(0);
        }

        public String toString() {
            return this.hUj.toString();
        }
    }
}
