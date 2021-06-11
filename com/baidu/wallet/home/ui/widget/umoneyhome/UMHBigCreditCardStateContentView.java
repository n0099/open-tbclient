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
    public MaskTextView f24522a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24523b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24524c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24525d;

    /* renamed from: e  reason: collision with root package name */
    public b f24526e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24527f;

    public UMHBigCreditCardStateContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_state_content_view_layout"), this);
        this.f24522a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_tip"));
        this.f24523b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_text"));
        this.f24524c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24523b.resetMaskText();
        this.f24522a.resetMaskText();
    }

    public void refresh() {
        this.f24522a.setMaskText(this.f24525d.value1);
        if (!TextUtils.isEmpty(this.f24525d.value2)) {
            this.f24523b.setVisibility(0);
            this.f24523b.setMaskText(this.f24525d.value2);
        } else {
            this.f24523b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = this.f24525d.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f24524c.setText(this.f24525d.buttons[0].name);
            this.f24524c.setVisibility(0);
            this.f24524c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardStateContentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UMHBigCreditCardStateContentView.this.f24526e != null) {
                        UMHBigCreditCardStateContentView.this.f24526e.jump(UMHBigCreditCardStateContentView.this.f24525d.buttons[0].stat != null ? UMHBigCreditCardStateContentView.this.f24525d.buttons[0].stat.getName() : UMHBigCreditCardStateContentView.this.f24525d.buttons[0].name, UMHBigCreditCardStateContentView.this.f24525d.buttons[0].type, UMHBigCreditCardStateContentView.this.f24525d.buttons[0].link_addr, "1".equals(UMHBigCreditCardStateContentView.this.f24525d.buttons[0].prevlogin));
                    }
                }
            });
        } else {
            this.f24524c.setVisibility(8);
        }
        if (this.f24527f) {
            this.f24524c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
        } else {
            this.f24524c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24525d = dataItem;
        this.f24526e = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f24527f = z;
    }

    public UMHBigCreditCardStateContentView(Context context) {
        super(context);
    }

    private boolean a() {
        return this.f24525d != null;
    }
}
