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
    private LinearLayout Mh;
    private NoNetworkView aMY;
    private AccountSafeActivity cNX;
    private LinearLayout cNY;
    private View cNZ;
    private BdSwitchView cOa;
    private TbSettingTextTipView cOb;
    private TbSettingTextTipView cOc;
    private TbSettingTextTipView cOd;
    private TbSettingTextTipView cOe;
    private TbSettingTextTipView cOf;
    private BdSwitchView.a cOg;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.cOg = new g(this);
        this.cNX = accountSafeActivity;
        zm();
    }

    private void zm() {
        this.cNX.setContentView(i.g.account_safe_activity);
        this.Mh = (LinearLayout) this.cNX.findViewById(i.f.parent);
        this.aMY = (NoNetworkView) this.cNX.findViewById(i.f.no_network_view);
        this.cNY = (LinearLayout) this.cNX.findViewById(i.f.content_container);
        this.mNavigationBar = (NavigationBar) this.cNX.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cNX.getPageContext().getString(i.h.account_safe));
        this.cNZ = this.cNX.findViewById(i.f.voicelogin_lock_layout);
        this.cOa = (BdSwitchView) this.cNX.findViewById(i.f.voicelogin_switch);
        this.cOb = (TbSettingTextTipView) this.cNX.findViewById(i.f.secure_mobil);
        this.cOc = (TbSettingTextTipView) this.cNX.findViewById(i.f.secure_email);
        this.cOd = (TbSettingTextTipView) this.cNX.findViewById(i.f.modify_pwd);
        this.cOe = (TbSettingTextTipView) this.cNX.findViewById(i.f.bar_record);
        this.cOf = (TbSettingTextTipView) this.cNX.findViewById(i.f.account_status);
        this.cNZ.setOnClickListener(this.cNX);
        this.cOb.setOnClickListener(this.cNX);
        this.cOc.setOnClickListener(this.cNX);
        this.cOd.setOnClickListener(this.cNX);
        this.cOe.setOnClickListener(this.cNX);
        this.cOf.setOnClickListener(this.cNX);
        this.cOa.setOnSwitchStateChangeListener(this.cOg);
    }

    public void dF(int i) {
        if (this.aMY != null) {
            this.aMY.onChangeSkinType(this.cNX.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cNX.getLayoutMode().ad(i == 1);
        this.cNX.getLayoutMode().k(this.Mh);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.arA() != null) {
            SimpleUser arA = aVar.arA();
            this.cOb.setTip(lj(arA.securemobil));
            this.cOc.setTip(lk(arA.secureemail));
            switch (arA.user_status.intValue()) {
                case 0:
                    this.cOf.setTip(getPageContext().getString(i.h.account_status_normal));
                    return;
                case 1:
                    this.cOf.setTip(getPageContext().getString(i.h.account_status_forbidden_and_block));
                    return;
                case 2:
                    this.cOf.setTip(getPageContext().getString(i.h.account_status_system_forbidden));
                    return;
                case 3:
                    this.cOf.setTip(getPageContext().getString(i.h.account_status_manager_forbidden));
                    return;
                case 4:
                    this.cOf.setTip(getPageContext().getString(i.h.account_status_doing_appeal));
                    return;
                default:
                    return;
            }
        }
    }

    private String lj(String str) {
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

    private String lk(String str) {
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

    public NoNetworkView PV() {
        return this.aMY;
    }

    public void release() {
        this.Mh.removeAllViews();
        this.cNX = null;
    }
}
