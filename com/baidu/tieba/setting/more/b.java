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
    private ImageView jjz;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity mVd;
    private MsgSettingItemView mVe;
    private TextView mVf;
    private View mVg;
    private View mVh;
    private TextView mVi;
    private TextView mVj;
    private TextView mVk;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mVd = adSettingActivity;
        bAL();
    }

    private void bAL() {
        this.mVd.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mVd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVd.getPageContext().getString(R.string.ad_control_setting));
        this.mVe = (MsgSettingItemView) this.mVd.findViewById(R.id.memberAdSetting);
        this.mVe.setLineVisibility(false);
        this.mVf = (TextView) this.mVd.findViewById(R.id.memberAdTips);
        this.mVg = this.mVd.findViewById(R.id.privacyContainer);
        this.mVh = this.mVd.findViewById(R.id.privacyItem);
        this.mVk = (TextView) this.mVd.findViewById(R.id.privacyControlText);
        this.mVi = (TextView) this.mVd.findViewById(R.id.privacyControlTipsSmall);
        this.mVi = (TextView) this.mVd.findViewById(R.id.privacyControlTipsSmall);
        this.mVj = (TextView) this.mVd.findViewById(R.id.privacyControlTips);
        this.jjz = (ImageView) this.mVd.findViewById(R.id.arrow);
        this.mParent = this.mVd.findViewById(R.id.parent);
        this.mVh.setOnClickListener(this.mVd);
        dIs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mVd.getLayoutMode().setNightMode(i == 1);
        this.mVd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mVf, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVj, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVk, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVi, R.color.CAM_X0108);
        ap.setBackgroundColor(this.mVf, R.color.CAM_X0201);
        SvgManager.btW().a(this.jjz, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mVg, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mVh, R.drawable.setting_item_selector);
    }

    private void dIs() {
        int i;
        int i2 = 0;
        this.mVe.setText(R.string.member_ad_setting_text);
        this.mVe.setOnSwitchStateChangeListener(this.mVd);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mVe.setVisibility(8);
            this.mVf.setVisibility(8);
        } else if (i2 == 0) {
            this.mVe.turnOffNoCallback();
        } else {
            this.mVe.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bsO().getString("sync_ad_privacy_url", ""))) {
            this.mVg.setVisibility(8);
        }
    }

    public View dIt() {
        return this.mVh;
    }

    public void dIu() {
        this.mVe.turnOffNoCallback();
    }

    public void dIv() {
        this.mVe.turnOnNoCallback();
    }
}
