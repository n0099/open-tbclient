package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.MoreDeskView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yc5 extends ad5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc5(Context context, int i) {
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
        this.b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.d = i == -1 ? R.drawable.icon_pure_post_more24 : i;
        this.e = R.drawable.icon_mask_post_keyboard24_selection;
        this.i = false;
        this.j = true;
        this.m = new MoreDeskView(context);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc5(Context context, boolean z) {
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
        this.b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.d = R.drawable.icon_pure_post_more24;
        this.e = R.drawable.icon_mask_post_keyboard24_selection;
        this.i = false;
        this.j = true;
        this.m = new MoreDeskView(context, !z);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1};
    }
}
