package com.baidu.wallet.home.ui.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes13.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.home.ui.a.a f51320b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51321c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.TitleConfig f51322d;

    public a(com.baidu.wallet.home.ui.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51321c = false;
        this.f51320b = aVar;
    }

    private void b(Context context, HomeCfgResponse.TitleItemData titleItemData) {
        com.baidu.wallet.home.ui.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, context, titleItemData) == null) || (aVar = this.f51320b) == null) {
            return;
        }
        aVar.refreshRightZoneDot(a(context, titleItemData));
    }

    public void a(Context context, String str, HomeCfgResponse.TitleConfig titleConfig, String str2) {
        HomeCfgResponse.TitleItem[] titleItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, titleConfig, str2) == null) {
            this.a = str2;
            com.baidu.wallet.home.ui.a.a aVar = this.f51320b;
            if (aVar == null) {
                return;
            }
            if (titleConfig != null && (titleItemArr = titleConfig.data) != null && titleItemArr.length > 0) {
                aVar.refreshRightZoneDot(false);
                this.f51322d = titleConfig;
                if (!TextUtils.isEmpty(titleConfig.data[0].titlebar)) {
                    this.f51320b.refreshTitle(titleConfig.data[0].titlebar);
                }
                this.f51320b.refreshSafeTip(titleConfig.data[0].safe_title);
                HomeCfgResponse.TitleItem[] titleItemArr2 = titleConfig.data;
                if (titleItemArr2[0].list != null && titleItemArr2[0].list.length >= 1) {
                    if (titleItemArr2[0].list.length > 1) {
                        this.f51321c = true;
                        this.f51320b.refreshRightZone(ResUtils.drawable(context, "wallet_base_actionbar_more"));
                        this.f51320b.refreshMenu(str, titleConfig.data[0].list, this.a);
                        return;
                    } else if (titleItemArr2[0].list.length == 1) {
                        HomeCfgResponse.TitleItemData titleItemData = titleItemArr2[0].list[0];
                        if (titleItemData != null && !TextUtils.isEmpty(titleItemData.setting_addr) && !TextUtils.isEmpty(titleItemData.setting_type)) {
                            this.f51320b.refreshRightZone(ResUtils.drawable(context, a(this.a)));
                            b(context, titleItemData);
                            this.f51321c = false;
                            String str3 = titleConfig.data[0].list[0].setting_icon;
                            if (TextUtils.isEmpty(str3)) {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            this.f51320b.refreshRightZone(str + str3);
                            return;
                        }
                        this.f51320b.hideRightZone();
                        return;
                    } else {
                        return;
                    }
                }
                this.f51320b.hideRightZone();
                return;
            }
            this.f51320b.hideRightZone();
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.f51321c) {
                com.baidu.wallet.home.ui.a.a aVar = this.f51320b;
                if (aVar != null) {
                    aVar.showMenu();
                }
            } else if (this.f51322d.checkTitleConfig()) {
                HomeCfgResponse.TitleItem[] titleItemArr = this.f51322d.data;
                if (titleItemArr[0].list == null || titleItemArr[0].list.length <= 0 || titleItemArr[0].list[0] == null || TextUtils.isEmpty(titleItemArr[0].list[0].setting_addr)) {
                    return;
                }
                HomeCfgResponse.TitleItemData titleItemData = this.f51322d.data[0].list[0];
                if (a(context, titleItemData)) {
                    if (!TextUtils.isEmpty(titleItemData.getLinkAddr())) {
                        com.baidu.wallet.home.storage.a.a(context, titleItemData.getLinkAddr(), TextUtils.isEmpty(titleItemData.getTimeStamp()) ? "0" : titleItemData.getTimeStamp());
                    }
                    b(context, titleItemData);
                }
                com.baidu.wallet.home.a.a().a(context, titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, false, this.a);
            }
        }
    }

    public boolean a(Context context, HomeCfgResponse.TitleItemData titleItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, titleItemData)) == null) ? titleItemData != null && ("2".equalsIgnoreCase(titleItemData.timestamp_icon) || "1".equalsIgnoreCase(titleItemData.timestamp_icon)) && titleItemData.isShoudShowPoint(context) : invokeLL.booleanValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? HomeCfgBean.PAGE_FINANCE.equals(str) ? "wallet_home_go_wallet_logo" : "wallet_home_go_security_center" : (String) invokeL.objValue;
    }
}
