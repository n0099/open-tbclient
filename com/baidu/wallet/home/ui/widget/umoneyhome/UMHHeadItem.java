package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class UMHHeadItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24431a;

    public UMHHeadItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        NetImageView netImageView = new NetImageView(getContext());
        this.f24431a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f24431a.setImageDrawable(new ColorDrawable(ResUtils.getColor(getContext(), "wallet_home_umh_background")));
        addView(this.f24431a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24431a, getData().logo);
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public UMHHeadItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
