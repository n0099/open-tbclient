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
import com.baidu.tieba.j54;
import com.baidu.tieba.n54;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class m54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m54 i;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public e b;
    public k54 c;
    public long d;
    public int e;
    public long f;
    public l54 g;
    public n54.d h;

    /* loaded from: classes6.dex */
    public class b implements j54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j54.d b;
        public final /* synthetic */ m54 c;

        /* loaded from: classes6.dex */
        public class a implements n54.d {
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

            @Override // com.baidu.tieba.n54.d
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.b.onFail(str);
                }
            }

            @Override // com.baidu.tieba.n54.d
            public void onSuccess(Object obj) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    o54 o54Var = (o54) obj;
                    if (js1.a) {
                        Log.d("AntiAddictionManager", o54Var.toString());
                    }
                    int i = o54Var.a;
                    if (i == 0) {
                        this.a.b.onSuccess();
                    } else if (1 == i) {
                        this.a.b.onFail(o54Var.b);
                    } else {
                        this.a.b.onFail(o54Var.b);
                        if (TextUtils.isEmpty(o54Var.b) || (activity = this.a.c.getActivity()) == null) {
                            return;
                        }
                        this.a.c.g.f(activity, o54Var.b, activity.getString(R.string.obfuscated_res_0x7f0f0133), true, null);
                    }
                }
            }
        }

        public b(m54 m54Var, String str, j54.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m54Var;
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.tieba.j54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.onFail(str);
            }
        }

        @Override // com.baidu.tieba.j54.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                n54.h(this.a, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements j54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        public a(m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m54Var;
        }

        @Override // com.baidu.tieba.j54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && js1.a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // com.baidu.tieba.j54.d
        public void onSuccess() {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (activity = this.a.getActivity()) == null) {
                return;
            }
            rb3.f(activity, R.string.obfuscated_res_0x7f0f0134).G();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        public c(m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m54Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements n54.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        public d(m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m54Var;
        }

        @Override // com.baidu.tieba.n54.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && js1.a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // com.baidu.tieba.n54.d
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                p54 p54Var = (p54) obj;
                if (js1.a) {
                    Log.d("AntiAddictionManager", p54Var.toString());
                }
                this.a.d = System.currentTimeMillis();
                if (!this.a.s(p54Var.c)) {
                    return;
                }
                this.a.r(p54Var.d * 1000);
                this.a.p(p54Var.a, p54Var.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m54 m54Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var, looper};
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
            this.a = m54Var;
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

    public m54() {
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

    public void w(k54 k54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, k54Var) == null) {
            this.c = k54Var;
        }
    }

    public void j(String str, j54.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!t()) {
                dVar.onSuccess();
            } else {
                j54.b(new b(this, str, dVar));
            }
        }
    }

    public final void u(int i2, String str) {
        k54 k54Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) && (k54Var = this.c) != null) {
            try {
                k54Var.x(i2, str);
            } catch (JSONException e2) {
                if (js1.a) {
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
            zb3 b0 = zb3.b0();
            if (b0 != null && b0.w() != null) {
                return b0.w();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static m54 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (m54.class) {
                    if (i == null) {
                        i = new m54();
                    }
                }
            }
            return i;
        }
        return (m54) invokeV.objValue;
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (m54.class) {
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
            this.g = new l54();
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
            j54.c(new a(this));
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
                if (js1.a) {
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
                this.g.f(activity, activity.getString(R.string.obfuscated_res_0x7f0f0132), activity.getString(R.string.obfuscated_res_0x7f0f0131), true, new c(this));
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
            if (js1.a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            n54.i(j, this.h);
        }
    }
}
