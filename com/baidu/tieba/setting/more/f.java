package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<AccountSafeActivity> {
    private LinearLayout Nf;
    private NoNetworkView aWk;
    private AccountSafeActivity dJE;
    private LinearLayout dJF;
    private View dJG;
    private BdSwitchView dJH;
    private TbSettingTextTipView dJI;
    private TbSettingTextTipView dJJ;
    private TbSettingTextTipView dJK;
    private TbSettingTextTipView dJL;
    private TbSettingTextTipView dJM;
    private BdSwitchView.a dJN;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.dJN = new g(this);
        this.dJE = accountSafeActivity;
        Bk();
    }

    private void Bk() {
        this.dJE.setContentView(t.h.account_safe_activity);
        this.Nf = (LinearLayout) this.dJE.findViewById(t.g.parent);
        this.aWk = (NoNetworkView) this.dJE.findViewById(t.g.no_network_view);
        this.dJF = (LinearLayout) this.dJE.findViewById(t.g.content_container);
        this.mNavigationBar = (NavigationBar) this.dJE.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dJE.getPageContext().getString(t.j.account_safe));
        this.dJG = this.dJE.findViewById(t.g.voicelogin_lock_layout);
        this.dJH = (BdSwitchView) this.dJE.findViewById(t.g.voicelogin_switch);
        this.dJI = (TbSettingTextTipView) this.dJE.findViewById(t.g.secure_mobil);
        this.dJJ = (TbSettingTextTipView) this.dJE.findViewById(t.g.secure_email);
        this.dJK = (TbSettingTextTipView) this.dJE.findViewById(t.g.modify_pwd);
        this.dJL = (TbSettingTextTipView) this.dJE.findViewById(t.g.bar_record);
        this.dJM = (TbSettingTextTipView) this.dJE.findViewById(t.g.account_status);
        this.dJG.setOnClickListener(this.dJE);
        this.dJI.setOnClickListener(this.dJE);
        this.dJJ.setOnClickListener(this.dJE);
        this.dJK.setOnClickListener(this.dJE);
        this.dJL.setOnClickListener(this.dJE);
        this.dJM.setOnClickListener(this.dJE);
        this.dJH.setOnSwitchStateChangeListener(this.dJN);
    }

    public void ej(int i) {
        if (this.aWk != null) {
            this.aWk.onChangeSkinType(this.dJE.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dJE.getLayoutMode().ac(i == 1);
        this.dJE.getLayoutMode().x(this.Nf);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.aGm() != null) {
            SimpleUser aGm = aVar.aGm();
            this.dJI.setTip(ml(aGm.securemobil));
            this.dJJ.setTip(mm(aGm.secureemail));
            switch (aGm.user_status.intValue()) {
                case 0:
                    this.dJM.setTip(getPageContext().getString(t.j.account_status_normal));
                    return;
                case 1:
                    this.dJM.setTip(getPageContext().getString(t.j.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.dJM.setTip(getPageContext().getString(t.j.account_status_system_forbidden));
                    return;
                case 3:
                    this.dJM.setTip(getPageContext().getString(t.j.account_status_manager_forbidden));
                    return;
                case 4:
                    this.dJM.setTip(getPageContext().getString(t.j.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String ml(String str) {
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(t.j.unbind_status);
        }
        if (!str.contains("*")) {
            if (str.length() < 7) {
                return getPageContext().getString(t.j.unbind_status);
            }
            return str.replace(str.substring(3, str.length() - 2), "******");
        }
        return str;
    }

    private String mm(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(t.j.unbind_status);
        }
        if (!str.contains("*")) {
            if (!str.contains("@")) {
                return getPageContext().getString(t.j.unbind_status);
            }
            String[] split = str.split("@");
            if (split == null || split.length < 2) {
                return getPageContext().getString(t.j.unbind_status);
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

    public NoNetworkView UM() {
        return this.aWk;
    }

    public void release() {
        this.Nf.removeAllViews();
        this.dJE = null;
    }
}
