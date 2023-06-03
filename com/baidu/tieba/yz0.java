package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.c61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yz0 extends pz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz0 a;

        public a(yz0 yz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u().l();
            }
        }
    }

    public yz0() {
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

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e21.a("hidePoster()");
            this.e.setVisibility(8);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e21.a("showPoster()");
            this.e.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.uz0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return z();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 5, 3};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pz0, com.baidu.tieba.hz0, com.baidu.tieba.uz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            this.e.o("");
        }
    }

    @Override // com.baidu.tieba.hz0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.D();
            AdImageView adImageView = (AdImageView) LayoutInflater.from(this.c).inflate(R.layout.nad_bd_layer_poster_layout, z()).findViewById(R.id.image_poster);
            this.e = adImageView;
            adImageView.setVisibility(8);
            if (this.e.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.e.getLayoutParams()).gravity = 17;
            }
        }
    }

    public final void P() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e21.a("loadPoster()");
            BdVideoSeries o1 = u().o1();
            if (o1 != null) {
                str = o1.getPoster();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
                return;
            }
            this.e.q(str);
            N(u().V0());
            this.e.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.hz0
    public void H(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uw0Var) == null) {
            super.H(uw0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int i2 = -1;
            if (z) {
                if (c61.c.c(this.c) < c61.c.e(this.c)) {
                    i2 = (c61.c.c(this.c) * 16) / 9;
                } else {
                    i = (c61.c.e(this.c) * 9) / 16;
                    if (this.e.getLayoutParams() == null) {
                        this.e.getLayoutParams().width = i2;
                        this.e.getLayoutParams().height = i;
                        return;
                    }
                    return;
                }
            }
            i = -1;
            if (this.e.getLayoutParams() == null) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hz0, com.baidu.tieba.vx0
    public void d(@NonNull uw0 uw0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uw0Var) == null) {
            String c2 = uw0Var.c();
            switch (c2.hashCode()) {
                case -1043170264:
                    if (c2.equals(PlayerEvent.ACTION_PLAYER_ATTACH)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -971135626:
                    if (c2.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1370689931:
                    if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1 && c != 2) {
                    if (c == 3) {
                        this.e.o("");
                        return;
                    }
                    return;
                }
                P();
                return;
            }
            int g = uw0Var.g(1);
            if (g == 904 || g == 956) {
                O();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hz0, com.baidu.tieba.vx0
    public void k(@NonNull uw0 uw0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uw0Var) == null) {
            String c2 = uw0Var.c();
            switch (c2.hashCode()) {
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1554330967:
                    if (c2.equals(LayerEvent.ACTION_HIDE_POSTER)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2062901052:
                    if (c2.equals(LayerEvent.ACTION_SHOW_POSTER)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3) {
                            N(false);
                            return;
                        }
                        return;
                    }
                    N(true);
                    return;
                }
                O();
                return;
            }
            Q();
        }
    }

    @Override // com.baidu.tieba.hz0, com.baidu.tieba.vx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                O();
            } else if (playerStatus == PlayerStatus.PREPARING) {
                Q();
            }
        }
    }
}
