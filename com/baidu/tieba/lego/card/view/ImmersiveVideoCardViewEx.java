package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.hg9;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.pg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements pda, oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup m;
    public pg9 n;
    public hg9 o;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void v(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, immersiveVideoCardEx, i) == null) {
        }
    }

    @Override // com.baidu.tieba.pda
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

    public void E() {
        hg9 hg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hg9Var = this.o) != null) {
            hg9Var.n();
        }
    }

    @Override // com.baidu.tieba.oda
    public void a() {
        hg9 hg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hg9Var = this.o) != null) {
            hg9Var.j();
        }
    }

    @Override // com.baidu.tieba.oda
    public void c() {
        hg9 hg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (hg9Var = this.o) != null) {
            hg9Var.k();
        }
    }

    @Override // com.baidu.tieba.oda
    public void e() {
        hg9 hg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (hg9Var = this.o) != null) {
            hg9Var.m();
        }
    }

    @Override // com.baidu.tieba.pda
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            pg9 pg9Var = this.n;
            if (pg9Var != null) {
                return pg9Var.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pda
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            pg9 pg9Var = this.n;
            if (pg9Var != null) {
                return pg9Var.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pda
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            pg9 pg9Var = this.n;
            if (pg9Var != null) {
                return pg9Var.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pda
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            pg9 pg9Var = this.n;
            if (pg9Var != null && pg9Var.p()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pda
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            pg9 pg9Var = this.n;
            if (pg9Var != null && pg9Var.q()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pda
    public void startPlay() {
        pg9 pg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pg9Var = this.n) != null) {
            pg9Var.v();
        }
    }

    @Override // com.baidu.tieba.pda
    public void stopPlay() {
        pg9 pg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (pg9Var = this.n) != null) {
            pg9Var.w();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: G */
    public void w(ImmersiveVideoCardEx immersiveVideoCardEx) {
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
        E();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01d7, (ViewGroup) null);
            this.m = viewGroup;
            this.n = new pg9(this.i, viewGroup.findViewById(R.id.obfuscated_res_0x7f09158a));
            hg9 hg9Var = new hg9(this.i, this.m);
            this.o = hg9Var;
            this.n.s(hg9Var);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
