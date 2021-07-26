package com.bytedance.sdk.openadsdk.core;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public w f31164a;

    public x(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31164a = wVar;
    }

    public void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) {
            this.f31164a = wVar;
        }
    }

    @JavascriptInterface
    public String adInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            w wVar = this.f31164a;
            return wVar != null ? wVar.adInfo() : "";
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String appInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            w wVar = this.f31164a;
            return wVar != null ? wVar.appInfo() : "";
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            w wVar = this.f31164a;
            return wVar != null ? wVar.getCurrentVideoState() : "";
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            w wVar = this.f31164a;
            return wVar != null ? wVar.getTemplateInfo() : "";
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public void initRenderFinish() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.renderDidFinish(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (wVar = this.f31164a) == null) {
            return;
        }
        wVar.skipVideo();
    }
}
