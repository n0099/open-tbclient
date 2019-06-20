package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView fzJ;
    private TextView iKA;
    private TextView iKB;
    private AdSettingActivity iKu;
    private MsgSettingItemView iKv;
    private TextView iKw;
    private View iKx;
    private View iKy;
    private TextView iKz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iKu = adSettingActivity;
        apq();
    }

    private void apq() {
        this.iKu.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKu.getPageContext().getString(R.string.ad_control_setting));
        this.iKv = (MsgSettingItemView) this.iKu.findViewById(R.id.memberAdSetting);
        this.iKv.setLineVisibility(false);
        this.iKw = (TextView) this.iKu.findViewById(R.id.memberAdTips);
        this.iKx = this.iKu.findViewById(R.id.privacyContainer);
        this.iKy = this.iKu.findViewById(R.id.privacyItem);
        this.iKB = (TextView) this.iKu.findViewById(R.id.privacyControlText);
        this.iKz = (TextView) this.iKu.findViewById(R.id.privacyControlTipsSmall);
        this.iKz = (TextView) this.iKu.findViewById(R.id.privacyControlTipsSmall);
        this.iKA = (TextView) this.iKu.findViewById(R.id.privacyControlTips);
        this.fzJ = (ImageView) this.iKu.findViewById(R.id.arrow);
        this.mParent = this.iKu.findViewById(R.id.parent);
        this.iKy.setOnClickListener(this.iKu);
        cgX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iKu.getLayoutMode().setNightMode(i == 1);
        this.iKu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.iKw, R.color.cp_cont_b);
        al.j(this.iKA, R.color.cp_cont_b);
        al.j(this.iKB, R.color.cp_cont_b);
        al.j(this.iKz, R.color.cp_cont_c);
        al.l(this.iKw, R.color.cp_bg_line_d);
        al.c(this.fzJ, (int) R.drawable.icon_arrow_gray_right_n);
        al.l(this.iKx, R.color.cp_bg_line_d);
        al.k(this.iKy, R.drawable.setting_item_selector);
    }

    private void cgX() {
        int i;
        int i2 = 0;
        this.iKv.setText(R.string.member_ad_setting_text);
        this.iKv.setOnSwitchStateChangeListener(this.iKu);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iKv.setVisibility(8);
            this.iKw.setVisibility(8);
        } else if (i2 == 0) {
            this.iKv.mU();
        } else {
            this.iKv.mT();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.agM().getString("sync_ad_privacy_url", ""))) {
            this.iKx.setVisibility(8);
        }
    }

    public View cgY() {
        return this.iKy;
    }

    public void cgZ() {
        this.iKv.mU();
    }

    public void cha() {
        this.iKv.mT();
    }
}
