package com.baidu.tieba;

import androidx.annotation.NonNull;
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
public class jg8 implements IDeviceInfoAppHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uc9 a;

    public jg8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
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
            uc9 uc9Var = this.a;
            if (uc9Var != null) {
                return new IDeviceInfoAppHost.OAIDResult(true, uc9Var.b(), this.a.a());
            }
            uc9 d = wc9.c(AppRuntime.getAppContext()).d();
            if (d != null) {
                this.a = d;
                return new IDeviceInfoAppHost.OAIDResult(true, d.b(), this.a.a());
            }
            return new IDeviceInfoAppHost.OAIDResult(false, null, null);
        }
        return (IDeviceInfoAppHost.OAIDResult) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? wf5.b() : (String) invokeV.objValue;
    }
}
