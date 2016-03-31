package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.MemberCloseAdHttpResponseMessage;
import com.baidu.tbadk.data.MemberCloseAdRequestMessage;
import com.baidu.tbadk.data.MemberCloseAdSocketResponseMessage;
import com.baidu.tieba.setting.AboutActivityConfig;
import com.baidu.tieba.setting.AccountSafeSettingActivityConfig;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private static int edb = 0;
    private static int edc = 1;
    private static int edd = -1;
    private aa ecU;
    private com.baidu.tieba.setting.model.c ecW;
    private MoreModel ecV = null;
    private a ecX = null;
    private com.baidu.adp.framework.listener.a ecY = new t(this, CmdConfigHttp.CMD_GET_USER_INFO, 303024);
    private com.baidu.adp.framework.listener.a ecZ = new u(this, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
    private int eda = edd;
    private com.baidu.tbadk.core.view.b bbk = new com.baidu.tbadk.core.view.b(getPageContext());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ecU = new aa(this, aNT());
        r(bundle);
        KL();
        registerListener(this.ecY);
        EH();
        registerListener(this.ecZ);
    }

    private s aNT() {
        return new v(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        abL();
        if (this.ecU != null) {
            this.ecU.aOm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ecU != null) {
            this.ecU.refreshNewVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ecU.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.ecU.aNi();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, this.ecV.getPersonChangeData());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aOb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    if (personChangeData != null) {
                        this.ecV.setPersonChangeData(personChangeData);
                        this.ecV.im(true);
                        if (this.ecW != null) {
                            aCP();
                            return;
                        }
                        return;
                    }
                    return;
                case 12008:
                    Vj();
                    return;
                default:
                    return;
            }
        }
    }

    private void aCP() {
        com.baidu.tbadk.getUserInfo.b.EG().EI();
    }

    private void aNU() {
        if (this.ecV.aNn()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ecV.getPersonChangeData());
            setResult(-1, intent);
        }
    }

    private void r(Bundle bundle) {
        PersonChangeData personChangeData;
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable(PersonChangeData.TAG_PERSON_INFO);
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        }
        if (personChangeData == null) {
            this.ecW = new com.baidu.tieba.setting.model.c(this);
            this.ecW.setUniqueId(getUniqueId());
            this.ecW.setId(TbadkCoreApplication.getCurrentAccount());
            this.ecW.setLoadDataCallBack(new w(this));
            this.ecW.x(true, true);
        }
        b(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.ecU.H(personChangeData.getPortrait(), false);
        }
        this.ecV = new MoreModel(personChangeData);
        this.ecV.setLoadDataCallBack(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(MoreActivity moreActivity, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.ecU.refreshNewVersion();
        }
    }

    private void KL() {
        this.ecX = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ecX, intentFilter);
    }

    private void abL() {
        if (this.ecX != null) {
            unregisterReceiver(this.ecX);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (BdSwitchView.SwitchState.ON == switchState) {
            TiebaStatic.log("c11143");
            oU(1);
            return;
        }
        oU(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        bg.wM().c(getPageContext(), new String[]{"feedback:"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNV() {
        String str;
        String str2 = TbConfig.RECOMMEND_APP_ADDRESS;
        if (str2.indexOf("?") < 0) {
            str2 = String.valueOf(str2) + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = String.valueOf(str2) + "&";
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            str = String.valueOf(str2) + "night_type=1";
        } else {
            str = String.valueOf(str2) + "night_type=0";
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AppsActivityConfig(getPageContext().getPageActivity(), str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNW() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountSafeSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNX() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNY() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.qP() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(t.j.login_manage_account), 11003)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOa() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.ecV.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOb() {
        aNU();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOc() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOd() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(t.j.mebmer_close_ad_dialog_message);
        aVar.cb(t.d.cp_link_tip_d);
        aVar.a(t.j.open_now, new y(this));
        aVar.b(t.j.cancel, new z(this));
        aVar.b(getPageContext()).up();
    }

    public void EH() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOf() {
        io(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(boolean z) {
        if (this.eda == edb) {
            this.ecU.aOj();
        } else if (this.eda == edc) {
            this.ecU.aOi();
        }
        if (z) {
            showToast(t.j.setdefualt_error);
        }
        this.eda = edd;
        this.bbk.ay(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oT(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.ecU.aOi();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.ecU.aOj();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.eda = edd;
        this.bbk.ay(false);
    }

    public void oU(int i) {
        if (this.eda == edd) {
            if (i == 0) {
                this.eda = edb;
            } else {
                this.eda = edc;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.bbk.cY(t.j.setting_submiting);
            this.bbk.ay(true);
        }
    }
}
