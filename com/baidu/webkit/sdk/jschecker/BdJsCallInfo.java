package com.baidu.webkit.sdk.jschecker;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public final class BdJsCallInfo implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mJsInterfaceName;
    public String mJsMethodName;
    public String mMethodDeclaration;
    public boolean mPermissionChecked;
    public String mUrl;
    public String mWebViewFrameName;

    public BdJsCallInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void finishPermissionCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPermissionChecked = true;
        }
    }

    public final String getJsInterfaceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mJsInterfaceName : (String) invokeV.objValue;
    }

    public final String getJsMethodDeclaration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMethodDeclaration : (String) invokeV.objValue;
    }

    public final String getJsMethodName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mJsMethodName : (String) invokeV.objValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public final String getWebViewFrameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWebViewFrameName : (String) invokeV.objValue;
    }

    public final boolean hasFinishedPermissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPermissionChecked : invokeV.booleanValue;
    }

    public final void setJsInterfaceName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mJsInterfaceName = str;
        }
    }

    public final void setJsMethodDeclaration(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mMethodDeclaration = str;
        }
    }

    public final void setJsMethodName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mJsMethodName = str;
        }
    }

    public final void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mUrl = str;
        }
    }

    public final void setWebViewFrameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mWebViewFrameName = str;
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "BdJsCallInfo{mJsInterfaceName='" + this.mJsInterfaceName + ExtendedMessageFormat.QUOTE + ", mMethodDeclaration='" + this.mMethodDeclaration + ExtendedMessageFormat.QUOTE + ", mPermissionChecked=" + this.mPermissionChecked + ", mUrl='" + this.mUrl + ExtendedMessageFormat.QUOTE + ", mWebViewFrameName='" + this.mWebViewFrameName + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
