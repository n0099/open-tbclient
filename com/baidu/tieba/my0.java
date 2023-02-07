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
import com.baidu.tieba.pw0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class my0 extends hy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public my0() {
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

    @Override // com.baidu.tieba.iy0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
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

    public void S() {
        nw0 nw0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (nw0Var = this.f) != null) {
            nw0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.ww0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hy0, com.baidu.tieba.qy0, com.baidu.tieba.iy0, com.baidu.tieba.vy0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    public my0(String str) {
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

    @Override // com.baidu.tieba.hy0
    public void O(nw0 nw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nw0Var) == null) {
            super.O(nw0Var);
            nw0 nw0Var2 = this.f;
            if (nw0Var2 != null) {
                nw0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.hy0, com.baidu.tieba.xw0
    public boolean e(@NonNull vv0 vv0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vv0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(vv0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void n(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vv0Var) == null) {
            super.n(vv0Var);
            nw0 nw0Var = this.f;
            if (nw0Var != null) {
                nw0Var.c(vv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void q(@NonNull vv0 vv0Var) {
        nw0 nw0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, vv0Var) == null) && (nw0Var = this.f) != null) {
            nw0Var.c(vv0Var);
        }
    }

    public final void R() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            ct0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                rw0 a = pw0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(u.V0());
                O(a);
            }
        }
    }

    public final void T() {
        BdVideoSeries o1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof rw0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            rw0 rw0Var = (rw0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            rw0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void d(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vv0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(vv0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            nw0 nw0Var = this.f;
            if (nw0Var != null) {
                nw0Var.c(vv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void k(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vv0Var) == null) {
            super.k(vv0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(vv0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(vv0Var.c())) {
                nk0.a("AdLayer", "screen mode: " + vv0Var.c());
            }
            nw0 nw0Var = this.f;
            if (nw0Var != null) {
                nw0Var.c(vv0Var);
            }
        }
    }
}
