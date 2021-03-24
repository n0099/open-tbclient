package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CHBigCreditCardGroup extends BaseItemLayout implements View.OnClickListener {
    public static int q = 24;

    /* renamed from: a  reason: collision with root package name */
    public final int f24633a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24634b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24635c;

    /* renamed from: e  reason: collision with root package name */
    public final float f24636e;

    /* renamed from: f  reason: collision with root package name */
    public final float f24637f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f24638g;

    /* renamed from: h  reason: collision with root package name */
    public MaskTextView f24639h;
    public NetImageView i;
    public MaskTextView j;
    public LinearLayout k;
    public Button l;
    public View m;
    public LinearLayout n;
    public NetImageView o;
    public boolean p;
    public List<BaseItemView> r;

    public CHBigCreditCardGroup(Context context) {
        super(context);
        this.f24633a = 3;
        this.f24634b = 44;
        this.f24635c = 22;
        this.f24636e = 19.0f;
        this.f24637f = 10.0f;
        this.p = true;
        this.r = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.r;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_layout"), this);
        this.o = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_bg"));
        this.f24638g = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_logo"));
        this.f24639h = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_title"));
        this.j = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_lines_number"));
        this.k = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_card_tips"));
        this.l = (Button) findViewById(ResUtils.id(getContext(), "ch_credit_card_button"));
        this.m = findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_divider"));
        this.n = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_card_repayment_layout"));
        this.i = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_eye"));
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0 || dataItemArr[0] == null) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isDataValid()) {
            if (view == this.i) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                getWalletInterface().onEyeMaskBtnClick();
            } else if (view == this.j) {
                if (!CheckUtils.isFastDoubleClick() && isDataValid()) {
                    b walletInterface = getWalletInterface();
                    HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
                    walletInterface.jump(dataItemArr[0].name, dataItemArr[0].type, dataItemArr[0].link_addr, dataItemArr[0].getPrevlogin());
                }
            } else if (view == this.l && !CheckUtils.isFastDoubleClick() && isDataValid()) {
                HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                if (dataItemArr2[0].buttons == null || dataItemArr2[0].buttons.length == 0 || dataItemArr2[0].buttons[0] == null) {
                    return;
                }
                b walletInterface2 = getWalletInterface();
                HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
                walletInterface2.jump(dataItemArr3[0].buttons[0].name, dataItemArr3[0].buttons[0].type, dataItemArr3[0].buttons[0].link_addr, dataItemArr3[0].getPrevlogin());
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.j.resetMaskText();
        if (this.i != null) {
            this.i.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        NetImageView netImageView = this.o;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_background);
        if (!TextUtils.isEmpty(this.mConfigData.list[0].logo)) {
            this.f24638g.setVisibility(0);
            NetImageView netImageView2 = this.f24638g;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].logo);
        } else {
            this.f24638g.setVisibility(8);
        }
        this.f24639h.setMaskText(this.mConfigData.list[0].name);
        this.j.setMaskText(this.mConfigData.list[0].value2);
        boolean z = !TextUtils.isEmpty(this.mConfigData.list[0].value2) && this.mConfigData.list[0].value2.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
        this.j.setTextSize(1, z ? 44.0f : 22.0f);
        this.j.setPadding(0, DisplayUtils.dip2px(getContext(), z ? 0.0f : 19.0f), 0, DisplayUtils.dip2px(getContext(), z ? 0.0f : 10.0f));
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        if (dataItemArr[0].icons != null && dataItemArr[0].icons.length > 0) {
            int length = dataItemArr[0].icons.length <= 3 ? dataItemArr[0].icons.length : 3;
            int i = q / length;
            for (int i2 = 0; i2 < length; i2++) {
                HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                if (dataItemArr2[0].icons[i2] != null && !TextUtils.isEmpty(dataItemArr2[0].icons[i2].name)) {
                    CHBigCreditCardTipsItem cHBigCreditCardTipsItem = new CHBigCreditCardTipsItem(getContext());
                    cHBigCreditCardTipsItem.setMaxLength(i);
                    cHBigCreditCardTipsItem.setData(this.mConfigData.list[0].icons[i2], getWalletInterface());
                    if (i2 == length - 1) {
                        cHBigCreditCardTipsItem.setShowDivider(false);
                    }
                    cHBigCreditCardTipsItem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (CheckUtils.isFastDoubleClick()) {
                                return;
                            }
                            CHBigCreditCardGroup.this.getWalletInterface().jump(CHBigCreditCardGroup.this.mConfigData.list[0].name, CHBigCreditCardGroup.this.mConfigData.list[0].type, CHBigCreditCardGroup.this.mConfigData.list[0].link_addr, CHBigCreditCardGroup.this.mConfigData.list[0].getPrevlogin());
                        }
                    });
                    this.k.addView(cHBigCreditCardTipsItem);
                    this.r.add(cHBigCreditCardTipsItem);
                }
            }
        }
        HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
        if (dataItemArr3[0].buttons != null && dataItemArr3[0].buttons.length > 0) {
            if (dataItemArr3[0].buttons[0] != null) {
                this.l.setText(dataItemArr3[0].buttons[0].name);
            } else {
                this.l.setVisibility(8);
            }
            HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
            if (dataItemArr4[0].buttons.length > 1 && dataItemArr4[0].buttons[1] != null) {
                this.m.setVisibility(0);
                MaskTextView maskTextView = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_time"));
                MaskTextView maskTextView2 = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_repayment_button_text"));
                NetImageView netImageView3 = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_icon"));
                this.n.setVisibility(0);
                if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].icon)) {
                    netImageView3.setVisibility(0);
                    netImageView3.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].buttons[1].icon);
                } else {
                    netImageView3.setVisibility(8);
                }
                maskTextView.setMaskText(this.mConfigData.list[0].buttons[1].btn_type);
                if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].name)) {
                    maskTextView2.setVisibility(0);
                    maskTextView2.setMaskText(this.mConfigData.list[0].buttons[1].name);
                } else {
                    maskTextView2.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].type) && !TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].link_addr)) {
                    findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_button")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            CHBigCreditCardGroup.this.getWalletInterface().jump(CHBigCreditCardGroup.this.mConfigData.list[0].buttons[1].name, CHBigCreditCardGroup.this.mConfigData.list[0].buttons[1].type, CHBigCreditCardGroup.this.mConfigData.list[0].buttons[1].link_addr, CHBigCreditCardGroup.this.mConfigData.list[0].getPrevlogin());
                        }
                    });
                }
            } else {
                this.m.setVisibility(8);
                this.n.setVisibility(8);
            }
        }
        HomeCfgResponse.DataItem[] dataItemArr5 = this.mConfigData.list;
        if (dataItemArr5[0].value3 != null && TextUtils.equals(dataItemArr5[0].value3, "1")) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.i.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        this.i.setOnClickListener(this);
    }

    public CHBigCreditCardGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24633a = 3;
        this.f24634b = 44;
        this.f24635c = 22;
        this.f24636e = 19.0f;
        this.f24637f = 10.0f;
        this.p = true;
        this.r = new ArrayList();
    }
}
