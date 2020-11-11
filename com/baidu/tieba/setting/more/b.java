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
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView iVm;
    private TextView mGA;
    private View mGB;
    private View mGC;
    private TextView mGD;
    private TextView mGE;
    private TextView mGF;
    private AdSettingActivity mGy;
    private MsgSettingItemView mGz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mGy = adSettingActivity;
        bxV();
    }

    private void bxV() {
        this.mGy.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mGy.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGy.getPageContext().getString(R.string.ad_control_setting));
        this.mGz = (MsgSettingItemView) this.mGy.findViewById(R.id.memberAdSetting);
        this.mGz.setLineVisibility(false);
        this.mGA = (TextView) this.mGy.findViewById(R.id.memberAdTips);
        this.mGB = this.mGy.findViewById(R.id.privacyContainer);
        this.mGC = this.mGy.findViewById(R.id.privacyItem);
        this.mGF = (TextView) this.mGy.findViewById(R.id.privacyControlText);
        this.mGD = (TextView) this.mGy.findViewById(R.id.privacyControlTipsSmall);
        this.mGD = (TextView) this.mGy.findViewById(R.id.privacyControlTipsSmall);
        this.mGE = (TextView) this.mGy.findViewById(R.id.privacyControlTips);
        this.iVm = (ImageView) this.mGy.findViewById(R.id.arrow);
        this.mParent = this.mGy.findViewById(R.id.parent);
        this.mGC.setOnClickListener(this.mGy);
        dDB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mGy.getLayoutMode().setNightMode(i == 1);
        this.mGy.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mGA, R.color.cp_cont_b);
        ap.setViewTextColor(this.mGE, R.color.cp_cont_b);
        ap.setViewTextColor(this.mGF, R.color.cp_cont_b);
        ap.setViewTextColor(this.mGD, R.color.cp_cont_c);
        ap.setBackgroundColor(this.mGA, R.color.cp_bg_line_d);
        SvgManager.brn().a(this.iVm, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mGB, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mGC, R.drawable.setting_item_selector);
    }

    private void dDB() {
        int i;
        int i2 = 0;
        this.mGz.setText(R.string.member_ad_setting_text);
        this.mGz.setOnSwitchStateChangeListener(this.mGy);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mGz.setVisibility(8);
            this.mGA.setVisibility(8);
        } else if (i2 == 0) {
            this.mGz.turnOffNoCallback();
        } else {
            this.mGz.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bqh().getString("sync_ad_privacy_url", ""))) {
            this.mGB.setVisibility(8);
        }
    }

    public View dDC() {
        return this.mGC;
    }

    public void dDD() {
        this.mGz.turnOffNoCallback();
    }

    public void dDE() {
        this.mGz.turnOnNoCallback();
    }
}
