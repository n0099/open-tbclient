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
    private ImageView hzB;
    private AdSettingActivity kWr;
    private MsgSettingItemView kWs;
    private TextView kWt;
    private View kWu;
    private View kWv;
    private TextView kWw;
    private TextView kWx;
    private TextView kWy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.kWr = adSettingActivity;
        bbB();
    }

    private void bbB() {
        this.kWr.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kWr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kWr.getPageContext().getString(R.string.ad_control_setting));
        this.kWs = (MsgSettingItemView) this.kWr.findViewById(R.id.memberAdSetting);
        this.kWs.setLineVisibility(false);
        this.kWt = (TextView) this.kWr.findViewById(R.id.memberAdTips);
        this.kWu = this.kWr.findViewById(R.id.privacyContainer);
        this.kWv = this.kWr.findViewById(R.id.privacyItem);
        this.kWy = (TextView) this.kWr.findViewById(R.id.privacyControlText);
        this.kWw = (TextView) this.kWr.findViewById(R.id.privacyControlTipsSmall);
        this.kWw = (TextView) this.kWr.findViewById(R.id.privacyControlTipsSmall);
        this.kWx = (TextView) this.kWr.findViewById(R.id.privacyControlTips);
        this.hzB = (ImageView) this.kWr.findViewById(R.id.arrow);
        this.mParent = this.kWr.findViewById(R.id.parent);
        this.kWv.setOnClickListener(this.kWr);
        cXz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kWr.getLayoutMode().setNightMode(i == 1);
        this.kWr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kWt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kWx, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kWy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kWw, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.kWt, R.color.cp_bg_line_d);
        SvgManager.aUW().a(this.hzB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.kWu, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kWv, R.drawable.setting_item_selector);
    }

    private void cXz() {
        int i;
        int i2 = 0;
        this.kWs.setText(R.string.member_ad_setting_text);
        this.kWs.setOnSwitchStateChangeListener(this.kWr);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.kWs.setVisibility(8);
            this.kWt.setVisibility(8);
        } else if (i2 == 0) {
            this.kWs.turnOffNoCallback();
        } else {
            this.kWs.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aTX().getString("sync_ad_privacy_url", ""))) {
            this.kWu.setVisibility(8);
        }
    }

    public View cXA() {
        return this.kWv;
    }

    public void cXB() {
        this.kWs.turnOffNoCallback();
    }

    public void cXC() {
        this.kWs.turnOnNoCallback();
    }
}
