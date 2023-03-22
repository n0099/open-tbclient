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
public class l11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ir0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(m11 m11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m11Var;
        }

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                k11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.hr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                k11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable m11 m11Var) {
        l31 l31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, m11Var) == null) && m11Var != null && !TextUtils.isEmpty(m11Var.d())) {
            pr0 pr0Var = new pr0();
            pr0Var.l(m11Var.d());
            pr0Var.g(3000);
            pr0Var.c();
            if (!TextUtils.isEmpty(m11Var.e)) {
                pr0Var.d("User-Agent", m11Var.e);
            } else {
                pr0Var.d("User-Agent", hi0.e());
            }
            wq0.b().a().a(pr0Var, new a(m11Var));
            if (f31.a && (l31Var = (l31) e31.a().a(l31.class)) != null) {
                l31Var.b(new g31("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        l31 l31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        pr0 pr0Var = new pr0();
        pr0Var.l(str);
        pr0Var.g(3000);
        pr0Var.d("User-Agent", hi0.e());
        pr0Var.c();
        wq0.b().a().a(pr0Var, null);
        if (f31.a && (l31Var = (l31) e31.a().a(l31.class)) != null) {
            l31Var.b(new g31("计费", "", "并行计费"));
        }
    }
}
