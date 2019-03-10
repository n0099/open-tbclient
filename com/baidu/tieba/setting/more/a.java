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
    private AboutActivity irC;
    private RelativeLayout irD;
    private TextView irE;
    private SettingTextTestNewView irF;
    private ImageView irG;
    private TbSettingTextTipView irH;
    private TbSettingTextTipView irI;
    private TbSettingTextTipView irJ;
    private TbSettingTextTipView irK;
    protected TextView irL;
    private ProgressBar irM;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.irC = aboutActivity;
        akr();
        a(dVar);
    }

    public void bYO() {
        if (this.irM != null) {
            this.irM.setVisibility(0);
        }
    }

    public void biq() {
        if (this.irM != null) {
            this.irM.setVisibility(8);
        }
    }

    private void akr() {
        this.irC.setContentView(d.h.about_activity);
        this.irD = (RelativeLayout) this.irC.findViewById(d.g.parent);
        this.irG = (ImageView) this.irC.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.irC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irC.getPageContext().getString(d.j.version_info));
        this.irE = (TextView) this.irC.findViewById(d.g.text_versioninfo);
        this.irF = (SettingTextTestNewView) this.irC.findViewById(d.g.about_version_update);
        this.irH = (TbSettingTextTipView) this.irC.findViewById(d.g.about_guide);
        this.irH.hideArrow();
        this.irI = (TbSettingTextTipView) this.irC.findViewById(d.g.tieba_protocol_text);
        this.irI.hideArrow();
        this.irJ = (TbSettingTextTipView) this.irC.findViewById(d.g.tieba_privacy_text);
        this.irJ.hideArrow();
        this.irK = (TbSettingTextTipView) this.irC.findViewById(d.g.tieba_tdou_use_introduce);
        this.irK.hideArrow();
        this.irM = (ProgressBar) this.irC.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.irE.setText(this.irC.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.irC.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.irL = (TextView) this.irC.findViewById(d.g.text_version_protoco);
        jg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.irH.setVisibility(8);
            this.irC.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.irI) {
                    ba.adD().c(a.this.irC.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.irJ) {
                    ba.adD().a(a.this.irC.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.irK) {
                    ba.adD().c(a.this.irC.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.irF) {
                    if (view != a.this.irH) {
                        if (view == a.this.irG) {
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
        this.irF.setOnClickListener(onClickListener);
        this.irH.setOnClickListener(onClickListener);
        this.irI.setOnClickListener(onClickListener);
        this.irJ.setOnClickListener(onClickListener);
        this.irK.setOnClickListener(onClickListener);
        this.irG.setOnClickListener(onClickListener);
    }

    private void yz(int i) {
        this.irC.findViewById(d.g.line0).setVisibility(i);
    }

    public void bYP() {
        if (this.irF != null) {
            this.irF.refresh();
        }
    }

    public void jg(int i) {
        al.l(this.irD, d.C0236d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irC.getLayoutMode().setNightMode(i == 1);
        this.irC.getLayoutMode().onModeChanged(this.irD);
        bYP();
    }
}
