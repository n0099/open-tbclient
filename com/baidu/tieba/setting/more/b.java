package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView hMJ;
    private AdSettingActivity lqo;
    private MsgSettingItemView lqp;
    private TextView lqq;
    private View lqr;
    private View lqs;
    private TextView lqt;
    private TextView lqu;
    private TextView lqv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lqo = adSettingActivity;
        bdD();
    }

    private void bdD() {
        this.lqo.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lqo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lqo.getPageContext().getString(R.string.ad_control_setting));
        this.lqp = (MsgSettingItemView) this.lqo.findViewById(R.id.memberAdSetting);
        this.lqp.setLineVisibility(false);
        this.lqq = (TextView) this.lqo.findViewById(R.id.memberAdTips);
        this.lqr = this.lqo.findViewById(R.id.privacyContainer);
        this.lqs = this.lqo.findViewById(R.id.privacyItem);
        this.lqv = (TextView) this.lqo.findViewById(R.id.privacyControlText);
        this.lqt = (TextView) this.lqo.findViewById(R.id.privacyControlTipsSmall);
        this.lqt = (TextView) this.lqo.findViewById(R.id.privacyControlTipsSmall);
        this.lqu = (TextView) this.lqo.findViewById(R.id.privacyControlTips);
        this.hMJ = (ImageView) this.lqo.findViewById(R.id.arrow);
        this.mParent = this.lqo.findViewById(R.id.parent);
        this.lqs.setOnClickListener(this.lqo);
        dbP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lqo.getLayoutMode().setNightMode(i == 1);
        this.lqo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        an.setViewTextColor(this.lqq, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.lqu, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.lqv, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.lqt, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.lqq, R.color.cp_bg_line_d);
        SvgManager.aWQ().a(this.hMJ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        an.setBackgroundColor(this.lqr, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.lqs, R.drawable.setting_item_selector);
    }

    private void dbP() {
        int i;
        int i2 = 0;
        this.lqp.setText(R.string.member_ad_setting_text);
        this.lqp.setOnSwitchStateChangeListener(this.lqo);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lqp.setVisibility(8);
            this.lqq.setVisibility(8);
        } else if (i2 == 0) {
            this.lqp.turnOffNoCallback();
        } else {
            this.lqp.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aVP().getString("sync_ad_privacy_url", ""))) {
            this.lqr.setVisibility(8);
        }
    }

    public View dbQ() {
        return this.lqs;
    }

    public void dbR() {
        this.lqp.turnOffNoCallback();
    }

    public void dbS() {
        this.lqp.turnOnNoCallback();
    }
}
