package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.switchs.VideoCardLazyInitSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o17 extends yw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l98 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o17(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yw, com.baidu.tieba.my
    public l98 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.k) && this.k.equals("index") && VideoCardLazyInitSwitch.getIsOn()) {
                this.z = new q17(this.b, this.i);
            } else {
                this.z = new p17(this.b, this.i);
            }
            this.z.setStageType("2001");
            return this.z;
        }
        return (l98) invokeV.objValue;
    }
}
