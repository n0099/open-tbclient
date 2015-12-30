package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNProblemUploader extends s {
    private static Object clV = new Object();
    private static volatile CDNProblemUploader clW;
    private f aiY;
    private int clQ;
    private int clR;
    private int clS;
    private int mErrorNum;
    private Handler mHandler;
    private final int clD = 5;
    private final int clE = 0;
    private final int clF = 1;
    private final int clG = 2;
    private final int clH = 3;
    private final byte clI = 0;
    private final byte clJ = 1;
    private int clK = 0;
    private final int clL = 5;
    private boolean clM = false;
    private long wV = 0;
    private final long clN = 86400000;
    private final float clO = 100.0f;
    private float clP = 0.0f;
    private BdAsyncTaskParallel clT = null;
    private final CdnErrorJsonData clU = new CdnErrorJsonData(this, null);

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNProblemUploader m414getInstance() {
        if (clW == null) {
            synchronized (CDNProblemUploader.class) {
                if (clW == null) {
                    clW = new CDNProblemUploader();
                }
            }
        }
        return clW;
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

    @Override // com.baidu.tbadk.core.util.s
    public f getmCdnLogData() {
        return this.aiY;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setmCdnLogData(f fVar) {
        synchronized (clV) {
            this.aiY = fVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertErrorData(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void insertNormalData(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void _insertErrorData(int i, String str) {
        int i2 = 1;
        synchronized (clV) {
            if (getmCdnLogData() == null) {
                this.clP += 25.0f;
            } else {
                this.clP += getmCdnLogData().getErrRank();
            }
            this.clR++;
            this.mErrorNum++;
            this.clU.add(i);
            int i3 = this.clR;
            int i4 = this.mErrorNum;
            int i5 = this.clQ;
            int i6 = this.clQ != 0 ? this.clS / this.clQ : 0;
            String cdnErrorJsonData = this.clU.toString();
            if (getmCdnLogData() != null && this.wV > 0 && System.currentTimeMillis() - this.wV > 86400000) {
                getmCdnLogData().setmSwitch(true);
                this.clK = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                if (this.clR < 5) {
                    i2 = 0;
                } else if (this.clP < 100.0f || this.mErrorNum < getmCdnLogData().getErrNumber() || this.clQ < getmCdnLogData().getSlowNumber()) {
                    if (this.clP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                        i2 = 2;
                    } else {
                        i2 = (this.clP < 100.0f || this.clQ < getmCdnLogData().getSlowNumber()) ? 0 : 3;
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
        synchronized (clV) {
            if (j >= i3) {
                if (getmCdnLogData() == null) {
                    this.clP += 10.0f;
                } else {
                    this.clP += getmCdnLogData().getSlowRank();
                }
                this.clQ++;
                this.clS = (int) (this.clS + j);
                this.clR++;
                int i4 = this.clR;
                int i5 = this.mErrorNum;
                int i6 = this.clQ;
                if (this.clQ != 0) {
                    i = this.clS / this.clQ;
                }
                String cdnErrorJsonData = this.clU.toString();
                if (getmCdnLogData() != null && this.wV > 0 && System.currentTimeMillis() - this.wV > 86400000) {
                    getmCdnLogData().setmSwitch(true);
                    this.clK = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().ismSwitch()) {
                    if (this.clR >= 5) {
                        if (this.clP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber() && this.clQ >= getmCdnLogData().getSlowNumber()) {
                            i2 = 1;
                        } else if (this.clP >= 100.0f && this.mErrorNum >= getmCdnLogData().getErrNumber()) {
                            i2 = 2;
                        } else if (this.clP >= 100.0f && this.clQ >= getmCdnLogData().getSlowNumber()) {
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
                this.clP -= 25.0f;
            } else {
                this.clP -= getmCdnLogData().getSuccRank();
            }
            if (this.clP < 0.0f) {
                this.clP = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() != null && getmCdnLogData().ismSwitch() && i != 0 && !this.clM) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.clT == null) {
            this.clT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.clT);
        cDNUpLoadTask.execute(new Object[0]);
        this.clM = true;
        d he = v.he();
        he.q("act", "fallback");
        he.q("type", IntentConfig.START);
        a.hl().b("img", he);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.clR = 0;
        this.clQ = 0;
        this.mErrorNum = 0;
        this.clS = 0;
        this.clP = 0.0f;
        this.clU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        private final ab Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
        private final String Zo;
        private final int clQ;
        private final int clR;
        private final String clY;
        private final int mErrorNum;
        private final int mType;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.mErrorNum = i3;
            this.clQ = i4;
            this.Zo = str;
            this.clY = str2;
            this.mType = i;
            this.clR = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().ismSwitch() || this.mType == 0) {
                return null;
            }
            this.Ua.o("number", String.valueOf(this.clR));
            if (this.mType == 1) {
                this.Ua.o("ab_num_error", String.valueOf(this.mErrorNum));
                this.Ua.o("error", this.Zo);
                this.Ua.o("ab_num_slow", String.valueOf(this.clQ));
                this.Ua.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.clY);
            } else if (this.mType == 3) {
                this.Ua.o("ab_num_slow", new StringBuilder(String.valueOf(this.clQ)).toString());
                this.Ua.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.clY);
            } else if (this.mType == 2) {
                this.Ua.o("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
                this.Ua.o("error", this.Zo);
            }
            String tV = this.Ua.tV();
            if (!this.Ua.uz() || TextUtils.isEmpty(tV)) {
                return null;
            }
            try {
                return new JSONObject(tV);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                if (jSONObject == null) {
                    d he = v.he();
                    he.q("act", "fallback");
                    he.q("result", "1");
                    he.q("type", "end");
                    a.hl().b("img", he);
                    return;
                }
                CDNProblemUploader cDNProblemUploader = CDNProblemUploader.this;
                int i = cDNProblemUploader.clK + 1;
                cDNProblemUploader.clK = i;
                if (i >= 5) {
                    CDNProblemUploader.this.aiY.setmSwitch(false);
                    CDNProblemUploader.this.wV = System.currentTimeMillis();
                    return;
                }
                if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                    d he2 = v.he();
                    he2.q("act", "fallback");
                    he2.q("result", "2");
                    he2.q("type", "end");
                    a.hl().b("img", he2);
                } else {
                    d he3 = v.he();
                    he3.q("act", "fallback");
                    he3.q("result", "0");
                    he3.q("type", "end");
                    a.hl().b("img", he3);
                    CDNProblemUploader.this.reset();
                    CDNProblemUploader.this.aiY.setmSwitch(false);
                    CDNProblemUploader.this.wV = System.currentTimeMillis();
                }
                String optString = jSONObject.optString("photo_strategy");
                f fVar = new f();
                fVar.parseJson(optString);
                if (fVar.ismSwitch() == CDNProblemUploader.this.getmCdnLogData().ismSwitch() && fVar.getErrNumber() == CDNProblemUploader.this.getmCdnLogData().getErrNumber() && fVar.getSlowNumber() == CDNProblemUploader.this.getmCdnLogData().getSlowNumber() && fVar.getTime() == CDNProblemUploader.this.getmCdnLogData().getTime()) {
                    return;
                }
                CDNProblemUploader.this.setmCdnLogData(fVar);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                CDNProblemUploader.this.clM = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CdnErrorJsonData {
        StringBuffer clZ;

        private CdnErrorJsonData() {
            this.clZ = new StringBuffer(100);
        }

        /* synthetic */ CdnErrorJsonData(CDNProblemUploader cDNProblemUploader, CdnErrorJsonData cdnErrorJsonData) {
            this();
        }

        public void add(int i) {
            if (this.clZ.length() != 0) {
                this.clZ.append(",");
            }
            this.clZ.append(i);
        }

        public void clear() {
            this.clZ.setLength(0);
        }

        public String toString() {
            return this.clZ.toString();
        }
    }
}
