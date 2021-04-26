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
    public NetImageView f25230a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f25231b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f25232c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f25233d;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f25234e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f25235f;

    public UMHBigCreditCardPromotionTipView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_tip_item_layout"), this);
        this.f25230a = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img1"));
        this.f25231b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img2"));
        this.f25232c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text1"));
        this.f25233d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text2"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f25232c.resetMaskText();
        this.f25233d.resetMaskText();
    }

    public void refresh() {
        HomeCfgResponse.DataIcon dataIcon = this.f25234e;
        if (dataIcon != null) {
            if (!TextUtils.isEmpty(dataIcon.icon_link)) {
                this.f25230a.setImageUrl(this.f25234e.icon_link);
            }
            if (!TextUtils.isEmpty(this.f25234e.name)) {
                this.f25232c.setVisibility(0);
                this.f25232c.setMaskText(this.f25234e.name);
            } else {
                this.f25232c.setVisibility(4);
            }
        } else {
            this.f25230a.setVisibility(4);
            this.f25232c.setVisibility(4);
        }
        HomeCfgResponse.DataIcon dataIcon2 = this.f25235f;
        if (dataIcon2 != null) {
            if (!TextUtils.isEmpty(dataIcon2.icon_link)) {
                this.f25231b.setImageUrl(this.f25235f.icon_link);
            }
            if (!TextUtils.isEmpty(this.f25235f.name)) {
                this.f25233d.setVisibility(0);
                this.f25233d.setMaskText(this.f25235f.name);
                return;
            }
            this.f25233d.setVisibility(4);
            return;
        }
        this.f25231b.setVisibility(4);
        this.f25233d.setVisibility(4);
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, HomeCfgResponse.DataIcon dataIcon2) {
        this.f25234e = dataIcon;
        this.f25235f = dataIcon2;
        initView();
        refresh();
    }

    public UMHBigCreditCardPromotionTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
