package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.v5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class u5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final v4b b;
    @NonNull
    public final EditorTools c;
    @NonNull
    public final o3b d;
    @NonNull
    public final g6b e;
    @NonNull
    public final k6b f;
    @NonNull
    public final WriteData g;

    public u5b(@NonNull TbPageContext<?> tbPageContext, @NonNull v4b v4bVar, @NonNull EditorTools editorTools, @NonNull o3b o3bVar, @NonNull g6b g6bVar, @NonNull k6b k6bVar, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, v4bVar, editorTools, o3bVar, g6bVar, k6bVar, writeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = v4bVar;
        this.c = editorTools;
        this.d = o3bVar;
        this.e = g6bVar;
        this.f = k6bVar;
        this.g = writeData;
    }

    public List<z4b<?>> a(List<v5b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (v5b.a aVar : list) {
                z4b<?> b = b(aVar);
                if (b != null) {
                    b.h(aVar.b, this.g);
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public z4b<?> b(v5b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            String str = aVar.a;
            char c = 65535;
            int hashCode = str.hashCode();
            switch (hashCode) {
                case 3118:
                    if (str.equals("c1")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3119:
                    if (str.equals("c2")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3120:
                    if (str.equals("c3")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3121:
                    if (str.equals("c4")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3122:
                    if (str.equals("c5")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 3123:
                    if (str.equals("c6")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3124:
                    if (str.equals("c7")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3125:
                    if (str.equals("c8")) {
                        c = 11;
                        break;
                    }
                    break;
                case 3126:
                    if (str.equals("c9")) {
                        c = 14;
                        break;
                    }
                    break;
                default:
                    switch (hashCode) {
                        case 96706:
                            if (str.equals("c10")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 96707:
                            if (str.equals("c11")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 96708:
                            if (str.equals("c12")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 96709:
                            if (str.equals("c13")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 96710:
                            if (str.equals("c14")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 96711:
                            if (str.equals("c15")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 96712:
                            if (str.equals("c16")) {
                                c = '\b';
                                break;
                            }
                            break;
                    }
            }
            switch (c) {
                case 0:
                    return c6b.a(this.a);
                case 1:
                    return c6b.b(this.a);
                case 2:
                    return c6b.c(this.a, this.b, this.c, this.d, this.e);
                case 3:
                    return c6b.e(this.a);
                case 4:
                    return c6b.f(this.a);
                case 5:
                    return c6b.g(this.a);
                case 6:
                    return c6b.h(this.a, this.f);
                case 7:
                    return c6b.i(this.a);
                case '\b':
                    return c6b.j(this.a);
                case '\t':
                    return c6b.k(this.a);
                case '\n':
                    return c6b.l(this.a);
                case 11:
                    return c6b.m(this.a, this.b, this.c, this.f, this.d, this.e);
                case '\f':
                    return c6b.n(this.a, this.b, this.d, this.e);
                case '\r':
                    return c6b.o(this.a);
                case 14:
                    return c6b.p(this.a);
                case 15:
                    return c6b.q(this.a);
                default:
                    return null;
            }
        }
        return (z4b) invokeL.objValue;
    }
}
