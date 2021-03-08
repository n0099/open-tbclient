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
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d<AboutActivity> {
    private long[] cSA;
    private NavigationBar mNavigationBar;
    private AboutActivity nhL;
    private RelativeLayout nhM;
    private TextView nhN;
    private SettingTextTestNewView nhO;
    private ImageView nhP;
    private TbSettingTextTipView nhQ;
    private TbSettingTextTipView nhR;
    private TbSettingTextTipView nhS;
    private TbSettingTextTipView nhT;
    protected TextView nhU;
    private ProgressBar nhV;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cSA = new long[5];
        this.nhL = aboutActivity;
        bzH();
        a(dVar);
    }

    public void dGN() {
        if (this.nhV != null) {
            this.nhV.setVisibility(0);
        }
    }

    public void cKv() {
        if (this.nhV != null) {
            this.nhV.setVisibility(8);
        }
    }

    private void bzH() {
        this.nhL.setContentView(R.layout.about_activity);
        this.nhM = (RelativeLayout) this.nhL.findViewById(R.id.parent);
        this.nhP = (ImageView) this.nhL.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.nhL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nhL.getPageContext().getString(R.string.version_info));
        this.nhN = (TextView) this.nhL.findViewById(R.id.text_versioninfo);
        this.nhO = (SettingTextTestNewView) this.nhL.findViewById(R.id.about_version_update);
        this.nhQ = (TbSettingTextTipView) this.nhL.findViewById(R.id.about_guide);
        this.nhQ.hideArrow();
        this.nhR = (TbSettingTextTipView) this.nhL.findViewById(R.id.tieba_protocol_text);
        this.nhR.hideArrow();
        this.nhS = (TbSettingTextTipView) this.nhL.findViewById(R.id.tieba_privacy_text);
        this.nhS.hideArrow();
        this.nhT = (TbSettingTextTipView) this.nhL.findViewById(R.id.tieba_tdou_use_introduce);
        this.nhT.hideArrow();
        this.nhV = (ProgressBar) this.nhL.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !au.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.nhN.setText(this.nhL.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.nhL.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.nhU = (TextView) this.nhL.findViewById(R.id.text_version_protoco);
        qK(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.nhQ.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            IK(0);
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
                if (view == a.this.nhR) {
                    bf.bsY().b(a.this.nhL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.nhS) {
                    bf.bsY().a(a.this.nhL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.nhT) {
                    bf.bsY().b(a.this.nhL.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.nhO) {
                    if (view != a.this.nhQ) {
                        if (view == a.this.nhP) {
                            dVar.IJ(4);
                            System.arraycopy(a.this.cSA, 1, a.this.cSA, 0, a.this.cSA.length - 1);
                            a.this.cSA[a.this.cSA.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cSA[0] >= a.this.cSA[a.this.cSA.length - 1] - 2000) {
                                a.this.cSA = new long[5];
                                dVar.IJ(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.IJ(2);
                } else {
                    dVar.IJ(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.nhP && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.IJ(5);
                    return true;
                }
                return false;
            }
        };
        this.nhO.setOnClickListener(onClickListener);
        this.nhQ.setOnClickListener(onClickListener);
        this.nhR.setOnClickListener(onClickListener);
        this.nhS.setOnClickListener(onClickListener);
        this.nhT.setOnClickListener(onClickListener);
        this.nhP.setOnClickListener(onClickListener);
        this.nhP.setOnLongClickListener(onLongClickListener);
    }

    private void IK(int i) {
        this.nhL.findViewById(R.id.line0).setVisibility(i);
    }

    public void dGO() {
        if (this.nhO != null) {
            this.nhO.refresh();
        }
    }

    public void qK(int i) {
        ap.setBackgroundColor(this.nhM, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nhL.getLayoutMode().setNightMode(i == 1);
        this.nhL.getLayoutMode().onModeChanged(this.nhM);
        dGO();
    }
}
