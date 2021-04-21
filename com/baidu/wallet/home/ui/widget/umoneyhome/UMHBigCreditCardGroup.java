package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class UMHBigCreditCardGroup extends BaseItemLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f24467a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24468b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24469c;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24470e;

    /* renamed from: f  reason: collision with root package name */
    public UMHBigCreditCardContentView f24471f;

    /* renamed from: g  reason: collision with root package name */
    public UMHBigCreditCardStateContentView f24472g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24473h;
    public UMHBigCreditCardRepayTipView i;
    public List<BaseItemView> j;
    public boolean k;

    public UMHBigCreditCardGroup(Context context) {
        super(context);
        this.j = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.j;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_group_layout"), this);
        this.f24467a = findViewById(ResUtils.id(getContext(), "umh_big_credit_card_background"));
        this.f24468b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_logo"));
        this.f24469c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_text"));
        this.f24470e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_eye"));
        this.f24471f = (UMHBigCreditCardContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_group"));
        this.f24472g = (UMHBigCreditCardStateContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_shengpi_content_group"));
        this.f24473h = (LinearLayout) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_promotion_tips_group"));
        this.i = (UMHBigCreditCardRepayTipView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_repay_tips_group"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0 || dataItemArr[0] == null) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f24470e || CheckUtils.isFastDoubleClick()) {
            return;
        }
        onEyeMaskChanged();
        getWalletInterface().onEyeMaskBtnClick();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        if (this.f24470e != null) {
            this.f24470e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        if ("603".equals(this.mConfigData.getGroup_layout())) {
            this.f24467a.setVisibility("0".equals(this.mConfigData.group_has_background) ? 4 : 0);
            this.k = true;
        } else {
            this.f24467a.setVisibility("1".equals(this.mConfigData.group_has_background) ? 0 : 4);
            this.k = false;
        }
        NetImageView netImageView = this.f24468b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].logo);
        this.f24469c.setText(this.mConfigData.list[0].name);
        if (!TextUtils.isEmpty(this.mConfigData.list[0].label)) {
            this.f24471f.setVisibility(0);
            this.f24472g.setVisibility(8);
            this.f24471f.setIsManYiDai(this.k);
            this.f24471f.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.f24471f);
        } else {
            this.f24471f.setVisibility(8);
            this.f24472g.setVisibility(0);
            this.f24472g.setIsManYiDai(this.k);
            this.f24472g.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.f24472g);
        }
        if (this.mConfigData.list[0].repay != null) {
            this.f24473h.setVisibility(8);
            this.i.setVisibility(0);
            this.i.setIsManYiDai(this.k);
            this.i.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.i);
        } else {
            this.i.setVisibility(8);
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            if (dataItemArr[0].icons != null && dataItemArr[0].icons.length > 0) {
                this.f24473h.setVisibility(0);
                HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                int length = dataItemArr2[0].icons.length <= 4 ? dataItemArr2[0].icons.length : 4;
                int i = 0;
                while (i < length) {
                    UMHBigCreditCardPromotionTipView uMHBigCreditCardPromotionTipView = new UMHBigCreditCardPromotionTipView(getContext());
                    if (i == length - 1) {
                        uMHBigCreditCardPromotionTipView.setData(this.mConfigData.list[0].icons[i], (HomeCfgResponse.DataIcon) null);
                    } else {
                        HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
                        HomeCfgResponse.DataIcon dataIcon = dataItemArr3[0].icons[i];
                        i++;
                        uMHBigCreditCardPromotionTipView.setData(dataIcon, dataItemArr3[0].icons[i]);
                    }
                    this.f24473h.addView(uMHBigCreditCardPromotionTipView);
                    i++;
                }
            } else {
                this.f24473h.setVisibility(8);
            }
        }
        HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
        if (dataItemArr4[0].value3 != null && TextUtils.equals(dataItemArr4[0].value3, "1")) {
            this.f24470e.setVisibility(8);
            return;
        }
        this.f24470e.setVisibility(0);
        this.f24470e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
        this.f24470e.setOnClickListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void setConfigData(HomeCfgResponse.ConfigData configData, b bVar) {
        super.setConfigData(configData, bVar);
        setOnClickListener(this);
    }

    public UMHBigCreditCardGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList();
    }
}
