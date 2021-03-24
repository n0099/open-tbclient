package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHNoticeItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f24685a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24686b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24687c;

    public CHNoticeItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_notice_item"), this);
        this.f24685a = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_notice_content"));
        this.f24686b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_notice_class"));
        this.f24687c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_notice_img"));
    }

    private void b() {
        if (!TextUtils.isEmpty(getData().label)) {
            this.f24686b.setMaskText(getData().label);
        } else {
            this.f24686b.setVisibility(8);
        }
        this.f24685a.setMaskText(getData().name);
        if (!TextUtils.isEmpty(getData().type) && !TextUtils.isEmpty(getData().link_addr)) {
            this.f24687c.setVisibility(0);
        } else {
            this.f24687c.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        b();
    }

    public CHNoticeItem(Context context) {
        super(context);
    }
}
