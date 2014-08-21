package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    private BaseActivity a;
    private r b;
    private NavigationBar c;
    private AlertDialog d;
    private SettingTextImageView e;
    private TbSettingTextTipView f;
    private TbSettingTextTipView g;
    private TbSettingTextTipView h;
    private TbSettingTextTipView i;
    private SettingTextVersionView j;
    private TbSettingTextTipView k;
    private TbSettingTextTipView l;
    private View m;
    private TbSettingTextNewDotView n;
    private TbSettingTextTipView o;
    private RelativeLayout p;
    private View q;

    public ac(BaseActivity baseActivity, r rVar) {
        super(baseActivity);
        this.a = baseActivity;
        this.b = rVar;
        this.a.setContentView(com.baidu.tieba.v.more_activity);
        e();
    }

    public void a() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
    }

    public void a(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.e != null) {
                this.e.a();
                return;
            }
            return;
        }
        this.e.b();
        this.e.a(str, z);
    }

    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        if (this.n != null) {
            this.n.a();
        }
    }

    public void c() {
        this.e.c();
        this.f.d();
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        this.l.d();
        this.o.d();
    }

    public void a(int i) {
        b(i);
    }

    public void b(int i) {
        this.c.c(i);
        this.e.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.p);
        this.c.c(i);
        b();
    }

    private void e() {
        View.OnClickListener g = g();
        this.p = (RelativeLayout) this.a.findViewById(com.baidu.tieba.u.parent);
        this.c = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.q = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.a.getString(com.baidu.tieba.x.setup));
        this.e = (SettingTextImageView) this.a.findViewById(com.baidu.tieba.u.personInfo);
        this.f = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.accountManager);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.browseSetting);
        this.h = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.messageSetting);
        this.i = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.secretSetting);
        this.j = (SettingTextVersionView) this.a.findViewById(com.baidu.tieba.u.versionInfo);
        this.k = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.feedBack);
        this.l = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.recommend);
        this.m = this.a.findViewById(com.baidu.tieba.u.line_recommend_layout);
        if (!com.baidu.tieba.ai.c().n()) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
        }
        this.n = (TbSettingTextNewDotView) this.a.findViewById(com.baidu.tieba.u.systemhelpsetting);
        this.o = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.quit);
        b();
        a();
        this.e.a();
        b(TbadkApplication.m252getInst().getSkinType());
        a(g);
        f();
    }

    private void f() {
        View a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.quit_dialog, null);
        ((LinearLayout) a.findViewById(com.baidu.tieba.u.id_close_ll)).setOnClickListener(new ad(this));
        ((LinearLayout) a.findViewById(com.baidu.tieba.u.id_quit_ll)).setOnClickListener(new ae(this));
        this.d = new AlertDialog.Builder(this.mContext).create();
        this.d.setView(a, 0, 0, 0, 0);
    }

    private void a(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.n.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
    }

    private View.OnClickListener g() {
        return new af(this);
    }

    public void d() {
        if (this.d != null) {
            com.baidu.adp.lib.e.e.a(this.d, this.a);
        }
    }
}
