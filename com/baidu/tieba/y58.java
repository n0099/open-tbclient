package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PeiwanInfo;
/* loaded from: classes8.dex */
public class y58 extends pm<cq6, ThreadCardViewHolder<cq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public s78 c;
    public String d;
    public boolean e;
    public in f;
    public mp6<cq6> g;

    /* loaded from: classes8.dex */
    public class a extends mp6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y58 b;

        public a(y58 y58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && cq6Var != null && cq6Var.getThreadData() != null && !StringUtils.isNull(cq6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !o58.b(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L))) {
                        o58.a(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L), cq6Var.u(), cq6Var.i(), cq6Var.h(), cq6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, cq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, cq6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y58 a;

        public b(y58 y58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y58Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof cq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) cnVar;
                cq6Var.f = 1;
                ThreadData threadData = cq6Var.a;
                if (threadData != null && threadData.getPeiwanInfo() != null && !TextUtils.isEmpty(cq6Var.a.getPeiwanInfo().scheme)) {
                    UrlManager.getInstance().dealOneLink(cq6Var.a.getPeiwanInfo().scheme);
                    y58.x(cq6Var.a);
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) cq6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = true;
        this.g = new a(this);
        this.b = tbPageContext;
        y();
    }

    public void C(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s78Var) == null) {
            this.c = s78Var;
        }
    }

    public void D(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, inVar) == null) {
            this.f = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public static void x(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
            if (threadData.isFromNet) {
                str = "1";
            } else {
                str = "0";
            }
            statisticItem.addParam("obj_param1", str);
            statisticItem.eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            dy dyVar = new dy(this.b.getPageActivity());
            dyVar.setFrom("index");
            dyVar.x(this.e);
            bVar.n(dyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                cq6Var.a.statFloor = cq6Var.h();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(cq6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                ep6.b().a(cq6Var.s());
                m56.c().a(cq6Var.s());
                x78.p(cq6Var.a, this.a, cq6Var.h());
                x78.o(cq6Var.a, cq6Var.i(), cq6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void B(View view2, cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(cq6Var.N());
                    m56.c().i("page_recommend", "clk_", cq6Var.N());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(cq6Var.N());
                    m56.c().i("page_recommend", "clk_", cq6Var.N());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(cq6Var.f());
                    m56.c().i("page_recommend", "clk_", cq6Var.f());
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(cq6Var.K());
                            m56.c().i("page_recommend", "clk_", cq6Var.K());
                            x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            } else {
                TiebaStatic.log(cq6Var.q());
                m56.c().i("page_recommend", "clk_", cq6Var.q());
                x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 1);
                i = 1;
            }
            if (i != 0) {
                x78.d(cq6Var.a, this.a, cq6Var.h(), i);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cq6.f1090T = "c10705";
            cq6.U = "c10730";
            cq6.V = "c10731";
            cq6.W = "c10704";
            cq6.X = "c10755";
            cq6.Y = "c10710";
            cq6.Z = "c10736";
            cq6.a0 = "c10737";
            cq6.b0 = "c10711";
            cq6.c0 = "c10758";
            cq6.d0 = "c10757";
        }
    }
}
