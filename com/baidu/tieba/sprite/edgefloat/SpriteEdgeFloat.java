package com.baidu.tieba.sprite.edgefloat;

import android.app.Activity;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.g6a;
import com.baidu.tieba.m6a;
import com.baidu.tieba.n6a;
import com.baidu.tieba.o9a;
import com.baidu.tieba.p7a;
import com.baidu.tieba.q9a;
import com.baidu.tieba.sprite.view.NormalSpriteView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020$J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020$2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010.J\u0006\u0010/\u001a\u00020$J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020$R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "", "activity", "Landroid/app/Activity;", "spriteStateMap", "Lcom/baidu/tieba/sprite/funnysprite/StateMap;", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "startX", "startY", "canDrag", "", "pageSupportList", "", "", "(Landroid/app/Activity;Lcom/baidu/tieba/sprite/funnysprite/StateMap;IIIZLjava/util/List;)V", "edgeFloat", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "getEdgeFloat", "()Lcom/baidu/tieba/edgefloat/EdgeFloat;", "edgeFloat$delegate", "Lkotlin/Lazy;", "normalSpriteView", "Lcom/baidu/tieba/sprite/view/NormalSpriteView;", "getNormalSpriteView", "()Lcom/baidu/tieba/sprite/view/NormalSpriteView;", "normalSpriteView$delegate", "spriteStateMachine", "Lcom/baidu/tieba/sprite/funnysprite/StateMachine;", "getSpriteStateMachine", "()Lcom/baidu/tieba/sprite/funnysprite/StateMachine;", "spriteStateMachine$delegate", "currentState", "Lcom/baidu/tieba/statemachine/base/State;", "getMachine", "hide", "", "isShowing", "release", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "setOnSpriteAnimClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setOnSpriteAnimEndListener", "Lkotlin/Function0;", "show", "updateData", "data", "Lcom/baidu/tieba/sprite/view/NormalSpriteData;", "webpStopAndDelay", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SpriteEdgeFloat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n6a a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public SpriteEdgeFloat(final Activity activity, n6a spriteStateMap, final int i, final int i2, final int i3, final boolean z, final List<String> pageSupportList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, spriteStateMap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(spriteStateMap, "spriteStateMap");
        Intrinsics.checkNotNullParameter(pageSupportList, "pageSupportList");
        this.a = spriteStateMap;
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<m6a>(this) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat$spriteStateMachine$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final m6a invoke() {
                InterceptResult invokeV;
                n6a n6aVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (m6a) invokeV.objValue;
                }
                n6aVar = this.this$0.a;
                return new m6a(n6aVar);
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<NormalSpriteView>(activity) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat$normalSpriteView$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {activity};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$activity = activity;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NormalSpriteView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new NormalSpriteView(this.$activity, null, 2, null);
                }
                return (NormalSpriteView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<EdgeFloat>(activity, this, i, i2, i3, z, pageSupportList) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat$edgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public final /* synthetic */ boolean $canDrag;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int $gravity;
            public final /* synthetic */ List<String> $pageSupportList;
            public final /* synthetic */ int $startX;
            public final /* synthetic */ int $startY;
            public final /* synthetic */ SpriteEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {activity, this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$activity = activity;
                this.this$0 = this;
                this.$gravity = i;
                this.$startX = i2;
                this.$startY = i3;
                this.$canDrag = z;
                this.$pageSupportList = pageSupportList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EdgeFloat invoke() {
                InterceptResult invokeV;
                NormalSpriteView f;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    g6a g6aVar = new g6a(this.$activity);
                    f = this.this$0.f();
                    g6aVar.M(f);
                    g6aVar.y(this.$gravity);
                    g6aVar.I(this.$startX);
                    g6aVar.J(this.$startY);
                    g6aVar.d(this.$canDrag);
                    g6aVar.D(this.$pageSupportList);
                    return g6aVar.c();
                }
                return (EdgeFloat) invokeV.objValue;
            }
        });
    }

    public final void k(o9a event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            g().f(event);
        }
    }

    public final void l(View.OnClickListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            f().setOnSpriteAnimClickListener(listener);
        }
    }

    public final void m(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, function0) == null) {
            f().setOnDynamicAnimEndListener(function0);
        }
    }

    public final void o(p7a data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            f().a(data);
        }
    }

    public final q9a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return g().c();
        }
        return (q9a) invokeV.objValue;
    }

    public final EdgeFloat d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (EdgeFloat) this.d.getValue();
        }
        return (EdgeFloat) invokeV.objValue;
    }

    public final m6a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return g();
        }
        return (m6a) invokeV.objValue;
    }

    public final NormalSpriteView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (NormalSpriteView) this.c.getValue();
        }
        return (NormalSpriteView) invokeV.objValue;
    }

    public final m6a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (m6a) this.b.getValue();
        }
        return (m6a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d().k();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return d().o();
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EdgeFloatLifecycle.Companion.a().unRegister(d());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d().D();
            if (Intrinsics.areEqual(c(), this.a.a())) {
                g().g();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            f().b();
        }
    }
}
