package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tp7;
import com.baidu.tieba.up7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class rp7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String Q = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String R = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public int D;
    public long E;
    public String F;
    public String G;
    public int H;
    public Boolean I;
    public int J;
    public String K;
    public String L;
    public String M;
    public int N;
    public AdapterView.d O;
    public View.OnClickListener P;
    public TbPageContext a;
    public View b;
    public RelativeLayout c;
    public HListView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public GridView i;
    public LinearLayout j;
    public TextView k;
    public NoNetworkView l;
    public TextView m;
    public LinearLayout n;
    public sp7 o;
    public tp7 p;
    public up7 q;
    public up7.h r;
    public up7.c s;
    public up7.d t;
    public up7.a u;
    public up7.b v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948129392, "Lcom/baidu/tieba/rp7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948129392, "Lcom/baidu/tieba/rp7;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements tp7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp7 a;

        public a(rp7 rp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp7Var;
        }

        @Override // com.baidu.tieba.tp7.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vp7.d(this.a.J, this.a.K, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp7 a;

        public b(rp7 rp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp7Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            up7.e item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.o.getItem(i)) == null) {
                return;
            }
            item.i = true;
            this.a.o.i(item);
            this.a.x(item.j);
            this.a.A(item.f);
            vp7.c(this.a.J, this.a.K, item.a);
            this.a.v(item);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp7 a;

        public c(rp7 rp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 0;
                if (view2 == this.a.k) {
                    this.a.o();
                    int i2 = 2;
                    if (this.a.D != 1) {
                        int unused = this.a.D;
                        i2 = 1;
                    }
                    up7.e c = this.a.o.c();
                    if (c != null && c.j != 1) {
                        long j = c.h;
                        if (j == 1) {
                            i = 1;
                        } else if (j == 3) {
                            i = 3;
                        } else if (j == 6) {
                            i = 6;
                        } else if (j == 12) {
                            i = 12;
                        }
                    }
                    if (c != null) {
                        vp7.b(this.a.J, this.a.K, c.f / 100);
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i2).param("obj_locate", i));
                } else if (view2 == this.a.e) {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{rp7.R});
                } else if (view2 == this.a.g) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, true);
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{rp7.Q}, false, bundle);
                }
            }
        }
    }

    public rp7(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2, int i3, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = 2;
        this.I = Boolean.FALSE;
        this.N = 0;
        this.O = new b(this);
        this.P = new c(this);
        this.b = view2;
        this.a = tbPageContext;
        this.D = i;
        this.I = Boolean.valueOf(z);
        this.F = str;
        this.G = str2;
        this.H = i2;
        this.J = i3;
        this.K = str3;
        this.L = str4;
        q();
    }

    public void u(up7 up7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, up7Var) == null) {
            if (up7Var == null) {
                this.c.setVisibility(8);
                return;
            }
            this.q = up7Var;
            p();
            t();
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 1) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public final void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.k.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f13ec, "" + (j / 100)));
        }
    }

    public final void B() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.D;
            if (2 == i) {
                if (this.E == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0456, new Object[]{this.z});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0534, new Object[]{this.z});
                }
                this.C = this.z;
            } else if (1 == i) {
                long j = this.E;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0456, new Object[]{this.A});
                } else if (j == 0) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0534, new Object[]{this.A});
                } else {
                    string = null;
                }
                this.C = this.A;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0534, new Object[]{this.A});
                this.C = this.A;
            }
            this.B = string;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            up7.e c2 = this.o.c();
            if (c2 == null) {
                yi.O(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13ee);
            } else if (c2.j == 1 && BdBaseApplication.getInst().isDebugMode() && oe5.a) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{"tieba.baidu.com/mo/q/tbeanrights?from=autopay"}, true);
            } else if (c2.j == 1 && c2.k) {
                yi.O(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1474);
            } else {
                w(c2.e, c2.f / 100, c2.h, c2.j);
                if (this.H == 26) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
                }
            }
        }
    }

    public final void t() {
        up7.h hVar;
        up7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.q == null) {
                this.c.setVisibility(8);
            } else if (this.s != null && (hVar = this.r) != null) {
                if (hVar.a == null) {
                    this.c.setVisibility(8);
                } else if (this.u == null && this.t == null) {
                    this.c.setVisibility(8);
                } else if (this.D == 2 && ((aVar = this.u) == null || ListUtils.isEmpty(aVar.a))) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    y();
                    z();
                    B();
                }
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public final void y() {
        up7.d dVar;
        List<up7.e> list;
        up7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (2 != this.D ? (dVar = this.t) == null || (list = dVar.a) == null : (aVar = this.u) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (up7.e eVar : list) {
                if (eVar.i) {
                    x(eVar.j);
                    A(eVar.f);
                    this.M = eVar.a;
                }
            }
            if (this.o == null) {
                sp7 sp7Var = new sp7(this.a);
                this.o = sp7Var;
                sp7Var.f(list);
                this.d.setAdapter((ListAdapter) this.o);
            }
            this.o.f(list);
            this.o.notifyDataSetChanged();
        }
    }

    public final void p() {
        up7 up7Var;
        up7.f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (up7Var = this.q) == null) {
            return;
        }
        up7.c cVar = up7Var.b;
        this.s = cVar;
        up7.h hVar = up7Var.a;
        this.r = hVar;
        this.v = up7Var.c;
        if (cVar == null || hVar == null || (fVar = hVar.a) == null) {
            return;
        }
        this.E = fVar.a;
        up7.a aVar = cVar.b;
        this.u = aVar;
        if (aVar != null) {
            this.z = aVar.c;
        }
        up7.d dVar = this.s.a;
        this.t = dVar;
        if (dVar != null) {
            this.A = dVar.c;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.p == null) {
            ArrayList<up7.i> arrayList = this.v.a;
            tp7 tp7Var = new tp7(this.a.getPageActivity());
            this.p = tp7Var;
            tp7Var.g(new a(this));
            this.p.f(arrayList);
            this.i.setAdapter((ListAdapter) this.p);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091cbd);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f091ac1);
            this.j = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c21);
            this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c22);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091af0);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091ae8);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091ce7);
            this.i = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f091ade);
            this.l = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f092615);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09152e);
            this.n = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09152f);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092413);
            this.w = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0909de);
            this.x = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e6f);
            this.y = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0921c6);
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f08127e);
            this.d.setOnItemClickListener(this.O);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08127e));
            this.i.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.i.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds80));
            this.k.setOnClickListener(this.P);
            this.e.setOnClickListener(this.P);
            this.g.setOnClickListener(this.P);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.l.d(this.a, i);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_tbvip_arrow_right, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080ae1);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0311);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.dimen.tbds31).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.obfuscated_res_0x7f0607d6, R.color.CAM_X0335).into(this.n);
            pw4 d = pw4.d(this.w);
            d.n(R.string.J_X06);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0203);
            d.f(R.color.CAM_X0205);
            pw4 d2 = pw4.d(this.x);
            d2.n(R.string.J_X06);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0203);
            d2.f(R.color.CAM_X0205);
            if (StringHelper.equals(this.L, "1")) {
                this.x.setVisibility(8);
            }
            pw4.d(this.y).f(R.color.CAM_X0201);
        }
    }

    public void s(boolean z) {
        up7.d dVar;
        List<up7.e> list;
        up7.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.q == null) {
            return;
        }
        List<up7.e> list2 = null;
        if (2 != this.D ? !((dVar = this.t) == null || (list = dVar.a) == null) : !((aVar = this.u) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            up7.e eVar = list2.get(i);
            if (eVar != null && eVar.f >= 0 && eVar.j == 1) {
                eVar.k = z;
                return;
            }
        }
    }

    public final void v(up7.e eVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) && (i = this.J) >= 100200 && i <= 100299 && this.N < 1 && StringUtils.isNotNull(this.M) && !this.M.equals(eVar.a)) {
            BdToast b2 = BdToast.b(this.a.getPageActivity(), this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f13ef));
            b2.f(BdToast.ToastIcon.FAILURE);
            b2.i();
            this.N++;
        }
    }

    public final void w(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.I.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.F, this.G);
            payConfig.setTitle(this.B);
            payConfig.setOrderName(this.C + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0aec, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.H == 23) {
                payConfig.paymentPosKey = "37";
            }
            me5.c().a(payConfig, this.a.getPageActivity());
        }
    }
}
