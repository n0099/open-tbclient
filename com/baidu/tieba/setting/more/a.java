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
    private AboutActivity jRY;
    private RelativeLayout jRZ;
    private TextView jSa;
    private SettingTextTestNewView jSb;
    private ImageView jSc;
    private TbSettingTextTipView jSd;
    private TbSettingTextTipView jSe;
    private TbSettingTextTipView jSf;
    private TbSettingTextTipView jSg;
    protected TextView jSh;
    private ProgressBar jSi;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jRY = aboutActivity;
        aMS();
        a(dVar);
    }

    public void cFm() {
        if (this.jSi != null) {
            this.jSi.setVisibility(0);
        }
    }

    public void bJO() {
        if (this.jSi != null) {
            this.jSi.setVisibility(8);
        }
    }

    private void aMS() {
        this.jRY.setContentView(R.layout.about_activity);
        this.jRZ = (RelativeLayout) this.jRY.findViewById(R.id.parent);
        this.jSc = (ImageView) this.jRY.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jRY.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRY.getPageContext().getString(R.string.version_info));
        this.jSa = (TextView) this.jRY.findViewById(R.id.text_versioninfo);
        this.jSb = (SettingTextTestNewView) this.jRY.findViewById(R.id.about_version_update);
        this.jSd = (TbSettingTextTipView) this.jRY.findViewById(R.id.about_guide);
        this.jSd.hideArrow();
        this.jSe = (TbSettingTextTipView) this.jRY.findViewById(R.id.tieba_protocol_text);
        this.jSe.hideArrow();
        this.jSf = (TbSettingTextTipView) this.jRY.findViewById(R.id.tieba_privacy_text);
        this.jSf.hideArrow();
        this.jSg = (TbSettingTextTipView) this.jRY.findViewById(R.id.tieba_tdou_use_introduce);
        this.jSg.hideArrow();
        this.jSi = (ProgressBar) this.jRY.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jSa.setText(this.jRY.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jRY.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jSh = (TextView) this.jRY.findViewById(R.id.text_version_protoco);
        me(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jSd.setVisibility(8);
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
                if (view == a.this.jSe) {
                    ba.aGG().b(a.this.jRY.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jSf) {
                    ba.aGG().a(a.this.jRY.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jSg) {
                    ba.aGG().b(a.this.jRY.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jSb) {
                    if (view != a.this.jSd) {
                        if (view == a.this.jSc) {
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
                if (view == a.this.jSc && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.BC(5);
                    return true;
                }
                return false;
            }
        };
        this.jSb.setOnClickListener(onClickListener);
        this.jSd.setOnClickListener(onClickListener);
        this.jSe.setOnClickListener(onClickListener);
        this.jSf.setOnClickListener(onClickListener);
        this.jSg.setOnClickListener(onClickListener);
        this.jSc.setOnClickListener(onClickListener);
        this.jSc.setOnLongClickListener(onLongClickListener);
    }

    private void BD(int i) {
        this.jRY.findViewById(R.id.line0).setVisibility(i);
    }

    public void cFn() {
        if (this.jSb != null) {
            this.jSb.refresh();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jRZ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jRY.getLayoutMode().setNightMode(i == 1);
        this.jRY.getLayoutMode().onModeChanged(this.jRZ);
        cFn();
    }
}
