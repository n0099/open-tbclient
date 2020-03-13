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
    private ImageView gzA;
    private AdSettingActivity jSs;
    private MsgSettingItemView jSt;
    private TextView jSu;
    private View jSv;
    private View jSw;
    private TextView jSx;
    private TextView jSy;
    private TextView jSz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.jSs = adSettingActivity;
        aMS();
    }

    private void aMS() {
        this.jSs.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSs.getPageContext().getString(R.string.ad_control_setting));
        this.jSt = (MsgSettingItemView) this.jSs.findViewById(R.id.memberAdSetting);
        this.jSt.setLineVisibility(false);
        this.jSu = (TextView) this.jSs.findViewById(R.id.memberAdTips);
        this.jSv = this.jSs.findViewById(R.id.privacyContainer);
        this.jSw = this.jSs.findViewById(R.id.privacyItem);
        this.jSz = (TextView) this.jSs.findViewById(R.id.privacyControlText);
        this.jSx = (TextView) this.jSs.findViewById(R.id.privacyControlTipsSmall);
        this.jSx = (TextView) this.jSs.findViewById(R.id.privacyControlTipsSmall);
        this.jSy = (TextView) this.jSs.findViewById(R.id.privacyControlTips);
        this.gzA = (ImageView) this.jSs.findViewById(R.id.arrow);
        this.mParent = this.jSs.findViewById(R.id.parent);
        this.jSw.setOnClickListener(this.jSs);
        cFq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jSs.getLayoutMode().setNightMode(i == 1);
        this.jSs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jSu, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jSx, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.jSu, R.color.cp_bg_line_d);
        SvgManager.aGC().a(this.gzA, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.jSv, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jSw, R.drawable.setting_item_selector);
    }

    private void cFq() {
        int i;
        int i2 = 0;
        this.jSt.setText(R.string.member_ad_setting_text);
        this.jSt.setOnSwitchStateChangeListener(this.jSs);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.jSt.setVisibility(8);
            this.jSu.setVisibility(8);
        } else if (i2 == 0) {
            this.jSt.turnOffNoCallback();
        } else {
            this.jSt.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aFD().getString("sync_ad_privacy_url", ""))) {
            this.jSv.setVisibility(8);
        }
    }

    public View cFr() {
        return this.jSw;
    }

    public void cFs() {
        this.jSt.turnOffNoCallback();
    }

    public void cFt() {
        this.jSt.turnOnNoCallback();
    }
}
