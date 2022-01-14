package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.WalletMenuLayout;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes13.dex */
public class c extends BdMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomeCfgResponse.TitleItemData[] a;

    /* renamed from: b  reason: collision with root package name */
    public String f51162b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51163c;

    /* renamed from: d  reason: collision with root package name */
    public d f51164d;

    /* renamed from: e  reason: collision with root package name */
    public String f51165e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51163c = view.getContext();
        setDismissOnClick(true);
        setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                }
            }
        });
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, list) == null) {
            WalletHomeMenuView walletHomeMenuView = (WalletHomeMenuView) view;
            walletHomeMenuView.layoutMenu(this.f51162b, this.a);
            walletHomeMenuView.setMenuSelectListener(new WalletMenuLayout.a(this) { // from class: com.baidu.wallet.home.ui.widget.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
                public void a(HomeCfgResponse.TitleItemData titleItemData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, titleItemData) == null) {
                        if (this.a.f51164d != null && this.a.f51164d.a(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr)) {
                            DXMSdkSAUtils.onEventWithValues("clickHomeMenu", Arrays.asList(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, HomeCfgResponse.getUserStatus()));
                        } else {
                            com.baidu.wallet.home.a.a().a(this.a.f51163c, titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, titleItemData.getPrevlogin(), this.a.f51165e);
                        }
                        this.a.dismiss();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public View getMenuView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            WalletHomeMenuView walletHomeMenuView = new WalletHomeMenuView(context);
            walletHomeMenuView.setPadding(0, (int) ResUtils.getDimension(context, "bd_wallet_base_menu_margin"), (int) ResUtils.getDimension(context, "bd_wallet_base_menu_margin"), 0);
            return walletHomeMenuView;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, popupWindow) == null) {
            popupWindow.showAsDropDown(this.mViewToAttach);
        }
    }

    public void a(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048576, this, str, titleItemDataArr, str2) != null) {
            return;
        }
        this.f51165e = str2;
        removeAllItem();
        this.f51162b = str;
        this.a = titleItemDataArr;
        if (titleItemDataArr == null || titleItemDataArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            HomeCfgResponse.TitleItemData[] titleItemDataArr2 = this.a;
            if (i2 >= titleItemDataArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(titleItemDataArr2[i2].setting_name)) {
                add(i2, this.a[i2].setting_name);
            }
            i2++;
        }
    }
}
