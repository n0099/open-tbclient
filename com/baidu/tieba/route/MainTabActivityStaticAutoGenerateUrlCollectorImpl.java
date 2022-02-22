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
public final class MainTabActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MainTabActivityStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002004", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
            hashMap.put("2012111", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
            hashMap.put("2012118", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
            hashMap.put("2001626", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
            hashMap.put("2015002", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
            hashMap.put("3001000", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
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
            arrayList.add(UrlSchemaHelper.GOTO_ENTERFORUM_TAB);
            arrayList.add(UrlSchemaHelper.GOTO_RECOMMNEDS_FRS_TAB);
            arrayList.add("n/video/opersquare?jump_to_publish_video_thread=1");
            arrayList.add("tiebavr:");
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_LIVETAB);
            hashMap.put("com.baidu.tieba.tblauncher.MainTabActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
