package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ob7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class m4a implements ob7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m4a() {
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

    @Override // com.baidu.tieba.nb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ob7.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nb7
    public Map<String, String> a(a77 a77Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a77Var)) == null) {
            return ob7.a.a(this, a77Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ob7
    public String c(a77 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            String str = businessInfo.a().get("card_head_type");
            if (str == null) {
                str = "common_user";
            }
            int hashCode = str.hashCode();
            if (hashCode == 448970189 ? str.equals("common_forum") : !(hashCode == 1201356814 ? !str.equals("live_forum") : !(hashCode == 1373469789 && str.equals("video_forum")))) {
                return "forum_head_rec_forum_click";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
