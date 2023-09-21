package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class z8a implements cd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    @Override // com.baidu.tieba.cd7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? CommonStatisticKey.KEY_LIVE_MERGE_CARD_SHOW : (String) invokeV.objValue;
    }

    public z8a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
    }

    @Override // com.baidu.tieba.cd7
    public Map<String, String> a(m87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = businessInfo.a().get("live_attach_image_type");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            linkedHashMap.put("obj_name", str);
            String str3 = businessInfo.a().get(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
            if (str3 == null) {
                str3 = "";
            }
            linkedHashMap.put("obj_source", str3);
            String str4 = businessInfo.a().get("live_page_from");
            if (str4 == null) {
                str4 = "";
            }
            linkedHashMap.put(TiebaStatic.Params.OBJ_TO, str4);
            String str5 = businessInfo.a().get("live_app_id");
            if (str5 == null) {
                str5 = "";
            }
            linkedHashMap.put(TiebaStatic.Params.OBJ_PARAM3, str5);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null) {
                str2 = currentAccount;
            }
            linkedHashMap.put("uid", str2);
            String hdid = TbadkCoreApplication.getInst().getHdid();
            Intrinsics.checkNotNullExpressionValue(hdid, "getInst().hdid");
            linkedHashMap.put("hdid", hdid);
            linkedHashMap.put("obj_locate", this.a);
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final z8a b(String objLocate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objLocate)) == null) {
            Intrinsics.checkNotNullParameter(objLocate, "objLocate");
            this.a = objLocate;
            return this;
        }
        return (z8a) invokeL.objValue;
    }
}
