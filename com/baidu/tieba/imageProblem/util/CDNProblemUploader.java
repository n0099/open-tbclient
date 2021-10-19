package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.n.a;
import c.a.q0.s.q.s;
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
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CDNProblemUploader extends ICDNProblemUploader {
    public static /* synthetic */ Interceptable $ic;
    public static Object m;
    public static volatile CDNProblemUploader n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public s f53713a;

    /* renamed from: b  reason: collision with root package name */
    public int f53714b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53715c;

    /* renamed from: d  reason: collision with root package name */
    public long f53716d;

    /* renamed from: e  reason: collision with root package name */
    public float f53717e;

    /* renamed from: f  reason: collision with root package name */
    public int f53718f;

    /* renamed from: g  reason: collision with root package name */
    public int f53719g;

    /* renamed from: h  reason: collision with root package name */
    public int f53720h;

    /* renamed from: i  reason: collision with root package name */
    public int f53721i;

    /* renamed from: j  reason: collision with root package name */
    public BdAsyncTaskParallel f53722j;
    public final CdnErrorJsonData k;
    public Handler l;

    /* loaded from: classes7.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final NetWork f53724a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53725b;

        /* renamed from: c  reason: collision with root package name */
        public final int f53726c;

        /* renamed from: d  reason: collision with root package name */
        public final String f53727d;

        /* renamed from: e  reason: collision with root package name */
        public final String f53728e;

        /* renamed from: f  reason: collision with root package name */
        public final int f53729f;

        /* renamed from: g  reason: collision with root package name */
        public final int f53730g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CDNProblemUploader f53731h;

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
            this.f53731h = cDNProblemUploader;
            this.f53724a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
            this.f53725b = i4;
            this.f53726c = i5;
            this.f53727d = str;
            this.f53728e = str2;
            this.f53729f = i2;
            this.f53730g = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.f53731h.getmCdnLogData() == null || !this.f53731h.getmCdnLogData().g() || this.f53729f == 0) {
                    return null;
                }
                this.f53724a.addPostData(IdCardActivity.KEY_NUMBER, String.valueOf(this.f53730g));
                int i2 = this.f53729f;
                if (i2 == 1) {
                    this.f53724a.addPostData("ab_num_error", String.valueOf(this.f53725b));
                    this.f53724a.addPostData("error", this.f53727d);
                    this.f53724a.addPostData("ab_num_slow", String.valueOf(this.f53726c));
                    this.f53724a.addPostData("time", this.f53728e);
                } else if (i2 == 3) {
                    NetWork netWork = this.f53724a;
                    netWork.addPostData("ab_num_slow", this.f53726c + "");
                    this.f53724a.addPostData("time", this.f53728e);
                } else if (i2 == 2) {
                    NetWork netWork2 = this.f53724a;
                    netWork2.addPostData("ab_num_error", this.f53725b + "");
                    this.f53724a.addPostData("error", this.f53727d);
                }
                String postNetData = this.f53724a.postNetData();
                if (this.f53724a.isNetSuccess() && !TextUtils.isEmpty(postNetData)) {
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
                    } else if (CDNProblemUploader.a(this.f53731h) >= 5) {
                        this.f53731h.f53713a.j(false);
                        this.f53731h.f53716d = System.currentTimeMillis();
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
                            this.f53731h.g();
                            this.f53731h.f53713a.j(false);
                            this.f53731h.f53716d = System.currentTimeMillis();
                        }
                        String optString = jSONObject.optString("photo_strategy");
                        s sVar = new s();
                        sVar.h(optString);
                        if (sVar.g() != this.f53731h.getmCdnLogData().g() || sVar.a() != this.f53731h.getmCdnLogData().a() || sVar.c() != this.f53731h.getmCdnLogData().c() || sVar.f() != this.f53731h.getmCdnLogData().f()) {
                            this.f53731h.setmCdnLogData(sVar);
                        }
                    }
                } finally {
                    this.f53731h.f53715c = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class CdnErrorJsonData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public StringBuffer f53732a;

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
            this.f53732a = new StringBuffer(100);
        }

        public void add(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f53732a.length() != 0) {
                    this.f53732a.append(",");
                }
                this.f53732a.append(i2);
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53732a.setLength(0);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53732a.toString() : (String) invokeV.objValue;
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
        this.f53714b = 0;
        this.f53715c = false;
        this.f53716d = 0L;
        this.f53717e = 0.0f;
        this.f53722j = null;
        this.l = null;
        this.k = new CdnErrorJsonData();
        this.l = new Handler(this) { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CDNProblemUploader f53723a;

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
                this.f53723a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 == 0) {
                        this.f53723a._insertNormalData(message.arg1, (String) message.obj);
                    } else if (i4 != 1) {
                    } else {
                        this.f53723a._insertErrorData(message.arg1, (String) message.obj);
                    }
                }
            }
        };
    }

    public static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i2 = cDNProblemUploader.f53714b + 1;
        cDNProblemUploader.f53714b = i2;
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
                    this.f53717e += 25.0f;
                } else {
                    this.f53717e += getmCdnLogData().b();
                }
                this.f53720h++;
                this.f53719g++;
                this.k.add(i2);
                int i4 = this.f53720h;
                int i5 = this.f53719g;
                int i6 = this.f53718f;
                int i7 = this.f53718f != 0 ? this.f53721i / this.f53718f : 0;
                String cdnErrorJsonData = this.k.toString();
                if (getmCdnLogData() != null && this.f53716d > 0 && System.currentTimeMillis() - this.f53716d > 86400000) {
                    getmCdnLogData().j(true);
                    this.f53714b = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().g()) {
                    if (this.f53720h >= 5) {
                        if (this.f53717e >= 100.0f && this.f53719g >= getmCdnLogData().a() && this.f53718f >= getmCdnLogData().c()) {
                            i3 = 1;
                        } else if (this.f53717e >= 100.0f && this.f53719g >= getmCdnLogData().a()) {
                            i3 = 2;
                        } else if (this.f53717e >= 100.0f && this.f53718f >= getmCdnLogData().c()) {
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

    public void _insertNormalData(long j2, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, str) == null) {
            int f2 = getmCdnLogData() != null ? getmCdnLogData().f() : 5000;
            synchronized (m) {
                if (j2 >= f2) {
                    if (getmCdnLogData() == null) {
                        this.f53717e += 10.0f;
                    } else {
                        this.f53717e += getmCdnLogData().d();
                    }
                    int i3 = this.f53718f + 1;
                    this.f53718f = i3;
                    int i4 = (int) (this.f53721i + j2);
                    this.f53721i = i4;
                    int i5 = this.f53720h + 1;
                    this.f53720h = i5;
                    int i6 = this.f53719g;
                    int i7 = i3 != 0 ? i4 / i3 : 0;
                    String cdnErrorJsonData = this.k.toString();
                    if (getmCdnLogData() != null && this.f53716d > 0 && System.currentTimeMillis() - this.f53716d > 86400000) {
                        getmCdnLogData().j(true);
                        this.f53714b = 0;
                    }
                    if (getmCdnLogData() != null && getmCdnLogData().g()) {
                        if (this.f53720h >= 5) {
                            if (this.f53717e >= 100.0f && this.f53719g >= getmCdnLogData().a() && this.f53718f >= getmCdnLogData().c()) {
                                i2 = 1;
                            } else if (this.f53717e >= 100.0f && this.f53719g >= getmCdnLogData().a()) {
                                i2 = 2;
                            } else if (this.f53717e >= 100.0f && this.f53718f >= getmCdnLogData().c()) {
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
                    this.f53717e -= 25.0f;
                } else {
                    this.f53717e -= getmCdnLogData().e();
                }
                if (this.f53717e < 0.0f) {
                    this.f53717e = 0.0f;
                }
            }
        }
    }

    public final void f(int i2, int i3, int i4, String str, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || getmCdnLogData() == null || !getmCdnLogData().g() || i2 == 0 || this.f53715c) {
            return;
        }
        h(i2, i3, i4, str, i5, i6 + "");
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f53720h = 0;
            this.f53718f = 0;
            this.f53719g = 0;
            this.f53721i = 0;
            this.f53717e = 0.0f;
            this.k.clear();
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public s getmCdnLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53713a : (s) invokeV.objValue;
    }

    public final void h(int i2, int i3, int i4, String str, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), str2}) == null) {
            if (this.f53722j == null) {
                this.f53722j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(this, i2, i3, i4, str, i5, str2);
            cDNUpLoadTask.setParallel(this.f53722j);
            cDNUpLoadTask.execute(new Object[0]);
            this.f53715c = true;
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
    public void insertNormalData(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j2, str) == null) {
            Handler handler = this.l;
            handler.sendMessage(handler.obtainMessage(0, (int) j2, 0, str));
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void setmCdnLogData(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            synchronized (m) {
                this.f53713a = sVar;
            }
        }
    }
}
