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
    private ImageView hyO;
    private AdSettingActivity kVi;
    private MsgSettingItemView kVj;
    private TextView kVk;
    private View kVl;
    private View kVm;
    private TextView kVn;
    private TextView kVo;
    private TextView kVp;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.kVi = adSettingActivity;
        bbA();
    }

    private void bbA() {
        this.kVi.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kVi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kVi.getPageContext().getString(R.string.ad_control_setting));
        this.kVj = (MsgSettingItemView) this.kVi.findViewById(R.id.memberAdSetting);
        this.kVj.setLineVisibility(false);
        this.kVk = (TextView) this.kVi.findViewById(R.id.memberAdTips);
        this.kVl = this.kVi.findViewById(R.id.privacyContainer);
        this.kVm = this.kVi.findViewById(R.id.privacyItem);
        this.kVp = (TextView) this.kVi.findViewById(R.id.privacyControlText);
        this.kVn = (TextView) this.kVi.findViewById(R.id.privacyControlTipsSmall);
        this.kVn = (TextView) this.kVi.findViewById(R.id.privacyControlTipsSmall);
        this.kVo = (TextView) this.kVi.findViewById(R.id.privacyControlTips);
        this.hyO = (ImageView) this.kVi.findViewById(R.id.arrow);
        this.mParent = this.kVi.findViewById(R.id.parent);
        this.kVm.setOnClickListener(this.kVi);
        cXj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kVi.getLayoutMode().setNightMode(i == 1);
        this.kVi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kVk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kVo, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kVp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kVn, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.kVk, R.color.cp_bg_line_d);
        SvgManager.aUV().a(this.hyO, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.kVl, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kVm, R.drawable.setting_item_selector);
    }

    private void cXj() {
        int i;
        int i2 = 0;
        this.kVj.setText(R.string.member_ad_setting_text);
        this.kVj.setOnSwitchStateChangeListener(this.kVi);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.kVj.setVisibility(8);
            this.kVk.setVisibility(8);
        } else if (i2 == 0) {
            this.kVj.turnOffNoCallback();
        } else {
            this.kVj.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.aTX().getString("sync_ad_privacy_url", ""))) {
            this.kVl.setVisibility(8);
        }
    }

    public View cXk() {
        return this.kVm;
    }

    public void cXl() {
        this.kVj.turnOffNoCallback();
    }

    public void cXm() {
        this.kVj.turnOnNoCallback();
    }
}
