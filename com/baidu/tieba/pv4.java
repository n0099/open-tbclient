package com.baidu.tieba;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.switchs.StokenEnableSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class pv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface b {
        void onFailed();

        void onSuccess(String str);
    }

    /* loaded from: classes7.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public a(pv4 pv4Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv4Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) && (bVar = this.a) != null) {
                bVar.onFailed();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) {
                if (getTplStokenResult == null) {
                    b bVar = this.a;
                    if (bVar != null) {
                        bVar.onFailed();
                        return;
                    }
                    return;
                }
                Map<String, String> map = getTplStokenResult.tplStokenMap;
                if (map != null && map.size() > 0) {
                    String str = map.get(TbConfig.PassConfig.TPL);
                    if (StringUtils.isNULL(str)) {
                        b bVar2 = this.a;
                        if (bVar2 != null) {
                            bVar2.onFailed();
                            return;
                        }
                        return;
                    }
                    b bVar3 = this.a;
                    if (bVar3 != null) {
                        bVar3.onSuccess(str);
                        return;
                    }
                    return;
                }
                b bVar4 = this.a;
                if (bVar4 != null) {
                    bVar4.onFailed();
                }
            }
        }
    }

    public pv4() {
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

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (SwitchManager.getInstance().findType(StokenEnableSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String a(AccountData accountData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountData)) == null) {
            if (accountData == null || !b()) {
                return null;
            }
            return accountData.getStoken();
        }
        return (String) invokeL.objValue;
    }

    public void c(String str, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) && !StringUtils.isNull(str)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(TbConfig.PassConfig.TPL);
            if (SapiAccountManager.getInstance().getAccountService() == null) {
                return;
            }
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, bVar), str, linkedList);
        }
    }
}
