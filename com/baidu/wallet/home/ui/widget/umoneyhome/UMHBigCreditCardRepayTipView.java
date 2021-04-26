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
    public MaskTextView f25236a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f25237b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f25238c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f25239d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f25240e;

    /* renamed from: f  reason: collision with root package name */
    public Button f25241f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25242g;

    /* renamed from: h  reason: collision with root package name */
    public HomeCfgResponse.DataItem f25243h;

    /* renamed from: i  reason: collision with root package name */
    public b f25244i;
    public boolean j;

    public UMHBigCreditCardRepayTipView(Context context) {
        super(context);
    }

    private boolean a() {
        HomeCfgResponse.DataItem dataItem = this.f25243h;
        return (dataItem == null || dataItem.repay == null) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_item_layout"), this);
        this.f25236a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_text"));
        this.f25237b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_money"));
        this.f25240e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_img"));
        this.f25238c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_tip"));
        this.f25239d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_sub_tip"));
        this.f25241f = (Button) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
        this.f25242g = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        HomeCfgResponse.DataButton[] dataButtonArr;
        if (CheckUtils.isFastDoubleClick() || this.f25243h == null || getWalletInterface() == null || (dataButtonArr = this.f25243h.repay.buttons) == null || dataButtonArr.length <= 0 || dataButtonArr[0] == null) {
            return;
        }
        b bVar = this.f25244i;
        String name = dataButtonArr[0].stat != null ? dataButtonArr[0].stat.getName() : dataButtonArr[0].name;
        HomeCfgResponse.DataButton[] dataButtonArr2 = this.f25243h.repay.buttons;
        bVar.jump(name, dataButtonArr2[0].type, dataButtonArr2[0].link_addr, "1".equalsIgnoreCase(dataButtonArr2[0].prevlogin));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f25239d.resetMaskText();
        this.f25238c.resetMaskText();
        this.f25237b.resetMaskText();
        this.f25236a.resetMaskText();
    }

    public void refresh() {
        boolean z;
        HomeCfgResponse.DataRepay dataRepay = this.f25243h.repay;
        if (!TextUtils.isEmpty(dataRepay.name)) {
            this.f25236a.setVisibility(0);
            this.f25236a.setMaskText(dataRepay.name);
        } else {
            this.f25236a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(dataRepay.label)) {
            this.f25237b.setVisibility(0);
            this.f25237b.setMaskText(dataRepay.label);
        } else {
            this.f25237b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = dataRepay.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f25241f.setText(dataRepay.buttons[0].name);
            this.f25242g.setText(dataRepay.buttons[0].name);
            this.f25241f.setOnClickListener(this);
            this.f25242g.setOnClickListener(this);
            z = true;
        } else {
            this.f25241f.setVisibility(8);
            this.f25242g.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(dataRepay.value)) {
            this.f25238c.setVisibility(0);
            this.f25238c.setMaskText(dataRepay.value);
            if (z) {
                this.f25241f.setVisibility(0);
                this.f25242g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.desc)) {
                this.f25239d.setVisibility(0);
                this.f25239d.setMaskText(dataRepay.desc);
            } else {
                this.f25239d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.type) && TextUtils.equals("2", dataRepay.type)) {
                setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_fff6f6"));
                int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_fa5050");
                a(color, color, ResUtils.getColor(getContext(), "wallet_home_umh_text_aafa5050"), color, color);
                this.f25241f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_red"));
                this.f25240e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_jin_tan_hao"));
                return;
            }
            setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
            int color2 = ResUtils.getColor(getContext(), "wallet_home_umh_text_121c32");
            int color3 = ResUtils.getColor(getContext(), "wallet_home_umh_text_868e9e");
            int color4 = ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6");
            int color5 = ResUtils.getColor(getContext(), "wallet_home_umh_text_cba14e");
            if (this.j) {
                a(color2, color2, color3, color2, color4);
                this.f25241f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_wathet"));
            } else {
                a(color2, color2, color3, color2, color5);
                this.f25241f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_yellow"));
            }
            this.f25240e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_ri_li"));
            return;
        }
        this.f25240e.setVisibility(8);
        this.f25238c.setVisibility(8);
        this.f25239d.setVisibility(8);
        this.f25241f.setVisibility(8);
        if (z) {
            this.f25241f.setVisibility(8);
            this.f25242g.setVisibility(0);
        }
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f25243h = getData();
        this.f25244i = bVar;
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

    private void a(int i2, int i3, int i4, int i5, int i6) {
        this.f25236a.setTextColor(i2);
        this.f25237b.setTextColor(i3);
        this.f25238c.setTextColor(i4);
        this.f25239d.setTextColor(i5);
        this.f25241f.setTextColor(i6);
    }
}
