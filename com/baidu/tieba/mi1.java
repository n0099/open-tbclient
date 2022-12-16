package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mi1 extends li1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends jj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ mi1 c;

        public a(mi1 mi1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mi1Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.jj1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.b(this.b);
                } catch (Throwable th) {
                    oj1.d(th);
                    mi1 mi1Var = this.c;
                    mi1Var.d(this.b, 3, 2009, mi1Var.c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends jj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ mi1 c;

        public b(mi1 mi1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mi1Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.jj1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.g(this.b, this.c.c, this.c.h);
                } catch (Throwable th) {
                    oj1.d(th);
                    mi1 mi1Var = this.c;
                    mi1Var.n(this.b, 3, 2009, mi1Var.c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.li1
    public void j(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.j(context, i, j);
            c(i, 2);
            lj1.c().b(new a(this, i));
        }
    }

    @Override // com.baidu.tieba.li1
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
            c(i, 4);
            lj1.c().b(new b(this, i));
        }
    }

    @Override // com.baidu.tieba.li1
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.e)) {
                this.g = null;
                this.f = 0L;
                return true;
            } else if (this.f - System.currentTimeMillis() < nj1.a) {
                this.g = null;
                this.f = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.li1
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.h)) {
                this.i = 0L;
                return true;
            } else if (this.i - System.currentTimeMillis() < nj1.a) {
                this.i = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
