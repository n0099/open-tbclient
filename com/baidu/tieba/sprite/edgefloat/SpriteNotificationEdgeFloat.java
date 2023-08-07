package com.baidu.tieba.sprite.edgefloat;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.g6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/sprite/edgefloat/SpriteNotificationEdgeFloat;", "", "activity", "Landroid/app/Activity;", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "startX", "startY", "canDrag", "", "pageSupportList", "", "", "view", "Landroid/view/View;", "(Landroid/app/Activity;IIIZLjava/util/List;Landroid/view/View;)V", "edgeFloat", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "getEdgeFloat", "()Lcom/baidu/tieba/edgefloat/EdgeFloat;", "edgeFloat$delegate", "Lkotlin/Lazy;", "tipContainer", "Landroid/widget/FrameLayout;", "getTipContainer", "()Landroid/widget/FrameLayout;", "tipContainer$delegate", "hide", "", "release", "show", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SpriteNotificationEdgeFloat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    public SpriteNotificationEdgeFloat(final Activity activity, final int i, final int i2, final int i3, final boolean z, final List<String> pageSupportList, final View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList, view2};
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
        Intrinsics.checkNotNullParameter(pageSupportList, "pageSupportList");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(activity) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteNotificationEdgeFloat$tipContainer$2
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
            public final FrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    FrameLayout frameLayout = new FrameLayout(this.$activity);
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    return frameLayout;
                }
                return (FrameLayout) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<EdgeFloat>(this, view2, activity, i, i2, i3, z, pageSupportList) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteNotificationEdgeFloat$edgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public final /* synthetic */ boolean $canDrag;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int $gravity;
            public final /* synthetic */ List<String> $pageSupportList;
            public final /* synthetic */ int $startX;
            public final /* synthetic */ int $startY;
            public final /* synthetic */ View $view;
            public final /* synthetic */ SpriteNotificationEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, view2, activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList};
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
                this.$view = view2;
                this.$activity = activity;
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
                FrameLayout c;
                FrameLayout c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EdgeFloat) invokeV.objValue;
                }
                c = this.this$0.c();
                c.addView(this.$view);
                g6a g6aVar = new g6a(this.$activity);
                c2 = this.this$0.c();
                g6aVar.M(c2);
                g6aVar.y(this.$gravity);
                g6aVar.I(this.$startX);
                g6aVar.J(this.$startY);
                g6aVar.d(this.$canDrag);
                g6aVar.D(this.$pageSupportList);
                return g6aVar.c();
            }
        });
    }

    public final EdgeFloat b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (EdgeFloat) this.b.getValue();
        }
        return (EdgeFloat) invokeV.objValue;
    }

    public final FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (FrameLayout) this.a.getValue();
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b().k();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EdgeFloatLifecycle.Companion.a().unRegister(b());
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b().D();
        }
    }
}
