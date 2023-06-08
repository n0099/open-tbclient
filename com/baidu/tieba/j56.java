package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class j56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener a;
    public BaseActivity b;
    public LinearLayout c;
    public LinearLayout d;
    public TbSettingTextTipView e;
    public TbSettingTextTipView f;
    public TextView g;

    public j56(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity;
        this.a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.removeAllViews();
            this.b = null;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0025, (ViewGroup) null);
            this.c = linearLayout;
            this.d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.e = (TbSettingTextTipView) this.c.findViewById(R.id.obfuscated_res_0x7f09035b);
            this.g = (TextView) this.c.findViewById(R.id.tv_title);
            this.f = (TbSettingTextTipView) this.c.findViewById(R.id.obfuscated_res_0x7f090068);
            this.e.a();
            this.f.a();
            this.e.setOnClickListener(this.a);
            this.f.setOnClickListener(this.a);
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, simpleUser) != null) || simpleUser == null) {
            return;
        }
        this.f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d05 layoutMode = this.b.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.b.getLayoutMode().k(this.c);
            o75 d = o75.d(this.g);
            d.w(R.color.CAM_X0109);
            d.f(R.color.CAM_X0204);
        }
    }
}
