package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.ac7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xka implements ac7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xka() {
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

    @Override // com.baidu.tieba.zb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ac7.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb7
    public Map<String, String> a(v57 v57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v57Var)) == null) {
            return ac7.a.a(this, v57Var);
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r5.equals("video_forum") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r5.equals("live_forum") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r5.equals("live_user") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r5.equals("common_forum") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        return "enter_forum_btn_click";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.equals("video_user") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        if (r5.equals("common_user") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
        return "user_head_click";
     */
    @Override // com.baidu.tieba.ac7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(v57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            String str = businessInfo.a().get("card_head_type");
            if (str == null) {
                str = "common_user";
            }
            switch (str.hashCode()) {
                case -1924729441:
                    break;
                case -1617812209:
                    break;
                case 448970189:
                    break;
                case 1009035070:
                    break;
                case 1201356814:
                    break;
                case 1373469789:
                    break;
                default:
                    if (!GlobalBuildConfig.isDebug()) {
                        return "";
                    }
                    throw new IllegalStateException("unknown card_head_type :" + str);
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
