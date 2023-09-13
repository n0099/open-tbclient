package com.baidu.tieba.view.headcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.b15;
import com.baidu.tieba.cn;
import com.baidu.tieba.cq6;
import com.baidu.tieba.ep6;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.m56;
import com.baidu.tieba.nx5;
import com.baidu.tieba.view.headcard.playerlist.MatchPlayerListView;
import com.baidu.tieba.view.headcard.viewholder.MatchPlayerListViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class ContentCollectListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<cn> b;
    public fxa c;

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public final class ContentCollectViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentCollectView a;
        public ThreadData b;
        public cq6 c;
        public final /* synthetic */ ContentCollectListAdapter d;

        /* loaded from: classes8.dex */
        public class a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ContentCollectViewHolder a;

            public a(ContentCollectViewHolder contentCollectViewHolder, ContentCollectListAdapter contentCollectListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {contentCollectViewHolder, contentCollectListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = contentCollectViewHolder;
            }

            @Override // com.baidu.tieba.view.headcard.ContentCollectListAdapter.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b != null) {
                        ThreadCardUtils.jumpToPBCommentArea(this.a.b, this.a.d.a.getPageActivity(), 2, 0);
                    }
                    if (this.a.c != null) {
                        ContentCollectViewHolder contentCollectViewHolder = this.a;
                        contentCollectViewHolder.d.r(false, contentCollectViewHolder.c.q(), "clk_");
                        if (this.a.d.s()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 2);
                            ContentCollectListAdapter contentCollectListAdapter = this.a.d;
                            contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.c);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.view.headcard.ContentCollectListAdapter.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.b != null) {
                        this.a.d.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.d.a.getPageActivity()).createNormalCfg(this.a.b.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR)));
                    }
                    if (this.a.c != null) {
                        ContentCollectViewHolder contentCollectViewHolder = this.a;
                        contentCollectViewHolder.d.r(false, contentCollectViewHolder.c.f(), "clk_");
                        if (this.a.d.s()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 1);
                            ContentCollectListAdapter contentCollectListAdapter = this.a.d;
                            contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.c);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentCollectViewHolder(ContentCollectListAdapter contentCollectListAdapter, ContentCollectView contentCollectView) {
            super(contentCollectView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, contentCollectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = contentCollectListAdapter;
            this.a = contentCollectView;
            contentCollectView.setCommonClickListener(new a(this, contentCollectListAdapter));
        }

        public void c(ThreadData threadData, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, cq6Var) == null) {
                this.b = threadData;
                this.c = cq6Var;
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class CoverCollectViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MatchCardView a;
        public final /* synthetic */ ContentCollectListAdapter b;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fxa a;
            public final /* synthetic */ CoverCollectViewHolder b;

            public a(CoverCollectViewHolder coverCollectViewHolder, fxa fxaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverCollectViewHolder, fxaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = coverCollectViewHolder;
                this.a = fxaVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b.a != null && this.a.c() != null) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(this.a.c().c())) {
                        BrowserHelper.startWebActivity(this.b.b.a.getPageActivity(), this.a.c().c());
                        z = true;
                    }
                    if (this.a.c().p() != 0) {
                        nx5.f(this.b.b.a, String.valueOf(this.a.c().p()), null);
                        z = true;
                    }
                    if (z) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 1);
                        ContentCollectListAdapter contentCollectListAdapter = this.b.b;
                        contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.c);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CoverCollectViewHolder(ContentCollectListAdapter contentCollectListAdapter, MatchCardView matchCardView) {
            super(matchCardView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, matchCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = contentCollectListAdapter;
            this.a = matchCardView;
        }

        public void a(fxa fxaVar) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fxaVar) == null) && fxaVar != null && (matchCardView = this.a) != null) {
                matchCardView.setData(fxaVar);
                this.a.setOnClickListener(new a(this, fxaVar));
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class CornerType {
        public static final /* synthetic */ CornerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CornerType FULL;
        public static final CornerType ITEM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1022460901, "Lcom/baidu/tieba/view/headcard/ContentCollectListAdapter$CornerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1022460901, "Lcom/baidu/tieba/view/headcard/ContentCollectListAdapter$CornerType;");
                    return;
                }
            }
            FULL = new CornerType("FULL", 0);
            CornerType cornerType = new CornerType("ITEM", 1);
            ITEM = cornerType;
            $VALUES = new CornerType[]{FULL, cornerType};
        }

        public CornerType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CornerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CornerType) Enum.valueOf(CornerType.class, str);
            }
            return (CornerType) invokeL.objValue;
        }

        public static CornerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CornerType[]) $VALUES.clone();
            }
            return (CornerType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class TitleViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(ContentCollectListAdapter contentCollectListAdapter, TextView textView) {
            super(textView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
        }

        public void a(@NonNull hxa hxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hxaVar) == null) {
                this.a.setText(hxaVar.a());
                EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ cq6 b;
        public final /* synthetic */ ContentCollectListAdapter c;

        public a(ContentCollectListAdapter contentCollectListAdapter, ThreadData threadData, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, threadData, cq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentCollectListAdapter;
            this.a = threadData;
            this.b = cq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadData threadData = this.a;
                if (threadData != null) {
                    ThreadCardUtils.jumpToPB((b15) threadData, (Context) this.c.a.getPageActivity(), 2, false);
                }
                cq6 cq6Var = this.b;
                if (cq6Var != null) {
                    this.c.r(false, cq6Var.q(), "clk_");
                    if (this.c.s()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 2);
                        ContentCollectListAdapter contentCollectListAdapter = this.c;
                        contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.c);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    public ContentCollectListAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<cn> list = this.b;
            if (list != null && list.size() > i) {
                return this.b.get(i).getType().getId();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void t(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = list;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) && viewHolder != null && (list = this.b) != null && list.size() > i) {
            viewHolder.setIsRecyclable(false);
            cn cnVar = this.b.get(i);
            if ((cnVar instanceof hxa) && (viewHolder instanceof TitleViewHolder)) {
                ((TitleViewHolder) viewHolder).a((hxa) cnVar);
            } else if ((cnVar instanceof fxa) && (viewHolder instanceof CoverCollectViewHolder)) {
                fxa fxaVar = (fxa) cnVar;
                this.c = fxaVar;
                ((CoverCollectViewHolder) viewHolder).a(fxaVar);
                if (!fxaVar.a) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_SHOW);
                    if (fxaVar.c() != null && fxaVar.c().g() != null) {
                        statisticItem.addParam("obj_locate", fxaVar.c().g().intValue());
                    }
                    statisticItem.addParam("obj_source", fxaVar.d());
                    statisticItem.addParam("fid", fxaVar.a());
                    statisticItem.addParam("fname", fxaVar.b());
                    TiebaStatic.log(statisticItem);
                    fxaVar.a = true;
                }
            } else if ((cnVar instanceof gxa) && (viewHolder instanceof MatchPlayerListViewHolder)) {
                ((MatchPlayerListViewHolder) viewHolder).a((gxa) cnVar);
            } else {
                ThreadData threadData = (ThreadData) this.b.get(i);
                if (threadData == null) {
                    return;
                }
                ContentCollectViewHolder contentCollectViewHolder = (ContentCollectViewHolder) viewHolder;
                contentCollectViewHolder.a.setData(threadData);
                cq6 cq6Var = new cq6();
                cq6Var.position = 0;
                cq6Var.a = threadData;
                cq6Var.position = i;
                r(true, cq6Var.s(), "show_");
                contentCollectViewHolder.c(threadData, cq6Var);
                contentCollectViewHolder.a.setOnClickListener(new a(this, threadData, cq6Var));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            if (i == hxa.b.getId()) {
                EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
                eMTextView.setPadding(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X005), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds30), 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X004));
                return new TitleViewHolder(this, eMTextView);
            } else if (i == fxa.f.getId()) {
                return new CoverCollectViewHolder(this, new MatchCardView(this.a));
            } else {
                if (i == gxa.b.getId()) {
                    return new MatchPlayerListViewHolder(new MatchPlayerListView(this.a.getPageActivity()));
                }
                return new ContentCollectViewHolder(this, new ContentCollectView(this.a));
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void q(StatisticItem statisticItem, fxa fxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, statisticItem, fxaVar) != null) || fxaVar == null) {
            return;
        }
        int i = 0;
        if (fxaVar.c() != null && fxaVar.c().g() != null) {
            i = fxaVar.c().g().intValue();
        }
        int d = fxaVar.d();
        String a2 = fxaVar.a();
        String b2 = fxaVar.b();
        statisticItem.addParam("obj_locate", i);
        statisticItem.addParam("obj_source", d);
        statisticItem.addParam("fid", a2);
        statisticItem.addParam("fname", b2);
    }

    public final void r(boolean z, StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), statisticItem, str}) != null) || statisticItem == null) {
            return;
        }
        statisticItem.addParam("resource_id", 1);
        if (z) {
            ep6.b().a(statisticItem);
        } else {
            TiebaStatic.log(statisticItem);
        }
        if ("clk_".equals(str)) {
            ep6.b().d(true);
        }
        m56.c().i("page_recommend", str, statisticItem);
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ListUtils.isNotEmpty(this.b)) {
                for (cn cnVar : this.b) {
                    if (cnVar instanceof fxa) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
