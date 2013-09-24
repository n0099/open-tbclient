package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.d {
    private com.baidu.tieba.j b;
    private NavigationBar c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private SettingTextVersionView i;
    private SettingTextTipView j;
    private ProgressBar k;

    public d(com.baidu.tieba.j jVar, aa aaVar) {
        super(jVar);
        this.b = jVar;
        e();
        a(aaVar);
    }

    public void b() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public void c() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    private void e() {
        this.b.setContentView(R.layout.about_activity);
        this.d = (RelativeLayout) this.b.findViewById(R.id.parent);
        this.c = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.b.getString(R.string.version_info));
        this.e = (ImageView) this.b.findViewById(R.id.image_logo);
        this.f = (TextView) this.b.findViewById(R.id.text_versioninfo);
        this.g = (ImageView) this.b.findViewById(R.id.text_description);
        this.i = (SettingTextVersionView) this.b.findViewById(R.id.about_version_update);
        this.i.b();
        this.j = (SettingTextTipView) this.b.findViewById(R.id.about_guide);
        this.k = (ProgressBar) this.b.findViewById(R.id.about_progress);
        this.f.setText(String.valueOf(this.b.getString(R.string.setting_version_text)) + " " + com.baidu.tieba.data.g.j());
        this.h = (TextView) this.b.findViewById(R.id.text_version_protoco);
        a(TiebaApplication.g().ap());
    }

    private void a(aa aaVar) {
        e eVar = new e(this, aaVar);
        this.i.setOnClickListener(eVar);
        this.j.setOnClickListener(eVar);
    }

    public void d() {
        if (this.i != null) {
            this.i.d();
        }
    }

    public void a(int i) {
        as.b(this.d, i);
        this.c.b(i);
        this.i.a(i);
        this.j.a(i);
        if (i == 1) {
            as.e(this.i, (int) R.drawable.more_up_1);
            as.e(this.j, (int) R.drawable.more_down_1);
            this.h.setTextColor(this.b.getResources().getColor(R.color.skin_1_common_color));
            this.f.setTextColor(this.b.getResources().getColor(R.color.skin_1_common_color));
            this.g.setImageDrawable(this.b.getResources().getDrawable(R.drawable.setting_logo_desc_1));
        } else {
            as.e(this.i, (int) R.drawable.more_up);
            as.e(this.j, (int) R.drawable.more_down);
            this.h.setTextColor(this.b.getResources().getColor(R.color.c_555d68));
            this.f.setTextColor(this.b.getResources().getColor(R.color.c_262626));
            this.g.setImageDrawable(this.b.getResources().getDrawable(R.drawable.setting_logo_desc));
        }
        d();
    }
}
