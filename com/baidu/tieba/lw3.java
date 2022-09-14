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
import com.baidu.tieba.iw3;
import com.baidu.tieba.mw3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class lw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lw3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public e b;
    public jw3 c;
    public long d;
    public int e;
    public long f;
    public kw3 g;
    public mw3.d h;

    /* loaded from: classes4.dex */
    public class a implements iw3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw3 a;

        public a(lw3 lw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw3Var;
        }

        @Override // com.baidu.tieba.iw3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && ij1.a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // com.baidu.tieba.iw3.d
        public void onSuccess() {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (activity = this.a.getActivity()) == null) {
                return;
            }
            q23.f(activity, R.string.obfuscated_res_0x7f0f010a).G();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements iw3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ iw3.d b;
        public final /* synthetic */ lw3 c;

        /* loaded from: classes4.dex */
        public class a implements mw3.d {
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

            @Override // com.baidu.tieba.mw3.d
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.b.onFail(str);
                }
            }

            @Override // com.baidu.tieba.mw3.d
            public void onSuccess(Object obj) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    nw3 nw3Var = (nw3) obj;
                    if (ij1.a) {
                        Log.d("AntiAddictionManager", nw3Var.toString());
                    }
                    int i = nw3Var.a;
                    if (i == 0) {
                        this.a.b.onSuccess();
                    } else if (1 == i) {
                        this.a.b.onFail(nw3Var.b);
                    } else {
                        this.a.b.onFail(nw3Var.b);
                        if (TextUtils.isEmpty(nw3Var.b) || (activity = this.a.c.getActivity()) == null) {
                            return;
                        }
                        this.a.c.g.f(activity, nw3Var.b, activity.getString(R.string.obfuscated_res_0x7f0f0109), true, null);
                    }
                }
            }
        }

        public b(lw3 lw3Var, String str, iw3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lw3Var;
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.tieba.iw3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.onFail(str);
            }
        }

        @Override // com.baidu.tieba.iw3.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                mw3.h(this.a, new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw3 a;

        public c(lw3 lw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements mw3.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw3 a;

        public d(lw3 lw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw3Var;
        }

        @Override // com.baidu.tieba.mw3.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && ij1.a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // com.baidu.tieba.mw3.d
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                ow3 ow3Var = (ow3) obj;
                if (ij1.a) {
                    Log.d("AntiAddictionManager", ow3Var.toString());
                }
                this.a.d = System.currentTimeMillis();
                if (this.a.s(ow3Var.c)) {
                    this.a.r(ow3Var.d * 1000);
                    this.a.p(ow3Var.a, ow3Var.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw3 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(lw3 lw3Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var, looper};
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
            this.a = lw3Var;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.a.e) {
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

    public lw3() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            y23 b0 = y23.b0();
            if (b0 == null || b0.w() == null) {
                return null;
            }
            return b0.w();
        }
        return (Activity) invokeV.objValue;
    }

    public static lw3 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (lw3.class) {
                    if (i == null) {
                        i = new lw3();
                    }
                }
            }
            return i;
        }
        return (lw3) invokeV.objValue;
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (lw3.class) {
                if (i != null) {
                    i.m();
                    i = null;
                }
            }
        }
    }

    public void j(String str, iw3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!t()) {
                dVar.onSuccess();
            } else {
                iw3.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            y(true);
            x();
            this.g = new kw3();
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

    public final void p(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (i2 < 0) {
                if (ij1.a) {
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
                this.g.f(activity, activity.getString(R.string.obfuscated_res_0x7f0f0108), activity.getString(R.string.obfuscated_res_0x7f0f0107), true, new c(this));
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            iw3.c(new a(this));
        }
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
            if (1 == i2) {
                n();
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e == 0 : invokeV.booleanValue;
    }

    public final void u(int i2, String str) {
        jw3 jw3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) || (jw3Var = this.c) == null) {
            return;
        }
        try {
            jw3Var.x(i2, str);
        } catch (JSONException e2) {
            if (ij1.a) {
                e2.printStackTrace();
            }
        }
    }

    public void w(jw3 jw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jw3Var) == null) {
            this.c = jw3Var;
        }
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

    public final void y(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                j = 0;
            } else {
                j = System.currentTimeMillis() - this.d;
                if (LiveFeedPageSdk.REFRESH_TIME > j) {
                    return;
                }
            }
            if (ij1.a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            mw3.i(j, this.h);
        }
    }
}
