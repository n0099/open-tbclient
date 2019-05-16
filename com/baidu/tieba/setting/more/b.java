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
    private ImageView fzI;
    private AdSettingActivity iKo;
    private MsgSettingItemView iKp;
    private TextView iKq;
    private View iKr;
    private View iKs;
    private TextView iKt;
    private TextView iKu;
    private TextView iKv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iKo = adSettingActivity;
        apq();
    }

    private void apq() {
        this.iKo.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKo.getPageContext().getString(R.string.ad_control_setting));
        this.iKp = (MsgSettingItemView) this.iKo.findViewById(R.id.memberAdSetting);
        this.iKp.setLineVisibility(false);
        this.iKq = (TextView) this.iKo.findViewById(R.id.memberAdTips);
        this.iKr = this.iKo.findViewById(R.id.privacyContainer);
        this.iKs = this.iKo.findViewById(R.id.privacyItem);
        this.iKv = (TextView) this.iKo.findViewById(R.id.privacyControlText);
        this.iKt = (TextView) this.iKo.findViewById(R.id.privacyControlTipsSmall);
        this.iKt = (TextView) this.iKo.findViewById(R.id.privacyControlTipsSmall);
        this.iKu = (TextView) this.iKo.findViewById(R.id.privacyControlTips);
        this.fzI = (ImageView) this.iKo.findViewById(R.id.arrow);
        this.mParent = this.iKo.findViewById(R.id.parent);
        this.iKs.setOnClickListener(this.iKo);
        cgU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iKo.getLayoutMode().setNightMode(i == 1);
        this.iKo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.iKq, R.color.cp_cont_b);
        al.j(this.iKu, R.color.cp_cont_b);
        al.j(this.iKv, R.color.cp_cont_b);
        al.j(this.iKt, R.color.cp_cont_c);
        al.l(this.iKq, R.color.cp_bg_line_d);
        al.c(this.fzI, (int) R.drawable.icon_arrow_gray_right_n);
        al.l(this.iKr, R.color.cp_bg_line_d);
        al.k(this.iKs, R.drawable.setting_item_selector);
    }

    private void cgU() {
        int i;
        int i2 = 0;
        this.iKp.setText(R.string.member_ad_setting_text);
        this.iKp.setOnSwitchStateChangeListener(this.iKo);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iKp.setVisibility(8);
            this.iKq.setVisibility(8);
        } else if (i2 == 0) {
            this.iKp.mU();
        } else {
            this.iKp.mT();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.agM().getString("sync_ad_privacy_url", ""))) {
            this.iKr.setVisibility(8);
        }
    }

    public View cgV() {
        return this.iKs;
    }

    public void cgW() {
        this.iKp.mU();
    }

    public void cgX() {
        this.iKp.mT();
    }
}
