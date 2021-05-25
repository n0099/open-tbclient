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
    public RelativeLayout f24290a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24291b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24292c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24293d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24294e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f24295f;

    public CHFinanceUserItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_user_item"), this);
        this.f24291b = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_bg"));
        this.f24290a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "ch_fu_item_panel"));
        this.f24292c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_income"));
        this.f24293d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_total_value"));
        this.f24294e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_asset_value"));
        this.f24295f = (ImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_eye"));
        setOnClickListener(null);
        this.f24290a.setOnClickListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24292c.resetMaskText();
        this.f24293d.resetMaskText();
        this.f24294e.resetMaskText();
        if (this.f24295f != null) {
            this.f24295f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        }
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24291b, getData().logo);
        this.f24292c.setMaskText(getData().value1);
        this.f24293d.setMaskText(getData().value2);
        this.f24294e.setMaskText(getData().value3);
        this.f24295f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        this.f24295f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.credithome.CHFinanceUserItem.1
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
