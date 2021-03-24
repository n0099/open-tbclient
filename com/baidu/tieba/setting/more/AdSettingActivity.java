package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.b {
    public static int NO_SET_MEMBER_CLOSE_AD = -1;
    public static int SET_MEMBER_CLOSE_AD_FALSE = 0;
    public static int SET_MEMBER_CLOSE_AD_TRUE = 1;
    public d.b.i0.u2.c.b mView;
    public int mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
    public d.b.h0.r.f0.a mWaitingDialog = new d.b.h0.r.f0.a(getPageContext());
    public d.b.b.c.g.a mMemberCloseAdListener = new c(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(AdSettingActivity.this.getPageContext().getPageActivity(), 2, "", 20);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_SITE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.b.c.g.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    AdSettingActivity.this.showMemberDialog();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    AdSettingActivity.this.setMemberCloseAdFail();
                    return;
                } else {
                    AdSettingActivity.this.showToast(responsedMessage.getErrorString());
                }
                AdSettingActivity.this.setMemberCloseAdFail(false);
                return;
            }
            boolean z = responsedMessage instanceof MemberCloseAdHttpResponseMessage;
            if (!z && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                AdSettingActivity.this.setMemberCloseAdFail();
                return;
            }
            CloseAdData closeAdData = null;
            if (z) {
                closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
            } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
            }
            if (closeAdData == null) {
                AdSettingActivity.this.setMemberCloseAdFail();
                return;
            }
            AdSettingActivity.this.setMemberCloseAdSuccess(closeAdData.t());
        }
    }

    private void goToPrivacyControl() {
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{d.b.h0.r.d0.b.i().o("sync_ad_privacy_url", "")}, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdFail() {
        setMemberCloseAdFail(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdSuccess(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.mView.h();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.mView.i();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
        this.mWaitingDialog.h(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void showMemberDialog() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessageId(R.string.mebmer_close_ad_dialog_message);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setPositiveButton(R.string.open_now, new a());
        aVar.setNegativeButton(R.string.cancel, new b());
        aVar.create(getPageContext()).show();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == null || this.mView == null) {
            return;
        }
        if (BdSwitchView.SwitchState.ON == switchState) {
            TiebaStatic.log("c11143");
            sendMessageToCloseAd(1);
            return;
        }
        sendMessageToCloseAd(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mView.d()) {
            goToPrivacyControl();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.b.i0.u2.c.b(this);
        registerTask();
        registerListener(this.mMemberCloseAdListener);
    }

    public void registerTask() {
        d.b.i0.c3.d0.a.h(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    public void sendMessageToCloseAd(int i) {
        if (this.mMemberCloseAdSettingState != NO_SET_MEMBER_CLOSE_AD) {
            return;
        }
        if (i == 0) {
            this.mMemberCloseAdSettingState = SET_MEMBER_CLOSE_AD_FALSE;
        } else {
            this.mMemberCloseAdSettingState = SET_MEMBER_CLOSE_AD_TRUE;
        }
        MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
        memberCloseAdRequestMessage.setVipClose(i);
        MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
        this.mWaitingDialog.i(R.string.setting_submiting);
        this.mWaitingDialog.h(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdFail(boolean z) {
        int i = this.mMemberCloseAdSettingState;
        if (i == SET_MEMBER_CLOSE_AD_FALSE) {
            this.mView.i();
        } else if (i == SET_MEMBER_CLOSE_AD_TRUE) {
            this.mView.h();
        }
        if (z) {
            showToast(R.string.setdefualt_error);
        }
        this.mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
        this.mWaitingDialog.h(false);
    }
}
