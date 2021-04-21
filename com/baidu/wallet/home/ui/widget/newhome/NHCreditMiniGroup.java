package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHCreditMiniGroup extends BaseItemLayout {
    public static final float HIEGHT = 98.5f;
    public static final int ITEM_LIMIT = 12;
    public static final float WIDTH_DIVIDER = 15.0f;

    /* renamed from: a  reason: collision with root package name */
    public NHTitleView f24430a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24431b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24432c;

    public NHCreditMiniGroup(Context context) {
        super(context);
        this.f24432c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24432c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_mini_layout"), this);
        this.f24430a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_mini_title"));
        this.f24431b = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_mini_layout"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        int dip2px;
        this.f24430a.setData(this.mConfigData, getWalletInterface());
        this.f24430a.setHasGap(this.mConfigData.isLayoutHasGap());
        int displayWidth = DisplayUtils.getDisplayWidth(getContext());
        if (this.mConfigData.list.length <= 2) {
            this.f24431b.setLayoutParams(new FrameLayout.LayoutParams(displayWidth, -2));
            dip2px = (int) ((displayWidth - (DisplayUtils.dip2px(getContext(), 15.0f) * 3.0f)) / 2.0f);
        } else {
            this.f24431b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            dip2px = (int) ((displayWidth - (DisplayUtils.dip2px(getContext(), 15.0f) * 3.0f)) / 2.2d);
        }
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = 12 >= dataItemArr.length ? dataItemArr.length : 12;
        for (int i = 0; i < length; i++) {
            NHCreditMiniItem nHCreditMiniItem = new NHCreditMiniItem(getContext());
            nHCreditMiniItem.setData(this.mConfigData.list[i], getWalletInterface());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, DisplayUtils.dip2px(getContext(), 98.5f));
            layoutParams.width = dip2px;
            layoutParams.setMargins(DisplayUtils.dip2px(getContext(), 15.0f), 0, 0, 0);
            this.f24431b.addView(nHCreditMiniItem, layoutParams);
            this.f24432c.add(nHCreditMiniItem);
        }
        this.f24431b.addView(new View(getContext()), new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 15.0f), DisplayUtils.dip2px(getContext(), 98.5f)));
    }

    public NHCreditMiniGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24432c = new ArrayList();
    }
}
