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
    private AboutActivity irf;
    private RelativeLayout irg;
    private TextView irh;
    private SettingTextTestNewView iri;
    private ImageView irj;
    private TbSettingTextTipView irk;
    private TbSettingTextTipView irl;
    private TbSettingTextTipView irm;
    private TbSettingTextTipView irn;
    protected TextView iro;
    private ProgressBar irp;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.irf = aboutActivity;
        akn();
        a(dVar);
    }

    public void bYM() {
        if (this.irp != null) {
            this.irp.setVisibility(0);
        }
    }

    public void bin() {
        if (this.irp != null) {
            this.irp.setVisibility(8);
        }
    }

    private void akn() {
        this.irf.setContentView(d.h.about_activity);
        this.irg = (RelativeLayout) this.irf.findViewById(d.g.parent);
        this.irj = (ImageView) this.irf.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.irf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irf.getPageContext().getString(d.j.version_info));
        this.irh = (TextView) this.irf.findViewById(d.g.text_versioninfo);
        this.iri = (SettingTextTestNewView) this.irf.findViewById(d.g.about_version_update);
        this.irk = (TbSettingTextTipView) this.irf.findViewById(d.g.about_guide);
        this.irk.hideArrow();
        this.irl = (TbSettingTextTipView) this.irf.findViewById(d.g.tieba_protocol_text);
        this.irl.hideArrow();
        this.irm = (TbSettingTextTipView) this.irf.findViewById(d.g.tieba_privacy_text);
        this.irm.hideArrow();
        this.irn = (TbSettingTextTipView) this.irf.findViewById(d.g.tieba_tdou_use_introduce);
        this.irn.hideArrow();
        this.irp = (ProgressBar) this.irf.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.irh.setText(this.irf.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.irf.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.iro = (TextView) this.irf.findViewById(d.g.text_version_protoco);
        jf(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.irk.setVisibility(8);
            this.irf.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            yv(0);
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
                if (view == a.this.irl) {
                    ba.adA().c(a.this.irf.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.irm) {
                    ba.adA().a(a.this.irf.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.irn) {
                    ba.adA().c(a.this.irf.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iri) {
                    if (view != a.this.irk) {
                        if (view == a.this.irj) {
                            dVar.yu(4);
                            return;
                        }
                        return;
                    }
                    dVar.yu(2);
                } else {
                    dVar.yu(1);
                }
            }
        };
        this.iri.setOnClickListener(onClickListener);
        this.irk.setOnClickListener(onClickListener);
        this.irl.setOnClickListener(onClickListener);
        this.irm.setOnClickListener(onClickListener);
        this.irn.setOnClickListener(onClickListener);
        this.irj.setOnClickListener(onClickListener);
    }

    private void yv(int i) {
        this.irf.findViewById(d.g.line0).setVisibility(i);
    }

    public void bYN() {
        if (this.iri != null) {
            this.iri.refresh();
        }
    }

    public void jf(int i) {
        al.l(this.irg, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irf.getLayoutMode().setNightMode(i == 1);
        this.irf.getLayoutMode().onModeChanged(this.irg);
        bYN();
    }
}
