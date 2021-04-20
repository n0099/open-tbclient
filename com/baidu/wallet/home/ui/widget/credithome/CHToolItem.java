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
    public NetImageView f24378a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24379b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24380c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24381d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24382e;

    public CHToolItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        boolean isShowRedDot = isShowRedDot();
        this.f24380c.setVisibility(isShowRedDot ? 0 : 8);
        this.f24380c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
        return isShowRedDot;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_tool_item_view"), this);
        this.f24378a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_icon"));
        this.f24379b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_title"));
        this.f24380c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_star"));
        this.f24381d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_corner"));
        this.f24382e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_money"));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24378a, getData().getPicAddr());
        this.f24379b.setMaskText(getData().name);
        if (!handlePoint() && !TextUtils.isEmpty(getData().desc)) {
            this.f24381d.setVisibility(0);
            this.f24381d.setMaskText(getData().desc);
        } else {
            this.f24381d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f24382e.setVisibility(0);
            this.f24382e.setMaskText(getData().value1);
            return;
        }
        this.f24382e.setVisibility(8);
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
