package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PeiwanInfo;
/* loaded from: classes6.dex */
public class jm7 extends fi7<h45, ThreadCardViewHolder<ThreadData>> implements kp6, xt7, o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public mp6<ThreadData> p;

    @Override // com.baidu.tieba.kp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm7 b;

        public a(jm7 jm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, this.b.getType());
                }
                if ("c13010".equals(this.b.l)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        ut7.e(threadData, 5, this.b.mPageId, xt7.q0, this.b.t());
                        tw7.h(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        ut7.e(threadData, 14, this.b.mPageId, xt7.q0, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.p.a instanceof Boolean) {
                            if (((Boolean) this.b.p.a).booleanValue()) {
                                ut7.e(threadData, 1, this.b.mPageId, xt7.q0, this.b.t());
                            } else {
                                ut7.e(threadData, 3, this.b.mPageId, xt7.q0, this.b.t());
                            }
                        }
                        tw7.h(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        ut7.e(threadData, 15, this.b.mPageId, xt7.q0, this.b.t());
                        tw7.h(threadData, this.b.b, 1);
                    } else {
                        ut7.e(threadData, 1, this.b.mPageId, xt7.q0, this.b.t());
                        tw7.h(threadData, this.b.b, 1);
                    }
                } else {
                    ut7.e(threadData, 2, this.b.mPageId, xt7.q0, this.b.t());
                }
                if (view2.getId() == R.id.thread_card_root && threadData.isVideoThreadType()) {
                    this.b.b0(threadData);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        tw7.a(xt7.q0, threadData.getRecomReason());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.p.a instanceof Boolean) {
                            if (((Boolean) this.b.p.a).booleanValue()) {
                                wt7.k().h(xt7.q0, threadData, 1);
                            } else {
                                wt7.k().h(xt7.q0, threadData, 3);
                            }
                        }
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        wt7.k().h(xt7.q0, threadData, 5);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().f0() != null && threadData.getTopAgreePost().f0().O() != null && threadData.getTopAgreePost().f0().O().size() > 0) {
                            i = threadData.getTopAgreePost().N ? 9 : 8;
                        }
                        wt7.k().h(xt7.q0, threadData, i);
                    } else {
                        wt7.k().h(xt7.q0, threadData, 1);
                    }
                } else {
                    wt7.k().h(xt7.q0, threadData, 2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm7 a;

        public b(jm7 jm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm7Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof h45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((h45) cnVar).t;
                threadData.objType = 1;
                if (threadData.getPeiwanInfo() != null && !TextUtils.isEmpty(threadData.getPeiwanInfo().scheme)) {
                    UrlManager.getInstance().dealOneLink(threadData.getPeiwanInfo().scheme);
                    jm7.Y(threadData);
                    return;
                }
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = 3;
        this.p = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.kp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.fi7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.baidu.tieba.fi7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n = z;
        }
    }

    public static void Y(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
            if (threadData.isFromNet) {
                str = "1";
            } else {
                str = "0";
            }
            statisticItem.addParam("obj_param1", str);
            statisticItem.addParam("fid", threadData.getFid());
            statisticItem.addParam("fname", threadData.getForum_name());
            statisticItem.addParam("fid", threadData.getFid());
            statisticItem.addParam("fname", threadData.getForum_name());
            statisticItem.eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity(), false);
            dy dyVar = new dy(this.c.getPageActivity());
            dyVar.setFrom("frs");
            dyVar.x(this.n);
            dyVar.y(true);
            bVar.n(dyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.o(false);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    public final void b0(ThreadData threadData) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (u()) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_locate", i);
            if (threadData.getThreadAlaInfo() == null) {
                j = -1;
            } else {
                j = threadData.getThreadAlaInfo().live_id;
            }
            TiebaStatic.log(param2.param("obj_id", j).param("obj_type", 1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) h45Var, (h45) threadCardViewHolder);
            if (h45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.m);
                threadCardViewHolder.a().r(i);
                ei7.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    h45Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                threadCardViewHolder.e(h45Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.p);
                h45Var.t.updateShowStatus();
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.xt7
    public vt7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return xt7.q0;
        }
        return (vt7) invokeV.objValue;
    }
}
