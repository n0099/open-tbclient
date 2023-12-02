package com.baidu.tieba;

import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.template.PersonalImageMsgTemplate;
import com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class za9 implements ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kq8 a;
    public final hd9 b;
    public final BehaviorExt c;

    public za9(kq8 processor, hd9 sendTransfer, BehaviorExt behaviorExt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {processor, sendTransfer, behaviorExt};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(sendTransfer, "sendTransfer");
        Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
        this.a = processor;
        this.b = sendTransfer;
        this.c = behaviorExt;
    }

    @Override // com.baidu.tieba.ib7
    public List<qb7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PersonalTextMsgTemplate("text_left", this.b, this.a, this.c));
            arrayList.add(new PersonalTextMsgTemplate("text_right", this.b, this.a, this.c));
            arrayList.add(new rd9("loading_left"));
            arrayList.add(new sd9("voice_left"));
            arrayList.add(new PersonalImageMsgTemplate("image_left"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
