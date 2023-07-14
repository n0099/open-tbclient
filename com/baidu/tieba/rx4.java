package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TBWebContainerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rx4 implements un6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TBWebContainerActivity a;

    @Override // com.baidu.tieba.un6
    public /* synthetic */ void b(int i, int i2, int i3, int i4) {
        tn6.b(this, i, i2, i3, i4);
    }

    @Override // com.baidu.tieba.un6
    public /* synthetic */ void d(int i, int i2, int i3, int i4) {
        tn6.a(this, i, i2, i3, i4);
    }

    public rx4(TBWebContainerActivity tBWebContainerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tBWebContainerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tBWebContainerActivity;
    }

    @Override // com.baidu.tieba.un6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            this.a.mView.t(i, i2, i3, i4);
        }
    }
}
