package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.q1.o.l.a;
import b.a.r0.q1.o.l.n;
import b.a.r0.q2.d;
import b.a.r0.q2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements e, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f51138f;

    /* renamed from: g  reason: collision with root package name */
    public n f51139g;

    /* renamed from: h  reason: collision with root package name */
    public a f51140h;

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

    @Override // b.a.r0.q2.d
    public void displayAll() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f51140h) == null) {
            return;
        }
        aVar.j();
    }

    @Override // b.a.r0.q2.d
    public void displayAllWithoutAnim() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f51140h) == null) {
            return;
        }
        aVar.k();
    }

    @Override // b.a.r0.q2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n nVar = this.f51139g;
            if (nVar != null) {
                return nVar.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.q2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n nVar = this.f51139g;
            if (nVar != null) {
                return nVar.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n nVar = this.f51139g;
            if (nVar != null) {
                return nVar.n();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.q2.d
    public void hideAll() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f51140h) == null) {
            return;
        }
        aVar.m();
    }

    public void hideAllWithoutAnim() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f51140h) == null) {
            return;
        }
        aVar.n();
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
            this.f51138f = viewGroup;
            this.f51139g = new n(this.mContext, viewGroup.findViewById(R.id.layout_video_container));
            a aVar = new a(this.mContext, this.f51138f);
            this.f51140h = aVar;
            this.f51139g.s(aVar);
            return this.f51138f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            n nVar = this.f51139g;
            return nVar != null && nVar.p();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.f51139g;
            return nVar != null && nVar.q();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(ImmersiveVideoCardEx immersiveVideoCardEx, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, immersiveVideoCardEx, i2) == null) {
        }
    }

    public void postHideExceptVideo() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.f51140h) == null) {
            return;
        }
        aVar.r();
    }

    @Override // b.a.r0.q2.e
    public void startPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (nVar = this.f51139g) == null) {
            return;
        }
        nVar.v();
    }

    @Override // b.a.r0.q2.e
    public void stopPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (nVar = this.f51139g) == null) {
            return;
        }
        nVar.w();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(ImmersiveVideoCardEx immersiveVideoCardEx) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, immersiveVideoCardEx) == null) || immersiveVideoCardEx.getVideoInfo() == null) {
            return;
        }
        this.f51139g.y(immersiveVideoCardEx.getShowExtra(), "feed");
        this.f51139g.x(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
        boolean z = immersiveVideoCardEx.getVideoInfo().f51095i;
        this.f51139g.u(z);
        this.f51139g.t(z);
        this.f51140h.u(z);
        setTag(this);
        hideAllWithoutAnim();
    }
}
