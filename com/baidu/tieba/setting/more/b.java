package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView fEH;
    private AdSettingActivity iQM;
    private MsgSettingItemView iQN;
    private TextView iQO;
    private View iQP;
    private View iQQ;
    private TextView iQR;
    private TextView iQS;
    private TextView iQT;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iQM = adSettingActivity;
        aqv();
    }

    private void aqv() {
        this.iQM.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iQM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iQM.getPageContext().getString(R.string.ad_control_setting));
        this.iQN = (MsgSettingItemView) this.iQM.findViewById(R.id.memberAdSetting);
        this.iQN.setLineVisibility(false);
        this.iQO = (TextView) this.iQM.findViewById(R.id.memberAdTips);
        this.iQP = this.iQM.findViewById(R.id.privacyContainer);
        this.iQQ = this.iQM.findViewById(R.id.privacyItem);
        this.iQT = (TextView) this.iQM.findViewById(R.id.privacyControlText);
        this.iQR = (TextView) this.iQM.findViewById(R.id.privacyControlTipsSmall);
        this.iQR = (TextView) this.iQM.findViewById(R.id.privacyControlTipsSmall);
        this.iQS = (TextView) this.iQM.findViewById(R.id.privacyControlTips);
        this.fEH = (ImageView) this.iQM.findViewById(R.id.arrow);
        this.mParent = this.iQM.findViewById(R.id.parent);
        this.iQQ.setOnClickListener(this.iQM);
        cjO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iQM.getLayoutMode().setNightMode(i == 1);
        this.iQM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.iQO, R.color.cp_cont_b);
        am.j(this.iQS, R.color.cp_cont_b);
        am.j(this.iQT, R.color.cp_cont_b);
        am.j(this.iQR, R.color.cp_cont_c);
        am.l(this.iQO, R.color.cp_bg_line_d);
        am.c(this.fEH, (int) R.drawable.icon_arrow_gray_right_n);
        am.l(this.iQP, R.color.cp_bg_line_d);
        am.k(this.iQQ, R.drawable.setting_item_selector);
    }

    private void cjO() {
        int i;
        int i2 = 0;
        this.iQN.setText(R.string.member_ad_setting_text);
        this.iQN.setOnSwitchStateChangeListener(this.iQM);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iQN.setVisibility(8);
            this.iQO.setVisibility(8);
        } else if (i2 == 0) {
            this.iQN.nl();
        } else {
            this.iQN.nk();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.ahO().getString("sync_ad_privacy_url", ""))) {
            this.iQP.setVisibility(8);
        }
    }

    public View cjP() {
        return this.iQQ;
    }

    public void cjQ() {
        this.iQN.nl();
    }

    public void cjR() {
        this.iQN.nk();
    }
}
