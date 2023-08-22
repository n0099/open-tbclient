package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r48 extends om<zo6, ThreadCardViewHolder<zo6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public hn c;

    /* loaded from: classes7.dex */
    public class a implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx a;

        public a(r48 r48Var, wx wxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r48Var, wxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wxVar;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            zo6 zo6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = bnVar instanceof zo6;
                int i2 = 0;
                if (z && (zo6Var = (zo6) bnVar) != null && zo6Var.u && (threadData = zo6Var.a) != null && threadData.getItem() != null) {
                    int intValue = zo6Var.a.getItem().button_link_type.intValue();
                    if (zo6Var.a.getItem().apk_detail != null) {
                        i2 = zo6Var.a.getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = ma5.a(intValue, i2);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(zo6Var.a.getItem());
                    ItemCardHelper.q(this.a.B(), zo6Var.a.getItem().item_id.longValue(), this.a.A(itemData), zo6Var.a.getTid(), a, "", 2);
                    ItemClickJumpUtil.itemClickJump(zo6Var.a.getItem().forum_name, String.valueOf(zo6Var.a.getItem().item_id), 1, 1);
                } else if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    zo6 zo6Var2 = (zo6) bnVar;
                    zo6Var2.f = 1;
                    ThreadCardUtils.jumpToPB((w05) zo6Var2, view2.getContext(), 4, false);
                    ((ThreadCardViewHolder) view2.getTag()).b().p(new yy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.b = tbPageContext;
    }

    public void u(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hnVar) == null) {
            this.c = hnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: s */
    public ThreadCardViewHolder<zo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            wx wxVar = new wx(this.b.getPageActivity());
            wxVar.D(true);
            wxVar.G(1);
            wxVar.z();
            bVar.h(wxVar);
            ny k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.s(2);
            ThreadCardViewHolder<zo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new a(this, wxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zo6 zo6Var, ThreadCardViewHolder<zo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo6Var, threadCardViewHolder})) == null) {
            if (zo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zo6Var.a != null) {
                zo6Var.A(zo6Var.position + 1);
                zo6Var.a.statFloor = zo6Var.h();
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(zo6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
