package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;
/* loaded from: classes8.dex */
public class UMHGuideGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LEAST_ITEM = 3;
    public static final int MAX_ITEM = 6;
    public static final int MIN_ITEM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public GridLayout mGridLayout;
    public NetImageView mPicture;
    public UMHTitleView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHGuideGroup(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_guide_layout"), this);
            this.mTitle = (UMHTitleView) findViewById(ResUtils.id(getContext(), "guide_group_title"));
            NetImageView netImageView = (NetImageView) findViewById(ResUtils.id(getContext(), "guide_group_pic"));
            this.mPicture = netImageView;
            ViewGroup.LayoutParams layoutParams = netImageView.getLayoutParams();
            layoutParams.height = (DisplayUtils.getDisplayWidth(getContext()) * 189) / 750;
            this.mPicture.setLayoutParams(layoutParams);
            this.mGridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "guide_group_grid"));
            this.mPicture.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHGuideGroup.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ UMHGuideGroup f61549a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61549a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f61549a.getWalletInterface().jump(this.f61549a.mConfigData.stat != null ? this.f61549a.mConfigData.stat.getName() : this.f61549a.mConfigData.getGroup_name(), this.f61549a.mConfigData.getGroup_type(), this.f61549a.mConfigData.getGroup_link(), this.f61549a.mConfigData.getGroup_prevlogin());
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length < 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.ConfigData configData;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (configData = this.mConfigData) == null || (dataItemArr = configData.list) == null || dataItemArr.length < 1) {
            return;
        }
        int i2 = 3;
        this.mGridLayout.setColumnCount(3);
        this.mGridLayout.setHorizontalSpacing(0);
        this.mGridLayout.setVerticalSpacing(0);
        this.mGridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        this.mTitle.setData(this.mConfigData, getWalletInterface());
        NetImageView netImageView = this.mPicture;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_logo);
        HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
        int length = dataItemArr2.length;
        if (length < 3) {
            this.mGridLayout.setVisibility(8);
            i2 = 0;
        } else if (length >= 6) {
            i2 = 6;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (dataItemArr2[i3] != null) {
                UMHGuideItem uMHGuideItem = new UMHGuideItem(getContext());
                uMHGuideItem.setData(dataItemArr2[i3], getWalletInterface());
                this.mGridLayout.addView(uMHGuideItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHGuideGroup(Context context, AttributeSet attributeSet) {
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
