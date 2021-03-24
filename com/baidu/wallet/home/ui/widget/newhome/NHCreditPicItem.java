package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHCreditPicItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24745a;

    public NHCreditPicItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        NetImageView netImageView = new NetImageView(getContext());
        this.f24745a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f24745a.setImageResource(ResUtils.drawable(getContext(), "wallet_home_nh_shape_credit_background"));
        addView(this.f24745a, new GridLayout.LayoutParams(-1, -1));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24745a, getData().logo);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public NHCreditPicItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
