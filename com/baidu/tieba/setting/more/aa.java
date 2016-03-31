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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity ede;
    private s edf;
    private AlertDialog edg;
    private View edh;
    private TbSettingTextTipView edi;
    private SettingTextImageView edj;
    private TbSettingTextTipView edk;
    private TbSettingTextTipView edl;
    private MsgSettingItemView edm;
    private TbSettingTextTipView edn;
    private TbSettingTextTipView edo;
    private SettingTextVersionView edp;
    private TbSettingTextTipView edq;
    private TbSettingTextTipView edr;
    private View eds;
    private TbSettingTextNewDotView edt;
    private TextView edu;
    private RelativeLayout edv;
    private View edw;
    private NavigationBar mNavigationBar;

    public aa(MoreActivity moreActivity, s sVar) {
        super(moreActivity.getPageContext());
        this.ede = moreActivity;
        this.edf = sVar;
        this.ede.setContentView(t.h.more_activity);
        BN();
    }

    public void aOg() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.edj.setVisibility(8);
        } else {
            this.edj.setVisibility(0);
        }
    }

    public void H(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.edj != null) {
                this.edj.aPi();
                return;
            }
            return;
        }
        this.edj.aPj();
        this.edj.I(str, z);
    }

    public void refreshNewVersion() {
        if (this.edp != null) {
            this.edp.refresh();
        }
        if (this.edt != null) {
            this.edt.refresh();
        }
    }

    public void aNi() {
        this.edj.recycle();
        this.edk.recycle();
        this.edl.recycle();
        this.edn.recycle();
        this.edo.recycle();
        this.edp.recycle();
        this.edq.recycle();
        this.edr.recycle();
    }

    public void onChangeSkinType(int i) {
        em(i);
        if (this.edh != null) {
            this.ede.getLayoutMode().ab(i == 1);
            this.ede.getLayoutMode().x(this.edh);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void em(int i) {
        com.baidu.tbadk.core.util.at.l(this.edv, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.edj.em(i);
        this.ede.getLayoutMode().ab(i == 1);
        this.ede.getLayoutMode().x(this.edv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.edm.d(this.ede.getPageContext(), i);
        refreshNewVersion();
    }

    private void BN() {
        View.OnClickListener aOk = aOk();
        this.edv = (RelativeLayout) this.ede.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.ede.findViewById(t.g.view_navigation_bar);
        this.edw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ede.getPageContext().getString(t.j.setup));
        this.edi = (TbSettingTextTipView) this.ede.findViewById(t.g.accountSafeSetting);
        this.edj = (SettingTextImageView) this.ede.findViewById(t.g.personInfo);
        this.edk = (TbSettingTextTipView) this.ede.findViewById(t.g.accountManager);
        this.edl = (TbSettingTextTipView) this.ede.findViewById(t.g.browseSetting);
        this.edn = (TbSettingTextTipView) this.ede.findViewById(t.g.messageSetting);
        this.edo = (TbSettingTextTipView) this.ede.findViewById(t.g.secretSetting);
        this.edp = (SettingTextVersionView) this.ede.findViewById(t.g.versionInfo);
        this.edq = (TbSettingTextTipView) this.ede.findViewById(t.g.feedBack);
        this.edr = (TbSettingTextTipView) this.ede.findViewById(t.g.recommend);
        this.eds = this.ede.findViewById(t.g.line_recommend);
        this.edm = (MsgSettingItemView) this.ede.findViewById(t.g.memberAdSetting);
        aOh();
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.edr.setVisibility(8);
            this.eds.setVisibility(8);
        } else {
            this.edr.setVisibility(0);
            this.eds.setVisibility(0);
        }
        this.edt = (TbSettingTextNewDotView) this.ede.findViewById(t.g.systemhelpsetting);
        this.edu = (TextView) this.ede.findViewById(t.g.quit);
        refreshNewVersion();
        aOg();
        this.edj.aPi();
        em(TbadkCoreApplication.m411getInst().getSkinType());
        T(aOk);
        if (!Sx()) {
            this.edl.setTip(this.ede.getResources().getString(t.j.browsing_settings_tip_no_night));
        }
    }

    private void aOh() {
        int i;
        int i2 = 0;
        this.edm.setText(t.j.member_ad_setting_text);
        this.edm.setTipImageResource(t.f.label_red_svip);
        this.edm.setOnSwitchStateChangeListener(this.ede);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.edm.setVisibility(8);
        } else if (i2 == 0) {
            this.edm.mj();
        } else {
            this.edm.mi();
        }
    }

    public void aOi() {
        this.edm.mj();
    }

    public void aOj() {
        this.edm.mi();
    }

    private boolean Sx() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void axG() {
        this.edh = LayoutInflater.from(this.ede.getPageContext().getPageActivity()).inflate(t.h.quit_dialog, (ViewGroup) null);
        this.ede.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ede.getLayoutMode().x(this.edh);
        ((TextView) this.edh.findViewById(t.g.id_close_tv)).setOnClickListener(new ab(this));
        ((TextView) this.edh.findViewById(t.g.id_quit_tv)).setOnClickListener(new ac(this));
        this.edg = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.h.j.a(this.edg, this.mContext.getPageActivity());
        if (this.edg.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.edg.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.edg.getWindow().setAttributes(attributes);
            this.edg.getWindow().setContentView(this.edh);
        }
    }

    private void T(View.OnClickListener onClickListener) {
        this.edi.setOnClickListener(onClickListener);
        this.edw.setOnClickListener(onClickListener);
        this.edj.setOnClickListener(onClickListener);
        this.edk.setOnClickListener(onClickListener);
        this.edl.setOnClickListener(onClickListener);
        this.edn.setOnClickListener(onClickListener);
        this.edo.setOnClickListener(onClickListener);
        this.edp.setOnClickListener(onClickListener);
        this.edq.setOnClickListener(onClickListener);
        this.edr.setOnClickListener(onClickListener);
        this.edt.setOnClickListener(onClickListener);
        this.edu.setOnClickListener(onClickListener);
    }

    private View.OnClickListener aOk() {
        return new ad(this);
    }

    public void aOl() {
        if (this.edg == null) {
            axG();
        }
        com.baidu.adp.lib.h.j.a(this.edg, this.ede.getPageContext());
    }

    public void aOm() {
        if (this.edg != null) {
            com.baidu.adp.lib.h.j.b(this.edg, this.ede.getPageContext());
        }
    }
}
