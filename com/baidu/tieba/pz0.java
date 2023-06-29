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
import com.baidu.tieba.sx0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class pz0 extends kz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public pz0() {
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

    @Override // com.baidu.tieba.lz0
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
        qx0 qx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qx0Var = this.f) != null) {
            qx0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.zx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz0, com.baidu.tieba.tz0, com.baidu.tieba.lz0, com.baidu.tieba.yz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            U();
        }
    }

    public pz0(String str) {
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

    @Override // com.baidu.tieba.kz0
    public void Q(qx0 qx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qx0Var) == null) {
            super.Q(qx0Var);
            qx0 qx0Var2 = this.f;
            if (qx0Var2 != null) {
                qx0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.kz0, com.baidu.tieba.ay0
    public boolean e(@NonNull yw0 yw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yw0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(yw0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void n(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yw0Var) == null) {
            super.n(yw0Var);
            qx0 qx0Var = this.f;
            if (qx0Var != null) {
                qx0Var.c(yw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void q(@NonNull yw0 yw0Var) {
        qx0 qx0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, yw0Var) == null) && (qx0Var = this.f) != null) {
            qx0Var.c(yw0Var);
        }
    }

    public final void T() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            fu0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                ux0 a = sx0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
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
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof ux0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            ux0 ux0Var = (ux0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            ux0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void d(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yw0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(yw0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    V();
                } else {
                    S();
                }
            }
            qx0 qx0Var = this.f;
            if (qx0Var != null) {
                qx0Var.c(yw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void k(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yw0Var) == null) {
            super.k(yw0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(yw0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(yw0Var.c())) {
                ol0.a("AdLayer", "screen mode: " + yw0Var.c());
            }
            qx0 qx0Var = this.f;
            if (qx0Var != null) {
                qx0Var.c(yw0Var);
            }
        }
    }
}
