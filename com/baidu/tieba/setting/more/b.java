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
    private ImageView hka;
    private AdSettingActivity kDg;
    private MsgSettingItemView kDh;
    private TextView kDi;
    private View kDj;
    private View kDk;
    private TextView kDl;
    private TextView kDm;
    private TextView kDn;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.kDg = adSettingActivity;
        aVr();
    }

    private void aVr() {
        this.kDg.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kDg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kDg.getPageContext().getString(R.string.ad_control_setting));
        this.kDh = (MsgSettingItemView) this.kDg.findViewById(R.id.memberAdSetting);
        this.kDh.setLineVisibility(false);
        this.kDi = (TextView) this.kDg.findViewById(R.id.memberAdTips);
        this.kDj = this.kDg.findViewById(R.id.privacyContainer);
        this.kDk = this.kDg.findViewById(R.id.privacyItem);
        this.kDn = (TextView) this.kDg.findViewById(R.id.privacyControlText);
        this.kDl = (TextView) this.kDg.findViewById(R.id.privacyControlTipsSmall);
        this.kDl = (TextView) this.kDg.findViewById(R.id.privacyControlTipsSmall);
        this.kDm = (TextView) this.kDg.findViewById(R.id.privacyControlTips);
        this.hka = (ImageView) this.kDg.findViewById(R.id.arrow);
        this.mParent = this.kDg.findViewById(R.id.parent);
        this.kDk.setOnClickListener(this.kDg);
        cQf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kDg.getLayoutMode().setNightMode(i == 1);
        this.kDg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kDi, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDl, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.kDi, R.color.cp_bg_line_d);
        SvgManager.aOR().a(this.hka, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.kDj, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kDk, R.drawable.setting_item_selector);
    }

    private void cQf() {
        int i;
        int i2 = 0;
        this.kDh.setText(R.string.member_ad_setting_text);
        this.kDh.setOnSwitchStateChangeListener(this.kDg);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.kDh.setVisibility(8);
            this.kDi.setVisibility(8);
        } else if (i2 == 0) {
            this.kDh.turnOffNoCallback();
        } else {
            this.kDh.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aNT().getString("sync_ad_privacy_url", ""))) {
            this.kDj.setVisibility(8);
        }
    }

    public View cQg() {
        return this.kDk;
    }

    public void cQh() {
        this.kDh.turnOffNoCallback();
    }

    public void cQi() {
        this.kDh.turnOnNoCallback();
    }
}
