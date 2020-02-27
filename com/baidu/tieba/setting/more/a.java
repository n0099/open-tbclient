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
    private AboutActivity jRK;
    private RelativeLayout jRL;
    private TextView jRM;
    private SettingTextTestNewView jRN;
    private ImageView jRO;
    private TbSettingTextTipView jRP;
    private TbSettingTextTipView jRQ;
    private TbSettingTextTipView jRR;
    private TbSettingTextTipView jRS;
    protected TextView jRT;
    private ProgressBar jRU;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jRK = aboutActivity;
        aMP();
        a(dVar);
    }

    public void cFj() {
        if (this.jRU != null) {
            this.jRU.setVisibility(0);
        }
    }

    public void bJL() {
        if (this.jRU != null) {
            this.jRU.setVisibility(8);
        }
    }

    private void aMP() {
        this.jRK.setContentView(R.layout.about_activity);
        this.jRL = (RelativeLayout) this.jRK.findViewById(R.id.parent);
        this.jRO = (ImageView) this.jRK.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jRK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRK.getPageContext().getString(R.string.version_info));
        this.jRM = (TextView) this.jRK.findViewById(R.id.text_versioninfo);
        this.jRN = (SettingTextTestNewView) this.jRK.findViewById(R.id.about_version_update);
        this.jRP = (TbSettingTextTipView) this.jRK.findViewById(R.id.about_guide);
        this.jRP.hideArrow();
        this.jRQ = (TbSettingTextTipView) this.jRK.findViewById(R.id.tieba_protocol_text);
        this.jRQ.hideArrow();
        this.jRR = (TbSettingTextTipView) this.jRK.findViewById(R.id.tieba_privacy_text);
        this.jRR.hideArrow();
        this.jRS = (TbSettingTextTipView) this.jRK.findViewById(R.id.tieba_tdou_use_introduce);
        this.jRS.hideArrow();
        this.jRU = (ProgressBar) this.jRK.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jRM.setText(this.jRK.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jRK.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jRT = (TextView) this.jRK.findViewById(R.id.text_version_protoco);
        me(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jRP.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
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
                if (view == a.this.jRQ) {
                    ba.aGE().b(a.this.jRK.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jRR) {
                    ba.aGE().a(a.this.jRK.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jRS) {
                    ba.aGE().b(a.this.jRK.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jRN) {
                    if (view != a.this.jRP) {
                        if (view == a.this.jRO) {
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
                if (view == a.this.jRO && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.BC(5);
                    return true;
                }
                return false;
            }
        };
        this.jRN.setOnClickListener(onClickListener);
        this.jRP.setOnClickListener(onClickListener);
        this.jRQ.setOnClickListener(onClickListener);
        this.jRR.setOnClickListener(onClickListener);
        this.jRS.setOnClickListener(onClickListener);
        this.jRO.setOnClickListener(onClickListener);
        this.jRO.setOnLongClickListener(onLongClickListener);
    }

    private void BD(int i) {
        this.jRK.findViewById(R.id.line0).setVisibility(i);
    }

    public void cFk() {
        if (this.jRN != null) {
            this.jRN.refresh();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jRL, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jRK.getLayoutMode().setNightMode(i == 1);
        this.jRK.getLayoutMode().onModeChanged(this.jRL);
        cFk();
    }
}
