package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webviewx.AdWebActivity;
import com.baidu.nadcore.webviewx.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.cb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class qa1 extends bj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements cb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ jj0 c;
        public final /* synthetic */ fj0 d;
        public final /* synthetic */ qa1 e;

        public a(qa1 qa1Var, Context context, HashMap hashMap, jj0 jj0Var, fj0 fj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var, context, hashMap, jj0Var, fj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qa1Var;
            this.a = context;
            this.b = hashMap;
            this.c = jj0Var;
            this.d = fj0Var;
        }

        @Override // com.baidu.tieba.cb1.b
        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = qa1.g(this.a, this.b);
                qa1 qa1Var = this.e;
                jj0 jj0Var = this.c;
                fj0 fj0Var = this.d;
                if (g) {
                    i = 0;
                } else {
                    i = 1001;
                }
                qa1Var.c(jj0Var, fj0Var, i, g);
            }
        }
    }

    public qa1() {
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
            if (ch0.a) {
                n41.a().showToast(context, "启动SDK Webview");
            }
            if (!na1.a.a(hashMap, 0)) {
                return false;
            }
            if ("1".equals(hashMap.remove("newbrowser"))) {
                cls = AdWebActivityStandard.class;
            } else {
                cls = AdWebActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return b51.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.bj0
    public boolean b(@NonNull Context context, @NonNull fj0 fj0Var, @Nullable Map<String, Object> map, @Nullable jj0 jj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fj0Var, map, jj0Var)) == null) {
            super.b(context, fj0Var, map, jj0Var);
            HashMap<String, String> d = fj0Var.d();
            int b = ra1.b(context.getApplicationContext(), new a(this, context, d, jj0Var, fj0Var));
            int i = 0;
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    if (!g) {
                        i = 1001;
                    }
                    c(jj0Var, fj0Var, i, g);
                }
                return true;
            }
            c(jj0Var, fj0Var, 1001, false);
            if (!ch0.a) {
                return true;
            }
            throw new IllegalStateException("web app init failed, state=" + b);
        }
        return invokeLLLL.booleanValue;
    }
}
