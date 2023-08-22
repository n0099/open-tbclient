package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class zd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<bk4, Set<c>> a;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, wm3 wm3Var);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static zd2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235612349, "Lcom/baidu/tieba/zd2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235612349, "Lcom/baidu/tieba/zd2$b;");
                    return;
                }
            }
            a = new zd2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356033, "Lcom/baidu/tieba/zd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356033, "Lcom/baidu/tieba/zd2;");
                return;
            }
        }
        b = nr1.a;
    }

    public zd2() {
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
        this.a = new HashMap<>();
    }

    public static zd2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (zd2) invokeV.objValue;
    }

    public /* synthetic */ zd2(a aVar) {
        this();
    }

    public synchronized void a(bk4 bk4Var, PMSDownloadType pMSDownloadType, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bk4Var, pMSDownloadType, wm3Var) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + bk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(bk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.b(pMSDownloadType, wm3Var);
                        }
                    }
                    this.a.remove(bk4Var);
                }
            }
        }
    }

    public synchronized void b(bk4 bk4Var, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bk4Var, pMSDownloadType) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + bk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(bk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(bk4Var);
                }
            }
        }
    }

    public synchronized void d(bk4 bk4Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bk4Var, cVar) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + bk4Var);
                }
                if (bk4Var != null && cVar != null) {
                    Set<c> set = this.a.get(bk4Var);
                    if (set != null) {
                        set.add(cVar);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(cVar);
                        this.a.put(bk4Var, hashSet);
                    }
                }
            }
        }
    }
}
