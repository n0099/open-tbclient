package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.WalletNewHomeActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class BaseItemLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f61277d;
    public HomeCfgResponse.ConfigData mConfigData;
    public b mWalletHomeInterface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseItemLayout(Context context) {
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
        this.f61277d = -1;
    }

    public void dispatchShowPoint(String str) {
        List<BaseItemView> children;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (children = getChildren()) == null) {
            return;
        }
        for (BaseItemView baseItemView : children) {
            baseItemView.forceShowPoint(str);
        }
    }

    public abstract List<BaseItemView> getChildren();

    public b getWalletInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mWalletHomeInterface : (b) invokeV.objValue;
    }

    public boolean hasItemShowPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<BaseItemView> children = getChildren();
            if (children == null) {
                return false;
            }
            for (BaseItemView baseItemView : children) {
                if (baseItemView.isShoudShowPoint()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void initView();

    public abstract boolean isDataValid();

    public void onEyeMaskChanged() {
        List<BaseItemView> children;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (children = getChildren()) == null) {
            return;
        }
        for (BaseItemView baseItemView : children) {
            baseItemView.onEyeMaskChanged();
        }
    }

    public abstract void refreshData();

    public void setConfigData(HomeCfgResponse.ConfigData configData, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configData, bVar) == null) {
            if (this.mConfigData == null || ((bVar instanceof WalletNewHomeActivity.r) && ((WalletNewHomeActivity.r) bVar).f61230a.f61211a > this.f61277d)) {
                this.mConfigData = configData;
                this.mWalletHomeInterface = bVar;
                if (bVar instanceof WalletNewHomeActivity.r) {
                    this.f61277d = ((WalletNewHomeActivity.r) bVar).f61230a.f61211a;
                }
                if (!isDataValid() || this.mWalletHomeInterface == null) {
                    return;
                }
                removeAllViews();
                initView();
                refreshData();
            }
        }
    }

    public void setNetImageViewUrl(NetImageView netImageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, netImageView, str) == null) || netImageView == null || TextUtils.isEmpty(str) || getWalletInterface() == null) {
            return;
        }
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseItemLayout(Context context, AttributeSet attributeSet) {
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
        this.f61277d = -1;
    }
}
