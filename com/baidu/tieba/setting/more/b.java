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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.d<AdSettingActivity> {
    private ImageView jxm;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity ngb;
    private MsgSettingItemView ngc;
    private TextView ngd;
    private View nge;
    private View ngf;
    private TextView ngg;
    private TextView ngh;
    private TextView ngi;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.ngb = adSettingActivity;
        bzE();
    }

    private void bzE() {
        this.ngb.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ngb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ngb.getPageContext().getString(R.string.ad_control_setting));
        this.ngc = (MsgSettingItemView) this.ngb.findViewById(R.id.memberAdSetting);
        this.ngc.setLineVisibility(false);
        this.ngd = (TextView) this.ngb.findViewById(R.id.memberAdTips);
        this.nge = this.ngb.findViewById(R.id.privacyContainer);
        this.ngf = this.ngb.findViewById(R.id.privacyItem);
        this.ngi = (TextView) this.ngb.findViewById(R.id.privacyControlText);
        this.ngg = (TextView) this.ngb.findViewById(R.id.privacyControlTipsSmall);
        this.ngg = (TextView) this.ngb.findViewById(R.id.privacyControlTipsSmall);
        this.ngh = (TextView) this.ngb.findViewById(R.id.privacyControlTips);
        this.jxm = (ImageView) this.ngb.findViewById(R.id.arrow);
        this.mParent = this.ngb.findViewById(R.id.parent);
        this.ngf.setOnClickListener(this.ngb);
        dGJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ngb.getLayoutMode().setNightMode(i == 1);
        this.ngb.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.ngd, R.color.CAM_X0105);
        ap.setViewTextColor(this.ngh, R.color.CAM_X0105);
        ap.setViewTextColor(this.ngi, R.color.CAM_X0105);
        ap.setViewTextColor(this.ngg, R.color.CAM_X0108);
        ap.setBackgroundColor(this.ngd, R.color.CAM_X0201);
        SvgManager.bsR().a(this.jxm, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.nge, R.color.CAM_X0201);
        ap.setBackgroundResource(this.ngf, R.drawable.setting_item_selector);
    }

    private void dGJ() {
        int i;
        int i2;
        this.ngc.setText(R.string.member_ad_setting_text);
        this.ngc.setOnSwitchStateChangeListener(this.ngb);
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
            this.ngc.setVisibility(8);
            this.ngd.setVisibility(8);
        } else if (i == 0) {
            this.ngc.turnOffNoCallback();
        } else {
            this.ngc.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.brQ().getString("sync_ad_privacy_url", ""))) {
            this.nge.setVisibility(8);
        }
    }

    public View dGK() {
        return this.ngf;
    }

    public void dGL() {
        this.ngc.turnOffNoCallback();
    }

    public void dGM() {
        this.ngc.turnOnNoCallback();
    }
}
