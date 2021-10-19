package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class NHHeadToolGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_ITEM = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f61634a;
    public NetImageView mBackground;
    public GridLayout mGrid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHHeadToolGroup(Context context) {
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
        this.f61634a = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61634a : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_head_tool_layout"), this);
            NetImageView netImageView = (NetImageView) findViewById(ResUtils.id(getContext(), "head_tool_bg"));
            this.mBackground = netImageView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) netImageView.getLayoutParams();
            int displayWidth = DisplayUtils.getDisplayWidth(getContext());
            int i2 = (displayWidth * 116) / 750;
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(displayWidth, i2);
            } else {
                layoutParams.width = displayWidth;
                layoutParams.height = i2;
            }
            this.mBackground.setLayoutParams(layoutParams);
            GridLayout gridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "head_tool_grid"));
            this.mGrid = gridLayout;
            gridLayout.setHorizontalSpacing(0);
            this.mGrid.setVerticalSpacing(1);
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
            setNetImageViewUrl(this.mBackground, this.mConfigData.getGroup_logo());
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            int length = dataItemArr.length < 4 ? dataItemArr.length : 4;
            this.mGrid.setColumnCount(length);
            for (int i2 = 0; i2 < length; i2++) {
                NHHeadToolItem nHHeadToolItem = new NHHeadToolItem(getContext());
                nHHeadToolItem.setData(dataItemArr[i2], getWalletInterface());
                this.mGrid.addView(nHHeadToolItem);
                this.f61634a.add(nHHeadToolItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHHeadToolGroup(Context context, AttributeSet attributeSet) {
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
        this.f61634a = new ArrayList();
    }
}
