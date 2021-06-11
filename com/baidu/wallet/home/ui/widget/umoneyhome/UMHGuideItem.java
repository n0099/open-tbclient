package com.baidu.wallet.home.ui.widget.umoneyhome;

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
public class UMHGuideItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24530a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24531b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24532c;

    public UMHGuideItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_guide_item"), this);
        this.f24530a = (NetImageView) findViewById(ResUtils.id(getContext(), "item_logo"));
        this.f24531b = (MaskTextView) findViewById(ResUtils.id(getContext(), "item_title"));
        this.f24532c = (MaskTextView) findViewById(ResUtils.id(getContext(), "item_desc"));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24530a, getData().logo);
        this.f24531b.setMaskText(getData().name);
        this.f24532c.setMaskText(getData().desc);
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public UMHGuideItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
