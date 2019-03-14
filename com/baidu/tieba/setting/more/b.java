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
    private ImageView fjB;
    private AdSettingActivity irP;
    private MsgSettingItemView irQ;
    private TextView irR;
    private View irS;
    private View irT;
    private TextView irU;
    private TextView irV;
    private TextView irW;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.irP = adSettingActivity;
        akq();
    }

    private void akq() {
        this.irP.setContentView(d.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irP.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irP.getPageContext().getString(d.j.ad_control_setting));
        this.irQ = (MsgSettingItemView) this.irP.findViewById(d.g.memberAdSetting);
        this.irQ.setLineVisibility(false);
        this.irR = (TextView) this.irP.findViewById(d.g.memberAdTips);
        this.irS = this.irP.findViewById(d.g.privacyContainer);
        this.irT = this.irP.findViewById(d.g.privacyItem);
        this.irW = (TextView) this.irP.findViewById(d.g.privacyControlText);
        this.irU = (TextView) this.irP.findViewById(d.g.privacyControlTipsSmall);
        this.irU = (TextView) this.irP.findViewById(d.g.privacyControlTipsSmall);
        this.irV = (TextView) this.irP.findViewById(d.g.privacyControlTips);
        this.fjB = (ImageView) this.irP.findViewById(d.g.arrow);
        this.mParent = this.irP.findViewById(d.g.parent);
        this.irT.setOnClickListener(this.irP);
        bYU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.irP.getLayoutMode().setNightMode(i == 1);
        this.irP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.irR, d.C0277d.cp_cont_b);
        al.j(this.irV, d.C0277d.cp_cont_b);
        al.j(this.irW, d.C0277d.cp_cont_b);
        al.j(this.irU, d.C0277d.cp_cont_c);
        al.l(this.irR, d.C0277d.cp_bg_line_d);
        al.c(this.fjB, d.f.icon_arrow_gray_right_n);
        al.l(this.irS, d.C0277d.cp_bg_line_d);
        al.k(this.irT, d.f.setting_item_selector);
    }

    private void bYU() {
        int i;
        int i2 = 0;
        this.irQ.setText(d.j.member_ad_setting_text);
        this.irQ.setOnSwitchStateChangeListener(this.irP);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.irQ.setVisibility(8);
            this.irR.setVisibility(8);
        } else if (i2 == 0) {
            this.irQ.nZ();
        } else {
            this.irQ.nY();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.irS.setVisibility(8);
        }
    }

    public View bYV() {
        return this.irT;
    }

    public void bYW() {
        this.irQ.nZ();
    }

    public void bYX() {
        this.irQ.nY();
    }
}
