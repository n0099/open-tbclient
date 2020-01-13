package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes11.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity jQK;
    private RelativeLayout jQL;
    private TextView jQM;
    private SettingTextTestNewView jQN;
    private ImageView jQO;
    private TbSettingTextTipView jQP;
    private TbSettingTextTipView jQQ;
    private TbSettingTextTipView jQR;
    private TbSettingTextTipView jQS;
    protected TextView jQT;
    private ProgressBar jQU;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jQK = aboutActivity;
        aKt();
        a(dVar);
    }

    public void cDG() {
        if (this.jQU != null) {
            this.jQU.setVisibility(0);
        }
    }

    public void bIj() {
        if (this.jQU != null) {
            this.jQU.setVisibility(8);
        }
    }

    private void aKt() {
        this.jQK.setContentView(R.layout.about_activity);
        this.jQL = (RelativeLayout) this.jQK.findViewById(R.id.parent);
        this.jQO = (ImageView) this.jQK.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jQK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jQK.getPageContext().getString(R.string.version_info));
        this.jQM = (TextView) this.jQK.findViewById(R.id.text_versioninfo);
        this.jQN = (SettingTextTestNewView) this.jQK.findViewById(R.id.about_version_update);
        this.jQP = (TbSettingTextTipView) this.jQK.findViewById(R.id.about_guide);
        this.jQP.hideArrow();
        this.jQQ = (TbSettingTextTipView) this.jQK.findViewById(R.id.tieba_protocol_text);
        this.jQQ.hideArrow();
        this.jQR = (TbSettingTextTipView) this.jQK.findViewById(R.id.tieba_privacy_text);
        this.jQR.hideArrow();
        this.jQS = (TbSettingTextTipView) this.jQK.findViewById(R.id.tieba_tdou_use_introduce);
        this.jQS.hideArrow();
        this.jQU = (ProgressBar) this.jQK.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jQM.setText(this.jQK.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jQK.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jQT = (TextView) this.jQK.findViewById(R.id.text_version_protoco);
        lM(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jQP.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Bu(0);
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
                if (view == a.this.jQQ) {
                    ba.aEt().b(a.this.jQK.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jQR) {
                    ba.aEt().a(a.this.jQK.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jQS) {
                    ba.aEt().b(a.this.jQK.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jQN) {
                    if (view != a.this.jQP) {
                        if (view == a.this.jQO) {
                            dVar.Bt(4);
                            return;
                        }
                        return;
                    }
                    dVar.Bt(2);
                } else {
                    dVar.Bt(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.jQO && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Bt(5);
                    return true;
                }
                return false;
            }
        };
        this.jQN.setOnClickListener(onClickListener);
        this.jQP.setOnClickListener(onClickListener);
        this.jQQ.setOnClickListener(onClickListener);
        this.jQR.setOnClickListener(onClickListener);
        this.jQS.setOnClickListener(onClickListener);
        this.jQO.setOnClickListener(onClickListener);
        this.jQO.setOnLongClickListener(onLongClickListener);
    }

    private void Bu(int i) {
        this.jQK.findViewById(R.id.line0).setVisibility(i);
    }

    public void cDH() {
        if (this.jQN != null) {
            this.jQN.refresh();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jQL, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jQK.getLayoutMode().setNightMode(i == 1);
        this.jQK.getLayoutMode().onModeChanged(this.jQL);
        cDH();
    }
}
