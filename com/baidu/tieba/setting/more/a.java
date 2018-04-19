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
    private AboutActivity ghl;
    private RelativeLayout ghm;
    private TextView ghn;
    private SettingTextTestNewView gho;
    private ImageView ghp;
    private TbSettingTextTipView ghq;
    private TbSettingTextTipView ghr;
    private TbSettingTextTipView ghs;
    private TbSettingTextTipView ght;
    protected TextView ghu;
    private ProgressBar ghv;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.ghl = aboutActivity;
        Cb();
        a(cVar);
    }

    public void blq() {
        if (this.ghv != null) {
            this.ghv.setVisibility(0);
        }
    }

    public void auL() {
        if (this.ghv != null) {
            this.ghv.setVisibility(8);
        }
    }

    private void Cb() {
        this.ghl.setContentView(d.i.about_activity);
        this.ghm = (RelativeLayout) this.ghl.findViewById(d.g.parent);
        this.ghp = (ImageView) this.ghl.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.ghl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ghl.getPageContext().getString(d.k.version_info));
        this.ghn = (TextView) this.ghl.findViewById(d.g.text_versioninfo);
        this.gho = (SettingTextTestNewView) this.ghl.findViewById(d.g.about_version_update);
        this.ghq = (TbSettingTextTipView) this.ghl.findViewById(d.g.about_guide);
        this.ghq.hideArrow();
        this.ghr = (TbSettingTextTipView) this.ghl.findViewById(d.g.tieba_protocol_text);
        this.ghr.hideArrow();
        this.ghs = (TbSettingTextTipView) this.ghl.findViewById(d.g.tieba_privacy_text);
        this.ghs.hideArrow();
        this.ght = (TbSettingTextTipView) this.ghl.findViewById(d.g.tieba_tdou_use_introduce);
        this.ght.hideArrow();
        this.ghv = (ProgressBar) this.ghl.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !an.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.ghn.setText(this.ghl.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.ghl.getPageContext().getString(d.k.setting_version_text) + " " + version);
        this.ghu = (TextView) this.ghl.findViewById(d.g.text_version_protoco);
        ep(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.ghq.setVisibility(8);
            this.ghl.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view2 == a.this.ghr) {
                    ax.wg().c(a.this.ghl.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view2 == a.this.ghs) {
                    ax.wg().a(a.this.ghl.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view2 == a.this.ght) {
                    ax.wg().c(a.this.ghl.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view2 != a.this.gho) {
                    if (view2 != a.this.ghq) {
                        if (view2 == a.this.ghp) {
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
        this.gho.setOnClickListener(onClickListener);
        this.ghq.setOnClickListener(onClickListener);
        this.ghr.setOnClickListener(onClickListener);
        this.ghs.setOnClickListener(onClickListener);
        this.ght.setOnClickListener(onClickListener);
        this.ghp.setOnClickListener(onClickListener);
    }

    private void st(int i) {
        this.ghl.findViewById(d.g.line0).setVisibility(i);
    }

    public void blr() {
        if (this.gho != null) {
            this.gho.refresh();
        }
    }

    public void ep(int i) {
        ak.j(this.ghm, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ghl.getLayoutMode().setNightMode(i == 1);
        this.ghl.getLayoutMode().u(this.ghm);
        blr();
    }
}
