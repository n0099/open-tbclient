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
import com.baidu.tbadk.core.atomData.LabelSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.play.x;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private e jRT;
    private MoreDiscoveryModel jRV;
    private GetFriendAndStrangerSwitchModel jRY;
    private GetImageWatermarkTypeModel jRZ;
    private MoreModel jRU = null;
    private a jRW = null;
    private com.baidu.adp.framework.listener.a jRX = new com.baidu.adp.framework.listener.a(1003001, CmdConfigSocket.CMD_GET_USER_INFO) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.aNk() != null) {
                        String portrait = aVar.aNk().getPortrait();
                        MoreActivity.this.jRT.az(o.sX(portrait), false);
                        PersonChangeData cDF = MoreActivity.this.jRU.cDF();
                        if (cDF != null) {
                            cDF.setPhotoChanged(true);
                            cDF.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener iiH = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.jRV != null) {
                    MoreActivity.this.jRV.al(false, true);
                }
            }
        }
    };
    private CustomMessageListener gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.jRV != null) {
                    MoreActivity.this.jRV.al(false, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRT = new e(this, cEh());
        ay(bundle);
        bQe();
        registerListener(this.jRX);
        registerListener(this.iiH);
        registerListener(this.gnE);
    }

    private d cEh() {
        return new d() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.d
            public void Bt(int i) {
                if (i == 0) {
                    MoreActivity.this.cEt();
                } else if (i == 1) {
                    MoreActivity.this.cEs();
                } else if (i == 15) {
                    MoreActivity.this.cEq();
                } else if (i == 2) {
                    MoreActivity.this.cEr();
                } else if (i == 3) {
                    MoreActivity.this.cEo();
                } else if (i == 16) {
                    MoreActivity.this.cEp();
                } else if (i == 4) {
                    MoreActivity.this.cEu();
                } else if (i == 6) {
                    MoreActivity.this.cEn();
                } else if (i == 7) {
                    MoreActivity.this.cEk();
                } else if (i == 8) {
                    MoreActivity.this.cEl();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.cEv();
                } else if (i == 10) {
                    MoreActivity.this.jRT.cEB();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LOG_OUT, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, true);
                    com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    x.cxW().clear();
                    com.baidu.tbadk.core.e.b.c(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.cEm();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bQf();
        if (this.jRT != null) {
            this.jRT.xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jRT != null) {
            this.jRT.cEx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jRT.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.jRT.cDA();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.jRU.cDF()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cEt();
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
                        this.jRU.b(personChangeData);
                        this.jRU.sj(true);
                        if (this.jRV != null) {
                            cEi();
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_FEEDBACK /* 12008 */:
                    cEk();
                    return;
                default:
                    return;
            }
        }
    }

    private void cEi() {
        com.baidu.tbadk.getUserInfo.b.aNl().aNm();
    }

    private void cEj() {
        if (this.jRU.cDE()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.jRU.cDF());
            setResult(-1, intent);
        }
    }

    private void ay(Bundle bundle) {
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
            this.jRV = new MoreDiscoveryModel(this);
            this.jRV.setUniqueId(getUniqueId());
            this.jRV.setId(TbadkCoreApplication.getCurrentAccount());
            this.jRV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.jRV.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.jRV.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.jRV.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.jRV.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.jRV.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.jRV.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.jRV.getUser().getIsMem());
                        personChangeData2.setForumAge(MoreActivity.this.jRV.getUser().getTb_age());
                        personChangeData2.setCanModifyAvatar(MoreActivity.this.jRV.getUser().canModifyAvatar());
                        personChangeData2.setCantModifyAvatarDesc(MoreActivity.this.jRV.getUser().getCantModifyAvatarDesc());
                        if (MoreActivity.this.jRV.getUser().alaUserData != null) {
                            personChangeData2.setAlaId(MoreActivity.this.jRV.getUser().alaUserData.ala_id);
                        }
                        if (MoreActivity.this.jRV.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.jRV.getNicknameInfo().left_days.intValue());
                        }
                        if (MoreActivity.this.jRV.getUser().getBirthdayInfo() != null) {
                            personChangeData2.setUserAge(MoreActivity.this.jRV.getUser().getBirthdayInfo().age);
                            personChangeData2.setBirthdayTime(MoreActivity.this.jRV.getUser().getBirthdayInfo().cQJ);
                            personChangeData2.setBirthdayShowStatus(MoreActivity.this.jRV.getUser().getBirthdayInfo().cQK);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData2));
                        MoreActivity.this.c(personChangeData2);
                    }
                }
            });
            this.jRV.al(false, true);
        }
        c(personChangeData);
        this.jRY = new GetFriendAndStrangerSwitchModel(this);
        this.jRZ = new GetImageWatermarkTypeModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.jRT.az(o.sX(personChangeData.getPortrait()), false);
        }
        this.jRU = new MoreModel(personChangeData);
        this.jRU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.d
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
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.jRT.cEx();
        }
    }

    private void bQe() {
        this.jRW = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.jRW, intentFilter);
    }

    private void bQf() {
        if (this.jRW != null) {
            unregisterReceiver(this.jRW);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.jRT != null) {
            if (view == this.jRT.cEC()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.showSkinChangeAnimation(this);
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.cp_bg_line_d_1));
                    this.jRT.By(1);
                } else {
                    am.s(true, false);
                }
            }
            if (view == this.jRT.cED()) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_is_dark_mode_notify_shown", true);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_is_follow_system_mode", BdSwitchView.SwitchState.ON == switchState);
                if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                    am.s(true, false);
                }
                TiebaStatic.log(new an("c13577").Z("obj_type", BdSwitchView.SwitchState.ON == switchState ? 1 : 2).Z("obj_locate", 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEk() {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        ba.aEt().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEl() {
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
    public void cEm() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.CMD_START_ACCOUNT_SAFE_MANAGER, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEn() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEo() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEp() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AdSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEq() {
        TiebaStatic.log(new an("c12236").cp("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEr() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.axB() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEs() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.jRU.cDF(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEt() {
        cEj();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEv() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }
}
