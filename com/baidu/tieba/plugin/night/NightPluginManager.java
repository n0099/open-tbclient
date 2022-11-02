package com.baidu.tieba.plugin.night;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.iw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NightPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.tieba.plugin.night.NightPluginImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.tieba.plugin.night";
    public transient /* synthetic */ FieldHolder $fh;
    public INightPlugin mINightPlugin;

    /* loaded from: classes5.dex */
    public class a implements IInvokeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ NightPluginManager b;

        public a(NightPluginManager nightPluginManager, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nightPluginManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nightPluginManager;
            this.a = i;
        }

        @Override // com.baidu.nps.main.invoke.IInvokeCallback
        public void onResult(int i, String str, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeILL(1048576, this, i, str, obj) != null) || i != 14) {
                return;
            }
            try {
                if (this.b.mINightPlugin == null) {
                    this.b.mINightPlugin = (INightPlugin) ((Class) obj).newInstance();
                }
                SkinManager.setPackageName(this.b.mINightPlugin.getNightPluginPackageName());
                iw4.a();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921608, Integer.valueOf(this.a)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements IInstallCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IInvokeCallback a;

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            }
        }

        public b(NightPluginManager nightPluginManager, IInvokeCallback iInvokeCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nightPluginManager, iInvokeCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iInvokeCallback;
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == 13) {
                NPSManager.getInstance().loadClazz(NightPluginManager.PLUGIN_PKG_NAME, NightPluginManager.PLUGIN_IMPL_CLASS, INightPlugin.class, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final NightPluginManager a;
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
            a = new NightPluginManager(null);
        }
    }

    public NightPluginManager() {
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

    public static NightPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.a;
        }
        return (NightPluginManager) invokeV.objValue;
    }

    public boolean isInvokePlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) != 43 && this.mINightPlugin == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ NightPluginManager(a aVar) {
        this();
    }

    private void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iInvokeCallback) == null) {
            if (isInvokePlugin()) {
                NPSManager.getInstance().loadClazz(PLUGIN_PKG_NAME, PLUGIN_IMPL_CLASS, INightPlugin.class, iInvokeCallback);
            } else {
                NPSPackageManager.getInstance().installBundle(PLUGIN_PKG_NAME, new b(this, iInvokeCallback));
            }
        }
    }

    public String getNightPluginPackageName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            INightPlugin iNightPlugin = this.mINightPlugin;
            if (iNightPlugin == null) {
                invokePlugin(new a(this, i));
                return null;
            }
            return iNightPlugin.getNightPluginPackageName();
        }
        return (String) invokeI.objValue;
    }
}
