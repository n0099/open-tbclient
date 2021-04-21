package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHCreditLongItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24424a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24425b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24426c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24427d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24428e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24429f;

    public NHCreditLongItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_item"), this);
        this.f24424a = (NetImageView) findViewById(ResUtils.id(getContext(), "bg_pic"));
        this.f24425b = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title1"));
        this.f24426c = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title2"));
        this.f24427d = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_desc"));
        this.f24428e = (MaskTextView) findViewById(ResUtils.id(getContext(), "bt_submit"));
        this.f24429f = (TextView) findViewById(ResUtils.id(getContext(), "tv_dot"));
    }

    public void refresh() {
        MaskTextView maskTextView;
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24424a, getData().logo);
        boolean z = true;
        boolean z2 = (TextUtils.isEmpty(getData().name) || this.f24425b == null) ? false : true;
        z = (TextUtils.isEmpty(getData().value1) || this.f24426c == null) ? false : false;
        if (z2) {
            this.f24425b.setVisibility(0);
            this.f24425b.setMaskText(getData().name);
        }
        if (z) {
            this.f24426c.setVisibility(0);
            this.f24426c.setMaskText(getData().value1);
        }
        this.f24429f.setVisibility((z2 && z) ? 0 : 8);
        if (!TextUtils.isEmpty(getData().value2) && (maskTextView = this.f24427d) != null) {
            maskTextView.setVisibility(0);
            this.f24427d.setMaskText(getData().value2);
        }
        if (!TextUtils.isEmpty(getData().value3)) {
            this.f24428e.setVisibility(0);
            this.f24428e.setMaskText(getData().value3);
            return;
        }
        this.f24428e.setVisibility(4);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public NHCreditLongItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
