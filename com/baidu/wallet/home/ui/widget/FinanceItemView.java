package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class FinanceItemView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f24284a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24285b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24286c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24287d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24288e;

    public FinanceItemView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_item_view_layout_type_8"), this);
        this.f24284a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "item_view"));
        this.f24285b = (NetImageView) findViewById(ResUtils.id(getContext(), "home_type_8_item_icon"));
        this.f24286c = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_title"));
        this.f24288e = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
        this.f24287d = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_des_1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24286c.setMaskText(getData().name);
        NetImageView netImageView = this.f24285b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f24287d.setMaskText(getData().value1);
            this.f24287d.setVisibility(0);
        } else {
            this.f24287d.setVisibility(8);
        }
        if (!handlePoint() && hasCornor()) {
            this.f24288e.setVisibility(0);
            NetImageView netImageView2 = this.f24288e;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f24288e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public void setIconMarginTop(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24285b.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f24285b.setLayoutParams(layoutParams);
    }

    public void setLayoutPaddingBottom(int i2) {
        RelativeLayout relativeLayout = this.f24284a;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f24284a.getPaddingTop(), this.f24284a.getPaddingRight(), i2);
    }

    public void setTitleMarginTop(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24286c.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f24286c.setLayoutParams(layoutParams);
    }

    public boolean showValue1() {
        return !TextUtils.isEmpty(getData().value1);
    }

    public FinanceItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
