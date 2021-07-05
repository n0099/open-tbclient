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
/* loaded from: classes5.dex */
public final class SquareSearchActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SquareSearchActivityStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2015003", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
            hashMap.put("2009002", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
            hashMap.put("2009001", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
            hashMap.put("2001190", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
            hashMap.put("2001191", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
            hashMap.put("3001000", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
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
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH);
            arrayList.add("create_forum");
            hashMap.put("com.baidu.tieba.mainentrance.SquareSearchActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
