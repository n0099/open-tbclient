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
    private AboutActivity iJW;
    private RelativeLayout iJX;
    private TextView iJY;
    private SettingTextTestNewView iJZ;
    private ImageView iKa;
    private TbSettingTextTipView iKb;
    private TbSettingTextTipView iKc;
    private TbSettingTextTipView iKd;
    private TbSettingTextTipView iKe;
    protected TextView iKf;
    private ProgressBar iKg;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iJW = aboutActivity;
        apq();
        a(dVar);
    }

    public void cgS() {
        if (this.iKg != null) {
            this.iKg.setVisibility(0);
        }
    }

    public void bpG() {
        if (this.iKg != null) {
            this.iKg.setVisibility(8);
        }
    }

    private void apq() {
        this.iJW.setContentView(R.layout.about_activity);
        this.iJX = (RelativeLayout) this.iJW.findViewById(R.id.parent);
        this.iKa = (ImageView) this.iJW.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iJW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iJW.getPageContext().getString(R.string.version_info));
        this.iJY = (TextView) this.iJW.findViewById(R.id.text_versioninfo);
        this.iJZ = (SettingTextTestNewView) this.iJW.findViewById(R.id.about_version_update);
        this.iKb = (TbSettingTextTipView) this.iJW.findViewById(R.id.about_guide);
        this.iKb.hideArrow();
        this.iKc = (TbSettingTextTipView) this.iJW.findViewById(R.id.tieba_protocol_text);
        this.iKc.hideArrow();
        this.iKd = (TbSettingTextTipView) this.iJW.findViewById(R.id.tieba_privacy_text);
        this.iKd.hideArrow();
        this.iKe = (TbSettingTextTipView) this.iJW.findViewById(R.id.tieba_tdou_use_introduce);
        this.iKe.hideArrow();
        this.iKg = (ProgressBar) this.iJW.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iJY.setText(this.iJW.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iJW.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iKf = (TextView) this.iJW.findViewById(R.id.text_version_protoco);
        jT(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iKb.setVisibility(8);
            this.iJW.findViewById(R.id.line_about_guide).setVisibility(8);
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
                if (view == a.this.iKc) {
                    ba.aiz().c(a.this.iJW.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iKd) {
                    ba.aiz().a(a.this.iJW.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iKe) {
                    ba.aiz().c(a.this.iJW.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iJZ) {
                    if (view != a.this.iKb) {
                        if (view == a.this.iKa) {
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
        this.iJZ.setOnClickListener(onClickListener);
        this.iKb.setOnClickListener(onClickListener);
        this.iKc.setOnClickListener(onClickListener);
        this.iKd.setOnClickListener(onClickListener);
        this.iKe.setOnClickListener(onClickListener);
        this.iKa.setOnClickListener(onClickListener);
    }

    private void zC(int i) {
        this.iJW.findViewById(R.id.line0).setVisibility(i);
    }

    public void cgT() {
        if (this.iJZ != null) {
            this.iJZ.refresh();
        }
    }

    public void jT(int i) {
        al.l(this.iJX, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iJW.getLayoutMode().setNightMode(i == 1);
        this.iJW.getLayoutMode().onModeChanged(this.iJX);
        cgT();
    }
}
