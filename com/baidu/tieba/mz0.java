package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.px0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class mz0 extends hz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public mz0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.iz0
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            U();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                T();
            }
        }
    }

    public void U() {
        nx0 nx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (nx0Var = this.f) != null) {
            nx0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.wx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hz0, com.baidu.tieba.qz0, com.baidu.tieba.iz0, com.baidu.tieba.vz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            U();
        }
    }

    public mz0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = str;
    }

    @Override // com.baidu.tieba.hz0
    public void Q(nx0 nx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx0Var) == null) {
            super.Q(nx0Var);
            nx0 nx0Var2 = this.f;
            if (nx0Var2 != null) {
                nx0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.hz0, com.baidu.tieba.xx0
    public boolean e(@NonNull vw0 vw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vw0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(vw0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void n(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vw0Var) == null) {
            super.n(vw0Var);
            nx0 nx0Var = this.f;
            if (nx0Var != null) {
                nx0Var.c(vw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void q(@NonNull vw0 vw0Var) {
        nx0 nx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, vw0Var) == null) && (nx0Var = this.f) != null) {
            nx0Var.c(vw0Var);
        }
    }

    public final void T() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            cu0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                rx0 a = px0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(u.V0());
                Q(a);
            }
        }
    }

    public final void V() {
        BdVideoSeries o1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof rx0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            rx0 rx0Var = (rx0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            rx0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void d(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vw0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(vw0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    V();
                } else {
                    S();
                }
            }
            nx0 nx0Var = this.f;
            if (nx0Var != null) {
                nx0Var.c(vw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void k(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vw0Var) == null) {
            super.k(vw0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(vw0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(vw0Var.c())) {
                ll0.a("AdLayer", "screen mode: " + vw0Var.c());
            }
            nx0 nx0Var = this.f;
            if (nx0Var != null) {
                nx0Var.c(vw0Var);
            }
        }
    }
}
