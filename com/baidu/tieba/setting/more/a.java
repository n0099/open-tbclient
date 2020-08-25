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
/* loaded from: classes20.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity lOB;
    private RelativeLayout lOC;
    private TextView lOD;
    private SettingTextTestNewView lOE;
    private ImageView lOF;
    private TbSettingTextTipView lOG;
    private TbSettingTextTipView lOH;
    private TbSettingTextTipView lOI;
    private TbSettingTextTipView lOJ;
    protected TextView lOK;
    private ProgressBar lOL;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.lOB = aboutActivity;
        bpY();
        a(dVar);
    }

    public void dql() {
        if (this.lOL != null) {
            this.lOL.setVisibility(0);
        }
    }

    public void csy() {
        if (this.lOL != null) {
            this.lOL.setVisibility(8);
        }
    }

    private void bpY() {
        this.lOB.setContentView(R.layout.about_activity);
        this.lOC = (RelativeLayout) this.lOB.findViewById(R.id.parent);
        this.lOF = (ImageView) this.lOB.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.lOB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lOB.getPageContext().getString(R.string.version_info));
        this.lOD = (TextView) this.lOB.findViewById(R.id.text_versioninfo);
        this.lOE = (SettingTextTestNewView) this.lOB.findViewById(R.id.about_version_update);
        this.lOG = (TbSettingTextTipView) this.lOB.findViewById(R.id.about_guide);
        this.lOG.hideArrow();
        this.lOH = (TbSettingTextTipView) this.lOB.findViewById(R.id.tieba_protocol_text);
        this.lOH.hideArrow();
        this.lOI = (TbSettingTextTipView) this.lOB.findViewById(R.id.tieba_privacy_text);
        this.lOI.hideArrow();
        this.lOJ = (TbSettingTextTipView) this.lOB.findViewById(R.id.tieba_tdou_use_introduce);
        this.lOJ.hideArrow();
        this.lOL = (ProgressBar) this.lOB.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.lOD.setText(this.lOB.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.lOB.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.lOK = (TextView) this.lOB.findViewById(R.id.text_version_protoco);
        pT(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.lOG.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            GS(0);
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
                if (view == a.this.lOH) {
                    be.bju().b(a.this.lOB.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.lOI) {
                    be.bju().a(a.this.lOB.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.lOJ) {
                    be.bju().b(a.this.lOB.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.lOE) {
                    if (view != a.this.lOG) {
                        if (view == a.this.lOF) {
                            dVar.GR(4);
                            return;
                        }
                        return;
                    }
                    dVar.GR(2);
                } else {
                    dVar.GR(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.lOF && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.GR(5);
                    return true;
                }
                return false;
            }
        };
        this.lOE.setOnClickListener(onClickListener);
        this.lOG.setOnClickListener(onClickListener);
        this.lOH.setOnClickListener(onClickListener);
        this.lOI.setOnClickListener(onClickListener);
        this.lOJ.setOnClickListener(onClickListener);
        this.lOF.setOnClickListener(onClickListener);
        this.lOF.setOnLongClickListener(onLongClickListener);
    }

    private void GS(int i) {
        this.lOB.findViewById(R.id.line0).setVisibility(i);
    }

    public void dqm() {
        if (this.lOE != null) {
            this.lOE.refresh();
        }
    }

    public void pT(int i) {
        ap.setBackgroundColor(this.lOC, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lOB.getLayoutMode().setNightMode(i == 1);
        this.lOB.getLayoutMode().onModeChanged(this.lOC);
        dqm();
    }
}
