package com.baidu.tieba.sprite.homepage;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.fna;
import com.baidu.tieba.hu6;
import com.baidu.tieba.ku6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.qz6;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController$checkListSetListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController$mainTabTipCloseListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController$splashCloseListener$2;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController$spriteShowListener$2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eR*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0018\u0010\rR\u001b\u0010\u001a\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001b\u0010\r¨\u0006\""}, d2 = {"Lcom/baidu/tieba/sprite/homepage/HomeSpriteShowController;", "", "owner", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "checkList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "checkListSetListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getCheckListSetListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "checkListSetListener$delegate", "Lkotlin/Lazy;", "easterEggAdHiddenEvent", "com/baidu/tieba/sprite/homepage/HomeSpriteShowController$easterEggAdHiddenEvent$1", "Lcom/baidu/tieba/sprite/homepage/HomeSpriteShowController$easterEggAdHiddenEvent$1;", "mainTabTipCloseListener", "getMainTabTipCloseListener", "mainTabTipCloseListener$delegate", "page", "splashCloseListener", "getSplashCloseListener", "splashCloseListener$delegate", "spriteShowListener", "getSpriteShowListener", "spriteShowListener$delegate", "checkStatusAndShow", "", "release", "unRegisterListener", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HomeSpriteShowController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final a d;
    public final Lazy e;
    public Lifecycle f;
    public HashMap<String, Boolean> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1395388985, "Lcom/baidu/tieba/sprite/homepage/HomeSpriteShowController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1395388985, "Lcom/baidu/tieba/sprite/homepage/HomeSpriteShowController;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a extends ku6<qz6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeSpriteShowController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomeSpriteShowController homeSpriteShowController, Class<qz6> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeSpriteShowController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homeSpriteShowController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ku6
        public void onEvent(qz6 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.b.c();
            }
        }
    }

    public HomeSpriteShowController(Lifecycle owner) {
        Lifecycle lifecycle;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {owner};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteShowController$splashCloseListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteShowController$splashCloseListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomeSpriteShowController this$0;

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

            /* loaded from: classes8.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteShowController a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteShowController homeSpriteShowController) {
                    super(2921736);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homeSpriteShowController};
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
                    this.a = homeSpriteShowController;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    HashMap hashMap;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921736) {
                        hashMap = this.a.g;
                        hashMap.put("statusSplash", Boolean.TRUE);
                        this.a.c();
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
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteShowController$mainTabTipCloseListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteShowController$mainTabTipCloseListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomeSpriteShowController this$0;

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

            /* loaded from: classes8.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteShowController a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteShowController homeSpriteShowController) {
                    super(2921802);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homeSpriteShowController};
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
                    this.a = homeSpriteShowController;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    HashMap hashMap;
                    Interceptable interceptable = $ic;
                    if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921802 || !(customResponsedMessage.getData() instanceof String)) {
                        return;
                    }
                    hashMap = this.a.g;
                    Object data = customResponsedMessage.getData();
                    if (data != null) {
                        hashMap.put((String) data, Boolean.TRUE);
                        this.a.c();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteShowController$spriteShowListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteShowController$spriteShowListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomeSpriteShowController this$0;

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

            /* loaded from: classes8.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteShowController a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteShowController homeSpriteShowController) {
                    super(2921797);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homeSpriteShowController};
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
                    this.a = homeSpriteShowController;
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
                            HomeSpriteShowController homeSpriteShowController = this.a;
                            if (num.intValue() == 1) {
                                HomeSpriteEdgeFloatManager.l.f(false);
                                homeSpriteShowController.c();
                                return;
                            }
                            HomeSpriteEdgeFloatManager.l.c().N();
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
        this.d = new a(this, qz6.class);
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HomeSpriteShowController$checkListSetListener$2.a>(this) { // from class: com.baidu.tieba.sprite.homepage.HomeSpriteShowController$checkListSetListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomeSpriteShowController this$0;

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

            /* loaded from: classes8.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeSpriteShowController a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomeSpriteShowController homeSpriteShowController) {
                    super(2921809);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homeSpriteShowController};
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
                    this.a = homeSpriteShowController;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    HashMap hashMap;
                    Interceptable interceptable = $ic;
                    if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921809 || !(customResponsedMessage.getData() instanceof String)) {
                        return;
                    }
                    hashMap = this.a.g;
                    Object data = customResponsedMessage.getData();
                    if (data != null) {
                        hashMap.put((String) data, Boolean.FALSE);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
        this.f = owner;
        this.g = new HashMap<>();
        if (fna.i.a().g()) {
            if (HomeSpriteEdgeFloatManager.l.b() && (lifecycle = this.f) != null) {
                lifecycle.addObserver(HomeSpriteEdgeFloatManager.l.c());
            }
            fna.i.a().m(false);
            return;
        }
        if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            this.g.put("statusSplash", Boolean.FALSE);
        }
        this.g.put("source_from_theme", Boolean.FALSE);
        MessageManager.getInstance().registerListener(i());
        MessageManager.getInstance().registerListener(h());
        MessageManager.getInstance().registerListener(j());
        hu6.b().a(this, this.d);
        MessageManager.getInstance().registerListener(g());
    }

    public static final void d(HomeSpriteShowController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Lifecycle lifecycle = this$0.f;
            if (lifecycle != null) {
                lifecycle.addObserver(HomeSpriteEdgeFloatManager.l.c());
            }
            this$0.k();
        }
    }

    public static final void e(HomeSpriteShowController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Lifecycle lifecycle = this$0.f;
            if (lifecycle != null) {
                lifecycle.addObserver(HomeSpriteEdgeFloatManager.l.c());
            }
            this$0.f = null;
        }
    }

    public static final void f(HomeSpriteShowController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.l();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Map.Entry<String, Boolean> entry : this.g.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("HomeSpriteShow", "当前状态不可用展示精灵：" + this.g);
                    return;
                }
            }
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.i("HomeSpriteShow", "开始展示首页小精灵:" + HomeSpriteEdgeFloatManager.l.b());
            if (HomeSpriteEdgeFloatManager.l.b()) {
                if (!HomeSpriteEdgeFloatManager.l.h() && HomeSpriteEdgeFloatManager.l.g()) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ada
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                HomeSpriteShowController.e(HomeSpriteShowController.this);
                            }
                        }
                    }, 3000L);
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.xca
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                HomeSpriteShowController.f(HomeSpriteShowController.this);
                            }
                        }
                    });
                    return;
                }
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.zca
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomeSpriteShowController.d(HomeSpriteShowController.this);
                        }
                    }
                });
            }
        }
    }

    public final CustomMessageListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (CustomMessageListener) this.e.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final CustomMessageListener h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (CustomMessageListener) this.b.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final CustomMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (CustomMessageListener) this.a.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final CustomMessageListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (CustomMessageListener) this.c.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = null;
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(i());
            MessageManager.getInstance().unRegisterListener(h());
            MessageManager.getInstance().unRegisterListener(j());
            hu6.b().unregister(this);
            MessageManager.getInstance().unRegisterListener(g());
        }
    }
}
