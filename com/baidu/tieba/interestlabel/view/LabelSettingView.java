package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.i0.d0.g;
import d.a.i0.d0.h;
import d.a.i0.r.s.a;
/* loaded from: classes4.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f18531e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f18532f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.h1.c.a f18533g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f18534h;

    /* renamed from: i  reason: collision with root package name */
    public View f18535i;
    public TextView j;
    public NoNetworkView k;
    public GridLineView l;
    public g m;
    public h n;
    public d.a.j0.h1.a.b o;
    public d.a.i0.r.s.a p;
    public boolean q;
    public NoNetworkView.b r;

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z && LabelSettingView.this.o.getCount() == 0 && LabelSettingView.this.f18533g != null) {
                LabelSettingView.this.f18533g.getLabel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            LabelSettingView.this.f18532f.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || LabelSettingView.this.f18533g == null) {
                return;
            }
            LabelSettingView.this.f18533g.getLabel();
        }
    }

    public LabelSettingView(TbPageContext<?> tbPageContext, d.a.j0.h1.c.a aVar) {
        super(tbPageContext.getPageActivity());
        this.f18531e = 3;
        this.r = new a();
        this.f18532f = tbPageContext;
        this.f18533g = aVar;
        i(tbPageContext.getPageActivity());
        l();
    }

    public void d(boolean z) {
        this.q = z;
        this.j.setSelected(z);
    }

    public void e() {
        NoNetworkView noNetworkView = this.k;
        if (noNetworkView != null) {
            noNetworkView.d(this.r);
        }
        this.p.dismiss();
        g();
        h();
    }

    public boolean f() {
        d.a.j0.h1.a.b bVar = this.o;
        if (bVar == null) {
            return false;
        }
        return !ListUtils.equalList(bVar.f(), this.o.g());
    }

    public void g() {
        g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this);
            this.m = null;
        }
    }

    public void h() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this);
            this.n = null;
        }
    }

    public final void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.f18534h = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.k = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.l = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.f18534h.setTitleText(context.getString(R.string.choose_interest_label));
        this.f18535i = this.f18534h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.j = (TextView) this.f18534h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.k.a(this.r);
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f18532f.getPageActivity());
        this.p = aVar;
        aVar.setMessage(this.f18532f.getString(R.string.confirm_give_up_label));
        this.p.setPositiveButton(this.f18532f.getString(R.string.alert_yes_button), new b());
        this.p.setNegativeButton(this.f18532f.getString(R.string.cancel), new c());
        this.p.create(this.f18532f);
        d.a.j0.h1.a.b bVar = new d.a.j0.h1.a.b(this);
        this.o = bVar;
        this.l.setAdapter((ListAdapter) bVar);
    }

    public boolean j() {
        g gVar = this.m;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean k() {
        h hVar = this.n;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void l() {
        NoNetworkView noNetworkView;
        NavigationBar navigationBar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f18531e) {
            return;
        }
        this.f18531e = skinType;
        TbPageContext<?> tbPageContext = this.f18532f;
        if (tbPageContext != null && (navigationBar = this.f18534h) != null) {
            navigationBar.onChangeSkinType(tbPageContext, skinType);
        }
        TextView textView = this.j;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.drawable.color_nav_complete_selector);
        }
        TbPageContext<?> tbPageContext2 = this.f18532f;
        if (tbPageContext2 != null && (noNetworkView = this.k) != null) {
            noNetworkView.c(tbPageContext2, this.f18531e);
        }
        GridLineView gridLineView = this.l;
        if (gridLineView != null) {
            gridLineView.d();
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.j0.h1.a.b bVar = this.o;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        setBackgroundColor(SkinManager.getColor(this.f18531e, R.color.CAM_X0205));
    }

    public void m() {
        this.p.show();
    }

    public void n(boolean z) {
        if (j()) {
            return;
        }
        if (this.m == null) {
            g gVar = new g(getContext());
            this.m = gVar;
            gVar.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void o(boolean z) {
        if (k()) {
            return;
        }
        if (this.n == null) {
            this.n = new h(getContext(), new d());
        }
        this.n.j(this.f18532f.getResources().getDimensionPixelSize(R.dimen.ds380));
        this.n.attachView(this, z);
        this.n.o();
        this.l.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f18535i) {
            if (f()) {
                m();
            } else {
                this.f18532f.getPageActivity().finish();
            }
        } else if (view == this.j && this.f18533g != null && this.q) {
            TiebaStatic.log(new StatisticItem("c12237").param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.f18533g.subLabel(this.o.g());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public void setData(d.a.j0.h1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.l.setVisibility(0);
        this.o.h(bVar);
        this.o.notifyDataSetChanged();
    }
}
