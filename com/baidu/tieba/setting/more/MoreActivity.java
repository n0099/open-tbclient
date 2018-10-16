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
    private static int gOt = 0;
    private static int gOu = 1;
    private static int gOv = -1;
    private d gOl;
    private MoreDiscoveryModel gOn;
    private GetFriendAndStrangerSwitchModel gOq;
    private MoreModel gOm = null;
    private a gOo = null;
    private com.baidu.adp.framework.listener.a gOp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_USER_INFO, 303024) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.LU() != null) {
                        String portrait = aVar.LU().getPortrait();
                        MoreActivity.this.gOl.aa(o.fc(portrait), false);
                        PersonChangeData personChangeData = MoreActivity.this.gOm.getPersonChangeData();
                        if (personChangeData != null) {
                            personChangeData.setPhotoChanged(true);
                            personChangeData.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener fqO = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.gOn != null) {
                    MoreActivity.this.gOn.T(false, true);
                }
            }
        }
    };
    private CustomMessageListener dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.gOn != null) {
                    MoreActivity.this.gOn.T(false, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gOr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348) { // from class: com.baidu.tieba.setting.more.MoreActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 1990043) {
                    MoreActivity.this.bvV();
                } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    MoreActivity.this.bvW();
                    return;
                } else {
                    MoreActivity.this.showToast(responsedMessage.getErrorString());
                }
                MoreActivity.this.mG(false);
            } else if (!(responsedMessage instanceof MemberCloseAdHttpResponseMessage) && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                MoreActivity.this.bvW();
            } else {
                CloseAdData closeAdData = null;
                if (responsedMessage instanceof MemberCloseAdHttpResponseMessage) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    MoreActivity.this.bvW();
                    return;
                }
                MoreActivity.this.tJ(closeAdData.Kf());
            }
        }
    };
    private int gOs = gOv;
    private com.baidu.tbadk.core.view.d mWaitingDialog = new com.baidu.tbadk.core.view.d(getPageContext());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gOl = new d(this, bvH());
        E(bundle);
        aMu();
        registerListener(this.gOp);
        registerTask();
        registerListener(this.gOr);
        registerListener(this.fqO);
        registerListener(this.dBC);
    }

    private c bvH() {
        return new c() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.c
            public void tG(int i) {
                if (i == 0) {
                    MoreActivity.this.bvS();
                } else if (i == 1) {
                    MoreActivity.this.bvR();
                } else if (i == 15) {
                    MoreActivity.this.bvP();
                } else if (i == 2) {
                    MoreActivity.this.bvQ();
                } else if (i == 3) {
                    MoreActivity.this.bvO();
                } else if (i == 4) {
                    MoreActivity.this.bvT();
                } else if (i == 6) {
                    MoreActivity.this.bvN();
                } else if (i == 7) {
                    MoreActivity.this.bvK();
                } else if (i == 8) {
                    MoreActivity.this.bvL();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.bvU();
                } else if (i == 10) {
                    MoreActivity.this.gOl.bwe();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    BdSocketLinkService.close("exit app");
                    y.bqO().clear();
                    com.baidu.tbadk.core.e.b.d(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.bvM();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aMv();
        if (this.gOl != null) {
            this.gOl.RM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gOl != null) {
            this.gOl.bvY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gOl.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.gOl.bvg();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.gOm.getPersonChangeData()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bvS();
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
                        this.gOm.setPersonChangeData(personChangeData);
                        this.gOm.mF(true);
                        if (this.gOn != null) {
                            bvI();
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                    bvK();
                    return;
                default:
                    return;
            }
        }
    }

    private void bvI() {
        com.baidu.tbadk.getUserInfo.b.LV().LW();
    }

    private void bvJ() {
        if (this.gOm.bvk()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gOm.getPersonChangeData());
            setResult(-1, intent);
        }
    }

    private void E(Bundle bundle) {
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
            this.gOn = new MoreDiscoveryModel(this);
            this.gOn.setUniqueId(getUniqueId());
            this.gOn.setId(TbadkCoreApplication.getCurrentAccount());
            this.gOn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.gOn.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.gOn.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.gOn.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.gOn.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.gOn.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.gOn.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.gOn.getUser().getIsMem());
                        if (MoreActivity.this.gOn.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.gOn.getNicknameInfo().left_days.intValue());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData2));
                        MoreActivity.this.b(personChangeData2);
                    }
                }
            });
            this.gOn.T(false, true);
        }
        b(personChangeData);
        this.gOq = new GetFriendAndStrangerSwitchModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.gOl.aa(o.fc(personChangeData.getPortrait()), false);
        }
        this.gOm = new MoreModel(personChangeData);
        this.gOm.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
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
            MoreActivity.this.gOl.bvY();
        }
    }

    private void aMu() {
        this.gOo = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gOo, intentFilter);
    }

    private void aMv() {
        if (this.gOo != null) {
            unregisterReceiver(this.gOo);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.gOl != null) {
            if (view == this.gOl.bwf()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(e.d.cp_bg_line_d_1));
                    this.gOl.tL(1);
                    return;
                }
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(e.d.cp_bg_line_d));
                this.gOl.tL(0);
            } else if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                tK(1);
            } else {
                tK(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvK() {
        ay.CU().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvL() {
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
    public void bvM() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.atC, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvN() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvO() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvP() {
        TiebaStatic.log(new am("c12236").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage(2002001, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.wA() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvR() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.gOm.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        bvJ();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvT() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvU() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void bvV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(e.j.mebmer_close_ad_dialog_message);
        aVar.cA(e.d.cp_link_tip_d);
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
        aVar.b(getPageContext()).Au();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309348, MemberCloseAdSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvW() {
        mG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG(boolean z) {
        if (this.gOs == gOt) {
            this.gOl.bwc();
        } else if (this.gOs == gOu) {
            this.gOl.bwb();
        }
        if (z) {
            showToast(e.j.setdefualt_error);
        }
        this.gOs = gOv;
        this.mWaitingDialog.bj(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (i == 0) {
            this.gOl.bwb();
            currentAccountObj.setMemberCloseAdVipClose(0);
        } else {
            this.gOl.bwc();
            currentAccountObj.setMemberCloseAdVipClose(1);
        }
        this.gOs = gOv;
        this.mWaitingDialog.bj(false);
    }

    public void tK(int i) {
        if (this.gOs == gOv) {
            if (i == 0) {
                this.gOs = gOt;
            } else {
                this.gOs = gOu;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.dA(e.j.setting_submiting);
            this.mWaitingDialog.bj(true);
        }
    }
}
