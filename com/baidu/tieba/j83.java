package com.baidu.tieba;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.tieba.k83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j83 extends k83.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j83(Context context) {
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
        this.f = context;
    }

    @Override // com.baidu.tieba.k83.a
    public k83 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.e = this.f.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
            layoutParams.addRule(12);
            this.a.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fa));
            layoutParams2.addRule(2, this.a.t.getId());
            this.a.h.setLayoutParams(layoutParams2);
            o(R.color.obfuscated_res_0x7f0603fd);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(2, this.a.h.getId());
            this.a.u.setLayoutParams(layoutParams3);
            return super.c();
        }
        return (k83) invokeV.objValue;
    }
}
