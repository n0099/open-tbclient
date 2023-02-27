package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ss0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w21 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(w21 w21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w21Var;
        }

        @Override // com.baidu.tieba.qs0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                u21.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.rs0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rs0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                u21.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable w21 w21Var) {
        v41 v41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, w21Var) == null) && w21Var != null && !TextUtils.isEmpty(w21Var.d())) {
            zs0 zs0Var = new zs0();
            zs0Var.l(w21Var.d());
            zs0Var.g(3000);
            zs0Var.c();
            if (!TextUtils.isEmpty(w21Var.e)) {
                zs0Var.d("User-Agent", w21Var.e);
            } else {
                zs0Var.d("User-Agent", rj0.e());
            }
            gs0.b().a().a(zs0Var, new a(w21Var));
            if (p41.a && (v41Var = (v41) o41.a().a(v41.class)) != null) {
                v41Var.b(new q41("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        v41 v41Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        zs0 zs0Var = new zs0();
        zs0Var.l(str);
        zs0Var.g(3000);
        zs0Var.d("User-Agent", rj0.e());
        zs0Var.c();
        gs0.b().a().a(zs0Var, null);
        if (p41.a && (v41Var = (v41) o41.a().a(v41.class)) != null) {
            v41Var.b(new q41("计费", "", "并行计费"));
        }
    }
}
