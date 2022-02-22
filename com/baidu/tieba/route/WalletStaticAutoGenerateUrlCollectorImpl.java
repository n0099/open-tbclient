package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public final class WalletStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WalletStaticAutoGenerateUrlCollectorImpl() {
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

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            new ArrayList();
            hashMap.put("2001351", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2016457", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921565", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921433", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921432", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2001451", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2001447", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921335", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921393", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2001387", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("3001000", "com.baidu.tieba.wallet.WalletStatic");
            hashMap.put("2921539", "com.baidu.tieba.wallet.WalletStatic");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH);
            hashMap.put("com.baidu.tieba.wallet.WalletStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
