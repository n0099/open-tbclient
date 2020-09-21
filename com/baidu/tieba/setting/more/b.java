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
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView ioa;
    private AdSettingActivity lYo;
    private MsgSettingItemView lYp;
    private TextView lYq;
    private View lYr;
    private View lYs;
    private TextView lYt;
    private TextView lYu;
    private TextView lYv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.lYo = adSettingActivity;
        bqT();
    }

    private void bqT() {
        this.lYo.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lYo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lYo.getPageContext().getString(R.string.ad_control_setting));
        this.lYp = (MsgSettingItemView) this.lYo.findViewById(R.id.memberAdSetting);
        this.lYp.setLineVisibility(false);
        this.lYq = (TextView) this.lYo.findViewById(R.id.memberAdTips);
        this.lYr = this.lYo.findViewById(R.id.privacyContainer);
        this.lYs = this.lYo.findViewById(R.id.privacyItem);
        this.lYv = (TextView) this.lYo.findViewById(R.id.privacyControlText);
        this.lYt = (TextView) this.lYo.findViewById(R.id.privacyControlTipsSmall);
        this.lYt = (TextView) this.lYo.findViewById(R.id.privacyControlTipsSmall);
        this.lYu = (TextView) this.lYo.findViewById(R.id.privacyControlTips);
        this.ioa = (ImageView) this.lYo.findViewById(R.id.arrow);
        this.mParent = this.lYo.findViewById(R.id.parent);
        this.lYs.setOnClickListener(this.lYo);
        dug();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.lYo.getLayoutMode().setNightMode(i == 1);
        this.lYo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lYq, R.color.cp_cont_b);
        ap.setViewTextColor(this.lYu, R.color.cp_cont_b);
        ap.setViewTextColor(this.lYv, R.color.cp_cont_b);
        ap.setViewTextColor(this.lYt, R.color.cp_cont_c);
        ap.setBackgroundColor(this.lYq, R.color.cp_bg_line_d);
        SvgManager.bkl().a(this.ioa, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.lYr, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lYs, R.drawable.setting_item_selector);
    }

    private void dug() {
        int i;
        int i2 = 0;
        this.lYp.setText(R.string.member_ad_setting_text);
        this.lYp.setOnSwitchStateChangeListener(this.lYo);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.lYp.setVisibility(8);
            this.lYq.setVisibility(8);
        } else if (i2 == 0) {
            this.lYp.turnOffNoCallback();
        } else {
            this.lYp.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bjf().getString("sync_ad_privacy_url", ""))) {
            this.lYr.setVisibility(8);
        }
    }

    public View duh() {
        return this.lYs;
    }

    public void dui() {
        this.lYp.turnOffNoCallback();
    }

    public void duj() {
        this.lYp.turnOnNoCallback();
    }
}
