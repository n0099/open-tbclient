package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes7.dex */
public class m1 extends i1<e7, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e7 b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, aVar)) == null) {
            return null;
        }
        return (u6) invokeLLL.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a extends e1<e7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Locale b;
        public final String c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((Locale) objArr[0], (String) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(Locale locale, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locale, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = locale;
            this.c = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(l1 l1Var) {
        super(l1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public e7 d(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, aVar)) == null) {
            e7 e7Var = this.b;
            this.b = null;
            return e7Var;
        }
        return (e7) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, a aVar) {
        Locale locale;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, aVar) == null) {
            String str2 = null;
            this.b = null;
            if (aVar == null) {
                locale = Locale.getDefault();
            } else {
                Locale locale2 = aVar.b;
                if (locale2 == null) {
                    locale2 = Locale.getDefault();
                }
                locale = locale2;
                str2 = aVar.c;
            }
            if (str2 == null) {
                this.b = e7.b(d3Var, locale);
            } else {
                this.b = e7.c(d3Var, locale, str2);
            }
        }
    }
}
