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
    private AboutActivity gYG;
    private RelativeLayout gYH;
    private TextView gYI;
    private SettingTextTestNewView gYJ;
    private ImageView gYK;
    private TbSettingTextTipView gYL;
    private TbSettingTextTipView gYM;
    private TbSettingTextTipView gYN;
    private TbSettingTextTipView gYO;
    protected TextView gYP;
    private ProgressBar gYQ;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.gYG = aboutActivity;
        Ky();
        a(dVar);
    }

    public void bxq() {
        if (this.gYQ != null) {
            this.gYQ.setVisibility(0);
        }
    }

    public void aHD() {
        if (this.gYQ != null) {
            this.gYQ.setVisibility(8);
        }
    }

    private void Ky() {
        this.gYG.setContentView(e.h.about_activity);
        this.gYH = (RelativeLayout) this.gYG.findViewById(e.g.parent);
        this.gYK = (ImageView) this.gYG.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gYG.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gYG.getPageContext().getString(e.j.version_info));
        this.gYI = (TextView) this.gYG.findViewById(e.g.text_versioninfo);
        this.gYJ = (SettingTextTestNewView) this.gYG.findViewById(e.g.about_version_update);
        this.gYL = (TbSettingTextTipView) this.gYG.findViewById(e.g.about_guide);
        this.gYL.hideArrow();
        this.gYM = (TbSettingTextTipView) this.gYG.findViewById(e.g.tieba_protocol_text);
        this.gYM.hideArrow();
        this.gYN = (TbSettingTextTipView) this.gYG.findViewById(e.g.tieba_privacy_text);
        this.gYN.hideArrow();
        this.gYO = (TbSettingTextTipView) this.gYG.findViewById(e.g.tieba_tdou_use_introduce);
        this.gYO.hideArrow();
        this.gYQ = (ProgressBar) this.gYG.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gYI.setText(this.gYG.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gYG.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gYP = (TextView) this.gYG.findViewById(e.g.text_version_protoco);
        fv(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gYL.setVisibility(8);
            this.gYG.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            uH(0);
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
                if (view == a.this.gYM) {
                    ay.Ef().c(a.this.gYG.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gYN) {
                    ay.Ef().a(a.this.gYG.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gYO) {
                    ay.Ef().c(a.this.gYG.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gYJ) {
                    if (view != a.this.gYL) {
                        if (view == a.this.gYK) {
                            dVar.uG(4);
                            return;
                        }
                        return;
                    }
                    dVar.uG(2);
                } else {
                    dVar.uG(1);
                }
            }
        };
        this.gYJ.setOnClickListener(onClickListener);
        this.gYL.setOnClickListener(onClickListener);
        this.gYM.setOnClickListener(onClickListener);
        this.gYN.setOnClickListener(onClickListener);
        this.gYO.setOnClickListener(onClickListener);
        this.gYK.setOnClickListener(onClickListener);
    }

    private void uH(int i) {
        this.gYG.findViewById(e.g.line0).setVisibility(i);
    }

    public void bxr() {
        if (this.gYJ != null) {
            this.gYJ.refresh();
        }
    }

    public void fv(int i) {
        al.j(this.gYH, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gYG.getLayoutMode().setNightMode(i == 1);
        this.gYG.getLayoutMode().onModeChanged(this.gYH);
        bxr();
    }
}
