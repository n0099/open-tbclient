package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class PbActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PbActivityStaticAutoGenerateUrlCollectorImpl() {
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
    public Map<String, String> getCmdRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            new ArrayList();
            hashMap.put("2004001", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
            hashMap.put("2004003", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
            hashMap.put("3001000", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
            hashMap.put("2921343", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
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
            arrayList.add(PbModel.UNIDISPATCH_PB);
            arrayList.add("com.baidu.tieba://?kz=");
            arrayList.add("tieba.baidu.com/p/");
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB);
            arrayList.add("SubPbActivityConfig");
            arrayList.add("PbSearchEmotionActivityConfig");
            arrayList.add("PbFullScreenEditorActivityConfig");
            arrayList.add("ForbidActivityConfig");
            hashMap.put("com.baidu.tieba.pb.pb.main.PbActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
