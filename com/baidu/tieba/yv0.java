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
import com.baidu.tieba.bu0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class yv0 extends tv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public yv0() {
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

    @Override // com.baidu.tieba.uv0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
        }
    }

    @Override // com.baidu.tieba.tv0
    public void O(zt0 zt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zt0Var) == null) {
            super.O(zt0Var);
            zt0 zt0Var2 = this.f;
            if (zt0Var2 != null) {
                zt0Var2.d(this);
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                R();
            }
        }
    }

    public final void R() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            oq0 u = u();
            if (o1 == null || u == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            du0 a = bu0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(u.V0());
            O(a);
        }
    }

    public void S() {
        zt0 zt0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (zt0Var = this.f) == null) {
            return;
        }
        zt0Var.onDestroy();
        this.f = null;
    }

    public final void T() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) && (this.f instanceof du0) && (o1 = u().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((du0) this.f).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void d(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ht0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ht0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            zt0 zt0Var = this.f;
            if (zt0Var != null) {
                zt0Var.c(ht0Var);
            }
        }
    }

    @Override // com.baidu.tieba.tv0, com.baidu.tieba.ju0
    public boolean e(@NonNull ht0 ht0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ht0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(ht0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iu0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void k(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ht0Var) == null) {
            super.k(ht0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(ht0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(ht0Var.c())) {
                jj0.a("AdLayer", "screen mode: " + ht0Var.c());
            }
            zt0 zt0Var = this.f;
            if (zt0Var != null) {
                zt0Var.c(ht0Var);
            }
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void n(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ht0Var) == null) {
            super.n(ht0Var);
            zt0 zt0Var = this.f;
            if (zt0Var != null) {
                zt0Var.c(ht0Var);
            }
        }
    }

    @Override // com.baidu.tieba.tv0, com.baidu.tieba.cw0, com.baidu.tieba.uv0, com.baidu.tieba.hw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void q(@NonNull ht0 ht0Var) {
        zt0 zt0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ht0Var) == null) || (zt0Var = this.f) == null) {
            return;
        }
        zt0Var.c(ht0Var);
    }

    public yv0(String str) {
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
}
