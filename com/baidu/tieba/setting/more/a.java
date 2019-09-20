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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity iTR;
    private RelativeLayout iTS;
    private TextView iTT;
    private SettingTextTestNewView iTU;
    private ImageView iTV;
    private TbSettingTextTipView iTW;
    private TbSettingTextTipView iTX;
    private TbSettingTextTipView iTY;
    private TbSettingTextTipView iTZ;
    protected TextView iUa;
    private ProgressBar iUb;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iTR = aboutActivity;
        aqJ();
        a(dVar);
    }

    public void ckO() {
        if (this.iUb != null) {
            this.iUb.setVisibility(0);
        }
    }

    public void bsJ() {
        if (this.iUb != null) {
            this.iUb.setVisibility(8);
        }
    }

    private void aqJ() {
        this.iTR.setContentView(R.layout.about_activity);
        this.iTS = (RelativeLayout) this.iTR.findViewById(R.id.parent);
        this.iTV = (ImageView) this.iTR.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iTR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iTR.getPageContext().getString(R.string.version_info));
        this.iTT = (TextView) this.iTR.findViewById(R.id.text_versioninfo);
        this.iTU = (SettingTextTestNewView) this.iTR.findViewById(R.id.about_version_update);
        this.iTW = (TbSettingTextTipView) this.iTR.findViewById(R.id.about_guide);
        this.iTW.hideArrow();
        this.iTX = (TbSettingTextTipView) this.iTR.findViewById(R.id.tieba_protocol_text);
        this.iTX.hideArrow();
        this.iTY = (TbSettingTextTipView) this.iTR.findViewById(R.id.tieba_privacy_text);
        this.iTY.hideArrow();
        this.iTZ = (TbSettingTextTipView) this.iTR.findViewById(R.id.tieba_tdou_use_introduce);
        this.iTZ.hideArrow();
        this.iUb = (ProgressBar) this.iTR.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iTT.setText(this.iTR.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iTR.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iUa = (TextView) this.iTR.findViewById(R.id.text_version_protoco);
        kd(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iTW.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("debug_plugin_switcher", false)) {
            An(0);
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
                if (view == a.this.iTX) {
                    ba.ajK().c(a.this.iTR.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iTY) {
                    ba.ajK().a(a.this.iTR.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iTZ) {
                    ba.ajK().c(a.this.iTR.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iTU) {
                    if (view != a.this.iTW) {
                        if (view == a.this.iTV) {
                            dVar.Am(4);
                            return;
                        }
                        return;
                    }
                    dVar.Am(2);
                } else {
                    dVar.Am(1);
                }
            }
        };
        this.iTU.setOnClickListener(onClickListener);
        this.iTW.setOnClickListener(onClickListener);
        this.iTX.setOnClickListener(onClickListener);
        this.iTY.setOnClickListener(onClickListener);
        this.iTZ.setOnClickListener(onClickListener);
        this.iTV.setOnClickListener(onClickListener);
    }

    private void An(int i) {
        this.iTR.findViewById(R.id.line0).setVisibility(i);
    }

    public void ckP() {
        if (this.iTU != null) {
            this.iTU.refresh();
        }
    }

    public void kd(int i) {
        am.l(this.iTS, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iTR.getLayoutMode().setNightMode(i == 1);
        this.iTR.getLayoutMode().onModeChanged(this.iTS);
        ckP();
    }
}
