package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
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
import com.repackage.k19;
import com.repackage.mg;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RelevanceItemListController implements BdRecyclerView.i, k19.b, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final RelevanceItemListFragment b;
    public final k19 c;
    public BdRecyclerView d;
    public PbListView e;
    public List<ReleavanceItemListData.ItemListBean> f;
    public boolean g;
    public String h;
    public RecyclerView.Adapter i;

    /* loaded from: classes4.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;
        public ItemCardView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            ItemCardView itemCardView = (ItemCardView) view2.findViewById(R.id.obfuscated_res_0x7f090f8a);
            this.b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.b.setSizeStyle(1);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0903cb);
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
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            tbRichTextEvaluateItemInfo.setTags(itemListBean.getTags());
            ItemCardView itemCardView = this.b;
            itemCardView.setHighLightText(str + "");
            this.b.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    /* loaded from: classes4.dex */
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
                listViewHolder.a((ReleavanceItemListData.ItemListBean) this.a.f.get(i), this.a.h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d072e, (ViewGroup) null)) : (ListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f.size() : invokeV.intValue;
        }
    }

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view2, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relevanceItemListFragment, view2, str, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.i = new a(this);
        this.a = view2;
        this.b = relevanceItemListFragment;
        this.c = new k19(bdUniqueId, str);
        j();
    }

    @Override // com.repackage.k19.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.G0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
        double d;
        double d2;
        double d3;
        int i2;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || ListUtils.isEmpty(this.f)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.f.get(i);
        double d4 = 0.0d;
        try {
            parseDouble = Double.parseDouble(itemListBean.getScore());
        } catch (NumberFormatException e) {
            e = e;
            d = 0.0d;
        }
        try {
            d4 = Double.parseDouble(itemListBean.getIcon_size());
            i2 = Integer.parseInt(itemListBean.getStar());
            d3 = d4;
            d2 = parseDouble;
        } catch (NumberFormatException e2) {
            e = e2;
            double d5 = d4;
            d4 = parseDouble;
            d = d5;
            e.printStackTrace();
            d2 = d4;
            d3 = d;
            i2 = 0;
            if (this.b.C0(mg.g(itemListBean.getItem_id(), 0L))) {
            }
        }
        if (this.b.C0(mg.g(itemListBean.getItem_id(), 0L))) {
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d2, d3, i2, itemListBean.getTags()));
            this.b.getActivity().finish();
            return;
        }
        oi.M(this.b.getContext(), R.string.obfuscated_res_0x7f0f1585);
    }

    @Override // com.repackage.k19.b
    public void c(RelevanceItemSearchData relevanceItemSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relevanceItemSearchData) == null) {
            this.b.E0();
            if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
                this.f.addAll(relevanceItemSearchData.getData().getItem_list());
                this.i.notifyDataSetChanged();
            }
            if (this.d.getVisibility() == 8) {
                this.d.setVisibility(0);
            }
        }
    }

    @Override // com.repackage.k19.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = false;
            this.d.setNextPage(this.e);
            this.e.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
            this.e.f();
            this.e.L(oi.f(this.d.getContext(), R.dimen.tbds44));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f.clear();
            this.g = true;
            this.h = str;
            this.i.notifyDataSetChanged();
            this.c.g(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.h();
        }
    }

    public BdRecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (BdRecyclerView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f090f7c);
            this.d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.a.getContext()));
            this.d.setAdapter(this.i);
            PbListView pbListView = new PbListView(this.a.getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.p(R.color.CAM_X0205);
            this.e.x();
            this.e.E(SkinManager.getColor(R.color.CAM_X0107));
            this.e.G(R.dimen.tbfontsize33);
            this.e.A(R.color.CAM_X0110);
            this.d.setNextPage(this.e);
            this.d.setOnItemClickListener(this);
            this.d.setOnSrollToBottomListener(this);
            this.c.m(this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.j();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.J();
            this.e.Q();
            this.e.C(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    @Override // com.repackage.k19.b
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.f.clear();
            this.i.notifyDataSetChanged();
            this.d.setVisibility(8);
            this.b.F0(str);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.g) {
            this.c.h();
            l();
        }
    }
}
