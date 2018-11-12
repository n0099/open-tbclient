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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity gOW;
    private RelativeLayout gOX;
    private TextView gOY;
    private SettingTextTestNewView gOZ;
    private ImageView gPa;
    private TbSettingTextTipView gPb;
    private TbSettingTextTipView gPc;
    private TbSettingTextTipView gPd;
    private TbSettingTextTipView gPe;
    protected TextView gPf;
    private ProgressBar gPg;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, c cVar) {
        super(aboutActivity.getPageContext());
        this.gOW = aboutActivity;
        Jt();
        a(cVar);
    }

    public void buK() {
        if (this.gPg != null) {
            this.gPg.setVisibility(0);
        }
    }

    public void aFc() {
        if (this.gPg != null) {
            this.gPg.setVisibility(8);
        }
    }

    private void Jt() {
        this.gOW.setContentView(e.h.about_activity);
        this.gOX = (RelativeLayout) this.gOW.findViewById(e.g.parent);
        this.gPa = (ImageView) this.gOW.findViewById(e.g.image_logo);
        this.mNavigationBar = (NavigationBar) this.gOW.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gOW.getPageContext().getString(e.j.version_info));
        this.gOY = (TextView) this.gOW.findViewById(e.g.text_versioninfo);
        this.gOZ = (SettingTextTestNewView) this.gOW.findViewById(e.g.about_version_update);
        this.gPb = (TbSettingTextTipView) this.gOW.findViewById(e.g.about_guide);
        this.gPb.hideArrow();
        this.gPc = (TbSettingTextTipView) this.gOW.findViewById(e.g.tieba_protocol_text);
        this.gPc.hideArrow();
        this.gPd = (TbSettingTextTipView) this.gOW.findViewById(e.g.tieba_privacy_text);
        this.gPd.hideArrow();
        this.gPe = (TbSettingTextTipView) this.gOW.findViewById(e.g.tieba_tdou_use_introduce);
        this.gPe.hideArrow();
        this.gPg = (ProgressBar) this.gOW.findViewById(e.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ao.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.gOY.setText(this.gOW.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.gOW.getPageContext().getString(e.j.setting_version_text) + " " + version);
        this.gPf = (TextView) this.gOW.findViewById(e.g.text_version_protoco);
        fg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.gPb.setVisibility(8);
            this.gOW.findViewById(e.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("debug_plugin_switcher", false)) {
            ua(0);
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
                if (view == a.this.gPc) {
                    ay.Db().c(a.this.gOW.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.gPd) {
                    ay.Db().a(a.this.gOW.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.gPe) {
                    ay.Db().c(a.this.gOW.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.gOZ) {
                    if (view != a.this.gPb) {
                        if (view == a.this.gPa) {
                            cVar.tZ(4);
                            return;
                        }
                        return;
                    }
                    cVar.tZ(2);
                } else {
                    cVar.tZ(1);
                }
            }
        };
        this.gOZ.setOnClickListener(onClickListener);
        this.gPb.setOnClickListener(onClickListener);
        this.gPc.setOnClickListener(onClickListener);
        this.gPd.setOnClickListener(onClickListener);
        this.gPe.setOnClickListener(onClickListener);
        this.gPa.setOnClickListener(onClickListener);
    }

    private void ua(int i) {
        this.gOW.findViewById(e.g.line0).setVisibility(i);
    }

    public void buL() {
        if (this.gOZ != null) {
            this.gOZ.refresh();
        }
    }

    public void fg(int i) {
        al.j(this.gOX, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOW.getLayoutMode().setNightMode(i == 1);
        this.gOW.getLayoutMode().onModeChanged(this.gOX);
        buL();
    }
}
