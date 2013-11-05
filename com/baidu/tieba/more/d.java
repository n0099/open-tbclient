package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f2005a;
    private NavigationBar c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private SettingTextVersionView i;
    private SettingTextTipView j;
    private ProgressBar k;

    public d(com.baidu.tieba.j jVar, ac acVar) {
        super(jVar);
        this.f2005a = jVar;
        g();
        a(acVar);
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
        this.f2005a.setContentView(R.layout.about_activity);
        this.d = (RelativeLayout) this.f2005a.findViewById(R.id.parent);
        this.c = (NavigationBar) this.f2005a.findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.f2005a.getString(R.string.version_info));
        this.e = (ImageView) this.f2005a.findViewById(R.id.image_logo);
        this.f = (TextView) this.f2005a.findViewById(R.id.text_versioninfo);
        this.g = (ImageView) this.f2005a.findViewById(R.id.text_description);
        this.i = (SettingTextVersionView) this.f2005a.findViewById(R.id.about_version_update);
        this.i.b();
        this.j = (SettingTextTipView) this.f2005a.findViewById(R.id.about_guide);
        this.k = (ProgressBar) this.f2005a.findViewById(R.id.about_progress);
        this.f.setText(this.f2005a.getString(R.string.setting_version_text) + " " + com.baidu.tieba.data.h.j());
        this.h = (TextView) this.f2005a.findViewById(R.id.text_version_protoco);
        a(TiebaApplication.g().as());
    }

    private void a(ac acVar) {
        e eVar = new e(this, acVar);
        this.i.setOnClickListener(eVar);
        this.j.setOnClickListener(eVar);
    }

    public void f() {
        if (this.i != null) {
            this.i.d();
        }
    }

    public void a(int i) {
        com.baidu.tieba.util.bb.b(this.d, i);
        this.c.b(i);
        this.i.a(i);
        this.j.a(i);
        if (i == 1) {
            com.baidu.tieba.util.bb.e(this.i, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.bb.e(this.j, (int) R.drawable.more_down_1);
            this.h.setTextColor(this.f2005a.getResources().getColor(R.color.skin_1_common_color));
            this.f.setTextColor(this.f2005a.getResources().getColor(R.color.skin_1_common_color));
            this.g.setImageDrawable(this.f2005a.getResources().getDrawable(R.drawable.setting_logo_desc_1));
        } else {
            com.baidu.tieba.util.bb.e(this.i, (int) R.drawable.more_up);
            com.baidu.tieba.util.bb.e(this.j, (int) R.drawable.more_down);
            this.h.setTextColor(this.f2005a.getResources().getColor(R.color.c_555d68));
            this.f.setTextColor(this.f2005a.getResources().getColor(R.color.c_262626));
            this.g.setImageDrawable(this.f2005a.getResources().getDrawable(R.drawable.setting_logo_desc));
        }
        f();
    }
}
