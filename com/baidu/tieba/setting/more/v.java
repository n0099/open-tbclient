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
    private MoreActivity cOV;
    private r cOW;
    private AlertDialog cOX;
    private View cOY;
    private TbSettingTextTipView cOZ;
    private SettingTextImageView cPa;
    private TbSettingTextTipView cPb;
    private TbSettingTextTipView cPc;
    private TbSettingTextTipView cPd;
    private TbSettingTextTipView cPe;
    private SettingTextVersionView cPf;
    private TbSettingTextTipView cPg;
    private TbSettingTextTipView cPh;
    private View cPi;
    private TbSettingTextNewDotView cPj;
    private TextView cPk;
    private RelativeLayout cPl;
    private View cPm;
    private NavigationBar mNavigationBar;

    public v(MoreActivity moreActivity, r rVar) {
        super(moreActivity.getPageContext());
        this.cOV = moreActivity;
        this.cOW = rVar;
        this.cOV.setContentView(i.g.more_activity);
        zm();
    }

    public void asH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cPa.setVisibility(8);
        } else {
            this.cPa.setVisibility(0);
        }
    }

    public void F(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cPa != null) {
                this.cPa.atE();
                return;
            }
            return;
        }
        this.cPa.atF();
        this.cPa.G(str, z);
    }

    public void refreshNewVersion() {
        if (this.cPf != null) {
            this.cPf.refresh();
        }
        if (this.cPj != null) {
            this.cPj.refresh();
        }
    }

    public void arM() {
        this.cPa.recycle();
        this.cPb.recycle();
        this.cPc.recycle();
        this.cPd.recycle();
        this.cPe.recycle();
        this.cPf.recycle();
        this.cPg.recycle();
        this.cPh.recycle();
    }

    public void onChangeSkinType(int i) {
        dF(i);
        if (this.cOY != null) {
            this.cOV.getLayoutMode().ad(i == 1);
            this.cOV.getLayoutMode().k(this.cOY);
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.an.j(this.cPl, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cPa.dF(i);
        this.cOV.getLayoutMode().ad(i == 1);
        this.cOV.getLayoutMode().k(this.cPl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zm() {
        View.OnClickListener asI = asI();
        this.cPl = (RelativeLayout) this.cOV.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cOV.findViewById(i.f.view_navigation_bar);
        this.cPm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cOV.getPageContext().getString(i.h.setup));
        this.cOZ = (TbSettingTextTipView) this.cOV.findViewById(i.f.accountSafeSetting);
        this.cPa = (SettingTextImageView) this.cOV.findViewById(i.f.personInfo);
        this.cPb = (TbSettingTextTipView) this.cOV.findViewById(i.f.accountManager);
        this.cPc = (TbSettingTextTipView) this.cOV.findViewById(i.f.browseSetting);
        this.cPd = (TbSettingTextTipView) this.cOV.findViewById(i.f.messageSetting);
        this.cPe = (TbSettingTextTipView) this.cOV.findViewById(i.f.secretSetting);
        this.cPf = (SettingTextVersionView) this.cOV.findViewById(i.f.versionInfo);
        this.cPg = (TbSettingTextTipView) this.cOV.findViewById(i.f.feedBack);
        this.cPh = (TbSettingTextTipView) this.cOV.findViewById(i.f.recommend);
        this.cPi = this.cOV.findViewById(i.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cPh.setVisibility(8);
            this.cPi.setVisibility(8);
        } else {
            this.cPh.setVisibility(0);
            this.cPi.setVisibility(0);
        }
        this.cPj = (TbSettingTextNewDotView) this.cOV.findViewById(i.f.systemhelpsetting);
        this.cPk = (TextView) this.cOV.findViewById(i.f.quit);
        refreshNewVersion();
        asH();
        this.cPa.atE();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        I(asI);
        if (!ML()) {
            this.cPc.setTip(this.cOV.getResources().getString(i.h.browsing_settings_tip_no_night));
        }
    }

    private boolean ML() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.cOY = LayoutInflater.from(this.cOV.getPageContext().getPageActivity()).inflate(i.g.quit_dialog, (ViewGroup) null);
        this.cOV.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cOV.getLayoutMode().k(this.cOY);
        ((TextView) this.cOY.findViewById(i.f.id_close_tv)).setOnClickListener(new w(this));
        ((TextView) this.cOY.findViewById(i.f.id_quit_tv)).setOnClickListener(new x(this));
        this.cOX = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.g.j.a(this.cOX, this.mContext.getPageActivity());
        if (this.cOX.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cOX.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cOX.getWindow().setAttributes(attributes);
            this.cOX.getWindow().setContentView(this.cOY);
        }
    }

    private void I(View.OnClickListener onClickListener) {
        this.cOZ.setOnClickListener(onClickListener);
        this.cPm.setOnClickListener(onClickListener);
        this.cPa.setOnClickListener(onClickListener);
        this.cPb.setOnClickListener(onClickListener);
        this.cPc.setOnClickListener(onClickListener);
        this.cPd.setOnClickListener(onClickListener);
        this.cPe.setOnClickListener(onClickListener);
        this.cPf.setOnClickListener(onClickListener);
        this.cPg.setOnClickListener(onClickListener);
        this.cPh.setOnClickListener(onClickListener);
        this.cPj.setOnClickListener(onClickListener);
        this.cPk.setOnClickListener(onClickListener);
    }

    private View.OnClickListener asI() {
        return new y(this);
    }

    public void asJ() {
        if (this.cOX == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.j.a(this.cOX, this.cOV.getPageContext());
    }

    public void asK() {
        if (this.cOX == null) {
            com.baidu.adp.lib.g.j.b(this.cOX, this.cOV.getPageContext());
        }
    }
}
