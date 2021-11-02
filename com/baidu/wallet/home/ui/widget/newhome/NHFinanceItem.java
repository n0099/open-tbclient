package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes10.dex */
public class NHFinanceItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View divider_view;
    public FrameLayout framelayout_content;
    public TextView tv_name;
    public TextView tv_value1;
    public TextView tv_value2;
    public TextView tv_value3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHFinanceItem(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_finance_item"), this);
            this.tv_name = (TextView) findViewById(ResUtils.id(getContext(), "tv_name"));
            this.tv_value1 = (TextView) findViewById(ResUtils.id(getContext(), "tv_value1"));
            this.tv_value2 = (TextView) findViewById(ResUtils.id(getContext(), "tv_value2"));
            this.tv_value3 = (TextView) findViewById(ResUtils.id(getContext(), "tv_value3"));
            this.framelayout_content = (FrameLayout) findViewById(ResUtils.id(getContext(), "framelayout_content"));
            this.divider_view = findViewById(ResUtils.id(getContext(), "divider_view"));
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getData() == null) {
            return;
        }
        this.tv_name.setText(getData().name);
        if (!TextUtils.isEmpty(getData().value2)) {
            this.tv_value2.setText(getData().value2);
            this.tv_value2.setVisibility(0);
        } else {
            this.tv_value2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(getData().value3)) {
            this.tv_value3.setText(getData().value3);
            this.tv_value3.setVisibility(0);
        } else {
            this.tv_value3.setVisibility(8);
        }
        if (!TextUtils.isEmpty(getData().value1)) {
            this.tv_value1.setText(getData().value1);
            this.tv_value1.setVisibility(0);
            return;
        }
        this.tv_value1.setVisibility(8);
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
    public NHFinanceItem(Context context, AttributeSet attributeSet) {
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
