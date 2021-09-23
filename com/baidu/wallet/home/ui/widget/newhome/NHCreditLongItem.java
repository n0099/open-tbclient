package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
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
/* loaded from: classes8.dex */
public class NHCreditLongItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f61576a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f61577b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f61578c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f61579d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f61580e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61581f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditLongItem(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_item"), this);
            this.f61576a = (NetImageView) findViewById(ResUtils.id(getContext(), "bg_pic"));
            this.f61577b = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title1"));
            this.f61578c = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_title2"));
            this.f61579d = (MaskTextView) findViewById(ResUtils.id(getContext(), "tv_desc"));
            this.f61580e = (MaskTextView) findViewById(ResUtils.id(getContext(), "bt_submit"));
            this.f61581f = (TextView) findViewById(ResUtils.id(getContext(), "tv_dot"));
        }
    }

    public void refresh() {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f61576a, getData().logo);
        boolean z = true;
        boolean z2 = (TextUtils.isEmpty(getData().name) || this.f61577b == null) ? false : true;
        z = (TextUtils.isEmpty(getData().value1) || this.f61578c == null) ? false : false;
        if (z2) {
            this.f61577b.setVisibility(0);
            this.f61577b.setMaskText(getData().name);
        }
        if (z) {
            this.f61578c.setVisibility(0);
            this.f61578c.setMaskText(getData().value1);
        }
        this.f61581f.setVisibility((z2 && z) ? 0 : 8);
        if (!TextUtils.isEmpty(getData().value2) && (maskTextView = this.f61579d) != null) {
            maskTextView.setVisibility(0);
            this.f61579d.setMaskText(getData().value2);
        }
        if (!TextUtils.isEmpty(getData().value3)) {
            this.f61580e.setVisibility(0);
            this.f61580e.setMaskText(getData().value3);
            return;
        }
        this.f61580e.setVisibility(4);
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
    public NHCreditLongItem(Context context, AttributeSet attributeSet) {
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
