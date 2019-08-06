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
    private ImageView fFv;
    private AdSettingActivity iRQ;
    private MsgSettingItemView iRR;
    private TextView iRS;
    private View iRT;
    private View iRU;
    private TextView iRV;
    private TextView iRW;
    private TextView iRX;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.iRQ = adSettingActivity;
        aqx();
    }

    private void aqx() {
        this.iRQ.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iRQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iRQ.getPageContext().getString(R.string.ad_control_setting));
        this.iRR = (MsgSettingItemView) this.iRQ.findViewById(R.id.memberAdSetting);
        this.iRR.setLineVisibility(false);
        this.iRS = (TextView) this.iRQ.findViewById(R.id.memberAdTips);
        this.iRT = this.iRQ.findViewById(R.id.privacyContainer);
        this.iRU = this.iRQ.findViewById(R.id.privacyItem);
        this.iRX = (TextView) this.iRQ.findViewById(R.id.privacyControlText);
        this.iRV = (TextView) this.iRQ.findViewById(R.id.privacyControlTipsSmall);
        this.iRV = (TextView) this.iRQ.findViewById(R.id.privacyControlTipsSmall);
        this.iRW = (TextView) this.iRQ.findViewById(R.id.privacyControlTips);
        this.fFv = (ImageView) this.iRQ.findViewById(R.id.arrow);
        this.mParent = this.iRQ.findViewById(R.id.parent);
        this.iRU.setOnClickListener(this.iRQ);
        ckg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iRQ.getLayoutMode().setNightMode(i == 1);
        this.iRQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.iRS, R.color.cp_cont_b);
        am.j(this.iRW, R.color.cp_cont_b);
        am.j(this.iRX, R.color.cp_cont_b);
        am.j(this.iRV, R.color.cp_cont_c);
        am.l(this.iRS, R.color.cp_bg_line_d);
        am.c(this.fFv, (int) R.drawable.icon_arrow_gray_right_n);
        am.l(this.iRT, R.color.cp_bg_line_d);
        am.k(this.iRU, R.drawable.setting_item_selector);
    }

    private void ckg() {
        int i;
        int i2 = 0;
        this.iRR.setText(R.string.member_ad_setting_text);
        this.iRR.setOnSwitchStateChangeListener(this.iRQ);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.iRR.setVisibility(8);
            this.iRS.setVisibility(8);
        } else if (i2 == 0) {
            this.iRR.nl();
        } else {
            this.iRR.nk();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("sync_ad_privacy_url", ""))) {
            this.iRT.setVisibility(8);
        }
    }

    public View ckh() {
        return this.iRU;
    }

    public void cki() {
        this.iRR.nl();
    }

    public void ckj() {
        this.iRR.nk();
    }
}
