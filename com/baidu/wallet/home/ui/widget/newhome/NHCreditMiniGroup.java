package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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
/* loaded from: classes13.dex */
public class NHCreditMiniGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float HIEGHT = 98.5f;
    public static final int ITEM_LIMIT = 12;
    public static final float WIDTH_DIVIDER = 15.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public NHTitleView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f51285b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f51286c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditMiniGroup(Context context) {
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
        this.f51286c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51286c : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_mini_layout"), this);
            this.a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_mini_title"));
            this.f51285b = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_mini_layout"));
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
        int dip2px;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setData(this.mConfigData, getWalletInterface());
            this.a.setHasGap(this.mConfigData.isLayoutHasGap());
            int displayWidth = DisplayUtils.getDisplayWidth(getContext());
            if (this.mConfigData.list.length <= 2) {
                this.f51285b.setLayoutParams(new FrameLayout.LayoutParams(displayWidth, -2));
                dip2px = (int) ((displayWidth - (DisplayUtils.dip2px(getContext(), 15.0f) * 3.0f)) / 2.0f);
            } else {
                this.f51285b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                dip2px = (int) ((displayWidth - (DisplayUtils.dip2px(getContext(), 15.0f) * 3.0f)) / 2.2d);
            }
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            int length = 12 >= dataItemArr.length ? dataItemArr.length : 12;
            for (int i2 = 0; i2 < length; i2++) {
                NHCreditMiniItem nHCreditMiniItem = new NHCreditMiniItem(getContext());
                nHCreditMiniItem.setData(this.mConfigData.list[i2], getWalletInterface());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, DisplayUtils.dip2px(getContext(), 98.5f));
                layoutParams.width = dip2px;
                layoutParams.setMargins(DisplayUtils.dip2px(getContext(), 15.0f), 0, 0, 0);
                this.f51285b.addView(nHCreditMiniItem, layoutParams);
                this.f51286c.add(nHCreditMiniItem);
            }
            this.f51285b.addView(new View(getContext()), new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 15.0f), DisplayUtils.dip2px(getContext(), 98.5f)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditMiniGroup(Context context, AttributeSet attributeSet) {
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
        this.f51286c = new ArrayList();
    }
}
