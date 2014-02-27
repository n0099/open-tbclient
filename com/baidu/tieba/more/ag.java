package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ag extends com.baidu.adp.a.e {
    private com.baidu.tieba.f a;
    private ab c;
    private com.baidu.tieba.util.i d;
    private NavigationBar e;
    private SettingTextImageView f;
    private SettingTextTipView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextTipView j;
    private SettingTextVersionView k;
    private SettingTextTipView l;
    private SettingTextTipView m;
    private View n;
    private SettingTextTipView o;
    private RelativeLayout p;
    private ImageView q;

    public ag(com.baidu.tieba.f fVar, ab abVar) {
        super(fVar);
        this.a = fVar;
        this.c = abVar;
        this.a.setContentView(R.layout.more_activity);
        ai aiVar = new ai(this);
        this.p = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.a.getString(R.string.setup));
        this.q = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (SettingTextImageView) this.a.findViewById(R.id.personInfo);
        this.g = (SettingTextTipView) this.a.findViewById(R.id.accountManager);
        this.h = (SettingTextTipView) this.a.findViewById(R.id.browseSetting);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.messageSetting);
        this.j = (SettingTextTipView) this.a.findViewById(R.id.secretSetting);
        this.k = (SettingTextVersionView) this.a.findViewById(R.id.versionInfo);
        this.l = (SettingTextTipView) this.a.findViewById(R.id.feedBack);
        this.m = (SettingTextTipView) this.a.findViewById(R.id.recommend);
        this.n = this.a.findViewById(R.id.line_recommend_layout);
        if (TiebaApplication.g().s()) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
        this.o = (SettingTextTipView) this.a.findViewById(R.id.systemhelpsetting);
        d();
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        this.f.a();
        a(TiebaApplication.g().ae());
        this.q.setOnClickListener(aiVar);
        this.f.setOnClickListener(aiVar);
        this.g.setOnClickListener(aiVar);
        this.h.setOnClickListener(aiVar);
        this.i.setOnClickListener(aiVar);
        this.j.setOnClickListener(aiVar);
        this.k.setOnClickListener(aiVar);
        this.l.setOnClickListener(aiVar);
        this.m.setOnClickListener(aiVar);
        this.o.setOnClickListener(aiVar);
    }

    public final void a(String str) {
        if (str == null || str.length() <= 0) {
            if (this.f != null) {
                this.f.a();
                return;
            }
            return;
        }
        if (this.d == null) {
            this.d = new com.baidu.tieba.util.i(this.a);
        }
        this.f.b();
        a();
        com.baidu.tieba.util.i iVar = this.d;
        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(str);
        if (b != null) {
            this.f.setIcon(b);
            return;
        }
        com.baidu.adp.widget.ImageView.b a = this.d.a(str, new ah(this));
        if (a != null) {
            this.f.setIcon(a);
        }
    }

    public final void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (this.f != null) {
            this.f.setIcon(bVar);
        }
    }

    public final void a() {
        if (this.f != null) {
            this.f.setIcon(R.drawable.person_photo);
        }
    }

    public final void b(String str) {
        if (this.d != null) {
            com.baidu.tieba.util.i iVar = this.d;
            com.baidu.tbadk.imageManager.e.a().a(str);
        }
    }

    public final void d() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public final void e() {
        SettingTextImageView settingTextImageView = this.f;
        SettingTextImageView.c();
        SettingTextTipView settingTextTipView = this.g;
        SettingTextTipView.d();
        SettingTextTipView settingTextTipView2 = this.h;
        SettingTextTipView.d();
        SettingTextTipView settingTextTipView3 = this.i;
        SettingTextTipView.d();
        SettingTextTipView settingTextTipView4 = this.j;
        SettingTextTipView.d();
        SettingTextVersionView settingTextVersionView = this.k;
        SettingTextVersionView.d();
        SettingTextTipView settingTextTipView5 = this.l;
        SettingTextTipView.d();
        SettingTextTipView settingTextTipView6 = this.m;
        SettingTextTipView.d();
    }

    public final void a(int i) {
        this.e.b(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
        this.l.a(i);
        this.m.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.p);
        this.e.b(i);
        d();
        this.o.a(i);
    }
}
