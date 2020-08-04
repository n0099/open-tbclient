package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView hSK;
    private AdSettingActivity lxH;
    private MsgSettingItemView lxI;
    private TextView lxJ;
    private View lxK;
    private View lxL;
    private TextView lxM;
    private TextView lxN;
    private TextView lxO;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lxH = adSettingActivity;
        bhm();
    }

    private void bhm() {
        this.lxH.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lxH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lxH.getPageContext().getString(R.string.ad_control_setting));
        this.lxI = (MsgSettingItemView) this.lxH.findViewById(R.id.memberAdSetting);
        this.lxI.setLineVisibility(false);
        this.lxJ = (TextView) this.lxH.findViewById(R.id.memberAdTips);
        this.lxK = this.lxH.findViewById(R.id.privacyContainer);
        this.lxL = this.lxH.findViewById(R.id.privacyItem);
        this.lxO = (TextView) this.lxH.findViewById(R.id.privacyControlText);
        this.lxM = (TextView) this.lxH.findViewById(R.id.privacyControlTipsSmall);
        this.lxM = (TextView) this.lxH.findViewById(R.id.privacyControlTipsSmall);
        this.lxN = (TextView) this.lxH.findViewById(R.id.privacyControlTips);
        this.hSK = (ImageView) this.lxH.findViewById(R.id.arrow);
        this.mParent = this.lxH.findViewById(R.id.parent);
        this.lxL.setOnClickListener(this.lxH);
        deW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lxH.getLayoutMode().setNightMode(i == 1);
        this.lxH.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lxJ, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxN, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxO, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxM, R.color.cp_cont_c);
        ao.setBackgroundColor(this.lxJ, R.color.cp_bg_line_d);
        SvgManager.baR().a(this.hSK, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.lxK, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.lxL, R.drawable.setting_item_selector);
    }

    private void deW() {
        int i;
        int i2 = 0;
        this.lxI.setText(R.string.member_ad_setting_text);
        this.lxI.setOnSwitchStateChangeListener(this.lxH);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lxI.setVisibility(8);
            this.lxJ.setVisibility(8);
        } else if (i2 == 0) {
            this.lxI.turnOffNoCallback();
        } else {
            this.lxI.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aZP().getString("sync_ad_privacy_url", ""))) {
            this.lxK.setVisibility(8);
        }
    }

    public View deX() {
        return this.lxL;
    }

    public void deY() {
        this.lxI.turnOffNoCallback();
    }

    public void deZ() {
        this.lxI.turnOnNoCallback();
    }
}
