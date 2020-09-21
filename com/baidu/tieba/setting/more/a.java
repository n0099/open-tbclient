package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity lXU;
    private RelativeLayout lXV;
    private TextView lXW;
    private SettingTextTestNewView lXX;
    private ImageView lXY;
    private TbSettingTextTipView lXZ;
    private TbSettingTextTipView lYa;
    private TbSettingTextTipView lYb;
    private TbSettingTextTipView lYc;
    protected TextView lYd;
    private ProgressBar lYe;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.lXU = aboutActivity;
        bqT();
        a(dVar);
    }

    public void duc() {
        if (this.lYe != null) {
            this.lYe.setVisibility(0);
        }
    }

    public void cvO() {
        if (this.lYe != null) {
            this.lYe.setVisibility(8);
        }
    }

    private void bqT() {
        this.lXU.setContentView(R.layout.about_activity);
        this.lXV = (RelativeLayout) this.lXU.findViewById(R.id.parent);
        this.lXY = (ImageView) this.lXU.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.lXU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lXU.getPageContext().getString(R.string.version_info));
        this.lXW = (TextView) this.lXU.findViewById(R.id.text_versioninfo);
        this.lXX = (SettingTextTestNewView) this.lXU.findViewById(R.id.about_version_update);
        this.lXZ = (TbSettingTextTipView) this.lXU.findViewById(R.id.about_guide);
        this.lXZ.hideArrow();
        this.lYa = (TbSettingTextTipView) this.lXU.findViewById(R.id.tieba_protocol_text);
        this.lYa.hideArrow();
        this.lYb = (TbSettingTextTipView) this.lXU.findViewById(R.id.tieba_privacy_text);
        this.lYb.hideArrow();
        this.lYc = (TbSettingTextTipView) this.lXU.findViewById(R.id.tieba_tdou_use_introduce);
        this.lYc.hideArrow();
        this.lYe = (ProgressBar) this.lXU.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.lXW.setText(this.lXU.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.lXU.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.lYd = (TextView) this.lXU.findViewById(R.id.text_version_protoco);
        qg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.lXZ.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Hv(0);
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
                if (view == a.this.lYa) {
                    be.bkp().b(a.this.lXU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.lYb) {
                    be.bkp().a(a.this.lXU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.lYc) {
                    be.bkp().b(a.this.lXU.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.lXX) {
                    if (view != a.this.lXZ) {
                        if (view == a.this.lXY) {
                            dVar.Hu(4);
                            return;
                        }
                        return;
                    }
                    dVar.Hu(2);
                } else {
                    dVar.Hu(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.lXY && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Hu(5);
                    return true;
                }
                return false;
            }
        };
        this.lXX.setOnClickListener(onClickListener);
        this.lXZ.setOnClickListener(onClickListener);
        this.lYa.setOnClickListener(onClickListener);
        this.lYb.setOnClickListener(onClickListener);
        this.lYc.setOnClickListener(onClickListener);
        this.lXY.setOnClickListener(onClickListener);
        this.lXY.setOnLongClickListener(onLongClickListener);
    }

    private void Hv(int i) {
        this.lXU.findViewById(R.id.line0).setVisibility(i);
    }

    public void dud() {
        if (this.lXX != null) {
            this.lXX.refresh();
        }
    }

    public void qg(int i) {
        ap.setBackgroundColor(this.lXV, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lXU.getLayoutMode().setNightMode(i == 1);
        this.lXU.getLayoutMode().onModeChanged(this.lXV);
        dud();
    }
}
