package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8NetFunctionTable;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestSettings;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.ph3;
import com.baidu.tieba.sb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ValueCallback<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ V8Engine a;

        /* renamed from: com.baidu.tieba.r02$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0472a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0472a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetRequest netRequest = new NetRequest();
                    NetRequestSettings netRequestSettings = new NetRequestSettings();
                    netRequestSettings.mTimeout = 60000;
                    boolean z = true;
                    netRequestSettings.mShouldNeverClearReferer = true;
                    netRequestSettings.mLoadDoNotSendCookies = true;
                    netRequest.setRequestInterceptor(new q02());
                    netRequest.setRedirectInterceptor(new x02());
                    netRequest.addObserver(new s02());
                    netRequest.setNetRequestSettings(netRequestSettings);
                    int javaNetRequest = this.a.a.setJavaNetRequest(netRequest);
                    if (javaNetRequest != 0) {
                        z = false;
                    }
                    boolean unused = r02.c = z;
                    if (!r02.c) {
                        int unused2 = r02.b = 0;
                        r02.g(javaNetRequest);
                        h82.c("ChromeNetManager", "setJavaNetRequest fail, code=" + javaNetRequest);
                    }
                }
            }
        }

        public a(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Engine};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v8Engine;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                this.a.runOnJSThread(new RunnableC0472a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ph3.b bVar = new ph3.b(SessionCommand.COMMAND_CODE_PLAYER_GET_CURRENT_MEDIA_ITEM);
                bVar.l(String.valueOf(this.a));
                bVar.h(gb3.K().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067733, "Lcom/baidu/tieba/r02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067733, "Lcom/baidu/tieba/r02;");
                return;
            }
        }
        a = rr1.a;
        b = -1;
        c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (un3.e() && h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (ou2.g0().y() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (ou2.g0().y() >= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void f(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, v8Engine) == null) {
            if (!d()) {
                h82.k("ChromeNetManager", "Not Used ChromeNet");
            } else {
                V8NetFunctionTable.addOnCronetThreadInitializedListener(new a(v8Engine));
            }
        }
    }

    public static void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            bo3.f().execute(new b(i));
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (b == -1) {
                if (j() && !wo3.f("3.300.0")) {
                    i = 1;
                } else {
                    i = 0;
                }
                b = i;
            }
            if (b != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void k(@Nullable SwanAppConfigData swanAppConfigData) {
        sb3.a aVar;
        int i;
        dd2 W;
        NetRequest m0;
        NetRequestSettings netRequestSettings;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, swanAppConfigData) == null) && d() && swanAppConfigData != null && (aVar = swanAppConfigData.h) != null && (i = aVar.b) > 0 && (W = bi2.U().W()) != null && (W.e() instanceof pi2) && (m0 = ((pi2) W.e()).m0()) != null && (netRequestSettings = m0.getNetRequestSettings()) != null) {
            netRequestSettings.mTimeout = i;
            if (a) {
                Log.d("ChromeNetManager", "settings.mTimeout=" + i);
            }
        }
    }
}
