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
    private AboutActivity gZL;
    private RelativeLayout gZM;
    private TextView gZN;
    private SettingTextTestNewView gZO;
    private ImageView gZP;
    private TbSettingTextTipView gZQ;
    private TbSettingTextTipView gZR;
    private TbSettingTextTipView gZS;
    private TbSettingTextTipView gZT;
    protected TextView gZU;
    private ProgressBar gZV;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.gZL = aboutActivity;
        KN();
        a(dVar);
    }

    public void bxZ() {
        if (this.gZV != null) {
            this.gZV.setVisibility(0);
        }
    }

    public void aIa() {
        if (this.gZV != null) {
            this.gZV.setVisibility(8);
        }
    }

    private void KN() {
        this.gZL.setContentView(e.h.about_activity);
        this.gZM = (RelativeLayout) this.gZL.findViewById(e.g.parent);
        this.gZP = (ImageView) this.gZL.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gZL.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gZL.getPageContext().getString(e.j.version_info));
        this.gZN = (TextView) this.gZL.findViewById(e.g.text_versioninfo);
        this.gZO = (SettingTextTestNewView) this.gZL.findViewById(e.g.about_version_update);
        this.gZQ = (TbSettingTextTipView) this.gZL.findViewById(e.g.about_guide);
        this.gZQ.hideArrow();
        this.gZR = (TbSettingTextTipView) this.gZL.findViewById(e.g.tieba_protocol_text);
        this.gZR.hideArrow();
        this.gZS = (TbSettingTextTipView) this.gZL.findViewById(e.g.tieba_privacy_text);
        this.gZS.hideArrow();
        this.gZT = (TbSettingTextTipView) this.gZL.findViewById(e.g.tieba_tdou_use_introduce);
        this.gZT.hideArrow();
        this.gZV = (ProgressBar) this.gZL.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gZN.setText(this.gZL.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gZL.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gZU = (TextView) this.gZL.findViewById(e.g.text_version_protoco);
        fv(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gZQ.setVisibility(8);
            this.gZL.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            uK(0);
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
                if (view == a.this.gZR) {
                    ay.Es().c(a.this.gZL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gZS) {
                    ay.Es().a(a.this.gZL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gZT) {
                    ay.Es().c(a.this.gZL.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gZO) {
                    if (view != a.this.gZQ) {
                        if (view == a.this.gZP) {
                            dVar.uJ(4);
                            return;
                        }
                        return;
                    }
                    dVar.uJ(2);
                } else {
                    dVar.uJ(1);
                }
            }
        };
        this.gZO.setOnClickListener(onClickListener);
        this.gZQ.setOnClickListener(onClickListener);
        this.gZR.setOnClickListener(onClickListener);
        this.gZS.setOnClickListener(onClickListener);
        this.gZT.setOnClickListener(onClickListener);
        this.gZP.setOnClickListener(onClickListener);
    }

    private void uK(int i) {
        this.gZL.findViewById(e.g.line0).setVisibility(i);
    }

    public void bya() {
        if (this.gZO != null) {
            this.gZO.refresh();
        }
    }

    public void fv(int i) {
        al.j(this.gZM, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gZL.getLayoutMode().setNightMode(i == 1);
        this.gZL.getLayoutMode().onModeChanged(this.gZM);
        bya();
    }
}
