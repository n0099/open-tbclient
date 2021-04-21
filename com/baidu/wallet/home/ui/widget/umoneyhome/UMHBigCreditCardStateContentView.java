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
    public MaskTextView f24488a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24489b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24490c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24491d;

    /* renamed from: e  reason: collision with root package name */
    public b f24492e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24493f;

    public UMHBigCreditCardStateContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_state_content_view_layout"), this);
        this.f24488a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_tip"));
        this.f24489b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_text"));
        this.f24490c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24489b.resetMaskText();
        this.f24488a.resetMaskText();
    }

    public void refresh() {
        this.f24488a.setMaskText(this.f24491d.value1);
        if (!TextUtils.isEmpty(this.f24491d.value2)) {
            this.f24489b.setVisibility(0);
            this.f24489b.setMaskText(this.f24491d.value2);
        } else {
            this.f24489b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = this.f24491d.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f24490c.setText(this.f24491d.buttons[0].name);
            this.f24490c.setVisibility(0);
            this.f24490c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardStateContentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UMHBigCreditCardStateContentView.this.f24492e != null) {
                        UMHBigCreditCardStateContentView.this.f24492e.jump(UMHBigCreditCardStateContentView.this.f24491d.buttons[0].stat != null ? UMHBigCreditCardStateContentView.this.f24491d.buttons[0].stat.getName() : UMHBigCreditCardStateContentView.this.f24491d.buttons[0].name, UMHBigCreditCardStateContentView.this.f24491d.buttons[0].type, UMHBigCreditCardStateContentView.this.f24491d.buttons[0].link_addr, "1".equals(UMHBigCreditCardStateContentView.this.f24491d.buttons[0].prevlogin));
                    }
                }
            });
        } else {
            this.f24490c.setVisibility(8);
        }
        if (this.f24493f) {
            this.f24490c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
        } else {
            this.f24490c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24491d = dataItem;
        this.f24492e = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f24493f = z;
    }

    public UMHBigCreditCardStateContentView(Context context) {
        super(context);
    }

    private boolean a() {
        return this.f24491d != null;
    }
}
