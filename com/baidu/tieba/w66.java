package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ImageView d;
    public MessageRedDotView e;

    public w66(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.b = inflate;
        this.c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.d = (ImageView) this.b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.img_red_tip);
        this.e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public ImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.e.e();
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void g(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (view2 = this.b) != null) {
            view2.setVisibility(i);
        }
    }

    public void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.e.f(i);
                this.e.setVisibility(0);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, controlAlign, z) == null) && !z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.d.getLayoutParams()).rightMargin = -yi.g(this.a, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = -yi.g(this.a, R.dimen.tbds10);
            this.c.getLayoutParams().width = yi.g(this.a, R.dimen.obfuscated_res_0x7f070306);
        }
    }
}
