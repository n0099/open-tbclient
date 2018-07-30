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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.play.x;
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
    private static int gzJ = 0;
    private static int gzK = 1;
    private static int gzL = -1;
    private d gzB;
    private MoreDiscoveryModel gzD;
    private GetFriendAndStrangerSwitchModel gzG;
    private MoreModel gzC = null;
    private a gzE = null;
    private com.baidu.adp.framework.listener.a gzF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_USER_INFO, 303024) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.IG() != null) {
                        String portrait = aVar.IG().getPortrait();
                        MoreActivity.this.gzB.S(p.ev(portrait), false);
                        PersonChangeData personChangeData = MoreActivity.this.gzC.getPersonChangeData();
                        if (personChangeData != null) {
                            personChangeData.setPhotoChanged(true);
                            personChangeData.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener fbP = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.gzD != null) {
                    MoreActivity.this.gzD.Q(false, true);
                }
            }
        }
    };
    private CustomMessageListener dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.gzD != null) {
                    MoreActivity.this.gzD.Q(false, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gzH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348) { // from class: com.baidu.tieba.setting.more.MoreActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    MoreActivity.this.bqc();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    MoreActivity.this.bqd();
                    return;
                } else {
                    MoreActivity.this.showToast(responsedMessage.getErrorString());
                }
                MoreActivity.this.lR(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                MoreActivity.this.bqd();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    MoreActivity.this.bqd();
                    return;
                }
                MoreActivity.this.sO(closeAdData.GQ());
            }
        }
    };
    private int gzI = gzL;
    private com.baidu.tbadk.core.view.a mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gzB = new d(this, bpO());
        D(bundle);
        aGR();
        registerListener(this.gzF);
        registerTask();
        registerListener(this.gzH);
        registerListener(this.fbP);
        registerListener(this.dnF);
    }

    private c bpO() {
        return new c() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.c
            public void sL(int i) {
                if (i == 0) {
                    MoreActivity.this.bpZ();
                } else if (i == 1) {
                    MoreActivity.this.bpY();
                } else if (i == 15) {
                    MoreActivity.this.bpW();
                } else if (i == 2) {
                    MoreActivity.this.bpX();
                } else if (i == 3) {
                    MoreActivity.this.bpV();
                } else if (i == 4) {
                    MoreActivity.this.bqa();
                } else if (i == 6) {
                    MoreActivity.this.bpU();
                } else if (i == 7) {
                    MoreActivity.this.bpR();
                } else if (i == 8) {
                    MoreActivity.this.bpS();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.bqb();
                } else if (i == 10) {
                    MoreActivity.this.gzB.bql();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    BdSocketLinkService.close("exit app");
                    x.bkW().clear();
                    com.baidu.tbadk.core.e.b.c(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.bpT();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aGS();
        if (this.gzB != null) {
            this.gzB.ZB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gzB != null) {
            this.gzB.bqf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gzB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.gzB.bpi();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.gzC.getPersonChangeData()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bpZ();
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
                        this.gzC.setPersonChangeData(personChangeData);
                        this.gzC.lQ(true);
                        if (this.gzD != null) {
                            bpP();
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                    bpR();
                    return;
                default:
                    return;
            }
        }
    }

    private void bpP() {
        com.baidu.tbadk.getUserInfo.b.IH().II();
    }

    private void bpQ() {
        if (this.gzC.bpn()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gzC.getPersonChangeData());
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
            this.gzD = new MoreDiscoveryModel(this);
            this.gzD.setUniqueId(getUniqueId());
            this.gzD.setId(TbadkCoreApplication.getCurrentAccount());
            this.gzD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.gzD.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.gzD.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.gzD.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.gzD.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.gzD.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.gzD.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.gzD.getUser().getIsMem());
                        if (MoreActivity.this.gzD.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.gzD.getNicknameInfo().left_days.intValue());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData2));
                        MoreActivity.this.b(personChangeData2);
                    }
                }
            });
            this.gzD.Q(false, true);
        }
        b(personChangeData);
        this.gzG = new GetFriendAndStrangerSwitchModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.gzB.S(p.ev(personChangeData.getPortrait()), false);
        }
        this.gzC = new MoreModel(personChangeData);
        this.gzC.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        MoreActivity.this.showToast(MoreActivity.this.getPageContext().getString(d.j.image_cash_del_suc));
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
            MoreActivity.this.gzB.bqf();
        }
    }

    private void aGR() {
        this.gzE = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gzE, intentFilter);
    }

    private void aGS() {
        if (this.gzE != null) {
            unregisterReceiver(this.gzE);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.gzB != null) {
            if (view == this.gzB.bqm()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(d.C0140d.cp_bg_line_d_1));
                    this.gzB.sQ(1);
                    return;
                }
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(d.C0140d.cp_bg_line_d));
                this.gzB.sQ(0);
            } else if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                sP(1);
            } else {
                sP(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpR() {
        ay.zK().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpS() {
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
    public void bpT() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.ame, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpU() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpV() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        TiebaStatic.log(new an("c12236").af("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage(2002001, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.tp() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpY() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.gzC.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpZ() {
        bpQ();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqa() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqb() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void bqc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(d.j.mebmer_close_ad_dialog_message);
        aVar.cg(d.C0140d.cp_link_tip_d);
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MoreActivity.this.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone("site_V8.9", "pop_ups_opende/renewalfee_button_V8.9");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xf();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqd() {
        lR(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(boolean z) {
        if (this.gzI == gzJ) {
            this.gzB.bqj();
        } else if (this.gzI == gzK) {
            this.gzB.bqi();
        }
        if (z) {
            showToast(d.j.setdefualt_error);
        }
        this.gzI = gzL;
        this.mWaitingDialog.aM(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sO(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.gzB.bqi();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.gzB.bqj();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.gzI = gzL;
        this.mWaitingDialog.aM(false);
    }

    public void sP(int i) {
        if (this.gzI == gzL) {
            if (i == 0) {
                this.gzI = gzJ;
            } else {
                this.gzI = gzK;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.df(d.j.setting_submiting);
            this.mWaitingDialog.aM(true);
        }
    }
}
