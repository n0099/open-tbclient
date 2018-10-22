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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private SettingTextTestNewView gNA;
    private ImageView gNB;
    private TbSettingTextTipView gNC;
    private TbSettingTextTipView gND;
    private TbSettingTextTipView gNE;
    private TbSettingTextTipView gNF;
    protected TextView gNG;
    private ProgressBar gNH;
    private AboutActivity gNx;
    private RelativeLayout gNy;
    private TextView gNz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gNx = aboutActivity;
        Jh();
        a(cVar);
    }

    public void bvo() {
        if (this.gNH != null) {
            this.gNH.setVisibility(0);
        }
    }

    public void aFG() {
        if (this.gNH != null) {
            this.gNH.setVisibility(8);
        }
    }

    private void Jh() {
        this.gNx.setContentView(e.h.about_activity);
        this.gNy = (RelativeLayout) this.gNx.findViewById(e.g.parent);
        this.gNB = (ImageView) this.gNx.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gNx.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gNx.getPageContext().getString(e.j.version_info));
        this.gNz = (TextView) this.gNx.findViewById(e.g.text_versioninfo);
        this.gNA = (SettingTextTestNewView) this.gNx.findViewById(e.g.about_version_update);
        this.gNC = (TbSettingTextTipView) this.gNx.findViewById(e.g.about_guide);
        this.gNC.hideArrow();
        this.gND = (TbSettingTextTipView) this.gNx.findViewById(e.g.tieba_protocol_text);
        this.gND.hideArrow();
        this.gNE = (TbSettingTextTipView) this.gNx.findViewById(e.g.tieba_privacy_text);
        this.gNE.hideArrow();
        this.gNF = (TbSettingTextTipView) this.gNx.findViewById(e.g.tieba_tdou_use_introduce);
        this.gNF.hideArrow();
        this.gNH = (ProgressBar) this.gNx.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gNz.setText(this.gNx.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gNx.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gNG = (TextView) this.gNx.findViewById(e.g.text_version_protoco);
        eS(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gNC.setVisibility(8);
            this.gNx.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            tH(0);
        }
    }

    private void a(final c cVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.a.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.gND) {
                    ay.CU().c(a.this.gNx.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gNE) {
                    ay.CU().a(a.this.gNx.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gNF) {
                    ay.CU().c(a.this.gNx.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gNA) {
                    if (view != a.this.gNC) {
                        if (view == a.this.gNB) {
                            cVar.tG(4);
                            return;
                        }
                        return;
                    }
                    cVar.tG(2);
                } else {
                    cVar.tG(1);
                }
            }
        };
        this.gNA.setOnClickListener(onClickListener);
        this.gNC.setOnClickListener(onClickListener);
        this.gND.setOnClickListener(onClickListener);
        this.gNE.setOnClickListener(onClickListener);
        this.gNF.setOnClickListener(onClickListener);
        this.gNB.setOnClickListener(onClickListener);
    }

    private void tH(int i) {
        this.gNx.findViewById(e.g.line0).setVisibility(i);
    }

    public void bvp() {
        if (this.gNA != null) {
            this.gNA.refresh();
        }
    }

    public void eS(int i) {
        al.j(this.gNy, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNx.getLayoutMode().setNightMode(i == 1);
        this.gNx.getLayoutMode().onModeChanged(this.gNy);
        bvp();
    }
}
