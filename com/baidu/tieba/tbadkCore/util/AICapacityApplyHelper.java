package com.baidu.tieba.tbadkCore.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.aiApply.AICapacityMainProcessToastEvent;
import com.baidu.tbadk.mutiprocess.aiApply.AICapacityStatusUpdateEvent;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper;", "", "()V", "aiCapacityPermission", "", "aiWriteScheme", "", PopItemMethodConstant.showToast, "toastRunnable", "Ljava/lang/Runnable;", "checkAIAbilityPermission", "popH5AiApplyDialog", "", "type", "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$capacityApplyType;", "processToastToMainProcess", "toastStr", "replaceSchemaParam", "oldScheme", "replaceStr", "setAICapavityPermission", ShareLoginStat.GetShareListStat.KEY_PERMISSION, "setAIWriteScheme", "scheme", "toastShow", "toastText", "updateAICapacityStatusByEvent", "Companion", "capacityApplyType", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AICapacityApplyHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final a e;
    public static final Lazy<AICapacityApplyHelper> f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;
    public final Runnable d;

    /* loaded from: classes8.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249428692, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-249428692, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$b;");
                    return;
                }
            }
            int[] iArr = new int[capacityApplyType.values().length];
            iArr[capacityApplyType.AI_WRITE_POST.ordinal()] = 1;
            iArr[capacityApplyType.AI_WRITE_REPLY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final AICapacityApplyHelper c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e.a() : (AICapacityApplyHelper) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        @JvmStatic
        public final AICapacityApplyHelper a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (AICapacityApplyHelper) invokeV.objValue;
        }

        public final AICapacityApplyHelper b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (AICapacityApplyHelper) AICapacityApplyHelper.f.getValue();
            }
            return (AICapacityApplyHelper) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$capacityApplyType;", "", "(Ljava/lang/String;I)V", "AI_WRITE_POST", "AI_WRITE_REPLY", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class capacityApplyType {
        public static final /* synthetic */ capacityApplyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final capacityApplyType AI_WRITE_POST;
        public static final capacityApplyType AI_WRITE_REPLY;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ capacityApplyType[] $values() {
            return new capacityApplyType[]{AI_WRITE_POST, AI_WRITE_REPLY};
        }

        public static capacityApplyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (capacityApplyType) Enum.valueOf(capacityApplyType.class, str) : (capacityApplyType) invokeL.objValue;
        }

        public static capacityApplyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (capacityApplyType[]) $VALUES.clone() : (capacityApplyType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1710285600, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$capacityApplyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1710285600, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper$capacityApplyType;");
                    return;
                }
            }
            AI_WRITE_POST = new capacityApplyType("AI_WRITE_POST", 0);
            AI_WRITE_REPLY = new capacityApplyType("AI_WRITE_REPLY", 1);
            $VALUES = $values();
        }

        public capacityApplyType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1117576726, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1117576726, "Lcom/baidu/tieba/tbadkCore/util/AICapacityApplyHelper;");
                return;
            }
        }
        e = new a(null);
        f = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) AICapacityApplyHelper$Companion$instance$2.INSTANCE);
    }

    public AICapacityApplyHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = new Runnable() { // from class: com.baidu.tieba.zga
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    AICapacityApplyHelper.i(AICapacityApplyHelper.this);
                }
            }
        };
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public static final void i(AICapacityApplyHelper this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c = true;
        }
    }

    public final void e(String toastStr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, toastStr) == null) {
            Intrinsics.checkNotNullParameter(toastStr, "toastStr");
            AICapacityMainProcessToastEvent aICapacityMainProcessToastEvent = new AICapacityMainProcessToastEvent();
            aICapacityMainProcessToastEvent.setToastString(toastStr);
            MutiProcessManager.publishEvent(aICapacityMainProcessToastEvent);
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public final void h(String scheme) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scheme) == null) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            this.b = scheme;
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            AICapacityStatusUpdateEvent aICapacityStatusUpdateEvent = new AICapacityStatusUpdateEvent();
            aICapacityStatusUpdateEvent.setAiCapacityPermission(z);
            MutiProcessManager.publishEvent(aICapacityStatusUpdateEvent);
        }
    }

    public final void d(capacityApplyType type) {
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = b.$EnumSwitchMapping$0[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    f2 = null;
                } else {
                    f2 = f(this.b, "reply");
                }
            } else {
                f2 = f(this.b, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND);
            }
            if (f2 != null) {
                UrlManager.getInstance().dealOneLink(f2);
            }
        }
    }

    public final void j(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && this.c) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).show();
                this.c = false;
                SafeHandler.getInst().postDelayed(this.d, 2000L);
            }
        }
    }

    public final String f(String str, String replaceStr) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, replaceStr)) == null) {
            Intrinsics.checkNotNullParameter(replaceStr, "replaceStr");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "dialog_ai_write_scene_from", false, 2, (Object) null)) {
                return StringsKt__StringsJVMKt.replace(str, "dialog_ai_write_scene_from", replaceStr, false);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}
