package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
/* loaded from: classes10.dex */
public class SwitchButton extends ImageButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61437a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61438b;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context) {
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
        this.f61438b = false;
        a();
    }

    public boolean isChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61437a == this.f61438b : invokeV.booleanValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61437a : invokeV.booleanValue;
    }

    public void resetChecked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61438b = this.f61437a;
        }
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_pressed_on"));
            } else {
                setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_default_off"));
            }
            this.f61437a = z;
            AccessibilityUtils.setContentDescription(this, !z ? "开" : "关");
        }
    }

    public void setOnCheckedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            setOnClickListener(new View.OnClickListener(this, aVar) { // from class: com.baidu.wallet.paysdk.ui.widget.SwitchButton.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f61439a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SwitchButton f61440b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61440b = this;
                    this.f61439a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar2 = this.f61439a) == null) {
                        return;
                    }
                    aVar2.a(!this.f61440b.f61437a);
                }
            });
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_default_off"));
            AccessibilityUtils.setContentDescription(this, !this.f61437a ? "开" : "关");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context, AttributeSet attributeSet) {
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
        this.f61438b = false;
        a();
    }
}
