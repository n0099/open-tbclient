package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView dVZ;
    private AdSettingActivity hag;
    private MsgSettingItemView hah;
    private TextView hai;
    private View haj;
    private View hak;
    private TextView hal;
    private TextView ham;
    private TextView han;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.hag = adSettingActivity;
        KN();
    }

    private void KN() {
        this.hag.setContentView(e.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.hag.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hag.getPageContext().getString(e.j.ad_control_setting));
        this.hah = (MsgSettingItemView) this.hag.findViewById(e.g.memberAdSetting);
        this.hah.setLineVisibility(false);
        this.hai = (TextView) this.hag.findViewById(e.g.memberAdTips);
        this.haj = this.hag.findViewById(e.g.privacyContainer);
        this.hak = this.hag.findViewById(e.g.privacyItem);
        this.han = (TextView) this.hag.findViewById(e.g.privacyControlText);
        this.hal = (TextView) this.hag.findViewById(e.g.privacyControlTipsSmall);
        this.hal = (TextView) this.hag.findViewById(e.g.privacyControlTipsSmall);
        this.ham = (TextView) this.hag.findViewById(e.g.privacyControlTips);
        this.dVZ = (ImageView) this.hag.findViewById(e.g.arrow);
        this.mParent = this.hag.findViewById(e.g.parent);
        this.hak.setOnClickListener(this.hag);
        byd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hag.getLayoutMode().setNightMode(i == 1);
        this.hag.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.hai, e.d.cp_cont_b);
        al.h(this.ham, e.d.cp_cont_b);
        al.h(this.han, e.d.cp_cont_b);
        al.h(this.hal, e.d.cp_cont_c);
        al.j(this.hai, e.d.cp_bg_line_d);
        al.c(this.dVZ, e.f.icon_arrow_gray_right_n);
        al.j(this.haj, e.d.cp_bg_line_d);
        al.i(this.hak, e.f.setting_item_selector);
    }

    private void byd() {
        int i;
        int i2 = 0;
        this.hah.setText(e.j.member_ad_setting_text);
        this.hah.setOnSwitchStateChangeListener(this.hag);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.hah.setVisibility(8);
            this.hai.setVisibility(8);
        } else if (i2 == 0) {
            this.hah.nU();
        } else {
            this.hah.nT();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.haj.setVisibility(8);
        }
    }

    public View bye() {
        return this.hak;
    }

    public void byf() {
        this.hah.nU();
    }

    public void byg() {
        this.hah.nT();
    }
}
