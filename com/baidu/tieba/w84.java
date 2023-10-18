package com.baidu.tieba;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes8.dex */
public class w84 implements x84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public e94 b;
    public b c;
    public Handler d;
    public ViewGroup e;
    public int f;
    public boolean g;
    public ObjectAnimator h;
    public z84 i;

    /* loaded from: classes8.dex */
    public interface b {
        void b();

        void o();

        void u(int i);
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w84 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w84 w84Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w84Var, looper};
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
            this.a = w84Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int f = this.a.f();
                if (f > 0 && this.a.g) {
                    this.a.d.sendEmptyMessageDelayed(1, f);
                }
                this.a.k();
            }
        }
    }

    public w84(@NonNull Context context, @NonNull z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, z84Var};
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
        this.i = z84Var;
        j(i());
        h();
        b();
    }

    @Override // com.baidu.tieba.x84
    public void e(e94 e94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e94Var) == null) {
            this.b = e94Var;
        }
    }

    @Override // com.baidu.tieba.x84
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.g) {
            this.d.removeMessages(1);
            if (z) {
                this.d.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.tieba.x84
    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @NonNull
    public static w84 c(int i, @NonNull Context context, @NonNull z84 z84Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, context, z84Var)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return new b94(context, z84Var);
                }
                return new d94(context, z84Var);
            }
            return new b94(context, z84Var);
        }
        return (w84) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setVisibility(8);
            j84.a(this.e, g());
        }
    }

    @Override // com.baidu.tieba.v84
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = false;
            this.d.removeCallbacksAndMessages(null);
            j84.d(this.e);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = d();
            this.d = new a(this, Looper.getMainLooper());
        }
    }

    @Override // com.baidu.tieba.v84
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = false;
            this.d.removeMessages(1);
            this.e.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0947, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.start();
        }
    }

    @Override // com.baidu.tieba.v84
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = true;
            this.e.setVisibility(0);
            this.d.removeMessages(1);
            this.d.sendEmptyMessage(1);
        }
    }

    public final ObjectAnimator d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    public final vv2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vv2 vv2Var = new vv2();
            vv2Var.l(f84.a(this.i.left) - this.f);
            vv2Var.m(f84.a(this.i.top) - this.f);
            vv2Var.n(-2);
            vv2Var.j(-2);
            return vv2Var;
        }
        return (vv2) invokeV.objValue;
    }

    public final void j(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.f = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07089e);
            this.e = new FrameLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f84.a(this.i.width), f84.a(this.i.height));
            int i = this.f;
            layoutParams.setMargins(i, i, i, i);
            this.e.setBackgroundColor(0);
            this.e.addView(view2, layoutParams);
        }
    }
}
