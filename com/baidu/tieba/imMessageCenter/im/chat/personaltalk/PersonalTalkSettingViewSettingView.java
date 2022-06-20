package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SettingTextSwitchView a;
    public SettingTextSwitchView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z) {
                this.a.h(false);
            } else {
                this.a.f(false);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0636, this);
            SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.obfuscated_res_0x7f091dcb);
            this.a = settingTextSwitchView;
            SkinManager.setBackgroundColor(settingTextSwitchView.getView(), R.color.CAM_X0201);
            SettingTextSwitchView settingTextSwitchView2 = (SettingTextSwitchView) findViewById(R.id.obfuscated_res_0x7f091dcd);
            this.b = settingTextSwitchView2;
            SkinManager.setBackgroundColor(settingTextSwitchView2.getView(), R.color.CAM_X0201);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.b.g();
            } else {
                this.b.e();
            }
        }
    }

    public BdSwitchView getChatNeglectSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SettingTextSwitchView settingTextSwitchView = this.a;
            if (settingTextSwitchView != null) {
                return settingTextSwitchView.getSwitchView();
            }
            return null;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView getTopToChatSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SettingTextSwitchView settingTextSwitchView = this.b;
            if (settingTextSwitchView != null) {
                return settingTextSwitchView.getSwitchView();
            }
            return null;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        SettingTextSwitchView settingTextSwitchView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (settingTextSwitchView = this.a) == null) {
            return;
        }
        settingTextSwitchView.setSwitchStateChangeListener(bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }
}
