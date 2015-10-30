package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f<MoreActivity> {
    private r cNA;
    private AlertDialog cNB;
    private View cNC;
    private TbSettingTextTipView cND;
    private SettingTextImageView cNE;
    private TbSettingTextTipView cNF;
    private TbSettingTextTipView cNG;
    private TbSettingTextTipView cNH;
    private TbSettingTextTipView cNI;
    private SettingTextVersionView cNJ;
    private TbSettingTextTipView cNK;
    private TbSettingTextTipView cNL;
    private View cNM;
    private TbSettingTextNewDotView cNN;
    private TextView cNO;
    private RelativeLayout cNP;
    private View cNQ;
    private MoreActivity cNz;
    private NavigationBar mNavigationBar;

    public v(MoreActivity moreActivity, r rVar) {
        super(moreActivity.getPageContext());
        this.cNz = moreActivity;
        this.cNA = rVar;
        this.cNz.setContentView(i.g.more_activity);
        zh();
    }

    public void asb() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cNE.setVisibility(8);
        } else {
            this.cNE.setVisibility(0);
        }
    }

    public void F(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cNE != null) {
                this.cNE.asY();
                return;
            }
            return;
        }
        this.cNE.asZ();
        this.cNE.G(str, z);
    }

    public void refreshNewVersion() {
        if (this.cNJ != null) {
            this.cNJ.refresh();
        }
        if (this.cNN != null) {
            this.cNN.refresh();
        }
    }

    public void arg() {
        this.cNE.recycle();
        this.cNF.recycle();
        this.cNG.recycle();
        this.cNH.recycle();
        this.cNI.recycle();
        this.cNJ.recycle();
        this.cNK.recycle();
        this.cNL.recycle();
    }

    public void onChangeSkinType(int i) {
        dF(i);
        if (this.cNC != null) {
            this.cNz.getLayoutMode().ad(i == 1);
            this.cNz.getLayoutMode().k(this.cNC);
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.an.j(this.cNP, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cNE.dF(i);
        this.cNz.getLayoutMode().ad(i == 1);
        this.cNz.getLayoutMode().k(this.cNP);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zh() {
        View.OnClickListener asc = asc();
        this.cNP = (RelativeLayout) this.cNz.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cNz.findViewById(i.f.view_navigation_bar);
        this.cNQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cNz.getPageContext().getString(i.h.setup));
        this.cND = (TbSettingTextTipView) this.cNz.findViewById(i.f.accountSafeSetting);
        this.cNE = (SettingTextImageView) this.cNz.findViewById(i.f.personInfo);
        this.cNF = (TbSettingTextTipView) this.cNz.findViewById(i.f.accountManager);
        this.cNG = (TbSettingTextTipView) this.cNz.findViewById(i.f.browseSetting);
        this.cNH = (TbSettingTextTipView) this.cNz.findViewById(i.f.messageSetting);
        this.cNI = (TbSettingTextTipView) this.cNz.findViewById(i.f.secretSetting);
        this.cNJ = (SettingTextVersionView) this.cNz.findViewById(i.f.versionInfo);
        this.cNK = (TbSettingTextTipView) this.cNz.findViewById(i.f.feedBack);
        this.cNL = (TbSettingTextTipView) this.cNz.findViewById(i.f.recommend);
        this.cNM = this.cNz.findViewById(i.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cNL.setVisibility(8);
            this.cNM.setVisibility(8);
        } else {
            this.cNL.setVisibility(0);
            this.cNM.setVisibility(0);
        }
        this.cNN = (TbSettingTextNewDotView) this.cNz.findViewById(i.f.systemhelpsetting);
        this.cNO = (TextView) this.cNz.findViewById(i.f.quit);
        refreshNewVersion();
        asb();
        this.cNE.asY();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        I(asc);
        if (!Mv()) {
            this.cNG.setTip(this.cNz.getResources().getString(i.h.browsing_settings_tip_no_night));
        }
    }

    private boolean Mv() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.cNC = LayoutInflater.from(this.cNz.getPageContext().getPageActivity()).inflate(i.g.quit_dialog, (ViewGroup) null);
        this.cNz.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cNz.getLayoutMode().k(this.cNC);
        ((TextView) this.cNC.findViewById(i.f.id_close_tv)).setOnClickListener(new w(this));
        ((TextView) this.cNC.findViewById(i.f.id_quit_tv)).setOnClickListener(new x(this));
        this.cNB = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.g.j.a(this.cNB, this.mContext.getPageActivity());
        if (this.cNB.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cNB.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cNB.getWindow().setAttributes(attributes);
            this.cNB.getWindow().setContentView(this.cNC);
        }
    }

    private void I(View.OnClickListener onClickListener) {
        this.cND.setOnClickListener(onClickListener);
        this.cNQ.setOnClickListener(onClickListener);
        this.cNE.setOnClickListener(onClickListener);
        this.cNF.setOnClickListener(onClickListener);
        this.cNG.setOnClickListener(onClickListener);
        this.cNH.setOnClickListener(onClickListener);
        this.cNI.setOnClickListener(onClickListener);
        this.cNJ.setOnClickListener(onClickListener);
        this.cNK.setOnClickListener(onClickListener);
        this.cNL.setOnClickListener(onClickListener);
        this.cNN.setOnClickListener(onClickListener);
        this.cNO.setOnClickListener(onClickListener);
    }

    private View.OnClickListener asc() {
        return new y(this);
    }

    public void asd() {
        if (this.cNB == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.j.a(this.cNB, this.cNz.getPageContext());
    }

    public void ase() {
        if (this.cNB == null) {
            com.baidu.adp.lib.g.j.b(this.cNB, this.cNz.getPageContext());
        }
    }
}
