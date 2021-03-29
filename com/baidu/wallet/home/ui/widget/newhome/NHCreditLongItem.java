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
    public NetImageView f24731a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24732b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24733c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24734d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24735e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24736f;

    public NHCreditLongItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_item"), this);
        this.f24731a = (NetImageView) findViewById(ResUtils.id(getContext(), "bg_pic"));
        this.f24732b = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title1"));
        this.f24733c = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title2"));
        this.f24734d = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_desc"));
        this.f24735e = (MaskTextView) findViewById(ResUtils.id(getContext(), "bt_submit"));
        this.f24736f = (TextView) findViewById(ResUtils.id(getContext(), "tv_dot"));
    }

    public void refresh() {
        MaskTextView maskTextView;
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24731a, getData().logo);
        boolean z = true;
        boolean z2 = (TextUtils.isEmpty(getData().name) || this.f24732b == null) ? false : true;
        z = (TextUtils.isEmpty(getData().value1) || this.f24733c == null) ? false : false;
        if (z2) {
            this.f24732b.setVisibility(0);
            this.f24732b.setMaskText(getData().name);
        }
        if (z) {
            this.f24733c.setVisibility(0);
            this.f24733c.setMaskText(getData().value1);
        }
        this.f24736f.setVisibility((z2 && z) ? 0 : 8);
        if (!TextUtils.isEmpty(getData().value2) && (maskTextView = this.f24734d) != null) {
            maskTextView.setVisibility(0);
            this.f24734d.setMaskText(getData().value2);
        }
        if (!TextUtils.isEmpty(getData().value3)) {
            this.f24735e.setVisibility(0);
            this.f24735e.setMaskText(getData().value3);
            return;
        }
        this.f24735e.setVisibility(4);
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
