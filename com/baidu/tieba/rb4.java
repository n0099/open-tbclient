package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class rb4 extends z73 implements w83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static final Set<String> h;
    public static long i;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements uob<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ rb4 c;

        public a(rb4 rb4Var, boolean z, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb4Var, Boolean.valueOf(z), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rb4Var;
            this.a = z;
            this.b = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uob
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a) {
                    if (rb4.g) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + rb4.i);
                    }
                    a93.k().c(this.c, rb4.i);
                }
                jk2 d = lk2.c().d();
                if (d != null) {
                    List<String> singletonList = Collections.singletonList(this.b.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    ul2 l = ul2.l();
                    l.i(6);
                    d.h(singletonList, true, l.k());
                }
                if (rb4.g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d);
                }
                if (!this.a) {
                    this.c.h();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948115845, "Lcom/baidu/tieba/rb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948115845, "Lcom/baidu/tieba/rb4;");
                return;
            }
        }
        g = js1.a;
        h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        i = TimeUnit.SECONDS.toMillis(10L);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.a.getString("scheme");
            if (g) {
                Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
            }
            if (!TextUtils.isEmpty(string)) {
                SchemeRouter.invoke(AppRuntime.getAppContext(), string);
            }
        }
    }

    public rb4() {
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
        this.f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // com.baidu.tieba.w83
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (g) {
                Log.i("SwanGameReloadDelegate", "timeout");
            }
            h();
        }
    }

    @Override // com.baidu.tieba.w83
    public void a(String str, y83 y83Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, y83Var) == null) && y83Var.b.index == this.f && h.contains(str)) {
            a93.k().h(this);
            if (g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // com.baidu.tieba.z73
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (g) {
                Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f);
                Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
            }
            gob.h("").m(Schedulers.io()).y(new a(this, checkProcessId, bundle));
        }
    }
}
