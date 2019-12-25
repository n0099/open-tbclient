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
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView gub;
    private AdSettingActivity jNB;
    private MsgSettingItemView jNC;
    private TextView jND;
    private View jNE;
    private View jNF;
    private TextView jNG;
    private TextView jNH;
    private TextView jNI;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jNB = adSettingActivity;
        aKa();
    }

    private void aKa() {
        this.jNB.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jNB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jNB.getPageContext().getString(R.string.ad_control_setting));
        this.jNC = (MsgSettingItemView) this.jNB.findViewById(R.id.memberAdSetting);
        this.jNC.setLineVisibility(false);
        this.jND = (TextView) this.jNB.findViewById(R.id.memberAdTips);
        this.jNE = this.jNB.findViewById(R.id.privacyContainer);
        this.jNF = this.jNB.findViewById(R.id.privacyItem);
        this.jNI = (TextView) this.jNB.findViewById(R.id.privacyControlText);
        this.jNG = (TextView) this.jNB.findViewById(R.id.privacyControlTipsSmall);
        this.jNG = (TextView) this.jNB.findViewById(R.id.privacyControlTipsSmall);
        this.jNH = (TextView) this.jNB.findViewById(R.id.privacyControlTips);
        this.gub = (ImageView) this.jNB.findViewById(R.id.arrow);
        this.mParent = this.jNB.findViewById(R.id.parent);
        this.jNF.setOnClickListener(this.jNB);
        cCG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jNB.getLayoutMode().setNightMode(i == 1);
        this.jNB.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jND, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jNH, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jNI, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jNG, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jND, R.color.cp_bg_line_d);
        SvgManager.aDW().a(this.gub, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jNE, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jNF, R.drawable.setting_item_selector);
    }

    private void cCG() {
        int i;
        int i2 = 0;
        this.jNC.setText(R.string.member_ad_setting_text);
        this.jNC.setOnSwitchStateChangeListener(this.jNB);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jNC.setVisibility(8);
            this.jND.setVisibility(8);
        } else if (i2 == 0) {
            this.jNC.turnOffNoCallback();
        } else {
            this.jNC.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aCY().getString("sync_ad_privacy_url", ""))) {
            this.jNE.setVisibility(8);
        }
    }

    public View cCH() {
        return this.jNF;
    }

    public void cCI() {
        this.jNC.turnOffNoCallback();
    }

    public void cCJ() {
        this.jNC.turnOnNoCallback();
    }
}
