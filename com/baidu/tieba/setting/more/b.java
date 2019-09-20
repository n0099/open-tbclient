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
    private ImageView fHk;
    private AdSettingActivity iUl;
    private MsgSettingItemView iUm;
    private TextView iUn;
    private View iUo;
    private View iUp;
    private TextView iUq;
    private TextView iUr;
    private TextView iUs;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iUl = adSettingActivity;
        aqJ();
    }

    private void aqJ() {
        this.iUl.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iUl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iUl.getPageContext().getString(R.string.ad_control_setting));
        this.iUm = (MsgSettingItemView) this.iUl.findViewById(R.id.memberAdSetting);
        this.iUm.setLineVisibility(false);
        this.iUn = (TextView) this.iUl.findViewById(R.id.memberAdTips);
        this.iUo = this.iUl.findViewById(R.id.privacyContainer);
        this.iUp = this.iUl.findViewById(R.id.privacyItem);
        this.iUs = (TextView) this.iUl.findViewById(R.id.privacyControlText);
        this.iUq = (TextView) this.iUl.findViewById(R.id.privacyControlTipsSmall);
        this.iUq = (TextView) this.iUl.findViewById(R.id.privacyControlTipsSmall);
        this.iUr = (TextView) this.iUl.findViewById(R.id.privacyControlTips);
        this.fHk = (ImageView) this.iUl.findViewById(R.id.arrow);
        this.mParent = this.iUl.findViewById(R.id.parent);
        this.iUp.setOnClickListener(this.iUl);
        ckS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iUl.getLayoutMode().setNightMode(i == 1);
        this.iUl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.iUn, R.color.cp_cont_b);
        am.j(this.iUr, R.color.cp_cont_b);
        am.j(this.iUs, R.color.cp_cont_b);
        am.j(this.iUq, R.color.cp_cont_c);
        am.l(this.iUn, R.color.cp_bg_line_d);
        SvgManager.ajv().a(this.fHk, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.l(this.iUo, R.color.cp_bg_line_d);
        am.k(this.iUp, R.drawable.setting_item_selector);
    }

    private void ckS() {
        int i;
        int i2 = 0;
        this.iUm.setText(R.string.member_ad_setting_text);
        this.iUm.setOnSwitchStateChangeListener(this.iUl);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iUm.setVisibility(8);
            this.iUn.setVisibility(8);
        } else if (i2 == 0) {
            this.iUm.nl();
        } else {
            this.iUm.nk();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.ahU().getString("sync_ad_privacy_url", ""))) {
            this.iUo.setVisibility(8);
        }
    }

    public View ckT() {
        return this.iUp;
    }

    public void ckU() {
        this.iUm.nl();
    }

    public void ckV() {
        this.iUm.nk();
    }
}
