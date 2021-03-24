package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.ui.widget.credithome.CHNoticeBarGroup;
/* loaded from: classes5.dex */
public class UMHNoticeBarGroup extends CHNoticeBarGroup {
    public UMHNoticeBarGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.credithome.CHNoticeBarGroup, com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        super.initView();
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_background"));
        this.flipper.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_notice_background"));
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_card_notice_view_parent"));
        if (linearLayout != null) {
            linearLayout.setPadding(0, 0, 0, DisplayUtils.dip2px(getContext(), 10.0f));
        }
    }

    public UMHNoticeBarGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
