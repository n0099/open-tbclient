package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class m27 extends pm<h45, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public TbPageContext<?> c;
    public in d;
    public mp6<ThreadData> e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;

    /* loaded from: classes7.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m27 b;

        public a(m27 m27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                ep6.b().d(true);
                l07.a(view2, threadData, this.b.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(m27 m27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(b15 b15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, b15Var, view2) == null) && b15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    b15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    b15Var.objType = 4;
                } else {
                    b15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m27 a;

        public c(m27 m27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m27Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof h45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((h45) cnVar).t;
                threadData.objType = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), 2, false, ex.a((in) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m27 a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) {
            }
        }

        public d(m27 m27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m27Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) == null) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadNEGFeedbackStatisticLog(negativeFeedBackData, this.a.b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m27(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.f = new d(this);
        this.c = tbPageContext;
        this.a = bdUniqueId2;
        this.b = str;
    }

    public void y(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inVar) == null) {
            this.d = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.p(this.a);
            dxVar.f(1024);
            dxVar.y(new b(this));
            dxVar.B(this.c);
            bVar.o(dxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, threadCardViewHolder})) == null) {
            if (h45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && (threadData = h45Var.t) != null) {
                threadData.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.f);
                threadCardViewHolder.e(h45Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
