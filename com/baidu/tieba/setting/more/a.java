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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity kVX;
    private RelativeLayout kVY;
    private TextView kVZ;
    private SettingTextTestNewView kWa;
    private ImageView kWb;
    private TbSettingTextTipView kWc;
    private TbSettingTextTipView kWd;
    private TbSettingTextTipView kWe;
    private TbSettingTextTipView kWf;
    protected TextView kWg;
    private ProgressBar kWh;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.kVX = aboutActivity;
        bbB();
        a(dVar);
    }

    public void cXv() {
        if (this.kWh != null) {
            this.kWh.setVisibility(0);
        }
    }

    public void cbc() {
        if (this.kWh != null) {
            this.kWh.setVisibility(8);
        }
    }

    private void bbB() {
        this.kVX.setContentView(R.layout.about_activity);
        this.kVY = (RelativeLayout) this.kVX.findViewById(R.id.parent);
        this.kWb = (ImageView) this.kVX.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.kVX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kVX.getPageContext().getString(R.string.version_info));
        this.kVZ = (TextView) this.kVX.findViewById(R.id.text_versioninfo);
        this.kWa = (SettingTextTestNewView) this.kVX.findViewById(R.id.about_version_update);
        this.kWc = (TbSettingTextTipView) this.kVX.findViewById(R.id.about_guide);
        this.kWc.hideArrow();
        this.kWd = (TbSettingTextTipView) this.kVX.findViewById(R.id.tieba_protocol_text);
        this.kWd.hideArrow();
        this.kWe = (TbSettingTextTipView) this.kVX.findViewById(R.id.tieba_privacy_text);
        this.kWe.hideArrow();
        this.kWf = (TbSettingTextTipView) this.kVX.findViewById(R.id.tieba_tdou_use_introduce);
        this.kWf.hideArrow();
        this.kWh = (ProgressBar) this.kVX.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.kVZ.setText(this.kVX.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.kVX.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.kWg = (TextView) this.kVX.findViewById(R.id.text_version_protoco);
        mW(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.kWc.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            CX(0);
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
                if (view == a.this.kWd) {
                    ba.aVa().b(a.this.kVX.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.kWe) {
                    ba.aVa().a(a.this.kVX.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.kWf) {
                    ba.aVa().b(a.this.kVX.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.kWa) {
                    if (view != a.this.kWc) {
                        if (view == a.this.kWb) {
                            dVar.CW(4);
                            return;
                        }
                        return;
                    }
                    dVar.CW(2);
                } else {
                    dVar.CW(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.kWb && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.CW(5);
                    return true;
                }
                return false;
            }
        };
        this.kWa.setOnClickListener(onClickListener);
        this.kWc.setOnClickListener(onClickListener);
        this.kWd.setOnClickListener(onClickListener);
        this.kWe.setOnClickListener(onClickListener);
        this.kWf.setOnClickListener(onClickListener);
        this.kWb.setOnClickListener(onClickListener);
        this.kWb.setOnLongClickListener(onLongClickListener);
    }

    private void CX(int i) {
        this.kVX.findViewById(R.id.line0).setVisibility(i);
    }

    public void cXw() {
        if (this.kWa != null) {
            this.kWa.refresh();
        }
    }

    public void mW(int i) {
        am.setBackgroundColor(this.kVY, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kVX.getLayoutMode().setNightMode(i == 1);
        this.kVX.getLayoutMode().onModeChanged(this.kVY);
        cXw();
    }
}
