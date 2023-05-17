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
/* loaded from: classes7.dex */
public final class PassManagerStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PassManagerStaticAutoGenerateUrlCollectorImpl() {
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

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add("LoginActivityConfig");
            arrayList.add(UrlSchemaHelper.GOTO_LOGIN);
            hashMap.put("com.baidu.tieba.passaccount.framework.PassManagerStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            new ArrayList();
            hashMap.put("2002001", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2001268", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2001293", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2016301", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921530", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921438", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921328", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921329", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921332", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921351", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921339", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921352", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("3001000", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921709", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            hashMap.put("2921710", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
