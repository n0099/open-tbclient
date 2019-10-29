package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.DefaultConfig;
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
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity iTC;
    private RelativeLayout iTD;
    private TextView iTE;
    private SettingTextTestNewView iTF;
    private ImageView iTG;
    private TbSettingTextTipView iTH;
    private TbSettingTextTipView iTI;
    private TbSettingTextTipView iTJ;
    private TbSettingTextTipView iTK;
    protected TextView iTL;
    private ProgressBar iTM;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iTC = aboutActivity;
        asD();
        a(dVar);
    }

    public void ciA() {
        if (this.iTM != null) {
            this.iTM.setVisibility(0);
        }
    }

    public void bpN() {
        if (this.iTM != null) {
            this.iTM.setVisibility(8);
        }
    }

    private void asD() {
        this.iTC.setContentView(R.layout.about_activity);
        this.iTD = (RelativeLayout) this.iTC.findViewById(R.id.parent);
        this.iTG = (ImageView) this.iTC.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iTC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iTC.getPageContext().getString(R.string.version_info));
        this.iTE = (TextView) this.iTC.findViewById(R.id.text_versioninfo);
        this.iTF = (SettingTextTestNewView) this.iTC.findViewById(R.id.about_version_update);
        this.iTH = (TbSettingTextTipView) this.iTC.findViewById(R.id.about_guide);
        this.iTH.hideArrow();
        this.iTI = (TbSettingTextTipView) this.iTC.findViewById(R.id.tieba_protocol_text);
        this.iTI.hideArrow();
        this.iTJ = (TbSettingTextTipView) this.iTC.findViewById(R.id.tieba_privacy_text);
        this.iTJ.hideArrow();
        this.iTK = (TbSettingTextTipView) this.iTC.findViewById(R.id.tieba_tdou_use_introduce);
        this.iTK.hideArrow();
        this.iTM = (ProgressBar) this.iTC.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + DefaultConfig.TOKEN_SEPARATOR + TbConfig.getSubVersion();
        }
        this.iTE.setText(this.iTC.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iTC.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.iTL = (TextView) this.iTC.findViewById(R.id.text_version_protoco);
        jA(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.iTH.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            yV(0);
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
                if (view == a.this.iTI) {
                    ba.amQ().b(a.this.iTC.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iTJ) {
                    ba.amQ().a(a.this.iTC.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iTK) {
                    ba.amQ().b(a.this.iTC.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iTF) {
                    if (view != a.this.iTH) {
                        if (view == a.this.iTG) {
                            dVar.yU(4);
                            return;
                        }
                        return;
                    }
                    dVar.yU(2);
                } else {
                    dVar.yU(1);
                }
            }
        };
        this.iTF.setOnClickListener(onClickListener);
        this.iTH.setOnClickListener(onClickListener);
        this.iTI.setOnClickListener(onClickListener);
        this.iTJ.setOnClickListener(onClickListener);
        this.iTK.setOnClickListener(onClickListener);
        this.iTG.setOnClickListener(onClickListener);
    }

    private void yV(int i) {
        this.iTC.findViewById(R.id.line0).setVisibility(i);
    }

    public void ciB() {
        if (this.iTF != null) {
            this.iTF.refresh();
        }
    }

    public void jA(int i) {
        am.setBackgroundColor(this.iTD, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iTC.getLayoutMode().setNightMode(i == 1);
        this.iTC.getLayoutMode().onModeChanged(this.iTD);
        ciB();
    }
}
