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
    private AboutActivity gLR;
    private RelativeLayout gLS;
    private TextView gLT;
    private SettingTextTestNewView gLU;
    private ImageView gLV;
    private TbSettingTextTipView gLW;
    private TbSettingTextTipView gLX;
    private TbSettingTextTipView gLY;
    private TbSettingTextTipView gLZ;
    protected TextView gMa;
    private ProgressBar gMb;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gLR = aboutActivity;
        Ju();
        a(cVar);
    }

    public void bqg() {
        if (this.gMb != null) {
            this.gMb.setVisibility(0);
        }
    }

    public void azS() {
        if (this.gMb != null) {
            this.gMb.setVisibility(8);
        }
    }

    private void Ju() {
        this.gLR.setContentView(d.h.about_activity);
        this.gLS = (RelativeLayout) this.gLR.findViewById(d.g.parent);
        this.gLV = (ImageView) this.gLR.findViewById(d.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gLR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gLR.getPageContext().getString(d.j.version_info));
        this.gLT = (TextView) this.gLR.findViewById(d.g.text_versioninfo);
        this.gLU = (SettingTextTestNewView) this.gLR.findViewById(d.g.about_version_update);
        this.gLW = (TbSettingTextTipView) this.gLR.findViewById(d.g.about_guide);
        this.gLW.hideArrow();
        this.gLX = (TbSettingTextTipView) this.gLR.findViewById(d.g.tieba_protocol_text);
        this.gLX.hideArrow();
        this.gLY = (TbSettingTextTipView) this.gLR.findViewById(d.g.tieba_privacy_text);
        this.gLY.hideArrow();
        this.gLZ = (TbSettingTextTipView) this.gLR.findViewById(d.g.tieba_tdou_use_introduce);
        this.gLZ.hideArrow();
        this.gMb = (ProgressBar) this.gLR.findViewById(d.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !am.isEmpty(TbConfig.getSubVersion())) {
            version = version + Constants.DOT + TbConfig.getSubVersion();
        }
        this.gLT.setText(this.gLR.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gLR.getPageContext().getString(d.j.setting_version_text) + " " + version);
        this.gMa = (TextView) this.gLR.findViewById(d.g.text_version_protoco);
        hr(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gLW.setVisibility(8);
            this.gLR.findViewById(d.g.line_about_guide).setVisibility(8);
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
                if (view == a.this.gLX) {
                    aw.Dt().c(a.this.gLR.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gLY) {
                    aw.Dt().a(a.this.gLR.getPageContext(), new String[]{"http://www.baidu.com/duty/wise/wise_secretright.html"}, true);
                } else if (view == a.this.gLZ) {
                    aw.Dt().c(a.this.gLR.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gLU) {
                    if (view != a.this.gLW) {
                        if (view == a.this.gLV) {
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
        this.gLU.setOnClickListener(onClickListener);
        this.gLW.setOnClickListener(onClickListener);
        this.gLX.setOnClickListener(onClickListener);
        this.gLY.setOnClickListener(onClickListener);
        this.gLZ.setOnClickListener(onClickListener);
        this.gLV.setOnClickListener(onClickListener);
    }

    private void uR(int i) {
        this.gLR.findViewById(d.g.line0).setVisibility(i);
    }

    public void bqh() {
        if (this.gLU != null) {
            this.gLU.refresh();
        }
    }

    public void hr(int i) {
        aj.t(this.gLS, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gLR.getLayoutMode().aQ(i == 1);
        this.gLR.getLayoutMode().aM(this.gLS);
        bqh();
    }
}
