package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.BdActionBar;
/* loaded from: classes5.dex */
public class BdLightAppActionBar extends BdActionBar {
    public BdLightAppActionBar(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.base.widget.BdActionBar
    public String getLayoutId() {
        return "wallet_langbrige_action_bar";
    }

    public BdLightAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BdLightAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
