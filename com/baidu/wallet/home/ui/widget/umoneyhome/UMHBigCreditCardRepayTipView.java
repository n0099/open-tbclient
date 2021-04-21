package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class UMHBigCreditCardRepayTipView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f24480a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24481b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24482c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24483d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24484e;

    /* renamed from: f  reason: collision with root package name */
    public Button f24485f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24486g;

    /* renamed from: h  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24487h;
    public b i;
    public boolean j;

    public UMHBigCreditCardRepayTipView(Context context) {
        super(context);
    }

    private boolean a() {
        HomeCfgResponse.DataItem dataItem = this.f24487h;
        return (dataItem == null || dataItem.repay == null) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_item_layout"), this);
        this.f24480a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_text"));
        this.f24481b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_money"));
        this.f24484e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_img"));
        this.f24482c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_tip"));
        this.f24483d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_sub_tip"));
        this.f24485f = (Button) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
        this.f24486g = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        HomeCfgResponse.DataButton[] dataButtonArr;
        if (CheckUtils.isFastDoubleClick() || this.f24487h == null || getWalletInterface() == null || (dataButtonArr = this.f24487h.repay.buttons) == null || dataButtonArr.length <= 0 || dataButtonArr[0] == null) {
            return;
        }
        b bVar = this.i;
        String name = dataButtonArr[0].stat != null ? dataButtonArr[0].stat.getName() : dataButtonArr[0].name;
        HomeCfgResponse.DataButton[] dataButtonArr2 = this.f24487h.repay.buttons;
        bVar.jump(name, dataButtonArr2[0].type, dataButtonArr2[0].link_addr, "1".equalsIgnoreCase(dataButtonArr2[0].prevlogin));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24483d.resetMaskText();
        this.f24482c.resetMaskText();
        this.f24481b.resetMaskText();
        this.f24480a.resetMaskText();
    }

    public void refresh() {
        boolean z;
        HomeCfgResponse.DataRepay dataRepay = this.f24487h.repay;
        if (!TextUtils.isEmpty(dataRepay.name)) {
            this.f24480a.setVisibility(0);
            this.f24480a.setMaskText(dataRepay.name);
        } else {
            this.f24480a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(dataRepay.label)) {
            this.f24481b.setVisibility(0);
            this.f24481b.setMaskText(dataRepay.label);
        } else {
            this.f24481b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = dataRepay.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f24485f.setText(dataRepay.buttons[0].name);
            this.f24486g.setText(dataRepay.buttons[0].name);
            this.f24485f.setOnClickListener(this);
            this.f24486g.setOnClickListener(this);
            z = true;
        } else {
            this.f24485f.setVisibility(8);
            this.f24486g.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(dataRepay.value)) {
            this.f24482c.setVisibility(0);
            this.f24482c.setMaskText(dataRepay.value);
            if (z) {
                this.f24485f.setVisibility(0);
                this.f24486g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.desc)) {
                this.f24483d.setVisibility(0);
                this.f24483d.setMaskText(dataRepay.desc);
            } else {
                this.f24483d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.type) && TextUtils.equals("2", dataRepay.type)) {
                setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_fff6f6"));
                int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_fa5050");
                a(color, color, ResUtils.getColor(getContext(), "wallet_home_umh_text_aafa5050"), color, color);
                this.f24485f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_red"));
                this.f24484e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_jin_tan_hao"));
                return;
            }
            setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
            int color2 = ResUtils.getColor(getContext(), "wallet_home_umh_text_121c32");
            int color3 = ResUtils.getColor(getContext(), "wallet_home_umh_text_868e9e");
            int color4 = ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6");
            int color5 = ResUtils.getColor(getContext(), "wallet_home_umh_text_cba14e");
            if (this.j) {
                a(color2, color2, color3, color2, color4);
                this.f24485f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_wathet"));
            } else {
                a(color2, color2, color3, color2, color5);
                this.f24485f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_yellow"));
            }
            this.f24484e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_ri_li"));
            return;
        }
        this.f24484e.setVisibility(8);
        this.f24482c.setVisibility(8);
        this.f24483d.setVisibility(8);
        this.f24485f.setVisibility(8);
        if (z) {
            this.f24485f.setVisibility(8);
            this.f24486g.setVisibility(0);
        }
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24487h = getData();
        this.i = bVar;
        if (a()) {
            initView();
            refresh();
        }
    }

    public void setIsManYiDai(boolean z) {
        this.j = z;
    }

    public UMHBigCreditCardRepayTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i, int i2, int i3, int i4, int i5) {
        this.f24480a.setTextColor(i);
        this.f24481b.setTextColor(i2);
        this.f24482c.setTextColor(i3);
        this.f24483d.setTextColor(i4);
        this.f24485f.setTextColor(i5);
    }
}
