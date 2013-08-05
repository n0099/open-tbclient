package com.baidu.tieba.kn.pk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected s f1210a;
    public com.baidu.tieba.kn.pk.widget.b b;
    ImageView c;
    private BdPullRefreshScrollView d;
    private PKEndActivity e;
    private ProgressBar f;
    private ImageView g;
    private TextView h;
    private long i;
    private long j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private LinearLayout u;
    private LinearLayout v;

    public ProgressBar a() {
        return this.f;
    }

    public ImageView b() {
        return this.g;
    }

    public c(PKEndActivity pKEndActivity, String str) {
        this.e = pKEndActivity;
        this.d = (BdPullRefreshScrollView) pKEndActivity.findViewById(R.id.pullScrollView);
        this.d.setOnPullDownListener(pKEndActivity);
        this.b = new com.baidu.tieba.kn.pk.widget.b(pKEndActivity, pKEndActivity);
        this.f = (ProgressBar) pKEndActivity.findViewById(R.id.progress);
        this.h = (TextView) pKEndActivity.findViewById(R.id.title_text);
        if (str != null) {
            this.h.setText(str);
        }
        c();
    }

    protected void c() {
        View findViewById = this.e.findViewById(R.id.title);
        this.g = (ImageView) this.e.findViewById(R.id.back);
        this.g.setOnClickListener(this.e);
        ((ImageView) this.e.findViewById(R.id.share_weixin)).setOnClickListener(this.e);
        ((ImageView) this.e.findViewById(R.id.share_qqfriend)).setOnClickListener(this.e);
        ((ImageView) this.e.findViewById(R.id.share_qqzone)).setOnClickListener(this.e);
        ((ImageView) this.e.findViewById(R.id.share_sina)).setOnClickListener(this.e);
        ah.a(this.g, 0);
        ah.a((ImageView) this.e.findViewById(R.id.home), 0);
        ah.d(findViewById, 0);
        ah.f(this.h, 0);
        this.c = (ImageView) this.e.findViewById(R.id.cmd_folder);
        this.c.setOnClickListener(this);
        this.k = (TextView) this.e.findViewById(R.id.pk_res_left_un);
        this.l = (TextView) this.e.findViewById(R.id.pk_res_left_vote);
        this.m = (TextView) this.e.findViewById(R.id.pk_res_left_unum);
        this.n = (TextView) this.e.findViewById(R.id.pk_res_left_uvote);
        this.o = (ImageView) this.e.findViewById(R.id.pk_res_left_icon);
        this.p = (TextView) this.e.findViewById(R.id.pk_res_right_un);
        this.q = (TextView) this.e.findViewById(R.id.pk_res_right_vote);
        this.r = (TextView) this.e.findViewById(R.id.pk_res_right_unum);
        this.s = (TextView) this.e.findViewById(R.id.pk_res_right_uvote);
        this.t = (ImageView) this.e.findViewById(R.id.pk_res_right_icon);
        this.u = (LinearLayout) this.e.findViewById(R.id.pk_res_left_lay);
        this.v = (LinearLayout) this.e.findViewById(R.id.pk_res_right_lay);
        int a2 = (am.a((Context) this.e) - am.a((Context) this.e, 40.0f)) / 2;
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.width = a2;
        this.u.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
        layoutParams2.width = a2;
        this.v.setLayoutParams(layoutParams2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c && !this.b.a()) {
            if (this.b.g()) {
                this.c.setImageResource(R.drawable.icon_pk_upward_selector);
                this.b.e();
                return;
            }
            this.c.setImageResource(R.drawable.icon_pk_downward_selector);
            this.b.f();
        }
    }

    public void a(com.baidu.tieba.util.a aVar, s sVar) {
        com.baidu.adp.widget.a.b a2;
        com.baidu.adp.widget.a.b a3;
        this.f.setVisibility(8);
        this.d.c();
        if (sVar.a()) {
            this.d.setVisibility(0);
            this.e.a(sVar.b());
            return;
        }
        this.f1210a = sVar;
        this.h.setText(this.f1210a.c());
        this.b.a(this.f1210a.b);
        this.b.a("PK规则", this.f1210a.c);
        this.b.a(String.valueOf(sVar.j.e) + this.e.getString(R.string.forum), sVar.j.g, this.e);
        this.b.b(String.valueOf(sVar.k.e) + this.e.getString(R.string.forum), sVar.k.g, this.e);
        this.i = this.f1210a.j.h;
        this.j = this.f1210a.k.h;
        d();
        String str = sVar.j.c;
        if (str != null && (a3 = aVar.a(str, new d(this, str))) != null) {
            this.b.a(a3.f());
        }
        String str2 = sVar.k.c;
        if (str2 != null && (a2 = aVar.a(str2, new e(this, str2))) != null) {
            this.b.b(a2.f());
        }
        this.k.setText(sVar.j.b);
        this.l.setText(sVar.j.h + "票");
        this.m.setText(sVar.j.i + "人投票");
        if (sVar.j.i > 0) {
            this.n.setText("人均投票数：" + Math.round((sVar.j.h * 1.0d) / sVar.j.i) + "票");
        } else {
            this.n.setVisibility(8);
        }
        this.p.setText(sVar.k.b);
        this.q.setText(sVar.k.h + "票");
        this.r.setText(sVar.k.i + "人投票");
        if (sVar.k.i > 0) {
            this.s.setText("人均投票数：" + Math.round((sVar.k.h * 1.0d) / sVar.k.i) + "票");
        } else {
            this.s.setVisibility(8);
        }
        if (sVar.i.equals(sVar.j.f1243a)) {
            this.l.setTextColor(-13135118);
            this.q.setTextColor(-691656);
            this.o.setImageResource(R.drawable.icon_crown_s);
            this.t.setImageResource(R.drawable.icon_crown_d);
        } else if (sVar.i.equals(sVar.k.f1243a)) {
            this.l.setTextColor(-691656);
            this.q.setTextColor(-13135118);
            this.o.setImageResource(R.drawable.icon_crown_d);
            this.t.setImageResource(R.drawable.icon_crown_s);
        }
        this.b.d();
        this.d.setVisibility(0);
    }

    protected void d() {
        this.b.a(this.i);
        this.b.b(this.j);
    }

    public void e() {
        this.f.setVisibility(8);
        this.d.c();
        this.d.setVisibility(0);
    }
}
