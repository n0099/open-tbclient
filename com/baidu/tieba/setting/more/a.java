package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity ghi;
    private RelativeLayout ghj;
    private TextView ghk;
    private SettingTextTestNewView ghl;
    private ImageView ghm;
    private TbSettingTextTipView ghn;
    private TbSettingTextTipView gho;
    private TbSettingTextTipView ghp;
    private TbSettingTextTipView ghq;
    protected TextView ghr;
    private ProgressBar ghs;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.ghi = aboutActivity;
        Cb();
        a(cVar);
    }

    public void blq() {
        if (this.ghs != null) {
            this.ghs.setVisibility(0);
        }
    }

    public void auL() {
        if (this.ghs != null) {
            this.ghs.setVisibility(8);
        }
    }

    private void Cb() {
        this.ghi.setContentView(d.i.about_activity);
        this.ghj = (RelativeLayout) this.ghi.findViewById(d.g.parent);
        this.ghm = (ImageView) this.ghi.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.ghi.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ghi.getPageContext().getString(d.k.version_info));
        this.ghk = (TextView) this.ghi.findViewById(d.g.text_versioninfo);
        this.ghl = (SettingTextTestNewView) this.ghi.findViewById(d.g.about_version_update);
        this.ghn = (TbSettingTextTipView) this.ghi.findViewById(d.g.about_guide);
        this.ghn.hideArrow();
        this.gho = (TbSettingTextTipView) this.ghi.findViewById(d.g.tieba_protocol_text);
        this.gho.hideArrow();
        this.ghp = (TbSettingTextTipView) this.ghi.findViewById(d.g.tieba_privacy_text);
        this.ghp.hideArrow();
        this.ghq = (TbSettingTextTipView) this.ghi.findViewById(d.g.tieba_tdou_use_introduce);
        this.ghq.hideArrow();
        this.ghs = (ProgressBar) this.ghi.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !an.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.ghk.setText(this.ghi.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.ghi.getPageContext().getString(d.k.setting_version_text) + " " + version);
        this.ghr = (TextView) this.ghi.findViewById(d.g.text_version_protoco);
        ep(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.ghn.setVisibility(8);
            this.ghi.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            st(0);
        }
    }

    private void a(final c cVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.a.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == a.this.gho) {
                    ax.wg().c(a.this.ghi.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view2 == a.this.ghp) {
                    ax.wg().a(a.this.ghi.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view2 == a.this.ghq) {
                    ax.wg().c(a.this.ghi.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view2 != a.this.ghl) {
                    if (view2 != a.this.ghn) {
                        if (view2 == a.this.ghm) {
                            cVar.ss(4);
                            return;
                        }
                        return;
                    }
                    cVar.ss(2);
                } else {
                    cVar.ss(1);
                }
            }
        };
        this.ghl.setOnClickListener(onClickListener);
        this.ghn.setOnClickListener(onClickListener);
        this.gho.setOnClickListener(onClickListener);
        this.ghp.setOnClickListener(onClickListener);
        this.ghq.setOnClickListener(onClickListener);
        this.ghm.setOnClickListener(onClickListener);
    }

    private void st(int i) {
        this.ghi.findViewById(d.g.line0).setVisibility(i);
    }

    public void blr() {
        if (this.ghl != null) {
            this.ghl.refresh();
        }
    }

    public void ep(int i) {
        ak.j(this.ghj, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ghi.getLayoutMode().setNightMode(i == 1);
        this.ghi.getLayoutMode().u(this.ghj);
        blr();
    }
}
