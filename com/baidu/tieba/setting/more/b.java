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
    private ImageView gzm;
    private AdSettingActivity jSe;
    private MsgSettingItemView jSf;
    private TextView jSg;
    private View jSh;
    private View jSi;
    private TextView jSj;
    private TextView jSk;
    private TextView jSl;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jSe = adSettingActivity;
        aMP();
    }

    private void aMP() {
        this.jSe.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSe.getPageContext().getString(R.string.ad_control_setting));
        this.jSf = (MsgSettingItemView) this.jSe.findViewById(R.id.memberAdSetting);
        this.jSf.setLineVisibility(false);
        this.jSg = (TextView) this.jSe.findViewById(R.id.memberAdTips);
        this.jSh = this.jSe.findViewById(R.id.privacyContainer);
        this.jSi = this.jSe.findViewById(R.id.privacyItem);
        this.jSl = (TextView) this.jSe.findViewById(R.id.privacyControlText);
        this.jSj = (TextView) this.jSe.findViewById(R.id.privacyControlTipsSmall);
        this.jSj = (TextView) this.jSe.findViewById(R.id.privacyControlTipsSmall);
        this.jSk = (TextView) this.jSe.findViewById(R.id.privacyControlTips);
        this.gzm = (ImageView) this.jSe.findViewById(R.id.arrow);
        this.mParent = this.jSe.findViewById(R.id.parent);
        this.jSi.setOnClickListener(this.jSe);
        cFn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jSe.getLayoutMode().setNightMode(i == 1);
        this.jSe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jSg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSj, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jSg, R.color.cp_bg_line_d);
        SvgManager.aGA().a(this.gzm, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jSh, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jSi, R.drawable.setting_item_selector);
    }

    private void cFn() {
        int i;
        int i2 = 0;
        this.jSf.setText(R.string.member_ad_setting_text);
        this.jSf.setOnSwitchStateChangeListener(this.jSe);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jSf.setVisibility(8);
            this.jSg.setVisibility(8);
        } else if (i2 == 0) {
            this.jSf.turnOffNoCallback();
        } else {
            this.jSf.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aFB().getString("sync_ad_privacy_url", ""))) {
            this.jSh.setVisibility(8);
        }
    }

    public View cFo() {
        return this.jSi;
    }

    public void cFp() {
        this.jSf.turnOffNoCallback();
    }

    public void cFq() {
        this.jSf.turnOnNoCallback();
    }
}
