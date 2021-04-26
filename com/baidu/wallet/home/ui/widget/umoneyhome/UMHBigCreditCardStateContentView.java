package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class UMHBigCreditCardStateContentView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f25245a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25246b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25247c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataItem f25248d;

    /* renamed from: e  reason: collision with root package name */
    public b f25249e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25250f;

    public UMHBigCreditCardStateContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_state_content_view_layout"), this);
        this.f25245a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_tip"));
        this.f25246b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_text"));
        this.f25247c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f25246b.resetMaskText();
        this.f25245a.resetMaskText();
    }

    public void refresh() {
        this.f25245a.setMaskText(this.f25248d.value1);
        if (!TextUtils.isEmpty(this.f25248d.value2)) {
            this.f25246b.setVisibility(0);
            this.f25246b.setMaskText(this.f25248d.value2);
        } else {
            this.f25246b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = this.f25248d.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f25247c.setText(this.f25248d.buttons[0].name);
            this.f25247c.setVisibility(0);
            this.f25247c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardStateContentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UMHBigCreditCardStateContentView.this.f25249e != null) {
                        UMHBigCreditCardStateContentView.this.f25249e.jump(UMHBigCreditCardStateContentView.this.f25248d.buttons[0].stat != null ? UMHBigCreditCardStateContentView.this.f25248d.buttons[0].stat.getName() : UMHBigCreditCardStateContentView.this.f25248d.buttons[0].name, UMHBigCreditCardStateContentView.this.f25248d.buttons[0].type, UMHBigCreditCardStateContentView.this.f25248d.buttons[0].link_addr, "1".equals(UMHBigCreditCardStateContentView.this.f25248d.buttons[0].prevlogin));
                    }
                }
            });
        } else {
            this.f25247c.setVisibility(8);
        }
        if (this.f25250f) {
            this.f25247c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
        } else {
            this.f25247c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f25248d = dataItem;
        this.f25249e = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f25250f = z;
    }

    public UMHBigCreditCardStateContentView(Context context) {
        super(context);
    }

    private boolean a() {
        return this.f25248d != null;
    }
}
