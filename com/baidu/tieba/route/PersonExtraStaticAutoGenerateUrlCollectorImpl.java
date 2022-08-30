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
public final class PersonExtraStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonExtraStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.personExtra.PersonExtraStatic");
            hashMap.put("2002003", "com.baidu.tieba.personExtra.PersonExtraStatic");
            hashMap.put("3001000", "com.baidu.tieba.personExtra.PersonExtraStatic");
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
            arrayList.add("EditHeadActivityConfig");
            arrayList.add("PersonMoreActivityConfig");
            arrayList.add("PersonFriendActivityConfig");
            arrayList.add("PersonBarActivityConfig");
            arrayList.add("PersonImageActivityConfig");
            arrayList.add("PersonChangeActivityConfig");
            arrayList.add("EditNickNameActivityConfig");
            arrayList.add("EditNickNameActivityConfig");
            arrayList.add("SmartAppBrowseHistoryActivityConfig");
            arrayList.add("PersonPolymericActivityConfig");
            arrayList.add("PersonPostActivityConfig");
            arrayList.add(UrlSchemaHelper.GOTO_PERSON_INFO);
            arrayList.add(UrlSchemaHelper.OPEN_PERSON_INFO);
            arrayList.add(UrlSchemaHelper.JUMP_TO_MODIFY_NICKNAME);
            arrayList.add(UrlSchemaHelper.JUMP_TO_POST_LIST);
            hashMap.put("com.baidu.tieba.personExtra.PersonExtraStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
