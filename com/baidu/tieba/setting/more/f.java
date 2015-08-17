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
    private NoNetworkView aNx;
    private AccountSafeActivity cwE;
    private LinearLayout cwF;
    private View cwG;
    private BdSwitchView cwH;
    private TbSettingTextTipView cwI;
    private TbSettingTextTipView cwJ;
    private TbSettingTextTipView cwK;
    private TbSettingTextTipView cwL;
    private TbSettingTextTipView cwM;
    private BdSwitchView.a cwN;
    private NavigationBar mNavigationBar;

    public f(AccountSafeActivity accountSafeActivity) {
        super(accountSafeActivity.getPageContext());
        this.cwN = new g(this);
        this.cwE = accountSafeActivity;
        zl();
    }

    private void zl() {
        this.cwE.setContentView(i.g.account_safe_activity);
        this.Mg = (LinearLayout) this.cwE.findViewById(i.f.parent);
        this.aNx = (NoNetworkView) this.cwE.findViewById(i.f.no_network_view);
        this.cwF = (LinearLayout) this.cwE.findViewById(i.f.content_container);
        this.mNavigationBar = (NavigationBar) this.cwE.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cwE.getPageContext().getString(i.C0057i.account_safe));
        this.cwG = this.cwE.findViewById(i.f.voicelogin_lock_layout);
        this.cwH = (BdSwitchView) this.cwE.findViewById(i.f.voicelogin_switch);
        this.cwI = (TbSettingTextTipView) this.cwE.findViewById(i.f.secure_mobil);
        this.cwJ = (TbSettingTextTipView) this.cwE.findViewById(i.f.secure_email);
        this.cwK = (TbSettingTextTipView) this.cwE.findViewById(i.f.modify_pwd);
        this.cwL = (TbSettingTextTipView) this.cwE.findViewById(i.f.bar_record);
        this.cwM = (TbSettingTextTipView) this.cwE.findViewById(i.f.account_status);
        this.cwG.setOnClickListener(this.cwE);
        this.cwI.setOnClickListener(this.cwE);
        this.cwJ.setOnClickListener(this.cwE);
        this.cwK.setOnClickListener(this.cwE);
        this.cwL.setOnClickListener(this.cwE);
        this.cwM.setOnClickListener(this.cwE);
        this.cwH.setOnSwitchStateChangeListener(this.cwN);
    }

    public void dw(int i) {
        if (this.aNx != null) {
            this.aNx.onChangeSkinType(this.cwE.getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cwE.getLayoutMode().ad(i == 1);
        this.cwE.getLayoutMode().k(this.Mg);
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && aVar.akt() != null) {
            SimpleUser akt = aVar.akt();
            this.cwI.setTip(jZ(akt.securemobil));
            this.cwJ.setTip(ka(akt.secureemail));
            if (akt.user_status.intValue() == 0) {
                this.cwM.setTip(getPageContext().getString(i.C0057i.account_status_normal));
            } else {
                this.cwM.setTip(getPageContext().getString(i.C0057i.account_status_exception));
            }
        }
    }

    private String jZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(i.C0057i.unbind_status);
        }
        if (!str.contains("*")) {
            if (str.length() < 7) {
                return getPageContext().getString(i.C0057i.unbind_status);
            }
            return str.replace(str.substring(3, str.length() - 2), "******");
        }
        return str;
    }

    private String ka(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return getPageContext().getString(i.C0057i.unbind_status);
        }
        if (!str.contains("*")) {
            if (!str.contains("@")) {
                return getPageContext().getString(i.C0057i.unbind_status);
            }
            String[] split = str.split("@");
            if (split == null || split.length < 2) {
                return getPageContext().getString(i.C0057i.unbind_status);
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

    public NoNetworkView PA() {
        return this.aNx;
    }

    public void release() {
        this.Mg.removeAllViews();
        this.cwE = null;
    }
}
