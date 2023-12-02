package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j05 extends i05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView l;
    public TextView m;
    public View.OnClickListener n;
    public int o;
    public int p;

    @Override // com.baidu.tieba.i05
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j05(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = R.color.CAM_X0304;
        this.p = R.color.CAM_X0107;
        this.l = (TextView) e().findViewById(R.id.title_ok);
        this.m = (TextView) e().findViewById(R.id.title_cancel);
        i(true);
    }

    @Override // com.baidu.tieba.i05
    public void b(BdPageContext<?> bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdPageContext) == null) {
            super.b(bdPageContext);
            o();
        }
    }

    @Override // com.baidu.tieba.i05
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            j(i);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EMManager.from(this.l).setTextSelectorColor(this.o);
            EMManager.from(this.m).setTextSelectorColor(this.p);
        }
    }

    public j05 p(int i, View.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, onClickListener)) == null) {
            this.m.setText(i);
            this.m.setOnClickListener(onClickListener);
            this.m.setVisibility(0);
            return this;
        }
        return (j05) invokeIL.objValue;
    }

    public j05 q(int i, View.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, onClickListener)) == null) {
            this.l.setText(i);
            this.l.setOnClickListener(onClickListener);
            this.l.setVisibility(0);
            this.n = onClickListener;
            return this;
        }
        return (j05) invokeIL.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.o = R.color.CAM_X0304;
                this.l.setEnabled(true);
                this.l.setOnClickListener(this.n);
            } else {
                this.o = R.color.CAM_X0110;
                this.l.setEnabled(false);
                this.l.setOnClickListener(null);
            }
            o();
        }
    }
}
