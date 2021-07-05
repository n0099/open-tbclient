package com.baidu.webkit.internal;

import android.webkit.ValueCallback;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class ApisInteractWithMario implements INoProGuard {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ApisInteractWithMario";
    public static final ArrayList<Runnable> mPenddingOps;
    public static ApisInteractWithMario sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-199968865, "Lcom/baidu/webkit/internal/ApisInteractWithMario;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-199968865, "Lcom/baidu/webkit/internal/ApisInteractWithMario;");
                return;
            }
        }
        mPenddingOps = new ArrayList<>();
    }

    public ApisInteractWithMario() {
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

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, valueCallback) == null) {
            if (!WebViewFactory.hasProvider()) {
                synchronized (mPenddingOps) {
                    mPenddingOps.add(new Runnable(valueCallback) { // from class: com.baidu.webkit.internal.ApisInteractWithMario.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ValueCallback f27274a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {valueCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27274a = valueCallback;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ApisInteractWithMario.addOnCronetThreadInitializedListener(this.f27274a);
                            }
                        }
                    });
                }
                return;
            }
            ApisInteractWithMario impl = getImpl();
            if (impl != null) {
                impl.addOnCronetThreadInitializedListenerImpl(valueCallback);
            } else {
                Log.e(TAG, "Not implemented!");
            }
        }
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (!WebViewFactory.hasProvider()) {
                synchronized (mPenddingOps) {
                    mPenddingOps.add(new Runnable(str) { // from class: com.baidu.webkit.internal.ApisInteractWithMario.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f27273a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27273a = str;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ApisInteractWithMario.clearCrashKey(this.f27273a);
                            }
                        }
                    });
                }
                return;
            }
            ApisInteractWithMario impl = getImpl();
            if (impl != null) {
                impl.clearCrashKeyImpl(str);
            } else {
                Log.e(TAG, "Not implemented!");
            }
        }
    }

    public static ApisInteractWithMario getImpl() {
        InterceptResult invokeV;
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (sInstance == null && (provider = WebViewFactory.getProvider()) != null) {
                Object apisInteractWithMario = provider.getApisInteractWithMario();
                if (apisInteractWithMario instanceof ApisInteractWithMario) {
                    sInstance = (ApisInteractWithMario) apisInteractWithMario;
                }
            }
            return sInstance;
        }
        return (ApisInteractWithMario) invokeV.objValue;
    }

    public static void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (mPenddingOps) {
                Iterator<Runnable> it = mPenddingOps.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                mPenddingOps.clear();
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            if (!WebViewFactory.hasProvider()) {
                synchronized (mPenddingOps) {
                    mPenddingOps.add(new Runnable(str, str2) { // from class: com.baidu.webkit.internal.ApisInteractWithMario.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f27271a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f27272b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27271a = str;
                            this.f27272b = str2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ApisInteractWithMario.setCrashKeyValue(this.f27271a, this.f27272b);
                            }
                        }
                    });
                }
                return;
            }
            ApisInteractWithMario impl = getImpl();
            if (impl != null) {
                impl.setCrashKeyValueImpl(str, str2);
            } else {
                Log.e(TAG, "Not implemented!");
            }
        }
    }

    public static void setMessageChannalFunctoinTable(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            if (!WebViewFactory.hasProvider()) {
                synchronized (mPenddingOps) {
                    mPenddingOps.add(new Runnable(j) { // from class: com.baidu.webkit.internal.ApisInteractWithMario.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ long f27270a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {Long.valueOf(j)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27270a = j;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ApisInteractWithMario.setMessageChannalFunctoinTable(this.f27270a);
                            }
                        }
                    });
                }
                return;
            }
            ApisInteractWithMario impl = getImpl();
            if (impl != null) {
                impl.setMessageChannalFunctoinTableImpl(j);
            } else {
                Log.e(TAG, "Not implemented!");
            }
        }
    }

    public abstract void addOnCronetThreadInitializedListenerImpl(ValueCallback<Long> valueCallback);

    public abstract void clearCrashKeyImpl(String str);

    public abstract void setCrashKeyValueImpl(String str, String str2);

    public abstract void setMessageChannalFunctoinTableImpl(long j);
}
