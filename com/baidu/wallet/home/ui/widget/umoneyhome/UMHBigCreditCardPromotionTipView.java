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
    public NetImageView f24780a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24781b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24782c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24783d;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24784e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24785f;

    public UMHBigCreditCardPromotionTipView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_tip_item_layout"), this);
        this.f24780a = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img1"));
        this.f24781b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img2"));
        this.f24782c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text1"));
        this.f24783d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text2"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24782c.resetMaskText();
        this.f24783d.resetMaskText();
    }

    public void refresh() {
        HomeCfgResponse.DataIcon dataIcon = this.f24784e;
        if (dataIcon != null) {
            if (!TextUtils.isEmpty(dataIcon.icon_link)) {
                this.f24780a.setImageUrl(this.f24784e.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24784e.name)) {
                this.f24782c.setVisibility(0);
                this.f24782c.setMaskText(this.f24784e.name);
            } else {
                this.f24782c.setVisibility(4);
            }
        } else {
            this.f24780a.setVisibility(4);
            this.f24782c.setVisibility(4);
        }
        HomeCfgResponse.DataIcon dataIcon2 = this.f24785f;
        if (dataIcon2 != null) {
            if (!TextUtils.isEmpty(dataIcon2.icon_link)) {
                this.f24781b.setImageUrl(this.f24785f.icon_link);
            }
            if (!TextUtils.isEmpty(this.f24785f.name)) {
                this.f24783d.setVisibility(0);
                this.f24783d.setMaskText(this.f24785f.name);
                return;
            }
            this.f24783d.setVisibility(4);
            return;
        }
        this.f24781b.setVisibility(4);
        this.f24783d.setVisibility(4);
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, HomeCfgResponse.DataIcon dataIcon2) {
        this.f24784e = dataIcon;
        this.f24785f = dataIcon2;
        initView();
        refresh();
    }

    public UMHBigCreditCardPromotionTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
