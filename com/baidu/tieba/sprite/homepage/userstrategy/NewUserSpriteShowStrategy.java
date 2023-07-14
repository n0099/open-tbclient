package com.baidu.tieba.sprite.homepage.userstrategy;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a8a;
import com.baidu.tieba.k8a;
import com.baidu.tieba.oaa;
import com.baidu.tieba.r7a;
import com.baidu.tieba.sprite.edgefloat.SpriteEdgeFloat;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.waa;
import com.baidu.tieba.xaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/sprite/homepage/userstrategy/NewUserSpriteShowStrategy;", "Lcom/baidu/tieba/sprite/homepage/userstrategy/ISpriteShowStrategy;", "()V", "dispatchSpriteNotification", "", "hotEventShowData", "Lcom/baidu/tieba/statemachine/animationtip/message/HotEventShowData;", "dispatchSpriteTip", "context", "Landroid/app/Activity;", "response", "Lcom/baidu/tieba/sprite/funnysprite/data/SpriteTipHttpResponseMessage;", "spriteTipView", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "hide", "isSpriteEnable", "", "onFragmentCreate", "onSpriteOnceAppear", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function0;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NewUserSpriteShowStrategy implements k8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends waa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r7a b;
        public final /* synthetic */ Function0<Unit> c;

        public a(r7a r7aVar, Function0<Unit> function0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar, function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r7aVar;
            this.c = function0;
        }

        @Override // com.baidu.tieba.waa
        public void b(xaa state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, state) == null) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state instanceof a8a) {
                    this.b.e(this);
                    this.c.invoke();
                }
            }
        }
    }

    public NewUserSpriteShowStrategy() {
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

    @Override // com.baidu.tieba.k8a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return HomeSpriteEdgeFloatManager.l.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k8a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HomeSpriteEdgeFloatManager.l.c().a0();
        }
    }

    @Override // com.baidu.tieba.k8a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HomeSpriteEdgeFloatManager.l.c().T();
        }
    }

    @Override // com.baidu.tieba.k8a
    public void b(oaa hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            e(new NewUserSpriteShowStrategy$dispatchSpriteNotification$1(hotEventShowData));
            HomeSpriteEdgeFloatManager.l.c().W();
        }
    }

    public final void e(Function0<Unit> function0) {
        SpriteEdgeFloat E;
        r7a e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, function0) == null) && (E = HomeSpriteEdgeFloatManager.l.c().E()) != null && (e = E.e()) != null) {
            e.a(new a(e, function0));
        }
    }

    @Override // com.baidu.tieba.k8a
    public void c(Activity context, SpriteTipHttpResponseMessage response, HomePageSpriteBottomTipView spriteTipView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, response, spriteTipView) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(spriteTipView, "spriteTipView");
            e(new NewUserSpriteShowStrategy$dispatchSpriteTip$1(context, response, spriteTipView));
            HomeSpriteEdgeFloatManager.l.c().W();
        }
    }
}
