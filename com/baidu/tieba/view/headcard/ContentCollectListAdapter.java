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
import com.baidu.tieba.c26;
import com.baidu.tieba.dn6;
import com.baidu.tieba.du5;
import com.baidu.tieba.em6;
import com.baidu.tieba.fw4;
import com.baidu.tieba.jbb;
import com.baidu.tieba.pi;
import com.baidu.tieba.rbb;
import com.baidu.tieba.sbb;
import com.baidu.tieba.tbb;
import com.baidu.tieba.view.headcard.compete.CompeteCardView;
import com.baidu.tieba.view.headcard.playerlist.MatchPlayerListView;
import com.baidu.tieba.view.headcard.viewholder.MatchCompeteCardViewHolder;
import com.baidu.tieba.view.headcard.viewholder.MatchPlayerListViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Objects;
/* loaded from: classes8.dex */
public class ContentCollectListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<pi> b;
    public int c;
    public String d;
    public String e;
    public rbb f;

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public final class ContentCollectViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentCollectView a;
        public ThreadData b;
        public dn6 c;
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
                        contentCollectViewHolder.d.s(false, contentCollectViewHolder.c.q(), "clk_");
                        if (this.a.d.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 2);
                            ContentCollectListAdapter contentCollectListAdapter = this.a.d;
                            contentCollectListAdapter.r(statisticItem, contentCollectListAdapter.f);
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
                        contentCollectViewHolder.d.s(false, contentCollectViewHolder.c.f(), "clk_");
                        if (this.a.d.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 1);
                            ContentCollectListAdapter contentCollectListAdapter = this.a.d;
                            contentCollectListAdapter.r(statisticItem, contentCollectListAdapter.f);
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

        public void c(ThreadData threadData, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, dn6Var) == null) {
                this.b = threadData;
                this.c = dn6Var;
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
            public final /* synthetic */ rbb a;
            public final /* synthetic */ CoverCollectViewHolder b;

            public a(CoverCollectViewHolder coverCollectViewHolder, rbb rbbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverCollectViewHolder, rbbVar};
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
                this.a = rbbVar;
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
                        du5.f(this.b.b.a, String.valueOf(this.a.c().p()), null);
                        z = true;
                    }
                    if (z) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 1);
                        ContentCollectListAdapter contentCollectListAdapter = this.b.b;
                        contentCollectListAdapter.r(statisticItem, contentCollectListAdapter.f);
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

        public void a(rbb rbbVar) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rbbVar) == null) && rbbVar != null && (matchCardView = this.a) != null) {
                matchCardView.setData(rbbVar);
                this.a.setOnClickListener(new a(this, rbbVar));
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

        public void a(@NonNull tbb tbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tbbVar) == null) {
                this.a.setText(tbbVar.a());
                EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ dn6 b;
        public final /* synthetic */ ContentCollectListAdapter c;

        public a(ContentCollectListAdapter contentCollectListAdapter, ThreadData threadData, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, threadData, dn6Var};
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
            this.b = dn6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadData threadData = this.a;
                if (threadData != null) {
                    ThreadCardUtils.jumpToPB((fw4) threadData, (Context) this.c.a.getPageActivity(), 2, false);
                }
                dn6 dn6Var = this.b;
                if (dn6Var != null) {
                    this.c.s(false, dn6Var.q(), "clk_");
                    if (this.c.t()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 2);
                        ContentCollectListAdapter contentCollectListAdapter = this.c;
                        contentCollectListAdapter.r(statisticItem, contentCollectListAdapter.f);
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
            List<pi> list = this.b;
            if (list != null && list.size() > i) {
                return this.b.get(i).getType().getId();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void u(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = list;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.e = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
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
        List<pi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) && viewHolder != null && (list = this.b) != null && list.size() > i) {
            boolean z = false;
            viewHolder.setIsRecyclable(false);
            pi piVar = this.b.get(i);
            if ((piVar instanceof tbb) && (viewHolder instanceof TitleViewHolder)) {
                ((TitleViewHolder) viewHolder).a((tbb) piVar);
            } else if ((piVar instanceof rbb) && (viewHolder instanceof CoverCollectViewHolder)) {
                rbb rbbVar = (rbb) piVar;
                this.f = rbbVar;
                ((CoverCollectViewHolder) viewHolder).a(rbbVar);
                if (!rbbVar.a) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_SHOW);
                    if (rbbVar.c() != null && rbbVar.c().g() != null) {
                        statisticItem.addParam("obj_locate", rbbVar.c().g().intValue());
                    }
                    statisticItem.addParam("obj_source", rbbVar.d());
                    statisticItem.addParam("fid", rbbVar.a());
                    statisticItem.addParam("fname", rbbVar.b());
                    TiebaStatic.log(statisticItem);
                    rbbVar.a = true;
                }
            } else if ((piVar instanceof sbb) && (viewHolder instanceof MatchPlayerListViewHolder)) {
                ((MatchPlayerListViewHolder) viewHolder).a((sbb) piVar);
            } else if ((piVar instanceof jbb) && (viewHolder instanceof MatchCompeteCardViewHolder)) {
                MatchCompeteCardViewHolder matchCompeteCardViewHolder = (MatchCompeteCardViewHolder) viewHolder;
                jbb jbbVar = (jbb) Objects.requireNonNull((jbb) piVar);
                if (this.c == 3) {
                    z = true;
                }
                matchCompeteCardViewHolder.a(jbbVar, z, this.e, this.d);
            } else {
                ThreadData threadData = (ThreadData) this.b.get(i);
                if (threadData == null) {
                    return;
                }
                ContentCollectViewHolder contentCollectViewHolder = (ContentCollectViewHolder) viewHolder;
                contentCollectViewHolder.a.setData(threadData);
                dn6 dn6Var = new dn6();
                dn6Var.position = 0;
                dn6Var.a = threadData;
                dn6Var.position = i;
                s(true, dn6Var.s(), "show_");
                contentCollectViewHolder.c(threadData, dn6Var);
                contentCollectViewHolder.a.setOnClickListener(new a(this, threadData, dn6Var));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            if (i == tbb.b.getId()) {
                EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
                eMTextView.setPadding(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X005), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds30), 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X004));
                return new TitleViewHolder(this, eMTextView);
            } else if (i == rbb.f.getId()) {
                return new CoverCollectViewHolder(this, new MatchCardView(this.a));
            } else {
                if (i == sbb.b.getId()) {
                    return new MatchPlayerListViewHolder(new MatchPlayerListView(this.a.getPageActivity()));
                }
                if (i == jbb.g.getId()) {
                    return new MatchCompeteCardViewHolder(new CompeteCardView(this.a));
                }
                return new ContentCollectViewHolder(this, new ContentCollectView(this.a));
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void r(StatisticItem statisticItem, rbb rbbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, statisticItem, rbbVar) != null) || rbbVar == null) {
            return;
        }
        int i = 0;
        if (rbbVar.c() != null && rbbVar.c().g() != null) {
            i = rbbVar.c().g().intValue();
        }
        int d = rbbVar.d();
        String a2 = rbbVar.a();
        String b2 = rbbVar.b();
        statisticItem.addParam("obj_locate", i);
        statisticItem.addParam("obj_source", d);
        statisticItem.addParam("fid", a2);
        statisticItem.addParam("fname", b2);
    }

    public final void s(boolean z, StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), statisticItem, str}) != null) || statisticItem == null) {
            return;
        }
        statisticItem.addParam("resource_id", 1);
        if (z) {
            em6.b().a(statisticItem);
        } else {
            TiebaStatic.log(statisticItem);
        }
        if ("clk_".equals(str)) {
            em6.b().d(true);
        }
        c26.c().i("page_recommend", str, statisticItem);
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ListUtils.isNotEmpty(this.b)) {
                for (pi piVar : this.b) {
                    if (piVar instanceof rbb) {
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
