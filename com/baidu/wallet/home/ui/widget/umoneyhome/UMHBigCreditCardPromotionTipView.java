package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
/* loaded from: classes8.dex */
public class UMHBigCreditCardPromotionTipView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f61674a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f61675b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f61676c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f61677d;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f61678e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f61679f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardPromotionTipView(Context context) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_tip_item_layout"), this);
            this.f61674a = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img1"));
            this.f61675b = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_img2"));
            this.f61676c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text1"));
            this.f61677d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_credit_card_tip_tip_item_text2"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.f61676c.resetMaskText();
            this.f61677d.resetMaskText();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HomeCfgResponse.DataIcon dataIcon = this.f61678e;
            if (dataIcon != null) {
                if (!TextUtils.isEmpty(dataIcon.icon_link)) {
                    this.f61674a.setImageUrl(this.f61678e.icon_link);
                }
                if (!TextUtils.isEmpty(this.f61678e.name)) {
                    this.f61676c.setVisibility(0);
                    this.f61676c.setMaskText(this.f61678e.name);
                } else {
                    this.f61676c.setVisibility(4);
                }
            } else {
                this.f61674a.setVisibility(4);
                this.f61676c.setVisibility(4);
            }
            HomeCfgResponse.DataIcon dataIcon2 = this.f61679f;
            if (dataIcon2 != null) {
                if (!TextUtils.isEmpty(dataIcon2.icon_link)) {
                    this.f61675b.setImageUrl(this.f61679f.icon_link);
                }
                if (!TextUtils.isEmpty(this.f61679f.name)) {
                    this.f61677d.setVisibility(0);
                    this.f61677d.setMaskText(this.f61679f.name);
                    return;
                }
                this.f61677d.setVisibility(4);
                return;
            }
            this.f61675b.setVisibility(4);
            this.f61677d.setVisibility(4);
        }
    }

    public void setData(HomeCfgResponse.DataIcon dataIcon, HomeCfgResponse.DataIcon dataIcon2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dataIcon, dataIcon2) == null) {
            this.f61678e = dataIcon;
            this.f61679f = dataIcon2;
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardPromotionTipView(Context context, AttributeSet attributeSet) {
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
    }
}
