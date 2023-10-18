package com.baidu.tieba;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class y1 implements k1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AssetManager a;

    public y1(AssetManager assetManager, ContextWrapper contextWrapper, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, contextWrapper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = assetManager;
        String absolutePath = contextWrapper.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            String str = absolutePath + "/";
        }
        if (z) {
            a(contextWrapper);
        }
    }

    public String a(ContextWrapper contextWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, contextWrapper)) == null) {
            File externalFilesDir = contextWrapper.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return null;
            }
            String absolutePath = externalFilesDir.getAbsolutePath();
            if (!absolutePath.endsWith("/")) {
                return absolutePath + "/";
            }
            return absolutePath;
        }
        return (String) invokeL.objValue;
    }
}
