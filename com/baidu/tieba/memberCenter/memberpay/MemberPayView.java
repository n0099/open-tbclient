package com.baidu.tieba.memberCenter.memberpay;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.l0.d;
import d.a.j0.r1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayView extends LinearLayout {
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
    public MemberPayActivity f19089e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f19090f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f19091g;

    /* renamed from: h  reason: collision with root package name */
    public View f19092h;

    /* renamed from: i  reason: collision with root package name */
    public RadioGroup f19093i;
    public RadioButton j;
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

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f19094a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19095b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19096c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f19097d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19098e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19099f;

        /* renamed from: g  reason: collision with root package name */
        public View f19100g;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public List<f.d> f19101e;

        public c(List<f.d> list) {
            this.f19101e = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            if (MemberPayView.this.l == null) {
                return;
            }
            f.d dVar = null;
            for (int i2 = 0; i2 < MemberPayView.this.l.getChildCount(); i2++) {
                View childAt = MemberPayView.this.l.getChildAt(i2);
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
                    MemberPayView.this.i(this.f19101e, i2, (b) childAt.getTag());
                }
            }
            if (dVar == null) {
                return;
            }
            if (dVar.n != 1 || !dVar.o) {
                MemberPayView.this.j(dVar.f59691i, dVar.j / 100, dVar.l, dVar.n);
            } else {
                l.L(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
            }
        }
    }

    public MemberPayView(MemberPayActivity memberPayActivity, int i2, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.I = 12;
        this.J = 2;
        this.M = false;
        this.N = Boolean.FALSE;
        this.f19089e = memberPayActivity;
        this.L = i2;
        this.N = Boolean.valueOf(z);
        e();
    }

    public final void d() {
        f.e eVar;
        f fVar = this.x;
        if (fVar == null) {
            return;
        }
        f.b bVar = fVar.f59670b;
        this.z = bVar;
        f.g gVar = fVar.f59669a;
        this.y = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f59696c) == null) {
            return;
        }
        long j = eVar.f59692a;
        this.K = j;
        this.M = j == 2 || this.L == 2;
        f.b bVar2 = this.z;
        f.a aVar = bVar2.f59677b;
        this.B = aVar;
        if (aVar == null) {
            return;
        }
        this.C = aVar.f59673c;
        this.G = aVar.f59674d;
        String str = aVar.f59675e;
        f.c cVar = bVar2.f59676a;
        this.A = cVar;
        if (cVar == null) {
            return;
        }
        this.D = cVar.f59680c;
        this.H = cVar.f59681d;
        String str2 = cVar.f59682e;
    }

    public final void e() {
        this.f19089e.setContentView(R.layout.member_pay_activity);
        this.f19092h = this.f19089e.findViewById(R.id.root);
        NavigationBar navigationBar = (NavigationBar) this.f19089e.findViewById(R.id.navigationbar);
        this.f19090f = navigationBar;
        navigationBar.setTitleText("");
        this.f19090f.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19091g = (NoNetworkView) this.f19089e.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f19089e.findViewById(R.id.container);
        RadioGroup radioGroup = (RadioGroup) this.f19089e.findViewById(R.id.btns_mem_select);
        this.f19093i = radioGroup;
        radioGroup.setOnCheckedChangeListener(this.f19089e);
        this.j = (RadioButton) this.f19089e.findViewById(R.id.btn_mem1);
        this.k = (RadioButton) this.f19089e.findViewById(R.id.btn_mem2);
        this.q = this.f19089e.findViewById(R.id.v_blank);
        this.s = (TextView) this.f19089e.findViewById(R.id.goods_des);
        this.t = (TbImageView) this.f19089e.findViewById(R.id.bdimg_adv);
        this.u = (TbImageView) this.f19089e.findViewById(R.id.bdimg_comm);
        this.v = (ImageView) this.f19089e.findViewById(R.id.crumb_adv);
        this.w = (ImageView) this.f19089e.findViewById(R.id.crumb_comm);
        TextView textView = (TextView) this.f19089e.findViewById(R.id.aotu_pay_law);
        this.r = textView;
        textView.setOnClickListener(this.f19089e);
    }

    public void f(int i2) {
        this.f19089e.getLayoutMode().k(i2 == 1);
        this.f19089e.getLayoutMode().j(this.f19092h);
        this.f19090f.onChangeSkinType(this.f19089e.getPageContext(), i2);
        this.f19091g.c(this.f19089e.getPageContext(), i2);
    }

    public void g(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        if (this.x == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.J ? !((cVar = this.A) == null || (list = cVar.f59678a) == null) : !((aVar = this.B) == null || (list = aVar.f59671a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            f.d dVar = list2.get(i2);
            if (dVar != null && dVar.j >= 0 && dVar.n == 1) {
                dVar.o = z;
                return;
            }
        }
    }

    public String getCurrentContent() {
        return this.F;
    }

    public int getCurrentShowType() {
        return this.J;
    }

    public NoNetworkView getNoNetworkView() {
        return this.f19091g;
    }

    public String getTitle() {
        return this.E;
    }

    public final void h() {
        f.g gVar;
        if (this.x == null) {
            this.f19092h.setVisibility(8);
        } else if (this.z != null && (gVar = this.y) != null) {
            if (gVar.f59696c == null) {
                this.f19092h.setVisibility(8);
            } else if (this.B == null && this.A == null) {
                this.f19092h.setVisibility(8);
            } else if (this.M && ListUtils.isEmpty(this.B.f59671a)) {
                this.f19092h.setVisibility(8);
            } else {
                this.f19092h.setVisibility(0);
                n();
                o();
                p();
                m();
            }
        } else {
            this.f19092h.setVisibility(8);
        }
    }

    public final void i(List<f.d> list, int i2, b bVar) {
        f.d dVar;
        if (list == null || i2 >= list.size() || bVar == null || (dVar = list.get(i2)) == null) {
            return;
        }
        if (i2 == 0) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_up_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_up_n);
            }
            bVar.f19100g.setVisibility(0);
        } else if (i2 == list.size() - 1) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_down_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_down_n);
            }
            bVar.f19100g.setVisibility(8);
        } else {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_center_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f19094a, R.drawable.bg_pay_list_center_n);
            }
            bVar.f19100g.setVisibility(0);
        }
    }

    public final void j(long j, long j2, long j3, int i2) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.N.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.f19089e.getReferPage(), this.f19089e.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.f19089e.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i2);
        if (this.f19089e.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.f19089e.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        d.c().a(payConfig, this.f19089e.getPageContext().getPageActivity());
    }

    public void k(int i2) {
        if (i2 < 0 || i2 > 2) {
            return;
        }
        this.J = i2;
        h();
    }

    public String l(String str, int i2) {
        if (str.length() > i2) {
            return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public final void m() {
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

    public final void n() {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Boolean bool = Boolean.FALSE;
        if (2 != this.J ? (cVar = this.A) == null || (list = cVar.f59678a) == null : (aVar = this.B) == null || (list = aVar.f59671a) == null) {
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
            if (dVar != null && dVar.j >= 0) {
                if (dVar.n == 1) {
                    bool = Boolean.TRUE;
                }
                b bVar = new b();
                View inflate = LayoutInflater.from(this.f19089e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                bVar.f19095b = (TextView) inflate.findViewById(R.id.cb);
                bVar.f19096c = (TextView) inflate.findViewById(R.id.tv_month);
                bVar.f19097d = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                bVar.f19098e = (TextView) inflate.findViewById(R.id.tv_discount);
                bVar.f19099f = (TextView) inflate.findViewById(R.id.tv_money);
                bVar.f19094a = (RelativeLayout) inflate.findViewById(R.id.root);
                bVar.f19100g = inflate.findViewById(R.id.v_line);
                bVar.f19096c.setText(l(dVar.f59684b, 7));
                if (!TextUtils.isEmpty(dVar.f59687e)) {
                    bVar.f19097d.setVisibility(0);
                    bVar.f19097d.V(dVar.f59687e, 10, false);
                }
                if (TextUtils.isEmpty(dVar.f59685c)) {
                    bVar.f19098e.setVisibility(8);
                } else {
                    bVar.f19098e.setVisibility(0);
                    bVar.f19098e.setText(l(dVar.f59685c, 10));
                }
                bVar.f19099f.setText("¥" + (dVar.j / 100));
                if (dVar.m) {
                    SkinManager.setBackgroundResource(bVar.f19095b, R.drawable.btn_non_orange_s);
                    SkinManager.setViewTextColor(bVar.f19095b, R.color.CAM_X0101);
                } else {
                    SkinManager.setBackgroundResource(bVar.f19095b, R.drawable.btn_non_orange_n);
                    SkinManager.setViewTextColor(bVar.f19095b, R.color.CAM_X0305);
                }
                bVar.f19095b.setTag(dVar);
                bVar.f19095b.setText(R.string.click_open);
                inflate.setContentDescription(l(dVar.f59684b, 7));
                inflate.setOnClickListener(new c(list));
                inflate.setTag(bVar);
                inflate.setLayoutParams(layoutParams);
                d.a.i0.s0.a.a(this.f19089e.getPageContext(), inflate);
                i(list, i2, bVar);
                this.l.addView(inflate);
            }
        }
        if (bool.booleanValue()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f19089e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
            this.m = linearLayout;
            this.n = (TextView) linearLayout.findViewById(R.id.tv_member_agreement_auto_pay);
            this.o = this.m.findViewById(R.id.view_agreement_divider_auto_pay);
            this.p = (TextView) this.m.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
            this.n.setOnClickListener(this.f19089e);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204_1);
            }
            this.p.setOnClickListener(this.f19089e);
            this.l.addView(this.m);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.f19089e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
        this.m = linearLayout2;
        TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_member_agreement_normal);
        this.n = textView;
        textView.setOnClickListener(this.f19089e);
        this.l.addView(this.m);
    }

    public final void o() {
        f.c cVar;
        this.j.setText(l(this.C, this.I));
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
        if (k.isEmpty(this.B.f59675e)) {
            SkinManager.setImageResource(this.t, R.drawable.icon_vip_advanced, 0);
        } else {
            this.t.V(this.B.f59675e, 10, false);
        }
        if (!this.M && (cVar = this.A) != null && !ListUtils.isEmpty(cVar.f59678a)) {
            this.k.setVisibility(0);
            this.k.setText(l(this.D, this.I));
            this.u.setVisibility(0);
            if (k.isEmpty(this.A.f59682e)) {
                SkinManager.setImageResource(this.u, R.drawable.icon_vip_member, 0);
            } else {
                this.u.V(this.A.f59682e, 21, false);
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

    public final void p() {
        String string;
        int i2 = this.J;
        if (2 == i2) {
            if (this.K == 2) {
                string = this.f19089e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.C});
            } else {
                string = this.f19089e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.C});
            }
            this.F = this.C;
        } else if (1 == i2) {
            long j = this.K;
            if (j == 1) {
                string = this.f19089e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.D});
            } else {
                string = j == 0 ? this.f19089e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D}) : null;
            }
            this.F = this.D;
        } else {
            string = this.f19089e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D});
            this.F = this.D;
        }
        this.E = string;
        if (StringUtils.isNULL(string)) {
            return;
        }
        this.f19090f.setTitleText(l(string, 10));
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.f19092h.setVisibility(8);
            return;
        }
        this.x = fVar;
        d();
        k(this.J);
    }
}
