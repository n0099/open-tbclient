package com.baidu.tieba.plugin.night;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NightPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.tieba.plugin.night.NightPluginImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.tieba.plugin.night";
    public transient /* synthetic */ FieldHolder $fh;
    public INightPlugin mINightPlugin;

    /* loaded from: classes7.dex */
    public class a implements IInvokeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NightPluginManager f55829b;

        public a(NightPluginManager nightPluginManager, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nightPluginManager, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55829b = nightPluginManager;
            this.f55828a = i2;
        }

        @Override // com.baidu.nps.main.invoke.IInvokeCallback
        public void onResult(int i2, String str, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                try {
                    if (this.f55829b.mINightPlugin == null) {
                        this.f55829b.mINightPlugin = (INightPlugin) ((Class) obj).newInstance();
                    }
                    SkinManager.setPackageName(this.f55829b.mINightPlugin.getNightPluginPackageName());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921608, Integer.valueOf(this.f55828a)));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IInstallCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IInvokeCallback f55830a;

        public b(NightPluginManager nightPluginManager, IInvokeCallback iInvokeCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nightPluginManager, iInvokeCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55830a = iInvokeCallback;
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onProgress(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && i2 == 13) {
                NPSManager.getInstance().loadClazz(NightPluginManager.PLUGIN_PKG_NAME, NightPluginManager.PLUGIN_IMPL_CLASS, INightPlugin.class, this.f55830a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final NightPluginManager f55831a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1284623093, "Lcom/baidu/tieba/plugin/night/NightPluginManager$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1284623093, "Lcom/baidu/tieba/plugin/night/NightPluginManager$c;");
                    return;
                }
            }
            f55831a = new NightPluginManager(null);
        }
    }

    public /* synthetic */ NightPluginManager(a aVar) {
        this();
    }

    public static NightPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.f55831a : (NightPluginManager) invokeV.objValue;
    }

    private void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, iInvokeCallback) == null) {
            if (isInvokePlugin()) {
                NPSManager.getInstance().loadClazz(PLUGIN_PKG_NAME, PLUGIN_IMPL_CLASS, INightPlugin.class, iInvokeCallback);
            } else {
                NPSPackageManager.getInstance().installBundle(PLUGIN_PKG_NAME, new b(this, iInvokeCallback));
            }
        }
    }

    public String getNightPluginPackageName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            INightPlugin iNightPlugin = this.mINightPlugin;
            if (iNightPlugin == null) {
                invokePlugin(new a(this, i2));
                return null;
            }
            return iNightPlugin.getNightPluginPackageName();
        }
        return (String) invokeI.objValue;
    }

    public boolean isInvokePlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) == 43 : invokeV.booleanValue;
    }

    public NightPluginManager() {
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
}
