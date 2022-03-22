package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes6.dex */
public final class ManifestParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GLIDE_MODULE_VALUE = "GlideModule";
    public static final String TAG = "ManifestParser";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;

    public ManifestParser(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
    }

    public static GlideModule parseModule(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                Class<?> cls = Class.forName(str);
                Object obj = null;
                try {
                    obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (IllegalAccessException e2) {
                    throwInstantiateGlideModuleException(cls, e2);
                } catch (InstantiationException e3) {
                    throwInstantiateGlideModuleException(cls, e3);
                } catch (NoSuchMethodException e4) {
                    throwInstantiateGlideModuleException(cls, e4);
                } catch (InvocationTargetException e5) {
                    throwInstantiateGlideModuleException(cls, e5);
                }
                if (obj instanceof GlideModule) {
                    return (GlideModule) obj;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            } catch (ClassNotFoundException e6) {
                throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
            }
        }
        return (GlideModule) invokeL.objValue;
    }

    public static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cls, exc) == null) {
            throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
        }
    }

    public List<GlideModule> parse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Loading Glide modules");
            }
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
                if (applicationInfo.metaData == null) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Got null app info metadata");
                    }
                    return arrayList;
                }
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Got app info metadata: " + applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Finished loading Glide modules");
                }
                return arrayList;
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
            }
        }
        return (List) invokeV.objValue;
    }
}
