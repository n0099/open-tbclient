package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webviewx.AdWebActivity;
import com.baidu.nadcore.webviewx.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.wb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class kb1 extends vj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements wb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ dk0 c;
        public final /* synthetic */ zj0 d;
        public final /* synthetic */ kb1 e;

        public a(kb1 kb1Var, Context context, HashMap hashMap, dk0 dk0Var, zj0 zj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb1Var, context, hashMap, dk0Var, zj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kb1Var;
            this.a = context;
            this.b = hashMap;
            this.c = dk0Var;
            this.d = zj0Var;
        }

        @Override // com.baidu.tieba.wb1.b
        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = kb1.g(this.a, this.b);
                kb1 kb1Var = this.e;
                dk0 dk0Var = this.c;
                zj0 zj0Var = this.d;
                if (g) {
                    i = 0;
                } else {
                    i = 1001;
                }
                kb1Var.c(dk0Var, zj0Var, i, g);
            }
        }
    }

    public kb1() {
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
            if (wh0.a) {
                h51.a().showToast(context, "启动SDK Webview");
            }
            if (!hb1.a.a(hashMap, 0)) {
                return false;
            }
            if ("1".equals(hashMap.remove("newbrowser"))) {
                cls = AdWebActivityStandard.class;
            } else {
                cls = AdWebActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return v51.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.vj0
    public boolean b(@NonNull Context context, @NonNull zj0 zj0Var, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zj0Var, map, dk0Var)) == null) {
            super.b(context, zj0Var, map, dk0Var);
            HashMap<String, String> d = zj0Var.d();
            int b = lb1.b(context.getApplicationContext(), new a(this, context, d, dk0Var, zj0Var));
            int i = 0;
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    if (!g) {
                        i = 1001;
                    }
                    c(dk0Var, zj0Var, i, g);
                }
                return true;
            }
            c(dk0Var, zj0Var, 1001, false);
            if (!wh0.a) {
                return true;
            }
            throw new IllegalStateException("web app init failed, state=" + b);
        }
        return invokeLLLL.booleanValue;
    }
}
