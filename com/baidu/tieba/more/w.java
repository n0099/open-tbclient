package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class w extends com.baidu.adp.a.f {
    private com.baidu.tbadk.a a;
    private p c;
    private com.baidu.tbadk.editortool.ab d;
    private NavigationBar e;
    private AlertDialog f;
    private SettingTextImageView g;
    private TbSettingTextTipView h;
    private TbSettingTextTipView i;
    private TbSettingTextTipView j;
    private TbSettingTextTipView k;
    private SettingTextVersionView l;
    private TbSettingTextTipView m;
    private TbSettingTextTipView n;
    private View o;
    private TbSettingTextTipView p;
    private TbSettingTextTipView q;
    private RelativeLayout r;
    private View s;

    public w(com.baidu.tbadk.a aVar, p pVar) {
        super(aVar);
        this.a = aVar;
        this.c = pVar;
        this.a.setContentView(com.baidu.tieba.a.i.more_activity);
        z zVar = new z(this);
        this.r = (RelativeLayout) this.a.findViewById(com.baidu.tieba.a.h.parent);
        this.e = (NavigationBar) this.a.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.s = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(this.a.getString(com.baidu.tieba.a.k.setup));
        this.g = (SettingTextImageView) this.a.findViewById(com.baidu.tieba.a.h.personInfo);
        this.h = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.accountManager);
        this.i = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.browseSetting);
        this.j = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.messageSetting);
        this.k = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.secretSetting);
        this.l = (SettingTextVersionView) this.a.findViewById(com.baidu.tieba.a.h.versionInfo);
        this.m = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.feedBack);
        this.n = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.recommend);
        this.o = this.a.findViewById(com.baidu.tieba.a.h.line_recommend_layout);
        if (com.baidu.tieba.p.c().k()) {
            this.n.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
        }
        this.p = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.systemhelpsetting);
        this.q = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.quit);
        d();
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
        this.g.a();
        a(TbadkApplication.j().l());
        this.s.setOnClickListener(zVar);
        this.g.setOnClickListener(zVar);
        this.h.setOnClickListener(zVar);
        this.i.setOnClickListener(zVar);
        this.j.setOnClickListener(zVar);
        this.k.setOnClickListener(zVar);
        this.l.setOnClickListener(zVar);
        this.m.setOnClickListener(zVar);
        this.n.setOnClickListener(zVar);
        this.p.setOnClickListener(zVar);
        this.q.setOnClickListener(zVar);
        int dimensionPixelSize = b().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds42);
        SpannableString spannableString = new SpannableString(this.b.getString(com.baidu.tieba.a.k.close_tb));
        spannableString.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, 5, 33);
        spannableString.setSpan(new AbsoluteSizeSpan((dimensionPixelSize * 2) / 3), 5, spannableString.length(), 33);
        SpannableString spannableString2 = new SpannableString(this.b.getString(com.baidu.tieba.a.k.logout));
        spannableString2.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, 5, 33);
        spannableString2.setSpan(new AbsoluteSizeSpan((dimensionPixelSize * 2) / 3), 5, spannableString2.length(), 33);
        this.f = new AlertDialog.Builder(this.b).setItems(new CharSequence[]{spannableString, spannableString2}, new y(this)).create();
    }

    public final void a(String str) {
        if (str == null || str.length() <= 0) {
            if (this.g != null) {
                this.g.a();
                return;
            }
            return;
        }
        if (this.d == null) {
            this.d = new com.baidu.tbadk.editortool.ab(this.a);
        }
        this.g.b();
        a();
        com.baidu.tbadk.editortool.ab abVar = this.d;
        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(str);
        if (b != null) {
            this.g.setIcon(b);
            return;
        }
        com.baidu.adp.widget.ImageView.b a = this.d.a(str, new x(this));
        if (a != null) {
            this.g.setIcon(a);
        }
    }

    public final void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (this.g != null) {
            this.g.setIcon(bVar);
        }
    }

    public final void a() {
        if (this.g != null) {
            this.g.setIcon(com.baidu.tieba.a.g.person_photo);
        }
    }

    public final void b(String str) {
        if (this.d != null) {
            com.baidu.tbadk.editortool.ab abVar = this.d;
            com.baidu.tbadk.imageManager.e.a().a(str);
        }
    }

    public final void d() {
        if (this.l != null) {
            this.l.e();
        }
    }

    public final void e() {
        SettingTextImageView settingTextImageView = this.g;
        SettingTextImageView.c();
        TbSettingTextTipView tbSettingTextTipView = this.h;
        TbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = this.i;
        TbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView3 = this.j;
        TbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView4 = this.k;
        TbSettingTextTipView.c();
        SettingTextVersionView settingTextVersionView = this.l;
        SettingTextVersionView.c();
        TbSettingTextTipView tbSettingTextTipView5 = this.m;
        TbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView6 = this.n;
        TbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView7 = this.q;
        TbSettingTextTipView.c();
    }

    public final void a(int i) {
        this.e.b(i);
        this.g.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.r);
        this.e.b(i);
        d();
    }

    public final void f() {
        if (this.f != null) {
            this.f.show();
        }
    }
}
