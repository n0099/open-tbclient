package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
/* loaded from: classes5.dex */
public class UMHBigCreditCardPromotionTipView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24475a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24476b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24477c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24478d;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24479e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24480f;

    public UMHBigCreditCardPromotionTipView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_tip_item_layout"), this);
        this.f24475a = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img1"));
        this.f24476b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img2"));
        this.f24477c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text1"));
        this.f24478d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text2"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24477c.resetMaskText();
        this.f24478d.resetMaskText();
    }

    public void refresh() {
        HomeCfgResponse.DataIcon dataIcon = this.f24479e;
        if (dataIcon != null) {
            if (!TextUtils.isEmpty(dataIcon.icon_link)) {
                this.f24475a.setImageUrl(this.f24479e.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24479e.name)) {
                this.f24477c.setVisibility(0);
                this.f24477c.setMaskText(this.f24479e.name);
            } else {
                this.f24477c.setVisibility(4);
            }
        } else {
            this.f24475a.setVisibility(4);
            this.f24477c.setVisibility(4);
        }
        HomeCfgResponse.DataIcon dataIcon2 = this.f24480f;
        if (dataIcon2 != null) {
            if (!TextUtils.isEmpty(dataIcon2.icon_link)) {
                this.f24476b.setImageUrl(this.f24480f.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24480f.name)) {
                this.f24478d.setVisibility(0);
                this.f24478d.setMaskText(this.f24480f.name);
                return;
            }
            this.f24478d.setVisibility(4);
            return;
        }
        this.f24476b.setVisibility(4);
        this.f24478d.setVisibility(4);
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, HomeCfgResponse.DataIcon dataIcon2) {
        this.f24479e = dataIcon;
        this.f24480f = dataIcon2;
        initView();
        refresh();
    }

    public UMHBigCreditCardPromotionTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
