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
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView iVY;
    private AdSettingActivity mGX;
    private MsgSettingItemView mGY;
    private TextView mGZ;
    private View mHa;
    private View mHb;
    private TextView mHc;
    private TextView mHd;
    private TextView mHe;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mGX = adSettingActivity;
        bxl();
    }

    private void bxl() {
        this.mGX.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mGX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGX.getPageContext().getString(R.string.ad_control_setting));
        this.mGY = (MsgSettingItemView) this.mGX.findViewById(R.id.memberAdSetting);
        this.mGY.setLineVisibility(false);
        this.mGZ = (TextView) this.mGX.findViewById(R.id.memberAdTips);
        this.mHa = this.mGX.findViewById(R.id.privacyContainer);
        this.mHb = this.mGX.findViewById(R.id.privacyItem);
        this.mHe = (TextView) this.mGX.findViewById(R.id.privacyControlText);
        this.mHc = (TextView) this.mGX.findViewById(R.id.privacyControlTipsSmall);
        this.mHc = (TextView) this.mGX.findViewById(R.id.privacyControlTipsSmall);
        this.mHd = (TextView) this.mGX.findViewById(R.id.privacyControlTips);
        this.iVY = (ImageView) this.mGX.findViewById(R.id.arrow);
        this.mParent = this.mGX.findViewById(R.id.parent);
        this.mHb.setOnClickListener(this.mGX);
        dDg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mGX.getLayoutMode().setNightMode(i == 1);
        this.mGX.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mGZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.mHd, R.color.CAM_X0105);
        ap.setViewTextColor(this.mHe, R.color.CAM_X0105);
        ap.setViewTextColor(this.mHc, R.color.CAM_X0108);
        ap.setBackgroundColor(this.mGZ, R.color.CAM_X0201);
        SvgManager.bqB().a(this.iVY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mHa, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mHb, R.drawable.setting_item_selector);
    }

    private void dDg() {
        int i;
        int i2 = 0;
        this.mGY.setText(R.string.member_ad_setting_text);
        this.mGY.setOnSwitchStateChangeListener(this.mGX);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mGY.setVisibility(8);
            this.mGZ.setVisibility(8);
        } else if (i2 == 0) {
            this.mGY.turnOffNoCallback();
        } else {
            this.mGY.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bpu().getString("sync_ad_privacy_url", ""))) {
            this.mHa.setVisibility(8);
        }
    }

    public View dDh() {
        return this.mHb;
    }

    public void dDi() {
        this.mGY.turnOffNoCallback();
    }

    public void dDj() {
        this.mGY.turnOnNoCallback();
    }
}
