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
import com.baidu.tieba.nq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class ou0<T extends ViewGroup, S extends nq0> extends eu0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T e;
    public final ArrayList<S> f;

    public abstract void R();

    public void S(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
        }
    }

    public abstract void T();

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
        }
    }

    public ou0() {
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

    @Override // com.baidu.tieba.eu0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().m();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ru0
    @NonNull
    /* renamed from: Q */
    public T getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new int[]{4, 5, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ru0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onContainerDetach();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ru0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onLayerRelease();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
    }

    @Override // com.baidu.tieba.eu0
    public void C(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.C(message);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().i(message);
            }
        }
    }

    public void M(@NonNull S s) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, s) == null) && !this.f.contains(s)) {
            tx0.b(this.f, s);
        }
    }

    public void P(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sr0Var) == null) {
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().l(sr0Var);
            }
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void j(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sr0Var) == null) {
            super.j(sr0Var);
            P(sr0Var);
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void n(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sr0Var) == null) {
            super.n(sr0Var);
            P(sr0Var);
        }
    }

    @Override // com.baidu.tieba.eu0
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            R();
            T();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                S next = it.next();
                next.q(this);
                next.j();
                if (next.d()) {
                    N(next);
                }
            }
            S(this.e);
        }
    }

    public void N(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s) == null) {
            tw0.k(s.getContentView());
            if (O(s.g())) {
                this.e.addView(s.getContentView(), s.g());
            } else {
                this.e.addView(s.getContentView());
            }
        }
    }

    public boolean O(@Nullable ViewGroup.LayoutParams layoutParams) {
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

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().o(playerStatus, playerStatus2);
            }
        }
    }
}
