package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.feed.widget.FeedBackReasonView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ob7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CompoundButton.OnCheckedChangeListener A;
    public final Runnable B;
    public View.OnClickListener C;
    public PopupWindow.OnDismissListener D;
    public CustomMessageListener E;
    public String a;
    public String b;
    public Context c;
    public PopupWindow d;
    public ViewGroup e;
    public SparseArray<String> f;
    public List<FeedBackReasonView.b> g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public PopupWindow p;
    public View q;
    public TextView r;
    public TBSpecificationBtn s;
    public hb5 t;
    public FeedBackReasonView u;
    public boolean v;
    public int w;
    public boolean x;
    public f y;
    public v87 z;

    /* loaded from: classes7.dex */
    public interface f {
        void a(List<FeedBackReasonView.b> list, boolean z);
    }

    /* loaded from: classes7.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public a(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                lu6.b().b(new bf5(this.a.z, compoundButton, z));
                if (compoundButton.getTag() instanceof FeedBackReasonView.b) {
                    FeedBackReasonView.b bVar = (FeedBackReasonView.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.g.contains(bVar)) {
                            this.a.g.add(bVar);
                        }
                    } else {
                        this.a.g.remove(bVar);
                    }
                }
                if (this.a.q != null && !ListUtils.isEmpty(this.a.g)) {
                    this.a.q.removeCallbacks(this.a.B);
                    this.a.q.postDelayed(this.a.B, 500L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public b(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o(false);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public c(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.o(true);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public d(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.q != null) {
                    this.a.q.removeCallbacks(this.a.B);
                }
                if (this.a.p != null) {
                    this.a.p.dismiss();
                    this.a.p = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ob7 ob7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.j();
            }
        }
    }

    public ob7(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.f = null;
        this.g = new ArrayList();
        this.w = 3;
        this.x = false;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this);
        this.E = new e(this, 2016524);
        this.c = view2.getContext();
        this.q = view2;
        n();
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            f fVar = this.y;
            if (fVar != null) {
                fVar.a(this.g, z);
            }
            j();
        }
    }

    public void r(v87 v87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, v87Var) == null) {
            this.z = v87Var;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.u.setFirstRowSingleColumn(z);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !xi.isEmpty(str)) {
            this.a = str;
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.y = fVar;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !xi.isEmpty(str)) {
            this.b = str;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.x = z;
        }
    }

    public final boolean h(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int j = yi.j(context);
            int l = yi.l(context);
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

    public final void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.w) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
            this.w = skinType;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PopupWindow popupWindow = this.d;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.d = null;
            }
            PopupWindow popupWindow2 = this.p;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.p = null;
            }
        }
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.e.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !this.v || this.g.size() == 0) {
            return;
        }
        this.g.clear();
        y();
    }

    public final View k() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.c;
            if (context == null) {
                return null;
            }
            if (this.e == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.e = viewGroup;
                this.r = (TextView) viewGroup.findViewById(R.id.head_text);
                if (!xi.isEmpty(this.a)) {
                    this.r.setText(this.a);
                }
                this.s = (TBSpecificationBtn) this.e.findViewById(R.id.uninterested_btn);
                hb5 hb5Var = new hb5();
                this.t = hb5Var;
                hb5Var.u(R.color.CAM_X0304);
                this.s.setConfig(this.t);
                this.s.setOnClickListener(this.C);
                this.s.setText(this.c.getResources().getString(R.string.not_interested));
                this.s.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.e;
                int i2 = this.n;
                if (this.x) {
                    i = 0;
                } else {
                    i = this.o;
                }
                viewGroup2.setPadding(i2, 0, i2, i);
            }
            i();
            y();
            FeedBackReasonView feedBackReasonView = this.u;
            if (feedBackReasonView != null && feedBackReasonView.getParent() == null) {
                this.e.addView(this.u);
            }
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int size = this.g.size();
            if (size > 0) {
                String string = this.c.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.r;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.s;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f04c1));
                    return;
                }
                return;
            }
            if (this.r != null) {
                if (!xi.isEmpty(this.a)) {
                    this.r.setText(this.a);
                } else {
                    this.r.setText(this.c.getResources().getString(R.string.tell_us_reason));
                }
            }
            if (this.s != null) {
                if (!xi.isEmpty(this.b)) {
                    this.s.setText(this.b);
                } else {
                    this.s.setText(this.c.getResources().getString(R.string.not_interested));
                }
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!ListUtils.isEmpty(this.g)) {
                StringBuilder sb = new StringBuilder();
                for (FeedBackReasonView.b bVar : this.g) {
                    if (bVar != null) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(bVar.b);
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = yi.g(this.c, R.dimen.M_W_X004);
            this.m = yi.g(this.c, R.dimen.tbds14);
            this.n = yi.g(this.c, R.dimen.M_W_X005);
            this.o = yi.g(this.c, R.dimen.M_H_X007);
            this.i = yi.l(this.c) - (this.l * 2);
            this.k = yi.g(this.c, R.dimen.tbds160);
            FeedBackReasonView feedBackReasonView = new FeedBackReasonView(this.c);
            this.u = feedBackReasonView;
            feedBackReasonView.setCanUnCheckedInSingleBox(false);
            this.u.setOnCheckedChangedListener(this.A);
            MessageManager.getInstance().registerListener(this.E);
        }
    }

    public void q(SparseArray<String> sparseArray, SparseArray<String> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sparseArray, sparseArray2) == null) {
            this.f = sparseArray;
            if (sparseArray != null && sparseArray.size() > 9) {
                for (int size = this.f.size() - 1; size >= 9; size--) {
                    this.f.removeAt(size);
                }
            }
            this.u.setData(this.f, sparseArray2);
        }
    }

    public void w(View view2) {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, view2) != null) || this.c == null) {
            return;
        }
        if (!this.x && ((sparseArray = this.f) == null || sparseArray.size() == 0)) {
            return;
        }
        View k = k();
        this.i = yi.l(this.c) - (this.l * 2);
        int m = m();
        this.h = m;
        int[] iArr = new int[2];
        boolean h = h(this.c, this.q, m, this.i, this.k, this.m, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0207));
        gradientDrawable.setCornerRadius(yi.g(this.c, R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.i, m());
        this.d = popupWindow;
        GreyUtil.grey(popupWindow);
        this.d.setFocusable(true);
        this.d.setTouchable(true);
        this.d.setOnDismissListener(this.D);
        p();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.c).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.p = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setAttachedInDecor(false);
        }
        this.p.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.d.setBackgroundDrawable(new ColorDrawable(0));
        if (h) {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f10040f);
        } else {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f100410);
        }
        this.d.showAtLocation(this.q, 0, iArr[0] - this.l, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        lu6.b().b(new ef5(this.z));
        this.v = true;
    }
}
