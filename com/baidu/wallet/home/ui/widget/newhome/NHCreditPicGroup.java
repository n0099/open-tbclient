package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.List;
/* loaded from: classes5.dex */
public class NHCreditPicGroup extends BaseItemLayout {
    public static final float WIDTH_DIVIDER = 15.0f;

    /* renamed from: a  reason: collision with root package name */
    public NHTitleView f24429a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24430b;

    public NHCreditPicGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_layout"), this);
        this.f24429a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_group_title"));
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_group_list"));
        this.f24430b = linearLayout;
        linearLayout.setOrientation(0);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24429a.setData(this.mConfigData, getWalletInterface());
        this.f24429a.setHasGap(this.mConfigData.isLayoutHasGap());
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - (DisplayUtils.dip2px(getContext(), 15.0f) * 3)) / 2;
        int i = (displayWidth * 5) / 8;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth, i);
        NHCreditPicItem nHCreditPicItem = new NHCreditPicItem(getContext());
        nHCreditPicItem.setData(this.mConfigData.list[0], getWalletInterface());
        this.f24430b.addView(nHCreditPicItem, layoutParams);
        if (this.mConfigData.list.length > 1) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(displayWidth, i);
            NHCreditPicItem nHCreditPicItem2 = new NHCreditPicItem(getContext());
            layoutParams2.setMargins(DisplayUtils.dip2px(getContext(), 15.0f), 0, 0, 0);
            nHCreditPicItem2.setData(this.mConfigData.list[1], getWalletInterface());
            this.f24430b.addView(nHCreditPicItem2, layoutParams2);
        }
    }

    public NHCreditPicGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
