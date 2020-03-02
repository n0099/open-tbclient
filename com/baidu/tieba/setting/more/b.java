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
    private ImageView gzo;
    private AdSettingActivity jSg;
    private MsgSettingItemView jSh;
    private TextView jSi;
    private View jSj;
    private View jSk;
    private TextView jSl;
    private TextView jSm;
    private TextView jSn;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jSg = adSettingActivity;
        aMR();
    }

    private void aMR() {
        this.jSg.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSg.getPageContext().getString(R.string.ad_control_setting));
        this.jSh = (MsgSettingItemView) this.jSg.findViewById(R.id.memberAdSetting);
        this.jSh.setLineVisibility(false);
        this.jSi = (TextView) this.jSg.findViewById(R.id.memberAdTips);
        this.jSj = this.jSg.findViewById(R.id.privacyContainer);
        this.jSk = this.jSg.findViewById(R.id.privacyItem);
        this.jSn = (TextView) this.jSg.findViewById(R.id.privacyControlText);
        this.jSl = (TextView) this.jSg.findViewById(R.id.privacyControlTipsSmall);
        this.jSl = (TextView) this.jSg.findViewById(R.id.privacyControlTipsSmall);
        this.jSm = (TextView) this.jSg.findViewById(R.id.privacyControlTips);
        this.gzo = (ImageView) this.jSg.findViewById(R.id.arrow);
        this.mParent = this.jSg.findViewById(R.id.parent);
        this.jSk.setOnClickListener(this.jSg);
        cFp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jSg.getLayoutMode().setNightMode(i == 1);
        this.jSg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jSi, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSl, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jSi, R.color.cp_bg_line_d);
        SvgManager.aGC().a(this.gzo, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jSj, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jSk, R.drawable.setting_item_selector);
    }

    private void cFp() {
        int i;
        int i2 = 0;
        this.jSh.setText(R.string.member_ad_setting_text);
        this.jSh.setOnSwitchStateChangeListener(this.jSg);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jSh.setVisibility(8);
            this.jSi.setVisibility(8);
        } else if (i2 == 0) {
            this.jSh.turnOffNoCallback();
        } else {
            this.jSh.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aFD().getString("sync_ad_privacy_url", ""))) {
            this.jSj.setVisibility(8);
        }
    }

    public View cFq() {
        return this.jSk;
    }

    public void cFr() {
        this.jSh.turnOffNoCallback();
    }

    public void cFs() {
        this.jSh.turnOnNoCallback();
    }
}
