package com.baidu.wallet.personal.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.BdContextMenuView;
/* loaded from: classes5.dex */
public class BankCardDetailContextMenuView extends BdContextMenuView {
    public BankCardDetailContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @SuppressLint({"NewApi"})
    public BankCardDetailContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.wallet.base.widget.BdContextMenuView
    public String getBackgroundResId() {
        return "wallet_base_menu_bg_white";
    }

    @Override // com.baidu.wallet.base.widget.BdContextMenuView
    public String getMenuItemBackgroudResId(int i, int i2) {
        return "ebpay_transparent";
    }

    @Override // com.baidu.wallet.base.widget.BdContextMenuView
    public String getMenuItemViewLayoutId() {
        return "wallet_personal_bank_menu_item_view";
    }

    @Override // com.baidu.wallet.base.widget.BdContextMenuView
    public String getSeparatorResId() {
        return null;
    }
}
