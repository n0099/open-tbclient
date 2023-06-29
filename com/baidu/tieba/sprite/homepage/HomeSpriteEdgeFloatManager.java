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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.c87;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.e2a;
import com.baidu.tieba.ew8;
import com.baidu.tieba.f0a;
import com.baidu.tieba.h9;
import com.baidu.tieba.hw8;
import com.baidu.tieba.j2a;
import com.baidu.tieba.l;
import com.baidu.tieba.l2a;
import com.baidu.tieba.m0a;
import com.baidu.tieba.m2a;
import com.baidu.tieba.nn5;
import com.baidu.tieba.os6;
import com.baidu.tieba.qz9;
import com.baidu.tieba.rw5;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteNotificationEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$visibleOrGoneListener$2;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.yr6;
import com.baidu.tieba.z9a;
import com.baidu.tieba.zf5;
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
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0002J\b\u00100\u001a\u000201H\u0002J\u001a\u00102\u001a\u0002012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u00106\u001a\u000201J\u0006\u00107\u001a\u000201J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u000201H\u0002J\u0006\u0010B\u001a\u000201J\u000e\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u000201J\b\u0010G\u001a\u000201H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\b\u001a\u0004\b*\u0010\f¨\u0006I"}, d2 = {"Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "normalMainTabBarHeight", "", "getNormalMainTabBarHeight", "()I", "normalMainTabBarHeight$delegate", "Lkotlin/Lazy;", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "spriteEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "getSpriteEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "spriteJumpScheme", "", "getSpriteJumpScheme", "()Ljava/lang/String;", "setSpriteJumpScheme", "(Ljava/lang/String;)V", "spriteNotificationEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteNotificationEdgeFloat;", "spriteStateMap", "Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "getSpriteStateMap", "()Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "spriteStateMap$delegate", "spriteTipController", "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "getSpriteTipController", "()Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "spriteTipEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "getSpriteTipEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "tipDissmisListener", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "visibleOrGoneListener", "getVisibleOrGoneListener", "visibleOrGoneListener$delegate", "generateDataByState", "Lcom/baidu/tieba/sprite/view/NormalSpriteData;", "dayResName", "darkResName", "gone", "", "gotoScheme", "context", "Landroid/content/Context;", "scheme", "hide", "hideNotification", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "sendStandEvent", "show", "showNotification", "hotEventShowData", "Lcom/baidu/tieba/statemachine/animationtip/message/HotEventShowData;", "spriteDialogHide", MapBundleKey.MapObjKey.OBJ_SL_VISI, "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HomeSpriteEdgeFloatManager implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final a k;
    public static final Lazy<HomeSpriteEdgeFloatManager> l;
    public static final Lazy<List<String>> m;
    public static final hw8 n;
    public static boolean o;
    public static final Lazy<Double> p;
    public static final double q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final Lazy b;
    public final Lazy c;
    public yr6.e d;
    public final Lazy e;
    public final Lazy f;
    public HomePageSpriteTipController g;
    public SpriteTipEdgeFloat h;
    public SpriteEdgeFloat i;
    public SpriteNotificationEdgeFloat j;

    public /* synthetic */ HomeSpriteEdgeFloatManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        l.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        l.$default$onStop(this, lifecycleOwner);
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
                return (HomeSpriteEdgeFloatManager) HomeSpriteEdgeFloatManager.l.getValue();
            }
            return (HomeSpriteEdgeFloatManager) invokeV.objValue;
        }

        public final double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ((Number) HomeSpriteEdgeFloatManager.p.getValue()).doubleValue();
            }
            return invokeV.doubleValue;
        }

        public final List<String> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return (List) HomeSpriteEdgeFloatManager.m.getValue();
            }
            return (List) invokeV.objValue;
        }

        @JvmStatic
        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048580, this, z) != null) {
                return;
            }
            HomeSpriteEdgeFloatManager.o = z;
        }

        @JvmStatic
        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean z = false;
                if (z9a.g.a().e()) {
                    DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat blocked by easter egg");
                    return false;
                }
                if (FunnySpriteSwitch.Companion.isOn() && FunnySpriteResDownloadUtil.k().invoke().booleanValue() && HomeSpriteEdgeFloatManager.n.f()) {
                    z = true;
                }
                ew8 defaultLog = DefaultLog.getInstance();
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
                if (HomeSpriteEdgeFloatManager.q < d()) {
                    ew8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c("SpriteEdgeFloat", "跳过精灵入场动画 限制:" + d() + " 机型评分:" + HomeSpriteEdgeFloatManager.q);
                    return HomeSpriteEdgeFloatManager.o;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements j2a {
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

        @Override // com.baidu.tieba.j2a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            m0a v = this.a.v("day_normal", "dark_normal");
            v.a().c(true);
            this.b.n(v);
            if (HomeSpriteEdgeFloatManager.k.g()) {
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
        k = new a(null);
        l = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) HomeSpriteEdgeFloatManager$Companion$instance$2.INSTANCE);
        m = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$PAGE_SUPPORT_LIST$2.INSTANCE);
        n = new hw8("key_sprite_dialog_disappear");
        o = true;
        p = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$limit$2.INSTANCE);
        q = ScheduleStrategy.getDeviceScore();
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
        this.a = nn5.b("sprite_talk_default", 0);
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
                    r5 = r4.a.D();
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SpriteEdgeFloat D;
                    qz9 E;
                    qz9 E2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && D != null) {
                        HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                        m2a c = D.c();
                        E = homeSpriteEdgeFloatManager.E();
                        if (Intrinsics.areEqual(c, E.c())) {
                            m0a v = homeSpriteEdgeFloatManager.v("day_stand", "dark_stand");
                            v.a().c(false);
                            D.n(v);
                            return;
                        }
                        E2 = homeSpriteEdgeFloatManager.E();
                        if (!Intrinsics.areEqual(c, E2.f())) {
                            return;
                        }
                        m0a v2 = homeSpriteEdgeFloatManager.v("day_normal", "dark_normal");
                        v2.a().c(true);
                        D.n(v2);
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
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteEdgeFloatManager$visibleOrGoneListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$visibleOrGoneListener$2
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
                    super(2921810);
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
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Object obj;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                        Integer num = null;
                        if (customResponsedMessage != null) {
                            obj = customResponsedMessage.getData();
                        } else {
                            obj = null;
                        }
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        if (num != null) {
                            HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                            int intValue = num.intValue();
                            if (intValue != 1) {
                                if (intValue != 2) {
                                    return;
                                }
                                homeSpriteEdgeFloatManager.J();
                                return;
                            }
                            homeSpriteEdgeFloatManager.V();
                        }
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

    public final SpriteTipEdgeFloat H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h == null) {
                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                if (mainActivity == null && (mainActivity = h9.f().b()) == null) {
                    return null;
                }
                Activity activity = mainActivity;
                synchronized (this) {
                    if (this.h == null) {
                        this.h = new SpriteTipEdgeFloat(activity, 85, xi.g(activity, R.dimen.tbds177), w(), false, k.e());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.h;
        }
        return (SpriteTipEdgeFloat) invokeV.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SpriteEdgeFloat D = D();
            if (D != null) {
                DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() is Showing???");
                if (!D.h()) {
                    return;
                }
                MessageManager.getInstance().unRegisterListener(C());
                DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() internal hide");
                D.g();
                z9a.g.a().k(false);
            }
            SpriteTipEdgeFloat H = H();
            if (H != null) {
                H.e();
            }
        }
    }

    public static final void T(HomeSpriteEdgeFloatManager this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件自动隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this$0.j;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this$0.j = null;
            yr6.e eVar = this$0.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this$0.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        HomePageSpriteTipController G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onPause");
            l.$default$onPause(this, owner);
            if (k.b() && (G = G()) != null) {
                G.g();
            }
        }
    }

    public static final void b(HomeSpriteEdgeFloatManager this$0, Ref.ObjectRef activity, View view2) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, activity, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (rw5.a()) {
                return;
            }
            SpriteTipEdgeFloat H = this$0.H();
            if (H != null) {
                bool = Boolean.valueOf(H.f());
            } else {
                bool = null;
            }
            f0a.a(Intrinsics.areEqual(bool, Boolean.TRUE));
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                SpriteTipEdgeFloat H2 = this$0.H();
                if (H2 != null) {
                    H2.d();
                    return;
                }
                return;
            }
            T activity2 = activity.element;
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            this$0.L((Context) activity2, this$0.a);
        }
    }

    public final CustomMessageListener C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (CustomMessageListener) this.e.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final qz9 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (qz9) this.c.getValue();
        }
        return (qz9) invokeV.objValue;
    }

    public final CustomMessageListener I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (CustomMessageListener) this.f.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this.j;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this.j = null;
            yr6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat sendStandEvent");
            O(E().b());
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat dialog displayed");
            n.i();
        }
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return ((Number) this.b.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final void O(l2a l2aVar) {
        SpriteEdgeFloat D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, l2aVar) == null) && (D = D()) != null) {
            D.j(l2aVar);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onCreate");
            l.$default$onCreate(this, owner);
            R();
            MessageManager.getInstance().registerListener(I());
        }
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.app.Activity] */
    public final SpriteEdgeFloat D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.i == null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                objectRef.element = mainActivity;
                if (mainActivity == 0) {
                    ?? b2 = h9.f().b();
                    if (b2 == 0) {
                        return null;
                    }
                    objectRef.element = b2;
                }
                synchronized (this) {
                    if (this.i == null) {
                        int w = w() - xi.g((Context) objectRef.element, R.dimen.M_H_X003);
                        T activity = objectRef.element;
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        final SpriteEdgeFloat spriteEdgeFloat = new SpriteEdgeFloat((Activity) activity, E(), 85, 0, w, false, k.e());
                        spriteEdgeFloat.k(new View.OnClickListener() { // from class: com.baidu.tieba.b0a
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
                        E().c().a(new j2a(spriteEdgeFloat, this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2
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

                            @Override // com.baidu.tieba.j2a
                            public void a() {
                                qz9 E;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (HomeSpriteEdgeFloatManager.k.g()) {
                                        SpriteEdgeFloat spriteEdgeFloat2 = this.a;
                                        E = this.b.E();
                                        spriteEdgeFloat2.j(E.e());
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
                                            qz9 E2;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                this.$this_apply.l(null);
                                                SpriteEdgeFloat spriteEdgeFloat4 = this.$this_apply;
                                                E2 = this.this$0.E();
                                                spriteEdgeFloat4.j(E2.e());
                                            }
                                        }
                                    });
                                    m0a v = this.b.v("day_stand", "dark_stand");
                                    v.a().c(false);
                                    this.a.n(v);
                                }
                            }
                        });
                        E().f().a(new b(this, spriteEdgeFloat));
                        this.i = spriteEdgeFloat;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.i;
        }
        return (SpriteEdgeFloat) invokeV.objValue;
    }

    public final HomePageSpriteTipController G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g == null) {
                synchronized (this) {
                    if (this.g == null && H() != null) {
                        SpriteTipEdgeFloat H = H();
                        Intrinsics.checkNotNull(H);
                        this.g = new HomePageSpriteTipController(H.c());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.g;
        }
        return (HomePageSpriteTipController) invokeV.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpriteEdgeFloat D = D();
            if (D != null) {
                if (!D.h()) {
                    return;
                }
                D.g();
                z9a.g.a().k(false);
            }
            SpriteTipEdgeFloat H = H();
            if (H != null) {
                H.e();
            }
            HomePageSpriteTipController G = G();
            if (G != null) {
                G.l(false);
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || !k.b()) {
            return;
        }
        SpriteEdgeFloat D = D();
        if (D != null) {
            if (D.h()) {
                return;
            }
            D.m();
            z9a.g.a().k(true);
        }
        SpriteTipEdgeFloat H = H();
        if (H != null) {
            H.h();
        }
        HomePageSpriteTipController G = G();
        if (G != null) {
            G.l(true);
        }
    }

    public final void L(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
            boolean z = true;
            if ((str == null || !StringsKt__StringsJVMKt.startsWith$default(str, "tiebaapp://router/portal", false, 2, null)) ? false : false) {
                c87.c(context, str);
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !k.b()) {
            return;
        }
        SpriteEdgeFloat D = D();
        if (D != null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show is not Showing???");
            if (D.h()) {
                return;
            }
            MessageManager.getInstance().registerListener(C());
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show internal show");
            D.m();
            f0a.b();
            Q();
            HomePageSpriteTipController G = G();
            if (G != null) {
                G.d();
            }
            z9a.g.a().k(true);
        }
        SpriteTipEdgeFloat H = H();
        if (H != null) {
            H.h();
        }
    }

    public final void S(e2a hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件显示");
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            if (mainActivity == null) {
                mainActivity = h9.f().b();
            }
            Activity curActivity = mainActivity;
            this.d = hotEventShowData.a();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (curActivity != null) {
                hotEventShowData.b().setShowCloseBtn(false);
                hotEventShowData.b().setUseRightBg(false);
                SpriteBottomTipView tipView = zf5.f(hotEventShowData.b(), curActivity, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds177);
                ViewGroup.LayoutParams layoutParams = tipView.getContentView().getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.width = xi.l(curActivity) - dimenPixelSize;
                }
                int w = w();
                Intrinsics.checkNotNullExpressionValue(curActivity, "curActivity");
                List e = k.e();
                Intrinsics.checkNotNullExpressionValue(tipView, "tipView");
                SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = new SpriteNotificationEdgeFloat(curActivity, 85, dimenPixelSize, w, false, e, tipView);
                this.j = spriteNotificationEdgeFloat;
                if (spriteNotificationEdgeFloat != null) {
                    spriteNotificationEdgeFloat.f();
                }
                DefaultLog.getInstance().c("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示成功");
                zf5.o();
                zf5.q(hotEventShowData.b());
                yg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.zz9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomeSpriteEdgeFloatManager.T(HomeSpriteEdgeFloatManager.this);
                        }
                    }
                }, 5000L);
                return;
            }
            DefaultLog.getInstance().b("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示失败");
            yr6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onDestroy");
            l.$default$onDestroy(this, owner);
            MessageManager.getInstance().unRegisterListener(I());
            if (z9a.g.a().g()) {
                M();
                HomePageSpriteTipController G = G();
                if (G != null) {
                    G.f();
                }
                this.g = null;
                SpriteTipEdgeFloat H = H();
                if (H != null) {
                    H.g();
                }
                this.h = null;
                SpriteEdgeFloat D = D();
                if (D != null) {
                    D.i();
                }
                this.i = null;
            }
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this.j;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.e();
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onResume");
            l.$default$onResume(this, owner);
            if (k.b()) {
                HomePageSpriteTipController G = G();
                if (G != null) {
                    G.h();
                }
                SpriteEdgeFloat D = D();
                boolean z = true;
                if ((D == null || !D.h()) ? false : false) {
                    f0a.b();
                }
            }
        }
    }

    public final m0a v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) {
            os6 os6Var = new os6();
            m0a m0aVar = new m0a(os6Var);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = str2;
            }
            os6Var.d(FunnySpriteResDownloadUtil.j(str, null, false, 6, null));
            if (StringsKt__StringsJVMKt.endsWith$default(os6Var.a(), DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, false, 2, null)) {
                os6Var.e(1);
            } else if (StringsKt__StringsJVMKt.endsWith$default(os6Var.a(), ".webp", false, 2, null)) {
                os6Var.e(2);
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new IllegalStateException("unsupported file path " + os6Var.a());
            }
            return m0aVar;
        }
        return (m0a) invokeLL.objValue;
    }
}
