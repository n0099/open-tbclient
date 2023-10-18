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
/* loaded from: classes8.dex */
public final class TiebaIMActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TiebaIMActivityStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001275", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2002006", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001289", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001290", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001286", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001298", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2012110", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2003004", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001306", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("2001299", "com.baidu.tieba.im.TiebaIMActivityStatic");
            hashMap.put("3001000", "com.baidu.tieba.im.TiebaIMActivityStatic");
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
            arrayList.add("OfficialMsgImageActivityConfig");
            arrayList.add("OfficialBarHistoryActivityConfig");
            arrayList.add("OfficialHistoryImageActivityConfig");
            arrayList.add("ForumDetailActivityConfig");
            arrayList.add("RecommendDetailActivityConfig");
            arrayList.add("OfficialBarFeedActivityConfig");
            arrayList.add(UrlSchemaHelper.GOTO_OFFICIAL_CHAT);
            arrayList.add("middlepage");
            hashMap.put("com.baidu.tieba.im.TiebaIMActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
