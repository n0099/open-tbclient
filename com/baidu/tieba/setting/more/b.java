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
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView fFI;
    private AdSettingActivity iTf;
    private MsgSettingItemView iTg;
    private TextView iTh;
    private View iTi;
    private View iTj;
    private TextView iTk;
    private TextView iTl;
    private TextView iTm;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iTf = adSettingActivity;
        asB();
    }

    private void asB() {
        this.iTf.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iTf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iTf.getPageContext().getString(R.string.ad_control_setting));
        this.iTg = (MsgSettingItemView) this.iTf.findViewById(R.id.memberAdSetting);
        this.iTg.setLineVisibility(false);
        this.iTh = (TextView) this.iTf.findViewById(R.id.memberAdTips);
        this.iTi = this.iTf.findViewById(R.id.privacyContainer);
        this.iTj = this.iTf.findViewById(R.id.privacyItem);
        this.iTm = (TextView) this.iTf.findViewById(R.id.privacyControlText);
        this.iTk = (TextView) this.iTf.findViewById(R.id.privacyControlTipsSmall);
        this.iTk = (TextView) this.iTf.findViewById(R.id.privacyControlTipsSmall);
        this.iTl = (TextView) this.iTf.findViewById(R.id.privacyControlTips);
        this.fFI = (ImageView) this.iTf.findViewById(R.id.arrow);
        this.mParent = this.iTf.findViewById(R.id.parent);
        this.iTj.setOnClickListener(this.iTf);
        ciC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iTf.getLayoutMode().setNightMode(i == 1);
        this.iTf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iTh, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iTl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iTm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iTk, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.iTh, R.color.cp_bg_line_d);
        SvgManager.amL().a(this.fFI, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundColor(this.iTi, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.iTj, R.drawable.setting_item_selector);
    }

    private void ciC() {
        int i;
        int i2 = 0;
        this.iTg.setText(R.string.member_ad_setting_text);
        this.iTg.setOnSwitchStateChangeListener(this.iTf);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iTg.setVisibility(8);
            this.iTh.setVisibility(8);
        } else if (i2 == 0) {
            this.iTg.turnOffNoCallback();
        } else {
            this.iTg.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.alP().getString("sync_ad_privacy_url", ""))) {
            this.iTi.setVisibility(8);
        }
    }

    public View ciD() {
        return this.iTj;
    }

    public void ciE() {
        this.iTg.turnOffNoCallback();
    }

    public void ciF() {
        this.iTg.turnOnNoCallback();
    }
}
