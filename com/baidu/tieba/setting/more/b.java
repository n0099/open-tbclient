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
    private ImageView igS;
    private AdSettingActivity lOV;
    private MsgSettingItemView lOW;
    private TextView lOX;
    private View lOY;
    private View lOZ;
    private TextView lPa;
    private TextView lPb;
    private TextView lPc;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lOV = adSettingActivity;
        bpY();
    }

    private void bpY() {
        this.lOV.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lOV.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lOV.getPageContext().getString(R.string.ad_control_setting));
        this.lOW = (MsgSettingItemView) this.lOV.findViewById(R.id.memberAdSetting);
        this.lOW.setLineVisibility(false);
        this.lOX = (TextView) this.lOV.findViewById(R.id.memberAdTips);
        this.lOY = this.lOV.findViewById(R.id.privacyContainer);
        this.lOZ = this.lOV.findViewById(R.id.privacyItem);
        this.lPc = (TextView) this.lOV.findViewById(R.id.privacyControlText);
        this.lPa = (TextView) this.lOV.findViewById(R.id.privacyControlTipsSmall);
        this.lPa = (TextView) this.lOV.findViewById(R.id.privacyControlTipsSmall);
        this.lPb = (TextView) this.lOV.findViewById(R.id.privacyControlTips);
        this.igS = (ImageView) this.lOV.findViewById(R.id.arrow);
        this.mParent = this.lOV.findViewById(R.id.parent);
        this.lOZ.setOnClickListener(this.lOV);
        dqp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lOV.getLayoutMode().setNightMode(i == 1);
        this.lOV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lOX, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPb, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPc, R.color.cp_cont_b);
        ap.setViewTextColor(this.lPa, R.color.cp_cont_c);
        ap.setBackgroundColor(this.lOX, R.color.cp_bg_line_d);
        SvgManager.bjq().a(this.igS, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.lOY, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lOZ, R.drawable.setting_item_selector);
    }

    private void dqp() {
        int i;
        int i2 = 0;
        this.lOW.setText(R.string.member_ad_setting_text);
        this.lOW.setOnSwitchStateChangeListener(this.lOV);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lOW.setVisibility(8);
            this.lOX.setVisibility(8);
        } else if (i2 == 0) {
            this.lOW.turnOffNoCallback();
        } else {
            this.lOW.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bik().getString("sync_ad_privacy_url", ""))) {
            this.lOY.setVisibility(8);
        }
    }

    public View dqq() {
        return this.lOZ;
    }

    public void dqr() {
        this.lOW.turnOffNoCallback();
    }

    public void dqs() {
        this.lOW.turnOnNoCallback();
    }
}
