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
public class o21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ms0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p21 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(p21 p21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p21Var;
        }

        @Override // com.baidu.tieba.ks0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                n21.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.ls0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ls0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                n21.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable p21 p21Var) {
        o41 o41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p21Var) == null) && p21Var != null && !TextUtils.isEmpty(p21Var.d())) {
            if (!p21Var.c()) {
                b(p21Var.d());
                return;
            }
            ts0 ts0Var = new ts0();
            ts0Var.l(p21Var.d());
            ts0Var.g(3000);
            ts0Var.d("User-Agent", nj0.e());
            ts0Var.c();
            as0.b().a().a(ts0Var, new a(p21Var));
            if (i41.a && (o41Var = (o41) h41.a().a(o41.class)) != null) {
                o41Var.b(new j41("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        o41 o41Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ts0 ts0Var = new ts0();
        ts0Var.l(str);
        ts0Var.g(3000);
        ts0Var.d("User-Agent", nj0.e());
        ts0Var.c();
        as0.b().a().a(ts0Var, null);
        if (i41.a && (o41Var = (o41) h41.a().a(o41.class)) != null) {
            o41Var.b(new j41("计费", "", "并行计费"));
        }
    }
}
