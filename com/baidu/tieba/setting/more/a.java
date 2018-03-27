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
    private AboutActivity gMh;
    private RelativeLayout gMi;
    private TextView gMj;
    private SettingTextTestNewView gMk;
    private ImageView gMl;
    private TbSettingTextTipView gMm;
    private TbSettingTextTipView gMn;
    private TbSettingTextTipView gMo;
    private TbSettingTextTipView gMp;
    protected TextView gMq;
    private ProgressBar gMr;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gMh = aboutActivity;
        Jv();
        a(cVar);
    }

    public void bqh() {
        if (this.gMr != null) {
            this.gMr.setVisibility(0);
        }
    }

    public void azU() {
        if (this.gMr != null) {
            this.gMr.setVisibility(8);
        }
    }

    private void Jv() {
        this.gMh.setContentView(d.h.about_activity);
        this.gMi = (RelativeLayout) this.gMh.findViewById(d.g.parent);
        this.gMl = (ImageView) this.gMh.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gMh.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMh.getPageContext().getString(d.j.version_info));
        this.gMj = (TextView) this.gMh.findViewById(d.g.text_versioninfo);
        this.gMk = (SettingTextTestNewView) this.gMh.findViewById(d.g.about_version_update);
        this.gMm = (TbSettingTextTipView) this.gMh.findViewById(d.g.about_guide);
        this.gMm.hideArrow();
        this.gMn = (TbSettingTextTipView) this.gMh.findViewById(d.g.tieba_protocol_text);
        this.gMn.hideArrow();
        this.gMo = (TbSettingTextTipView) this.gMh.findViewById(d.g.tieba_privacy_text);
        this.gMo.hideArrow();
        this.gMp = (TbSettingTextTipView) this.gMh.findViewById(d.g.tieba_tdou_use_introduce);
        this.gMp.hideArrow();
        this.gMr = (ProgressBar) this.gMh.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !am.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.gMj.setText(this.gMh.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gMh.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.gMq = (TextView) this.gMh.findViewById(d.g.text_version_protoco);
        hr(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gMm.setVisibility(8);
            this.gMh.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            uR(0);
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
                if (view == a.this.gMn) {
                    aw.Du().c(a.this.gMh.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gMo) {
                    aw.Du().a(a.this.gMh.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gMp) {
                    aw.Du().c(a.this.gMh.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gMk) {
                    if (view != a.this.gMm) {
                        if (view == a.this.gMl) {
                            cVar.uQ(4);
                            return;
                        }
                        return;
                    }
                    cVar.uQ(2);
                } else {
                    cVar.uQ(1);
                }
            }
        };
        this.gMk.setOnClickListener(onClickListener);
        this.gMm.setOnClickListener(onClickListener);
        this.gMn.setOnClickListener(onClickListener);
        this.gMo.setOnClickListener(onClickListener);
        this.gMp.setOnClickListener(onClickListener);
        this.gMl.setOnClickListener(onClickListener);
    }

    private void uR(int i) {
        this.gMh.findViewById(d.g.line0).setVisibility(i);
    }

    public void bqi() {
        if (this.gMk != null) {
            this.gMk.refresh();
        }
    }

    public void hr(int i) {
        aj.t(this.gMi, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gMh.getLayoutMode().aQ(i == 1);
        this.gMh.getLayoutMode().aM(this.gMi);
        bqi();
    }
}
