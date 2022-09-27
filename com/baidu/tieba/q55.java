package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.MoreDeskView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q55 extends s55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q55(Context context, int i) {
        super(context, null, 2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b02);
        this.d = i == -1 ? R.drawable.obfuscated_res_0x7f0809c3 : i;
        this.e = R.drawable.obfuscated_res_0x7f08081e;
        this.i = false;
        this.j = true;
        this.m = new MoreDeskView(context);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q55(Context context, boolean z) {
        super(context, null, 2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b02);
        this.d = R.drawable.obfuscated_res_0x7f0809c3;
        this.e = R.drawable.obfuscated_res_0x7f08081e;
        this.i = false;
        this.j = true;
        this.m = new MoreDeskView(context, !z);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1};
    }
}
