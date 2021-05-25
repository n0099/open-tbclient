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
    public RelativeLayout f24181a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24182b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24183c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24184d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24185e;

    public FinanceItemView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_item_view_layout_type_8"), this);
        this.f24181a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "item_view"));
        this.f24182b = (NetImageView) findViewById(ResUtils.id(getContext(), "home_type_8_item_icon"));
        this.f24183c = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_title"));
        this.f24185e = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
        this.f24184d = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_des_1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24183c.setMaskText(getData().name);
        NetImageView netImageView = this.f24182b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f24184d.setMaskText(getData().value1);
            this.f24184d.setVisibility(0);
        } else {
            this.f24184d.setVisibility(8);
        }
        if (!handlePoint() && hasCornor()) {
            this.f24185e.setVisibility(0);
            NetImageView netImageView2 = this.f24185e;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f24185e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public void setIconMarginTop(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24182b.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f24182b.setLayoutParams(layoutParams);
    }

    public void setLayoutPaddingBottom(int i2) {
        RelativeLayout relativeLayout = this.f24181a;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f24181a.getPaddingTop(), this.f24181a.getPaddingRight(), i2);
    }

    public void setTitleMarginTop(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24183c.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f24183c.setLayoutParams(layoutParams);
    }

    public boolean showValue1() {
        return !TextUtils.isEmpty(getData().value1);
    }

    public FinanceItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
