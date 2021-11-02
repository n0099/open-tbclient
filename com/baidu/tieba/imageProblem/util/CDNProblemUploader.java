package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.n.a;
import b.a.q0.s.q.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CDNProblemUploader extends ICDNProblemUploader {
    public static /* synthetic */ Interceptable $ic;
    public static Object m;
    public static volatile CDNProblemUploader n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public s f50946a;

    /* renamed from: b  reason: collision with root package name */
    public int f50947b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50948c;

    /* renamed from: d  reason: collision with root package name */
    public long f50949d;

    /* renamed from: e  reason: collision with root package name */
    public float f50950e;

    /* renamed from: f  reason: collision with root package name */
    public int f50951f;

    /* renamed from: g  reason: collision with root package name */
    public int f50952g;

    /* renamed from: h  reason: collision with root package name */
    public int f50953h;

    /* renamed from: i  reason: collision with root package name */
    public int f50954i;
    public BdAsyncTaskParallel j;
    public final CdnErrorJsonData k;
    public Handler l;

    /* loaded from: classes9.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final NetWork f50956a;

        /* renamed from: b  reason: collision with root package name */
        public final int f50957b;

        /* renamed from: c  reason: collision with root package name */
        public final int f50958c;

        /* renamed from: d  reason: collision with root package name */
        public final String f50959d;

        /* renamed from: e  reason: collision with root package name */
        public final String f50960e;

        /* renamed from: f  reason: collision with root package name */
        public final int f50961f;

        /* renamed from: g  reason: collision with root package name */
        public final int f50962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CDNProblemUploader f50963h;

        public CDNUpLoadTask(CDNProblemUploader cDNProblemUploader, int i2, int i3, int i4, String str, int i5, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNProblemUploader, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50963h = cDNProblemUploader;
            this.f50956a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
            this.f50957b = i4;
            this.f50958c = i5;
            this.f50959d = str;
            this.f50960e = str2;
            this.f50961f = i2;
            this.f50962g = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.f50963h.getmCdnLogData() == null || !this.f50963h.getmCdnLogData().g() || this.f50961f == 0) {
                    return null;
                }
                this.f50956a.addPostData("number", String.valueOf(this.f50962g));
                int i2 = this.f50961f;
                if (i2 == 1) {
                    this.f50956a.addPostData("ab_num_error", String.valueOf(this.f50957b));
                    this.f50956a.addPostData("error", this.f50959d);
                    this.f50956a.addPostData("ab_num_slow", String.valueOf(this.f50958c));
                    this.f50956a.addPostData("time", this.f50960e);
                } else if (i2 == 3) {
                    NetWork netWork = this.f50956a;
                    netWork.addPostData("ab_num_slow", this.f50958c + "");
                    this.f50956a.addPostData("time", this.f50960e);
                } else if (i2 == 2) {
                    NetWork netWork2 = this.f50956a;
                    netWork2.addPostData("ab_num_error", this.f50957b + "");
                    this.f50956a.addPostData("error", this.f50959d);
                }
                String postNetData = this.f50956a.postNetData();
                if (this.f50956a.isNetSuccess() && !TextUtils.isEmpty(postNetData)) {
                    try {
                        return new JSONObject(postNetData);
                    } catch (JSONException e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (JSONObject) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
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
                        logItem.b("type", "end");
                        BdStatisticsManager.getInstance().debug("img", logItem);
                    } else if (CDNProblemUploader.a(this.f50963h) >= 5) {
                        this.f50963h.f50946a.j(false);
                        this.f50963h.f50949d = System.currentTimeMillis();
                    } else {
                        if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                            a logItem2 = ImageLogger.getLogItem();
                            logItem2.b("act", "fallback");
                            logItem2.b("result", "2");
                            logItem2.b("type", "end");
                            BdStatisticsManager.getInstance().debug("img", logItem2);
                        } else {
                            a logItem3 = ImageLogger.getLogItem();
                            logItem3.b("act", "fallback");
                            logItem3.b("result", "0");
                            logItem3.b("type", "end");
                            BdStatisticsManager.getInstance().debug("img", logItem3);
                            this.f50963h.g();
                            this.f50963h.f50946a.j(false);
                            this.f50963h.f50949d = System.currentTimeMillis();
                        }
                        String optString = jSONObject.optString("photo_strategy");
                        s sVar = new s();
                        sVar.h(optString);
                        if (sVar.g() != this.f50963h.getmCdnLogData().g() || sVar.a() != this.f50963h.getmCdnLogData().a() || sVar.c() != this.f50963h.getmCdnLogData().c() || sVar.f() != this.f50963h.getmCdnLogData().f()) {
                            this.f50963h.setmCdnLogData(sVar);
                        }
                    }
                } finally {
                    this.f50963h.f50948c = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class CdnErrorJsonData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public StringBuffer f50964a;

        public CdnErrorJsonData(CDNProblemUploader cDNProblemUploader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNProblemUploader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50964a = new StringBuffer(100);
        }

        public void add(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f50964a.length() != 0) {
                    this.f50964a.append(",");
                }
                this.f50964a.append(i2);
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50964a.setLength(0);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50964a.toString() : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-454554069, "Lcom/baidu/tieba/imageProblem/util/CDNProblemUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-454554069, "Lcom/baidu/tieba/imageProblem/util/CDNProblemUploader;");
                return;
            }
        }
        m = new Object();
    }

    public CDNProblemUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50947b = 0;
        this.f50948c = false;
        this.f50949d = 0L;
        this.f50950e = 0.0f;
        this.j = null;
        this.l = null;
        this.k = new CdnErrorJsonData();
        this.l = new Handler(this) { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CDNProblemUploader f50955a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f50955a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 == 0) {
                        this.f50955a._insertNormalData(message.arg1, (String) message.obj);
                    } else if (i4 != 1) {
                    } else {
                        this.f50955a._insertErrorData(message.arg1, (String) message.obj);
                    }
                }
            }
        };
    }

    public static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i2 = cDNProblemUploader.f50947b + 1;
        cDNProblemUploader.f50947b = i2;
        return i2;
    }

    public static CDNProblemUploader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (n == null) {
                synchronized (CDNProblemUploader.class) {
                    if (n == null) {
                        n = new CDNProblemUploader();
                    }
                }
            }
            return n;
        }
        return (CDNProblemUploader) invokeV.objValue;
    }

    public void _insertErrorData(int i2, String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            synchronized (m) {
                if (getmCdnLogData() == null) {
                    this.f50950e += 25.0f;
                } else {
                    this.f50950e += getmCdnLogData().b();
                }
                this.f50953h++;
                this.f50952g++;
                this.k.add(i2);
                int i4 = this.f50953h;
                int i5 = this.f50952g;
                int i6 = this.f50951f;
                int i7 = this.f50951f != 0 ? this.f50954i / this.f50951f : 0;
                String cdnErrorJsonData = this.k.toString();
                if (getmCdnLogData() != null && this.f50949d > 0 && System.currentTimeMillis() - this.f50949d > 86400000) {
                    getmCdnLogData().j(true);
                    this.f50947b = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().g()) {
                    if (this.f50953h >= 5) {
                        if (this.f50950e >= 100.0f && this.f50952g >= getmCdnLogData().a() && this.f50951f >= getmCdnLogData().c()) {
                            i3 = 1;
                        } else if (this.f50950e >= 100.0f && this.f50952g >= getmCdnLogData().a()) {
                            i3 = 2;
                        } else if (this.f50950e >= 100.0f && this.f50951f >= getmCdnLogData().c()) {
                            i3 = 3;
                        }
                        f(i3, i4, i5, cdnErrorJsonData, i6, i7);
                    }
                    i3 = 0;
                    f(i3, i4, i5, cdnErrorJsonData, i6, i7);
                }
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
            int f2 = getmCdnLogData() != null ? getmCdnLogData().f() : 5000;
            synchronized (m) {
                if (j >= f2) {
                    if (getmCdnLogData() == null) {
                        this.f50950e += 10.0f;
                    } else {
                        this.f50950e += getmCdnLogData().d();
                    }
                    int i3 = this.f50951f + 1;
                    this.f50951f = i3;
                    int i4 = (int) (this.f50954i + j);
                    this.f50954i = i4;
                    int i5 = this.f50953h + 1;
                    this.f50953h = i5;
                    int i6 = this.f50952g;
                    int i7 = i3 != 0 ? i4 / i3 : 0;
                    String cdnErrorJsonData = this.k.toString();
                    if (getmCdnLogData() != null && this.f50949d > 0 && System.currentTimeMillis() - this.f50949d > 86400000) {
                        getmCdnLogData().j(true);
                        this.f50947b = 0;
                    }
                    if (getmCdnLogData() != null && getmCdnLogData().g()) {
                        if (this.f50953h >= 5) {
                            if (this.f50950e >= 100.0f && this.f50952g >= getmCdnLogData().a() && this.f50951f >= getmCdnLogData().c()) {
                                i2 = 1;
                            } else if (this.f50950e >= 100.0f && this.f50952g >= getmCdnLogData().a()) {
                                i2 = 2;
                            } else if (this.f50950e >= 100.0f && this.f50951f >= getmCdnLogData().c()) {
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
                    this.f50950e -= 25.0f;
                } else {
                    this.f50950e -= getmCdnLogData().e();
                }
                if (this.f50950e < 0.0f) {
                    this.f50950e = 0.0f;
                }
            }
        }
    }

    public final void f(int i2, int i3, int i4, String str, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || getmCdnLogData() == null || !getmCdnLogData().g() || i2 == 0 || this.f50948c) {
            return;
        }
        h(i2, i3, i4, str, i5, i6 + "");
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50953h = 0;
            this.f50951f = 0;
            this.f50952g = 0;
            this.f50954i = 0;
            this.f50950e = 0.0f;
            this.k.clear();
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public s getmCdnLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50946a : (s) invokeV.objValue;
    }

    public final void h(int i2, int i3, int i4, String str, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), str2}) == null) {
            if (this.j == null) {
                this.j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(this, i2, i3, i4, str, i5, str2);
            cDNUpLoadTask.setParallel(this.j);
            cDNUpLoadTask.execute(new Object[0]);
            this.f50948c = true;
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("type", "start");
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertErrorData(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            Handler handler = this.l;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, str));
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertNormalData(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, str) == null) {
            Handler handler = this.l;
            handler.sendMessage(handler.obtainMessage(0, (int) j, 0, str));
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void setmCdnLogData(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            synchronized (m) {
                this.f50946a = sVar;
            }
        }
    }
}
