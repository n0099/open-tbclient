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
import com.baidu.tieba.qz3;
import com.baidu.tieba.uz3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class tz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tz3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public e b;
    public rz3 c;
    public long d;
    public int e;
    public long f;
    public sz3 g;
    public uz3.d h;

    /* loaded from: classes8.dex */
    public class b implements qz3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qz3.d b;
        public final /* synthetic */ tz3 c;

        /* loaded from: classes8.dex */
        public class a implements uz3.d {
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

            @Override // com.baidu.tieba.uz3.d
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.b.onFail(str);
                }
            }

            @Override // com.baidu.tieba.uz3.d
            public void onSuccess(Object obj) {
                Activity o;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    vz3 vz3Var = (vz3) obj;
                    if (rm1.a) {
                        Log.d("AntiAddictionManager", vz3Var.toString());
                    }
                    int i = vz3Var.a;
                    if (i == 0) {
                        this.a.b.onSuccess();
                    } else if (1 == i) {
                        this.a.b.onFail(vz3Var.b);
                    } else {
                        this.a.b.onFail(vz3Var.b);
                        if (TextUtils.isEmpty(vz3Var.b) || (o = this.a.c.o()) == null) {
                            return;
                        }
                        this.a.c.g.f(o, vz3Var.b, o.getString(R.string.obfuscated_res_0x7f0f0138), true, null);
                    }
                }
            }
        }

        public b(tz3 tz3Var, String str, qz3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz3Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tz3Var;
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.tieba.qz3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.onFail(str);
            }
        }

        @Override // com.baidu.tieba.qz3.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                uz3.h(this.a, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements qz3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz3 a;

        public a(tz3 tz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz3Var;
        }

        @Override // com.baidu.tieba.qz3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && rm1.a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // com.baidu.tieba.qz3.d
        public void onSuccess() {
            Activity o;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (o = this.a.o()) == null) {
                return;
            }
            y53.f(o, R.string.obfuscated_res_0x7f0f0139).G();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz3 a;

        public c(tz3 tz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements uz3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz3 a;

        public d(tz3 tz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz3Var;
        }

        @Override // com.baidu.tieba.uz3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && rm1.a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // com.baidu.tieba.uz3.d
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                wz3 wz3Var = (wz3) obj;
                if (rm1.a) {
                    Log.d("AntiAddictionManager", wz3Var.toString());
                }
                this.a.d = System.currentTimeMillis();
                if (!this.a.t(wz3Var.c)) {
                    return;
                }
                this.a.s(wz3Var.d * 1000);
                this.a.q(wz3Var.a, wz3Var.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz3 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(tz3 tz3Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz3Var, looper};
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
            this.a = tz3Var;
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
                this.a.z(false);
                c();
            }
        }
    }

    public tz3() {
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

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            if (300000 < j) {
                this.f = j;
            } else {
                this.f = 300000L;
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.e = i2;
            if (1 != i2) {
                return true;
            }
            n();
            return false;
        }
        return invokeI.booleanValue;
    }

    public void x(rz3 rz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rz3Var) == null) {
            this.c = rz3Var;
        }
    }

    public void j(String str, qz3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!u()) {
                dVar.onSuccess();
            } else {
                qz3.b(new b(this, str, dVar));
            }
        }
    }

    public final void v(int i2, String str) {
        rz3 rz3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) && (rz3Var = this.c) != null) {
            try {
                rz3Var.w(i2, str);
            } catch (JSONException e2) {
                if (rm1.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static tz3 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (i == null) {
                synchronized (tz3.class) {
                    if (i == null) {
                        i = new tz3();
                    }
                }
            }
            return i;
        }
        return (tz3) invokeV.objValue;
    }

    public static synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (tz3.class) {
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
            z(true);
            y();
            this.g = new sz3();
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
                if (u()) {
                    z(false);
                }
                this.b.a();
            }
        }
    }

    public final Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g63 c0 = g63.c0();
            if (c0 != null && c0.w() != null) {
                return c0.w();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            qz3.c(new a(this));
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.e == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (u() && !this.b.b()) {
                    this.d = System.currentTimeMillis();
                    this.b.c();
                }
            }
        }
    }

    public final void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            if (i2 < 0) {
                if (rm1.a) {
                    Log.e("AntiAddictionManager", "server AntiAddiction state error = " + i2 + " msg = " + str);
                }
            } else if (i2 != 0) {
                if (i2 != 1) {
                    v(i2, str);
                    return;
                }
                Activity o = o();
                if (o == null) {
                    return;
                }
                this.g.f(o, o.getString(R.string.obfuscated_res_0x7f0f0137), o.getString(R.string.obfuscated_res_0x7f0f0136), true, new c(this));
            }
        }
    }

    public final void z(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (!z) {
                j = System.currentTimeMillis() - this.d;
                if (LiveFeedPageSdk.REFRESH_TIME > j) {
                    return;
                }
            } else {
                j = 0;
            }
            if (rm1.a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            uz3.i(j, this.h);
        }
    }
}
