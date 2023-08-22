package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ud7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207233, "Lcom/baidu/tieba/ud7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207233, "Lcom/baidu/tieba/ud7;");
                return;
            }
        }
        Intrinsics.checkNotNullExpressionValue(TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_name), "getInst().getString(R.st…apk_unknown_default_name)");
        Intrinsics.checkNotNullExpressionValue(TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_tag), "getInst().getString(R.st…_apk_unknown_default_tag)");
        Intrinsics.checkNotNullExpressionValue(TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_content), "getInst().getString(R.st…_unknown_default_content)");
    }

    @JvmStatic
    public static final void a(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ox6 ox6Var = new ox6();
            ox6Var.a = data.getItemData();
            ox6Var.b = data.getSource();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921819, ox6Var));
        }
    }
}
