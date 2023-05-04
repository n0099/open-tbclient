package com.baidu.tieba.sprite.edgefloat;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.qk9;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001aR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "", "activity", "Landroid/app/Activity;", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "startX", "startY", "canDrag", "", "pageSupportList", "", "", "(Landroid/app/Activity;IIIZLjava/util/List;)V", "edgeFloat", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "getEdgeFloat", "()Lcom/baidu/tieba/edgefloat/EdgeFloat;", "edgeFloat$delegate", "Lkotlin/Lazy;", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "getSpriteTipView", "()Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "spriteTipView$delegate", "gotoChatPage", "", "isShowing", "release", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SpriteTipEdgeFloat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    public SpriteTipEdgeFloat(final Activity activity, final int i, final int i2, final int i3, final boolean z, final List<String> pageSupportList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList};
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
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<HomePageSpriteBottomTipView>(activity, this) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat$spriteTipView$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteTipEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {activity, this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HomePageSpriteBottomTipView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    HomePageSpriteBottomTipView homePageSpriteBottomTipView = new HomePageSpriteBottomTipView(this.$activity, null, 2, null);
                    final SpriteTipEdgeFloat spriteTipEdgeFloat = this.this$0;
                    homePageSpriteBottomTipView.setOnVisibilityChangedListener(new Function1<Boolean, Unit>(spriteTipEdgeFloat) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat$spriteTipView$2$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpriteTipEdgeFloat this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {spriteTipEdgeFloat};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    super(((Integer) newInitContext2.callArgs[0]).intValue());
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = spriteTipEdgeFloat;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            EdgeFloat b;
                            EdgeFloat b2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
                                if (z2) {
                                    b2 = this.this$0.b();
                                    b2.C();
                                    return;
                                }
                                b = this.this$0.b();
                                b.k();
                            }
                        }
                    });
                    return homePageSpriteBottomTipView;
                }
                return (HomePageSpriteBottomTipView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<EdgeFloat>(activity, this, i, i2, i3, z, pageSupportList) { // from class: com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat$edgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public final /* synthetic */ boolean $canDrag;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int $gravity;
            public final /* synthetic */ List<String> $pageSupportList;
            public final /* synthetic */ int $startX;
            public final /* synthetic */ int $startY;
            public final /* synthetic */ SpriteTipEdgeFloat this$0;

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
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    qk9 qk9Var = new qk9(this.$activity);
                    qk9Var.I(this.this$0.c());
                    qk9Var.w(this.$gravity);
                    qk9Var.E(this.$startX);
                    qk9Var.F(this.$startY);
                    qk9Var.d(this.$canDrag);
                    qk9Var.B(this.$pageSupportList);
                    return qk9Var.c();
                }
                return (EdgeFloat) invokeV.objValue;
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

    public final HomePageSpriteBottomTipView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (HomePageSpriteBottomTipView) this.a.getValue();
        }
        return (HomePageSpriteBottomTipView) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c().e();
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b().o();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EdgeFloatLifecycle.b.a().l(b());
        }
    }
}
