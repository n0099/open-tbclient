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
import java.util.List;
/* loaded from: classes8.dex */
public class NHCreditPicGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float WIDTH_DIVIDER = 15.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NHTitleView f61096a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f61097b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditPicGroup(Context context) {
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

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_layout"), this);
            this.f61096a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_group_title"));
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_group_list"));
            this.f61097b = linearLayout;
            linearLayout.setOrientation(0);
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
            this.f61096a.setData(this.mConfigData, getWalletInterface());
            this.f61096a.setHasGap(this.mConfigData.isLayoutHasGap());
            int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - (DisplayUtils.dip2px(getContext(), 15.0f) * 3)) / 2;
            int i2 = (displayWidth * 5) / 8;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth, i2);
            NHCreditPicItem nHCreditPicItem = new NHCreditPicItem(getContext());
            nHCreditPicItem.setData(this.mConfigData.list[0], getWalletInterface());
            this.f61097b.addView(nHCreditPicItem, layoutParams);
            if (this.mConfigData.list.length > 1) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(displayWidth, i2);
                NHCreditPicItem nHCreditPicItem2 = new NHCreditPicItem(getContext());
                layoutParams2.setMargins(DisplayUtils.dip2px(getContext(), 15.0f), 0, 0, 0);
                nHCreditPicItem2.setData(this.mConfigData.list[1], getWalletInterface());
                this.f61097b.addView(nHCreditPicItem2, layoutParams2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditPicGroup(Context context, AttributeSet attributeSet) {
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
