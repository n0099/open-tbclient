package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.sxa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final swa b;
    @NonNull
    public final EditorTools c;
    @NonNull
    public final lva d;
    @NonNull
    public final dya e;
    @NonNull
    public final hya f;
    @NonNull
    public final WriteData g;

    public rxa(@NonNull TbPageContext<?> tbPageContext, @NonNull swa swaVar, @NonNull EditorTools editorTools, @NonNull lva lvaVar, @NonNull dya dyaVar, @NonNull hya hyaVar, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, swaVar, editorTools, lvaVar, dyaVar, hyaVar, writeData};
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
        this.b = swaVar;
        this.c = editorTools;
        this.d = lvaVar;
        this.e = dyaVar;
        this.f = hyaVar;
        this.g = writeData;
    }

    public List<wwa<?>> a(List<sxa.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (sxa.a aVar : list) {
                wwa<?> b = b(aVar);
                if (b != null) {
                    b.h(aVar.b, this.g);
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public wwa<?> b(sxa.a aVar) {
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
                    return zxa.a(this.a);
                case 1:
                    return zxa.b(this.a);
                case 2:
                    return zxa.c(this.a, this.b, this.c, this.d, this.e);
                case 3:
                    return zxa.e(this.a);
                case 4:
                    return zxa.f(this.a);
                case 5:
                    return zxa.g(this.a);
                case 6:
                    return zxa.h(this.a, this.f);
                case 7:
                    return zxa.i(this.a);
                case '\b':
                    return zxa.j(this.a);
                case '\t':
                    return zxa.k(this.a);
                case '\n':
                    return zxa.l(this.a);
                case 11:
                    return zxa.m(this.a, this.b, this.c, this.f, this.d, this.e);
                case '\f':
                    return zxa.n(this.a, this.b, this.d, this.e);
                case '\r':
                    return zxa.o(this.a);
                case 14:
                    return zxa.p(this.a);
                case 15:
                    return zxa.q(this.a);
                default:
                    return null;
            }
        }
        return (wwa) invokeL.objValue;
    }
}
