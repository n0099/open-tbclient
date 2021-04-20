package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class O2OMenuItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26083a;

    /* renamed from: b  reason: collision with root package name */
    public String f26084b;

    public O2OMenuItemView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_o2o_menu_item_view"), this);
        this.f26083a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_o2o_menu_item_text"));
    }

    public String getString() {
        return this.f26084b;
    }

    public void updateItem(String str) {
        if (str == null) {
            return;
        }
        this.f26084b = str;
        this.f26083a.setText(str);
    }
}
