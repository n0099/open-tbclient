package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
/* loaded from: classes26.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.a {
    private static int mUY = 0;
    private static int mUZ = 1;
    private static int mVa = -1;
    private b mUW;
    private int mUX = mVa;
    private com.baidu.tbadk.core.view.a mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
    private com.baidu.adp.framework.listener.a mVb = new com.baidu.adp.framework.listener.a(1003090, CmdConfigSocket.CMD_MEMBER_CLOSE_AD) { // from class: com.baidu.tieba.setting.more.AdSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    AdSettingActivity.this.dIr();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    AdSettingActivity.this.dIq();
                    return;
                } else {
                    AdSettingActivity.this.showToast(responsedMessage.getErrorString());
                }
                AdSettingActivity.this.xy(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                AdSettingActivity.this.dIq();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    AdSettingActivity.this.dIq();
                    return;
                }
                AdSettingActivity.this.Ka(closeAdData.bBD());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUW = new b(this);
        registerTask();
        registerListener(this.mVb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mUW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mUW.dIt()) {
            dGq();
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_CLOSE_AD, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_CLOSE_AD, 1003090, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    private void dGq() {
        bf.bua().a(getPageContext(), new String[]{com.baidu.tbadk.core.sharedPref.b.bsO().getString("sync_ad_privacy_url", "")}, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIq() {
        xy(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(boolean z) {
        if (this.mUX == mUY) {
            this.mUW.dIv();
        } else if (this.mUX == mUZ) {
            this.mUW.dIu();
        }
        if (z) {
            showToast(R.string.setdefualt_error);
        }
        this.mUX = mVa;
        this.mWaitingDialog.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.mUW.dIu();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.mUW.dIv();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.mUX = mVa;
        this.mWaitingDialog.setDialogVisiable(false);
    }

    public void Kb(int i) {
        if (this.mUX == mVa) {
            if (i == 0) {
                this.mUX = mUY;
            } else {
                this.mUX = mUZ;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(1003090, CmdConfigSocket.CMD_MEMBER_CLOSE_AD);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.setTipString(R.string.setting_submiting);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dIr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.mebmer_close_ad_dialog_message);
        aVar.oR(R.color.CAM_X0305);
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.setting.more.AdSettingActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(AdSettingActivity.this.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_SITE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.AdSettingActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).brv();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.mUW != null) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                Kb(1);
                return;
            }
            Kb(0);
        }
    }
}
