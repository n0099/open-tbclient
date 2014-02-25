package com.baidu.tieba.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.e {
    private NavigationBar a;
    private ViewGroup c;
    private ImageView d;
    private SettingTextSwitchView e;
    private SettingTextTipView f;
    private SecretSettingActivity g;

    public am(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.a = null;
        this.g = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
    }

    public void a(SecretSettingActivity secretSettingActivity) {
        b(secretSettingActivity);
    }

    public void a(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a((View) this.c);
        this.a.c(i);
        this.f.a(i);
    }

    void b(SecretSettingActivity secretSettingActivity) {
        this.c = (RelativeLayout) secretSettingActivity.findViewById(R.id.parent);
        this.a = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.a.a(secretSettingActivity.getString(R.string.secretSetting_title));
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, secretSettingActivity);
        this.e = (SettingTextSwitchView) secretSettingActivity.findViewById(R.id.only_send_me);
        this.e.setSwitchStateChangeListener(this.g);
        this.f = (SettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.f.setOnClickListener(this.g);
    }

    public void a() {
        this.g.showLoadingDialog(this.g.getString(R.string.loading));
    }

    public void e() {
        this.f.d();
    }

    public void f() {
        this.g.showLoadingDialog(this.g.getString(R.string.saving));
    }

    public void g() {
        this.g.closeLoadingDialog();
    }

    public ImageView h() {
        return this.d;
    }

    public SettingTextSwitchView i() {
        return this.e;
    }

    public SettingTextTipView j() {
        return this.f;
    }
}
