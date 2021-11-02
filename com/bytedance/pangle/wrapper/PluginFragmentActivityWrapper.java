package com.bytedance.pangle.wrapper;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.b;
import com.bytedance.pangle.util.FieldUtils;
@Keep
/* loaded from: classes11.dex */
public class PluginFragmentActivityWrapper extends GenerateFragmentActivityWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasInit;

    public PluginFragmentActivityWrapper(Activity activity, PluginContext pluginContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, pluginContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasInit = true;
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        this.mOriginActivity = fragmentActivity;
        this.pluginContext = pluginContext;
        if (!fragmentActivity.isDestroyed()) {
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(new b(this) { // from class: com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PluginFragmentActivityWrapper f61533a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f61533a = this;
                }

                @Override // com.bytedance.pangle.b, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity2) == null) {
                        super.onActivityDestroyed(activity2);
                        if (activity2 == this.f61533a.mOriginActivity) {
                            Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
                        }
                    }
                }
            });
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        com.bytedance.pangle.util.a.a(this, activity);
    }

    @Override // com.bytedance.pangle.wrapper.GenerateFragmentActivityWrapper, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.hasInit) {
                try {
                    return new LifecycleRegistry(this);
                } catch (Throwable unused) {
                }
            }
            return super.getLifecycle();
        }
        return (Lifecycle) invokeV.objValue;
    }

    public Activity getOriginActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOriginActivity : (Activity) invokeV.objValue;
    }
}
