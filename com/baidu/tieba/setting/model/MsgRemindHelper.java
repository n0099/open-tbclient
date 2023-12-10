package com.baidu.tieba.setting.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.ia5;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.tieba.rj6;
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
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u00152\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/tieba/setting/model/MsgRemindHelper;", "", "()V", "KEY_FAILED", "", "OPT_GET", "OPT_SET", "nameToTypeAndMethod", "", "Lcom/baidu/tieba/setting/model/MsgRemindHelper$TypeAndMethod;", "settingManager", "Lcom/baidu/tbadk/coreExtra/messageCenter/MessageSettingManager;", "kotlin.jvm.PlatformType", "webViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "getTbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "context", "Landroid/content/Context;", "handlePushNotificationPermission", "", "webView", "switchName", "operateType", "setStatus", "notifyWebView", "params", "", "switchSetting", "pageContext", "remindType", "", "remindValue", "", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "TypeAndMethod", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MsgRemindHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final MsgRemindHelper a;
    public static final ia5 b;
    public static WeakReference<WebView> c;
    public static final Map<String, TypeAndMethod> d;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/setting/model/MsgRemindHelper$TypeAndMethod;", "Ljava/io/Serializable;", "remindType", "", "revertSetValue", "", "setMethod", "Lkotlin/Function1;", "", "getMethod", "Lkotlin/Function0;", "(IZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getGetMethod", "()Lkotlin/jvm/functions/Function0;", "getRemindType", "()I", "getRevertSetValue", "()Z", "getSetMethod", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "", "hashCode", "toString", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class TypeAndMethod implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function0<Boolean> getMethod;
        public final int remindType;
        public final boolean revertSetValue;
        public final Function1<Boolean, Unit> setMethod;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.setting.model.MsgRemindHelper$TypeAndMethod */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TypeAndMethod copy$default(TypeAndMethod typeAndMethod, int i, boolean z, Function1 function1, Function0 function0, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = typeAndMethod.remindType;
            }
            if ((i2 & 2) != 0) {
                z = typeAndMethod.revertSetValue;
            }
            if ((i2 & 4) != 0) {
                function1 = typeAndMethod.setMethod;
            }
            if ((i2 & 8) != 0) {
                function0 = typeAndMethod.getMethod;
            }
            return typeAndMethod.copy(i, z, function1, function0);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.remindType : invokeV.intValue;
        }

        public final boolean component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.revertSetValue : invokeV.booleanValue;
        }

        public final Function1<Boolean, Unit> component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.setMethod : (Function1) invokeV.objValue;
        }

        public final Function0<Boolean> component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.getMethod : (Function0) invokeV.objValue;
        }

        public final TypeAndMethod copy(int i, boolean z, Function1<? super Boolean, Unit> function1, Function0<Boolean> getMethod) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), function1, getMethod})) == null) {
                Intrinsics.checkNotNullParameter(getMethod, "getMethod");
                return new TypeAndMethod(i, z, function1, getMethod);
            }
            return (TypeAndMethod) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TypeAndMethod) {
                    TypeAndMethod typeAndMethod = (TypeAndMethod) obj;
                    return this.remindType == typeAndMethod.remindType && this.revertSetValue == typeAndMethod.revertSetValue && Intrinsics.areEqual(this.setMethod, typeAndMethod.setMethod) && Intrinsics.areEqual(this.getMethod, typeAndMethod.getMethod);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int i = this.remindType * 31;
                boolean z = this.revertSetValue;
                int i2 = z;
                if (z != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                Function1<Boolean, Unit> function1 = this.setMethod;
                return ((i3 + (function1 == null ? 0 : function1.hashCode())) * 31) + this.getMethod.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "TypeAndMethod(remindType=" + this.remindType + ", revertSetValue=" + this.revertSetValue + ", setMethod=" + this.setMethod + ", getMethod=" + this.getMethod + ')';
            }
            return (String) invokeV.objValue;
        }

        public TypeAndMethod(int i, boolean z, Function1<? super Boolean, Unit> function1, Function0<Boolean> getMethod) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), function1, getMethod};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(getMethod, "getMethod");
            this.remindType = i;
            this.revertSetValue = z;
            this.setMethod = function1;
            this.getMethod = getMethod;
        }

        public /* synthetic */ TypeAndMethod(int i, boolean z, Function1 function1, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : function1, function0);
        }

        public final Function0<Boolean> getGetMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.getMethod;
            }
            return (Function0) invokeV.objValue;
        }

        public final int getRemindType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.remindType;
            }
            return invokeV.intValue;
        }

        public final boolean getRevertSetValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.revertSetValue;
            }
            return invokeV.booleanValue;
        }

        public final Function1<Boolean, Unit> getSetMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.setMethod;
            }
            return (Function1) invokeV.objValue;
        }
    }

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
        b = ia5.e();
        d = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("officialPush", new TypeAndMethod(6, true, null, MsgRemindHelper$nameToTypeAndMethod$1.INSTANCE, 4, null)), TuplesKt.to("collectThreadsUpdate", new TypeAndMethod(36, false, null, MsgRemindHelper$nameToTypeAndMethod$2.INSTANCE, 6, null)), TuplesKt.to("replyMe", new TypeAndMethod(1, false, null, MsgRemindHelper$nameToTypeAndMethod$3.INSTANCE, 6, null)), TuplesKt.to(FeedData.TYPE_ZAN, new TypeAndMethod(20, false, null, MsgRemindHelper$nameToTypeAndMethod$4.INSTANCE, 6, null)), TuplesKt.to("atMe", new TypeAndMethod(2, false, null, MsgRemindHelper$nameToTypeAndMethod$5.INSTANCE, 6, null)), TuplesKt.to("newFans", new TypeAndMethod(3, false, null, MsgRemindHelper$nameToTypeAndMethod$6.INSTANCE, 6, null)), TuplesKt.to("mutualFriendPush", new TypeAndMethod(10, false, null, MsgRemindHelper$nameToTypeAndMethod$7.INSTANCE, 6, null)), TuplesKt.to("followUserEssenceUpdate", new TypeAndMethod(34, false, null, MsgRemindHelper$nameToTypeAndMethod$8.INSTANCE, 6, null)), TuplesKt.to("signPush", new TypeAndMethod(-1, false, MsgRemindHelper$nameToTypeAndMethod$9.INSTANCE, MsgRemindHelper$nameToTypeAndMethod$10.INSTANCE, 2, null)), TuplesKt.to("signAlert", new TypeAndMethod(37, false, null, MsgRemindHelper$nameToTypeAndMethod$11.INSTANCE, 6, null)), TuplesKt.to("forumBroadcast", new TypeAndMethod(7, true, null, MsgRemindHelper$nameToTypeAndMethod$12.INSTANCE, 4, null)));
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
    public static final void d(WebView webView, String switchName, String operateType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView, switchName, operateType, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(switchName, "switchName");
            Intrinsics.checkNotNullParameter(operateType, "operateType");
            TypeAndMethod typeAndMethod = d.get(switchName);
            MsgRemindHelper msgRemindHelper = a;
            Context context = webView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "webView.context");
            TbPageContext<?> c2 = msgRemindHelper.c(context);
            if (typeAndMethod != null && c2 != null) {
                c = new WeakReference<>(webView);
                boolean areEqual = Intrinsics.areEqual("set", operateType);
                String str2 = "1";
                if (areEqual) {
                    boolean areEqual2 = Intrinsics.areEqual(str, "1");
                    if (typeAndMethod.getRevertSetValue()) {
                        areEqual2 = !areEqual2;
                    }
                    int remindType = typeAndMethod.getRemindType();
                    if (remindType >= 0) {
                        g(c2, remindType, areEqual2, MsgRemindHelper$handlePushNotificationPermission$1.INSTANCE);
                        return;
                    } else if (typeAndMethod.getSetMethod() != null) {
                        typeAndMethod.getSetMethod().invoke(Boolean.valueOf(areEqual2));
                        a.e(new LinkedHashMap());
                        return;
                    } else {
                        a.e(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("key_failed", "key_failed")));
                        return;
                    }
                }
                boolean booleanValue = typeAndMethod.getGetMethod().invoke().booleanValue();
                MsgRemindHelper msgRemindHelper2 = a;
                Pair[] pairArr = new Pair[1];
                if (!booleanValue) {
                    str2 = "0";
                }
                pairArr[0] = TuplesKt.to("status", str2);
                msgRemindHelper2.e(MapsKt__MapsKt.mutableMapOf(pairArr));
                return;
            }
            a.e(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("key_failed", "key_failed")));
        }
    }

    public static final void f(Map params) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, params) == null) {
            Intrinsics.checkNotNullParameter(params, "$params");
            WeakReference<WebView> weakReference = c;
            if (weakReference != null && (webView = weakReference.get()) != null) {
                rj6.a().d(webView, "pushNotificationPermission", new HashMap<>(params));
            }
        }
    }

    public final void e(final Map<String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.kna
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgRemindHelper.f(map);
                    }
                }
            });
        }
    }

    @JvmStatic
    public static final void g(TbPageContext<?> pageContext, int i, boolean z, Function1<? super Boolean, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{pageContext, Integer.valueOf(i), Boolean.valueOf(z), callback}) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            new MsgRemindModel(pageContext).T(i, z, new a(callback));
        }
    }

    public final TbPageContext<?> c(Context context) {
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
                return c(baseContext);
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }
}
