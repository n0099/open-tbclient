package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends mt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(y31 y31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y31Var;
        }

        @Override // com.baidu.tieba.kt0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                w31.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.lt0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lt0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                w31.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable y31 y31Var) {
        a61 a61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, y31Var) == null) && y31Var != null && !TextUtils.isEmpty(y31Var.d())) {
            tt0 tt0Var = new tt0();
            tt0Var.l(y31Var.d());
            tt0Var.g(3000);
            tt0Var.c();
            if (!TextUtils.isEmpty(y31Var.e)) {
                tt0Var.d("User-Agent", y31Var.e);
            } else {
                tt0Var.d("User-Agent", sj0.e());
            }
            at0.b().a().a(tt0Var, new a(y31Var));
            if (t51.a && (a61Var = (a61) s51.a().a(a61.class)) != null) {
                a61Var.b(new u51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        a61 a61Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        tt0 tt0Var = new tt0();
        tt0Var.l(str);
        tt0Var.g(3000);
        tt0Var.d("User-Agent", sj0.e());
        tt0Var.c();
        at0.b().a().a(tt0Var, null);
        if (t51.a && (a61Var = (a61) s51.a().a(a61.class)) != null) {
            a61Var.b(new u51("计费", "", "并行计费"));
        }
    }
}
