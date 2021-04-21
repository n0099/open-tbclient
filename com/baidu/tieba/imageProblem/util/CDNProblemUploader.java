package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.qq.e.comm.constants.Constants;
import d.b.c.e.n.a;
import d.b.i0.r.q.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNProblemUploader extends ICDNProblemUploader {
    public static Object m = new Object();
    public static volatile CDNProblemUploader n;

    /* renamed from: a  reason: collision with root package name */
    public r f18147a;

    /* renamed from: f  reason: collision with root package name */
    public int f18152f;

    /* renamed from: g  reason: collision with root package name */
    public int f18153g;

    /* renamed from: h  reason: collision with root package name */
    public int f18154h;
    public int i;
    public Handler l;

    /* renamed from: b  reason: collision with root package name */
    public int f18148b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18149c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f18150d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f18151e = 0.0f;
    public BdAsyncTaskParallel j = null;
    public final CdnErrorJsonData k = new CdnErrorJsonData();

    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final NetWork f18156a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);

        /* renamed from: b  reason: collision with root package name */
        public final int f18157b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18158c;

        /* renamed from: d  reason: collision with root package name */
        public final String f18159d;

        /* renamed from: e  reason: collision with root package name */
        public final String f18160e;

        /* renamed from: f  reason: collision with root package name */
        public final int f18161f;

        /* renamed from: g  reason: collision with root package name */
        public final int f18162g;

        public CDNUpLoadTask(int i, int i2, int i3, String str, int i4, String str2) {
            this.f18157b = i3;
            this.f18158c = i4;
            this.f18159d = str;
            this.f18160e = str2;
            this.f18161f = i;
            this.f18162g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().g() || this.f18161f == 0) {
                return null;
            }
            this.f18156a.addPostData(IdCardActivity.KEY_NUMBER, String.valueOf(this.f18162g));
            int i = this.f18161f;
            if (i == 1) {
                this.f18156a.addPostData("ab_num_error", String.valueOf(this.f18157b));
                this.f18156a.addPostData("error", this.f18159d);
                this.f18156a.addPostData("ab_num_slow", String.valueOf(this.f18158c));
                this.f18156a.addPostData("time", this.f18160e);
            } else if (i == 3) {
                NetWork netWork = this.f18156a;
                netWork.addPostData("ab_num_slow", this.f18158c + "");
                this.f18156a.addPostData("time", this.f18160e);
            } else if (i == 2) {
                NetWork netWork2 = this.f18156a;
                netWork2.addPostData("ab_num_error", this.f18157b + "");
                this.f18156a.addPostData("error", this.f18159d);
            }
            String postNetData = this.f18156a.postNetData();
            if (this.f18156a.isNetSuccess() && !TextUtils.isEmpty(postNetData)) {
                try {
                    return new JSONObject(postNetData);
                } catch (JSONException e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            try {
                try {
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (jSONObject == null) {
                    a logItem = ImageLogger.getLogItem();
                    logItem.b("act", "fallback");
                    logItem.b("result", "1");
                    logItem.b("type", ProgressInfo.JSON_KEY_END);
                    BdStatisticsManager.getInstance().debug("img", logItem);
                } else if (CDNProblemUploader.a(CDNProblemUploader.this) >= 5) {
                    CDNProblemUploader.this.f18147a.j(false);
                    CDNProblemUploader.this.f18150d = System.currentTimeMillis();
                } else {
                    if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                        a logItem2 = ImageLogger.getLogItem();
                        logItem2.b("act", "fallback");
                        logItem2.b("result", "2");
                        logItem2.b("type", ProgressInfo.JSON_KEY_END);
                        BdStatisticsManager.getInstance().debug("img", logItem2);
                    } else {
                        a logItem3 = ImageLogger.getLogItem();
                        logItem3.b("act", "fallback");
                        logItem3.b("result", "0");
                        logItem3.b("type", ProgressInfo.JSON_KEY_END);
                        BdStatisticsManager.getInstance().debug("img", logItem3);
                        CDNProblemUploader.this.g();
                        CDNProblemUploader.this.f18147a.j(false);
                        CDNProblemUploader.this.f18150d = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    r rVar = new r();
                    rVar.h(optString);
                    if (rVar.g() != CDNProblemUploader.this.getmCdnLogData().g() || rVar.a() != CDNProblemUploader.this.getmCdnLogData().a() || rVar.c() != CDNProblemUploader.this.getmCdnLogData().c() || rVar.f() != CDNProblemUploader.this.getmCdnLogData().f()) {
                        CDNProblemUploader.this.setmCdnLogData(rVar);
                    }
                }
            } finally {
                CDNProblemUploader.this.f18149c = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {

        /* renamed from: a  reason: collision with root package name */
        public StringBuffer f18164a;

        public CdnErrorJsonData(CDNProblemUploader cDNProblemUploader) {
            this.f18164a = new StringBuffer(100);
        }

        public void add(int i) {
            if (this.f18164a.length() != 0) {
                this.f18164a.append(",");
            }
            this.f18164a.append(i);
        }

        public void clear() {
            this.f18164a.setLength(0);
        }

        public String toString() {
            return this.f18164a.toString();
        }
    }

    public CDNProblemUploader() {
        this.l = null;
        this.l = new Handler() { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    CDNProblemUploader.this._insertNormalData(message.arg1, (String) message.obj);
                } else if (i != 1) {
                } else {
                    CDNProblemUploader.this._insertErrorData(message.arg1, (String) message.obj);
                }
            }
        };
    }

    public static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.f18148b + 1;
        cDNProblemUploader.f18148b = i;
        return i;
    }

    public static CDNProblemUploader getInstance() {
        if (n == null) {
            synchronized (CDNProblemUploader.class) {
                if (n == null) {
                    n = new CDNProblemUploader();
                }
            }
        }
        return n;
    }

    public void _insertErrorData(int i, String str) {
        int i2;
        synchronized (m) {
            if (getmCdnLogData() == null) {
                this.f18151e += 25.0f;
            } else {
                this.f18151e += getmCdnLogData().b();
            }
            this.f18154h++;
            this.f18153g++;
            this.k.add(i);
            int i3 = this.f18154h;
            int i4 = this.f18153g;
            int i5 = this.f18152f;
            int i6 = this.f18152f != 0 ? this.i / this.f18152f : 0;
            String cdnErrorJsonData = this.k.toString();
            if (getmCdnLogData() != null && this.f18150d > 0 && System.currentTimeMillis() - this.f18150d > 86400000) {
                getmCdnLogData().j(true);
                this.f18148b = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().g()) {
                if (this.f18154h >= 5) {
                    if (this.f18151e >= 100.0f && this.f18153g >= getmCdnLogData().a() && this.f18152f >= getmCdnLogData().c()) {
                        i2 = 1;
                    } else if (this.f18151e >= 100.0f && this.f18153g >= getmCdnLogData().a()) {
                        i2 = 2;
                    } else if (this.f18151e >= 100.0f && this.f18152f >= getmCdnLogData().c()) {
                        i2 = 3;
                    }
                    f(i2, i3, i4, cdnErrorJsonData, i5, i6);
                }
                i2 = 0;
                f(i2, i3, i4, cdnErrorJsonData, i5, i6);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i;
        int f2 = getmCdnLogData() != null ? getmCdnLogData().f() : 5000;
        synchronized (m) {
            if (j >= f2) {
                if (getmCdnLogData() == null) {
                    this.f18151e += 10.0f;
                } else {
                    this.f18151e += getmCdnLogData().d();
                }
                int i2 = this.f18152f + 1;
                this.f18152f = i2;
                int i3 = (int) (this.i + j);
                this.i = i3;
                int i4 = this.f18154h + 1;
                this.f18154h = i4;
                int i5 = this.f18153g;
                int i6 = i2 != 0 ? i3 / i2 : 0;
                String cdnErrorJsonData = this.k.toString();
                if (getmCdnLogData() != null && this.f18150d > 0 && System.currentTimeMillis() - this.f18150d > 86400000) {
                    getmCdnLogData().j(true);
                    this.f18148b = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().g()) {
                    if (this.f18154h >= 5) {
                        if (this.f18151e >= 100.0f && this.f18153g >= getmCdnLogData().a() && this.f18152f >= getmCdnLogData().c()) {
                            i = 1;
                        } else if (this.f18151e >= 100.0f && this.f18153g >= getmCdnLogData().a()) {
                            i = 2;
                        } else if (this.f18151e >= 100.0f && this.f18152f >= getmCdnLogData().c()) {
                            i = 3;
                        }
                        f(i, i4, i5, cdnErrorJsonData, i2, i6);
                        return;
                    }
                    i = 0;
                    f(i, i4, i5, cdnErrorJsonData, i2, i6);
                    return;
                }
                return;
            }
            if (getmCdnLogData() == null) {
                this.f18151e -= 25.0f;
            } else {
                this.f18151e -= getmCdnLogData().e();
            }
            if (this.f18151e < 0.0f) {
                this.f18151e = 0.0f;
            }
        }
    }

    public final void f(int i, int i2, int i3, String str, int i4, int i5) {
        if (getmCdnLogData() == null || !getmCdnLogData().g() || i == 0 || this.f18149c) {
            return;
        }
        h(i, i2, i3, str, i4, i5 + "");
    }

    public final void g() {
        this.f18154h = 0;
        this.f18152f = 0;
        this.f18153g = 0;
        this.i = 0;
        this.f18151e = 0.0f;
        this.k.clear();
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public r getmCdnLogData() {
        return this.f18147a;
    }

    public final void h(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.j == null) {
            this.j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i, i2, i3, str, i4, str2);
        cDNUpLoadTask.setParallel(this.j);
        cDNUpLoadTask.execute(new Object[0]);
        this.f18149c = true;
        a logItem = ImageLogger.getLogItem();
        logItem.b("act", "fallback");
        logItem.b("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertErrorData(int i, String str) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(1, i, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertNormalData(long j, String str) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(0, (int) j, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void setmCdnLogData(r rVar) {
        synchronized (m) {
            this.f18147a = rVar;
        }
    }
}
