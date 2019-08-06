package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private ImageView iRA;
    private TbSettingTextTipView iRB;
    private TbSettingTextTipView iRC;
    private TbSettingTextTipView iRD;
    private TbSettingTextTipView iRE;
    protected TextView iRF;
    private ProgressBar iRG;
    private AboutActivity iRw;
    private RelativeLayout iRx;
    private TextView iRy;
    private SettingTextTestNewView iRz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iRw = aboutActivity;
        aqx();
        a(dVar);
    }

    public void ckc() {
        if (this.iRG != null) {
            this.iRG.setVisibility(0);
        }
    }

    public void brW() {
        if (this.iRG != null) {
            this.iRG.setVisibility(8);
        }
    }

    private void aqx() {
        this.iRw.setContentView(R.layout.about_activity);
        this.iRx = (RelativeLayout) this.iRw.findViewById(R.id.parent);
        this.iRA = (ImageView) this.iRw.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iRw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iRw.getPageContext().getString(R.string.version_info));
        this.iRy = (TextView) this.iRw.findViewById(R.id.text_versioninfo);
        this.iRz = (SettingTextTestNewView) this.iRw.findViewById(R.id.about_version_update);
        this.iRB = (TbSettingTextTipView) this.iRw.findViewById(R.id.about_guide);
        this.iRB.hideArrow();
        this.iRC = (TbSettingTextTipView) this.iRw.findViewById(R.id.tieba_protocol_text);
        this.iRC.hideArrow();
        this.iRD = (TbSettingTextTipView) this.iRw.findViewById(R.id.tieba_privacy_text);
        this.iRD.hideArrow();
        this.iRE = (TbSettingTextTipView) this.iRw.findViewById(R.id.tieba_tdou_use_introduce);
        this.iRE.hideArrow();
        this.iRG = (ProgressBar) this.iRw.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iRy.setText(this.iRw.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iRw.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iRF = (TextView) this.iRw.findViewById(R.id.text_version_protoco);
        ka(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iRB.setVisibility(8);
            this.iRw.findViewById(R.id.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("debug_plugin_switcher", false)) {
            Ak(0);
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
                if (view == a.this.iRC) {
                    bb.ajE().c(a.this.iRw.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iRD) {
                    bb.ajE().a(a.this.iRw.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iRE) {
                    bb.ajE().c(a.this.iRw.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iRz) {
                    if (view != a.this.iRB) {
                        if (view == a.this.iRA) {
                            dVar.Aj(4);
                            return;
                        }
                        return;
                    }
                    dVar.Aj(2);
                } else {
                    dVar.Aj(1);
                }
            }
        };
        this.iRz.setOnClickListener(onClickListener);
        this.iRB.setOnClickListener(onClickListener);
        this.iRC.setOnClickListener(onClickListener);
        this.iRD.setOnClickListener(onClickListener);
        this.iRE.setOnClickListener(onClickListener);
        this.iRA.setOnClickListener(onClickListener);
    }

    private void Ak(int i) {
        this.iRw.findViewById(R.id.line0).setVisibility(i);
    }

    public void ckd() {
        if (this.iRz != null) {
            this.iRz.refresh();
        }
    }

    public void ka(int i) {
        am.l(this.iRx, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iRw.getLayoutMode().setNightMode(i == 1);
        this.iRw.getLayoutMode().onModeChanged(this.iRx);
        ckd();
    }
}
