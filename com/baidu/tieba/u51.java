package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.AdWebActivity;
import com.baidu.nadcore.webview.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.h61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class u51 extends oi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.oi0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements h61.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ wi0 c;
        public final /* synthetic */ si0 d;
        public final /* synthetic */ u51 e;

        public a(u51 u51Var, Context context, HashMap hashMap, wi0 wi0Var, si0 si0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u51Var, context, hashMap, wi0Var, si0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u51Var;
            this.a = context;
            this.b = hashMap;
            this.c = wi0Var;
            this.d = si0Var;
        }

        @Override // com.baidu.tieba.h61.b
        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = u51.g(this.a, this.b);
                u51 u51Var = this.e;
                wi0 wi0Var = this.c;
                si0 si0Var = this.d;
                if (g) {
                    i = 0;
                } else {
                    i = 1001;
                }
                u51Var.c(wi0Var, si0Var, i, g);
            }
        }
    }

    public u51() {
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
            if (sg0.a) {
                x21.a().showToast(context, "启动SDK Webview");
            }
            if (!q51.a.b(hashMap, 0)) {
                return false;
            }
            if ("1".equals(hashMap.remove("newbrowser"))) {
                cls = AdWebActivityStandard.class;
            } else {
                cls = AdWebActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return l31.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.oi0
    public boolean b(@NonNull Context context, @NonNull si0 si0Var, @Nullable Map<String, Object> map, @Nullable wi0 wi0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, si0Var, map, wi0Var)) == null) {
            super.b(context, si0Var, map, wi0Var);
            HashMap<String, String> d = si0Var.d();
            int b = v51.b(context.getApplicationContext(), new a(this, context, d, wi0Var, si0Var));
            int i = 0;
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    if (!g) {
                        i = 1001;
                    }
                    c(wi0Var, si0Var, i, g);
                }
                return true;
            }
            c(wi0Var, si0Var, 1001, false);
            if (!sg0.a) {
                return true;
            }
            throw new IllegalStateException("web app init failed, state=" + b);
        }
        return invokeLLLL.booleanValue;
    }
}
