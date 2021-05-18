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
    public static final String f24303a = WalletHomeMenuView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public HomeCfgResponse.TitleItemData[] f24304b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24305c;

    /* renamed from: d  reason: collision with root package name */
    public WalletMenuLayout f24306d;

    /* renamed from: e  reason: collision with root package name */
    public WalletMenuLayout.a f24307e;

    @SuppressLint({"NewApi"})
    public WalletHomeMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24305c = false;
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
        if (this.f24305c) {
            return;
        }
        Log.d(f24303a, "layout menu view");
        this.f24304b = titleItemDataArr;
        this.f24306d.setData(getContext(), str, titleItemDataArr, new WalletMenuLayout.a() { // from class: com.baidu.wallet.home.ui.widget.WalletHomeMenuView.1
            @Override // com.baidu.wallet.home.ui.widget.WalletMenuLayout.a
            public void a(HomeCfgResponse.TitleItemData titleItemData) {
                if (WalletHomeMenuView.this.f24307e == null || WalletHomeMenuView.this.f24304b == null) {
                    return;
                }
                WalletHomeMenuView.this.f24307e.a(titleItemData);
            }
        });
        this.f24305c = true;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.f24305c = false;
    }

    public void setMenuSelectListener(WalletMenuLayout.a aVar) {
        this.f24307e = aVar;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_menu_view"), this);
        WalletMenuLayout walletMenuLayout = (WalletMenuLayout) findViewById(ResUtils.id(getContext(), "listview"));
        this.f24306d = walletMenuLayout;
        walletMenuLayout.setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        setFocusableInTouchMode(true);
    }

    public WalletHomeMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24305c = false;
        a();
    }

    public WalletHomeMenuView(Context context) {
        super(context);
        this.f24305c = false;
        a();
    }
}
