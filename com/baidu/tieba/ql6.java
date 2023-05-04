package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ql6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ja5 b;
    public ThreadData c;
    public PopupWindow d;
    public PopupWindow e;
    public ViewGroup f;
    public TextView g;
    public TBSpecificationBtn h;
    public e65 i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public View q;
    public int r;
    public PopupWindow.OnDismissListener s;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
    public class a implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql6 a;

        public a(ql6 ql6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql6Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.e.dismiss();
                this.a.e = null;
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql6 a;

        public b(ql6 ql6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.a.showToast(R.string.network_ungeilivable);
                }
                if (ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                    if (this.a.c == null) {
                        return;
                    }
                    this.a.b.i(false, this.a.c.getAuthor().getPortrait(), this.a.c.getAuthor().getUserId(), this.a.c.getAuthor().isGod(), "0", this.a.a.getUniqueId(), null, "0");
                    TiebaStatic.log(new StatisticItem("c13571"));
                }
                if (this.a.e != null && this.a.d != null) {
                    this.a.e.dismiss();
                    this.a.d.dismiss();
                    this.a.d = null;
                    this.a.e = null;
                }
            }
        }
    }

    public ql6(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 3;
        this.s = new a(this);
        this.t = new b(this);
        this.a = tbPageContext;
        this.b = new ja5(tbPageContext);
        this.q = view2;
        m();
    }

    public void h(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            this.c = threadData;
        }
    }

    public final boolean i(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int j = ii.j(context);
            int l = ii.l(context);
            if (((j - iArr2[1]) - height) - i3 < i) {
                z = true;
            } else {
                z = false;
            }
            iArr[0] = l - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.r) {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            this.r = skinType;
        }
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.f;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f.getMeasuredHeight();
            this.o = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.getContext() == null) {
                return null;
            }
            if (this.f == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.g = textView;
                textView.setText(this.a.getString(R.string.confirm_unlike));
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f.findViewById(R.id.uninterested_btn);
                this.h = tBSpecificationBtn;
                tBSpecificationBtn.setText(this.a.getString(R.string.confirm_unlike_confirm));
                this.h.setTextSize(R.dimen.T_X08);
                this.h.setOnClickListener(this.t);
                e65 e65Var = new e65();
                this.i = e65Var;
                e65Var.t(R.color.CAM_X0304);
                this.h.setConfig(this.i);
                ViewGroup viewGroup2 = this.f;
                int i = this.j;
                viewGroup2.setPadding(i, 0, i, 0);
            }
            j();
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = ii.g(this.a.getContext(), R.dimen.M_W_X005);
            this.k = ii.g(this.a.getContext(), R.dimen.M_W_X004);
            this.l = ii.g(this.a.getContext(), R.dimen.tbds14);
            this.p = ii.g(this.a.getContext(), R.dimen.tbds160);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.a.getContext() == null) {
            return;
        }
        View k = k();
        this.n = ii.l(this.a.getContext()) - (this.k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i = i(this.a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(ii.g(this.a.getContext(), R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.n, l());
        this.d = popupWindow;
        GreyUtil.grey(popupWindow);
        this.d.setFocusable(true);
        this.d.setTouchable(true);
        this.d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.e = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.e.setAttachedInDecor(false);
        }
        this.e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.d.setBackgroundDrawable(new ColorDrawable(0));
        if (i) {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f1003fa);
        } else {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f1003fb);
        }
        this.d.showAtLocation(this.q, 0, iArr[0] - this.k, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }
}
