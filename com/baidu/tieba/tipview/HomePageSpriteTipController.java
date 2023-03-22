package com.baidu.tieba.tipview;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SpriteTipHttpResponseMessage;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.jg;
import com.baidu.tieba.m35;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.resdownload.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.tips.SpriteBottomTipView;
import com.baidu.tieba.tipview.HomePageSpriteTipController;
import com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2;
import com.baidu.tieba.uf5;
import com.baidu.tieba.w58;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/tipview/HomePageSpriteTipController;", "", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView;", "(Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView;)V", "httpListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "getHttpListener", "()Lcom/baidu/adp/framework/listener/HttpMessageListener;", "httpListener$delegate", "Lkotlin/Lazy;", "isActivityResumed", "", "lastShowTime", "", "startPollTipData", "Ljava/lang/Runnable;", "onCreate", "", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "requestTip", "scene", "", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomePageSpriteTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public final Lazy c;
    public final Runnable d;

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

    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageSpriteTipController a;

        public a(HomePageSpriteTipController homePageSpriteTipController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageSpriteTipController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageSpriteTipController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HomePageSpriteTipController.l(this.a, 0, 1, null);
                jg.a().postDelayed(this, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
        }
    }

    public HomePageSpriteTipController(final SpriteBottomTipView spriteBottomTipView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteBottomTipView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<HomePageSpriteTipController$httpListener$2.a>(this, spriteBottomTipView) { // from class: com.baidu.tieba.tipview.HomePageSpriteTipController$httpListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteBottomTipView $spriteTipView;
            public final /* synthetic */ HomePageSpriteTipController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, spriteBottomTipView};
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
                this.$spriteTipView = spriteBottomTipView;
            }

            /* loaded from: classes6.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomePageSpriteTipController a;
                public final /* synthetic */ SpriteBottomTipView b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(HomePageSpriteTipController homePageSpriteTipController, SpriteBottomTipView spriteBottomTipView) {
                    super(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {homePageSpriteTipController, spriteBottomTipView};
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
                    this.b = spriteBottomTipView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    boolean z;
                    boolean z2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003562) {
                        if (httpResponsedMessage instanceof SpriteTipHttpResponseMessage) {
                            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = (SpriteTipHttpResponseMessage) httpResponsedMessage;
                            if (spriteTipHttpResponseMessage.isSuccess() && spriteTipHttpResponseMessage.getScene() != 2) {
                                z2 = this.a.b;
                                if (z2 && HomeSpriteEdgeFloatManager.j.b()) {
                                    w58 defaultLog = DefaultLog.getInstance();
                                    defaultLog.c("SpriteTip", "show responseTip:" + spriteTipHttpResponseMessage.getText());
                                    this.a.a = System.currentTimeMillis();
                                    SpriteBottomTipView spriteBottomTipView = this.b;
                                    if (spriteBottomTipView != null) {
                                        spriteBottomTipView.setDataAndShow(spriteTipHttpResponseMessage);
                                    }
                                    String s = m35.m().s("key_sprite_speech_version", "");
                                    String version = spriteTipHttpResponseMessage.getVersion();
                                    if (!TextUtils.isEmpty(version) && !Intrinsics.areEqual(s, version)) {
                                        m35.m().B("key_sprite_speech_version", version);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        w58 defaultLog2 = DefaultLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("not show Tip isActivityResumed:");
                        z = this.a.b;
                        sb.append(z);
                        sb.append(" switch:");
                        sb.append(FunnySpriteSwitch.Companion.isOn());
                        sb.append(" isAllResExist:");
                        sb.append(FunnySpriteResDownloadUtil.i().invoke().booleanValue());
                        sb.append(" canShowSpriteAndTip:");
                        sb.append(HomeSpriteEdgeFloatManager.j.b());
                        defaultLog2.b("SpriteTip", sb.toString());
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
        this.d = new a(this);
    }

    public final void k(final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            w58 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "requestTip canShowSpriteTip:" + this.b);
            jg.a().post(new Runnable() { // from class: com.baidu.tieba.ti9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HomePageSpriteTipController.m(i);
                    }
                }
            });
        }
    }

    public static final void e(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.b) {
                this$0.k(4);
            }
        }
    }

    public static final void i(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.b) {
                uf5.c();
            }
        }
    }

    public static final void j(HomePageSpriteTipController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.b) {
                l(this$0, 0, 1, null);
            }
        }
    }

    public static final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i) == null) {
            if (TbSingleton.getInstance().isShowSpriteDialog) {
                uf5.b(3);
                TbSingleton.getInstance().isShowSpriteDialog = false;
                return;
            }
            uf5.b(i);
        }
    }

    public static /* synthetic */ void l(HomePageSpriteTipController homePageSpriteTipController, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        homePageSpriteTipController.k(i);
    }

    public final HttpMessageListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (HttpMessageListener) this.c.getValue();
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
            MessageManager.getInstance().unRegisterListener(c());
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = false;
            jg.a().removeCallbacks(this.d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                Class.forName("com.baidu.tieba.homepage.framework.RecommendFrsStatic");
            } catch (Exception e) {
                BdLog.i(e.getMessage());
            }
            MessageManager.getInstance().registerListener(c());
            if (!TbSingleton.getInstance().isShowSpriteDialog) {
                jg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.si9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomePageSpriteTipController.e(HomePageSpriteTipController.this);
                        }
                    }
                }, 3000L);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = true;
            jg.a().removeCallbacks(this.d);
            jg.a().postDelayed(this.d, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (TbSingleton.getInstance().isShowSpriteDialog) {
                jg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.vi9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomePageSpriteTipController.i(HomePageSpriteTipController.this);
                        }
                    }
                }, 3000L);
            } else if (this.a > 0 && System.currentTimeMillis() - this.a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                jg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.ui9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            HomePageSpriteTipController.j(HomePageSpriteTipController.this);
                        }
                    }
                }, 5000L);
            }
        }
    }
}
