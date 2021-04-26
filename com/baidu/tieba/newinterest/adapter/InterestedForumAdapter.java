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
import d.a.j0.z1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.j0.z1.c.a> f19482a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f19483b;

    /* renamed from: c  reason: collision with root package name */
    public c f19484c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19485d;

    /* loaded from: classes3.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f19486a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19487b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19488c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f19489d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f19490e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f19491f;

        /* renamed from: g  reason: collision with root package name */
        public BarImageView f19492g;

        /* renamed from: h  reason: collision with root package name */
        public BarImageView f19493h;

        /* renamed from: i  reason: collision with root package name */
        public BarImageView f19494i;
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
            this.f19486a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f19487b = (TextView) view.findViewById(R.id.interest_text);
            this.f19488c = (TextView) view.findViewById(R.id.interest_change);
            this.f19489d = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.f19490e = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.f19491f = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.f19492g = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.f19493h = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.f19494i = (BarImageView) view.findViewById(R.id.bottom_forum_image);
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
            SkinManager.setViewTextColor(this.f19487b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19488c, R.color.CAM_X0107);
            this.f19487b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new d.a.i0.r.f0.m.b());
            this.w.setConfig(new d.a.i0.r.f0.m.b());
            this.x.setConfig(new d.a.i0.r.f0.m.b());
            a(this.f19492g);
            a(this.f19493h);
            a(this.f19494i);
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
        public final /* synthetic */ d.a.j0.z1.c.a f19495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestedForumViewHolder f19496f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19497g;

        public a(d.a.j0.z1.c.a aVar, InterestedForumViewHolder interestedForumViewHolder, int i2) {
            this.f19495e = aVar;
            this.f19496f = interestedForumViewHolder;
            this.f19497g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = this.f19495e.f62945a.size() - 1;
            InterestedForumAdapter.this.o(size, this.f19495e);
            InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder = this.f19496f;
            d.a.j0.z1.c.a aVar = this.f19495e;
            interestedForumAdapter.x(interestedForumViewHolder, aVar.f62945a.get(aVar.f62948d));
            InterestedForumAdapter.this.o(size, this.f19495e);
            InterestedForumAdapter interestedForumAdapter2 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder2 = this.f19496f;
            d.a.j0.z1.c.a aVar2 = this.f19495e;
            interestedForumAdapter2.u(interestedForumViewHolder2, aVar2.f62945a.get(aVar2.f62948d));
            InterestedForumAdapter.this.o(size, this.f19495e);
            InterestedForumAdapter interestedForumAdapter3 = InterestedForumAdapter.this;
            InterestedForumViewHolder interestedForumViewHolder3 = this.f19496f;
            d.a.j0.z1.c.a aVar3 = this.f19495e;
            interestedForumAdapter3.t(interestedForumViewHolder3, aVar3.f62945a.get(aVar3.f62948d));
            InterestedForumAdapter interestedForumAdapter4 = InterestedForumAdapter.this;
            interestedForumAdapter4.f19485d = interestedForumAdapter4.p();
            InterestedForumAdapter.this.notifyItemChanged(this.f19497g);
            if (InterestedForumAdapter.this.f19484c != null) {
                InterestedForumAdapter.this.f19484c.c(InterestedForumAdapter.this.f19483b, InterestedForumAdapter.this.f19485d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_source", this.f19495e.f62946b.intValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19499e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f19500f;

        public b(d dVar, TBSpecificationBtn tBSpecificationBtn) {
            this.f19499e = dVar;
            this.f19500f = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f19499e;
            dVar.f62955b = !dVar.f62955b;
            d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
            if (!this.f19499e.f62955b) {
                InterestedForumAdapter.l(InterestedForumAdapter.this);
                this.f19500f.setText("感兴趣");
                this.f19500f.setConfig(bVar);
                InterestedForumAdapter.this.f19485d = false;
            } else {
                InterestedForumAdapter.k(InterestedForumAdapter.this);
                this.f19500f.setText("已选择");
                bVar.r(R.color.CAM_X0109);
                this.f19500f.setConfig(bVar);
                InterestedForumAdapter interestedForumAdapter = InterestedForumAdapter.this;
                interestedForumAdapter.f19485d = interestedForumAdapter.p();
            }
            if (InterestedForumAdapter.this.f19484c != null) {
                InterestedForumAdapter.this.f19484c.c(InterestedForumAdapter.this.f19483b, InterestedForumAdapter.this.f19485d);
            }
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", this.f19499e.f62954a.forum_id.longValue());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(int i2, boolean z);
    }

    public static /* synthetic */ int k(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f19483b;
        interestedForumAdapter.f19483b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i2 = interestedForumAdapter.f19483b;
        interestedForumAdapter.f19483b = i2 - 1;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.a.j0.z1.c.a> list = this.f19482a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m(List<d.a.j0.z1.c.a> list) {
        this.f19482a.addAll(list);
        notifyDataSetChanged();
    }

    public List<d.a.j0.z1.c.a> n() {
        return this.f19482a;
    }

    public final void o(int i2, d.a.j0.z1.c.a aVar) {
        int i3 = aVar.f62948d;
        if (i3 < i2) {
            aVar.f62948d = i3 + 1;
        } else {
            aVar.f62948d = 0;
        }
    }

    public boolean p() {
        for (d.a.j0.z1.c.a aVar : this.f19482a) {
            int i2 = aVar.f62948d;
            if (!aVar.f62945a.get(i2).f62955b) {
                return false;
            }
            int size = i2 + (-1) < 0 ? aVar.f62945a.size() - 1 : i2 - 1;
            if (!aVar.f62945a.get(size).f62955b) {
                return false;
            }
            if (!aVar.f62945a.get(size + (-1) < 0 ? aVar.f62945a.size() - 1 : size - 1).f62955b) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i2) {
        d.a.j0.z1.c.a aVar = this.f19482a.get(i2);
        interestedForumViewHolder.f19487b.setText(aVar.f62947c);
        if (aVar.f62946b.intValue() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(interestedForumViewHolder.f19486a, d.a.j0.z1.e.a.b(aVar.f62946b.intValue()), null);
        }
        List<d> list = aVar.f62945a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i3 = aVar.f62948d;
        if (i3 == 0) {
            if (aVar.f62945a.size() >= 1) {
                x(interestedForumViewHolder, aVar.f62945a.get(0));
            }
            if (aVar.f62945a.size() >= 2) {
                u(interestedForumViewHolder, aVar.f62945a.get(1));
            }
            if (aVar.f62945a.size() >= 3) {
                t(interestedForumViewHolder, aVar.f62945a.get(2));
            }
            if (aVar.f62945a.size() > 3) {
                aVar.f62948d = 2;
            }
        } else {
            t(interestedForumViewHolder, aVar.f62945a.get(i3));
            int size = i3 + (-1) < 0 ? aVar.f62945a.size() - 1 : i3 - 1;
            u(interestedForumViewHolder, aVar.f62945a.get(size));
            x(interestedForumViewHolder, aVar.f62945a.get(size + (-1) < 0 ? aVar.f62945a.size() - 1 : size - 1));
        }
        if (aVar.f62945a.size() <= 3) {
            interestedForumViewHolder.f19488c.setEnabled(false);
        } else {
            interestedForumViewHolder.f19488c.setEnabled(true);
        }
        interestedForumViewHolder.f19488c.setOnClickListener(new a(aVar, interestedForumViewHolder, i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    public void s() {
        List<d.a.j0.z1.c.a> list = this.f19482a;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.j0.z1.c.a aVar : this.f19482a) {
            int i2 = aVar.f62948d;
            aVar.f62945a.get(i2).f62955b = !this.f19485d;
            z(aVar, i2);
            int size = i2 + (-1) < 0 ? aVar.f62945a.size() - 1 : i2 - 1;
            aVar.f62945a.get(size).f62955b = !this.f19485d;
            z(aVar, size);
            if (size - 1 < 0) {
                size = aVar.f62945a.size();
            }
            int i3 = size - 1;
            aVar.f62945a.get(i3).f62955b = !this.f19485d;
            z(aVar, i3);
        }
        this.f19485d = !this.f19485d;
        notifyDataSetChanged();
        c cVar = this.f19484c;
        if (cVar != null) {
            boolean z = this.f19485d;
            if (z) {
                this.f19483b = this.f19482a.size() * 3;
                this.f19484c.c(this.f19482a.size() * 3, this.f19485d);
                return;
            }
            this.f19483b = 0;
            cVar.c(0, z);
        }
    }

    public final void t(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19491f.setVisibility(0);
        interestedForumViewHolder.f19494i.setVisibility(0);
        interestedForumViewHolder.f19494i.V(dVar.f62954a.avatar, 10, false);
        interestedForumViewHolder.l.setText(dVar.f62954a.forum_name);
        if (TextUtils.isEmpty(dVar.f62954a.slogan)) {
            str = "百度" + dVar.f62954a.forum_name + "吧";
        } else {
            str = dVar.f62954a.slogan;
        }
        interestedForumViewHolder.o.setText(str);
        interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.member_count.intValue()));
        interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.thread_count.intValue()));
        y(interestedForumViewHolder.x, dVar);
        w(dVar, interestedForumViewHolder.x);
    }

    public final void u(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19490e.setVisibility(0);
        interestedForumViewHolder.f19493h.setVisibility(0);
        interestedForumViewHolder.f19493h.V(dVar.f62954a.avatar, 10, false);
        interestedForumViewHolder.k.setText(dVar.f62954a.forum_name);
        if (TextUtils.isEmpty(dVar.f62954a.slogan)) {
            str = "百度" + dVar.f62954a.forum_name + "吧";
        } else {
            str = dVar.f62954a.slogan;
        }
        interestedForumViewHolder.n.setText(str);
        interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.member_count.intValue()));
        interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.thread_count.intValue()));
        y(interestedForumViewHolder.w, dVar);
        w(dVar, interestedForumViewHolder.w);
    }

    public void v(c cVar) {
        this.f19484c = cVar;
    }

    public final void w(d dVar, TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new b(dVar, tBSpecificationBtn));
    }

    public final void x(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.f19489d.setVisibility(0);
        interestedForumViewHolder.f19492g.setVisibility(0);
        interestedForumViewHolder.f19492g.V(dVar.f62954a.avatar, 10, false);
        interestedForumViewHolder.j.setText(dVar.f62954a.forum_name);
        if (TextUtils.isEmpty(dVar.f62954a.slogan)) {
            str = "百度" + dVar.f62954a.forum_name + "吧";
        } else {
            str = dVar.f62954a.slogan;
        }
        interestedForumViewHolder.m.setText(str);
        interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.member_count.intValue()));
        interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(dVar.f62954a.thread_count.intValue()));
        y(interestedForumViewHolder.v, dVar);
        w(dVar, interestedForumViewHolder.v);
    }

    public final void y(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
        if (!dVar.f62955b) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.r(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public final void z(d.a.j0.z1.c.a aVar, int i2) {
        if (this.f19485d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", aVar.f62945a.get(i2).f62954a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }
}
