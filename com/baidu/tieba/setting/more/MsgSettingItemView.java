package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class MsgSettingItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20920e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20921f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20922g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwitchView f20923h;

    /* renamed from: i  reason: collision with root package name */
    public View f20924i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgSettingItemView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view, (ViewGroup) this, true);
            this.f20920e = (TextView) findViewById(R.id.setting_text);
            this.f20921f = (TbImageView) findViewById(R.id.setting_tip_image);
            this.f20922g = (TextView) findViewById(R.id.setting_tip);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.setting_switch);
            this.f20923h = bdSwitchView;
            l.c(context, bdSwitchView, 10, 10, 10, 10);
            View findViewById = findViewById(R.id.space_view);
            this.f20924i = findViewById;
            findViewById.setVisibility(0);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20923h.d() : invokeV.booleanValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            tbPageContext.getLayoutMode().k(i2 == 1);
            tbPageContext.getLayoutMode().j(this);
            this.f20923h.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            int i3 = this.j;
            if (i3 != 0) {
                SkinManager.setImageResource(this.f20921f, i3);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20923h.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20923h.h();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f20923h.i();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f20923h.k();
        }
    }

    public BdSwitchView getSwitchView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20923h : (BdSwitchView) invokeV.objValue;
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f20923h.setOnSwitchStateChangeListener(bVar);
        }
    }

    public void setSpaceView(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (view = this.f20924i) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSwitchStateNoCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.f20923h.k();
            } else {
                this.f20923h.h();
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (StringUtils.isNULL(str)) {
                str = "";
            }
            this.f20920e.setText(str);
        }
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.f20921f.setOnClickListener(onClickListener);
        }
    }

    public void setTipImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.j = i2;
            SkinManager.setImageResource(this.f20921f, i2);
            this.f20921f.setVisibility(0);
        }
    }

    public void setTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (StringUtils.isNULL(str)) {
                str = "";
            }
            this.f20922g.setVisibility(0);
            this.f20922g.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgSettingItemView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f20920e.setText(i2);
    }

    public void setTipText(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f20922g.setVisibility(0);
        this.f20922g.setText(i2);
    }
}
