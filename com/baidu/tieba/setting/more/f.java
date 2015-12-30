package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.n;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<AccountSafeActivity> {
    private LinearLayout MO;
    private NoNetworkView aUd;
    private AccountSafeActivity dtA;
    private LinearLayout dtB;
    private View dtC;
    private BdSwitchView dtD;
    private TbSettingTextTipView dtE;
    private TbSettingTextTipView dtF;
    private TbSettingTextTipView dtG;
    private TbSettingTextTipView dtH;
    private TbSettingTextTipView dtI;
    private BdSwitchView.a dtJ;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.dtJ = new g(this);
        this.dtA = accountSafeActivity;
        zU();
    }

    private void zU() {
        this.dtA.setContentView(n.h.account_safe_activity);
        this.MO = (LinearLayout) this.dtA.findViewById(n.g.parent);
        this.aUd = (NoNetworkView) this.dtA.findViewById(n.g.no_network_view);
        this.dtB = (LinearLayout) this.dtA.findViewById(n.g.content_container);
        this.mNavigationBar = (NavigationBar) this.dtA.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dtA.getPageContext().getString(n.j.account_safe));
        this.dtC = this.dtA.findViewById(n.g.voicelogin_lock_layout);
        this.dtD = (BdSwitchView) this.dtA.findViewById(n.g.voicelogin_switch);
        this.dtE = (TbSettingTextTipView) this.dtA.findViewById(n.g.secure_mobil);
        this.dtF = (TbSettingTextTipView) this.dtA.findViewById(n.g.secure_email);
        this.dtG = (TbSettingTextTipView) this.dtA.findViewById(n.g.modify_pwd);
        this.dtH = (TbSettingTextTipView) this.dtA.findViewById(n.g.bar_record);
        this.dtI = (TbSettingTextTipView) this.dtA.findViewById(n.g.account_status);
        this.dtC.setOnClickListener(this.dtA);
        this.dtE.setOnClickListener(this.dtA);
        this.dtF.setOnClickListener(this.dtA);
        this.dtG.setOnClickListener(this.dtA);
        this.dtH.setOnClickListener(this.dtA);
        this.dtI.setOnClickListener(this.dtA);
        this.dtD.setOnSwitchStateChangeListener(this.dtJ);
    }

    public void dO(int i) {
        if (this.aUd != null) {
            this.aUd.onChangeSkinType(this.dtA.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dtA.getLayoutMode().ac(i == 1);
        this.dtA.getLayoutMode().k(this.MO);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.azf() != null) {
            SimpleUser azf = aVar.azf();
            this.dtE.setTip(lU(azf.securemobil));
            this.dtF.setTip(lV(azf.secureemail));
            switch (azf.user_status.intValue()) {
                case 0:
                    this.dtI.setTip(getPageContext().getString(n.j.account_status_normal));
                    return;
                case 1:
                    this.dtI.setTip(getPageContext().getString(n.j.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.dtI.setTip(getPageContext().getString(n.j.account_status_system_forbidden));
                    return;
                case 3:
                    this.dtI.setTip(getPageContext().getString(n.j.account_status_manager_forbidden));
                    return;
                case 4:
                    this.dtI.setTip(getPageContext().getString(n.j.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String lU(String str) {
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(n.j.unbind_status);
        }
        if (!str.contains("*")) {
            if (str.length() < 7) {
                return getPageContext().getString(n.j.unbind_status);
            }
            return str.replace(str.substring(3, str.length() - 2), "******");
        }
        return str;
    }

    private String lV(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(n.j.unbind_status);
        }
        if (!str.contains("*")) {
            if (!str.contains("@")) {
                return getPageContext().getString(n.j.unbind_status);
            }
            String[] split = str.split("@");
            if (split == null || split.length < 2) {
                return getPageContext().getString(n.j.unbind_status);
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

    public NoNetworkView SD() {
        return this.aUd;
    }

    public void release() {
        this.MO.removeAllViews();
        this.dtA = null;
    }
}
