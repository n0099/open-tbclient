package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.m54;
import com.baidu.tieba.q54;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class p54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p54 i;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public e b;
    public n54 c;
    public long d;
    public int e;
    public long f;
    public o54 g;
    public q54.d h;

    /* loaded from: classes7.dex */
    public class b implements m54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ m54.d b;
        public final /* synthetic */ p54 c;

        /* loaded from: classes7.dex */
        public class a implements q54.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.q54.d
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.b.onFail(str);
                }
            }

            @Override // com.baidu.tieba.q54.d
            public void onSuccess(Object obj) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    r54 r54Var = (r54) obj;
                    if (ms1.a) {
                        Log.d("AntiAddictionManager", r54Var.toString());
                    }
                    int i = r54Var.a;
                    if (i == 0) {
                        this.a.b.onSuccess();
                    } else if (1 == i) {
                        this.a.b.onFail(r54Var.b);
                    } else {
                        this.a.b.onFail(r54Var.b);
                        if (TextUtils.isEmpty(r54Var.b) || (activity = this.a.c.getActivity()) == null) {
                            return;
                        }
                        this.a.c.g.f(activity, r54Var.b, activity.getString(R.string.obfuscated_res_0x7f0f0135), true, null);
                    }
                }
            }
        }

        public b(p54 p54Var, String str, m54.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p54Var;
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.tieba.m54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.onFail(str);
            }
        }

        @Override // com.baidu.tieba.m54.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                q54.h(this.a, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements m54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p54 a;

        public a(p54 p54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p54Var;
        }

        @Override // com.baidu.tieba.m54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && ms1.a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // com.baidu.tieba.m54.d
        public void onSuccess() {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (activity = this.a.getActivity()) == null) {
                return;
            }
            ub3.f(activity, R.string.obfuscated_res_0x7f0f0136).G();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p54 a;

        public c(p54 p54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p54Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements q54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p54 a;

        public d(p54 p54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p54Var;
        }

        @Override // com.baidu.tieba.q54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && ms1.a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // com.baidu.tieba.q54.d
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                s54 s54Var = (s54) obj;
                if (ms1.a) {
                    Log.d("AntiAddictionManager", s54Var.toString());
                }
                this.a.d = System.currentTimeMillis();
                if (!this.a.s(s54Var.c)) {
                    return;
                }
                this.a.r(s54Var.d * 1000);
                this.a.p(s54Var.a, s54Var.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p54 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(p54 p54Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p54Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                removeCallbacksAndMessages(null);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return hasMessages(1);
            }
            return invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || 1 == this.a.e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.a.f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.a.y(false);
                c();
            }
        }
    }

    public p54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = 300000L;
        this.h = new d(this);
        k();
    }

    public final void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (300000 < j) {
                this.f = j;
            } else {
                this.f = 300000L;
            }
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.e = i2;
            if (1 != i2) {
                return true;
            }
            n();
            return false;
        }
        return invokeI.booleanValue;
    }

    public void w(n54 n54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, n54Var) == null) {
            this.c = n54Var;
        }
    }

    public void j(String str, m54.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!t()) {
                dVar.onSuccess();
            } else {
                m54.b(new b(this, str, dVar));
            }
        }
    }

    public final void u(int i2, String str) {
        n54 n54Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) && (n54Var = this.c) != null) {
            try {
                n54Var.x(i2, str);
            } catch (JSONException e2) {
                if (ms1.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 != null && b0.w() != null) {
                return b0.w();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static p54 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (p54.class) {
                    if (i == null) {
                        i = new p54();
                    }
                }
            }
            return i;
        }
        return (p54) invokeV.objValue;
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (p54.class) {
                if (i != null) {
                    i.m();
                    i = null;
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            y(true);
            x();
            this.g = new o54();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new e(this, this.a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.b.a();
                if (this.a != null) {
                    this.a.quitSafely();
                    this.a = null;
                }
                if (this.g != null) {
                    this.g.e();
                    this.g = null;
                }
            }
        }
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (t()) {
                    y(false);
                }
                this.b.a();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            m54.c(new a(this));
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.e == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (t() && !this.b.b()) {
                    this.d = System.currentTimeMillis();
                    this.b.c();
                }
            }
        }
    }

    public final void p(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (i2 < 0) {
                if (ms1.a) {
                    Log.e("AntiAddictionManager", "server AntiAddiction state error = " + i2 + " msg = " + str);
                }
            } else if (i2 != 0) {
                if (i2 != 1) {
                    u(i2, str);
                    return;
                }
                Activity activity = getActivity();
                if (activity == null) {
                    return;
                }
                this.g.f(activity, activity.getString(R.string.obfuscated_res_0x7f0f0134), activity.getString(R.string.obfuscated_res_0x7f0f0133), true, new c(this));
            }
        }
    }

    public final void y(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (!z) {
                j = System.currentTimeMillis() - this.d;
                if (LiveFeedPageSdk.REFRESH_TIME > j) {
                    return;
                }
            } else {
                j = 0;
            }
            if (ms1.a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            q54.i(j, this.h);
        }
    }
}
