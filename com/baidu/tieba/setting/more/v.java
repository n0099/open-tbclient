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
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity cxC;
    private r cxD;
    private AlertDialog cxE;
    private View cxF;
    private TbSettingTextTipView cxG;
    private SettingTextImageView cxH;
    private TbSettingTextTipView cxI;
    private TbSettingTextTipView cxJ;
    private TbSettingTextTipView cxK;
    private TbSettingTextTipView cxL;
    private SettingTextVersionView cxM;
    private TbSettingTextTipView cxN;
    private TbSettingTextTipView cxO;
    private View cxP;
    private TbSettingTextNewDotView cxQ;
    private TextView cxR;
    private RelativeLayout cxS;
    private View cxT;
    private NavigationBar mNavigationBar;

    public v(MoreActivity moreActivity, r rVar) {
        super(moreActivity.getPageContext());
        this.cxC = moreActivity;
        this.cxD = rVar;
        this.cxC.setContentView(i.g.more_activity);
        zl();
    }

    public void alA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cxH.setVisibility(8);
        } else {
            this.cxH.setVisibility(0);
        }
    }

    public void C(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cxH != null) {
                this.cxH.amv();
                return;
            }
            return;
        }
        this.cxH.amw();
        this.cxH.D(str, z);
    }

    public void refreshNewVersion() {
        if (this.cxM != null) {
            this.cxM.refresh();
        }
        if (this.cxQ != null) {
            this.cxQ.refresh();
        }
    }

    public void akF() {
        this.cxH.recycle();
        this.cxI.recycle();
        this.cxJ.recycle();
        this.cxK.recycle();
        this.cxL.recycle();
        this.cxM.recycle();
        this.cxN.recycle();
        this.cxO.recycle();
    }

    public void onChangeSkinType(int i) {
        dw(i);
        if (this.cxF != null) {
            this.cxC.getLayoutMode().ad(i == 1);
            this.cxC.getLayoutMode().k(this.cxF);
        }
    }

    public void dw(int i) {
        com.baidu.tbadk.core.util.al.j(this.cxS, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cxH.dw(i);
        this.cxC.getLayoutMode().ad(i == 1);
        this.cxC.getLayoutMode().k(this.cxS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zl() {
        View.OnClickListener alB = alB();
        this.cxS = (RelativeLayout) this.cxC.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cxC.findViewById(i.f.view_navigation_bar);
        this.cxT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cxC.getPageContext().getString(i.C0057i.setup));
        this.cxG = (TbSettingTextTipView) this.cxC.findViewById(i.f.accountSafeSetting);
        this.cxH = (SettingTextImageView) this.cxC.findViewById(i.f.personInfo);
        this.cxI = (TbSettingTextTipView) this.cxC.findViewById(i.f.accountManager);
        this.cxJ = (TbSettingTextTipView) this.cxC.findViewById(i.f.browseSetting);
        this.cxK = (TbSettingTextTipView) this.cxC.findViewById(i.f.messageSetting);
        this.cxL = (TbSettingTextTipView) this.cxC.findViewById(i.f.secretSetting);
        this.cxM = (SettingTextVersionView) this.cxC.findViewById(i.f.versionInfo);
        this.cxN = (TbSettingTextTipView) this.cxC.findViewById(i.f.feedBack);
        this.cxO = (TbSettingTextTipView) this.cxC.findViewById(i.f.recommend);
        this.cxP = this.cxC.findViewById(i.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cxO.setVisibility(8);
            this.cxP.setVisibility(8);
        } else {
            this.cxO.setVisibility(0);
            this.cxP.setVisibility(0);
        }
        this.cxQ = (TbSettingTextNewDotView) this.cxC.findViewById(i.f.systemhelpsetting);
        this.cxR = (TextView) this.cxC.findViewById(i.f.quit);
        refreshNewVersion();
        alA();
        this.cxH.amv();
        dw(TbadkCoreApplication.m411getInst().getSkinType());
        G(alB);
        if (!MA()) {
            this.cxJ.setTip(this.cxC.getResources().getString(i.C0057i.browsing_settings_tip_no_night));
        }
    }

    private boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.cxF = LayoutInflater.from(this.cxC.getPageContext().getPageActivity()).inflate(i.g.quit_dialog, (ViewGroup) null);
        this.cxC.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cxC.getLayoutMode().k(this.cxF);
        ((TextView) this.cxF.findViewById(i.f.id_close_tv)).setOnClickListener(new w(this));
        ((TextView) this.cxF.findViewById(i.f.id_quit_tv)).setOnClickListener(new x(this));
        this.cxE = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.g.j.a(this.cxE, this.mContext.getPageActivity());
        if (this.cxE.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cxE.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cxE.getWindow().setAttributes(attributes);
            this.cxE.getWindow().setContentView(this.cxF);
        }
    }

    private void G(View.OnClickListener onClickListener) {
        this.cxG.setOnClickListener(onClickListener);
        this.cxT.setOnClickListener(onClickListener);
        this.cxH.setOnClickListener(onClickListener);
        this.cxI.setOnClickListener(onClickListener);
        this.cxJ.setOnClickListener(onClickListener);
        this.cxK.setOnClickListener(onClickListener);
        this.cxL.setOnClickListener(onClickListener);
        this.cxM.setOnClickListener(onClickListener);
        this.cxN.setOnClickListener(onClickListener);
        this.cxO.setOnClickListener(onClickListener);
        this.cxQ.setOnClickListener(onClickListener);
        this.cxR.setOnClickListener(onClickListener);
    }

    private View.OnClickListener alB() {
        return new y(this);
    }

    public void alC() {
        if (this.cxE == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.j.a(this.cxE, this.cxC.getPageContext());
    }

    public void alD() {
        if (this.cxE == null) {
            com.baidu.adp.lib.g.j.b(this.cxE, this.cxC.getPageContext());
        }
    }
}
