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
public class p11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends mr0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(q11 q11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q11Var;
        }

        @Override // com.baidu.tieba.kr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                o11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.lr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                o11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable q11 q11Var) {
        p31 p31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, q11Var) == null) && q11Var != null && !TextUtils.isEmpty(q11Var.d())) {
            tr0 tr0Var = new tr0();
            tr0Var.l(q11Var.d());
            tr0Var.g(3000);
            tr0Var.c();
            if (!TextUtils.isEmpty(q11Var.e)) {
                tr0Var.d("User-Agent", q11Var.e);
            } else {
                tr0Var.d("User-Agent", li0.e());
            }
            ar0.b().a().a(tr0Var, new a(q11Var));
            if (j31.a && (p31Var = (p31) i31.a().a(p31.class)) != null) {
                p31Var.b(new k31("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        p31 p31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        tr0 tr0Var = new tr0();
        tr0Var.l(str);
        tr0Var.g(3000);
        tr0Var.d("User-Agent", li0.e());
        tr0Var.c();
        ar0.b().a().a(tr0Var, null);
        if (j31.a && (p31Var = (p31) i31.a().a(p31.class)) != null) {
            p31Var.b(new k31("计费", "", "并行计费"));
        }
    }
}
