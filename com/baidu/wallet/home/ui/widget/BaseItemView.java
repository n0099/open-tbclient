package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes6.dex */
public abstract class BaseItemView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomeCfgResponse.DataItem a;

    /* renamed from: b  reason: collision with root package name */
    public b f49745b;

    /* renamed from: c  reason: collision with root package name */
    public Context f49746c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseItemView(Context context) {
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
        this.f49746c = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setOnClickListener(this);
            setPadding(0, 0, -1, 0);
        }
    }

    public void forceShowPoint(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(this.a.link_addr) && this.a.link_addr.equalsIgnoreCase(str)) {
            com.baidu.wallet.home.storage.a.a(this.f49746c, this.a.link_addr, "-1");
            handlePoint();
            getWalletInterface().onPointShowChanged();
        }
    }

    public HomeCfgResponse.DataItem getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (HomeCfgResponse.DataItem) invokeV.objValue;
    }

    public b getWalletInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49745b : (b) invokeV.objValue;
    }

    public abstract boolean handlePoint();

    public boolean hasCornor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.a;
            return dataItem != null && dataItem.hasCornor();
        }
        return invokeV.booleanValue;
    }

    public boolean isShoudShowPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.a;
            return dataItem != null && dataItem.isShoudShowPoint(getContext());
        }
        return invokeV.booleanValue;
    }

    public boolean isShowCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.a;
            return dataItem != null && "3".equalsIgnoreCase(dataItem.timestamp_icon) && this.a.isShoudShowPoint(getContext());
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRedDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.a;
            return dataItem != null && "2".equalsIgnoreCase(dataItem.timestamp_icon) && this.a.isShoudShowPoint(getContext());
        }
        return invokeV.booleanValue;
    }

    public boolean isShowWhiteDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.a;
            return dataItem != null && "1".equalsIgnoreCase(dataItem.timestamp_icon) && this.a.isShoudShowPoint(getContext());
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || CheckUtils.isFastDoubleClick() || this.a == null || getWalletInterface() == null) {
            return;
        }
        if (isShoudShowPoint()) {
            if (!TextUtils.isEmpty(this.a.link_addr)) {
                Context context = this.f49746c;
                HomeCfgResponse.DataItem dataItem = this.a;
                com.baidu.wallet.home.storage.a.a(context, dataItem.link_addr, TextUtils.isEmpty(dataItem.timestamp) ? "0" : this.a.timestamp);
            }
            handlePoint();
            getWalletInterface().onPointShowChanged();
        }
        b walletInterface = getWalletInterface();
        HomeCfgResponse.DataItem dataItem2 = this.a;
        HomeCfgResponse.Stat stat = dataItem2.stat;
        walletInterface.jump(stat != null ? stat.getName() : dataItem2.getName(), this.a.getType(), this.a.getLinkAddr(), this.a.getPrevlogin());
    }

    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, dataItem, bVar) == null) {
            this.a = dataItem;
            this.f49745b = bVar;
        }
    }

    public void setNetImageViewUrl(NetImageView netImageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, netImageView, str) == null) || netImageView == null || TextUtils.isEmpty(str) || getWalletInterface() == null) {
            return;
        }
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseItemView(Context context, AttributeSet attributeSet) {
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
        this.f49746c = context;
        a();
    }
}
