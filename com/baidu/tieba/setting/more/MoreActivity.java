package com.baidu.tieba.setting.more;

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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.play.n;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes7.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private e mWD;
    private MoreDiscoveryModel mWF;
    private GetFriendAndStrangerSwitchModel mWI;
    private GetImageWatermarkTypeModel mWJ;
    private MoreModel mWE = null;
    private a mWG = null;
    private com.baidu.adp.framework.listener.a mWH = new com.baidu.adp.framework.listener.a(1003001, CmdConfigSocket.CMD_GET_USER_INFO) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.bCp() != null) {
                        String portrait = aVar.bCp().getPortrait();
                        MoreActivity.this.mWD.bc(q.AE(portrait), false);
                        PersonChangeData dEi = MoreActivity.this.mWE.dEi();
                        if (dEi != null) {
                            dEi.setPhotoChanged(true);
                            dEi.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener lgK = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.mWF != null) {
                    MoreActivity.this.mWF.aA(false, true);
                }
            }
        }
    };
    private CustomMessageListener jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.mWF != null) {
                    MoreActivity.this.mWF.aA(false, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWD = new e(this, dEN());
        aH(bundle);
        cSw();
        registerListener(this.mWH);
        registerListener(this.lgK);
        registerListener(this.jcp);
    }

    private d dEN() {
        return new d() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.d
            public void Il(int i) {
                if (i == 0) {
                    MoreActivity.this.dFa();
                } else if (i == 1) {
                    MoreActivity.this.dEZ();
                } else if (i == 15) {
                    MoreActivity.this.dEX();
                } else if (i == 2) {
                    MoreActivity.this.dEY();
                } else if (i == 3) {
                    MoreActivity.this.dEU();
                } else if (i == 16) {
                    MoreActivity.this.dEW();
                } else if (i == 4) {
                    MoreActivity.this.dFb();
                } else if (i == 6) {
                    MoreActivity.this.dET();
                } else if (i == 7) {
                    MoreActivity.this.dEQ();
                } else if (i == 8) {
                    MoreActivity.this.dER();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.dFc();
                } else if (i == 10) {
                    if (!com.baidu.tbadk.youngster.b.c.bIM()) {
                        MoreActivity.this.mWD.dFi();
                    } else {
                        l.showToast(MoreActivity.this.getPageContext().getPageActivity(), R.string.youngster_settings_logout);
                    }
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LOG_OUT, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, true);
                    com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    n.dxY().clear();
                    com.baidu.tbadk.core.e.b.d(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.dES();
                    TiebaStatic.log("c10017");
                } else if (i == 17) {
                    MoreActivity.this.dEV();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cSx();
        if (this.mWD != null) {
            this.mWD.Ek();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWD != null) {
            this.mWD.dFe();
            this.mWD.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.mWD.dEe();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.mWE.dEi()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dFa();
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
                        this.mWE.b(personChangeData);
                        this.mWE.xu(true);
                        if (this.mWF != null) {
                            dEO();
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_FEEDBACK /* 12008 */:
                    dEQ();
                    return;
                default:
                    return;
            }
        }
    }

    private void dEO() {
        com.baidu.tbadk.getUserInfo.b.bCq().bCr();
    }

    private void dEP() {
        if (this.mWE.dEh()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.mWE.dEi());
            setResult(-1, intent);
        }
    }

    private void aH(Bundle bundle) {
        PersonChangeData personChangeData = null;
        if (bundle != null) {
            String string = bundle.getString("person_change_data");
            if (!StringUtils.isNull(string)) {
                personChangeData = (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class);
            }
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        }
        if (personChangeData == null) {
            this.mWF = new MoreDiscoveryModel(this);
            this.mWF.setUniqueId(getUniqueId());
            this.mWF.setId(TbadkCoreApplication.getCurrentAccount());
            this.mWF.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.mWF.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.mWF.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.mWF.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.mWF.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.mWF.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.mWF.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.mWF.getUser().getIsMem());
                        personChangeData2.setForumAge(MoreActivity.this.mWF.getUser().getTb_age());
                        personChangeData2.setCanModifyAvatar(MoreActivity.this.mWF.getUser().canModifyAvatar());
                        personChangeData2.setCantModifyAvatarDesc(MoreActivity.this.mWF.getUser().getCantModifyAvatarDesc());
                        if (MoreActivity.this.mWF.getUser().alaUserData != null) {
                            personChangeData2.setAlaId(MoreActivity.this.mWF.getUser().alaUserData.ala_id);
                        }
                        if (MoreActivity.this.mWF.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.mWF.getNicknameInfo().left_days.intValue());
                        }
                        if (MoreActivity.this.mWF.getUser().getBirthdayInfo() != null) {
                            personChangeData2.setUserAge(MoreActivity.this.mWF.getUser().getBirthdayInfo().age);
                            personChangeData2.setBirthdayTime(MoreActivity.this.mWF.getUser().getBirthdayInfo().eSh);
                            personChangeData2.setBirthdayShowStatus(MoreActivity.this.mWF.getUser().getBirthdayInfo().eSi);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData2));
                        MoreActivity.this.c(personChangeData2);
                    }
                }
            });
            this.mWF.aA(false, true);
        }
        c(personChangeData);
        this.mWI = new GetFriendAndStrangerSwitchModel(this);
        this.mWJ = new GetImageWatermarkTypeModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.mWD.bc(q.AE(personChangeData.getPortrait()), false);
        }
        this.mWE = new MoreModel(personChangeData);
        this.mWE.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        MoreActivity.this.showToast(MoreActivity.this.getPageContext().getString(R.string.image_cash_del_suc));
                    }
                    MoreActivity.this.closeLoadingDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.mWD.dFe();
        }
    }

    private void cSw() {
        this.mWG = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mWG, intentFilter);
    }

    private void cSx() {
        if (this.mWG != null) {
            unregisterReceiver(this.mWG);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.mWD != null) {
            if (view == this.mWD.dFj()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.showSkinChangeAnimation(this);
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.CAM_X0201_1));
                    this.mWD.Iq(1);
                } else {
                    ao.C(true, false);
                }
            }
            if (view == this.mWD.dFk()) {
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_is_dark_mode_notify_shown", true);
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_is_follow_system_mode", BdSwitchView.SwitchState.ON == switchState);
                if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                    ao.C(true, false);
                }
                TiebaStatic.log(new aq("c13577").an("obj_type", BdSwitchView.SwitchState.ON == switchState ? 1 : 2).an("obj_locate", 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEQ() {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        be.bsB().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dER() {
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
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AppsActivityConfig(getPageContext().getPageActivity(), str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dES() {
        MessageManager.getInstance().runTask(2921329, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dET() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEU() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEV() {
        if (com.baidu.tbadk.youngster.b.c.bIM()) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getPageContext().getPageActivity());
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(2);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            return;
        }
        YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(getPageContext().getPageActivity());
        youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(2);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterIntroduceActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AdSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEX() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEY() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.bkE() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_LOGIN_USE)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.mWE.dEi(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFa() {
        dEP();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFb() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFc() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
        TiebaStatic.log(new aq("c14001").dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
