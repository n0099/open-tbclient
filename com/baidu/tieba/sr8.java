package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.impersonal.components.PersonalMsgContainer;
import com.baidu.tieba.qp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public abstract class sr8<T, V extends View, M extends qp8<T>> implements s87<PersonalMsgContainer<T, V>, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    public abstract void d(V v, M m);

    public void f(ViewGroup container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
        }
    }

    public abstract V g(ViewGroup viewGroup);

    public sr8(String name) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = name;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s87
    /* renamed from: e */
    public void b(PersonalMsgContainer<T, V> view2, M data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, data) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            view2.h(data);
            d(view2.getChild(), data);
            f(view2.getChildContainer());
        }
    }

    @Override // com.baidu.tieba.s87
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return StringsKt__StringsJVMKt.endsWith$default(c(), "_left", false, 2, null);
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return StringsKt__StringsJVMKt.endsWith$default(c(), "_right", false, 2, null);
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s87
    /* renamed from: h */
    public PersonalMsgContainer<T, V> a(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i()) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                PersonalMsgContainer<T, V> personalMsgContainer = new PersonalMsgContainer<>(true, context, null, 4, null);
                personalMsgContainer.e(g(parent));
                return personalMsgContainer;
            } else if (j()) {
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                PersonalMsgContainer<T, V> personalMsgContainer2 = new PersonalMsgContainer<>(false, context2, null, 4, null);
                personalMsgContainer2.e(g(parent));
                return personalMsgContainer2;
            } else {
                throw new IllegalArgumentException("unknown template: " + c());
            }
        }
        return (PersonalMsgContainer) invokeL.objValue;
    }
}
