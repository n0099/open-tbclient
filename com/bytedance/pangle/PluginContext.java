package com.bytedance.pangle;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
/* loaded from: classes7.dex */
public class PluginContext extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public Context mOriginContext;
    public Configuration mOverrideConfiguration;
    public Plugin mPlugin;

    public PluginContext() {
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

    private Resources getResourcesInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.mPlugin.mResources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.mOriginContext;
            if (context instanceof PluginApplicationWrapper) {
                return context;
            }
            return ZeusTransformUtils.wrapperContext(context.getApplicationContext(), this.mPlugin.mPkgName);
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPlugin.mHostApplicationInfoHookSomeField;
        }
        return (ApplicationInfo) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPlugin.mResources.getAssets();
        }
        return (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context baseContext = super.getBaseContext();
            if (baseContext instanceof ContextWrapper) {
                return ((ContextWrapper) baseContext).getBaseContext();
            }
            return baseContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPlugin.mClassLoader;
        }
        return (ClassLoader) invokeV.objValue;
    }

    public Configuration getOverrideConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mOverrideConfiguration;
        }
        return (Configuration) invokeV.objValue;
    }

    public String getPluginPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mPlugin.mPkgName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.pangle.e
    public String getPluginPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mPlugin.mPkgName;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mPlugin.mResources;
        }
        return (Resources) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginContext(Context context, Plugin plugin, boolean z) {
        super(getContextWithoutTheme(context), getThemeResourceId(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, plugin, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPlugin = plugin;
        this.mOriginContext = context;
        this.mIsHostApplicationContext = z;
    }

    public static Context getContextWithoutTheme(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (Context) invokeL.objValue;
        }
        while (true) {
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                context = ((androidx.appcompat.view.ContextThemeWrapper) context).getBaseContext();
            } else {
                return context;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
            if (this.mPlugin.mResources == null) {
                if (this.mOverrideConfiguration == null) {
                    this.mOverrideConfiguration = new Configuration(configuration);
                    return;
                }
                throw new IllegalStateException("Override configuration has already been set");
            }
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, componentCallbacks) == null) {
            if (this.mIsHostApplicationContext) {
                this.mOriginContext.registerComponentCallbacks(componentCallbacks);
            } else {
                super.registerComponentCallbacks(componentCallbacks);
            }
        }
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, componentCallbacks) == null) {
            if (this.mIsHostApplicationContext) {
                this.mOriginContext.unregisterComponentCallbacks(componentCallbacks);
            } else {
                super.unregisterComponentCallbacks(componentCallbacks);
            }
        }
    }

    public static int getThemeResourceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof ContextThemeWrapper) {
                try {
                    return ((Integer) FieldUtils.readField(context, "mThemeResource")).intValue();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration)) == null) {
            Context createConfigurationContext = super.createConfigurationContext(configuration);
            try {
                try {
                    FieldUtils.writeField(createConfigurationContext, "mResources", this.mPlugin.mResources);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable unused) {
                com.bytedance.pangle.a.b.a.a(createConfigurationContext.getClass(), "mResources").set(createConfigurationContext, this.mPlugin.mResources);
            }
            return createConfigurationContext;
        }
        return (Context) invokeL.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ("layout_inflater".equals(str)) {
                if (this.mInflater == null) {
                    LayoutInflater cloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
                    this.mInflater = cloneInContext;
                    com.bytedance.pangle.res.b.a(cloneInContext);
                }
                return this.mInflater;
            }
            Context context = this.mOriginContext;
            if (context != null) {
                return context.getSystemService(str);
            }
            return getBaseContext().getSystemService(str);
        }
        return invokeL.objValue;
    }
}
