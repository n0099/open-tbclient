package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHFinanceUserItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f24475a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24476b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24477c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24478d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24479e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f24480f;

    public CHFinanceUserItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_user_item"), this);
        this.f24476b = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_bg"));
        this.f24475a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "ch_fu_item_panel"));
        this.f24477c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_income"));
        this.f24478d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_total_value"));
        this.f24479e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_asset_value"));
        this.f24480f = (ImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_eye"));
        setOnClickListener(null);
        this.f24475a.setOnClickListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24477c.resetMaskText();
        this.f24478d.resetMaskText();
        this.f24479e.resetMaskText();
        if (this.f24480f != null) {
            this.f24480f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        }
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24476b, getData().logo);
        this.f24477c.setMaskText(getData().value1);
        this.f24478d.setMaskText(getData().value2);
        this.f24479e.setMaskText(getData().value3);
        this.f24480f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        this.f24480f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.credithome.CHFinanceUserItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                CHFinanceUserItem.this.getWalletInterface().onEyeMaskBtnClick();
            }
        });
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public CHFinanceUserItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
