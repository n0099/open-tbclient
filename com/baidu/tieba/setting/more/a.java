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
    private AboutActivity gip;
    private RelativeLayout giq;
    private TextView gir;
    private SettingTextTestNewView gis;
    private ImageView git;
    private TbSettingTextTipView giu;
    private TbSettingTextTipView giv;
    private TbSettingTextTipView giw;
    private TbSettingTextTipView gix;
    protected TextView giy;
    private ProgressBar giz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gip = aboutActivity;
        BZ();
        a(cVar);
    }

    public void blp() {
        if (this.giz != null) {
            this.giz.setVisibility(0);
        }
    }

    public void auK() {
        if (this.giz != null) {
            this.giz.setVisibility(8);
        }
    }

    private void BZ() {
        this.gip.setContentView(d.i.about_activity);
        this.giq = (RelativeLayout) this.gip.findViewById(d.g.parent);
        this.git = (ImageView) this.gip.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gip.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gip.getPageContext().getString(d.k.version_info));
        this.gir = (TextView) this.gip.findViewById(d.g.text_versioninfo);
        this.gis = (SettingTextTestNewView) this.gip.findViewById(d.g.about_version_update);
        this.giu = (TbSettingTextTipView) this.gip.findViewById(d.g.about_guide);
        this.giu.hideArrow();
        this.giv = (TbSettingTextTipView) this.gip.findViewById(d.g.tieba_protocol_text);
        this.giv.hideArrow();
        this.giw = (TbSettingTextTipView) this.gip.findViewById(d.g.tieba_privacy_text);
        this.giw.hideArrow();
        this.gix = (TbSettingTextTipView) this.gip.findViewById(d.g.tieba_tdou_use_introduce);
        this.gix.hideArrow();
        this.giz = (ProgressBar) this.gip.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !an.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.gir.setText(this.gip.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gip.getPageContext().getString(d.k.setting_version_text) + " " + version);
        this.giy = (TextView) this.gip.findViewById(d.g.text_version_protoco);
        eq(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.giu.setVisibility(8);
            this.gip.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            ss(0);
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
                if (view2 == a.this.giv) {
                    ax.wf().c(a.this.gip.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view2 == a.this.giw) {
                    ax.wf().a(a.this.gip.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view2 == a.this.gix) {
                    ax.wf().c(a.this.gip.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view2 != a.this.gis) {
                    if (view2 != a.this.giu) {
                        if (view2 == a.this.git) {
                            cVar.sr(4);
                            return;
                        }
                        return;
                    }
                    cVar.sr(2);
                } else {
                    cVar.sr(1);
                }
            }
        };
        this.gis.setOnClickListener(onClickListener);
        this.giu.setOnClickListener(onClickListener);
        this.giv.setOnClickListener(onClickListener);
        this.giw.setOnClickListener(onClickListener);
        this.gix.setOnClickListener(onClickListener);
        this.git.setOnClickListener(onClickListener);
    }

    private void ss(int i) {
        this.gip.findViewById(d.g.line0).setVisibility(i);
    }

    public void blq() {
        if (this.gis != null) {
            this.gis.refresh();
        }
    }

    public void eq(int i) {
        ak.j(this.giq, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gip.getLayoutMode().setNightMode(i == 1);
        this.gip.getLayoutMode().u(this.giq);
        blq();
    }
}
