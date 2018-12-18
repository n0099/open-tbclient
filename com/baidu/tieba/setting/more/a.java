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
    private AboutActivity gVM;
    private RelativeLayout gVN;
    private TextView gVO;
    private SettingTextTestNewView gVP;
    private ImageView gVQ;
    private TbSettingTextTipView gVR;
    private TbSettingTextTipView gVS;
    private TbSettingTextTipView gVT;
    private TbSettingTextTipView gVU;
    protected TextView gVV;
    private ProgressBar gVW;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gVM = aboutActivity;
        Kx();
        a(cVar);
    }

    public void bwC() {
        if (this.gVW != null) {
            this.gVW.setVisibility(0);
        }
    }

    public void aGO() {
        if (this.gVW != null) {
            this.gVW.setVisibility(8);
        }
    }

    private void Kx() {
        this.gVM.setContentView(e.h.about_activity);
        this.gVN = (RelativeLayout) this.gVM.findViewById(e.g.parent);
        this.gVQ = (ImageView) this.gVM.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gVM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gVM.getPageContext().getString(e.j.version_info));
        this.gVO = (TextView) this.gVM.findViewById(e.g.text_versioninfo);
        this.gVP = (SettingTextTestNewView) this.gVM.findViewById(e.g.about_version_update);
        this.gVR = (TbSettingTextTipView) this.gVM.findViewById(e.g.about_guide);
        this.gVR.hideArrow();
        this.gVS = (TbSettingTextTipView) this.gVM.findViewById(e.g.tieba_protocol_text);
        this.gVS.hideArrow();
        this.gVT = (TbSettingTextTipView) this.gVM.findViewById(e.g.tieba_privacy_text);
        this.gVT.hideArrow();
        this.gVU = (TbSettingTextTipView) this.gVM.findViewById(e.g.tieba_tdou_use_introduce);
        this.gVU.hideArrow();
        this.gVW = (ProgressBar) this.gVM.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gVO.setText(this.gVM.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gVM.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gVV = (TextView) this.gVM.findViewById(e.g.text_version_protoco);
        fu(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gVR.setVisibility(8);
            this.gVM.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            uu(0);
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
                if (view == a.this.gVS) {
                    ay.Ef().c(a.this.gVM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gVT) {
                    ay.Ef().a(a.this.gVM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gVU) {
                    ay.Ef().c(a.this.gVM.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gVP) {
                    if (view != a.this.gVR) {
                        if (view == a.this.gVQ) {
                            cVar.ut(4);
                            return;
                        }
                        return;
                    }
                    cVar.ut(2);
                } else {
                    cVar.ut(1);
                }
            }
        };
        this.gVP.setOnClickListener(onClickListener);
        this.gVR.setOnClickListener(onClickListener);
        this.gVS.setOnClickListener(onClickListener);
        this.gVT.setOnClickListener(onClickListener);
        this.gVU.setOnClickListener(onClickListener);
        this.gVQ.setOnClickListener(onClickListener);
    }

    private void uu(int i) {
        this.gVM.findViewById(e.g.line0).setVisibility(i);
    }

    public void bwD() {
        if (this.gVP != null) {
            this.gVP.refresh();
        }
    }

    public void fu(int i) {
        al.j(this.gVN, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gVM.getLayoutMode().setNightMode(i == 1);
        this.gVM.getLayoutMode().onModeChanged(this.gVN);
        bwD();
    }
}
