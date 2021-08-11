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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.n0.d;
import c.a.p0.w1.f.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class MemberPayView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f.c A;
    public f.a B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public int I;
    public int J;
    public long K;
    public int L;
    public boolean M;
    public Boolean N;

    /* renamed from: e  reason: collision with root package name */
    public MemberPayActivity f54048e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f54049f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f54050g;

    /* renamed from: h  reason: collision with root package name */
    public View f54051h;

    /* renamed from: i  reason: collision with root package name */
    public RadioGroup f54052i;

    /* renamed from: j  reason: collision with root package name */
    public RadioButton f54053j;
    public RadioButton k;
    public LinearLayout l;
    public LinearLayout m;
    public TextView n;
    public View o;
    public TextView p;
    public View q;
    public TextView r;
    public TextView s;
    public TbImageView t;
    public TbImageView u;
    public ImageView v;
    public ImageView w;
    public f x;
    public f.g y;
    public f.b z;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f54054a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54055b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54056c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f54057d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54058e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f54059f;

        /* renamed from: g  reason: collision with root package name */
        public View f54060g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<f.d> f54061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MemberPayView f54062f;

        public c(MemberPayView memberPayView, List<f.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayView, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54062f = memberPayView;
            this.f54061e = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54062f.l == null) {
                return;
            }
            f.d dVar = null;
            for (int i2 = 0; i2 < this.f54062f.l.getChildCount(); i2++) {
                View childAt = this.f54062f.l.getChildAt(i2);
                if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof b) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                    if (textView.getTag() instanceof f.d) {
                        f.d dVar2 = (f.d) textView.getTag();
                        if (view == childAt) {
                            dVar2.m = true;
                            SkinManager.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                            dVar = dVar2;
                        } else {
                            dVar2.m = false;
                            SkinManager.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                            SkinManager.setViewTextColor(textView, R.color.CAM_X0305);
                        }
                    }
                    this.f54062f.g(this.f54061e, i2, (b) childAt.getTag());
                }
            }
            if (dVar == null) {
                return;
            }
            if (dVar.n != 1 || !dVar.o) {
                this.f54062f.h(dVar.f27646i, dVar.f27647j / 100, dVar.l, dVar.n);
            } else {
                l.L(this.f54062f.getContext(), R.string.tips_auto_pay_succ);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayView(MemberPayActivity memberPayActivity, int i2, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPayActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = 12;
        this.J = 2;
        this.M = false;
        this.N = Boolean.FALSE;
        this.f54048e = memberPayActivity;
        this.L = i2;
        this.N = Boolean.valueOf(z);
        e();
    }

    public final void d() {
        f fVar;
        f.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.x) == null) {
            return;
        }
        f.b bVar = fVar.f27625b;
        this.z = bVar;
        f.g gVar = fVar.f27624a;
        this.y = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f27652c) == null) {
            return;
        }
        long j2 = eVar.f27648a;
        this.K = j2;
        this.M = j2 == 2 || this.L == 2;
        f.b bVar2 = this.z;
        f.a aVar = bVar2.f27632b;
        this.B = aVar;
        if (aVar == null) {
            return;
        }
        this.C = aVar.f27628c;
        this.G = aVar.f27629d;
        String str = aVar.f27630e;
        f.c cVar = bVar2.f27631a;
        this.A = cVar;
        if (cVar == null) {
            return;
        }
        this.D = cVar.f27635c;
        this.H = cVar.f27636d;
        String str2 = cVar.f27637e;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f54048e.setContentView(R.layout.member_pay_activity);
            this.f54051h = this.f54048e.findViewById(R.id.root);
            NavigationBar navigationBar = (NavigationBar) this.f54048e.findViewById(R.id.navigationbar);
            this.f54049f = navigationBar;
            navigationBar.setTitleText("");
            this.f54049f.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f54050g = (NoNetworkView) this.f54048e.findViewById(R.id.view_no_network);
            this.l = (LinearLayout) this.f54048e.findViewById(R.id.container);
            RadioGroup radioGroup = (RadioGroup) this.f54048e.findViewById(R.id.btns_mem_select);
            this.f54052i = radioGroup;
            radioGroup.setOnCheckedChangeListener(this.f54048e);
            this.f54053j = (RadioButton) this.f54048e.findViewById(R.id.btn_mem1);
            this.k = (RadioButton) this.f54048e.findViewById(R.id.btn_mem2);
            this.q = this.f54048e.findViewById(R.id.v_blank);
            this.s = (TextView) this.f54048e.findViewById(R.id.goods_des);
            this.t = (TbImageView) this.f54048e.findViewById(R.id.bdimg_adv);
            this.u = (TbImageView) this.f54048e.findViewById(R.id.bdimg_comm);
            this.v = (ImageView) this.f54048e.findViewById(R.id.crumb_adv);
            this.w = (ImageView) this.f54048e.findViewById(R.id.crumb_comm);
            TextView textView = (TextView) this.f54048e.findViewById(R.id.aotu_pay_law);
            this.r = textView;
            textView.setOnClickListener(this.f54048e);
        }
    }

    public final void f() {
        f.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.x == null) {
                this.f54051h.setVisibility(8);
            } else if (this.z != null && (gVar = this.y) != null) {
                if (gVar.f27652c == null) {
                    this.f54051h.setVisibility(8);
                } else if (this.B == null && this.A == null) {
                    this.f54051h.setVisibility(8);
                } else if (this.M && ListUtils.isEmpty(this.B.f27626a)) {
                    this.f54051h.setVisibility(8);
                } else {
                    this.f54051h.setVisibility(0);
                    j();
                    k();
                    l();
                    i();
                }
            } else {
                this.f54051h.setVisibility(8);
            }
        }
    }

    public final void g(List<f.d> list, int i2, b bVar) {
        f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, list, i2, bVar) == null) || list == null || i2 >= list.size() || bVar == null || (dVar = list.get(i2)) == null) {
            return;
        }
        if (i2 == 0) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_up_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_up_n);
            }
            bVar.f54060g.setVisibility(0);
        } else if (i2 == list.size() - 1) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_down_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_down_n);
            }
            bVar.f54060g.setVisibility(8);
        } else {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_center_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f54054a, R.drawable.bg_pay_list_center_n);
            }
            bVar.f54060g.setVisibility(0);
        }
    }

    public String getCurrentContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public int getCurrentShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.J : invokeV.intValue;
    }

    public NoNetworkView getNoNetworkView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54050g : (NoNetworkView) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public final void h(long j2, long j3, long j4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j2), String.valueOf(j3), String.valueOf(j4), true, this.N.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.f54048e.getReferPage(), this.f54048e.getClickZone());
            payConfig.setTitle(getTitle());
            payConfig.setOrderName(getCurrentContent() + this.f54048e.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j4)}));
            payConfig.setAutoPay(i2);
            if (this.f54048e.getFrom() == 23) {
                payConfig.paymentPosKey = "37";
            } else if (this.f54048e.getFrom() == 25) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
            }
            d.c().a(payConfig, this.f54048e.getPageContext().getPageActivity());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.J;
            if (2 == i2) {
                if (!k.isEmpty(this.G)) {
                    this.s.setText(this.G);
                    this.v.setVisibility(0);
                    this.w.setVisibility(4);
                    return;
                }
                this.v.setVisibility(4);
                this.w.setVisibility(4);
            } else if (1 == i2) {
                if (!k.isEmpty(this.H)) {
                    this.s.setText(this.H);
                    this.v.setVisibility(4);
                    this.w.setVisibility(0);
                    return;
                }
                this.v.setVisibility(4);
                this.w.setVisibility(4);
            }
        }
    }

    public final void j() {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Boolean bool = Boolean.FALSE;
            if (2 != this.J ? (cVar = this.A) == null || (list = cVar.f27633a) == null : (aVar = this.B) == null || (list = aVar.f27626a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.l.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            for (int i2 = 0; i2 < list.size(); i2++) {
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.f27647j >= 0) {
                    if (dVar.n == 1) {
                        bool = Boolean.TRUE;
                    }
                    b bVar = new b(null);
                    View inflate = LayoutInflater.from(this.f54048e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    bVar.f54055b = (TextView) inflate.findViewById(R.id.cb);
                    bVar.f54056c = (TextView) inflate.findViewById(R.id.tv_month);
                    bVar.f54057d = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    bVar.f54058e = (TextView) inflate.findViewById(R.id.tv_discount);
                    bVar.f54059f = (TextView) inflate.findViewById(R.id.tv_money);
                    bVar.f54054a = (RelativeLayout) inflate.findViewById(R.id.root);
                    bVar.f54060g = inflate.findViewById(R.id.v_line);
                    bVar.f54056c.setText(truncateStr(dVar.f27639b, 7));
                    if (!TextUtils.isEmpty(dVar.f27642e)) {
                        bVar.f54057d.setVisibility(0);
                        bVar.f54057d.startLoad(dVar.f27642e, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.f27640c)) {
                        bVar.f54058e.setVisibility(8);
                    } else {
                        bVar.f54058e.setVisibility(0);
                        bVar.f54058e.setText(truncateStr(dVar.f27640c, 10));
                    }
                    bVar.f54059f.setText("¥" + (dVar.f27647j / 100));
                    if (dVar.m) {
                        SkinManager.setBackgroundResource(bVar.f54055b, R.drawable.btn_non_orange_s);
                        SkinManager.setViewTextColor(bVar.f54055b, R.color.CAM_X0101);
                    } else {
                        SkinManager.setBackgroundResource(bVar.f54055b, R.drawable.btn_non_orange_n);
                        SkinManager.setViewTextColor(bVar.f54055b, R.color.CAM_X0305);
                    }
                    bVar.f54055b.setTag(dVar);
                    bVar.f54055b.setText(R.string.click_open);
                    inflate.setContentDescription(truncateStr(dVar.f27639b, 7));
                    inflate.setOnClickListener(new c(this, list));
                    inflate.setTag(bVar);
                    inflate.setLayoutParams(layoutParams);
                    c.a.o0.u0.a.a(this.f54048e.getPageContext(), inflate);
                    g(list, i2, bVar);
                    this.l.addView(inflate);
                }
            }
            if (bool.booleanValue()) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f54048e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.m = linearLayout;
                this.n = (TextView) linearLayout.findViewById(R.id.tv_member_agreement_auto_pay);
                this.o = this.m.findViewById(R.id.view_agreement_divider_auto_pay);
                this.p = (TextView) this.m.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.n.setOnClickListener(this.f54048e);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204_1);
                }
                this.p.setOnClickListener(this.f54048e);
                this.l.addView(this.m);
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.f54048e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.m = linearLayout2;
            TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_member_agreement_normal);
            this.n = textView;
            textView.setOnClickListener(this.f54048e);
            this.l.addView(this.m);
        }
    }

    public final void k() {
        f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f54053j.setText(truncateStr(this.C, this.I));
            if (2 == this.J) {
                if (k.isEmpty(this.G)) {
                    this.s.setVisibility(8);
                    this.v.setVisibility(8);
                } else {
                    this.s.setVisibility(0);
                    this.v.setVisibility(0);
                    this.s.setText(this.G);
                }
            } else if (k.isEmpty(this.H)) {
                this.s.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                this.w.setVisibility(0);
                this.s.setText(this.H);
            }
            this.t.setDefaultBgResource(0);
            this.u.setDefaultBgResource(0);
            this.t.setAutoChangeStyle(false);
            this.u.setAutoChangeStyle(false);
            if (k.isEmpty(this.B.f27630e)) {
                SkinManager.setImageResource(this.t, R.drawable.icon_vip_advanced, 0);
            } else {
                this.t.startLoad(this.B.f27630e, 10, false);
            }
            if (!this.M && (cVar = this.A) != null && !ListUtils.isEmpty(cVar.f27633a)) {
                this.k.setVisibility(0);
                this.k.setText(truncateStr(this.D, this.I));
                this.u.setVisibility(0);
                if (k.isEmpty(this.A.f27637e)) {
                    SkinManager.setImageResource(this.u, R.drawable.icon_vip_member, 0);
                } else {
                    this.u.startLoad(this.A.f27637e, 21, false);
                }
            } else {
                this.k.setVisibility(8);
                this.u.setVisibility(8);
                this.w.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
                this.w.setVisibility(8);
            }
            View view = this.q;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void l() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.J;
            if (2 == i2) {
                if (this.K == 2) {
                    string = this.f54048e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.C});
                } else {
                    string = this.f54048e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.C});
                }
                this.F = this.C;
            } else if (1 == i2) {
                long j2 = this.K;
                if (j2 == 1) {
                    string = this.f54048e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.D});
                } else {
                    string = j2 == 0 ? this.f54048e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D}) : null;
                }
                this.F = this.D;
            } else {
                string = this.f54048e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D});
                this.F = this.D;
            }
            this.E = string;
            if (StringUtils.isNULL(string)) {
                return;
            }
            this.f54049f.setTitleText(truncateStr(string, 10));
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f54048e.getLayoutMode().k(i2 == 1);
            this.f54048e.getLayoutMode().j(this.f54051h);
            this.f54049f.onChangeSkinType(this.f54048e.getPageContext(), i2);
            this.f54050g.onChangeSkinType(this.f54048e.getPageContext(), i2);
        }
    }

    public void refreshAutoPayItemUI(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.x == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.J ? !((cVar = this.A) == null || (list = cVar.f27633a) == null) : !((aVar = this.B) == null || (list = aVar.f27626a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            f.d dVar = list2.get(i2);
            if (dVar != null && dVar.f27647j >= 0 && dVar.n == 1) {
                dVar.o = z;
                return;
            }
        }
    }

    public void setDataAndRefreshUI(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            if (fVar == null) {
                this.f54051h.setVisibility(8);
                return;
            }
            this.x = fVar;
            d();
            switchTab(this.J);
        }
    }

    public void switchTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 < 0 || i2 > 2) {
            return;
        }
        this.J = i2;
        f();
    }

    public String truncateStr(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (str.length() > i2) {
                return str.substring(0, i2 - 1) + "...";
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }
}
