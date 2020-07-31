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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity lxl;
    private RelativeLayout lxm;
    private TextView lxn;
    private SettingTextTestNewView lxo;
    private ImageView lxp;
    private TbSettingTextTipView lxq;
    private TbSettingTextTipView lxr;
    private TbSettingTextTipView lxs;
    private TbSettingTextTipView lxt;
    protected TextView lxu;
    private ProgressBar lxv;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.lxl = aboutActivity;
        bhm();
        a(dVar);
    }

    public void deS() {
        if (this.lxv != null) {
            this.lxv.setVisibility(0);
        }
    }

    public void chU() {
        if (this.lxv != null) {
            this.lxv.setVisibility(8);
        }
    }

    private void bhm() {
        this.lxl.setContentView(R.layout.about_activity);
        this.lxm = (RelativeLayout) this.lxl.findViewById(R.id.parent);
        this.lxp = (ImageView) this.lxl.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.lxl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lxl.getPageContext().getString(R.string.version_info));
        this.lxn = (TextView) this.lxl.findViewById(R.id.text_versioninfo);
        this.lxo = (SettingTextTestNewView) this.lxl.findViewById(R.id.about_version_update);
        this.lxq = (TbSettingTextTipView) this.lxl.findViewById(R.id.about_guide);
        this.lxq.hideArrow();
        this.lxr = (TbSettingTextTipView) this.lxl.findViewById(R.id.tieba_protocol_text);
        this.lxr.hideArrow();
        this.lxs = (TbSettingTextTipView) this.lxl.findViewById(R.id.tieba_privacy_text);
        this.lxs.hideArrow();
        this.lxt = (TbSettingTextTipView) this.lxl.findViewById(R.id.tieba_tdou_use_introduce);
        this.lxt.hideArrow();
        this.lxv = (ProgressBar) this.lxl.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !as.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.lxn.setText(this.lxl.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.lxl.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.lxu = (TextView) this.lxl.findViewById(R.id.text_version_protoco);
        nI(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.lxq.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Ev(0);
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
                if (view == a.this.lxr) {
                    bd.baV().b(a.this.lxl.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.lxs) {
                    bd.baV().a(a.this.lxl.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.lxt) {
                    bd.baV().b(a.this.lxl.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.lxo) {
                    if (view != a.this.lxq) {
                        if (view == a.this.lxp) {
                            dVar.Eu(4);
                            return;
                        }
                        return;
                    }
                    dVar.Eu(2);
                } else {
                    dVar.Eu(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.lxp && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Eu(5);
                    return true;
                }
                return false;
            }
        };
        this.lxo.setOnClickListener(onClickListener);
        this.lxq.setOnClickListener(onClickListener);
        this.lxr.setOnClickListener(onClickListener);
        this.lxs.setOnClickListener(onClickListener);
        this.lxt.setOnClickListener(onClickListener);
        this.lxp.setOnClickListener(onClickListener);
        this.lxp.setOnLongClickListener(onLongClickListener);
    }

    private void Ev(int i) {
        this.lxl.findViewById(R.id.line0).setVisibility(i);
    }

    public void deT() {
        if (this.lxo != null) {
            this.lxo.refresh();
        }
    }

    public void nI(int i) {
        ao.setBackgroundColor(this.lxm, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lxl.getLayoutMode().setNightMode(i == 1);
        this.lxl.getLayoutMode().onModeChanged(this.lxm);
        deT();
    }
}
