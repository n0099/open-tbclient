package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class LifeItemViewForType6 extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24293a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24294b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24295c;

    public LifeItemViewForType6(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_item_view_for_type_6"), this);
        this.f24293a = (NetImageView) findViewById(ResUtils.id(getContext(), "life_icon"));
        this.f24294b = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
        this.f24295c = (NetImageView) findViewById(ResUtils.id(getContext(), "red_dot_im"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        if (isShoudShowPoint()) {
            this.f24295c.setVisibility(0);
            this.f24295c.setImageDrawable(ResUtils.getDrawable(getContext(), isShowWhiteDot() ? "wallet_home_white_star" : "wallet_home_red_star"));
            return true;
        }
        this.f24295c.setVisibility(8);
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24294b.setMaskText(getData().name);
        NetImageView netImageView = this.f24293a;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public LifeItemViewForType6(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
