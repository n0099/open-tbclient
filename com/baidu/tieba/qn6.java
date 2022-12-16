package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qn6 extends kn<yu4, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public BdTypeRecyclerView c;

    /* loaded from: classes5.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx a;
        public final /* synthetic */ qn6 b;

        public a(qn6 qn6Var, vx vxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, vxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qn6Var;
            this.a = vxVar;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = xnVar instanceof yu4;
                int i2 = 0;
                if (z) {
                    yu4 yu4Var = (yu4) xnVar;
                    if (yu4Var.t.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                        BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking));
                        b.f(BdToast.ToastIcon.FAILURE);
                        b.i();
                        return;
                    }
                    ThreadData threadData = yu4Var.t;
                    if (threadData != null && yu4Var.n && threadData.getItem() != null) {
                        int intValue = yu4Var.t.getItem().button_link_type.intValue();
                        if (yu4Var.t.getItem().apk_detail != null) {
                            i2 = yu4Var.t.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = yz4.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(yu4Var.t.getItem());
                        ItemCardHelper.q(this.a.y(), yu4Var.t.getItem().item_id.longValue(), this.a.x(itemData), yu4Var.t.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(yu4Var.t.getItem().forum_name, String.valueOf(yu4Var.t.getItem().item_id), 10, 10);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadData threadData2 = ((yu4) xnVar).t;
                    threadData2.objType = 1;
                    ThreadCardUtils.jumpToPB((vr4) threadData2, view2.getContext(), 2, false);
                    ((ThreadCardViewHolder) view2.getTag()).a().p(new zy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.a = bdUniqueId2;
    }

    public void v(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) {
            this.c = bdTypeRecyclerView;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            vx vxVar = new vx(this.b.getPageActivity());
            vxVar.A(true);
            vxVar.D(6);
            vxVar.w();
            bVar.h(vxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.s(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new a(this, vxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yu4 yu4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yu4Var, threadCardViewHolder})) == null) {
            if (yu4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && (threadData = yu4Var.t) != null) {
                threadData.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.e(yu4Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
