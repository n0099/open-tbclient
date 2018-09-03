package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gyL;
    private RelativeLayout gyM;
    private TextView gyN;
    private SettingTextTestNewView gyO;
    private ImageView gyP;
    private TbSettingTextTipView gyQ;
    private TbSettingTextTipView gyR;
    private TbSettingTextTipView gyS;
    private TbSettingTextTipView gyT;
    protected TextView gyU;
    private ProgressBar gyV;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gyL = aboutActivity;
        FQ();
        a(cVar);
    }

    public void bps() {
        if (this.gyV != null) {
            this.gyV.setVisibility(0);
        }
    }

    public void aAe() {
        if (this.gyV != null) {
            this.gyV.setVisibility(8);
        }
    }

    private void FQ() {
        this.gyL.setContentView(f.h.about_activity);
        this.gyM = (RelativeLayout) this.gyL.findViewById(f.g.parent);
        this.gyP = (ImageView) this.gyL.findViewById(f.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gyL.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gyL.getPageContext().getString(f.j.version_info));
        this.gyN = (TextView) this.gyL.findViewById(f.g.text_versioninfo);
        this.gyO = (SettingTextTestNewView) this.gyL.findViewById(f.g.about_version_update);
        this.gyQ = (TbSettingTextTipView) this.gyL.findViewById(f.g.about_guide);
        this.gyQ.hideArrow();
        this.gyR = (TbSettingTextTipView) this.gyL.findViewById(f.g.tieba_protocol_text);
        this.gyR.hideArrow();
        this.gyS = (TbSettingTextTipView) this.gyL.findViewById(f.g.tieba_privacy_text);
        this.gyS.hideArrow();
        this.gyT = (TbSettingTextTipView) this.gyL.findViewById(f.g.tieba_tdou_use_introduce);
        this.gyT.hideArrow();
        this.gyV = (ProgressBar) this.gyL.findViewById(f.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gyN.setText(this.gyL.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gyL.getPageContext().getString(f.j.setting_version_text) + " " + version);
        this.gyU = (TextView) this.gyL.findViewById(f.g.text_version_protoco);
        ex(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gyQ.setVisibility(8);
            this.gyL.findViewById(f.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            sM(0);
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
                if (view == a.this.gyR) {
                    az.zI().c(a.this.gyL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gyS) {
                    az.zI().a(a.this.gyL.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gyT) {
                    az.zI().c(a.this.gyL.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gyO) {
                    if (view != a.this.gyQ) {
                        if (view == a.this.gyP) {
                            cVar.sL(4);
                            return;
                        }
                        return;
                    }
                    cVar.sL(2);
                } else {
                    cVar.sL(1);
                }
            }
        };
        this.gyO.setOnClickListener(onClickListener);
        this.gyQ.setOnClickListener(onClickListener);
        this.gyR.setOnClickListener(onClickListener);
        this.gyS.setOnClickListener(onClickListener);
        this.gyT.setOnClickListener(onClickListener);
        this.gyP.setOnClickListener(onClickListener);
    }

    private void sM(int i) {
        this.gyL.findViewById(f.g.line0).setVisibility(i);
    }

    public void bpt() {
        if (this.gyO != null) {
            this.gyO.refresh();
        }
    }

    public void ex(int i) {
        am.j(this.gyM, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gyL.getLayoutMode().setNightMode(i == 1);
        this.gyL.getLayoutMode().onModeChanged(this.gyM);
        bpt();
    }
}
