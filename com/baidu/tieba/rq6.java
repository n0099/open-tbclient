package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ImageView d;
    public MessageRedDotView e;
    @Nullable
    public MessageRedDotView f;
    public boolean g;
    public ea5 h;
    public int i;

    public rq6(Context context) {
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
        this.g = false;
        this.i = 0;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.b = inflate;
        this.c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.d = (ImageView) this.b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.img_red_tip);
        this.e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
        this.h = (ea5) ServiceManager.getService(ea5.a);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public MessageRedDotView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public ImageView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f == null) {
                this.h.e();
            }
            MessageRedDotView messageRedDotView = this.f;
            if (messageRedDotView != null) {
                messageRedDotView.setVisibility(8);
                TbSingleton.MsgUpgradeTips.markHasShown();
                this.f = null;
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            if (this.g && this.e != null && !this.h.d()) {
                this.e.setVisibility(0);
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e.onChangeSkinType();
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void i(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (view2 = this.b) != null) {
            view2.setVisibility(i);
        }
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f) == null) && (messageRedDotView = this.f) != null) {
            messageRedDotView.setAlpha(f);
        }
    }

    public void k(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, navigationBar) == null) {
            l(navigationBar, false);
        }
    }

    public void g(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.e.refresh(i);
                this.g = true;
                if (this.h.d() && i <= 0) {
                    this.e.setVisibility(8);
                } else if (this.f == null) {
                    this.e.setVisibility(0);
                }
            } else {
                this.e.setVisibility(8);
                this.g = false;
            }
            this.i = i;
        }
    }

    public void h(NavigationBar.ControlAlign controlAlign, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, controlAlign, z) == null) && !z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.d.getLayoutParams()).rightMargin = -BdUtilHelper.getDimens(this.a, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = -BdUtilHelper.getDimens(this.a, R.dimen.tbds10);
            this.c.getLayoutParams().width = BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070421);
        }
    }

    public void l(@NonNull NavigationBar navigationBar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048587, this, navigationBar, z) != null) || !TbSingleton.MsgUpgradeTips.shouldShow()) {
            return;
        }
        MessageRedDotView messageRedDotView = this.e;
        if (messageRedDotView != null) {
            messageRedDotView.setVisibility(8);
        }
        Context context = navigationBar.getContext();
        MessageRedDotView messageRedDotView2 = new MessageRedDotView(context);
        this.f = messageRedDotView2;
        messageRedDotView2.refresh(context.getString(R.string.message_notify_upgrade), false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds90);
        if (z) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(this.f, new FrameLayout.LayoutParams(-2, -2));
            frameLayout.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds72));
            layoutParams.addRule(12);
            navigationBar.addView(frameLayout, layoutParams);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds20);
            navigationBar.addView(this.f, layoutParams);
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }
}
