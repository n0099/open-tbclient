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
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.i9;
import com.baidu.tieba.p8a;
import com.baidu.tieba.play.VideoPostionCacheManager;
import com.baidu.tieba.pn5;
import com.baidu.tieba.q8a;
import com.baidu.tieba.rl5;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.model.MoreDiscoveryModel;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel;
import com.baidu.tieba.sl5;
import com.baidu.tieba.zpa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MoreActivity extends BaseActivity<MoreActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q8a a;
    public MoreModel b;
    public MoreDiscoveryModel c;
    public g d;
    public List<Integer> e;
    public boolean f;
    public NetMessageListener g;
    public HttpMessageListener h;
    public CustomMessageListener i;
    public GetFriendAndStrangerSwitchModel j;
    public GetImageWatermarkTypeModel k;

    /* loaded from: classes8.dex */
    public class a extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getError() == 0) {
                boolean z = responsedMessage instanceof GetUserInfoHttpResponseMessage;
                if (!z && !(responsedMessage instanceof GetUserInfoSocketResponseMessage)) {
                    return;
                }
                rl5 rl5Var = null;
                if (z) {
                    rl5Var = ((GetUserInfoHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof GetUserInfoSocketResponseMessage) {
                    rl5Var = ((GetUserInfoSocketResponseMessage) responsedMessage).getData();
                }
                if (rl5Var != null && rl5Var.a() != null) {
                    String portrait = rl5Var.a().getPortrait();
                    this.a.a.U(portrait, false);
                    PersonChangeData M = this.a.b.M();
                    if (M != null) {
                        M.setPhotoChanged(true);
                        M.setPortrait(portrait);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                if (statusCode == 200 && error == 0 && this.a.c != null) {
                    this.a.c.S(false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && this.a.c != null) {
                    this.a.c.S(false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements p8a {
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

        @Override // com.baidu.tieba.p8a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.Y1(i)) {
                return;
            }
            if (i == 0) {
                this.a.O1();
            } else if (i == 1) {
                this.a.U1();
            } else if (i == 15) {
                this.a.S1();
            } else if (i == 2) {
                this.a.L1();
            } else if (i == 3) {
                this.a.P1();
            } else if (i == 16) {
                this.a.N1();
            } else if (i == 4) {
                this.a.T1();
            } else if (i == 6) {
                this.a.K1();
            } else if (i == 7) {
                this.a.R1();
            } else if (i == 5) {
                this.a.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(this.a.getPageContext().getPageActivity())));
            } else if (i == 9) {
                this.a.W1();
            } else if (i == 10) {
                this.a.a.a0();
            } else if (i == 12) {
                MessageManager.getInstance().runTask(2921330, null, this.a);
            } else if (i == 11) {
                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                pn5.b(0, 0, 0, 2, 12);
                BdSocketLinkService.close("exit app");
                VideoPostionCacheManager.getInstance().clear();
                MainEntrance.goToMainTabRefresh(this.a.getPageContext().getPageActivity(), 12, false);
            } else if (i == 13) {
                this.a.M1();
                TiebaStatic.log("c10017");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.a.c.getUser() != null) {
                    personChangeData.setUserId(this.a.c.getUser().getUserId());
                    personChangeData.setName(this.a.c.getUser().getUserName());
                    personChangeData.setIntro(this.a.c.getUser().getIntro());
                    personChangeData.setPortrait(this.a.c.getUser().getPortrait());
                    personChangeData.setSex(this.a.c.getUser().getSex());
                    personChangeData.setNameShow(this.a.c.getUser().getName_show());
                    personChangeData.setMem(this.a.c.getUser().getIsMem());
                    personChangeData.setForumAge(this.a.c.getUser().getTb_age());
                    personChangeData.setCanModifyAvatar(this.a.c.getUser().canModifyAvatar());
                    personChangeData.setCantModifyAvatarDesc(this.a.c.getUser().getCantModifyAvatarDesc());
                    personChangeData.setTiebaId(this.a.c.getUser().getmTiebaUid());
                    if (this.a.c.getUser().getBusinessAccountData() != null) {
                        if (this.a.c.getUser().getBusinessAccountData().isBusinessAccount) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        personChangeData.setIsBusinessAccount(str);
                    }
                    if (this.a.c.getUser().alaUserData != null) {
                        personChangeData.setAlaId(this.a.c.getUser().alaUserData.ala_id);
                    }
                    if (this.a.c.T() != null) {
                        personChangeData.setNickNameLeftDays(this.a.c.T().left_days.intValue());
                    }
                    if (this.a.c.getUser().getBirthdayInfo() != null) {
                        personChangeData.setUserAge(this.a.c.getUser().getBirthdayInfo().c);
                        personChangeData.setBirthdayTime(this.a.c.getUser().getBirthdayInfo().a);
                        personChangeData.setBirthdayShowStatus(this.a.c.getUser().getBirthdayInfo().d);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
                    this.a.H1(personChangeData);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && (obj instanceof MoreModel.TaskType)) {
                if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                    MoreActivity moreActivity = this.a;
                    moreActivity.showToast(moreActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a75));
                }
                this.a.closeLoadingDialog();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        public /* synthetic */ g(MoreActivity moreActivity, a aVar) {
            this(moreActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.a.Y();
            }
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
        this.b = null;
        this.d = null;
        this.f = false;
        this.g = new a(this, CmdConfigHttp.CMD_GET_USER_INFO, 303024);
        this.h = new b(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.i = new c(this, 2921033);
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((currentAccount == null || currentAccount.length() <= 0) && AccountStorage.getAccountNum() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 11003)));
            } else {
                sendMessage(new CustomMessage(2015006, new IntentConfig(getPageContext().getPageActivity())));
            }
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                String currSoLoaded = SoLoadUtils.getCurrSoLoaded();
                String currSoDownloaded = SoLoadUtils.getCurrSoDownloaded();
                Logger.addLog("write", 100L, 0, "MoreActivity_goToFeedBack", 1, currSoLoaded + ":" + currSoDownloaded, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            startActivity(zpa.a());
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SUGGEST_FEEDBACK_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void U1() {
        String currentAccount;
        MoreModel moreModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (currentAccount = TbadkCoreApplication.getCurrentAccount()) != null && currentAccount.length() > 0 && (moreModel = this.b) != null && I1(moreModel.M())) {
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, this.b.M(), Boolean.FALSE)));
        }
    }

    public final void H1(PersonChangeData personChangeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, personChangeData) == null) {
            if (personChangeData != null && personChangeData.getPortrait() != null) {
                this.a.U(personChangeData.getPortrait(), false);
            }
            MoreModel moreModel = new MoreModel(personChangeData);
            this.b = moreModel;
            moreModel.setLoadDataCallBack(new f(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            super.onChangeSkinType(i);
            UtilHelper.setNavigationBarBg(getActivity(), SkinManager.getColor(R.color.CAM_X0201));
            this.a.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            bundle.putSerializable(PersonChangeData.TAG_PERSON_INFO, OrmObject.jsonStrWithObject(this.b.M()));
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, keyEvent)) == null) {
            if (i == 4) {
                O1();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final boolean I1(PersonChangeData personChangeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personChangeData)) == null) {
            if (personChangeData != null && (!TextUtils.isEmpty(personChangeData.getUserId()) || !TextUtils.isEmpty(personChangeData.getName()) || !TextUtils.isEmpty(personChangeData.getPortrait()) || !TextUtils.isEmpty(personChangeData.getmTiebaId()))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if ((getIntent() != null && getIntent().getBooleanExtra("not_need_account", false)) || this.e.contains(Integer.valueOf(i))) {
                return false;
            }
            return !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this, LoginDialogData.SETTING_PAGE));
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new q8a(this, J1());
            X1(bundle);
            b2();
            registerListener(this.g);
            registerListener(this.h);
            registerListener(this.i);
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            super.onUserChanged(z);
            if (z && !this.f) {
                MoreDiscoveryModel moreDiscoveryModel = this.c;
                if (moreDiscoveryModel != null) {
                    moreDiscoveryModel.S(false, true);
                }
                if (this.j != null) {
                    this.j = new GetFriendAndStrangerSwitchModel(this);
                }
                if (this.k != null) {
                    this.k = new GetImageWatermarkTypeModel(this);
                }
                q8a q8aVar = this.a;
                if (q8aVar != null) {
                    q8aVar.b0();
                    this.a.d0();
                }
            }
        }
    }

    public final p8a J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new d(this);
        }
        return (p8a) invokeV.objValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sendMessage(new CustomMessage(2002001, new AboutActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().runTask(2921329, null, this);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Z1();
            finish();
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sendMessage(new CustomMessage(2002001, new BrowseSettingActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this);
            interestGuideActivityConfig.setIsBackToMainTab(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.b.N()) {
            Intent intent = new Intent();
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.b.M());
            setResult(-1, intent);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            sl5.d().h();
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.d = new g(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.d, intentFilter);
        }
    }

    public final void c2() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (gVar = this.d) != null) {
            unregisterReceiver(gVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            c2();
            q8a q8aVar = this.a;
            if (q8aVar != null) {
                q8aVar.N();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            setSkinType(-1);
            this.a.X();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            q8a q8aVar = this.a;
            if (q8aVar != null) {
                q8aVar.Y();
                this.a.W();
            }
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdSettingActivityConfig adSettingActivityConfig = new AdSettingActivityConfig(this);
            MoreDiscoveryModel moreDiscoveryModel = this.c;
            if (moreDiscoveryModel != null && moreDiscoveryModel.getUser() != null && this.c.getUser().getShakeAdSwitch() != null) {
                adSettingActivityConfig.setShakeAdData(this.c.getUser().getShakeAdSwitch());
            }
            sendMessage(new CustomMessage(2002001, adSettingActivityConfig));
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MsgRemindActivityConfig msgRemindActivityConfig = new MsgRemindActivityConfig(getPageContext().getPageActivity());
            if (getIntent() != null && getIntent().getBooleanExtra("not_need_account", false)) {
                msgRemindActivityConfig.getIntent().putExtra("not_need_account", true);
            }
            sendMessage(new CustomMessage(2002001, msgRemindActivityConfig));
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(getPageContext().getPageActivity())));
            TiebaStatic.log(new StatisticItem("c14001").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            arrayList.add(17);
            this.e.add(17);
            this.e.add(16);
            this.e.add(6);
            this.e.add(0);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void R(View view2, BdSwitchView.SwitchState switchState) {
        q8a q8aVar;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, switchState) == null) && view2 != null && (q8aVar = this.a) != null) {
            if (view2 == q8aVar.P()) {
                this.a.R().h();
                if (BdSwitchView.SwitchState.ON == switchState) {
                    UtilHelper.showSkinChangeAnimation(this);
                    UtilHelper.setNavigationBarBackground(this, getResources().getColor(R.color.CAM_X0201_2));
                    this.a.Z(4);
                } else {
                    SharedPrefHelper.getInstance().putBoolean("key_is_follow_system_mode", false);
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                }
            }
            if (view2 == this.a.R()) {
                SharedPrefHelper.getInstance().putBoolean("key_is_dark_mode_notify_shown", true);
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                sharedPrefHelper.putBoolean("key_is_follow_system_mode", z);
                if (BdSwitchView.SwitchState.ON == switchState) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DARK_MODE_FOLLOW_SYSTEM);
                if (BdSwitchView.SwitchState.ON == switchState) {
                    i = 1;
                } else {
                    i = 2;
                }
                TiebaStatic.log(statisticItem.param("obj_type", i).param("obj_locate", 1));
            }
        }
    }

    public final void X1(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            if (bundle != null) {
                String string = bundle.getString(PersonChangeData.TAG_PERSON_INFO);
                if (!StringUtils.isNull(string)) {
                    personChangeData = (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class);
                } else {
                    personChangeData = null;
                }
            } else {
                personChangeData = (PersonChangeData) getIntent().getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
            }
            if (personChangeData == null) {
                MoreDiscoveryModel moreDiscoveryModel = new MoreDiscoveryModel(this);
                this.c = moreDiscoveryModel;
                moreDiscoveryModel.setUniqueId(getUniqueId());
                this.c.d0(TbadkCoreApplication.getCurrentAccount());
                this.c.setLoadDataCallBack(new e(this));
                if (TbadkCoreApplication.isLogin()) {
                    this.f = true;
                    this.c.S(false, true);
                }
            }
            H1(personChangeData);
            if (TbadkCoreApplication.isLogin()) {
                this.f = true;
                this.j = new GetFriendAndStrangerSwitchModel(this);
                this.k = new GetImageWatermarkTypeModel(this);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i != 101) {
                    if (i == 12008) {
                        R1();
                        return;
                    }
                    return;
                }
                PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                if (personChangeData == null) {
                    return;
                }
                this.b.O(personChangeData);
                this.b.P(true);
                if (this.c != null) {
                    a2();
                }
            }
        }
    }
}
