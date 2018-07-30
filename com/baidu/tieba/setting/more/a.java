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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gyI;
    private RelativeLayout gyJ;
    private TextView gyK;
    private SettingTextTestNewView gyL;
    private ImageView gyM;
    private TbSettingTextTipView gyN;
    private TbSettingTextTipView gyO;
    private TbSettingTextTipView gyP;
    private TbSettingTextTipView gyQ;
    protected TextView gyR;
    private ProgressBar gyS;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gyI = aboutActivity;
        FQ();
        a(cVar);
    }

    public void bpr() {
        if (this.gyS != null) {
            this.gyS.setVisibility(0);
        }
    }

    public void aAh() {
        if (this.gyS != null) {
            this.gyS.setVisibility(8);
        }
    }

    private void FQ() {
        this.gyI.setContentView(d.h.about_activity);
        this.gyJ = (RelativeLayout) this.gyI.findViewById(d.g.parent);
        this.gyM = (ImageView) this.gyI.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gyI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gyI.getPageContext().getString(d.j.version_info));
        this.gyK = (TextView) this.gyI.findViewById(d.g.text_versioninfo);
        this.gyL = (SettingTextTestNewView) this.gyI.findViewById(d.g.about_version_update);
        this.gyN = (TbSettingTextTipView) this.gyI.findViewById(d.g.about_guide);
        this.gyN.hideArrow();
        this.gyO = (TbSettingTextTipView) this.gyI.findViewById(d.g.tieba_protocol_text);
        this.gyO.hideArrow();
        this.gyP = (TbSettingTextTipView) this.gyI.findViewById(d.g.tieba_privacy_text);
        this.gyP.hideArrow();
        this.gyQ = (TbSettingTextTipView) this.gyI.findViewById(d.g.tieba_tdou_use_introduce);
        this.gyQ.hideArrow();
        this.gyS = (ProgressBar) this.gyI.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gyK.setText(this.gyI.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gyI.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.gyR = (TextView) this.gyI.findViewById(d.g.text_version_protoco);
        ey(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gyN.setVisibility(8);
            this.gyI.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.gyO) {
                    ay.zK().c(a.this.gyI.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gyP) {
                    ay.zK().a(a.this.gyI.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gyQ) {
                    ay.zK().c(a.this.gyI.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gyL) {
                    if (view != a.this.gyN) {
                        if (view == a.this.gyM) {
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
        this.gyL.setOnClickListener(onClickListener);
        this.gyN.setOnClickListener(onClickListener);
        this.gyO.setOnClickListener(onClickListener);
        this.gyP.setOnClickListener(onClickListener);
        this.gyQ.setOnClickListener(onClickListener);
        this.gyM.setOnClickListener(onClickListener);
    }

    private void sM(int i) {
        this.gyI.findViewById(d.g.line0).setVisibility(i);
    }

    public void bps() {
        if (this.gyL != null) {
            this.gyL.refresh();
        }
    }

    public void ey(int i) {
        am.j(this.gyJ, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gyI.getLayoutMode().setNightMode(i == 1);
        this.gyI.getLayoutMode().onModeChanged(this.gyJ);
        bps();
    }
}
