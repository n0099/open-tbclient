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
public class CHToolItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f25140a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25141b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f25142c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f25143d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f25144e;

    public CHToolItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        boolean isShowRedDot = isShowRedDot();
        this.f25142c.setVisibility(isShowRedDot ? 0 : 8);
        this.f25142c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
        return isShowRedDot;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_tool_item_view"), this);
        this.f25140a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_icon"));
        this.f25141b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_title"));
        this.f25142c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_star"));
        this.f25143d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_corner"));
        this.f25144e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_money"));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f25140a, getData().getPicAddr());
        this.f25141b.setMaskText(getData().name);
        if (!handlePoint() && !TextUtils.isEmpty(getData().desc)) {
            this.f25143d.setVisibility(0);
            this.f25143d.setMaskText(getData().desc);
        } else {
            this.f25143d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f25144e.setVisibility(0);
            this.f25144e.setMaskText(getData().value1);
            return;
        }
        this.f25144e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public CHToolItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
