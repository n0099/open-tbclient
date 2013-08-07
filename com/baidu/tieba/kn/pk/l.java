package com.baidu.tieba.kn.pk;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.util.ah;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected s f1217a;
    public com.baidu.tieba.kn.pk.widget.b b;
    ImageView c;
    private BdPullRefreshScrollView d;
    private PKWaitingActivity e;
    private ProgressBar f;
    private ImageView g;
    private TextView h;

    public ProgressBar a() {
        return this.f;
    }

    public ImageView b() {
        return this.g;
    }

    public l(PKWaitingActivity pKWaitingActivity, String str) {
        this.e = pKWaitingActivity;
        this.d = (BdPullRefreshScrollView) pKWaitingActivity.findViewById(R.id.pullScrollView);
        this.d.setOnPullDownListener(pKWaitingActivity);
        this.b = new com.baidu.tieba.kn.pk.widget.b(pKWaitingActivity, pKWaitingActivity);
        this.b.b();
        this.f = (ProgressBar) pKWaitingActivity.findViewById(R.id.progress);
        this.h = (TextView) pKWaitingActivity.findViewById(R.id.title_text);
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
        this.f1217a = sVar;
        this.h.setText(this.f1217a.c());
        this.b.a(this.f1217a.b);
        this.b.a("PK规则", this.f1217a.c);
        this.b.a(String.valueOf(sVar.j.e) + this.e.getString(R.string.forum), sVar.j.g, this.e);
        this.b.b(String.valueOf(sVar.k.e) + this.e.getString(R.string.forum), sVar.k.g, this.e);
        d();
        String str = sVar.j.c;
        if (str != null && (a3 = aVar.a(str, new m(this, str))) != null) {
            this.b.a(a3.f());
        }
        String str2 = sVar.k.c;
        if (str2 != null && (a2 = aVar.a(str2, new n(this, str2))) != null) {
            this.b.b(a2.f());
        }
        this.d.setVisibility(0);
    }

    protected void d() {
        this.b.a(0L);
        this.b.b(0L);
    }

    public void e() {
        this.f.setVisibility(8);
        this.d.c();
        this.d.setVisibility(0);
    }
}
