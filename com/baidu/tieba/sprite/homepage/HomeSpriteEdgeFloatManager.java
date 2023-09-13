package com.baidu.tieba.sprite.homepage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.co5;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.eda;
import com.baidu.tieba.eg5;
import com.baidu.tieba.fda;
import com.baidu.tieba.fna;
import com.baidu.tieba.hda;
import com.baidu.tieba.ifa;
import com.baidu.tieba.jca;
import com.baidu.tieba.k59;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m;
import com.baidu.tieba.mca;
import com.baidu.tieba.nfa;
import com.baidu.tieba.oda;
import com.baidu.tieba.pfa;
import com.baidu.tieba.pu6;
import com.baidu.tieba.rfa;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteNotificationEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$visibleOrGoneListener$2;
import com.baidu.tieba.sprite.homepage.userstrategy.NewUserSpriteShowStrategy;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.xb7;
import com.baidu.tieba.xw5;
import com.baidu.tieba.yt6;
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
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u001e\u00103\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u000200H\u0002J\u001a\u0010?\u001a\u0002002\u0006\u00104\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010B\u001a\u000200J\u0006\u0010C\u001a\u000200J\u0006\u0010D\u001a\u000200J\b\u0010E\u001a\u000200H\u0002J\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u0002002\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010L\u001a\u0002002\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010M\u001a\u0002002\u0006\u0010I\u001a\u00020JH\u0016J\u0006\u0010N\u001a\u000200J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u000200H\u0002J\u0006\u0010S\u001a\u00020GJ\u000e\u0010T\u001a\u0002002\u0006\u00101\u001a\u000202J\u0006\u0010U\u001a\u000200J\u0006\u0010V\u001a\u000200J\b\u0010W\u001a\u000200H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\b\u001a\u0004\b-\u0010\f¨\u0006Y"}, d2 = {"Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "normalMainTabBarHeight", "", "getNormalMainTabBarHeight", "()I", "normalMainTabBarHeight$delegate", "Lkotlin/Lazy;", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "<set-?>", "Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "spriteEdgeFloat", "getSpriteEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "spriteJumpScheme", "", "getSpriteJumpScheme", "()Ljava/lang/String;", "setSpriteJumpScheme", "(Ljava/lang/String;)V", "spriteNotificationEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteNotificationEdgeFloat;", "spriteShowStrategy", "Lcom/baidu/tieba/sprite/homepage/userstrategy/ISpriteShowStrategy;", "spriteStateMap", "Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "getSpriteStateMap", "()Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "spriteStateMap$delegate", "spriteTipController", "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "getSpriteTipController", "()Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "spriteTipEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "getSpriteTipEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "tipDissmisListener", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "visibleOrGoneListener", "getVisibleOrGoneListener", "visibleOrGoneListener$delegate", "dispatchSpriteNotification", "", "hotEventShowData", "Lcom/baidu/tieba/statemachine/animationtip/message/HotEventShowData;", "dispatchSpriteTip", "context", "Landroid/app/Activity;", "response", "Lcom/baidu/tieba/sprite/funnysprite/data/SpriteTipHttpResponseMessage;", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "generateDataByState", "Lcom/baidu/tieba/sprite/view/NormalSpriteData;", "dayResName", "darkResName", "gone", "gotoScheme", "Landroid/content/Context;", "scheme", "hide", "hideNotification", "hideSpriteFloatImmediately", "initSpriteShowStrategy", "isSpriteEnable", "", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "runSpriteFloatExitSate", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "sendStandEvent", "show", "showNotification", "spriteDialogHide", "startSpriteTipLoop", MapBundleKey.MapObjKey.OBJ_SL_VISI, "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HomeSpriteEdgeFloatManager implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final a l;
    public static final Lazy<HomeSpriteEdgeFloatManager> m;
    public static final Lazy<List<String>> n;
    public static final k59 o;
    public static boolean p;
    public static final Lazy<Double> q;
    public static final double r;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final Lazy b;
    public final Lazy c;
    public yt6.e d;
    public final Lazy e;
    public final Lazy f;
    public HomePageSpriteTipController g;
    public SpriteTipEdgeFloat h;
    public SpriteEdgeFloat i;
    public SpriteNotificationEdgeFloat j;
    public eda k;

    public /* synthetic */ HomeSpriteEdgeFloatManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStop(this, lifecycleOwner);
    }

    /* loaded from: classes8.dex */
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
                return (HomeSpriteEdgeFloatManager) HomeSpriteEdgeFloatManager.m.getValue();
            }
            return (HomeSpriteEdgeFloatManager) invokeV.objValue;
        }

        public final double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ((Number) HomeSpriteEdgeFloatManager.q.getValue()).doubleValue();
            }
            return invokeV.doubleValue;
        }

        public final List<String> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return (List) HomeSpriteEdgeFloatManager.n.getValue();
            }
            return (List) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (jca.a.a() && !jca.a.b()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @JvmStatic
        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048580, this, z) != null) {
                return;
            }
            HomeSpriteEdgeFloatManager.p = z;
        }

        @JvmStatic
        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean z = false;
                if (fna.i.a().f()) {
                    DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat blocked by easter egg");
                    return false;
                }
                if (FunnySpriteSwitch.Companion.isOn() && FunnySpriteResDownloadUtil.k().invoke().booleanValue()) {
                    z = true;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("SpriteEdgeFloat", "spriteEdgeFloat canShowSpriteAndTip " + z);
                return z;
            }
            return invokeV.booleanValue;
        }

        @JvmStatic
        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (!g() || HomeSpriteEdgeFloatManager.r >= d()) {
                    return false;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("SpriteEdgeFloat", "跳过精灵入场动画 限制:" + d() + " 机型评分:" + HomeSpriteEdgeFloatManager.r);
                return HomeSpriteEdgeFloatManager.p;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements nfa {
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

        @Override // com.baidu.tieba.nfa
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            oda B = this.a.B("day_normal", "dark_normal");
            B.a().c(true);
            this.b.o(B);
            if (HomeSpriteEdgeFloatManager.l.h()) {
                this.b.p();
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
        l = new a(null);
        m = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) HomeSpriteEdgeFloatManager$Companion$instance$2.INSTANCE);
        n = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$PAGE_SUPPORT_LIST$2.INSTANCE);
        o = new k59("key_sprite_dialog_disappear");
        p = true;
        q = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$Companion$limit$2.INSTANCE);
        r = ScheduleStrategy.getDeviceScore();
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
        Q();
        this.a = co5.b("sprite_talk_default", 0);
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

            /* loaded from: classes8.dex */
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
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SpriteEdgeFloat F;
                    mca G;
                    mca G2;
                    mca G3;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (F = this.a.F()) != null) {
                        HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                        rfa c = F.c();
                        G = homeSpriteEdgeFloatManager.G();
                        if (Intrinsics.areEqual(c, G.c())) {
                            oda B = homeSpriteEdgeFloatManager.B("day_stand", "dark_stand");
                            B.a().c(false);
                            F.o(B);
                            return;
                        }
                        G2 = homeSpriteEdgeFloatManager.G();
                        if (Intrinsics.areEqual(c, G2.h())) {
                            oda B2 = homeSpriteEdgeFloatManager.B("day_normal", "dark_normal");
                            B2.a().c(true);
                            F.o(B2);
                            return;
                        }
                        G3 = homeSpriteEdgeFloatManager.G();
                        if (!Intrinsics.areEqual(c, G3.d())) {
                            return;
                        }
                        oda B3 = homeSpriteEdgeFloatManager.B("day_disappear", "dark_disappear");
                        B3.a().c(false);
                        F.o(B3);
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

            /* loaded from: classes8.dex */
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
                                homeSpriteEdgeFloatManager.L();
                                return;
                            }
                            homeSpriteEdgeFloatManager.a0();
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

    public final SpriteTipEdgeFloat I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.h == null) {
                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                if (mainActivity == null && (mainActivity = BdActivityStack.getInst().currentActivity()) == null) {
                    return null;
                }
                Activity activity = mainActivity;
                synchronized (this) {
                    if (this.h == null) {
                        this.h = new SpriteTipEdgeFloat(activity, 85, BdUtilHelper.getDimens(activity, R.dimen.tbds177), D(), false, l.e());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.h;
        }
        return (SpriteTipEdgeFloat) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SpriteEdgeFloat F = F();
            if (F != null) {
                DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat hide() is Showing???");
                if (!F.i()) {
                    return;
                }
                MessageManager.getInstance().unRegisterListener(E());
                DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat hide() internal hide");
                eda edaVar = this.k;
                if (edaVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spriteShowStrategy");
                    edaVar = null;
                }
                edaVar.hide();
                fna.i.a().n(false);
            }
            SpriteTipEdgeFloat I = I();
            if (I != null) {
                I.e();
            }
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        SpriteEdgeFloat F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!l.b() || (F = F()) == null) {
                return false;
            }
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat show is not Showing???");
            if (F.i()) {
                return false;
            }
            MessageManager.getInstance().registerListener(E());
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat show internal show");
            F.n();
            hda.b();
            U();
            fna.i.a().n(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || !l.b()) {
            return;
        }
        if (!l.g()) {
            HomePageSpriteTipController H = H();
            if (H != null) {
                H.l(true);
                return;
            }
            return;
        }
        SpriteEdgeFloat F = F();
        if (F != null) {
            if (F.i()) {
                return;
            }
            F.n();
            fna.i.a().n(true);
        }
        HomePageSpriteTipController H2 = H();
        if (H2 != null) {
            H2.l(true);
        }
    }

    public static final void X(HomeSpriteEdgeFloatManager this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件自动隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this$0.j;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this$0.j = null;
            yt6.e eVar = this$0.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this$0.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat onCreate");
            m.$default$onCreate(this, owner);
            eda edaVar = this.k;
            if (edaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spriteShowStrategy");
                edaVar = null;
            }
            edaVar.d();
            MessageManager.getInstance().registerListener(K());
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        HomePageSpriteTipController H;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat onPause");
            m.$default$onPause(this, owner);
            if (l.b() && (H = H()) != null) {
                H.g();
            }
        }
    }

    public static final void b(HomeSpriteEdgeFloatManager this$0, Ref.ObjectRef activity, View view2) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, activity, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (xw5.a()) {
                return;
            }
            SpriteTipEdgeFloat I = this$0.I();
            if (I != null) {
                bool = Boolean.valueOf(I.f());
            } else {
                bool = null;
            }
            hda.a(Intrinsics.areEqual(bool, Boolean.TRUE));
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                SpriteTipEdgeFloat I2 = this$0.I();
                if (I2 != null) {
                    I2.d();
                    return;
                }
                return;
            }
            T activity2 = activity.element;
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            this$0.M((Context) activity2, this$0.a);
        }
    }

    public final void A(Activity context, SpriteTipHttpResponseMessage response, HomePageSpriteBottomTipView spriteTipView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, response, spriteTipView) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(spriteTipView, "spriteTipView");
            eda edaVar = this.k;
            if (edaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spriteShowStrategy");
                edaVar = null;
            }
            edaVar.c(context, response, spriteTipView);
        }
    }

    public final int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((Number) this.b.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final CustomMessageListener E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (CustomMessageListener) this.e.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final mca G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (mca) this.c.getValue();
        }
        return (mca) invokeV.objValue;
    }

    public final CustomMessageListener K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (CustomMessageListener) this.f.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            DefaultLog.getInstance().i("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件隐藏");
            SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = this.j;
            if (spriteNotificationEdgeFloat != null) {
                spriteNotificationEdgeFloat.d();
            }
            this.j = null;
            yt6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    public final void P() {
        SpriteEdgeFloat F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (F = F()) != null) {
            F.h();
        }
    }

    public final void Q() {
        eda newUserSpriteShowStrategy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (l.g()) {
                newUserSpriteShowStrategy = new fda();
            } else {
                newUserSpriteShowStrategy = new NewUserSpriteShowStrategy();
            }
            this.k = newUserSpriteShowStrategy;
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            eda edaVar = this.k;
            if (edaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spriteShowStrategy");
                edaVar = null;
            }
            return edaVar.a();
        }
        return invokeV.booleanValue;
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            T(G().e());
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat sendStandEvent");
            T(G().b());
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat dialog displayed");
            o.i();
        }
    }

    public final void Z() {
        HomePageSpriteTipController H;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (H = H()) != null) {
            H.d();
        }
    }

    public final void T(pfa pfaVar) {
        SpriteEdgeFloat F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, pfaVar) == null) && (F = F()) != null) {
            F.k(pfaVar);
        }
    }

    public final void w(ifa hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            eda edaVar = this.k;
            if (edaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spriteShowStrategy");
                edaVar = null;
            }
            edaVar.b(hotEventShowData);
        }
    }

    public final oda B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            pu6 pu6Var = new pu6();
            oda odaVar = new oda(pu6Var);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = str2;
            }
            pu6Var.d(FunnySpriteResDownloadUtil.j(str, null, false, 6, null));
            if (StringsKt__StringsJVMKt.endsWith$default(pu6Var.a(), DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, false, 2, null)) {
                pu6Var.e(1);
            } else if (StringsKt__StringsJVMKt.endsWith$default(pu6Var.a(), ".webp", false, 2, null)) {
                pu6Var.e(2);
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new IllegalStateException("unsupported file path " + pu6Var.a());
            }
            return odaVar;
        }
        return (oda) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.app.Activity] */
    public final SpriteEdgeFloat F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.i == null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                objectRef.element = mainActivity;
                if (mainActivity == 0) {
                    ?? currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity == 0) {
                        return null;
                    }
                    objectRef.element = currentActivity;
                }
                synchronized (this) {
                    if (this.i == null) {
                        int D = D() - BdUtilHelper.getDimens((Context) objectRef.element, R.dimen.M_H_X003);
                        T activity = objectRef.element;
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        final SpriteEdgeFloat spriteEdgeFloat = new SpriteEdgeFloat((Activity) activity, G(), 85, 0, D, false, l.e());
                        spriteEdgeFloat.l(new View.OnClickListener() { // from class: com.baidu.tieba.yca
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
                        G().c().a(new nfa(spriteEdgeFloat, this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2
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

                            @Override // com.baidu.tieba.nfa
                            public void a() {
                                mca G;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (HomeSpriteEdgeFloatManager.l.h()) {
                                        SpriteEdgeFloat spriteEdgeFloat2 = this.a;
                                        G = this.b.G();
                                        spriteEdgeFloat2.k(G.g());
                                        return;
                                    }
                                    final SpriteEdgeFloat spriteEdgeFloat3 = this.a;
                                    final HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.b;
                                    spriteEdgeFloat3.m(new Function0<Unit>(spriteEdgeFloat3, homeSpriteEdgeFloatManager) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2$doAction$1
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
                                            mca G2;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                this.$this_apply.m(null);
                                                SpriteEdgeFloat spriteEdgeFloat4 = this.$this_apply;
                                                G2 = this.this$0.G();
                                                spriteEdgeFloat4.k(G2.g());
                                            }
                                        }
                                    });
                                    oda B = this.b.B("day_stand", "dark_stand");
                                    B.a().c(false);
                                    this.a.o(B);
                                }
                            }
                        });
                        G().h().a(new b(this, spriteEdgeFloat));
                        G().d().a(new nfa(spriteEdgeFloat, this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$4
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

                            @Override // com.baidu.tieba.nfa
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (!HomeSpriteEdgeFloatManager.l.h()) {
                                        final SpriteEdgeFloat spriteEdgeFloat2 = this.a;
                                        final HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.b;
                                        spriteEdgeFloat2.m(new Function0<Unit>(spriteEdgeFloat2, homeSpriteEdgeFloatManager) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$4$doAction$1
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
                                                    Object[] objArr = {spriteEdgeFloat2, homeSpriteEdgeFloatManager};
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
                                                this.$this_apply = spriteEdgeFloat2;
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
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                    this.$this_apply.m(null);
                                                    this.this$0.P();
                                                }
                                            }
                                        });
                                        oda B = this.b.B("day_disappear", "dark_disappear");
                                        B.a().c(false);
                                        this.a.o(B);
                                        return;
                                    }
                                    this.b.P();
                                }
                            }
                        });
                        this.i = spriteEdgeFloat;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.i;
        }
        return (SpriteEdgeFloat) invokeV.objValue;
    }

    public final HomePageSpriteTipController H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g == null) {
                synchronized (this) {
                    if (this.g == null && I() != null) {
                        SpriteTipEdgeFloat I = I();
                        Intrinsics.checkNotNull(I);
                        this.g = new HomePageSpriteTipController(I.c());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.g;
        }
        return (HomePageSpriteTipController) invokeV.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpriteEdgeFloat F = F();
            if (F != null) {
                if (!F.i()) {
                    return;
                }
                F.h();
                fna.i.a().n(false);
            }
            SpriteTipEdgeFloat I = I();
            if (I != null) {
                I.e();
            }
            HomePageSpriteTipController H = H();
            if (H != null) {
                H.l(false);
            }
        }
    }

    public final void M(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            boolean z = true;
            if ((str == null || !StringsKt__StringsJVMKt.startsWith$default(str, "tiebaapp://router/portal", false, 2, null)) ? false : false) {
                xb7.c(context, str);
            }
        }
    }

    public final void W(ifa hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "精灵动画提示控件：触发首页精灵动画提示控件显示");
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            if (mainActivity == null) {
                mainActivity = BdActivityStack.getInst().currentActivity();
            }
            Activity curActivity = mainActivity;
            this.d = hotEventShowData.a();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (curActivity != null) {
                hotEventShowData.b().setShowCloseBtn(false);
                hotEventShowData.b().setUseRightBg(false);
                SpriteBottomTipView tipView = eg5.f(hotEventShowData.b(), curActivity, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds177);
                ViewGroup.LayoutParams layoutParams = tipView.getContentView().getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.width = BdUtilHelper.getEquipmentWidth(curActivity) - dimenPixelSize;
                }
                int D = D();
                Intrinsics.checkNotNullExpressionValue(curActivity, "curActivity");
                List e = l.e();
                Intrinsics.checkNotNullExpressionValue(tipView, "tipView");
                SpriteNotificationEdgeFloat spriteNotificationEdgeFloat = new SpriteNotificationEdgeFloat(curActivity, 85, dimenPixelSize, D, false, e, tipView);
                this.j = spriteNotificationEdgeFloat;
                if (spriteNotificationEdgeFloat != null) {
                    spriteNotificationEdgeFloat.f();
                }
                DefaultLog.getInstance().i("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示成功");
                eg5.o();
                eg5.q(hotEventShowData.b());
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.wca
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomeSpriteEdgeFloatManager.X(HomeSpriteEdgeFloatManager.this);
                        }
                    }
                }, 5000L);
                return;
            }
            DefaultLog.getInstance().e("SpriteEdgeFloat", "精灵动画提示控件：首页精灵动画提示控件显示失败");
            yt6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d = null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat onDestroy");
            m.$default$onDestroy(this, owner);
            MessageManager.getInstance().unRegisterListener(K());
            if (fna.i.a().h()) {
                N();
                HomePageSpriteTipController H = H();
                if (H != null) {
                    H.f();
                }
                this.g = null;
                SpriteTipEdgeFloat I = I();
                if (I != null) {
                    I.g();
                }
                this.h = null;
                SpriteEdgeFloat F = F();
                if (F != null) {
                    F.j();
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
        if (interceptable == null || interceptable.invokeL(1048603, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().i("SpriteEdgeFloat", "spriteEdgeFloat onResume");
            m.$default$onResume(this, owner);
            if (l.b()) {
                HomePageSpriteTipController H = H();
                if (H != null) {
                    H.h();
                }
                SpriteEdgeFloat F = F();
                boolean z = true;
                if ((F == null || !F.i()) ? false : false) {
                    hda.b();
                }
            }
        }
    }
}
