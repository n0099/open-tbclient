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
public class y31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends nt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(z31 z31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z31Var;
        }

        @Override // com.baidu.tieba.lt0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                x31.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.mt0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mt0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                x31.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable z31 z31Var) {
        b61 b61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, z31Var) == null) && z31Var != null && !TextUtils.isEmpty(z31Var.d())) {
            ut0 ut0Var = new ut0();
            ut0Var.l(z31Var.d());
            ut0Var.g(3000);
            ut0Var.c();
            if (!TextUtils.isEmpty(z31Var.e)) {
                ut0Var.d("User-Agent", z31Var.e);
            } else {
                ut0Var.d("User-Agent", tj0.e());
            }
            bt0.b().a().a(ut0Var, new a(z31Var));
            if (u51.a && (b61Var = (b61) t51.a().a(b61.class)) != null) {
                b61Var.b(new v51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        b61 b61Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ut0 ut0Var = new ut0();
        ut0Var.l(str);
        ut0Var.g(3000);
        ut0Var.d("User-Agent", tj0.e());
        ut0Var.c();
        bt0.b().a().a(ut0Var, null);
        if (u51.a && (b61Var = (b61) t51.a().a(b61.class)) != null) {
            b61Var.b(new v51("计费", "", "并行计费"));
        }
    }
}
