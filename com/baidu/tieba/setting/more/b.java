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
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView gxl;
    private AdSettingActivity jRe;
    private MsgSettingItemView jRf;
    private TextView jRg;
    private View jRh;
    private View jRi;
    private TextView jRj;
    private TextView jRk;
    private TextView jRl;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jRe = adSettingActivity;
        aKt();
    }

    private void aKt() {
        this.jRe.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jRe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRe.getPageContext().getString(R.string.ad_control_setting));
        this.jRf = (MsgSettingItemView) this.jRe.findViewById(R.id.memberAdSetting);
        this.jRf.setLineVisibility(false);
        this.jRg = (TextView) this.jRe.findViewById(R.id.memberAdTips);
        this.jRh = this.jRe.findViewById(R.id.privacyContainer);
        this.jRi = this.jRe.findViewById(R.id.privacyItem);
        this.jRl = (TextView) this.jRe.findViewById(R.id.privacyControlText);
        this.jRj = (TextView) this.jRe.findViewById(R.id.privacyControlTipsSmall);
        this.jRj = (TextView) this.jRe.findViewById(R.id.privacyControlTipsSmall);
        this.jRk = (TextView) this.jRe.findViewById(R.id.privacyControlTips);
        this.gxl = (ImageView) this.jRe.findViewById(R.id.arrow);
        this.mParent = this.jRe.findViewById(R.id.parent);
        this.jRi.setOnClickListener(this.jRe);
        cDK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jRe.getLayoutMode().setNightMode(i == 1);
        this.jRe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jRg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRj, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jRg, R.color.cp_bg_line_d);
        SvgManager.aEp().a(this.gxl, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jRh, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jRi, R.drawable.setting_item_selector);
    }

    private void cDK() {
        int i;
        int i2 = 0;
        this.jRf.setText(R.string.member_ad_setting_text);
        this.jRf.setOnSwitchStateChangeListener(this.jRe);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jRf.setVisibility(8);
            this.jRg.setVisibility(8);
        } else if (i2 == 0) {
            this.jRf.turnOffNoCallback();
        } else {
            this.jRf.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aDr().getString("sync_ad_privacy_url", ""))) {
            this.jRh.setVisibility(8);
        }
    }

    public View cDL() {
        return this.jRi;
    }

    public void cDM() {
        this.jRf.turnOffNoCallback();
    }

    public void cDN() {
        this.jRf.turnOnNoCallback();
    }
}
