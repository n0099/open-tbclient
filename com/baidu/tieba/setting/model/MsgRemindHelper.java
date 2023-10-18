package com.baidu.tieba.setting.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.hh6;
import com.baidu.tieba.setting.model.MsgRemindHelper;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u00152\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\"H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/setting/model/MsgRemindHelper;", "", "()V", "KEY_FAILED", "", "OPT_GET", "OPT_SET", "nameToMethod", "", "Lkotlin/Function0;", "", "nameToRemindType", "", "webViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "getTbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "context", "Landroid/content/Context;", "handlePushNotificationPermission", "", "webView", "switchName", "operateType", "setStatus", "notifyWebView", "params", "", "switchSetting", "pageContext", "remindType", "remindValue", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MsgRemindHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final MsgRemindHelper a;
    public static final Map<String, Integer> b;
    public static final Map<String, Function0<Boolean>> c;
    public static WeakReference<WebView> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements MsgRemindModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function1<Boolean, Unit> a;

        public a(Function1<? super Boolean, Unit> function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function1;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.invoke(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(480711098, "Lcom/baidu/tieba/setting/model/MsgRemindHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(480711098, "Lcom/baidu/tieba/setting/model/MsgRemindHelper;");
                return;
            }
        }
        a = new MsgRemindHelper();
        b = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("collectThreadsUpdate", 36), TuplesKt.to("followUserEssenceUpdate", 34), TuplesKt.to("officialPush", 6));
        c = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("collectThreadsUpdate", MsgRemindHelper$nameToMethod$1.INSTANCE), TuplesKt.to("followUserEssenceUpdate", MsgRemindHelper$nameToMethod$2.INSTANCE), TuplesKt.to("officialPush", MsgRemindHelper$nameToMethod$3.INSTANCE));
    }

    public MsgRemindHelper() {
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

    @JvmStatic
    public static final void c(WebView webView, String switchName, String operateType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, webView, switchName, operateType, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(switchName, "switchName");
            Intrinsics.checkNotNullParameter(operateType, "operateType");
            Integer num = b.get(switchName);
            MsgRemindHelper msgRemindHelper = a;
            Context context = webView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "webView.context");
            TbPageContext<?> b2 = msgRemindHelper.b(context);
            if (num != null && b2 != null) {
                d = new WeakReference<>(webView);
                boolean areEqual = Intrinsics.areEqual("set", operateType);
                String str2 = "1";
                if (areEqual) {
                    boolean areEqual2 = Intrinsics.areEqual(str, "1");
                    if (num.intValue() == 6) {
                        areEqual2 = !areEqual2;
                    }
                    f(b2, num.intValue(), areEqual2, MsgRemindHelper$handlePushNotificationPermission$1.INSTANCE);
                    return;
                }
                Function0<Boolean> function0 = c.get(switchName);
                Intrinsics.checkNotNull(function0);
                boolean booleanValue = function0.invoke().booleanValue();
                MsgRemindHelper msgRemindHelper2 = a;
                Pair[] pairArr = new Pair[1];
                if (!booleanValue) {
                    str2 = "0";
                }
                pairArr[0] = TuplesKt.to("status", str2);
                msgRemindHelper2.d(MapsKt__MapsKt.mutableMapOf(pairArr));
                return;
            }
            a.d(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("key_failed", "key_failed")));
        }
    }

    public static final void e(Map params) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, params) == null) {
            Intrinsics.checkNotNullParameter(params, "$params");
            WeakReference<WebView> weakReference = d;
            if (weakReference != null && (webView = weakReference.get()) != null) {
                hh6.a().d(webView, "pushNotificationPermission", new HashMap<>(params));
            }
        }
    }

    public final void d(final Map<String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.g5a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgRemindHelper.e(map);
                    }
                }
            });
        }
    }

    @JvmStatic
    public static final void f(TbPageContext<?> pageContext, int i, boolean z, Function1<? super Boolean, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pageContext, Integer.valueOf(i), Boolean.valueOf(z), callback}) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            new MsgRemindModel(pageContext).S(i, z, new a(callback));
        }
    }

    public final TbPageContext<?> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "context.baseContext");
                return b(baseContext);
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }
}
