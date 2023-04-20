package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends kr0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(o11 o11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o11Var;
        }

        @Override // com.baidu.tieba.ir0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                m11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.jr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                m11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable o11 o11Var) {
        n31 n31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, o11Var) == null) && o11Var != null && !TextUtils.isEmpty(o11Var.d())) {
            rr0 rr0Var = new rr0();
            rr0Var.l(o11Var.d());
            rr0Var.g(3000);
            rr0Var.c();
            if (!TextUtils.isEmpty(o11Var.e)) {
                rr0Var.d("User-Agent", o11Var.e);
            } else {
                rr0Var.d("User-Agent", ji0.e());
            }
            yq0.b().a().a(rr0Var, new a(o11Var));
            if (h31.a && (n31Var = (n31) g31.a().a(n31.class)) != null) {
                n31Var.b(new i31("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        n31 n31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        rr0 rr0Var = new rr0();
        rr0Var.l(str);
        rr0Var.g(3000);
        rr0Var.d("User-Agent", ji0.e());
        rr0Var.c();
        yq0.b().a().a(rr0Var, null);
        if (h31.a && (n31Var = (n31) g31.a().a(n31.class)) != null) {
            n31Var.b(new i31("计费", "", "并行计费"));
        }
    }
}
