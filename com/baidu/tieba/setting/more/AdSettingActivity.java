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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
/* loaded from: classes3.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.a {
    private static int iKp = 0;
    private static int iKq = 1;
    private static int iKr = -1;
    private b iKn;
    private int iKo = iKr;
    private com.baidu.tbadk.core.view.b mWaitingDialog = new com.baidu.tbadk.core.view.b(getPageContext());
    private com.baidu.adp.framework.listener.a iKs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348) { // from class: com.baidu.tieba.setting.more.AdSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    AdSettingActivity.this.cgW();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    AdSettingActivity.this.cgV();
                    return;
                } else {
                    AdSettingActivity.this.showToast(responsedMessage.getErrorString());
                }
                AdSettingActivity.this.qn(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                AdSettingActivity.this.cgV();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    AdSettingActivity.this.cgV();
                    return;
                }
                AdSettingActivity.this.zD(closeAdData.aqm());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKn = new b(this);
        registerTask();
        registerListener(this.iKs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iKn.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iKn.cgY()) {
            cfO();
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    private void cfO() {
        ba.aiz().a(getPageContext(), new String[]{com.baidu.tbadk.core.sharedPref.b.agM().getString("sync_ad_privacy_url", "")}, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgV() {
        qn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(boolean z) {
        if (this.iKo == iKp) {
            this.iKn.cha();
        } else if (this.iKo == iKq) {
            this.iKn.cgZ();
        }
        if (z) {
            showToast(R.string.setdefualt_error);
        }
        this.iKo = iKr;
        this.mWaitingDialog.ef(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.iKn.cgZ();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.iKn.cha();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.iKo = iKr;
        this.mWaitingDialog.ef(false);
    }

    public void zE(int i) {
        if (this.iKo == iKr) {
            if (i == 0) {
                this.iKo = iKp;
            } else {
                this.iKo = iKq;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.it(R.string.setting_submiting);
            this.mWaitingDialog.ef(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cgW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.mebmer_close_ad_dialog_message);
        aVar.hp(R.color.cp_link_tip_d);
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.setting.more.AdSettingActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(AdSettingActivity.this.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone("site_V8.9", "pop_ups_opende/renewalfee_button_V8.9");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.AdSettingActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).afG();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.iKn != null) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                zE(1);
                return;
            }
            zE(0);
        }
    }
}
