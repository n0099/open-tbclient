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
    private AboutActivity nae;
    private RelativeLayout naf;
    private TextView nag;
    private SettingTextTestNewView nah;
    private ImageView nai;
    private TbSettingTextTipView naj;
    private TbSettingTextTipView nak;
    private TbSettingTextTipView nal;
    private TbSettingTextTipView nam;
    protected TextView nan;
    private ProgressBar nao;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cTy = new long[5];
        this.nae = aboutActivity;
        bDf();
        a(dVar);
    }

    public void dId() {
        if (this.nao != null) {
            this.nao.setVisibility(0);
        }
    }

    public void cMM() {
        if (this.nao != null) {
            this.nao.setVisibility(8);
        }
    }

    private void bDf() {
        this.nae.setContentView(R.layout.about_activity);
        this.naf = (RelativeLayout) this.nae.findViewById(R.id.parent);
        this.nai = (ImageView) this.nae.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.nae.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nae.getPageContext().getString(R.string.version_info));
        this.nag = (TextView) this.nae.findViewById(R.id.text_versioninfo);
        this.nah = (SettingTextTestNewView) this.nae.findViewById(R.id.about_version_update);
        this.naj = (TbSettingTextTipView) this.nae.findViewById(R.id.about_guide);
        this.naj.hideArrow();
        this.nak = (TbSettingTextTipView) this.nae.findViewById(R.id.tieba_protocol_text);
        this.nak.hideArrow();
        this.nal = (TbSettingTextTipView) this.nae.findViewById(R.id.tieba_privacy_text);
        this.nal.hideArrow();
        this.nam = (TbSettingTextTipView) this.nae.findViewById(R.id.tieba_tdou_use_introduce);
        this.nam.hideArrow();
        this.nao = (ProgressBar) this.nae.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !at.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.nag.setText(this.nae.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.nae.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.nan = (TextView) this.nae.findViewById(R.id.text_version_protoco);
        sk(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.naj.setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.PREFS_DEBUG_PLUGIN_SWITCHER, false)) {
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
                if (view == a.this.nak) {
                    be.bwu().b(a.this.nae.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.nal) {
                    be.bwu().a(a.this.nae.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.nam) {
                    be.bwu().b(a.this.nae.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.nah) {
                    if (view != a.this.naj) {
                        if (view == a.this.nai) {
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
                if (view == a.this.nai && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.JS(5);
                    return true;
                }
                return false;
            }
        };
        this.nah.setOnClickListener(onClickListener);
        this.naj.setOnClickListener(onClickListener);
        this.nak.setOnClickListener(onClickListener);
        this.nal.setOnClickListener(onClickListener);
        this.nam.setOnClickListener(onClickListener);
        this.nai.setOnClickListener(onClickListener);
        this.nai.setOnLongClickListener(onLongClickListener);
    }

    private void JT(int i) {
        this.nae.findViewById(R.id.line0).setVisibility(i);
    }

    public void dIe() {
        if (this.nah != null) {
            this.nah.refresh();
        }
    }

    public void sk(int i) {
        ao.setBackgroundColor(this.naf, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nae.getLayoutMode().setNightMode(i == 1);
        this.nae.getLayoutMode().onModeChanged(this.naf);
        dIe();
    }
}
