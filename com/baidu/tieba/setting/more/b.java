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
    private AdSettingActivity jRj;
    private MsgSettingItemView jRk;
    private TextView jRl;
    private View jRm;
    private View jRn;
    private TextView jRo;
    private TextView jRp;
    private TextView jRq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jRj = adSettingActivity;
        aKt();
    }

    private void aKt() {
        this.jRj.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jRj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRj.getPageContext().getString(R.string.ad_control_setting));
        this.jRk = (MsgSettingItemView) this.jRj.findViewById(R.id.memberAdSetting);
        this.jRk.setLineVisibility(false);
        this.jRl = (TextView) this.jRj.findViewById(R.id.memberAdTips);
        this.jRm = this.jRj.findViewById(R.id.privacyContainer);
        this.jRn = this.jRj.findViewById(R.id.privacyItem);
        this.jRq = (TextView) this.jRj.findViewById(R.id.privacyControlText);
        this.jRo = (TextView) this.jRj.findViewById(R.id.privacyControlTipsSmall);
        this.jRo = (TextView) this.jRj.findViewById(R.id.privacyControlTipsSmall);
        this.jRp = (TextView) this.jRj.findViewById(R.id.privacyControlTips);
        this.gxl = (ImageView) this.jRj.findViewById(R.id.arrow);
        this.mParent = this.jRj.findViewById(R.id.parent);
        this.jRn.setOnClickListener(this.jRj);
        cDM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jRj.getLayoutMode().setNightMode(i == 1);
        this.jRj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jRl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jRo, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jRl, R.color.cp_bg_line_d);
        SvgManager.aEp().a(this.gxl, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jRm, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jRn, R.drawable.setting_item_selector);
    }

    private void cDM() {
        int i;
        int i2 = 0;
        this.jRk.setText(R.string.member_ad_setting_text);
        this.jRk.setOnSwitchStateChangeListener(this.jRj);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jRk.setVisibility(8);
            this.jRl.setVisibility(8);
        } else if (i2 == 0) {
            this.jRk.turnOffNoCallback();
        } else {
            this.jRk.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aDr().getString("sync_ad_privacy_url", ""))) {
            this.jRm.setVisibility(8);
        }
    }

    public View cDN() {
        return this.jRn;
    }

    public void cDO() {
        this.jRk.turnOffNoCallback();
    }

    public void cDP() {
        this.jRk.turnOnNoCallback();
    }
}
