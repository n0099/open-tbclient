package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.apkabtest.ApkAbTestHelper;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.yunpush.BaiduYunPushMessageReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class kb5 {
    public static /* synthetic */ Interceptable $ic;
    public static kb5 f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public n5 b;
    public UpdateClientInfoMessage c;
    public int d;
    public final n5 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947907339, "Lcom/baidu/tieba/kb5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947907339, "Lcom/baidu/tieba/kb5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements n5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb5 a;

        public a(kb5 kb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kb5Var;
        }

        @Override // com.baidu.tieba.n5
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.b != null) {
                this.a.b.a(str);
            }
        }

        @Override // com.baidu.tieba.n5
        public void c(ud udVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, udVar) == null) && this.a.b != null) {
                this.a.b.c(udVar);
            }
        }

        @Override // com.baidu.tieba.n5
        public void d(ce ceVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, ceVar) == null) && this.a.b != null) {
                this.a.b.d(ceVar);
            }
        }

        @Override // com.baidu.tieba.n5
        public boolean b(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
                zh5.b(0, 2, 0, 0, 0);
                if (this.a.b != null) {
                    this.a.b.b(i, str);
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tieba.n5
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                zh5.b(0, 1, 0, 0, 0);
                if (this.a.b != null) {
                    this.a.b.g(map);
                }
                if (!f95.e().f()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921695, ""));
                }
                i5.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
                if (PerformanceLoggerHelper.getInstance().isSmallFlow() && kb5.b(this.a) < 10) {
                    i5.e();
                }
                zh5.b(1001, 0, 0, 3, 0);
                kb5 kb5Var = this.a;
                kb5Var.c = kb5Var.i();
                MessageManager.getInstance().sendMessage(this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends z5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kb5 kb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb5Var, Integer.valueOf(i)};
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
            this.a = kb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w5
        /* renamed from: i */
        public SocketResponsedMessage g(SocketResponsedMessage socketResponsedMessage) {
            InterceptResult invokeL;
            long j;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
                if (socketResponsedMessage instanceof ResponseOnlineMessage) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getOrginalMessage() != null && (responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) {
                        i = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
                        j = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getClientLogID();
                    } else {
                        j = 0;
                        i = 0;
                    }
                    if (responseOnlineMessage.getError() == 0) {
                        this.a.m();
                        i5.b("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + this.a.a);
                        return socketResponsedMessage;
                    }
                    this.a.o(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    i5.b("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + this.a.a);
                    return null;
                }
                this.a.o(socketResponsedMessage.getCmd(), -1, null);
                return null;
            }
            return (SocketResponsedMessage) invokeL.objValue;
        }
    }

    public kb5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = new a(this);
        MessageManager.getInstance().addResponsedMessageRule(new b(this, 1001));
    }

    public static synchronized kb5 j() {
        InterceptResult invokeV;
        kb5 kb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (kb5.class) {
                if (f == null) {
                    synchronized (kb5.class) {
                        if (f == null) {
                            f = new kb5();
                        }
                    }
                }
                kb5Var = f;
            }
            return kb5Var;
        }
        return (kb5) invokeV.objValue;
    }

    public static /* synthetic */ int b(kb5 kb5Var) {
        int i = kb5Var.d + 1;
        kb5Var.d = i;
        return i;
    }

    public void p(n5 n5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, n5Var) == null) {
            this.b = n5Var;
        }
    }

    public final UpdateClientInfoMessage i() {
        InterceptResult invokeV;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
            if (lx9.b()) {
                updateClientInfoMessage.addUserInfo("model", DeviceInfoHelper.getModel());
                updateClientInfoMessage.addUserInfo("brand", Build.BRAND);
                updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
                updateClientInfoMessage.addUserInfo(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                updateClientInfoMessage.addUserInfo(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            } else {
                updateClientInfoMessage.addUserInfo(HttpRequest.NEED_DECRYPT, lx9.c());
                String g = lx9.g(HttpRequest.PHONE_IMEI);
                if (!TextUtils.isEmpty(g)) {
                    updateClientInfoMessage.addUserInfo(g, lx9.f());
                }
                String g2 = lx9.g("model");
                if (!TextUtils.isEmpty(g2)) {
                    updateClientInfoMessage.addUserInfo(g2, lx9.h());
                }
                String g3 = lx9.g("brand");
                if (!TextUtils.isEmpty(g3)) {
                    updateClientInfoMessage.addUserInfo(g3, lx9.e());
                }
                String g4 = lx9.g(HttpRequest.ANDROID_ID);
                if (!TextUtils.isEmpty(g4)) {
                    updateClientInfoMessage.addUserInfo(g4, lx9.d());
                }
            }
            if (kx9.b()) {
                updateClientInfoMessage.addUserInfo("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
            } else {
                updateClientInfoMessage.addUserInfo("need_cam_decrypt", kx9.c());
                String d = kx9.d("mac");
                if (!TextUtils.isEmpty(d)) {
                    updateClientInfoMessage.addUserInfo(d, kx9.e());
                }
            }
            String str = "2";
            updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_TYPE, "2");
            updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
            updateClientInfoMessage.addUserInfo("user_agent", WebviewHelper.getGlobalUserAgent());
            String clientId = TbadkCoreApplication.getClientId();
            if (clientId != null) {
                updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_ID, clientId);
            }
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                updateClientInfoMessage.addUserInfo(HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
            }
            String from = TbadkCoreApplication.getFrom();
            if (from != null && from.length() > 0) {
                updateClientInfoMessage.addUserInfo("from", from);
            }
            if (NetTypeFixedSwitch.isOn()) {
                updateClientInfoMessage.addUserInfo("net_type", String.valueOf(BdNetTypeUtil.netType()));
            } else {
                String netType = NetWorkUtil.getNetType();
                if (netType != null) {
                    updateClientInfoMessage.addUserInfo("net_type", netType);
                }
            }
            if (!NetDeleteSwitch.isOn() && (valueOf = String.valueOf(BdNetTypeUtil.netType())) != null) {
                updateClientInfoMessage.addUserInfo("net", valueOf);
            }
            updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
            updateClientInfoMessage.addUserInfo("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            updateClientInfoMessage.addUserInfo("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            updateClientInfoMessage.addUserInfo(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
            updateClientInfoMessage.addUserInfo(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            updateClientInfoMessage.addUserInfo("z_id", TbadkCoreApplication.getInst().getZid());
            updateClientInfoMessage.addUserInfo("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            updateClientInfoMessage.addUserInfo("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            updateClientInfoMessage.addUserInfo("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            updateClientInfoMessage.addUserInfo("naws_game_ver", TbadkCoreApplication.getInst().getNaws_game_ver());
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
            if (f95.e().g() > 0) {
                updateClientInfoMessage.addUserInfo("_msg_status", "0");
            } else {
                updateClientInfoMessage.addUserInfo("_msg_status", "1");
            }
            updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(uu4.c().e()));
            String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
            Log.i(BaiduYunPushMessageReceiver.TAG, "channel_id " + yunpushChannelId);
            if (!TextUtils.isEmpty(yunpushChannelId)) {
                updateClientInfoMessage.addUserInfo("channel_id", yunpushChannelId);
            }
            try {
                if (TbadkCoreApplication.isLogin()) {
                    AccountLoginCoreHelper.a parseBDUSS = AccountLoginCoreHelper.getInstance().parseBDUSS(TbadkCoreApplication.getCurrentBduss());
                    String a2 = xu4.a(TbadkCoreApplication.getCurrentAccountInfo());
                    if (parseBDUSS != null) {
                        updateClientInfoMessage.setBduss(parseBDUSS.a, a2);
                    } else {
                        updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), a2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int dip2px = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f);
            updateClientInfoMessage.setHeight(BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f));
            updateClientInfoMessage.setWidth(dip2px);
            if (ApkAbTestHelper.getInstance().isTarget()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(ApkAbTestHelper.getInstance().getPubEnv()));
            }
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(JavaTypesHelper.toInt(TbSingleton.getInstance().getPubEnvValue(), 0)));
            }
            updateClientInfoMessage.setSecretKey(m5.a().c());
            updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            updateClientInfoMessage.addUserInfo("q_type", String.valueOf(uu4.c().e()));
            updateClientInfoMessage.addUserInfo("scr_h", String.valueOf(BdUtilHelper.getEquipmentHeight(inst)));
            updateClientInfoMessage.addUserInfo("scr_w", String.valueOf(BdUtilHelper.getEquipmentWidth(inst)));
            updateClientInfoMessage.addUserInfo("scr_dip", String.valueOf(Double.valueOf(BdUtilHelper.getEquipmentDensity(inst))));
            updateClientInfoMessage.addUserInfo("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp() + "");
            updateClientInfoMessage.addUserInfo("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime() + "");
            updateClientInfoMessage.addUserInfo(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime() + "");
            updateClientInfoMessage.addUserInfo("event_day", TbSingleton.getInstance().getData());
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                str = "1";
            }
            updateClientInfoMessage.addUserInfo("cmode", str);
            updateClientInfoMessage.addUserInfo("extra", SharedPrefHelper.getInstance().getString("key_sync_extra_field", ""));
            updateClientInfoMessage.addUserInfo("personalized_rec_switch", String.valueOf(TbSingleton.getInstance().getPersonalizedRecSwitch()));
            if (SocketAddCommonParamSwitch.getIsOn()) {
                updateClientInfoMessage.addUserInfo("start_type", GrowthFunnelHelper.realStartType + "");
                updateClientInfoMessage.addUserInfo("start_scheme", GrowthFunnelHelper.getRealStartScheme());
            }
            return updateClientInfoMessage;
        }
        return (UpdateClientInfoMessage) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().getSocketClient().F(this.e);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a >= 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = 0;
            MessageManager.getInstance().getSocketClient().H();
            NoNetworkView.updateUI();
            BdSocketLinkService.stopReConnStrategy("online succ");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a++;
            if (l()) {
                BdSocketLinkService.setAvailable(false);
                NoNetworkView.updateUI();
            }
        }
    }

    public final void o(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
            n();
            BdSocketLinkService.close(8, "online error = " + i2);
        }
    }
}
