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
import b.a.e.e.p.l;
import b.a.r0.g2.c.g;
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
/* loaded from: classes9.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.r0.g2.c.a> f51971a;

    /* renamed from: b  reason: collision with root package name */
    public int f51972b;

    /* renamed from: c  reason: collision with root package name */
    public c f51973c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51974d;

    /* loaded from: classes9.dex */
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
            this.topSelectInterest.setConfig(new b.a.q0.s.g0.n.b());
            this.middleSelectInterest.setConfig(new b.a.q0.s.g0.n.b());
            this.bottomSelectInterest.setConfig(new b.a.q0.s.g0.n.b());
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
                barImageView.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.g2.c.a f51975e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f51976f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51977g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f51978h;

        public a(InterestedForumAdapter interestedForumAdapter, b.a.r0.g2.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
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
            this.f51978h = interestedForumAdapter;
            this.f51975e = aVar;
            this.f51976f = interestedForumViewHolder;
            this.f51977g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.f51975e.f16762a.size() - 1;
                this.f51978h.k(size, this.f51975e);
                InterestedForumAdapter interestedForumAdapter = this.f51978h;
                InterestedForumViewHolder interestedForumViewHolder = this.f51976f;
                b.a.r0.g2.c.a aVar = this.f51975e;
                interestedForumAdapter.o(interestedForumViewHolder, aVar.f16762a.get(aVar.f16766e));
                this.f51978h.k(size, this.f51975e);
                InterestedForumAdapter interestedForumAdapter2 = this.f51978h;
                InterestedForumViewHolder interestedForumViewHolder2 = this.f51976f;
                b.a.r0.g2.c.a aVar2 = this.f51975e;
                interestedForumAdapter2.m(interestedForumViewHolder2, aVar2.f16762a.get(aVar2.f16766e));
                this.f51978h.k(size, this.f51975e);
                InterestedForumAdapter interestedForumAdapter3 = this.f51978h;
                InterestedForumViewHolder interestedForumViewHolder3 = this.f51976f;
                b.a.r0.g2.c.a aVar3 = this.f51975e;
                interestedForumAdapter3.l(interestedForumViewHolder3, aVar3.f16762a.get(aVar3.f16766e));
                InterestedForumAdapter interestedForumAdapter4 = this.f51978h;
                interestedForumAdapter4.f51974d = interestedForumAdapter4.isCurrentPageSelectAll();
                this.f51978h.notifyItemChanged(this.f51977g);
                if (this.f51978h.f51973c != null) {
                    this.f51978h.f51973c.a(this.f51978h.f51972b, this.f51978h.f51974d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.f51975e.f16763b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f51979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f51980f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f51981g;

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
            this.f51981g = interestedForumAdapter;
            this.f51979e = gVar;
            this.f51980f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f51979e;
                gVar.f16788b = !gVar.f16788b;
                b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
                if (!this.f51979e.f16788b) {
                    InterestedForumAdapter.j(this.f51981g);
                    this.f51980f.setText("感兴趣");
                    this.f51980f.setConfig(bVar);
                    this.f51981g.f51974d = false;
                } else {
                    InterestedForumAdapter.i(this.f51981g);
                    this.f51980f.setText("已选择");
                    bVar.s(R.color.CAM_X0109);
                    this.f51980f.setConfig(bVar);
                    InterestedForumAdapter interestedForumAdapter = this.f51981g;
                    interestedForumAdapter.f51974d = interestedForumAdapter.isCurrentPageSelectAll();
                }
                if (this.f51981g.f51973c != null) {
                    this.f51981g.f51973c.a(this.f51981g.f51972b, this.f51981g.f51974d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.f51979e.f16787a.forum_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f51971a = new ArrayList();
    }

    public static /* synthetic */ int i(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f51972b;
        interestedForumAdapter.f51972b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int j(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f51972b;
        interestedForumAdapter.f51972b = i2 - 1;
        return i2;
    }

    public void addData(List<b.a.r0.g2.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f51971a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<b.a.r0.g2.c.a> getInterestedForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51971a : (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<b.a.r0.g2.c.a> list = this.f51971a;
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
            for (b.a.r0.g2.c.a aVar : this.f51971a) {
                int i2 = aVar.f16766e;
                if (!aVar.f16762a.get(i2).f16788b) {
                    return false;
                }
                int size = i2 + (-1) < 0 ? aVar.f16762a.size() - 1 : i2 - 1;
                if (!aVar.f16762a.get(size).f16788b) {
                    return false;
                }
                if (!aVar.f16762a.get(size + (-1) < 0 ? aVar.f16762a.size() - 1 : size - 1).f16788b) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void k(int i2, b.a.r0.g2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, aVar) == null) {
            int i3 = aVar.f16766e;
            if (i3 < i2) {
                aVar.f16766e = i3 + 1;
            } else {
                aVar.f16766e = 0;
            }
        }
    }

    public final void l(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.bottomRecommendLayout.setVisibility(0);
            interestedForumViewHolder.bottomForumImage.setVisibility(0);
            interestedForumViewHolder.bottomForumImage.startLoad(gVar.f16787a.avatar, 10, false);
            interestedForumViewHolder.bottomForumName.setText(gVar.f16787a.forum_name);
            if (TextUtils.isEmpty(gVar.f16787a.slogan)) {
                str = "百度" + gVar.f16787a.forum_name + "吧";
            } else {
                str = gVar.f16787a.slogan;
            }
            interestedForumViewHolder.bottomForumDesc.setText(str);
            interestedForumViewHolder.bottomMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.member_count.intValue()));
            interestedForumViewHolder.bottomPostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.thread_count.intValue()));
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
            interestedForumViewHolder.middleForumImage.startLoad(gVar.f16787a.avatar, 10, false);
            interestedForumViewHolder.middleForumName.setText(gVar.f16787a.forum_name);
            if (TextUtils.isEmpty(gVar.f16787a.slogan)) {
                str = "百度" + gVar.f16787a.forum_name + "吧";
            } else {
                str = gVar.f16787a.slogan;
            }
            interestedForumViewHolder.middleForumDesc.setText(str);
            interestedForumViewHolder.middleMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.member_count.intValue()));
            interestedForumViewHolder.middlePostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.thread_count.intValue()));
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
            interestedForumViewHolder.topForumImage.startLoad(gVar.f16787a.avatar, 10, false);
            interestedForumViewHolder.topForumName.setText(gVar.f16787a.forum_name);
            if (TextUtils.isEmpty(gVar.f16787a.slogan)) {
                str = "百度" + gVar.f16787a.forum_name + "吧";
            } else {
                str = gVar.f16787a.slogan;
            }
            interestedForumViewHolder.topForumDesc.setText(str);
            interestedForumViewHolder.topMemberText.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.member_count.intValue()));
            interestedForumViewHolder.topPostText.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.f16787a.thread_count.intValue()));
            p(interestedForumViewHolder.topSelectInterest, gVar);
            n(gVar, interestedForumViewHolder.topSelectInterest);
        }
    }

    public final void p(TBSpecificationBtn tBSpecificationBtn, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, tBSpecificationBtn, gVar) == null) {
            b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
            if (!gVar.f16788b) {
                tBSpecificationBtn.setText("感兴趣");
                tBSpecificationBtn.setConfig(bVar);
                return;
            }
            tBSpecificationBtn.setText("已选择");
            bVar.s(R.color.CAM_X0109);
            tBSpecificationBtn.setConfig(bVar);
        }
    }

    public final void q(b.a.r0.g2.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, aVar, i2) == null) || this.f51974d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f16762a.get(i2).f16787a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    public void selectAll() {
        List<b.a.r0.g2.c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (list = this.f51971a) == null || list.size() == 0) {
            return;
        }
        for (b.a.r0.g2.c.a aVar : this.f51971a) {
            int i2 = aVar.f16766e;
            aVar.f16762a.get(i2).f16788b = !this.f51974d;
            q(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.f16762a.size() - 1 : i2 - 1;
            aVar.f16762a.get(size).f16788b = !this.f51974d;
            q(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f16762a.size();
            }
            int i3 = size - 1;
            aVar.f16762a.get(i3).f16788b = !this.f51974d;
            q(aVar, i3);
        }
        this.f51974d = !this.f51974d;
        notifyDataSetChanged();
        c cVar = this.f51973c;
        if (cVar != null) {
            boolean z = this.f51974d;
            if (z) {
                this.f51972b = this.f51971a.size() * 3;
                this.f51973c.a(this.f51971a.size() * 3, this.f51974d);
                return;
            }
            this.f51972b = 0;
            cVar.a(0, z);
        }
    }

    public void setSelectChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f51973c = cVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, interestedForumViewHolder, i2) == null) {
            b.a.r0.g2.c.a aVar = this.f51971a.get(i2);
            interestedForumViewHolder.interestText.setText(aVar.f16764c);
            if (aVar.f16763b.intValue() > 0) {
                SkinManager.setImageResource(interestedForumViewHolder.interestIcon, b.a.r0.g2.g.a.b(aVar.f16763b.intValue()));
            }
            List<g> list = aVar.f16762a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i3 = aVar.f16766e;
            if (i3 == 0) {
                if (aVar.f16762a.size() >= 1) {
                    o(interestedForumViewHolder, aVar.f16762a.get(0));
                }
                if (aVar.f16762a.size() >= 2) {
                    m(interestedForumViewHolder, aVar.f16762a.get(1));
                }
                if (aVar.f16762a.size() >= 3) {
                    l(interestedForumViewHolder, aVar.f16762a.get(2));
                }
                if (aVar.f16762a.size() > 3) {
                    aVar.f16766e = 2;
                }
            } else {
                l(interestedForumViewHolder, aVar.f16762a.get(i3));
                int size = i3 + (-1) < 0 ? aVar.f16762a.size() - 1 : i3 - 1;
                m(interestedForumViewHolder, aVar.f16762a.get(size));
                o(interestedForumViewHolder, aVar.f16762a.get(size + (-1) < 0 ? aVar.f16762a.size() - 1 : size - 1));
            }
            if (aVar.f16762a.size() <= 3) {
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
