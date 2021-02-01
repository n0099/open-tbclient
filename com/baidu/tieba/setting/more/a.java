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
    private AboutActivity nfh;
    private RelativeLayout nfi;
    private TextView nfj;
    private SettingTextTestNewView nfk;
    private ImageView nfl;
    private TbSettingTextTipView nfm;
    private TbSettingTextTipView nfn;
    private TbSettingTextTipView nfo;
    private TbSettingTextTipView nfp;
    protected TextView nfq;
    private ProgressBar nfr;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.cRa = new long[5];
        this.nfh = aboutActivity;
        bzE();
        a(dVar);
    }

    public void dGx() {
        if (this.nfr != null) {
            this.nfr.setVisibility(0);
        }
    }

    public void cKi() {
        if (this.nfr != null) {
            this.nfr.setVisibility(8);
        }
    }

    private void bzE() {
        this.nfh.setContentView(R.layout.about_activity);
        this.nfi = (RelativeLayout) this.nfh.findViewById(R.id.parent);
        this.nfl = (ImageView) this.nfh.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.nfh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nfh.getPageContext().getString(R.string.version_info));
        this.nfj = (TextView) this.nfh.findViewById(R.id.text_versioninfo);
        this.nfk = (SettingTextTestNewView) this.nfh.findViewById(R.id.about_version_update);
        this.nfm = (TbSettingTextTipView) this.nfh.findViewById(R.id.about_guide);
        this.nfm.hideArrow();
        this.nfn = (TbSettingTextTipView) this.nfh.findViewById(R.id.tieba_protocol_text);
        this.nfn.hideArrow();
        this.nfo = (TbSettingTextTipView) this.nfh.findViewById(R.id.tieba_privacy_text);
        this.nfo.hideArrow();
        this.nfp = (TbSettingTextTipView) this.nfh.findViewById(R.id.tieba_tdou_use_introduce);
        this.nfp.hideArrow();
        this.nfr = (ProgressBar) this.nfh.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !au.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.nfj.setText(this.nfh.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.nfh.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.nfq = (TextView) this.nfh.findViewById(R.id.text_version_protoco);
        qJ(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.nfm.setVisibility(8);
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
                if (view == a.this.nfn) {
                    bf.bsV().b(a.this.nfh.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.nfo) {
                    bf.bsV().a(a.this.nfh.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                } else if (view == a.this.nfp) {
                    bf.bsV().b(a.this.nfh.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.nfk) {
                    if (view != a.this.nfm) {
                        if (view == a.this.nfl) {
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
                if (view == a.this.nfl && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    dVar.IF(5);
                    return true;
                }
                return false;
            }
        };
        this.nfk.setOnClickListener(onClickListener);
        this.nfm.setOnClickListener(onClickListener);
        this.nfn.setOnClickListener(onClickListener);
        this.nfo.setOnClickListener(onClickListener);
        this.nfp.setOnClickListener(onClickListener);
        this.nfl.setOnClickListener(onClickListener);
        this.nfl.setOnLongClickListener(onLongClickListener);
    }

    private void IG(int i) {
        this.nfh.findViewById(R.id.line0).setVisibility(i);
    }

    public void dGy() {
        if (this.nfk != null) {
            this.nfk.refresh();
        }
    }

    public void qJ(int i) {
        ap.setBackgroundColor(this.nfi, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nfh.getLayoutMode().setNightMode(i == 1);
        this.nfh.getLayoutMode().onModeChanged(this.nfi);
        dGy();
    }
}
