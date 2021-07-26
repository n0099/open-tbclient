package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class UMHBigCreditCardGroup extends BaseItemLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f25392a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f25393b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25394c;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f25395e;

    /* renamed from: f  reason: collision with root package name */
    public UMHBigCreditCardContentView f25396f;

    /* renamed from: g  reason: collision with root package name */
    public UMHBigCreditCardStateContentView f25397g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25398h;

    /* renamed from: i  reason: collision with root package name */
    public UMHBigCreditCardRepayTipView f25399i;
    public List<BaseItemView> j;
    public boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_group_layout"), this);
            this.f25392a = findViewById(ResUtils.id(getContext(), "umh_big_credit_card_background"));
            this.f25393b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_logo"));
            this.f25394c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_text"));
            this.f25395e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_title_eye"));
            this.f25396f = (UMHBigCreditCardContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_group"));
            this.f25397g = (UMHBigCreditCardStateContentView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_shengpi_content_group"));
            this.f25398h = (LinearLayout) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_promotion_tips_group"));
            this.f25399i = (UMHBigCreditCardRepayTipView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_repay_tips_group"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0 || dataItemArr[0] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f25395e && !CheckUtils.isFastDoubleClick()) {
            onEyeMaskChanged();
            getWalletInterface().onEyeMaskBtnClick();
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onEyeMaskChanged();
            if (this.f25395e != null) {
                this.f25395e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ("603".equals(this.mConfigData.getGroup_layout())) {
                this.f25392a.setVisibility("0".equals(this.mConfigData.group_has_background) ? 4 : 0);
                this.k = true;
            } else {
                this.f25392a.setVisibility("1".equals(this.mConfigData.group_has_background) ? 0 : 4);
                this.k = false;
            }
            NetImageView netImageView = this.f25393b;
            netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].logo);
            this.f25394c.setText(this.mConfigData.list[0].name);
            if (!TextUtils.isEmpty(this.mConfigData.list[0].label)) {
                this.f25396f.setVisibility(0);
                this.f25397g.setVisibility(8);
                this.f25396f.setIsManYiDai(this.k);
                this.f25396f.setData(this.mConfigData.list[0], getWalletInterface());
                this.j.add(this.f25396f);
            } else {
                this.f25396f.setVisibility(8);
                this.f25397g.setVisibility(0);
                this.f25397g.setIsManYiDai(this.k);
                this.f25397g.setData(this.mConfigData.list[0], getWalletInterface());
                this.j.add(this.f25397g);
            }
            if (this.mConfigData.list[0].repay != null) {
                this.f25398h.setVisibility(8);
                this.f25399i.setVisibility(0);
                this.f25399i.setIsManYiDai(this.k);
                this.f25399i.setData(this.mConfigData.list[0], getWalletInterface());
                this.j.add(this.f25399i);
            } else {
                this.f25399i.setVisibility(8);
                HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
                if (dataItemArr[0].icons != null && dataItemArr[0].icons.length > 0) {
                    this.f25398h.setVisibility(0);
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
                        this.f25398h.addView(uMHBigCreditCardPromotionTipView);
                        i2++;
                    }
                } else {
                    this.f25398h.setVisibility(8);
                }
            }
            HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
            if (dataItemArr4[0].value3 != null && TextUtils.equals(dataItemArr4[0].value3, "1")) {
                this.f25395e.setVisibility(8);
                return;
            }
            this.f25395e.setVisibility(0);
            this.f25395e.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_umh_eye_close" : "wallet_home_umh_eye_open"));
            this.f25395e.setOnClickListener(this);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void setConfigData(HomeCfgResponse.ConfigData configData, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, configData, bVar) == null) {
            super.setConfigData(configData, bVar);
            setOnClickListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
    }
}
