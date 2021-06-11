package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.m0.r.q.c1;
import d.a.n0.e2.k.e.i0;
/* loaded from: classes5.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19184a;

    /* renamed from: b  reason: collision with root package name */
    public View f19185b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19186c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19187d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19188e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19189f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19190g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19191h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19192i;
    public TextView j;
    public LinearLayout k;
    public ImageView l;
    public TextView m;
    public View n;
    public c1 o;
    public c1 p;
    public c1 q;
    public TbPageContext r;
    public int s;
    public i0 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PbPageNewsInfoHolder.this.r.getPageActivity()) && l.D()) {
                if (PbPageNewsInfoHolder.this.u != null) {
                    PbPageNewsInfoHolder.this.u.a(PbPageNewsInfoHolder.this.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = PbPageNewsInfoHolder.this;
                if (view == pbPageNewsInfoHolder.f19186c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.o.f53641a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.o.f53641a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", PbPageNewsInfoHolder.this.o.f53641a));
                } else if (view == pbPageNewsInfoHolder.f19191h) {
                    BdLog.e("link: " + PbPageNewsInfoHolder.this.p.f53641a);
                    if (PbPageNewsInfoHolder.this.p == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.p.f53641a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.p.f53641a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", PbPageNewsInfoHolder.this.p.f53641a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.q.f53641a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.q.f53641a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", PbPageNewsInfoHolder.this.q.f53641a));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(i0 i0Var);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.s = 3;
        this.v = new a();
        this.r = tbPageContext;
        this.u = bVar;
        this.f19184a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19185b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19186c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19187d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19188e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19189f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19190g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19191h = (LinearLayout) view.findViewById(R.id.news_info);
        this.f19192i = (ImageView) view.findViewById(R.id.news_info_img);
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.k = (LinearLayout) view.findViewById(R.id.game_info);
        this.l = (ImageView) view.findViewById(R.id.game_info_img);
        this.m = (TextView) view.findViewById(R.id.game_info_text);
        this.n = view.findViewById(R.id.pb_news_info_divider);
        j(this.v);
    }

    public void h(i0 i0Var) {
        if (i0Var == null) {
            return;
        }
        this.t = i0Var;
        c1 c1Var = i0Var.x0;
        this.o = c1Var;
        this.p = i0Var.y0;
        this.q = i0Var.z0;
        if (c1Var != null) {
            this.f19187d.U(c1Var.f53644d, 10, false);
            this.f19189f.setText(this.o.f53642b);
            this.f19190g.setText(this.o.f53645e);
            this.f19188e.setText(this.o.f53646f);
            SkinManager.setBackgroundResource(this.f19188e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19188e, R.drawable.news_text_color_selector);
        } else {
            this.f19186c.setVisibility(8);
        }
        c1 c1Var2 = this.p;
        if (c1Var2 != null) {
            this.j.setText(c1Var2.f53642b);
            SkinManager.setBackgroundResource(this.f19192i, R.drawable.icon_frs_news);
        } else {
            this.f19191h.setVisibility(8);
            this.j.setVisibility(8);
            this.f19192i.setVisibility(8);
        }
        c1 c1Var3 = this.q;
        if (c1Var3 != null) {
            this.m.setText(c1Var3.f53642b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19184a.setTag(i0Var);
    }

    public void i(int i2) {
        if (this.s != i2) {
            this.r.getLayoutMode().k(i2 == 1);
            this.r.getLayoutMode().j(a());
            this.s = i2;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.f19186c.setOnClickListener(onClickListener);
        this.f19191h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }
}
