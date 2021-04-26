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
    public View f25222a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f25223b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25224c;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f25225e;

    /* renamed from: f  reason: collision with root package name */
    public UMHBigCreditCardContentView f25226f;

    /* renamed from: g  reason: collision with root package name */
    public UMHBigCreditCardStateContentView f25227g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25228h;

    /* renamed from: i  reason: collision with root package name */
    public UMHBigCreditCardRepayTipView f25229i;
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
        this.f25222a = findViewById(ResUtils.id(getContext(), "umh_big_credit_card_background"));
        this.f25223b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_logo"));
        this.f25224c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_text"));
        this.f25225e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_eye"));
        this.f25226f = (UMHBigCreditCardContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_group"));
        this.f25227g = (UMHBigCreditCardStateContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_shengpi_content_group"));
        this.f25228h = (LinearLayout) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_promotion_tips_group"));
        this.f25229i = (UMHBigCreditCardRepayTipView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_repay_tips_group"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0 || dataItemArr[0] == null) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f25225e || CheckUtils.isFastDoubleClick()) {
            return;
        }
        onEyeMaskChanged();
        getWalletInterface().onEyeMaskBtnClick();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        if (this.f25225e != null) {
            this.f25225e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        if ("603".equals(this.mConfigData.getGroup_layout())) {
            this.f25222a.setVisibility("0".equals(this.mConfigData.group_has_background) ? 4 : 0);
            this.k = true;
        } else {
            this.f25222a.setVisibility("1".equals(this.mConfigData.group_has_background) ? 0 : 4);
            this.k = false;
        }
        NetImageView netImageView = this.f25223b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].logo);
        this.f25224c.setText(this.mConfigData.list[0].name);
        if (!TextUtils.isEmpty(this.mConfigData.list[0].label)) {
            this.f25226f.setVisibility(0);
            this.f25227g.setVisibility(8);
            this.f25226f.setIsManYiDai(this.k);
            this.f25226f.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.f25226f);
        } else {
            this.f25226f.setVisibility(8);
            this.f25227g.setVisibility(0);
            this.f25227g.setIsManYiDai(this.k);
            this.f25227g.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.f25227g);
        }
        if (this.mConfigData.list[0].repay != null) {
            this.f25228h.setVisibility(8);
            this.f25229i.setVisibility(0);
            this.f25229i.setIsManYiDai(this.k);
            this.f25229i.setData(this.mConfigData.list[0], getWalletInterface());
            this.j.add(this.f25229i);
        } else {
            this.f25229i.setVisibility(8);
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            if (dataItemArr[0].icons != null && dataItemArr[0].icons.length > 0) {
                this.f25228h.setVisibility(0);
                HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                int length = dataItemArr2[0].icons.length <= 4 ? dataItemArr2[0].icons.length : 4;
                int i2 = 0;
                while (i2 < length) {
                    UMHBigCreditCardPromotionTipView uMHBigCreditCardPromotionTipView = new UMHBigCreditCardPromotionTipView(getContext());
                    if (i2 == length - 1) {
                        uMHBigCreditCardPromotionTipView.setData(this.mConfigData.list[0].icons[i2], (HomeCfgResponse.DataIcon) null);
                    } else {
                        HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
                        HomeCfgResponse.DataIcon dataIcon = dataItemArr3[0].icons[i2];
                        i2++;
                        uMHBigCreditCardPromotionTipView.setData(dataIcon, dataItemArr3[0].icons[i2]);
                    }
                    this.f25228h.addView(uMHBigCreditCardPromotionTipView);
                    i2++;
                }
            } else {
                this.f25228h.setVisibility(8);
            }
        }
        HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
        if (dataItemArr4[0].value3 != null && TextUtils.equals(dataItemArr4[0].value3, "1")) {
            this.f25225e.setVisibility(8);
            return;
        }
        this.f25225e.setVisibility(0);
        this.f25225e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
        this.f25225e.setOnClickListener(this);
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
