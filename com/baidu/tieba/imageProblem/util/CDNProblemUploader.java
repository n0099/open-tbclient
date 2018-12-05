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
    private static Object fjj = new Object();
    private static volatile CDNProblemUploader fjk;
    private k aNX;
    private int fje;
    private int fjf;
    private int fjg;
    private int mErrorNum;
    private Handler mHandler;
    private final int fiR = 5;
    private final int fiS = 0;
    private final int fiT = 1;
    private final int fiU = 2;
    private final int fiV = 3;
    private final byte fiW = 0;
    private final byte fiX = 1;
    private int fiY = 0;
    private final int fiZ = 5;
    private boolean fja = false;
    private long EF = 0;
    private final long fjb = 86400000;
    private final float fjc = 100.0f;
    private float fjd = 0.0f;
    private BdAsyncTaskParallel fjh = null;
    private final CdnErrorJsonData fji = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.fiY + 1;
        cDNProblemUploader.fiY = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (fjk == null) {
            synchronized (CDNProblemUploader.class) {
                if (fjk == null) {
                    fjk = new CDNProblemUploader();
                }
            }
        }
        return fjk;
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
        return this.aNX;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (fjj) {
            this.aNX = kVar;
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
        synchronized (fjj) {
            if (getmCdnLogData() == null) {
                this.fjd += 25.0f;
            } else {
                this.fjd += getmCdnLogData().getErrRank();
            }
            this.fjf++;
            this.mErrorNum++;
            this.fji.add(i);
            int i3 = this.fjf;
            int i4 = this.mErrorNum;
            int i5 = this.fje;
            int i6 = this.fje != 0 ? this.fjg / this.fje : 0;
            String cdnErrorJsonData = this.fji.toString();
            if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.fiY = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.fjf < 5) {
                    i2 = 0;
                } else if (this.fjd < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.fje < getmCdnLogData().getSlowNumber()) {
                    if (this.fjd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.fjd < 100.0f || this.fje < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (fjj) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.fjd += 10.0f;
                } else {
                    this.fjd += getmCdnLogData().getSlowRank();
                }
                this.fje++;
                this.fjg = (int) (this.fjg + j);
                this.fjf++;
                int i4 = this.fjf;
                int i5 = this.mErrorNum;
                int i6 = this.fje;
                if (this.fje != 0) {
                    i = this.fjg / this.fje;
                }
                String cdnErrorJsonData = this.fji.toString();
                if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.fiY = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.fjf >= 5) {
                        if (this.fjd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.fje >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.fjd >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.fjd >= 100.0f && this.fje >= getmCdnLogData().getSlowNumber()) {
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
                this.fjd -= 25.0f;
            } else {
                this.fjd -= getmCdnLogData().getSuccRank();
            }
            if (this.fjd < 0.0f) {
                this.fjd = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.fja) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.fjh == null) {
            this.fjh = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.fjh);
        cDNUpLoadTask.execute(new Object[0]);
        this.fja = true;
        a jB = s.jB();
        jB.append(SocialConstants.PARAM_ACT, "fallback");
        jB.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.fjf = 0;
        this.fje = 0;
        this.mErrorNum = 0;
        this.fjg = 0;
        this.fjd = 0.0f;
        this.fji.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String ayW;
        private final int fje;
        private final int fjf;
        private final String fjm;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.fje = i4;
            this.ayW = str;
            this.fjm = str2;
            this.mType = i;
            this.fjf = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.fjf));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.ayW);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.fje));
                this.mNetWork.x("time", this.fjm);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.fje + "");
                this.mNetWork.x("time", this.fjm);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.ayW);
            }
            String CL = this.mNetWork.CL();
            if (!this.mNetWork.Dm() || TextUtils.isEmpty(CL)) {
                return null;
            }
            try {
                return new JSONObject(CL);
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
                    CDNProblemUploader.this.aNX.setmSwitch(false);
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
                        CDNProblemUploader.this.aNX.setmSwitch(false);
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
                CDNProblemUploader.this.fja = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {
        StringBuffer fjn;

        private CdnErrorJsonData() {
            this.fjn = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.fjn.length() != 0) {
                this.fjn.append(",");
            }
            this.fjn.append(i);
        }

        public void clear() {
            this.fjn.setLength(0);
        }

        public String toString() {
            return this.fjn.toString();
        }
    }
}
