package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b68;
import com.repackage.c68;
import com.repackage.ld7;
import com.repackage.td7;
/* loaded from: classes3.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements c68, b68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup m;
    public td7 n;
    public ld7 o;

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
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ld7Var = this.o) == null) {
            return;
        }
        ld7Var.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: D */
    public void t(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, immersiveVideoCardEx, i) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(ImmersiveVideoCardEx immersiveVideoCardEx) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, immersiveVideoCardEx) == null) || immersiveVideoCardEx.getVideoInfo() == null) {
            return;
        }
        this.n.y(immersiveVideoCardEx.getShowExtra(), ExternalTransferSpeedStats.FEED_PAGE);
        this.n.x(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
        boolean z = immersiveVideoCardEx.getVideoInfo().i;
        this.n.u(z);
        this.n.t(z);
        this.o.u(z);
        setTag(this);
        C();
    }

    @Override // com.repackage.b68
    public void a() {
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ld7Var = this.o) == null) {
            return;
        }
        ld7Var.j();
    }

    @Override // com.repackage.b68
    public void b() {
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ld7Var = this.o) == null) {
            return;
        }
        ld7Var.k();
    }

    @Override // com.repackage.b68
    public void c() {
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ld7Var = this.o) == null) {
            return;
        }
        ld7Var.m();
    }

    @Override // com.repackage.c68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            td7 td7Var = this.n;
            if (td7Var != null) {
                return td7Var.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.c68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            td7 td7Var = this.n;
            if (td7Var != null) {
                return td7Var.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            td7 td7Var = this.n;
            if (td7Var != null) {
                return td7Var.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            td7 td7Var = this.n;
            return td7Var != null && td7Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            td7 td7Var = this.n;
            return td7Var != null && td7Var.q();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d019f, (ViewGroup) null);
            this.m = viewGroup;
            this.n = new td7(this.i, viewGroup.findViewById(R.id.obfuscated_res_0x7f091259));
            ld7 ld7Var = new ld7(this.i, this.m);
            this.o = ld7Var;
            this.n.s(ld7Var);
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public void startPlay() {
        td7 td7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (td7Var = this.n) == null) {
            return;
        }
        td7Var.v();
    }

    @Override // com.repackage.c68
    public void stopPlay() {
        td7 td7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (td7Var = this.n) == null) {
            return;
        }
        td7Var.w();
    }
}
