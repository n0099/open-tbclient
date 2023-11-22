package com.baidu.tieba.sdkcode.tts;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.sdkcode.ISdkCodePlugin;
import com.baidu.tieba.zha;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/sdkcode/tts/TtsManager;", "", "()V", "ttsApiClassProxy", "Lcom/baidu/tieba/sdkcode/tts/TtsApi;", "getTtsApiClassProxy", "()Lcom/baidu/tieba/sdkcode/tts/TtsApi;", "ttsApiClassProxy$delegate", "Lkotlin/Lazy;", "createTts", "getContext", "Landroid/content/Context;", "TtsInvocationHandler", "SdkCodeInterface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TtsManager {
    public static /* synthetic */ Interceptable $ic;
    public static final TtsManager INSTANCE;
    public static final Lazy ttsApiClassProxy$delegate;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            InterceptResult invokeLLL;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                TtsLog ttsLog = TtsLog.INSTANCE;
                Object[] objArr2 = new Object[3];
                objArr2[0] = "TtsInvocationHandler";
                objArr2[1] = "method";
                if (method != null) {
                    str = method.getName();
                } else {
                    str = null;
                }
                objArr2[2] = str;
                ttsLog.logI(objArr2);
                if (method != null) {
                    str2 = method.getName();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(str2, "speak")) {
                    BdUtilHelper.showToast(TtsManager.INSTANCE.getContext(), "插件未安装成功，暂不支持播放");
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1839320207, "Lcom/baidu/tieba/sdkcode/tts/TtsManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1839320207, "Lcom/baidu/tieba/sdkcode/tts/TtsManager;");
                return;
            }
        }
        INSTANCE = new TtsManager();
        ttsApiClassProxy$delegate = LazyKt__LazyJVMKt.lazy(TtsManager$ttsApiClassProxy$2.INSTANCE);
    }

    public TtsManager() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    private final TtsApi getTtsApiClassProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (TtsApi) ttsApiClassProxy$delegate.getValue();
        }
        return (TtsApi) invokeV.objValue;
    }

    public final TtsApi createTts() {
        InterceptResult invokeV;
        TtsApi ttsApi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ISdkCodePlugin h = zha.a.h();
            if (h != null) {
                ttsApi = h.createTtsApi();
            } else {
                ttsApi = null;
            }
            if (ttsApi != null) {
                ttsApi.init(getContext());
                return ttsApi;
            }
            return getTtsApiClassProxy();
        }
        return (TtsApi) invokeV.objValue;
    }
}
