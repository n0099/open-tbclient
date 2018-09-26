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
    private AboutActivity gGa;
    private RelativeLayout gGb;
    private TextView gGc;
    private SettingTextTestNewView gGd;
    private ImageView gGe;
    private TbSettingTextTipView gGf;
    private TbSettingTextTipView gGg;
    private TbSettingTextTipView gGh;
    private TbSettingTextTipView gGi;
    protected TextView gGj;
    private ProgressBar gGk;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gGa = aboutActivity;
        Hg();
        a(cVar);
    }

    public void brZ() {
        if (this.gGk != null) {
            this.gGk.setVisibility(0);
        }
    }

    public void aCn() {
        if (this.gGk != null) {
            this.gGk.setVisibility(8);
        }
    }

    private void Hg() {
        this.gGa.setContentView(e.h.about_activity);
        this.gGb = (RelativeLayout) this.gGa.findViewById(e.g.parent);
        this.gGe = (ImageView) this.gGa.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gGa.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gGa.getPageContext().getString(e.j.version_info));
        this.gGc = (TextView) this.gGa.findViewById(e.g.text_versioninfo);
        this.gGd = (SettingTextTestNewView) this.gGa.findViewById(e.g.about_version_update);
        this.gGf = (TbSettingTextTipView) this.gGa.findViewById(e.g.about_guide);
        this.gGf.hideArrow();
        this.gGg = (TbSettingTextTipView) this.gGa.findViewById(e.g.tieba_protocol_text);
        this.gGg.hideArrow();
        this.gGh = (TbSettingTextTipView) this.gGa.findViewById(e.g.tieba_privacy_text);
        this.gGh.hideArrow();
        this.gGi = (TbSettingTextTipView) this.gGa.findViewById(e.g.tieba_tdou_use_introduce);
        this.gGi.hideArrow();
        this.gGk = (ProgressBar) this.gGa.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gGc.setText(this.gGa.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gGa.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gGj = (TextView) this.gGa.findViewById(e.g.text_version_protoco);
        eJ(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gGf.setVisibility(8);
            this.gGa.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            tk(0);
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
                if (view == a.this.gGg) {
                    ay.AN().c(a.this.gGa.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gGh) {
                    ay.AN().a(a.this.gGa.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gGi) {
                    ay.AN().c(a.this.gGa.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gGd) {
                    if (view != a.this.gGf) {
                        if (view == a.this.gGe) {
                            cVar.tj(4);
                            return;
                        }
                        return;
                    }
                    cVar.tj(2);
                } else {
                    cVar.tj(1);
                }
            }
        };
        this.gGd.setOnClickListener(onClickListener);
        this.gGf.setOnClickListener(onClickListener);
        this.gGg.setOnClickListener(onClickListener);
        this.gGh.setOnClickListener(onClickListener);
        this.gGi.setOnClickListener(onClickListener);
        this.gGe.setOnClickListener(onClickListener);
    }

    private void tk(int i) {
        this.gGa.findViewById(e.g.line0).setVisibility(i);
    }

    public void bsa() {
        if (this.gGd != null) {
            this.gGd.refresh();
        }
    }

    public void eJ(int i) {
        al.j(this.gGb, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gGa.getLayoutMode().setNightMode(i == 1);
        this.gGa.getLayoutMode().onModeChanged(this.gGb);
        bsa();
    }
}
