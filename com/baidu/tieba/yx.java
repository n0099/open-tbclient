package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yx extends xx<t15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout f;
    public t15 g;
    public View.OnClickListener h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx a;

        public a(yx yxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yx yxVar = this.a;
                yxVar.z(yxVar.a.k(), this.a.g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements xz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx a;

        public b(yx yxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yxVar;
        }

        @Override // com.baidu.tieba.xz.b
        public boolean a(xz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    gp6.a(this.a.g.getThreadData().getId());
                    gp6.l(this.a.f.getTitle(), this.a.g.getThreadData().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx(Context context) {
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
        this.h = new a(this);
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.f = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.h);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: A */
    public void b(t15 t15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) {
            this.g = t15Var;
            this.f.b(t15Var);
        }
    }

    @Override // com.baidu.tieba.xx
    public void q(up6<t15> up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, up6Var) == null) {
            super.q(up6Var);
            this.f.setSubClickListener(up6Var);
        }
    }

    @Override // com.baidu.tieba.xx
    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xx
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            n(1, new b(this));
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void z(View view2, yn ynVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, ynVar) == null) {
            t15 t15Var = this.g;
            if ((!(t15Var instanceof fq6) && !(t15Var instanceof ThreadData)) || !(view2.getTag() instanceof ThreadCardViewHolder)) {
                return;
            }
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            if (ynVar instanceof fq6) {
                fq6 fq6Var = (fq6) this.g;
                fq6Var.f = 1;
                Context context = view2.getContext();
                if (fq6Var.a.isFromHomPage) {
                    i = 2;
                } else {
                    i = 1;
                }
                ThreadCardUtils.jumpToPB((t15) fq6Var, context, i, false);
                threadCardViewHolder.b().p(new xz.a(1));
            } else if (ynVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) this.g;
                threadData.objType = 1;
                ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }
}
