package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j8a implements dd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j8a() {
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

    @Override // com.baidu.tieba.cd7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return dd7.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cd7
    public Map<String, String> a(m87 m87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m87Var)) == null) {
            return dd7.a.a(this, m87Var);
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e A[ORIG_RETURN, RETURN] */
    @Override // com.baidu.tieba.dd7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(m87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            if (!Intrinsics.areEqual(businessInfo.a().get("thread_type"), "74")) {
                return "";
            }
            String str = businessInfo.a().get("card_head_type");
            if (str == null) {
                str = "common_user";
            }
            switch (str.hashCode()) {
                case -1924729441:
                    if (!str.equals("common_user")) {
                        return "";
                    }
                    return "live_mix_card_person_head_click";
                case -1617812209:
                    if (!str.equals("video_user")) {
                        return "";
                    }
                    break;
                case 448970189:
                    if (!str.equals("common_forum")) {
                        return "";
                    }
                    return "live_mix_card_forum_head_click";
                case 1009035070:
                    if (!str.equals("live_user")) {
                        return "";
                    }
                    break;
                case 1201356814:
                    if (!str.equals("live_forum")) {
                        return "";
                    }
                    break;
                case 1373469789:
                    if (!str.equals("video_forum")) {
                        return "";
                    }
                    break;
                default:
                    return "";
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
