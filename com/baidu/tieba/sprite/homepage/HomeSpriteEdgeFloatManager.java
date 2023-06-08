package com.baidu.tieba.sprite.homepage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.aw9;
import com.baidu.tieba.bu9;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.cr8;
import com.baidu.tieba.es6;
import com.baidu.tieba.fn5;
import com.baidu.tieba.fw9;
import com.baidu.tieba.g9;
import com.baidu.tieba.hw5;
import com.baidu.tieba.hw9;
import com.baidu.tieba.iu9;
import com.baidu.tieba.iw9;
import com.baidu.tieba.k;
import com.baidu.tieba.mt9;
import com.baidu.tieba.or6;
import com.baidu.tieba.qf5;
import com.baidu.tieba.s77;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteNotificationEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.vi;
import com.baidu.tieba.w3a;
import com.baidu.tieba.wg;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0013H\u0002J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u00102\u001a\u00020.J\u0006\u00103\u001a\u00020.J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020.H\u0002J\u0006\u0010>\u001a\u00020.J\u000e\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020.R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "normalMainTabBarHeight", "", "getNormalMainTabBarHeight", "()I", "normalMainTabBarHeight$delegate", "Lkotlin/Lazy;", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "spriteEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "getSpriteEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "spriteJumpScheme", "", "getSpriteJumpScheme", "()Ljava/lang/String;", "setSpriteJumpScheme", "(Ljava/lang/String;)V", "spriteNotificationEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteNotificationEdgeFloat;", "spriteStateMap", "Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "getSpriteStateMap", "()Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "spriteStateMap$delegate", "spriteTipController", "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "getSpriteTipController", "()Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "spriteTipEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "getSpriteTipEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "tipDissmisListener", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "generateDataByState", "Lcom/baidu/tieba/sprite/view/NormalSpriteData;", "dayResName", "darkResName", "gotoScheme", "", "context", "Landroid/content/Context;", "scheme", "hide", "hideNotification", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "sendStandEvent", "show", "showNotification", "hotEventShowData", "Lcom/baidu/tieba/statemachine/animationtip/message/HotEventShowData;", "spriteDialogHide", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HomeSpriteEdgeFloatManager implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public static final Lazy<HomeSpriteEdgeFloatManager> k;
    public static final Lazy<List<String>> l;
    public static final cr8 m;
    public static boolean n;
    public static final Lazy<Double> o;
    public static final double p;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final Lazy b;
    public final Lazy c;
    public or6.e d;
    public final Lazy e;
    public HomePageSpriteTipController f;
    public SpriteTipEdgeFloat g;
    public SpriteEdgeFloat h;
    public SpriteNotificationEdgeFloat i;

    public /* synthetic */ HomeSpriteEdgeFloatManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        k.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        k.$default$onStop(this, lifecycleOwner);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final HomeSpriteEdgeFloatManager c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (HomeSpriteEdgeFloatManager) HomeSpriteEdgeFloatManager.k.getValue();
            }
            return (HomeSpriteEdgeFloatManager) invokeV.objValue;
        }

        public final double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ((Number) HomeSpriteEdgeFloatManager.o.getValue()).doubleValue();
            }
            return invokeV.doubleValue;
        }

        public final List<String> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return (List) HomeSpriteEdgeFloatManager.l.getValue();
            }
            return (List) invokeV.objValue;
        }

        @JvmStatic
        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048580, this, z) != null) {
                return;
            }
            HomeSpriteEdgeFloatManager.n = z;
        }

        @JvmStatic
        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean z = false;
                if (w3a.g.a().e()) {
                    DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat blocked by easter egg");
                    return false;
                }
                if (FunnySpriteSwitch.Companion.isOn() && FunnySpriteResDownloadUtil.k().invoke().booleanValue() && HomeSpriteEdgeFloatManager.m.f()) {
                    z = true;
                }
                zq8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("SpriteEdgeFloat", "spriteEdgeFloat canShowSpriteAndTip " + z);
                return z;
            }
            return invokeV.booleanValue;
        }

        @JvmStatic
        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (HomeSpriteEdgeFloatManager.p < d()) {
                    zq8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c("SpriteEdgeFloat", "跳过精灵入场动画 限制:" + d() + " 机型评分:" + HomeSpriteEdgeFloatManager.p);
                    return HomeSpriteEdgeFloatManager.n;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements fw9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeSpriteEdgeFloatManager a;
        public final /* synthetic */ SpriteEdgeFloat b;

        public b(HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager, SpriteEdgeFloat spriteEdgeFloat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeSpriteEdgeFloatManager, spriteEdgeFloat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homeSpriteEdgeFloatManager;
            this.b = spriteEdgeFloat;
        }

        @Override // com.baidu.tieba.fw9
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            iu9 t = this.a.t("day_normal", "dark_normal");
            t.a().c(true);
            this.b.n(t);
            if (HomeSpriteEdgeFloatManager.j.g()) {
                this.b.o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-641599100, "Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-641599100, "Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;");
                return;
            }
        }
        j = new a(null);
        k = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) HomeSpriteEdgeFloatManager$Companion$instance$2.INSTANCE);
        l = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$PAGE_SUPPORT_LIST$2.INSTANCE);
        m = new cr8("key_sprite_dialog_disappear");
        n = true;
        o = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$limit$2.INSTANCE);
        p = ScheduleStrategy.getDeviceScore();
    }

    public HomeSpriteEdgeFloatManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = fn5.b("sprite_talk_default", 0);
        this.b = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$normalMainTabBarHeight$2.INSTANCE);
        this.c = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$spriteStateMap$2.INSTANCE);
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteEdgeFloatManager$skinChangeListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomeSpriteEdgeFloatManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            /* loaded from: classes7.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteEdgeFloatManager a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager) {
                    super(2001304);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homeSpriteEdgeFloatManager};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = homeSpriteEdgeFloatManager;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
                    r5 = r4.a.z();
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SpriteEdgeFloat z;
                    mt9 C;
                    mt9 C2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && z != null) {
                        HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                        iw9 c = z.c();
                        C = homeSpriteEdgeFloatManager.C();
                        if (Intrinsics.areEqual(c, C.c())) {
                            iu9 t = homeSpriteEdgeFloatManager.t("day_stand", "dark_stand");
                            t.a().c(false);
                            z.n(t);
                            return;
                        }
                        C2 = homeSpriteEdgeFloatManager.C();
                        if (!Intrinsics.areEqual(c, C2.f())) {
                            return;
                        }
                        iu9 t2 = homeSpriteEdgeFloatManager.t("day_normal", "dark_normal");
                        t2.a().c(true);
                        z.n(t2);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
    }

    public final SpriteTipEdgeFloat E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                if (mainActivity == null && (mainActivity = g9.f().b()) == null) {
                    return null;
                }
                Activity activity = mainActivity;
                synchronized (this) {
                    if (this.g == null) {
                        this.g = new SpriteTipEdgeFloat(activity, 85, vi.g(activity, R.dimen.tbds177), u(), false, j.e());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.g;
        }
        return (SpriteTipEdgeFloat) invokeV.objValue;
    }

    public final void H() {
        SpriteEdgeFloat z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (z = z()) != null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() is Showing???");
            if (!z.h()) {
                return;
            }
            MessageManager.getInstance().unRegisterListener(v());
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() internal hide");
            z.g();
            w3a.g.a().k(false);
        }
    }

    public final void M() {
        SpriteEdgeFloat z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && j.b() && (z = z()) != null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show is not Showing???");
            if (z.h()) {
                return;
            }
            MessageManager.getInstance().registerListener(v());
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show internal show");
            z.m();
            bu9.b();
            L();
            HomePageSpriteTipController D = D();
            if (D != null) {
                D.d();
            }
            w3a.g.a().k(true);
        }
    }

    public static final void O(HomeSpriteEdgeFloatManager this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件自动隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this$0.i;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this$0.i = null;
            or6.e eVar = this$0.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this$0.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        HomePageSpriteTipController D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onPause");
            k.$default$onPause(this, owner);
            if (j.b() && (D = D()) != null) {
                D.g();
            }
        }
    }

    public static final void b(HomeSpriteEdgeFloatManager this$0, Ref.ObjectRef activity, View view2) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, activity, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (hw5.a()) {
                return;
            }
            SpriteTipEdgeFloat E = this$0.E();
            if (E != null) {
                bool = Boolean.valueOf(E.e());
            } else {
                bool = null;
            }
            bu9.a(Intrinsics.areEqual(bool, Boolean.TRUE));
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                SpriteTipEdgeFloat E2 = this$0.E();
                if (E2 != null) {
                    E2.d();
                    return;
                }
                return;
            }
            T activity2 = activity.element;
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            this$0.G((Context) activity2, this$0.a);
        }
    }

    public final mt9 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (mt9) this.c.getValue();
        }
        return (mt9) invokeV.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this.i;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this.i = null;
            or6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat sendStandEvent");
            J(C().b());
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat dialog displayed");
            m.i();
        }
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return ((Number) this.b.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final CustomMessageListener v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return (CustomMessageListener) this.e.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void J(hw9 hw9Var) {
        SpriteEdgeFloat z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, hw9Var) == null) && (z = z()) != null) {
            z.j(hw9Var);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onCreate");
            k.$default$onCreate(this, owner);
            M();
        }
    }

    public final HomePageSpriteTipController D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f == null) {
                synchronized (this) {
                    if (this.f == null && E() != null) {
                        SpriteTipEdgeFloat E = E();
                        Intrinsics.checkNotNull(E);
                        this.f = new HomePageSpriteTipController(E.c());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.f;
        }
        return (HomePageSpriteTipController) invokeV.objValue;
    }

    public final void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            boolean z = true;
            if ((str == null || !StringsKt__StringsJVMKt.startsWith$default(str, "tiebaapp://router/portal", false, 2, null)) ? false : false) {
                s77.c(context, str);
            }
        }
    }

    public final void N(aw9 hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件显示");
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            if (mainActivity == null) {
                mainActivity = g9.f().b();
            }
            Activity curActivity = mainActivity;
            this.d = hotEventShowData.a();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (curActivity != null) {
                hotEventShowData.b().setShowCloseBtn(false);
                hotEventShowData.b().setUseRightBg(false);
                SpriteBottomTipView tipView = qf5.f(hotEventShowData.b(), curActivity, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds177);
                ViewGroup.LayoutParams layoutParams = tipView.getContentView().getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.width = vi.l(curActivity) - dimenPixelSize;
                }
                int u = u();
                Intrinsics.checkNotNullExpressionValue(curActivity, "curActivity");
                List e = j.e();
                Intrinsics.checkNotNullExpressionValue(tipView, "tipView");
                SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = new SpriteNotificationEdgeFloat(curActivity, 85, dimenPixelSize, u, false, e, tipView);
                this.i = spriteNotificationEdgeFloat;
                if (spriteNotificationEdgeFloat != null) {
                    spriteNotificationEdgeFloat.f();
                }
                DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示成功");
                qf5.o();
                qf5.q(hotEventShowData.b());
                wg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.zt9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomeSpriteEdgeFloatManager.O(HomeSpriteEdgeFloatManager.this);
                        }
                    }
                }, 5000L);
                return;
            }
            DefaultLog.getInstance().b("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示失败");
            or6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onDestroy");
            k.$default$onDestroy(this, owner);
            if (w3a.g.a().g()) {
                H();
                HomePageSpriteTipController D = D();
                if (D != null) {
                    D.f();
                }
                this.f = null;
                SpriteTipEdgeFloat E = E();
                if (E != null) {
                    E.f();
                }
                this.g = null;
                SpriteEdgeFloat z = z();
                if (z != null) {
                    z.i();
                }
                this.h = null;
            }
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this.i;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.e();
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onResume");
            k.$default$onResume(this, owner);
            if (j.b()) {
                HomePageSpriteTipController D = D();
                if (D != null) {
                    D.h();
                }
                SpriteEdgeFloat z = z();
                boolean z2 = true;
                if ((z == null || !z.h()) ? false : false) {
                    bu9.b();
                }
            }
        }
    }

    public final iu9 t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            es6 es6Var = new es6();
            iu9 iu9Var = new iu9(es6Var);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = str2;
            }
            es6Var.d(FunnySpriteResDownloadUtil.j(str, null, false, 6, null));
            if (StringsKt__StringsJVMKt.endsWith$default(es6Var.a(), DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, false, 2, null)) {
                es6Var.e(1);
            } else if (StringsKt__StringsJVMKt.endsWith$default(es6Var.a(), ".webp", false, 2, null)) {
                es6Var.e(2);
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new IllegalStateException("unsupported file path " + es6Var.a());
            }
            return iu9Var;
        }
        return (iu9) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.app.Activity] */
    public final SpriteEdgeFloat z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.h == null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                objectRef.element = mainActivity;
                if (mainActivity == 0) {
                    ?? b2 = g9.f().b();
                    if (b2 == 0) {
                        return null;
                    }
                    objectRef.element = b2;
                }
                synchronized (this) {
                    if (this.h == null) {
                        int u = u() - vi.g((Context) objectRef.element, R.dimen.M_H_X003);
                        T activity = objectRef.element;
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        final SpriteEdgeFloat spriteEdgeFloat = new SpriteEdgeFloat((Activity) activity, C(), 85, 0, u, false, j.e());
                        spriteEdgeFloat.k(new View.OnClickListener() { // from class: com.baidu.tieba.wt9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    HomeSpriteEdgeFloatManager.b(HomeSpriteEdgeFloatManager.this, objectRef, view2);
                                }
                            }
                        });
                        C().c().a(new fw9(spriteEdgeFloat, this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SpriteEdgeFloat a;
                            public final /* synthetic */ HomeSpriteEdgeFloatManager b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {spriteEdgeFloat, this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = spriteEdgeFloat;
                                this.b = this;
                            }

                            @Override // com.baidu.tieba.fw9
                            public void a() {
                                mt9 C;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (HomeSpriteEdgeFloatManager.j.g()) {
                                        SpriteEdgeFloat spriteEdgeFloat2 = this.a;
                                        C = this.b.C();
                                        spriteEdgeFloat2.j(C.e());
                                        return;
                                    }
                                    final SpriteEdgeFloat spriteEdgeFloat3 = this.a;
                                    final HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.b;
                                    spriteEdgeFloat3.l(new Function0<Unit>(spriteEdgeFloat3, homeSpriteEdgeFloatManager) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2$doAction$1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ SpriteEdgeFloat $this_apply;
                                        public final /* synthetic */ HomeSpriteEdgeFloatManager this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {spriteEdgeFloat3, homeSpriteEdgeFloatManager};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.$this_apply = spriteEdgeFloat3;
                                            this.this$0 = homeSpriteEdgeFloatManager;
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
                                            mt9 C2;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                this.$this_apply.l(null);
                                                SpriteEdgeFloat spriteEdgeFloat4 = this.$this_apply;
                                                C2 = this.this$0.C();
                                                spriteEdgeFloat4.j(C2.e());
                                            }
                                        }
                                    });
                                    iu9 t = this.b.t("day_stand", "dark_stand");
                                    t.a().c(false);
                                    this.a.n(t);
                                }
                            }
                        });
                        C().f().a(new b(this, spriteEdgeFloat));
                        this.h = spriteEdgeFloat;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.h;
        }
        return (SpriteEdgeFloat) invokeV.objValue;
    }
}
