package com.baidu.tieba.write.write.work.videoview;

import b.a.e.f.p.l;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class WorkPublishVideoView$MAX_VIDEO_HEIGHT$2 extends Lambda implements Function0<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WorkPublishVideoView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(WorkPublishVideoView workPublishVideoView) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {workPublishVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = workPublishVideoView;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX DEBUG: Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [int, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Integer] */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l.g(this.this$0.getContext(), R.dimen.tbds866) : invokeV.intValue;
    }
}
