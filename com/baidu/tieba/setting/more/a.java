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
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity jNh;
    private RelativeLayout jNi;
    private TextView jNj;
    private SettingTextTestNewView jNk;
    private ImageView jNl;
    private TbSettingTextTipView jNm;
    private TbSettingTextTipView jNn;
    private TbSettingTextTipView jNo;
    private TbSettingTextTipView jNp;
    protected TextView jNq;
    private ProgressBar jNr;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jNh = aboutActivity;
        aKa();
        a(dVar);
    }

    public void cCC() {
        if (this.jNr != null) {
            this.jNr.setVisibility(0);
        }
    }

    public void bHh() {
        if (this.jNr != null) {
            this.jNr.setVisibility(8);
        }
    }

    private void aKa() {
        this.jNh.setContentView(R.layout.about_activity);
        this.jNi = (RelativeLayout) this.jNh.findViewById(R.id.parent);
        this.jNl = (ImageView) this.jNh.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jNh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jNh.getPageContext().getString(R.string.version_info));
        this.jNj = (TextView) this.jNh.findViewById(R.id.text_versioninfo);
        this.jNk = (SettingTextTestNewView) this.jNh.findViewById(R.id.about_version_update);
        this.jNm = (TbSettingTextTipView) this.jNh.findViewById(R.id.about_guide);
        this.jNm.hideArrow();
        this.jNn = (TbSettingTextTipView) this.jNh.findViewById(R.id.tieba_protocol_text);
        this.jNn.hideArrow();
        this.jNo = (TbSettingTextTipView) this.jNh.findViewById(R.id.tieba_privacy_text);
        this.jNo.hideArrow();
        this.jNp = (TbSettingTextTipView) this.jNh.findViewById(R.id.tieba_tdou_use_introduce);
        this.jNp.hideArrow();
        this.jNr = (ProgressBar) this.jNh.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jNj.setText(this.jNh.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jNh.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jNq = (TextView) this.jNh.findViewById(R.id.text_version_protoco);
        lM(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jNm.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Bp(0);
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
                if (view == a.this.jNn) {
                    ba.aEa().b(a.this.jNh.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jNo) {
                    ba.aEa().a(a.this.jNh.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jNp) {
                    ba.aEa().b(a.this.jNh.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jNk) {
                    if (view != a.this.jNm) {
                        if (view == a.this.jNl) {
                            dVar.Bo(4);
                            return;
                        }
                        return;
                    }
                    dVar.Bo(2);
                } else {
                    dVar.Bo(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.jNl && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Bo(5);
                    return true;
                }
                return false;
            }
        };
        this.jNk.setOnClickListener(onClickListener);
        this.jNm.setOnClickListener(onClickListener);
        this.jNn.setOnClickListener(onClickListener);
        this.jNo.setOnClickListener(onClickListener);
        this.jNp.setOnClickListener(onClickListener);
        this.jNl.setOnClickListener(onClickListener);
        this.jNl.setOnLongClickListener(onLongClickListener);
    }

    private void Bp(int i) {
        this.jNh.findViewById(R.id.line0).setVisibility(i);
    }

    public void cCD() {
        if (this.jNk != null) {
            this.jNk.refresh();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jNi, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jNh.getLayoutMode().setNightMode(i == 1);
        this.jNh.getLayoutMode().onModeChanged(this.jNi);
        cCD();
    }
}
