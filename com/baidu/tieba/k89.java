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
/* loaded from: classes7.dex */
public final class k89 {
    public static /* synthetic */ Interceptable $ic;
    public static final k89 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867101, "Lcom/baidu/tieba/k89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867101, "Lcom/baidu/tieba/k89;");
                return;
            }
        }
        a = new k89();
    }

    public k89() {
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

    public final ab7<?> a(o99 o99Var, f89<?> f89Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{o99Var, f89Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = f89Var.f();
            Class<?> cls = null;
            if (f instanceof g89) {
                if (f89Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                x79 x79Var = new x79(f89Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !f89Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                x79Var.k(z2);
                x79Var.h(MsgEvents.a.b(o99Var));
                return x79Var;
            } else if (f instanceof c89) {
                return new w79(f89Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (f89Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    y79 y79Var = new y79(f89Var, str2);
                    y79Var.g(MsgEvents.a.a());
                    return y79Var;
                } else if (f instanceof b89) {
                    if (f89Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new v79(f89Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = f89Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (ab7) invokeCommon.objValue;
    }

    public final List<ab7<?>> b(o99 repo, List<? extends a89> list, SpriteMsgProcessor.e loadType) {
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
                a89 a89Var = (a89) obj;
                if (a89Var instanceof f89) {
                    k89 k89Var = a;
                    f89<?> f89Var = (f89) a89Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    ab7<?> a2 = k89Var.a(repo, f89Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + a89Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
