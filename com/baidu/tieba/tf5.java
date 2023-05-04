package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.sendtool.SendNoLaunchView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tf5 extends ud5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tf5(Context context, boolean z) {
        super(context, (String) null, 38);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.o = true;
        this.n = 8;
        SendNoLaunchView sendNoLaunchView = new SendNoLaunchView(context);
        sendNoLaunchView.setIsFriend(z);
        this.m = sendNoLaunchView;
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
        ((View) this.m).setLayoutParams(layoutParams);
        this.p = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
    }
}
