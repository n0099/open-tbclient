package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class NHCreditLongGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ITEM_LIMIT = 12;
    public static final float WIDTH_DIVIDER = 15.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NHTitleView f58492a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f58493b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f58494c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditLongGroup(Context context) {
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
        this.f58494c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58494c : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_layout"), this);
            this.f58492a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_group_title"));
            this.f58493b = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_group_list"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58492a.setData(this.mConfigData, getWalletInterface());
            this.f58492a.setHasGap(this.mConfigData.isLayoutHasGap());
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            if (dataItemArr == null) {
                return;
            }
            int length = 12 >= dataItemArr.length ? dataItemArr.length : 12;
            int i2 = 0;
            while (i2 < length) {
                NHCreditLongItem nHCreditLongItem = new NHCreditLongItem(getContext());
                nHCreditLongItem.setData(dataItemArr[i2], getWalletInterface());
                this.f58493b.addView(nHCreditLongItem);
                this.f58494c.add(nHCreditLongItem);
                ((LinearLayout.LayoutParams) nHCreditLongItem.getLayoutParams()).setMargins(0, DisplayUtils.dip2px(getContext(), i2 == 0 ? 0.0f : 15.0f), 0, 0);
                i2++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditLongGroup(Context context, AttributeSet attributeSet) {
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
        this.f58494c = new ArrayList();
    }
}
