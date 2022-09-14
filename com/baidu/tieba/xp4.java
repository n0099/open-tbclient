package com.baidu.tieba;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class xp4 {
    public static /* synthetic */ Interceptable $ic;
    public static xp4 k;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountData a;
    public boolean b;
    public c c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public ChangeSkinReceiver i;
    public boolean j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ xp4 c;

        public a(xp4 xp4Var, AccountData accountData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp4Var, accountData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xp4Var;
            this.a = accountData;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.L(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
                tn8.a("", 7);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp4 this$0;

        public c(xp4 xp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xp4Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.D() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    this.this$0.a = (AccountData) serializableExtra;
                } else {
                    this.this$0.a = null;
                }
                y95.o(this.this$0.B());
                if (this.this$0.a != null) {
                    y95.n(this.this$0.a.getBDUSS());
                    y95.q(this.this$0.a.getTbs());
                    y95.p(this.this$0.a.getStoken());
                }
            }
        }

        public /* synthetic */ c(xp4 xp4Var, a aVar) {
            this(xp4Var);
        }
    }

    public xp4() {
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
        this.a = null;
        this.b = false;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.j = false;
    }

    public static void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            jh.a().b(new b());
            bx4.k().x("app_inverval", System.currentTimeMillis());
        }
    }

    public static void H(AccountData accountData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, accountData) == null) {
            String str2 = null;
            if (accountData != null) {
                str2 = accountData.getID();
                str = accountData.getAccount();
            } else {
                str = null;
            }
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.account_changed");
            intent.putExtra("intent_data_userid", str2);
            intent.putExtra("intent_data_username", str);
            intent.putExtra("intent_data_bduss", currentBduss);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            try {
                TbadkCoreApplication.getInst().sendStickyBroadcast(intent);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.baidu.tieba.action.accountChange");
            intent2.putExtra("intent_data_accountData", accountData);
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            y95.o(!TextUtils.isEmpty(str2));
            if (accountData != null) {
                y95.n(accountData.getBDUSS());
                y95.q(accountData.getTbs());
                y95.p(accountData.getStoken());
            }
        }
    }

    public static xp4 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (k == null) {
                synchronized (xp4.class) {
                    if (k == null) {
                        k = new xp4();
                    }
                }
            }
            return k;
        }
        return (xp4) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && D()) {
            this.i = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.i, intentFilter);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String g = g();
            return g != null && g.length() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean C(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().isRemoteProcess() : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void F(AccountData accountData, Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, accountData, application) == null) {
            ac7.a("onAccountChanged()");
            BdLog.e("账号切换");
            bx4 k2 = bx4.k();
            String q = k2.q("current_used_theme_" + g(), null);
            if (StringUtils.isNull(q)) {
                this.e = 0;
            } else {
                String[] split = q.split("/");
                if (split != null && split.length >= 2) {
                    this.e = dh.e(split[0], 0);
                } else {
                    this.e = 0;
                }
            }
            e();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2005006, accountData));
            ac7.a("send METHOD_ACCOUNT_CHANGE");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
            MessageManager.getInstance().registerStickyMode(2005019);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TbSingleton.getInstance().onAccountChange();
        }
    }

    public void I(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, accountData, str, str2) == null) {
            if (accountData == null && this.a != null) {
                this.b = true;
            } else if (this.a == null && accountData != null) {
                this.b = true;
            } else {
                AccountData accountData2 = this.a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.b = true;
                }
            }
            if (this.a == null && accountData != null) {
                this.a = accountData;
            }
            if (this.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.setBDUSS(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.setTbs(str2);
        }
    }

    public void J(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, accountData, context) == null) {
            String str = "set_application_account:";
            if (accountData == null) {
                str = "set_application_account:" + StringUtil.NULL_STRING;
            } else if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid_logined";
            } else if (!StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid";
            } else if (!StringUtils.isNull(accountData.getID())) {
                str = "set_application_account:logined";
            }
            qw4.a(DI.ACCOUNT, -1L, 0, str, 0, "", new Object[0]);
            if (!this.b) {
                if (accountData == null && this.a != null) {
                    this.b = true;
                    ac7.a("account == null && mAccount != null");
                } else if (this.a == null && accountData != null) {
                    this.b = true;
                    ac7.a("mAccount == null && account != null 初始化");
                } else {
                    AccountData accountData2 = this.a;
                    if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                        this.b = true;
                        ac7.a("mAccount != null && account != null");
                    }
                }
            }
            this.a = accountData;
            tn8.n();
            if (this.b) {
                BdSocketLinkService.setHasAbsoluteClose(false);
                BdSocketLinkService.setAvailable(true);
                l85.b(0, 0, 0, 1, 2);
                BdSocketLinkService.startService(true, "account changed");
            }
            gc.b().a("setCurrentAccountInUI", new a(this, accountData, context));
        }
    }

    public void K(AccountData accountData, Context context) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accountData, context) == null) {
            this.a = accountData;
            String str3 = null;
            if (accountData != null) {
                str3 = accountData.getID();
                str2 = accountData.getAccount();
                str = accountData.getBDUSS();
            } else {
                str = null;
                str2 = null;
            }
            BdStatisticsManager.getInstance().setUser(str3, str2, str);
        }
    }

    public final void L(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, accountData, context) == null) {
            if (context != null) {
                if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                    UtilHelper.startPushService(context);
                } else {
                    UtilHelper.stopPushService(context);
                }
            }
            H(accountData);
            if (this.b) {
                F(accountData, TbadkCoreApplication.getInst());
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            if (BdNetTypeUtil.isWifiNet() && accountData != null) {
                MessageManager.getInstance().runTask(2004611, (Class) null);
            }
            TbadkCoreApplication.getInst().setActivityPrizeData(null);
        }
    }

    public void M(int i) {
        AccountData accountData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (accountData = this.a) == null) {
            return;
        }
        accountData.setMemberType(i);
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h = u();
            G();
            O(i);
            TbadkSettings.getInst().saveInt("skin_", i);
            a(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i)));
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.d = i;
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.a != null) {
                this.a.setTbs(str);
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSkin());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("skin_type", i);
            TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || str == null) {
            return;
        }
        y9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String g = g();
            if (TextUtils.isEmpty(g)) {
                AccountData e = yp4.e();
                return e != null ? e.getID() : "";
            }
            return g;
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return dh.g(accountData.getID(), 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public AccountData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (AccountData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccount();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccountNameShow();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccountData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a : (AccountData) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            if (!TextUtils.isEmpty(m.getAvatar())) {
                return m.getAvatar();
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getBDUSS();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getMemberType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AccountData accountData = this.a;
            if (accountData == null || accountData.getVipInfo() == null) {
                return 0;
            }
            return this.a.getVipInfo().getVipLevel();
        }
        return invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.h : invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.d : invokeV.intValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getTbs();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.e : invokeV.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.j) {
            return;
        }
        this.j = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (C(true)) {
            try {
                if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    AccountData e = yp4.e();
                    if (e != null) {
                        qw4.a(DI.ACCOUNT, -1L, 0, "application_init_account", 0, "", new Object[0]);
                        J(e, TbadkCoreApplication.getInst());
                    } else {
                        qw4.a(DI.ACCOUNT, -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                    }
                } else {
                    qw4.a(DI.ACCOUNT, -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fd5.b().i(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && !C(false) && D() && this.c == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.c, intentFilter);
        }
    }
}
