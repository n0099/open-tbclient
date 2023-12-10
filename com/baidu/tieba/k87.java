package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class k87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final j87 a(Map<String, String> businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                od7.b(str, null, 1, null);
                String str2 = businessInfo.get("forum_name");
                od7.b(str2, null, 1, null);
                String str3 = businessInfo.get("thread_id");
                od7.b(str3, null, 1, null);
                String str4 = businessInfo.get("is_top");
                od7.b(str4, null, 1, null);
                boolean areEqual = Intrinsics.areEqual(str4, "1");
                String str5 = businessInfo.get("submit_text");
                od7.b(str5, null, 1, null);
                String str6 = businessInfo.get(WriteImageActivityConfig.CANCEL_TEXT);
                od7.b(str6, null, 1, null);
                return new j87(str, str2, str3, areEqual, str5, str6);
            } catch (Exception unused) {
                return null;
            }
        }
        return (j87) invokeL.objValue;
    }
}
