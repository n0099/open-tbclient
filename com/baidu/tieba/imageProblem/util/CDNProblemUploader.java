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
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends p {
    private static Object hau = new Object();
    private static volatile CDNProblemUploader hav;
    private m cuk;
    private int hao;
    private int hap;
    private int haq;
    private int har;
    private Handler mHandler;
    private final int hab = 5;
    private final int hac = 0;
    private final int had = 1;
    private final int hae = 2;
    private final int haf = 3;
    private final byte hag = 0;
    private final byte hah = 1;
    private int hai = 0;
    private final int haj = 5;
    private boolean hak = false;
    private long qm = 0;
    private final long hal = 86400000;
    private final float ham = 100.0f;
    private float han = 0.0f;
    private BdAsyncTaskParallel has = null;
    private final CdnErrorJsonData hat = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.hai + 1;
        cDNProblemUploader.hai = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (hav == null) {
            synchronized (CDNProblemUploader.class) {
                if (hav == null) {
                    hav = new CDNProblemUploader();
                }
            }
        }
        return hav;
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
    public m getmCdnLogData() {
        return this.cuk;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(m mVar) {
        synchronized (hau) {
            this.cuk = mVar;
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
        synchronized (hau) {
            if (getmCdnLogData() == null) {
                this.han += 25.0f;
            } else {
                this.han += getmCdnLogData().getErrRank();
            }
            this.haq++;
            this.hap++;
            this.hat.add(i);
            int i3 = this.haq;
            int i4 = this.hap;
            int i5 = this.hao;
            int i6 = this.hao != 0 ? this.har / this.hao : 0;
            String cdnErrorJsonData = this.hat.toString();
            if (getmCdnLogData() != null && this.qm > 0 && System.currentTimeMillis() - this.qm > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.hai = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.haq < 5) {
                    i2 = 0;
                } else if (this.han < 100.0f || this.hap < getmCdnLogData().getErrNumber() || this.hao < getmCdnLogData().getSlowNumber()) {
                    if (this.han >= 100.0f && this.hap >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.han < 100.0f || this.hao < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (hau) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.han += 10.0f;
                } else {
                    this.han += getmCdnLogData().getSlowRank();
                }
                this.hao++;
                this.har = (int) (this.har + j);
                this.haq++;
                int i4 = this.haq;
                int i5 = this.hap;
                int i6 = this.hao;
                if (this.hao != 0) {
                    i = this.har / this.hao;
                }
                String cdnErrorJsonData = this.hat.toString();
                if (getmCdnLogData() != null && this.qm > 0 && System.currentTimeMillis() - this.qm > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.hai = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.haq >= 5) {
                        if (this.han >= 100.0f && this.hap >= getmCdnLogData().getErrNumber() && this.hao >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.han >= 100.0f && this.hap >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.han >= 100.0f && this.hao >= getmCdnLogData().getSlowNumber()) {
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
                this.han -= 25.0f;
            } else {
                this.han -= getmCdnLogData().getSuccRank();
            }
            if (this.han < 0.0f) {
                this.han = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.hak) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.has == null) {
            this.has = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.has);
        cDNUpLoadTask.execute(new Object[0]);
        this.hak = true;
        a fU = s.fU();
        fU.append("act", "fallback");
        fU.append("type", "start");
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.haq = 0;
        this.hao = 0;
        this.hap = 0;
        this.har = 0;
        this.han = 0.0f;
        this.hat.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String aoa;
        private final x bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int hao;
        private final int hap;
        private final int haq;
        private final String hax;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.hap = i3;
            this.hao = i4;
            this.aoa = str;
            this.hax = str2;
            this.mType = i;
            this.haq = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.bUY.addPostData("number", String.valueOf(this.haq));
            if (this.mType == 1) {
                this.bUY.addPostData("ab_num_error", String.valueOf(this.hap));
                this.bUY.addPostData(BdStatsConstant.StatsType.ERROR, this.aoa);
                this.bUY.addPostData("ab_num_slow", String.valueOf(this.hao));
                this.bUY.addPostData("time", this.hax);
            } else if (this.mType == 3) {
                this.bUY.addPostData("ab_num_slow", this.hao + "");
                this.bUY.addPostData("time", this.hax);
            } else if (this.mType == 2) {
                this.bUY.addPostData("ab_num_error", this.hap + "");
                this.bUY.addPostData(BdStatsConstant.StatsType.ERROR, this.aoa);
            }
            String postNetData = this.bUY.postNetData();
            if (!this.bUY.isNetSuccess() || TextUtils.isEmpty(postNetData)) {
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
        /* renamed from: cc */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a fU = s.fU();
                    fU.append("act", "fallback");
                    fU.append("result", "1");
                    fU.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", fU);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.cuk.setmSwitch(false);
                    CDNProblemUploader.this.qm = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                        a fU2 = s.fU();
                        fU2.append("act", "fallback");
                        fU2.append("result", "2");
                        fU2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fU2);
                    } else {
                        a fU3 = s.fU();
                        fU3.append("act", "fallback");
                        fU3.append("result", "0");
                        fU3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", fU3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.cuk.setmSwitch(false);
                        CDNProblemUploader.this.qm = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    m mVar = new m();
                    mVar.parseJson(optString);
                    if (mVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && mVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && mVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && mVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(mVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.hak = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer hay;

        private CdnErrorJsonData() {
            this.hay = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.hay.length() != 0) {
                this.hay.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.hay.append(i);
        }

        public void clear() {
            this.hay.setLength(0);
        }

        public String toString() {
            return this.hay.toString();
        }
    }
}
