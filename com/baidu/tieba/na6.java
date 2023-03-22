package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TBWebContainerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class na6 implements od6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TBWebContainerActivity a;

    @Override // com.baidu.tieba.od6
    public /* synthetic */ void a(int i, int i2, int i3, int i4) {
        nd6.b(this, i, i2, i3, i4);
    }

    @Override // com.baidu.tieba.od6
    public /* synthetic */ void b(int i, int i2, int i3, int i4) {
        nd6.a(this, i, i2, i3, i4);
    }

    public na6(TBWebContainerActivity tBWebContainerActivity) {
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

    @Override // com.baidu.tieba.od6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        mt4 mt4Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) != null) {
            return;
        }
        mt4Var = this.a.mView;
        mt4Var.t(i, i2, i3, i4);
    }
}
