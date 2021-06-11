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
    public MaskTextView f24490a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24491b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24492c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24493d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24494e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24495f;

    /* renamed from: g  reason: collision with root package name */
    public b f24496g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24497h;

    public UMHBigCreditCardContentView(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_content_view_layout"), this);
        this.f24490a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip"));
        this.f24491b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip_detail"));
        this.f24492c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_money"));
        this.f24493d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_text"));
        this.f24494e = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24490a.resetMaskText();
        this.f24493d.resetMaskText();
        this.f24492c.resetMaskText();
        this.f24491b.resetMaskText();
    }

    public void refresh() {
        this.f24490a.setMaskText(this.f24495f.label);
        if (TextUtils.isEmpty(this.f24495f.value1)) {
            this.f24492c.setVisibility(8);
            this.f24494e.setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(0);
            this.f24490a.setTextSize(1, 15.0f);
            int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_5d667a");
            this.f24490a.setTextColor(color);
            this.f24493d.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_b2b7c2"));
            if (!TextUtils.isEmpty(this.f24495f.detail)) {
                this.f24491b.setVisibility(0);
                this.f24491b.setMaskText(this.f24495f.detail);
                this.f24491b.setTextSize(1, 19.0f);
                this.f24491b.setTextColor(color);
            } else {
                this.f24491b.setVisibility(8);
            }
        } else {
            this.f24490a.setTextSize(1, 12.0f);
            this.f24491b.setVisibility(8);
            this.f24492c.setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(8);
            findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(8);
            this.f24492c.setMaskText(this.f24495f.value1);
            HomeCfgResponse.DataButton[] dataButtonArr = this.f24495f.buttons;
            if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                this.f24494e.setVisibility(0);
                this.f24494e.setText(this.f24495f.buttons[0].name);
                this.f24494e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardContentView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UMHBigCreditCardContentView.this.f24496g != null) {
                            UMHBigCreditCardContentView.this.f24496g.jump(UMHBigCreditCardContentView.this.f24495f.buttons[0].stat != null ? UMHBigCreditCardContentView.this.f24495f.buttons[0].stat.getName() : UMHBigCreditCardContentView.this.f24495f.buttons[0].name, UMHBigCreditCardContentView.this.f24495f.buttons[0].type, UMHBigCreditCardContentView.this.f24495f.buttons[0].link_addr, "1".equals(UMHBigCreditCardContentView.this.f24495f.buttons[0].prevlogin));
                        }
                    }
                });
            } else {
                this.f24494e.setVisibility(8);
            }
            if (this.f24497h) {
                this.f24492c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6"));
                this.f24494e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
            } else {
                this.f24492c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_d862b7"));
                this.f24494e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
            }
        }
        if (!TextUtils.isEmpty(this.f24495f.value2)) {
            this.f24493d.setVisibility(0);
            this.f24493d.setMaskText(this.f24495f.value2);
            return;
        }
        this.f24493d.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24495f = dataItem;
        this.f24496g = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f24497h = z;
    }

    public UMHBigCreditCardContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a() {
        return this.f24495f != null;
    }
}
