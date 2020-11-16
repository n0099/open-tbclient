package com.baidu.tieba.setting.more;

import android.os.SystemClock;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private long[] cHK;
    private AboutActivity mGD;
    private RelativeLayout mGE;
    private TextView mGF;
    private SettingTextTestNewView mGG;
    private ImageView mGH;
    private TbSettingTextTipView mGI;
    private TbSettingTextTipView mGJ;
    private TbSettingTextTipView mGK;
    private TbSettingTextTipView mGL;
    protected TextView mGM;
    private ProgressBar mGN;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cHK = new long[5];
        this.mGD = aboutActivity;
        bxl();
        a(dVar);
    }

    public void dDc() {
        if (this.mGN != null) {
            this.mGN.setVisibility(0);
        }
    }

    public void cEy() {
        if (this.mGN != null) {
            this.mGN.setVisibility(8);
        }
    }

    private void bxl() {
        this.mGD.setContentView(R.layout.about_activity);
        this.mGE = (RelativeLayout) this.mGD.findViewById(R.id.parent);
        this.mGH = (ImageView) this.mGD.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mGD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGD.getPageContext().getString(R.string.version_info));
        this.mGF = (TextView) this.mGD.findViewById(R.id.text_versioninfo);
        this.mGG = (SettingTextTestNewView) this.mGD.findViewById(R.id.about_version_update);
        this.mGI = (TbSettingTextTipView) this.mGD.findViewById(R.id.about_guide);
        this.mGI.hideArrow();
        this.mGJ = (TbSettingTextTipView) this.mGD.findViewById(R.id.tieba_protocol_text);
        this.mGJ.hideArrow();
        this.mGK = (TbSettingTextTipView) this.mGD.findViewById(R.id.tieba_privacy_text);
        this.mGK.hideArrow();
        this.mGL = (TbSettingTextTipView) this.mGD.findViewById(R.id.tieba_tdou_use_introduce);
        this.mGL.hideArrow();
        this.mGN = (ProgressBar) this.mGD.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !au.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mGF.setText(this.mGD.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mGD.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mGM = (TextView) this.mGD.findViewById(R.id.text_version_protoco);
        rx(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mGI.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Ji(0);
        }
    }

    private void a(final d dVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.a.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: com.baidu.tieba.setting.more.AboutActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.mGJ) {
                    bf.bqF().b(a.this.mGD.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mGK) {
                    bf.bqF().a(a.this.mGD.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mGL) {
                    bf.bqF().b(a.this.mGD.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mGG) {
                    if (view != a.this.mGI) {
                        if (view == a.this.mGH) {
                            dVar.Jh(4);
                            System.arraycopy(a.this.cHK, 1, a.this.cHK, 0, a.this.cHK.length - 1);
                            a.this.cHK[a.this.cHK.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cHK[0] >= a.this.cHK[a.this.cHK.length - 1] - 2000) {
                                a.this.cHK = new long[5];
                                dVar.Jh(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.Jh(2);
                } else {
                    dVar.Jh(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mGH && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Jh(5);
                    return true;
                }
                return false;
            }
        };
        this.mGG.setOnClickListener(onClickListener);
        this.mGI.setOnClickListener(onClickListener);
        this.mGJ.setOnClickListener(onClickListener);
        this.mGK.setOnClickListener(onClickListener);
        this.mGL.setOnClickListener(onClickListener);
        this.mGH.setOnClickListener(onClickListener);
        this.mGH.setOnLongClickListener(onLongClickListener);
    }

    private void Ji(int i) {
        this.mGD.findViewById(R.id.line0).setVisibility(i);
    }

    public void dDd() {
        if (this.mGG != null) {
            this.mGG.refresh();
        }
    }

    public void rx(int i) {
        ap.setBackgroundColor(this.mGE, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mGD.getLayoutMode().setNightMode(i == 1);
        this.mGD.getLayoutMode().onModeChanged(this.mGE);
        dDd();
    }
}
