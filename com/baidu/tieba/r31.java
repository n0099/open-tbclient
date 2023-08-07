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
public class r31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends gt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s31 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(s31 s31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s31Var;
        }

        @Override // com.baidu.tieba.et0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                q31.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.ft0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ft0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                q31.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable s31 s31Var) {
        s51 s51Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, s31Var) == null) && s31Var != null && !TextUtils.isEmpty(s31Var.d())) {
            nt0 nt0Var = new nt0();
            nt0Var.l(s31Var.d());
            nt0Var.g(3000);
            nt0Var.c();
            if (!TextUtils.isEmpty(s31Var.e)) {
                nt0Var.d("User-Agent", s31Var.e);
            } else {
                nt0Var.d("User-Agent", pj0.e());
            }
            us0.b().a().a(nt0Var, new a(s31Var));
            if (l51.a && (s51Var = (s51) k51.a().a(s51.class)) != null) {
                s51Var.b(new m51("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        s51 s51Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        nt0 nt0Var = new nt0();
        nt0Var.l(str);
        nt0Var.g(3000);
        nt0Var.d("User-Agent", pj0.e());
        nt0Var.c();
        us0.b().a().a(nt0Var, null);
        if (l51.a && (s51Var = (s51) k51.a().a(s51.class)) != null) {
            s51Var.b(new m51("计费", "", "并行计费"));
        }
    }
}
