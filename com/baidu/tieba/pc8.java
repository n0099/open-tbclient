package com.baidu.tieba;

import android.animation.TypeEvaluator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pc8 implements TypeEvaluator<rc8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rc8 a;

    public pc8(rc8 rc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rc8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rc8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public rc8 evaluate(float f, rc8 rc8Var, rc8 rc8Var2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), rc8Var, rc8Var2})) == null) {
            float f2 = 1.0f - f;
            float f3 = f2 * f2;
            float f4 = 2.0f * f * f2;
            rc8 rc8Var3 = this.a;
            float f5 = f * f;
            return new rc8((int) ((rc8Var.a * f3) + (rc8Var3.a * f4) + (rc8Var2.a * f5)), (int) ((f3 * rc8Var.b) + (f4 * rc8Var3.b) + (f5 * rc8Var2.b)));
        }
        return (rc8) invokeCommon.objValue;
    }
}
