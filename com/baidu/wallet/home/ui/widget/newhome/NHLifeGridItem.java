package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHLifeGridItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f25206a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25207b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f25208c;

    public NHLifeGridItem(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_life_item_view"), this);
        this.f25206a = (NetImageView) findViewById(ResUtils.id(getContext(), "life_icon"));
        this.f25207b = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
        this.f25208c = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f25207b.setMaskText(getData().name);
        NetImageView netImageView = this.f25206a;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (hasCornor()) {
            this.f25208c.setVisibility(0);
            NetImageView netImageView2 = this.f25208c;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public NHLifeGridItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
