package com.baidu.tieba.immessagecenter.arch.ext;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.gi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ViewExtKt$onVisibilityChange$checkVisibility$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ int $KEY_VISIBILITY;
    public final /* synthetic */ Function2<View, Boolean, Unit> $block;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ View $this_onVisibilityChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewExtKt$onVisibilityChange$checkVisibility$1(View view2, int i, Function2<? super View, ? super Boolean, Unit> function2) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), function2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$this_onVisibilityChange = view2;
        this.$KEY_VISIBILITY = i;
        this.$block = function2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object tag = this.$this_onVisibilityChange.getTag(this.$KEY_VISIBILITY);
            if (tag instanceof Boolean) {
                bool = (Boolean) tag;
            } else {
                bool = null;
            }
            boolean a = gi8.a(this.$this_onVisibilityChange);
            if (bool == null) {
                if (a) {
                    this.$block.invoke(this.$this_onVisibilityChange, Boolean.TRUE);
                    this.$this_onVisibilityChange.setTag(this.$KEY_VISIBILITY, Boolean.TRUE);
                }
            } else if (!Intrinsics.areEqual(bool, Boolean.valueOf(a))) {
                this.$block.invoke(this.$this_onVisibilityChange, Boolean.valueOf(a));
                this.$this_onVisibilityChange.setTag(this.$KEY_VISIBILITY, Boolean.valueOf(a));
            }
        }
    }
}
