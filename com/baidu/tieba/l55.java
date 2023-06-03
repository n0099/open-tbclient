package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.MaxHeightScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public RoundLinearLayout b;
    public LinearLayout c;
    public LinearLayout d;
    public EMTextView e;
    public View f;
    public TextView g;
    public View h;
    public MaxHeightScrollView i;
    public String j;
    public SpannableStringBuilder k;
    public List<? extends k55> l;
    public f m;
    public c n;
    public d o;
    public boolean p;
    public boolean q;

    /* loaded from: classes6.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface f {
        void M0(l55 l55Var, int i, View view2);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l55 a;

        public a(l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l55 a;

        public b(l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onClick();
            }
        }
    }

    public l55(Context context) {
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
        this.p = false;
        this.q = true;
        if (context == null) {
            return;
        }
        this.a = context;
        h();
    }

    public void l(List<? extends k55> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, list) != null) || list == null) {
            return;
        }
        this.l = list;
        this.c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            k55 k55Var = list.get(i);
            if (k55Var != null) {
                this.c.addView(k55Var.getView());
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.q = z;
        }
    }

    public void n(int i) {
        MaxHeightScrollView maxHeightScrollView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (maxHeightScrollView = this.i) != null) {
            maxHeightScrollView.setMaxHeight(i);
            this.i.setVerticalScrollBarEnabled(true);
        }
    }

    public void o(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.n = cVar;
            if (cVar != null && (textView = this.g) != null) {
                textView.setOnClickListener(new a(this));
            }
        }
    }

    public void p(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void r(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, spannableStringBuilder) == null) {
            this.k = spannableStringBuilder;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.j = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(List<? extends k55> list) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        i();
        this.l = list;
        this.c.removeAllViews();
        this.d.removeAllViews();
        boolean z3 = true;
        if (list.size() < 2) {
            z = false;
        } else {
            if (((h55) list.get(0)).f() != -1) {
                z = false;
            } else {
                z = true;
            }
            if (((h55) list.get(1)).f() == -2) {
                z2 = true;
                View view2 = this.f;
                if (!z) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
                if (z) {
                    i2 = 0;
                } else if (z2) {
                    i2 = 4;
                } else {
                    i2 = 3;
                }
                if (list.size() - i2 <= 4) {
                    z3 = false;
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    h55 h55Var = (h55) list.get(i3);
                    h55Var.k(z3);
                    h55Var.e();
                    if (h55Var != null) {
                        if (i3 < i2) {
                            this.c.addView(h55Var.getView());
                        } else {
                            this.d.addView(h55Var.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        View view22 = this.f;
        if (!z) {
        }
        view22.setVisibility(i);
        if (z) {
        }
        if (list.size() - i2 <= 4) {
        }
        while (i3 < list.size()) {
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            s();
            if (this.n != null) {
                this.g.setOnClickListener(new b(this));
            }
            j();
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return (f) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public List<? extends k55> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.b = roundLinearLayout;
            m75 d2 = m75.d(roundLinearLayout);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.c = (LinearLayout) this.b.findViewById(R.id.content_view);
            this.e = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0924a3);
            View findViewById = this.b.findViewById(R.id.title_divide_line);
            this.f = findViewById;
            findViewById.setVisibility(8);
            this.h = this.b.findViewById(R.id.dialog_header);
            this.l = new ArrayList();
            this.g = (TextView) this.b.findViewById(R.id.dialog_bottom_cancel_button);
            this.i = (MaxHeightScrollView) this.b.findViewById(R.id.max_height_scroll_view);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d dVar = this.o;
            if (dVar != null) {
                dVar.a();
            }
            if (this.p) {
                EMTextView eMTextView = this.e;
                if (eMTextView != null) {
                    eMTextView.setText(this.k);
                }
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            }
            if (this.q) {
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0206);
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            m75 d2 = m75.d(this.b);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            List<? extends k55> list = this.l;
            if (list != null) {
                for (k55 k55Var : list) {
                    k55Var.a();
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
            this.b = roundLinearLayout;
            m75 d2 = m75.d(roundLinearLayout);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.c = (LinearLayout) this.b.findViewById(R.id.content_view);
            this.d = (LinearLayout) this.b.findViewById(R.id.content_view_second);
            this.e = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0924a3);
            View findViewById = this.b.findViewById(R.id.title_divide_line);
            this.f = findViewById;
            findViewById.setVisibility(8);
            this.h = this.b.findViewById(R.id.dialog_header);
            this.l = new ArrayList();
            this.g = (TextView) this.b.findViewById(R.id.dialog_bottom_cancel_button);
            int l = (vi.l(this.a) - (h55.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = l;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = l;
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).leftMargin = l;
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).rightMargin = l;
        }
    }

    public void m(List<? extends k55> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                l(list);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!StringUtils.isNull(this.j)) {
                this.e.setVisibility(0);
                this.e.setText(this.j);
            } else if (this.k != null) {
                this.e.setVisibility(0);
                this.e.setText(this.k);
            }
        }
    }
}
