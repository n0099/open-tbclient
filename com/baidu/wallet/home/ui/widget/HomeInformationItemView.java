package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
/* loaded from: classes13.dex */
public class HomeInformationItemView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53173b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53174c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53175d;
    public View mLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeInformationItemView(Context context, AttributeSet attributeSet) {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeAllViews();
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_information_item_view"), this);
            this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "home_info_item_logo"));
            this.f53173b = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_title"));
            this.f53174c = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_date"));
            this.f53175d = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_source"));
            this.mLine = findViewById(ResUtils.id(getContext(), "home_info_item_line"));
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

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getData() == null) {
            return;
        }
        a();
        if (this.a != null) {
            String str = getData().value3;
            if (!TextUtils.isEmpty(str)) {
                this.a.setImageUrl(str);
            }
        }
        if (this.f53173b != null) {
            String str2 = getData().name;
            if (!TextUtils.isEmpty(str2)) {
                this.f53173b.setText(str2);
            }
        }
        if (this.f53174c != null) {
            String str3 = getData().value2;
            if (!TextUtils.isEmpty(str3)) {
                this.f53174c.setText(str3);
            }
        }
        if (this.f53175d != null) {
            String str4 = getData().value1;
            if (!TextUtils.isEmpty(str4)) {
                this.f53175d.setText(str4);
            }
        }
        if (TextUtils.isEmpty(getData().link_addr)) {
            setOnClickListener(null);
            setEnabled(false);
        } else {
            setOnClickListener(this);
            setEnabled(true);
        }
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            a();
            refresh();
        }
    }

    public void setLineVisibility(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (view = this.mLine) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeInformationItemView(Context context) {
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
}
