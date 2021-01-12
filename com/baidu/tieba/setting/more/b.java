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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.d<AdSettingActivity> {
    private ImageView jrs;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity mVS;
    private MsgSettingItemView mVT;
    private TextView mVU;
    private View mVV;
    private View mVW;
    private TextView mVX;
    private TextView mVY;
    private TextView mVZ;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mVS = adSettingActivity;
        bzm();
    }

    private void bzm() {
        this.mVS.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mVS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVS.getPageContext().getString(R.string.ad_control_setting));
        this.mVT = (MsgSettingItemView) this.mVS.findViewById(R.id.memberAdSetting);
        this.mVT.setLineVisibility(false);
        this.mVU = (TextView) this.mVS.findViewById(R.id.memberAdTips);
        this.mVV = this.mVS.findViewById(R.id.privacyContainer);
        this.mVW = this.mVS.findViewById(R.id.privacyItem);
        this.mVZ = (TextView) this.mVS.findViewById(R.id.privacyControlText);
        this.mVX = (TextView) this.mVS.findViewById(R.id.privacyControlTipsSmall);
        this.mVX = (TextView) this.mVS.findViewById(R.id.privacyControlTipsSmall);
        this.mVY = (TextView) this.mVS.findViewById(R.id.privacyControlTips);
        this.jrs = (ImageView) this.mVS.findViewById(R.id.arrow);
        this.mParent = this.mVS.findViewById(R.id.parent);
        this.mVW.setOnClickListener(this.mVS);
        dEq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mVS.getLayoutMode().setNightMode(i == 1);
        this.mVS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.mVU, R.color.CAM_X0105);
        ao.setViewTextColor(this.mVY, R.color.CAM_X0105);
        ao.setViewTextColor(this.mVZ, R.color.CAM_X0105);
        ao.setViewTextColor(this.mVX, R.color.CAM_X0108);
        ao.setBackgroundColor(this.mVU, R.color.CAM_X0201);
        SvgManager.bsx().a(this.jrs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.mVV, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mVW, R.drawable.setting_item_selector);
    }

    private void dEq() {
        int i;
        int i2;
        this.mVT.setText(R.string.member_ad_setting_text);
        this.mVT.setOnSwitchStateChangeListener(this.mVS);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            int memberCloseAdIsOpen = currentAccountObj.getMemberCloseAdIsOpen();
            i = currentAccountObj.getMemberCloseAdVipClose();
            i2 = memberCloseAdIsOpen;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 == 0) {
            this.mVT.setVisibility(8);
            this.mVU.setVisibility(8);
        } else if (i == 0) {
            this.mVT.turnOffNoCallback();
        } else {
            this.mVT.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.brx().getString("sync_ad_privacy_url", ""))) {
            this.mVV.setVisibility(8);
        }
    }

    public View dEr() {
        return this.mVW;
    }

    public void dEs() {
        this.mVT.turnOffNoCallback();
    }

    public void dEt() {
        this.mVT.turnOnNoCallback();
    }
}
