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
/* loaded from: classes7.dex */
public class re2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<tk4, Set<c>> a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, on3 on3Var);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static re2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-463722036, "Lcom/baidu/tieba/re2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-463722036, "Lcom/baidu/tieba/re2$b;");
                    return;
                }
            }
            a = new re2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118666, "Lcom/baidu/tieba/re2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118666, "Lcom/baidu/tieba/re2;");
                return;
            }
        }
        b = fs1.a;
    }

    public re2() {
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

    public static re2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (re2) invokeV.objValue;
    }

    public /* synthetic */ re2(a aVar) {
        this();
    }

    public synchronized void a(tk4 tk4Var, PMSDownloadType pMSDownloadType, on3 on3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, tk4Var, pMSDownloadType, on3Var) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + tk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(tk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.b(pMSDownloadType, on3Var);
                        }
                    }
                    this.a.remove(tk4Var);
                }
            }
        }
    }

    public synchronized void b(tk4 tk4Var, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tk4Var, pMSDownloadType) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + tk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(tk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(tk4Var);
                }
            }
        }
    }

    public synchronized void d(tk4 tk4Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tk4Var, cVar) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + tk4Var);
                }
                if (tk4Var != null && cVar != null) {
                    Set<c> set = this.a.get(tk4Var);
                    if (set != null) {
                        set.add(cVar);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(cVar);
                        this.a.put(tk4Var, hashSet);
                    }
                }
            }
        }
    }
}
