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
/* loaded from: classes5.dex */
public final class RelationshipStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RelationshipStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
            hashMap.put("2001174", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
            hashMap.put("2002014", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
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
            arrayList.add("CMD_GET_ADDRESSLIST");
            arrayList.add("CMD_QUERY_LOCAL_ADDRESSLIST");
            arrayList.add("CMD_QUERY_CONTACT_LIST");
            arrayList.add("CMD_INSERT_CONTACT");
            arrayList.add("CMD_DELETE_CONTACT");
            hashMap.put("com.baidu.tieba.addresslist.relationship.RelationshipStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
