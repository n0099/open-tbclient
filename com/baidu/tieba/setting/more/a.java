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
    private AboutActivity kUO;
    private RelativeLayout kUP;
    private TextView kUQ;
    private SettingTextTestNewView kUR;
    private ImageView kUS;
    private TbSettingTextTipView kUT;
    private TbSettingTextTipView kUU;
    private TbSettingTextTipView kUV;
    private TbSettingTextTipView kUW;
    protected TextView kUX;
    private ProgressBar kUY;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.kUO = aboutActivity;
        bbA();
        a(dVar);
    }

    public void cXf() {
        if (this.kUY != null) {
            this.kUY.setVisibility(0);
        }
    }

    public void caU() {
        if (this.kUY != null) {
            this.kUY.setVisibility(8);
        }
    }

    private void bbA() {
        this.kUO.setContentView(R.layout.about_activity);
        this.kUP = (RelativeLayout) this.kUO.findViewById(R.id.parent);
        this.kUS = (ImageView) this.kUO.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.kUO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kUO.getPageContext().getString(R.string.version_info));
        this.kUQ = (TextView) this.kUO.findViewById(R.id.text_versioninfo);
        this.kUR = (SettingTextTestNewView) this.kUO.findViewById(R.id.about_version_update);
        this.kUT = (TbSettingTextTipView) this.kUO.findViewById(R.id.about_guide);
        this.kUT.hideArrow();
        this.kUU = (TbSettingTextTipView) this.kUO.findViewById(R.id.tieba_protocol_text);
        this.kUU.hideArrow();
        this.kUV = (TbSettingTextTipView) this.kUO.findViewById(R.id.tieba_privacy_text);
        this.kUV.hideArrow();
        this.kUW = (TbSettingTextTipView) this.kUO.findViewById(R.id.tieba_tdou_use_introduce);
        this.kUW.hideArrow();
        this.kUY = (ProgressBar) this.kUO.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.kUQ.setText(this.kUO.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.kUO.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.kUX = (TextView) this.kUO.findViewById(R.id.text_version_protoco);
        mU(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.kUT.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            CV(0);
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
                if (view == a.this.kUU) {
                    ba.aUZ().b(a.this.kUO.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.kUV) {
                    ba.aUZ().a(a.this.kUO.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.kUW) {
                    ba.aUZ().b(a.this.kUO.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.kUR) {
                    if (view != a.this.kUT) {
                        if (view == a.this.kUS) {
                            dVar.CU(4);
                            return;
                        }
                        return;
                    }
                    dVar.CU(2);
                } else {
                    dVar.CU(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.kUS && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.CU(5);
                    return true;
                }
                return false;
            }
        };
        this.kUR.setOnClickListener(onClickListener);
        this.kUT.setOnClickListener(onClickListener);
        this.kUU.setOnClickListener(onClickListener);
        this.kUV.setOnClickListener(onClickListener);
        this.kUW.setOnClickListener(onClickListener);
        this.kUS.setOnClickListener(onClickListener);
        this.kUS.setOnLongClickListener(onLongClickListener);
    }

    private void CV(int i) {
        this.kUO.findViewById(R.id.line0).setVisibility(i);
    }

    public void cXg() {
        if (this.kUR != null) {
            this.kUR.refresh();
        }
    }

    public void mU(int i) {
        am.setBackgroundColor(this.kUP, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kUO.getLayoutMode().setNightMode(i == 1);
        this.kUO.getLayoutMode().onModeChanged(this.kUP);
        cXg();
    }
}
