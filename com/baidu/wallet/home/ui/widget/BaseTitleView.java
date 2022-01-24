package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes13.dex */
public class BaseTitleView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomeCfgResponse.ConfigData a;

    /* renamed from: b  reason: collision with root package name */
    public b f51161b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51162c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTitleView(Context context) {
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
        this.f51162c = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setOnClickListener(this);
        }
    }

    public HomeCfgResponse.ConfigData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (HomeCfgResponse.ConfigData) invokeV.objValue;
    }

    public String getGroupDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return (configData == null || TextUtils.isEmpty(configData.getGroup_desc())) ? "" : this.a.getGroup_desc();
        }
        return (String) invokeV.objValue;
    }

    public String getGroupLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return (configData == null || TextUtils.isEmpty(configData.getGroup_layout())) ? "" : this.a.getGroup_layout();
        }
        return (String) invokeV.objValue;
    }

    public String getGroupLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return (configData == null || TextUtils.isEmpty(configData.getGroup_link())) ? "" : this.a.getGroup_link();
        }
        return (String) invokeV.objValue;
    }

    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return (configData == null || TextUtils.isEmpty(configData.getGroup_name())) ? "" : this.a.getGroup_name();
        }
        return (String) invokeV.objValue;
    }

    public String getGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return (configData == null || TextUtils.isEmpty(configData.getGroup_type())) ? "" : this.a.getGroup_type();
        }
        return (String) invokeV.objValue;
    }

    public b getWalletInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51161b : (b) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean isClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.a;
            return configData != null && configData.isGroupCanClick();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || this.a == null || getWalletInterface() == null) {
            return;
        }
        b walletInterface = getWalletInterface();
        HomeCfgResponse.ConfigData configData = this.a;
        HomeCfgResponse.Stat stat = configData.stat;
        walletInterface.jump(stat != null ? stat.getName() : configData.getGroup_name(), this.a.getGroup_type(), this.a.getGroup_link(), this.a.getGroup_prevlogin());
    }

    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void setData(HomeCfgResponse.ConfigData configData, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, configData, bVar) == null) {
            this.a = configData;
            this.f51161b = bVar;
            if (!isClickable()) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTitleView(Context context, AttributeSet attributeSet) {
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
        this.f51162c = context;
        a();
    }
}
