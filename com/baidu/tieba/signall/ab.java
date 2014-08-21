package com.baidu.tieba.signall;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.f {
    public static int a;
    private BaseActivity b;
    private NavigationBar c;
    private RelativeLayout d;
    private x e;
    private ProgressBar f;
    private BdListView g;
    private com.baidu.tbadk.core.view.v h;
    private o i;
    private b j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private TextView o;

    public ab(BaseActivity baseActivity) {
        super(baseActivity);
        this.h = null;
        this.b = baseActivity;
        this.b.setContentView(com.baidu.tieba.v.signallforum_view);
        this.d = (RelativeLayout) this.b.findViewById(com.baidu.tieba.u.sign_all_forum_parent);
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(this.b.getString(com.baidu.tieba.x.signallforum));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ac(this));
        this.g = (BdListView) this.b.findViewById(com.baidu.tieba.u.signallforum_list);
        this.g.setOnItemClickListener(baseActivity);
        this.h = new com.baidu.tbadk.core.view.v(baseActivity);
        this.g.setPullRefresh(this.h);
        this.o = (TextView) com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.signallforum_maxcount_warning, null);
        this.g.addFooterView(this.o);
        this.e = new x(this.b);
        this.f = this.e.getProgressBar();
        this.f.setOnClickListener(this.b);
        this.g.addHeaderView(this.e);
        this.e.setVisibility(8);
        this.k = (RelativeLayout) this.e.findViewById(com.baidu.tieba.u.guidecontainer);
        this.n = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.guideopenbtn);
        this.l = (TextView) this.e.findViewById(com.baidu.tieba.u.guidetip);
        this.m = (TextView) this.e.findViewById(com.baidu.tieba.u.guideopen);
        this.n.setOnClickListener(this.b);
        this.i = new o(this.b, null);
        this.g.setAdapter((ListAdapter) this.i);
        this.g.setOnScrollListener(this.i);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.d);
        this.b.getLayoutMode().a(this.o);
        this.b.getLayoutMode().a((View) this.e);
        if (i == 1) {
            this.d.setBackgroundColor(TbadkApplication.m252getInst().getResources().getColor(com.baidu.tieba.r.square_image_default_background_1));
        } else {
            this.d.setBackgroundColor(TbadkApplication.m252getInst().getResources().getColor(com.baidu.tieba.r.square_listview_bg));
        }
        this.c.c(i);
        this.h.a(i);
        this.i.notifyDataSetChanged();
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.j = bVar;
            i();
            ArrayList<d> i = bVar.i();
            this.i.a(this.j);
            if (i.size() == a) {
                this.o.setVisibility(0);
                this.o.setText(bVar.f());
                return;
            }
            this.o.setVisibility(8);
        }
    }

    private void i() {
        if (this.j != null) {
            this.e.setHasPrivilege(this.j.m());
            this.e.setmCurrentStatus(this.j.p());
            TextView message1 = this.e.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.j.b()) + this.j.c() + this.j.d());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.m252getInst().getResources().getColor(com.baidu.tieba.r.sign_all_forum_text_color));
            int length = this.j.b().length();
            spannableString.setSpan(foregroundColorSpan, length, this.j.c().length() + length, 33);
            message1.setText(spannableString);
            this.e.getMessage2().setText(this.j.e());
            this.l.setText(this.j.o());
            if (TextUtils.isEmpty(this.j.n())) {
                this.m.setText(com.baidu.tieba.x.sign_all_forum_memberbtn_content);
            } else {
                this.m.setText(this.j.n());
            }
            this.e.setVisibility(0);
            if (this.j.m()) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
        }
    }

    public void a() {
        this.g.e();
    }

    public void b() {
        this.g.d();
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.h.a(dVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.g.setOnItemClickListener(onItemClickListener);
    }

    public x c() {
        return this.e;
    }

    public ProgressBar d() {
        return this.f;
    }

    public BdListView e() {
        return this.g;
    }

    public b f() {
        return this.j;
    }

    public o g() {
        return this.i;
    }

    public LinearLayout h() {
        return this.n;
    }
}
