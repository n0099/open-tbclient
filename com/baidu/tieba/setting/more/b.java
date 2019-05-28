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
    private AdSettingActivity iKq;
    private MsgSettingItemView iKr;
    private TextView iKs;
    private View iKt;
    private View iKu;
    private TextView iKv;
    private TextView iKw;
    private TextView iKx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iKq = adSettingActivity;
        apq();
    }

    private void apq() {
        this.iKq.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKq.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKq.getPageContext().getString(R.string.ad_control_setting));
        this.iKr = (MsgSettingItemView) this.iKq.findViewById(R.id.memberAdSetting);
        this.iKr.setLineVisibility(false);
        this.iKs = (TextView) this.iKq.findViewById(R.id.memberAdTips);
        this.iKt = this.iKq.findViewById(R.id.privacyContainer);
        this.iKu = this.iKq.findViewById(R.id.privacyItem);
        this.iKx = (TextView) this.iKq.findViewById(R.id.privacyControlText);
        this.iKv = (TextView) this.iKq.findViewById(R.id.privacyControlTipsSmall);
        this.iKv = (TextView) this.iKq.findViewById(R.id.privacyControlTipsSmall);
        this.iKw = (TextView) this.iKq.findViewById(R.id.privacyControlTips);
        this.fzJ = (ImageView) this.iKq.findViewById(R.id.arrow);
        this.mParent = this.iKq.findViewById(R.id.parent);
        this.iKu.setOnClickListener(this.iKq);
        cgW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iKq.getLayoutMode().setNightMode(i == 1);
        this.iKq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.iKs, R.color.cp_cont_b);
        al.j(this.iKw, R.color.cp_cont_b);
        al.j(this.iKx, R.color.cp_cont_b);
        al.j(this.iKv, R.color.cp_cont_c);
        al.l(this.iKs, R.color.cp_bg_line_d);
        al.c(this.fzJ, (int) R.drawable.icon_arrow_gray_right_n);
        al.l(this.iKt, R.color.cp_bg_line_d);
        al.k(this.iKu, R.drawable.setting_item_selector);
    }

    private void cgW() {
        int i;
        int i2 = 0;
        this.iKr.setText(R.string.member_ad_setting_text);
        this.iKr.setOnSwitchStateChangeListener(this.iKq);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iKr.setVisibility(8);
            this.iKs.setVisibility(8);
        } else if (i2 == 0) {
            this.iKr.mU();
        } else {
            this.iKr.mT();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.agM().getString("sync_ad_privacy_url", ""))) {
            this.iKt.setVisibility(8);
        }
    }

    public View cgX() {
        return this.iKu;
    }

    public void cgY() {
        this.iKr.mU();
    }

    public void cgZ() {
        this.iKr.mT();
    }
}
