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
public class s31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends pt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(t31 t31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t31Var;
        }

        @Override // com.baidu.tieba.nt0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                r31.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.ot0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                r31.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable t31 t31Var) {
        s51 s51Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, t31Var) == null) && t31Var != null && !TextUtils.isEmpty(t31Var.d())) {
            wt0 wt0Var = new wt0();
            wt0Var.l(t31Var.d());
            wt0Var.g(3000);
            wt0Var.c();
            if (!TextUtils.isEmpty(t31Var.e)) {
                wt0Var.d("User-Agent", t31Var.e);
            } else {
                wt0Var.d("User-Agent", ok0.e());
            }
            dt0.b().a().a(wt0Var, new a(t31Var));
            if (m51.a && (s51Var = (s51) l51.a().a(s51.class)) != null) {
                s51Var.b(new n51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        s51 s51Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        wt0 wt0Var = new wt0();
        wt0Var.l(str);
        wt0Var.g(3000);
        wt0Var.d("User-Agent", ok0.e());
        wt0Var.c();
        dt0.b().a().a(wt0Var, null);
        if (m51.a && (s51Var = (s51) l51.a().a(s51.class)) != null) {
            s51Var.b(new n51("计费", "", "并行计费"));
        }
    }
}
