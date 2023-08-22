package com.baidu.tieba;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.NadBrowserContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class xq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NadBrowserContainer a;

    public xq0(uq0 frameContext, vq0 frameExtHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameContext, frameExtHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(frameContext, "frameContext");
        Intrinsics.checkNotNullParameter(frameExtHandler, "frameExtHandler");
        this.a = new NadBrowserContainer(frameContext, frameExtHandler, null);
    }

    public final void a() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.u0(false);
        }
    }

    public final Integer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                return Integer.valueOf(nadBrowserContainer.W());
            }
            return null;
        }
        return (Integer) invokeV.objValue;
    }

    public final void c() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.u();
        }
    }

    public final void d() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.onDestroy();
        }
    }

    public final void f() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.onPause();
        }
    }

    public final void g() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.w();
        }
    }

    public final void h() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.x();
        }
    }

    public final void i() {
        NadBrowserContainer nadBrowserContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (nadBrowserContainer = this.a) != null) {
            nadBrowserContainer.y();
        }
    }

    public final View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                return nadBrowserContainer.U();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final boolean e(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, keyEvent)) == null) {
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                return nadBrowserContainer.onKeyDown(i, keyEvent);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void k(JSONObject jSONObject) {
        Intent q;
        Intent q2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) && jSONObject != null) {
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null && (q2 = nadBrowserContainer.q()) != null) {
                q2.putExtra("immersive_video_stay_time", jSONObject.optString("immersive_video_stay_time"));
            }
            NadBrowserContainer nadBrowserContainer2 = this.a;
            if (nadBrowserContainer2 != null && (q = nadBrowserContainer2.q()) != null) {
                q.putExtra("immersive_webview_first_show_time", jSONObject.optString("immersive_webview_first_show_time"));
            }
        }
    }
}
