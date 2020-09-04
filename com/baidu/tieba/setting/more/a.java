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
    private AboutActivity lOO;
    private RelativeLayout lOP;
    private TextView lOQ;
    private SettingTextTestNewView lOR;
    private ImageView lOS;
    private TbSettingTextTipView lOT;
    private TbSettingTextTipView lOU;
    private TbSettingTextTipView lOV;
    private TbSettingTextTipView lOW;
    protected TextView lOX;
    private ProgressBar lOY;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.lOO = aboutActivity;
        bpZ();
        a(dVar);
    }

    public void dqo() {
        if (this.lOY != null) {
            this.lOY.setVisibility(0);
        }
    }

    public void csz() {
        if (this.lOY != null) {
            this.lOY.setVisibility(8);
        }
    }

    private void bpZ() {
        this.lOO.setContentView(R.layout.about_activity);
        this.lOP = (RelativeLayout) this.lOO.findViewById(R.id.parent);
        this.lOS = (ImageView) this.lOO.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.lOO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lOO.getPageContext().getString(R.string.version_info));
        this.lOQ = (TextView) this.lOO.findViewById(R.id.text_versioninfo);
        this.lOR = (SettingTextTestNewView) this.lOO.findViewById(R.id.about_version_update);
        this.lOT = (TbSettingTextTipView) this.lOO.findViewById(R.id.about_guide);
        this.lOT.hideArrow();
        this.lOU = (TbSettingTextTipView) this.lOO.findViewById(R.id.tieba_protocol_text);
        this.lOU.hideArrow();
        this.lOV = (TbSettingTextTipView) this.lOO.findViewById(R.id.tieba_privacy_text);
        this.lOV.hideArrow();
        this.lOW = (TbSettingTextTipView) this.lOO.findViewById(R.id.tieba_tdou_use_introduce);
        this.lOW.hideArrow();
        this.lOY = (ProgressBar) this.lOO.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.lOQ.setText(this.lOO.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.lOO.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.lOX = (TextView) this.lOO.findViewById(R.id.text_version_protoco);
        pT(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.lOT.setVisibility(8);
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
                if (view == a.this.lOU) {
                    be.bju().b(a.this.lOO.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.lOV) {
                    be.bju().a(a.this.lOO.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.lOW) {
                    be.bju().b(a.this.lOO.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.lOR) {
                    if (view != a.this.lOT) {
                        if (view == a.this.lOS) {
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
                if (view == a.this.lOS && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.GR(5);
                    return true;
                }
                return false;
            }
        };
        this.lOR.setOnClickListener(onClickListener);
        this.lOT.setOnClickListener(onClickListener);
        this.lOU.setOnClickListener(onClickListener);
        this.lOV.setOnClickListener(onClickListener);
        this.lOW.setOnClickListener(onClickListener);
        this.lOS.setOnClickListener(onClickListener);
        this.lOS.setOnLongClickListener(onLongClickListener);
    }

    private void GS(int i) {
        this.lOO.findViewById(R.id.line0).setVisibility(i);
    }

    public void dqp() {
        if (this.lOR != null) {
            this.lOR.refresh();
        }
    }

    public void pT(int i) {
        ap.setBackgroundColor(this.lOP, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lOO.getLayoutMode().setNightMode(i == 1);
        this.lOO.getLayoutMode().onModeChanged(this.lOP);
        dqp();
    }
}
