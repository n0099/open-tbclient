package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
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
/* loaded from: classes11.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private AboutActivity jQP;
    private RelativeLayout jQQ;
    private TextView jQR;
    private SettingTextTestNewView jQS;
    private ImageView jQT;
    private TbSettingTextTipView jQU;
    private TbSettingTextTipView jQV;
    private TbSettingTextTipView jQW;
    private TbSettingTextTipView jQX;
    protected TextView jQY;
    private ProgressBar jQZ;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.jQP = aboutActivity;
        aKt();
        a(dVar);
    }

    public void cDI() {
        if (this.jQZ != null) {
            this.jQZ.setVisibility(0);
        }
    }

    public void bIj() {
        if (this.jQZ != null) {
            this.jQZ.setVisibility(8);
        }
    }

    private void aKt() {
        this.jQP.setContentView(R.layout.about_activity);
        this.jQQ = (RelativeLayout) this.jQP.findViewById(R.id.parent);
        this.jQT = (ImageView) this.jQP.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.jQP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jQP.getPageContext().getString(R.string.version_info));
        this.jQR = (TextView) this.jQP.findViewById(R.id.text_versioninfo);
        this.jQS = (SettingTextTestNewView) this.jQP.findViewById(R.id.about_version_update);
        this.jQU = (TbSettingTextTipView) this.jQP.findViewById(R.id.about_guide);
        this.jQU.hideArrow();
        this.jQV = (TbSettingTextTipView) this.jQP.findViewById(R.id.tieba_protocol_text);
        this.jQV.hideArrow();
        this.jQW = (TbSettingTextTipView) this.jQP.findViewById(R.id.tieba_privacy_text);
        this.jQW.hideArrow();
        this.jQX = (TbSettingTextTipView) this.jQP.findViewById(R.id.tieba_tdou_use_introduce);
        this.jQX.hideArrow();
        this.jQZ = (ProgressBar) this.jQP.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.jQR.setText(this.jQP.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.jQP.getPageContext().getString(R.string.setting_version_text) + HanziToPinyin.Token.SEPARATOR + version);
        this.jQY = (TextView) this.jQP.findViewById(R.id.text_version_protoco);
        lM(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.jQU.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            Bu(0);
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
                if (view == a.this.jQV) {
                    ba.aEt().b(a.this.jQP.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.jQW) {
                    ba.aEt().a(a.this.jQP.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.jQX) {
                    ba.aEt().b(a.this.jQP.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.jQS) {
                    if (view != a.this.jQU) {
                        if (view == a.this.jQT) {
                            dVar.Bt(4);
                            return;
                        }
                        return;
                    }
                    dVar.Bt(2);
                } else {
                    dVar.Bt(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.jQT && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.Bt(5);
                    return true;
                }
                return false;
            }
        };
        this.jQS.setOnClickListener(onClickListener);
        this.jQU.setOnClickListener(onClickListener);
        this.jQV.setOnClickListener(onClickListener);
        this.jQW.setOnClickListener(onClickListener);
        this.jQX.setOnClickListener(onClickListener);
        this.jQT.setOnClickListener(onClickListener);
        this.jQT.setOnLongClickListener(onLongClickListener);
    }

    private void Bu(int i) {
        this.jQP.findViewById(R.id.line0).setVisibility(i);
    }

    public void cDJ() {
        if (this.jQS != null) {
            this.jQS.refresh();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jQQ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jQP.getLayoutMode().setNightMode(i == 1);
        this.jQP.getLayoutMode().onModeChanged(this.jQQ);
        cDJ();
    }
}
