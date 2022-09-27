package com.baidu.tieba;

import android.animation.TypeEvaluator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j87 implements TypeEvaluator<l87> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l87 a;

    public j87(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l87Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l87Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public l87 evaluate(float f, l87 l87Var, l87 l87Var2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), l87Var, l87Var2})) == null) {
            float f2 = 1.0f - f;
            float f3 = f2 * f2;
            float f4 = 2.0f * f * f2;
            l87 l87Var3 = this.a;
            float f5 = f * f;
            return new l87((int) ((l87Var.a * f3) + (l87Var3.a * f4) + (l87Var2.a * f5)), (int) ((f3 * l87Var.b) + (f4 * l87Var3.b) + (f5 * l87Var2.b)));
        }
        return (l87) invokeCommon.objValue;
    }
}
