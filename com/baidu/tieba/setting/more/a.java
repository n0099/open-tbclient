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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d<AboutActivity> {
    private long[] cOM;
    private NavigationBar mNavigationBar;
    private TextView mVA;
    private SettingTextTestNewView mVB;
    private ImageView mVC;
    private TbSettingTextTipView mVD;
    private TbSettingTextTipView mVE;
    private TbSettingTextTipView mVF;
    private TbSettingTextTipView mVG;
    protected TextView mVH;
    private ProgressBar mVI;
    private AboutActivity mVy;
    private RelativeLayout mVz;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cOM = new long[5];
        this.mVy = aboutActivity;
        bzm();
        a(dVar);
    }

    public void dEm() {
        if (this.mVI != null) {
            this.mVI.setVisibility(0);
        }
    }

    public void cIV() {
        if (this.mVI != null) {
            this.mVI.setVisibility(8);
        }
    }

    private void bzm() {
        this.mVy.setContentView(R.layout.about_activity);
        this.mVz = (RelativeLayout) this.mVy.findViewById(R.id.parent);
        this.mVC = (ImageView) this.mVy.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.mVy.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVy.getPageContext().getString(R.string.version_info));
        this.mVA = (TextView) this.mVy.findViewById(R.id.text_versioninfo);
        this.mVB = (SettingTextTestNewView) this.mVy.findViewById(R.id.about_version_update);
        this.mVD = (TbSettingTextTipView) this.mVy.findViewById(R.id.about_guide);
        this.mVD.hideArrow();
        this.mVE = (TbSettingTextTipView) this.mVy.findViewById(R.id.tieba_protocol_text);
        this.mVE.hideArrow();
        this.mVF = (TbSettingTextTipView) this.mVy.findViewById(R.id.tieba_privacy_text);
        this.mVF.hideArrow();
        this.mVG = (TbSettingTextTipView) this.mVy.findViewById(R.id.tieba_tdou_use_introduce);
        this.mVG.hideArrow();
        this.mVI = (ProgressBar) this.mVy.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.mVA.setText(this.mVy.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.mVy.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.mVH = (TextView) this.mVy.findViewById(R.id.text_version_protoco);
        qE(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.mVD.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Im(0);
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
                if (view == a.this.mVE) {
                    be.bsB().b(a.this.mVy.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.mVF) {
                    be.bsB().a(a.this.mVy.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.mVG) {
                    be.bsB().b(a.this.mVy.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.mVB) {
                    if (view != a.this.mVD) {
                        if (view == a.this.mVC) {
                            dVar.Il(4);
                            System.arraycopy(a.this.cOM, 1, a.this.cOM, 0, a.this.cOM.length - 1);
                            a.this.cOM[a.this.cOM.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cOM[0] >= a.this.cOM[a.this.cOM.length - 1] - 2000) {
                                a.this.cOM = new long[5];
                                dVar.Il(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.Il(2);
                } else {
                    dVar.Il(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.mVC && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Il(5);
                    return true;
                }
                return false;
            }
        };
        this.mVB.setOnClickListener(onClickListener);
        this.mVD.setOnClickListener(onClickListener);
        this.mVE.setOnClickListener(onClickListener);
        this.mVF.setOnClickListener(onClickListener);
        this.mVG.setOnClickListener(onClickListener);
        this.mVC.setOnClickListener(onClickListener);
        this.mVC.setOnLongClickListener(onLongClickListener);
    }

    private void Im(int i) {
        this.mVy.findViewById(R.id.line0).setVisibility(i);
    }

    public void dEn() {
        if (this.mVB != null) {
            this.mVB.refresh();
        }
    }

    public void qE(int i) {
        ao.setBackgroundColor(this.mVz, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mVy.getLayoutMode().setNightMode(i == 1);
        this.mVy.getLayoutMode().onModeChanged(this.mVz);
        dEn();
    }
}
