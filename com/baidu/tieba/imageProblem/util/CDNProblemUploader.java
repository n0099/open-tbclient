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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNProblemUploader extends p {
    private static Object faX = new Object();
    private static volatile CDNProblemUploader faY;
    private k aJI;
    private int faS;
    private int faT;
    private int faU;
    private int mErrorNum;
    private Handler mHandler;
    private final int faF = 5;
    private final int faG = 0;
    private final int faH = 1;
    private final int faI = 2;
    private final int faJ = 3;
    private final byte faK = 0;
    private final byte faL = 1;
    private int faM = 0;
    private final int faN = 5;
    private boolean faO = false;
    private long EB = 0;
    private final long faP = 86400000;
    private final float faQ = 100.0f;
    private float faR = 0.0f;
    private BdAsyncTaskParallel faV = null;
    private final CdnErrorJsonData faW = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.faM + 1;
        cDNProblemUploader.faM = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (faY == null) {
            synchronized (CDNProblemUploader.class) {
                if (faY == null) {
                    faY = new CDNProblemUploader();
                }
            }
        }
        return faY;
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
    public k getmCdnLogData() {
        return this.aJI;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (faX) {
            this.aJI = kVar;
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
        synchronized (faX) {
            if (getmCdnLogData() == null) {
                this.faR += 25.0f;
            } else {
                this.faR += getmCdnLogData().getErrRank();
            }
            this.faT++;
            this.mErrorNum++;
            this.faW.add(i);
            int i3 = this.faT;
            int i4 = this.mErrorNum;
            int i5 = this.faS;
            int i6 = this.faS != 0 ? this.faU / this.faS : 0;
            String cdnErrorJsonData = this.faW.toString();
            if (getmCdnLogData() != null && this.EB > 0 && System.currentTimeMillis() - this.EB > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.faM = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.faT < 5) {
                    i2 = 0;
                } else if (this.faR < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.faS < getmCdnLogData().getSlowNumber()) {
                    if (this.faR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.faR < 100.0f || this.faS < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (faX) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.faR += 10.0f;
                } else {
                    this.faR += getmCdnLogData().getSlowRank();
                }
                this.faS++;
                this.faU = (int) (this.faU + j);
                this.faT++;
                int i4 = this.faT;
                int i5 = this.mErrorNum;
                int i6 = this.faS;
                if (this.faS != 0) {
                    i = this.faU / this.faS;
                }
                String cdnErrorJsonData = this.faW.toString();
                if (getmCdnLogData() != null && this.EB > 0 && System.currentTimeMillis() - this.EB > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.faM = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.faT >= 5) {
                        if (this.faR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.faS >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.faR >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.faR >= 100.0f && this.faS >= getmCdnLogData().getSlowNumber()) {
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
                this.faR -= 25.0f;
            } else {
                this.faR -= getmCdnLogData().getSuccRank();
            }
            if (this.faR < 0.0f) {
                this.faR = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.faO) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.faV == null) {
            this.faV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.faV);
        cDNUpLoadTask.execute(new Object[0]);
        this.faO = true;
        a jD = s.jD();
        jD.append(SocialConstants.PARAM_ACT, "fallback");
        jD.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.faT = 0;
        this.faS = 0;
        this.mErrorNum = 0;
        this.faU = 0;
        this.faR = 0.0f;
        this.faW.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String auJ;
        private final int faS;
        private final int faT;
        private final String fba;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.faS = i4;
            this.auJ = str;
            this.fba = str2;
            this.mType = i;
            this.faT = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.faT));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.auJ);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.faS));
                this.mNetWork.x("time", this.fba);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.faS + "");
                this.mNetWork.x("time", this.fba);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.auJ);
            }
            String BA = this.mNetWork.BA();
            if (!this.mNetWork.Cb() || TextUtils.isEmpty(BA)) {
                return null;
            }
            try {
                return new JSONObject(BA);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: af */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a jD = s.jD();
                    jD.append(SocialConstants.PARAM_ACT, "fallback");
                    jD.append("result", "1");
                    jD.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aJI.setmSwitch(false);
                    CDNProblemUploader.this.EB = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a jD2 = s.jD();
                        jD2.append(SocialConstants.PARAM_ACT, "fallback");
                        jD2.append("result", "2");
                        jD2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD2);
                    } else {
                        a jD3 = s.jD();
                        jD3.append(SocialConstants.PARAM_ACT, "fallback");
                        jD3.append("result", "0");
                        jD3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aJI.setmSwitch(false);
                        CDNProblemUploader.this.EB = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    k kVar = new k();
                    kVar.parseJson(optString);
                    if (kVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && kVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && kVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && kVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(kVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.faO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {
        StringBuffer fbb;

        private CdnErrorJsonData() {
            this.fbb = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.fbb.length() != 0) {
                this.fbb.append(",");
            }
            this.fbb.append(i);
        }

        public void clear() {
            this.fbb.setLength(0);
        }

        public String toString() {
            return this.fbb.toString();
        }
    }
}
