package com.baidu.tieba.tipview;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SpriteTipHttpResponseMessage;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteColdStartRequestSwitch;
import com.baidu.tieba.bj5;
import com.baidu.tieba.fx9;
import com.baidu.tieba.ga5;
import com.baidu.tieba.iv9;
import com.baidu.tieba.sg;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.sy9;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2;
import com.baidu.tieba.u25;
import com.baidu.tieba.zk8;
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
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "(Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;)V", "httpListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "getHttpListener", "()Lcom/baidu/adp/framework/listener/HttpMessageListener;", "httpListener$delegate", "Lkotlin/Lazy;", "isActivityResumed", "", "onCreateTime", "", "getIntervalTime", "onCreate", "", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "requestTip", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HomePageSpriteTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public final Lazy c;

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
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<HomePageSpriteTipController$httpListener$2.a>(this, spriteTipView) { // from class: com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2
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

            /* loaded from: classes7.dex */
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
                    boolean z;
                    boolean z2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003562) {
                        if (2 == fx9.d.a().b().a().c && 1 == fx9.d.a().b().b().c && 6 == fx9.d.a().b().c().c) {
                            return;
                        }
                        if (httpResponsedMessage instanceof SpriteTipHttpResponseMessage) {
                            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = (SpriteTipHttpResponseMessage) httpResponsedMessage;
                            if (spriteTipHttpResponseMessage.isSuccess()) {
                                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                                Intrinsics.checkNotNullExpressionValue(mainActivity, "getInst().mainActivity");
                                if (mainActivity instanceof iv9) {
                                    z2 = this.a.a;
                                    if (z2) {
                                        u25.g(CollectionsKt__CollectionsJVMKt.listOf(new sy9(mainActivity, spriteTipHttpResponseMessage, this.b)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        zk8 defaultLog = DefaultLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("not show Tip responseMessage:");
                        sb.append(httpResponsedMessage);
                        sb.append(" isActivityResumed:");
                        z = this.a.a;
                        sb.append(z);
                        defaultLog.b("SpriteTip", sb.toString());
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
    }

    public static final void e(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.a) {
                bj5.f(4);
            }
        }
    }

    public static final void i(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.a) {
                this$0.j();
            }
        }
    }

    public final HttpMessageListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (HttpMessageListener) this.c.getValue();
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Integer b;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ga5 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
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
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
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
                if (HomeSpriteEdgeFloatManager.j.g()) {
                    j = TbSingleton.getInstance().getSkipDelayTime();
                }
                DefaultLog.getInstance().c("SpriteTip", "精灵轻互动首次请求延迟 " + j);
                sg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.py9
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
            this.b = System.currentTimeMillis();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = true;
            long j = 3000;
            if (System.currentTimeMillis() - this.b < 3000) {
                DefaultLog.getInstance().c("SpriteTip", "刚刚启动小精灵，延迟请求");
            } else {
                j = 1000;
            }
            sg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.ry9
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

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !bj5.h() && sy9.e.a() > 0 && System.currentTimeMillis() - sy9.e.a() > c()) {
            zk8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "requestTip canShowSpriteTip:" + this.a);
            bj5.f(5);
        }
    }
}
