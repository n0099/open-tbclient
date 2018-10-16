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
    private ImageView gNA;
    private TbSettingTextTipView gNB;
    private TbSettingTextTipView gNC;
    private TbSettingTextTipView gND;
    private TbSettingTextTipView gNE;
    protected TextView gNF;
    private ProgressBar gNG;
    private AboutActivity gNw;
    private RelativeLayout gNx;
    private TextView gNy;
    private SettingTextTestNewView gNz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gNw = aboutActivity;
        Jh();
        a(cVar);
    }

    public void bvo() {
        if (this.gNG != null) {
            this.gNG.setVisibility(0);
        }
    }

    public void aFG() {
        if (this.gNG != null) {
            this.gNG.setVisibility(8);
        }
    }

    private void Jh() {
        this.gNw.setContentView(e.h.about_activity);
        this.gNx = (RelativeLayout) this.gNw.findViewById(e.g.parent);
        this.gNA = (ImageView) this.gNw.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gNw.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gNw.getPageContext().getString(e.j.version_info));
        this.gNy = (TextView) this.gNw.findViewById(e.g.text_versioninfo);
        this.gNz = (SettingTextTestNewView) this.gNw.findViewById(e.g.about_version_update);
        this.gNB = (TbSettingTextTipView) this.gNw.findViewById(e.g.about_guide);
        this.gNB.hideArrow();
        this.gNC = (TbSettingTextTipView) this.gNw.findViewById(e.g.tieba_protocol_text);
        this.gNC.hideArrow();
        this.gND = (TbSettingTextTipView) this.gNw.findViewById(e.g.tieba_privacy_text);
        this.gND.hideArrow();
        this.gNE = (TbSettingTextTipView) this.gNw.findViewById(e.g.tieba_tdou_use_introduce);
        this.gNE.hideArrow();
        this.gNG = (ProgressBar) this.gNw.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gNy.setText(this.gNw.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gNw.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gNF = (TextView) this.gNw.findViewById(e.g.text_version_protoco);
        eS(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gNB.setVisibility(8);
            this.gNw.findViewById(e.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.gNC) {
                    ay.CU().c(a.this.gNw.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gND) {
                    ay.CU().a(a.this.gNw.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gNE) {
                    ay.CU().c(a.this.gNw.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gNz) {
                    if (view != a.this.gNB) {
                        if (view == a.this.gNA) {
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
        this.gNz.setOnClickListener(onClickListener);
        this.gNB.setOnClickListener(onClickListener);
        this.gNC.setOnClickListener(onClickListener);
        this.gND.setOnClickListener(onClickListener);
        this.gNE.setOnClickListener(onClickListener);
        this.gNA.setOnClickListener(onClickListener);
    }

    private void tH(int i) {
        this.gNw.findViewById(e.g.line0).setVisibility(i);
    }

    public void bvp() {
        if (this.gNz != null) {
            this.gNz.refresh();
        }
    }

    public void eS(int i) {
        al.j(this.gNx, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNw.getLayoutMode().setNightMode(i == 1);
        this.gNw.getLayoutMode().onModeChanged(this.gNx);
        bvp();
    }
}
