package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p05 {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertConfig.OperateBtnConfig a;
        public final /* synthetic */ View.OnClickListener b;

        public a(p05 p05Var, TBAlertConfig.OperateBtnConfig operateBtnConfig, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p05Var, operateBtnConfig, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = operateBtnConfig;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View.OnClickListener onClickListener = this.a.listener;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
                View.OnClickListener onClickListener2 = this.b;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-569837578, "Lcom/baidu/tieba/p05$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-569837578, "Lcom/baidu/tieba/p05$b;");
                    return;
                }
            }
            int[] iArr = new int[TBAlertConfig.OperateBtnStyle.values().length];
            b = iArr;
            try {
                iArr[TBAlertConfig.OperateBtnStyle.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.MAIN_BG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.ALERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.FORCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.SECONDARY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.BG_GRADIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.CUSTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008244, "Lcom/baidu/tieba/p05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008244, "Lcom/baidu/tieba/p05;");
                return;
            }
        }
        j = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public p05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final TextView a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            TextView textView = new TextView(context);
            this.g = textView;
            EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0301).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0301).setCorner(R.string.J_X07).setBackGroundSelectorColor(17170445);
            this.g.setMaxLines(1);
            this.g.setSingleLine();
            this.g.setGravity(17);
            return this.g;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            TextView textView = new TextView(context);
            this.f = textView;
            EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setCorner(R.string.J_X07).setBackGroundSelectorColor(R.color.CAM_X0303);
            this.f.setMaxLines(1);
            this.f.setSingleLine();
            this.f.setGravity(17);
            return this.f;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView n(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            TextView textView = new TextView(context);
            this.h = textView;
            EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0105).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0902).setCorner(R.string.J_X07).setBackGroundSelectorColor(17170445);
            this.h.setMaxLines(1);
            this.h.setSingleLine();
            this.h.setGravity(17);
            return this.h;
        }
        return (TextView) invokeL.objValue;
    }

    public TextView o(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.a = eMTextView;
            EMManager.from(eMTextView).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            this.a.setMaxLines(1);
            this.a.setSingleLine();
            this.a.setGravity(17);
            return this.a;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView b(@NonNull Context context, @NonNull TBAlertConfig.OperateBtnConfig operateBtnConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, operateBtnConfig)) == null) {
            this.i = new TextView(context);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.string.J_X07).gradientLinear(operateBtnConfig.mBgGradientDirection, operateBtnConfig.mBgGradientColor).into(this.i);
            this.i.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.i.setMaxLines(1);
            this.i.setSingleLine();
            this.i.setGravity(17);
            return this.i;
        }
        return (TextView) invokeLL.objValue;
    }

    public final void m(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048588, this, textView, z) != null) || textView == null) {
            return;
        }
        EMManager corner = EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0304).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304).setBorderAlpha(R.string.A_X07).setCorner(R.string.J_X07);
        if (z) {
            corner.setBackGroundSelectorColor(R.color.CAM_X0905, 17170445);
        } else {
            corner.setBackGroundSelectorColor(17170445);
        }
    }

    public TextView c(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, activity, z)) == null) {
            if (z) {
                return d(activity);
            }
            return e(activity);
        }
        return (TextView) invokeLZ.objValue;
    }

    public TextView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.b = eMTextView;
            EMManager.from(eMTextView).setTextSize(R.dimen.T_X07).setTextLinePadding(R.dimen.M_T_X002).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            return this.b;
        }
        return (TextView) invokeL.objValue;
    }

    public TextView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.c = eMTextView;
            EMManager.from(eMTextView).setTextSize(R.dimen.T_X07).setTextLinePadding(R.dimen.M_T_X002).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            return this.c;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            TextView textView = new TextView(context);
            this.d = textView;
            m(textView, false);
            this.d.setMaxLines(1);
            this.d.setSingleLine();
            this.d.setGravity(17);
            return this.d;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView g(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            TextView textView = new TextView(context);
            this.e = textView;
            m(textView, true);
            this.e.setMaxLines(1);
            this.e.setSingleLine();
            this.e.setGravity(17);
            return this.e;
        }
        return (TextView) invokeL.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TextView textView = this.g;
            if (textView != null) {
                EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0301).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0301).setCorner(R.string.J_X07).setBackGroundSelectorColor(17170445);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                EMManager.from(textView2).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0105).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0902).setCorner(R.string.J_X07).setBackGroundSelectorColor(17170445);
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                EMManager.from(textView3).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setCorner(R.string.J_X07).setBackGroundSelectorColor(R.color.CAM_X0303);
            }
            TextView textView4 = this.d;
            if (textView4 != null) {
                m(textView4, false);
            }
            TextView textView5 = this.e;
            if (textView5 != null) {
                m(textView5, true);
            }
            TextView textView6 = this.a;
            if (textView6 != null) {
                EMManager.from(textView6).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            }
            TextView textView7 = this.b;
            if (textView7 != null) {
                EMManager.from(textView7).setTextSize(R.dimen.T_X07).setTextLinePadding(R.dimen.M_T_X002).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            }
            TextView textView8 = this.c;
            if (textView8 != null) {
                EMManager.from(textView8).setTextSize(R.dimen.T_X07).setTextLinePadding(R.dimen.M_T_X002).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            }
        }
    }

    public final View j(@NonNull Context context, @NonNull TBAlertConfig.OperateBtnConfig operateBtnConfig, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, operateBtnConfig, onClickListener)) == null) {
            return k(context, operateBtnConfig, onClickListener, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final View k(@NonNull Context context, @NonNull TBAlertConfig.OperateBtnConfig operateBtnConfig, @Nullable View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{context, operateBtnConfig, onClickListener, Boolean.valueOf(z)})) == null) {
            switch (b.b[operateBtnConfig.style.ordinal()]) {
                case 1:
                    h = h(context);
                    break;
                case 2:
                    h = g(context);
                    break;
                case 3:
                    h = a(context);
                    break;
                case 4:
                    h = f(context);
                    break;
                case 5:
                    h = n(context);
                    break;
                case 6:
                    h = b(context, operateBtnConfig);
                    break;
                case 7:
                    h = operateBtnConfig.getCustomView();
                    break;
                default:
                    h = null;
                    break;
            }
            h.setText(operateBtnConfig.btnText);
            int i = operateBtnConfig.btnTextColor;
            if (i != 0) {
                h.setTextColor(i);
            }
            if (z) {
                EMManager.from(h).setTextSize(R.dimen.T_X08);
            }
            h.setOnClickListener(new a(this, operateBtnConfig, onClickListener));
            return h;
        }
        return (View) invokeCommon.objValue;
    }

    public View l(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, aVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, BdUtilHelper.getDimens(context, R.dimen.M_H_X008), 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i = b.a[aVar.a.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        linearLayout.setOrientation(1);
                        View j2 = j(context, aVar.b, onClickListener);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, j);
                        layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X012), BdUtilHelper.getDimens(context, R.dimen.M_H_X005));
                        linearLayout.addView(j2, layoutParams);
                        View j3 = j(context, aVar.c, onClickListener);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, j);
                        layoutParams2.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X012), BdUtilHelper.getDimens(context, R.dimen.M_H_X005));
                        linearLayout.addView(j3, layoutParams2);
                        View j4 = j(context, aVar.d, onClickListener);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, j);
                        layoutParams3.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0);
                        linearLayout.addView(j4, layoutParams3);
                    }
                } else {
                    linearLayout.setOrientation(0);
                    if (aVar.b.btnText.length() <= 6 && aVar.c.btnText.length() <= 6) {
                        z = false;
                    }
                    View k = k(context, aVar.b, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, j);
                    layoutParams4.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X006) / 2, 0);
                    layoutParams4.weight = 1.0f;
                    linearLayout.addView(k, layoutParams4);
                    View k2 = k(context, aVar.c, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, j);
                    layoutParams5.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X006) / 2, 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X012), 0);
                    layoutParams5.weight = 1.0f;
                    linearLayout.addView(k2, layoutParams5);
                }
            } else {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View j5 = j(context, aVar.b, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, j);
                layoutParams6.weight = 494.0f;
                linearLayout.addView(j5, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
