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
    public MaskTextView f24795a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24796b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24797c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24798d;

    /* renamed from: e  reason: collision with root package name */
    public b f24799e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24800f;

    public UMHBigCreditCardStateContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_state_content_view_layout"), this);
        this.f24795a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_tip"));
        this.f24796b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_text"));
        this.f24797c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_button"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24796b.resetMaskText();
        this.f24795a.resetMaskText();
    }

    public void refresh() {
        this.f24795a.setMaskText(this.f24798d.value1);
        if (!TextUtils.isEmpty(this.f24798d.value2)) {
            this.f24796b.setVisibility(0);
            this.f24796b.setMaskText(this.f24798d.value2);
        } else {
            this.f24796b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = this.f24798d.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f24797c.setText(this.f24798d.buttons[0].name);
            this.f24797c.setVisibility(0);
            this.f24797c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardStateContentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UMHBigCreditCardStateContentView.this.f24799e != null) {
                        UMHBigCreditCardStateContentView.this.f24799e.jump(UMHBigCreditCardStateContentView.this.f24798d.buttons[0].stat != null ? UMHBigCreditCardStateContentView.this.f24798d.buttons[0].stat.getName() : UMHBigCreditCardStateContentView.this.f24798d.buttons[0].name, UMHBigCreditCardStateContentView.this.f24798d.buttons[0].type, UMHBigCreditCardStateContentView.this.f24798d.buttons[0].link_addr, "1".equals(UMHBigCreditCardStateContentView.this.f24798d.buttons[0].prevlogin));
                    }
                }
            });
        } else {
            this.f24797c.setVisibility(8);
        }
        if (this.f24800f) {
            this.f24797c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
        } else {
            this.f24797c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24798d = dataItem;
        this.f24799e = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.f24800f = z;
    }

    public UMHBigCreditCardStateContentView(Context context) {
        super(context);
    }

    private boolean a() {
        return this.f24798d != null;
    }
}
