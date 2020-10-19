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
    private NavigationBar mNavigationBar;
    private AboutActivity mnA;
    private RelativeLayout mnB;
    private TextView mnC;
    private SettingTextTestNewView mnD;
    private ImageView mnE;
    private TbSettingTextTipView mnF;
    private TbSettingTextTipView mnG;
    private TbSettingTextTipView mnH;
    private TbSettingTextTipView mnI;
    protected TextView mnJ;
    private ProgressBar mnK;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.mnA = aboutActivity;
        btD();
        a(dVar);
    }

    public void dxN() {
        if (this.mnK != null) {
            this.mnK.setVisibility(0);
        }
    }

    public void czl() {
        if (this.mnK != null) {
            this.mnK.setVisibility(8);
        }
    }

    private void btD() {
        this.mnA.setContentView(R.layout.about_activity);
        this.mnB = (RelativeLayout) this.mnA.findViewById(R.id.parent);
        this.mnE = (ImageView) this.mnA.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mnA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mnA.getPageContext().getString(R.string.version_info));
        this.mnC = (TextView) this.mnA.findViewById(R.id.text_versioninfo);
        this.mnD = (SettingTextTestNewView) this.mnA.findViewById(R.id.about_version_update);
        this.mnF = (TbSettingTextTipView) this.mnA.findViewById(R.id.about_guide);
        this.mnF.hideArrow();
        this.mnG = (TbSettingTextTipView) this.mnA.findViewById(R.id.tieba_protocol_text);
        this.mnG.hideArrow();
        this.mnH = (TbSettingTextTipView) this.mnA.findViewById(R.id.tieba_privacy_text);
        this.mnH.hideArrow();
        this.mnI = (TbSettingTextTipView) this.mnA.findViewById(R.id.tieba_tdou_use_introduce);
        this.mnI.hideArrow();
        this.mnK = (ProgressBar) this.mnA.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mnC.setText(this.mnA.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mnA.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mnJ = (TextView) this.mnA.findViewById(R.id.text_version_protoco);
        qE(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mnF.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Ib(0);
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
                if (view == a.this.mnG) {
                    be.bmY().b(a.this.mnA.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mnH) {
                    be.bmY().a(a.this.mnA.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mnI) {
                    be.bmY().b(a.this.mnA.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mnD) {
                    if (view != a.this.mnF) {
                        if (view == a.this.mnE) {
                            dVar.Ia(4);
                            return;
                        }
                        return;
                    }
                    dVar.Ia(2);
                } else {
                    dVar.Ia(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mnE && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Ia(5);
                    return true;
                }
                return false;
            }
        };
        this.mnD.setOnClickListener(onClickListener);
        this.mnF.setOnClickListener(onClickListener);
        this.mnG.setOnClickListener(onClickListener);
        this.mnH.setOnClickListener(onClickListener);
        this.mnI.setOnClickListener(onClickListener);
        this.mnE.setOnClickListener(onClickListener);
        this.mnE.setOnLongClickListener(onLongClickListener);
    }

    private void Ib(int i) {
        this.mnA.findViewById(R.id.line0).setVisibility(i);
    }

    public void dxO() {
        if (this.mnD != null) {
            this.mnD.refresh();
        }
    }

    public void qE(int i) {
        ap.setBackgroundColor(this.mnB, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mnA.getLayoutMode().setNightMode(i == 1);
        this.mnA.getLayoutMode().onModeChanged(this.mnB);
        dxO();
    }
}
