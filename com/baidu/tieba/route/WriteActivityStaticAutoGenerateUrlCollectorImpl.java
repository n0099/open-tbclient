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
public final class WriteActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WriteActivityStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.write.write.WriteActivityStatic");
            hashMap.put("2016301", "com.baidu.tieba.write.write.WriteActivityStatic");
            hashMap.put("2001449", "com.baidu.tieba.write.write.WriteActivityStatic");
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
            arrayList.add("WriteActivityConfig");
            arrayList.add("TransmitPostEditActivityConfig");
            arrayList.add("VcodeActivityConfig");
            arrayList.add("AlbumActivityConfig");
            arrayList.add("NewVcodeActivityConfig");
            arrayList.add("NewVcodeActivityConfig");
            arrayList.add("AtListActivityConfig");
            arrayList.add("WriteImageActivityConfig");
            arrayList.add("WriteMulitImageActivityConfig");
            arrayList.add("TransmitForumActivityConfig");
            arrayList.add("SelectForumActivityConfig");
            arrayList.add("HotTopicChangeActivityConfig");
            arrayList.add("AccountAccessActivityConfig");
            arrayList.add("AddLinkActivityConfig");
            arrayList.add("SelectTagActivityConfig");
            arrayList.add("SelectClassDialogActivityConfig");
            arrayList.add("ShareFriendActivityConfig");
            hashMap.put("com.baidu.tieba.write.write.WriteActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
