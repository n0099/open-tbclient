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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.play.y;
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
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private static int gWJ = 0;
    private static int gWK = 1;
    private static int gWL = -1;
    private d gWB;
    private MoreDiscoveryModel gWD;
    private GetFriendAndStrangerSwitchModel gWG;
    private MoreModel gWC = null;
    private a gWE = null;
    private com.baidu.adp.framework.listener.a gWF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_USER_INFO, 303024) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.Nk() != null) {
                        String portrait = aVar.Nk().getPortrait();
                        MoreActivity.this.gWB.ac(o.fu(portrait), false);
                        PersonChangeData personChangeData = MoreActivity.this.gWC.getPersonChangeData();
                        if (personChangeData != null) {
                            personChangeData.setPhotoChanged(true);
                            personChangeData.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener fyV = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.gWD != null) {
                    MoreActivity.this.gWD.V(false, true);
                }
            }
        }
    };
    private CustomMessageListener dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.gWD != null) {
                    MoreActivity.this.gWD.V(false, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gWH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348) { // from class: com.baidu.tieba.setting.more.MoreActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    MoreActivity.this.bxk();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    MoreActivity.this.bxl();
                    return;
                } else {
                    MoreActivity.this.showToast(responsedMessage.getErrorString());
                }
                MoreActivity.this.mU(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                MoreActivity.this.bxl();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    MoreActivity.this.bxl();
                    return;
                }
                MoreActivity.this.uw(closeAdData.Lv());
            }
        }
    };
    private int gWI = gWL;
    private com.baidu.tbadk.core.view.d mWaitingDialog = new com.baidu.tbadk.core.view.d(getPageContext());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gWB = new d(this, bwW());
        K(bundle);
        aNK();
        registerListener(this.gWF);
        registerTask();
        registerListener(this.gWH);
        registerListener(this.fyV);
        registerListener(this.dJs);
    }

    private c bwW() {
        return new c() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.c
            public void ut(int i) {
                if (i == 0) {
                    MoreActivity.this.bxh();
                } else if (i == 1) {
                    MoreActivity.this.bxg();
                } else if (i == 15) {
                    MoreActivity.this.bxe();
                } else if (i == 2) {
                    MoreActivity.this.bxf();
                } else if (i == 3) {
                    MoreActivity.this.bxd();
                } else if (i == 4) {
                    MoreActivity.this.bxi();
                } else if (i == 6) {
                    MoreActivity.this.bxc();
                } else if (i == 7) {
                    MoreActivity.this.bwZ();
                } else if (i == 8) {
                    MoreActivity.this.bxa();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.bxj();
                } else if (i == 10) {
                    MoreActivity.this.gWB.bxt();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    com.baidu.tbadk.lcs.a.b(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    y.bsd().clear();
                    com.baidu.tbadk.core.e.b.d(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.bxb();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aNL();
        if (this.gWB != null) {
            this.gWB.Tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gWB != null) {
            this.gWB.bxn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gWB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.gWB.bwv();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.gWC.getPersonChangeData()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bxh();
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
                        this.gWC.setPersonChangeData(personChangeData);
                        this.gWC.mT(true);
                        if (this.gWD != null) {
                            bwX();
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                    bwZ();
                    return;
                default:
                    return;
            }
        }
    }

    private void bwX() {
        com.baidu.tbadk.getUserInfo.b.Nl().Nm();
    }

    private void bwY() {
        if (this.gWC.bwz()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gWC.getPersonChangeData());
            setResult(-1, intent);
        }
    }

    private void K(Bundle bundle) {
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
            this.gWD = new MoreDiscoveryModel(this);
            this.gWD.setUniqueId(getUniqueId());
            this.gWD.setId(TbadkCoreApplication.getCurrentAccount());
            this.gWD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.gWD.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.gWD.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.gWD.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.gWD.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.gWD.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.gWD.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.gWD.getUser().getIsMem());
                        if (MoreActivity.this.gWD.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.gWD.getNicknameInfo().left_days.intValue());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData2));
                        MoreActivity.this.b(personChangeData2);
                    }
                }
            });
            this.gWD.V(false, true);
        }
        b(personChangeData);
        this.gWG = new GetFriendAndStrangerSwitchModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.gWB.ac(o.fu(personChangeData.getPortrait()), false);
        }
        this.gWC = new MoreModel(personChangeData);
        this.gWC.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        MoreActivity.this.showToast(MoreActivity.this.getPageContext().getString(e.j.image_cash_del_suc));
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
            MoreActivity.this.gWB.bxn();
        }
    }

    private void aNK() {
        this.gWE = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gWE, intentFilter);
    }

    private void aNL() {
        if (this.gWE != null) {
            unregisterReceiver(this.gWE);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.gWB != null) {
            if (view == this.gWB.bxu()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.showSkinChangeAnimation(this);
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(e.d.cp_bg_line_d_1));
                    this.gWB.uy(1);
                    return;
                }
                UtilHelper.showSkinChangeAnimation(this);
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(e.d.cp_bg_line_d));
                this.gWB.uy(0);
            } else if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                ux(1);
            } else {
                ux(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwZ() {
        ay.Ef().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        String str;
        String str2 = TbConfig.RECOMMEND_APP_ADDRESS;
        if (str2.indexOf("?") < 0) {
            str2 = str2 + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith(ETAG.ITEM_SEPARATOR)) {
            str2 = str2 + ETAG.ITEM_SEPARATOR;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            str = str2 + "night_type=1";
        } else {
            str = str2 + "night_type=0";
        }
        sendMessage(new CustomMessage(2002001, new AppsActivityConfig(getPageContext().getPageActivity(), str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.axP, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxd() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxe() {
        TiebaStatic.log(new am("c12236").aA("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage(2002001, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.xM() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxg() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.gWC.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxh() {
        bwY();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxi() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxj() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void bxk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.mebmer_close_ad_dialog_message);
        aVar.dc(e.d.cp_link_tip_d);
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MoreActivity.this.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone("site_V8.9", "pop_ups_opende/renewalfee_button_V8.9");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.MoreActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).BF();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxl() {
        mU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        if (this.gWI == gWJ) {
            this.gWB.bxr();
        } else if (this.gWI == gWK) {
            this.gWB.bxq();
        }
        if (z) {
            showToast(e.j.setdefualt_error);
        }
        this.gWI = gWL;
        this.mWaitingDialog.bA(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.gWB.bxq();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.gWB.bxr();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.gWI = gWL;
        this.mWaitingDialog.bA(false);
    }

    public void ux(int i) {
        if (this.gWI == gWL) {
            if (i == 0) {
                this.gWI = gWJ;
            } else {
                this.gWI = gWK;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.ec(e.j.setting_submiting);
            this.mWaitingDialog.bA(true);
        }
    }
}
