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
public class m11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends jr0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(n11 n11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n11Var;
        }

        @Override // com.baidu.tieba.hr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                l11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.ir0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ir0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                l11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable n11 n11Var) {
        m31 m31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, n11Var) == null) && n11Var != null && !TextUtils.isEmpty(n11Var.d())) {
            qr0 qr0Var = new qr0();
            qr0Var.l(n11Var.d());
            qr0Var.g(3000);
            qr0Var.c();
            if (!TextUtils.isEmpty(n11Var.e)) {
                qr0Var.d("User-Agent", n11Var.e);
            } else {
                qr0Var.d("User-Agent", ii0.e());
            }
            xq0.b().a().a(qr0Var, new a(n11Var));
            if (g31.a && (m31Var = (m31) f31.a().a(m31.class)) != null) {
                m31Var.b(new h31("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        m31 m31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        qr0 qr0Var = new qr0();
        qr0Var.l(str);
        qr0Var.g(3000);
        qr0Var.d("User-Agent", ii0.e());
        qr0Var.c();
        xq0.b().a().a(qr0Var, null);
        if (g31.a && (m31Var = (m31) f31.a().a(m31.class)) != null) {
            m31Var.b(new h31("计费", "", "并行计费"));
        }
    }
}
