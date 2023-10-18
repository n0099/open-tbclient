package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class SwanAppAbTestStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SwanAppAbTestStaticAutoGenerateUrlCollectorImpl() {
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
            arrayList.add("tbcfrom=web_search");
            hashMap.put("com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", arrayList);
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
            hashMap.put("2921361", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
            hashMap.put("2921377", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
            hashMap.put("2921410", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
            hashMap.put("3001000", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
            hashMap.put("2921512", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
