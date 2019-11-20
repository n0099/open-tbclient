package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity iSL;
    private RelativeLayout iSM;
    private TextView iSN;
    private SettingTextTestNewView iSO;
    private ImageView iSP;
    private TbSettingTextTipView iSQ;
    private TbSettingTextTipView iSR;
    private TbSettingTextTipView iSS;
    private TbSettingTextTipView iST;
    protected TextView iSU;
    private ProgressBar iSV;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iSL = aboutActivity;
        asB();
        a(dVar);
    }

    public void ciy() {
        if (this.iSV != null) {
            this.iSV.setVisibility(0);
        }
    }

    public void bpL() {
        if (this.iSV != null) {
            this.iSV.setVisibility(8);
        }
    }

    private void asB() {
        this.iSL.setContentView(R.layout.about_activity);
        this.iSM = (RelativeLayout) this.iSL.findViewById(R.id.parent);
        this.iSP = (ImageView) this.iSL.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iSL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iSL.getPageContext().getString(R.string.version_info));
        this.iSN = (TextView) this.iSL.findViewById(R.id.text_versioninfo);
        this.iSO = (SettingTextTestNewView) this.iSL.findViewById(R.id.about_version_update);
        this.iSQ = (TbSettingTextTipView) this.iSL.findViewById(R.id.about_guide);
        this.iSQ.hideArrow();
        this.iSR = (TbSettingTextTipView) this.iSL.findViewById(R.id.tieba_protocol_text);
        this.iSR.hideArrow();
        this.iSS = (TbSettingTextTipView) this.iSL.findViewById(R.id.tieba_privacy_text);
        this.iSS.hideArrow();
        this.iST = (TbSettingTextTipView) this.iSL.findViewById(R.id.tieba_tdou_use_introduce);
        this.iST.hideArrow();
        this.iSV = (ProgressBar) this.iSL.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + DefaultConfig.TOKEN_SEPARATOR + TbConfig.getSubVersion();
        }
        this.iSN.setText(this.iSL.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iSL.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.iSU = (TextView) this.iSL.findViewById(R.id.text_version_protoco);
        jz(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.iSQ.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            yU(0);
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
                if (view == a.this.iSR) {
                    ba.amO().b(a.this.iSL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iSS) {
                    ba.amO().a(a.this.iSL.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iST) {
                    ba.amO().b(a.this.iSL.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iSO) {
                    if (view != a.this.iSQ) {
                        if (view == a.this.iSP) {
                            dVar.yT(4);
                            return;
                        }
                        return;
                    }
                    dVar.yT(2);
                } else {
                    dVar.yT(1);
                }
            }
        };
        this.iSO.setOnClickListener(onClickListener);
        this.iSQ.setOnClickListener(onClickListener);
        this.iSR.setOnClickListener(onClickListener);
        this.iSS.setOnClickListener(onClickListener);
        this.iST.setOnClickListener(onClickListener);
        this.iSP.setOnClickListener(onClickListener);
    }

    private void yU(int i) {
        this.iSL.findViewById(R.id.line0).setVisibility(i);
    }

    public void ciz() {
        if (this.iSO != null) {
            this.iSO.refresh();
        }
    }

    public void jz(int i) {
        am.setBackgroundColor(this.iSM, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iSL.getLayoutMode().setNightMode(i == 1);
        this.iSL.getLayoutMode().onModeChanged(this.iSM);
        ciz();
    }
}
