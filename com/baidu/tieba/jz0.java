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
import com.baidu.tieba.mx0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class jz0 extends ez0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public jz0() {
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

    @Override // com.baidu.tieba.fz0
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
        kx0 kx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (kx0Var = this.f) != null) {
            kx0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.tx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ez0, com.baidu.tieba.nz0, com.baidu.tieba.fz0, com.baidu.tieba.sz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            T();
        }
    }

    public jz0(String str) {
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

    @Override // com.baidu.tieba.ez0
    public void P(kx0 kx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kx0Var) == null) {
            super.P(kx0Var);
            kx0 kx0Var2 = this.f;
            if (kx0Var2 != null) {
                kx0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.ez0, com.baidu.tieba.ux0
    public boolean e(@NonNull sw0 sw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sw0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(sw0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void n(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sw0Var) == null) {
            super.n(sw0Var);
            kx0 kx0Var = this.f;
            if (kx0Var != null) {
                kx0Var.c(sw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void q(@NonNull sw0 sw0Var) {
        kx0 kx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, sw0Var) == null) && (kx0Var = this.f) != null) {
            kx0Var.c(sw0Var);
        }
    }

    public final void S() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            zt0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                ox0 a = mx0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
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
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof ox0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            ox0 ox0Var = (ox0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            ox0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void d(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sw0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(sw0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    U();
                } else {
                    R();
                }
            }
            kx0 kx0Var = this.f;
            if (kx0Var != null) {
                kx0Var.c(sw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.fz0, com.baidu.tieba.tx0
    public void k(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sw0Var) == null) {
            super.k(sw0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(sw0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(sw0Var.c())) {
                sk0.a("AdLayer", "screen mode: " + sw0Var.c());
            }
            kx0 kx0Var = this.f;
            if (kx0Var != null) {
                kx0Var.c(sw0Var);
            }
        }
    }
}
