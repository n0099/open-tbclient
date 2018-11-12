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
    private static Object fcr = new Object();
    private static volatile CDNProblemUploader fcs;
    private k aKy;
    private int fcm;
    private int fcn;
    private int fco;
    private int mErrorNum;
    private Handler mHandler;
    private final int fbZ = 5;
    private final int fca = 0;
    private final int fcb = 1;
    private final int fcc = 2;
    private final int fcd = 3;
    private final byte fce = 0;
    private final byte fcf = 1;
    private int fcg = 0;
    private final int fch = 5;
    private boolean fci = false;
    private long EF = 0;
    private final long fcj = 86400000;
    private final float fck = 100.0f;
    private float fcl = 0.0f;
    private BdAsyncTaskParallel fcp = null;
    private final CdnErrorJsonData fcq = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.fcg + 1;
        cDNProblemUploader.fcg = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (fcs == null) {
            synchronized (CDNProblemUploader.class) {
                if (fcs == null) {
                    fcs = new CDNProblemUploader();
                }
            }
        }
        return fcs;
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
        return this.aKy;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void setmCdnLogData(k kVar) {
        synchronized (fcr) {
            this.aKy = kVar;
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
        synchronized (fcr) {
            if (getmCdnLogData() == null) {
                this.fcl += 25.0f;
            } else {
                this.fcl += getmCdnLogData().getErrRank();
            }
            this.fcn++;
            this.mErrorNum++;
            this.fcq.add(i);
            int i3 = this.fcn;
            int i4 = this.mErrorNum;
            int i5 = this.fcm;
            int i6 = this.fcm != 0 ? this.fco / this.fcm : 0;
            String cdnErrorJsonData = this.fcq.toString();
            if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.fcg = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.fcn < 5) {
                    i2 = 0;
                } else if (this.fcl < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.fcm < getmCdnLogData().getSlowNumber()) {
                    if (this.fcl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.fcl < 100.0f || this.fcm < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (fcr) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.fcl += 10.0f;
                } else {
                    this.fcl += getmCdnLogData().getSlowRank();
                }
                this.fcm++;
                this.fco = (int) (this.fco + j);
                this.fcn++;
                int i4 = this.fcn;
                int i5 = this.mErrorNum;
                int i6 = this.fcm;
                if (this.fcm != 0) {
                    i = this.fco / this.fcm;
                }
                String cdnErrorJsonData = this.fcq.toString();
                if (getmCdnLogData() != null && this.EF > 0 && System.currentTimeMillis() - this.EF > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.fcg = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.fcn >= 5) {
                        if (this.fcl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.fcm >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.fcl >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.fcl >= 100.0f && this.fcm >= getmCdnLogData().getSlowNumber()) {
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
                this.fcl -= 25.0f;
            } else {
                this.fcl -= getmCdnLogData().getSuccRank();
            }
            if (this.fcl < 0.0f) {
                this.fcl = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.fci) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.fcp == null) {
            this.fcp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.fcp);
        cDNUpLoadTask.execute(new Object[0]);
        this.fci = true;
        a jB = s.jB();
        jB.append(SocialConstants.PARAM_ACT, "fallback");
        jB.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.fcn = 0;
        this.fcm = 0;
        this.mErrorNum = 0;
        this.fco = 0;
        this.fcl = 0.0f;
        this.fcq.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String avw;
        private final int fcm;
        private final int fcn;
        private final String fcu;
        private final int mErrorNum;
        private final x mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.fcm = i4;
            this.avw = str;
            this.fcu = str2;
            this.mType = i;
            this.fcn = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.x("number", String.valueOf(this.fcn));
            if (this.mType == 1) {
                this.mNetWork.x("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.avw);
                this.mNetWork.x("ab_num_slow", String.valueOf(this.fcm));
                this.mNetWork.x("time", this.fcu);
            } else if (this.mType == 3) {
                this.mNetWork.x("ab_num_slow", this.fcm + "");
                this.mNetWork.x("time", this.fcu);
            } else if (this.mType == 2) {
                this.mNetWork.x("ab_num_error", this.mErrorNum + "");
                this.mNetWork.x(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.avw);
            }
            String BH = this.mNetWork.BH();
            if (!this.mNetWork.Ci() || TextUtils.isEmpty(BH)) {
                return null;
            }
            try {
                return new JSONObject(BH);
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
                    a jB = s.jB();
                    jB.append(SocialConstants.PARAM_ACT, "fallback");
                    jB.append("result", "1");
                    jB.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aKy.setmSwitch(false);
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
                        CDNProblemUploader.this.aKy.setmSwitch(false);
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
                CDNProblemUploader.this.fci = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {
        StringBuffer fcv;

        private CdnErrorJsonData() {
            this.fcv = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.fcv.length() != 0) {
                this.fcv.append(",");
            }
            this.fcv.append(i);
        }

        public void clear() {
            this.fcv.setLength(0);
        }

        public String toString() {
            return this.fcv.toString();
        }
    }
}
