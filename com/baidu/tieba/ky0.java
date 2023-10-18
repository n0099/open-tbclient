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
public class ky0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends jo0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly0 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(ly0 ly0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly0Var;
        }

        @Override // com.baidu.tieba.ho0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                jy0.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.io0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.io0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                jy0.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable ly0 ly0Var) {
        n01 n01Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ly0Var) == null) && ly0Var != null && !TextUtils.isEmpty(ly0Var.d())) {
            qo0 qo0Var = new qo0();
            qo0Var.l(ly0Var.d());
            qo0Var.g(3000);
            qo0Var.c();
            if (!TextUtils.isEmpty(ly0Var.e)) {
                qo0Var.d("User-Agent", ly0Var.e);
            } else {
                qo0Var.d("User-Agent", pe0.e());
            }
            xn0.b().a().a(qo0Var, new a(ly0Var));
            if (g01.a && (n01Var = (n01) f01.a().a(n01.class)) != null) {
                n01Var.b(new h01("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        n01 n01Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        qo0 qo0Var = new qo0();
        qo0Var.l(str);
        qo0Var.g(3000);
        qo0Var.d("User-Agent", pe0.e());
        qo0Var.c();
        xn0.b().a().a(qo0Var, null);
        if (g01.a && (n01Var = (n01) f01.a().a(n01.class)) != null) {
            n01Var.b(new h01("计费", "", "并行计费"));
        }
    }
}
