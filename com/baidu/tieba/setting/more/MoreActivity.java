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
import c.a.e.e.p.l;
import c.a.p0.o2.n;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MoreDiscoveryModel mDiscoveryModel;
    public GetFriendAndStrangerSwitchModel mFriendAndStrangerSwitchModel;
    public GetImageWatermarkTypeModel mGetImageWatermarkTypeModel;
    public HttpMessageListener mGetMemberPayinfoListener;
    public MoreModel mModel;
    public CustomMessageListener mModifyNicknameSucceedListener;
    public c.a.e.c.g.a mPersonInfoChangedListener;
    public c.a.p0.a3.c.e mView;
    public g receiver;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56374a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreActivity moreActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56374a = moreActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getError() == 0) {
                boolean z = responsedMessage instanceof GetUserInfoHttpResponseMessage;
                if (z || (responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                    c.a.o0.a0.a aVar = null;
                    if (z) {
                        aVar = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                        aVar = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                    }
                    if (aVar == null || aVar.a() == null) {
                        return;
                    }
                    String portrait = aVar.a().getPortrait();
                    this.f56374a.mView.B(HeadIconRefreshHelper.headPortraitFilter(portrait), false);
                    PersonChangeData w = this.f56374a.mModel.w();
                    if (w != null) {
                        w.setPhotoChanged(true);
                        w.setPortrait(portrait);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MoreActivity moreActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56375a = moreActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && this.f56375a.mDiscoveryModel != null) {
                    this.f56375a.mDiscoveryModel.C(false, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56376a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MoreActivity moreActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56376a = moreActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data) || this.f56376a.mDiscoveryModel == null) {
                return;
            }
            this.f56376a.mDiscoveryModel.C(false, true);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.p0.a3.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56377a;

        public d(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56377a = moreActivity;
        }

        @Override // c.a.p0.a3.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f56377a.goToBack();
                } else if (i2 == 1) {
                    this.f56377a.goToPersonInfo();
                } else if (i2 == 15) {
                    this.f56377a.goToInterestSetting();
                } else if (i2 == 2) {
                    if (!c.a.o0.e1.b.e.d()) {
                        this.f56377a.goToAccountManager();
                    } else {
                        l.L(this.f56377a.getPageContext().getPageActivity(), R.string.youngster_settings_logout);
                    }
                } else if (i2 == 3) {
                    this.f56377a.goToBrowseSetting();
                } else if (i2 == 16) {
                    this.f56377a.goToAdSetting();
                } else if (i2 == 4) {
                    this.f56377a.goToMessage();
                } else if (i2 == 6) {
                    this.f56377a.goToAbout();
                } else if (i2 == 7) {
                    this.f56377a.goToFeedBack();
                } else if (i2 == 8) {
                    this.f56377a.goToRecommend();
                } else if (i2 == 5) {
                    this.f56377a.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(this.f56377a.getPageContext().getPageActivity())));
                } else if (i2 == 9) {
                    this.f56377a.goToSecretSettings();
                } else if (i2 == 10) {
                    if (!c.a.o0.e1.b.e.d()) {
                        this.f56377a.mView.N();
                    } else {
                        l.L(this.f56377a.getPageContext().getPageActivity(), R.string.youngster_settings_logout);
                    }
                } else if (i2 == 12) {
                    MessageManager.getInstance().runTask(2921330, null, this.f56377a);
                } else if (i2 == 11) {
                    TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                    c.a.o0.e0.a.b(0, 0, 0, 2, 12);
                    BdSocketLinkService.close("exit app");
                    n.d().b();
                    c.a.o0.s.a0.b.g(this.f56377a.getPageContext().getPageActivity(), 12, false);
                } else if (i2 == 13) {
                    this.f56377a.goToAccountSafe();
                    TiebaStatic.log("c10017");
                } else if (i2 == 17) {
                    this.f56377a.goToYoungsterSetting();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56378a;

        public e(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56378a = moreActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.f56378a.mDiscoveryModel.getUser() != null) {
                    personChangeData.setName(this.f56378a.mDiscoveryModel.getUser().getUserName());
                    personChangeData.setIntro(this.f56378a.mDiscoveryModel.getUser().getIntro());
                    personChangeData.setPortrait(this.f56378a.mDiscoveryModel.getUser().getPortrait());
                    personChangeData.setSex(this.f56378a.mDiscoveryModel.getUser().getSex());
                    personChangeData.setNameShow(this.f56378a.mDiscoveryModel.getUser().getName_show());
                    personChangeData.setMem(this.f56378a.mDiscoveryModel.getUser().getIsMem());
                    personChangeData.setForumAge(this.f56378a.mDiscoveryModel.getUser().getTb_age());
                    personChangeData.setCanModifyAvatar(this.f56378a.mDiscoveryModel.getUser().canModifyAvatar());
                    personChangeData.setCantModifyAvatarDesc(this.f56378a.mDiscoveryModel.getUser().getCantModifyAvatarDesc());
                    personChangeData.setTiebaId(this.f56378a.mDiscoveryModel.getUser().getmTiebaUid());
                    if (this.f56378a.mDiscoveryModel.getUser().alaUserData != null) {
                        personChangeData.setAlaId(this.f56378a.mDiscoveryModel.getUser().alaUserData.ala_id);
                    }
                    if (this.f56378a.mDiscoveryModel.D() != null) {
                        personChangeData.setNickNameLeftDays(this.f56378a.mDiscoveryModel.D().left_days.intValue());
                    }
                    if (this.f56378a.mDiscoveryModel.getUser().getBirthdayInfo() != null) {
                        personChangeData.setUserAge(this.f56378a.mDiscoveryModel.getUser().getBirthdayInfo().f13960c);
                        personChangeData.setBirthdayTime(this.f56378a.mDiscoveryModel.getUser().getBirthdayInfo().f13958a);
                        personChangeData.setBirthdayShowStatus(this.f56378a.mDiscoveryModel.getUser().getBirthdayInfo().f13961d);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
                    this.f56378a.buildModel(personChangeData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreActivity f56379a;

        public f(MoreActivity moreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56379a = moreActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && (obj instanceof MoreModel.TaskType)) {
                if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                    MoreActivity moreActivity = this.f56379a;
                    moreActivity.showToast(moreActivity.getPageContext().getString(R.string.image_cash_del_suc));
                }
                this.f56379a.closeLoadingDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.this$0.mView.K();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mModel = null;
        this.receiver = null;
        this.mPersonInfoChangedListener = new a(this, CmdConfigHttp.CMD_GET_USER_INFO, 303024);
        this.mGetMemberPayinfoListener = new b(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.mModifyNicknameSucceedListener = new c(this, 2921033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildModel(PersonChangeData personChangeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, personChangeData) == null) {
            if (personChangeData != null && personChangeData.getPortrait() != null) {
                this.mView.B(HeadIconRefreshHelper.headPortraitFilter(personChangeData.getPortrait()), false);
            }
            MoreModel moreModel = new MoreModel(personChangeData);
            this.mModel = moreModel;
            moreModel.setLoadDataCallBack(new f(this));
        }
    }

    private c.a.p0.a3.c.d getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? new d(this) : (c.a.p0.a3.c.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAbout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((currentAccount == null || currentAccount.length() <= 0) && c.a.o0.s.l.c.d() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
            } else {
                sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAccountSafe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            MessageManager.getInstance().runTask(2921329, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAdSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            sendMessage(new CustomMessage(2002001, new AdSettingActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            passPersonInfoChange();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBrowseSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToFeedBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToInterestSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            sendMessage(new CustomMessage(2002001, new MsgRemindActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPersonInfo() {
        String currentAccount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || (currentAccount = TbadkCoreApplication.getCurrentAccount()) == null || currentAccount.length() <= 0) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.mModel.w(), Boolean.FALSE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToRecommend() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
            TiebaStatic.log(new StatisticItem("c14001").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToYoungsterSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            if (c.a.o0.e1.b.e.d()) {
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
    }

    private void initModel(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, bundle) == null) {
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
                this.mDiscoveryModel.N(TbadkCoreApplication.getCurrentAccount());
                this.mDiscoveryModel.setLoadDataCallBack(new e(this));
                this.mDiscoveryModel.C(false, true);
            }
            buildModel(personChangeData);
            this.mFriendAndStrangerSwitchModel = new GetFriendAndStrangerSwitchModel(this);
            this.mGetImageWatermarkTypeModel = new GetImageWatermarkTypeModel(this);
        }
    }

    private void passPersonInfoChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65570, this) == null) && this.mModel.x()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.mModel.w());
            setResult(-1, intent);
        }
    }

    private void refreshPortrait() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            c.a.o0.a0.b.a().d();
        }
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.receiver = new g(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.receiver, intentFilter);
        }
    }

    private void unregReceiver() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || (gVar = this.receiver) == null) {
            return;
        }
        unregisterReceiver(gVar);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        c.a.p0.a3.c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) || view == null || (eVar = this.mView) == null) {
            return;
        }
        if (view == eVar.w()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                UtilHelper.showSkinChangeAnimation(this);
                UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.CAM_X0201_1));
                this.mView.L(1);
            } else {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
        }
        if (view == this.mView.y()) {
            c.a.o0.s.d0.b.j().t("key_is_dark_mode_notify_shown", true);
            c.a.o0.s.d0.b.j().t("key_is_follow_system_mode", BdSwitchView.SwitchState.ON == switchState);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DARK_MODE_FOLLOW_SYSTEM).param("obj_type", BdSwitchView.SwitchState.ON == switchState ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
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
                this.mModel.y(personChangeData);
                this.mModel.z(true);
                if (this.mDiscoveryModel != null) {
                    refreshPortrait();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new c.a.p0.a3.c.e(this, getItemClickListener());
            initModel(bundle);
            regReceiver();
            registerListener(this.mPersonInfoChangedListener);
            registerListener(this.mGetMemberPayinfoListener);
            registerListener(this.mModifyNicknameSucceedListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            unregReceiver();
            c.a.p0.a3.c.e eVar = this.mView;
            if (eVar != null) {
                eVar.u();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                goToBack();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setSkinType(-1);
            this.mView.J();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            c.a.p0.a3.c.e eVar = this.mView;
            if (eVar != null) {
                eVar.K();
                this.mView.D();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            bundle.putSerializable("person_change_data", OrmObject.jsonStrWithObject(this.mModel.w()));
            super.onSaveInstanceState(bundle);
        }
    }
}
