package com.baidu.tieba.videoplay.danmu;

import com.baidu.tieba.r86;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoDanmuController$renderer$2 extends Lambda implements Function0<r86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ VideoDanmuController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDanmuController$renderer$2(VideoDanmuController videoDanmuController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoDanmuController};
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
        this.this$0 = videoDanmuController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final r86 invoke() {
        InterceptResult invokeV;
        DefaultRenderer defaultRenderer;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (r86) invokeV.objValue;
        }
        defaultRenderer = this.this$0.A;
        return new r86(defaultRenderer, new Pair[0]);
    }
}
