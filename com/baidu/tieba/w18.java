package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Vector;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class w18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o18 a;
    public final String b;
    public final long c;
    public final String d;
    public final Vector<String> e;
    public final Runnable f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948217835, "Lcom/baidu/tieba/w18;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948217835, "Lcom/baidu/tieba/w18;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w18 a;

        public a(w18 w18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
                o18 o18Var = this.a.a;
                String loadingTimeOutContent = this.a.f();
                Intrinsics.checkNotNullExpressionValue(loadingTimeOutContent, "loadingTimeOutContent");
                o18Var.t(loadingTimeOutContent);
            }
        }
    }

    public w18(o18 repo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.a = repo;
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f12ba);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.sprite_time_out_hint)");
        this.b = string;
        this.c = m35.m().n("key_funny_sprite_msg_time_out", 60) * 1000;
        this.d = m35.m().s("key_funny_sprite_msg_time_out_content", this.b);
        this.e = new Vector<>();
        this.f = new a(this);
    }

    public final void c(String msgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msgKey) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            this.e.add(msgKey);
            d();
        }
    }

    public final void h(String msgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, msgKey) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            i(msgKey, false);
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e.isEmpty()) {
                e();
                return;
            }
            e8a.a().removeCallbacks(this.f);
            e8a.a().postDelayed(this.f, this.c);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e8a.a().removeCallbacks(this.f);
            this.a.s();
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.clear();
            e();
        }
    }

    public final void i(String msgKey, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, msgKey, z) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            if (z) {
                this.e.remove(msgKey);
            } else if (!g()) {
                Vector<String> vector = this.e;
                vector.remove(vector.size() - 1);
            }
        }
    }
}
