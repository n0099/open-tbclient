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
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity jRM;
    private RelativeLayout jRN;
    private TextView jRO;
    private SettingTextTestNewView jRP;
    private ImageView jRQ;
    private TbSettingTextTipView jRR;
    private TbSettingTextTipView jRS;
    private TbSettingTextTipView jRT;
    private TbSettingTextTipView jRU;
    protected TextView jRV;
    private ProgressBar jRW;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jRM = aboutActivity;
        aMR();
        a(dVar);
    }

    public void cFl() {
        if (this.jRW != null) {
            this.jRW.setVisibility(0);
        }
    }

    public void bJN() {
        if (this.jRW != null) {
            this.jRW.setVisibility(8);
        }
    }

    private void aMR() {
        this.jRM.setContentView(R.layout.about_activity);
        this.jRN = (RelativeLayout) this.jRM.findViewById(R.id.parent);
        this.jRQ = (ImageView) this.jRM.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jRM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRM.getPageContext().getString(R.string.version_info));
        this.jRO = (TextView) this.jRM.findViewById(R.id.text_versioninfo);
        this.jRP = (SettingTextTestNewView) this.jRM.findViewById(R.id.about_version_update);
        this.jRR = (TbSettingTextTipView) this.jRM.findViewById(R.id.about_guide);
        this.jRR.hideArrow();
        this.jRS = (TbSettingTextTipView) this.jRM.findViewById(R.id.tieba_protocol_text);
        this.jRS.hideArrow();
        this.jRT = (TbSettingTextTipView) this.jRM.findViewById(R.id.tieba_privacy_text);
        this.jRT.hideArrow();
        this.jRU = (TbSettingTextTipView) this.jRM.findViewById(R.id.tieba_tdou_use_introduce);
        this.jRU.hideArrow();
        this.jRW = (ProgressBar) this.jRM.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jRO.setText(this.jRM.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jRM.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jRV = (TextView) this.jRM.findViewById(R.id.text_version_protoco);
        me(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jRR.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            BD(0);
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
                if (view == a.this.jRS) {
                    ba.aGG().b(a.this.jRM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jRT) {
                    ba.aGG().a(a.this.jRM.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jRU) {
                    ba.aGG().b(a.this.jRM.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jRP) {
                    if (view != a.this.jRR) {
                        if (view == a.this.jRQ) {
                            dVar.BC(4);
                            return;
                        }
                        return;
                    }
                    dVar.BC(2);
                } else {
                    dVar.BC(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.jRQ && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.BC(5);
                    return true;
                }
                return false;
            }
        };
        this.jRP.setOnClickListener(onClickListener);
        this.jRR.setOnClickListener(onClickListener);
        this.jRS.setOnClickListener(onClickListener);
        this.jRT.setOnClickListener(onClickListener);
        this.jRU.setOnClickListener(onClickListener);
        this.jRQ.setOnClickListener(onClickListener);
        this.jRQ.setOnLongClickListener(onLongClickListener);
    }

    private void BD(int i) {
        this.jRM.findViewById(R.id.line0).setVisibility(i);
    }

    public void cFm() {
        if (this.jRP != null) {
            this.jRP.refresh();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jRN, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jRM.getLayoutMode().setNightMode(i == 1);
        this.jRM.getLayoutMode().onModeChanged(this.jRN);
        cFm();
    }
}
