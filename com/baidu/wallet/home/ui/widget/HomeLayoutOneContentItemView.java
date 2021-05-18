package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class HomeLayoutOneContentItemView extends BaseItemView {
    public static final String TAG = "HomeFinanceContentItemView";

    /* renamed from: a  reason: collision with root package name */
    public View f24271a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24272b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24273c;
    public MaskTextView mDesc_1;
    public MaskTextView mDesc_2;
    public NetImageView mIcon;
    public MaskTextView mTitle;

    public HomeLayoutOneContentItemView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_layout1_item_layout"), this);
        this.f24271a = findViewById(ResUtils.id(getContext(), "content_layout"));
        this.mIcon = (NetImageView) findViewById(ResUtils.id(getContext(), "home_finance_item_icon"));
        this.mTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_title"));
        this.mDesc_1 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_des_1"));
        this.mDesc_2 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_des_2"));
        this.f24272b = (NetImageView) findViewById(ResUtils.id(getContext(), "red_dot_im"));
        this.f24273c = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
    }

    public static int getItemHeight(Context context, HomeCfgResponse.DataItem[] dataItemArr) {
        int dimension = (int) ResUtils.getDimension(context, "bd_wallet_home_item_finace_two_line_height");
        if (dataItemArr == null || dataItemArr.length <= 0) {
            return dimension;
        }
        for (int i2 = 0; i2 < dataItemArr.length; i2++) {
            if (dataItemArr[i2] != null && !TextUtils.isEmpty(dataItemArr[i2].value1) && !TextUtils.isEmpty(dataItemArr[i2].value2)) {
                return (int) ResUtils.getDimension(context, "bd_wallet_home_item_finace_three_line_height");
            }
        }
        return dimension;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        if (isShoudShowPoint()) {
            this.f24272b.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.f24272b.getLayoutParams()).addRule(1, this.mTitle.getId());
            ((RelativeLayout.LayoutParams) this.f24272b.getLayoutParams()).addRule(6, this.mTitle.getId());
            ((RelativeLayout.LayoutParams) this.f24272b.getLayoutParams()).leftMargin = (int) (ResUtils.getDimension(getContext(), "bd_wallet_home_icon_flag_text_right_margin") - ResUtils.getDimension(getContext(), "bd_wallet_home_item_life_margin"));
            this.f24272b.setImageDrawable(ResUtils.getDrawable(getContext(), isShowWhiteDot() ? "wallet_home_white_star" : "wallet_home_red_star"));
            return true;
        }
        this.f24272b.setVisibility(8);
        return false;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        MaskTextView maskTextView = this.mTitle;
        if (maskTextView != null) {
            maskTextView.resetMaskText();
        }
        MaskTextView maskTextView2 = this.mDesc_1;
        if (maskTextView2 != null) {
            maskTextView2.resetMaskText();
        }
        MaskTextView maskTextView3 = this.mDesc_2;
        if (maskTextView3 != null) {
            maskTextView3.resetMaskText();
        }
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        a();
        setTitle(getData().name);
        if (!TextUtils.isEmpty(getData().value1)) {
            setDesc1(getData().value1);
            setDesc1Visibility(0);
        } else {
            setDesc1Visibility(8);
        }
        if (!TextUtils.isEmpty(getData().value2)) {
            setDesc2(getData().value2);
            setDesc2Visibility(0);
        } else {
            setDesc2Visibility(8);
        }
        setIconUrl(getData().logo);
        if (!handlePoint() && hasCornor()) {
            this.f24273c.setVisibility(0);
            NetImageView netImageView = this.f24273c;
            netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f24273c.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public void setDesc1(String str) {
        MaskTextView maskTextView = this.mDesc_1;
        if (maskTextView != null) {
            maskTextView.setMaskText(str);
        }
    }

    public void setDesc1Visibility(int i2) {
        MaskTextView maskTextView = this.mDesc_1;
        if (maskTextView == null || maskTextView.getVisibility() == i2) {
            return;
        }
        this.mDesc_1.setVisibility(i2);
    }

    public void setDesc2(String str) {
        MaskTextView maskTextView = this.mDesc_2;
        if (maskTextView != null) {
            maskTextView.setMaskText(str);
        }
    }

    public void setDesc2Visibility(int i2) {
        MaskTextView maskTextView = this.mDesc_2;
        if (maskTextView == null || maskTextView.getVisibility() == i2) {
            return;
        }
        this.mDesc_2.setVisibility(i2);
    }

    public void setHeight(int i2) {
        this.f24271a.getLayoutParams().height = i2;
    }

    public void setIconUrl(String str) {
        if (this.mIcon == null || TextUtils.isEmpty(str)) {
            return;
        }
        NetImageView netImageView = this.mIcon;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    public void setTitle(String str) {
        MaskTextView maskTextView = this.mTitle;
        if (maskTextView != null) {
            maskTextView.setMaskText(str);
        }
    }

    public HomeLayoutOneContentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
