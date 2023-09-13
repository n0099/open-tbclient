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
public final class jz8 {
    public static /* synthetic */ Interceptable $ic;
    public static final jz8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900705, "Lcom/baidu/tieba/jz8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900705, "Lcom/baidu/tieba/jz8;");
                return;
            }
        }
        a = new jz8();
    }

    public jz8() {
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

    public final pc7<?> a(n09 n09Var, ez8<?> ez8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{n09Var, ez8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = ez8Var.f();
            Class<?> cls = null;
            if (f instanceof fz8) {
                if (ez8Var.e().d()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                wy8 wy8Var = new wy8(ez8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.getType() == 3 && z && !ez8Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                wy8Var.k(z2);
                wy8Var.h(MsgEvents.a.b(n09Var));
                return wy8Var;
            } else if (f instanceof bz8) {
                return new vy8(ez8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (ez8Var.e().d()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    xy8 xy8Var = new xy8(ez8Var, str2);
                    xy8Var.g(MsgEvents.a.a());
                    return xy8Var;
                } else if (f instanceof az8) {
                    if (ez8Var.e().d()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new uy8(ez8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = ez8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (pc7) invokeCommon.objValue;
    }

    public final List<pc7<?>> b(n09 repo, List<? extends zy8> list, SpriteMsgProcessor.e loadType) {
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
                zy8 zy8Var = (zy8) obj;
                if (zy8Var instanceof ez8) {
                    jz8 jz8Var = a;
                    ez8<?> ez8Var = (ez8) zy8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    pc7<?> a2 = jz8Var.a(repo, ez8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + zy8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
