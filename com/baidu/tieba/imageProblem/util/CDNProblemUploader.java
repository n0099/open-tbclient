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
import d.a.c.e.n.a;
import d.a.m0.r.q.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNProblemUploader extends ICDNProblemUploader {
    public static Object m = new Object();
    public static volatile CDNProblemUploader n;

    /* renamed from: a  reason: collision with root package name */
    public r f17795a;

    /* renamed from: f  reason: collision with root package name */
    public int f17800f;

    /* renamed from: g  reason: collision with root package name */
    public int f17801g;

    /* renamed from: h  reason: collision with root package name */
    public int f17802h;

    /* renamed from: i  reason: collision with root package name */
    public int f17803i;
    public Handler l;

    /* renamed from: b  reason: collision with root package name */
    public int f17796b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17797c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f17798d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f17799e = 0.0f;
    public BdAsyncTaskParallel j = null;
    public final CdnErrorJsonData k = new CdnErrorJsonData();

    /* loaded from: classes4.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final NetWork f17805a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);

        /* renamed from: b  reason: collision with root package name */
        public final int f17806b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17807c;

        /* renamed from: d  reason: collision with root package name */
        public final String f17808d;

        /* renamed from: e  reason: collision with root package name */
        public final String f17809e;

        /* renamed from: f  reason: collision with root package name */
        public final int f17810f;

        /* renamed from: g  reason: collision with root package name */
        public final int f17811g;

        public CDNUpLoadTask(int i2, int i3, int i4, String str, int i5, String str2) {
            this.f17806b = i4;
            this.f17807c = i5;
            this.f17808d = str;
            this.f17809e = str2;
            this.f17810f = i2;
            this.f17811g = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Object... objArr) {
            if (CDNProblemUploader.this.getmCdnLogData() == null || !CDNProblemUploader.this.getmCdnLogData().g() || this.f17810f == 0) {
                return null;
            }
            this.f17805a.addPostData(IdCardActivity.KEY_NUMBER, String.valueOf(this.f17811g));
            int i2 = this.f17810f;
            if (i2 == 1) {
                this.f17805a.addPostData("ab_num_error", String.valueOf(this.f17806b));
                this.f17805a.addPostData("error", this.f17808d);
                this.f17805a.addPostData("ab_num_slow", String.valueOf(this.f17807c));
                this.f17805a.addPostData("time", this.f17809e);
            } else if (i2 == 3) {
                NetWork netWork = this.f17805a;
                netWork.addPostData("ab_num_slow", this.f17807c + "");
                this.f17805a.addPostData("time", this.f17809e);
            } else if (i2 == 2) {
                NetWork netWork2 = this.f17805a;
                netWork2.addPostData("ab_num_error", this.f17806b + "");
                this.f17805a.addPostData("error", this.f17808d);
            }
            String postNetData = this.f17805a.postNetData();
            if (this.f17805a.isNetSuccess() && !TextUtils.isEmpty(postNetData)) {
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
                    CDNProblemUploader.this.f17795a.j(false);
                    CDNProblemUploader.this.f17798d = System.currentTimeMillis();
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
                        CDNProblemUploader.this.f17795a.j(false);
                        CDNProblemUploader.this.f17798d = System.currentTimeMillis();
                    }
                    String optString = jSONObject.optString("photo_strategy");
                    r rVar = new r();
                    rVar.h(optString);
                    if (rVar.g() != CDNProblemUploader.this.getmCdnLogData().g() || rVar.a() != CDNProblemUploader.this.getmCdnLogData().a() || rVar.c() != CDNProblemUploader.this.getmCdnLogData().c() || rVar.f() != CDNProblemUploader.this.getmCdnLogData().f()) {
                        CDNProblemUploader.this.setmCdnLogData(rVar);
                    }
                }
            } finally {
                CDNProblemUploader.this.f17797c = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class CdnErrorJsonData {

        /* renamed from: a  reason: collision with root package name */
        public StringBuffer f17813a;

        public CdnErrorJsonData(CDNProblemUploader cDNProblemUploader) {
            this.f17813a = new StringBuffer(100);
        }

        public void add(int i2) {
            if (this.f17813a.length() != 0) {
                this.f17813a.append(",");
            }
            this.f17813a.append(i2);
        }

        public void clear() {
            this.f17813a.setLength(0);
        }

        public String toString() {
            return this.f17813a.toString();
        }
    }

    public CDNProblemUploader() {
        this.l = null;
        this.l = new Handler() { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    CDNProblemUploader.this._insertNormalData(message.arg1, (String) message.obj);
                } else if (i2 != 1) {
                } else {
                    CDNProblemUploader.this._insertErrorData(message.arg1, (String) message.obj);
                }
            }
        };
    }

    public static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i2 = cDNProblemUploader.f17796b + 1;
        cDNProblemUploader.f17796b = i2;
        return i2;
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

    public void _insertErrorData(int i2, String str) {
        int i3;
        synchronized (m) {
            if (getmCdnLogData() == null) {
                this.f17799e += 25.0f;
            } else {
                this.f17799e += getmCdnLogData().b();
            }
            this.f17802h++;
            this.f17801g++;
            this.k.add(i2);
            int i4 = this.f17802h;
            int i5 = this.f17801g;
            int i6 = this.f17800f;
            int i7 = this.f17800f != 0 ? this.f17803i / this.f17800f : 0;
            String cdnErrorJsonData = this.k.toString();
            if (getmCdnLogData() != null && this.f17798d > 0 && System.currentTimeMillis() - this.f17798d > 86400000) {
                getmCdnLogData().j(true);
                this.f17796b = 0;
            }
            if (getmCdnLogData() != null && getmCdnLogData().g()) {
                if (this.f17802h >= 5) {
                    if (this.f17799e >= 100.0f && this.f17801g >= getmCdnLogData().a() && this.f17800f >= getmCdnLogData().c()) {
                        i3 = 1;
                    } else if (this.f17799e >= 100.0f && this.f17801g >= getmCdnLogData().a()) {
                        i3 = 2;
                    } else if (this.f17799e >= 100.0f && this.f17800f >= getmCdnLogData().c()) {
                        i3 = 3;
                    }
                    f(i3, i4, i5, cdnErrorJsonData, i6, i7);
                }
                i3 = 0;
                f(i3, i4, i5, cdnErrorJsonData, i6, i7);
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i2;
        int f2 = getmCdnLogData() != null ? getmCdnLogData().f() : 5000;
        synchronized (m) {
            if (j >= f2) {
                if (getmCdnLogData() == null) {
                    this.f17799e += 10.0f;
                } else {
                    this.f17799e += getmCdnLogData().d();
                }
                int i3 = this.f17800f + 1;
                this.f17800f = i3;
                int i4 = (int) (this.f17803i + j);
                this.f17803i = i4;
                int i5 = this.f17802h + 1;
                this.f17802h = i5;
                int i6 = this.f17801g;
                int i7 = i3 != 0 ? i4 / i3 : 0;
                String cdnErrorJsonData = this.k.toString();
                if (getmCdnLogData() != null && this.f17798d > 0 && System.currentTimeMillis() - this.f17798d > 86400000) {
                    getmCdnLogData().j(true);
                    this.f17796b = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().g()) {
                    if (this.f17802h >= 5) {
                        if (this.f17799e >= 100.0f && this.f17801g >= getmCdnLogData().a() && this.f17800f >= getmCdnLogData().c()) {
                            i2 = 1;
                        } else if (this.f17799e >= 100.0f && this.f17801g >= getmCdnLogData().a()) {
                            i2 = 2;
                        } else if (this.f17799e >= 100.0f && this.f17800f >= getmCdnLogData().c()) {
                            i2 = 3;
                        }
                        f(i2, i5, i6, cdnErrorJsonData, i3, i7);
                        return;
                    }
                    i2 = 0;
                    f(i2, i5, i6, cdnErrorJsonData, i3, i7);
                    return;
                }
                return;
            }
            if (getmCdnLogData() == null) {
                this.f17799e -= 25.0f;
            } else {
                this.f17799e -= getmCdnLogData().e();
            }
            if (this.f17799e < 0.0f) {
                this.f17799e = 0.0f;
            }
        }
    }

    public final void f(int i2, int i3, int i4, String str, int i5, int i6) {
        if (getmCdnLogData() == null || !getmCdnLogData().g() || i2 == 0 || this.f17797c) {
            return;
        }
        h(i2, i3, i4, str, i5, i6 + "");
    }

    public final void g() {
        this.f17802h = 0;
        this.f17800f = 0;
        this.f17801g = 0;
        this.f17803i = 0;
        this.f17799e = 0.0f;
        this.k.clear();
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public r getmCdnLogData() {
        return this.f17795a;
    }

    public final void h(int i2, int i3, int i4, String str, int i5, String str2) {
        if (this.j == null) {
            this.j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(i2, i3, i4, str, i5, str2);
        cDNUpLoadTask.setParallel(this.j);
        cDNUpLoadTask.execute(new Object[0]);
        this.f17797c = true;
        a logItem = ImageLogger.getLogItem();
        logItem.b("act", "fallback");
        logItem.b("type", IntentConfig.START);
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertErrorData(int i2, String str) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(1, i2, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertNormalData(long j, String str) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(0, (int) j, 0, str));
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void setmCdnLogData(r rVar) {
        synchronized (m) {
            this.f17795a = rVar;
        }
    }
}
