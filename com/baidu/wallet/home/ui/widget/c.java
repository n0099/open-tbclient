package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.WalletMenuLayout;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BdMenu {

    /* renamed from: a  reason: collision with root package name */
    public HomeCfgResponse.TitleItemData[] f24622a;

    /* renamed from: b  reason: collision with root package name */
    public String f24623b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24624c;

    /* renamed from: d  reason: collision with root package name */
    public d f24625d;

    /* renamed from: e  reason: collision with root package name */
    public String f24626e;

    public c(View view) {
        super(view);
        this.f24624c = view.getContext();
        setDismissOnClick(true);
        setMenuItemClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.home.ui.widget.c.1
            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem) {
            }
        });
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        WalletHomeMenuView walletHomeMenuView = (WalletHomeMenuView) view;
        walletHomeMenuView.layoutMenu(this.f24623b, this.f24622a);
        walletHomeMenuView.setMenuSelectListener(new WalletMenuLayout.a() { // from class: com.baidu.wallet.home.ui.widget.c.2
            @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
            public void a(HomeCfgResponse.TitleItemData titleItemData) {
                if (c.this.f24625d != null && c.this.f24625d.a(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr)) {
                    DXMSdkSAUtils.onEventWithValues("clickHomeMenu", Arrays.asList(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr));
                    PayStatisticsUtil.onEventWithValues("clickHomeMenu", Arrays.asList(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr));
                } else {
                    com.baidu.wallet.home.a.a().a(c.this.f24624c, titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, titleItemData.getPrevlogin(), c.this.f24626e);
                }
                c.this.dismiss();
            }
        });
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public View getMenuView(Context context) {
        WalletHomeMenuView walletHomeMenuView = new WalletHomeMenuView(context);
        walletHomeMenuView.setPadding(0, (int) ResUtils.getDimension(context, "bd_wallet_base_menu_margin"), (int) ResUtils.getDimension(context, "bd_wallet_base_menu_margin"), 0);
        return walletHomeMenuView;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        popupWindow.showAsDropDown(this.mViewToAttach);
    }

    public void a(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, String str2) {
        this.f24626e = str2;
        removeAllItem();
        this.f24623b = str;
        this.f24622a = titleItemDataArr;
        if (titleItemDataArr == null || titleItemDataArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            HomeCfgResponse.TitleItemData[] titleItemDataArr2 = this.f24622a;
            if (i >= titleItemDataArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(titleItemDataArr2[i].setting_name)) {
                add(i, this.f24622a[i].setting_name);
            }
            i++;
        }
    }
}
