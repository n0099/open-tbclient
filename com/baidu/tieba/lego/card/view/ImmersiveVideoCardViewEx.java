package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.m39;
import com.baidu.tieba.u39;
import com.baidu.tieba.xy9;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements yy9, xy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup m;
    public u39 n;
    public m39 o;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: D */
    public void t(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, immersiveVideoCardEx, i) == null) {
        }
    }

    @Override // com.baidu.tieba.yy9
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

    public void C() {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (m39Var = this.o) != null) {
            m39Var.n();
        }
    }

    @Override // com.baidu.tieba.xy9
    public void a() {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (m39Var = this.o) != null) {
            m39Var.j();
        }
    }

    @Override // com.baidu.tieba.xy9
    public void b() {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (m39Var = this.o) != null) {
            m39Var.k();
        }
    }

    @Override // com.baidu.tieba.xy9
    public void e() {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (m39Var = this.o) != null) {
            m39Var.m();
        }
    }

    @Override // com.baidu.tieba.yy9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u39 u39Var = this.n;
            if (u39Var != null) {
                return u39Var.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            u39 u39Var = this.n;
            if (u39Var != null) {
                return u39Var.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            u39 u39Var = this.n;
            if (u39Var != null) {
                return u39Var.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            u39 u39Var = this.n;
            if (u39Var != null && u39Var.p()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            u39 u39Var = this.n;
            if (u39Var != null && u39Var.q()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public void startPlay() {
        u39 u39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (u39Var = this.n) != null) {
            u39Var.v();
        }
    }

    @Override // com.baidu.tieba.yy9
    public void stopPlay() {
        u39 u39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (u39Var = this.n) != null) {
            u39Var.w();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(ImmersiveVideoCardEx immersiveVideoCardEx) {
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
        C();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01cf, (ViewGroup) null);
            this.m = viewGroup;
            this.n = new u39(this.i, viewGroup.findViewById(R.id.obfuscated_res_0x7f0914d4));
            m39 m39Var = new m39(this.i, this.m);
            this.o = m39Var;
            this.n.s(m39Var);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
