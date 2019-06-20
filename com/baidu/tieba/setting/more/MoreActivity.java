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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.play.y;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.MsgRemindActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.a {
    private e iLe;
    private MoreDiscoveryModel iLg;
    private GetFriendAndStrangerSwitchModel iLj;
    private MoreModel iLf = null;
    private a iLh = null;
    private com.baidu.adp.framework.listener.a iLi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_USER_INFO, 303024) { // from class: com.baidu.tieba.setting.more.MoreActivity.1
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
                    if (aVar != null && aVar.asg() != null) {
                        String portrait = aVar.asg().getPortrait();
                        MoreActivity.this.iLe.av(o.nA(portrait), false);
                        PersonChangeData personChangeData = MoreActivity.this.iLf.getPersonChangeData();
                        if (personChangeData != null) {
                            personChangeData.setPhotoChanged(true);
                            personChangeData.setPortrait(portrait);
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener hkd = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.setting.more.MoreActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && MoreActivity.this.iLg != null) {
                    MoreActivity.this.iLg.ah(false, true);
                }
            }
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.setting.more.MoreActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && MoreActivity.this.iLg != null) {
                    MoreActivity.this.iLg.ah(false, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLe = new e(this, chs());
        af(bundle);
        bxp();
        registerListener(this.iLi);
        registerListener(this.hkd);
        registerListener(this.fqs);
    }

    private d chs() {
        return new d() { // from class: com.baidu.tieba.setting.more.MoreActivity.4
            @Override // com.baidu.tieba.setting.more.d
            public void zB(int i) {
                if (i == 0) {
                    MoreActivity.this.chE();
                } else if (i == 1) {
                    MoreActivity.this.chD();
                } else if (i == 15) {
                    MoreActivity.this.chB();
                } else if (i == 2) {
                    MoreActivity.this.chC();
                } else if (i == 3) {
                    MoreActivity.this.chz();
                } else if (i == 16) {
                    MoreActivity.this.chA();
                } else if (i == 4) {
                    MoreActivity.this.chF();
                } else if (i == 6) {
                    MoreActivity.this.chy();
                } else if (i == 7) {
                    MoreActivity.this.chv();
                } else if (i == 8) {
                    MoreActivity.this.chw();
                } else if (i == 5) {
                    MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
                } else if (i == 9) {
                    MoreActivity.this.chG();
                } else if (i == 10) {
                    MoreActivity.this.iLe.chL();
                } else if (i == 12) {
                    MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
                } else if (i == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    com.baidu.tbadk.lcs.a.c(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    y.cbW().clear();
                    com.baidu.tbadk.core.e.b.c(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
                } else if (i == 13) {
                    MoreActivity.this.chx();
                    TiebaStatic.log("c10017");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bxq();
        if (this.iLe != null) {
            this.iLe.ayB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iLe != null) {
            this.iLe.chI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iLe.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.iLe.cgM();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.iLf.getPersonChangeData()));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            chE();
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
                        this.iLf.setPersonChangeData(personChangeData);
                        this.iLf.qm(true);
                        if (this.iLg != null) {
                            cht();
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                    chv();
                    return;
                default:
                    return;
            }
        }
    }

    private void cht() {
        com.baidu.tbadk.getUserInfo.b.ash().asi();
    }

    private void chu() {
        if (this.iLf.cgQ()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.iLf.getPersonChangeData());
            setResult(-1, intent);
        }
    }

    private void af(Bundle bundle) {
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
            this.iLg = new MoreDiscoveryModel(this);
            this.iLg.setUniqueId(getUniqueId());
            this.iLg.setId(TbadkCoreApplication.getCurrentAccount());
            this.iLg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.5
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    PersonChangeData personChangeData2 = new PersonChangeData();
                    if (MoreActivity.this.iLg.getUser() != null) {
                        personChangeData2.setName(MoreActivity.this.iLg.getUser().getUserName());
                        personChangeData2.setIntro(MoreActivity.this.iLg.getUser().getIntro());
                        personChangeData2.setPortrait(MoreActivity.this.iLg.getUser().getPortrait());
                        personChangeData2.setSex(MoreActivity.this.iLg.getUser().getSex());
                        personChangeData2.setNameShow(MoreActivity.this.iLg.getUser().getName_show());
                        personChangeData2.setMem(MoreActivity.this.iLg.getUser().getIsMem());
                        if (MoreActivity.this.iLg.getNicknameInfo() != null) {
                            personChangeData2.setNickNameLeftDays(MoreActivity.this.iLg.getNicknameInfo().left_days.intValue());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData2));
                        MoreActivity.this.b(personChangeData2);
                    }
                }
            });
            this.iLg.ah(false, true);
        }
        b(personChangeData);
        this.iLj = new GetFriendAndStrangerSwitchModel(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.iLe.av(o.nA(personChangeData.getPortrait()), false);
        }
        this.iLf = new MoreModel(personChangeData);
        this.iLf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.MoreActivity.6
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
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
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.iLe.chI();
        }
    }

    private void bxp() {
        this.iLh = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.iLh, intentFilter);
    }

    private void bxq() {
        if (this.iLh != null) {
            unregisterReceiver(this.iLh);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && this.iLe != null && view == this.iLe.chM()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                UtilHelper.showSkinChangeAnimation(this);
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.cp_bg_line_d_1));
                this.iLe.zG(1);
                return;
            }
            UtilHelper.showSkinChangeAnimation(this);
            UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.cp_bg_line_d));
            this.iLe.zG(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chv() {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        ba.aiz().a(getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chw() {
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
    public void chx() {
        MessageManager.getInstance().runTask(com.baidu.tbadk.core.frameworkData.a.bNR, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chy() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chz() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chA() {
        sendMessage(new CustomMessage(2002001, new AdSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chB() {
        TiebaStatic.log(new am("c12236").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        sendMessage(new CustomMessage(2002001, new LabelSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chC() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.a.b.abj() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.iLf.getPersonChangeData(), false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chE() {
        chu();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chF() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chG() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
    }
}
