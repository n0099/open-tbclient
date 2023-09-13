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
import com.baidu.tieba.qx0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class nz0 extends iz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public nz0() {
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

    @Override // com.baidu.tieba.jz0
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                S();
            }
        }
    }

    public void T() {
        ox0 ox0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ox0Var = this.f) != null) {
            ox0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.xx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.rz0, com.baidu.tieba.jz0, com.baidu.tieba.wz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            T();
        }
    }

    public nz0(String str) {
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

    @Override // com.baidu.tieba.iz0
    public void P(ox0 ox0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ox0Var) == null) {
            super.P(ox0Var);
            ox0 ox0Var2 = this.f;
            if (ox0Var2 != null) {
                ox0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.yx0
    public boolean e(@NonNull ww0 ww0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ww0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(ww0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void n(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ww0Var) == null) {
            super.n(ww0Var);
            ox0 ox0Var = this.f;
            if (ox0Var != null) {
                ox0Var.c(ww0Var);
            }
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void q(@NonNull ww0 ww0Var) {
        ox0 ox0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, ww0Var) == null) && (ox0Var = this.f) != null) {
            ox0Var.c(ww0Var);
        }
    }

    public final void S() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            du0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                sx0 a = qx0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(u.V0());
                P(a);
            }
        }
    }

    public final void U() {
        BdVideoSeries o1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof sx0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            sx0 sx0Var = (sx0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            sx0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void d(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ww0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ww0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    U();
                } else {
                    R();
                }
            }
            ox0 ox0Var = this.f;
            if (ox0Var != null) {
                ox0Var.c(ww0Var);
            }
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void k(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ww0Var) == null) {
            super.k(ww0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(ww0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(ww0Var.c())) {
                tk0.a("AdLayer", "screen mode: " + ww0Var.c());
            }
            ox0 ox0Var = this.f;
            if (ox0Var != null) {
                ox0Var.c(ww0Var);
            }
        }
    }
}
