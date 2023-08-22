package com.baidu.tieba.statemachine.animationtip;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.TbAnimationTipView;
import com.baidu.tieba.jda;
import com.baidu.tieba.jn5;
import com.baidu.tieba.kda;
import com.baidu.tieba.lt6;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.tieba.uda;
import com.baidu.tieba.yda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0001LB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00106\u001a\u00020\tH\u0002J\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020\tJ\u000e\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;J\u0016\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>J,\u0010@\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010A\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010CJ&\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020>J\u000e\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020>J\u0006\u0010K\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006M"}, d2 = {"Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "animationFlowEndListener", "Lkotlin/Function0;", "", "getAnimationFlowEndListener", "()Lkotlin/jvm/functions/Function0;", "setAnimationFlowEndListener", "(Lkotlin/jvm/functions/Function0;)V", "animationTipStateMachine", "Lcom/baidu/tieba/statemachine/animationtip/AnimationTipStateMachine;", "getAnimationTipStateMachine", "()Lcom/baidu/tieba/statemachine/animationtip/AnimationTipStateMachine;", "animationTipStateMachine$delegate", "Lkotlin/Lazy;", "animationTipStateMap", "Lcom/baidu/tieba/statemachine/animationtip/AnimationTipStateMap;", "animationTipView", "Lcom/baidu/tieba/core/widget/TbAnimationTipView;", "appearStateData", "Lcom/baidu/tieba/core/image/dynamic/DynamicAnimData;", "bubbleStateData", "customAnimationTipViewLp", "Landroid/widget/FrameLayout$LayoutParams;", "getCustomAnimationTipViewLp", "()Landroid/widget/FrameLayout$LayoutParams;", "setCustomAnimationTipViewLp", "(Landroid/widget/FrameLayout$LayoutParams;)V", "exitRunnable", "Ljava/lang/Runnable;", "exitStateData", "tipView", "Landroid/view/View;", "getTipView", "()Landroid/view/View;", "setTipView", "(Landroid/view/View;)V", "tipViewShowDuration", "", "getTipViewShowDuration", "()J", "setTipViewShowDuration", "(J)V", "useFadeAlpha", "", "getUseFadeAlpha", "()Z", "setUseFadeAlpha", "(Z)V", "attachToActivity", "execExit", "hide", "onChangeSkin", "resFilePath", "", "setAnimationTipViewSize", "width", "", "height", "setData", "setDynamicViewCLickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setDynamicViewMargin", "left", "top", "right", "bottom", "setTipGravity", NotificationCompat.WearableExtender.KEY_GRAVITY, "show", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SpriteAnimationTipManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final TbAnimationTipView b;
    public final kda c;
    public final Lazy d;
    public lt6 e;
    public lt6 f;
    public lt6 g;
    public View h;
    public FrameLayout.LayoutParams i;
    public long j;
    public Function0<Unit> k;
    public boolean l;
    public final Runnable m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1724330775, "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1724330775, "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"com/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager$3", "Lcom/baidu/tieba/statemachine/base/Action;", "isSpriteAnimExecDone", "", "()Z", "setSpriteAnimExecDone", "(Z)V", "isTipAnimExecDone", "setTipAnimExecDone", "doAction", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass3 implements uda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ SpriteAnimationTipManager c;

        public AnonymousClass3(SpriteAnimationTipManager spriteAnimationTipManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteAnimationTipManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = spriteAnimationTipManager;
        }

        public final void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a = z;
            }
        }

        public final void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.b = z;
            }
        }

        @Override // com.baidu.tieba.uda
        public void a() {
            lt6 lt6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lt6Var = this.c.g) != null) {
                final SpriteAnimationTipManager spriteAnimationTipManager = this.c;
                spriteAnimationTipManager.b.setAnimationListener(new Function0<Unit>(this, spriteAnimationTipManager) { // from class: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager$3$doAction$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpriteAnimationTipManager.AnonymousClass3 this$0;
                    public final /* synthetic */ SpriteAnimationTipManager this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, spriteAnimationTipManager};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.this$1 = spriteAnimationTipManager;
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
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.this$0.d(true);
                            if (this.this$0.b() && this.this$0.c()) {
                                DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：精灵动画执行完成，精灵动画提示控件整体动画完成");
                                this.this$1.p();
                                Function0<Unit> k = this.this$1.k();
                                if (k != null) {
                                    k.invoke();
                                    return;
                                }
                                return;
                            }
                            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：精灵动画执行完成，气泡动画未完成");
                            this.this$1.b.setDynamicViewVisibility(4);
                        }
                    }
                });
                spriteAnimationTipManager.b.setLastAnimationCurFrameToPlaceHolder();
                spriteAnimationTipManager.b.f(lt6Var);
                if (spriteAnimationTipManager.o()) {
                    spriteAnimationTipManager.b.a(500L, 1.0f, 0.0f, new Function0<Unit>(this, spriteAnimationTipManager) { // from class: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager$3$doAction$1$2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpriteAnimationTipManager.AnonymousClass3 this$0;
                        public final /* synthetic */ SpriteAnimationTipManager this$1;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, spriteAnimationTipManager};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.this$1 = spriteAnimationTipManager;
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
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.this$0.e(true);
                                if (this.this$0.b() && this.this$0.c()) {
                                    DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：气泡动画执行完成，精灵动画提示控件整体动画完成");
                                    this.this$1.p();
                                    Function0<Unit> k = this.this$1.k();
                                    if (k != null) {
                                        k.invoke();
                                        return;
                                    }
                                    return;
                                }
                                DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：气泡动画执行完成，精灵动画未完成");
                                this.this$1.b.setTipViewVisibility(8);
                            }
                        }
                    });
                    return;
                }
                DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：气泡控件无动画，直接隐藏");
                this.b = true;
                spriteAnimationTipManager.b.setTipViewVisibility(8);
            }
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements uda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteAnimationTipManager a;

        public a(SpriteAnimationTipManager spriteAnimationTipManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteAnimationTipManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteAnimationTipManager;
        }

        @Override // com.baidu.tieba.uda
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lt6 lt6Var = this.a.f;
                Unit unit = null;
                if (lt6Var != null) {
                    SpriteAnimationTipManager spriteAnimationTipManager = this.a;
                    spriteAnimationTipManager.b.f(lt6Var);
                    View m = spriteAnimationTipManager.m();
                    if (m != null) {
                        spriteAnimationTipManager.b.g(m);
                        if (spriteAnimationTipManager.o()) {
                            spriteAnimationTipManager.b.a(300L, 0.0f, 1.0f, null);
                        }
                        if (spriteAnimationTipManager.n() != -1) {
                            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：气泡非常驻");
                            SafeHandler.getInst().postDelayed(spriteAnimationTipManager.m, spriteAnimationTipManager.n());
                        }
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        spriteAnimationTipManager.l().f(spriteAnimationTipManager.c.f());
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    SpriteAnimationTipManager spriteAnimationTipManager2 = this.a;
                    spriteAnimationTipManager2.l().f(spriteAnimationTipManager2.c.f());
                }
            }
        }
    }

    public SpriteAnimationTipManager(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = new TbAnimationTipView(this.a, null, 0, 6, null);
        this.c = new kda();
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<jda>(this) { // from class: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager$animationTipStateMachine$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteAnimationTipManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
            public final jda invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new jda(this.this$0.c);
                }
                return (jda) invokeV.objValue;
            }
        });
        this.j = -1L;
        this.l = true;
        this.m = new Runnable() { // from class: com.baidu.tieba.ida
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    SpriteAnimationTipManager.j(SpriteAnimationTipManager.this);
                }
            }
        };
        this.c.c().a(new uda(this) { // from class: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteAnimationTipManager a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.uda
            public void a() {
                Unit unit;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    lt6 lt6Var = this.a.e;
                    if (lt6Var != null) {
                        final SpriteAnimationTipManager spriteAnimationTipManager = this.a;
                        spriteAnimationTipManager.b.setAnimationListener(new Function0<Unit>(spriteAnimationTipManager) { // from class: com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager$1$doAction$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SpriteAnimationTipManager this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {spriteAnimationTipManager};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$0 = spriteAnimationTipManager;
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
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.this$0.l().f(this.this$0.c.d());
                                }
                            }
                        });
                        spriteAnimationTipManager.b.f(lt6Var);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        SpriteAnimationTipManager spriteAnimationTipManager2 = this.a;
                        spriteAnimationTipManager2.l().f(spriteAnimationTipManager2.c.d());
                    }
                }
            }
        });
        this.c.e().a(new a(this));
        this.c.g().a(new AnonymousClass3(this));
    }

    public final void q(String resFilePath) {
        boolean z;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, resFilePath) == null) {
            Intrinsics.checkNotNullParameter(resFilePath, "resFilePath");
            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：精灵动画切换皮肤模式");
            boolean z2 = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                z = true;
            } else {
                z = false;
            }
            yda c = l().c();
            String str4 = "";
            if (Intrinsics.areEqual(c, this.c.c())) {
                if (z) {
                    str3 = "funny_sprite_appear_day";
                } else {
                    str3 = "funny_sprite_appear_dark";
                }
                str4 = FunnySpriteResDownloadUtil.i(str3, resFilePath, true);
            } else if (Intrinsics.areEqual(c, this.c.e())) {
                if (z) {
                    str2 = "funny_sprite_show_day";
                } else {
                    str2 = "funny_sprite_show_dark";
                }
                str4 = FunnySpriteResDownloadUtil.i(str2, resFilePath, true);
                z2 = true;
            } else if (Intrinsics.areEqual(c, this.c.g())) {
                if (z) {
                    str = "funny_sprite_exit_day";
                } else {
                    str = "funny_sprite_exit_dark";
                }
                FunnySpriteResDownloadUtil.i(str, resFilePath, true);
            }
            this.b.f(jn5.a(str4, z2, 2));
        }
    }

    public static final void j(SpriteAnimationTipManager this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：精灵自动执行退场");
            this$0.l().f(this$0.c.f());
        }
    }

    public final void r(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, function0) == null) {
            this.k = function0;
        }
    }

    public final void t(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            this.i = layoutParams;
        }
    }

    public final void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.b.setDynamicViewCLickListener(onClickListener);
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b.setGravity(i);
        }
    }

    public final void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            this.h = view2;
        }
    }

    public final void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.j = j;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：开始展示");
            h();
            l().g();
            l().f(this.c.b());
        }
    }

    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：手动退场");
            SafeHandler.getInst().removeCallbacks(this.m);
            l().f(this.c.f());
        }
    }

    public final Function0<Unit> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (Function0) invokeV.objValue;
    }

    public final jda l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (jda) this.d.getValue();
        }
        return (jda) invokeV.objValue;
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            DefaultLog.getInstance().e("SpriteAnimationTipManager", "精灵动画提示控件：整体隐藏");
            SafeHandler.getInst().removeCallbacks(this.m);
            this.b.setVisibility(8);
            l().d();
        }
    }

    public final void h() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View findViewById = this.a.findViewById(16908290);
            Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(android.R.id.content)");
            FrameLayout frameLayout = (FrameLayout) findViewById;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X014);
            FrameLayout.LayoutParams layoutParams2 = this.i;
            if (layoutParams2 != null) {
                layoutParams = layoutParams2;
            }
            ViewParent parent = this.b.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.b);
            }
            frameLayout.addView(this.b, layoutParams);
        }
    }

    public final void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.b.setDynamicViewSize(i, i2);
        }
    }

    @JvmOverloads
    public final void u(lt6 lt6Var, lt6 lt6Var2, lt6 lt6Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, lt6Var, lt6Var2, lt6Var3) == null) {
            this.e = lt6Var;
            this.f = lt6Var2;
            this.g = lt6Var3;
        }
    }

    public final void w(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i, i2, i3, i4) == null) {
            this.b.setDynamicViewMargin(i, i2, i3, i4);
        }
    }
}
