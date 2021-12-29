package com.baidu.tieba.newinterest.adapter;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.t0.o2.c.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.t0.o2.c.a> a;

    /* renamed from: b  reason: collision with root package name */
    public int f48068b;

    /* renamed from: c  reason: collision with root package name */
    public c f48069c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48070d;

    /* loaded from: classes12.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView bottomForumDesc;
        public BarImageView bottomForumImage;
        public TextView bottomForumName;
        public TextView bottomMemberText;
        public TextView bottomPostText;
        public RelativeLayout bottomRecommendLayout;
        public TBSpecificationBtn bottomSelectInterest;
        public TextView interestChange;
        public ImageView interestIcon;
        public TextView interestText;
        public TextView middleForumDesc;
        public BarImageView middleForumImage;
        public TextView middleForumName;
        public TextView middleMemberText;
        public TextView middlePostText;
        public RelativeLayout middleRecommendLayout;
        public TBSpecificationBtn middleSelectInterest;
        public TextView topForumDesc;
        public BarImageView topForumImage;
        public TextView topForumName;
        public TextView topMemberText;
        public TextView topPostText;
        public RelativeLayout topRecommendLayout;
        public TBSpecificationBtn topSelectInterest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterestedForumViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.interestIcon = (ImageView) view.findViewById(R.id.interest_icon);
            this.interestText = (TextView) view.findViewById(R.id.interest_text);
            this.interestChange = (TextView) view.findViewById(R.id.interest_change);
            this.topRecommendLayout = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.middleRecommendLayout = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.bottomRecommendLayout = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.topForumImage = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.middleForumImage = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.bottomForumImage = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.topForumName = (TextView) view.findViewById(R.id.top_forum_name);
            this.middleForumName = (TextView) view.findViewById(R.id.middle_forum_name);
            this.bottomForumName = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.topForumDesc = (TextView) view.findViewById(R.id.top_forum_desc);
            this.middleForumDesc = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.bottomForumDesc = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.topMemberText = (TextView) view.findViewById(R.id.top_member_text);
            this.middleMemberText = (TextView) view.findViewById(R.id.middle_member_text);
            this.bottomMemberText = (TextView) view.findViewById(R.id.bottom_member_text);
            this.topPostText = (TextView) view.findViewById(R.id.top_post_text);
            this.middlePostText = (TextView) view.findViewById(R.id.middle_post_text);
            this.bottomPostText = (TextView) view.findViewById(R.id.bottom_post_text);
            this.topSelectInterest = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.middleSelectInterest = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.bottomSelectInterest = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            SkinManager.setViewTextColor(this.topForumName, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.middleForumName, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.bottomForumName, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.topForumDesc, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.middleForumDesc, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.bottomForumDesc, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.topMemberText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.middleMemberText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.bottomMemberText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.topPostText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.middlePostText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.bottomPostText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.interestText, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.interestChange, R.color.CAM_X0107);
            this.interestText.setTypeface(Typeface.DEFAULT_BOLD);
            this.topForumName.setTypeface(Typeface.DEFAULT_BOLD);
            this.middleForumName.setTypeface(Typeface.DEFAULT_BOLD);
            this.bottomForumName.setTypeface(Typeface.DEFAULT_BOLD);
            this.topSelectInterest.setConfig(new c.a.s0.s.i0.n.b());
            this.middleSelectInterest.setConfig(new c.a.s0.s.i0.n.b());
            this.bottomSelectInterest.setConfig(new c.a.s0.s.i0.n.b());
            a(this.topForumImage);
            a(this.middleForumImage);
            a(this.bottomForumImage);
        }

        public final void a(BarImageView barImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, barImageView) == null) {
                barImageView.setShowOval(true);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.o2.c.a f48071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f48072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f48074h;

        public a(InterestedForumAdapter interestedForumAdapter, c.a.t0.o2.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, aVar, interestedForumViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48074h = interestedForumAdapter;
            this.f48071e = aVar;
            this.f48072f = interestedForumViewHolder;
            this.f48073g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.f48071e.a.size() - 1;
                this.f48074h.k(size, this.f48071e);
                InterestedForumAdapter interestedForumAdapter = this.f48074h;
                InterestedForumViewHolder interestedForumViewHolder = this.f48072f;
                c.a.t0.o2.c.a aVar = this.f48071e;
                interestedForumAdapter.o(interestedForumViewHolder, aVar.a.get(aVar.f21402e));
                this.f48074h.k(size, this.f48071e);
                InterestedForumAdapter interestedForumAdapter2 = this.f48074h;
                InterestedForumViewHolder interestedForumViewHolder2 = this.f48072f;
                c.a.t0.o2.c.a aVar2 = this.f48071e;
                interestedForumAdapter2.m(interestedForumViewHolder2, aVar2.a.get(aVar2.f21402e));
                this.f48074h.k(size, this.f48071e);
                InterestedForumAdapter interestedForumAdapter3 = this.f48074h;
                InterestedForumViewHolder interestedForumViewHolder3 = this.f48072f;
                c.a.t0.o2.c.a aVar3 = this.f48071e;
                interestedForumAdapter3.l(interestedForumViewHolder3, aVar3.a.get(aVar3.f21402e));
                InterestedForumAdapter interestedForumAdapter4 = this.f48074h;
                interestedForumAdapter4.f48070d = interestedForumAdapter4.isCurrentPageSelectAll();
                this.f48074h.notifyItemChanged(this.f48073g);
                if (this.f48074h.f48069c != null) {
                    this.f48074h.f48069c.a(this.f48074h.f48068b, this.f48074h.f48070d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.f48071e.f21399b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f48075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f48076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f48077g;

        public b(InterestedForumAdapter interestedForumAdapter, g gVar, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, gVar, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48077g = interestedForumAdapter;
            this.f48075e = gVar;
            this.f48076f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f48075e;
                gVar.f21423b = !gVar.f21423b;
                c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
                if (!this.f48075e.f21423b) {
                    InterestedForumAdapter.j(this.f48077g);
                    this.f48076f.setText("感兴趣");
                    this.f48076f.setConfig(bVar);
                    this.f48077g.f48070d = false;
                } else {
                    InterestedForumAdapter.i(this.f48077g);
                    this.f48076f.setText("已选择");
                    bVar.s(R.color.CAM_X0109);
                    this.f48076f.setConfig(bVar);
                    InterestedForumAdapter interestedForumAdapter = this.f48077g;
                    interestedForumAdapter.f48070d = interestedForumAdapter.isCurrentPageSelectAll();
                }
                if (this.f48077g.f48069c != null) {
                    this.f48077g.f48069c.a(this.f48077g.f48068b, this.f48077g.f48070d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.f48075e.a.forum_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a(int i2, boolean z);
    }

    public InterestedForumAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static /* synthetic */ int i(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f48068b;
        interestedForumAdapter.f48068b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int j(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f48068b;
        interestedForumAdapter.f48068b = i2 - 1;
        return i2;
    }

    public void addData(List<c.a.t0.o2.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<c.a.t0.o2.c.a> getInterestedForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.t0.o2.c.a> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public boolean isCurrentPageSelectAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (c.a.t0.o2.c.a aVar : this.a) {
                int i2 = aVar.f21402e;
                if (!aVar.a.get(i2).f21423b) {
                    return false;
                }
                int size = i2 + (-1) < 0 ? aVar.a.size() - 1 : i2 - 1;
                if (!aVar.a.get(size).f21423b) {
                    return false;
                }
                if (!aVar.a.get(size + (-1) < 0 ? aVar.a.size() - 1 : size - 1).f21423b) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void k(int i2, c.a.t0.o2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, aVar) == null) {
            int i3 = aVar.f21402e;
            if (i3 < i2) {
                aVar.f21402e = i3 + 1;
            } else {
                aVar.f21402e = 0;
            }
        }
    }

    public final void l(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.bottomRecommendLayout.setVisibility(0);
            interestedForumViewHolder.bottomForumImage.setVisibility(0);
            interestedForumViewHolder.bottomForumImage.startLoad(gVar.a.avatar, 10, false);
            interestedForumViewHolder.bottomForumName.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.bottomForumDesc.setText(str);
            interestedForumViewHolder.bottomMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.bottomPostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            p(interestedForumViewHolder.bottomSelectInterest, gVar);
            n(gVar, interestedForumViewHolder.bottomSelectInterest);
        }
    }

    public final void m(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.middleRecommendLayout.setVisibility(0);
            interestedForumViewHolder.middleForumImage.setVisibility(0);
            interestedForumViewHolder.middleForumImage.startLoad(gVar.a.avatar, 10, false);
            interestedForumViewHolder.middleForumName.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.middleForumDesc.setText(str);
            interestedForumViewHolder.middleMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.middlePostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            p(interestedForumViewHolder.middleSelectInterest, gVar);
            n(gVar, interestedForumViewHolder.middleSelectInterest);
        }
    }

    public final void n(g gVar, TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gVar, tBSpecificationBtn) == null) {
            tBSpecificationBtn.setOnClickListener(new b(this, gVar, tBSpecificationBtn));
        }
    }

    public final void o(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.topRecommendLayout.setVisibility(0);
            interestedForumViewHolder.topForumImage.setVisibility(0);
            interestedForumViewHolder.topForumImage.startLoad(gVar.a.avatar, 10, false);
            interestedForumViewHolder.topForumName.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.topForumDesc.setText(str);
            interestedForumViewHolder.topMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.topPostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            p(interestedForumViewHolder.topSelectInterest, gVar);
            n(gVar, interestedForumViewHolder.topSelectInterest);
        }
    }

    public final void p(TBSpecificationBtn tBSpecificationBtn, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, tBSpecificationBtn, gVar) == null) {
            c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
            if (!gVar.f21423b) {
                tBSpecificationBtn.setText("感兴趣");
                tBSpecificationBtn.setConfig(bVar);
                return;
            }
            tBSpecificationBtn.setText("已选择");
            bVar.s(R.color.CAM_X0109);
            tBSpecificationBtn.setConfig(bVar);
        }
    }

    public final void q(c.a.t0.o2.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, aVar, i2) == null) || this.f48070d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.a.get(i2).a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    public void selectAll() {
        List<c.a.t0.o2.c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (list = this.a) == null || list.size() == 0) {
            return;
        }
        for (c.a.t0.o2.c.a aVar : this.a) {
            int i2 = aVar.f21402e;
            aVar.a.get(i2).f21423b = !this.f48070d;
            q(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.a.size() - 1 : i2 - 1;
            aVar.a.get(size).f21423b = !this.f48070d;
            q(aVar, size);
            if (size - 1 < 0) {
                size = aVar.a.size();
            }
            int i3 = size - 1;
            aVar.a.get(i3).f21423b = !this.f48070d;
            q(aVar, i3);
        }
        this.f48070d = !this.f48070d;
        notifyDataSetChanged();
        c cVar = this.f48069c;
        if (cVar != null) {
            boolean z = this.f48070d;
            if (z) {
                this.f48068b = this.a.size() * 3;
                this.f48069c.a(this.a.size() * 3, this.f48070d);
                return;
            }
            this.f48068b = 0;
            cVar.a(0, z);
        }
    }

    public void setSelectChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f48069c = cVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, interestedForumViewHolder, i2) == null) {
            c.a.t0.o2.c.a aVar = this.a.get(i2);
            interestedForumViewHolder.interestText.setText(aVar.f21400c);
            if (aVar.f21399b.intValue() > 0) {
                SkinManager.setImageResource(interestedForumViewHolder.interestIcon, c.a.t0.o2.g.a.b(aVar.f21399b.intValue()));
            }
            List<g> list = aVar.a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i3 = aVar.f21402e;
            if (i3 == 0) {
                if (aVar.a.size() >= 1) {
                    o(interestedForumViewHolder, aVar.a.get(0));
                }
                if (aVar.a.size() >= 2) {
                    m(interestedForumViewHolder, aVar.a.get(1));
                }
                if (aVar.a.size() >= 3) {
                    l(interestedForumViewHolder, aVar.a.get(2));
                }
                if (aVar.a.size() > 3) {
                    aVar.f21402e = 2;
                }
            } else {
                l(interestedForumViewHolder, aVar.a.get(i3));
                int size = i3 + (-1) < 0 ? aVar.a.size() - 1 : i3 - 1;
                m(interestedForumViewHolder, aVar.a.get(size));
                o(interestedForumViewHolder, aVar.a.get(size + (-1) < 0 ? aVar.a.size() - 1 : size - 1));
            }
            if (aVar.a.size() <= 3) {
                interestedForumViewHolder.interestChange.setEnabled(false);
            } else {
                interestedForumViewHolder.interestChange.setEnabled(true);
            }
            interestedForumViewHolder.interestChange.setOnClickListener(new a(this, aVar, interestedForumViewHolder, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, viewGroup, i2)) == null) ? new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null)) : (InterestedForumViewHolder) invokeLI.objValue;
    }
}
