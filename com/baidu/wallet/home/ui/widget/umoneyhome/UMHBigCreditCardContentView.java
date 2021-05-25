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
    public MaskTextView f24387a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24388b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24389c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24390d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24391e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24392f;

    /* renamed from: g  reason: collision with root package name */
    public b f24393g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24394h;

    public UMHBigCreditCardContentView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_content_view_layout"), this);
        this.f24387a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip"));
        this.f24388b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip_detail"));
        this.f24389c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_money"));
        this.f24390d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_text"));
        this.f24391e = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24387a.resetMaskText();
        this.f24390d.resetMaskText();
        this.f24389c.resetMaskText();
        this.f24388b.resetMaskText();
    }

    public void refresh() {
        this.f24387a.setMaskText(this.f24392f.label);
        if (TextUtils.isEmpty(this.f24392f.value1)) {
            this.f24389c.setVisibility(8);
            this.f24391e.setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(0);
            this.f24387a.setTextSize(1, 15.0f);
            int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_5d667a");
            this.f24387a.setTextColor(color);
            this.f24390d.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_b2b7c2"));
            if (!TextUtils.isEmpty(this.f24392f.detail)) {
                this.f24388b.setVisibility(0);
                this.f24388b.setMaskText(this.f24392f.detail);
                this.f24388b.setTextSize(1, 19.0f);
                this.f24388b.setTextColor(color);
            } else {
                this.f24388b.setVisibility(8);
            }
        } else {
            this.f24387a.setTextSize(1, 12.0f);
            this.f24388b.setVisibility(8);
            this.f24389c.setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(8);
            this.f24389c.setMaskText(this.f24392f.value1);
            HomeCfgResponse.DataButton[] dataButtonArr = this.f24392f.buttons;
            if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                this.f24391e.setVisibility(0);
                this.f24391e.setText(this.f24392f.buttons[0].name);
                this.f24391e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardContentView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UMHBigCreditCardContentView.this.f24393g != null) {
                            UMHBigCreditCardContentView.this.f24393g.jump(UMHBigCreditCardContentView.this.f24392f.buttons[0].stat != null ? UMHBigCreditCardContentView.this.f24392f.buttons[0].stat.getName() : UMHBigCreditCardContentView.this.f24392f.buttons[0].name, UMHBigCreditCardContentView.this.f24392f.buttons[0].type, UMHBigCreditCardContentView.this.f24392f.buttons[0].link_addr, "1".equals(UMHBigCreditCardContentView.this.f24392f.buttons[0].prevlogin));
                        }
                    }
                });
            } else {
                this.f24391e.setVisibility(8);
            }
            if (this.f24394h) {
                this.f24389c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6"));
                this.f24391e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
            } else {
                this.f24389c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_d862b7"));
                this.f24391e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
            }
        }
        if (!TextUtils.isEmpty(this.f24392f.value2)) {
            this.f24390d.setVisibility(0);
            this.f24390d.setMaskText(this.f24392f.value2);
            return;
        }
        this.f24390d.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24392f = dataItem;
        this.f24393g = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f24394h = z;
    }

    public UMHBigCreditCardContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a() {
        return this.f24392f != null;
    }
}
