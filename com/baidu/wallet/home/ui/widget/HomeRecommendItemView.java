package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class HomeRecommendItemView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f25035a;
    public MaskTextView mDesc_1;
    public MaskTextView mDesc_2;
    public MaskTextView mRmdText;
    public MaskTextView mTitle;

    public HomeRecommendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_recommend_item_layout"), this);
        this.mRmdText = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_rmd_tj"));
        this.mTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_rmd_title"));
        this.mDesc_1 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_rmd_title_des_1"));
        this.mDesc_2 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_rmd_title_des_2"));
        this.f25035a = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
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
            this.mRmdText.setMaskText(getData().value1);
            this.mRmdText.setVisibility(0);
        } else {
            this.mRmdText.setVisibility(4);
        }
        if (!TextUtils.isEmpty(getData().value2)) {
            setDesc1(getData().value2);
            setDesc1Visibility(0);
        } else {
            setDesc1Visibility(4);
        }
        if (!TextUtils.isEmpty(getData().value3)) {
            setDesc2(getData().value3);
            setDesc2Visibility(0);
        } else {
            setDesc2Visibility(4);
        }
        if (!handlePoint() && hasCornor()) {
            setIconUrl(getData().corner_addr);
            this.f25035a.setVisibility(0);
            return;
        }
        this.f25035a.setVisibility(8);
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

    public void setIconUrl(String str) {
        if (this.f25035a == null || TextUtils.isEmpty(str)) {
            return;
        }
        NetImageView netImageView = this.f25035a;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    public void setTitle(String str) {
        MaskTextView maskTextView = this.mTitle;
        if (maskTextView != null) {
            maskTextView.setMaskText(str);
        }
    }

    public HomeRecommendItemView(Context context) {
        super(context);
    }
}
