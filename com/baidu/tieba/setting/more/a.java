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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity kCM;
    private RelativeLayout kCN;
    private TextView kCO;
    private SettingTextTestNewView kCP;
    private ImageView kCQ;
    private TbSettingTextTipView kCR;
    private TbSettingTextTipView kCS;
    private TbSettingTextTipView kCT;
    private TbSettingTextTipView kCU;
    protected TextView kCV;
    private ProgressBar kCW;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.kCM = aboutActivity;
        aVr();
        a(dVar);
    }

    public void cQc() {
        if (this.kCW != null) {
            this.kCW.setVisibility(0);
        }
    }

    public void bUx() {
        if (this.kCW != null) {
            this.kCW.setVisibility(8);
        }
    }

    private void aVr() {
        this.kCM.setContentView(R.layout.about_activity);
        this.kCN = (RelativeLayout) this.kCM.findViewById(R.id.parent);
        this.kCQ = (ImageView) this.kCM.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.kCM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kCM.getPageContext().getString(R.string.version_info));
        this.kCO = (TextView) this.kCM.findViewById(R.id.text_versioninfo);
        this.kCP = (SettingTextTestNewView) this.kCM.findViewById(R.id.about_version_update);
        this.kCR = (TbSettingTextTipView) this.kCM.findViewById(R.id.about_guide);
        this.kCR.hideArrow();
        this.kCS = (TbSettingTextTipView) this.kCM.findViewById(R.id.tieba_protocol_text);
        this.kCS.hideArrow();
        this.kCT = (TbSettingTextTipView) this.kCM.findViewById(R.id.tieba_privacy_text);
        this.kCT.hideArrow();
        this.kCU = (TbSettingTextTipView) this.kCM.findViewById(R.id.tieba_tdou_use_introduce);
        this.kCU.hideArrow();
        this.kCW = (ProgressBar) this.kCM.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.kCO.setText(this.kCM.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.kCM.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.kCV = (TextView) this.kCM.findViewById(R.id.text_version_protoco);
        ms(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.kCR.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Cl(0);
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
                if (view == a.this.kCS) {
                    ba.aOV().b(a.this.kCM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.kCT) {
                    ba.aOV().a(a.this.kCM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.kCU) {
                    ba.aOV().b(a.this.kCM.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.kCP) {
                    if (view != a.this.kCR) {
                        if (view == a.this.kCQ) {
                            dVar.Ck(4);
                            return;
                        }
                        return;
                    }
                    dVar.Ck(2);
                } else {
                    dVar.Ck(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.kCQ && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Ck(5);
                    return true;
                }
                return false;
            }
        };
        this.kCP.setOnClickListener(onClickListener);
        this.kCR.setOnClickListener(onClickListener);
        this.kCS.setOnClickListener(onClickListener);
        this.kCT.setOnClickListener(onClickListener);
        this.kCU.setOnClickListener(onClickListener);
        this.kCQ.setOnClickListener(onClickListener);
        this.kCQ.setOnLongClickListener(onLongClickListener);
    }

    private void Cl(int i) {
        this.kCM.findViewById(R.id.line0).setVisibility(i);
    }

    public void cQd() {
        if (this.kCP != null) {
            this.kCP.refresh();
        }
    }

    public void ms(int i) {
        am.setBackgroundColor(this.kCN, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kCM.getLayoutMode().setNightMode(i == 1);
        this.kCM.getLayoutMode().onModeChanged(this.kCN);
        cQd();
    }
}
