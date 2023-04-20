package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nl1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nl1 a;
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void onFinish(String str);
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ nl1 b;

        public b(nl1 nl1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl1Var;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    sl1.a("sso onekey init");
                    this.b.f(this.a.getApplicationContext());
                    dm1.m().e(this.a.getApplicationContext());
                } catch (Throwable th) {
                    en1.d(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public c(nl1 nl1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    sl1.a("sso onekey preLogin");
                    if (!ol1.g(this.a.getApplicationContext()).e()) {
                        bm1.b(this.b, yl1.a(), -1, null, false);
                        sl1.d("sso onekey preLogin fail, user not auth");
                        return;
                    }
                    dm1.m().f(this.a.getApplicationContext(), 0, null, this.c, this.b);
                } catch (Throwable th) {
                    en1.d(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public d(nl1 nl1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    sl1.a("sso onekey login");
                    if (!ol1.g(this.a.getApplicationContext()).e()) {
                        bm1.b(this.b, yl1.a(), -1, null, false);
                        sl1.d("sso onekey login fail, user not auth");
                        return;
                    }
                    dm1.m().g(this.a.getApplicationContext(), this.c, this.b);
                } catch (Throwable th) {
                    en1.d(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public e(nl1 nl1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    sl1.a("sso onekey verifyPhoneNum");
                    if (!ol1.g(this.a.getApplicationContext()).e()) {
                        bm1.b(this.b, yl1.a(), -1, null, false);
                        sl1.d("sso onekey verifyPhoneNum fail, user not auth");
                        return;
                    }
                    dm1.m().l(this.a.getApplicationContext(), this.c, this.b);
                } catch (Throwable th) {
                    en1.d(th);
                }
            }
        }
    }

    public nl1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static nl1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (nl1.class) {
                    if (a == null) {
                        a = new nl1();
                    }
                }
            }
            return a;
        }
        return (nl1) invokeV.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            sl1.b(z);
        }
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            sl1.a("getCurrentOperatorName");
            if (!ol1.g(context.getApplicationContext()).e()) {
                sl1.d("getCurrentOperatorName fail, user not auth");
                return null;
            }
            int intValue = ((Integer) nn1.c(context.getApplicationContext()).second).intValue();
            if (intValue == 1) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
            }
            if (intValue == 3) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
            }
            if (intValue != 2) {
                return null;
            }
            return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void e(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            synchronized (this) {
                try {
                    b = str;
                    c = str2;
                    ym1.b().post(new b(this, context));
                } catch (Throwable th) {
                    en1.d(th);
                }
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            String m0 = ol1.g(context).m0();
            if (TextUtils.isEmpty(m0)) {
                return;
            }
            String[] split = m0.split("_");
            if (split.length != 2) {
                ol1.g(context).h();
            }
            b = split[0];
            c = split[1];
        }
    }

    public void g(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                ym1.b().post(new d(this, context, aVar, j));
            } catch (Throwable th) {
                en1.d(th);
            }
        }
    }

    public void h(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                ym1.b().post(new c(this, context, aVar, j));
            } catch (Throwable th) {
                en1.d(th);
            }
        }
    }

    public void j(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                ym1.b().post(new e(this, context, aVar, j));
            } catch (Throwable th) {
                en1.d(th);
            }
        }
    }

    public void i(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            try {
                sl1.a("setUserAuthPrivacyState, value:" + z);
                ol1.g(context.getApplicationContext()).Z(z);
            } catch (Throwable th) {
                en1.d(th);
            }
        }
    }
}
