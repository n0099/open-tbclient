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
    private ImageView hSI;
    private AdSettingActivity lxF;
    private MsgSettingItemView lxG;
    private TextView lxH;
    private View lxI;
    private View lxJ;
    private TextView lxK;
    private TextView lxL;
    private TextView lxM;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lxF = adSettingActivity;
        bhm();
    }

    private void bhm() {
        this.lxF.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lxF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lxF.getPageContext().getString(R.string.ad_control_setting));
        this.lxG = (MsgSettingItemView) this.lxF.findViewById(R.id.memberAdSetting);
        this.lxG.setLineVisibility(false);
        this.lxH = (TextView) this.lxF.findViewById(R.id.memberAdTips);
        this.lxI = this.lxF.findViewById(R.id.privacyContainer);
        this.lxJ = this.lxF.findViewById(R.id.privacyItem);
        this.lxM = (TextView) this.lxF.findViewById(R.id.privacyControlText);
        this.lxK = (TextView) this.lxF.findViewById(R.id.privacyControlTipsSmall);
        this.lxK = (TextView) this.lxF.findViewById(R.id.privacyControlTipsSmall);
        this.lxL = (TextView) this.lxF.findViewById(R.id.privacyControlTips);
        this.hSI = (ImageView) this.lxF.findViewById(R.id.arrow);
        this.mParent = this.lxF.findViewById(R.id.parent);
        this.lxJ.setOnClickListener(this.lxF);
        deW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lxF.getLayoutMode().setNightMode(i == 1);
        this.lxF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lxH, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxL, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxM, R.color.cp_cont_b);
        ao.setViewTextColor(this.lxK, R.color.cp_cont_c);
        ao.setBackgroundColor(this.lxH, R.color.cp_bg_line_d);
        SvgManager.baR().a(this.hSI, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.lxI, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.lxJ, R.drawable.setting_item_selector);
    }

    private void deW() {
        int i;
        int i2 = 0;
        this.lxG.setText(R.string.member_ad_setting_text);
        this.lxG.setOnSwitchStateChangeListener(this.lxF);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lxG.setVisibility(8);
            this.lxH.setVisibility(8);
        } else if (i2 == 0) {
            this.lxG.turnOffNoCallback();
        } else {
            this.lxG.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aZP().getString("sync_ad_privacy_url", ""))) {
            this.lxI.setVisibility(8);
        }
    }

    public View deX() {
        return this.lxJ;
    }

    public void deY() {
        this.lxG.turnOffNoCallback();
    }

    public void deZ() {
        this.lxG.turnOnNoCallback();
    }
}
