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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.d<AdSettingActivity> {
    private ImageView jyV;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity nig;
    private MsgSettingItemView nih;
    private TextView nii;
    private View nij;
    private View nik;
    private TextView nil;
    private TextView nim;
    private TextView nin;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.nig = adSettingActivity;
        bzH();
    }

    private void bzH() {
        this.nig.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.nig.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nig.getPageContext().getString(R.string.ad_control_setting));
        this.nih = (MsgSettingItemView) this.nig.findViewById(R.id.memberAdSetting);
        this.nih.setLineVisibility(false);
        this.nii = (TextView) this.nig.findViewById(R.id.memberAdTips);
        this.nij = this.nig.findViewById(R.id.privacyContainer);
        this.nik = this.nig.findViewById(R.id.privacyItem);
        this.nin = (TextView) this.nig.findViewById(R.id.privacyControlText);
        this.nil = (TextView) this.nig.findViewById(R.id.privacyControlTipsSmall);
        this.nil = (TextView) this.nig.findViewById(R.id.privacyControlTipsSmall);
        this.nim = (TextView) this.nig.findViewById(R.id.privacyControlTips);
        this.jyV = (ImageView) this.nig.findViewById(R.id.arrow);
        this.mParent = this.nig.findViewById(R.id.parent);
        this.nik.setOnClickListener(this.nig);
        dGR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.nig.getLayoutMode().setNightMode(i == 1);
        this.nig.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.nii, R.color.CAM_X0105);
        ap.setViewTextColor(this.nim, R.color.CAM_X0105);
        ap.setViewTextColor(this.nin, R.color.CAM_X0105);
        ap.setViewTextColor(this.nil, R.color.CAM_X0108);
        ap.setBackgroundColor(this.nii, R.color.CAM_X0201);
        SvgManager.bsU().a(this.jyV, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.nij, R.color.CAM_X0201);
        ap.setBackgroundResource(this.nik, R.drawable.setting_item_selector);
    }

    private void dGR() {
        int i;
        int i2;
        this.nih.setText(R.string.member_ad_setting_text);
        this.nih.setOnSwitchStateChangeListener(this.nig);
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
            this.nih.setVisibility(8);
            this.nii.setVisibility(8);
        } else if (i == 0) {
            this.nih.turnOffNoCallback();
        } else {
            this.nih.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.brR().getString("sync_ad_privacy_url", ""))) {
            this.nij.setVisibility(8);
        }
    }

    public View dGS() {
        return this.nik;
    }

    public void dGT() {
        this.nih.turnOffNoCallback();
    }

    public void dGU() {
        this.nih.turnOnNoCallback();
    }
}
