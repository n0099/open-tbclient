package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHAssetItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f25162a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25163b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f25164c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f25165d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f25166e;

    /* renamed from: f  reason: collision with root package name */
    public MaskTextView f25167f;

    public NHAssetItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        boolean isShowRedDot = isShowRedDot();
        this.f25164c.setVisibility(isShowRedDot ? 0 : 8);
        this.f25164c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
        return isShowRedDot;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_asset_item"), this);
        this.f25162a = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_subtitle"));
        this.f25163b = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_title"));
        this.f25164c = (NetImageView) findViewById(ResUtils.id(getContext(), "asset_item_star"));
        this.f25165d = (LinearLayout) findViewById(ResUtils.id(getContext(), "asset_item_desc_panel"));
        this.f25166e = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_subdesc"));
        this.f25167f = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_desc"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f25162a.resetMaskText();
        this.f25163b.resetMaskText();
        this.f25166e.resetMaskText();
        this.f25167f.resetMaskText();
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f25162a.setMaskText(getData().name);
        this.f25163b.setMaskText(getData().value1);
        if (TextUtils.isEmpty(getData().value3)) {
            this.f25165d.setVisibility(8);
        } else {
            this.f25165d.setVisibility(0);
            this.f25166e.setMaskText(getData().value2);
            this.f25167f.setMaskText(getData().value3);
        }
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public NHAssetItem(Context context) {
        super(context);
    }
}
