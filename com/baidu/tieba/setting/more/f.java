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
    private LinearLayout My;
    private NoNetworkView aQl;
    private AccountSafeActivity dmo;
    private LinearLayout dmp;
    private View dmq;
    private BdSwitchView dmr;
    private TbSettingTextTipView dms;
    private TbSettingTextTipView dmt;
    private TbSettingTextTipView dmu;
    private TbSettingTextTipView dmv;
    private TbSettingTextTipView dmw;
    private BdSwitchView.a dmx;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.dmx = new g(this);
        this.dmo = accountSafeActivity;
        Ai();
    }

    private void Ai() {
        this.dmo.setContentView(n.g.account_safe_activity);
        this.My = (LinearLayout) this.dmo.findViewById(n.f.parent);
        this.aQl = (NoNetworkView) this.dmo.findViewById(n.f.no_network_view);
        this.dmp = (LinearLayout) this.dmo.findViewById(n.f.content_container);
        this.mNavigationBar = (NavigationBar) this.dmo.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dmo.getPageContext().getString(n.i.account_safe));
        this.dmq = this.dmo.findViewById(n.f.voicelogin_lock_layout);
        this.dmr = (BdSwitchView) this.dmo.findViewById(n.f.voicelogin_switch);
        this.dms = (TbSettingTextTipView) this.dmo.findViewById(n.f.secure_mobil);
        this.dmt = (TbSettingTextTipView) this.dmo.findViewById(n.f.secure_email);
        this.dmu = (TbSettingTextTipView) this.dmo.findViewById(n.f.modify_pwd);
        this.dmv = (TbSettingTextTipView) this.dmo.findViewById(n.f.bar_record);
        this.dmw = (TbSettingTextTipView) this.dmo.findViewById(n.f.account_status);
        this.dmq.setOnClickListener(this.dmo);
        this.dms.setOnClickListener(this.dmo);
        this.dmt.setOnClickListener(this.dmo);
        this.dmu.setOnClickListener(this.dmo);
        this.dmv.setOnClickListener(this.dmo);
        this.dmw.setOnClickListener(this.dmo);
        this.dmr.setOnSwitchStateChangeListener(this.dmx);
    }

    public void dU(int i) {
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(this.dmo.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dmo.getLayoutMode().af(i == 1);
        this.dmo.getLayoutMode().k(this.My);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.awY() != null) {
            SimpleUser awY = aVar.awY();
            this.dms.setTip(lX(awY.securemobil));
            this.dmt.setTip(lY(awY.secureemail));
            switch (awY.user_status.intValue()) {
                case 0:
                    this.dmw.setTip(getPageContext().getString(n.i.account_status_normal));
                    return;
                case 1:
                    this.dmw.setTip(getPageContext().getString(n.i.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.dmw.setTip(getPageContext().getString(n.i.account_status_system_forbidden));
                    return;
                case 3:
                    this.dmw.setTip(getPageContext().getString(n.i.account_status_manager_forbidden));
                    return;
                case 4:
                    this.dmw.setTip(getPageContext().getString(n.i.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String lX(String str) {
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(n.i.unbind_status);
        }
        if (!str.contains("*")) {
            if (str.length() < 7) {
                return getPageContext().getString(n.i.unbind_status);
            }
            return str.replace(str.substring(3, str.length() - 2), "******");
        }
        return str;
    }

    private String lY(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(n.i.unbind_status);
        }
        if (!str.contains("*")) {
            if (!str.contains("@")) {
                return getPageContext().getString(n.i.unbind_status);
            }
            String[] split = str.split("@");
            if (split == null || split.length < 2) {
                return getPageContext().getString(n.i.unbind_status);
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

    public NoNetworkView Sl() {
        return this.aQl;
    }

    public void release() {
        this.My.removeAllViews();
        this.dmo = null;
    }
}
