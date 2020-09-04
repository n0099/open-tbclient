package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView igY;
    private AdSettingActivity lPi;
    private MsgSettingItemView lPj;
    private TextView lPk;
    private View lPl;
    private View lPm;
    private TextView lPn;
    private TextView lPo;
    private TextView lPp;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lPi = adSettingActivity;
        bpZ();
    }

    private void bpZ() {
        this.lPi.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lPi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lPi.getPageContext().getString(R.string.ad_control_setting));
        this.lPj = (MsgSettingItemView) this.lPi.findViewById(R.id.memberAdSetting);
        this.lPj.setLineVisibility(false);
        this.lPk = (TextView) this.lPi.findViewById(R.id.memberAdTips);
        this.lPl = this.lPi.findViewById(R.id.privacyContainer);
        this.lPm = this.lPi.findViewById(R.id.privacyItem);
        this.lPp = (TextView) this.lPi.findViewById(R.id.privacyControlText);
        this.lPn = (TextView) this.lPi.findViewById(R.id.privacyControlTipsSmall);
        this.lPn = (TextView) this.lPi.findViewById(R.id.privacyControlTipsSmall);
        this.lPo = (TextView) this.lPi.findViewById(R.id.privacyControlTips);
        this.igY = (ImageView) this.lPi.findViewById(R.id.arrow);
        this.mParent = this.lPi.findViewById(R.id.parent);
        this.lPm.setOnClickListener(this.lPi);
        dqs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lPi.getLayoutMode().setNightMode(i == 1);
        this.lPi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lPk, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPo, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPp, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPn, R.color.cp_cont_c);
        ap.setBackgroundColor(this.lPk, R.color.cp_bg_line_d);
        SvgManager.bjq().a(this.igY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.lPl, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lPm, R.drawable.setting_item_selector);
    }

    private void dqs() {
        int i;
        int i2 = 0;
        this.lPj.setText(R.string.member_ad_setting_text);
        this.lPj.setOnSwitchStateChangeListener(this.lPi);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lPj.setVisibility(8);
            this.lPk.setVisibility(8);
        } else if (i2 == 0) {
            this.lPj.turnOffNoCallback();
        } else {
            this.lPj.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bik().getString("sync_ad_privacy_url", ""))) {
            this.lPl.setVisibility(8);
        }
    }

    public View dqt() {
        return this.lPm;
    }

    public void dqu() {
        this.lPj.turnOffNoCallback();
    }

    public void dqv() {
        this.lPj.turnOnNoCallback();
    }
}
