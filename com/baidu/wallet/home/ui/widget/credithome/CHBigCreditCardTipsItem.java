package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes6.dex */
public class CHBigCreditCardTipsItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24991a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24992b;

    /* renamed from: c  reason: collision with root package name */
    public View f24993c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f24994d;

    /* renamed from: e  reason: collision with root package name */
    public b f24995e;

    /* renamed from: f  reason: collision with root package name */
    public int f24996f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardTipsItem(Context context) {
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
        this.f24996f = 24;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_tips_item"), this);
            this.f24991a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_img"));
            this.f24992b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_text"));
            this.f24993c = findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_divider"));
            this.f24992b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f24996f)});
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!TextUtils.isEmpty(this.f24994d.icon_link)) {
                this.f24991a.setVisibility(0);
                NetImageView netImageView = this.f24991a;
                netImageView.setImageUrl(this.f24995e.getAndroidPrefix() + this.f24994d.icon_link);
            } else {
                this.f24991a.setVisibility(8);
            }
            this.f24992b.setText(this.f24994d.name);
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

    public void setData(HomeCfgResponse.DataIcon dataIcon, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataIcon, bVar) == null) {
            this.f24994d = dataIcon;
            this.f24995e = bVar;
            a();
            b();
        }
    }

    public void setMaxLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f24996f = i2;
        }
    }

    public void setShowDivider(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f24993c.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardTipsItem(Context context, AttributeSet attributeSet) {
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
        this.f24996f = 24;
    }
}
