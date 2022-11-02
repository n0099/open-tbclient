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
/* loaded from: classes6.dex */
public abstract class zw0 implements mx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public tx0 a;
    public LayerContainer b;
    public Context c;
    public Handler d;

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void a(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mu0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void d(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mu0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nv0
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nv0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void j(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mu0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void k(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mu0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void n(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mu0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.mx0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.nv0
    public void q(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mu0Var) == null) {
        }
    }

    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, message) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<zw0> a;

        public a(zw0 zw0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(zw0Var);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            zw0 zw0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (zw0Var = this.a.get()) != null && zw0Var.getContentView() != null && zw0Var.getContentView().getParent() != null) {
                zw0Var.z(message);
            }
        }
    }

    public zw0() {
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
        A(null);
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && C() && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.a.c(i, this);
            }
        }
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return u().getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mx0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            vz0.a("onLayerRelease() = " + this);
            this.d.removeCallbacksAndMessages(null);
            this.c = null;
            this.a = null;
        }
    }

    public void s() {
        tx0 tx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (tx0Var = this.a) != null) {
            tx0Var.e(this);
            this.a = null;
        }
    }

    @NonNull
    public Context t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c.getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    public sr0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            LayerContainer layerContainer = this.b;
            if (layerContainer != null) {
                return layerContainer.getBindPlayer();
            }
            return null;
        }
        return (sr0) invokeV.objValue;
    }

    public zt0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return u().q();
        }
        return (zt0) invokeV.objValue;
    }

    public Handler w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d;
        }
        return (Handler) invokeV.objValue;
    }

    public LayerContainer x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.b;
        }
        return (LayerContainer) invokeV.objValue;
    }

    @Nullable
    public tx0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a;
        }
        return (tx0) invokeV.objValue;
    }

    public zw0(@Nullable Context context) {
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
        vz0.a("AbsLayer(context@" + System.identityHashCode(context) + ") = " + this);
        A(context);
    }

    public final void A(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (context == null) {
                this.c = rr0.b();
            } else {
                this.c = context;
            }
            this.d = new a(this);
        }
    }

    public void F(mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mu0Var) == null) {
            G(mu0Var);
        }
    }

    public final void G(mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, mu0Var) == null) && C()) {
            mu0Var.t(this);
            this.a.d(mu0Var);
        }
    }

    public void H(@Nullable ov0 ov0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ov0Var) == null) {
            u().u0(ov0Var);
        }
    }

    public void I(@NonNull LayerContainer layerContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layerContainer) == null) {
            this.b = layerContainer;
        }
    }

    public void r(@NonNull tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tx0Var) == null) {
            this.a = tx0Var;
            E();
        }
    }
}
