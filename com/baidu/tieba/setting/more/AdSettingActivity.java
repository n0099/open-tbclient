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
/* loaded from: classes8.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.a {
    private static int nfW = 0;
    private static int nfX = 1;
    private static int nfY = -1;
    private b nfU;
    private int nfV = nfY;
    private com.baidu.tbadk.core.view.a mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
    private com.baidu.adp.framework.listener.a nfZ = new com.baidu.adp.framework.listener.a(1003090, CmdConfigSocket.CMD_MEMBER_CLOSE_AD) { // from class: com.baidu.tieba.setting.more.AdSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    AdSettingActivity.this.dGI();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    AdSettingActivity.this.dGH();
                    return;
                } else {
                    AdSettingActivity.this.showToast(responsedMessage.getErrorString());
                }
                AdSettingActivity.this.xO(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                AdSettingActivity.this.dGH();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    AdSettingActivity.this.dGH();
                    return;
                }
                AdSettingActivity.this.IH(closeAdData.bAx());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nfU = new b(this);
        registerTask();
        registerListener(this.nfZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nfU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nfU.dGK()) {
            dEF();
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_CLOSE_AD, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_CLOSE_AD, 1003090, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    private void dEF() {
        bf.bsV().a(getPageContext(), new String[]{com.baidu.tbadk.core.sharedPref.b.brQ().getString("sync_ad_privacy_url", "")}, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGH() {
        xO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(boolean z) {
        if (this.nfV == nfW) {
            this.nfU.dGM();
        } else if (this.nfV == nfX) {
            this.nfU.dGL();
        }
        if (z) {
            showToast(R.string.setdefualt_error);
        }
        this.nfV = nfY;
        this.mWaitingDialog.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IH(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.nfU.dGL();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.nfU.dGM();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.nfV = nfY;
        this.mWaitingDialog.setDialogVisiable(false);
    }

    public void II(int i) {
        if (this.nfV == nfY) {
            if (i == 0) {
                this.nfV = nfW;
            } else {
                this.nfV = nfX;
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
    public void dGI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nx(R.string.mebmer_close_ad_dialog_message);
        aVar.ny(R.color.CAM_X0305);
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
        aVar.b(getPageContext()).bqx();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.nfU != null) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                II(1);
                return;
            }
            II(0);
        }
    }
}
