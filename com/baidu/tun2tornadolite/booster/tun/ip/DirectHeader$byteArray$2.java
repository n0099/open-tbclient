package com.baidu.tun2tornadolite.booster.tun.ip;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "index", "", "value", "", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class DirectHeader$byteArray$2 extends Lambda implements Function2<Integer, List<? extends Byte>, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DirectHeader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectHeader$byteArray$2(DirectHeader directHeader) {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {directHeader};
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
        this.this$0 = directHeader;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Byte> list) {
        invoke(num.intValue(), (List<Byte>) list);
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, List<Byte> value) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, value) != null) {
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size() - 1;
        if (size < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            this.this$0.getBuffer()[i2 + i3] = value.get(i3).byteValue();
            if (i4 > size) {
                return;
            }
            i3 = i4;
        }
    }
}
