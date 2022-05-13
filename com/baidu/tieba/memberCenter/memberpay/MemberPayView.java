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
import com.repackage.ck7;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.v85;
import com.repackage.w95;
import java.util.List;
/* loaded from: classes3.dex */
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
    public NavigationBar b;
    public NoNetworkView c;
    public View d;
    public RadioGroup e;
    public RadioButton f;
    public RadioButton g;
    public LinearLayout h;
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
    public ck7 t;
    public ck7.g u;
    public ck7.b v;
    public ck7.c w;
    public ck7.a x;
    public String y;
    public String z;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public TextView b;
        public TextView c;
        public TbImageView d;
        public TextView e;
        public TextView f;
        public View g;

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

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ck7.d> a;
        public final /* synthetic */ MemberPayView b;

        public c(MemberPayView memberPayView, List<ck7.d> list) {
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
            this.b = memberPayView;
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.h == null) {
                return;
            }
            ck7.d dVar = null;
            for (int i = 0; i < this.b.h.getChildCount(); i++) {
                View childAt = this.b.h.getChildAt(i);
                if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof b) && (textView = (TextView) childAt.findViewById(R.id.obfuscated_res_0x7f0905ad)) != null && textView.getTag() != null) {
                    if (textView.getTag() instanceof ck7.d) {
                        ck7.d dVar2 = (ck7.d) textView.getTag();
                        if (view2 == childAt) {
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
                    this.b.i(this.a, i, (b) childAt.getTag());
                }
            }
            if (dVar == null) {
                return;
            }
            if (dVar.n != 1 || !dVar.o) {
                this.b.j(dVar.i, dVar.j / 100, dVar.l, dVar.n);
            } else {
                mi.M(this.b.getContext(), R.string.obfuscated_res_0x7f0f140b);
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
        ck7 ck7Var;
        ck7.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ck7Var = this.t) == null) {
            return;
        }
        ck7.b bVar = ck7Var.b;
        this.v = bVar;
        ck7.g gVar = ck7Var.a;
        this.u = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.c) == null) {
            return;
        }
        long j = eVar.a;
        this.G = j;
        this.I = j == 2 || this.H == 2;
        ck7.b bVar2 = this.v;
        ck7.a aVar = bVar2.b;
        this.x = aVar;
        if (aVar == null) {
            return;
        }
        this.y = aVar.c;
        this.C = aVar.d;
        String str = aVar.e;
        ck7.c cVar = bVar2.a;
        this.w = cVar;
        if (cVar == null) {
            return;
        }
        this.z = cVar.c;
        this.D = cVar.d;
        String str2 = cVar.e;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0531);
            this.d = this.a.findViewById(R.id.obfuscated_res_0x7f091b16);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f091547);
            this.b = navigationBar;
            navigationBar.setTitleText("");
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f0923ff);
            this.h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906cd);
            RadioGroup radioGroup = (RadioGroup) this.a.findViewById(R.id.obfuscated_res_0x7f090449);
            this.e = radioGroup;
            radioGroup.setOnCheckedChangeListener(this.a);
            this.f = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090426);
            this.g = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090427);
            this.m = this.a.findViewById(R.id.obfuscated_res_0x7f092320);
            this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090cce);
            this.p = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090347);
            this.q = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090348);
            this.r = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09072d);
            this.s = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09072e);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090272);
            this.n = textView;
            textView.setOnClickListener(this.a);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.d);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            this.c.c(this.a.getPageContext(), i);
        }
    }

    public void g(boolean z) {
        ck7.c cVar;
        List<ck7.d> list;
        ck7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.t == null) {
            return;
        }
        List<ck7.d> list2 = null;
        if (2 != this.F ? !((cVar = this.w) == null || (list = cVar.a) == null) : !((aVar = this.x) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            ck7.d dVar = list2.get(i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (NoNetworkView) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public final void h() {
        ck7.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.t == null) {
                this.d.setVisibility(8);
            } else if (this.v != null && (gVar = this.u) != null) {
                if (gVar.c == null) {
                    this.d.setVisibility(8);
                } else if (this.x == null && this.w == null) {
                    this.d.setVisibility(8);
                } else if (this.I && ListUtils.isEmpty(this.x.a)) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                    n();
                    o();
                    p();
                    m();
                }
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public final void i(List<ck7.d> list, int i, b bVar) {
        ck7.d dVar;
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
            bVar.g.setVisibility(0);
        } else if (i == list.size() - 1) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_down_s);
            } else {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_down_n);
            }
            bVar.g.setVisibility(8);
        } else {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_center_s);
            } else {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.bg_pay_list_center_n);
            }
            bVar.g.setVisibility(0);
        }
    }

    public final void j(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.J.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.a.getReferPage(), this.a.getClickZone());
            payConfig.setTitle(getTitle());
            payConfig.setOrderName(getCurrentContent() + this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0aad, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.a.getFrom() == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            } else if (this.a.getFrom() == 25) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
            }
            v85.c().a(payConfig, this.a.getPageContext().getPageActivity());
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
                if (!li.isEmpty(this.C)) {
                    this.o.setText(this.C);
                    this.r.setVisibility(0);
                    this.s.setVisibility(4);
                    return;
                }
                this.r.setVisibility(4);
                this.s.setVisibility(4);
            } else if (1 == i) {
                if (!li.isEmpty(this.D)) {
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
        ck7.c cVar;
        List<ck7.d> list;
        ck7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Boolean bool = Boolean.FALSE;
            if (2 != this.F ? (cVar = this.w) == null || (list = cVar.a) == null : (aVar = this.x) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.h.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            for (int i = 0; i < list.size(); i++) {
                ck7.d dVar = list.get(i);
                if (dVar != null && dVar.j >= 0) {
                    if (dVar.n == 1) {
                        bool = Boolean.TRUE;
                    }
                    b bVar = new b(null);
                    View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d053b, (ViewGroup) null);
                    bVar.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0905ad);
                    bVar.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092210);
                    bVar.d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913ee);
                    bVar.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921de);
                    bVar.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09220f);
                    bVar.a = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091b16);
                    bVar.g = inflate.findViewById(R.id.obfuscated_res_0x7f092322);
                    bVar.c.setText(l(dVar.b, 7));
                    if (!TextUtils.isEmpty(dVar.e)) {
                        bVar.d.setVisibility(0);
                        bVar.d.K(dVar.e, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.c)) {
                        bVar.e.setVisibility(8);
                    } else {
                        bVar.e.setVisibility(0);
                        bVar.e.setText(l(dVar.c, 10));
                    }
                    bVar.f.setText("¥" + (dVar.j / 100));
                    if (dVar.m) {
                        SkinManager.setBackgroundResource(bVar.b, R.drawable.btn_non_orange_s);
                        SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setBackgroundResource(bVar.b, R.drawable.btn_non_orange_n);
                        SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0305);
                    }
                    bVar.b.setTag(dVar);
                    bVar.b.setText(R.string.obfuscated_res_0x7f0f03e7);
                    inflate.setContentDescription(l(dVar.b, 7));
                    inflate.setOnClickListener(new c(this, list));
                    inflate.setTag(bVar);
                    inflate.setLayoutParams(layoutParams);
                    w95.a(this.a.getPageContext(), inflate);
                    i(list, i, bVar);
                    this.h.addView(inflate);
                }
            }
            if (bool.booleanValue()) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d053a, (ViewGroup) null);
                this.i = linearLayout;
                this.j = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09220c);
                this.k = this.i.findViewById(R.id.obfuscated_res_0x7f0923da);
                this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0921c4);
                this.j.setOnClickListener(this.a);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204_1);
                }
                this.l.setOnClickListener(this.a);
                this.h.addView(this.i);
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d053c, (ViewGroup) null);
            this.i = linearLayout2;
            TextView textView = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f09220d);
            this.j = textView;
            textView.setOnClickListener(this.a);
            this.h.addView(this.i);
        }
    }

    public final void o() {
        ck7.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f.setText(l(this.y, this.E));
            if (2 == this.F) {
                if (li.isEmpty(this.C)) {
                    this.o.setVisibility(8);
                    this.r.setVisibility(8);
                } else {
                    this.o.setVisibility(0);
                    this.r.setVisibility(0);
                    this.o.setText(this.C);
                }
            } else if (li.isEmpty(this.D)) {
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
            if (li.isEmpty(this.x.e)) {
                SkinManager.setImageResource(this.p, R.drawable.icon_vip_advanced, 0);
            } else {
                this.p.K(this.x.e, 10, false);
            }
            if (!this.I && (cVar = this.w) != null && !ListUtils.isEmpty(cVar.a)) {
                this.g.setVisibility(0);
                this.g.setText(l(this.z, this.E));
                this.q.setVisibility(0);
                if (li.isEmpty(this.w.e)) {
                    SkinManager.setImageResource(this.q, R.drawable.icon_vip_member, 0);
                } else {
                    this.q.K(this.w.e, 21, false);
                }
            } else {
                this.g.setVisibility(8);
                this.q.setVisibility(8);
                this.s.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
                this.s.setVisibility(8);
            }
            View view2 = this.m;
            if (view2 != null) {
                view2.setVisibility(8);
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
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f043e, new Object[]{this.y});
                } else {
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f050f, new Object[]{this.y});
                }
                this.B = this.y;
            } else if (1 == i) {
                long j = this.G;
                if (j == 1) {
                    string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f043e, new Object[]{this.z});
                } else {
                    string = j == 0 ? this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f050f, new Object[]{this.z}) : null;
                }
                this.B = this.z;
            } else {
                string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f050f, new Object[]{this.z});
                this.B = this.z;
            }
            this.A = string;
            if (StringUtils.isNULL(string)) {
                return;
            }
            this.b.setTitleText(l(string, 10));
        }
    }

    public void setDataAndRefreshUI(ck7 ck7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ck7Var) == null) {
            if (ck7Var == null) {
                this.d.setVisibility(8);
                return;
            }
            this.t = ck7Var;
            d();
            k(this.F);
        }
    }
}
