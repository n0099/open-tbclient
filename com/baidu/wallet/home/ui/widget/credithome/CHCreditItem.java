package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class CHCreditItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f61381a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f61382b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f61383c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f61384d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f61385e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHCreditItem(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_item"), this);
            this.f61381a = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines"));
            this.f61382b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_tip"));
            this.f61383c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_title"));
            this.f61385e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_lable"));
            this.f61384d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_lines_title_desc"));
        }
    }

    public void refresh() {
        MaskTextView maskTextView;
        MaskTextView maskTextView2;
        MaskTextView maskTextView3;
        MaskTextView maskTextView4;
        MaskTextView maskTextView5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getData() == null) {
            return;
        }
        if (!TextUtils.isEmpty(getData().value1) && (maskTextView5 = this.f61381a) != null) {
            maskTextView5.setMaskText(getData().value1);
        }
        if (!TextUtils.isEmpty(getData().value2) && (maskTextView4 = this.f61382b) != null) {
            maskTextView4.setMaskText(getData().value2);
        }
        if (!TextUtils.isEmpty(getData().name) && (maskTextView3 = this.f61383c) != null) {
            maskTextView3.setMaskText(getData().name);
        }
        if (!TextUtils.isEmpty(getData().label) && (maskTextView2 = this.f61385e) != null) {
            maskTextView2.setMaskText(getData().label);
        } else {
            MaskTextView maskTextView6 = this.f61385e;
            if (maskTextView6 != null) {
                maskTextView6.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(getData().value3) || (maskTextView = this.f61384d) == null) {
            return;
        }
        maskTextView.setMaskText(getData().value3);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHCreditItem(Context context, AttributeSet attributeSet) {
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
