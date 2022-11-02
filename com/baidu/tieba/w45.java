package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.cr4;
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
public class w45 {
    public static /* synthetic */ Interceptable $ic;
    public static w45 f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public za b;
    public UpdateClientInfoMessage c;
    public int d;
    public final za e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948220625, "Lcom/baidu/tieba/w45;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948220625, "Lcom/baidu/tieba/w45;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w45 a;

        public a(w45 w45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w45Var;
        }

        @Override // com.baidu.tieba.za
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.b != null) {
                this.a.b.a(str);
            }
        }

        @Override // com.baidu.tieba.za
        public void c(sj sjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sjVar) == null) && this.a.b != null) {
                this.a.b.c(sjVar);
            }
        }

        @Override // com.baidu.tieba.za
        public void d(ak akVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, akVar) == null) && this.a.b != null) {
                this.a.b.d(akVar);
            }
        }

        @Override // com.baidu.tieba.za
        public boolean b(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
                v95.b(0, 2, 0, 0, 0);
                if (this.a.b != null) {
                    this.a.b.b(i, str);
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tieba.za
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                v95.b(0, 1, 0, 0, 0);
                if (this.a.b != null) {
                    this.a.b.g(map);
                }
                if (!i35.d().e()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921695, ""));
                }
                ua.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
                if (PerformanceLoggerHelper.getInstance().isSmallFlow() && w45.b(this.a) < 10) {
                    ua.e();
                }
                v95.b(1001, 0, 0, 3, 0);
                w45 w45Var = this.a;
                w45Var.c = w45Var.i();
                MessageManager.getInstance().sendMessage(this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends nb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w45 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w45 w45Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w45Var, Integer.valueOf(i)};
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
            this.a = w45Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kb
        /* renamed from: c */
        public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
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
                        ua.b("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + this.a.a);
                        return socketResponsedMessage;
                    }
                    this.a.o(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    ua.b("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + this.a.a);
                    return null;
                }
                this.a.o(socketResponsedMessage.getCmd(), -1, null);
                return null;
            }
            return (SocketResponsedMessage) invokeL.objValue;
        }
    }

    public w45() {
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

    public static synchronized w45 j() {
        InterceptResult invokeV;
        w45 w45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (w45.class) {
                if (f == null) {
                    synchronized (w45.class) {
                        if (f == null) {
                            f = new w45();
                        }
                    }
                }
                w45Var = f;
            }
            return w45Var;
        }
        return (w45) invokeV.objValue;
    }

    public static /* synthetic */ int b(w45 w45Var) {
        int i = w45Var.d + 1;
        w45Var.d = i;
        return i;
    }

    public void p(za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zaVar) == null) {
            this.b = zaVar;
        }
    }

    public final UpdateClientInfoMessage i() {
        InterceptResult invokeV;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
            String str = "2";
            updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_TYPE, "2");
            updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
            updateClientInfoMessage.addUserInfo(HttpRequest.USER_AGENT, xj5.b());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            }
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
            updateClientInfoMessage.addUserInfo("model", zi.g());
            updateClientInfoMessage.addUserInfo(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            updateClientInfoMessage.addUserInfo("z_id", TbadkCoreApplication.getInst().getZid());
            updateClientInfoMessage.addUserInfo("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
            updateClientInfoMessage.addUserInfo(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
            updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            updateClientInfoMessage.addUserInfo("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            updateClientInfoMessage.addUserInfo("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            updateClientInfoMessage.addUserInfo("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            updateClientInfoMessage.addUserInfo("naws_game_ver", TbadkCoreApplication.getInst().getNaws_game_ver());
            updateClientInfoMessage.addUserInfo("_os_version", zi.k());
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(xi.l(TbadkCoreApplication.getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(xi.j(TbadkCoreApplication.getInst().getApp())));
            updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
            if (i35.d().f() > 0) {
                updateClientInfoMessage.addUserInfo("_msg_status", "0");
            } else {
                updateClientInfoMessage.addUserInfo("_msg_status", "1");
            }
            updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(ar4.c().e()));
            String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
            Log.i(BaiduYunPushMessageReceiver.TAG, "channel_id " + yunpushChannelId);
            if (!TextUtils.isEmpty(yunpushChannelId)) {
                updateClientInfoMessage.addUserInfo("channel_id", yunpushChannelId);
            }
            try {
                if (TbadkCoreApplication.isLogin()) {
                    cr4.b c = cr4.b().c(TbadkCoreApplication.getCurrentBduss());
                    String a2 = gr4.a(TbadkCoreApplication.getCurrentAccountInfo());
                    if (c != null) {
                        updateClientInfoMessage.setBduss(c.a, a2);
                    } else {
                        updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), a2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int d = xi.d(TbadkCoreApplication.getInst().getContext(), 70.0f);
            updateClientInfoMessage.setHeight(xi.d(TbadkCoreApplication.getInst().getContext(), 70.0f));
            updateClientInfoMessage.setWidth(d);
            if (d15.b().d()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(d15.b().c()));
            }
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(wg.e(TbSingleton.getInstance().getPubEnvValue(), 0)));
            }
            updateClientInfoMessage.setSecretKey(ya.a().c());
            updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            updateClientInfoMessage.addUserInfo("q_type", String.valueOf(ar4.c().e()));
            updateClientInfoMessage.addUserInfo("scr_h", String.valueOf(xi.j(inst)));
            updateClientInfoMessage.addUserInfo("scr_w", String.valueOf(xi.l(inst)));
            updateClientInfoMessage.addUserInfo("scr_dip", String.valueOf(Double.valueOf(xi.i(inst))));
            updateClientInfoMessage.addUserInfo("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp() + "");
            updateClientInfoMessage.addUserInfo("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime() + "");
            updateClientInfoMessage.addUserInfo(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime() + "");
            updateClientInfoMessage.addUserInfo("event_day", TbSingleton.getInstance().getData());
            updateClientInfoMessage.addUserInfo(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                str = "1";
            }
            updateClientInfoMessage.addUserInfo("cmode", str);
            updateClientInfoMessage.addUserInfo("extra", ky4.k().q("key_sync_extra_field", ""));
            updateClientInfoMessage.addUserInfo("personalized_rec_switch", String.valueOf(TbSingleton.getInstance().getPersonalizedRecSwitch()));
            if (SocketAddCommonParamSwitch.getIsOn()) {
                updateClientInfoMessage.addUserInfo("start_type", zw4.f + "");
                updateClientInfoMessage.addUserInfo("start_scheme", zw4.e());
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
            NoNetworkView.f();
            BdSocketLinkService.stopReConnStrategy("online succ");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a++;
            if (l()) {
                BdSocketLinkService.setAvailable(false);
                NoNetworkView.f();
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
