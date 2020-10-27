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
    private ImageView iPp;
    private TextView mAA;
    private TextView mAB;
    private TextView mAC;
    private AdSettingActivity mAv;
    private MsgSettingItemView mAw;
    private TextView mAx;
    private View mAy;
    private View mAz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mAv = adSettingActivity;
        bvw();
    }

    private void bvw() {
        this.mAv.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mAv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mAv.getPageContext().getString(R.string.ad_control_setting));
        this.mAw = (MsgSettingItemView) this.mAv.findViewById(R.id.memberAdSetting);
        this.mAw.setLineVisibility(false);
        this.mAx = (TextView) this.mAv.findViewById(R.id.memberAdTips);
        this.mAy = this.mAv.findViewById(R.id.privacyContainer);
        this.mAz = this.mAv.findViewById(R.id.privacyItem);
        this.mAC = (TextView) this.mAv.findViewById(R.id.privacyControlText);
        this.mAA = (TextView) this.mAv.findViewById(R.id.privacyControlTipsSmall);
        this.mAA = (TextView) this.mAv.findViewById(R.id.privacyControlTipsSmall);
        this.mAB = (TextView) this.mAv.findViewById(R.id.privacyControlTips);
        this.iPp = (ImageView) this.mAv.findViewById(R.id.arrow);
        this.mParent = this.mAv.findViewById(R.id.parent);
        this.mAz.setOnClickListener(this.mAv);
        dAZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mAv.getLayoutMode().setNightMode(i == 1);
        this.mAv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mAx, R.color.cp_cont_b);
        ap.setViewTextColor(this.mAB, R.color.cp_cont_b);
        ap.setViewTextColor(this.mAC, R.color.cp_cont_b);
        ap.setViewTextColor(this.mAA, R.color.cp_cont_c);
        ap.setBackgroundColor(this.mAx, R.color.cp_bg_line_d);
        SvgManager.boN().a(this.iPp, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mAy, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mAz, R.drawable.setting_item_selector);
    }

    private void dAZ() {
        int i;
        int i2 = 0;
        this.mAw.setText(R.string.member_ad_setting_text);
        this.mAw.setOnSwitchStateChangeListener(this.mAv);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mAw.setVisibility(8);
            this.mAx.setVisibility(8);
        } else if (i2 == 0) {
            this.mAw.turnOffNoCallback();
        } else {
            this.mAw.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bnH().getString("sync_ad_privacy_url", ""))) {
            this.mAy.setVisibility(8);
        }
    }

    public View dBa() {
        return this.mAz;
    }

    public void dBb() {
        this.mAw.turnOffNoCallback();
    }

    public void dBc() {
        this.mAw.turnOnNoCallback();
    }
}
