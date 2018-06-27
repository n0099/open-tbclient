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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gxA;
    private RelativeLayout gxB;
    private TextView gxC;
    private SettingTextTestNewView gxD;
    private ImageView gxE;
    private TbSettingTextTipView gxF;
    private TbSettingTextTipView gxG;
    private TbSettingTextTipView gxH;
    private TbSettingTextTipView gxI;
    protected TextView gxJ;
    private ProgressBar gxK;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gxA = aboutActivity;
        FU();
        a(cVar);
    }

    public void bqO() {
        if (this.gxK != null) {
            this.gxK.setVisibility(0);
        }
    }

    public void azA() {
        if (this.gxK != null) {
            this.gxK.setVisibility(8);
        }
    }

    private void FU() {
        this.gxA.setContentView(d.i.about_activity);
        this.gxB = (RelativeLayout) this.gxA.findViewById(d.g.parent);
        this.gxE = (ImageView) this.gxA.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gxA.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gxA.getPageContext().getString(d.k.version_info));
        this.gxC = (TextView) this.gxA.findViewById(d.g.text_versioninfo);
        this.gxD = (SettingTextTestNewView) this.gxA.findViewById(d.g.about_version_update);
        this.gxF = (TbSettingTextTipView) this.gxA.findViewById(d.g.about_guide);
        this.gxF.hideArrow();
        this.gxG = (TbSettingTextTipView) this.gxA.findViewById(d.g.tieba_protocol_text);
        this.gxG.hideArrow();
        this.gxH = (TbSettingTextTipView) this.gxA.findViewById(d.g.tieba_privacy_text);
        this.gxH.hideArrow();
        this.gxI = (TbSettingTextTipView) this.gxA.findViewById(d.g.tieba_tdou_use_introduce);
        this.gxI.hideArrow();
        this.gxK = (ProgressBar) this.gxA.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ap.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gxC.setText(this.gxA.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gxA.getPageContext().getString(d.k.setting_version_text) + " " + version);
        this.gxJ = (TextView) this.gxA.findViewById(d.g.text_version_protoco);
        ev(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gxF.setVisibility(8);
            this.gxA.findViewById(d.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            sO(0);
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
                if (view == a.this.gxG) {
                    az.zV().c(a.this.gxA.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gxH) {
                    az.zV().a(a.this.gxA.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gxI) {
                    az.zV().c(a.this.gxA.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gxD) {
                    if (view != a.this.gxF) {
                        if (view == a.this.gxE) {
                            cVar.sN(4);
                            return;
                        }
                        return;
                    }
                    cVar.sN(2);
                } else {
                    cVar.sN(1);
                }
            }
        };
        this.gxD.setOnClickListener(onClickListener);
        this.gxF.setOnClickListener(onClickListener);
        this.gxG.setOnClickListener(onClickListener);
        this.gxH.setOnClickListener(onClickListener);
        this.gxI.setOnClickListener(onClickListener);
        this.gxE.setOnClickListener(onClickListener);
    }

    private void sO(int i) {
        this.gxA.findViewById(d.g.line0).setVisibility(i);
    }

    public void bqP() {
        if (this.gxD != null) {
            this.gxD.refresh();
        }
    }

    public void ev(int i) {
        am.j(this.gxB, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gxA.getLayoutMode().setNightMode(i == 1);
        this.gxA.getLayoutMode().onModeChanged(this.gxB);
        bqP();
    }
}
