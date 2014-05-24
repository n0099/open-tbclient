package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.c {
    private BaseActivity a;
    private p b;
    private com.baidu.tbadk.editortool.ab c;
    private NavigationBar d;
    private AlertDialog e;
    private SettingTextImageView f;
    private TbSettingTextTipView g;
    private TbSettingTextTipView h;
    private TbSettingTextTipView i;
    private TbSettingTextTipView j;
    private SettingTextVersionView k;
    private TbSettingTextTipView l;
    private TbSettingTextTipView m;
    private View n;
    private TbSettingTextNewDotView o;
    private TbSettingTextTipView p;
    private RelativeLayout q;
    private View r;

    public w(BaseActivity baseActivity, p pVar) {
        super(baseActivity);
        this.a = baseActivity;
        this.b = pVar;
        this.a.setContentView(com.baidu.tieba.w.more_activity);
        f();
    }

    public void a() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
    }

    public void a(String str) {
        if (str == null || str.length() <= 0) {
            if (this.f != null) {
                this.f.a();
                return;
            }
            return;
        }
        if (this.c == null) {
            this.c = new com.baidu.tbadk.editortool.ab(this.a);
        }
        this.f.b();
        b();
        com.baidu.adp.widget.a.a c = this.c.c(str);
        if (c != null) {
            this.f.setIcon(c);
            return;
        }
        com.baidu.adp.widget.a.a a = this.c.a(str, new x(this));
        if (a != null) {
            this.f.setIcon(a);
        }
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        if (this.f != null) {
            this.f.setIcon(aVar);
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.setIcon(com.baidu.tieba.u.person_photo);
        }
    }

    public void b(String str) {
        if (this.c != null) {
            this.c.e(str);
        }
    }

    public void c() {
        if (this.k != null) {
            this.k.a();
        }
        if (this.o != null) {
            this.o.a();
        }
    }

    public void d() {
        this.f.c();
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        this.l.d();
        this.m.d();
        this.p.d();
    }

    public void a(int i) {
        b(i);
    }

    public void b(int i) {
        this.d.c(i);
        this.f.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.q);
        this.d.c(i);
        c();
    }

    private void f() {
        View.OnClickListener g = g();
        this.q = (RelativeLayout) this.a.findViewById(com.baidu.tieba.v.parent);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.r = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.a.getString(com.baidu.tieba.y.setup));
        this.f = (SettingTextImageView) this.a.findViewById(com.baidu.tieba.v.personInfo);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.accountManager);
        this.h = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.browseSetting);
        this.i = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.messageSetting);
        this.j = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.secretSetting);
        this.k = (SettingTextVersionView) this.a.findViewById(com.baidu.tieba.v.versionInfo);
        this.l = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.feedBack);
        this.m = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.recommend);
        this.n = this.a.findViewById(com.baidu.tieba.v.line_recommend_layout);
        if (!com.baidu.tieba.ai.c().n()) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
        }
        this.o = (TbSettingTextNewDotView) this.a.findViewById(com.baidu.tieba.v.systemhelpsetting);
        this.p = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.quit);
        c();
        a();
        this.f.a();
        b(TbadkApplication.m252getInst().getSkinType());
        a(g);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds42);
        SpannableString spannableString = new SpannableString(this.mContext.getString(com.baidu.tieba.y.close_tb));
        spannableString.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, 5, 33);
        spannableString.setSpan(new AbsoluteSizeSpan((dimensionPixelSize * 2) / 3), 5, spannableString.length(), 33);
        SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.logout));
        spannableString2.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, 5, 33);
        spannableString2.setSpan(new AbsoluteSizeSpan((dimensionPixelSize * 2) / 3), 5, spannableString2.length(), 33);
        this.e = new AlertDialog.Builder(this.mContext).setItems(new CharSequence[]{spannableString, spannableString2}, new y(this)).create();
    }

    private void a(View.OnClickListener onClickListener) {
        this.r.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
    }

    private View.OnClickListener g() {
        return new z(this);
    }

    public void e() {
        if (this.e != null) {
            this.e.show();
        }
    }
}
