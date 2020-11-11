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
/* loaded from: classes26.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity mGd;
    private RelativeLayout mGe;
    private TextView mGf;
    private SettingTextTestNewView mGg;
    private ImageView mGh;
    private TbSettingTextTipView mGi;
    private TbSettingTextTipView mGj;
    private TbSettingTextTipView mGk;
    private TbSettingTextTipView mGm;
    protected TextView mGn;
    private ProgressBar mGo;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.mGd = aboutActivity;
        bxV();
        a(dVar);
    }

    public void dDx() {
        if (this.mGo != null) {
            this.mGo.setVisibility(0);
        }
    }

    public void cET() {
        if (this.mGo != null) {
            this.mGo.setVisibility(8);
        }
    }

    private void bxV() {
        this.mGd.setContentView(R.layout.about_activity);
        this.mGe = (RelativeLayout) this.mGd.findViewById(R.id.parent);
        this.mGh = (ImageView) this.mGd.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mGd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGd.getPageContext().getString(R.string.version_info));
        this.mGf = (TextView) this.mGd.findViewById(R.id.text_versioninfo);
        this.mGg = (SettingTextTestNewView) this.mGd.findViewById(R.id.about_version_update);
        this.mGi = (TbSettingTextTipView) this.mGd.findViewById(R.id.about_guide);
        this.mGi.hideArrow();
        this.mGj = (TbSettingTextTipView) this.mGd.findViewById(R.id.tieba_protocol_text);
        this.mGj.hideArrow();
        this.mGk = (TbSettingTextTipView) this.mGd.findViewById(R.id.tieba_privacy_text);
        this.mGk.hideArrow();
        this.mGm = (TbSettingTextTipView) this.mGd.findViewById(R.id.tieba_tdou_use_introduce);
        this.mGm.hideArrow();
        this.mGo = (ProgressBar) this.mGd.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mGf.setText(this.mGd.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mGd.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mGn = (TextView) this.mGd.findViewById(R.id.text_version_protoco);
        qZ(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mGi.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            IH(0);
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
                if (view == a.this.mGj) {
                    be.brr().b(a.this.mGd.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mGk) {
                    be.brr().a(a.this.mGd.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mGm) {
                    be.brr().b(a.this.mGd.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mGg) {
                    if (view != a.this.mGi) {
                        if (view == a.this.mGh) {
                            dVar.IG(4);
                            return;
                        }
                        return;
                    }
                    dVar.IG(2);
                } else {
                    dVar.IG(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mGh && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.IG(5);
                    return true;
                }
                return false;
            }
        };
        this.mGg.setOnClickListener(onClickListener);
        this.mGi.setOnClickListener(onClickListener);
        this.mGj.setOnClickListener(onClickListener);
        this.mGk.setOnClickListener(onClickListener);
        this.mGm.setOnClickListener(onClickListener);
        this.mGh.setOnClickListener(onClickListener);
        this.mGh.setOnLongClickListener(onLongClickListener);
    }

    private void IH(int i) {
        this.mGd.findViewById(R.id.line0).setVisibility(i);
    }

    public void dDy() {
        if (this.mGg != null) {
            this.mGg.refresh();
        }
    }

    public void qZ(int i) {
        ap.setBackgroundColor(this.mGe, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mGd.getLayoutMode().setNightMode(i == 1);
        this.mGd.getLayoutMode().onModeChanged(this.mGe);
        dDy();
    }
}
