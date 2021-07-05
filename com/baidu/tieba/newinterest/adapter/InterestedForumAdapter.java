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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.d2.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.s0.d2.c.a> f18970a;

    /* renamed from: b  reason: collision with root package name */
    public int f18971b;

    /* renamed from: c  reason: collision with root package name */
    public c f18972c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18973d;

    /* loaded from: classes5.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18974a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18975b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18976c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f18977d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f18978e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f18979f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f18980g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f18981h;

        /* renamed from: i  reason: collision with root package name */
        public BarImageView f18982i;
        public TextView j;
        public TextView k;
        public TextView l;
        public TextView m;
        public TextView n;
        public TextView o;
        public TextView p;
        public TextView q;
        public TextView r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TBSpecificationBtn v;
        public TBSpecificationBtn w;
        public TBSpecificationBtn x;

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
            this.f18974a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f18975b = (TextView) view.findViewById(R.id.interest_text);
            this.f18976c = (TextView) view.findViewById(R.id.interest_change);
            this.f18977d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f18978e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f18979f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f18980g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f18981h = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.f18982i = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.j = (TextView) view.findViewById(R.id.top_forum_name);
            this.k = (TextView) view.findViewById(R.id.middle_forum_name);
            this.l = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.m = (TextView) view.findViewById(R.id.top_forum_desc);
            this.n = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.o = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.p = (TextView) view.findViewById(R.id.top_member_text);
            this.q = (TextView) view.findViewById(R.id.middle_member_text);
            this.r = (TextView) view.findViewById(R.id.bottom_member_text);
            this.s = (TextView) view.findViewById(R.id.top_post_text);
            this.t = (TextView) view.findViewById(R.id.middle_post_text);
            this.u = (TextView) view.findViewById(R.id.bottom_post_text);
            this.v = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.w = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.x = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f18975b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18976c, R.color.CAM_X0107);
            this.f18975b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.a.r0.r.f0.m.b());
            this.w.setConfig(new d.a.r0.r.f0.m.b());
            this.x.setConfig(new d.a.r0.r.f0.m.b());
            a(this.f18980g);
            a(this.f18981h);
            a(this.f18982i);
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.d2.c.a f18983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f18984f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f18986h;

        public a(InterestedForumAdapter interestedForumAdapter, d.a.s0.d2.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
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
            this.f18986h = interestedForumAdapter;
            this.f18983e = aVar;
            this.f18984f = interestedForumViewHolder;
            this.f18985g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.f18983e.f58162a.size() - 1;
                this.f18986h.p(size, this.f18983e);
                InterestedForumAdapter interestedForumAdapter = this.f18986h;
                InterestedForumViewHolder interestedForumViewHolder = this.f18984f;
                d.a.s0.d2.c.a aVar = this.f18983e;
                interestedForumAdapter.y(interestedForumViewHolder, aVar.f58162a.get(aVar.f58165d));
                this.f18986h.p(size, this.f18983e);
                InterestedForumAdapter interestedForumAdapter2 = this.f18986h;
                InterestedForumViewHolder interestedForumViewHolder2 = this.f18984f;
                d.a.s0.d2.c.a aVar2 = this.f18983e;
                interestedForumAdapter2.v(interestedForumViewHolder2, aVar2.f58162a.get(aVar2.f58165d));
                this.f18986h.p(size, this.f18983e);
                InterestedForumAdapter interestedForumAdapter3 = this.f18986h;
                InterestedForumViewHolder interestedForumViewHolder3 = this.f18984f;
                d.a.s0.d2.c.a aVar3 = this.f18983e;
                interestedForumAdapter3.u(interestedForumViewHolder3, aVar3.f58162a.get(aVar3.f58165d));
                InterestedForumAdapter interestedForumAdapter4 = this.f18986h;
                interestedForumAdapter4.f18973d = interestedForumAdapter4.q();
                this.f18986h.notifyItemChanged(this.f18985g);
                if (this.f18986h.f18972c != null) {
                    this.f18986h.f18972c.c(this.f18986h.f18971b, this.f18986h.f18973d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.f18983e.f58163b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f18988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f18989g;

        public b(InterestedForumAdapter interestedForumAdapter, d dVar, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, dVar, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18989g = interestedForumAdapter;
            this.f18987e = dVar;
            this.f18988f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d dVar = this.f18987e;
                dVar.f58172b = !dVar.f58172b;
                d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
                if (!this.f18987e.f58172b) {
                    InterestedForumAdapter.m(this.f18989g);
                    this.f18988f.setText("感兴趣");
                    this.f18988f.setConfig(bVar);
                    this.f18989g.f18973d = false;
                } else {
                    InterestedForumAdapter.l(this.f18989g);
                    this.f18988f.setText("已选择");
                    bVar.r(R.color.CAM_X0109);
                    this.f18988f.setConfig(bVar);
                    InterestedForumAdapter interestedForumAdapter = this.f18989g;
                    interestedForumAdapter.f18973d = interestedForumAdapter.q();
                }
                if (this.f18989g.f18972c != null) {
                    this.f18989g.f18972c.c(this.f18989g.f18971b, this.f18989g.f18973d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.f18987e.f58171a.forum_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(int i2, boolean z);
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
        this.f18970a = new ArrayList();
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18971b;
        interestedForumAdapter.f18971b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int m(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18971b;
        interestedForumAdapter.f18971b = i2 - 1;
        return i2;
    }

    public final void A(d.a.s0.d2.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || this.f18973d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f58162a.get(i2).f58171a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<d.a.s0.d2.c.a> list = this.f18970a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void n(List<d.a.s0.d2.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18970a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<d.a.s0.d2.c.a> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18970a : (List) invokeV.objValue;
    }

    public final void p(int i2, d.a.s0.d2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, aVar) == null) {
            int i3 = aVar.f58165d;
            if (i3 < i2) {
                aVar.f58165d = i3 + 1;
            } else {
                aVar.f58165d = 0;
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            for (d.a.s0.d2.c.a aVar : this.f18970a) {
                int i2 = aVar.f58165d;
                if (!aVar.f58162a.get(i2).f58172b) {
                    return false;
                }
                int size = i2 + (-1) < 0 ? aVar.f58162a.size() - 1 : i2 - 1;
                if (!aVar.f58162a.get(size).f58172b) {
                    return false;
                }
                if (!aVar.f58162a.get(size + (-1) < 0 ? aVar.f58162a.size() - 1 : size - 1).f58172b) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, interestedForumViewHolder, i2) == null) {
            d.a.s0.d2.c.a aVar = this.f18970a.get(i2);
            interestedForumViewHolder.f18975b.setText(aVar.f58164c);
            if (aVar.f58163b.intValue() > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f18974a, d.a.s0.d2.e.a.b(aVar.f58163b.intValue()), null);
            }
            List<d> list = aVar.f58162a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i3 = aVar.f58165d;
            if (i3 == 0) {
                if (aVar.f58162a.size() >= 1) {
                    y(interestedForumViewHolder, aVar.f58162a.get(0));
                }
                if (aVar.f58162a.size() >= 2) {
                    v(interestedForumViewHolder, aVar.f58162a.get(1));
                }
                if (aVar.f58162a.size() >= 3) {
                    u(interestedForumViewHolder, aVar.f58162a.get(2));
                }
                if (aVar.f58162a.size() > 3) {
                    aVar.f58165d = 2;
                }
            } else {
                u(interestedForumViewHolder, aVar.f58162a.get(i3));
                int size = i3 + (-1) < 0 ? aVar.f58162a.size() - 1 : i3 - 1;
                v(interestedForumViewHolder, aVar.f58162a.get(size));
                y(interestedForumViewHolder, aVar.f58162a.get(size + (-1) < 0 ? aVar.f58162a.size() - 1 : size - 1));
            }
            if (aVar.f58162a.size() <= 3) {
                interestedForumViewHolder.f18976c.setEnabled(false);
            } else {
                interestedForumViewHolder.f18976c.setEnabled(true);
            }
            interestedForumViewHolder.f18976c.setOnClickListener(new a(this, aVar, interestedForumViewHolder, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: s */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) ? new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null)) : (InterestedForumViewHolder) invokeLI.objValue;
    }

    public void t() {
        List<d.a.s0.d2.c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.f18970a) == null || list.size() == 0) {
            return;
        }
        for (d.a.s0.d2.c.a aVar : this.f18970a) {
            int i2 = aVar.f58165d;
            aVar.f58162a.get(i2).f58172b = !this.f18973d;
            A(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.f58162a.size() - 1 : i2 - 1;
            aVar.f58162a.get(size).f58172b = !this.f18973d;
            A(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f58162a.size();
            }
            int i3 = size - 1;
            aVar.f58162a.get(i3).f58172b = !this.f18973d;
            A(aVar, i3);
        }
        this.f18973d = !this.f18973d;
        notifyDataSetChanged();
        c cVar = this.f18972c;
        if (cVar != null) {
            boolean z = this.f18973d;
            if (z) {
                this.f18971b = this.f18970a.size() * 3;
                this.f18972c.c(this.f18970a.size() * 3, this.f18973d);
                return;
            }
            this.f18971b = 0;
            cVar.c(0, z);
        }
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, interestedForumViewHolder, dVar) == null) {
            interestedForumViewHolder.f18979f.setVisibility(0);
            interestedForumViewHolder.f18982i.setVisibility(0);
            interestedForumViewHolder.f18982i.M(dVar.f58171a.avatar, 10, false);
            interestedForumViewHolder.l.setText(dVar.f58171a.forum_name);
            if (TextUtils.isEmpty(dVar.f58171a.slogan)) {
                str = "百度" + dVar.f58171a.forum_name + "吧";
            } else {
                str = dVar.f58171a.slogan;
            }
            interestedForumViewHolder.o.setText(str);
            interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.member_count.intValue()));
            interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.thread_count.intValue()));
            z(interestedForumViewHolder.x, dVar);
            x(dVar, interestedForumViewHolder.x);
        }
    }

    public final void v(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, interestedForumViewHolder, dVar) == null) {
            interestedForumViewHolder.f18978e.setVisibility(0);
            interestedForumViewHolder.f18981h.setVisibility(0);
            interestedForumViewHolder.f18981h.M(dVar.f58171a.avatar, 10, false);
            interestedForumViewHolder.k.setText(dVar.f58171a.forum_name);
            if (TextUtils.isEmpty(dVar.f58171a.slogan)) {
                str = "百度" + dVar.f58171a.forum_name + "吧";
            } else {
                str = dVar.f58171a.slogan;
            }
            interestedForumViewHolder.n.setText(str);
            interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.member_count.intValue()));
            interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.thread_count.intValue()));
            z(interestedForumViewHolder.w, dVar);
            x(dVar, interestedForumViewHolder.w);
        }
    }

    public void w(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f18972c = cVar;
        }
    }

    public final void x(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, dVar, tBSpecificationBtn) == null) {
            tBSpecificationBtn.setOnClickListener(new b(this, dVar, tBSpecificationBtn));
        }
    }

    public final void y(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, interestedForumViewHolder, dVar) == null) {
            interestedForumViewHolder.f18977d.setVisibility(0);
            interestedForumViewHolder.f18980g.setVisibility(0);
            interestedForumViewHolder.f18980g.M(dVar.f58171a.avatar, 10, false);
            interestedForumViewHolder.j.setText(dVar.f58171a.forum_name);
            if (TextUtils.isEmpty(dVar.f58171a.slogan)) {
                str = "百度" + dVar.f58171a.forum_name + "吧";
            } else {
                str = dVar.f58171a.slogan;
            }
            interestedForumViewHolder.m.setText(str);
            interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.member_count.intValue()));
            interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f58171a.thread_count.intValue()));
            z(interestedForumViewHolder.v, dVar);
            x(dVar, interestedForumViewHolder.v);
        }
    }

    public final void z(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, tBSpecificationBtn, dVar) == null) {
            d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
            if (!dVar.f58172b) {
                tBSpecificationBtn.setText("感兴趣");
                tBSpecificationBtn.setConfig(bVar);
                return;
            }
            tBSpecificationBtn.setText("已选择");
            bVar.r(R.color.CAM_X0109);
            tBSpecificationBtn.setConfig(bVar);
        }
    }
}
