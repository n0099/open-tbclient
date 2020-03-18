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
    private AboutActivity jTA;
    private RelativeLayout jTB;
    private TextView jTC;
    private SettingTextTestNewView jTD;
    private ImageView jTE;
    private TbSettingTextTipView jTF;
    private TbSettingTextTipView jTG;
    private TbSettingTextTipView jTH;
    private TbSettingTextTipView jTI;
    protected TextView jTJ;
    private ProgressBar jTK;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jTA = aboutActivity;
        aMW();
        a(dVar);
    }

    public void cFG() {
        if (this.jTK != null) {
            this.jTK.setVisibility(0);
        }
    }

    public void bKb() {
        if (this.jTK != null) {
            this.jTK.setVisibility(8);
        }
    }

    private void aMW() {
        this.jTA.setContentView(R.layout.about_activity);
        this.jTB = (RelativeLayout) this.jTA.findViewById(R.id.parent);
        this.jTE = (ImageView) this.jTA.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jTA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jTA.getPageContext().getString(R.string.version_info));
        this.jTC = (TextView) this.jTA.findViewById(R.id.text_versioninfo);
        this.jTD = (SettingTextTestNewView) this.jTA.findViewById(R.id.about_version_update);
        this.jTF = (TbSettingTextTipView) this.jTA.findViewById(R.id.about_guide);
        this.jTF.hideArrow();
        this.jTG = (TbSettingTextTipView) this.jTA.findViewById(R.id.tieba_protocol_text);
        this.jTG.hideArrow();
        this.jTH = (TbSettingTextTipView) this.jTA.findViewById(R.id.tieba_privacy_text);
        this.jTH.hideArrow();
        this.jTI = (TbSettingTextTipView) this.jTA.findViewById(R.id.tieba_tdou_use_introduce);
        this.jTI.hideArrow();
        this.jTK = (ProgressBar) this.jTA.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jTC.setText(this.jTA.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jTA.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jTJ = (TextView) this.jTA.findViewById(R.id.text_version_protoco);
        mg(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jTF.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            BL(0);
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
                if (view == a.this.jTG) {
                    ba.aGK().b(a.this.jTA.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jTH) {
                    ba.aGK().a(a.this.jTA.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jTI) {
                    ba.aGK().b(a.this.jTA.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jTD) {
                    if (view != a.this.jTF) {
                        if (view == a.this.jTE) {
                            dVar.BK(4);
                            return;
                        }
                        return;
                    }
                    dVar.BK(2);
                } else {
                    dVar.BK(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.jTE && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.BK(5);
                    return true;
                }
                return false;
            }
        };
        this.jTD.setOnClickListener(onClickListener);
        this.jTF.setOnClickListener(onClickListener);
        this.jTG.setOnClickListener(onClickListener);
        this.jTH.setOnClickListener(onClickListener);
        this.jTI.setOnClickListener(onClickListener);
        this.jTE.setOnClickListener(onClickListener);
        this.jTE.setOnLongClickListener(onLongClickListener);
    }

    private void BL(int i) {
        this.jTA.findViewById(R.id.line0).setVisibility(i);
    }

    public void cFH() {
        if (this.jTD != null) {
            this.jTD.refresh();
        }
    }

    public void mg(int i) {
        am.setBackgroundColor(this.jTB, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTA.getLayoutMode().setNightMode(i == 1);
        this.jTA.getLayoutMode().onModeChanged(this.jTB);
        cFH();
    }
}
