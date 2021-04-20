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
    public static final String f24298a = WalletHomeMenuView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public HomeCfgResponse.TitleItemData[] f24299b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24300c;

    /* renamed from: d  reason: collision with root package name */
    public WalletMenuLayout f24301d;

    /* renamed from: e  reason: collision with root package name */
    public WalletMenuLayout.a f24302e;

    @SuppressLint({"NewApi"})
    public WalletHomeMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24300c = false;
        a();
    }

    public String getBackgroundResId() {
        return "wallet_base_menu_bg_white";
    }

    public String getMenuItemBackgroudResId(int i, int i2) {
        return null;
    }

    public int getSeparatorColor() {
        return -1381654;
    }

    public void layoutMenu(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr) {
        if (this.f24300c) {
            return;
        }
        Log.d(f24298a, "layout menu view");
        this.f24299b = titleItemDataArr;
        this.f24301d.setData(getContext(), str, titleItemDataArr, new WalletMenuLayout.a() { // from class: com.baidu.wallet.home.ui.widget.WalletHomeMenuView.1
            @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
            public void a(HomeCfgResponse.TitleItemData titleItemData) {
                if (WalletHomeMenuView.this.f24302e == null || WalletHomeMenuView.this.f24299b == null) {
                    return;
                }
                WalletHomeMenuView.this.f24302e.a(titleItemData);
            }
        });
        this.f24300c = true;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.f24300c = false;
    }

    public void setMenuSelectListener(WalletMenuLayout.a aVar) {
        this.f24302e = aVar;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_menu_view"), this);
        WalletMenuLayout walletMenuLayout = (WalletMenuLayout) findViewById(ResUtils.id(getContext(), "listview"));
        this.f24301d = walletMenuLayout;
        walletMenuLayout.setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        setFocusableInTouchMode(true);
    }

    public WalletHomeMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24300c = false;
        a();
    }

    public WalletHomeMenuView(Context context) {
        super(context);
        this.f24300c = false;
        a();
    }
}
