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
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<AboutActivity> {
    private long[] cTy;
    private NavigationBar mNavigationBar;
    private AboutActivity nad;
    private RelativeLayout nae;
    private TextView naf;
    private SettingTextTestNewView nag;
    private ImageView nah;
    private TbSettingTextTipView nai;
    private TbSettingTextTipView naj;
    private TbSettingTextTipView nak;
    private TbSettingTextTipView nal;
    protected TextView nam;
    private ProgressBar nan;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cTy = new long[5];
        this.nad = aboutActivity;
        bDg();
        a(dVar);
    }

    public void dIe() {
        if (this.nan != null) {
            this.nan.setVisibility(0);
        }
    }

    public void cMN() {
        if (this.nan != null) {
            this.nan.setVisibility(8);
        }
    }

    private void bDg() {
        this.nad.setContentView(R.layout.about_activity);
        this.nae = (RelativeLayout) this.nad.findViewById(R.id.parent);
        this.nah = (ImageView) this.nad.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.nad.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nad.getPageContext().getString(R.string.version_info));
        this.naf = (TextView) this.nad.findViewById(R.id.text_versioninfo);
        this.nag = (SettingTextTestNewView) this.nad.findViewById(R.id.about_version_update);
        this.nai = (TbSettingTextTipView) this.nad.findViewById(R.id.about_guide);
        this.nai.hideArrow();
        this.naj = (TbSettingTextTipView) this.nad.findViewById(R.id.tieba_protocol_text);
        this.naj.hideArrow();
        this.nak = (TbSettingTextTipView) this.nad.findViewById(R.id.tieba_privacy_text);
        this.nak.hideArrow();
        this.nal = (TbSettingTextTipView) this.nad.findViewById(R.id.tieba_tdou_use_introduce);
        this.nal.hideArrow();
        this.nan = (ProgressBar) this.nad.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.naf.setText(this.nad.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.nad.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.nam = (TextView) this.nad.findViewById(R.id.text_version_protoco);
        sk(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.nai.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
            JT(0);
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
                if (view == a.this.naj) {
                    be.bwv().b(a.this.nad.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.nak) {
                    be.bwv().a(a.this.nad.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.nal) {
                    be.bwv().b(a.this.nad.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.nag) {
                    if (view != a.this.nai) {
                        if (view == a.this.nah) {
                            dVar.JS(4);
                            System.arraycopy(a.this.cTy, 1, a.this.cTy, 0, a.this.cTy.length - 1);
                            a.this.cTy[a.this.cTy.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.cTy[0] >= a.this.cTy[a.this.cTy.length - 1] - 2000) {
                                a.this.cTy = new long[5];
                                dVar.JS(6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.JS(2);
                } else {
                    dVar.JS(1);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.setting.more.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view == a.this.nah && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.JS(5);
                    return true;
                }
                return false;
            }
        };
        this.nag.setOnClickListener(onClickListener);
        this.nai.setOnClickListener(onClickListener);
        this.naj.setOnClickListener(onClickListener);
        this.nak.setOnClickListener(onClickListener);
        this.nal.setOnClickListener(onClickListener);
        this.nah.setOnClickListener(onClickListener);
        this.nah.setOnLongClickListener(onLongClickListener);
    }

    private void JT(int i) {
        this.nad.findViewById(R.id.line0).setVisibility(i);
    }

    public void dIf() {
        if (this.nag != null) {
            this.nag.refresh();
        }
    }

    public void sk(int i) {
        ao.setBackgroundColor(this.nae, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nad.getLayoutMode().setNightMode(i == 1);
        this.nad.getLayoutMode().onModeChanged(this.nae);
        dIf();
    }
}
