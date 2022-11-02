package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xy extends gx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext h;
    public int i;
    public VoteView j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr4 a;
        public final /* synthetic */ xy b;

        public a(xy xyVar, rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xyVar, rr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xyVar;
            this.a = rr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadCardUtils.jumpToPB(this.a, (Context) this.b.h.getPageActivity(), this.b.i, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new VoteView(context);
        v(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rx
    /* renamed from: z */
    public void a(rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rr4Var) == null) {
            if (y(rr4Var)) {
                this.j.setVisibility(0);
                this.j.setThreadData(rr4Var.getThreadData());
                this.j.setOnItemClickListener(new a(this, rr4Var));
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i = i;
        }
    }

    public void B(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.h = tbPageContext;
            this.j.setPageContext(tbPageContext);
        }
    }

    @Override // com.baidu.tieba.zw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.j.D(i);
        }
    }

    public final boolean y(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rr4Var)) == null) {
            if (rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().getPollData() != null && rr4Var.getThreadData().getPollData().getOptions() != null && rr4Var.getThreadData().getPollData().getOptions().size() > 0 && !rr4Var.getThreadData().isVideoThreadType()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
