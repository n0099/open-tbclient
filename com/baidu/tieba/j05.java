package com.baidu.tieba;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class j05 {
    public static /* synthetic */ Interceptable $ic;
    public static j05 k;
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
        public final /* synthetic */ j05 c;

        public a(j05 j05Var, AccountData accountData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j05Var, accountData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j05Var;
            this.a = accountData;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.b) {
                    BdSocketLinkService.setHasAbsoluteClose(false);
                    BdSocketLinkService.setAvailable(true);
                    wm5.b(0, 0, 0, 1, 2);
                    BdSocketLinkService.startService(true, "account changed");
                }
                this.c.M(this.a, this.b);
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
                aha.a("", 7);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j05 this$0;

        public c(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = j05Var;
        }

        public /* synthetic */ c(j05 j05Var, a aVar) {
            this(j05Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.E() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    this.this$0.a = (AccountData) serializableExtra;
                } else {
                    this.this$0.a = null;
                }
                pp5.o(this.this$0.C());
                if (this.this$0.a != null) {
                    pp5.n(this.this$0.a.getBDUSS());
                    pp5.q(this.this$0.a.getTbs());
                    pp5.p(this.this$0.a.getStoken());
                }
            }
        }
    }

    public j05() {
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

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !D(false) && E() && this.c == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.c, intentFilter);
        }
    }

    public static void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            kg.a().b(new b());
            SharedPrefHelper.getInstance().putLong("app_inverval", System.currentTimeMillis());
        }
    }

    public static j05 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (k == null) {
                synchronized (j05.class) {
                    if (k == null) {
                        k = new j05();
                    }
                }
            }
            return k;
        }
        return (j05) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && E()) {
            this.i = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.i, intentFilter);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String h = h();
            if (h != null && h.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return TbadkCoreApplication.getInst().isRemoteProcess();
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
        }
    }

    @Nullable
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String h = h();
            if (TextUtils.isEmpty(h)) {
                AccountData activeAccountData = AccountStorage.getActiveAccountData();
                if (activeAccountData != null) {
                    return activeAccountData.getID();
                }
                return "";
            }
            return h;
        }
        return (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AccountData accountData = this.a;
            if (accountData == null) {
                return 0L;
            }
            return JavaTypesHelper.toLong(accountData.getID(), 0L);
        }
        return invokeV.longValue;
    }

    public AccountData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.a;
        }
        return (AccountData) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccount();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccountNameShow();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccountData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a;
        }
        return (AccountData) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AccountData n = n();
            if (n == null) {
                return null;
            }
            if (!TextUtils.isEmpty(n.getAvatar())) {
                return n.getAvatar();
            }
            return n.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getBDUSS();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getMemberType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AccountData n = n();
            if (n == null) {
                return null;
            }
            return n.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null && accountData.getVipInfo() != null) {
                return this.a.getVipInfo().getVipLevel();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getTbs();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public static void I(AccountData accountData) {
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
            pp5.o(!TextUtils.isEmpty(str2));
            if (accountData != null) {
                pp5.n(accountData.getBDUSS());
                pp5.q(accountData.getTbs());
                pp5.p(accountData.getStoken());
            }
        }
    }

    public boolean D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(z);
        }
        return invokeZ.booleanValue;
    }

    public void N(int i) {
        AccountData accountData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (accountData = this.a) != null) {
            accountData.setMemberType(i);
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
            TbLog a2 = ck.a();
            a2.i(Config.DEVICE_PART, "skinType status: " + i);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && str != null && str.length() > 0) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.setTbs(str);
                }
            }
        }
    }

    public void L(AccountData accountData, Context context) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, accountData, context) == null) {
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

    public void G(AccountData accountData, Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, accountData, application) == null) {
            qi8.a("onAccountChanged()");
            BdLog.e("账号切换");
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            String string = sharedPrefHelper.getString("current_used_theme_" + h(), null);
            if (StringUtils.isNull(string)) {
                this.e = 0;
            } else {
                String[] split = string.split("/");
                if (split != null && split.length >= 2) {
                    this.e = JavaTypesHelper.toInt(split[0], 0);
                } else {
                    this.e = 0;
                }
            }
            f();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2005006, accountData));
            qi8.a("send METHOD_ACCOUNT_CHANGE");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
            MessageManager.getInstance().registerStickyMode(2005019);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TbSingleton.getInstance().onAccountChange();
            if (accountData != null) {
                TbLog a2 = ck.a();
                a2.i(Config.DEVICE_PART, "账号切换 Account:" + accountData.toString());
            }
        }
    }

    public void J(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, accountData, str, str2) == null) {
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
            if (!TextUtils.isEmpty(str2)) {
                this.a.setTbs(str2);
            }
        }
    }

    public void K(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accountData, context) == null) {
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
            Logger.addLog("account", -1L, 0, str, 0, "", new Object[0]);
            if (!this.b) {
                if (accountData == null && this.a != null) {
                    this.b = true;
                    qi8.a("account == null && mAccount != null");
                } else if (this.a == null && accountData != null) {
                    this.b = true;
                    qi8.a("mAccount == null && account != null 初始化");
                } else {
                    AccountData accountData2 = this.a;
                    if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                        this.b = true;
                        qi8.a("mAccount != null && account != null");
                    }
                }
            }
            this.a = accountData;
            aha.n();
            IdleHandlerManager.getInstance().addOrRunTask("setCurrentAccountInUI", new a(this, accountData, context));
        }
    }

    public final void M(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, accountData, context) == null) {
            if (context != null) {
                if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                    UtilHelper.startPushService(context);
                } else {
                    UtilHelper.stopPushService(context);
                }
            }
            I(accountData);
            if (this.b) {
                G(accountData, TbadkCoreApplication.getInst());
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            if (BdNetTypeUtil.isWifiNet() && accountData != null) {
                MessageManager.getInstance().runTask(2004611, (Class) null);
            }
            TbadkCoreApplication.getInst().setActivityPrizeData(null);
        }
    }

    public void g(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, str, z) != null) || str == null) {
            return;
        }
        n9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from search_data where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from search_post_data where account=?", new Object[]{str});
        if (z) {
            mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = v();
            H();
            P(i);
            TbadkSettings.getInst().saveInt("skin_", i);
            a(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i)));
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSkin());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("skin_type", i);
            TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || this.j) {
            return;
        }
        this.j = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (D(true)) {
            try {
                if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    AccountData activeAccountData = AccountStorage.getActiveAccountData();
                    if (activeAccountData != null) {
                        Logger.addLog("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                        K(activeAccountData, TbadkCoreApplication.getInst());
                    } else {
                        Logger.addLog("account", -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                    }
                } else {
                    Logger.addLog("account", -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            ns5.a().h(System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
