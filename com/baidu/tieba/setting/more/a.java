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
    private AboutActivity irg;
    private RelativeLayout irh;
    private TextView iri;
    private SettingTextTestNewView irj;
    private ImageView irk;
    private TbSettingTextTipView irl;
    private TbSettingTextTipView irm;
    private TbSettingTextTipView irn;
    private TbSettingTextTipView iro;
    protected TextView irp;
    private ProgressBar irq;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.irg = aboutActivity;
        akn();
        a(dVar);
    }

    public void bYM() {
        if (this.irq != null) {
            this.irq.setVisibility(0);
        }
    }

    public void bin() {
        if (this.irq != null) {
            this.irq.setVisibility(8);
        }
    }

    private void akn() {
        this.irg.setContentView(d.h.about_activity);
        this.irh = (RelativeLayout) this.irg.findViewById(d.g.parent);
        this.irk = (ImageView) this.irg.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.irg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irg.getPageContext().getString(d.j.version_info));
        this.iri = (TextView) this.irg.findViewById(d.g.text_versioninfo);
        this.irj = (SettingTextTestNewView) this.irg.findViewById(d.g.about_version_update);
        this.irl = (TbSettingTextTipView) this.irg.findViewById(d.g.about_guide);
        this.irl.hideArrow();
        this.irm = (TbSettingTextTipView) this.irg.findViewById(d.g.tieba_protocol_text);
        this.irm.hideArrow();
        this.irn = (TbSettingTextTipView) this.irg.findViewById(d.g.tieba_privacy_text);
        this.irn.hideArrow();
        this.iro = (TbSettingTextTipView) this.irg.findViewById(d.g.tieba_tdou_use_introduce);
        this.iro.hideArrow();
        this.irq = (ProgressBar) this.irg.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iri.setText(this.irg.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.irg.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.irp = (TextView) this.irg.findViewById(d.g.text_version_protoco);
        jf(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.irl.setVisibility(8);
            this.irg.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.irm) {
                    ba.adA().c(a.this.irg.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.irn) {
                    ba.adA().a(a.this.irg.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iro) {
                    ba.adA().c(a.this.irg.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.irj) {
                    if (view != a.this.irl) {
                        if (view == a.this.irk) {
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
        this.irj.setOnClickListener(onClickListener);
        this.irl.setOnClickListener(onClickListener);
        this.irm.setOnClickListener(onClickListener);
        this.irn.setOnClickListener(onClickListener);
        this.iro.setOnClickListener(onClickListener);
        this.irk.setOnClickListener(onClickListener);
    }

    private void yv(int i) {
        this.irg.findViewById(d.g.line0).setVisibility(i);
    }

    public void bYN() {
        if (this.irj != null) {
            this.irj.refresh();
        }
    }

    public void jf(int i) {
        al.l(this.irh, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irg.getLayoutMode().setNightMode(i == 1);
        this.irg.getLayoutMode().onModeChanged(this.irh);
        bYN();
    }
}
