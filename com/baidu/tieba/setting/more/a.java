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
    private AboutActivity iJU;
    private RelativeLayout iJV;
    private TextView iJW;
    private SettingTextTestNewView iJX;
    private ImageView iJY;
    private TbSettingTextTipView iJZ;
    private TbSettingTextTipView iKa;
    private TbSettingTextTipView iKb;
    private TbSettingTextTipView iKc;
    protected TextView iKd;
    private ProgressBar iKe;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iJU = aboutActivity;
        apq();
        a(dVar);
    }

    public void cgQ() {
        if (this.iKe != null) {
            this.iKe.setVisibility(0);
        }
    }

    public void bpD() {
        if (this.iKe != null) {
            this.iKe.setVisibility(8);
        }
    }

    private void apq() {
        this.iJU.setContentView(R.layout.about_activity);
        this.iJV = (RelativeLayout) this.iJU.findViewById(R.id.parent);
        this.iJY = (ImageView) this.iJU.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iJU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iJU.getPageContext().getString(R.string.version_info));
        this.iJW = (TextView) this.iJU.findViewById(R.id.text_versioninfo);
        this.iJX = (SettingTextTestNewView) this.iJU.findViewById(R.id.about_version_update);
        this.iJZ = (TbSettingTextTipView) this.iJU.findViewById(R.id.about_guide);
        this.iJZ.hideArrow();
        this.iKa = (TbSettingTextTipView) this.iJU.findViewById(R.id.tieba_protocol_text);
        this.iKa.hideArrow();
        this.iKb = (TbSettingTextTipView) this.iJU.findViewById(R.id.tieba_privacy_text);
        this.iKb.hideArrow();
        this.iKc = (TbSettingTextTipView) this.iJU.findViewById(R.id.tieba_tdou_use_introduce);
        this.iKc.hideArrow();
        this.iKe = (ProgressBar) this.iJU.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iJW.setText(this.iJU.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iJU.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iKd = (TextView) this.iJU.findViewById(R.id.text_version_protoco);
        jT(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iJZ.setVisibility(8);
            this.iJU.findViewById(R.id.line_about_guide).setVisibility(8);
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
                if (view == a.this.iKa) {
                    ba.aiz().c(a.this.iJU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iKb) {
                    ba.aiz().a(a.this.iJU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iKc) {
                    ba.aiz().c(a.this.iJU.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iJX) {
                    if (view != a.this.iJZ) {
                        if (view == a.this.iJY) {
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
        this.iJX.setOnClickListener(onClickListener);
        this.iJZ.setOnClickListener(onClickListener);
        this.iKa.setOnClickListener(onClickListener);
        this.iKb.setOnClickListener(onClickListener);
        this.iKc.setOnClickListener(onClickListener);
        this.iJY.setOnClickListener(onClickListener);
    }

    private void zC(int i) {
        this.iJU.findViewById(R.id.line0).setVisibility(i);
    }

    public void cgR() {
        if (this.iJX != null) {
            this.iJX.refresh();
        }
    }

    public void jT(int i) {
        al.l(this.iJV, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iJU.getLayoutMode().setNightMode(i == 1);
        this.iJU.getLayoutMode().onModeChanged(this.iJV);
        cgR();
    }
}
