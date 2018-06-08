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
    private static Object eEo = new Object();
    private static volatile CDNProblemUploader eEp;
    private l aBo;
    private int eEj;
    private int eEk;
    private int eEl;
    private int mErrorNum;
    private Handler mHandler;
    private final int eDW = 5;
    private final int eDX = 0;
    private final int eDY = 1;
    private final int eDZ = 2;
    private final int eEa = 3;
    private final byte eEb = 0;
    private final byte eEc = 1;
    private int eEd = 0;
    private final int eEe = 5;
    private boolean eEf = false;
    private long BA = 0;
    private final long eEg = 86400000;
    private final float eEh = 100.0f;
    private float eEi = 0.0f;
    private BdAsyncTaskParallel eEm = null;
    private final CdnErrorJsonData eEn = new CdnErrorJsonData();

    static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.eEd + 1;
        cDNProblemUploader.eEd = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (eEp == null) {
            synchronized (CDNProblemUploader.class) {
                if (eEp == null) {
                    eEp = new CDNProblemUploader();
                }
            }
        }
        return eEp;
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
        return this.aBo;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setmCdnLogData(l lVar) {
        synchronized (eEo) {
            this.aBo = lVar;
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
        synchronized (eEo) {
            if (getmCdnLogData() == null) {
                this.eEi += 25.0f;
            } else {
                this.eEi += getmCdnLogData().getErrRank();
            }
            this.eEk++;
            this.mErrorNum++;
            this.eEn.add(i);
            int i3 = this.eEk;
            int i4 = this.mErrorNum;
            int i5 = this.eEj;
            int i6 = this.eEj != 0 ? this.eEl / this.eEj : 0;
            String cdnErrorJsonData = this.eEn.toString();
            if (getmCdnLogData() != null && this.BA > 0 && System.currentTimeMillis() - this.BA > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.eEd = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.eEk < 5) {
                    i2 = 0;
                } else if (this.eEi < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.eEj < getmCdnLogData().getSlowNumber()) {
                    if (this.eEi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.eEi < 100.0f || this.eEj < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (eEo) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.eEi += 10.0f;
                } else {
                    this.eEi += getmCdnLogData().getSlowRank();
                }
                this.eEj++;
                this.eEl = (int) (this.eEl + j);
                this.eEk++;
                int i4 = this.eEk;
                int i5 = this.mErrorNum;
                int i6 = this.eEj;
                if (this.eEj != 0) {
                    i = this.eEl / this.eEj;
                }
                String cdnErrorJsonData = this.eEn.toString();
                if (getmCdnLogData() != null && this.BA > 0 && System.currentTimeMillis() - this.BA > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.eEd = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.eEk >= 5) {
                        if (this.eEi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.eEj >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.eEi >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.eEi >= 100.0f && this.eEj >= getmCdnLogData().getSlowNumber()) {
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
                this.eEi -= 25.0f;
            } else {
                this.eEi -= getmCdnLogData().getSuccRank();
            }
            if (this.eEi < 0.0f) {
                this.eEi = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.eEf) {
            a(i, i2, i3, str, i4, i5 + "");
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.eEm == null) {
            this.eEm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.eEm);
        cDNUpLoadTask.execute(new Object[0]);
        this.eEf = true;
        a ih = t.ih();
        ih.append(SocialConstants.PARAM_ACT, "fallback");
        ih.append("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", ih);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eEk = 0;
        this.eEj = 0;
        this.mErrorNum = 0;
        this.eEl = 0;
        this.eEi = 0.0f;
        this.eEn.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final String ank;
        private final int eEj;
        private final int eEk;
        private final String eEr;
        private final int mErrorNum;
        private final y mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.eEj = i4;
            this.ank = str;
            this.eEr = str2;
            this.mType = i;
            this.eEk = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.mNetWork.o("number", String.valueOf(this.eEk));
            if (this.mType == 1) {
                this.mNetWork.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.mNetWork.o("error", this.ank);
                this.mNetWork.o("ab_num_slow", String.valueOf(this.eEj));
                this.mNetWork.o("time", this.eEr);
            } else if (this.mType == 3) {
                this.mNetWork.o("ab_num_slow", this.eEj + "");
                this.mNetWork.o("time", this.eEr);
            } else if (this.mType == 2) {
                this.mNetWork.o("ab_num_error", this.mErrorNum + "");
                this.mNetWork.o("error", this.ank);
            }
            String yl = this.mNetWork.yl();
            if (!this.mNetWork.yM() || TextUtils.isEmpty(yl)) {
                return null;
            }
            try {
                return new JSONObject(yl);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    a ih = t.ih();
                    ih.append(SocialConstants.PARAM_ACT, "fallback");
                    ih.append("result", "1");
                    ih.append("type", "end");
                    BdStatisticsManager.getInstance().debug("img", ih);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.aBo.setmSwitch(false);
                    CDNProblemUploader.this.BA = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optInt("err_no", -1) != 0) {
                        a ih2 = t.ih();
                        ih2.append(SocialConstants.PARAM_ACT, "fallback");
                        ih2.append("result", "2");
                        ih2.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", ih2);
                    } else {
                        a ih3 = t.ih();
                        ih3.append(SocialConstants.PARAM_ACT, "fallback");
                        ih3.append("result", "0");
                        ih3.append("type", "end");
                        BdStatisticsManager.getInstance().debug("img", ih3);
                        CDNProblemUploader.this.reset();
                        CDNProblemUploader.this.aBo.setmSwitch(false);
                        CDNProblemUploader.this.BA = System.currentTimeMillis();
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
                CDNProblemUploader.this.eEf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CdnErrorJsonData {
        StringBuffer eEs;

        private CdnErrorJsonData() {
            this.eEs = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.eEs.length() != 0) {
                this.eEs.append(",");
            }
            this.eEs.append(i);
        }

        public void clear() {
            this.eEs.setLength(0);
        }

        public String toString() {
            return this.eEs.toString();
        }
    }
}
