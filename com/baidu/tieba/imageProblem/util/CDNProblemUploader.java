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
import com.baidu.mapapi.UIMsg;
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
    private static Object fmV = new Object();
    private static volatile CDNProblemUploader fmW;
    private k aOC;
    private int fmQ;
    private int fmR;
    private int fmS;
    private int mErrorNum;
    private Handler mHandler;
    private final int fmD = 5;
    private final int fmE = 0;
    private final int fmF = 1;
    private final int fmG = 2;
    private final int fmH = 3;
    private final byte fmI = 0;
    private final byte fmJ = 1;
    private int fmK = 0;
    private final int fmL = 5;
    private boolean fmM = false;
    private long EF = 0;
    private final long fmN = 86400000;
    private final float fmO = 100.0f;
    private float fmP = 0.0f;
    private BdAsyncTaskParallel fmT = null;
    private final CdnErrorJsonData fmU = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.fmK + 1;
        cDNProblemUploader.fmK = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (fmW == null) {
            synchronized (CDNProblemUploader.class) {
                if (fmW == null) {
                    fmW = new CDNProblemUploader();
                }
            }
        }
        return fmW;
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
        return this.aOC;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (fmV) {
            this.aOC = kVar;
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
        synchronized (fmV) {
            if (getmCdnLogData() == null) {
                this.fmP += 25.0f;
            } else {
                this.fmP += getmCdnLogData().getErrRank();
            }
            this.fmR++;
            this.mErrorNum++;
            this.fmU.add(i);
            int i3 = this.fmR;
            int i4 = this.mErrorNum;
            int i5 = this.fmQ;
            int i6 = this.fmQ != 0 ? this.fmS / this.fmQ : 0;
            String cdnErrorJsonData = this.fmU.toString();
            if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.fmK = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.fmR < 5) {
                    i2 = 0;
                } else if (this.fmP < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.fmQ < getmCdnLogData().getSlowNumber()) {
                    if (this.fmP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.fmP < 100.0f || this.fmQ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, cdnErrorJsonData, i5, i6);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = UIMsg.m_AppUI.MSG_APP_GPS;
        if (getmCdnLogData() != null) {
            i3 = getmCdnLogData().getTime();
        }
        synchronized (fmV) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.fmP += 10.0f;
                } else {
                    this.fmP += getmCdnLogData().getSlowRank();
                }
                this.fmQ++;
                this.fmS = (int) (this.fmS + j);
                this.fmR++;
                int i4 = this.fmR;
                int i5 = this.mErrorNum;
                int i6 = this.fmQ;
                if (this.fmQ != 0) {
                    i = this.fmS / this.fmQ;
                }
                String cdnErrorJsonData = this.fmU.toString();
                if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.fmK = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.fmR >= 5) {
                        if (this.fmP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.fmQ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.fmP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.fmP >= 100.0f && this.fmQ >= getmCdnLogData().getSlowNumber()) {
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
                this.fmP -= 25.0f;
            } else {
                this.fmP -= getmCdnLogData().getSuccRank();
            }
            if (this.fmP < 0.0f) {
                this.fmP = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.fmM) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.fmT == null) {
            this.fmT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.fmT);
        cDNUpLoadTask.execute(new Object[0]);
        this.fmM = true;
        a jB = s.jB();
        jB.append(SocialConstants.PARAM_ACT, "fallback");
        jB.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.fmR = 0;
        this.fmQ = 0;
        this.mErrorNum = 0;
        this.fmS = 0;
        this.fmP = 0.0f;
        this.fmU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String azz;
        private final int fmQ;
        private final int fmR;
        private final String fmY;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.fmQ = i4;
            this.azz = str;
            this.fmY = str2;
            this.mType = i;
            this.fmR = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.fmR));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.azz);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.fmQ));
                this.mNetWork.x("time", this.fmY);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.fmQ + "");
                this.mNetWork.x("time", this.fmY);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.azz);
            }
            String CY = this.mNetWork.CY();
            if (!this.mNetWork.Dz() || TextUtils.isEmpty(CY)) {
                return null;
            }
            try {
                return new JSONObject(CY);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ah */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a jB = s.jB();
                    jB.append(SocialConstants.PARAM_ACT, "fallback");
                    jB.append("result", "1");
                    jB.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aOC.setmSwitch(false);
                    CDNProblemUploader.this.EF = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a jB2 = s.jB();
                        jB2.append(SocialConstants.PARAM_ACT, "fallback");
                        jB2.append("result", "2");
                        jB2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB2);
                    } else {
                        a jB3 = s.jB();
                        jB3.append(SocialConstants.PARAM_ACT, "fallback");
                        jB3.append("result", "0");
                        jB3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aOC.setmSwitch(false);
                        CDNProblemUploader.this.EF = System.currentTimeMillis();
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
                CDNProblemUploader.this.fmM = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {
        StringBuffer fmZ;

        private CdnErrorJsonData() {
            this.fmZ = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.fmZ.length() != 0) {
                this.fmZ.append(",");
            }
            this.fmZ.append(i);
        }

        public void clear() {
            this.fmZ.setLength(0);
        }

        public String toString() {
            return this.fmZ.toString();
        }
    }
}
