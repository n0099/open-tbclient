package com.baidu.tieba;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class sw0 extends iw0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup e;
    public final ArrayList f;

    public abstract void P();

    public void Q(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
        }
    }

    public abstract void R();

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
        }
    }

    public sw0() {
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
        this.f = new ArrayList();
    }

    @Override // com.baidu.tieba.iw0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).l();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vw0
    /* renamed from: O */
    public ViewGroup getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wu0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new int[]{4, 5, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.vw0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onContainerDetach();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).j();
            }
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.vw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).m();
            }
        }
    }

    @Override // com.baidu.tieba.iw0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            P();
            R();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                qs0 qs0Var = (qs0) it.next();
                qs0Var.p(this);
                qs0Var.i();
                if (qs0Var.d()) {
                    L(qs0Var);
                }
            }
            Q(this.e);
        }
    }

    public void K(qs0 qs0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qs0Var) == null) && !this.f.contains(qs0Var)) {
            xz0.b(this.f, qs0Var);
        }
    }

    public void N(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vt0Var) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).k(vt0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void d(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vt0Var) == null) {
            super.d(vt0Var);
            N(vt0Var);
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void j(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vt0Var) == null) {
            super.j(vt0Var);
            N(vt0Var);
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void k(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, vt0Var) == null) {
            super.k(vt0Var);
            N(vt0Var);
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void n(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vt0Var) == null) {
            super.n(vt0Var);
            N(vt0Var);
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void q(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, vt0Var) == null) {
            super.q(vt0Var);
            N(vt0Var);
        }
    }

    @Override // com.baidu.tieba.iw0
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            super.z(message);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).h(message);
            }
        }
    }

    public void L(qs0 qs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qs0Var) == null) {
            gz0.k(qs0Var.getContentView());
            if (M(qs0Var.f())) {
                this.e.addView(qs0Var.getContentView(), qs0Var.f());
            } else {
                this.e.addView(qs0Var.getContentView());
            }
        }
    }

    public boolean M(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutParams)) == null) {
            if (getContentView() instanceof FrameLayout) {
                return layoutParams instanceof FrameLayout.LayoutParams;
            }
            if (getContentView() instanceof LinearLayout) {
                return layoutParams instanceof LinearLayout.LayoutParams;
            }
            if (getContentView() instanceof RelativeLayout) {
                return layoutParams instanceof RelativeLayout.LayoutParams;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((qs0) it.next()).n(playerStatus, playerStatus2);
            }
        }
    }
}
