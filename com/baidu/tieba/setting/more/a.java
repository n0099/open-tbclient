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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gMg;
    private RelativeLayout gMh;
    private TextView gMi;
    private SettingTextTestNewView gMj;
    private ImageView gMk;
    private TbSettingTextTipView gMl;
    private TbSettingTextTipView gMm;
    private TbSettingTextTipView gMn;
    private TbSettingTextTipView gMo;
    protected TextView gMp;
    private ProgressBar gMq;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gMg = aboutActivity;
        Jv();
        a(cVar);
    }

    public void bqh() {
        if (this.gMq != null) {
            this.gMq.setVisibility(0);
        }
    }

    public void azT() {
        if (this.gMq != null) {
            this.gMq.setVisibility(8);
        }
    }

    private void Jv() {
        this.gMg.setContentView(d.h.about_activity);
        this.gMh = (RelativeLayout) this.gMg.findViewById(d.g.parent);
        this.gMk = (ImageView) this.gMg.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gMg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMg.getPageContext().getString(d.j.version_info));
        this.gMi = (TextView) this.gMg.findViewById(d.g.text_versioninfo);
        this.gMj = (SettingTextTestNewView) this.gMg.findViewById(d.g.about_version_update);
        this.gMl = (TbSettingTextTipView) this.gMg.findViewById(d.g.about_guide);
        this.gMl.hideArrow();
        this.gMm = (TbSettingTextTipView) this.gMg.findViewById(d.g.tieba_protocol_text);
        this.gMm.hideArrow();
        this.gMn = (TbSettingTextTipView) this.gMg.findViewById(d.g.tieba_privacy_text);
        this.gMn.hideArrow();
        this.gMo = (TbSettingTextTipView) this.gMg.findViewById(d.g.tieba_tdou_use_introduce);
        this.gMo.hideArrow();
        this.gMq = (ProgressBar) this.gMg.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !am.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.gMi.setText(this.gMg.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gMg.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.gMp = (TextView) this.gMg.findViewById(d.g.text_version_protoco);
        hr(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gMl.setVisibility(8);
            this.gMg.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            uQ(0);
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
                if (view == a.this.gMm) {
                    aw.Du().c(a.this.gMg.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gMn) {
                    aw.Du().a(a.this.gMg.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gMo) {
                    aw.Du().c(a.this.gMg.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gMj) {
                    if (view != a.this.gMl) {
                        if (view == a.this.gMk) {
                            cVar.uP(4);
                            return;
                        }
                        return;
                    }
                    cVar.uP(2);
                } else {
                    cVar.uP(1);
                }
            }
        };
        this.gMj.setOnClickListener(onClickListener);
        this.gMl.setOnClickListener(onClickListener);
        this.gMm.setOnClickListener(onClickListener);
        this.gMn.setOnClickListener(onClickListener);
        this.gMo.setOnClickListener(onClickListener);
        this.gMk.setOnClickListener(onClickListener);
    }

    private void uQ(int i) {
        this.gMg.findViewById(d.g.line0).setVisibility(i);
    }

    public void bqi() {
        if (this.gMj != null) {
            this.gMj.refresh();
        }
    }

    public void hr(int i) {
        aj.t(this.gMh, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gMg.getLayoutMode().aQ(i == 1);
        this.gMg.getLayoutMode().aM(this.gMh);
        bqi();
    }
}
