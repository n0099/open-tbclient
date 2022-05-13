package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.ad8;
import com.repackage.bd8;
import com.repackage.du4;
import com.repackage.iu4;
import com.repackage.l78;
import com.repackage.on4;
import com.repackage.q45;
import com.repackage.r35;
import com.repackage.s35;
import com.repackage.wa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLoadData;
    public MoreDiscoveryModel mDiscoveryModel;
    public GetFriendAndStrangerSwitchModel mFriendAndStrangerSwitchModel;
    public GetImageWatermarkTypeModel mGetImageWatermarkTypeModel;
    public HttpMessageListener mGetMemberPayinfoListener;
    public MoreModel mModel;
    public CustomMessageListener mModifyNicknameSucceedListener;
    public wa mPersonInfoChangedListener;
    public bd8 mView;
    public List<Integer> notNeedLoginFunctions;
    public g receiver;

    /* loaded from: classes4.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreActivity moreActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getError() == 0) {
                boolean z = responsedMessage instanceof GetUserInfoHttpResponseMessage;
                if (z || (responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                    r35 r35Var = null;
                    if (z) {
                        r35Var = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                        r35Var = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                    }
                    if (r35Var == null || r35Var.a() == null) {
                        return;
                    }
                    String portrait = r35Var.a().getPortrait();
                    this.a.mView.E(HeadIconRefreshHelper.headPortraitFilter(portrait), false);
                    PersonChangeData y = this.a.mModel.y();
                    if (y != null) {
                        y.setPhotoChanged(true);
                        y.setPortrait(portrait);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MoreActivity moreActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && this.a.mDiscoveryModel != null) {
                    this.a.mDiscoveryModel.E(false, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MoreActivity moreActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data) || this.a.mDiscoveryModel == null) {
                return;
            }
            this.a.mDiscoveryModel.E(false, true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ad8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        public d(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        @Override // com.repackage.ad8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.isNeedLogin(i)) {
                return;
            }
            if (i == 0) {
                this.a.goToBack();
            } else if (i == 1) {
                this.a.goToPersonInfo();
            } else if (i == 15) {
                this.a.goToInterestSetting();
            } else if (i == 2) {
                this.a.goToAccountManager();
            } else if (i == 3) {
                this.a.goToBrowseSetting();
            } else if (i == 16) {
                this.a.goToAdSetting();
            } else if (i == 4) {
                this.a.goToMessage();
            } else if (i == 6) {
                this.a.goToAbout();
            } else if (i == 7) {
                this.a.goToFeedBack();
            } else if (i == 8) {
                this.a.goToRecommend();
            } else if (i == 5) {
                this.a.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(this.a.getPageContext().getPageActivity())));
            } else if (i == 9) {
                this.a.goToSecretSettings();
            } else if (i == 10) {
                this.a.mView.K();
            } else if (i == 12) {
                MessageManager.getInstance().runTask(2921330, null, this.a);
            } else if (i == 11) {
                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                q45.b(0, 0, 0, 2, 12);
                BdSocketLinkService.close("exit app");
                l78.d().b();
                du4.g(this.a.getPageContext().getPageActivity(), 12, false);
            } else if (i == 13) {
                this.a.goToAccountSafe();
                TiebaStatic.log("c10017");
            } else if (i == 17) {
                this.a.goToYoungsterSetting();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        public e(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.a.mDiscoveryModel.getUser() != null) {
                    personChangeData.setUserId(this.a.mDiscoveryModel.getUser().getUserId());
                    personChangeData.setName(this.a.mDiscoveryModel.getUser().getUserName());
                    personChangeData.setIntro(this.a.mDiscoveryModel.getUser().getIntro());
                    personChangeData.setPortrait(this.a.mDiscoveryModel.getUser().getPortrait());
                    personChangeData.setSex(this.a.mDiscoveryModel.getUser().getSex());
                    personChangeData.setNameShow(this.a.mDiscoveryModel.getUser().getName_show());
                    personChangeData.setMem(this.a.mDiscoveryModel.getUser().getIsMem());
                    personChangeData.setForumAge(this.a.mDiscoveryModel.getUser().getTb_age());
                    personChangeData.setCanModifyAvatar(this.a.mDiscoveryModel.getUser().canModifyAvatar());
                    personChangeData.setCantModifyAvatarDesc(this.a.mDiscoveryModel.getUser().getCantModifyAvatarDesc());
                    personChangeData.setTiebaId(this.a.mDiscoveryModel.getUser().getmTiebaUid());
                    if (this.a.mDiscoveryModel.getUser().getBusinessAccountData() != null) {
                        personChangeData.setIsBusinessAccount(this.a.mDiscoveryModel.getUser().getBusinessAccountData().isBusinessAccount ? "1" : "0");
                    }
                    if (this.a.mDiscoveryModel.getUser().alaUserData != null) {
                        personChangeData.setAlaId(this.a.mDiscoveryModel.getUser().alaUserData.ala_id);
                    }
                    if (this.a.mDiscoveryModel.F() != null) {
                        personChangeData.setNickNameLeftDays(this.a.mDiscoveryModel.F().left_days.intValue());
                    }
                    if (this.a.mDiscoveryModel.getUser().getBirthdayInfo() != null) {
                        personChangeData.setUserAge(this.a.mDiscoveryModel.getUser().getBirthdayInfo().c);
                        personChangeData.setBirthdayTime(this.a.mDiscoveryModel.getUser().getBirthdayInfo().a);
                        personChangeData.setBirthdayShowStatus(this.a.mDiscoveryModel.getUser().getBirthdayInfo().d);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
                    this.a.buildModel(personChangeData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity a;

        public f(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && (obj instanceof MoreModel.TaskType)) {
                if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                    MoreActivity moreActivity = this.a;
                    moreActivity.showToast(moreActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f08bb));
                }
                this.a.closeLoadingDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreActivity this$0;

        public g(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = moreActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.mView.H();
            }
        }

        public /* synthetic */ g(MoreActivity moreActivity, a aVar) {
            this(moreActivity);
        }
    }

    public MoreActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mModel = null;
        this.receiver = null;
        this.isLoadData = false;
        this.mPersonInfoChangedListener = new a(this, CmdConfigHttp.CMD_GET_USER_INFO, 303024);
        this.mGetMemberPayinfoListener = new b(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.mModifyNicknameSucceedListener = new c(this, 2921033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildModel(PersonChangeData personChangeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, personChangeData) == null) {
            if (personChangeData != null && personChangeData.getPortrait() != null) {
                this.mView.E(HeadIconRefreshHelper.headPortraitFilter(personChangeData.getPortrait()), false);
            }
            MoreModel moreModel = new MoreModel(personChangeData);
            this.mModel = moreModel;
            moreModel.setLoadDataCallBack(new f(this));
        }
    }

    private boolean checkPersonChangeDataIsValid(PersonChangeData personChangeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, this, personChangeData)) == null) ? (personChangeData == null || (TextUtils.isEmpty(personChangeData.getUserId()) && TextUtils.isEmpty(personChangeData.getName()) && TextUtils.isEmpty(personChangeData.getPortrait()) && TextUtils.isEmpty(personChangeData.getmTiebaId()))) ? false : true : invokeL.booleanValue;
    }

    private ad8 getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? new d(this) : (ad8) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAbout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((currentAccount == null || currentAccount.length() <= 0) && on4.d() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
            } else {
                sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountSafe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            MessageManager.getInstance().runTask(2921329, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAdSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            sendMessage(new CustomMessage(2002001, new AdSettingActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            passPersonInfoChange();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBrowseSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToFeedBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToInterestSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPersonInfo() {
        String currentAccount;
        MoreModel moreModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (currentAccount = TbadkCoreApplication.getCurrentAccount()) == null || currentAccount.length() <= 0 || (moreModel = this.mModel) == null || !checkPersonChangeDataIsValid(moreModel.y())) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.mModel.y(), Boolean.FALSE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToRecommend() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSecretSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
            TiebaStatic.log(new StatisticItem("c14001").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToYoungsterSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(getPageContext().getPageActivity());
            youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(2);
            sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.notNeedLoginFunctions = arrayList;
            arrayList.add(17);
            this.notNeedLoginFunctions.add(17);
            this.notNeedLoginFunctions.add(16);
            this.notNeedLoginFunctions.add(6);
            this.notNeedLoginFunctions.add(0);
        }
    }

    private void initModel(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, bundle) == null) {
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
                this.mDiscoveryModel.P(TbadkCoreApplication.getCurrentAccount());
                this.mDiscoveryModel.setLoadDataCallBack(new e(this));
                if (TbadkCoreApplication.isLogin()) {
                    this.isLoadData = true;
                    this.mDiscoveryModel.E(false, true);
                }
            }
            buildModel(personChangeData);
            if (TbadkCoreApplication.isLogin()) {
                this.isLoadData = true;
                this.mFriendAndStrangerSwitchModel = new GetFriendAndStrangerSwitchModel(this);
                this.mGetImageWatermarkTypeModel = new GetImageWatermarkTypeModel(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedLogin(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65573, this, i)) == null) {
            if (this.notNeedLoginFunctions.contains(Integer.valueOf(i))) {
                return false;
            }
            return !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this, LoginDialogData.SETTING_PAGE));
        }
        return invokeI.booleanValue;
    }

    private void passPersonInfoChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, this) == null) && this.mModel.z()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.mModel.y());
            setResult(-1, intent);
        }
    }

    private void refreshPortrait() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            s35.d().h();
        }
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.receiver = new g(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.receiver, intentFilter);
        }
    }

    private void unregReceiver() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65577, this) == null) || (gVar = this.receiver) == null) {
            return;
        }
        unregisterReceiver(gVar);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        bd8 bd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) || view2 == null || (bd8Var = this.mView) == null) {
            return;
        }
        if (view2 == bd8Var.z()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                UtilHelper.showSkinChangeAnimation(this);
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.CAM_X0201_1));
                this.mView.I(1);
            } else {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
        }
        if (view2 == this.mView.B()) {
            iu4.k().u("key_is_dark_mode_notify_shown", true);
            iu4.k().u("key_is_follow_system_mode", BdSwitchView.SwitchState.ON == switchState);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DARK_MODE_FOLLOW_SYSTEM).param("obj_type", BdSwitchView.SwitchState.ON == switchState ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i != 101) {
                    if (i != 12008) {
                        return;
                    }
                    goToFeedBack();
                    return;
                }
                PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                if (personChangeData == null) {
                    return;
                }
                this.mModel.A(personChangeData);
                this.mModel.B(true);
                if (this.mDiscoveryModel != null) {
                    refreshPortrait();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            UtilHelper.setNavigationBarBg(getActivity(), SkinManager.getColor(R.color.CAM_X0201));
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new bd8(this, getItemClickListener());
            initModel(bundle);
            regReceiver();
            registerListener(this.mPersonInfoChangedListener);
            registerListener(this.mGetMemberPayinfoListener);
            registerListener(this.mModifyNicknameSucceedListener);
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            unregReceiver();
            bd8 bd8Var = this.mView;
            if (bd8Var != null) {
                bd8Var.x();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (i == 4) {
                goToBack();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setSkinType(-1);
            this.mView.G();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            bd8 bd8Var = this.mView;
            if (bd8Var != null) {
                bd8Var.H();
                this.mView.F();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.mModel.y()));
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onUserChanged(z);
            if (!z || this.isLoadData) {
                return;
            }
            MoreDiscoveryModel moreDiscoveryModel = this.mDiscoveryModel;
            if (moreDiscoveryModel != null) {
                moreDiscoveryModel.E(false, true);
            }
            if (this.mFriendAndStrangerSwitchModel != null) {
                this.mFriendAndStrangerSwitchModel = new GetFriendAndStrangerSwitchModel(this);
            }
            if (this.mGetImageWatermarkTypeModel != null) {
                this.mGetImageWatermarkTypeModel = new GetImageWatermarkTypeModel(this);
            }
            bd8 bd8Var = this.mView;
            if (bd8Var != null) {
                bd8Var.L();
                this.mView.N();
            }
        }
    }
}
