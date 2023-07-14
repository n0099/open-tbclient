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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.kq6;
import com.baidu.tieba.my5;
import com.baidu.tieba.np6;
import com.baidu.tieba.nx4;
import com.baidu.tieba.r66;
import com.baidu.tieba.t15;
import com.baidu.tieba.tra;
import com.baidu.tieba.ura;
import com.baidu.tieba.view.headcard.playerlist.MatchPlayerListView;
import com.baidu.tieba.view.headcard.viewholder.MatchPlayerListViewHolder;
import com.baidu.tieba.vra;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
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
    public List<yn> b;
    public tra c;

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
        public kq6 c;
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
                        contentCollectViewHolder.d.r(false, contentCollectViewHolder.c.p(), "clk_");
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

        public void d(ThreadData threadData, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, kq6Var) == null) {
                this.b = threadData;
                this.c = kq6Var;
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
            public final /* synthetic */ tra a;
            public final /* synthetic */ CoverCollectViewHolder b;

            public a(CoverCollectViewHolder coverCollectViewHolder, tra traVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverCollectViewHolder, traVar};
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
                this.a = traVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b.a != null && this.a.c() != null) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(this.a.c().c())) {
                        nx4.s(this.b.b.a.getPageActivity(), this.a.c().c());
                        z = true;
                    }
                    if (this.a.c().p() != 0) {
                        String valueOf = String.valueOf(this.a.c().p());
                        if (NewWebHotTopicPageSwitch.isOn()) {
                            my5.f(this.b.b.a, valueOf, null);
                        } else {
                            new HotTopicActivityConfig(view2.getContext()).createNormalConfig(valueOf, null, "1").start();
                        }
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

        public void b(tra traVar) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, traVar) == null) && traVar != null && (matchCardView = this.a) != null) {
                matchCardView.setData(traVar);
                this.a.setOnClickListener(new a(this, traVar));
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

        public void b(@NonNull vra vraVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vraVar) == null) {
                this.a.setText(vraVar.a());
                d85 d = d85.d(this.a);
                d.D(R.string.F_X02);
                d.C(R.dimen.T_X07);
                d.x(R.color.CAM_X0105);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ kq6 b;
        public final /* synthetic */ ContentCollectListAdapter c;

        public a(ContentCollectListAdapter contentCollectListAdapter, ThreadData threadData, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, threadData, kq6Var};
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
            this.b = kq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadData threadData = this.a;
                if (threadData != null) {
                    ThreadCardUtils.jumpToPB((t15) threadData, (Context) this.c.a.getPageActivity(), 2, false);
                }
                kq6 kq6Var = this.b;
                if (kq6Var != null) {
                    this.c.r(false, kq6Var.p(), "clk_");
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
            List<yn> list = this.b;
            if (list != null && list.size() > i) {
                return this.b.get(i).getType().getId();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void t(List<yn> list) {
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
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) && viewHolder != null && (list = this.b) != null && list.size() > i) {
            viewHolder.setIsRecyclable(false);
            yn ynVar = this.b.get(i);
            if ((ynVar instanceof vra) && (viewHolder instanceof TitleViewHolder)) {
                ((TitleViewHolder) viewHolder).b((vra) ynVar);
            } else if ((ynVar instanceof tra) && (viewHolder instanceof CoverCollectViewHolder)) {
                tra traVar = (tra) ynVar;
                this.c = traVar;
                ((CoverCollectViewHolder) viewHolder).b(traVar);
                if (!traVar.a) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_SHOW);
                    if (traVar.c() != null && traVar.c().g() != null) {
                        statisticItem.addParam("obj_locate", traVar.c().g().intValue());
                    }
                    statisticItem.addParam("obj_source", traVar.d());
                    statisticItem.addParam("fid", traVar.a());
                    statisticItem.addParam("fname", traVar.b());
                    TiebaStatic.log(statisticItem);
                    traVar.a = true;
                }
            } else if ((ynVar instanceof ura) && (viewHolder instanceof MatchPlayerListViewHolder)) {
                ((MatchPlayerListViewHolder) viewHolder).b((ura) ynVar);
            } else {
                ThreadData threadData = (ThreadData) this.b.get(i);
                if (threadData == null) {
                    return;
                }
                ContentCollectViewHolder contentCollectViewHolder = (ContentCollectViewHolder) viewHolder;
                contentCollectViewHolder.a.setData(threadData);
                kq6 kq6Var = new kq6();
                kq6Var.position = 0;
                kq6Var.a = threadData;
                kq6Var.position = i;
                r(true, kq6Var.r(), "show_");
                contentCollectViewHolder.d(threadData, kq6Var);
                contentCollectViewHolder.a.setOnClickListener(new a(this, threadData, kq6Var));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            if (i == vra.b.getId()) {
                EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
                eMTextView.setPadding(yi.g(this.a.getPageActivity(), R.dimen.M_W_X005), yi.g(this.a.getPageActivity(), R.dimen.tbds30), 0, yi.g(this.a.getPageActivity(), R.dimen.M_H_X004));
                return new TitleViewHolder(this, eMTextView);
            } else if (i == tra.f.getId()) {
                return new CoverCollectViewHolder(this, new MatchCardView(this.a));
            } else {
                if (i == ura.b.getId()) {
                    return new MatchPlayerListViewHolder(new MatchPlayerListView(this.a.getPageActivity()));
                }
                return new ContentCollectViewHolder(this, new ContentCollectView(this.a));
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void q(StatisticItem statisticItem, tra traVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, statisticItem, traVar) != null) || traVar == null) {
            return;
        }
        int i = 0;
        if (traVar.c() != null && traVar.c().g() != null) {
            i = traVar.c().g().intValue();
        }
        int d = traVar.d();
        String a2 = traVar.a();
        String b2 = traVar.b();
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
            np6.b().a(statisticItem);
        } else {
            TiebaStatic.log(statisticItem);
        }
        if ("clk_".equals(str)) {
            np6.b().d(true);
        }
        r66.c().i("page_recommend", str, statisticItem);
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ListUtils.isNotEmpty(this.b)) {
                for (yn ynVar : this.b) {
                    if (ynVar instanceof tra) {
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
