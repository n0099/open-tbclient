package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lx extends hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b15 h;
    public ForumEnterLayout i;
    public final View.OnClickListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx a;

        public a(lx lxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g() != null) {
                this.a.g().a(view2, this.a.h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lx(Context context) {
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
        this.j = new a(this);
        int dimens = BdUtilHelper.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = BdUtilHelper.getDimens(context, R.dimen.tbds0);
        x(dimens);
        u(dimens2);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().d instanceof ForumEnterLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().d.getParent() == null) {
            this.i = (ForumEnterLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().d;
        } else {
            this.i = new ForumEnterLayout(context);
        }
        this.i.setOnAfterClickListener(this.j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: A */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) {
            this.h = b15Var;
            this.i.setSourceForPb(this.a.j());
            this.i.setData(b15Var);
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.b, R.dimen.M_H_X003);
            int dimens2 = BdUtilHelper.getDimens(this.b, R.dimen.tbds0);
            x(dimens);
            u(dimens2);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.i.n(tbPageContext, i);
        }
    }
}
