package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    protected ImageView a;
    protected TextView b;
    private BaseActivity c;
    private NavigationBar d;
    private RelativeLayout e;
    private TextView f;
    private SettingTextTestNewView g;
    private TbSettingTextTipView h;
    private SettingTextFunctionIntroView i;
    private ProgressBar j;

    public d(BaseActivity baseActivity, p pVar) {
        super(baseActivity);
        this.c = baseActivity;
        d();
        a(pVar);
    }

    public void a() {
        if (this.j != null) {
            this.j.setVisibility(0);
        }
    }

    public void b() {
        if (this.j != null) {
            this.j.setVisibility(8);
        }
    }

    private void d() {
        this.c.setContentView(com.baidu.tieba.w.about_activity);
        this.e = (RelativeLayout) this.c.findViewById(com.baidu.tieba.v.parent);
        this.d = (NavigationBar) this.c.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.c.getString(com.baidu.tieba.y.version_info));
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.v.text_versioninfo);
        this.a = (ImageView) this.c.findViewById(com.baidu.tieba.v.text_description);
        this.g = (SettingTextTestNewView) this.c.findViewById(com.baidu.tieba.v.about_version_update);
        this.g.e();
        this.i = (SettingTextFunctionIntroView) this.c.findViewById(com.baidu.tieba.v.about_function_intro);
        this.h = (TbSettingTextTipView) this.c.findViewById(com.baidu.tieba.v.about_guide);
        this.j = (ProgressBar) this.c.findViewById(com.baidu.tieba.v.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !bm.c(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.f.setText(String.valueOf(this.c.getString(com.baidu.tieba.y.setting_version_text)) + " " + version);
        this.b = (TextView) this.c.findViewById(com.baidu.tieba.v.text_version_protoco);
        a(TbadkApplication.m252getInst().getSkinType());
    }

    private void a(p pVar) {
        e eVar = new e(this, pVar);
        this.g.setOnClickListener(eVar);
        this.h.setOnClickListener(eVar);
        this.i.setOnClickListener(eVar);
    }

    public void c() {
        if (this.g != null) {
            this.g.a();
        }
        if (this.i != null) {
            this.i.a();
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.e.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.s.bg_page_setting_1));
        } else {
            this.e.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.s.bg_page_setting));
        }
        this.d.c(i);
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a((View) this.e);
        c();
    }
}
