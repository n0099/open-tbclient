package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.video.a.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.io.File;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class CacheDirConstants {
    public static /* synthetic */ Interceptable $ic;
    public static String ROOT_DIR;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheDirConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        File a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!TextUtils.isEmpty(ROOT_DIR)) {
                return ROOT_DIR;
            }
            Context a3 = o.a();
            if (o.h().C() == 1) {
                k.c("CacheDirConstants", "使用内部存储");
                a2 = f.b(a3, b.b(), "tt_ad");
            } else {
                k.c("CacheDirConstants", "使用外部存储");
                a2 = f.a(a3, b.b(), "tt_ad");
            }
            if (a2.isFile()) {
                a2.delete();
            }
            if (!a2.exists()) {
                a2.mkdirs();
            }
            String absolutePath = a2.getAbsolutePath();
            ROOT_DIR = absolutePath;
            return absolutePath;
        }
        return (String) invokeV.objValue;
    }

    public static void clearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            HashSet hashSet = new HashSet();
            if (Build.VERSION.SDK_INT >= 23) {
                for (a aVar : a.f65262a.values()) {
                    if (aVar != null && aVar.a() != null) {
                        com.bytedance.sdk.component.video.b.a a2 = aVar.a();
                        hashSet.add(com.bytedance.sdk.component.video.d.b.b(a2.d(), a2.c()).getAbsolutePath());
                    }
                }
                for (com.bytedance.sdk.component.video.a.c.a aVar2 : com.bytedance.sdk.component.video.a.b.a.f65278a.values()) {
                    if (aVar2 != null && aVar2.a() != null) {
                        com.bytedance.sdk.component.video.b.a a3 = aVar2.a();
                        hashSet.add(com.bytedance.sdk.component.video.d.b.b(a3.d(), a3.c()).getAbsolutePath());
                    }
                }
            }
            f.a(new File(getFeedCacheDir()), 30, hashSet);
            f.a(new File(getRewardFullCacheDir()), 20, hashSet);
        }
    }

    public static String getBrandCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a() + File.separator + "video_brand";
        }
        return (String) invokeV.objValue;
    }

    public static String getFeedCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a() + File.separator + "video_feed";
        }
        return (String) invokeV.objValue;
    }

    public static String getRewardFullCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return a() + File.separator + "video_reward_full";
        }
        return (String) invokeV.objValue;
    }
}
