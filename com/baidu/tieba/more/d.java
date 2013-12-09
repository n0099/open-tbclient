package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f2088a;
    private NavigationBar c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private SettingTextTestNewView h;
    private SettingTextTipView i;
    private SettingTextFunctionIntroView j;
    private ProgressBar k;

    public d(com.baidu.tieba.j jVar, ac acVar) {
        super(jVar);
        this.f2088a = jVar;
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
        this.f2088a.setContentView(R.layout.about_activity);
        this.d = (RelativeLayout) this.f2088a.findViewById(R.id.parent);
        this.c = (NavigationBar) this.f2088a.findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.f2088a.getString(R.string.version_info));
        this.e = (TextView) this.f2088a.findViewById(R.id.text_versioninfo);
        this.f = (ImageView) this.f2088a.findViewById(R.id.text_description);
        this.h = (SettingTextTestNewView) this.f2088a.findViewById(R.id.about_version_update);
        this.h.d();
        this.j = (SettingTextFunctionIntroView) this.f2088a.findViewById(R.id.about_function_intro);
        this.i = (SettingTextTipView) this.f2088a.findViewById(R.id.about_guide);
        this.k = (ProgressBar) this.f2088a.findViewById(R.id.about_progress);
        this.e.setText(this.f2088a.getString(R.string.setting_version_text) + " " + com.baidu.tieba.data.h.j());
        this.g = (TextView) this.f2088a.findViewById(R.id.text_version_protoco);
        a(TiebaApplication.h().an());
    }

    private void a(ac acVar) {
        e eVar = new e(this, acVar);
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
            this.d.setBackgroundColor(this.f2088a.getResources().getColor(R.color.bg_page_setting_1));
        } else {
            this.d.setBackgroundColor(this.f2088a.getResources().getColor(R.color.bg_page_setting));
        }
        this.c.c(i);
        this.h.a(i);
        this.j.a(i);
        this.i.a(i);
        if (i == 1) {
            ba.e(this.h, (int) R.drawable.more_up_1);
            ba.e(this.i, (int) R.drawable.more_down_1);
            ba.e(this.j, (int) R.drawable.more_middle_1);
            this.g.setTextColor(this.f2088a.getResources().getColor(R.color.skin_1_common_color));
            this.e.setTextColor(this.f2088a.getResources().getColor(R.color.skin_1_common_color));
            this.f.setImageDrawable(this.f2088a.getResources().getDrawable(R.drawable.setting_logo_desc_1));
        } else {
            ba.e(this.h, (int) R.drawable.more_up);
            ba.e(this.i, (int) R.drawable.more_down);
            ba.e(this.j, (int) R.drawable.more_middle);
            this.g.setTextColor(this.f2088a.getResources().getColor(R.color.c_555d68));
            this.e.setTextColor(this.f2088a.getResources().getColor(R.color.c_262626));
            this.f.setImageDrawable(this.f2088a.getResources().getDrawable(R.drawable.setting_logo_desc));
        }
        f();
    }
}
