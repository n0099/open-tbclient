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
    private ImageView fjn;
    private MsgSettingItemView irA;
    private TextView irB;
    private View irC;
    private View irD;
    private TextView irE;
    private TextView irF;
    private TextView irG;
    private AdSettingActivity irz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.irz = adSettingActivity;
        akn();
    }

    private void akn() {
        this.irz.setContentView(d.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irz.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irz.getPageContext().getString(d.j.ad_control_setting));
        this.irA = (MsgSettingItemView) this.irz.findViewById(d.g.memberAdSetting);
        this.irA.setLineVisibility(false);
        this.irB = (TextView) this.irz.findViewById(d.g.memberAdTips);
        this.irC = this.irz.findViewById(d.g.privacyContainer);
        this.irD = this.irz.findViewById(d.g.privacyItem);
        this.irG = (TextView) this.irz.findViewById(d.g.privacyControlText);
        this.irE = (TextView) this.irz.findViewById(d.g.privacyControlTipsSmall);
        this.irE = (TextView) this.irz.findViewById(d.g.privacyControlTipsSmall);
        this.irF = (TextView) this.irz.findViewById(d.g.privacyControlTips);
        this.fjn = (ImageView) this.irz.findViewById(d.g.arrow);
        this.mParent = this.irz.findViewById(d.g.parent);
        this.irD.setOnClickListener(this.irz);
        bYQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.irz.getLayoutMode().setNightMode(i == 1);
        this.irz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.irB, d.C0277d.cp_cont_b);
        al.j(this.irF, d.C0277d.cp_cont_b);
        al.j(this.irG, d.C0277d.cp_cont_b);
        al.j(this.irE, d.C0277d.cp_cont_c);
        al.l(this.irB, d.C0277d.cp_bg_line_d);
        al.c(this.fjn, d.f.icon_arrow_gray_right_n);
        al.l(this.irC, d.C0277d.cp_bg_line_d);
        al.k(this.irD, d.f.setting_item_selector);
    }

    private void bYQ() {
        int i;
        int i2 = 0;
        this.irA.setText(d.j.member_ad_setting_text);
        this.irA.setOnSwitchStateChangeListener(this.irz);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.irA.setVisibility(8);
            this.irB.setVisibility(8);
        } else if (i2 == 0) {
            this.irA.nZ();
        } else {
            this.irA.nY();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.irC.setVisibility(8);
        }
    }

    public View bYR() {
        return this.irD;
    }

    public void bYS() {
        this.irA.nZ();
    }

    public void bYT() {
        this.irA.nY();
    }
}
