package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<AboutActivity> {
    private TbSettingTextTipView iQA;
    protected TextView iQB;
    private ProgressBar iQC;
    private AboutActivity iQs;
    private RelativeLayout iQt;
    private TextView iQu;
    private SettingTextTestNewView iQv;
    private ImageView iQw;
    private TbSettingTextTipView iQx;
    private TbSettingTextTipView iQy;
    private TbSettingTextTipView iQz;
    private NavigationBar mNavigationBar;

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.iQs = aboutActivity;
        aqv();
        a(dVar);
    }

    public void cjK() {
        if (this.iQC != null) {
            this.iQC.setVisibility(0);
        }
    }

    public void brJ() {
        if (this.iQC != null) {
            this.iQC.setVisibility(8);
        }
    }

    private void aqv() {
        this.iQs.setContentView(R.layout.about_activity);
        this.iQt = (RelativeLayout) this.iQs.findViewById(R.id.parent);
        this.iQw = (ImageView) this.iQs.findViewById(R.id.image_logo);
        this.mNavigationBar = (NavigationBar) this.iQs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iQs.getPageContext().getString(R.string.version_info));
        this.iQu = (TextView) this.iQs.findViewById(R.id.text_versioninfo);
        this.iQv = (SettingTextTestNewView) this.iQs.findViewById(R.id.about_version_update);
        this.iQx = (TbSettingTextTipView) this.iQs.findViewById(R.id.about_guide);
        this.iQx.hideArrow();
        this.iQy = (TbSettingTextTipView) this.iQs.findViewById(R.id.tieba_protocol_text);
        this.iQy.hideArrow();
        this.iQz = (TbSettingTextTipView) this.iQs.findViewById(R.id.tieba_privacy_text);
        this.iQz.hideArrow();
        this.iQA = (TbSettingTextTipView) this.iQs.findViewById(R.id.tieba_tdou_use_introduce);
        this.iQA.hideArrow();
        this.iQC = (ProgressBar) this.iQs.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !aq.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.iQu.setText(this.iQs.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.iQs.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.iQB = (TextView) this.iQs.findViewById(R.id.text_version_protoco);
        jZ(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.iQx.setVisibility(8);
            this.iQs.findViewById(R.id.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("debug_plugin_switcher", false)) {
            Ai(0);
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
                if (view == a.this.iQy) {
                    bb.ajC().c(a.this.iQs.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == a.this.iQz) {
                    bb.ajC().a(a.this.iQs.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
                } else if (view == a.this.iQA) {
                    bb.ajC().c(a.this.iQs.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                } else if (view != a.this.iQv) {
                    if (view != a.this.iQx) {
                        if (view == a.this.iQw) {
                            dVar.Ah(4);
                            return;
                        }
                        return;
                    }
                    dVar.Ah(2);
                } else {
                    dVar.Ah(1);
                }
            }
        };
        this.iQv.setOnClickListener(onClickListener);
        this.iQx.setOnClickListener(onClickListener);
        this.iQy.setOnClickListener(onClickListener);
        this.iQz.setOnClickListener(onClickListener);
        this.iQA.setOnClickListener(onClickListener);
        this.iQw.setOnClickListener(onClickListener);
    }

    private void Ai(int i) {
        this.iQs.findViewById(R.id.line0).setVisibility(i);
    }

    public void cjL() {
        if (this.iQv != null) {
            this.iQv.refresh();
        }
    }

    public void jZ(int i) {
        am.l(this.iQt, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iQs.getLayoutMode().setNightMode(i == 1);
        this.iQs.getLayoutMode().onModeChanged(this.iQt);
        cjL();
    }
}
