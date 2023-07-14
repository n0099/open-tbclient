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
public class o41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends du0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p41 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(p41 p41Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p41Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p41Var;
        }

        @Override // com.baidu.tieba.bu0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                n41.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.cu0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cu0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                n41.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable p41 p41Var) {
        p61 p61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p41Var) == null) && p41Var != null && !TextUtils.isEmpty(p41Var.d())) {
            ku0 ku0Var = new ku0();
            ku0Var.l(p41Var.d());
            ku0Var.g(3000);
            ku0Var.c();
            if (!TextUtils.isEmpty(p41Var.e)) {
                ku0Var.d("User-Agent", p41Var.e);
            } else {
                ku0Var.d("User-Agent", rk0.e());
            }
            rt0.b().a().a(ku0Var, new a(p41Var));
            if (i61.a && (p61Var = (p61) h61.a().a(p61.class)) != null) {
                p61Var.b(new j61("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        p61 p61Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ku0 ku0Var = new ku0();
        ku0Var.l(str);
        ku0Var.g(3000);
        ku0Var.d("User-Agent", rk0.e());
        ku0Var.c();
        rt0.b().a().a(ku0Var, null);
        if (i61.a && (p61Var = (p61) h61.a().a(p61.class)) != null) {
            p61Var.b(new j61("计费", "", "并行计费"));
        }
    }
}
