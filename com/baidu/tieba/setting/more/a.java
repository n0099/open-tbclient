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
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<AboutActivity> {
    private long[] cRa;
    private NavigationBar mNavigationBar;
    private AboutActivity nfH;
    private RelativeLayout nfI;
    private TextView nfJ;
    private SettingTextTestNewView nfK;
    private ImageView nfL;
    private TbSettingTextTipView nfM;
    private TbSettingTextTipView nfN;
    private TbSettingTextTipView nfO;
    private TbSettingTextTipView nfP;
    protected TextView nfQ;
    private ProgressBar nfR;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cRa = new long[5];
        this.nfH = aboutActivity;
        bzE();
        a(dVar);
    }

    public void dGF() {
        if (this.nfR != null) {
            this.nfR.setVisibility(0);
        }
    }

    public void cKp() {
        if (this.nfR != null) {
            this.nfR.setVisibility(8);
        }
    }

    private void bzE() {
        this.nfH.setContentView(R.layout.about_activity);
        this.nfI = (RelativeLayout) this.nfH.findViewById(R.id.parent);
        this.nfL = (ImageView) this.nfH.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.nfH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nfH.getPageContext().getString(R.string.version_info));
        this.nfJ = (TextView) this.nfH.findViewById(R.id.text_versioninfo);
        this.nfK = (SettingTextTestNewView) this.nfH.findViewById(R.id.about_version_update);
        this.nfM = (TbSettingTextTipView) this.nfH.findViewById(R.id.about_guide);
        this.nfM.hideArrow();
        this.nfN = (TbSettingTextTipView) this.nfH.findViewById(R.id.tieba_protocol_text);
        this.nfN.hideArrow();
        this.nfO = (TbSettingTextTipView) this.nfH.findViewById(R.id.tieba_privacy_text);
        this.nfO.hideArrow();
        this.nfP = (TbSettingTextTipView) this.nfH.findViewById(R.id.tieba_tdou_use_introduce);
        this.nfP.hideArrow();
        this.nfR = (ProgressBar) this.nfH.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !au.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.nfJ.setText(this.nfH.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.nfH.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.nfQ = (TextView) this.nfH.findViewById(R.id.text_version_protoco);
        qJ(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.nfM.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            IG(0);
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
                if (view == a.this.nfN) {
                    bf.bsV().b(a.this.nfH.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.nfO) {
                    bf.bsV().a(a.this.nfH.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.nfP) {
                    bf.bsV().b(a.this.nfH.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.nfK) {
                    if (view != a.this.nfM) {
                        if (view == a.this.nfL) {
                            dVar.IF(4);
                            System.arraycopy(a.this.cRa, 1, a.this.cRa, 0, a.this.cRa.length - 1);
                            a.this.cRa[a.this.cRa.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cRa[0] >= a.this.cRa[a.this.cRa.length - 1] - 2000) {
                                a.this.cRa = new long[5];
                                dVar.IF(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.IF(2);
                } else {
                    dVar.IF(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.nfL && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.IF(5);
                    return true;
                }
                return false;
            }
        };
        this.nfK.setOnClickListener(onClickListener);
        this.nfM.setOnClickListener(onClickListener);
        this.nfN.setOnClickListener(onClickListener);
        this.nfO.setOnClickListener(onClickListener);
        this.nfP.setOnClickListener(onClickListener);
        this.nfL.setOnClickListener(onClickListener);
        this.nfL.setOnLongClickListener(onLongClickListener);
    }

    private void IG(int i) {
        this.nfH.findViewById(R.id.line0).setVisibility(i);
    }

    public void dGG() {
        if (this.nfK != null) {
            this.nfK.refresh();
        }
    }

    public void qJ(int i) {
        ap.setBackgroundColor(this.nfI, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nfH.getLayoutMode().setNightMode(i == 1);
        this.nfH.getLayoutMode().onModeChanged(this.nfI);
        dGG();
    }
}
