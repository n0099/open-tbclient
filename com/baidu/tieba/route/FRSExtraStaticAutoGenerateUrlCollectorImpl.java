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
/* loaded from: classes6.dex */
public final class FRSExtraStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FRSExtraStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.frs.FRSExtraStatic");
            hashMap.put("2003008", "com.baidu.tieba.frs.FRSExtraStatic");
            hashMap.put("2001616", "com.baidu.tieba.frs.FRSExtraStatic");
            hashMap.put("2016468", "com.baidu.tieba.frs.FRSExtraStatic");
            hashMap.put("3001000", "com.baidu.tieba.frs.FRSExtraStatic");
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
            arrayList.add("VideoEasterEggActivityConfig");
            arrayList.add("GameShareActivityConfig");
            arrayList.add("VideoAggregationActivityConfig");
            arrayList.add("VideoMiddlePageActivityConfig");
            arrayList.add("FrsGameCommentActivityConfig");
            arrayList.add("FrsGameSubPbActivityConfig");
            arrayList.add("FrsProfessionIntroActivityConfig");
            arrayList.add("FrsMoreFeedForumsConfig");
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_VIDEO_MIDDLE_PAGE);
            hashMap.put("com.baidu.tieba.frs.FRSExtraStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
