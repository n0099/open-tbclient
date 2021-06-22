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
    public NetImageView f24589a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24590b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24591c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24592d;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24593e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24594f;

    public UMHBigCreditCardPromotionTipView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_tip_item_layout"), this);
        this.f24589a = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img1"));
        this.f24590b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img2"));
        this.f24591c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text1"));
        this.f24592d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text2"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24591c.resetMaskText();
        this.f24592d.resetMaskText();
    }

    public void refresh() {
        HomeCfgResponse.DataIcon dataIcon = this.f24593e;
        if (dataIcon != null) {
            if (!TextUtils.isEmpty(dataIcon.icon_link)) {
                this.f24589a.setImageUrl(this.f24593e.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24593e.name)) {
                this.f24591c.setVisibility(0);
                this.f24591c.setMaskText(this.f24593e.name);
            } else {
                this.f24591c.setVisibility(4);
            }
        } else {
            this.f24589a.setVisibility(4);
            this.f24591c.setVisibility(4);
        }
        HomeCfgResponse.DataIcon dataIcon2 = this.f24594f;
        if (dataIcon2 != null) {
            if (!TextUtils.isEmpty(dataIcon2.icon_link)) {
                this.f24590b.setImageUrl(this.f24594f.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24594f.name)) {
                this.f24592d.setVisibility(0);
                this.f24592d.setMaskText(this.f24594f.name);
                return;
            }
            this.f24592d.setVisibility(4);
            return;
        }
        this.f24590b.setVisibility(4);
        this.f24592d.setVisibility(4);
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, HomeCfgResponse.DataIcon dataIcon2) {
        this.f24593e = dataIcon;
        this.f24594f = dataIcon2;
        initView();
        refresh();
    }

    public UMHBigCreditCardPromotionTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
