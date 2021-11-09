package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import b.a.r0.y1.c.i;
import b.a.r0.y1.c.k.q;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TaskViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f51524a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f51525b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewHolder(View view, BaseFragmentActivity baseFragmentActivity, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity, onClickListener};
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
        this.f51525b = onClickListener;
        this.f51524a = new i(view, baseFragmentActivity, onClickListener);
    }

    public void fillView(q qVar) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null || (iVar = this.f51524a) == null) {
            return;
        }
        iVar.a(qVar);
        this.f51524a.c();
    }

    public void setCommenClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f51525b = onClickListener;
        }
    }
}
