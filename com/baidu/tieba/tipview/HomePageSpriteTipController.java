package com.baidu.tieba.tipview;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteColdStartRequestSwitch;
import com.baidu.tieba.dha;
import com.baidu.tieba.hfa;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.o7a;
import com.baidu.tieba.pc5;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.sr6;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2;
import com.baidu.tieba.um5;
import com.baidu.tieba.via;
import com.baidu.tieba.vr6;
import com.baidu.tieba.yw6;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "(Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;)V", "easterEggAdHiddenEvent", "com/baidu/tieba/tipview/HomePageSpriteTipController$easterEggAdHiddenEvent$1", "Lcom/baidu/tieba/tipview/HomePageSpriteTipController$easterEggAdHiddenEvent$1;", "httpListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "getHttpListener", "()Lcom/baidu/adp/framework/listener/HttpMessageListener;", "httpListener$delegate", "Lkotlin/Lazy;", "isActivityResumed", "", "isFirstStartup", "onCreateTime", "", "shouldShowTips", "getShouldShowTips", "()Z", "setShouldShowTips", "(Z)V", "getIntervalTime", "onCreate", "", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "processShowSpriteTip", "responsedMessage", "Lcom/baidu/adp/framework/message/HttpResponsedMessage;", "requestTip", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HomePageSpriteTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public long c;
    public boolean d;
    public final Lazy e;
    public final a f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1647993676, "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1647993676, "Lcom/baidu/tieba/tipview/HomePageSpriteTipController;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a extends vr6<yw6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageSpriteTipController b;
        public final /* synthetic */ HomePageSpriteBottomTipView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageSpriteTipController homePageSpriteTipController, HomePageSpriteBottomTipView homePageSpriteBottomTipView, Class<yw6> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageSpriteTipController, homePageSpriteBottomTipView, cls};
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
            this.b = homePageSpriteTipController;
            this.c = homePageSpriteBottomTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(yw6 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                SpriteTipHttpResponseMessage b = o7a.b.a().b();
                if (b != null) {
                    this.b.j(b, this.c);
                    o7a.b.a().a();
                }
            }
        }
    }

    public HomePageSpriteTipController(final HomePageSpriteBottomTipView spriteTipView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteTipView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(spriteTipView, "spriteTipView");
        this.b = true;
        this.d = true;
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HomePageSpriteTipController$httpListener$2.a>(this, spriteTipView) { // from class: com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HomePageSpriteBottomTipView $spriteTipView;
            public final /* synthetic */ HomePageSpriteTipController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, spriteTipView};
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
                this.$spriteTipView = spriteTipView;
            }

            /* loaded from: classes8.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomePageSpriteTipController a;
                public final /* synthetic */ HomePageSpriteBottomTipView b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomePageSpriteTipController homePageSpriteTipController, HomePageSpriteBottomTipView homePageSpriteBottomTipView) {
                    super(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homePageSpriteTipController, homePageSpriteBottomTipView};
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
                    this.a = homePageSpriteTipController;
                    this.b = homePageSpriteBottomTipView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003562) {
                        this.a.j(httpResponsedMessage, this.b);
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
                    return new a(this.this$0, this.$spriteTipView);
                }
                return (a) invokeV.objValue;
            }
        });
        this.f = new a(this, spriteTipView, yw6.class);
    }

    public static final void e(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.a) {
                um5.i(4);
            }
        }
    }

    public static final void i(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.a) {
                this$0.k();
            }
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.d = z;
        }
    }

    public final HttpMessageListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (HttpMessageListener) this.e.getValue();
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Integer b;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pc5 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
            if (funnySpriteConfig != null && (b = funnySpriteConfig.b()) != null && (intValue = b.intValue()) > 0) {
                return intValue * 1000;
            }
            return AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        }
        return invokeV.longValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(b());
            sr6.b().unregister(this);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.b = false;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                Class.forName("com.baidu.tieba.homepage.framework.RecommendFrsStatic");
            } catch (Exception e) {
                BdLog.i(e.getMessage());
            }
            MessageManager.getInstance().registerListener(b());
            if (FunnySpriteColdStartRequestSwitch.isOn() && !TbSingleton.getInstance().isShowSpriteDialog) {
                long j = 3000;
                if (HomeSpriteEdgeFloatManager.l.h()) {
                    j = TbSingleton.getInstance().getSkipDelayTime();
                }
                if (!HomeSpriteEdgeFloatManager.l.g()) {
                    j = 0;
                }
                DefaultLog.getInstance().i("SpriteTip", "精灵轻互动首次请求延迟 " + j);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.sia
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomePageSpriteTipController.e(HomePageSpriteTipController.this);
                        }
                    }
                }, j);
            }
            this.c = System.currentTimeMillis();
            sr6.b().a(this, this.f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !um5.m() && via.f.a() > 0 && System.currentTimeMillis() - via.f.a() > c()) {
            if (!this.b && FunnySpriteColdStartRequestSwitch.isOn() && !dha.h.a().d()) {
                um5.i(4);
                return;
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("SpriteTip", "requestTip canShowSpriteTip:" + this.a);
            um5.i(5);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = true;
            long j = 3000;
            if (System.currentTimeMillis() - this.c < 3000) {
                DefaultLog.getInstance().i("SpriteTip", "刚刚启动小精灵，延迟请求");
            } else {
                j = 1000;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.uia
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HomePageSpriteTipController.i(HomePageSpriteTipController.this);
                    }
                }
            }, j);
        }
    }

    public final void j(HttpResponsedMessage httpResponsedMessage, HomePageSpriteBottomTipView homePageSpriteBottomTipView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpResponsedMessage, homePageSpriteBottomTipView) == null) {
            if ((2 == dha.h.a().b().a().c && 1 == dha.h.a().b().b().c && 6 == dha.h.a().b().c().c) || !this.d) {
                return;
            }
            if (httpResponsedMessage instanceof SpriteTipHttpResponseMessage) {
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = (SpriteTipHttpResponseMessage) httpResponsedMessage;
                if (spriteTipHttpResponseMessage.isSuccess()) {
                    Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                    Intrinsics.checkNotNullExpressionValue(mainActivity, "getInst().mainActivity");
                    if ((mainActivity instanceof hfa) && this.a) {
                        HomeSpriteEdgeFloatManager.l.c().B(mainActivity, spriteTipHttpResponseMessage, homePageSpriteBottomTipView);
                        return;
                    }
                    return;
                }
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("SpriteTip", "not show Tip responseMessage:" + httpResponsedMessage + " isActivityResumed:" + this.a);
        }
    }
}
