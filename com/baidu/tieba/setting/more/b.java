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
    private ImageView jjx;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity mVb;
    private MsgSettingItemView mVc;
    private TextView mVd;
    private View mVe;
    private View mVf;
    private TextView mVg;
    private TextView mVh;
    private TextView mVi;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mVb = adSettingActivity;
        bAL();
    }

    private void bAL() {
        this.mVb.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mVb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVb.getPageContext().getString(R.string.ad_control_setting));
        this.mVc = (MsgSettingItemView) this.mVb.findViewById(R.id.memberAdSetting);
        this.mVc.setLineVisibility(false);
        this.mVd = (TextView) this.mVb.findViewById(R.id.memberAdTips);
        this.mVe = this.mVb.findViewById(R.id.privacyContainer);
        this.mVf = this.mVb.findViewById(R.id.privacyItem);
        this.mVi = (TextView) this.mVb.findViewById(R.id.privacyControlText);
        this.mVg = (TextView) this.mVb.findViewById(R.id.privacyControlTipsSmall);
        this.mVg = (TextView) this.mVb.findViewById(R.id.privacyControlTipsSmall);
        this.mVh = (TextView) this.mVb.findViewById(R.id.privacyControlTips);
        this.jjx = (ImageView) this.mVb.findViewById(R.id.arrow);
        this.mParent = this.mVb.findViewById(R.id.parent);
        this.mVf.setOnClickListener(this.mVb);
        dIr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mVb.getLayoutMode().setNightMode(i == 1);
        this.mVb.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mVd, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVh, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVi, R.color.CAM_X0105);
        ap.setViewTextColor(this.mVg, R.color.CAM_X0108);
        ap.setBackgroundColor(this.mVd, R.color.CAM_X0201);
        SvgManager.btW().a(this.jjx, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mVe, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mVf, R.drawable.setting_item_selector);
    }

    private void dIr() {
        int i;
        int i2 = 0;
        this.mVc.setText(R.string.member_ad_setting_text);
        this.mVc.setOnSwitchStateChangeListener(this.mVb);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mVc.setVisibility(8);
            this.mVd.setVisibility(8);
        } else if (i2 == 0) {
            this.mVc.turnOffNoCallback();
        } else {
            this.mVc.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bsO().getString("sync_ad_privacy_url", ""))) {
            this.mVe.setVisibility(8);
        }
    }

    public View dIs() {
        return this.mVf;
    }

    public void dIt() {
        this.mVc.turnOffNoCallback();
    }

    public void dIu() {
        this.mVc.turnOnNoCallback();
    }
}
