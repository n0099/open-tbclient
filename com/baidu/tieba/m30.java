package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m30 {
    public static /* synthetic */ Interceptable $ic;
    public static m30 i;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;
    public AtomicInteger b;
    public o30 c;
    public x30 d;
    public HashMap<String, String> e;
    public HashMap<String, String> f;
    public v30 g;
    public Context h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (m30.i == null) {
                synchronized (m30.class) {
                    if (m30.i == null) {
                        m30 unused = m30.i = new m30(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (a == null) {
                    synchronized (m30.class) {
                        if (a == null) {
                            a = new a(context);
                        }
                    }
                }
                return a;
            }
            return (a) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m30.i.e = new HashMap();
                m30.i.e.put(BOSTokenRequest.CHARSET, IMAudioTransRequest.CHARSET);
                m30.i.e.put("Content-type", "application/json");
                m30.i.d = new f40();
            }
        }

        public m30 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (m30.i.d == null) {
                    a();
                }
                return m30.i;
            }
            return (m30) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m30 a;

        public b(m30 m30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m30Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m30 m30Var = this.a;
                m30Var.c = new s30(m30Var.h);
                if (this.a.g != null) {
                    this.a.g.a(this.a.c.a());
                    z = this.a.g.b();
                } else {
                    z = false;
                }
                if (z && this.a.k()) {
                    this.a.o();
                    this.a.m();
                }
                this.a.a = null;
            }
        }
    }

    public m30(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.h = context;
        this.g = new c40(context);
    }

    public /* synthetic */ m30(Context context, n30 n30Var) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f;
            return hashMap == null ? str : e40.a(str, hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (Runnable) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        y30 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e = e("https://mbd.baidu.com/store");
            x30 x30Var = this.d;
            JSONObject a3 = b40.a((x30Var == null || (a2 = x30Var.a()) == null) ? null : a2.a(e, "POST", this.e, this.c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicInteger = this.b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public final void o() {
        v30 v30Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (v30Var = this.g) == null) {
            return;
        }
        v30Var.b(this.c.a());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (m30.class) {
                if (this.b.get() == 0) {
                    if (this.h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.b.set(1);
                    if (this.a == null) {
                        this.a = new Thread(h());
                    }
                    this.a.start();
                }
            }
        }
    }
}
