package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView fjC;
    private AdSettingActivity irW;
    private MsgSettingItemView irX;
    private TextView irY;
    private View irZ;
    private View isa;
    private TextView isb;
    private TextView isc;
    private TextView isd;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.irW = adSettingActivity;
        akr();
    }

    private void akr() {
        this.irW.setContentView(d.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irW.getPageContext().getString(d.j.ad_control_setting));
        this.irX = (MsgSettingItemView) this.irW.findViewById(d.g.memberAdSetting);
        this.irX.setLineVisibility(false);
        this.irY = (TextView) this.irW.findViewById(d.g.memberAdTips);
        this.irZ = this.irW.findViewById(d.g.privacyContainer);
        this.isa = this.irW.findViewById(d.g.privacyItem);
        this.isd = (TextView) this.irW.findViewById(d.g.privacyControlText);
        this.isb = (TextView) this.irW.findViewById(d.g.privacyControlTipsSmall);
        this.isb = (TextView) this.irW.findViewById(d.g.privacyControlTipsSmall);
        this.isc = (TextView) this.irW.findViewById(d.g.privacyControlTips);
        this.fjC = (ImageView) this.irW.findViewById(d.g.arrow);
        this.mParent = this.irW.findViewById(d.g.parent);
        this.isa.setOnClickListener(this.irW);
        bYS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.irW.getLayoutMode().setNightMode(i == 1);
        this.irW.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.irY, d.C0236d.cp_cont_b);
        al.j(this.isc, d.C0236d.cp_cont_b);
        al.j(this.isd, d.C0236d.cp_cont_b);
        al.j(this.isb, d.C0236d.cp_cont_c);
        al.l(this.irY, d.C0236d.cp_bg_line_d);
        al.c(this.fjC, d.f.icon_arrow_gray_right_n);
        al.l(this.irZ, d.C0236d.cp_bg_line_d);
        al.k(this.isa, d.f.setting_item_selector);
    }

    private void bYS() {
        int i;
        int i2 = 0;
        this.irX.setText(d.j.member_ad_setting_text);
        this.irX.setOnSwitchStateChangeListener(this.irW);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.irX.setVisibility(8);
            this.irY.setVisibility(8);
        } else if (i2 == 0) {
            this.irX.nZ();
        } else {
            this.irX.nY();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.irZ.setVisibility(8);
        }
    }

    public View bYT() {
        return this.isa;
    }

    public void bYU() {
        this.irX.nZ();
    }

    public void bYV() {
        this.irX.nY();
    }
}
