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
    private static Object hUr = new Object();
    private static volatile CDNProblemUploader hUs;
    private n dmB;
    private int hUl;
    private int hUm;
    private int hUn;
    private int hUo;
    private Handler mHandler;
    private final int hTY = 5;
    private final int hTZ = 0;
    private final int hUa = 1;
    private final int hUb = 2;
    private final int hUc = 3;
    private final byte hUd = 0;
    private final byte hUe = 1;
    private int hUf = 0;
    private final int hUg = 5;
    private boolean hUh = false;
    private long tl = 0;
    private final long hUi = 86400000;
    private final float hUj = 100.0f;
    private float hUk = 0.0f;
    private BdAsyncTaskParallel hUp = null;
    private final CdnErrorJsonData hUq = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hUf + 1;
        cDNProblemUploader.hUf = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hUs == null) {
            synchronized (CDNProblemUploader.class) {
                if (hUs == null) {
                    hUs = new CDNProblemUploader();
                }
            }
        }
        return hUs;
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
        return this.dmB;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(n nVar) {
        synchronized (hUr) {
            this.dmB = nVar;
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
        synchronized (hUr) {
            if (getmCdnLogData() == null) {
                this.hUk += 25.0f;
            } else {
                this.hUk += getmCdnLogData().getErrRank();
            }
            this.hUn++;
            this.hUm++;
            this.hUq.add(i);
            int i3 = this.hUn;
            int i4 = this.hUm;
            int i5 = this.hUl;
            int i6 = this.hUl != 0 ? this.hUo / this.hUl : 0;
            String cdnErrorJsonData = this.hUq.toString();
            if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hUf = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.hUn < 5) {
                    i2 = 0;
                } else if (this.hUk < 100.0f || this.hUm < getmCdnLogData().getErrNumber() || this.hUl < getmCdnLogData().getSlowNumber()) {
                    if (this.hUk >= 100.0f && this.hUm >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.hUk < 100.0f || this.hUl < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hUr) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.hUk += 10.0f;
                } else {
                    this.hUk += getmCdnLogData().getSlowRank();
                }
                this.hUl++;
                this.hUo = (int) (this.hUo + j);
                this.hUn++;
                int i4 = this.hUn;
                int i5 = this.hUm;
                int i6 = this.hUl;
                if (this.hUl != 0) {
                    i = this.hUo / this.hUl;
                }
                String cdnErrorJsonData = this.hUq.toString();
                if (getmCdnLogData() != null && this.tl > 0 && System.currentTimeMillis() - this.tl > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hUf = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.hUn >= 5) {
                        if (this.hUk >= 100.0f && this.hUm >= getmCdnLogData().getErrNumber() && this.hUl >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.hUk >= 100.0f && this.hUm >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.hUk >= 100.0f && this.hUl >= getmCdnLogData().getSlowNumber()) {
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
                this.hUk -= 25.0f;
            } else {
                this.hUk -= getmCdnLogData().getSuccRank();
            }
            if (this.hUk < 0.0f) {
                this.hUk = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hUh) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.hUp == null) {
            this.hUp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.hUp);
        cDNUpLoadTask.execute(new Object[0]);
        this.hUh = true;
        a gs = s.gs();
        gs.append("act", "fallback");
        gs.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hUn = 0;
        this.hUl = 0;
        this.hUm = 0;
        this.hUo = 0;
        this.hUk = 0.0f;
        this.hUq.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aBb;
        private final x cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hUl;
        private final int hUm;
        private final int hUn;
        private final String hUu;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hUm = i3;
            this.hUl = i4;
            this.aBb = str;
            this.hUu = str2;
            this.mType = i;
            this.hUn = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.cLF.addPostData("number", String.valueOf(this.hUn));
            if (this.mType == 1) {
                this.cLF.addPostData("ab_num_error", String.valueOf(this.hUm));
                this.cLF.addPostData(BdStatsConstant.StatsType.ERROR, this.aBb);
                this.cLF.addPostData("ab_num_slow", String.valueOf(this.hUl));
                this.cLF.addPostData("time", this.hUu);
            } else if (this.mType == 3) {
                this.cLF.addPostData("ab_num_slow", this.hUl + "");
                this.cLF.addPostData("time", this.hUu);
            } else if (this.mType == 2) {
                this.cLF.addPostData("ab_num_error", this.hUm + "");
                this.cLF.addPostData(BdStatsConstant.StatsType.ERROR, this.aBb);
            }
            String postNetData = this.cLF.postNetData();
            if (!this.cLF.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.dmB.setmSwitch(false);
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
                        CDNProblemUploader.this.dmB.setmSwitch(false);
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
                CDNProblemUploader.this.hUh = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class CdnErrorJsonData {
        StringBuffer hUv;

        private CdnErrorJsonData() {
            this.hUv = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hUv.length() != 0) {
                this.hUv.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hUv.append(i);
        }

        public void clear() {
            this.hUv.setLength(0);
        }

        public String toString() {
            return this.hUv.toString();
        }
    }
}
