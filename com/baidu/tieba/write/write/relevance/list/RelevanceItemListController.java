package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.p0.s4.u.m.a.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RelevanceItemListController implements BdRecyclerView.i, a.b, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final RelevanceItemListFragment f37469b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.s4.u.m.a.a f37470c;

    /* renamed from: d  reason: collision with root package name */
    public BdRecyclerView f37471d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f37472e;

    /* renamed from: f  reason: collision with root package name */
    public List<ReleavanceItemListData.ItemListBean> f37473f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37474g;

    /* renamed from: h  reason: collision with root package name */
    public String f37475h;
    public RecyclerView.Adapter i;

    /* loaded from: classes6.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public ItemCardView f37476b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            ItemCardView itemCardView = (ItemCardView) view.findViewById(R.id.obfuscated_res_0x7f090f8f);
            this.f37476b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.f37476b.setSizeStyle(1);
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f0903c1);
            this.a = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0203);
        }

        public void a(ReleavanceItemListData.ItemListBean itemListBean, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, itemListBean, str) == null) || itemListBean == null) {
                return;
            }
            TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
            tbRichTextEvaluateItemInfo.setTitle(itemListBean.getItem_name());
            tbRichTextEvaluateItemInfo.setIconUrl(itemListBean.getIcon_url());
            try {
                tbRichTextEvaluateItemInfo.setScore(Double.parseDouble(itemListBean.getScore()));
                tbRichTextEvaluateItemInfo.setIconSize(Double.parseDouble(itemListBean.getIcon_size()));
                tbRichTextEvaluateItemInfo.setStar(Integer.parseInt(itemListBean.getStar()));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            tbRichTextEvaluateItemInfo.setTags(itemListBean.getTags());
            ItemCardView itemCardView = this.f37476b;
            itemCardView.setHighLightText(str + "");
            this.f37476b.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.Adapter<ListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelevanceItemListController a;

        public a(RelevanceItemListController relevanceItemListController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemListController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = relevanceItemListController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, listViewHolder, i) == null) {
                listViewHolder.a((ReleavanceItemListData.ItemListBean) this.a.f37473f.get(i), this.a.f37475h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0737, (ViewGroup) null)) : (ListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f37473f.size() : invokeV.intValue;
        }
    }

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relevanceItemListFragment, view, str, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37473f = new ArrayList();
        this.f37474g = true;
        this.i = new a(this);
        this.a = view;
        this.f37469b = relevanceItemListFragment;
        this.f37470c = new c.a.p0.s4.u.m.a.a(bdUniqueId, str);
        j();
    }

    @Override // c.a.p0.s4.u.m.a.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37469b.H0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
        double d2;
        double d3;
        double d4;
        int i2;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || ListUtils.isEmpty(this.f37473f)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.f37473f.get(i);
        double d5 = 0.0d;
        try {
            parseDouble = Double.parseDouble(itemListBean.getScore());
        } catch (NumberFormatException e2) {
            e = e2;
            d2 = 0.0d;
        }
        try {
            d5 = Double.parseDouble(itemListBean.getIcon_size());
            i2 = Integer.parseInt(itemListBean.getStar());
            d4 = d5;
            d3 = parseDouble;
        } catch (NumberFormatException e3) {
            e = e3;
            double d6 = d5;
            d5 = parseDouble;
            d2 = d6;
            e.printStackTrace();
            d3 = d5;
            d4 = d2;
            i2 = 0;
            if (this.f37469b.D0(b.g(itemListBean.getItem_id(), 0L))) {
            }
        }
        if (this.f37469b.D0(b.g(itemListBean.getItem_id(), 0L))) {
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i2, itemListBean.getTags()));
            this.f37469b.getActivity().finish();
            return;
        }
        n.M(this.f37469b.getContext(), R.string.obfuscated_res_0x7f0f157f);
    }

    @Override // c.a.p0.s4.u.m.a.a.b
    public void c(RelevanceItemSearchData relevanceItemSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relevanceItemSearchData) == null) {
            this.f37469b.F0();
            if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
                this.f37473f.addAll(relevanceItemSearchData.getData().getItem_list());
                this.i.notifyDataSetChanged();
            }
            if (this.f37471d.getVisibility() == 8) {
                this.f37471d.setVisibility(0);
            }
        }
    }

    @Override // c.a.p0.s4.u.m.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f37474g = false;
            this.f37471d.setNextPage(this.f37472e);
            this.f37472e.D(this.f37469b.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
            this.f37472e.f();
            this.f37472e.M(n.f(this.f37471d.getContext(), R.dimen.tbds44));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f37473f.clear();
            this.f37474g = true;
            this.f37475h = str;
            this.i.notifyDataSetChanged();
            this.f37470c.g(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f37470c.h();
        }
    }

    public BdRecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37471d : (BdRecyclerView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f090f81);
            this.f37471d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.a.getContext()));
            this.f37471d.setAdapter(this.i);
            PbListView pbListView = new PbListView(this.a.getContext());
            this.f37472e = pbListView;
            pbListView.a();
            this.f37472e.p(R.color.CAM_X0205);
            this.f37472e.y();
            this.f37472e.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f37472e.H(R.dimen.tbfontsize33);
            this.f37472e.B(R.color.CAM_X0110);
            this.f37471d.setNextPage(this.f37472e);
            this.f37471d.setOnItemClickListener(this);
            this.f37471d.setOnSrollToBottomListener(this);
            this.f37470c.m(this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f37470c.j();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f37472e.K();
            this.f37472e.R();
            this.f37472e.D(this.f37471d.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.f37472e.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    @Override // c.a.p0.s4.u.m.a.a.b
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.f37473f.clear();
            this.i.notifyDataSetChanged();
            this.f37471d.setVisibility(8);
            this.f37469b.G0(str);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f37474g) {
            this.f37470c.h();
            l();
        }
    }
}
