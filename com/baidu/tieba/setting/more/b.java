package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.d<AdSettingActivity> {
    private ImageView jwY;
    private NavigationBar mNavigationBar;
    private View mParent;
    private AdSettingActivity nfB;
    private MsgSettingItemView nfC;
    private TextView nfD;
    private View nfE;
    private View nfF;
    private TextView nfG;
    private TextView nfH;
    private TextView nfI;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.nfB = adSettingActivity;
        bzE();
    }

    private void bzE() {
        this.nfB.setContentView(R.layout.ad_setting_activity);
        this.mNavigationBar = (NavigationBar) this.nfB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nfB.getPageContext().getString(R.string.ad_control_setting));
        this.nfC = (MsgSettingItemView) this.nfB.findViewById(R.id.memberAdSetting);
        this.nfC.setLineVisibility(false);
        this.nfD = (TextView) this.nfB.findViewById(R.id.memberAdTips);
        this.nfE = this.nfB.findViewById(R.id.privacyContainer);
        this.nfF = this.nfB.findViewById(R.id.privacyItem);
        this.nfI = (TextView) this.nfB.findViewById(R.id.privacyControlText);
        this.nfG = (TextView) this.nfB.findViewById(R.id.privacyControlTipsSmall);
        this.nfG = (TextView) this.nfB.findViewById(R.id.privacyControlTipsSmall);
        this.nfH = (TextView) this.nfB.findViewById(R.id.privacyControlTips);
        this.jwY = (ImageView) this.nfB.findViewById(R.id.arrow);
        this.mParent = this.nfB.findViewById(R.id.parent);
        this.nfF.setOnClickListener(this.nfB);
        dGB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.nfB.getLayoutMode().setNightMode(i == 1);
        this.nfB.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.nfD, R.color.CAM_X0105);
        ap.setViewTextColor(this.nfH, R.color.CAM_X0105);
        ap.setViewTextColor(this.nfI, R.color.CAM_X0105);
        ap.setViewTextColor(this.nfG, R.color.CAM_X0108);
        ap.setBackgroundColor(this.nfD, R.color.CAM_X0201);
        SvgManager.bsR().a(this.jwY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.nfE, R.color.CAM_X0201);
        ap.setBackgroundResource(this.nfF, R.drawable.setting_item_selector);
    }

    private void dGB() {
        int i;
        int i2;
        this.nfC.setText(R.string.member_ad_setting_text);
        this.nfC.setOnSwitchStateChangeListener(this.nfB);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            int memberCloseAdIsOpen = currentAccountObj.getMemberCloseAdIsOpen();
            i = currentAccountObj.getMemberCloseAdVipClose();
            i2 = memberCloseAdIsOpen;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 == 0) {
            this.nfC.setVisibility(8);
            this.nfD.setVisibility(8);
        } else if (i == 0) {
            this.nfC.turnOffNoCallback();
        } else {
            this.nfC.turnOnNoCallback();
        }
        if (TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.brQ().getString("sync_ad_privacy_url", ""))) {
            this.nfE.setVisibility(8);
        }
    }

    public View dGC() {
        return this.nfF;
    }

    public void dGD() {
        this.nfC.turnOffNoCallback();
    }

    public void dGE() {
        this.nfC.turnOnNoCallback();
    }
}
