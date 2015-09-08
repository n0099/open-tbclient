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
    private NoNetworkView aNK;
    private AccountSafeActivity cFb;
    private LinearLayout cFc;
    private View cFd;
    private BdSwitchView cFe;
    private TbSettingTextTipView cFf;
    private TbSettingTextTipView cFg;
    private TbSettingTextTipView cFh;
    private TbSettingTextTipView cFi;
    private TbSettingTextTipView cFj;
    private BdSwitchView.a cFk;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.cFk = new g(this);
        this.cFb = accountSafeActivity;
        zy();
    }

    private void zy() {
        this.cFb.setContentView(i.g.account_safe_activity);
        this.Mf = (LinearLayout) this.cFb.findViewById(i.f.parent);
        this.aNK = (NoNetworkView) this.cFb.findViewById(i.f.no_network_view);
        this.cFc = (LinearLayout) this.cFb.findViewById(i.f.content_container);
        this.mNavigationBar = (NavigationBar) this.cFb.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cFb.getPageContext().getString(i.h.account_safe));
        this.cFd = this.cFb.findViewById(i.f.voicelogin_lock_layout);
        this.cFe = (BdSwitchView) this.cFb.findViewById(i.f.voicelogin_switch);
        this.cFf = (TbSettingTextTipView) this.cFb.findViewById(i.f.secure_mobil);
        this.cFg = (TbSettingTextTipView) this.cFb.findViewById(i.f.secure_email);
        this.cFh = (TbSettingTextTipView) this.cFb.findViewById(i.f.modify_pwd);
        this.cFi = (TbSettingTextTipView) this.cFb.findViewById(i.f.bar_record);
        this.cFj = (TbSettingTextTipView) this.cFb.findViewById(i.f.account_status);
        this.cFd.setOnClickListener(this.cFb);
        this.cFf.setOnClickListener(this.cFb);
        this.cFg.setOnClickListener(this.cFb);
        this.cFh.setOnClickListener(this.cFb);
        this.cFi.setOnClickListener(this.cFb);
        this.cFj.setOnClickListener(this.cFb);
        this.cFe.setOnSwitchStateChangeListener(this.cFk);
    }

    public void dE(int i) {
        if (this.aNK != null) {
            this.aNK.onChangeSkinType(this.cFb.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cFb.getLayoutMode().ad(i == 1);
        this.cFb.getLayoutMode().k(this.Mf);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.aoA() != null) {
            SimpleUser aoA = aVar.aoA();
            this.cFf.setTip(kE(aoA.securemobil));
            this.cFg.setTip(kF(aoA.secureemail));
            if (aoA.user_status.intValue() == 0) {
                this.cFj.setTip(getPageContext().getString(i.h.account_status_normal));
            } else {
                this.cFj.setTip(getPageContext().getString(i.h.account_status_exception));
            }
        }
    }

    private String kE(String str) {
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

    private String kF(String str) {
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

    public NoNetworkView PB() {
        return this.aNK;
    }

    public void release() {
        this.Mf.removeAllViews();
        this.cFb = null;
    }
}
