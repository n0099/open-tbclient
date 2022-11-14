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
public class uv4 {
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
    public List<? extends tv4> l;
    public e m;
    public c n;
    public boolean o;

    /* loaded from: classes6.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void n0(uv4 uv4Var, int i, View view2);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv4 a;

        public a(uv4 uv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv4Var;
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
        public final /* synthetic */ uv4 a;

        public b(uv4 uv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onClick();
            }
        }
    }

    public uv4(Context context) {
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
        this.o = false;
        if (context == null) {
            return;
        }
        this.a = context;
        g();
    }

    public void j(List<? extends tv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || list == null) {
            return;
        }
        this.l = list;
        this.c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            tv4 tv4Var = list.get(i);
            if (tv4Var != null) {
                this.c.addView(tv4Var.getView());
            }
        }
    }

    public void l(int i) {
        MaxHeightScrollView maxHeightScrollView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (maxHeightScrollView = this.i) != null) {
            maxHeightScrollView.setMaxHeight(i);
            this.i.setVerticalScrollBarEnabled(true);
        }
    }

    public void m(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.n = cVar;
            if (cVar != null && (textView = this.g) != null) {
                textView.setOnClickListener(new a(this));
            }
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void o(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, spannableStringBuilder) == null) {
            this.k = spannableStringBuilder;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
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
    public final void b(List<? extends tv4> list) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        h();
        this.l = list;
        this.c.removeAllViews();
        this.d.removeAllViews();
        boolean z3 = true;
        if (list.size() < 2) {
            z = false;
        } else {
            if (((qv4) list.get(0)).f() != -1) {
                z = false;
            } else {
                z = true;
            }
            if (((qv4) list.get(1)).f() == -2) {
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
                    qv4 qv4Var = (qv4) list.get(i3);
                    qv4Var.k(z3);
                    qv4Var.e();
                    if (qv4Var != null) {
                        if (i3 < i2) {
                            this.c.addView(qv4Var.getView());
                        } else {
                            this.d.addView(qv4Var.getView());
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
            p();
            if (this.n != null) {
                this.g.setOnClickListener(new b(this));
            }
            i();
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return (e) invokeV.objValue;
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

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075b, (ViewGroup) null);
            this.b = roundLinearLayout;
            pw4 d2 = pw4.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.c = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09070d);
            this.e = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f092263);
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f092274);
            this.f = findViewById;
            findViewById.setVisibility(8);
            this.h = this.b.findViewById(R.id.obfuscated_res_0x7f0907db);
            this.l = new ArrayList();
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0907cc);
            this.i = (MaxHeightScrollView) this.b.findViewById(R.id.obfuscated_res_0x7f091508);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075c, (ViewGroup) null);
            this.b = roundLinearLayout;
            pw4 d2 = pw4.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.c = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09070d);
            this.d = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09070e);
            this.e = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f092263);
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f092274);
            this.f = findViewById;
            findViewById.setVisibility(8);
            this.h = this.b.findViewById(R.id.obfuscated_res_0x7f0907db);
            this.l = new ArrayList();
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0907cc);
            int l = (yi.l(this.a) - (qv4.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = l;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = l;
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).leftMargin = l;
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).rightMargin = l;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.o) {
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            List<? extends tv4> list = this.l;
            if (list != null) {
                for (tv4 tv4Var : list) {
                    tv4Var.a();
                }
            }
        }
    }

    public void k(List<? extends tv4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                j(list);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
