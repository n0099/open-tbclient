package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qk7 extends y25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk7(Context context) {
        super(context, context.getString(R.string.obfuscated_res_0x7f0f053e), 12);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = R.drawable.obfuscated_res_0x7f080997;
        this.h = R.drawable.icon_pure_post_more_bubble64;
        this.e = R.drawable.obfuscated_res_0x7f080804;
        this.r = R.drawable.obfuscated_res_0x7f080993;
        this.i = false;
        this.j = true;
        this.o = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.m = commonTabHost;
        commonTabHost.h(new pk7());
        this.n = 6;
        this.p = new int[]{1};
    }
}
