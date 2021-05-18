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
import d.a.k0.z1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.k0.z1.c.a> f18770a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f18771b;

    /* renamed from: c  reason: collision with root package name */
    public c f18772c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18773d;

    /* loaded from: classes4.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18774a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18775b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18776c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f18777d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f18778e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f18779f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f18780g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f18781h;

        /* renamed from: i  reason: collision with root package name */
        public BarImageView f18782i;
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
            this.f18774a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f18775b = (TextView) view.findViewById(R.id.interest_text);
            this.f18776c = (TextView) view.findViewById(R.id.interest_change);
            this.f18777d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f18778e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f18779f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f18780g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f18781h = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.f18782i = (BarImageView) view.findViewById(R.id.bottom_forum_image);
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
            SkinManager.setViewTextColor(this.f18775b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18776c, R.color.CAM_X0107);
            this.f18775b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.a.j0.r.f0.m.b());
            this.w.setConfig(new d.a.j0.r.f0.m.b());
            this.x.setConfig(new d.a.j0.r.f0.m.b());
            a(this.f18780g);
            a(this.f18781h);
            a(this.f18782i);
        }

        public final void a(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.z1.c.a f18783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f18784f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18785g;

        public a(d.a.k0.z1.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
            this.f18783e = aVar;
            this.f18784f = interestedForumViewHolder;
            this.f18785g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = this.f18783e.f63669a.size() - 1;
            InterestedForumAdapter.this.o(size, this.f18783e);
            InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder = this.f18784f;
            d.a.k0.z1.c.a aVar = this.f18783e;
            interestedForumAdapter.x(interestedForumViewHolder, aVar.f63669a.get(aVar.f63672d));
            InterestedForumAdapter.this.o(size, this.f18783e);
            InterestedForumAdapter interestedForumAdapter2 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder2 = this.f18784f;
            d.a.k0.z1.c.a aVar2 = this.f18783e;
            interestedForumAdapter2.u(interestedForumViewHolder2, aVar2.f63669a.get(aVar2.f63672d));
            InterestedForumAdapter.this.o(size, this.f18783e);
            InterestedForumAdapter interestedForumAdapter3 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder3 = this.f18784f;
            d.a.k0.z1.c.a aVar3 = this.f18783e;
            interestedForumAdapter3.t(interestedForumViewHolder3, aVar3.f63669a.get(aVar3.f63672d));
            InterestedForumAdapter interestedForumAdapter4 = InterestedForumAdapter.this;
            interestedForumAdapter4.f18773d = interestedForumAdapter4.p();
            InterestedForumAdapter.this.notifyItemChanged(this.f18785g);
            if (InterestedForumAdapter.this.f18772c != null) {
                InterestedForumAdapter.this.f18772c.c(InterestedForumAdapter.this.f18771b, InterestedForumAdapter.this.f18773d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_source", this.f18783e.f63670b.intValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f18788f;

        public b(d dVar, TBSpecificationBtn tBSpecificationBtn) {
            this.f18787e = dVar;
            this.f18788f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f18787e;
            dVar.f63679b = !dVar.f63679b;
            d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
            if (!this.f18787e.f63679b) {
                InterestedForumAdapter.l(InterestedForumAdapter.this);
                this.f18788f.setText("感兴趣");
                this.f18788f.setConfig(bVar);
                InterestedForumAdapter.this.f18773d = false;
            } else {
                InterestedForumAdapter.k(InterestedForumAdapter.this);
                this.f18788f.setText("已选择");
                bVar.r(R.color.CAM_X0109);
                this.f18788f.setConfig(bVar);
                InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
                interestedForumAdapter.f18773d = interestedForumAdapter.p();
            }
            if (InterestedForumAdapter.this.f18772c != null) {
                InterestedForumAdapter.this.f18772c.c(InterestedForumAdapter.this.f18771b, InterestedForumAdapter.this.f18773d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", this.f18787e.f63678a.forum_id.longValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void c(int i2, boolean z);
    }

    public static /* synthetic */ int k(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18771b;
        interestedForumAdapter.f18771b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f18771b;
        interestedForumAdapter.f18771b = i2 - 1;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.a.k0.z1.c.a> list = this.f18770a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m(List<d.a.k0.z1.c.a> list) {
        this.f18770a.addAll(list);
        notifyDataSetChanged();
    }

    public List<d.a.k0.z1.c.a> n() {
        return this.f18770a;
    }

    public final void o(int i2, d.a.k0.z1.c.a aVar) {
        int i3 = aVar.f63672d;
        if (i3 < i2) {
            aVar.f63672d = i3 + 1;
        } else {
            aVar.f63672d = 0;
        }
    }

    public boolean p() {
        for (d.a.k0.z1.c.a aVar : this.f18770a) {
            int i2 = aVar.f63672d;
            if (!aVar.f63669a.get(i2).f63679b) {
                return false;
            }
            int size = i2 + (-1) < 0 ? aVar.f63669a.size() - 1 : i2 - 1;
            if (!aVar.f63669a.get(size).f63679b) {
                return false;
            }
            if (!aVar.f63669a.get(size + (-1) < 0 ? aVar.f63669a.size() - 1 : size - 1).f63679b) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        d.a.k0.z1.c.a aVar = this.f18770a.get(i2);
        interestedForumViewHolder.f18775b.setText(aVar.f63671c);
        if (aVar.f63670b.intValue() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f18774a, d.a.k0.z1.e.a.b(aVar.f63670b.intValue()), null);
        }
        List<d> list = aVar.f63669a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i3 = aVar.f63672d;
        if (i3 == 0) {
            if (aVar.f63669a.size() >= 1) {
                x(interestedForumViewHolder, aVar.f63669a.get(0));
            }
            if (aVar.f63669a.size() >= 2) {
                u(interestedForumViewHolder, aVar.f63669a.get(1));
            }
            if (aVar.f63669a.size() >= 3) {
                t(interestedForumViewHolder, aVar.f63669a.get(2));
            }
            if (aVar.f63669a.size() > 3) {
                aVar.f63672d = 2;
            }
        } else {
            t(interestedForumViewHolder, aVar.f63669a.get(i3));
            int size = i3 + (-1) < 0 ? aVar.f63669a.size() - 1 : i3 - 1;
            u(interestedForumViewHolder, aVar.f63669a.get(size));
            x(interestedForumViewHolder, aVar.f63669a.get(size + (-1) < 0 ? aVar.f63669a.size() - 1 : size - 1));
        }
        if (aVar.f63669a.size() <= 3) {
            interestedForumViewHolder.f18776c.setEnabled(false);
        } else {
            interestedForumViewHolder.f18776c.setEnabled(true);
        }
        interestedForumViewHolder.f18776c.setOnClickListener(new a(aVar, interestedForumViewHolder, i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    public void s() {
        List<d.a.k0.z1.c.a> list = this.f18770a;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.k0.z1.c.a aVar : this.f18770a) {
            int i2 = aVar.f63672d;
            aVar.f63669a.get(i2).f63679b = !this.f18773d;
            z(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.f63669a.size() - 1 : i2 - 1;
            aVar.f63669a.get(size).f63679b = !this.f18773d;
            z(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f63669a.size();
            }
            int i3 = size - 1;
            aVar.f63669a.get(i3).f63679b = !this.f18773d;
            z(aVar, i3);
        }
        this.f18773d = !this.f18773d;
        notifyDataSetChanged();
        c cVar = this.f18772c;
        if (cVar != null) {
            boolean z = this.f18773d;
            if (z) {
                this.f18771b = this.f18770a.size() * 3;
                this.f18772c.c(this.f18770a.size() * 3, this.f18773d);
                return;
            }
            this.f18771b = 0;
            cVar.c(0, z);
        }
    }

    public final void t(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18779f.setVisibility(0);
        interestedForumViewHolder.f18782i.setVisibility(0);
        interestedForumViewHolder.f18782i.V(dVar.f63678a.avatar, 10, false);
        interestedForumViewHolder.l.setText(dVar.f63678a.forum_name);
        if (TextUtils.isEmpty(dVar.f63678a.slogan)) {
            str = "百度" + dVar.f63678a.forum_name + "吧";
        } else {
            str = dVar.f63678a.slogan;
        }
        interestedForumViewHolder.o.setText(str);
        interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.member_count.intValue()));
        interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.thread_count.intValue()));
        y(interestedForumViewHolder.x, dVar);
        w(dVar, interestedForumViewHolder.x);
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18778e.setVisibility(0);
        interestedForumViewHolder.f18781h.setVisibility(0);
        interestedForumViewHolder.f18781h.V(dVar.f63678a.avatar, 10, false);
        interestedForumViewHolder.k.setText(dVar.f63678a.forum_name);
        if (TextUtils.isEmpty(dVar.f63678a.slogan)) {
            str = "百度" + dVar.f63678a.forum_name + "吧";
        } else {
            str = dVar.f63678a.slogan;
        }
        interestedForumViewHolder.n.setText(str);
        interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.member_count.intValue()));
        interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.thread_count.intValue()));
        y(interestedForumViewHolder.w, dVar);
        w(dVar, interestedForumViewHolder.w);
    }

    public void v(c cVar) {
        this.f18772c = cVar;
    }

    public final void w(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new b(dVar, tBSpecificationBtn));
    }

    public final void x(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f18777d.setVisibility(0);
        interestedForumViewHolder.f18780g.setVisibility(0);
        interestedForumViewHolder.f18780g.V(dVar.f63678a.avatar, 10, false);
        interestedForumViewHolder.j.setText(dVar.f63678a.forum_name);
        if (TextUtils.isEmpty(dVar.f63678a.slogan)) {
            str = "百度" + dVar.f63678a.forum_name + "吧";
        } else {
            str = dVar.f63678a.slogan;
        }
        interestedForumViewHolder.m.setText(str);
        interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.member_count.intValue()));
        interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f63678a.thread_count.intValue()));
        y(interestedForumViewHolder.v, dVar);
        w(dVar, interestedForumViewHolder.v);
    }

    public final void y(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
        if (!dVar.f63679b) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.r(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public final void z(d.a.k0.z1.c.a aVar, int i2) {
        if (this.f18773d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f63669a.get(i2).f63678a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }
}
