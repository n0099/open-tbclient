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
    private AboutActivity kCI;
    private RelativeLayout kCJ;
    private TextView kCK;
    private SettingTextTestNewView kCL;
    private ImageView kCM;
    private TbSettingTextTipView kCN;
    private TbSettingTextTipView kCO;
    private TbSettingTextTipView kCP;
    private TbSettingTextTipView kCQ;
    protected TextView kCR;
    private ProgressBar kCS;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.kCI = aboutActivity;
        aVt();
        a(dVar);
    }

    public void cQe() {
        if (this.kCS != null) {
            this.kCS.setVisibility(0);
        }
    }

    public void bUy() {
        if (this.kCS != null) {
            this.kCS.setVisibility(8);
        }
    }

    private void aVt() {
        this.kCI.setContentView(R.layout.about_activity);
        this.kCJ = (RelativeLayout) this.kCI.findViewById(R.id.parent);
        this.kCM = (ImageView) this.kCI.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.kCI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kCI.getPageContext().getString(R.string.version_info));
        this.kCK = (TextView) this.kCI.findViewById(R.id.text_versioninfo);
        this.kCL = (SettingTextTestNewView) this.kCI.findViewById(R.id.about_version_update);
        this.kCN = (TbSettingTextTipView) this.kCI.findViewById(R.id.about_guide);
        this.kCN.hideArrow();
        this.kCO = (TbSettingTextTipView) this.kCI.findViewById(R.id.tieba_protocol_text);
        this.kCO.hideArrow();
        this.kCP = (TbSettingTextTipView) this.kCI.findViewById(R.id.tieba_privacy_text);
        this.kCP.hideArrow();
        this.kCQ = (TbSettingTextTipView) this.kCI.findViewById(R.id.tieba_tdou_use_introduce);
        this.kCQ.hideArrow();
        this.kCS = (ProgressBar) this.kCI.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.kCK.setText(this.kCI.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.kCI.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.kCR = (TextView) this.kCI.findViewById(R.id.text_version_protoco);
        ms(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.kCN.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
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
                if (view == a.this.kCO) {
                    ba.aOY().b(a.this.kCI.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.kCP) {
                    ba.aOY().a(a.this.kCI.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.kCQ) {
                    ba.aOY().b(a.this.kCI.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.kCL) {
                    if (view != a.this.kCN) {
                        if (view == a.this.kCM) {
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
                if (view == a.this.kCM && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Ck(5);
                    return true;
                }
                return false;
            }
        };
        this.kCL.setOnClickListener(onClickListener);
        this.kCN.setOnClickListener(onClickListener);
        this.kCO.setOnClickListener(onClickListener);
        this.kCP.setOnClickListener(onClickListener);
        this.kCQ.setOnClickListener(onClickListener);
        this.kCM.setOnClickListener(onClickListener);
        this.kCM.setOnLongClickListener(onLongClickListener);
    }

    private void Cl(int i) {
        this.kCI.findViewById(R.id.line0).setVisibility(i);
    }

    public void cQf() {
        if (this.kCL != null) {
            this.kCL.refresh();
        }
    }

    public void ms(int i) {
        am.setBackgroundColor(this.kCJ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kCI.getLayoutMode().setNightMode(i == 1);
        this.kCI.getLayoutMode().onModeChanged(this.kCJ);
        cQf();
    }
}
