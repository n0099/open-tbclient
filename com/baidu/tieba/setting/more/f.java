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
    private LinearLayout Nm;
    private NoNetworkView baT;
    private AccountSafeActivity ebY;
    private LinearLayout ebZ;
    private View eca;
    private BdSwitchView ecb;
    private TbSettingTextTipView ecc;
    private TbSettingTextTipView ecd;
    private TbSettingTextTipView ece;
    private TbSettingTextTipView ecf;
    private TbSettingTextTipView ecg;
    private BdSwitchView.a ech;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.ech = new g(this);
        this.ebY = accountSafeActivity;
        BN();
    }

    private void BN() {
        this.ebY.setContentView(t.h.account_safe_activity);
        this.Nm = (LinearLayout) this.ebY.findViewById(t.g.parent);
        this.baT = (NoNetworkView) this.ebY.findViewById(t.g.no_network_view);
        this.ebZ = (LinearLayout) this.ebY.findViewById(t.g.content_container);
        this.mNavigationBar = (NavigationBar) this.ebY.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ebY.getPageContext().getString(t.j.account_safe));
        this.eca = this.ebY.findViewById(t.g.voicelogin_lock_layout);
        this.ecb = (BdSwitchView) this.ebY.findViewById(t.g.voicelogin_switch);
        this.ecc = (TbSettingTextTipView) this.ebY.findViewById(t.g.secure_mobil);
        this.ecd = (TbSettingTextTipView) this.ebY.findViewById(t.g.secure_email);
        this.ece = (TbSettingTextTipView) this.ebY.findViewById(t.g.modify_pwd);
        this.ecf = (TbSettingTextTipView) this.ebY.findViewById(t.g.bar_record);
        this.ecg = (TbSettingTextTipView) this.ebY.findViewById(t.g.account_status);
        this.eca.setOnClickListener(this.ebY);
        this.ecc.setOnClickListener(this.ebY);
        this.ecd.setOnClickListener(this.ebY);
        this.ece.setOnClickListener(this.ebY);
        this.ecf.setOnClickListener(this.ebY);
        this.ecg.setOnClickListener(this.ebY);
        this.ecb.setOnSwitchStateChangeListener(this.ech);
    }

    public void em(int i) {
        if (this.baT != null) {
            this.baT.onChangeSkinType(this.ebY.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ebY.getLayoutMode().ab(i == 1);
        this.ebY.getLayoutMode().x(this.Nm);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.aMW() != null) {
            SimpleUser aMW = aVar.aMW();
            this.ecc.setTip(nw(aMW.securemobil));
            this.ecd.setTip(nx(aMW.secureemail));
            switch (aMW.user_status.intValue()) {
                case 0:
                    this.ecg.setTip(getPageContext().getString(t.j.account_status_normal));
                    return;
                case 1:
                    this.ecg.setTip(getPageContext().getString(t.j.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.ecg.setTip(getPageContext().getString(t.j.account_status_system_forbidden));
                    return;
                case 3:
                    this.ecg.setTip(getPageContext().getString(t.j.account_status_manager_forbidden));
                    return;
                case 4:
                    this.ecg.setTip(getPageContext().getString(t.j.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String nw(String str) {
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

    private String nx(String str) {
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

    public NoNetworkView WG() {
        return this.baT;
    }

    public void release() {
        this.Nm.removeAllViews();
        this.ebY = null;
    }
}
