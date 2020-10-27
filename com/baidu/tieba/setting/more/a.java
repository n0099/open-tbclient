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
/* loaded from: classes26.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity mAb;
    private RelativeLayout mAc;
    private TextView mAd;
    private SettingTextTestNewView mAe;
    private ImageView mAf;
    private TbSettingTextTipView mAg;
    private TbSettingTextTipView mAh;
    private TbSettingTextTipView mAi;
    private TbSettingTextTipView mAj;
    protected TextView mAk;
    private ProgressBar mAl;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.mAb = aboutActivity;
        bvw();
        a(dVar);
    }

    public void dAV() {
        if (this.mAl != null) {
            this.mAl.setVisibility(0);
        }
    }

    public void cCs() {
        if (this.mAl != null) {
            this.mAl.setVisibility(8);
        }
    }

    private void bvw() {
        this.mAb.setContentView(R.layout.about_activity);
        this.mAc = (RelativeLayout) this.mAb.findViewById(R.id.parent);
        this.mAf = (ImageView) this.mAb.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mAb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mAb.getPageContext().getString(R.string.version_info));
        this.mAd = (TextView) this.mAb.findViewById(R.id.text_versioninfo);
        this.mAe = (SettingTextTestNewView) this.mAb.findViewById(R.id.about_version_update);
        this.mAg = (TbSettingTextTipView) this.mAb.findViewById(R.id.about_guide);
        this.mAg.hideArrow();
        this.mAh = (TbSettingTextTipView) this.mAb.findViewById(R.id.tieba_protocol_text);
        this.mAh.hideArrow();
        this.mAi = (TbSettingTextTipView) this.mAb.findViewById(R.id.tieba_privacy_text);
        this.mAi.hideArrow();
        this.mAj = (TbSettingTextTipView) this.mAb.findViewById(R.id.tieba_tdou_use_introduce);
        this.mAj.hideArrow();
        this.mAl = (ProgressBar) this.mAb.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mAd.setText(this.mAb.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mAb.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mAk = (TextView) this.mAb.findViewById(R.id.text_version_protoco);
        qP(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mAg.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Iu(0);
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
                if (view == a.this.mAh) {
                    be.boR().b(a.this.mAb.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mAi) {
                    be.boR().a(a.this.mAb.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mAj) {
                    be.boR().b(a.this.mAb.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mAe) {
                    if (view != a.this.mAg) {
                        if (view == a.this.mAf) {
                            dVar.It(4);
                            return;
                        }
                        return;
                    }
                    dVar.It(2);
                } else {
                    dVar.It(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mAf && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.It(5);
                    return true;
                }
                return false;
            }
        };
        this.mAe.setOnClickListener(onClickListener);
        this.mAg.setOnClickListener(onClickListener);
        this.mAh.setOnClickListener(onClickListener);
        this.mAi.setOnClickListener(onClickListener);
        this.mAj.setOnClickListener(onClickListener);
        this.mAf.setOnClickListener(onClickListener);
        this.mAf.setOnLongClickListener(onLongClickListener);
    }

    private void Iu(int i) {
        this.mAb.findViewById(R.id.line0).setVisibility(i);
    }

    public void dAW() {
        if (this.mAe != null) {
            this.mAe.refresh();
        }
    }

    public void qP(int i) {
        ap.setBackgroundColor(this.mAc, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mAb.getLayoutMode().setNightMode(i == 1);
        this.mAb.getLayoutMode().onModeChanged(this.mAc);
        dAW();
    }
}
