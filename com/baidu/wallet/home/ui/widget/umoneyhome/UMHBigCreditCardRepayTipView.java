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
    public MaskTextView f24410a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24411b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24412c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24413d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24414e;

    /* renamed from: f  reason: collision with root package name */
    public Button f24415f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24416g;

    /* renamed from: h  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24417h;

    /* renamed from: i  reason: collision with root package name */
    public b f24418i;
    public boolean j;

    public UMHBigCreditCardRepayTipView(Context context) {
        super(context);
    }

    private boolean a() {
        HomeCfgResponse.DataItem dataItem = this.f24417h;
        return (dataItem == null || dataItem.repay == null) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_item_layout"), this);
        this.f24410a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_text"));
        this.f24411b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_money"));
        this.f24414e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_img"));
        this.f24412c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_tip"));
        this.f24413d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_sub_tip"));
        this.f24415f = (Button) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
        this.f24416g = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button1"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        HomeCfgResponse.DataButton[] dataButtonArr;
        if (CheckUtils.isFastDoubleClick() || this.f24417h == null || getWalletInterface() == null || (dataButtonArr = this.f24417h.repay.buttons) == null || dataButtonArr.length <= 0 || dataButtonArr[0] == null) {
            return;
        }
        b bVar = this.f24418i;
        String name = dataButtonArr[0].stat != null ? dataButtonArr[0].stat.getName() : dataButtonArr[0].name;
        HomeCfgResponse.DataButton[] dataButtonArr2 = this.f24417h.repay.buttons;
        bVar.jump(name, dataButtonArr2[0].type, dataButtonArr2[0].link_addr, "1".equalsIgnoreCase(dataButtonArr2[0].prevlogin));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.f24413d.resetMaskText();
        this.f24412c.resetMaskText();
        this.f24411b.resetMaskText();
        this.f24410a.resetMaskText();
    }

    public void refresh() {
        boolean z;
        HomeCfgResponse.DataRepay dataRepay = this.f24417h.repay;
        if (!TextUtils.isEmpty(dataRepay.name)) {
            this.f24410a.setVisibility(0);
            this.f24410a.setMaskText(dataRepay.name);
        } else {
            this.f24410a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(dataRepay.label)) {
            this.f24411b.setVisibility(0);
            this.f24411b.setMaskText(dataRepay.label);
        } else {
            this.f24411b.setVisibility(8);
        }
        HomeCfgResponse.DataButton[] dataButtonArr = dataRepay.buttons;
        if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
            this.f24415f.setText(dataRepay.buttons[0].name);
            this.f24416g.setText(dataRepay.buttons[0].name);
            this.f24415f.setOnClickListener(this);
            this.f24416g.setOnClickListener(this);
            z = true;
        } else {
            this.f24415f.setVisibility(8);
            this.f24416g.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(dataRepay.value)) {
            this.f24412c.setVisibility(0);
            this.f24412c.setMaskText(dataRepay.value);
            if (z) {
                this.f24415f.setVisibility(0);
                this.f24416g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.desc)) {
                this.f24413d.setVisibility(0);
                this.f24413d.setMaskText(dataRepay.desc);
            } else {
                this.f24413d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.type) && TextUtils.equals("2", dataRepay.type)) {
                setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_fff6f6"));
                int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_fa5050");
                a(color, color, ResUtils.getColor(getContext(), "wallet_home_umh_text_aafa5050"), color, color);
                this.f24415f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_red"));
                this.f24414e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_jin_tan_hao"));
                return;
            }
            setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
            int color2 = ResUtils.getColor(getContext(), "wallet_home_umh_text_121c32");
            int color3 = ResUtils.getColor(getContext(), "wallet_home_umh_text_868e9e");
            int color4 = ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6");
            int color5 = ResUtils.getColor(getContext(), "wallet_home_umh_text_cba14e");
            if (this.j) {
                a(color2, color2, color3, color2, color4);
                this.f24415f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_wathet"));
            } else {
                a(color2, color2, color3, color2, color5);
                this.f24415f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_yellow"));
            }
            this.f24414e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_ri_li"));
            return;
        }
        this.f24414e.setVisibility(8);
        this.f24412c.setVisibility(8);
        this.f24413d.setVisibility(8);
        this.f24415f.setVisibility(8);
        if (z) {
            this.f24415f.setVisibility(8);
            this.f24416g.setVisibility(0);
        }
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        this.f24417h = getData();
        this.f24418i = bVar;
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
        this.f24410a.setTextColor(i2);
        this.f24411b.setTextColor(i3);
        this.f24412c.setTextColor(i4);
        this.f24413d.setTextColor(i5);
        this.f24415f.setTextColor(i6);
    }
}
