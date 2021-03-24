package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHBigCreditCardTipsItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24642a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24643b;

    /* renamed from: c  reason: collision with root package name */
    public View f24644c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24645d;

    /* renamed from: e  reason: collision with root package name */
    public b f24646e;

    /* renamed from: f  reason: collision with root package name */
    public int f24647f;

    public CHBigCreditCardTipsItem(Context context) {
        super(context);
        this.f24647f = 24;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_tips_item"), this);
        this.f24642a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_img"));
        this.f24643b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_text"));
        this.f24644c = findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_divider"));
        this.f24643b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f24647f)});
    }

    private void b() {
        if (!TextUtils.isEmpty(this.f24645d.icon_link)) {
            this.f24642a.setVisibility(0);
            NetImageView netImageView = this.f24642a;
            netImageView.setImageUrl(this.f24646e.getAndroidPrefix() + this.f24645d.icon_link);
        } else {
            this.f24642a.setVisibility(8);
        }
        this.f24643b.setText(this.f24645d.name);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, b bVar) {
        this.f24645d = dataIcon;
        this.f24646e = bVar;
        a();
        b();
    }

    public void setMaxLength(int i) {
        this.f24647f = i;
    }

    public void setShowDivider(boolean z) {
        this.f24644c.setVisibility(z ? 0 : 4);
    }

    public CHBigCreditCardTipsItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24647f = 24;
    }
}
