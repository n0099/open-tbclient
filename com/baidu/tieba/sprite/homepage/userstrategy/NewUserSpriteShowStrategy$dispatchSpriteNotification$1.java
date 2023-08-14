package com.baidu.tieba.sprite.homepage.userstrategy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.i9a;
import com.baidu.tieba.lr6;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.homepage.userstrategy.NewUserSpriteShowStrategy$dispatchSpriteNotification$1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NewUserSpriteShowStrategy$dispatchSpriteNotification$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ i9a $hotEventShowData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserSpriteShowStrategy$dispatchSpriteNotification$1(i9a i9aVar) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i9aVar};
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
        this.$hotEventShowData = i9aVar;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m139invoke$lambda0(i9a hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "$hotEventShowData");
            HomeSpriteEdgeFloatManager.l.c().O();
            hotEventShowData.a().onDismiss();
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
            HotEventData b = this.$hotEventShowData.b();
            final i9a i9aVar = this.$hotEventShowData;
            HomeSpriteEdgeFloatManager.l.c().X(new i9a(b, new lr6.e() { // from class: com.baidu.tieba.e7a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lr6.e
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NewUserSpriteShowStrategy$dispatchSpriteNotification$1.m139invoke$lambda0(i9a.this);
                    }
                }
            }));
        }
    }
}
