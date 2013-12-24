package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.a.e {
    private SystemHelpSettingActivity a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextTipView e;
    private SettingTextTipView f;
    private NavigationBar g;

    public az(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = systemHelpSettingActivity;
        this.a.setContentView(R.layout.system_help_activity);
        this.g = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.g.a(this.a.getString(R.string.systemhelpsetting));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.a.findViewById(R.id.sv_earphone);
        this.e = (SettingTextTipView) this.a.findViewById(R.id.clear_cache);
        this.e.d();
        this.e.setOnClickListener(this.a);
        this.f = (SettingTextTipView) this.a.findViewById(R.id.clear_im);
        this.f.d();
        this.f.setOnClickListener(this.a);
        this.d.setSwitchStateChangeListener(this.a);
        this.c = (RelativeLayout) this.a.findViewById(R.id.parent);
        if (TiebaApplication.C()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public BdSwitchView a() {
        return this.d.getSwitchView();
    }

    public SettingTextTipView e() {
        return this.e;
    }

    public SettingTextTipView f() {
        return this.f;
    }

    public void a(int i) {
        this.g.c(i);
        this.d.a(i);
        if (i == 1) {
            bb.e(this.d, (int) R.drawable.more_all_1);
            bb.e(this.e, (int) R.drawable.more_all_1);
        } else {
            bb.e(this.d, (int) R.drawable.more_all);
            bb.e(this.e, (int) R.drawable.more_all);
        }
        this.e.a(i);
        this.f.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
    }
}
