package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class my0 extends ey0 implements sx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly0 b;
    public Object c;

    @Override // com.baidu.tieba.ey0
    public void f(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ww0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ey0
    public void i(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ww0Var) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my0(Map<String, String> map, Object obj) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.baidu.tieba.ox0
    public void a(boolean z) {
        ly0 ly0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ly0Var = this.b) != null) {
            ly0Var.k(z);
        }
    }

    @Override // com.baidu.tieba.sx0
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.c = obj;
        }
    }

    public void l(boolean z) {
        ly0 ly0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (ly0Var = this.b) != null) {
            ly0Var.j(z);
        }
    }

    @Override // com.baidu.tieba.px0
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null && PlayerEvent.ACTION_ON_COMPLETE.equals(str)) {
                this.a.Q(0);
                ly0 ly0Var = new ly0(this.a, this.c);
                this.b = ly0Var;
                ly0Var.e();
                if (k()) {
                    if (this.b.i()) {
                        this.a.Q(0);
                        this.a.u().y().y(true);
                        return true;
                    }
                    this.a.Q(8);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ey0
    public void g(ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ww0Var) == null) {
            String c2 = ww0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -552621273) {
                if (hashCode != -552580917) {
                    if (hashCode == 851534116 && c2.equals(LayerEvent.ACTION_NIGHT_MODEL_CHANGED)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        l(ww0Var.d(17));
                        return;
                    }
                    return;
                }
                a(true);
                return;
            }
            a(false);
        }
    }

    @Override // com.baidu.tieba.ey0
    public void h(ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ww0Var) == null) {
            String c2 = ww0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -1759675333) {
                if (hashCode == -882902390 && c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1 && this.a.N() && this.b != null) {
                    if (!ww0Var.d(4)) {
                        this.b.m();
                        return;
                    } else {
                        this.b.l();
                        return;
                    }
                }
                return;
            }
            this.a.Q(8);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            nz0 nz0Var = this.a;
            if (nz0Var == null || (o1 = nz0Var.u().o1()) == null || o1.getVideoAd() == null || o1.getVideoAd().fullItemAdData == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null) {
            return;
        }
        this.b = null;
    }

    @Override // com.baidu.tieba.ox0
    public void onDestroy() {
        nz0 nz0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.b != null && (nz0Var = this.a) != null && nz0Var.N()) {
                this.b.f();
            }
            ly0 ly0Var = this.b;
            if (ly0Var != null) {
                ly0Var.c();
                m();
            }
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.ox0
    public void onLayerRelease() {
        ly0 ly0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (ly0Var = this.b) != null) {
            ly0Var.f();
        }
    }
}
