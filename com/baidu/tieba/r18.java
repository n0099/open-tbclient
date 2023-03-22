package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e08;
import com.baidu.tieba.impersonal.components.PersonalMsgContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public abstract class r18<T, V extends View, M extends e08<T>> implements ps6<PersonalMsgContainer<T, V>, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    public abstract void d(V v, M m);

    public abstract V f(ViewGroup viewGroup);

    public r18(String name) {
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
    @Override // com.baidu.tieba.ps6
    /* renamed from: e */
    public void b(PersonalMsgContainer<T, V> view2, M data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, data) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            view2.h(data);
            d(view2.getChild(), data);
        }
    }

    @Override // com.baidu.tieba.ps6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ps6
    /* renamed from: g */
    public PersonalMsgContainer<T, V> a(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (StringsKt__StringsJVMKt.endsWith$default(c(), "_left", false, 2, null)) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                PersonalMsgContainer<T, V> personalMsgContainer = new PersonalMsgContainer<>(true, context, null, 4, null);
                personalMsgContainer.d(f(parent));
                return personalMsgContainer;
            } else if (StringsKt__StringsJVMKt.endsWith$default(c(), "_right", false, 2, null)) {
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                PersonalMsgContainer<T, V> personalMsgContainer2 = new PersonalMsgContainer<>(false, context2, null, 4, null);
                personalMsgContainer2.d(f(parent));
                return personalMsgContainer2;
            } else {
                throw new IllegalArgumentException("unknown template: " + c());
            }
        }
        return (PersonalMsgContainer) invokeL.objValue;
    }
}
