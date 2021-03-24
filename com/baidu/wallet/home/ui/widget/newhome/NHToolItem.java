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
public class NHToolItem extends BaseItemView {
    public NetImageView mCorner;
    public NetImageView mIcon;
    public NetImageView mStar;
    public MaskTextView mTitle;

    public NHToolItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        boolean isShowRedDot = isShowRedDot();
        this.mStar.setVisibility(isShowRedDot ? 0 : 8);
        this.mStar.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
        return isShowRedDot;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_tool_item"), this);
        this.mIcon = (NetImageView) findViewById(ResUtils.id(getContext(), "tool_item_icon"));
        this.mTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "tool_item_title"));
        this.mStar = (NetImageView) findViewById(ResUtils.id(getContext(), "tool_item_star"));
        this.mCorner = (NetImageView) findViewById(ResUtils.id(getContext(), "tool_item_corner"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.mIcon, getData().getPicAddr());
        this.mTitle.setMaskText(getData().name);
        if (!handlePoint() && hasCornor()) {
            setNetImageViewUrl(this.mCorner, getData().corner_addr);
            this.mCorner.setVisibility(0);
            return;
        }
        this.mCorner.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public NHToolItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
