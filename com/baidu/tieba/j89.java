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
/* loaded from: classes6.dex */
public final class j89 {
    public static /* synthetic */ Interceptable $ic;
    public static final j89 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837310, "Lcom/baidu/tieba/j89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837310, "Lcom/baidu/tieba/j89;");
                return;
            }
        }
        a = new j89();
    }

    public j89() {
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

    public final za7<?> a(n99 n99Var, e89<?> e89Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{n99Var, e89Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = e89Var.f();
            Class<?> cls = null;
            if (f instanceof f89) {
                if (e89Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                w79 w79Var = new w79(e89Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !e89Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                w79Var.k(z2);
                w79Var.h(MsgEvents.a.b(n99Var));
                return w79Var;
            } else if (f instanceof b89) {
                return new v79(e89Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (e89Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    x79 x79Var = new x79(e89Var, str2);
                    x79Var.g(MsgEvents.a.a());
                    return x79Var;
                } else if (f instanceof a89) {
                    if (e89Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new u79(e89Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = e89Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (za7) invokeCommon.objValue;
    }

    public final List<za7<?>> b(n99 repo, List<? extends z79> list, SpriteMsgProcessor.e loadType) {
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
                z79 z79Var = (z79) obj;
                if (z79Var instanceof e89) {
                    j89 j89Var = a;
                    e89<?> e89Var = (e89) z79Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    za7<?> a2 = j89Var.a(repo, e89Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + z79Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
