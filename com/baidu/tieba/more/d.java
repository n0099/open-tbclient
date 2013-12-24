package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.e {
    private com.baidu.tieba.j a;
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
        this.a = jVar;
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
        this.a.setContentView(R.layout.about_activity);
        this.d = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.c = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.a.getString(R.string.version_info));
        this.e = (TextView) this.a.findViewById(R.id.text_versioninfo);
        this.f = (ImageView) this.a.findViewById(R.id.text_description);
        this.h = (SettingTextTestNewView) this.a.findViewById(R.id.about_version_update);
        this.h.d();
        this.j = (SettingTextFunctionIntroView) this.a.findViewById(R.id.about_function_intro);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.about_guide);
        this.k = (ProgressBar) this.a.findViewById(R.id.about_progress);
        String j = com.baidu.tieba.data.h.j();
        if (com.baidu.tieba.data.h.l() == 1 && !bc.c(com.baidu.tieba.data.h.k())) {
            j = j + "." + com.baidu.tieba.data.h.k();
        }
        this.e.setText(this.a.getString(R.string.setting_version_text) + " " + j);
        this.g = (TextView) this.a.findViewById(R.id.text_version_protoco);
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
            this.d.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting_1));
        } else {
            this.d.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting));
        }
        this.c.c(i);
        this.h.a(i);
        this.j.a(i);
        this.i.a(i);
        if (i == 1) {
            bb.e(this.h, (int) R.drawable.more_up_1);
            bb.e(this.i, (int) R.drawable.more_down_1);
            bb.e(this.j, (int) R.drawable.more_middle_1);
            this.g.setTextColor(this.a.getResources().getColor(R.color.skin_1_common_color));
            this.e.setTextColor(this.a.getResources().getColor(R.color.skin_1_common_color));
            this.f.setImageDrawable(this.a.getResources().getDrawable(R.drawable.setting_logo_desc_1));
        } else {
            bb.e(this.h, (int) R.drawable.more_up);
            bb.e(this.i, (int) R.drawable.more_down);
            bb.e(this.j, (int) R.drawable.more_middle);
            this.g.setTextColor(this.a.getResources().getColor(R.color.c_555d68));
            this.e.setTextColor(this.a.getResources().getColor(R.color.c_262626));
            this.f.setImageDrawable(this.a.getResources().getDrawable(R.drawable.setting_logo_desc));
        }
        f();
    }
}
