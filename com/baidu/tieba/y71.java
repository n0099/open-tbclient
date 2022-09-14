package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.util.List;
/* loaded from: classes6.dex */
public class y71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(BundleInfo bundleInfo, BundleInfo bundleInfo2) {
        InterceptResult invokeLL;
        List<SubBundleInfo> subBundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundleInfo, bundleInfo2)) == null) {
            if (bundleInfo == null || bundleInfo2 == null || (subBundle = bundleInfo.getSubBundle()) == null) {
                return false;
            }
            for (SubBundleInfo subBundleInfo : subBundle) {
                if (TextUtils.equals(subBundleInfo.getPackageName(), bundleInfo2.getPackageName())) {
                    return subBundleInfo.getMaxVersion() >= bundleInfo2.getVersionCode() && subBundleInfo.getMinVersion() <= bundleInfo2.getVersionCode();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
