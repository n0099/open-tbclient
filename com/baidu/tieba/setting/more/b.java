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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.d<AdSettingActivity> {
    private ImageView jvY;
    private NavigationBar mNavigationBar;
    private View mParent;
    private TextView naA;
    private View naB;
    private View naC;
    private TextView naD;
    private TextView naE;
    private TextView naF;
    private AdSettingActivity nay;
    private MsgSettingItemView naz;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.nay = adSettingActivity;
        bDg();
    }

    private void bDg() {
        this.nay.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.nay.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nay.getPageContext().getString(R.string.ad_control_setting));
        this.naz = (MsgSettingItemView) this.nay.findViewById(R.id.memberAdSetting);
        this.naz.setLineVisibility(false);
        this.naA = (TextView) this.nay.findViewById(R.id.memberAdTips);
        this.naB = this.nay.findViewById(R.id.privacyContainer);
        this.naC = this.nay.findViewById(R.id.privacyItem);
        this.naF = (TextView) this.nay.findViewById(R.id.privacyControlText);
        this.naD = (TextView) this.nay.findViewById(R.id.privacyControlTipsSmall);
        this.naD = (TextView) this.nay.findViewById(R.id.privacyControlTipsSmall);
        this.naE = (TextView) this.nay.findViewById(R.id.privacyControlTips);
        this.jvY = (ImageView) this.nay.findViewById(R.id.arrow);
        this.mParent = this.nay.findViewById(R.id.parent);
        this.naC.setOnClickListener(this.nay);
        dIi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.nay.getLayoutMode().setNightMode(i == 1);
        this.nay.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.naA, R.color.CAM_X0105);
        ao.setViewTextColor(this.naE, R.color.CAM_X0105);
        ao.setViewTextColor(this.naF, R.color.CAM_X0105);
        ao.setViewTextColor(this.naD, R.color.CAM_X0108);
        ao.setBackgroundColor(this.naA, R.color.CAM_X0201);
        SvgManager.bwr().a(this.jvY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.naB, R.color.CAM_X0201);
        ao.setBackgroundResource(this.naC, R.drawable.setting_item_selector);
    }

    private void dIi() {
        int i;
        int i2;
        this.naz.setText(R.string.member_ad_setting_text);
        this.naz.setOnSwitchStateChangeListener(this.nay);
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
            this.naz.setVisibility(8);
            this.naA.setVisibility(8);
        } else if (i == 0) {
            this.naz.turnOffNoCallback();
        } else {
            this.naz.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bvr().getString("sync_ad_privacy_url", ""))) {
            this.naB.setVisibility(8);
        }
    }

    public View dIj() {
        return this.naC;
    }

    public void dIk() {
        this.naz.turnOffNoCallback();
    }

    public void dIl() {
        this.naz.turnOnNoCallback();
    }
}
