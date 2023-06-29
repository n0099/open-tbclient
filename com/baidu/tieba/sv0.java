package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes7.dex */
public class sv0 extends lz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public TextView h;

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void q(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yw0Var) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-419452641, "Lcom/baidu/tieba/sv0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-419452641, "Lcom/baidu/tieba/sv0$a;");
                    return;
                }
            }
            int[] iArr = new int[PlayerStatus.values().length];
            a = iArr;
            try {
                iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PlayerStatus.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public sv0() {
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

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return jx0.h().d(u().B(), u().L());
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h.setBackgroundColor(-65536);
        }
    }

    public final void O() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (M()) {
                i = DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK;
            } else {
                i = -65536;
            }
            this.h.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.yz0
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new int[]{4, 2, 5, 3};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lz0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.D();
            LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.nad_layer_debug_info_layout, null);
            this.e = linearLayout;
            this.f = (TextView) linearLayout.findViewById(R.id.text_version_code);
            this.g = (TextView) this.e.findViewById(R.id.text_status);
            this.h = (TextView) this.e.findViewById(R.id.text_pcdn_status);
            this.g.setText(PlayerStatus.IDLE.name());
        }
    }

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            this.g.setText(playerStatus.name());
            int i = a.a[playerStatus.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    N();
                    return;
                }
                return;
            }
            O();
        }
    }
}
