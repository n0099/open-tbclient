package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uw8 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public volatile boolean b;
    public long c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final uw8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361032459, "Lcom/baidu/tieba/uw8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361032459, "Lcom/baidu/tieba/uw8$b;");
                    return;
                }
            }
            a = new uw8(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948225523, "Lcom/baidu/tieba/uw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948225523, "Lcom/baidu/tieba/uw8;");
                return;
            }
        }
        d = jw8.a;
        e = uw8.class.getSimpleName();
    }

    public static uw8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (uw8) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.b || System.currentTimeMillis() - this.c > 172800000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public uw8() {
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
        String b2 = kw8.b("fulllog_switch", null);
        if (!TextUtils.isEmpty(b2)) {
            this.b = Boolean.valueOf(b2).booleanValue();
        }
        this.c = Long.parseLong(kw8.b("fulllog_switch_push_time", Long.toString(System.currentTimeMillis())));
    }

    public /* synthetic */ uw8(a aVar) {
        this();
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Logger logger = LoggerManager.getLogger("net");
            logger.e("1809", "netLog", str);
            logger.flush(true);
            if (g()) {
                e(false);
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && g()) {
            Logger logger = LoggerManager.getLogger("net");
            logger.d("1809", "netLog", str);
            logger.flush(true);
            e(false);
        }
    }

    public final boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j - this.a > 60000) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean d2 = d(currentTimeMillis);
            if (d2) {
                this.a = currentTimeMillis;
            }
            if (z || d2) {
                String b2 = kw8.b("fulllog_switch_push_time", Long.toString(System.currentTimeMillis()));
                ArrayList arrayList = new ArrayList();
                arrayList.add("net");
                IUploadTask iUploadTask = (IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE);
                if (iUploadTask != null) {
                    long j = currentTimeMillis - 5184000000L;
                    long j2 = currentTimeMillis + 3600000;
                    iUploadTask.activeUploadSnapShot("netLog", b2, arrayList, null, com.baidu.down.utils.Constants.TEST_SPEED_THRESHOLD_DEFAULT, j, j2, true, null);
                    if (d) {
                        String str = e;
                        Log.i(str, "dataId" + b2 + "   isMatchTimeInterval(curTime) == true");
                        String str2 = e;
                        Log.i(str2, "startTime==" + j + "endTime==" + j2);
                    }
                }
            }
        }
    }

    public boolean f(NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, networkStatRecord)) == null) {
            int c = kw8.c();
            if (networkStatRecord.exception == null && networkStatRecord.receiveHeaderTs - networkStatRecord.sendHeaderTs < c && networkStatRecord.realResponseLength <= 1048576 && networkStatRecord.requestBodyLength <= 1048576) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean h(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jSONObject, jSONObject2)) == null) {
            synchronized (this) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("type");
                    String optString2 = jSONObject.optString("fulllog");
                    if (TextUtils.equals(optString, "fulllog_network")) {
                        if (TextUtils.equals(optString2, "1")) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.a = currentTimeMillis;
                            this.c = currentTimeMillis;
                            this.b = true;
                            e(true);
                            if (d) {
                                Log.i(e, "Start online real full network log!");
                            }
                            kw8.e("fulllog_switch_push_time", Long.toString(System.currentTimeMillis()));
                        } else if (TextUtils.equals(optString2, "0")) {
                            this.b = false;
                            if (d) {
                                Log.i(e, "Stop online real full network log!");
                            }
                        }
                        kw8.e("fulllog_switch", String.valueOf(this.b));
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
