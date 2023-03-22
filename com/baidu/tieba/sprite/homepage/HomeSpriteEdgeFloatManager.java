package com.baidu.tieba.sprite.homepage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.fs6;
import com.baidu.tieba.hi;
import com.baidu.tieba.i89;
import com.baidu.tieba.jg;
import com.baidu.tieba.k;
import com.baidu.tieba.k89;
import com.baidu.tieba.l89;
import com.baidu.tieba.m89;
import com.baidu.tieba.q89;
import com.baidu.tieba.rh6;
import com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat;
import com.baidu.tieba.sprite.edgefloat.SpriteTipEdgeFloat;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$splashCloseListener$2;
import com.baidu.tieba.sprite.resdownload.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.tips.SpriteBottomTipView;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.uf5;
import com.baidu.tieba.uo5;
import com.baidu.tieba.w58;
import com.baidu.tieba.w8;
import com.baidu.tieba.y79;
import com.baidu.tieba.z58;
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
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0018H\u0002J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u00103\u001a\u00020/J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020/H\u0002J\u0006\u0010>\u001a\u00020/J\u0006\u0010?\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/baidu/tieba/sprite/homepage/HomeSpriteEdgeFloatManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "isSplashClose", "", "normalMainTabBarHeight", "", "getNormalMainTabBarHeight", "()I", "normalMainTabBarHeight$delegate", "Lkotlin/Lazy;", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "splashCloseListener", "getSplashCloseListener", "splashCloseListener$delegate", "spriteEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "getSpriteEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteEdgeFloat;", "spriteJumpScheme", "", "getSpriteJumpScheme", "()Ljava/lang/String;", "setSpriteJumpScheme", "(Ljava/lang/String;)V", "spriteStateMap", "Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "getSpriteStateMap", "()Lcom/baidu/tieba/sprite/funnysprite/StateMap;", "spriteStateMap$delegate", "spriteTipController", "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "getSpriteTipController", "()Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "spriteTipEdgeFloat", "Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "getSpriteTipEdgeFloat", "()Lcom/baidu/tieba/sprite/edgefloat/SpriteTipEdgeFloat;", "generateDataByState", "Lcom/baidu/tieba/sprite/view/NormalSpriteData;", "dayResName", "darkResName", "gotoScheme", "", "context", "Landroid/content/Context;", "scheme", "hide", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "sendEvent", "event", "Lcom/baidu/tieba/sprite/statemachine/Event;", "sendStandEvent", "show", "spriteDialogHide", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeSpriteEdgeFloatManager implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public static final Lazy<HomeSpriteEdgeFloatManager> k;
    public static final Lazy<List<String>> l;
    public static final z58 m;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public HomePageSpriteTipController g;
    public SpriteTipEdgeFloat h;
    public SpriteEdgeFloat i;

    public /* synthetic */ HomeSpriteEdgeFloatManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final HomeSpriteEdgeFloatManager l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? j.c() : (HomeSpriteEdgeFloatManager) invokeV.objValue;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        k.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        k.$default$onStop(this, lifecycleOwner);
    }

    /* loaded from: classes6.dex */
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

        public final List<String> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (List) HomeSpriteEdgeFloatManager.l.getValue();
            }
            return (List) invokeV.objValue;
        }

        @JvmStatic
        public final boolean b() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (FunnySpriteSwitch.Companion.isOn() && FunnySpriteResDownloadUtil.i().invoke().booleanValue() && HomeSpriteEdgeFloatManager.m.f()) {
                    z = true;
                } else {
                    z = false;
                }
                w58 defaultLog = DefaultLog.getInstance();
                defaultLog.c("SpriteEdgeFloat", "spriteEdgeFloat canShowSpriteAndTip " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements i89 {
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

        @Override // com.baidu.tieba.i89
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            q89 k = this.a.k("day_normal", "dark_normal");
            k.a().c(true);
            this.b.m(k);
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
        m = new z58("key_sprite_dialog_disappear");
    }

    public final void C() {
        SpriteEdgeFloat q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (q = q()) != null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() is Showing???");
            if (!q.h()) {
                return;
            }
            MessageManager.getInstance().unRegisterListener(n());
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat hide() internal hide");
            q.g();
        }
    }

    public final HomePageSpriteTipController x() {
        InterceptResult invokeV;
        SpriteBottomTipView spriteBottomTipView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.g == null) {
                synchronized (this) {
                    if (this.g == null) {
                        SpriteTipEdgeFloat A = A();
                        if (A != null) {
                            spriteBottomTipView = A.c();
                        } else {
                            spriteBottomTipView = null;
                        }
                        this.g = new HomePageSpriteTipController(spriteBottomTipView);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.g;
        }
        return (HomePageSpriteTipController) invokeV.objValue;
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
        this.a = uf5.a("sprite_talk_default", 0);
        this.c = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$normalMainTabBarHeight$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(HomeSpriteEdgeFloatManager$spriteStateMap$2.INSTANCE);
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteEdgeFloatManager$splashCloseListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$splashCloseListener$2
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

            /* loaded from: classes6.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteEdgeFloatManager a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager) {
                    super(2921736);
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

                public static final void a(HomeSpriteEdgeFloatManager this$0) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.F();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921736) {
                        return;
                    }
                    this.a.b = true;
                    jg a = jg.a();
                    final HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                    a.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: INVOKE  
                          (r5v3 'a' com.baidu.tieba.jg)
                          (wrap: java.lang.Runnable : 0x001e: CONSTRUCTOR  (r1v0 java.lang.Runnable A[REMOVE]) = (r0v4 'homeSpriteEdgeFloatManager' com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager A[DONT_INLINE]) call: com.baidu.tieba.g89.<init>(com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager):void type: CONSTRUCTOR)
                          (wrap: long : ?: SGET   androidx.appcompat.widget.TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS long)
                         type: VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean in method: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$splashCloseListener$2.a.onMessage(com.baidu.adp.framework.message.CustomResponsedMessage<?>):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.baidu.tieba.g89, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 19 more
                        */
                    /*
                        this = this;
                        com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$splashCloseListener$2.a.$ic
                        if (r0 != 0) goto L27
                    L4:
                        if (r5 == 0) goto L26
                        int r5 = r5.getCmd()
                        r0 = 2921736(0x2c9508, float:4.094224E-39)
                        if (r5 == r0) goto L10
                        goto L26
                    L10:
                        com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager r5 = r4.a
                        r0 = 1
                        com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager.j(r5, r0)
                        com.baidu.tieba.jg r5 = com.baidu.tieba.jg.a()
                        com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager r0 = r4.a
                        com.baidu.tieba.g89 r1 = new com.baidu.tieba.g89
                        r1.<init>(r0)
                        r2 = 2500(0x9c4, double:1.235E-320)
                        r5.postDelayed(r1, r2)
                    L26:
                        return
                    L27:
                        r2 = r0
                        r3 = 1048576(0x100000, float:1.469368E-39)
                        com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                        if (r0 == 0) goto L4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$splashCloseListener$2.a.onMessage(com.baidu.adp.framework.message.CustomResponsedMessage):void");
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
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteEdgeFloatManager$skinChangeListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$skinChangeListener$2
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

            /* loaded from: classes6.dex */
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
                    r5 = r4.a.q();
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SpriteEdgeFloat q;
                    y79 u;
                    y79 u2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && q != null) {
                        HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.a;
                        l89 c = q.c();
                        u = homeSpriteEdgeFloatManager.u();
                        if (Intrinsics.areEqual(c, u.f())) {
                            q89 k = homeSpriteEdgeFloatManager.k("day_stand", "dark_stand");
                            k.a().c(false);
                            q.m(k);
                            return;
                        }
                        u2 = homeSpriteEdgeFloatManager.u();
                        if (!Intrinsics.areEqual(c, u2.d())) {
                            return;
                        }
                        q89 k2 = homeSpriteEdgeFloatManager.k("day_normal", "dark_normal");
                        k2.a().c(true);
                        q.m(k2);
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

    public final SpriteTipEdgeFloat A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                Activity b2 = w8.f().b();
                if (b2 == null) {
                    return null;
                }
                synchronized (this) {
                    if (this.h == null) {
                        this.h = new SpriteTipEdgeFloat(b2, 85, hi.g(b2, R.dimen.M_W_X021), m(), false, j.d());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.h;
        }
        return (SpriteTipEdgeFloat) invokeV.objValue;
    }

    public final void F() {
        SpriteEdgeFloat q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && j.b() && (q = q()) != null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show is not Showing???");
            if (q.h()) {
                return;
            }
            MessageManager.getInstance().registerListener(n());
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat show internal show");
            q.l();
            m89.b();
            E();
            HomePageSpriteTipController x = x();
            if (x != null) {
                x.d();
            }
        }
    }

    public static final void a(HomeSpriteEdgeFloatManager this$0, Activity activity, View view2) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, activity, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (uo5.a()) {
                return;
            }
            SpriteTipEdgeFloat A = this$0.A();
            String str = null;
            if (A != null) {
                bool = Boolean.valueOf(A.d());
            } else {
                bool = null;
            }
            m89.a(Intrinsics.areEqual(bool, Boolean.TRUE));
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                SpriteTipEdgeFloat A2 = this$0.A();
                if (A2 != null) {
                    str = A2.e();
                }
                this$0.B(activity, str);
                return;
            }
            this$0.B(activity, this$0.a);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat sendStandEvent");
            D(u().e());
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat dialog displayed");
            m.i();
        }
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ((Number) this.c.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final CustomMessageListener n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (CustomMessageListener) this.f.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final CustomMessageListener o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (CustomMessageListener) this.e.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final y79 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return (y79) this.d.getValue();
        }
        return (y79) invokeV.objValue;
    }

    public final void D(k89 k89Var) {
        SpriteEdgeFloat q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, k89Var) == null) && (q = q()) != null) {
            q.i(k89Var);
        }
    }

    public final void B(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            boolean z = true;
            if ((str == null || !StringsKt__StringsJVMKt.startsWith$default(str, "tiebaapp://router/portal", false, 2, null)) ? false : false) {
                fs6.a(context, str);
            }
        }
    }

    public final q89 k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            rh6 rh6Var = new rh6();
            q89 q89Var = new q89(rh6Var);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = str2;
            }
            rh6Var.d(FunnySpriteResDownloadUtil.h(str));
            if (StringsKt__StringsJVMKt.endsWith$default(rh6Var.a(), DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, false, 2, null)) {
                rh6Var.e(1);
            } else if (StringsKt__StringsJVMKt.endsWith$default(rh6Var.a(), ".webp", false, 2, null)) {
                rh6Var.e(2);
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new IllegalStateException("unsupported file path " + rh6Var.a());
            }
            return q89Var;
        }
        return (q89) invokeLL.objValue;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onCreate");
            k.$default$onCreate(this, owner);
            MessageManager.getInstance().registerListener(o());
            if (this.b) {
                F();
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        HomePageSpriteTipController x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onPause");
            k.$default$onPause(this, owner);
            if (j.b() && (x = x()) != null) {
                x.g();
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLog.getInstance().c("SpriteEdgeFloat", "spriteEdgeFloat onDestroy");
            k.$default$onDestroy(this, owner);
            MessageManager.getInstance().unRegisterListener(o());
            if (j.b()) {
                C();
                HomePageSpriteTipController x = x();
                if (x != null) {
                    x.f();
                }
                this.g = null;
                SpriteTipEdgeFloat A = A();
                if (A != null) {
                    A.f();
                }
                this.h = null;
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
                HomePageSpriteTipController x = x();
                if (x != null) {
                    x.h();
                }
                SpriteEdgeFloat q = q();
                boolean z = true;
                if ((q == null || !q.h()) ? false : false) {
                    m89.b();
                }
            }
        }
    }

    public final SpriteEdgeFloat q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.i == null) {
                final Activity b2 = w8.f().b();
                if (b2 == null) {
                    return null;
                }
                synchronized (this) {
                    if (this.i == null) {
                        final SpriteEdgeFloat spriteEdgeFloat = new SpriteEdgeFloat(b2, u(), 85, 0, m() - hi.g(b2, R.dimen.M_H_X003), false, j.d());
                        spriteEdgeFloat.j(new View.OnClickListener() { // from class: com.baidu.tieba.f89
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    HomeSpriteEdgeFloatManager.a(HomeSpriteEdgeFloatManager.this, b2, view2);
                                }
                            }
                        });
                        u().f().a(new i89(spriteEdgeFloat, this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2
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

                            @Override // com.baidu.tieba.i89
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    final SpriteEdgeFloat spriteEdgeFloat2 = this.a;
                                    final HomeSpriteEdgeFloatManager homeSpriteEdgeFloatManager = this.b;
                                    spriteEdgeFloat2.k(new Function0<Unit>(spriteEdgeFloat2, homeSpriteEdgeFloatManager) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager$spriteEdgeFloat$1$1$2$doAction$1
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
                                            y79 u;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                this.$this_apply.k(null);
                                                SpriteEdgeFloat spriteEdgeFloat3 = this.$this_apply;
                                                u = this.this$0.u();
                                                spriteEdgeFloat3.i(u.c());
                                            }
                                        }
                                    });
                                    q89 k2 = this.b.k("day_stand", "dark_stand");
                                    k2.a().c(false);
                                    this.a.m(k2);
                                }
                            }
                        });
                        u().d().a(new b(this, spriteEdgeFloat));
                        this.i = spriteEdgeFloat;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.i;
        }
        return (SpriteEdgeFloat) invokeV.objValue;
    }
}
