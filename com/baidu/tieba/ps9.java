package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.BrowserType;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.util.IBaiduIdentityContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ps9 implements IBaiduIdentityContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public byte[] encryptByNativeBds(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? new byte[0] : (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getAppMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getBDVCInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getIid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean getJoinUserExperiencePreference(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getLocString(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i)) == null) {
            return null;
        }
        return (String) invokeLI.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getLocationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getMatrixstyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getOEMChannel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getOsBranch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getPassUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean getPrivacySwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String[] getProcessUARegex(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) ? new String[0] : (String[]) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getSearchBoxTypeId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getTn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean isAgreePrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean isBlinkEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean isDataFlowPopDialog(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean isPeakTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public boolean isSelfUpdateInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public CookieManager obtainCookieManager(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return null;
        }
        return (CookieManager) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String processUrlExternal(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, str, z)) == null) {
            return null;
        }
        return (String) invokeLZ.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public String processUserAgentExternal(String str, BrowserType browserType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, browserType)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.util.IBaiduIdentityContext
    public void setCookieManualNoBdussOperate(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048601, this, str, str2, z) == null) {
        }
    }

    public ps9() {
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
}
