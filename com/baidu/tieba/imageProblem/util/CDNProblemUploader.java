package com.baidu.tieba.imageProblem.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.io4;
import com.repackage.ug;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CDNProblemUploader extends ICDNProblemUploader {
    public static /* synthetic */ Interceptable $ic;
    public static Object m;
    public static volatile CDNProblemUploader n;
    public transient /* synthetic */ FieldHolder $fh;
    public io4 a;
    public int b;
    public boolean c;
    public long d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public BdAsyncTaskParallel j;
    public final CdnErrorJsonData k;
    public Handler l;

    /* loaded from: classes3.dex */
    public class CDNUpLoadTask extends BdAsyncTask<Object, Integer, JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NetWork a;
        public final int b;
        public final int c;
        public final String d;
        public final String e;
        public final int f;
        public final int g;
        public final /* synthetic */ CDNProblemUploader h;

        public CDNUpLoadTask(CDNProblemUploader cDNProblemUploader, int i, int i2, int i3, String str, int i4, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNProblemUploader, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = cDNProblemUploader;
            this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
            this.b = i3;
            this.c = i4;
            this.d = str;
            this.e = str2;
            this.f = i;
            this.g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.h.getmCdnLogData() == null || !this.h.getmCdnLogData().g() || this.f == 0) {
                    return null;
                }
                this.a.addPostData("number", String.valueOf(this.g));
                int i = this.f;
                if (i == 1) {
                    this.a.addPostData("ab_num_error", String.valueOf(this.b));
                    this.a.addPostData("error", this.d);
                    this.a.addPostData("ab_num_slow", String.valueOf(this.c));
                    this.a.addPostData("time", this.e);
                } else if (i == 3) {
                    NetWork netWork = this.a;
                    netWork.addPostData("ab_num_slow", this.c + "");
                    this.a.addPostData("time", this.e);
                } else if (i == 2) {
                    NetWork netWork2 = this.a;
                    netWork2.addPostData("ab_num_error", this.b + "");
                    this.a.addPostData("error", this.d);
                }
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess() && !TextUtils.isEmpty(postNetData)) {
                    try {
                        return new JSONObject(postNetData);
                    } catch (JSONException e) {
                        BdLog.e(e.getMessage());
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
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    if (jSONObject == null) {
                        ug logItem = ImageLogger.getLogItem();
                        logItem.b("act", "fallback");
                        logItem.b("result", "1");
                        logItem.b("type", "end");
                        BdStatisticsManager.getInstance().debug("img", logItem);
                    } else if (CDNProblemUploader.a(this.h) >= 5) {
                        this.h.a.j(false);
                        this.h.d = System.currentTimeMillis();
                    } else {
                        if (jSONObject.optJSONObject(Constants.KEYS.RET).optInt("err_no", -1) != 0) {
                            ug logItem2 = ImageLogger.getLogItem();
                            logItem2.b("act", "fallback");
                            logItem2.b("result", "2");
                            logItem2.b("type", "end");
                            BdStatisticsManager.getInstance().debug("img", logItem2);
                        } else {
                            ug logItem3 = ImageLogger.getLogItem();
                            logItem3.b("act", "fallback");
                            logItem3.b("result", "0");
                            logItem3.b("type", "end");
                            BdStatisticsManager.getInstance().debug("img", logItem3);
                            this.h.g();
                            this.h.a.j(false);
                            this.h.d = System.currentTimeMillis();
                        }
                        String optString = jSONObject.optString("photo_strategy");
                        io4 io4Var = new io4();
                        io4Var.h(optString);
                        if (io4Var.g() != this.h.getmCdnLogData().g() || io4Var.a() != this.h.getmCdnLogData().a() || io4Var.c() != this.h.getmCdnLogData().c() || io4Var.f() != this.h.getmCdnLogData().f()) {
                            this.h.setmCdnLogData(io4Var);
                        }
                    }
                } finally {
                    this.h.c = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class CdnErrorJsonData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuffer a;

        public CdnErrorJsonData(CDNProblemUploader cDNProblemUploader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNProblemUploader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new StringBuffer(100);
        }

        public void add(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.length() != 0) {
                    this.a.append(",");
                }
                this.a.append(i);
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.setLength(0);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
        this.d = 0L;
        this.e = 0.0f;
        this.j = null;
        this.l = null;
        this.k = new CdnErrorJsonData();
        this.l = new Handler(this) { // from class: com.baidu.tieba.imageProblem.util.CDNProblemUploader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CDNProblemUploader a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i3 = message.what;
                    if (i3 == 0) {
                        this.a._insertNormalData(message.arg1, (String) message.obj);
                    } else if (i3 != 1) {
                    } else {
                        this.a._insertErrorData(message.arg1, (String) message.obj);
                    }
                }
            }
        };
    }

    public static /* synthetic */ int a(CDNProblemUploader cDNProblemUploader) {
        int i = cDNProblemUploader.b + 1;
        cDNProblemUploader.b = i;
        return i;
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

    public void _insertErrorData(int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            synchronized (m) {
                if (getmCdnLogData() == null) {
                    this.e += 25.0f;
                } else {
                    this.e += getmCdnLogData().b();
                }
                this.h++;
                this.g++;
                this.k.add(i);
                int i3 = this.h;
                int i4 = this.g;
                int i5 = this.f;
                int i6 = this.f != 0 ? this.i / this.f : 0;
                String cdnErrorJsonData = this.k.toString();
                if (getmCdnLogData() != null && this.d > 0 && System.currentTimeMillis() - this.d > 86400000) {
                    getmCdnLogData().j(true);
                    this.b = 0;
                }
                if (getmCdnLogData() != null && getmCdnLogData().g()) {
                    if (this.h >= 5) {
                        if (this.e >= 100.0f && this.g >= getmCdnLogData().a() && this.f >= getmCdnLogData().c()) {
                            i2 = 1;
                        } else if (this.e >= 100.0f && this.g >= getmCdnLogData().a()) {
                            i2 = 2;
                        } else if (this.e >= 100.0f && this.f >= getmCdnLogData().c()) {
                            i2 = 3;
                        }
                        f(i2, i3, i4, cdnErrorJsonData, i5, i6);
                    }
                    i2 = 0;
                    f(i2, i3, i4, cdnErrorJsonData, i5, i6);
                }
            }
        }
    }

    public void _insertNormalData(long j, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
            int f = getmCdnLogData() != null ? getmCdnLogData().f() : 5000;
            synchronized (m) {
                if (j >= f) {
                    if (getmCdnLogData() == null) {
                        this.e += 10.0f;
                    } else {
                        this.e += getmCdnLogData().d();
                    }
                    int i2 = this.f + 1;
                    this.f = i2;
                    int i3 = (int) (this.i + j);
                    this.i = i3;
                    int i4 = this.h + 1;
                    this.h = i4;
                    int i5 = this.g;
                    int i6 = i2 != 0 ? i3 / i2 : 0;
                    String cdnErrorJsonData = this.k.toString();
                    if (getmCdnLogData() != null && this.d > 0 && System.currentTimeMillis() - this.d > 86400000) {
                        getmCdnLogData().j(true);
                        this.b = 0;
                    }
                    if (getmCdnLogData() != null && getmCdnLogData().g()) {
                        if (this.h >= 5) {
                            if (this.e >= 100.0f && this.g >= getmCdnLogData().a() && this.f >= getmCdnLogData().c()) {
                                i = 1;
                            } else if (this.e >= 100.0f && this.g >= getmCdnLogData().a()) {
                                i = 2;
                            } else if (this.e >= 100.0f && this.f >= getmCdnLogData().c()) {
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
                    this.e -= 25.0f;
                } else {
                    this.e -= getmCdnLogData().e();
                }
                if (this.e < 0.0f) {
                    this.e = 0.0f;
                }
            }
        }
    }

    public final void f(int i, int i2, int i3, String str, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || getmCdnLogData() == null || !getmCdnLogData().g() || i == 0 || this.c) {
            return;
        }
        h(i, i2, i3, str, i4, i5 + "");
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h = 0;
            this.f = 0;
            this.g = 0;
            this.i = 0;
            this.e = 0.0f;
            this.k.clear();
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public io4 getmCdnLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (io4) invokeV.objValue;
    }

    public final void h(int i, int i2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
            if (this.j == null) {
                this.j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            CDNUpLoadTask cDNUpLoadTask = new CDNUpLoadTask(this, i, i2, i3, str, i4, str2);
            cDNUpLoadTask.setParallel(this.j);
            cDNUpLoadTask.execute(new Object[0]);
            this.c = true;
            ug logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("type", "start");
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    @Override // com.baidu.tbadk.core.util.ICDNProblemUploader
    public void insertErrorData(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            Handler handler = this.l;
            handler.sendMessage(handler.obtainMessage(1, i, 0, str));
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
    public void setmCdnLogData(io4 io4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, io4Var) == null) {
            synchronized (m) {
                this.a = io4Var;
            }
        }
    }
}
