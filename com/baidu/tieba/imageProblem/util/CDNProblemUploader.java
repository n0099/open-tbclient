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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNProblemUploader extends q {
    private static Object eIe = new Object();
    private static volatile CDNProblemUploader eIf;
    private l aCi;
    private int eHZ;
    private int eIa;
    private int eIb;
    private int mErrorNum;
    private Handler mHandler;
    private final int eHM = 5;
    private final int eHN = 0;
    private final int eHO = 1;
    private final int eHP = 2;
    private final int eHQ = 3;
    private final byte eHR = 0;
    private final byte eHS = 1;
    private int eHT = 0;
    private final int eHU = 5;
    private boolean eHV = false;
    private long BC = 0;
    private final long eHW = 86400000;
    private final float eHX = 100.0f;
    private float eHY = 0.0f;
    private BdAsyncTaskParallel eIc = null;
    private final CdnErrorJsonData eId = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eHT + 1;
        cDNProblemUploader.eHT = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eIf == null) {
            synchronized (CDNProblemUploader.class) {
                if (eIf == null) {
                    eIf = new CDNProblemUploader();
                }
            }
        }
        return eIf;
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

    @Override // com.baidu.tbadk.core.util.q
    public l getmCdnLogData() {
        return this.aCi;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(l lVar) {
        synchronized (eIe) {
            this.aCi = lVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (eIe) {
            if (getmCdnLogData() == null) {
                this.eHY += 25.0f;
            } else {
                this.eHY += getmCdnLogData().getErrRank();
            }
            this.eIa++;
            this.mErrorNum++;
            this.eId.add(i);
            int i3 = this.eIa;
            int i4 = this.mErrorNum;
            int i5 = this.eHZ;
            int i6 = this.eHZ != 0 ? this.eIb / this.eHZ : 0;
            String cdnErrorJsonData = this.eId.toString();
            if (getmCdnLogData() != null && this.BC > 0 && System.currentTimeMillis() - this.BC > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eHT = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eIa < 5) {
                    i2 = 0;
                } else if (this.eHY < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eHZ < getmCdnLogData().getSlowNumber()) {
                    if (this.eHY >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eHY < 100.0f || this.eHZ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eIe) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eHY += 10.0f;
                } else {
                    this.eHY += getmCdnLogData().getSlowRank();
                }
                this.eHZ++;
                this.eIb = (int) (this.eIb + j);
                this.eIa++;
                int i4 = this.eIa;
                int i5 = this.mErrorNum;
                int i6 = this.eHZ;
                if (this.eHZ != 0) {
                    i = this.eIb / this.eHZ;
                }
                String cdnErrorJsonData = this.eId.toString();
                if (getmCdnLogData() != null && this.BC > 0 && System.currentTimeMillis() - this.BC > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eHT = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eIa >= 5) {
                        if (this.eHY >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eHZ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eHY >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eHY >= 100.0f && this.eHZ >= getmCdnLogData().getSlowNumber()) {
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
                this.eHY -= 25.0f;
            } else {
                this.eHY -= getmCdnLogData().getSuccRank();
            }
            if (this.eHY < 0.0f) {
                this.eHY = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eHV) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eIc == null) {
            this.eIc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eIc);
        cDNUpLoadTask.execute(new Object[0]);
        this.eHV = true;
        a ih = t.ih();
        ih.append(SocialConstants.PARAM_ACT, "fallback");
        ih.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eIa = 0;
        this.eHZ = 0;
        this.mErrorNum = 0;
        this.eIb = 0;
        this.eHY = 0.0f;
        this.eId.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String anK;
        private final int eHZ;
        private final int eIa;
        private final String eIh;
        private final int mErrorNum;
        private final y mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eHZ = i4;
            this.anK = str;
            this.eIh = str2;
            this.mType = i;
            this.eIa = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.eIa));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.anK);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.eHZ));
                this.mNetWork.o("time", this.eIh);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.eHZ + "");
                this.mNetWork.o("time", this.eIh);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.anK);
            }
            String yz = this.mNetWork.yz();
            if (!this.mNetWork.za() || TextUtils.isEmpty(yz)) {
                return null;
            }
            try {
                return new JSONObject(yz);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a ih = t.ih();
                    ih.append(SocialConstants.PARAM_ACT, "fallback");
                    ih.append("result", "1");
                    ih.append("type", "end");
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aCi.setmSwitch(false);
                    CDNProblemUploader.this.BC = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a ih2 = t.ih();
                        ih2.append(SocialConstants.PARAM_ACT, "fallback");
                        ih2.append("result", "2");
                        ih2.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih2);
                    } else {
                        a ih3 = t.ih();
                        ih3.append(SocialConstants.PARAM_ACT, "fallback");
                        ih3.append("result", "0");
                        ih3.append("type", "end");
                        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aCi.setmSwitch(false);
                        CDNProblemUploader.this.BC = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    l lVar = new l();
                    lVar.parseJson(optString);
                    if (lVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && lVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && lVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && lVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                        return;
                    }
                    CDNProblemUploader.this.setmCdnLogData(lVar);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.eHV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eIi;

        private CdnErrorJsonData() {
            this.eIi = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eIi.length() != 0) {
                this.eIi.append(",");
            }
            this.eIi.append(i);
        }

        public void clear() {
            this.eIi.setLength(0);
        }

        public String toString() {
            return this.eIi.toString();
        }
    }
}
