package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<AdSettingActivity> {
    private ImageView dVs;
    private AdSettingActivity gZa;
    private MsgSettingItemView gZb;
    private TextView gZc;
    private View gZd;
    private View gZe;
    private TextView gZf;
    private TextView gZg;
    private TextView gZh;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.gZa = adSettingActivity;
        Ky();
    }

    private void Ky() {
        this.gZa.setContentView(e.h.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gZa.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gZa.getPageContext().getString(e.j.ad_control_setting));
        this.gZb = (MsgSettingItemView) this.gZa.findViewById(e.g.memberAdSetting);
        this.gZb.setLineVisibility(false);
        this.gZc = (TextView) this.gZa.findViewById(e.g.memberAdTips);
        this.gZd = this.gZa.findViewById(e.g.privacyContainer);
        this.gZe = this.gZa.findViewById(e.g.privacyItem);
        this.gZh = (TextView) this.gZa.findViewById(e.g.privacyControlText);
        this.gZf = (TextView) this.gZa.findViewById(e.g.privacyControlTipsSmall);
        this.gZf = (TextView) this.gZa.findViewById(e.g.privacyControlTipsSmall);
        this.gZg = (TextView) this.gZa.findViewById(e.g.privacyControlTips);
        this.dVs = (ImageView) this.gZa.findViewById(e.g.arrow);
        this.mParent = this.gZa.findViewById(e.g.parent);
        this.gZe.setOnClickListener(this.gZa);
        bxu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gZa.getLayoutMode().setNightMode(i == 1);
        this.gZa.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.gZc, e.d.cp_cont_b);
        al.h(this.gZg, e.d.cp_cont_b);
        al.h(this.gZh, e.d.cp_cont_b);
        al.h(this.gZf, e.d.cp_cont_c);
        al.j(this.gZc, e.d.cp_bg_line_d);
        al.c(this.dVs, e.f.icon_arrow_gray_right_n);
        al.j(this.gZd, e.d.cp_bg_line_d);
        al.i(this.gZe, e.f.setting_item_selector);
    }

    private void bxu() {
        int i;
        int i2 = 0;
        this.gZb.setText(e.j.member_ad_setting_text);
        this.gZb.setOnSwitchStateChangeListener(this.gZa);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gZb.setVisibility(8);
            this.gZc.setVisibility(8);
        } else if (i2 == 0) {
            this.gZb.nQ();
        } else {
            this.gZb.nP();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_ad_privacy_url", ""))) {
            this.gZd.setVisibility(8);
        }
    }

    public View bxv() {
        return this.gZe;
    }

    public void bxw() {
        this.gZb.nQ();
    }

    public void bxx() {
        this.gZb.nP();
    }
}
