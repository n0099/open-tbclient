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
import d.a.c.e.p.l;
import d.a.o0.a2.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.o0.a2.c.a> f18842a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f18843b;

    /* renamed from: c  reason: collision with root package name */
    public c f18844c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18845d;

    /* loaded from: classes5.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18846a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18847b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18848c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f18849d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f18850e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f18851f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f18852g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f18853h;

        /* renamed from: i  reason: collision with root package name */
        public BarImageView f18854i;
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
            this.f18846a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f18847b = (TextView) view.findViewById(R.id.interest_text);
            this.f18848c = (TextView) view.findViewById(R.id.interest_change);
            this.f18849d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f18850e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f18851f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f18852g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f18853h = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.f18854i = (BarImageView) view.findViewById(R.id.bottom_forum_image);
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
            SkinManager.setViewTextColor(this.f18847b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18848c, R.color.CAM_X0107);
            this.f18847b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.a.n0.r.f0.m.b());
            this.w.setConfig(new d.a.n0.r.f0.m.b());
            this.x.setConfig(new d.a.n0.r.f0.m.b());
            a(this.f18852g);
            a(this.f18853h);
            a(this.f18854i);
        }

        public final void a(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a2.c.a f18855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f18856f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18857g;

        public a(d.a.o0.a2.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
            this.f18855e = aVar;
            this.f18856f = interestedForumViewHolder;
            this.f18857g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = this.f18855e.f54962a.size() - 1;
            InterestedForumAdapter.this.o(size, this.f18855e);
            InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder = this.f18856f;
            d.a.o0.a2.c.a aVar = this.f18855e;
            interestedForumAdapter.x(interestedForumViewHolder, aVar.f54962a.get(aVar.f54965d));
            InterestedForumAdapter.this.o(size, this.f18855e);
            InterestedForumAdapter interestedForumAdapter2 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder2 = this.f18856f;
            d.a.o0.a2.c.a aVar2 = this.f18855e;
            interestedForumAdapter2.u(interestedForumViewHolder2, aVar2.f54962a.get(aVar2.f54965d));
            InterestedForumAdapter.this.o(size, this.f18855e);
            InterestedForumAdapter interestedForumAdapter3 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder3 = this.f18856f;
            d.a.o0.a2.c.a aVar3 = this.f18855e;
            interestedForumAdapter3.t(interestedForumViewHolder3, aVar3.f54962a.get(aVar3.f54965d));
            InterestedForumAdapter interestedForumAdapter4 = InterestedForumAdapter.this;
            interestedForumAdapter4.f18845d = interestedForumAdapter4.p();
            InterestedForumAdapter.this.notifyItemChanged(this.f18857g);
            if (InterestedForumAdapter.this.f18844c != null) {
                InterestedForumAdapter.this.f18844c.c(InterestedForumAdapter.this.f18843b, InterestedForumAdapter.this.f18845d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_source", this.f18855e.f54963b.intValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f18860f;

        public b(d dVar, TBSpecificationBtn tBSpecificationBtn) {
            this.f18859e = dVar;
            this.f18860f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f18859e;
            dVar.f54972b = !dVar.f54972b;
            d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
            if (!this.f18859e.f54972b) {
                InterestedForumAdapter.l(InterestedForumAdapter.this);
                this.f18860f.setText("感兴趣");
                this.f18860f.setConfig(bVar);
                InterestedForumAdapter.this.f18845d = false;
            } else {
                InterestedForumAdapter.k(InterestedForumAdapter.this);
                this.f18860f.setText("已选择");
                bVar.r(R.color.CAM_X0109);
                this.f18860f.setConfig(bVar);
                InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
                interestedForumAdapter.f18845d = interestedForumAdapter.p();
            }
            if (InterestedForumAdapter.this.f18844c != null) {
                InterestedForumAdapter.this.f18844c.c(InterestedForumAdapter.this.f18843b, InterestedForumAdapter.this.f18845d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", this.f18859e.f54971a.forum_id.longValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(int i2, boolean z);
    }

    public static /* synthetic */ int k(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18843b;
        interestedForumAdapter.f18843b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18843b;
        interestedForumAdapter.f18843b = i2 - 1;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.a.o0.a2.c.a> list = this.f18842a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m(List<d.a.o0.a2.c.a> list) {
        this.f18842a.addAll(list);
        notifyDataSetChanged();
    }

    public List<d.a.o0.a2.c.a> n() {
        return this.f18842a;
    }

    public final void o(int i2, d.a.o0.a2.c.a aVar) {
        int i3 = aVar.f54965d;
        if (i3 < i2) {
            aVar.f54965d = i3 + 1;
        } else {
            aVar.f54965d = 0;
        }
    }

    public boolean p() {
        for (d.a.o0.a2.c.a aVar : this.f18842a) {
            int i2 = aVar.f54965d;
            if (!aVar.f54962a.get(i2).f54972b) {
                return false;
            }
            int size = i2 + (-1) < 0 ? aVar.f54962a.size() - 1 : i2 - 1;
            if (!aVar.f54962a.get(size).f54972b) {
                return false;
            }
            if (!aVar.f54962a.get(size + (-1) < 0 ? aVar.f54962a.size() - 1 : size - 1).f54972b) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        d.a.o0.a2.c.a aVar = this.f18842a.get(i2);
        interestedForumViewHolder.f18847b.setText(aVar.f54964c);
        if (aVar.f54963b.intValue() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f18846a, d.a.o0.a2.e.a.b(aVar.f54963b.intValue()), null);
        }
        List<d> list = aVar.f54962a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i3 = aVar.f54965d;
        if (i3 == 0) {
            if (aVar.f54962a.size() >= 1) {
                x(interestedForumViewHolder, aVar.f54962a.get(0));
            }
            if (aVar.f54962a.size() >= 2) {
                u(interestedForumViewHolder, aVar.f54962a.get(1));
            }
            if (aVar.f54962a.size() >= 3) {
                t(interestedForumViewHolder, aVar.f54962a.get(2));
            }
            if (aVar.f54962a.size() > 3) {
                aVar.f54965d = 2;
            }
        } else {
            t(interestedForumViewHolder, aVar.f54962a.get(i3));
            int size = i3 + (-1) < 0 ? aVar.f54962a.size() - 1 : i3 - 1;
            u(interestedForumViewHolder, aVar.f54962a.get(size));
            x(interestedForumViewHolder, aVar.f54962a.get(size + (-1) < 0 ? aVar.f54962a.size() - 1 : size - 1));
        }
        if (aVar.f54962a.size() <= 3) {
            interestedForumViewHolder.f18848c.setEnabled(false);
        } else {
            interestedForumViewHolder.f18848c.setEnabled(true);
        }
        interestedForumViewHolder.f18848c.setOnClickListener(new a(aVar, interestedForumViewHolder, i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    public void s() {
        List<d.a.o0.a2.c.a> list = this.f18842a;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.o0.a2.c.a aVar : this.f18842a) {
            int i2 = aVar.f54965d;
            aVar.f54962a.get(i2).f54972b = !this.f18845d;
            z(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.f54962a.size() - 1 : i2 - 1;
            aVar.f54962a.get(size).f54972b = !this.f18845d;
            z(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f54962a.size();
            }
            int i3 = size - 1;
            aVar.f54962a.get(i3).f54972b = !this.f18845d;
            z(aVar, i3);
        }
        this.f18845d = !this.f18845d;
        notifyDataSetChanged();
        c cVar = this.f18844c;
        if (cVar != null) {
            boolean z = this.f18845d;
            if (z) {
                this.f18843b = this.f18842a.size() * 3;
                this.f18844c.c(this.f18842a.size() * 3, this.f18845d);
                return;
            }
            this.f18843b = 0;
            cVar.c(0, z);
        }
    }

    public final void t(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18851f.setVisibility(0);
        interestedForumViewHolder.f18854i.setVisibility(0);
        interestedForumViewHolder.f18854i.U(dVar.f54971a.avatar, 10, false);
        interestedForumViewHolder.l.setText(dVar.f54971a.forum_name);
        if (TextUtils.isEmpty(dVar.f54971a.slogan)) {
            str = "百度" + dVar.f54971a.forum_name + "吧";
        } else {
            str = dVar.f54971a.slogan;
        }
        interestedForumViewHolder.o.setText(str);
        interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.member_count.intValue()));
        interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.thread_count.intValue()));
        y(interestedForumViewHolder.x, dVar);
        w(dVar, interestedForumViewHolder.x);
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18850e.setVisibility(0);
        interestedForumViewHolder.f18853h.setVisibility(0);
        interestedForumViewHolder.f18853h.U(dVar.f54971a.avatar, 10, false);
        interestedForumViewHolder.k.setText(dVar.f54971a.forum_name);
        if (TextUtils.isEmpty(dVar.f54971a.slogan)) {
            str = "百度" + dVar.f54971a.forum_name + "吧";
        } else {
            str = dVar.f54971a.slogan;
        }
        interestedForumViewHolder.n.setText(str);
        interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.member_count.intValue()));
        interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.thread_count.intValue()));
        y(interestedForumViewHolder.w, dVar);
        w(dVar, interestedForumViewHolder.w);
    }

    public void v(c cVar) {
        this.f18844c = cVar;
    }

    public final void w(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new b(dVar, tBSpecificationBtn));
    }

    public final void x(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18849d.setVisibility(0);
        interestedForumViewHolder.f18852g.setVisibility(0);
        interestedForumViewHolder.f18852g.U(dVar.f54971a.avatar, 10, false);
        interestedForumViewHolder.j.setText(dVar.f54971a.forum_name);
        if (TextUtils.isEmpty(dVar.f54971a.slogan)) {
            str = "百度" + dVar.f54971a.forum_name + "吧";
        } else {
            str = dVar.f54971a.slogan;
        }
        interestedForumViewHolder.m.setText(str);
        interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.member_count.intValue()));
        interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f54971a.thread_count.intValue()));
        y(interestedForumViewHolder.v, dVar);
        w(dVar, interestedForumViewHolder.v);
    }

    public final void y(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        if (!dVar.f54972b) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.r(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public final void z(d.a.o0.a2.c.a aVar, int i2) {
        if (this.f18845d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f54962a.get(i2).f54971a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }
}
