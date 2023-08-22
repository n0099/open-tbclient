package com.baidu.tieba;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.tieba.nv0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class pz0<T extends ViewGroup, S extends nv0> extends fz0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T e;
    public final ArrayList<S> f;

    public abstract void Q();

    public void R(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
        }
    }

    public abstract void S();

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
        }
    }

    public pz0() {
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
        this.f = new ArrayList<>();
    }

    @Override // com.baidu.tieba.fz0
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sz0
    @NonNull
    /* renamed from: P */
    public T getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new int[]{4, 5, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.sz0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onContainerDetach();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.sz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().m();
            }
        }
    }

    @Override // com.baidu.tieba.fz0
    public void B(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.B(message);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().h(message);
            }
        }
    }

    public void L(@NonNull S s) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, s) == null) && !this.f.contains(s)) {
            d31.b(this.f, s);
        }
    }

    public void O(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sw0Var) == null) {
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().k(sw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void d(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sw0Var) == null) {
            super.d(sw0Var);
            O(sw0Var);
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void j(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sw0Var) == null) {
            super.j(sw0Var);
            O(sw0Var);
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void k(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sw0Var) == null) {
            super.k(sw0Var);
            O(sw0Var);
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void n(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sw0Var) == null) {
            super.n(sw0Var);
            O(sw0Var);
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void q(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sw0Var) == null) {
            super.q(sw0Var);
            O(sw0Var);
        }
    }

    @Override // com.baidu.tieba.fz0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Q();
            S();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                S next = it.next();
                next.p(this);
                next.i();
                if (next.d()) {
                    M(next);
                }
            }
            R(this.e);
        }
    }

    public void M(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s) == null) {
            d21.k(s.getContentView());
            if (N(s.f())) {
                this.e.addView(s.getContentView(), s.f());
            } else {
                this.e.addView(s.getContentView());
            }
        }
    }

    public boolean N(@Nullable ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) {
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

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().n(playerStatus, playerStatus2);
            }
        }
    }
}
