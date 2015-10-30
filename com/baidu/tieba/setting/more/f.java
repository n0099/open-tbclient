package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<AccountSafeActivity> {
    private LinearLayout Mg;
    private NoNetworkView aMQ;
    private AccountSafeActivity cMB;
    private LinearLayout cMC;
    private View cMD;
    private BdSwitchView cME;
    private TbSettingTextTipView cMF;
    private TbSettingTextTipView cMG;
    private TbSettingTextTipView cMH;
    private TbSettingTextTipView cMI;
    private TbSettingTextTipView cMJ;
    private BdSwitchView.a cMK;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.cMK = new g(this);
        this.cMB = accountSafeActivity;
        zh();
    }

    private void zh() {
        this.cMB.setContentView(i.g.account_safe_activity);
        this.Mg = (LinearLayout) this.cMB.findViewById(i.f.parent);
        this.aMQ = (NoNetworkView) this.cMB.findViewById(i.f.no_network_view);
        this.cMC = (LinearLayout) this.cMB.findViewById(i.f.content_container);
        this.mNavigationBar = (NavigationBar) this.cMB.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cMB.getPageContext().getString(i.h.account_safe));
        this.cMD = this.cMB.findViewById(i.f.voicelogin_lock_layout);
        this.cME = (BdSwitchView) this.cMB.findViewById(i.f.voicelogin_switch);
        this.cMF = (TbSettingTextTipView) this.cMB.findViewById(i.f.secure_mobil);
        this.cMG = (TbSettingTextTipView) this.cMB.findViewById(i.f.secure_email);
        this.cMH = (TbSettingTextTipView) this.cMB.findViewById(i.f.modify_pwd);
        this.cMI = (TbSettingTextTipView) this.cMB.findViewById(i.f.bar_record);
        this.cMJ = (TbSettingTextTipView) this.cMB.findViewById(i.f.account_status);
        this.cMD.setOnClickListener(this.cMB);
        this.cMF.setOnClickListener(this.cMB);
        this.cMG.setOnClickListener(this.cMB);
        this.cMH.setOnClickListener(this.cMB);
        this.cMI.setOnClickListener(this.cMB);
        this.cMJ.setOnClickListener(this.cMB);
        this.cME.setOnSwitchStateChangeListener(this.cMK);
    }

    public void dF(int i) {
        if (this.aMQ != null) {
            this.aMQ.onChangeSkinType(this.cMB.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cMB.getLayoutMode().ad(i == 1);
        this.cMB.getLayoutMode().k(this.Mg);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.aqU() != null) {
            SimpleUser aqU = aVar.aqU();
            this.cMF.setTip(lf(aqU.securemobil));
            this.cMG.setTip(lg(aqU.secureemail));
            switch (aqU.user_status.intValue()) {
                case 0:
                    this.cMJ.setTip(getPageContext().getString(i.h.account_status_normal));
                    return;
                case 1:
                    this.cMJ.setTip(getPageContext().getString(i.h.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.cMJ.setTip(getPageContext().getString(i.h.account_status_system_forbidden));
                    return;
                case 3:
                    this.cMJ.setTip(getPageContext().getString(i.h.account_status_manager_forbidden));
                    return;
                case 4:
                    this.cMJ.setTip(getPageContext().getString(i.h.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String lf(String str) {
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(i.h.unbind_status);
        }
        if (!str.contains("*")) {
            if (str.length() < 7) {
                return getPageContext().getString(i.h.unbind_status);
            }
            return str.replace(str.substring(3, str.length() - 2), "******");
        }
        return str;
    }

    private String lg(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(i.h.unbind_status);
        }
        if (!str.contains("*")) {
            if (!str.contains("@")) {
                return getPageContext().getString(i.h.unbind_status);
            }
            String[] split = str.split("@");
            if (split == null || split.length < 2) {
                return getPageContext().getString(i.h.unbind_status);
            }
            String str3 = split[0];
            if (!TextUtils.isEmpty(str3) && str3.length() > 4) {
                str2 = String.valueOf(str3.substring(0, 3)) + "***";
            } else {
                str2 = "***";
            }
            return String.valueOf(str2) + "@" + split[1];
        }
        return str;
    }

    public NoNetworkView Pz() {
        return this.aMQ;
    }

    public void release() {
        this.Mg.removeAllViews();
        this.cMB = null;
    }
}
