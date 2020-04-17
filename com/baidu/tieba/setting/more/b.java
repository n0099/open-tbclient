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
    private ImageView hjU;
    private AdSettingActivity kDc;
    private MsgSettingItemView kDd;
    private TextView kDe;
    private View kDf;
    private View kDg;
    private TextView kDh;
    private TextView kDi;
    private TextView kDj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.kDc = adSettingActivity;
        aVt();
    }

    private void aVt() {
        this.kDc.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kDc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kDc.getPageContext().getString(R.string.ad_control_setting));
        this.kDd = (MsgSettingItemView) this.kDc.findViewById(R.id.memberAdSetting);
        this.kDd.setLineVisibility(false);
        this.kDe = (TextView) this.kDc.findViewById(R.id.memberAdTips);
        this.kDf = this.kDc.findViewById(R.id.privacyContainer);
        this.kDg = this.kDc.findViewById(R.id.privacyItem);
        this.kDj = (TextView) this.kDc.findViewById(R.id.privacyControlText);
        this.kDh = (TextView) this.kDc.findViewById(R.id.privacyControlTipsSmall);
        this.kDh = (TextView) this.kDc.findViewById(R.id.privacyControlTipsSmall);
        this.kDi = (TextView) this.kDc.findViewById(R.id.privacyControlTips);
        this.hjU = (ImageView) this.kDc.findViewById(R.id.arrow);
        this.mParent = this.kDc.findViewById(R.id.parent);
        this.kDg.setOnClickListener(this.kDc);
        cQi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kDc.getLayoutMode().setNightMode(i == 1);
        this.kDc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kDe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDi, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kDh, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.kDe, R.color.cp_bg_line_d);
        SvgManager.aOU().a(this.hjU, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.kDf, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kDg, R.drawable.setting_item_selector);
    }

    private void cQi() {
        int i;
        int i2 = 0;
        this.kDd.setText(R.string.member_ad_setting_text);
        this.kDd.setOnSwitchStateChangeListener(this.kDc);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.kDd.setVisibility(8);
            this.kDe.setVisibility(8);
        } else if (i2 == 0) {
            this.kDd.turnOffNoCallback();
        } else {
            this.kDd.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aNV().getString("sync_ad_privacy_url", ""))) {
            this.kDf.setVisibility(8);
        }
    }

    public View cQj() {
        return this.kDg;
    }

    public void cQk() {
        this.kDd.turnOffNoCallback();
    }

    public void cQl() {
        this.kDd.turnOnNoCallback();
    }
}
