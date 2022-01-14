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
    public int f46276b;

    /* renamed from: c  reason: collision with root package name */
    public c f46277c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46278d;

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
            this.topSelectInterest.setConfig(new c.a.s0.s.j0.n.b());
            this.middleSelectInterest.setConfig(new c.a.s0.s.j0.n.b());
            this.bottomSelectInterest.setConfig(new c.a.s0.s.j0.n.b());
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
        public final /* synthetic */ c.a.t0.o2.c.a f46279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f46280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f46282h;

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
            this.f46282h = interestedForumAdapter;
            this.f46279e = aVar;
            this.f46280f = interestedForumViewHolder;
            this.f46281g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.f46279e.a.size() - 1;
                this.f46282h.k(size, this.f46279e);
                InterestedForumAdapter interestedForumAdapter = this.f46282h;
                InterestedForumViewHolder interestedForumViewHolder = this.f46280f;
                c.a.t0.o2.c.a aVar = this.f46279e;
                interestedForumAdapter.o(interestedForumViewHolder, aVar.a.get(aVar.f20836e));
                this.f46282h.k(size, this.f46279e);
                InterestedForumAdapter interestedForumAdapter2 = this.f46282h;
                InterestedForumViewHolder interestedForumViewHolder2 = this.f46280f;
                c.a.t0.o2.c.a aVar2 = this.f46279e;
                interestedForumAdapter2.m(interestedForumViewHolder2, aVar2.a.get(aVar2.f20836e));
                this.f46282h.k(size, this.f46279e);
                InterestedForumAdapter interestedForumAdapter3 = this.f46282h;
                InterestedForumViewHolder interestedForumViewHolder3 = this.f46280f;
                c.a.t0.o2.c.a aVar3 = this.f46279e;
                interestedForumAdapter3.l(interestedForumViewHolder3, aVar3.a.get(aVar3.f20836e));
                InterestedForumAdapter interestedForumAdapter4 = this.f46282h;
                interestedForumAdapter4.f46278d = interestedForumAdapter4.isCurrentPageSelectAll();
                this.f46282h.notifyItemChanged(this.f46281g);
                if (this.f46282h.f46277c != null) {
                    this.f46282h.f46277c.a(this.f46282h.f46276b, this.f46282h.f46278d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.f46279e.f20833b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f46283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f46284f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f46285g;

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
            this.f46285g = interestedForumAdapter;
            this.f46283e = gVar;
            this.f46284f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f46283e;
                gVar.f20856b = !gVar.f20856b;
                c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
                if (!this.f46283e.f20856b) {
                    InterestedForumAdapter.j(this.f46285g);
                    this.f46284f.setText("感兴趣");
                    this.f46284f.setConfig(bVar);
                    this.f46285g.f46278d = false;
                } else {
                    InterestedForumAdapter.i(this.f46285g);
                    this.f46284f.setText("已选择");
                    bVar.s(R.color.CAM_X0109);
                    this.f46284f.setConfig(bVar);
                    InterestedForumAdapter interestedForumAdapter = this.f46285g;
                    interestedForumAdapter.f46278d = interestedForumAdapter.isCurrentPageSelectAll();
                }
                if (this.f46285g.f46277c != null) {
                    this.f46285g.f46277c.a(this.f46285g.f46276b, this.f46285g.f46278d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.f46283e.a.forum_id.longValue());
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
        int i2 = interestedForumAdapter.f46276b;
        interestedForumAdapter.f46276b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int j(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f46276b;
        interestedForumAdapter.f46276b = i2 - 1;
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
                int i2 = aVar.f20836e;
                if (!aVar.a.get(i2).f20856b) {
                    return false;
                }
                int size = i2 + (-1) < 0 ? aVar.a.size() - 1 : i2 - 1;
                if (!aVar.a.get(size).f20856b) {
                    return false;
                }
                if (!aVar.a.get(size + (-1) < 0 ? aVar.a.size() - 1 : size - 1).f20856b) {
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
            int i3 = aVar.f20836e;
            if (i3 < i2) {
                aVar.f20836e = i3 + 1;
            } else {
                aVar.f20836e = 0;
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
            c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
            if (!gVar.f20856b) {
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
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, aVar, i2) == null) || this.f46278d) {
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
            int i2 = aVar.f20836e;
            aVar.a.get(i2).f20856b = !this.f46278d;
            q(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.a.size() - 1 : i2 - 1;
            aVar.a.get(size).f20856b = !this.f46278d;
            q(aVar, size);
            if (size - 1 < 0) {
                size = aVar.a.size();
            }
            int i3 = size - 1;
            aVar.a.get(i3).f20856b = !this.f46278d;
            q(aVar, i3);
        }
        this.f46278d = !this.f46278d;
        notifyDataSetChanged();
        c cVar = this.f46277c;
        if (cVar != null) {
            boolean z = this.f46278d;
            if (z) {
                this.f46276b = this.a.size() * 3;
                this.f46277c.a(this.a.size() * 3, this.f46278d);
                return;
            }
            this.f46276b = 0;
            cVar.a(0, z);
        }
    }

    public void setSelectChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f46277c = cVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, interestedForumViewHolder, i2) == null) {
            c.a.t0.o2.c.a aVar = this.a.get(i2);
            interestedForumViewHolder.interestText.setText(aVar.f20834c);
            if (aVar.f20833b.intValue() > 0) {
                SkinManager.setImageResource(interestedForumViewHolder.interestIcon, c.a.t0.o2.g.a.b(aVar.f20833b.intValue()));
            }
            List<g> list = aVar.a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i3 = aVar.f20836e;
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
                    aVar.f20836e = 2;
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
