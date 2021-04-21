package com.baidu.wallet.home.ui.widget.newhome;

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
public class NHCreditMiniItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24433a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24434b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24435c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24436d;

    public NHCreditMiniItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_mini_item"), this);
        this.f24433a = (NetImageView) findViewById(ResUtils.id(getContext(), "bg_pic"));
        this.f24434b = (MaskTextView) findViewById(ResUtils.id(getContext(), "title_top"));
        this.f24435c = (MaskTextView) findViewById(ResUtils.id(getContext(), "title_mid"));
        this.f24436d = (MaskTextView) findViewById(ResUtils.id(getContext(), "title_bottom"));
    }

    public void refresh() {
        MaskTextView maskTextView;
        MaskTextView maskTextView2;
        MaskTextView maskTextView3;
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24433a, getData().logo);
        if (!TextUtils.isEmpty(getData().name) && (maskTextView3 = this.f24434b) != null) {
            maskTextView3.setMaskText(getData().name);
        }
        if (!TextUtils.isEmpty(getData().value1) && (maskTextView2 = this.f24435c) != null) {
            maskTextView2.setMaskText(getData().value1);
        }
        if (TextUtils.isEmpty(getData().value2) || (maskTextView = this.f24436d) == null) {
            return;
        }
        maskTextView.setMaskText(getData().value2);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public NHCreditMiniItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
