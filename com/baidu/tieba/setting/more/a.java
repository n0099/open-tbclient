package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private TbSettingTextTipView irA;
    private TbSettingTextTipView irB;
    private TbSettingTextTipView irC;
    private TbSettingTextTipView irD;
    protected TextView irE;
    private ProgressBar irF;
    private AboutActivity irv;
    private RelativeLayout irw;
    private TextView irx;
    private SettingTextTestNewView iry;
    private ImageView irz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.irv = aboutActivity;
        akq();
        a(dVar);
    }

    public void bYQ() {
        if (this.irF != null) {
            this.irF.setVisibility(0);
        }
    }

    public void bip() {
        if (this.irF != null) {
            this.irF.setVisibility(8);
        }
    }

    private void akq() {
        this.irv.setContentView(d.h.about_activity);
        this.irw = (RelativeLayout) this.irv.findViewById(d.g.parent);
        this.irz = (ImageView) this.irv.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.irv.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irv.getPageContext().getString(d.j.version_info));
        this.irx = (TextView) this.irv.findViewById(d.g.text_versioninfo);
        this.iry = (SettingTextTestNewView) this.irv.findViewById(d.g.about_version_update);
        this.irA = (TbSettingTextTipView) this.irv.findViewById(d.g.about_guide);
        this.irA.hideArrow();
        this.irB = (TbSettingTextTipView) this.irv.findViewById(d.g.tieba_protocol_text);
        this.irB.hideArrow();
        this.irC = (TbSettingTextTipView) this.irv.findViewById(d.g.tieba_privacy_text);
        this.irC.hideArrow();
        this.irD = (TbSettingTextTipView) this.irv.findViewById(d.g.tieba_tdou_use_introduce);
        this.irD.hideArrow();
        this.irF = (ProgressBar) this.irv.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.irx.setText(this.irv.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.irv.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.irE = (TextView) this.irv.findViewById(d.g.text_version_protoco);
        jg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.irA.setVisibility(8);
            this.irv.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            yz(0);
        }
    }

    private void a(final d dVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.a.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.irB) {
                    ba.adD().c(a.this.irv.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.irC) {
                    ba.adD().a(a.this.irv.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.irD) {
                    ba.adD().c(a.this.irv.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iry) {
                    if (view != a.this.irA) {
                        if (view == a.this.irz) {
                            dVar.yy(4);
                            return;
                        }
                        return;
                    }
                    dVar.yy(2);
                } else {
                    dVar.yy(1);
                }
            }
        };
        this.iry.setOnClickListener(onClickListener);
        this.irA.setOnClickListener(onClickListener);
        this.irB.setOnClickListener(onClickListener);
        this.irC.setOnClickListener(onClickListener);
        this.irD.setOnClickListener(onClickListener);
        this.irz.setOnClickListener(onClickListener);
    }

    private void yz(int i) {
        this.irv.findViewById(d.g.line0).setVisibility(i);
    }

    public void bYR() {
        if (this.iry != null) {
            this.iry.refresh();
        }
    }

    public void jg(int i) {
        al.l(this.irw, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irv.getLayoutMode().setNightMode(i == 1);
        this.irv.getLayoutMode().onModeChanged(this.irw);
        bYR();
    }
}
