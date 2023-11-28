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
/* loaded from: classes8.dex */
public final class vb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final vb9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235164, "Lcom/baidu/tieba/vb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235164, "Lcom/baidu/tieba/vb9;");
                return;
            }
        }
        a = new vb9();
    }

    public vb9() {
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

    public final nb7<?> a(bd9 bd9Var, qb9<?> qb9Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bd9Var, qb9Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = qb9Var.f();
            Class<?> cls = null;
            if (f instanceof rb9) {
                if (qb9Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                ib9 ib9Var = new ib9(qb9Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !qb9Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ib9Var.k(z2);
                ib9Var.h(MsgEvents.a.b(bd9Var));
                return ib9Var;
            } else if (f instanceof nb9) {
                return new hb9(qb9Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (qb9Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    jb9 jb9Var = new jb9(qb9Var, str2);
                    jb9Var.g(MsgEvents.a.a());
                    return jb9Var;
                } else if (f instanceof mb9) {
                    if (qb9Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new gb9(qb9Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = qb9Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (nb7) invokeCommon.objValue;
    }

    public final List<nb7<?>> b(bd9 repo, List<? extends lb9> list, SpriteMsgProcessor.e loadType) {
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
                lb9 lb9Var = (lb9) obj;
                if (lb9Var instanceof qb9) {
                    vb9 vb9Var = a;
                    qb9<?> qb9Var = (qb9) lb9Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    nb7<?> a2 = vb9Var.a(repo, qb9Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + lb9Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
