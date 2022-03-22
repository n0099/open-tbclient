package com.baidu.tieba.memberCenter.memberpay;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.q0.e;
import c.a.p0.j2.f.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class MemberPayView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public int E;
    public int F;
    public long G;
    public int H;
    public boolean I;
    public Boolean J;
    public MemberPayActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f34503b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f34504c;

    /* renamed from: d  reason: collision with root package name */
    public View f34505d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f34506e;

    /* renamed from: f  reason: collision with root package name */
    public RadioButton f34507f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f34508g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f34509h;
    public LinearLayout i;
    public TextView j;
    public View k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;
    public TbImageView p;
    public TbImageView q;
    public ImageView r;
    public ImageView s;
    public f t;
    public f.g u;
    public f.b v;
    public f.c w;
    public f.a x;
    public String y;
    public String z;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f34510b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f34511c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f34512d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f34513e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f34514f;

        /* renamed from: g  reason: collision with root package name */
        public View f34515g;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<f.d> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MemberPayView f34516b;

        public c(MemberPayView memberPayView, List<f.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayView, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34516b = memberPayView;
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f34516b.f34509h == null) {
                return;
            }
            f.d dVar = null;
            for (int i = 0; i < this.f34516b.f34509h.getChildCount(); i++) {
                View childAt = this.f34516b.f34509h.getChildAt(i);
                if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof b) && (textView = (TextView) childAt.findViewById(R.id.obfuscated_res_0x7f0905a5)) != null && textView.getTag() != null) {
                    if (textView.getTag() instanceof f.d) {
                        f.d dVar2 = (f.d) textView.getTag();
                        if (view == childAt) {
                            dVar2.m = true;
                            SkinManager.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                            dVar = dVar2;
                        } else {
                            dVar2.m = false;
                            SkinManager.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0305);
                        }
                    }
                    this.f34516b.i(this.a, i, (b) childAt.getTag());
                }
            }
            if (dVar == null) {
                return;
            }
            if (dVar.n != 1 || !dVar.o) {
                this.f34516b.j(dVar.i, dVar.j / 100, dVar.l, dVar.n);
            } else {
                n.M(this.f34516b.getContext(), R.string.obfuscated_res_0x7f0f13df);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPayActivity, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = 12;
        this.F = 2;
        this.I = false;
        this.J = Boolean.FALSE;
        this.a = memberPayActivity;
        this.H = i;
        this.J = Boolean.valueOf(z);
        e();
    }

    public final void d() {
        f fVar;
        f.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.t) == null) {
            return;
        }
        f.b bVar = fVar.f15736b;
        this.v = bVar;
        f.g gVar = fVar.a;
        this.u = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f15755c) == null) {
            return;
        }
        long j = eVar.a;
        this.G = j;
        this.I = j == 2 || this.H == 2;
        f.b bVar2 = this.v;
        f.a aVar = bVar2.f15741b;
        this.x = aVar;
        if (aVar == null) {
            return;
        }
        this.y = aVar.f15738c;
        this.C = aVar.f15739d;
        String str = aVar.f15740e;
        f.c cVar = bVar2.a;
        this.w = cVar;
        if (cVar == null) {
            return;
        }
        this.z = cVar.f15743c;
        this.D = cVar.f15744d;
        String str2 = cVar.f15745e;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0542);
            this.f34505d = this.a.findViewById(R.id.obfuscated_res_0x7f091ad7);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f09152d);
            this.f34503b = navigationBar;
            navigationBar.setTitleText("");
            this.f34503b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f34504c = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f0923d1);
            this.f34509h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906c9);
            RadioGroup radioGroup = (RadioGroup) this.a.findViewById(R.id.obfuscated_res_0x7f090446);
            this.f34506e = radioGroup;
            radioGroup.setOnCheckedChangeListener(this.a);
            this.f34507f = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090422);
            this.f34508g = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090423);
            this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0922e8);
            this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090cda);
            this.p = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090344);
            this.q = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090345);
            this.r = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090727);
            this.s = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090728);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090274);
            this.n = textView;
            textView.setOnClickListener(this.a);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f34505d);
            this.f34503b.onChangeSkinType(this.a.getPageContext(), i);
            this.f34504c.c(this.a.getPageContext(), i);
        }
    }

    public void g(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.t == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.F ? !((cVar = this.w) == null || (list = cVar.a) == null) : !((aVar = this.x) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            f.d dVar = list2.get(i);
            if (dVar != null && dVar.j >= 0 && dVar.n == 1) {
                dVar.o = z;
                return;
            }
        }
    }

    public String getCurrentContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public int getCurrentShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.F : invokeV.intValue;
    }

    public NoNetworkView getNoNetworkView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34504c : (NoNetworkView) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public final void h() {
        f.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.t == null) {
                this.f34505d.setVisibility(8);
            } else if (this.v != null && (gVar = this.u) != null) {
                if (gVar.f15755c == null) {
                    this.f34505d.setVisibility(8);
                } else if (this.x == null && this.w == null) {
                    this.f34505d.setVisibility(8);
                } else if (this.I && ListUtils.isEmpty(this.x.a)) {
                    this.f34505d.setVisibility(8);
                } else {
                    this.f34505d.setVisibility(0);
                    n();
                    o();
                    p();
                    m();
                }
            } else {
                this.f34505d.setVisibility(8);
            }
        }
    }

    public final void i(List<f.d> list, int i, b bVar) {
        f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, list, i, bVar) == null) || list == null || i >= list.size() || bVar == null || (dVar = list.get(i)) == null) {
            return;
        }
        if (i == 0) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_up_s);
            } else {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_up_n);
            }
            bVar.f34515g.setVisibility(0);
        } else if (i == list.size() - 1) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_down_s);
            } else {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_down_n);
            }
            bVar.f34515g.setVisibility(8);
        } else {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_center_s);
            } else {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_center_n);
            }
            bVar.f34515g.setVisibility(0);
        }
    }

    public final void j(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.J.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.a.getReferPage(), this.a.getClickZone());
            payConfig.setTitle(getTitle());
            payConfig.setOrderName(getCurrentContent() + this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0aa4, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.a.getFrom() == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            } else if (this.a.getFrom() == 25) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
            }
            e.c().a(payConfig, this.a.getPageContext().getPageActivity());
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i < 0 || i > 2) {
            return;
        }
        this.F = i;
        h();
    }

    public String l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = this.F;
            if (2 == i) {
                if (!m.isEmpty(this.C)) {
                    this.o.setText(this.C);
                    this.r.setVisibility(0);
                    this.s.setVisibility(4);
                    return;
                }
                this.r.setVisibility(4);
                this.s.setVisibility(4);
            } else if (1 == i) {
                if (!m.isEmpty(this.D)) {
                    this.o.setText(this.D);
                    this.r.setVisibility(4);
                    this.s.setVisibility(0);
                    return;
                }
                this.r.setVisibility(4);
                this.s.setVisibility(4);
            }
        }
    }

    public final void n() {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Boolean bool = Boolean.FALSE;
            if (2 != this.F ? (cVar = this.w) == null || (list = cVar.a) == null : (aVar = this.x) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f34509h.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            for (int i = 0; i < list.size(); i++) {
                f.d dVar = list.get(i);
                if (dVar != null && dVar.j >= 0) {
                    if (dVar.n == 1) {
                        bool = Boolean.TRUE;
                    }
                    b bVar = new b(null);
                    View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054c, (ViewGroup) null);
                    bVar.f34510b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0905a5);
                    bVar.f34511c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921d4);
                    bVar.f34512d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913df);
                    bVar.f34513e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921a1);
                    bVar.f34514f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921d3);
                    bVar.a = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091ad7);
                    bVar.f34515g = inflate.findViewById(R.id.obfuscated_res_0x7f0922ea);
                    bVar.f34511c.setText(l(dVar.f15746b, 7));
                    if (!TextUtils.isEmpty(dVar.f15749e)) {
                        bVar.f34512d.setVisibility(0);
                        bVar.f34512d.J(dVar.f15749e, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.f15747c)) {
                        bVar.f34513e.setVisibility(8);
                    } else {
                        bVar.f34513e.setVisibility(0);
                        bVar.f34513e.setText(l(dVar.f15747c, 10));
                    }
                    bVar.f34514f.setText("¥" + (dVar.j / 100));
                    if (dVar.m) {
                        SkinManager.setBackgroundResource(bVar.f34510b, R.drawable.btn_non_orange_s);
                        SkinManager.setViewTextColor(bVar.f34510b, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setBackgroundResource(bVar.f34510b, R.drawable.btn_non_orange_n);
                        SkinManager.setViewTextColor(bVar.f34510b, (int) R.color.CAM_X0305);
                    }
                    bVar.f34510b.setTag(dVar);
                    bVar.f34510b.setText(R.string.obfuscated_res_0x7f0f03db);
                    inflate.setContentDescription(l(dVar.f15746b, 7));
                    inflate.setOnClickListener(new c(this, list));
                    inflate.setTag(bVar);
                    inflate.setLayoutParams(layoutParams);
                    c.a.o0.w0.a.a(this.a.getPageContext(), inflate);
                    i(list, i, bVar);
                    this.f34509h.addView(inflate);
                }
            }
            if (bool.booleanValue()) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054b, (ViewGroup) null);
                this.i = linearLayout;
                this.j = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0921d0);
                this.k = this.i.findViewById(R.id.obfuscated_res_0x7f0923aa);
                this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092188);
                this.j.setOnClickListener(this.a);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204_1);
                }
                this.l.setOnClickListener(this.a);
                this.f34509h.addView(this.i);
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054d, (ViewGroup) null);
            this.i = linearLayout2;
            TextView textView = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f0921d1);
            this.j = textView;
            textView.setOnClickListener(this.a);
            this.f34509h.addView(this.i);
        }
    }

    public final void o() {
        f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f34507f.setText(l(this.y, this.E));
            if (2 == this.F) {
                if (m.isEmpty(this.C)) {
                    this.o.setVisibility(8);
                    this.r.setVisibility(8);
                } else {
                    this.o.setVisibility(0);
                    this.r.setVisibility(0);
                    this.o.setText(this.C);
                }
            } else if (m.isEmpty(this.D)) {
                this.o.setVisibility(8);
                this.s.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.s.setVisibility(0);
                this.o.setText(this.D);
            }
            this.p.setDefaultBgResource(0);
            this.q.setDefaultBgResource(0);
            this.p.setAutoChangeStyle(false);
            this.q.setAutoChangeStyle(false);
            if (m.isEmpty(this.x.f15740e)) {
                SkinManager.setImageResource(this.p, R.drawable.icon_vip_advanced, 0);
            } else {
                this.p.J(this.x.f15740e, 10, false);
            }
            if (!this.I && (cVar = this.w) != null && !ListUtils.isEmpty(cVar.a)) {
                this.f34508g.setVisibility(0);
                this.f34508g.setText(l(this.z, this.E));
                this.q.setVisibility(0);
                if (m.isEmpty(this.w.f15745e)) {
                    SkinManager.setImageResource(this.q, R.drawable.icon_vip_member, 0);
                } else {
                    this.q.J(this.w.f15745e, 21, false);
                }
            } else {
                this.f34508g.setVisibility(8);
                this.q.setVisibility(8);
                this.s.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
                this.s.setVisibility(8);
            }
            View view = this.m;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void p() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.F;
            if (2 == i) {
                if (this.G == 2) {
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f042f, new Object[]{this.y});
                } else {
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.y});
                }
                this.B = this.y;
            } else if (1 == i) {
                long j = this.G;
                if (j == 1) {
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f042f, new Object[]{this.z});
                } else {
                    string = j == 0 ? this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.z}) : null;
                }
                this.B = this.z;
            } else {
                string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.z});
                this.B = this.z;
            }
            this.A = string;
            if (StringUtils.isNULL(string)) {
                return;
            }
            this.f34503b.setTitleText(l(string, 10));
        }
    }

    public void setDataAndRefreshUI(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            if (fVar == null) {
                this.f34505d.setVisibility(8);
                return;
            }
            this.t = fVar;
            d();
            k(this.F);
        }
    }
}
