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
/* loaded from: classes26.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private long[] cOD;
    private NavigationBar mNavigationBar;
    private AboutActivity mUG;
    private RelativeLayout mUH;
    private TextView mUI;
    private SettingTextTestNewView mUJ;
    private ImageView mUL;
    private TbSettingTextTipView mUM;
    private TbSettingTextTipView mUN;
    private TbSettingTextTipView mUO;
    private TbSettingTextTipView mUP;
    protected TextView mUQ;
    private ProgressBar mUR;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cOD = new long[5];
        this.mUG = aboutActivity;
        bAL();
        a(dVar);
    }

    public void dIn() {
        if (this.mUR != null) {
            this.mUR.setVisibility(0);
        }
    }

    public void cJL() {
        if (this.mUR != null) {
            this.mUR.setVisibility(8);
        }
    }

    private void bAL() {
        this.mUG.setContentView(R.layout.about_activity);
        this.mUH = (RelativeLayout) this.mUG.findViewById(R.id.parent);
        this.mUL = (ImageView) this.mUG.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mUG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mUG.getPageContext().getString(R.string.version_info));
        this.mUI = (TextView) this.mUG.findViewById(R.id.text_versioninfo);
        this.mUJ = (SettingTextTestNewView) this.mUG.findViewById(R.id.about_version_update);
        this.mUM = (TbSettingTextTipView) this.mUG.findViewById(R.id.about_guide);
        this.mUM.hideArrow();
        this.mUN = (TbSettingTextTipView) this.mUG.findViewById(R.id.tieba_protocol_text);
        this.mUN.hideArrow();
        this.mUO = (TbSettingTextTipView) this.mUG.findViewById(R.id.tieba_privacy_text);
        this.mUO.hideArrow();
        this.mUP = (TbSettingTextTipView) this.mUG.findViewById(R.id.tieba_tdou_use_introduce);
        this.mUP.hideArrow();
        this.mUR = (ProgressBar) this.mUG.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !au.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mUI.setText(this.mUG.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mUG.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mUQ = (TextView) this.mUG.findViewById(R.id.text_version_protoco);
        rY(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mUM.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            JZ(0);
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
                if (view == a.this.mUN) {
                    bf.bua().b(a.this.mUG.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mUO) {
                    bf.bua().a(a.this.mUG.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mUP) {
                    bf.bua().b(a.this.mUG.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mUJ) {
                    if (view != a.this.mUM) {
                        if (view == a.this.mUL) {
                            dVar.JY(4);
                            System.arraycopy(a.this.cOD, 1, a.this.cOD, 0, a.this.cOD.length - 1);
                            a.this.cOD[a.this.cOD.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cOD[0] >= a.this.cOD[a.this.cOD.length - 1] - 2000) {
                                a.this.cOD = new long[5];
                                dVar.JY(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.JY(2);
                } else {
                    dVar.JY(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mUL && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.JY(5);
                    return true;
                }
                return false;
            }
        };
        this.mUJ.setOnClickListener(onClickListener);
        this.mUM.setOnClickListener(onClickListener);
        this.mUN.setOnClickListener(onClickListener);
        this.mUO.setOnClickListener(onClickListener);
        this.mUP.setOnClickListener(onClickListener);
        this.mUL.setOnClickListener(onClickListener);
        this.mUL.setOnLongClickListener(onLongClickListener);
    }

    private void JZ(int i) {
        this.mUG.findViewById(R.id.line0).setVisibility(i);
    }

    public void dIo() {
        if (this.mUJ != null) {
            this.mUJ.refresh();
        }
    }

    public void rY(int i) {
        ap.setBackgroundColor(this.mUH, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mUG.getLayoutMode().setNightMode(i == 1);
        this.mUG.getLayoutMode().onModeChanged(this.mUH);
        dIo();
    }
}
