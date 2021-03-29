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
import d.b.b.e.p.l;
import d.b.i0.y1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.i0.y1.c.a> f19346a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f19347b;

    /* renamed from: c  reason: collision with root package name */
    public c f19348c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19349d;

    /* loaded from: classes3.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f19350a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19351b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19352c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f19353d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f19354e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f19355f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f19356g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f19357h;
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
            this.f19350a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f19351b = (TextView) view.findViewById(R.id.interest_text);
            this.f19352c = (TextView) view.findViewById(R.id.interest_change);
            this.f19353d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f19354e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f19355f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f19356g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f19357h = (BarImageView) view.findViewById(R.id.middle_forum_image);
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
            SkinManager.setViewTextColor(this.f19351b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19352c, R.color.CAM_X0107);
            this.f19351b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.b.h0.r.f0.m.b());
            this.w.setConfig(new d.b.h0.r.f0.m.b());
            this.x.setConfig(new d.b.h0.r.f0.m.b());
            a(this.f19356g);
            a(this.f19357h);
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
        public final /* synthetic */ d.b.i0.y1.c.a f19358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f19359f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19360g;

        public a(d.b.i0.y1.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i) {
            this.f19358e = aVar;
            this.f19359f = interestedForumViewHolder;
            this.f19360g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = this.f19358e.f62579a.size() - 1;
            InterestedForumAdapter.this.o(size, this.f19358e);
            InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder = this.f19359f;
            d.b.i0.y1.c.a aVar = this.f19358e;
            interestedForumAdapter.y(interestedForumViewHolder, aVar.f62579a.get(aVar.f62582d));
            InterestedForumAdapter.this.o(size, this.f19358e);
            InterestedForumAdapter interestedForumAdapter2 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder2 = this.f19359f;
            d.b.i0.y1.c.a aVar2 = this.f19358e;
            interestedForumAdapter2.v(interestedForumViewHolder2, aVar2.f62579a.get(aVar2.f62582d));
            InterestedForumAdapter.this.o(size, this.f19358e);
            InterestedForumAdapter interestedForumAdapter3 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder3 = this.f19359f;
            d.b.i0.y1.c.a aVar3 = this.f19358e;
            interestedForumAdapter3.u(interestedForumViewHolder3, aVar3.f62579a.get(aVar3.f62582d));
            InterestedForumAdapter interestedForumAdapter4 = InterestedForumAdapter.this;
            interestedForumAdapter4.f19349d = interestedForumAdapter4.p();
            InterestedForumAdapter.this.notifyItemChanged(this.f19360g);
            if (InterestedForumAdapter.this.f19348c != null) {
                InterestedForumAdapter.this.f19348c.c(InterestedForumAdapter.this.f19347b, InterestedForumAdapter.this.f19349d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_source", this.f19358e.f62580b.intValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19362e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f19363f;

        public b(d dVar, TBSpecificationBtn tBSpecificationBtn) {
            this.f19362e = dVar;
            this.f19363f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f19362e;
            dVar.f62589b = !dVar.f62589b;
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            if (!this.f19362e.f62589b) {
                InterestedForumAdapter.l(InterestedForumAdapter.this);
                this.f19363f.setText("感兴趣");
                this.f19363f.setConfig(bVar);
                InterestedForumAdapter.this.f19349d = false;
            } else {
                InterestedForumAdapter.k(InterestedForumAdapter.this);
                this.f19363f.setText("已选择");
                bVar.r(R.color.CAM_X0109);
                this.f19363f.setConfig(bVar);
                InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
                interestedForumAdapter.f19349d = interestedForumAdapter.p();
            }
            if (InterestedForumAdapter.this.f19348c != null) {
                InterestedForumAdapter.this.f19348c.c(InterestedForumAdapter.this.f19347b, InterestedForumAdapter.this.f19349d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", this.f19362e.f62588a.forum_id.longValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(int i, boolean z);
    }

    public static /* synthetic */ int k(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f19347b;
        interestedForumAdapter.f19347b = i + 1;
        return i;
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.f19347b;
        interestedForumAdapter.f19347b = i - 1;
        return i;
    }

    public final void A(d.b.i0.y1.c.a aVar, int i) {
        if (this.f19349d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f62579a.get(i).f62588a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.b.i0.y1.c.a> list = this.f19346a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m(List<d.b.i0.y1.c.a> list) {
        this.f19346a.addAll(list);
        notifyDataSetChanged();
    }

    public List<d.b.i0.y1.c.a> n() {
        return this.f19346a;
    }

    public final void o(int i, d.b.i0.y1.c.a aVar) {
        int i2 = aVar.f62582d;
        if (i2 < i) {
            aVar.f62582d = i2 + 1;
        } else {
            aVar.f62582d = 0;
        }
    }

    public boolean p() {
        for (d.b.i0.y1.c.a aVar : this.f19346a) {
            int i = aVar.f62582d;
            if (!aVar.f62579a.get(i).f62589b) {
                return false;
            }
            int size = i + (-1) < 0 ? aVar.f62579a.size() - 1 : i - 1;
            if (!aVar.f62579a.get(size).f62589b) {
                return false;
            }
            if (!aVar.f62579a.get(size + (-1) < 0 ? aVar.f62579a.size() - 1 : size - 1).f62589b) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i) {
        d.b.i0.y1.c.a aVar = this.f19346a.get(i);
        interestedForumViewHolder.f19351b.setText(aVar.f62581c);
        if (aVar.f62580b.intValue() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f19350a, d.b.i0.y1.e.a.b(aVar.f62580b.intValue()), null);
        }
        List<d> list = aVar.f62579a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = aVar.f62582d;
        if (i2 == 0) {
            if (aVar.f62579a.size() >= 1) {
                y(interestedForumViewHolder, aVar.f62579a.get(0));
            }
            if (aVar.f62579a.size() >= 2) {
                v(interestedForumViewHolder, aVar.f62579a.get(1));
            }
            if (aVar.f62579a.size() >= 3) {
                u(interestedForumViewHolder, aVar.f62579a.get(2));
            }
            if (aVar.f62579a.size() > 3) {
                aVar.f62582d = 2;
            }
        } else {
            u(interestedForumViewHolder, aVar.f62579a.get(i2));
            int size = i2 + (-1) < 0 ? aVar.f62579a.size() - 1 : i2 - 1;
            v(interestedForumViewHolder, aVar.f62579a.get(size));
            y(interestedForumViewHolder, aVar.f62579a.get(size + (-1) < 0 ? aVar.f62579a.size() - 1 : size - 1));
        }
        if (aVar.f62579a.size() <= 3) {
            interestedForumViewHolder.f19352c.setEnabled(false);
        } else {
            interestedForumViewHolder.f19352c.setEnabled(true);
        }
        interestedForumViewHolder.f19352c.setOnClickListener(new a(aVar, interestedForumViewHolder, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    public void s() {
        List<d.b.i0.y1.c.a> list = this.f19346a;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.i0.y1.c.a aVar : this.f19346a) {
            int i = aVar.f62582d;
            aVar.f62579a.get(i).f62589b = !this.f19349d;
            A(aVar, i);
            int size = i + (-1) < 0 ? aVar.f62579a.size() - 1 : i - 1;
            aVar.f62579a.get(size).f62589b = !this.f19349d;
            A(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f62579a.size();
            }
            int i2 = size - 1;
            aVar.f62579a.get(i2).f62589b = !this.f19349d;
            A(aVar, i2);
        }
        this.f19349d = !this.f19349d;
        notifyDataSetChanged();
        c cVar = this.f19348c;
        if (cVar != null) {
            boolean z = this.f19349d;
            if (z) {
                this.f19347b = this.f19346a.size() * 3;
                this.f19348c.c(this.f19346a.size() * 3, this.f19349d);
                return;
            }
            this.f19347b = 0;
            cVar.c(0, z);
        }
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19355f.setVisibility(0);
        interestedForumViewHolder.i.setVisibility(0);
        interestedForumViewHolder.i.W(dVar.f62588a.avatar, 10, false);
        interestedForumViewHolder.l.setText(dVar.f62588a.forum_name);
        if (TextUtils.isEmpty(dVar.f62588a.slogan)) {
            str = "百度" + dVar.f62588a.forum_name + "吧";
        } else {
            str = dVar.f62588a.slogan;
        }
        interestedForumViewHolder.o.setText(str);
        interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.member_count.intValue()));
        interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.thread_count.intValue()));
        z(interestedForumViewHolder.x, dVar);
        x(dVar, interestedForumViewHolder.x);
    }

    public final void v(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19354e.setVisibility(0);
        interestedForumViewHolder.f19357h.setVisibility(0);
        interestedForumViewHolder.f19357h.W(dVar.f62588a.avatar, 10, false);
        interestedForumViewHolder.k.setText(dVar.f62588a.forum_name);
        if (TextUtils.isEmpty(dVar.f62588a.slogan)) {
            str = "百度" + dVar.f62588a.forum_name + "吧";
        } else {
            str = dVar.f62588a.slogan;
        }
        interestedForumViewHolder.n.setText(str);
        interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.member_count.intValue()));
        interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.thread_count.intValue()));
        z(interestedForumViewHolder.w, dVar);
        x(dVar, interestedForumViewHolder.w);
    }

    public void w(c cVar) {
        this.f19348c = cVar;
    }

    public final void x(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new b(dVar, tBSpecificationBtn));
    }

    public final void y(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19353d.setVisibility(0);
        interestedForumViewHolder.f19356g.setVisibility(0);
        interestedForumViewHolder.f19356g.W(dVar.f62588a.avatar, 10, false);
        interestedForumViewHolder.j.setText(dVar.f62588a.forum_name);
        if (TextUtils.isEmpty(dVar.f62588a.slogan)) {
            str = "百度" + dVar.f62588a.forum_name + "吧";
        } else {
            str = dVar.f62588a.slogan;
        }
        interestedForumViewHolder.m.setText(str);
        interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.member_count.intValue()));
        interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62588a.thread_count.intValue()));
        z(interestedForumViewHolder.v, dVar);
        x(dVar, interestedForumViewHolder.v);
    }

    public final void z(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        if (!dVar.f62589b) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.r(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }
}
