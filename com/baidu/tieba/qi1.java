package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qi1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public HashSet<String> f;

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi1 a;

        public a(qi1 qi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qi1Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String stringExtra = intent.getStringExtra("ss");
                if (this.a.b == 1) {
                    return;
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    if ("LOADED".equals(stringExtra)) {
                        if (this.a.f.isEmpty()) {
                            return;
                        }
                        this.a.b = 1;
                        return;
                    }
                    this.a.b = 1;
                    this.a.f.add(stringExtra);
                    return;
                }
                this.a.b = 1;
            }
        }
    }

    public qi1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new HashSet<>();
    }

    public static qi1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (g == null) {
                synchronized (qi1.class) {
                    if (g == null) {
                        g = new qi1();
                    }
                }
            }
            return g;
        }
        return (qi1) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c) {
                return -1000;
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.d) {
                return false;
            }
            if (!this.e) {
                return true;
            }
            if (!this.c || this.b == 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = 0;
            this.f.clear();
        }
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                if (this.a != null) {
                    return;
                }
                this.a = new a(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
                context.registerReceiver(this.a, intentFilter);
            } catch (Throwable th) {
                oj1.d(th);
            }
        }
    }

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            try {
                if (this.a == null) {
                    return;
                }
                context.unregisterReceiver(this.a);
                this.a = null;
            } catch (Throwable th) {
                oj1.d(th);
            }
        }
    }

    public void e(Context context, JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject) == null) {
            boolean z3 = false;
            if (jSONObject.optInt("1", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.d = z;
            if (jSONObject.optInt("2", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.c = z2;
            if (jSONObject.optInt("3", 0) == 1) {
                z3 = true;
            }
            this.e = z3;
            if (this.c) {
                d(context);
            } else {
                h(context);
            }
        }
    }
}
