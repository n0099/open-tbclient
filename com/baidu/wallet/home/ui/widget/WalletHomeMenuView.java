package com.baidu.wallet.home.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.WalletMenuLayout;
/* loaded from: classes5.dex */
public class WalletHomeMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25058a = WalletHomeMenuView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public HomeCfgResponse.TitleItemData[] f25059b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25060c;

    /* renamed from: d  reason: collision with root package name */
    public WalletMenuLayout f25061d;

    /* renamed from: e  reason: collision with root package name */
    public WalletMenuLayout.a f25062e;

    @SuppressLint({"NewApi"})
    public WalletHomeMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25060c = false;
        a();
    }

    public String getBackgroundResId() {
        return "wallet_base_menu_bg_white";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public int getSeparatorColor() {
        return -1381654;
    }

    public void layoutMenu(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr) {
        if (this.f25060c) {
            return;
        }
        Log.d(f25058a, "layout menu view");
        this.f25059b = titleItemDataArr;
        this.f25061d.setData(getContext(), str, titleItemDataArr, new WalletMenuLayout.a() { // from class: com.baidu.wallet.home.ui.widget.WalletHomeMenuView.1
            @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
            public void a(HomeCfgResponse.TitleItemData titleItemData) {
                if (WalletHomeMenuView.this.f25062e == null || WalletHomeMenuView.this.f25059b == null) {
                    return;
                }
                WalletHomeMenuView.this.f25062e.a(titleItemData);
            }
        });
        this.f25060c = true;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.f25060c = false;
    }

    public void setMenuSelectListener(WalletMenuLayout.a aVar) {
        this.f25062e = aVar;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_menu_view"), this);
        WalletMenuLayout walletMenuLayout = (WalletMenuLayout) findViewById(ResUtils.id(getContext(), "listview"));
        this.f25061d = walletMenuLayout;
        walletMenuLayout.setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        setFocusableInTouchMode(true);
    }

    public WalletHomeMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25060c = false;
        a();
    }

    public WalletHomeMenuView(Context context) {
        super(context);
        this.f25060c = false;
        a();
    }
}
