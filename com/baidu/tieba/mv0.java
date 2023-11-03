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
import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mv0 extends dv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv0 a;

        public a(mv0 mv0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y().l();
            }
        }
    }

    public mv0() {
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

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ix0.a("hidePoster()");
            this.e.setVisibility(8);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ix0.a("showPoster()");
            this.e.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.iv0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return B();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jt0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 5, 3};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dv0, com.baidu.tieba.vu0, com.baidu.tieba.iv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            this.e.r("");
        }
    }

    @Override // com.baidu.tieba.vu0
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.F();
            AdImageView adImageView = (AdImageView) LayoutInflater.from(this.c).inflate(R.layout.nad_bd_layer_poster_layout, B()).findViewById(R.id.image_poster);
            this.e = adImageView;
            adImageView.setVisibility(8);
            if (this.e.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.e.getLayoutParams()).gravity = 17;
            }
        }
    }

    public final void Q() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ix0.a("loadPoster()");
            BdVideoSeries j1 = y().j1();
            if (j1 != null) {
                str = j1.getPoster();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
                return;
            }
            this.e.C(str, false);
            O(y().Q0());
            this.e.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.vu0
    public void J(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var) == null) {
            super.J(js0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int i2 = -1;
            if (z) {
                if (t11.c.c(this.c) < t11.c.e(this.c)) {
                    i2 = (t11.c.c(this.c) * 16) / 9;
                } else {
                    i = (t11.c.e(this.c) * 9) / 16;
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
    @Override // com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void d(@NonNull js0 js0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, js0Var) == null) {
            String c2 = js0Var.c();
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
                        this.e.r("");
                        return;
                    }
                    return;
                }
                Q();
                return;
            }
            int g = js0Var.g(1);
            if (g == 904 || g == 956) {
                P();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void l(@NonNull js0 js0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, js0Var) == null) {
            String c2 = js0Var.c();
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
                            O(false);
                            return;
                        }
                        return;
                    }
                    O(true);
                    return;
                }
                P();
                return;
            }
            R();
        }
    }

    @Override // com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                P();
            } else if (playerStatus == PlayerStatus.PREPARING) {
                R();
            }
        }
    }
}
