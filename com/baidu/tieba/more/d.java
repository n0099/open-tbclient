package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.a.f {
    protected ImageView a;
    protected TextView c;
    private com.baidu.tbadk.a d;
    private NavigationBar e;
    private RelativeLayout f;
    private TextView g;
    private SettingTextTestNewView h;
    private TbSettingTextTipView i;
    private SettingTextFunctionIntroView j;
    private ProgressBar k;

    public d(com.baidu.tbadk.a aVar, p pVar) {
        super(aVar);
        this.d = aVar;
        this.d.setContentView(com.baidu.tieba.a.i.about_activity);
        this.f = (RelativeLayout) this.d.findViewById(com.baidu.tieba.a.h.parent);
        this.e = (NavigationBar) this.d.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(this.d.getString(com.baidu.tieba.a.k.version_info));
        this.g = (TextView) this.d.findViewById(com.baidu.tieba.a.h.text_versioninfo);
        this.a = (ImageView) this.d.findViewById(com.baidu.tieba.a.h.text_description);
        this.h = (SettingTextTestNewView) this.d.findViewById(com.baidu.tieba.a.h.about_version_update);
        this.h.d();
        this.j = (SettingTextFunctionIntroView) this.d.findViewById(com.baidu.tieba.a.h.about_function_intro);
        this.i = (TbSettingTextTipView) this.d.findViewById(com.baidu.tieba.a.h.about_guide);
        this.k = (ProgressBar) this.d.findViewById(com.baidu.tieba.a.h.about_progress);
        String c = com.baidu.tbadk.core.data.n.c();
        if (com.baidu.tbadk.core.data.n.e() == 1 && !bc.c(com.baidu.tbadk.core.data.n.d())) {
            c = String.valueOf(c) + "." + com.baidu.tbadk.core.data.n.d();
        }
        this.g.setText(String.valueOf(this.d.getString(com.baidu.tieba.a.k.setting_version_text)) + " " + c);
        this.c = (TextView) this.d.findViewById(com.baidu.tieba.a.h.text_version_protoco);
        a(TbadkApplication.j().l());
        e eVar = new e(this, pVar);
        this.h.setOnClickListener(eVar);
        this.i.setOnClickListener(eVar);
        this.j.setOnClickListener(eVar);
    }

    public final void a() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public final void d() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    public final void e() {
        if (this.h != null) {
            this.h.e();
        }
        if (this.j != null) {
            this.j.e();
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.f.setBackgroundColor(this.d.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting_1));
        } else {
            this.f.setBackgroundColor(this.d.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting));
        }
        this.e.b(i);
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.f);
        e();
    }
}
