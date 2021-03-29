package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHCreditItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f24652a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24653b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24654c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24655d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24656e;

    public CHCreditItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_item"), this);
        this.f24652a = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines"));
        this.f24653b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_tip"));
        this.f24654c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_title"));
        this.f24656e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_lable"));
        this.f24655d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_title_desc"));
    }

    public void refresh() {
        MaskTextView maskTextView;
        MaskTextView maskTextView2;
        MaskTextView maskTextView3;
        MaskTextView maskTextView4;
        MaskTextView maskTextView5;
        if (getData() == null) {
            return;
        }
        if (!TextUtils.isEmpty(getData().value1) && (maskTextView5 = this.f24652a) != null) {
            maskTextView5.setMaskText(getData().value1);
        }
        if (!TextUtils.isEmpty(getData().value2) && (maskTextView4 = this.f24653b) != null) {
            maskTextView4.setMaskText(getData().value2);
        }
        if (!TextUtils.isEmpty(getData().name) && (maskTextView3 = this.f24654c) != null) {
            maskTextView3.setMaskText(getData().name);
        }
        if (!TextUtils.isEmpty(getData().label) && (maskTextView2 = this.f24656e) != null) {
            maskTextView2.setMaskText(getData().label);
        } else {
            MaskTextView maskTextView6 = this.f24656e;
            if (maskTextView6 != null) {
                maskTextView6.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(getData().value3) || (maskTextView = this.f24655d) == null) {
            return;
        }
        maskTextView.setMaskText(getData().value3);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public CHCreditItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
