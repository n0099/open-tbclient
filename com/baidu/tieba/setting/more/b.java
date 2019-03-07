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
    private AdSettingActivity irV;
    private MsgSettingItemView irW;
    private TextView irX;
    private View irY;
    private View irZ;
    private TextView isa;
    private TextView isb;
    private TextView isc;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.irV = adSettingActivity;
        akr();
    }

    private void akr() {
        this.irV.setContentView(d.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irV.getPageContext().getString(d.j.ad_control_setting));
        this.irW = (MsgSettingItemView) this.irV.findViewById(d.g.memberAdSetting);
        this.irW.setLineVisibility(false);
        this.irX = (TextView) this.irV.findViewById(d.g.memberAdTips);
        this.irY = this.irV.findViewById(d.g.privacyContainer);
        this.irZ = this.irV.findViewById(d.g.privacyItem);
        this.isc = (TextView) this.irV.findViewById(d.g.privacyControlText);
        this.isa = (TextView) this.irV.findViewById(d.g.privacyControlTipsSmall);
        this.isa = (TextView) this.irV.findViewById(d.g.privacyControlTipsSmall);
        this.isb = (TextView) this.irV.findViewById(d.g.privacyControlTips);
        this.fjC = (ImageView) this.irV.findViewById(d.g.arrow);
        this.mParent = this.irV.findViewById(d.g.parent);
        this.irZ.setOnClickListener(this.irV);
        bYR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.irV.getLayoutMode().setNightMode(i == 1);
        this.irV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.irX, d.C0236d.cp_cont_b);
        al.j(this.isb, d.C0236d.cp_cont_b);
        al.j(this.isc, d.C0236d.cp_cont_b);
        al.j(this.isa, d.C0236d.cp_cont_c);
        al.l(this.irX, d.C0236d.cp_bg_line_d);
        al.c(this.fjC, d.f.icon_arrow_gray_right_n);
        al.l(this.irY, d.C0236d.cp_bg_line_d);
        al.k(this.irZ, d.f.setting_item_selector);
    }

    private void bYR() {
        int i;
        int i2 = 0;
        this.irW.setText(d.j.member_ad_setting_text);
        this.irW.setOnSwitchStateChangeListener(this.irV);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.irW.setVisibility(8);
            this.irX.setVisibility(8);
        } else if (i2 == 0) {
            this.irW.nZ();
        } else {
            this.irW.nY();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.irY.setVisibility(8);
        }
    }

    public View bYS() {
        return this.irZ;
    }

    public void bYT() {
        this.irW.nZ();
    }

    public void bYU() {
        this.irW.nY();
    }
}
