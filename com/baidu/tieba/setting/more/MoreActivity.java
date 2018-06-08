package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LabelSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private static int guJ = 0;
    private static int guK = 1;
    private static int guL = -1;
    private d guB;
    private MoreDiscoveryModel guD;
    private GetFriendAndStrangerSwitchModel guG;
    private MoreModel guC = null;
    private a guE = null;
    private com.baidu.adp.framework.listener.a guF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_USER_INFO, 303024) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getError() == 0) {
                if ((responsedMessage instanceof GetUserInfoHttpResponseMessage) || (responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                    com.baidu.tbadk.getUserInfo.a aVar = null;
                    if (responsedMessage instanceof GetUserInfoHttpResponseMessage) {
                        aVar = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                        aVar = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                    }
                    if (aVar != null && aVar.It() != null) {
                        String portrait = aVar.It().getPortrait();
                        MoreActivity.this.guB.S(p.eu(portrait), false);
                        PersonChangeData personChangeData = MoreActivity.this.guC.getPersonChangeData();
                        if (personChangeData != null) {
                            personChangeData.setPhotoChanged(true);
                            personChangeData.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eYG = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.guD != null) {
                    MoreActivity.this.guD.N(false, true);
                }
            }
        }
    };
    private CustomMessageListener diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.guD != null) {
                    MoreActivity.this.guD.N(false, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a guH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348) { // from class: com.baidu.tieba.setting.more.MoreActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    MoreActivity.this.bqY();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    MoreActivity.this.bqZ();
                    return;
                } else {
                    MoreActivity.this.showToast(responsedMessage.getErrorString());
                }
                MoreActivity.this.lV(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                MoreActivity.this.bqZ();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    MoreActivity.this.bqZ();
                    return;
                }
                MoreActivity.this.sG(closeAdData.GC());
            }
        }
    };
    private int guI = guL;
    private com.baidu.tbadk.core.view.a mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.guB = new d(this, bqK());
        D(bundle);
        aFj();
        registerListener(this.guF);
        registerTask();
        registerListener(this.guH);
        registerListener(this.eYG);
        registerListener(this.diO);
    }

    private c bqK() {
        return new c() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.c
            public void sD(int i) {
                if (i == 0) {
                    MoreActivity.this.bqV();
                } else if (i == 1) {
                    MoreActivity.this.bqU();
                } else if (i == 15) {
                    MoreActivity.this.bqS();
                } else if (i == 2) {
                    MoreActivity.this.bqT();
                } else if (i == 3) {
                    MoreActivity.this.bqR();
                } else if (i == 4) {
                    MoreActivity.this.bqW();
                } else if (i == 6) {
                    MoreActivity.this.bqQ();
                } else if (i == 7) {
                    MoreActivity.this.bqN();
                } else if (i == 8) {
                    MoreActivity.this.bqO();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.bqX();
                } else if (i == 10) {
                    MoreActivity.this.guB.brh();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    BdSocketLinkService.close("exit app");
                    com.baidu.tbadk.core.e.b.c(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.bqP();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFk();
        if (this.guB != null) {
            this.guB.YO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.guB != null) {
            this.guB.brb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.guB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.guB.bqe();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.guC.getPersonChangeData()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bqV();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    if (personChangeData != null) {
                        this.guC.setPersonChangeData(personChangeData);
                        this.guC.lU(true);
                        if (this.guD != null) {
                            bqL();
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                    bqN();
                    return;
                default:
                    return;
            }
        }
    }

    private void bqL() {
        com.baidu.tbadk.getUserInfo.b.Iu().Iv();
    }

    private void bqM() {
        if (this.guC.bqj()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.guC.getPersonChangeData());
            setResult(-1, intent);
        }
    }

    private void D(Bundle bundle) {
        PersonChangeData personChangeData = null;
        if (bundle != null) {
            String string = bundle.getString(PersonChangeData.TAG_PERSON_INFO);
            if (!StringUtils.isNull(string)) {
                personChangeData = (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class);
            }
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        }
        if (personChangeData == null) {
            this.guD = new MoreDiscoveryModel(this);
            this.guD.setUniqueId(getUniqueId());
            this.guD.setId(TbadkCoreApplication.getCurrentAccount());
            this.guD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.guD.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.guD.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.guD.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.guD.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.guD.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.guD.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.guD.getUser().getIsMem());
                        if (MoreActivity.this.guD.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.guD.getNicknameInfo().left_days.intValue());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData2));
                        MoreActivity.this.b(personChangeData2);
                    }
                }
            });
            this.guD.N(false, true);
        }
        b(personChangeData);
        this.guG = new GetFriendAndStrangerSwitchModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.guB.S(p.eu(personChangeData.getPortrait()), false);
        }
        this.guC = new MoreModel(personChangeData);
        this.guC.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        MoreActivity.this.showToast(MoreActivity.this.getPageContext().getString(d.k.image_cash_del_suc));
                    }
                    MoreActivity.this.closeLoadingDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.guB.brb();
        }
    }

    private void aFj() {
        this.guE = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.guE, intentFilter);
    }

    private void aFk() {
        if (this.guE != null) {
            unregisterReceiver(this.guE);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.guB != null) {
            if (view == this.guB.bri()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (com.baidu.tbadk.core.util.g.ya()) {
                        getWindow().setNavigationBarColor(getResources().getColor(d.C0141d.cp_bg_line_d_1));
                    }
                    this.guB.sI(1);
                    return;
                }
                if (com.baidu.tbadk.core.util.g.ya()) {
                    getWindow().setNavigationBarColor(getResources().getColor(d.C0141d.cp_bg_line_d));
                }
                this.guB.sI(0);
            } else if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                sH(1);
            } else {
                sH(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqN() {
        ay.zG().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        String str;
        String str2 = TbConfig.RECOMMEND_APP_ADDRESS;
        if (str2.indexOf("?") < 0) {
            str2 = str2 + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = str2 + "&";
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            str = str2 + "night_type=1";
        } else {
            str = str2 + "night_type=0";
        }
        sendMessage(new CustomMessage(2002001, new AppsActivityConfig(getPageContext().getPageActivity(), str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqP() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.ame, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqR() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        TiebaStatic.log(new am("c12236").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage(2002001, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.tD() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(d.k.login_manage_account), (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.guC.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqV() {
        bqM();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqW() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void bqY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.k.mebmer_close_ad_dialog_message);
        aVar.cd(d.C0141d.cp_link_tip_d);
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MoreActivity.this.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone("site_V8.9", "pop_ups_opende/renewalfee_button_V8.9");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xa();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqZ() {
        lV(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        if (this.guI == guJ) {
            this.guB.brf();
        } else if (this.guI == guK) {
            this.guB.bre();
        }
        if (z) {
            showToast(d.k.setdefualt_error);
        }
        this.guI = guL;
        this.mWaitingDialog.aM(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.guB.bre();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.guB.brf();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.guI = guL;
        this.mWaitingDialog.aM(false);
    }

    public void sH(int i) {
        if (this.guI == guL) {
            if (i == 0) {
                this.guI = guJ;
            } else {
                this.guI = guK;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.dc(d.k.setting_submiting);
            this.mWaitingDialog.aM(true);
        }
    }
}
