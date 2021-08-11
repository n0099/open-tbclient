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
public final class MemberCenterStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MemberCenterStaticAutoGenerateUrlCollectorImpl() {
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
            hashMap.put("2002001", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("2001294", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("2001343", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("2001283", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("2001284", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("2001339", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
            hashMap.put("3001000", "com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic");
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
            arrayList.add("TailManagementActivityConfig");
            arrayList.add("TailEditActivityConfig");
            arrayList.add("MemberTaskCenterActivityConfig");
            arrayList.add("BubbleChooseActivityConfig");
            arrayList.add("MemberPayActivityConfig");
            arrayList.add("MemberPrivilegeActivityConfig");
            arrayList.add("MembercenterActivityConfig");
            arrayList.add("CardBoxMemberPayActivityConfig");
            arrayList.add("MemberExchangeActivityConfig");
            arrayList.add("MemberPayResultActivityConfig");
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER);
            arrayList.add(UrlSchemaHelper.PAY_MEMBER_PAGE);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_JUMP_MEMBER_BUY);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY_ASSIST);
            arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_EXCHANGE);
            arrayList.add(UrlSchemaHelper.GOTO_TAIL_MANAGER);
            hashMap.put("com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
