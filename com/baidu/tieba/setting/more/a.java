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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gtI;
    private RelativeLayout gtJ;
    private TextView gtK;
    private SettingTextTestNewView gtL;
    private ImageView gtM;
    private TbSettingTextTipView gtN;
    private TbSettingTextTipView gtO;
    private TbSettingTextTipView gtP;
    private TbSettingTextTipView gtQ;
    protected TextView gtR;
    private ProgressBar gtS;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gtI = aboutActivity;
        FC();
        a(cVar);
    }

    public void bqn() {
        if (this.gtS != null) {
            this.gtS.setVisibility(0);
        }
    }

    public void ayU() {
        if (this.gtS != null) {
            this.gtS.setVisibility(8);
        }
    }

    private void FC() {
        this.gtI.setContentView(d.i.about_activity);
        this.gtJ = (RelativeLayout) this.gtI.findViewById(d.g.parent);
        this.gtM = (ImageView) this.gtI.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gtI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gtI.getPageContext().getString(d.k.version_info));
        this.gtK = (TextView) this.gtI.findViewById(d.g.text_versioninfo);
        this.gtL = (SettingTextTestNewView) this.gtI.findViewById(d.g.about_version_update);
        this.gtN = (TbSettingTextTipView) this.gtI.findViewById(d.g.about_guide);
        this.gtN.hideArrow();
        this.gtO = (TbSettingTextTipView) this.gtI.findViewById(d.g.tieba_protocol_text);
        this.gtO.hideArrow();
        this.gtP = (TbSettingTextTipView) this.gtI.findViewById(d.g.tieba_privacy_text);
        this.gtP.hideArrow();
        this.gtQ = (TbSettingTextTipView) this.gtI.findViewById(d.g.tieba_tdou_use_introduce);
        this.gtQ.hideArrow();
        this.gtS = (ProgressBar) this.gtI.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gtK.setText(this.gtI.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gtI.getPageContext().getString(d.k.setting_version_text) + " " + version);
        this.gtR = (TextView) this.gtI.findViewById(d.g.text_version_protoco);
        eu(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gtN.setVisibility(8);
            this.gtI.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            sE(0);
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
                if (view == a.this.gtO) {
                    ay.zG().c(a.this.gtI.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gtP) {
                    ay.zG().a(a.this.gtI.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gtQ) {
                    ay.zG().c(a.this.gtI.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gtL) {
                    if (view != a.this.gtN) {
                        if (view == a.this.gtM) {
                            cVar.sD(4);
                            return;
                        }
                        return;
                    }
                    cVar.sD(2);
                } else {
                    cVar.sD(1);
                }
            }
        };
        this.gtL.setOnClickListener(onClickListener);
        this.gtN.setOnClickListener(onClickListener);
        this.gtO.setOnClickListener(onClickListener);
        this.gtP.setOnClickListener(onClickListener);
        this.gtQ.setOnClickListener(onClickListener);
        this.gtM.setOnClickListener(onClickListener);
    }

    private void sE(int i) {
        this.gtI.findViewById(d.g.line0).setVisibility(i);
    }

    public void bqo() {
        if (this.gtL != null) {
            this.gtL.refresh();
        }
    }

    public void eu(int i) {
        al.j(this.gtJ, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gtI.getLayoutMode().setNightMode(i == 1);
        this.gtI.getLayoutMode().onModeChanged(this.gtJ);
        bqo();
    }
}
