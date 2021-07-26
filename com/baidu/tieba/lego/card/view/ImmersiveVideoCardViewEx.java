package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n1.o.l.a;
import d.a.q0.n1.o.l.n;
import d.a.q0.n2.d;
import d.a.q0.n2.e;
/* loaded from: classes4.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements e, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup r;
    public n s;
    public a t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.t) == null) {
            return;
        }
        aVar.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(ImmersiveVideoCardEx immersiveVideoCardEx, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, immersiveVideoCardEx, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void w(ImmersiveVideoCardEx immersiveVideoCardEx) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, immersiveVideoCardEx) == null) || immersiveVideoCardEx.getVideoInfo() == null) {
            return;
        }
        this.s.y(immersiveVideoCardEx.getShowExtra(), "feed");
        this.s.x(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
        boolean z = immersiveVideoCardEx.getVideoInfo().f18268i;
        this.s.u(z);
        this.s.t(z);
        this.t.u(z);
        setTag(this);
        H();
    }

    @Override // d.a.q0.n2.d
    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.t) == null) {
            return;
        }
        aVar.j();
    }

    @Override // d.a.q0.n2.d
    public void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.t) == null) {
            return;
        }
        aVar.k();
    }

    @Override // d.a.q0.n2.d
    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.t) == null) {
            return;
        }
        aVar.m();
    }

    @Override // d.a.q0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n nVar = this.s;
            if (nVar != null) {
                return nVar.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            n nVar = this.s;
            if (nVar != null) {
                return nVar.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            n nVar = this.s;
            if (nVar != null) {
                return nVar.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.q0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.s;
            return nVar != null && nVar.p();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            n nVar = this.s;
            return nVar != null && nVar.q();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
            this.r = viewGroup;
            this.s = new n(this.m, viewGroup.findViewById(R.id.layout_video_container));
            a aVar = new a(this.m, this.r);
            this.t = aVar;
            this.s.s(aVar);
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.q0.n2.e
    public void startPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nVar = this.s) == null) {
            return;
        }
        nVar.v();
    }

    @Override // d.a.q0.n2.e
    public void stopPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (nVar = this.s) == null) {
            return;
        }
        nVar.w();
    }
}
