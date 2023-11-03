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
import com.baidu.tieba.bw4;
import com.baidu.tieba.n6b;
import com.baidu.tieba.nm6;
import com.baidu.tieba.oi;
import com.baidu.tieba.pl6;
import com.baidu.tieba.q16;
import com.baidu.tieba.qt5;
import com.baidu.tieba.v6b;
import com.baidu.tieba.view.headcard.compete.CompeteCardView;
import com.baidu.tieba.view.headcard.playerlist.MatchPlayerListView;
import com.baidu.tieba.view.headcard.viewholder.MatchCompeteCardViewHolder;
import com.baidu.tieba.view.headcard.viewholder.MatchPlayerListViewHolder;
import com.baidu.tieba.w6b;
import com.baidu.tieba.x6b;
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
    public List<oi> b;
    public int c;
    public String d;
    public String e;
    public v6b f;

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
        public nm6 c;
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
                            contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.f);
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
                            contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.f);
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

        public void c(ThreadData threadData, nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, nm6Var) == null) {
                this.b = threadData;
                this.c = nm6Var;
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
            public final /* synthetic */ v6b a;
            public final /* synthetic */ CoverCollectViewHolder b;

            public a(CoverCollectViewHolder coverCollectViewHolder, v6b v6bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverCollectViewHolder, v6bVar};
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
                this.a = v6bVar;
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
                        qt5.f(this.b.b.a, String.valueOf(this.a.c().p()), null);
                        z = true;
                    }
                    if (z) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 1);
                        ContentCollectListAdapter contentCollectListAdapter = this.b.b;
                        contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.f);
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

        public void a(v6b v6bVar) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, v6bVar) == null) && v6bVar != null && (matchCardView = this.a) != null) {
                matchCardView.setData(v6bVar);
                this.a.setOnClickListener(new a(this, v6bVar));
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

        public void a(@NonNull x6b x6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x6bVar) == null) {
                this.a.setText(x6bVar.a());
                EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ nm6 b;
        public final /* synthetic */ ContentCollectListAdapter c;

        public a(ContentCollectListAdapter contentCollectListAdapter, ThreadData threadData, nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, threadData, nm6Var};
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
            this.b = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadData threadData = this.a;
                if (threadData != null) {
                    ThreadCardUtils.jumpToPB((bw4) threadData, (Context) this.c.a.getPageActivity(), 2, false);
                }
                nm6 nm6Var = this.b;
                if (nm6Var != null) {
                    this.c.s(false, nm6Var.q(), "clk_");
                    if (this.c.t()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                        statisticItem.param("obj_type", 2);
                        ContentCollectListAdapter contentCollectListAdapter = this.c;
                        contentCollectListAdapter.q(statisticItem, contentCollectListAdapter.f);
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
            List<oi> list = this.b;
            if (list != null && list.size() > i) {
                return this.b.get(i).getType().getId();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void u(List<oi> list) {
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
        List<oi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) && viewHolder != null && (list = this.b) != null && list.size() > i) {
            boolean z = false;
            viewHolder.setIsRecyclable(false);
            oi oiVar = this.b.get(i);
            if ((oiVar instanceof x6b) && (viewHolder instanceof TitleViewHolder)) {
                ((TitleViewHolder) viewHolder).a((x6b) oiVar);
            } else if ((oiVar instanceof v6b) && (viewHolder instanceof CoverCollectViewHolder)) {
                v6b v6bVar = (v6b) oiVar;
                this.f = v6bVar;
                ((CoverCollectViewHolder) viewHolder).a(v6bVar);
                if (!v6bVar.a) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_SHOW);
                    if (v6bVar.c() != null && v6bVar.c().g() != null) {
                        statisticItem.addParam("obj_locate", v6bVar.c().g().intValue());
                    }
                    statisticItem.addParam("obj_source", v6bVar.d());
                    statisticItem.addParam("fid", v6bVar.a());
                    statisticItem.addParam("fname", v6bVar.b());
                    TiebaStatic.log(statisticItem);
                    v6bVar.a = true;
                }
            } else if ((oiVar instanceof w6b) && (viewHolder instanceof MatchPlayerListViewHolder)) {
                ((MatchPlayerListViewHolder) viewHolder).a((w6b) oiVar);
            } else if ((oiVar instanceof n6b) && (viewHolder instanceof MatchCompeteCardViewHolder)) {
                MatchCompeteCardViewHolder matchCompeteCardViewHolder = (MatchCompeteCardViewHolder) viewHolder;
                n6b n6bVar = (n6b) Objects.requireNonNull((n6b) oiVar);
                if (this.c == 3) {
                    z = true;
                }
                matchCompeteCardViewHolder.a(n6bVar, z, this.e, this.d);
            } else {
                ThreadData threadData = (ThreadData) this.b.get(i);
                if (threadData == null) {
                    return;
                }
                ContentCollectViewHolder contentCollectViewHolder = (ContentCollectViewHolder) viewHolder;
                contentCollectViewHolder.a.setData(threadData);
                nm6 nm6Var = new nm6();
                nm6Var.position = 0;
                nm6Var.a = threadData;
                nm6Var.position = i;
                s(true, nm6Var.s(), "show_");
                contentCollectViewHolder.c(threadData, nm6Var);
                contentCollectViewHolder.a.setOnClickListener(new a(this, threadData, nm6Var));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            if (i == x6b.b.getId()) {
                EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
                eMTextView.setPadding(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X005), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds30), 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X004));
                return new TitleViewHolder(this, eMTextView);
            } else if (i == v6b.f.getId()) {
                return new CoverCollectViewHolder(this, new MatchCardView(this.a));
            } else {
                if (i == w6b.b.getId()) {
                    return new MatchPlayerListViewHolder(new MatchPlayerListView(this.a.getPageActivity()));
                }
                if (i == n6b.g.getId()) {
                    return new MatchCompeteCardViewHolder(new CompeteCardView(this.a));
                }
                return new ContentCollectViewHolder(this, new ContentCollectView(this.a));
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void q(StatisticItem statisticItem, v6b v6bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, statisticItem, v6bVar) != null) || v6bVar == null) {
            return;
        }
        int i = 0;
        if (v6bVar.c() != null && v6bVar.c().g() != null) {
            i = v6bVar.c().g().intValue();
        }
        int d = v6bVar.d();
        String a2 = v6bVar.a();
        String b2 = v6bVar.b();
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
            pl6.b().a(statisticItem);
        } else {
            TiebaStatic.log(statisticItem);
        }
        if ("clk_".equals(str)) {
            pl6.b().d(true);
        }
        q16.c().i("page_recommend", str, statisticItem);
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ListUtils.isNotEmpty(this.b)) {
                for (oi oiVar : this.b) {
                    if (oiVar instanceof v6b) {
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
