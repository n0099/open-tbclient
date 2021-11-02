package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.p0.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class WalletPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NPS_MODE = "Wallet";
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.tieba.wallet.WalletPluginImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.tieba.plugin.wallet";
    public transient /* synthetic */ FieldHolder $fh;
    public IWalletPlugin mIWalletPlugin;

    /* renamed from: com.baidu.tieba.wallet.WalletPluginManager$14  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass14 implements IInstallCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WalletPluginManager this$0;
        public final /* synthetic */ IInvokeCallback val$invokeCallback;

        public AnonymousClass14(WalletPluginManager walletPluginManager, IInvokeCallback iInvokeCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletPluginManager, iInvokeCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = walletPluginManager;
            this.val$invokeCallback = iInvokeCallback;
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && i2 == 13) {
                NPSManager.getInstance().loadClazz(WalletPluginManager.PLUGIN_PKG_NAME, WalletPluginManager.PLUGIN_IMPL_CLASS, IWalletPlugin.class, this.val$invokeCallback);
            }
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static WalletPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SingletonHolder.instance : (WalletPluginManager) invokeV.objValue;
    }

    public void accessWalletEntry(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.2
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$jumpData = str;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.accessWalletEntry(this.val$context, this.val$jumpData);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.accessWalletEntry(context, str);
            }
        }
    }

    public String doAliPay(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, z)) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this) { // from class: com.baidu.tieba.wallet.WalletPluginManager.7
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
                return null;
            }
            return iWalletPlugin.doAliPay(activity, str, z);
        }
        return (String) invokeLLZ.objValue;
    }

    public void doBaiduLBSPay(Activity activity, Map<String, String> map, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, map, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, activity, map, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.9
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduLBSPay(this.val$context, this.val$params, this.val$message, this.val$tag);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduLBSPay(activity, map, str, bdUniqueId);
            }
        }
    }

    public void doBaiduNovelPay(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.5
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$payOrder = str;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduNovelPay(this.val$context, this.val$payOrder);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduNovelPay(context, str);
            }
        }
    }

    public void doBaiduPay(Context context, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.6
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBaiduPay(this.val$context, this.val$payOrder, this.val$tag);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBaiduPay(context, str, bdUniqueId);
            }
        }
    }

    public void doBindCard(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, map) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, map) { // from class: com.baidu.tieba.wallet.WalletPluginManager.12
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$paramsMap = map;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doBindCard(this.val$context, this.val$paramsMap);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doBindCard(context, map);
            }
        }
    }

    public ITiebaPay doTiebaPay(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this) { // from class: com.baidu.tieba.wallet.WalletPluginManager.10
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
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

    public void doYYPay(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, fVar) { // from class: com.baidu.tieba.wallet.WalletPluginManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WalletPluginManager this$0;
                    public final /* synthetic */ f val$yyPayData;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$yyPayData = fVar;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doYYPay(this.val$yyPayData);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doYYPay(fVar);
            }
        }
    }

    public void gotoWalletService(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.4
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$id = str;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.gotoWalletService(this.val$context, this.val$id);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.gotoWalletService(context, str);
            }
        }
    }

    public void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iInvokeCallback) == null) {
            try {
                IWalletPlugin iWalletPlugin = (IWalletPlugin) Class.forName(PLUGIN_IMPL_CLASS).newInstance();
                this.mIWalletPlugin = iWalletPlugin;
                iWalletPlugin.init();
                if (iInvokeCallback != null) {
                    iInvokeCallback.onResult(14, null, null);
                }
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void openH5Module(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context, str) { // from class: com.baidu.tieba.wallet.WalletPluginManager.3
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$url = str;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.openH5Module(this.val$context, this.val$url);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.openH5Module(context, str);
            }
        }
    }

    public void registerIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this) { // from class: com.baidu.tieba.wallet.WalletPluginManager.13
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.registerIntent();
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.registerIntent();
            }
        }
    }

    public void startWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, context) { // from class: com.baidu.tieba.wallet.WalletPluginManager.1
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.startWallet(this.val$context);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.startWallet(context);
            }
        }
    }

    public WalletPluginManager() {
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

    public void doAliPay(Activity activity, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, bdUniqueId) == null) {
            IWalletPlugin iWalletPlugin = this.mIWalletPlugin;
            if (iWalletPlugin == null) {
                invokePlugin(new IInvokeCallback(this, activity, str, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginManager.8
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i2, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) && i2 == 14) {
                            try {
                                if (this.this$0.mIWalletPlugin == null) {
                                    this.this$0.mIWalletPlugin = (IWalletPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIWalletPlugin.init();
                                }
                                this.this$0.mIWalletPlugin.doAliPay(this.val$context, this.val$payOrder, this.val$tag);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iWalletPlugin.doAliPay(activity, str, bdUniqueId);
            }
        }
    }
}
