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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity iKa;
    private RelativeLayout iKb;
    private TextView iKc;
    private SettingTextTestNewView iKd;
    private ImageView iKe;
    private TbSettingTextTipView iKf;
    private TbSettingTextTipView iKg;
    private TbSettingTextTipView iKh;
    private TbSettingTextTipView iKi;
    protected TextView iKj;
    private ProgressBar iKk;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iKa = aboutActivity;
        apq();
        a(dVar);
    }

    public void cgT() {
        if (this.iKk != null) {
            this.iKk.setVisibility(0);
        }
    }

    public void bpI() {
        if (this.iKk != null) {
            this.iKk.setVisibility(8);
        }
    }

    private void apq() {
        this.iKa.setContentView(R.layout.about_activity);
        this.iKb = (RelativeLayout) this.iKa.findViewById(R.id.parent);
        this.iKe = (ImageView) this.iKa.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iKa.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKa.getPageContext().getString(R.string.version_info));
        this.iKc = (TextView) this.iKa.findViewById(R.id.text_versioninfo);
        this.iKd = (SettingTextTestNewView) this.iKa.findViewById(R.id.about_version_update);
        this.iKf = (TbSettingTextTipView) this.iKa.findViewById(R.id.about_guide);
        this.iKf.hideArrow();
        this.iKg = (TbSettingTextTipView) this.iKa.findViewById(R.id.tieba_protocol_text);
        this.iKg.hideArrow();
        this.iKh = (TbSettingTextTipView) this.iKa.findViewById(R.id.tieba_privacy_text);
        this.iKh.hideArrow();
        this.iKi = (TbSettingTextTipView) this.iKa.findViewById(R.id.tieba_tdou_use_introduce);
        this.iKi.hideArrow();
        this.iKk = (ProgressBar) this.iKa.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iKc.setText(this.iKa.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iKa.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iKj = (TextView) this.iKa.findViewById(R.id.text_version_protoco);
        jT(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iKf.setVisibility(8);
            this.iKa.findViewById(R.id.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("debug_plugin_switcher", false)) {
            zC(0);
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
                if (view == a.this.iKg) {
                    ba.aiz().c(a.this.iKa.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iKh) {
                    ba.aiz().a(a.this.iKa.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iKi) {
                    ba.aiz().c(a.this.iKa.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iKd) {
                    if (view != a.this.iKf) {
                        if (view == a.this.iKe) {
                            dVar.zB(4);
                            return;
                        }
                        return;
                    }
                    dVar.zB(2);
                } else {
                    dVar.zB(1);
                }
            }
        };
        this.iKd.setOnClickListener(onClickListener);
        this.iKf.setOnClickListener(onClickListener);
        this.iKg.setOnClickListener(onClickListener);
        this.iKh.setOnClickListener(onClickListener);
        this.iKi.setOnClickListener(onClickListener);
        this.iKe.setOnClickListener(onClickListener);
    }

    private void zC(int i) {
        this.iKa.findViewById(R.id.line0).setVisibility(i);
    }

    public void cgU() {
        if (this.iKd != null) {
            this.iKd.refresh();
        }
    }

    public void jT(int i) {
        al.l(this.iKb, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iKa.getLayoutMode().setNightMode(i == 1);
        this.iKa.getLayoutMode().onModeChanged(this.iKb);
        cgU();
    }
}
