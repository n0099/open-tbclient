package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.IdRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s81<VIEW extends View> extends r81<VIEW> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewStub a;
    public VIEW b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s81(View root, @IdRes int i, @IdRes int i2) {
        super(root, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {root, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(root, "root");
        View findViewById = root.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(stubId)");
        this.a = (ViewStub) findViewById;
    }

    public static final /* synthetic */ View a(s81 s81Var) {
        VIEW view2 = s81Var.b;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("theRealView");
        }
        return view2;
    }

    public VIEW c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VIEW view2 = this.b;
            if (view2 != null) {
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("theRealView");
                }
            } else {
                view2 = (VIEW) this.a.inflate();
                if (view2 != null) {
                    this.b = view2;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("theRealView");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type VIEW");
                }
            }
            return view2;
        }
        return (VIEW) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
