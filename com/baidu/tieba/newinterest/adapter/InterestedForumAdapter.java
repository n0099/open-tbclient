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
import c.a.p0.s2.c.g;
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
/* loaded from: classes5.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.s2.c.a> a;

    /* renamed from: b  reason: collision with root package name */
    public int f34740b;

    /* renamed from: c  reason: collision with root package name */
    public c f34741c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34742d;

    /* loaded from: classes5.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f34743b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f34744c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f34745d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f34746e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f34747f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f34748g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f34749h;
        public BarImageView i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f19);
            this.f34743b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f27);
            this.f34744c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f12);
            this.f34745d = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0920c9);
            this.f34746e = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09141a);
            this.f34747f = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0903d6);
            this.f34748g = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f0920b5);
            this.f34749h = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f091415);
            this.i = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f0903c5);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920b6);
            this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091416);
            this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903c6);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920b4);
            this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091414);
            this.o = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903c4);
            this.p = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920c2);
            this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091418);
            this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903cd);
            this.s = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920c7);
            this.t = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091419);
            this.u = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903d3);
            this.v = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f0920ca);
            this.w = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f09141b);
            this.x = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f0903d8);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f34743b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f34744c, (int) R.color.CAM_X0107);
            this.f34743b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new c.a.o0.r.l0.n.b());
            this.w.setConfig(new c.a.o0.r.l0.n.b());
            this.x.setConfig(new c.a.o0.r.l0.n.b());
            a(this.f34748g);
            a(this.f34749h);
            a(this.i);
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.s2.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f34750b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f34751c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f34752d;

        public a(InterestedForumAdapter interestedForumAdapter, c.a.p0.s2.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, aVar, interestedForumViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34752d = interestedForumAdapter;
            this.a = aVar;
            this.f34750b = interestedForumViewHolder;
            this.f34751c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.a.a.size() - 1;
                this.f34752d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter = this.f34752d;
                InterestedForumViewHolder interestedForumViewHolder = this.f34750b;
                c.a.p0.s2.c.a aVar = this.a;
                interestedForumAdapter.y(interestedForumViewHolder, aVar.a.get(aVar.f18228e));
                this.f34752d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter2 = this.f34752d;
                InterestedForumViewHolder interestedForumViewHolder2 = this.f34750b;
                c.a.p0.s2.c.a aVar2 = this.a;
                interestedForumAdapter2.v(interestedForumViewHolder2, aVar2.a.get(aVar2.f18228e));
                this.f34752d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter3 = this.f34752d;
                InterestedForumViewHolder interestedForumViewHolder3 = this.f34750b;
                c.a.p0.s2.c.a aVar3 = this.a;
                interestedForumAdapter3.u(interestedForumViewHolder3, aVar3.a.get(aVar3.f18228e));
                InterestedForumAdapter interestedForumAdapter4 = this.f34752d;
                interestedForumAdapter4.f34742d = interestedForumAdapter4.q();
                this.f34752d.notifyItemChanged(this.f34751c);
                if (this.f34752d.f34741c != null) {
                    this.f34752d.f34741c.a(this.f34752d.f34740b, this.f34752d.f34742d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.a.f18225b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f34753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InterestedForumAdapter f34754c;

        public b(InterestedForumAdapter interestedForumAdapter, g gVar, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, gVar, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34754c = interestedForumAdapter;
            this.a = gVar;
            this.f34753b = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.a;
                gVar.f18247b = !gVar.f18247b;
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                if (!this.a.f18247b) {
                    InterestedForumAdapter.m(this.f34754c);
                    this.f34753b.setText("感兴趣");
                    this.f34753b.setConfig(bVar);
                    this.f34754c.f34742d = false;
                } else {
                    InterestedForumAdapter.l(this.f34754c);
                    this.f34753b.setText("已选择");
                    bVar.t(R.color.CAM_X0109);
                    this.f34753b.setConfig(bVar);
                    InterestedForumAdapter interestedForumAdapter = this.f34754c;
                    interestedForumAdapter.f34742d = interestedForumAdapter.q();
                }
                if (this.f34754c.f34741c != null) {
                    this.f34754c.f34741c.a(this.f34754c.f34740b, this.f34754c.f34742d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.a.a.forum_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, boolean z);
    }

    public InterestedForumAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f34740b;
        interestedForumAdapter.f34740b = i + 1;
        return i;
    }

    public static /* synthetic */ int m(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f34740b;
        interestedForumAdapter.f34740b = i - 1;
        return i;
    }

    public final void A(c.a.p0.s2.c.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) || this.f34742d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.a.get(i).a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<c.a.p0.s2.c.a> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void n(List<c.a.p0.s2.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<c.a.p0.s2.c.a> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void p(int i, c.a.p0.s2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, aVar) == null) {
            int i2 = aVar.f18228e;
            if (i2 < i) {
                aVar.f18228e = i2 + 1;
            } else {
                aVar.f18228e = 0;
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            for (c.a.p0.s2.c.a aVar : this.a) {
                int i = aVar.f18228e;
                if (!aVar.a.get(i).f18247b) {
                    return false;
                }
                int size = i + (-1) < 0 ? aVar.a.size() - 1 : i - 1;
                if (!aVar.a.get(size).f18247b) {
                    return false;
                }
                if (!aVar.a.get(size + (-1) < 0 ? aVar.a.size() - 1 : size - 1).f18247b) {
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
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, interestedForumViewHolder, i) == null) {
            c.a.p0.s2.c.a aVar = this.a.get(i);
            interestedForumViewHolder.f34743b.setText(aVar.f18226c);
            if (aVar.f18225b.intValue() > 0) {
                SkinManager.setImageResource(interestedForumViewHolder.a, c.a.p0.s2.g.a.b(aVar.f18225b.intValue()));
            }
            List<g> list = aVar.a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i2 = aVar.f18228e;
            if (i2 == 0) {
                if (aVar.a.size() >= 1) {
                    y(interestedForumViewHolder, aVar.a.get(0));
                }
                if (aVar.a.size() >= 2) {
                    v(interestedForumViewHolder, aVar.a.get(1));
                }
                if (aVar.a.size() >= 3) {
                    u(interestedForumViewHolder, aVar.a.get(2));
                }
                if (aVar.a.size() > 3) {
                    aVar.f18228e = 2;
                }
            } else {
                u(interestedForumViewHolder, aVar.a.get(i2));
                int size = i2 + (-1) < 0 ? aVar.a.size() - 1 : i2 - 1;
                v(interestedForumViewHolder, aVar.a.get(size));
                y(interestedForumViewHolder, aVar.a.get(size + (-1) < 0 ? aVar.a.size() - 1 : size - 1));
            }
            if (aVar.a.size() <= 3) {
                interestedForumViewHolder.f34744c.setEnabled(false);
            } else {
                interestedForumViewHolder.f34744c.setEnabled(true);
            }
            interestedForumViewHolder.f34744c.setOnClickListener(new a(this, aVar, interestedForumViewHolder, i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: s */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i)) == null) ? new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0504, (ViewGroup) null)) : (InterestedForumViewHolder) invokeLI.objValue;
    }

    public void t() {
        List<c.a.p0.s2.c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.a) == null || list.size() == 0) {
            return;
        }
        for (c.a.p0.s2.c.a aVar : this.a) {
            int i = aVar.f18228e;
            aVar.a.get(i).f18247b = !this.f34742d;
            A(aVar, i);
            int size = i + (-1) < 0 ? aVar.a.size() - 1 : i - 1;
            aVar.a.get(size).f18247b = !this.f34742d;
            A(aVar, size);
            if (size - 1 < 0) {
                size = aVar.a.size();
            }
            int i2 = size - 1;
            aVar.a.get(i2).f18247b = !this.f34742d;
            A(aVar, i2);
        }
        this.f34742d = !this.f34742d;
        notifyDataSetChanged();
        c cVar = this.f34741c;
        if (cVar != null) {
            boolean z = this.f34742d;
            if (z) {
                this.f34740b = this.a.size() * 3;
                this.f34741c.a(this.a.size() * 3, this.f34742d);
                return;
            }
            this.f34740b = 0;
            cVar.a(0, z);
        }
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.f34747f.setVisibility(0);
            interestedForumViewHolder.i.setVisibility(0);
            interestedForumViewHolder.i.J(gVar.a.avatar, 10, false);
            interestedForumViewHolder.l.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.o.setText(str);
            interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            z(interestedForumViewHolder.x, gVar);
            x(gVar, interestedForumViewHolder.x);
        }
    }

    public final void v(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.f34746e.setVisibility(0);
            interestedForumViewHolder.f34749h.setVisibility(0);
            interestedForumViewHolder.f34749h.J(gVar.a.avatar, 10, false);
            interestedForumViewHolder.k.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.n.setText(str);
            interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            z(interestedForumViewHolder.w, gVar);
            x(gVar, interestedForumViewHolder.w);
        }
    }

    public void w(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f34741c = cVar;
        }
    }

    public final void x(g gVar, TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, gVar, tBSpecificationBtn) == null) {
            tBSpecificationBtn.setOnClickListener(new b(this, gVar, tBSpecificationBtn));
        }
    }

    public final void y(InterestedForumViewHolder interestedForumViewHolder, g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, interestedForumViewHolder, gVar) == null) {
            interestedForumViewHolder.f34745d.setVisibility(0);
            interestedForumViewHolder.f34748g.setVisibility(0);
            interestedForumViewHolder.f34748g.J(gVar.a.avatar, 10, false);
            interestedForumViewHolder.j.setText(gVar.a.forum_name);
            if (TextUtils.isEmpty(gVar.a.slogan)) {
                str = "百度" + gVar.a.forum_name + "吧";
            } else {
                str = gVar.a.slogan;
            }
            interestedForumViewHolder.m.setText(str);
            interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(gVar.a.member_count.intValue()));
            interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(gVar.a.thread_count.intValue()));
            z(interestedForumViewHolder.v, gVar);
            x(gVar, interestedForumViewHolder.v);
        }
    }

    public final void z(TBSpecificationBtn tBSpecificationBtn, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, tBSpecificationBtn, gVar) == null) {
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            if (!gVar.f18247b) {
                tBSpecificationBtn.setText("感兴趣");
                tBSpecificationBtn.setConfig(bVar);
                return;
            }
            tBSpecificationBtn.setText("已选择");
            bVar.t(R.color.CAM_X0109);
            tBSpecificationBtn.setConfig(bVar);
        }
    }
}
