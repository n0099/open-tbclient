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
public class u31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends jt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(v31 v31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v31Var;
        }

        @Override // com.baidu.tieba.ht0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                t31.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.it0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                t31.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable v31 v31Var) {
        x51 x51Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, v31Var) == null) && v31Var != null && !TextUtils.isEmpty(v31Var.d())) {
            qt0 qt0Var = new qt0();
            qt0Var.l(v31Var.d());
            qt0Var.g(3000);
            qt0Var.c();
            if (!TextUtils.isEmpty(v31Var.e)) {
                qt0Var.d("User-Agent", v31Var.e);
            } else {
                qt0Var.d("User-Agent", sj0.e());
            }
            xs0.b().a().a(qt0Var, new a(v31Var));
            if (q51.a && (x51Var = (x51) p51.a().a(x51.class)) != null) {
                x51Var.b(new r51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        x51 x51Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        qt0 qt0Var = new qt0();
        qt0Var.l(str);
        qt0Var.g(3000);
        qt0Var.d("User-Agent", sj0.e());
        qt0Var.c();
        xs0.b().a().a(qt0Var, null);
        if (q51.a && (x51Var = (x51) p51.a().a(x51.class)) != null) {
            x51Var.b(new r51("计费", "", "并行计费"));
        }
    }
}
