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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
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
import com.baidu.tieba.nn7;
import com.baidu.tieba.on7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ln7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String O = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String P = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
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
    public AdapterView.d M;
    public View.OnClickListener N;
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
    public mn7 o;
    public nn7 p;
    public on7 q;
    public on7.h r;
    public on7.c s;
    public on7.d t;
    public on7.a u;
    public on7.b v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    /* loaded from: classes4.dex */
    public class a implements nn7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln7 a;

        public a(ln7 ln7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln7Var;
        }

        @Override // com.baidu.tieba.nn7.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pn7.d(this.a.J, this.a.K, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln7 a;

        public b(ln7 ln7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln7Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            on7.e item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.o.getItem(i)) == null) {
                return;
            }
            item.i = true;
            this.a.o.i(item);
            this.a.v(item.j);
            this.a.y(item.f);
            pn7.c(this.a.J, this.a.K, item.a);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln7 a;

        public c(ln7 ln7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 0;
                if (view2 == this.a.k) {
                    this.a.n();
                    int i2 = 2;
                    if (this.a.D != 1) {
                        int unused = this.a.D;
                        i2 = 1;
                    }
                    on7.e c = this.a.o.c();
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
                        pn7.b(this.a.J, this.a.K, c.f / 100);
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i2).param("obj_locate", i));
                } else if (view2 != this.a.e) {
                    if (view2 == this.a.g) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, true);
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{ln7.O}, false, bundle);
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{ln7.P});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947948724, "Lcom/baidu/tieba/ln7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947948724, "Lcom/baidu/tieba/ln7;");
        }
    }

    public ln7(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2, int i3, String str3, String str4) {
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
        this.M = new b(this);
        this.N = new c(this);
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
        p();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            on7.e c2 = this.o.c();
            if (c2 == null) {
                ej.M(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13b6);
            } else if (c2.j == 1 && c2.k) {
                ej.M(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1436);
            } else {
                u(c2.e, c2.f / 100, c2.h, c2.j);
                if (this.H == 26) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
                }
            }
        }
    }

    public final void o() {
        on7 on7Var;
        on7.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (on7Var = this.q) == null) {
            return;
        }
        on7.c cVar = on7Var.b;
        this.s = cVar;
        on7.h hVar = on7Var.a;
        this.r = hVar;
        this.v = on7Var.c;
        if (cVar == null || hVar == null || (fVar = hVar.a) == null) {
            return;
        }
        this.E = fVar.a;
        on7.a aVar = cVar.b;
        this.u = aVar;
        if (aVar != null) {
            this.z = aVar.c;
        }
        on7.d dVar = this.s.a;
        this.t = dVar;
        if (dVar != null) {
            this.A = dVar.c;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c6d);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f091a77);
            this.j = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091bd4);
            this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091bd5);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091aa6);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a9e);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c96);
            this.i = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f091a94);
            this.l = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0925c7);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914f6);
            this.n = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0914f7);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0923c4);
            this.w = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0909c3);
            this.x = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e1e);
            this.y = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092167);
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081241);
            this.d.setOnItemClickListener(this.M);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081241));
            this.i.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.i.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds80));
            this.k.setOnClickListener(this.N);
            this.e.setOnClickListener(this.N);
            this.g.setOnClickListener(this.N);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.l.d(this.a, i);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_tbvip_arrow_right, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080ab3);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0311);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.dimen.tbds31).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.obfuscated_res_0x7f0607d5, R.color.CAM_X0335).into(this.n);
            hv4 d = hv4.d(this.w);
            d.n(R.string.J_X06);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0203);
            d.f(R.color.CAM_X0205);
            hv4 d2 = hv4.d(this.x);
            d2.n(R.string.J_X06);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0203);
            d2.f(R.color.CAM_X0205);
            if (StringHelper.equals(this.L, "1")) {
                this.x.setVisibility(8);
            }
            hv4.d(this.y).f(R.color.CAM_X0201);
        }
    }

    public void r(boolean z) {
        on7.d dVar;
        List<on7.e> list;
        on7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.q == null) {
            return;
        }
        List<on7.e> list2 = null;
        if (2 != this.D ? !((dVar = this.t) == null || (list = dVar.a) == null) : !((aVar = this.u) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            on7.e eVar = list2.get(i);
            if (eVar != null && eVar.f >= 0 && eVar.j == 1) {
                eVar.k = z;
                return;
            }
        }
    }

    public final void s() {
        on7.h hVar;
        on7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
                    w();
                    x();
                    z();
                }
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void t(on7 on7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, on7Var) == null) {
            if (on7Var == null) {
                this.c.setVisibility(8);
                return;
            }
            this.q = on7Var;
            o();
            s();
        }
    }

    public final void u(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.I.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.F, this.G);
            payConfig.setTitle(this.B);
            payConfig.setOrderName(this.C + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ad0, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.H == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            }
            ed5.c().a(payConfig, this.a.getPageActivity());
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 1) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public final void w() {
        on7.d dVar;
        List<on7.e> list;
        on7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (2 != this.D ? (dVar = this.t) == null || (list = dVar.a) == null : (aVar = this.u) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (on7.e eVar : list) {
                if (eVar.i) {
                    v(eVar.j);
                    y(eVar.f);
                }
            }
            if (this.o == null) {
                mn7 mn7Var = new mn7(this.a);
                this.o = mn7Var;
                mn7Var.f(list);
                this.d.setAdapter((ListAdapter) this.o);
            }
            this.o.f(list);
            this.o.notifyDataSetChanged();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.p == null) {
            ArrayList<on7.i> arrayList = this.v.a;
            nn7 nn7Var = new nn7(this.a.getPageActivity());
            this.p = nn7Var;
            nn7Var.g(new a(this));
            this.p.f(arrayList);
            this.i.setAdapter((ListAdapter) this.p);
        }
    }

    public final void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.k.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f13b4, "" + (j / 100)));
        }
    }

    public final void z() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = this.D;
            if (2 == i) {
                if (this.E == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f044c, new Object[]{this.z});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0528, new Object[]{this.z});
                }
                this.C = this.z;
            } else if (1 == i) {
                long j = this.E;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f044c, new Object[]{this.A});
                } else {
                    string = j == 0 ? this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0528, new Object[]{this.A}) : null;
                }
                this.C = this.A;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0528, new Object[]{this.A});
                this.C = this.A;
            }
            this.B = string;
        }
    }
}
