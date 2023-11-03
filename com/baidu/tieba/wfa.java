package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.hb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wfa implements hb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wfa() {
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

    @Override // com.baidu.tieba.gb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return hb7.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb7
    public Map<String, String> a(d57 d57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d57Var)) == null) {
            return hb7.a.a(this, d57Var);
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r5.equals("video_forum") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r5.equals("live_forum") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r5.equals("common_forum") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        return "forum_head_click";
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.hb7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(d57 businessInfo) {
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
                    if (str.equals("common_user")) {
                        return "";
                    }
                    if (GlobalBuildConfig.isDebug()) {
                        return "";
                    }
                    throw new IllegalStateException("unknown card_head_type :" + str);
                case -1617812209:
                    if (str.equals("video_user")) {
                        return "video_user_head_click";
                    }
                    if (GlobalBuildConfig.isDebug()) {
                    }
                    break;
                case 448970189:
                    break;
                case 1009035070:
                    if (str.equals("live_user")) {
                        return "live_user_head_click";
                    }
                    if (GlobalBuildConfig.isDebug()) {
                    }
                    break;
                case 1201356814:
                    break;
                case 1373469789:
                    break;
                default:
                    if (GlobalBuildConfig.isDebug()) {
                    }
                    break;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
