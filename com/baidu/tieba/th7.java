package com.baidu.tieba;

import android.app.ActivityManager;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
/* loaded from: classes8.dex */
public class th7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ImagePipelineConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (vh.a()) {
                return null;
            }
            ImagePipelineConfig.Builder newBuilder = ImagePipelineConfig.newBuilder(TbadkCoreApplication.getInst());
            newBuilder.setBitmapMemoryCacheParamsSupplier(new uh7((ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity")));
            return newBuilder.build();
        }
        return (ImagePipelineConfig) invokeV.objValue;
    }
}
