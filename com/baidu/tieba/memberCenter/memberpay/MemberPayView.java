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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.q1.f.f;
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
    public MemberPayActivity f18980e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f18981f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f18982g;

    /* renamed from: h  reason: collision with root package name */
    public View f18983h;
    public RadioGroup i;
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
        public RelativeLayout f18984a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18985b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18986c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f18987d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18988e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18989f;

        /* renamed from: g  reason: collision with root package name */
        public View f18990g;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public List<f.d> f18991e;

        public c(List<f.d> list) {
            this.f18991e = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            if (MemberPayView.this.l == null) {
                return;
            }
            f.d dVar = null;
            for (int i = 0; i < MemberPayView.this.l.getChildCount(); i++) {
                View childAt = MemberPayView.this.l.getChildAt(i);
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
                    MemberPayView.this.i(this.f18991e, i, (b) childAt.getTag());
                }
            }
            if (dVar == null) {
                return;
            }
            if (dVar.n != 1 || !dVar.o) {
                MemberPayView.this.j(dVar.i, dVar.j / 100, dVar.l, dVar.n);
            } else {
                l.K(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
            }
        }
    }

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.I = 12;
        this.J = 2;
        this.M = false;
        this.N = Boolean.FALSE;
        this.f18980e = memberPayActivity;
        this.L = i;
        this.N = Boolean.valueOf(z);
        e();
    }

    public final void d() {
        f.e eVar;
        f fVar = this.x;
        if (fVar == null) {
            return;
        }
        f.b bVar = fVar.f59405b;
        this.z = bVar;
        f.g gVar = fVar.f59404a;
        this.y = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f59430c) == null) {
            return;
        }
        long j = eVar.f59426a;
        this.K = j;
        this.M = j == 2 || this.L == 2;
        f.b bVar2 = this.z;
        f.a aVar = bVar2.f59412b;
        this.B = aVar;
        if (aVar == null) {
            return;
        }
        this.C = aVar.f59408c;
        this.G = aVar.f59409d;
        String str = aVar.f59410e;
        f.c cVar = bVar2.f59411a;
        this.A = cVar;
        if (cVar == null) {
            return;
        }
        this.D = cVar.f59415c;
        this.H = cVar.f59416d;
        String str2 = cVar.f59417e;
    }

    public final void e() {
        this.f18980e.setContentView(R.layout.member_pay_activity);
        this.f18983h = this.f18980e.findViewById(R.id.root);
        NavigationBar navigationBar = (NavigationBar) this.f18980e.findViewById(R.id.navigationbar);
        this.f18981f = navigationBar;
        navigationBar.setTitleText("");
        this.f18981f.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18982g = (NoNetworkView) this.f18980e.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f18980e.findViewById(R.id.container);
        RadioGroup radioGroup = (RadioGroup) this.f18980e.findViewById(R.id.btns_mem_select);
        this.i = radioGroup;
        radioGroup.setOnCheckedChangeListener(this.f18980e);
        this.j = (RadioButton) this.f18980e.findViewById(R.id.btn_mem1);
        this.k = (RadioButton) this.f18980e.findViewById(R.id.btn_mem2);
        this.q = this.f18980e.findViewById(R.id.v_blank);
        this.s = (TextView) this.f18980e.findViewById(R.id.goods_des);
        this.t = (TbImageView) this.f18980e.findViewById(R.id.bdimg_adv);
        this.u = (TbImageView) this.f18980e.findViewById(R.id.bdimg_comm);
        this.v = (ImageView) this.f18980e.findViewById(R.id.crumb_adv);
        this.w = (ImageView) this.f18980e.findViewById(R.id.crumb_comm);
        TextView textView = (TextView) this.f18980e.findViewById(R.id.aotu_pay_law);
        this.r = textView;
        textView.setOnClickListener(this.f18980e);
    }

    public void f(int i) {
        this.f18980e.getLayoutMode().k(i == 1);
        this.f18980e.getLayoutMode().j(this.f18983h);
        this.f18981f.onChangeSkinType(this.f18980e.getPageContext(), i);
        this.f18982g.c(this.f18980e.getPageContext(), i);
    }

    public void g(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        if (this.x == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.J ? !((cVar = this.A) == null || (list = cVar.f59413a) == null) : !((aVar = this.B) == null || (list = aVar.f59406a) == null)) {
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
        return this.F;
    }

    public int getCurrentShowType() {
        return this.J;
    }

    public NoNetworkView getNoNetworkView() {
        return this.f18982g;
    }

    public String getTitle() {
        return this.E;
    }

    public final void h() {
        f.g gVar;
        if (this.x == null) {
            this.f18983h.setVisibility(8);
        } else if (this.z != null && (gVar = this.y) != null) {
            if (gVar.f59430c == null) {
                this.f18983h.setVisibility(8);
            } else if (this.B == null && this.A == null) {
                this.f18983h.setVisibility(8);
            } else if (this.M && ListUtils.isEmpty(this.B.f59406a)) {
                this.f18983h.setVisibility(8);
            } else {
                this.f18983h.setVisibility(0);
                n();
                o();
                p();
                m();
            }
        } else {
            this.f18983h.setVisibility(8);
        }
    }

    public final void i(List<f.d> list, int i, b bVar) {
        f.d dVar;
        if (list == null || i >= list.size() || bVar == null || (dVar = list.get(i)) == null) {
            return;
        }
        if (i == 0) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_up_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_up_n);
            }
            bVar.f18990g.setVisibility(0);
        } else if (i == list.size() - 1) {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_down_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_down_n);
            }
            bVar.f18990g.setVisibility(8);
        } else {
            if (dVar.m) {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_center_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f18984a, R.drawable.bg_pay_list_center_n);
            }
            bVar.f18990g.setVisibility(0);
        }
    }

    public final void j(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.N.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.f18980e.getReferPage(), this.f18980e.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.f18980e.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.f18980e.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.f18980e.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        d.b.h0.l0.c.c().a(payConfig, this.f18980e.getPageContext().getPageActivity());
    }

    public void k(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.J = i;
        h();
    }

    public String l(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public final void m() {
        int i = this.J;
        if (2 == i) {
            if (!k.isEmpty(this.G)) {
                this.s.setText(this.G);
                this.v.setVisibility(0);
                this.w.setVisibility(4);
                return;
            }
            this.v.setVisibility(4);
            this.w.setVisibility(4);
        } else if (1 == i) {
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
        if (2 != this.J ? (cVar = this.A) == null || (list = cVar.f59413a) == null : (aVar = this.B) == null || (list = aVar.f59406a) == null) {
            list = null;
        }
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.l.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        for (int i = 0; i < list.size(); i++) {
            f.d dVar = list.get(i);
            if (dVar != null && dVar.j >= 0) {
                if (dVar.n == 1) {
                    bool = Boolean.TRUE;
                }
                b bVar = new b();
                View inflate = LayoutInflater.from(this.f18980e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                bVar.f18985b = (TextView) inflate.findViewById(R.id.cb);
                bVar.f18986c = (TextView) inflate.findViewById(R.id.tv_month);
                bVar.f18987d = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                bVar.f18988e = (TextView) inflate.findViewById(R.id.tv_discount);
                bVar.f18989f = (TextView) inflate.findViewById(R.id.tv_money);
                bVar.f18984a = (RelativeLayout) inflate.findViewById(R.id.root);
                bVar.f18990g = inflate.findViewById(R.id.v_line);
                bVar.f18986c.setText(l(dVar.f59419b, 7));
                if (!TextUtils.isEmpty(dVar.f59422e)) {
                    bVar.f18987d.setVisibility(0);
                    bVar.f18987d.W(dVar.f59422e, 10, false);
                }
                if (TextUtils.isEmpty(dVar.f59420c)) {
                    bVar.f18988e.setVisibility(8);
                } else {
                    bVar.f18988e.setVisibility(0);
                    bVar.f18988e.setText(l(dVar.f59420c, 10));
                }
                bVar.f18989f.setText("¥" + (dVar.j / 100));
                if (dVar.m) {
                    SkinManager.setBackgroundResource(bVar.f18985b, R.drawable.btn_non_orange_s);
                    SkinManager.setViewTextColor(bVar.f18985b, R.color.CAM_X0101);
                } else {
                    SkinManager.setBackgroundResource(bVar.f18985b, R.drawable.btn_non_orange_n);
                    SkinManager.setViewTextColor(bVar.f18985b, R.color.CAM_X0305);
                }
                bVar.f18985b.setTag(dVar);
                bVar.f18985b.setText(R.string.click_open);
                inflate.setContentDescription(l(dVar.f59419b, 7));
                inflate.setOnClickListener(new c(list));
                inflate.setTag(bVar);
                inflate.setLayoutParams(layoutParams);
                d.b.h0.s0.a.a(this.f18980e.getPageContext(), inflate);
                i(list, i, bVar);
                this.l.addView(inflate);
            }
        }
        if (bool.booleanValue()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f18980e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
            this.m = linearLayout;
            this.n = (TextView) linearLayout.findViewById(R.id.tv_member_agreement_auto_pay);
            this.o = this.m.findViewById(R.id.view_agreement_divider_auto_pay);
            this.p = (TextView) this.m.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
            this.n.setOnClickListener(this.f18980e);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204_1);
            }
            this.p.setOnClickListener(this.f18980e);
            this.l.addView(this.m);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.f18980e.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
        this.m = linearLayout2;
        TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_member_agreement_normal);
        this.n = textView;
        textView.setOnClickListener(this.f18980e);
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
        if (k.isEmpty(this.B.f59410e)) {
            SkinManager.setImageResource(this.t, R.drawable.icon_vip_advanced, 0);
        } else {
            this.t.W(this.B.f59410e, 10, false);
        }
        if (!this.M && (cVar = this.A) != null && !ListUtils.isEmpty(cVar.f59413a)) {
            this.k.setVisibility(0);
            this.k.setText(l(this.D, this.I));
            this.u.setVisibility(0);
            if (k.isEmpty(this.A.f59417e)) {
                SkinManager.setImageResource(this.u, R.drawable.icon_vip_member, 0);
            } else {
                this.u.W(this.A.f59417e, 21, false);
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
        int i = this.J;
        if (2 == i) {
            if (this.K == 2) {
                string = this.f18980e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.C});
            } else {
                string = this.f18980e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.C});
            }
            this.F = this.C;
        } else if (1 == i) {
            long j = this.K;
            if (j == 1) {
                string = this.f18980e.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.D});
            } else {
                string = j == 0 ? this.f18980e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D}) : null;
            }
            this.F = this.D;
        } else {
            string = this.f18980e.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.D});
            this.F = this.D;
        }
        this.E = string;
        if (StringUtils.isNULL(string)) {
            return;
        }
        this.f18981f.setTitleText(l(string, 10));
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.f18983h.setVisibility(8);
            return;
        }
        this.x = fVar;
        d();
        k(this.J);
    }
}
