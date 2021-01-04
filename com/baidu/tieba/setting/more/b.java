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
    private MsgSettingItemView naA;
    private TextView naB;
    private View naC;
    private View naD;
    private TextView naE;
    private TextView naF;
    private TextView naG;
    private AdSettingActivity naz;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.naz = adSettingActivity;
        bDf();
    }

    private void bDf() {
        this.naz.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.naz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.naz.getPageContext().getString(R.string.ad_control_setting));
        this.naA = (MsgSettingItemView) this.naz.findViewById(R.id.memberAdSetting);
        this.naA.setLineVisibility(false);
        this.naB = (TextView) this.naz.findViewById(R.id.memberAdTips);
        this.naC = this.naz.findViewById(R.id.privacyContainer);
        this.naD = this.naz.findViewById(R.id.privacyItem);
        this.naG = (TextView) this.naz.findViewById(R.id.privacyControlText);
        this.naE = (TextView) this.naz.findViewById(R.id.privacyControlTipsSmall);
        this.naE = (TextView) this.naz.findViewById(R.id.privacyControlTipsSmall);
        this.naF = (TextView) this.naz.findViewById(R.id.privacyControlTips);
        this.jvY = (ImageView) this.naz.findViewById(R.id.arrow);
        this.mParent = this.naz.findViewById(R.id.parent);
        this.naD.setOnClickListener(this.naz);
        dIh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.naz.getLayoutMode().setNightMode(i == 1);
        this.naz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.naB, R.color.CAM_X0105);
        ao.setViewTextColor(this.naF, R.color.CAM_X0105);
        ao.setViewTextColor(this.naG, R.color.CAM_X0105);
        ao.setViewTextColor(this.naE, R.color.CAM_X0108);
        ao.setBackgroundColor(this.naB, R.color.CAM_X0201);
        SvgManager.bwq().a(this.jvY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.naC, R.color.CAM_X0201);
        ao.setBackgroundResource(this.naD, R.drawable.setting_item_selector);
    }

    private void dIh() {
        int i;
        int i2;
        this.naA.setText(R.string.member_ad_setting_text);
        this.naA.setOnSwitchStateChangeListener(this.naz);
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
            this.naA.setVisibility(8);
            this.naB.setVisibility(8);
        } else if (i == 0) {
            this.naA.turnOffNoCallback();
        } else {
            this.naA.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bvq().getString("sync_ad_privacy_url", ""))) {
            this.naC.setVisibility(8);
        }
    }

    public View dIi() {
        return this.naD;
    }

    public void dIj() {
        this.naA.turnOffNoCallback();
    }

    public void dIk() {
        this.naA.turnOnNoCallback();
    }
}
