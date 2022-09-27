package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.tail.AdVideoTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jv0 extends bv0 implements AdVideoTailFrameView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoTailFrameView b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jv0(lw0 lw0Var, Object obj) {
        super(lw0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lw0Var, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((lw0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = this.c instanceof lp0;
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void b() {
        lw0 lw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object obj = this.c;
            if (obj instanceof lp0) {
                if ("ad_full_video".equals(((lp0) obj).n)) {
                    if (this.a != null && h() && this.a.M()) {
                        if (this.a.u().V0()) {
                            this.a.F(lt0.w(PlayerEvent.ACTION_ON_COMPLETE));
                        } else {
                            this.a.u().y().G(0);
                        }
                    }
                } else if ("ad_append_video".equals(((lp0) this.c).n) && (lw0Var = this.a) != null && lw0Var.M()) {
                    this.b.u(ClogBuilder.LogType.CLOSE.type, "", "");
                    this.a.P(8);
                    this.a.N();
                    this.a.F(kt0.w("layer_event_ad_finish"));
                    if (this.a.u().a0()) {
                        return;
                    }
                    this.a.F(lt0.w(PlayerEvent.ACTION_ON_COMPLETE));
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null || this.c == null) {
            return;
        }
        g();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        if (this.b == null) {
            AdVideoTailFrameView adVideoTailFrameView = new AdVideoTailFrameView(this.a.getContentView().getContext(), this.a, d());
            this.b = adVideoTailFrameView;
            this.a.L(adVideoTailFrameView);
        }
        this.b.n(d());
        this.b.setCallBack(this);
        Object obj = this.c;
        if (obj != null) {
            this.b.setData(obj);
            this.b.v();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lw0 lw0Var = this.a;
            return (lw0Var == null || lw0Var.u().o1() == null || this.a.u().o1().getVideoAd() == null || this.a.u().o1().getVideoAd().fullItemAdData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdVideoTailFrameView adVideoTailFrameView = this.b;
            return adVideoTailFrameView != null && adVideoTailFrameView.q();
        }
        return invokeV.booleanValue;
    }

    public void j(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.s(z);
    }

    public void k(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.n(z);
    }

    public void l() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.w();
    }

    public void m() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.t();
    }
}
