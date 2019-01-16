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
    private ImageView dVY;
    private AdSettingActivity haf;
    private MsgSettingItemView hag;
    private TextView hah;
    private View hai;
    private View haj;
    private TextView hak;
    private TextView hal;
    private TextView ham;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.haf = adSettingActivity;
        KN();
    }

    private void KN() {
        this.haf.setContentView(e.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.haf.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.haf.getPageContext().getString(e.j.ad_control_setting));
        this.hag = (MsgSettingItemView) this.haf.findViewById(e.g.memberAdSetting);
        this.hag.setLineVisibility(false);
        this.hah = (TextView) this.haf.findViewById(e.g.memberAdTips);
        this.hai = this.haf.findViewById(e.g.privacyContainer);
        this.haj = this.haf.findViewById(e.g.privacyItem);
        this.ham = (TextView) this.haf.findViewById(e.g.privacyControlText);
        this.hak = (TextView) this.haf.findViewById(e.g.privacyControlTipsSmall);
        this.hak = (TextView) this.haf.findViewById(e.g.privacyControlTipsSmall);
        this.hal = (TextView) this.haf.findViewById(e.g.privacyControlTips);
        this.dVY = (ImageView) this.haf.findViewById(e.g.arrow);
        this.mParent = this.haf.findViewById(e.g.parent);
        this.haj.setOnClickListener(this.haf);
        byd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.haf.getLayoutMode().setNightMode(i == 1);
        this.haf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.hah, e.d.cp_cont_b);
        al.h(this.hal, e.d.cp_cont_b);
        al.h(this.ham, e.d.cp_cont_b);
        al.h(this.hak, e.d.cp_cont_c);
        al.j(this.hah, e.d.cp_bg_line_d);
        al.c(this.dVY, e.f.icon_arrow_gray_right_n);
        al.j(this.hai, e.d.cp_bg_line_d);
        al.i(this.haj, e.f.setting_item_selector);
    }

    private void byd() {
        int i;
        int i2 = 0;
        this.hag.setText(e.j.member_ad_setting_text);
        this.hag.setOnSwitchStateChangeListener(this.haf);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.hag.setVisibility(8);
            this.hah.setVisibility(8);
        } else if (i2 == 0) {
            this.hag.nU();
        } else {
            this.hag.nT();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.hai.setVisibility(8);
        }
    }

    public View bye() {
        return this.haj;
    }

    public void byf() {
        this.hag.nU();
    }

    public void byg() {
        this.hag.nT();
    }
}
