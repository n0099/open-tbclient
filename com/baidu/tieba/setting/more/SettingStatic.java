package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.AppsActivityConfig;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.more.youngster.YoungsterIntroduceActivity;
import com.baidu.tieba.setting.more.youngster.YoungsterPasswordActivity;
import com.baidu.tieba.setting.more.youngster.YoungsterVerifyActivity;
import com.baidu.tieba.setting.more.youngster.message.YoungsterVerifyHttpResponsedMessage;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivity;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.tieba.setting.privacy.PrivacyPermissionActivity;
import com.baidu.tieba.setting.usermutelist.UserMuteListActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.MaskInfo;
/* loaded from: classes5.dex */
public class SettingStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static MaskInfo f20762a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f20763b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f20764c;

    /* renamed from: d  reason: collision with root package name */
    public static final d.a.c.c.g.c f20765d;

    /* renamed from: e  reason: collision with root package name */
    public static final CustomMessageListener f20766e;

    /* renamed from: f  reason: collision with root package name */
    public static final CustomMessageListener f20767f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MaskInfo maskInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !(socketResponsedMessage instanceof ResponseOnlineMessage) || (maskInfo = ((ResponseOnlineMessage) socketResponsedMessage).getMaskInfo()) == null) {
                return;
            }
            MaskInfo unused = SettingStatic.f20762a = maskInfo;
            SettingStatic.k();
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                boolean unused = SettingStatic.f20764c = false;
                MaskInfo unused2 = SettingStatic.f20762a = null;
                boolean unused3 = SettingStatic.f20763b = false;
                d.a.r0.z.b.a().d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                boolean unused = SettingStatic.f20763b = true;
                SettingStatic.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.r0.s.d.d.d().A();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    Context data = customMessage.getData();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
                    TbadkCoreApplication.getInst().deleteAccountAllInfo(currentAccount);
                    d.a.r0.s.a.a.b().a();
                    d.a.r0.r.z.a.a("account", -1L, 0, "logout_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, data);
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(data, true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(MoreActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(SecretSettingActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements CustomMessageTask.CustomRunnable<UserMuteListActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<UserMuteListActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(UserMuteListActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-379622294, "Lcom/baidu/tieba/setting/more/SettingStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-379622294, "Lcom/baidu/tieba/setting/more/SettingStatic;");
                return;
            }
        }
        f20765d = new a(1001);
        f20766e = new b(2005016);
        f20767f = new c(2001311);
        TbadkCoreApplication.getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(YoungsterIntroduceActivityConfig.class, YoungsterIntroduceActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(YoungsterPasswordActivityConfig.class, YoungsterPasswordActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(YoungsterVerifyActivityConfig.class, YoungsterVerifyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AdSettingActivityConfig.class, AdSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgReceiveActivityConfig.class, MsgReceiveActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PrivacyPermissionActivityConfig.class, PrivacyPermissionActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(OfficialAccountPushActivityConfig.class, OfficialAccountPushActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PrivacyMarkActivityConfig.class, PrivacyMarkActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ForbiddenForumActivityConfig.class, ForbiddenForumActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2015007, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        d.a.s0.h3.d0.a.f(303016, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, d.a.s0.h3.d0.a.a(TbConfig.GET_PRIVATE_INFO, 303016));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(f20766e);
        MessageManager.getInstance().registerListener(f20765d);
        MessageManager.getInstance().registerListener(f20767f);
        d.a.s0.h3.d0.a.f(104101, ResponseUpdateMaskMessage.class, false);
        d.a.s0.h3.d0.a.f(104106, ResponseUpdateForumMask.class, false);
        e();
        f();
        i();
        g();
        h();
        SwitchManager.getInstance().registerSwitch(d.a.s0.z2.b.a.b.class);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2016302, new h());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        j();
    }

    public SettingStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.FRIEND_AND_STRANGER_MSG_SWITCH);
            tbHttpMessageTask.setResponsedClass(FriendAndStrangerSwitchResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.GET_FRIEND_AND_STRANGER_MSG_SWITCH);
            tbHttpMessageTask.setResponsedClass(GetFriendAndStrangerSwitchResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.GET_IMAGE_WATERMARK_TYPE);
            tbHttpMessageTask.setResponsedClass(GetImageWatermarkTypeResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921330, new e());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.SET_IMAGE_WATERMARK_TYPE);
            tbHttpMessageTask.setResponsedClass(SetImageWatermarkTypeResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID, TbConfig.SERVER_ADDRESS + TbConfig.URL_YOUNGSTER_VERIFY_AUTHID);
            tbHttpMessageTask.setResponsedClass(YoungsterVerifyHttpResponsedMessage.class);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a8 A[LOOP:0: B:103:0x01a6->B:104:0x01a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cf A[LOOP:1: B:112:0x01cd->B:113:0x01cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f6 A[LOOP:2: B:121:0x01f4->B:122:0x01f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void k() {
        boolean z;
        boolean z2;
        Integer num;
        String[] split;
        String[] split2;
        String[] split3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, null) == null) || !f20763b || f20762a == null || f20764c) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return;
        }
        MaskInfo maskInfo = f20762a;
        Integer num2 = maskInfo.remindMask;
        if (num2 != null && maskInfo.shieldStatus != null && num2.intValue() == 0 && f20762a.shieldStatus.intValue() == 0) {
            if (!d.a.r0.r.d0.b.j().g("had_sync_setting_switch" + currentAccount, false)) {
                z = true;
                if (!z) {
                    d.a.r0.r.d0.b.j().t("had_sync_setting_switch" + currentAccount, true);
                    if (!d.a.r0.s.d.d.d().s()) {
                        l(14, false);
                    } else {
                        if (!d.a.r0.s.d.d.d().o()) {
                            l(2, false);
                        }
                        if (!d.a.r0.s.d.d.d().r()) {
                            l(3, false);
                        }
                        if (!d.a.r0.s.d.d.d().n()) {
                            l(4, false);
                        }
                        if (!d.a.r0.s.d.d.d().p()) {
                            l(5, false);
                        }
                        if (!d.a.r0.s.d.d.d().t()) {
                            l(1, false);
                        }
                        if (!d.a.r0.s.d.d.d().w()) {
                            l(20, false);
                        }
                    }
                } else {
                    Integer num3 = f20762a.remindMask;
                    if (num3 != null) {
                        if (num3.intValue() == 0) {
                            d.a.r0.s.d.d.d().B(true);
                        } else if (f20762a.remindMask.intValue() == 1) {
                            d.a.r0.s.d.d.d().B(false);
                            z2 = false;
                            num = f20762a.shieldStatus;
                            if (num != null) {
                                int intValue = num.intValue();
                                boolean z3 = (intValue & 16) == 0;
                                d.a.r0.s.d.d.d().D(z3);
                                boolean z4 = (intValue & 1) == 0;
                                d.a.r0.s.d.d.d().H(z4);
                                boolean z5 = (intValue & 2) == 0;
                                d.a.r0.s.d.d.d().C(z5);
                                boolean z6 = (intValue & 4) == 0;
                                d.a.r0.s.d.d.d().G(z6);
                                d.a.r0.s.d.d.d().P((intValue & 2048) == 0);
                                boolean z7 = (intValue & 4096) == 0;
                                d.a.r0.s.d.d.d().K(z7);
                                if (z4 || z5 || z6 || z3 || z2 || z7) {
                                    d.a.r0.s.d.d.d().E(300);
                                } else {
                                    d.a.r0.s.d.d.d().E(0);
                                }
                            }
                            d.a.c.e.m.h.a().b(new d());
                        }
                    }
                    z2 = true;
                    num = f20762a.shieldStatus;
                    if (num != null) {
                    }
                    d.a.c.e.m.h.a().b(new d());
                }
                if (!TextUtils.isEmpty(f20762a.maskFids) && (split3 = f20762a.maskFids.split(",")) != null && split3.length > 0) {
                    for (String str : split3) {
                        d.a.s0.i1.t.d.j().g(currentAccount, str, false, null);
                    }
                }
                if (!TextUtils.isEmpty(f20762a.maskGids) && (split2 = f20762a.maskGids.split(",")) != null && split2.length > 0) {
                    for (String str2 : split2) {
                        d.a.s0.i1.t.b.k().g(currentAccount, str2, false, null);
                    }
                }
                if (!TextUtils.isEmpty(f20762a.maskUids) && (split = f20762a.maskUids.split(",")) != null && split.length > 0) {
                    for (String str3 : split) {
                        d.a.s0.i1.t.e.j().g(currentAccount, str3, false, null);
                    }
                }
                f20764c = true;
            }
        }
        z = false;
        if (!z) {
        }
        if (!TextUtils.isEmpty(f20762a.maskFids)) {
            while (r7 < r6) {
            }
        }
        if (!TextUtils.isEmpty(f20762a.maskGids)) {
            while (r7 < r6) {
            }
        }
        if (!TextUtils.isEmpty(f20762a.maskUids)) {
            while (r6 < r3) {
            }
        }
        f20764c = true;
    }

    public static final void l(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                MessageManager.getInstance().sendMessage(requestUpdateMaskMessage);
                return;
            }
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(i2);
            requestUpdateMaskInfoMessage.setSettingMask(z);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }
}
