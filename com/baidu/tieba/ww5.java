package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ww5 implements ILiveFeedPageInvoke {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountManagerService a;
    public AppInfoService b;
    public ToastService c;
    public RouterService d;

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public String getIID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public ww5() {
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
        this.a = (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
        this.b = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.c = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.d = (RouterService) ServiceManager.getService(RouterService.Companion.getSERVICE_REFERENCE());
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public String getCuid() {
        InterceptResult invokeV;
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a != null && (appInfoService = this.b) != null) {
                return this.a.getSocialEncryption(appInfoService.getCuid(), "baiduuid_");
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public String getUIMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                return "night";
            }
            if (skinType == 4) {
                return "dark";
            }
            return "day";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public String getUK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AccountManagerService accountManagerService = this.a;
            if (accountManagerService != null) {
                return accountManagerService.getAccount().getUk();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public void invokeScheme(Context context, String str) {
        RouterService routerService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) && context != null && !TextUtils.isEmpty(str) && (routerService = this.d) != null) {
            routerService.invokeScheme(context, str);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke
    public void showToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) && this.c != null && context != null && !TextUtils.isEmpty(str)) {
            this.c.showNormal(context, str, 0);
        }
    }
}
