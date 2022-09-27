package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.IDeviceInfoAppHost;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes4.dex */
public class ki8 implements IDeviceInfoAppHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IDeviceInfoAppHost.OAIDResult a;

    public ki8() {
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

    @NonNull
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (str == null || TextUtils.isEmpty(str)) ? "" : new e50("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(str.getBytes()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppIdentityManager.getInstance().getAppName() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getEnUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PermissionUtil.isAgreePrivacyPolicy() ? AppCuidRuntime.getAppCuidManager().getEnCuid() : "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    public long getForceMappingCacheInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 86400000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public IDeviceInfoAppHost.OAIDResult getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IDeviceInfoAppHost.OAIDResult oAIDResult = this.a;
            if (oAIDResult != null) {
                return oAIDResult;
            }
            String f = s20.e(AppRuntime.getAppContext()).f();
            IDeviceInfoAppHost.OAIDResult oAIDResult2 = new IDeviceInfoAppHost.OAIDResult(true, f, a(f));
            this.a = oAIDResult2;
            return oAIDResult2;
        }
        return (IDeviceInfoAppHost.OAIDResult) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? gj.l() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    public boolean useMapping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
