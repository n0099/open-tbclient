package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class LifeItemViewForType3 extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24287a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24288b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24289c;

    public LifeItemViewForType3(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_life_item_view_new"), this);
        this.f24287a = (NetImageView) findViewById(ResUtils.id(getContext(), "life_icon"));
        this.f24288b = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
        this.f24289c = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24288b.setMaskText(getData().name);
        NetImageView netImageView = this.f24287a;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (hasCornor()) {
            this.f24289c.setVisibility(0);
            NetImageView netImageView2 = this.f24289c;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public LifeItemViewForType3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
