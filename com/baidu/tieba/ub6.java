package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TBWebContainerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ub6 implements xe6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TBWebContainerActivity a;

    @Override // com.baidu.tieba.xe6
    public /* synthetic */ void a(int i, int i2, int i3, int i4) {
        we6.b(this, i, i2, i3, i4);
    }

    @Override // com.baidu.tieba.xe6
    public /* synthetic */ void b(int i, int i2, int i3, int i4) {
        we6.a(this, i, i2, i3, i4);
    }

    public ub6(TBWebContainerActivity tBWebContainerActivity) {
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

    @Override // com.baidu.tieba.xe6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        pt4 pt4Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) != null) {
            return;
        }
        pt4Var = this.a.mView;
        pt4Var.t(i, i2, i3, i4);
    }
}
