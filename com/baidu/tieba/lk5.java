package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoRequstData;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lk5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static lk5 c = null;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public UserData a;
    public TbHttpMessageTask b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947945779, "Lcom/baidu/tieba/lk5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947945779, "Lcom/baidu/tieba/lk5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk5 a;

        public a(lk5 lk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GetUserInfoRequstData c = this.a.c();
                c.setNetType(NetMessage.NetType.HTTP);
                if (this.a.b != null) {
                    new HttpClient.a(c.getHttpMessage(), this.a.b).execute(new HttpMessage[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;

        public b(lk5 lk5Var, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk5Var, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AccountStorage.saveAccountData(this.a);
            }
        }
    }

    public lk5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static lk5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (lk5.class) {
                    if (c == null) {
                        c = new lk5();
                    }
                }
            }
            return c;
        }
        return (lk5) invokeV.objValue;
    }

    public UserData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gs6.a(new a(this), "sendGetUserInfoForDau", 3);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (d) {
                g();
                d = false;
                return;
            }
            MessageManager.getInstance().sendMessage(c());
        }
    }

    public final GetUserInfoRequstData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetUserInfoRequstData getUserInfoRequstData = new GetUserInfoRequstData(CmdConfigHttp.CMD_GET_USER_INFO, 303024);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                getUserInfoRequstData.setUid(JavaTypesHelper.toLong(currentAccountObj.getID(), 0L));
            }
            getUserInfoRequstData.setScreenWidth(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
            return getUserInfoRequstData;
        }
        return (GetUserInfoRequstData) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            aba.h(303024, GetUserInfoSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = aba.c(303024, CmdConfigHttp.CMD_GET_USER_INFO, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, true, false);
            this.b = c2;
            c2.setTimeOut(jb.d().b());
            this.b.setRetry(jb.d().a());
            this.b.setConnectTimeOut(jb.d().c());
        }
    }

    public void i(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, userData) == null) {
            this.a = userData;
            if (userData == null) {
                return;
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = new AccountData();
            }
            if (!StringUtils.isNull(userData.getUserName())) {
                currentAccountObj.setAccount(userData.getUserName());
            }
            if (!StringUtils.isNull(userData.getPortrait())) {
                currentAccountObj.setPortrait(userData.getPortrait());
            }
            currentAccountObj.setSex(userData.getSex());
            currentAccountObj.setMemberType(userData.getIsMem());
            currentAccountObj.setVipInfo(userData.getUserVipInfo());
            currentAccountObj.setPersonalBgUrl(userData.getBg_pic());
            if (userData.getGodUserData() != null) {
                currentAccountObj.setGodType(userData.getGodUserData().getType());
            }
            if (userData.getNewGodData() != null) {
                currentAccountObj.setNewGodStatus(userData.getNewGodData().getStatus());
            }
            if (!TextUtils.isEmpty(userData.getUk())) {
                currentAccountObj.setUk(userData.getUk());
            }
            currentAccountObj.setIsBigV(userData.isBigV());
            currentAccountObj.setNameShow(userData.getName_show());
            TbadkCoreApplication.getInst().setDefaultBubble(userData.getBimg_url());
            TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(userData.getDynamicUrl());
            PayMemberInfoData payMemberInfoData = userData.getPayMemberInfoData();
            if (currentAccountObj.getVipInfo() != null) {
                currentAccountObj.setMemberIconUrl(currentAccountObj.getVipInfo().getVipIconUrl());
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            CloseAdData closeAdData = userData.getCloseAdData();
            if (closeAdData != null) {
                currentAccountObj.setMemberCloseAdIsOpen(closeAdData.N());
                currentAccountObj.setMemberCloseAdVipClose(closeAdData.O());
            }
            currentAccountObj.setUserIcons(userData.getIconInfo());
            currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
            kg.a().c(new b(this, currentAccountObj));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247, payMemberInfoData));
        }
    }
}
