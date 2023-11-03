package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tieba.jc5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback;
import java.util.Map;
import kotlin.jvm.functions.Function1;
/* loaded from: classes8.dex */
public class WalletPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NPS_MODE = "Wallet";
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.tieba.wallet.WalletPluginImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.tieba.plugin.wallet";
    public static final String TAG = "WalletPlugin";
    public transient /* synthetic */ FieldHolder $fh;
    public IWalletPlugin mIWalletPlugin;

    /* loaded from: classes8.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final WalletPluginManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-565901233, "Lcom/baidu/tieba/wallet/WalletPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-565901233, "Lcom/baidu/tieba/wallet/WalletPluginManager$SingletonHolder;");
                    return;
                }
            }
            instance = new WalletPluginManager();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public WalletPluginManager() {
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

    public static WalletPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SingletonHolder.instance;
        }
        return (WalletPluginManager) invokeV.objValue;
    }

    private boolean isWalletPluginEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.mIWalletPlugin == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isInvokePlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) != 43 && this.mIWalletPlugin == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void registerIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this) { // from class: com.baidu.tieba.wallet.WalletPluginManager.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            super.onResult(i, str, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.registerIntent();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.registerIntent();
            }
        }
    }

    public ITiebaPay doTiebaPay(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this) { // from class: com.baidu.tieba.wallet.WalletPluginManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            super.onResult(i, str, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return null;
            }
            return iWalletPlugin.doTiebaPay(activity);
        }
        return (ITiebaPay) invokeL.objValue;
    }

    public void startWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context) { // from class: com.baidu.tieba.wallet.WalletPluginManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            super.onResult(i, str, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.startWallet(this.val$context);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.startWallet(context);
            }
        }
    }

    public void accessWalletEntry(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$jumpData;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$jumpData = str;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.accessWalletEntry(this.val$context, this.val$jumpData);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.accessWalletEntry(context, str);
            }
        }
    }

    public void doBaiduNovelPay(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$payOrder;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$payOrder = str;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduNovelPay(this.val$context, this.val$payOrder);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduNovelPay(context, str);
            }
        }
    }

    public void doBindCard(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, map) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, map) { // from class: com.baidu.tieba.wallet.WalletPluginManager.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ Map val$paramsMap;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, map};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$paramsMap = map;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            super.onResult(i, str, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBindCard(this.val$context, this.val$paramsMap);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBindCard(context, map);
            }
        }
    }

    public void doYYPay(String str, IDxmProxyCallback iDxmProxyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, iDxmProxyCallback) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, str, iDxmProxyCallback) { // from class: com.baidu.tieba.wallet.WalletPluginManager.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ IDxmProxyCallback val$iDxmProxyCallback;
                    public final /* synthetic */ String val$payload;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, iDxmProxyCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$payload = str;
                        this.val$iDxmProxyCallback = iDxmProxyCallback;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doYYPay(this.val$payload, this.val$iDxmProxyCallback);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doYYPay(str, iDxmProxyCallback);
            }
        }
    }

    public void gotoWalletService(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$id;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$id = str;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.gotoWalletService(this.val$context, this.val$id);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.gotoWalletService(context, str);
            }
        }
    }

    public void openH5Module(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$url = str;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.openH5Module(this.val$context, this.val$url);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.openH5Module(context, str);
            }
        }
    }

    public void doAliAuth(Activity activity, String str, Map<String, String> map, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, map, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, activity, str, map, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Activity val$context;
                    public final /* synthetic */ Map val$params;
                    public final /* synthetic */ String val$scheme;
                    public final /* synthetic */ BdUniqueId val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, str, map, bdUniqueId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = activity;
                        this.val$scheme = str;
                        this.val$params = map;
                        this.val$tag = bdUniqueId;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doAliAuth(this.val$context, this.val$scheme, this.val$params, this.val$tag);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doAliAuth(activity, str, map, bdUniqueId);
            }
        }
    }

    public void doBaiduLBSPay(Activity activity, Map<String, String> map, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, activity, map, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, activity, map, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Activity val$context;
                    public final /* synthetic */ String val$message;
                    public final /* synthetic */ Map val$params;
                    public final /* synthetic */ BdUniqueId val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, map, str, bdUniqueId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = activity;
                        this.val$params = map;
                        this.val$message = str;
                        this.val$tag = bdUniqueId;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduLBSPay(this.val$context, this.val$params, this.val$message, this.val$tag);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduLBSPay(activity, map, str, bdUniqueId);
            }
        }
    }

    public String doAliPay(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, activity, str, z)) == null) {
            return doAliPayWithCallback(activity, str, z, null);
        }
        return (String) invokeLLZ.objValue;
    }

    public void doBaiduPay(Context context, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, context, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$payOrder;
                    public final /* synthetic */ BdUniqueId val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, bdUniqueId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$payOrder = str;
                        this.val$tag = bdUniqueId;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduPay(this.val$context, this.val$payOrder, this.val$tag);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduPay(context, str, bdUniqueId);
            }
        }
    }

    public void doAliPay(Activity activity, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, activity, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Activity val$context;
                    public final /* synthetic */ String val$payOrder;
                    public final /* synthetic */ BdUniqueId val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, str, bdUniqueId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = activity;
                        this.val$payOrder = str;
                        this.val$tag = bdUniqueId;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doAliPay(this.val$context, this.val$payOrder, this.val$tag);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doAliPay(activity, str, bdUniqueId);
            }
        }
    }

    public String doAliPayWithCallback(Activity activity, String str, boolean z, @Nullable Function1<String, Void> function1) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, str, Boolean.valueOf(z), function1})) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new jc5(this, function1, activity, str, z) { // from class: com.baidu.tieba.wallet.WalletPluginManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ Function1 val$callback;
                    public final /* synthetic */ Activity val$context;
                    public final /* synthetic */ boolean val$flag;
                    public final /* synthetic */ String val$payInfoUrl;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, function1, activity, str, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = function1;
                        this.val$context = activity;
                        this.val$payInfoUrl = str;
                        this.val$flag = z;
                    }

                    @Override // com.baidu.tieba.jc5, com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                            super.onResult(i, str2, obj);
                            if (i != 14) {
                                return;
                            }
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                if (this.val$callback != null) {
                                    this.val$callback.invoke(this.this$0.mIWalletPlugin.doAliPay(this.val$context, this.val$payInfoUrl, this.val$flag));
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return null;
            }
            String doAliPay = iWalletPlugin.doAliPay(activity, str, z);
            if (function1 != null) {
                function1.invoke(doAliPay);
            }
            return doAliPay;
        }
        return (String) invokeCommon.objValue;
    }

    public void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iInvokeCallback) == null) {
            if (GlobalBuildConfig.getTiebaNpsPluginMode().contains("Host") && GlobalBuildConfig.getTiebaNpsPluginMode().contains("-Wallet")) {
                if (NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) == 43) {
                    if (PluginCheck.c(PLUGIN_PKG_NAME, iInvokeCallback, TAG, false)) {
                        NPSManager.getInstance().loadClazz(PLUGIN_PKG_NAME, PLUGIN_IMPL_CLASS, IWalletPlugin.class, iInvokeCallback);
                        return;
                    }
                    return;
                }
                NPSPackageManager.getInstance().installBundle(PLUGIN_PKG_NAME, new IInstallCallback(this, iInvokeCallback) { // from class: com.baidu.tieba.wallet.WalletPluginManager.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ IInvokeCallback val$invokeCallback;

                    @Override // com.baidu.nps.main.install.IInstallCallback
                    public void onProgress(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iInvokeCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$invokeCallback = iInvokeCallback;
                    }

                    @Override // com.baidu.nps.main.install.IInstallCallback
                    public void onResult(int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == 13 && PluginCheck.c(WalletPluginManager.PLUGIN_PKG_NAME, this.val$invokeCallback, WalletPluginManager.TAG, true)) {
                            NPSManager.getInstance().loadClazz(WalletPluginManager.PLUGIN_PKG_NAME, WalletPluginManager.PLUGIN_IMPL_CLASS, IWalletPlugin.class, this.val$invokeCallback);
                        }
                    }
                });
                return;
            }
            try {
                IWalletPlugin iWalletPlugin = (IWalletPlugin) Class.forName(PLUGIN_IMPL_CLASS).newInstance();
                this.mIWalletPlugin = iWalletPlugin;
                iWalletPlugin.init();
                if (iInvokeCallback != null) {
                    iInvokeCallback.onResult(14, null, null);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
    }
}
