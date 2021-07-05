package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.HomeLayoutOneTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class NHLifeGridLayout extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GridLayout f25111a;

    /* renamed from: b  reason: collision with root package name */
    public HomeLayoutOneTipView f25112b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f25113c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHLifeGridLayout(Context context) {
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
        this.f25113c = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gridLayout) == null) {
            gridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25113c : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_life_layout_finance"), this);
            GridLayout gridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "grid_layout"));
            this.f25111a = gridLayout;
            gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_whiteColor"));
            this.f25112b = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25112b.setData(this.mConfigData, getWalletInterface());
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            this.f25111a.setColumnCount(4);
            this.f25111a.setHorizontalSpacing(0);
            this.f25111a.setVerticalSpacing(0);
            this.f25111a.setPadding(20, 20, 20, 30);
            a(this.f25111a);
            for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
                NHLifeGridItem nHLifeGridItem = new NHLifeGridItem(getContext());
                nHLifeGridItem.setData(dataItem, getWalletInterface());
                this.f25111a.addView(nHLifeGridItem);
                this.f25113c.add(nHLifeGridItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHLifeGridLayout(Context context, AttributeSet attributeSet) {
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
        this.f25113c = new ArrayList();
    }
}
