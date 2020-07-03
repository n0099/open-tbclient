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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity lpU;
    private RelativeLayout lpV;
    private TextView lpW;
    private SettingTextTestNewView lpX;
    private ImageView lpY;
    private TbSettingTextTipView lpZ;
    private TbSettingTextTipView lqa;
    private TbSettingTextTipView lqb;
    private TbSettingTextTipView lqc;
    protected TextView lqd;
    private ProgressBar lqe;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.lpU = aboutActivity;
        bdD();
        a(dVar);
    }

    public void dbK() {
        if (this.lqe != null) {
            this.lqe.setVisibility(0);
        }
    }

    public void ceu() {
        if (this.lqe != null) {
            this.lqe.setVisibility(8);
        }
    }

    private void bdD() {
        this.lpU.setContentView(R.layout.about_activity);
        this.lpV = (RelativeLayout) this.lpU.findViewById(R.id.parent);
        this.lpY = (ImageView) this.lpU.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.lpU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lpU.getPageContext().getString(R.string.version_info));
        this.lpW = (TextView) this.lpU.findViewById(R.id.text_versioninfo);
        this.lpX = (SettingTextTestNewView) this.lpU.findViewById(R.id.about_version_update);
        this.lpZ = (TbSettingTextTipView) this.lpU.findViewById(R.id.about_guide);
        this.lpZ.hideArrow();
        this.lqa = (TbSettingTextTipView) this.lpU.findViewById(R.id.tieba_protocol_text);
        this.lqa.hideArrow();
        this.lqb = (TbSettingTextTipView) this.lpU.findViewById(R.id.tieba_privacy_text);
        this.lqb.hideArrow();
        this.lqc = (TbSettingTextTipView) this.lpU.findViewById(R.id.tieba_tdou_use_introduce);
        this.lqc.hideArrow();
        this.lqe = (ProgressBar) this.lpU.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ar.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.lpW.setText(this.lpU.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.lpU.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.lqd = (TextView) this.lpU.findViewById(R.id.text_version_protoco);
        nq(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.lpZ.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            DZ(0);
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
                if (view == a.this.lqa) {
                    bc.aWU().b(a.this.lpU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.lqb) {
                    bc.aWU().a(a.this.lpU.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.lqc) {
                    bc.aWU().b(a.this.lpU.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.lpX) {
                    if (view != a.this.lpZ) {
                        if (view == a.this.lpY) {
                            dVar.DY(4);
                            return;
                        }
                        return;
                    }
                    dVar.DY(2);
                } else {
                    dVar.DY(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.lpY && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.DY(5);
                    return true;
                }
                return false;
            }
        };
        this.lpX.setOnClickListener(onClickListener);
        this.lpZ.setOnClickListener(onClickListener);
        this.lqa.setOnClickListener(onClickListener);
        this.lqb.setOnClickListener(onClickListener);
        this.lqc.setOnClickListener(onClickListener);
        this.lpY.setOnClickListener(onClickListener);
        this.lpY.setOnLongClickListener(onLongClickListener);
    }

    private void DZ(int i) {
        this.lpU.findViewById(R.id.line0).setVisibility(i);
    }

    public void dbL() {
        if (this.lpX != null) {
            this.lpX.refresh();
        }
    }

    public void nq(int i) {
        an.setBackgroundColor(this.lpV, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lpU.getLayoutMode().setNightMode(i == 1);
        this.lpU.getLayoutMode().onModeChanged(this.lpV);
        dbL();
    }
}
