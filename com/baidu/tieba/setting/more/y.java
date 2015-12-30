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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity duE;
    private s duF;
    private AlertDialog duG;
    private View duH;
    private TbSettingTextTipView duI;
    private SettingTextImageView duJ;
    private TbSettingTextTipView duK;
    private TbSettingTextTipView duL;
    private TbSettingTextTipView duM;
    private TbSettingTextTipView duN;
    private SettingTextVersionView duO;
    private TbSettingTextTipView duP;
    private TbSettingTextTipView duQ;
    private View duR;
    private TbSettingTextNewDotView duS;
    private TextView duT;
    private RelativeLayout duU;
    private View duV;
    private NavigationBar mNavigationBar;

    public y(MoreActivity moreActivity, s sVar) {
        super(moreActivity.getPageContext());
        this.duE = moreActivity;
        this.duF = sVar;
        this.duE.setContentView(n.h.more_activity);
        zU();
    }

    public void aAp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.duJ.setVisibility(8);
        } else {
            this.duJ.setVisibility(0);
        }
    }

    public void G(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.duJ != null) {
                this.duJ.aBm();
                return;
            }
            return;
        }
        this.duJ.aBn();
        this.duJ.H(str, z);
    }

    public void refreshNewVersion() {
        if (this.duO != null) {
            this.duO.refresh();
        }
        if (this.duS != null) {
            this.duS.refresh();
        }
    }

    public void azr() {
        this.duJ.recycle();
        this.duK.recycle();
        this.duL.recycle();
        this.duM.recycle();
        this.duN.recycle();
        this.duO.recycle();
        this.duP.recycle();
        this.duQ.recycle();
    }

    public void onChangeSkinType(int i) {
        dO(i);
        if (this.duH != null) {
            this.duE.getLayoutMode().ac(i == 1);
            this.duE.getLayoutMode().k(this.duH);
        }
    }

    public void dO(int i) {
        com.baidu.tbadk.core.util.as.j(this.duU, n.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.duJ.dO(i);
        this.duE.getLayoutMode().ac(i == 1);
        this.duE.getLayoutMode().k(this.duU);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zU() {
        View.OnClickListener aAq = aAq();
        this.duU = (RelativeLayout) this.duE.findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) this.duE.findViewById(n.g.view_navigation_bar);
        this.duV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.duE.getPageContext().getString(n.j.setup));
        this.duI = (TbSettingTextTipView) this.duE.findViewById(n.g.accountSafeSetting);
        this.duJ = (SettingTextImageView) this.duE.findViewById(n.g.personInfo);
        this.duK = (TbSettingTextTipView) this.duE.findViewById(n.g.accountManager);
        this.duL = (TbSettingTextTipView) this.duE.findViewById(n.g.browseSetting);
        this.duM = (TbSettingTextTipView) this.duE.findViewById(n.g.messageSetting);
        this.duN = (TbSettingTextTipView) this.duE.findViewById(n.g.secretSetting);
        this.duO = (SettingTextVersionView) this.duE.findViewById(n.g.versionInfo);
        this.duP = (TbSettingTextTipView) this.duE.findViewById(n.g.feedBack);
        this.duQ = (TbSettingTextTipView) this.duE.findViewById(n.g.recommend);
        this.duR = this.duE.findViewById(n.g.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.duQ.setVisibility(8);
            this.duR.setVisibility(8);
        } else {
            this.duQ.setVisibility(0);
            this.duR.setVisibility(0);
        }
        this.duS = (TbSettingTextNewDotView) this.duE.findViewById(n.g.systemhelpsetting);
        this.duT = (TextView) this.duE.findViewById(n.g.quit);
        refreshNewVersion();
        aAp();
        this.duJ.aBm();
        dO(TbadkCoreApplication.m411getInst().getSkinType());
        M(aAq);
        if (!OC()) {
            this.duL.setTip(this.duE.getResources().getString(n.j.browsing_settings_tip_no_night));
        }
    }

    private boolean OC() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.duH = LayoutInflater.from(this.duE.getPageContext().getPageActivity()).inflate(n.h.quit_dialog, (ViewGroup) null);
        this.duE.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.duE.getLayoutMode().k(this.duH);
        ((TextView) this.duH.findViewById(n.g.id_close_tv)).setOnClickListener(new z(this));
        ((TextView) this.duH.findViewById(n.g.id_quit_tv)).setOnClickListener(new aa(this));
        this.duG = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.h.j.a(this.duG, this.mContext.getPageActivity());
        if (this.duG.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.duG.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.duG.getWindow().setAttributes(attributes);
            this.duG.getWindow().setContentView(this.duH);
        }
    }

    private void M(View.OnClickListener onClickListener) {
        this.duI.setOnClickListener(onClickListener);
        this.duV.setOnClickListener(onClickListener);
        this.duJ.setOnClickListener(onClickListener);
        this.duK.setOnClickListener(onClickListener);
        this.duL.setOnClickListener(onClickListener);
        this.duM.setOnClickListener(onClickListener);
        this.duN.setOnClickListener(onClickListener);
        this.duO.setOnClickListener(onClickListener);
        this.duP.setOnClickListener(onClickListener);
        this.duQ.setOnClickListener(onClickListener);
        this.duS.setOnClickListener(onClickListener);
        this.duT.setOnClickListener(onClickListener);
    }

    private View.OnClickListener aAq() {
        return new ab(this);
    }

    public void aAr() {
        if (this.duG == null) {
            createDialog();
        }
        com.baidu.adp.lib.h.j.a(this.duG, this.duE.getPageContext());
    }

    public void aAs() {
        if (this.duG == null) {
            com.baidu.adp.lib.h.j.b(this.duG, this.duE.getPageContext());
        }
    }
}
