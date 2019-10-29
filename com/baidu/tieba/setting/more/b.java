package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView fGz;
    private AdSettingActivity iTW;
    private MsgSettingItemView iTX;
    private TextView iTY;
    private View iTZ;
    private View iUa;
    private TextView iUb;
    private TextView iUc;
    private TextView iUd;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iTW = adSettingActivity;
        asD();
    }

    private void asD() {
        this.iTW.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iTW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iTW.getPageContext().getString(R.string.ad_control_setting));
        this.iTX = (MsgSettingItemView) this.iTW.findViewById(R.id.memberAdSetting);
        this.iTX.setLineVisibility(false);
        this.iTY = (TextView) this.iTW.findViewById(R.id.memberAdTips);
        this.iTZ = this.iTW.findViewById(R.id.privacyContainer);
        this.iUa = this.iTW.findViewById(R.id.privacyItem);
        this.iUd = (TextView) this.iTW.findViewById(R.id.privacyControlText);
        this.iUb = (TextView) this.iTW.findViewById(R.id.privacyControlTipsSmall);
        this.iUb = (TextView) this.iTW.findViewById(R.id.privacyControlTipsSmall);
        this.iUc = (TextView) this.iTW.findViewById(R.id.privacyControlTips);
        this.fGz = (ImageView) this.iTW.findViewById(R.id.arrow);
        this.mParent = this.iTW.findViewById(R.id.parent);
        this.iUa.setOnClickListener(this.iTW);
        ciE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iTW.getLayoutMode().setNightMode(i == 1);
        this.iTW.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iTY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iUc, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iUd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iUb, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.iTY, R.color.cp_bg_line_d);
        SvgManager.amN().a(this.fGz, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.iTZ, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.iUa, R.drawable.setting_item_selector);
    }

    private void ciE() {
        int i;
        int i2 = 0;
        this.iTX.setText(R.string.member_ad_setting_text);
        this.iTX.setOnSwitchStateChangeListener(this.iTW);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iTX.setVisibility(8);
            this.iTY.setVisibility(8);
        } else if (i2 == 0) {
            this.iTX.turnOffNoCallback();
        } else {
            this.iTX.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.alR().getString("sync_ad_privacy_url", ""))) {
            this.iTZ.setVisibility(8);
        }
    }

    public View ciF() {
        return this.iUa;
    }

    public void ciG() {
        this.iTX.turnOffNoCallback();
    }

    public void ciH() {
        this.iTX.turnOnNoCallback();
    }
}
