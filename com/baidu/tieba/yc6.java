package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class yc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public ad6 c;
    public boolean d;
    public boolean e;
    public BdUniqueId f;
    public View g;
    public View h;
    public TextView i;
    public TextView j;
    public BdTypeListView k;
    public PopupWindow l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public j95 q;
    public PbListView r;
    public NoNetworkView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public sc6 y;
    public om7 z;

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public a(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public b(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.z.b(view2, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public c(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.n(1);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public d(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.n(2);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public e(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView.p a;

        public f(yc6 yc6Var, BdListView.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BdListView.p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (pVar = this.a) != null) {
                pVar.onScrollToBottom();
            }
        }
    }

    public yc6(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), Boolean.valueOf(z2), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.a = tbPageContext;
        this.d = z;
        this.e = z2;
        this.f = bdUniqueId;
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            p(i);
            jg.d(this.l, this.a.getPageActivity());
            ad6 ad6Var = this.c;
            if (ad6Var != null) {
                ad6Var.a(i);
            }
        }
    }

    public void q(f96 f96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, f96Var) == null) {
            this.y.b(f96Var);
        }
    }

    public void r(ad6 ad6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ad6Var) == null) {
            this.c = ad6Var;
        }
    }

    public void s(i95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.q.a(gVar);
        }
    }

    public void u(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
            this.k.setOnSrollToBottomListener(pVar);
            this.r.G(new f(this, pVar));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.y();
        }
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y();
        }
    }

    public void w() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (pbListView = this.r) != null) {
            if (pbListView.c().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.S();
            this.r.U();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.m == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f9, (ViewGroup) null);
                this.m = inflate;
                this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c96);
                this.o = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090c97);
                this.p = this.m.findViewById(R.id.obfuscated_res_0x7f090c9f);
                this.n.setOnClickListener(new c(this));
                this.o.setOnClickListener(new d(this));
            }
            if (this.l == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.l = popupWindow;
                popupWindow.setContentView(this.m);
                GreyUtil.grey(this.l);
                this.l.setWidth(-2);
                this.l.setHeight(-2);
                this.l.setAnimationStyle(16973826);
                this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.l.setOutsideTouchable(true);
                this.l.setFocusable(true);
                this.l.setTouchable(true);
                this.l.setOnDismissListener(new e(this));
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f5, (ViewGroup) null);
            this.g = inflate;
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f090ca0);
            this.i = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090c98);
            this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090c9e);
            this.k = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f091534);
            this.s = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f092862);
            j95 j95Var = new j95(this.a);
            this.q = j95Var;
            j95Var.V(this.f);
            this.k.setPullRefresh(this.q);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.r = pbListView;
            pbListView.a();
            this.y = new sc6(this.a, this.k, this.d);
            this.j.setOnClickListener(new a(this));
            if (this.e) {
                this.z = new om7(this.a.getPageActivity(), this.f, this.e);
                this.k.setOnTouchListener(new b(this));
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            i();
            SkinManager.setBackgroundResource(this.m, R.drawable.bg_ala_frs_game_live_sort_panel);
            SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.o, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0106);
            int[] iArr = new int[2];
            this.j.getLocationOnScreen(iArr);
            int height = ((View) this.j.getParent()).getHeight() - this.j.getHeight();
            if (iArr[1] - this.l.getHeight() <= 50) {
                jg.d(this.l, this.a.getPageActivity());
                return;
            }
            jg.m(this.l, this.g, 0, (iArr[0] - (this.j.getWidth() / 2)) - this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.j.getHeight() + height);
            this.l.update();
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (this.b != i) {
                this.b = i;
            }
            k();
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.i != null) {
            this.i.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0811, StringHelper.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
        }
    }

    public void p(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 1) {
                TextView textView2 = this.j;
                if (textView2 != null) {
                    textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0815));
                }
            } else if (i == 2 && (textView = this.j) != null) {
                textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0816));
            }
        }
    }

    public void t(List<ym> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && list != null && !ListUtils.isEmpty(list)) {
            if (z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            this.y.c(list);
            if (z2) {
                v();
            } else {
                x();
            }
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (pbListView = this.r) != null) {
            if (pbListView.c().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.H(this.a.getResources().getString(R.string.load_more));
            this.r.g();
        }
    }

    public void x() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbListView = this.r) != null) {
            if (pbListView.c().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.H(this.a.getResources().getString(R.string.list_no_more));
            this.r.g();
        }
    }
}
