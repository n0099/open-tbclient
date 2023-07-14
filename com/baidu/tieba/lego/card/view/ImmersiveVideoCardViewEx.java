package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.hu9;
import com.baidu.tieba.iu9;
import com.baidu.tieba.l09;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.t09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements iu9, hu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup m;
    public t09 n;
    public l09 o;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, immersiveVideoCardEx, i) == null) {
        }
    }

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void D() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l09Var = this.o) != null) {
            l09Var.n();
        }
    }

    @Override // com.baidu.tieba.hu9
    public void b() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (l09Var = this.o) != null) {
            l09Var.j();
        }
    }

    @Override // com.baidu.tieba.hu9
    public void c() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (l09Var = this.o) != null) {
            l09Var.k();
        }
    }

    @Override // com.baidu.tieba.hu9
    public void f() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (l09Var = this.o) != null) {
            l09Var.m();
        }
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            t09 t09Var = this.n;
            if (t09Var != null) {
                return t09Var.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            t09 t09Var = this.n;
            if (t09Var != null) {
                return t09Var.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            t09 t09Var = this.n;
            if (t09Var != null) {
                return t09Var.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            t09 t09Var = this.n;
            if (t09Var != null && t09Var.p()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            t09 t09Var = this.n;
            if (t09Var != null && t09Var.q()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public void startPlay() {
        t09 t09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (t09Var = this.n) != null) {
            t09Var.v();
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        t09 t09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (t09Var = this.n) != null) {
            t09Var.w();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void v(ImmersiveVideoCardEx immersiveVideoCardEx) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, immersiveVideoCardEx) != null) || immersiveVideoCardEx.getVideoInfo() == null) {
            return;
        }
        this.n.y(immersiveVideoCardEx.getShowExtra(), "feed");
        this.n.x(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
        boolean z = immersiveVideoCardEx.getVideoInfo().i;
        this.n.u(z);
        this.n.t(z);
        this.o.u(z);
        setTag(this);
        D();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01c4, (ViewGroup) null);
            this.m = viewGroup;
            this.n = new t09(this.i, viewGroup.findViewById(R.id.obfuscated_res_0x7f0914a4));
            l09 l09Var = new l09(this.i, this.m);
            this.o = l09Var;
            this.n.s(l09Var);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
