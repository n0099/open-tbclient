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
import com.baidu.tieba.ls0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class iu0 extends du0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public iu0() {
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

    @Override // com.baidu.tieba.eu0
    public void G() {
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
        js0 js0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (js0Var = this.f) != null) {
            js0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.mu0, com.baidu.tieba.eu0, com.baidu.tieba.ru0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            U();
        }
    }

    public iu0(String str) {
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

    @Override // com.baidu.tieba.du0
    public void Q(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var) == null) {
            super.Q(js0Var);
            js0 js0Var2 = this.f;
            if (js0Var2 != null) {
                js0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.ts0
    public boolean e(@NonNull sr0 sr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sr0Var)) == null) {
            if (x().P0()) {
                return false;
            }
            return super.e(sr0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void n(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sr0Var) == null) {
            super.n(sr0Var);
            js0 js0Var = this.f;
            if (js0Var != null) {
                js0Var.c(sr0Var);
            }
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void q(@NonNull sr0 sr0Var) {
        js0 js0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, sr0Var) == null) && (js0Var = this.f) != null) {
            js0Var.c(sr0Var);
        }
    }

    public final void T() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries j1 = x().j1();
            zo0 x = x();
            if (j1 != null && x != null && (videoAd = j1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                ns0 a = ls0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(x.Q0());
                Q(a);
            }
        }
    }

    public final void V() {
        BdVideoSeries j1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof ns0) || (j1 = x().j1()) == null) {
                return;
            }
            BdVideoAd videoAd = j1.getVideoAd();
            ns0 ns0Var = (ns0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            ns0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void d(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sr0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(sr0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    V();
                } else {
                    S();
                }
            }
            js0 js0Var = this.f;
            if (js0Var != null) {
                js0Var.c(sr0Var);
            }
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void k(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sr0Var) == null) {
            super.k(sr0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(sr0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(sr0Var.c())) {
                pf0.a("AdLayer", "screen mode: " + sr0Var.c());
            }
            js0 js0Var = this.f;
            if (js0Var != null) {
                js0Var.c(sr0Var);
            }
        }
    }
}
