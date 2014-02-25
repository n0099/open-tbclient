package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.e {
    private com.baidu.tieba.f a;
    private NavigationBar c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private SettingTextTestNewView h;
    private SettingTextTipView i;
    private SettingTextFunctionIntroView j;
    private ProgressBar k;

    public d(com.baidu.tieba.f fVar, ab abVar) {
        super(fVar);
        this.a = fVar;
        g();
        a(abVar);
    }

    public void a() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public void e() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    private void g() {
        this.a.setContentView(R.layout.about_activity);
        this.d = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.c = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.a.getString(R.string.version_info));
        this.e = (TextView) this.a.findViewById(R.id.text_versioninfo);
        this.f = (ImageView) this.a.findViewById(R.id.text_description);
        this.h = (SettingTextTestNewView) this.a.findViewById(R.id.about_version_update);
        this.h.e();
        this.j = (SettingTextFunctionIntroView) this.a.findViewById(R.id.about_function_intro);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.about_guide);
        this.k = (ProgressBar) this.a.findViewById(R.id.about_progress);
        String u = com.baidu.tieba.data.i.u();
        if (com.baidu.tieba.data.i.w() == 1 && !bs.c(com.baidu.tieba.data.i.v())) {
            u = String.valueOf(u) + "." + com.baidu.tieba.data.i.v();
        }
        this.e.setText(String.valueOf(this.a.getString(R.string.setting_version_text)) + " " + u);
        this.g = (TextView) this.a.findViewById(R.id.text_version_protoco);
        a(TiebaApplication.g().al());
    }

    private void a(ab abVar) {
        e eVar = new e(this, abVar);
        this.h.setOnClickListener(eVar);
        this.i.setOnClickListener(eVar);
        this.j.setOnClickListener(eVar);
    }

    public void f() {
        if (this.h != null) {
            this.h.a();
        }
        if (this.j != null) {
            this.j.a();
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.d.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting_1));
        } else {
            this.d.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting));
        }
        this.c.c(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.d);
        this.h.a(i);
        this.j.a(i);
        this.i.a(i);
        f();
    }
}
