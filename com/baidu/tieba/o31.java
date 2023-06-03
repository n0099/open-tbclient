package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends lt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(p31 p31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p31Var;
        }

        @Override // com.baidu.tieba.jt0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                n31.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.kt0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kt0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                n31.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable p31 p31Var) {
        o51 o51Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p31Var) == null) && p31Var != null && !TextUtils.isEmpty(p31Var.d())) {
            st0 st0Var = new st0();
            st0Var.l(p31Var.d());
            st0Var.g(3000);
            st0Var.c();
            if (!TextUtils.isEmpty(p31Var.e)) {
                st0Var.d("User-Agent", p31Var.e);
            } else {
                st0Var.d("User-Agent", kk0.e());
            }
            zs0.b().a().a(st0Var, new a(p31Var));
            if (i51.a && (o51Var = (o51) h51.a().a(o51.class)) != null) {
                o51Var.b(new j51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        o51 o51Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        st0 st0Var = new st0();
        st0Var.l(str);
        st0Var.g(3000);
        st0Var.d("User-Agent", kk0.e());
        st0Var.c();
        zs0.b().a().a(st0Var, null);
        if (i51.a && (o51Var = (o51) h51.a().a(o51.class)) != null) {
            o51Var.b(new j51("计费", "", "并行计费"));
        }
    }
}
