package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.layer.LayerContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public abstract class zz0 implements m01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public t01 a;
    public LayerContainer b;
    public Context c;
    public Handler d;

    public void B(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void a(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void d(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ny0
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ny0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void j(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void k(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void n(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.m01
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void q(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mx0Var) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<zz0> a;

        public a(zz0 zz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(zz0Var);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            zz0 zz0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (zz0Var = this.a.get()) != null && zz0Var.getContentView() != null && zz0Var.getContentView().getParent() != null) {
                zz0Var.B(message);
            }
        }
    }

    public zz0() {
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
        C(null);
    }

    @Nullable
    public t01 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (t01) invokeV.objValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && E() && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.a.c(i, this);
            }
        }
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return u().getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m01
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            v21.a("onLayerRelease() = " + this);
            this.d.removeCallbacksAndMessages(null);
            this.c = null;
            this.a = null;
        }
    }

    public void s() {
        t01 t01Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (t01Var = this.a) != null) {
            t01Var.e(this);
            this.a = null;
        }
    }

    @NonNull
    public Context t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.c.getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    public su0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            LayerContainer layerContainer = this.b;
            if (layerContainer != null) {
                return layerContainer.getBindPlayer();
            }
            return null;
        }
        return (su0) invokeV.objValue;
    }

    public zw0 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return u().q();
        }
        return (zw0) invokeV.objValue;
    }

    public Handler y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return (Handler) invokeV.objValue;
    }

    public LayerContainer z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.b;
        }
        return (LayerContainer) invokeV.objValue;
    }

    public zz0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        v21.a("AbsLayer(context@" + System.identityHashCode(context) + ") = " + this);
        C(context);
    }

    public final void C(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context == null) {
                this.c = ru0.b();
            } else {
                this.c = context;
            }
            this.d = new a(this);
        }
    }

    public void H(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mx0Var) == null) {
            I(mx0Var);
        }
    }

    public final void I(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mx0Var) == null) && E()) {
            mx0Var.t(this);
            this.a.d(mx0Var);
        }
    }

    public void J(@Nullable oy0 oy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, oy0Var) == null) {
            u().u0(oy0Var);
        }
    }

    public void L(@NonNull LayerContainer layerContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layerContainer) == null) {
            this.b = layerContainer;
        }
    }

    public void r(@NonNull t01 t01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, t01Var) == null) {
            this.a = t01Var;
            G();
        }
    }
}
