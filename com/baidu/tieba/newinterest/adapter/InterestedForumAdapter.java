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
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.z1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.i0.z1.c.a> f19023a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f19024b;

    /* renamed from: c  reason: collision with root package name */
    public c f19025c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19026d;

    /* loaded from: classes3.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f19027a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19028b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19029c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f19030d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f19031e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f19032f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f19033g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f19034h;
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

        public InterestedForumViewHolder(View view) {
            super(view);
            this.f19027a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f19028b = (TextView) view.findViewById(R.id.interest_text);
            this.f19029c = (TextView) view.findViewById(R.id.interest_change);
            this.f19030d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f19031e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f19032f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f19033g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f19034h = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.i = (BarImageView) view.findViewById(R.id.bottom_forum_image);
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
            SkinManager.setViewTextColor(this.f19028b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19029c, R.color.CAM_X0107);
            this.f19028b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.b.h0.r.f0.m.b());
            this.w.setConfig(new d.b.h0.r.f0.m.b());
            this.x.setConfig(new d.b.h0.r.f0.m.b());
            a(this.f19033g);
            a(this.f19034h);
            a(this.i);
        }

        public final void a(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.z1.c.a f19035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f19036f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19037g;

        public a(d.b.i0.z1.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i) {
            this.f19035e = aVar;
            this.f19036f = interestedForumViewHolder;
            this.f19037g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = this.f19035e.f64240a.size() - 1;
            InterestedForumAdapter.this.o(size, this.f19035e);
            InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder = this.f19036f;
            d.b.i0.z1.c.a aVar = this.f19035e;
            interestedForumAdapter.y(interestedForumViewHolder, aVar.f64240a.get(aVar.f64243d));
            InterestedForumAdapter.this.o(size, this.f19035e);
            InterestedForumAdapter interestedForumAdapter2 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder2 = this.f19036f;
            d.b.i0.z1.c.a aVar2 = this.f19035e;
            interestedForumAdapter2.v(interestedForumViewHolder2, aVar2.f64240a.get(aVar2.f64243d));
            InterestedForumAdapter.this.o(size, this.f19035e);
            InterestedForumAdapter interestedForumAdapter3 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder3 = this.f19036f;
            d.b.i0.z1.c.a aVar3 = this.f19035e;
            interestedForumAdapter3.u(interestedForumViewHolder3, aVar3.f64240a.get(aVar3.f64243d));
            InterestedForumAdapter interestedForumAdapter4 = InterestedForumAdapter.this;
            interestedForumAdapter4.f19026d = interestedForumAdapter4.p();
            InterestedForumAdapter.this.notifyItemChanged(this.f19037g);
            if (InterestedForumAdapter.this.f19025c != null) {
                InterestedForumAdapter.this.f19025c.c(InterestedForumAdapter.this.f19024b, InterestedForumAdapter.this.f19026d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_source", this.f19035e.f64241b.intValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f19040f;

        public b(d dVar, TBSpecificationBtn tBSpecificationBtn) {
            this.f19039e = dVar;
            this.f19040f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f19039e;
            dVar.f64250b = !dVar.f64250b;
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            if (!this.f19039e.f64250b) {
                InterestedForumAdapter.l(InterestedForumAdapter.this);
                this.f19040f.setText("感兴趣");
                this.f19040f.setConfig(bVar);
                InterestedForumAdapter.this.f19026d = false;
            } else {
                InterestedForumAdapter.k(InterestedForumAdapter.this);
                this.f19040f.setText("已选择");
                bVar.r(R.color.CAM_X0109);
                this.f19040f.setConfig(bVar);
                InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
                interestedForumAdapter.f19026d = interestedForumAdapter.p();
            }
            if (InterestedForumAdapter.this.f19025c != null) {
                InterestedForumAdapter.this.f19025c.c(InterestedForumAdapter.this.f19024b, InterestedForumAdapter.this.f19026d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", this.f19039e.f64249a.forum_id.longValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(int i, boolean z);
    }

    public static /* synthetic */ int k(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f19024b;
        interestedForumAdapter.f19024b = i + 1;
        return i;
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f19024b;
        interestedForumAdapter.f19024b = i - 1;
        return i;
    }

    public final void A(d.b.i0.z1.c.a aVar, int i) {
        if (this.f19026d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f64240a.get(i).f64249a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.b.i0.z1.c.a> list = this.f19023a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m(List<d.b.i0.z1.c.a> list) {
        this.f19023a.addAll(list);
        notifyDataSetChanged();
    }

    public List<d.b.i0.z1.c.a> n() {
        return this.f19023a;
    }

    public final void o(int i, d.b.i0.z1.c.a aVar) {
        int i2 = aVar.f64243d;
        if (i2 < i) {
            aVar.f64243d = i2 + 1;
        } else {
            aVar.f64243d = 0;
        }
    }

    public boolean p() {
        for (d.b.i0.z1.c.a aVar : this.f19023a) {
            int i = aVar.f64243d;
            if (!aVar.f64240a.get(i).f64250b) {
                return false;
            }
            int size = i + (-1) < 0 ? aVar.f64240a.size() - 1 : i - 1;
            if (!aVar.f64240a.get(size).f64250b) {
                return false;
            }
            if (!aVar.f64240a.get(size + (-1) < 0 ? aVar.f64240a.size() - 1 : size - 1).f64250b) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i) {
        d.b.i0.z1.c.a aVar = this.f19023a.get(i);
        interestedForumViewHolder.f19028b.setText(aVar.f64242c);
        if (aVar.f64241b.intValue() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f19027a, d.b.i0.z1.e.a.b(aVar.f64241b.intValue()), null);
        }
        List<d> list = aVar.f64240a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = aVar.f64243d;
        if (i2 == 0) {
            if (aVar.f64240a.size() >= 1) {
                y(interestedForumViewHolder, aVar.f64240a.get(0));
            }
            if (aVar.f64240a.size() >= 2) {
                v(interestedForumViewHolder, aVar.f64240a.get(1));
            }
            if (aVar.f64240a.size() >= 3) {
                u(interestedForumViewHolder, aVar.f64240a.get(2));
            }
            if (aVar.f64240a.size() > 3) {
                aVar.f64243d = 2;
            }
        } else {
            u(interestedForumViewHolder, aVar.f64240a.get(i2));
            int size = i2 + (-1) < 0 ? aVar.f64240a.size() - 1 : i2 - 1;
            v(interestedForumViewHolder, aVar.f64240a.get(size));
            y(interestedForumViewHolder, aVar.f64240a.get(size + (-1) < 0 ? aVar.f64240a.size() - 1 : size - 1));
        }
        if (aVar.f64240a.size() <= 3) {
            interestedForumViewHolder.f19029c.setEnabled(false);
        } else {
            interestedForumViewHolder.f19029c.setEnabled(true);
        }
        interestedForumViewHolder.f19029c.setOnClickListener(new a(aVar, interestedForumViewHolder, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    public void s() {
        List<d.b.i0.z1.c.a> list = this.f19023a;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.i0.z1.c.a aVar : this.f19023a) {
            int i = aVar.f64243d;
            aVar.f64240a.get(i).f64250b = !this.f19026d;
            A(aVar, i);
            int size = i + (-1) < 0 ? aVar.f64240a.size() - 1 : i - 1;
            aVar.f64240a.get(size).f64250b = !this.f19026d;
            A(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f64240a.size();
            }
            int i2 = size - 1;
            aVar.f64240a.get(i2).f64250b = !this.f19026d;
            A(aVar, i2);
        }
        this.f19026d = !this.f19026d;
        notifyDataSetChanged();
        c cVar = this.f19025c;
        if (cVar != null) {
            boolean z = this.f19026d;
            if (z) {
                this.f19024b = this.f19023a.size() * 3;
                this.f19025c.c(this.f19023a.size() * 3, this.f19026d);
                return;
            }
            this.f19024b = 0;
            cVar.c(0, z);
        }
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19032f.setVisibility(0);
        interestedForumViewHolder.i.setVisibility(0);
        interestedForumViewHolder.i.W(dVar.f64249a.avatar, 10, false);
        interestedForumViewHolder.l.setText(dVar.f64249a.forum_name);
        if (TextUtils.isEmpty(dVar.f64249a.slogan)) {
            str = "百度" + dVar.f64249a.forum_name + "吧";
        } else {
            str = dVar.f64249a.slogan;
        }
        interestedForumViewHolder.o.setText(str);
        interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.member_count.intValue()));
        interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.thread_count.intValue()));
        z(interestedForumViewHolder.x, dVar);
        x(dVar, interestedForumViewHolder.x);
    }

    public final void v(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19031e.setVisibility(0);
        interestedForumViewHolder.f19034h.setVisibility(0);
        interestedForumViewHolder.f19034h.W(dVar.f64249a.avatar, 10, false);
        interestedForumViewHolder.k.setText(dVar.f64249a.forum_name);
        if (TextUtils.isEmpty(dVar.f64249a.slogan)) {
            str = "百度" + dVar.f64249a.forum_name + "吧";
        } else {
            str = dVar.f64249a.slogan;
        }
        interestedForumViewHolder.n.setText(str);
        interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.member_count.intValue()));
        interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.thread_count.intValue()));
        z(interestedForumViewHolder.w, dVar);
        x(dVar, interestedForumViewHolder.w);
    }

    public void w(c cVar) {
        this.f19025c = cVar;
    }

    public final void x(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new b(dVar, tBSpecificationBtn));
    }

    public final void y(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19030d.setVisibility(0);
        interestedForumViewHolder.f19033g.setVisibility(0);
        interestedForumViewHolder.f19033g.W(dVar.f64249a.avatar, 10, false);
        interestedForumViewHolder.j.setText(dVar.f64249a.forum_name);
        if (TextUtils.isEmpty(dVar.f64249a.slogan)) {
            str = "百度" + dVar.f64249a.forum_name + "吧";
        } else {
            str = dVar.f64249a.slogan;
        }
        interestedForumViewHolder.m.setText(str);
        interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.member_count.intValue()));
        interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f64249a.thread_count.intValue()));
        z(interestedForumViewHolder.v, dVar);
        x(dVar, interestedForumViewHolder.v);
    }

    public final void z(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        if (!dVar.f64250b) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.r(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }
}
