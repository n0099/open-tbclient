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
    private ImageView iCT;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity mnU;
    private MsgSettingItemView mnV;
    private TextView mnW;
    private View mnX;
    private View mnY;
    private TextView mnZ;
    private TextView moa;
    private TextView mob;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.mnU = adSettingActivity;
        btD();
    }

    private void btD() {
        this.mnU.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mnU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mnU.getPageContext().getString(R.string.ad_control_setting));
        this.mnV = (MsgSettingItemView) this.mnU.findViewById(R.id.memberAdSetting);
        this.mnV.setLineVisibility(false);
        this.mnW = (TextView) this.mnU.findViewById(R.id.memberAdTips);
        this.mnX = this.mnU.findViewById(R.id.privacyContainer);
        this.mnY = this.mnU.findViewById(R.id.privacyItem);
        this.mob = (TextView) this.mnU.findViewById(R.id.privacyControlText);
        this.mnZ = (TextView) this.mnU.findViewById(R.id.privacyControlTipsSmall);
        this.mnZ = (TextView) this.mnU.findViewById(R.id.privacyControlTipsSmall);
        this.moa = (TextView) this.mnU.findViewById(R.id.privacyControlTips);
        this.iCT = (ImageView) this.mnU.findViewById(R.id.arrow);
        this.mParent = this.mnU.findViewById(R.id.parent);
        this.mnY.setOnClickListener(this.mnU);
        dxR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mnU.getLayoutMode().setNightMode(i == 1);
        this.mnU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mnW, R.color.cp_cont_b);
        ap.setViewTextColor(this.moa, R.color.cp_cont_b);
        ap.setViewTextColor(this.mob, R.color.cp_cont_b);
        ap.setViewTextColor(this.mnZ, R.color.cp_cont_c);
        ap.setBackgroundColor(this.mnW, R.color.cp_bg_line_d);
        SvgManager.bmU().a(this.iCT, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mnX, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mnY, R.drawable.setting_item_selector);
    }

    private void dxR() {
        int i;
        int i2 = 0;
        this.mnV.setText(R.string.member_ad_setting_text);
        this.mnV.setOnSwitchStateChangeListener(this.mnU);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mnV.setVisibility(8);
            this.mnW.setVisibility(8);
        } else if (i2 == 0) {
            this.mnV.turnOffNoCallback();
        } else {
            this.mnV.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.blO().getString("sync_ad_privacy_url", ""))) {
            this.mnX.setVisibility(8);
        }
    }

    public View dxS() {
        return this.mnY;
    }

    public void dxT() {
        this.mnV.turnOffNoCallback();
    }

    public void dxU() {
        this.mnV.turnOnNoCallback();
    }
}
