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
public class x extends com.baidu.adp.base.f<MoreActivity> {
    private TbSettingTextTipView dnA;
    private SettingTextVersionView dnB;
    private TbSettingTextTipView dnC;
    private TbSettingTextTipView dnD;
    private View dnE;
    private TbSettingTextNewDotView dnF;
    private TextView dnG;
    private RelativeLayout dnH;
    private View dnI;
    private MoreActivity dnr;
    private s dns;
    private AlertDialog dnt;
    private View dnu;
    private TbSettingTextTipView dnv;
    private SettingTextImageView dnw;
    private TbSettingTextTipView dnx;
    private TbSettingTextTipView dny;
    private TbSettingTextTipView dnz;
    private NavigationBar mNavigationBar;

    public x(MoreActivity moreActivity, s sVar) {
        super(moreActivity.getPageContext());
        this.dnr = moreActivity;
        this.dns = sVar;
        this.dnr.setContentView(n.g.more_activity);
        Ai();
    }

    public void ayj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.dnw.setVisibility(8);
        } else {
            this.dnw.setVisibility(0);
        }
    }

    public void H(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.dnw != null) {
                this.dnw.azg();
                return;
            }
            return;
        }
        this.dnw.azh();
        this.dnw.I(str, z);
    }

    public void refreshNewVersion() {
        if (this.dnB != null) {
            this.dnB.refresh();
        }
        if (this.dnF != null) {
            this.dnF.refresh();
        }
    }

    public void axk() {
        this.dnw.recycle();
        this.dnx.recycle();
        this.dny.recycle();
        this.dnz.recycle();
        this.dnA.recycle();
        this.dnB.recycle();
        this.dnC.recycle();
        this.dnD.recycle();
    }

    public void onChangeSkinType(int i) {
        dU(i);
        if (this.dnu != null) {
            this.dnr.getLayoutMode().af(i == 1);
            this.dnr.getLayoutMode().k(this.dnu);
        }
    }

    public void dU(int i) {
        com.baidu.tbadk.core.util.as.j(this.dnH, n.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnw.dU(i);
        this.dnr.getLayoutMode().af(i == 1);
        this.dnr.getLayoutMode().k(this.dnH);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void Ai() {
        View.OnClickListener ayk = ayk();
        this.dnH = (RelativeLayout) this.dnr.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) this.dnr.findViewById(n.f.view_navigation_bar);
        this.dnI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dnr.getPageContext().getString(n.i.setup));
        this.dnv = (TbSettingTextTipView) this.dnr.findViewById(n.f.accountSafeSetting);
        this.dnw = (SettingTextImageView) this.dnr.findViewById(n.f.personInfo);
        this.dnx = (TbSettingTextTipView) this.dnr.findViewById(n.f.accountManager);
        this.dny = (TbSettingTextTipView) this.dnr.findViewById(n.f.browseSetting);
        this.dnz = (TbSettingTextTipView) this.dnr.findViewById(n.f.messageSetting);
        this.dnA = (TbSettingTextTipView) this.dnr.findViewById(n.f.secretSetting);
        this.dnB = (SettingTextVersionView) this.dnr.findViewById(n.f.versionInfo);
        this.dnC = (TbSettingTextTipView) this.dnr.findViewById(n.f.feedBack);
        this.dnD = (TbSettingTextTipView) this.dnr.findViewById(n.f.recommend);
        this.dnE = this.dnr.findViewById(n.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.dnD.setVisibility(8);
            this.dnE.setVisibility(8);
        } else {
            this.dnD.setVisibility(0);
            this.dnE.setVisibility(0);
        }
        this.dnF = (TbSettingTextNewDotView) this.dnr.findViewById(n.f.systemhelpsetting);
        this.dnG = (TextView) this.dnr.findViewById(n.f.quit);
        refreshNewVersion();
        ayj();
        this.dnw.azg();
        dU(TbadkCoreApplication.m411getInst().getSkinType());
        M(ayk);
        if (!Ok()) {
            this.dny.setTip(this.dnr.getResources().getString(n.i.browsing_settings_tip_no_night));
        }
    }

    private boolean Ok() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.dnu = LayoutInflater.from(this.dnr.getPageContext().getPageActivity()).inflate(n.g.quit_dialog, (ViewGroup) null);
        this.dnr.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dnr.getLayoutMode().k(this.dnu);
        ((TextView) this.dnu.findViewById(n.f.id_close_tv)).setOnClickListener(new y(this));
        ((TextView) this.dnu.findViewById(n.f.id_quit_tv)).setOnClickListener(new z(this));
        this.dnt = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.h.j.a(this.dnt, this.mContext.getPageActivity());
        if (this.dnt.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.dnt.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.dnt.getWindow().setAttributes(attributes);
            this.dnt.getWindow().setContentView(this.dnu);
        }
    }

    private void M(View.OnClickListener onClickListener) {
        this.dnv.setOnClickListener(onClickListener);
        this.dnI.setOnClickListener(onClickListener);
        this.dnw.setOnClickListener(onClickListener);
        this.dnx.setOnClickListener(onClickListener);
        this.dny.setOnClickListener(onClickListener);
        this.dnz.setOnClickListener(onClickListener);
        this.dnA.setOnClickListener(onClickListener);
        this.dnB.setOnClickListener(onClickListener);
        this.dnC.setOnClickListener(onClickListener);
        this.dnD.setOnClickListener(onClickListener);
        this.dnF.setOnClickListener(onClickListener);
        this.dnG.setOnClickListener(onClickListener);
    }

    private View.OnClickListener ayk() {
        return new aa(this);
    }

    public void ayl() {
        if (this.dnt == null) {
            createDialog();
        }
        com.baidu.adp.lib.h.j.a(this.dnt, this.dnr.getPageContext());
    }

    public void aym() {
        if (this.dnt == null) {
            com.baidu.adp.lib.h.j.b(this.dnt, this.dnr.getPageContext());
        }
    }
}
