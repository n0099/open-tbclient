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
    public RelativeLayout f24561a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24562b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24563c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24564d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24565e;

    public FinanceItemView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_item_view_layout_type_8"), this);
        this.f24561a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "item_view"));
        this.f24562b = (NetImageView) findViewById(ResUtils.id(getContext(), "home_type_8_item_icon"));
        this.f24563c = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_title"));
        this.f24565e = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
        this.f24564d = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_des_1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24563c.setMaskText(getData().name);
        NetImageView netImageView = this.f24562b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f24564d.setMaskText(getData().value1);
            this.f24564d.setVisibility(0);
        } else {
            this.f24564d.setVisibility(8);
        }
        if (!handlePoint() && hasCornor()) {
            this.f24565e.setVisibility(0);
            NetImageView netImageView2 = this.f24565e;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f24565e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public void setIconMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24562b.getLayoutParams();
        layoutParams.topMargin = i;
        this.f24562b.setLayoutParams(layoutParams);
    }

    public void setLayoutPaddingBottom(int i) {
        RelativeLayout relativeLayout = this.f24561a;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f24561a.getPaddingTop(), this.f24561a.getPaddingRight(), i);
    }

    public void setTitleMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24563c.getLayoutParams();
        layoutParams.topMargin = i;
        this.f24563c.setLayoutParams(layoutParams);
    }

    public boolean showValue1() {
        return !TextUtils.isEmpty(getData().value1);
    }

    public FinanceItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
