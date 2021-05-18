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
    public HomeCfgResponse.TitleItemData[] f24313a;

    /* renamed from: b  reason: collision with root package name */
    public String f24314b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24315c;

    /* renamed from: d  reason: collision with root package name */
    public d f24316d;

    /* renamed from: e  reason: collision with root package name */
    public String f24317e;

    public c(View view) {
        super(view);
        this.f24315c = view.getContext();
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
        walletHomeMenuView.layoutMenu(this.f24314b, this.f24313a);
        walletHomeMenuView.setMenuSelectListener(new WalletMenuLayout.a() { // from class: com.baidu.wallet.home.ui.widget.c.2
            @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
            public void a(HomeCfgResponse.TitleItemData titleItemData) {
                if (c.this.f24316d != null && c.this.f24316d.a(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr)) {
                    DXMSdkSAUtils.onEventWithValues("clickHomeMenu", Arrays.asList(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr));
                    PayStatisticsUtil.onEventWithValues("clickHomeMenu", Arrays.asList(titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr));
                } else {
                    com.baidu.wallet.home.a.a().a(c.this.f24315c, titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, titleItemData.getPrevlogin(), c.this.f24317e);
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
        this.f24317e = str2;
        removeAllItem();
        this.f24314b = str;
        this.f24313a = titleItemDataArr;
        if (titleItemDataArr == null || titleItemDataArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            HomeCfgResponse.TitleItemData[] titleItemDataArr2 = this.f24313a;
            if (i2 >= titleItemDataArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(titleItemDataArr2[i2].setting_name)) {
                add(i2, this.f24313a[i2].setting_name);
            }
            i2++;
        }
    }
}
