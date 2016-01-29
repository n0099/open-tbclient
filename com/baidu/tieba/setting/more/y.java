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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity dKI;
    private s dKJ;
    private AlertDialog dKK;
    private View dKL;
    private TbSettingTextTipView dKM;
    private SettingTextImageView dKN;
    private TbSettingTextTipView dKO;
    private TbSettingTextTipView dKP;
    private TbSettingTextTipView dKQ;
    private TbSettingTextTipView dKR;
    private SettingTextVersionView dKS;
    private TbSettingTextTipView dKT;
    private TbSettingTextTipView dKU;
    private View dKV;
    private TbSettingTextNewDotView dKW;
    private TextView dKX;
    private RelativeLayout dKY;
    private View dKZ;
    private NavigationBar mNavigationBar;

    public y(MoreActivity moreActivity, s sVar) {
        super(moreActivity.getPageContext());
        this.dKI = moreActivity;
        this.dKJ = sVar;
        this.dKI.setContentView(t.h.more_activity);
        Bk();
    }

    public void aHw() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.dKN.setVisibility(8);
        } else {
            this.dKN.setVisibility(0);
        }
    }

    public void G(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.dKN != null) {
                this.dKN.aIt();
                return;
            }
            return;
        }
        this.dKN.aIu();
        this.dKN.H(str, z);
    }

    public void refreshNewVersion() {
        if (this.dKS != null) {
            this.dKS.refresh();
        }
        if (this.dKW != null) {
            this.dKW.refresh();
        }
    }

    public void aGy() {
        this.dKN.recycle();
        this.dKO.recycle();
        this.dKP.recycle();
        this.dKQ.recycle();
        this.dKR.recycle();
        this.dKS.recycle();
        this.dKT.recycle();
        this.dKU.recycle();
    }

    public void onChangeSkinType(int i) {
        ej(i);
        if (this.dKL != null) {
            this.dKI.getLayoutMode().ac(i == 1);
            this.dKI.getLayoutMode().x(this.dKL);
        }
    }

    public void ej(int i) {
        com.baidu.tbadk.core.util.ar.l(this.dKY, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dKN.ej(i);
        this.dKI.getLayoutMode().ac(i == 1);
        this.dKI.getLayoutMode().x(this.dKY);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void Bk() {
        View.OnClickListener aHx = aHx();
        this.dKY = (RelativeLayout) this.dKI.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.dKI.findViewById(t.g.view_navigation_bar);
        this.dKZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dKI.getPageContext().getString(t.j.setup));
        this.dKM = (TbSettingTextTipView) this.dKI.findViewById(t.g.accountSafeSetting);
        this.dKN = (SettingTextImageView) this.dKI.findViewById(t.g.personInfo);
        this.dKO = (TbSettingTextTipView) this.dKI.findViewById(t.g.accountManager);
        this.dKP = (TbSettingTextTipView) this.dKI.findViewById(t.g.browseSetting);
        this.dKQ = (TbSettingTextTipView) this.dKI.findViewById(t.g.messageSetting);
        this.dKR = (TbSettingTextTipView) this.dKI.findViewById(t.g.secretSetting);
        this.dKS = (SettingTextVersionView) this.dKI.findViewById(t.g.versionInfo);
        this.dKT = (TbSettingTextTipView) this.dKI.findViewById(t.g.feedBack);
        this.dKU = (TbSettingTextTipView) this.dKI.findViewById(t.g.recommend);
        this.dKV = this.dKI.findViewById(t.g.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.dKU.setVisibility(8);
            this.dKV.setVisibility(8);
        } else {
            this.dKU.setVisibility(0);
            this.dKV.setVisibility(0);
        }
        this.dKW = (TbSettingTextNewDotView) this.dKI.findViewById(t.g.systemhelpsetting);
        this.dKX = (TextView) this.dKI.findViewById(t.g.quit);
        refreshNewVersion();
        aHw();
        this.dKN.aIt();
        ej(TbadkCoreApplication.m411getInst().getSkinType());
        R(aHx);
        if (!QE()) {
            this.dKP.setTip(this.dKI.getResources().getString(t.j.browsing_settings_tip_no_night));
        }
    }

    private boolean QE() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void aqq() {
        this.dKL = LayoutInflater.from(this.dKI.getPageContext().getPageActivity()).inflate(t.h.quit_dialog, (ViewGroup) null);
        this.dKI.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dKI.getLayoutMode().x(this.dKL);
        ((TextView) this.dKL.findViewById(t.g.id_close_tv)).setOnClickListener(new z(this));
        ((TextView) this.dKL.findViewById(t.g.id_quit_tv)).setOnClickListener(new aa(this));
        this.dKK = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.h.j.a(this.dKK, this.mContext.getPageActivity());
        if (this.dKK.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.dKK.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.dKK.getWindow().setAttributes(attributes);
            this.dKK.getWindow().setContentView(this.dKL);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        this.dKM.setOnClickListener(onClickListener);
        this.dKZ.setOnClickListener(onClickListener);
        this.dKN.setOnClickListener(onClickListener);
        this.dKO.setOnClickListener(onClickListener);
        this.dKP.setOnClickListener(onClickListener);
        this.dKQ.setOnClickListener(onClickListener);
        this.dKR.setOnClickListener(onClickListener);
        this.dKS.setOnClickListener(onClickListener);
        this.dKT.setOnClickListener(onClickListener);
        this.dKU.setOnClickListener(onClickListener);
        this.dKW.setOnClickListener(onClickListener);
        this.dKX.setOnClickListener(onClickListener);
    }

    private View.OnClickListener aHx() {
        return new ab(this);
    }

    public void aHy() {
        if (this.dKK == null) {
            aqq();
        }
        com.baidu.adp.lib.h.j.a(this.dKK, this.dKI.getPageContext());
    }

    public void aHz() {
        if (this.dKK != null) {
            com.baidu.adp.lib.h.j.b(this.dKK, this.dKI.getPageContext());
        }
    }
}
