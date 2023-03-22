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
import com.baidu.tieba.lv0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ix0 extends dx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public ix0() {
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

    @Override // com.baidu.tieba.ex0
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
        jv0 jv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (jv0Var = this.f) != null) {
            jv0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.sv0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dx0, com.baidu.tieba.mx0, com.baidu.tieba.ex0, com.baidu.tieba.rx0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            U();
        }
    }

    public ix0(String str) {
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

    @Override // com.baidu.tieba.dx0
    public void Q(jv0 jv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv0Var) == null) {
            super.Q(jv0Var);
            jv0 jv0Var2 = this.f;
            if (jv0Var2 != null) {
                jv0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.dx0, com.baidu.tieba.tv0
    public boolean e(@NonNull ru0 ru0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ru0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(ru0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ex0, com.baidu.tieba.sv0
    public void n(@NonNull ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ru0Var) == null) {
            super.n(ru0Var);
            jv0 jv0Var = this.f;
            if (jv0Var != null) {
                jv0Var.c(ru0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ex0, com.baidu.tieba.sv0
    public void q(@NonNull ru0 ru0Var) {
        jv0 jv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, ru0Var) == null) && (jv0Var = this.f) != null) {
            jv0Var.c(ru0Var);
        }
    }

    public final void T() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            yr0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                nv0 a = lv0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
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
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof nv0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            nv0 nv0Var = (nv0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            nv0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.ex0, com.baidu.tieba.sv0
    public void d(@NonNull ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ru0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ru0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    V();
                } else {
                    S();
                }
            }
            jv0 jv0Var = this.f;
            if (jv0Var != null) {
                jv0Var.c(ru0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ex0, com.baidu.tieba.sv0
    public void k(@NonNull ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ru0Var) == null) {
            super.k(ru0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(ru0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(ru0Var.c())) {
                hj0.a("AdLayer", "screen mode: " + ru0Var.c());
            }
            jv0 jv0Var = this.f;
            if (jv0Var != null) {
                jv0Var.c(ru0Var);
            }
        }
    }
}
