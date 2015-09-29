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
    private LinearLayout Mf;
    private NoNetworkView aMF;
    private AccountSafeActivity cMc;
    private LinearLayout cMd;
    private View cMe;
    private BdSwitchView cMf;
    private TbSettingTextTipView cMg;
    private TbSettingTextTipView cMh;
    private TbSettingTextTipView cMi;
    private TbSettingTextTipView cMj;
    private TbSettingTextTipView cMk;
    private BdSwitchView.a cMl;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.cMl = new g(this);
        this.cMc = accountSafeActivity;
        zk();
    }

    private void zk() {
        this.cMc.setContentView(i.g.account_safe_activity);
        this.Mf = (LinearLayout) this.cMc.findViewById(i.f.parent);
        this.aMF = (NoNetworkView) this.cMc.findViewById(i.f.no_network_view);
        this.cMd = (LinearLayout) this.cMc.findViewById(i.f.content_container);
        this.mNavigationBar = (NavigationBar) this.cMc.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cMc.getPageContext().getString(i.h.account_safe));
        this.cMe = this.cMc.findViewById(i.f.voicelogin_lock_layout);
        this.cMf = (BdSwitchView) this.cMc.findViewById(i.f.voicelogin_switch);
        this.cMg = (TbSettingTextTipView) this.cMc.findViewById(i.f.secure_mobil);
        this.cMh = (TbSettingTextTipView) this.cMc.findViewById(i.f.secure_email);
        this.cMi = (TbSettingTextTipView) this.cMc.findViewById(i.f.modify_pwd);
        this.cMj = (TbSettingTextTipView) this.cMc.findViewById(i.f.bar_record);
        this.cMk = (TbSettingTextTipView) this.cMc.findViewById(i.f.account_status);
        this.cMe.setOnClickListener(this.cMc);
        this.cMg.setOnClickListener(this.cMc);
        this.cMh.setOnClickListener(this.cMc);
        this.cMi.setOnClickListener(this.cMc);
        this.cMj.setOnClickListener(this.cMc);
        this.cMk.setOnClickListener(this.cMc);
        this.cMf.setOnSwitchStateChangeListener(this.cMl);
    }

    public void dF(int i) {
        if (this.aMF != null) {
            this.aMF.onChangeSkinType(this.cMc.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cMc.getLayoutMode().ad(i == 1);
        this.cMc.getLayoutMode().k(this.Mf);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.aqS() != null) {
            SimpleUser aqS = aVar.aqS();
            this.cMg.setTip(lc(aqS.securemobil));
            this.cMh.setTip(ld(aqS.secureemail));
            switch (aqS.user_status.intValue()) {
                case 0:
                    this.cMk.setTip(getPageContext().getString(i.h.account_status_normal));
                    return;
                case 1:
                    this.cMk.setTip(getPageContext().getString(i.h.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.cMk.setTip(getPageContext().getString(i.h.account_status_system_forbidden));
                    return;
                case 3:
                    this.cMk.setTip(getPageContext().getString(i.h.account_status_manager_forbidden));
                    return;
                case 4:
                    this.cMk.setTip(getPageContext().getString(i.h.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String lc(String str) {
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

    private String ld(String str) {
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

    public NoNetworkView PD() {
        return this.aMF;
    }

    public void release() {
        this.Mf.removeAllViews();
        this.cMc = null;
    }
}
