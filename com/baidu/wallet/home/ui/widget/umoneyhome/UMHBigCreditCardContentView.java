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
public class UMHBigCreditCardContentView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f25213a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25214b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f25215c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f25216d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25217e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataItem f25218f;

    /* renamed from: g  reason: collision with root package name */
    public b f25219g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25220h;

    public UMHBigCreditCardContentView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_content_view_layout"), this);
        this.f25213a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip"));
        this.f25214b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip_detail"));
        this.f25215c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_money"));
        this.f25216d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_text"));
        this.f25217e = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f25213a.resetMaskText();
        this.f25216d.resetMaskText();
        this.f25215c.resetMaskText();
        this.f25214b.resetMaskText();
    }

    public void refresh() {
        this.f25213a.setMaskText(this.f25218f.label);
        if (TextUtils.isEmpty(this.f25218f.value1)) {
            this.f25215c.setVisibility(8);
            this.f25217e.setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(0);
            this.f25213a.setTextSize(1, 15.0f);
            int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_5d667a");
            this.f25213a.setTextColor(color);
            this.f25216d.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_b2b7c2"));
            if (!TextUtils.isEmpty(this.f25218f.detail)) {
                this.f25214b.setVisibility(0);
                this.f25214b.setMaskText(this.f25218f.detail);
                this.f25214b.setTextSize(1, 19.0f);
                this.f25214b.setTextColor(color);
            } else {
                this.f25214b.setVisibility(8);
            }
        } else {
            this.f25213a.setTextSize(1, 12.0f);
            this.f25214b.setVisibility(8);
            this.f25215c.setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(8);
            this.f25215c.setMaskText(this.f25218f.value1);
            HomeCfgResponse.DataButton[] dataButtonArr = this.f25218f.buttons;
            if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                this.f25217e.setVisibility(0);
                this.f25217e.setText(this.f25218f.buttons[0].name);
                this.f25217e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardContentView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UMHBigCreditCardContentView.this.f25219g != null) {
                            UMHBigCreditCardContentView.this.f25219g.jump(UMHBigCreditCardContentView.this.f25218f.buttons[0].stat != null ? UMHBigCreditCardContentView.this.f25218f.buttons[0].stat.getName() : UMHBigCreditCardContentView.this.f25218f.buttons[0].name, UMHBigCreditCardContentView.this.f25218f.buttons[0].type, UMHBigCreditCardContentView.this.f25218f.buttons[0].link_addr, "1".equals(UMHBigCreditCardContentView.this.f25218f.buttons[0].prevlogin));
                        }
                    }
                });
            } else {
                this.f25217e.setVisibility(8);
            }
            if (this.f25220h) {
                this.f25215c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6"));
                this.f25217e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
            } else {
                this.f25215c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_d862b7"));
                this.f25217e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
            }
        }
        if (!TextUtils.isEmpty(this.f25218f.value2)) {
            this.f25216d.setVisibility(0);
            this.f25216d.setMaskText(this.f25218f.value2);
            return;
        }
        this.f25216d.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f25218f = dataItem;
        this.f25219g = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f25220h = z;
    }

    public UMHBigCreditCardContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a() {
        return this.f25218f != null;
    }
}
