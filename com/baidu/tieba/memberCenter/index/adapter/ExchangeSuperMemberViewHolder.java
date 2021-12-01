package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import c.a.r0.e2.c.f;
import c.a.r0.e2.c.k.k;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ExchangeSuperMemberViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExchangeSuperMemberViewHolder(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new f(view, baseFragmentActivity);
    }

    public void fillView(k kVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || kVar == null || (fVar = this.a) == null) {
            return;
        }
        fVar.f();
        this.a.c(kVar);
    }
}
