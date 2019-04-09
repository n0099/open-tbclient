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
    private AdSettingActivity irA;
    private MsgSettingItemView irB;
    private TextView irC;
    private View irD;
    private View irE;
    private TextView irF;
    private TextView irG;
    private TextView irH;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.irA = adSettingActivity;
        akn();
    }

    private void akn() {
        this.irA.setContentView(d.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irA.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irA.getPageContext().getString(d.j.ad_control_setting));
        this.irB = (MsgSettingItemView) this.irA.findViewById(d.g.memberAdSetting);
        this.irB.setLineVisibility(false);
        this.irC = (TextView) this.irA.findViewById(d.g.memberAdTips);
        this.irD = this.irA.findViewById(d.g.privacyContainer);
        this.irE = this.irA.findViewById(d.g.privacyItem);
        this.irH = (TextView) this.irA.findViewById(d.g.privacyControlText);
        this.irF = (TextView) this.irA.findViewById(d.g.privacyControlTipsSmall);
        this.irF = (TextView) this.irA.findViewById(d.g.privacyControlTipsSmall);
        this.irG = (TextView) this.irA.findViewById(d.g.privacyControlTips);
        this.fjn = (ImageView) this.irA.findViewById(d.g.arrow);
        this.mParent = this.irA.findViewById(d.g.parent);
        this.irE.setOnClickListener(this.irA);
        bYQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.irA.getLayoutMode().setNightMode(i == 1);
        this.irA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.irC, d.C0277d.cp_cont_b);
        al.j(this.irG, d.C0277d.cp_cont_b);
        al.j(this.irH, d.C0277d.cp_cont_b);
        al.j(this.irF, d.C0277d.cp_cont_c);
        al.l(this.irC, d.C0277d.cp_bg_line_d);
        al.c(this.fjn, d.f.icon_arrow_gray_right_n);
        al.l(this.irD, d.C0277d.cp_bg_line_d);
        al.k(this.irE, d.f.setting_item_selector);
    }

    private void bYQ() {
        int i;
        int i2 = 0;
        this.irB.setText(d.j.member_ad_setting_text);
        this.irB.setOnSwitchStateChangeListener(this.irA);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.irB.setVisibility(8);
            this.irC.setVisibility(8);
        } else if (i2 == 0) {
            this.irB.nZ();
        } else {
            this.irB.nY();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.irD.setVisibility(8);
        }
    }

    public View bYR() {
        return this.irE;
    }

    public void bYS() {
        this.irB.nZ();
    }

    public void bYT() {
        this.irB.nY();
    }
}
