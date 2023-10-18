package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.data.ResponeDelAllUserDataHttpResMsg;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.f95;
import com.baidu.tieba.ib;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.r65;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeResMsg;
import com.baidu.tieba.setting.more.youngster.message.YoungsterVerifyHttpResponsedMessage;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushHttpResponseMessage;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushRequestMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.tieba.setting.privacy.PrivacyPermissionActivity;
import com.baidu.tieba.tg8;
import com.baidu.tieba.vg8;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import protobuf.MaskInfo;
import protobuf.PushSignMask;
/* loaded from: classes8.dex */
public class SettingStatic {
    public static /* synthetic */ Interceptable $ic;
    public static MaskInfo a;
    public static boolean b;
    public static boolean c;
    public static final SocketMessageListener d;
    public static final CustomMessageListener e;
    public static final CustomMessageListener f;
    public static NetMessageListener g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MaskInfo maskInfo;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !(socketResponsedMessage instanceof ResponseOnlineMessage) || (maskInfo = ((ResponseOnlineMessage) socketResponsedMessage).getMaskInfo()) == null) {
                return;
            }
            MaskInfo unused = SettingStatic.a = maskInfo;
            SettingStatic.p();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            boolean unused = SettingStatic.c = false;
            MaskInfo unused2 = SettingStatic.a = null;
            boolean unused3 = SettingStatic.b = false;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            boolean unused = SettingStatic.b = true;
            SettingStatic.p();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
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
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                ArrayList<OfficialAccountPushInfo> arrayList = new ArrayList<>();
                if (responsedMessage instanceof OfficialAccountPushHttpResponseMessage) {
                    arrayList = ((OfficialAccountPushHttpResponseMessage) responsedMessage).getList();
                }
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    OfficialAccountPushInfo next = it.next();
                    if (next.uid == 1501754229) {
                        if (next.is_on == 1) {
                            z = true;
                        }
                    }
                }
                f95.e().a0(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f95.e().J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    wu4.t().g(TbadkCoreApplication.getCurrentAccount(), true);
                    r65.b().a();
                    Logger.addLog("account", -1L, 0, "logout_delete_account", 0, "", new Object[0]);
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

    /* loaded from: classes8.dex */
    public class g implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes8.dex */
    public class h implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes8.dex */
    public class i implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    MessageManager.getInstance().sendMessage(new OfficialAccountPushRequestMessage());
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
        d = new a(1001);
        e = new b(2005016);
        f = new c(2001311);
        g = new d(CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, 309620);
        TbadkCoreApplication.getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AdSettingActivityConfig.class, AdSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PrivacyPermissionActivityConfig.class, PrivacyPermissionActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PrivacyMarkActivityConfig.class, PrivacyMarkActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ForbiddenForumActivityConfig.class, ForbiddenForumActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2015007, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        xda.f(303016, ResponsedPrivacySocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, xda.a(TbConfig.GET_PRIVATE_INFO, 303016));
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(e);
        MessageManager.getInstance().registerListener(g);
        MessageManager.getInstance().registerListener(d);
        MessageManager.getInstance().registerListener(f);
        xda.f(104101, ResponseUpdateMaskMessage.class, false);
        xda.f(104106, ResponseUpdateForumMask.class, false);
        h();
        i();
        l();
        n();
        j();
        m();
        k();
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921695, new i());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        o();
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

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921330, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            xda.c(309620, CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, TbConfig.CHECK_OFFICIAL_SWITCH_URL, OfficialAccountPushHttpResponseMessage.class, true, false, true, false);
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            xda.c(309736, CmdConfigHttp.CMD_HTTP_ONEKEY_DELETION_HISTORY, TbConfig.URL_DELETE_USER_DATA, ResponeDelAllUserDataHttpResMsg.class, true, false, true, true);
        }
    }

    public static void e() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled();
            int k = f95.e().k();
            int l = f95.e().l();
            if (k > 9) {
                str = String.valueOf(k);
            } else {
                str = "0" + k;
            }
            if (l > 9) {
                str2 = String.valueOf(l);
            } else {
                str2 = "0" + l;
            }
            int i2 = 2;
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1415, new Object[]{str, str2});
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 1);
            if (areNotificationsEnabled) {
                i2 = 1;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            if (!f95.e().G()) {
                string = "";
            }
            TiebaStatic.log(param2.param("obj_param1", string).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", g()));
        }
    }

    public static String f(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("_");
            if (z) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            sb.append(i3);
            if (z2) {
                str = "-";
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return f(1, f95.e().B(), true) + f(2, f95.e().g, true) + f(3, f95.e().h, true) + f(4, f95.e().w(), true) + f(5, f95.e().t(), true) + f(6, f95.e().H(), true) + f(7, f95.e().p(), true) + f(8, f95.e().o(), true) + f(9, f95.e().G(), true) + f(10, f95.e().F(), true) + f(13, f95.e().q(), true) + f(11, f95.e().s(), false) + f(35, f95.e().u(), false);
        }
        return (String) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.FRIEND_AND_STRANGER_MSG_SWITCH);
            tbHttpMessageTask.setResponsedClass(FriendAndStrangerSwitchResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH, TbConfig.SERVER_ADDRESS + TbConfig.GET_FRIEND_AND_STRANGER_MSG_SWITCH);
            tbHttpMessageTask.setResponsedClass(GetFriendAndStrangerSwitchResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.GET_IMAGE_WATERMARK_TYPE);
            tbHttpMessageTask.setResponsedClass(GetImageWatermarkTypeResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_IMAGE_WATERMARK_TYPE, TbConfig.SERVER_ADDRESS + TbConfig.SET_IMAGE_WATERMARK_TYPE);
            tbHttpMessageTask.setResponsedClass(SetImageWatermarkTypeResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID, TbConfig.SERVER_ADDRESS + TbConfig.URL_YOUNGSTER_VERIFY_AUTHID);
            tbHttpMessageTask.setResponsedClass(YoungsterVerifyHttpResponsedMessage.class);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022c A[LOOP:0: B:135:0x022a->B:136:0x022c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0253 A[LOOP:1: B:144:0x0251->B:145:0x0253, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x027a A[LOOP:2: B:153:0x0278->B:154:0x027a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void p() {
        boolean z;
        boolean z2;
        Integer num;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        PushSignMask pushSignMask;
        boolean z14;
        PushSignMask pushSignMask2;
        long j;
        String[] split;
        String[] split2;
        String[] split3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, null) == null) && b && a != null && !c) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                return;
            }
            MaskInfo maskInfo = a;
            Integer num2 = maskInfo.remindMask;
            if (num2 != null && maskInfo.shieldStatus != null && num2.intValue() == 0 && a.shieldStatus.intValue() == 0) {
                if (!SharedPrefHelper.getInstance().getBoolean("had_sync_setting_switch" + currentAccount, false)) {
                    z = true;
                    if (!z) {
                        SharedPrefHelper.getInstance().putBoolean("had_sync_setting_switch" + currentAccount, true);
                        if (!f95.e().A()) {
                            q(14, false);
                        } else {
                            if (!f95.e().w()) {
                                q(2, false);
                            }
                            if (!f95.e().z()) {
                                q(3, false);
                            }
                            if (!f95.e().v()) {
                                q(4, false);
                            }
                            if (!f95.e().u()) {
                                q(35, false);
                            }
                            if (!f95.e().x()) {
                                q(5, false);
                            }
                            if (!f95.e().B()) {
                                q(1, false);
                            }
                            if (!f95.e().E()) {
                                q(20, false);
                            }
                            if (!f95.e().F()) {
                                q(30, false);
                            }
                        }
                    } else {
                        Integer num3 = a.remindMask;
                        if (num3 != null) {
                            if (num3.intValue() == 0) {
                                f95.e().N(true);
                            } else if (a.remindMask.intValue() == 1) {
                                f95.e().N(false);
                                z2 = false;
                                num = a.shieldStatus;
                                if (num != null) {
                                    int intValue = num.intValue();
                                    if ((intValue & 16) == 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    f95.e().P(z3);
                                    if ((intValue & 1) == 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    f95.e().T(z4);
                                    if ((intValue & 2) == 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    f95.e().O(z5);
                                    if ((intValue & 4) == 0) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    f95.e().S(z6);
                                    if ((intValue & 2048) == 0) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    f95.e().b0(z7);
                                    if ((intValue & 16384) == 0) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    f95.e().c0(z8);
                                    if ((intValue & 4096) == 0) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    f95.e().W(z9);
                                    if ((intValue & 8192) != 0) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    f95.e().Y(z10);
                                    if ((65536 & intValue) == 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    f95.e().M(z11);
                                    if ((intValue & 131072) == 0) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    f95.e().K(z12);
                                    if (!z4 && !z5 && !z6 && !z3 && !z2 && !z9) {
                                        z13 = false;
                                    } else {
                                        z13 = true;
                                    }
                                    if (z13) {
                                        f95.e().Q(300);
                                    } else {
                                        f95.e().Q(0);
                                    }
                                }
                                ib.a().b(new e());
                            }
                        }
                        z2 = true;
                        num = a.shieldStatus;
                        if (num != null) {
                        }
                        ib.a().b(new e());
                    }
                    pushSignMask = a.signMask;
                    if (pushSignMask == null && pushSignMask.signPushMask.intValue() == 1) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (a.signMask == null) {
                        j = pushSignMask2.signPushTimeStamp.intValue() * 1000;
                    } else {
                        j = 0;
                    }
                    f95.e().h0(z14, j);
                    if (!TextUtils.isEmpty(a.maskFids) && (split3 = a.maskFids.split(",")) != null && split3.length > 0) {
                        for (String str : split3) {
                            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(currentAccount, str, false, null);
                        }
                    }
                    if (!TextUtils.isEmpty(a.maskGids) && (split2 = a.maskGids.split(",")) != null && split2.length > 0) {
                        for (String str2 : split2) {
                            tg8.a().saveAcceptNotifyAsync(currentAccount, str2, false, null);
                        }
                    }
                    if (!TextUtils.isEmpty(a.maskUids) && (split = a.maskUids.split(",")) != null && split.length > 0) {
                        for (String str3 : split) {
                            vg8.a().saveAcceptNotifyAsync(currentAccount, str3, false, null);
                        }
                    }
                    e();
                    c = true;
                }
            }
            z = false;
            if (!z) {
            }
            pushSignMask = a.signMask;
            if (pushSignMask == null) {
            }
            z14 = false;
            if (a.signMask == null) {
            }
            f95.e().h0(z14, j);
            if (!TextUtils.isEmpty(a.maskFids)) {
                while (r7 < r6) {
                }
            }
            if (!TextUtils.isEmpty(a.maskGids)) {
                while (r7 < r6) {
                }
            }
            if (!TextUtils.isEmpty(a.maskUids)) {
                while (r6 < r3) {
                }
            }
            e();
            c = true;
        }
    }

    public static final void q(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
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
