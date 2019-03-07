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
    private AboutActivity irB;
    private RelativeLayout irC;
    private TextView irD;
    private SettingTextTestNewView irE;
    private ImageView irF;
    private TbSettingTextTipView irG;
    private TbSettingTextTipView irH;
    private TbSettingTextTipView irI;
    private TbSettingTextTipView irJ;
    protected TextView irK;
    private ProgressBar irL;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.irB = aboutActivity;
        akr();
        a(dVar);
    }

    public void bYN() {
        if (this.irL != null) {
            this.irL.setVisibility(0);
        }
    }

    public void bip() {
        if (this.irL != null) {
            this.irL.setVisibility(8);
        }
    }

    private void akr() {
        this.irB.setContentView(d.h.about_activity);
        this.irC = (RelativeLayout) this.irB.findViewById(d.g.parent);
        this.irF = (ImageView) this.irB.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.irB.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irB.getPageContext().getString(d.j.version_info));
        this.irD = (TextView) this.irB.findViewById(d.g.text_versioninfo);
        this.irE = (SettingTextTestNewView) this.irB.findViewById(d.g.about_version_update);
        this.irG = (TbSettingTextTipView) this.irB.findViewById(d.g.about_guide);
        this.irG.hideArrow();
        this.irH = (TbSettingTextTipView) this.irB.findViewById(d.g.tieba_protocol_text);
        this.irH.hideArrow();
        this.irI = (TbSettingTextTipView) this.irB.findViewById(d.g.tieba_privacy_text);
        this.irI.hideArrow();
        this.irJ = (TbSettingTextTipView) this.irB.findViewById(d.g.tieba_tdou_use_introduce);
        this.irJ.hideArrow();
        this.irL = (ProgressBar) this.irB.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.irD.setText(this.irB.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.irB.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.irK = (TextView) this.irB.findViewById(d.g.text_version_protoco);
        jg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.irG.setVisibility(8);
            this.irB.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.irH) {
                    ba.adD().c(a.this.irB.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.irI) {
                    ba.adD().a(a.this.irB.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.irJ) {
                    ba.adD().c(a.this.irB.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.irE) {
                    if (view != a.this.irG) {
                        if (view == a.this.irF) {
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
        this.irE.setOnClickListener(onClickListener);
        this.irG.setOnClickListener(onClickListener);
        this.irH.setOnClickListener(onClickListener);
        this.irI.setOnClickListener(onClickListener);
        this.irJ.setOnClickListener(onClickListener);
        this.irF.setOnClickListener(onClickListener);
    }

    private void yz(int i) {
        this.irB.findViewById(d.g.line0).setVisibility(i);
    }

    public void bYO() {
        if (this.irE != null) {
            this.irE.refresh();
        }
    }

    public void jg(int i) {
        al.l(this.irC, d.C0236d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irB.getLayoutMode().setNightMode(i == 1);
        this.irB.getLayoutMode().onModeChanged(this.irC);
        bYO();
    }
}
