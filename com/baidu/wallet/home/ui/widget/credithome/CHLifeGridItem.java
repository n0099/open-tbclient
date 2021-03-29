package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHLifeGridItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24679a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24680b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24681c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24682d;

    public CHLifeGridItem(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_life_item_view"), this);
        this.f24679a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_life_item_icon"));
        this.f24680b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_life_item_title"));
        this.f24681c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_life_item_star"));
        this.f24682d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_life_item_corner"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        boolean isShowRedDot = isShowRedDot();
        this.f24681c.setVisibility(isShowRedDot ? 0 : 8);
        this.f24681c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
        return isShowRedDot;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24680b.setMaskText(getData().name);
        setNetImageViewUrl(this.f24679a, getData().getPicAddr());
        if (!handlePoint() && !TextUtils.isEmpty(getData().desc)) {
            this.f24682d.setVisibility(0);
            this.f24682d.setMaskText(getData().desc);
            return;
        }
        this.f24682d.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public CHLifeGridItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
