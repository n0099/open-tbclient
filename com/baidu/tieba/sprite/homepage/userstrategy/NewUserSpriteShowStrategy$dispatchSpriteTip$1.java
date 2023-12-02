package com.baidu.tieba.sprite.homepage.userstrategy;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.m3b;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.userstrategy.NewUserSpriteShowStrategy$dispatchSpriteTip$1;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.sq6;
import com.baidu.tieba.v05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NewUserSpriteShowStrategy$dispatchSpriteTip$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Activity $context;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ SpriteTipHttpResponseMessage $response;
    public final /* synthetic */ HomePageSpriteBottomTipView $spriteTipView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserSpriteShowStrategy$dispatchSpriteTip$1(Activity activity, SpriteTipHttpResponseMessage spriteTipHttpResponseMessage, HomePageSpriteBottomTipView homePageSpriteBottomTipView) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, spriteTipHttpResponseMessage, homePageSpriteBottomTipView};
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
        this.$context = activity;
        this.$response = spriteTipHttpResponseMessage;
        this.$spriteTipView = homePageSpriteBottomTipView;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m147invoke$lambda0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            HomeSpriteEdgeFloatManager.l.c().O();
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v05.g(CollectionsKt__CollectionsJVMKt.listOf(new m3b(this.$context, this.$response, this.$spriteTipView, new sq6.e() { // from class: com.baidu.tieba.xra
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.sq6.e
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NewUserSpriteShowStrategy$dispatchSpriteTip$1.m147invoke$lambda0();
                    }
                }
            })));
        }
    }
}
