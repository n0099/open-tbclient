package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vi7 extends si7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView i;
    public an6 j;
    public ImageView k;
    public MessageRedDotView l;
    public ImageView m;
    public TextView n;
    public ImageView o;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345362424, "Lcom/baidu/tieba/vi7$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-345362424, "Lcom/baidu/tieba/vi7$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.SEARCH_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.MESSAGE_ICON_CONTROLLER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.MESSAGE_BTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.MESSAGE_RED_DOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.SHARE_BTN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.FOLD_TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LogicField.GROUP_BTN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public vi7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.si7
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setContentPaddingTop(ri.g(this.c.getContext(), R.dimen.tbds24));
            m();
            o();
            n();
            p();
            l();
        }
    }

    @Override // com.baidu.tieba.si7, com.baidu.tieba.ui7
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            switch (a.a[logicField.ordinal()]) {
                case 1:
                    return (T) this.i;
                case 2:
                    return (T) this.j;
                case 3:
                    return (T) this.k;
                case 4:
                    return (T) this.l;
                case 5:
                    return (T) this.m;
                case 6:
                    return (T) this.n;
                case 7:
                    return (T) this.o;
                default:
                    return (T) super.a(logicField);
            }
        }
        return (T) invokeL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n = this.e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            this.n.setLayoutParams(layoutParams);
            this.n.setPadding(0, 0, this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), 0);
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = new ImageView(this.e.getContext());
            int g = ri.g(this.e.getContext(), R.dimen.tbds102);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(g, g);
            marginLayoutParams.rightMargin = ri.g(this.e.getContext(), R.dimen.tbds24);
            this.o.setLayoutParams(marginLayoutParams);
            this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.o, this.d);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.ic_icon_pure_topbar_group40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            an6 an6Var = new an6(this.b);
            this.j = an6Var;
            this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, an6Var.c(), (View.OnClickListener) null);
            this.k = this.j.b();
            MessageRedDotView a2 = this.j.a();
            this.l = a2;
            a2.setShadowEnabled(false);
            this.j.c().setOnClickListener(this.d);
            this.j.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i = (ImageView) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d038e, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.i.setOnClickListener(this.d);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m = (ImageView) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d038f, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.m.setOnClickListener(this.d);
        }
    }
}
