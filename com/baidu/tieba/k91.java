package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webviewx.AdWebActivity;
import com.baidu.nadcore.webviewx.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.w91;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class k91 extends vh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements w91.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ di0 c;
        public final /* synthetic */ zh0 d;
        public final /* synthetic */ k91 e;

        public a(k91 k91Var, Context context, HashMap hashMap, di0 di0Var, zh0 zh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k91Var, context, hashMap, di0Var, zh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k91Var;
            this.a = context;
            this.b = hashMap;
            this.c = di0Var;
            this.d = zh0Var;
        }

        @Override // com.baidu.tieba.w91.b
        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = k91.g(this.a, this.b);
                k91 k91Var = this.e;
                di0 di0Var = this.c;
                zh0 zh0Var = this.d;
                if (g) {
                    i = 0;
                } else {
                    i = 1001;
                }
                k91Var.c(di0Var, zh0Var, i, g);
            }
        }
    }

    public k91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean g(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (wf0.a) {
                h31.a().showToast(context, "启动SDK Webview");
            }
            if (!h91.a.a(hashMap, 0)) {
                return false;
            }
            if ("1".equals(hashMap.remove("newbrowser"))) {
                cls = AdWebActivityStandard.class;
            } else {
                cls = AdWebActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return v31.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.vh0
    public boolean b(@NonNull Context context, @NonNull zh0 zh0Var, @Nullable Map<String, Object> map, @Nullable di0 di0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zh0Var, map, di0Var)) == null) {
            super.b(context, zh0Var, map, di0Var);
            HashMap<String, String> d = zh0Var.d();
            int b = l91.b(context.getApplicationContext(), new a(this, context, d, di0Var, zh0Var));
            int i = 0;
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    if (!g) {
                        i = 1001;
                    }
                    c(di0Var, zh0Var, i, g);
                }
                return true;
            }
            c(di0Var, zh0Var, 1001, false);
            if (!wf0.a) {
                return true;
            }
            throw new IllegalStateException("web app init failed, state=" + b);
        }
        return invokeLLLL.booleanValue;
    }
}
