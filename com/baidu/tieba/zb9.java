package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SpriteTypeWriterSwitch;
import com.baidu.tieba.impersonal.components.uistate.MsgEvents;
import com.baidu.tieba.impersonal.data.VoiceMsgContent;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final zb9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948354328, "Lcom/baidu/tieba/zb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948354328, "Lcom/baidu/tieba/zb9;");
                return;
            }
        }
        a = new zb9();
    }

    public zb9() {
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

    public final rb7<?> a(fd9 fd9Var, ub9<?> ub9Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{fd9Var, ub9Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = ub9Var.f();
            Class<?> cls = null;
            if (f instanceof vb9) {
                if (ub9Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                mb9 mb9Var = new mb9(ub9Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !ub9Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mb9Var.k(z2);
                mb9Var.h(MsgEvents.a.b(fd9Var));
                return mb9Var;
            } else if (f instanceof rb9) {
                return new lb9(ub9Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (ub9Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    nb9 nb9Var = new nb9(ub9Var, str2);
                    nb9Var.g(MsgEvents.a.a());
                    return nb9Var;
                } else if (f instanceof qb9) {
                    if (ub9Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new kb9(ub9Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = ub9Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (rb7) invokeCommon.objValue;
    }

    public final List<rb7<?>> b(fd9 repo, List<? extends pb9> list, SpriteMsgProcessor.e loadType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, repo, list, loadType)) == null) {
            Intrinsics.checkNotNullParameter(repo, "repo");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                pb9 pb9Var = (pb9) obj;
                if (pb9Var instanceof ub9) {
                    zb9 zb9Var = a;
                    ub9<?> ub9Var = (ub9) pb9Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    rb7<?> a2 = zb9Var.a(repo, ub9Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + pb9Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
