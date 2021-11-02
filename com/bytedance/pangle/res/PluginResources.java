package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.i;
import java.util.HashSet;
import java.util.List;
@Keep
/* loaded from: classes11.dex */
public class PluginResources extends Resources {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginResources(Resources resources) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static AssetManager appendHostRes(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, resources)) == null) {
            List<String> b2 = i.b();
            a aVar = new a();
            AssetManager assets = resources.getAssets();
            AssetManager assets2 = Zeus.getAppApplication().getAssets();
            HashSet hashSet = new HashSet(i.a(assets));
            List<String> a2 = i.a(assets2);
            for (String str : b2) {
                if (!hashSet.contains(str)) {
                    assets = aVar.a(assets, str, true);
                }
            }
            for (String str2 : a2) {
                if (!hashSet.contains(str2) && !b2.contains(str2)) {
                    assets = aVar.a(assets, str2, false);
                }
            }
            return assets;
        }
        return (AssetManager) invokeL.objValue;
    }
}
