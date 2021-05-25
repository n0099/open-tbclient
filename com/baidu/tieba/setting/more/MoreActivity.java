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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel;
import d.a.c.e.p.l;
import d.a.n0.k2.n;
/* loaded from: classes5.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.b {
    public MoreDiscoveryModel mDiscoveryModel;
    public GetFriendAndStrangerSwitchModel mFriendAndStrangerSwitchModel;
    public GetImageWatermarkTypeModel mGetImageWatermarkTypeModel;
    public d.a.n0.w2.c.e mView;
    public MoreModel mModel = null;
    public g receiver = null;
    public d.a.c.c.g.a mPersonInfoChangedListener = new a(CmdConfigHttp.CMD_GET_USER_INFO, 303024);
    public HttpMessageListener mGetMemberPayinfoListener = new b(CmdConfigHttp.GETPAYINFO_CMD);
    public CustomMessageListener mModifyNicknameSucceedListener = new c(2921033);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                return;
            }
            boolean z = responsedMessage instanceof GetUserInfoHttpResponseMessage;
            if (z || (responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                d.a.m0.z.a aVar = null;
                if (z) {
                    aVar = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                    aVar = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                }
                if (aVar == null || aVar.a() == null) {
                    return;
                }
                String portrait = aVar.a().getPortrait();
                MoreActivity.this.mView.G(HeadIconRefreshHelper.headPortraitFilter(portrait), false);
                PersonChangeData s = MoreActivity.this.mModel.s();
                if (s != null) {
                    s.setPhotoChanged(true);
                    s.setPortrait(portrait);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && MoreActivity.this.mDiscoveryModel != null) {
                MoreActivity.this.mDiscoveryModel.y(false, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data) || MoreActivity.this.mDiscoveryModel == null) {
                return;
            }
            MoreActivity.this.mDiscoveryModel.y(false, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.n0.w2.c.d {
        public d() {
        }

        @Override // d.a.n0.w2.c.d
        public void a(int i2) {
            if (i2 == 0) {
                MoreActivity.this.goToBack();
            } else if (i2 == 1) {
                MoreActivity.this.goToPersonInfo();
            } else if (i2 == 15) {
                MoreActivity.this.goToInterestSetting();
            } else if (i2 == 2) {
                if (!d.a.m0.c1.b.e.d()) {
                    MoreActivity.this.goToAccountManager();
                } else {
                    l.L(MoreActivity.this.getPageContext().getPageActivity(), R.string.youngster_settings_logout);
                }
            } else if (i2 == 3) {
                MoreActivity.this.goToBrowseSetting();
            } else if (i2 == 16) {
                MoreActivity.this.goToAdSetting();
            } else if (i2 == 4) {
                MoreActivity.this.goToMessage();
            } else if (i2 == 6) {
                MoreActivity.this.goToAbout();
            } else if (i2 == 7) {
                MoreActivity.this.goToFeedBack();
            } else if (i2 == 8) {
                MoreActivity.this.goToRecommend();
            } else if (i2 == 5) {
                MoreActivity.this.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(MoreActivity.this.getPageContext().getPageActivity())));
            } else if (i2 == 9) {
                MoreActivity.this.goToSecretSettings();
            } else if (i2 == 10) {
                if (!d.a.m0.c1.b.e.d()) {
                    MoreActivity.this.mView.L();
                } else {
                    l.L(MoreActivity.this.getPageContext().getPageActivity(), R.string.youngster_settings_logout);
                }
            } else if (i2 == 12) {
                MessageManager.getInstance().runTask(2921330, null, MoreActivity.this);
            } else if (i2 == 11) {
                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                d.a.m0.c0.a.b(0, 0, 0, 2, 12);
                BdSocketLinkService.close("exit app");
                n.d().b();
                d.a.m0.r.a0.b.g(MoreActivity.this.getPageContext().getPageActivity(), 12, false);
            } else if (i2 == 13) {
                MoreActivity.this.goToAccountSafe();
                TiebaStatic.log("c10017");
            } else if (i2 == 17) {
                MoreActivity.this.goToYoungsterSetting();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends d.a.c.a.e {
        public e() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (MoreActivity.this.mDiscoveryModel.getUser() != null) {
                personChangeData.setName(MoreActivity.this.mDiscoveryModel.getUser().getUserName());
                personChangeData.setIntro(MoreActivity.this.mDiscoveryModel.getUser().getIntro());
                personChangeData.setPortrait(MoreActivity.this.mDiscoveryModel.getUser().getPortrait());
                personChangeData.setSex(MoreActivity.this.mDiscoveryModel.getUser().getSex());
                personChangeData.setNameShow(MoreActivity.this.mDiscoveryModel.getUser().getName_show());
                personChangeData.setMem(MoreActivity.this.mDiscoveryModel.getUser().getIsMem());
                personChangeData.setForumAge(MoreActivity.this.mDiscoveryModel.getUser().getTb_age());
                personChangeData.setCanModifyAvatar(MoreActivity.this.mDiscoveryModel.getUser().canModifyAvatar());
                personChangeData.setCantModifyAvatarDesc(MoreActivity.this.mDiscoveryModel.getUser().getCantModifyAvatarDesc());
                personChangeData.setTiebaId(MoreActivity.this.mDiscoveryModel.getUser().getmTiebaUid());
                if (MoreActivity.this.mDiscoveryModel.getUser().alaUserData != null) {
                    personChangeData.setAlaId(MoreActivity.this.mDiscoveryModel.getUser().alaUserData.ala_id);
                }
                if (MoreActivity.this.mDiscoveryModel.z() != null) {
                    personChangeData.setNickNameLeftDays(MoreActivity.this.mDiscoveryModel.z().left_days.intValue());
                }
                if (MoreActivity.this.mDiscoveryModel.getUser().getBirthdayInfo() != null) {
                    personChangeData.setUserAge(MoreActivity.this.mDiscoveryModel.getUser().getBirthdayInfo().f50036c);
                    personChangeData.setBirthdayTime(MoreActivity.this.mDiscoveryModel.getUser().getBirthdayInfo().f50034a);
                    personChangeData.setBirthdayShowStatus(MoreActivity.this.mDiscoveryModel.getUser().getBirthdayInfo().f50037d);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
                MoreActivity.this.buildModel(personChangeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends d.a.c.a.e {
        public f() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj == null || !(obj instanceof MoreModel.TaskType)) {
                return;
            }
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                MoreActivity moreActivity = MoreActivity.this;
                moreActivity.showToast(moreActivity.getPageContext().getString(R.string.image_cash_del_suc));
            }
            MoreActivity.this.closeLoadingDialog();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MoreActivity.this.mView.J();
        }

        public /* synthetic */ g(MoreActivity moreActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildModel(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.mView.G(HeadIconRefreshHelper.headPortraitFilter(personChangeData.getPortrait()), false);
        }
        MoreModel moreModel = new MoreModel(personChangeData);
        this.mModel = moreModel;
        moreModel.setLoadDataCallBack(new f());
    }

    private d.a.n0.w2.c.d getItemClickListener() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAbout() {
        sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountManager() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && d.a.m0.r.l.c.d() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
        } else {
            sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountSafe() {
        MessageManager.getInstance().runTask(2921329, null, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAdSetting() {
        sendMessage(new CustomMessage(2002001, new AdSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBack() {
        passPersonInfoChange();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBrowseSetting() {
        sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToFeedBack() {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToInterestSetting() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMessage() {
        sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPersonInfo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.mModel.s(), Boolean.FALSE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToRecommend() {
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
    public void goToSecretSettings() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
        TiebaStatic.log(new StatisticItem("c14001").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToYoungsterSetting() {
        if (d.a.m0.c1.b.e.d()) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getPageContext().getPageActivity());
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(2);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            return;
        }
        YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(getPageContext().getPageActivity());
        youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(2);
        sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
    }

    private void initModel(Bundle bundle) {
        PersonChangeData personChangeData;
        if (bundle != null) {
            String string = bundle.getString("person_change_data");
            personChangeData = !StringUtils.isNull(string) ? (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class) : null;
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        }
        if (personChangeData == null) {
            MoreDiscoveryModel moreDiscoveryModel = new MoreDiscoveryModel(this);
            this.mDiscoveryModel = moreDiscoveryModel;
            moreDiscoveryModel.setUniqueId(getUniqueId());
            this.mDiscoveryModel.J(TbadkCoreApplication.getCurrentAccount());
            this.mDiscoveryModel.setLoadDataCallBack(new e());
            this.mDiscoveryModel.y(false, true);
        }
        buildModel(personChangeData);
        this.mFriendAndStrangerSwitchModel = new GetFriendAndStrangerSwitchModel(this);
        this.mGetImageWatermarkTypeModel = new GetImageWatermarkTypeModel(this);
    }

    private void passPersonInfoChange() {
        if (this.mModel.t()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.mModel.s());
            setResult(-1, intent);
        }
    }

    private void refreshPortrait() {
        d.a.m0.z.b.a().d();
    }

    private void regReceiver() {
        this.receiver = new g(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.receiver, intentFilter);
    }

    private void unregReceiver() {
        g gVar = this.receiver;
        if (gVar != null) {
            unregisterReceiver(gVar);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        d.a.n0.w2.c.e eVar;
        if (view == null || (eVar = this.mView) == null) {
            return;
        }
        if (view == eVar.y()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                UtilHelper.showSkinChangeAnimation(this);
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.CAM_X0201_1));
                this.mView.K(1);
            } else {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
        }
        if (view == this.mView.A()) {
            d.a.m0.r.d0.b.j().t("key_is_dark_mode_notify_shown", true);
            d.a.m0.r.d0.b.j().t("key_is_follow_system_mode", BdSwitchView.SwitchState.ON == switchState);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DARK_MODE_FOLLOW_SYSTEM).param("obj_type", BdSwitchView.SwitchState.ON == switchState ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 != 101) {
                if (i2 != 12008) {
                    return;
                }
                goToFeedBack();
                return;
            }
            PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
            if (personChangeData == null) {
                return;
            }
            this.mModel.u(personChangeData);
            this.mModel.v(true);
            if (this.mDiscoveryModel != null) {
                refreshPortrait();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.a.n0.w2.c.e(this, getItemClickListener());
        initModel(bundle);
        regReceiver();
        registerListener(this.mPersonInfoChangedListener);
        registerListener(this.mGetMemberPayinfoListener);
        registerListener(this.mModifyNicknameSucceedListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        d.a.n0.w2.c.e eVar = this.mView;
        if (eVar != null) {
            eVar.w();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            goToBack();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.mView.I();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.a.n0.w2.c.e eVar = this.mView;
        if (eVar != null) {
            eVar.J();
            this.mView.H();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.mModel.s()));
        super.onSaveInstanceState(bundle);
    }
}
