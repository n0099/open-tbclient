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
    private e jRO;
    private MoreDiscoveryModel jRQ;
    private GetFriendAndStrangerSwitchModel jRT;
    private GetImageWatermarkTypeModel jRU;
    private MoreModel jRP = null;
    private a jRR = null;
    private com.baidu.adp.framework.listener.a jRS = new com.baidu.adp.framework.listener.a(1003001, CmdConfigSocket.CMD_GET_USER_INFO) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                        MoreActivity.this.jRO.az(o.sX(portrait), false);
                        PersonChangeData cDD = MoreActivity.this.jRP.cDD();
                        if (cDD != null) {
                            cDD.setPhotoChanged(true);
                            cDD.setPortrait(portrait);
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
                if (statusCode == 200 && error == 0 && MoreActivity.this.jRQ != null) {
                    MoreActivity.this.jRQ.al(false, true);
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
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.jRQ != null) {
                    MoreActivity.this.jRQ.al(false, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRO = new e(this, cEf());
        ay(bundle);
        bQe();
        registerListener(this.jRS);
        registerListener(this.iiH);
        registerListener(this.gnE);
    }

    private d cEf() {
        return new d() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.d
            public void Bt(int i) {
                if (i == 0) {
                    MoreActivity.this.cEr();
                } else if (i == 1) {
                    MoreActivity.this.cEq();
                } else if (i == 15) {
                    MoreActivity.this.cEo();
                } else if (i == 2) {
                    MoreActivity.this.cEp();
                } else if (i == 3) {
                    MoreActivity.this.cEm();
                } else if (i == 16) {
                    MoreActivity.this.cEn();
                } else if (i == 4) {
                    MoreActivity.this.cEs();
                } else if (i == 6) {
                    MoreActivity.this.cEl();
                } else if (i == 7) {
                    MoreActivity.this.cEi();
                } else if (i == 8) {
                    MoreActivity.this.cEj();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.cEt();
                } else if (i == 10) {
                    MoreActivity.this.jRO.cEz();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LOG_OUT, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, true);
                    com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    x.cxU().clear();
                    com.baidu.tbadk.core.e.b.c(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.cEk();
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
        if (this.jRO != null) {
            this.jRO.xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jRO != null) {
            this.jRO.cEv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jRO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.jRO.cDy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.jRP.cDD()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cEr();
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
                        this.jRP.b(personChangeData);
                        this.jRP.sj(true);
                        if (this.jRQ != null) {
                            cEg();
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_FEEDBACK /* 12008 */:
                    cEi();
                    return;
                default:
                    return;
            }
        }
    }

    private void cEg() {
        com.baidu.tbadk.getUserInfo.b.aNl().aNm();
    }

    private void cEh() {
        if (this.jRP.cDC()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.jRP.cDD());
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
            this.jRQ = new MoreDiscoveryModel(this);
            this.jRQ.setUniqueId(getUniqueId());
            this.jRQ.setId(TbadkCoreApplication.getCurrentAccount());
            this.jRQ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.jRQ.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.jRQ.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.jRQ.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.jRQ.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.jRQ.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.jRQ.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.jRQ.getUser().getIsMem());
                        personChangeData2.setForumAge(MoreActivity.this.jRQ.getUser().getTb_age());
                        personChangeData2.setCanModifyAvatar(MoreActivity.this.jRQ.getUser().canModifyAvatar());
                        personChangeData2.setCantModifyAvatarDesc(MoreActivity.this.jRQ.getUser().getCantModifyAvatarDesc());
                        if (MoreActivity.this.jRQ.getUser().alaUserData != null) {
                            personChangeData2.setAlaId(MoreActivity.this.jRQ.getUser().alaUserData.ala_id);
                        }
                        if (MoreActivity.this.jRQ.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.jRQ.getNicknameInfo().left_days.intValue());
                        }
                        if (MoreActivity.this.jRQ.getUser().getBirthdayInfo() != null) {
                            personChangeData2.setUserAge(MoreActivity.this.jRQ.getUser().getBirthdayInfo().age);
                            personChangeData2.setBirthdayTime(MoreActivity.this.jRQ.getUser().getBirthdayInfo().cQJ);
                            personChangeData2.setBirthdayShowStatus(MoreActivity.this.jRQ.getUser().getBirthdayInfo().cQK);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData2));
                        MoreActivity.this.c(personChangeData2);
                    }
                }
            });
            this.jRQ.al(false, true);
        }
        c(personChangeData);
        this.jRT = new GetFriendAndStrangerSwitchModel(this);
        this.jRU = new GetImageWatermarkTypeModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.jRO.az(o.sX(personChangeData.getPortrait()), false);
        }
        this.jRP = new MoreModel(personChangeData);
        this.jRP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
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
            MoreActivity.this.jRO.cEv();
        }
    }

    private void bQe() {
        this.jRR = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.jRR, intentFilter);
    }

    private void bQf() {
        if (this.jRR != null) {
            unregisterReceiver(this.jRR);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.jRO != null) {
            if (view == this.jRO.cEA()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.showSkinChangeAnimation(this);
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.cp_bg_line_d_1));
                    this.jRO.By(1);
                } else {
                    am.s(true, false);
                }
            }
            if (view == this.jRO.cEB()) {
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
    public void cEi() {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        ba.aEt().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEj() {
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
    public void cEk() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.CMD_START_ACCOUNT_SAFE_MANAGER, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEl() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEm() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEn() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AdSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEo() {
        TiebaStatic.log(new an("c12236").cp("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.axB() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.jRP.cDD(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEr() {
        cEh();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEs() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEt() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }
}
