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
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView gAy;
    private AdSettingActivity jTU;
    private MsgSettingItemView jTV;
    private TextView jTW;
    private View jTX;
    private View jTY;
    private TextView jTZ;
    private TextView jUa;
    private TextView jUb;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jTU = adSettingActivity;
        aMW();
    }

    private void aMW() {
        this.jTU.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jTU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jTU.getPageContext().getString(R.string.ad_control_setting));
        this.jTV = (MsgSettingItemView) this.jTU.findViewById(R.id.memberAdSetting);
        this.jTV.setLineVisibility(false);
        this.jTW = (TextView) this.jTU.findViewById(R.id.memberAdTips);
        this.jTX = this.jTU.findViewById(R.id.privacyContainer);
        this.jTY = this.jTU.findViewById(R.id.privacyItem);
        this.jUb = (TextView) this.jTU.findViewById(R.id.privacyControlText);
        this.jTZ = (TextView) this.jTU.findViewById(R.id.privacyControlTipsSmall);
        this.jTZ = (TextView) this.jTU.findViewById(R.id.privacyControlTipsSmall);
        this.jUa = (TextView) this.jTU.findViewById(R.id.privacyControlTips);
        this.gAy = (ImageView) this.jTU.findViewById(R.id.arrow);
        this.mParent = this.jTU.findViewById(R.id.parent);
        this.jTY.setOnClickListener(this.jTU);
        cFK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jTU.getLayoutMode().setNightMode(i == 1);
        this.jTU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jTW, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jUa, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jUb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jTZ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jTW, R.color.cp_bg_line_d);
        SvgManager.aGG().a(this.gAy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jTX, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jTY, R.drawable.setting_item_selector);
    }

    private void cFK() {
        int i;
        int i2 = 0;
        this.jTV.setText(R.string.member_ad_setting_text);
        this.jTV.setOnSwitchStateChangeListener(this.jTU);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jTV.setVisibility(8);
            this.jTW.setVisibility(8);
        } else if (i2 == 0) {
            this.jTV.turnOffNoCallback();
        } else {
            this.jTV.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aFH().getString("sync_ad_privacy_url", ""))) {
            this.jTX.setVisibility(8);
        }
    }

    public View cFL() {
        return this.jTY;
    }

    public void cFM() {
        this.jTV.turnOffNoCallback();
    }

    public void cFN() {
        this.jTV.turnOnNoCallback();
    }
}
